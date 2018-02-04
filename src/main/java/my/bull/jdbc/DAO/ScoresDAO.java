package my.bull.jdbc.DAO;

import my.bull.game.TheGame;
import my.bull.jdbc.ConnectionSingleton;
import my.bull.jdbc.POJO.BestScores;
import my.bull.jdbc.POJO.Scores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by book on 02.02.2018.
 */
public class ScoresDAO {

    public boolean createScore(Integer userId, Integer triesNumber) {

        String sql = "insert into scores (userid, finalscore, triesnumber) " +
                "values (?, ?, ?); ";
        String sqlFinalScore = "select avg(triesnumber) as finalscore from scores where userid = ?";
        Connection con = ConnectionSingleton.getInstance();
        double score = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement psFS = con.prepareStatement(sqlFinalScore);
            psFS.setInt(1, userId);
            ResultSet rs = psFS.executeQuery();

            if (rs.next()){
                score = rs.getDouble("finalscore");

            }

            ps.setInt(1, userId);
            ps.setDouble(2, score);
            ps.setInt(3, triesNumber);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Scores> getAllScores() {

        String sql = "select u.login as user, s.triesnumber from scores s, users u where u.id = s.userid";
        Connection con = ConnectionSingleton.getInstance();
        ArrayList<Scores> al = new ArrayList<Scores>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                al.add(new Scores(rs.getString("user"), rs.getInt("triesnumber")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }

    public ArrayList<BestScores> getBestScores() {

        String sql = "select u.login as user, avg(s.triesnumber) as finalscore from scores s, users u where u.id = s.userid group by u.login";
        Connection con = ConnectionSingleton.getInstance();
        ArrayList<BestScores> al = new ArrayList<BestScores>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                al.add(new BestScores(rs.getString("user"),rs.getDouble("finalscore")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
}
