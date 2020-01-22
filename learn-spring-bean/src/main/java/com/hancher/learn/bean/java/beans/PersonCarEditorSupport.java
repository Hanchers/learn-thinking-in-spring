package com.hancher.learn.bean.java.beans;

import com.hancher.learn.bean.domain.CarModel;

import java.beans.PropertyEditorSupport;

/**
 * 属性编辑器demo
 * 通过配置，直接实例对应的人员+车实例
 * <p/>
 *
 * @author baihz
 * @date Created in 2020年01月02日 23:58
 * @version 1.0
 * @since 1.0
 */
public class PersonCarEditorSupport extends PropertyEditorSupport {
    public void setAsText(String text) throws java.lang.IllegalArgumentException {
        if (text == null || !text.contains(",")) {
            throw new IllegalArgumentException("非法字符");
        }

        String[] infos = text.split(",");
        CarModel car = new CarModel();
        car.setName(infos[0]);
        car.setColor(infos[1]);
        car.setSpeed(Integer.parseInt(infos[2]));

        setValue(car);
    }
}
