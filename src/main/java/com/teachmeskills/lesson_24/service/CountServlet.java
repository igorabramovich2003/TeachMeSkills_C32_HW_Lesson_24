package com.teachmeskills.lesson_24.service;

import com.teachmeskills.lesson_24.servlet.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class CountServlet extends HttpServlet {
    @Override
    public void init() {
        Logger.log("CountServlet init");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        Logger.log("CountServlet doGet is running");

        try {
            HttpSession session = req.getSession();
            Integer visitCount = (Integer) session.getAttribute("visitCount");

            if (visitCount == null) {
                visitCount = 0;
            }
            visitCount++;
            session.setAttribute("visitCount", visitCount);

            resp.setContentType("text/html");
            PrintWriter respWriter = resp.getWriter();
            respWriter.println("<html><body>");
            respWriter.println("<h1>Visits count: " + visitCount + "</h1>");
            respWriter.println("</body></html>");
            Logger.log("CountServlet - counter is " + visitCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {
        Logger.log("CountServlet destroy");
    }
}
