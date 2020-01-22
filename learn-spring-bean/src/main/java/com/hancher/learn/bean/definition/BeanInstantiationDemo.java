package com.hancher.learn.bean.definition;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化示例
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月22日 18:54
 * @version 1.0
 * @since 1.0
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        UserModel user = beanFactory.getBean("user-by-static-method", UserModel.class);
        UserModel userByInstanceMethod = beanFactory.getBean("user-by-instance-method", UserModel.class);
        UserModel userByFactoryBean = beanFactory.getBean("user-by-factory-bean", UserModel.class);
        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);

        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByFactoryBean);
    }
}
