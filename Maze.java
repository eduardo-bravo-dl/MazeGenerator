import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Maze {
    private int completedCells = 0;
    private static final int ROWS = 20;
    private static final int COLUMNS = 20;
    private MazeCell[][] maze = new MazeCell[ROWS][COLUMNS];

    public Maze() {
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                maze[i][j] = new MazeCell(i, j);
            }
        }
    }

    public void buildMaze() {
        MazeCell startingCell = pickUncompletedCell();
        markAsCompleted(startingCell);
        while(completedCells < ROWS * COLUMNS) {
            MazeCell joiningCell = pickUncompletedCell();
            joinToCompleted(joiningCell);
        }
    }

    private MazeCell pickUncompletedCell() {
        Random random = new Random();
        int r = 0;
        int c = 0;
        do {
            r = random.nextInt(ROWS);
            c = random.nextInt(COLUMNS);
        } while(maze[r][c].getStatus() != CellStatus.UNCOMPLETED);

        return maze[r][c];
    }

    private void markAsCompleted(MazeCell cell) {
        cell.setStatus(CellStatus.COMPLETED);
        completedCells++;
    }

    private void joinToCompleted(MazeCell startingCell) {
        MazeCell currentCell = startingCell;
        while(currentCell.getStatus() != CellStatus.COMPLETED) {
            CellDirection direction = getValidDirectionToMove(currentCell);
            currentCell.setDirection(direction);
            currentCell = getNextCell(currentCell);
        }
        walkToCell(startingCell, currentCell);
    }

    private CellDirection getValidDirectionToMove(MazeCell cell) {
        List<CellDirection> availableDirections = new ArrayList<>();
        if(cell.getRow() != 0) {
            availableDirections.add(CellDirection.UP);
        }
        if(cell.getCol() != 0) {
            availableDirections.add(CellDirection.LEFT);
        }
        if(cell.getRow() != ROWS - 1) {
            availableDirections.add(CellDirection.DOWN);
        }
        if(cell.getCol() != COLUMNS - 1) {
            availableDirections.add(CellDirection.RIGHT);
        }
        return CellDirection.getDirectionFromList(availableDirections);
    }

    private MazeCell getNextCell(MazeCell cell) {
        CellDirection direction = cell.getDirection();
        int nextRow = cell.getRow() + direction.getRowIndexIncrement();
        int nextCol = cell.getCol() + direction.getColIndexIncrement();
        return maze[nextRow][nextCol];
    }

    private void walkToCell(MazeCell startingCell, MazeCell targetCell) {
        MazeCell currentCell = startingCell;
        while(currentCell != targetCell) {
            markAsCompleted(currentCell);
            currentCell = getNextCell(currentCell);
        }
    }

    public void printMaze() {
        for(int row = 0; row < ROWS; row++) {
            for(int c = 0; c < COLUMNS; c++) {
                if(row == 0 || (maze[row][c].getDirection() != CellDirection.UP && maze[row - 1][c].getDirection() != CellDirection.DOWN)) {
                    System.out.print("+---");
                } else {
                    System.out.print("+   ");
                }
            }
            System.out.println("+");
            for(int c = 0; c < COLUMNS; c++) {
                if(c == 0 || (maze[row][c].getDirection() != CellDirection.LEFT && maze[row][c - 1].getDirection() != CellDirection.RIGHT)) {
                    System.out.print("|   ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println("|");
        }
        for(int c = 0; c < COLUMNS; c++) {
            System.out.print("+---");
        }   
        System.out.println("+");
    }
}