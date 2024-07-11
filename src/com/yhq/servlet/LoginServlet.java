package com.yhq.servlet;

import com.yhq.dao.UserDao;
import com.yhq.daoImpl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");

        HttpSession session = req.getSession();
        UserDao ud = new UserDaoImpl();
        try {
            boolean flag=ud.login(name,pwd);
            if(flag){
                session.setAttribute("Username",name);
                //转发
                //req.getRequestDispatcher("index.jsp").forward(req,resp);

                req.getRequestDispatcher("UserServlet").forward(req,resp);
            }else{
                //重定向
                resp.sendRedirect("error.jsp");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
