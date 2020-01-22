package com.hancher.learn.bean.definition;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 别名示例
 * <p>
 * <p/>
 *
 * @author Hancher
 * @version 1.0
 * @date Created in 2020年01月22日 14:40
 * @since 1.0
 */
public class BeanAliasDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/bean-definitions-context.xml");
        // 通过别名 user-hancher 获取曾用名 user 的 bean
        UserModel user = beanFactory.getBean("user", UserModel.class);
        UserModel userHancher = beanFactory.getBean("user-hancher", UserModel.class);
        String[] aliases = beanFactory.getAliases("user-hancher");

        //判断user 与 userHancher是否是一个对象
        System.out.println("user 和 userHancher 是否相同bean : " + (user == userHancher));
        System.out.println("beanFactory.getAliases 结果：" + aliases[0]);


    }
}
