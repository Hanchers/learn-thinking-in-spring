package com.hancher.learn.thinking.in.spring.ioc.container;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import com.hancher.learn.thinking.in.spring.ioc.enums.CityEnum;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 注解能力 {@link ApplicationContext} 作为 IoC 容器示例
 * <p>
 * <p/>
 *
 * @author Hancher
 * @version 1.0
 * @date Created in 2020年01月23日 16:04
 * @since 1.0
 */
@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找集合对象
        lookupCollectionByType(applicationContext);

        // 关闭应用上下文
        applicationContext.close();
    }

    /**
     * 遍历容器
     *
     * @param beanFactory 容器基类
     * @author Hancher
     * @date 2020年01月23日  16:06
     * @since 1.0
     */
    public static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, UserModel> beansMap = listableBeanFactory.getBeansOfType(UserModel.class);
            System.out.println("查找到的所有的 User 集合对象：" + beansMap);

        }
    }

    /**
     * 通过@bean 注解实例化
     * @author Hancher
     * @date  2020年01月23日  16:10
     * @since 1.0
     * @return userModel 实例
     */
    @Bean
    public UserModel initUser() {
        UserModel userModel = new UserModel();
        userModel.setCity(CityEnum.BEIJING);
        userModel.setId(3L);
        userModel.setName("寒澈3");

        return userModel;
    }
}
