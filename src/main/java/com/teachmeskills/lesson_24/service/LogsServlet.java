package com.teachmeskills.lesson_24.service;

import com.teachmeskills.lesson_24.servlet.Logger;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logs")
public class LogsServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.log("LogServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Logger.log("LogServlet doGet is run");
        resp.setContentType("text/html");
        final String LOG_FILE = "C:\\Users\\Igor and Maria\\IdeaProjects\\TeachMeSkills_C32_HW_Lesson_24\\src\\main\\resources\\log.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE));
             PrintWriter respWriter = resp.getWriter()) {
            String line;
            respWriter.println("<html>");
            respWriter.println("<head>");
            respWriter.println("</head>");
            respWriter.println("<body>");
            while ((line = reader.readLine()) != null) {
                respWriter.println("<p>" + line + "</p>");
            }
            respWriter.println("</body>");
            respWriter.println("</html>");
        } catch (IOException e) {
            resp.getWriter().println("Error during logs writing: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        Logger.log("LogServlet destroy");
    }
}
