package my.bull.servlets;

import my.bull.jdbc.DAO.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by book on 01.02.2018.
 */
public class IndexSrv extends HttpServlet {

    public void doGet (HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        UsersDAO usersDAO = new UsersDAO();
        usersDAO.createUser("test", "pass");

            request.getRequestDispatcher("/result.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UsersDAO ud = new UsersDAO();
        if (ud.createUser(login, password)) {
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
//            req.getRequestDispatcher("/game").forward(req, resp);
            resp.sendRedirect("/game");
        }
        else
            resp.sendRedirect("/");


    }
}