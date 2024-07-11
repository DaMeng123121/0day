package com.yhq.daoImpl;


import java.sql.Connection;
import com.yhq.dao.UserDao;
import com.yhq.db.DBConnetcion;
import com.yhq.vo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDaoImpl implements UserDao {

    //链接
    public Connection conn;
    //预处理
    public PreparedStatement pst;
    //结果
    public ResultSet rs;

    public boolean login(String name, String password) throws SQLException {
        boolean flag = false;

        //链接
        DBConnetcion db = new DBConnetcion();
        conn = db.getConn();

        String sql="select * from user where name=? and password=?";

        pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, password);
        rs = pst.executeQuery();

        if (rs.next()) {
            flag = true;
        }
        return flag;
    }

    public ArrayList<User> selectAll(){
        ArrayList<User> list = new ArrayList<User>();

        DBConnetcion db=new DBConnetcion();
        conn= db.getConn();

        String sql="select * from user";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setAge(rs.getInt("age"));
                u.setSex(rs.getString("sex"));
                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public boolean add(User u){
        DBConnetcion db = new DBConnetcion();
        conn= db.getConn();

        String  sql="insert into user values(id,?,?,?,?)";

        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, u.getName());
            pst.setString(2, u.getPassword());
            pst.setInt(3, u.getAge());
            pst.setString(4, u.getSex());
            int flag=pst.executeUpdate();
            if(flag>0){
                return true;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean delete(int id){
        DBConnetcion db = new DBConnetcion();
        conn= db.getConn();

        String sql="delete from user where id=?";

        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, id);
            int flag=pst.executeUpdate();
            if(flag>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    public User selectById(int id){
        DBConnetcion db = new DBConnetcion();
        conn= db.getConn();

        String sql="select * from user where id=?";
        User u = new User();//创建对象
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,id);

            rs=pst.executeQuery();//查询数据
            while(rs.next()){//u储值
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setAge(rs.getInt("age"));
                u.setSex(rs.getString("sex"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    public boolean update(User u){
        DBConnetcion db = new DBConnetcion();
        conn= db.getConn();

        String sql="update user set name =? ,password=?,age=?,sex=? where id=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, u.getName());
            pst.setString(2, u.getPassword());
            pst.setInt(3, u.getAge());
            pst.setString(4,u.getSex());
            pst.setInt(5,u.getId());
            int flag=pst.executeUpdate();
            if(flag>0){
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}
