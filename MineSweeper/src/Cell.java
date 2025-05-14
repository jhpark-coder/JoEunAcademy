/*
버튼의 실제 값 처리에 쓰이는 클래스.
하나의 버튼은 하나의 셀을 가짐

 */

public class Cell {
    private boolean isOpened;
    private boolean isMine;
    private boolean isFlagged;

    public Cell() { // 처음엔 false로 초기화해줌(닫혀있고, 지뢰가 없고, 깃발이 없는 상태)
        this.isOpened = false;
        this.isMine = false;
        this.isFlagged = false;
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


}
