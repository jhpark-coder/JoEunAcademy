/*
버튼의 실제 값 처리에 쓰이는 클래스.
하나의 버튼은 하나의 셀을 가짐

 */

public class Cell {
    private boolean isOpened; // 열렸는지 여부
    private boolean isMine; // 지뢰 여부
    private boolean isFlagged; //깃발 여부
    private int adjacentMines; // 주위에 지뢰 몇개인지 체크

    public Cell() { // 처음엔 false로 초기화해줌(닫혀있고, 지뢰가 없고, 깃발이 없는 상태)
        this.isOpened = false;
        this.isMine = false;
        this.isFlagged = false;
        this.adjacentMines = 0;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}
