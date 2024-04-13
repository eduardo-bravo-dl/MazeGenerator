public class MazeCell {
    private int row;
    private int col;
    private CellStatus status;
    private CellDirection direction;

    public MazeCell(int row, int col) {
        this.row = row;
        this.col = col;
        status = CellStatus.UNCOMPLETED;
        direction = null;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public CellDirection getDirection() {
        return direction;
    }

    public void setDirection(CellDirection direction) {
        this.direction = direction;
    }
}