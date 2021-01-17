package org.example.servlets;

import org.example.beans.AlienBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class AlienServlet extends HttpServlet {

    @EJB
    private AlienBean alienBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();

        log("test");
        log(alienBean.toString());
        session.setAttribute("aliensList",alienBean.findAll());


        RequestDispatcher dispatcher = getServletContext().getNamedDispatcher("/page.jsp");
        if(dispatcher != null){
            dispatcher.forward(request, response);
        }
    }


}
