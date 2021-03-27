package Utils;

import Commands.ExceptionsForCommands.NullException;
import Commands.ExceptionsForCommands.ValueTooBigException;


public class Coordinates {
    private int x; //Значение поля должно быть больше -856
    private Integer y; //Поле не может быть null

    public Coordinates(int x, Integer y) throws NullException, ValueTooBigException{
        this.x=x;
        this.y=y;
    }


    public int getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
