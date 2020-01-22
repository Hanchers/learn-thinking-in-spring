package com.hancher.learn.bean.definition;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注解 BeanDefinition 示例
 * 
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月22日 16:40
 * @version 1.0
 * @since 1.0
 */
// 注解方式：@import
@Import(value = AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //1、注解方式： 注册配置类
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        // 2、通过 BeanDefinition 注册 API 实现
//        registerUserBeanDefinition(applicationContext,"hancher-user");
//        registerUserBeanDefinition(applicationContext);

        // 启动 Spring 应用上下文
        applicationContext.refresh();
        System.out.println("UserModel 类型的所有 Beans : " + applicationContext.getBeansOfType(UserModel.class));

        // 按照类型依赖查找
        System.out.println("Config 类型的所有 Beans" + applicationContext.getBeansOfType(Config.class));
        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    /**
     * 通过java api 方式配置
     * {@link BeanDefinitionCreationDemo}
     * @param
     * @author Hancher
     * @date  2020年01月22日  16:50
     * @since 1.0
     * @return
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry,String beanName) {
        //bean 添加属性
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "hancher");

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // bean 注册到容器中
        if (StringUtils.hasText(beanName)) {
            // 判断如果 beanName 参数存在时
            registry.registerBeanDefinition(beanName,beanDefinition);
        } else {
            //使用默认的驼峰式的beanName
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    //1注解方式：@Component
    @Component
    public static class Config {

        //1注解方式： 通过 @Bean 方式定义

        /**
         * 通过 Java 注解的方式，定义了一个 Bean
         */
        @Bean(name = {"user1", "HancherUser"})
        public UserModel user() {
            UserModel user = new UserModel();
            user.setId(2L);
            user.setName("寒澈2");
            return user;
        }
    }

}
