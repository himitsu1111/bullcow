package my.bull.jdbc.POJO;

/**
 * Created by book on 03.02.2018.
 */
public class BestScores {
    private String user;
    private Double score;

    public BestScores(String user, Double score) {
        this.user = user;
        this.score = score;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
