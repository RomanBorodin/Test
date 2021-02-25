import java.math.*;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.DOWN);
        moveRobot(robot, -10, 20);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();
        int dX, dY;
        Direction dir_X = Direction.LEFT, dir_Y = Direction.UP, Direct;
        Direct = robot.getDirection();
        dX = toX-x;
        dY = toY-y;
        if (dX > 0){
            dir_X = Direction.RIGHT;
        }
        else if (dX < 0) {
            dir_X = Direction.LEFT;
        }
        if (dY > 0){
            dir_Y = Direction.UP;
        }
        else if (dY < 0){
            dir_Y = Direction.DOWN;
        }
        while (Direct!=dir_X){
            robot.turnRight();
            Direct = robot.getDirection();
        }
        for (int iX=0; x != Math.abs(dX); iX++){
            robot.stepForward();
        }
        while (Direct!=dir_Y){
            robot.turnRight();
            Direct = robot.getDirection();
        }
        for (int iY = 0; iY != Math.abs(dY); iY++){
            robot.stepForward();
        }
    }
}