package com.yhq.servlet;

import com.yhq.dao.UserDao;
import com.yhq.daoImpl.UserDaoImpl;
import com.yhq.vo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserUpdateServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        int age = Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");

        User u=new User(id,name,pwd,age,sex);

        UserDao ud=new UserDaoImpl();
        boolean flag=ud.update(u);
        resp.sendRedirect("UserServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
