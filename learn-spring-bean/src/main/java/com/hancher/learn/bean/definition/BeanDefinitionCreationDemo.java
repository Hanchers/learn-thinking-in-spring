package com.hancher.learn.bean.definition;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * <p>
 * <p/>
 *
 * @author Hancher
 * @version 1.0
 * @date Created in 2020年01月22日 16:13
 * @since 1.0
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserModel.class);
        // 通过属性设置
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "hancher");
        // 获取 BeanDefinition 实例
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        // BeanDefinition 并非 Bean 终态，可以自定义修改
        System.out.println("beanDefinition toString:"+beanDefinition.toString());

        // 2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        // 设置 Bean 类型
        genericBeanDefinition.setBeanClass(UserModel.class);
        // 通过 MutablePropertyValues 批量操作属性
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues
                .add("id",1)
                .add("name","hancher");
        // 通过 set MutablePropertyValues 批量操作属性
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

        System.out.println("GenericBeanDefinition toString:"+genericBeanDefinition.toString());

    }
}
