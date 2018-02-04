package my.bull.jdbc.DAO;

import my.bull.jdbc.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by book on 02.02.2018.
 */
public class UsersDAO {

    public boolean createUser(String login, String password) {

        String sql = "insert into users (login, pas) values (?, ?); "; //con name 2, con1, con2

        Connection con = ConnectionSingleton.getInstance();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Integer logMeIn(String log, String password) {

        String sql = "select id from users where login = ? and pas = ?";
        Connection con = ConnectionSingleton.getInstance();
        Integer login = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, log);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                login = rs.getInt("id");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }
}
