package com.yhq.dao;

import com.yhq.vo.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {
    //登录
    public boolean login(String Name, String password)  throws SQLException ;

    //全查询
    public ArrayList<User> selectAll() throws SQLException;

    //增加
    public boolean add(User u) ;

    //删除
    public boolean delete(int id) ;
    //单个查询
    public  User selectById(int id) ;
    //修改
    public boolean update(User u) ;

}
