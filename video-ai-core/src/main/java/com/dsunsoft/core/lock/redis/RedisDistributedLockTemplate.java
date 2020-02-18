package com.dsunsoft.core.lock.redis;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dsunsoft.core.lock.DistributedLockTemplate;
import com.dsunsoft.core.lock.LockedCallback;

import redis.clients.jedis.JedisPool;

/**
 * redis分布式锁
 * 
 * @author ygm
 *
 */
//@Service
public class RedisDistributedLockTemplate implements DistributedLockTemplate {
	private static final Logger logger = LoggerFactory.getLogger(RedisDistributedLockTemplate.class);

	private JedisPool jedisPool;

	public RedisDistributedLockTemplate(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/**
	 * 获取jedisPool
	 * 
	 * @return jedisPool jedisPool
	 */
	public JedisPool getJedisPool() {
		return jedisPool;
	}

	/**
	 * 设置jedisPool
	 * 
	 * @param jedisPool
	 *            jedisPool
	 */
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public Object execute(String lockId, int timeout, LockedCallback lockedCallback) {
		RedisReentrantLock distributedReentrantLock = null;
		boolean getLock = false;
		try {
			distributedReentrantLock = new RedisReentrantLock(jedisPool, lockId);
			if (distributedReentrantLock.tryLock(new Long(timeout), TimeUnit.MILLISECONDS)) {
				getLock = true;
				return lockedCallback.onGetLock();
			} else {
				return lockedCallback.onTimeout();
			}
		} catch (InterruptedException ex) {
			logger.error(ex.getMessage(), ex);
			Thread.currentThread().interrupt();
			return ex.getMessage().toString();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return e.getMessage().toString();
		} finally {
			if (getLock) {
				distributedReentrantLock.unlock();
			}
		}
	}
}
