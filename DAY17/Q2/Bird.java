package WEEK04.DAY17.Q2;

public class Bird extends Animal {

    Bird(String name, String color){
        super(name, color);
    }

    @Override
    public void behavior(){
        System.out.println(getColor() + " " + getName() + "(은/는) 날아다닌다");
    }
}
