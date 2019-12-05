package com.aaa.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/11/19
 */
@Component
public class SpringContextConfig implements ApplicationContextAware {
    public static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextConfig.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }

    public static <T> T getBean(String BeanName){
        return (T) applicationContext.getBean(BeanName);
    }
}
