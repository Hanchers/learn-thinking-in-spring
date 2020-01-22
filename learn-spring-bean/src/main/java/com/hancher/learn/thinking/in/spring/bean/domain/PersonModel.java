package com.hancher.learn.thinking.in.spring.bean.domain;
/**
 * 人员bean类
 * setter / getter 方法
 * 可写方法(writable) / 可读方法 (readable)
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月01日 16:11
 * @version 1.0
 * @since 1.0
 */
public class PersonModel {
    private String name;

    private Integer age;

    private CarModel car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CarModel getCar() {
        return car;
    }

    public void setCar(CarModel car) {
        this.car = car;
    }
}
