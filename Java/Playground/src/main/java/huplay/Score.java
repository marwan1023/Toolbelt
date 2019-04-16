package huplay;

public class Score {
    private static Score ourInstance = new Score();

    public static Score getInstance() {
        return ourInstance;
    }

    private int spellingScore = 0;
    private int mathScore = 0;
    private int mathHighScore = 0;
    private int spellingHighScore = 0;

    private Score() {

    }

    public void incrementMathScore(int point)
    {
        mathScore += point;
    }

    public void decrementMathScore(int point)
    {
        mathScore -= point;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void incrementSpellingScore(int point)
    {
        spellingScore += point;
    }

    public void decrementSpellingScore(int point) {
        spellingScore -= point;
    }

    public int getSpellingScore() {
        return spellingScore;
    }

    public int getMathHighScore() {
        return mathHighScore;
    }

    public void setMathHighScore(int mathHighScore) {
        this.mathHighScore = mathHighScore;
    }

    public int getSpellingHighScore() {
        return spellingHighScore;
    }

    public void setSpellingHighScore(int spellingHighScore) {
        this.spellingHighScore = spellingHighScore;
    }



}
