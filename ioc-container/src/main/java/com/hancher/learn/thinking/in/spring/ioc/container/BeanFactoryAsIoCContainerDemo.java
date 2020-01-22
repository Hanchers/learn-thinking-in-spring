package com.hancher.learn.thinking.in.spring.ioc.container;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * {@link BeanFactory} 作为 IoC 容器示例
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月17日 17:29
 * @version 1.0
 * @since 1.0
 */
public class BeanFactoryAsIoCContainerDemo {
    public static void main(String[] args) {
        // 创建 beanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // xml bean 定义读取器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        // XML 配置文件 ClassPath 路径
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        //加载bean 配置
        int beanDefinitionsCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        System.out.println("Bean 定义加载的数量：" + beanDefinitionsCount);

        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, UserModel> users = listableBeanFactory.getBeansOfType(UserModel.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }
}
