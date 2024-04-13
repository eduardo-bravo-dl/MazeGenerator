import java.util.Random;
import java.util.List;

public enum CellDirection {
    UP(-1, 0),
    RIGHT(0, 1),
    DOWN(1, 0),
    LEFT(0, -1);

    private int rowIndexIncrement;
    private int colIndexIncrement;

    private CellDirection(int rowIncrement, int colIncrement){
        rowIndexIncrement = rowIncrement;
        colIndexIncrement = colIncrement;
    }

    public static CellDirection getDirectionFromList(List<CellDirection> directions){
        Random random = new Random();
        int index = random.nextInt(directions.size());
        return directions.get(index);
    }

    public int getRowIndexIncrement() {
        return rowIndexIncrement;
    }

    public int getColIndexIncrement() {
        return colIndexIncrement;
    }
}