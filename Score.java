public class Score {
    private double startingScore;
    private double currentScore;
    private int numOfRoom = 0;
    private int numOfPuzzles = 0;
    private final int PUZZLE_VALUE = 10;

    public Score(int startingScore){
        this.startingScore = startingScore;
    } 

    public void visitRoom(){
        numOfRoom++;
    }

    public void solvePuzzle(){
        numOfPuzzles++;
    }

    public double getScore(){
        currentScore = startingScore - numOfRoom + (numOfPuzzles * PUZZLE_VALUE);
        return currentScore;
    }
}