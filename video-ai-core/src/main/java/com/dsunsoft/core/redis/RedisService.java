package com.dsunsoft.core.redis;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * RedisService
 * 
 * @author ygm
 *
 *         redis 支持五种基本类型 string、hash、list、set、sorted set
 */
@Component
public class RedisService {

	@Autowired
	private StringRedisTemplate redisTemplate;

	// 不能使用RedisTemplate,第一版用的StringRedisTemplate,2者不兼容
	// @Autowired
	// private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 不设置过期时长
	 */
	public static final long NOT_EXPIRE = -1;

	/**
	 * 添加String的值
	 *
	 * @param key
	 * @param value
	 * @Description
	 */
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 添加key的值
	 * 
	 * @param key
	 * @param value
	 * @param timeout
	 * @param unit
	 */
	public void set(String key, String value, long timeout, TimeUnit unit) {
		redisTemplate.opsForValue().set(key, value, timeout, unit);
	}

	/**
	 * 获取key的值
	 *
	 * @param key
	 * @Description
	 */
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 获取多个key的值
	 *
	 * @param key
	 * @Description
	 */
	public List<String> getKeys(List<String> key) {
		List<String> list = redisTemplate.opsForValue().multiGet(key);
		list.removeIf(p -> p == null);
		return list;
	}

	/**
	 * 判断key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 删除key
	 * 
	 * @param key
	 */
	public void del(String key) {
		redisTemplate.delete(key);
	}

	/**
	 * 删除key
	 * 
	 * @param key
	 */
	public void del(Set<String> keys) {
		redisTemplate.delete(keys);
	}

	/**
	 * 通过通配符获取key
	 * 
	 * @param pattern
	 * @return
	 */
	public Set<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	// ===================================List======================================

	/**
	 * 将list放入缓存
	 * 
	 * @param key
	 * @param value
	 */
	public void lSet(String key, String value) {
		redisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * 将list放入缓存
	 * 
	 * @param key
	 * @param value
	 */
	public void lSet(String key, String value, long time) {
		redisTemplate.opsForList().rightPush(key, value);
		if (time > 0) {
			setExpire(key, time);
		}
	}

	/**
	 * 通过索引 获取list中的值
	 * 
	 * @param key
	 * @param index
	 *            index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
	 * @return
	 */
	public Object lGetIndex(String key, long index) {
		return redisTemplate.opsForList().index(key, index);
	}

	/**
	 * 根据索引修改list中的某条数据
	 * 
	 * @param key
	 * @param index
	 * @param value
	 */
	public void lUpdateIndex(String key, long index, String value) {
		redisTemplate.opsForList().set(key, index, value);
	}

	/**
	 * 移除N个值为value
	 * 
	 * @param key
	 * @param count
	 * @param value
	 */
	public long lRemove(String key, long count, Object value) {
		Long result = redisTemplate.opsForList().remove(key, count, value);
		return result;
	}

	// ===================================Map=======================================

	/**
	 * 向Hash中添加值
	 *
	 * @param key
	 *            可以对应数据库中的表名
	 * @param field
	 *            可以对应数据库表中的唯一索引
	 * @param value
	 *            存入redis中的值
	 */
	public void hset(String key, String field, String value) {
		redisTemplate.opsForHash().put(key, field, value);
	}

	/**
	 * 从redis中取出值
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public Object hget(String key, String field) {
		return redisTemplate.opsForHash().get(key, field);
	}

	/**
	 * 判断 是否存在 key 以及 hash key
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public boolean hexists(String key, String field) {
		return redisTemplate.opsForHash().hasKey(key, field);
	}

	/**
	 * 查询 key中对应多少条数据
	 *
	 * @param key
	 * @return
	 */
	public long hsize(String key) {
		return redisTemplate.opsForHash().size(key);
	}

	/**
	 * 删除
	 *
	 * @param key
	 * @param field
	 */
	public void hdel(String key, String field) {
		redisTemplate.opsForHash().delete(key, field);
	}

	// ============================set=============================
	/**
	 * 根据key获取Set中的所有值
	 * 
	 * @param key
	 * 
	 * @return
	 */
	public Set<String> sGet(String key) {
		return redisTemplate.opsForSet().members(key);
	}

	/**
	 * 根据value从一个set中查询,是否存在
	 * 
	 * @param key
	 * 
	 * @param value
	 * 
	 * @return
	 */
	public boolean sHasKey(String key, Object value) {
		return redisTemplate.opsForSet().isMember(key, value);
	}

	/**
	 * 将数据放入set缓存
	 * 
	 * @param key
	 *            键
	 * @param values
	 *            值 可以是多个
	 * @return 成功个数
	 */
	public long sSet(String key, String... values) {
		return redisTemplate.opsForSet().add(key, values);
	}

	/**
	 * 将set数据放入缓存
	 * 
	 * @param key
	 *            键
	 * @param time
	 *            时间(秒)
	 * @param values
	 *            值 可以是多个
	 * @return 成功个数
	 */
	public long sSetAndTime(String key, long time, String... values) {
		Long count = redisTemplate.opsForSet().add(key, values);
		if (time > 0) {
			setExpire(key, time);
		}
		return count;
	}

	/**
	 * 获取set缓存的长度
	 * 
	 * @param key
	 * 
	 * @return
	 */
	public long sGetSetSize(String key) {
		return redisTemplate.opsForSet().size(key);
	}

	/**
	 * 移除值为value的
	 * 
	 * @param key
	 * 
	 * @param values
	 *            值 可以是多个
	 * @return 移除的个数
	 */
	public long setRemove(String key, Object... values) {
		Long count = redisTemplate.opsForSet().remove(key, values);
		return count;
	}

	/**
	 * 递减操作
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public double decr(String key, double value) {
		return redisTemplate.opsForValue().increment(key, -value);
	}

	/**
	 * 递增操作
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public double incr(String key, double value) {
		return redisTemplate.opsForValue().increment(key, value);
	}

	/**
	 * 指定缓存失效时间
	 * 
	 * @param key
	 *            键
	 * @param time
	 *            时间(秒)
	 * @return
	 */
	public void setExpire(String key, long time) {
		redisTemplate.expire(key, time, TimeUnit.SECONDS);
	}

	/**
	 * 根据key 获取过期时间
	 * 
	 * @param key
	 * 
	 * @return 时间(秒) 返回0代表为永久有效
	 */
	public long getExpire(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}
}
