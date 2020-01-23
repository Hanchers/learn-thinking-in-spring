package com.hancher.learn.thinking.in.spring.ioc.repository;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * 用户信息仓库
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月23日 19:30
 * @version 1.0
 * @since 1.0
 */
public class UserRepository {
    private Collection<UserModel> users; // 自定义 Bean

    private BeanFactory beanFactory; // 內建非 Bean 对象（依赖）

    private ObjectFactory<ApplicationContext> objectFactory;

    public Collection<UserModel> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserModel> users) {
        this.users = users;
    }


    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
