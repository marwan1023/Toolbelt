package huplay;

public class Score {
    private static Score ourInstance = new Score();

    public static Score getInstance() {
        return ourInstance;
    }

    private int spellingScore = 0;
    private int mathScore = 0;
    private int mathHighScore = 0;

    private Score() {

    }

    public void resetSpellingScore() { spellingScore = 0;}

    public void resetMathScore() { mathScore = 0;}

    public void incrementMathScore(int point)
    {
        mathScore += point;
    }

    public void decrementMathScore(int point)
    {
        if (mathScore != 0)
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

        if (spellingScore != 0)
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


}
