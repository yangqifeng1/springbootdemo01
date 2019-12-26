package com.springbootdemo.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration //表示该类用来做配置
public class PageHelperConfig {
	@Bean //启动拦截器
	public PageHelper pageHelper() {
		//rowBoundsWithCount为true时分页
		//pageNum<1查询第一页，大于pages查询最后一页
		PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
	}
}
