public class Map {
    private int width;
    private int height;
    private Character[][] mapArr;
    final private char EMPTY = '.';

    public Map(int width, int height){
        this.width = width;
        this.height = height;
        mapArr = new Character[width][height];

        for(int i = 0; i < mapArr.length; i++){
            for(int j = 0; j < mapArr[i].length; j++){
                mapArr[i][j] = EMPTY;
            }
        }
    }

    public void placeRoom(Position pos, char symbol){
        boolean isXInBoundary = pos.getX() >= 0 && pos.getX() <= width;
        boolean isYinBoundary = pos.getY() >= 0 && pos.getY() <= height;

        if(isXInBoundary && isYinBoundary){
            mapArr[pos.getX() - 1][pos.getY() - 1] = symbol;
        }
    }

    public String display(){
        String map = "";

        for(int i = 0; i < mapArr.length; i++){
            for(int j = 0; j < mapArr[i].length; j++){
                map += mapArr[i][j] + " ";
            }

            map += "\n";
        }

        return map;
    }
}