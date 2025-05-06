package P20250504.FishGame;

public class Lake {

    private Fish[][] fishes;
    private final int MAX_FISHES;
    private int fishCount;

    Lake(int size, int maxFish){
        fishes = new Fish[size][size];
        fishCount = 0;
        MAX_FISHES = maxFish;
    }

    public void setFishes(int i, int j, Fish fish) {
        fishes[i][j] = fish;
    }

    public Fish[][] getFishes(){
        return fishes;
    }

    public void updateFishCount(int num){
        fishCount+=num;
    }

    public int getFishCount(){
        return fishCount;
    }

    public int getMAX_FISHES(){
        return MAX_FISHES;
    }


}
