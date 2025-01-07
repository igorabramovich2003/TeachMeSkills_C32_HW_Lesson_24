package com.teachmeskills.lesson_24.service;

import com.teachmeskills.lesson_24.servlet.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/about")
public class AboutMeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        Logger.log("AboutMeServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("AboutMeServlet doGet is running");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("about.html").forward(req, resp);
    }

    @Override
    public void destroy() {
        Logger.log("AboutMeServlet destroy");
    }
}

