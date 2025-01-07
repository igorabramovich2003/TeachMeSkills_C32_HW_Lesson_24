package com.teachmeskills.lesson_24.service;

import com.teachmeskills.lesson_24.servlet.Logger;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.log("ResetServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Logger.log("ResetServlet doGet is running. Counter is reset.");
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        session.invalidate();

        PrintWriter respWriter = resp.getWriter();
        respWriter.println("<html><body>");
        respWriter.println("<h1>Counter is reset.</h1>");
        respWriter.println("</body></html>");
    }

    @Override
    public void destroy() {
        Logger.log("ResetServlet destroy");
    }
}
