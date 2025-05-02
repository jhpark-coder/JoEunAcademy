package WEEK04.DAY17.Q2;

public class Dog extends Animal{

    Dog(String name, String color){
        super(name, color);
    }

    @Override
    public void behavior(){
        System.out.println(getColor() + " " + getName() +  "(은/는) 짖는다");
    }

}
