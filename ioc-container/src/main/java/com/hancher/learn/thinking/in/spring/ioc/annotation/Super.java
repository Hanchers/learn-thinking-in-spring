package com.hancher.learn.thinking.in.spring.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记超级类
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月23日 20:06
 * @version 1.0
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
