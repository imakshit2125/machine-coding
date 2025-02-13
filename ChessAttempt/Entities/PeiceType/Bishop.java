package Entities.PeiceType;

import Entities.ChessBoard;
import Entities.Peice;

public class Bishop extends Peice {
    public Bishop(boolean isWhite,String name){
        super(isWhite,name);
    }

    public boolean isValidMove(ChessBoard board, int startX, int startY, int endX, int endY){
        int x = Math.abs(startX-endX);
        int y = Math.abs(startY-endY);

        if(x==y){
            if(!checkPathClear(board,startX,startY,endX,endY)) return false;
            Peice p = board.getPeice(endX,endY);
            return p == null || p.isWhite() != isWhite();
        }
        return false;
    }

    private boolean checkPathClear(ChessBoard board, int startRow, int startCol, int endRow, int endCol) {
        int rowStep = Integer.compare(endRow, startRow);
        int colStep = Integer.compare(endCol, startCol);
        int currentRow = startRow + rowStep;
        int currentCol = startCol + colStep;

        while (currentRow != endRow || currentCol != endCol) {
            if (board.getPeice(currentRow, currentCol) != null) {
                return false; // Path is blocked
            }
            currentRow += rowStep;
            currentCol += colStep;
        }
        return true;
    }
}
