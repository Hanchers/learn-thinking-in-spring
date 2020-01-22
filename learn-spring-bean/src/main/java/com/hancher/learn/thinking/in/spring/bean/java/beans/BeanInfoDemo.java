package com.hancher.learn.thinking.in.spring.bean.java.beans;

import com.hancher.learn.thinking.in.spring.bean.domain.PersonModel;

import java.beans.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * bean 信息demo
 * 文档参考：https://www.cnblogs.com/shijiaoyun/p/4415356.html
 * {@link java.beans.BeanInfo}
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月01日 16:15
 * @version 1.0
 * @since 1.0
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo beanInfo = Introspector.getBeanInfo(PersonModel.class);
        PersonModel person = new PersonModel();
        AtomicReference<PropertyEditor> propertyEditor = new AtomicReference<>();
        Arrays.stream(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                    // propertyDescriptor 允许添加属性编辑器 propertyEditor
                    // like GUI -> text to propertyType
                    // name -> string  age-> integer
                    Class<?> propertyType = propertyDescriptor.getPropertyType();//属性类型
                    String propertyName = propertyDescriptor.getName();//属性名称
                    if ("age".equals(propertyName)) {
                        // 为"age" 字段添加propertyEditor, string -> age
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                    }
                });
    }

    public static class StringToIntegerPropertyEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            super.setValue(value);
        }

    }
}
