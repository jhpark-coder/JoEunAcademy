package WEEK05.DAY18.Q3;

import java.util.Random;

public class Q3Main {
    public static void main(String[] args) {
        Random r = new Random();
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car(r);
        vehicles[1] = new Bicycle(r);
        vehicles[2] = new Motorcycle(r);

        int turn = 0;
        final int GOAL = 500;
        while(vehicles[0].getMileage() < GOAL && vehicles[1].getMileage() < GOAL && vehicles[2].getMileage() < GOAL){

            System.out.println("================="+(++turn)+"턴째===========================");
            int ranNum = r.nextInt(3);

            for(int i = 0 ; i < vehicles.length ; i++){

                vehicles[i].setGauge(vehicles[i].getGauge()+1);
                if(i == ranNum){
                    activateBooster((Booster)vehicles[i],false);

                }else{
                    vehicles[i].move();
                    activateBooster((Booster)vehicles[i],true);
                }
                printAll(vehicles[i]);
            }
        }

        int maxIndex = -1;
        int maxMeter = 0;
        for(int i = 0 ; i < vehicles.length ; i++){
            if(vehicles[i].getMileage() > maxMeter){
                maxMeter = vehicles[i].getMileage();
                maxIndex = i;
            }
        }
        System.out.println("=========================================================");
        System.out.println("축하합니다. "+vehicles[maxIndex].toString()+"의 승리입니다.");
    }

    public static void activateBooster(Booster b,boolean check){
        if(b instanceof Car){
            Vehicle car = (Car) b;
            if(b != null && car.getGauge() == 4){
                car.setGauge(0);
                if(check) {
                    car.setMileage(car.getMileage() + 2);
                }
            }
        }else if(b instanceof Bicycle){
            Vehicle bicycle = (Bicycle) b;
            if(b != null && bicycle.getGauge() == 2){
                bicycle.setGauge(0);
                if(check) {
                    bicycle.setMileage(bicycle.getMileage() + 5);
                }
            }

        }else{
            Vehicle motorcycle = (Motorcycle) b;
            if(b != null && motorcycle.getGauge() == 3){
                motorcycle.setGauge(0);
                if(check) {
                    motorcycle.setMileage(motorcycle.getMileage() + 3);
                }
            }
        }
    }

    public static void printAll(Vehicle v){
        if(v instanceof Car){
            Car c = (Car)v;
            c.printGauge();
            c.printMileage();
        }else if(v instanceof Bicycle){
            Bicycle b = (Bicycle)v;
            b.printGauge();
            b.printMileage();
        }else{
            Motorcycle m = (Motorcycle)v;
            m.printGauge();
            m.printMileage();
        }
    }
}
