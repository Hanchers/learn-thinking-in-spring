package com.hancher.learn.thinking.in.spring.ioc.domain;

import com.hancher.learn.thinking.in.spring.ioc.enums.CityEnum;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;

/**
 * 用户类
 *
 * <p/>
 * @author Hancher
 * @date Created in 2020年01月17日 17:56
 * @version 1.0
 * @since 1.0
 */
public class UserModel {
    private Long id;

    private String name;

    private CityEnum city;

    private CityEnum[] workCities;

    private List<CityEnum> lifeCities;

    private Resource configFileLocation;

    /**
     * 当前 Bean 的名称
     */
    private transient String beanName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityEnum getCity() {
        return city;
    }

    public void setCity(CityEnum city) {
        this.city = city;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public void setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
    }

    public CityEnum[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(CityEnum[] workCities) {
        this.workCities = workCities;
    }

    public List<CityEnum> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<CityEnum> lifeCities) {
        this.lifeCities = lifeCities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", configFileLocation=" + configFileLocation +
                '}';
    }
}
