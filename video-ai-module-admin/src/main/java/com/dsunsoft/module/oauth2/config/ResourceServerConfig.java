package com.dsunsoft.module.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

import com.dsunsoft.module.oauth2.exception.CustomizeAccessDeniedHandler;
import com.dsunsoft.module.oauth2.filter.CorsFilter;

/**
 * 资源服务授权
 * @author ygm
 *
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private CorsFilter clientCorsFilter;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().disable().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/swagger-resources/configuration/ui").permitAll().antMatchers("/video-ai/file/**").permitAll()
				.antMatchers("/video-ai/**").authenticated();
		http.addFilterBefore(clientCorsFilter, SecurityContextPersistenceFilter.class);
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resource) throws Exception {
		// 加自定义异常
		resource.authenticationEntryPoint(new AuthExceptionEntryPoint())
				.accessDeniedHandler(new CustomizeAccessDeniedHandler());
	}
}
