package com.example.servlet;


import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to the /add.jsp page to display the form
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/add.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User(firstName, lastName);
        Warehouse.getInstance().addUser(user);

        request.setAttribute("user", user);
//        response.sendRedirect(request.getContextPath() + "/add");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/add.jsp");
        requestDispatcher.forward(request, response);
    }
}
