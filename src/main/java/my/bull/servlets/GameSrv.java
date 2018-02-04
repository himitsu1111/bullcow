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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by book on 02.02.2018.
 */
public class GameSrv extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String login = (String)req.getSession().getAttribute("login");
        String password = (String)req.getSession().getAttribute("password");
        UsersDAO ud = new UsersDAO();
        GameSessionDAO gs = new GameSessionDAO();
        Integer log = ud.logMeIn(login, password);

        List<Integer> secretList = GameClass.generate();
        StringBuffer stringBuffer = new StringBuffer(4);
        for (Integer i : secretList) {
            stringBuffer.append(String.valueOf(i));
        }
        gs.createGameSession(stringBuffer.toString(), log, 0);
        TheGame theGame = gs.selectGame(stringBuffer.toString(), log);

        req.getSession().setAttribute("secretNum", theGame.getSecretNumber());
        req.getSession().setAttribute("secretArray", secretList);
        req.getSession().setAttribute("tryCount", 0);
        req.getSession().setAttribute("sessionId", theGame.getId());
        req.getSession().setAttribute("userId", theGame.getUserId());

        req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sellOne = (String)req.getParameter("sellOne");
        String sellTwo = (String)req.getParameter("sellTwo");
        String sellThree = (String)req.getParameter("sellThree");
        String sellFour = (String)req.getParameter("sellFour");

        ArrayList<Integer> secretList = (ArrayList<Integer>)req.getSession().getAttribute("secretArray");
        System.out.println(secretList.toString());
        List<Integer> resultList = new ArrayList<Integer>();

        resultList.add(Integer.valueOf(req.getParameter("sellOne")));
        resultList.add(Integer.valueOf(req.getParameter("sellTwo")));
        resultList.add(Integer.valueOf(req.getParameter("sellThree")));
        resultList.add(Integer.valueOf(req.getParameter("sellFour")));
        int bulls = GameClass.bullExist(secretList, resultList);
        int cows = GameClass.cowExist(secretList, resultList);
        System.out.println(sellOne + sellTwo + sellThree + sellFour + " result sells");
        System.out.println("bulls - " + bulls + " cows - " + cows);
        int count = (Integer)req.getSession().getAttribute("tryCount") + 1;

        req.setAttribute("bulls", bulls);
        req.setAttribute("cows", cows);

        req.getSession().setAttribute("tryCount", count);

        if (bulls == 4 && cows == 4)
           // resp.sendRedirect("/result");
            req.getRequestDispatcher("/result").forward(req, resp);
        else
            req.getRequestDispatcher("/game.jsp").forward(req, resp);
    }
}
