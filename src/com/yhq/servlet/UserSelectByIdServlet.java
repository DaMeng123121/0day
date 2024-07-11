package com.yhq.servlet;

import com.yhq.dao.UserDao;
import com.yhq.daoImpl.UserDaoImpl;
import com.yhq.vo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserSelectByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        UserDao ud = new UserDaoImpl();
        User u = ud.selectById(id);

        if (u != null) {
            req.setAttribute("userinfo",u);
            req.getRequestDispatcher("userUpdate.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("UserSelectByIdServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
