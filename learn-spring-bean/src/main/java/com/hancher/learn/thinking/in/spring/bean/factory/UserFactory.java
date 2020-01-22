package com.hancher.learn.thinking.in.spring.bean.factory;

import com.hancher.learn.thinking.in.spring.ioc.domain.UserModel;

/**
 * {@link UserModel} 用户工厂类：用于表示通过工厂方法来实现bean 实例
 *
 * 参考：bean-instantiation-context.xml
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月22日 19:00
 * @version 1.0
 * @since 1.0
 */
public interface UserFactory {
    default UserModel createUser() {
        return UserModel.createUser();
    }


    /**
     * 初始化工厂实例方法
     * @author Hancher
     * @date  2020年01月22日  19:35
     * @since 1.0
     */
    default void initUserFactory() {};


    /**
     * 销毁工厂实例方法
     * @author Hancher
     * @date  2020年01月22日  19:36
     * @since 1.0
     */
    default void doDestroy(){};
}
