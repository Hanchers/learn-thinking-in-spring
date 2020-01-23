package com.hancher.learn.thinking.in.spring.bean.definition;

import com.hancher.learn.thinking.in.spring.bean.factory.DefaultUserFactory;
import com.hancher.learn.thinking.in.spring.bean.factory.UserFactory;
import javafx.application.Application;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * 特殊的bean 实例 注册
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月23日 13:18
 * @version 1.0
 * @since 1.0
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        // 通过xml 的方式启动spring 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        //通过 ApplicationContext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        // 1、java serviceLoader 显示类加载方式.依赖META-INF/services 配置
//        demoServiceLoader();

        // 2、通过spring 自动加载 依赖META-INF/services 配置
        ServiceLoader userFactoryServiceLoader = autowireCapableBeanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);
        //显示所有的类加载器
        displayServiceLoader(userFactoryServiceLoader);

        // 3、创建 UserFactory 对象，通过 AutowireCapableBeanFactory
//        UserFactory userFactory = autowireCapableBeanFactory.createBean(DefaultUserFactory.class);
//        System.out.println(userFactory.createUser());

    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}

