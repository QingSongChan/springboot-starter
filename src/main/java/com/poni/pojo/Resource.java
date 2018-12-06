package com.poni.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 *@author:PONI_CHAN
 *@date:2018/12/1 15:13
 */
@Configuration
@ConfigurationProperties(prefix = "com.poni.opensource")   //前缀
@PropertySource(value = "classpath:resource.properties")   //项目打包后resource下的文件全部都在classpath下面，版本不同设置不同
public class Resource {

    private String name;

    private Integer age;

    private String major;

    private String favourite;

    private String phone;

    private String language;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getFavourite() {
        return favourite;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", favourite='" + favourite + '\'' +
                ", phone='" + phone + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
