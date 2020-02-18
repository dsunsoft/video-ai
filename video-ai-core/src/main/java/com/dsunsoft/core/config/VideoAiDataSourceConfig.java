package com.dsunsoft.core.config;

import com.dsunsoft.core.interceptor.MybatisInterceptor;
import com.github.pagehelper.PageInterceptor;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 视频AImysql数据源配置
 * @author zb
 */
@Configuration
@MapperScan(basePackages = {"com.dsunsoft.module.admin.dao","com.dsunsoft.module.business.dao"}, sqlSessionTemplateRef = "videoAiSqlSessionTemplate")
public class VideoAiDataSourceConfig {

    /**
     * 创建DataSource
     * @param videoAiConfig
     * @return
     * @throws SQLException
     */
    @Bean(name="videoAiDataSource")
    public DataSource videoAiDataSource(VideoAiConfig videoAiConfig) throws SQLException {
        // 1、创建xaDataSource
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(videoAiConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(videoAiConfig.getPassWord());
        mysqlXADataSource.setUser(videoAiConfig.getUserName());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        //2、注册到全局事务上
        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName(videoAiConfig.getUniqueResourceName());
        xaDataSource.setMinPoolSize(videoAiConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(videoAiConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(videoAiConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(videoAiConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(videoAiConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(videoAiConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(videoAiConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(videoAiConfig.getTestQuery());
       return xaDataSource;
    }

    /**
     * 创建SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name="videoAiSqlSessionFactory")
    public SqlSessionFactory videoAiSqlSessionFactory(@Qualifier("videoAiDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/**/*.xml"));
        //分页插件
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "mysql");
        //是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPageNum", "true");
        //是否进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        interceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[] {interceptor, new MybatisInterceptor()});
        return sqlSessionFactoryBean.getObject();
    }

//    /**
//     * 全局事务不要配置这个
//     * 创建 DataSourceTransactionManager
//     * @param dataSource
//     * @return
//     */
//    @Bean(name="videoAiTransctionManager")
//    public DataSourceTransactionManager videoAiTransctionManager(@Qualifier("videoAiDataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }

    /**
     * 创建 SqlSessionTemplate
     * @param sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean(name="videoAiSqlSessionTemplate")
    public SqlSessionTemplate videoAiSqlSessionTemplate(@Qualifier("videoAiSqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }




}
