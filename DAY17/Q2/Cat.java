package WEEK04.DAY17.Q2;

public class Cat extends Animal{

    Cat(String name, String color){
        super(name, color);
    }

    @Override
    public void behavior(){
        System.out.println(getColor() + " " + getName() +  "(은/는) 야옹한다");
    }
}
