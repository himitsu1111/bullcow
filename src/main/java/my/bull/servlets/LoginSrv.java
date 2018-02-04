package my.bull.servlets;

import my.bull.game.GameClass;
import my.bull.game.TheGame;
import my.bull.jdbc.DAO.GameSessionDAO;
import my.bull.jdbc.DAO.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by book on 02.02.2018.
 */
public class LoginSrv extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("loginL");
        String password = req.getParameter("passwordL");
        UsersDAO ud = new UsersDAO();
        Integer log = ud.logMeIn(login, password);
        if ((login != null) && (password != null)
                && (!login.equals(""))
                && (!password.equals(""))
                && log != null) {

            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            resp.sendRedirect("/game");
        }
        else
            resp.sendRedirect("/");

    }

}
