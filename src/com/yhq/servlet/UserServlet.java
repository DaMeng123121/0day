package com.yhq.servlet;

import com.yhq.dao.UserDao;
import com.yhq.daoImpl.UserDaoImpl;
import com.yhq.vo.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        UserDao ud = new UserDaoImpl();
        ArrayList<User> list = ((UserDaoImpl) ud).selectAll();
        req.setAttribute("userinfo", list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
