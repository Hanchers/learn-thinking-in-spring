package com.hancher.learn.thinking.in.spring.ioc.dependency.lookup;

import com.hancher.learn.thinking.in.spring.ioc.annotation.Super;
import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找系列
 * <p>
 * <p/>
 *
 * @author Hancher
 * @version 1.0
 * @date Created in 2020年01月23日 20:01
 * @since 1.0
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // 按照类型查找
        lookupByType(beanFactory);
        // 按照类型查找结合对象
        lookupCollectionByType(beanFactory);
        // 通过注解查找对象
        lookupByAnnotationType(beanFactory);

        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
    }

    private static void lookupByType(BeanFactory beanFactory) {
        UserModel user = beanFactory.getBean(UserModel.class);
        System.out.println("实时查找：" + user);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> superUserMap = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User 集合对象：" + superUserMap);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, UserModel> userMap = listableBeanFactory.getBeansOfType(UserModel.class);
            System.out.println("查找到的所有的 UserModel 类型的 集合对象：" + userMap);
        }
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<UserModel> objectFactory = (ObjectFactory<UserModel>) beanFactory.getBean("objectFactory");
        UserModel user = objectFactory.getObject();
        System.out.println("延迟查找：" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        UserModel user = (UserModel) beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }
}
