package com.zc.pojo;

/**
 * @ClassName com.zc.pojo.User
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/7 10:12
 * @Version 1.0
 **/
public class User {
    private int id;
    private String name;
    private String password;
    private String salt;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
