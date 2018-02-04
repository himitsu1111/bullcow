package my.bull.jdbc.DAO;

import my.bull.game.TheGame;
import my.bull.jdbc.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by book on 02.02.2018.
 */
public class GameSessionDAO {
    public boolean createGameSession(String secretNumber, Integer userId, Integer score) {

        String sql = "insert into gamesession (secret_number, user_id, score) values (?, ?, ?); "; //con name 2, con1, con2

        Connection con = ConnectionSingleton.getInstance();
        score = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, secretNumber);
            ps.setInt(2, userId);
            ps.setInt(3, score);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public TheGame selectGame(String secretNumber, Integer user) {

        String sql = "select * from gamesession where secret_number = ? and user_id = ?";
        Connection con = ConnectionSingleton.getInstance();
        Integer login = null;
        TheGame newGame = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, secretNumber);
            ps.setInt(2, user);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                newGame = new TheGame(rs.getInt("id"), rs.getString("secret_number"),
                                rs.getInt("user_id"), rs.getInt("score"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newGame;
    }

    public void updateScore(Integer id, int score) {

        String sql = "update gamesession set score = ? where id = ?";
        Connection con = ConnectionSingleton.getInstance();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, score);
            ps.setInt(2, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
