package my.bull.servlets;

import my.bull.jdbc.DAO.GameSessionDAO;
import my.bull.jdbc.DAO.ScoresDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by book on 02.02.2018.
 */
public class ResultSrv extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ScoresDAO scores = new ScoresDAO();
        HttpSession session = req.getSession();
        session.setAttribute("allScores", scores.getAllScores());
        session.setAttribute("bestScores", scores.getBestScores());
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        GameSessionDAO gs = new GameSessionDAO();
        ScoresDAO scores = new ScoresDAO();
        String s = req.toString();
        System.out.println(s);
        HttpSession session = req.getSession();
        Object sessionId = session.getAttribute("sessionId");
        Object tryCount = session.getAttribute("tryCount");
        Object userId = session.getAttribute("userId");
        gs.updateScore((Integer)sessionId, (Integer)tryCount);
        scores.createScore((Integer)userId, (Integer)tryCount);

        session.setAttribute("allScores", scores.getAllScores());
        session.setAttribute("bestScores", scores.getBestScores());

        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }
}
