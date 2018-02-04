package my.bull.jdbc.POJO;

/**
 * Created by book on 03.02.2018.
 */
public class Scores {

    private String userid;

    private Integer triesnumber;

    public Scores(String userid, Integer triesnumber) {
        this.userid = userid;
        this.triesnumber = triesnumber;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getTriesnumber() {
        return triesnumber;
    }

    public void setTriesnumber(Integer triesnumber) {
        this.triesnumber = triesnumber;
    }
}
