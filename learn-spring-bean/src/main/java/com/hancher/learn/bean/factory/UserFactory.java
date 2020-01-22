package com.hancher.learn.bean.factory;

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
}
