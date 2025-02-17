import java.awt.*;

public class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    private String modelName; // The car model name

    public double x = 0;
    public double y = 0;
    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    public Direction direction = Direction.NORTH;

    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    @Override
    public void move(){
        switch(direction){
            case NORTH: y += currentSpeed; break;
            case SOUTH: y -= currentSpeed; break;
            case EAST : x += currentSpeed; break;
            case WEST : x -= currentSpeed; break;
        }
    }

    @Override
    public void turnLeft(){
        switch(direction){
            case NORTH: direction = Direction.WEST;
            case SOUTH: direction = Direction.EAST;
            case EAST : direction = Direction.NORTH;
            case WEST : direction = Direction.SOUTH;
        }
    }

    @Override
    public void turnRight(){
        switch(direction){
            case NORTH: direction = Direction.EAST;
            case SOUTH: direction = Direction.WEST;
            case EAST : direction = Direction.SOUTH;
            case WEST : direction = Direction.NORTH;
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public Direction getDirection(){
        return direction;
    }

    public String getModelName(){
        return modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public double speedFactor(){
        return enginePower;
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1 ) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
