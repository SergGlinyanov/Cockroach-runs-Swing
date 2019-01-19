package Tarakan;
import java.awt.event.KeyEvent;

public class Player {

    private int x = 0;
    private int y = 0;
    private int speed = 2;
    private int mapX = 100;
    private int mapY = 100;

    private Direction playerDirection = Direction.NONE;

    public void move() {
        switch(playerDirection) {
            case UP:
                mapY+=speed;
                break;
            case DOWN:
                mapY-=speed;
                break;
            case LEFT:
                mapX+=speed;
                break;
            case RIGHT:
                mapX-=speed;
                break;
            default:
                break;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            playerDirection = Direction.UP;
        }
        if(key == KeyEvent.VK_S) {
            playerDirection = Direction.DOWN;
        }
        if(key == KeyEvent.VK_A) {
            playerDirection = Direction.LEFT;
        }
        if(key == KeyEvent.VK_D) {
            playerDirection = Direction.RIGHT;
        }
    }

    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }
}