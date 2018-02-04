package my.bull.game;

/**
 * Created by book on 02.02.2018.
 */
public class TheGame {
    private Integer id;
    private String secretNumber;
    private Integer userId;
    private Integer score;

    public TheGame(Integer id, String secretNumber, Integer userId, Integer score) {
        this.id = id;
        this.secretNumber = secretNumber;
        this.userId = userId;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
