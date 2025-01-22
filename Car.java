import java.awt.*;

public class Car implements Movable {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name

    private double x = 0;
    private double y = 0;
    private String direction = "NORTH";

    @Override
    public void move(){
        switch(direction){
            case "NORTH": y += currentSpeed;
            case "SOUTH": y -= currentSpeed;
            case "EAST" : x += currentSpeed;
            case "WEST" : x -= currentSpeed;
        }
    }

    @Override
    public void turnLeft(){
        switch(direction){
            case "NORTH": direction = "WEST";
            case "SOUTH": direction = "EAST";
            case "EAST" : direction = "NORTH";
            case "WEST" : direction = "SOUTH";
        }
    }

    @Override
    public void turnRight(){
        switch(direction){
            case "NORTH": direction = "EAST";
            case "SOUTH": direction = "WEST";
            case "EAST" : direction = "SOUTH";
            case "WEST" : direction = "NORTH";
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String getDirection(){
        return direction;
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
}
