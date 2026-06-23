package e3_1;

public class SportsCar extends Car {

    public SportsCar(String typeName, double gasolineCapacity, double startSpeed) {
        super(typeName, gasolineCapacity, startSpeed);
    }

    @Override
    public void accelerate() {
        super.accelerate();
        super.accelerate();
        
    }

    @Override
    public void decelerate(int amount) {
        super.decelerate(amount*2);
        
    }
}

