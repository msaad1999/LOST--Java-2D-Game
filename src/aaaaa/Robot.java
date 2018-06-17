package aaaaa;


import java.awt.Rectangle;
import java.util.ArrayList;

public class Robot {

    // Constants are Here
    final int JUMPSPEED = -17;
    final int MOVESPEED = 5;

    private int centerX = 500;
    private int centerY = 560;
    private boolean jumped = false;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean ducked = false;
    private static String direction = "right";

    private int speedX = 0;
    private int speedY = 0;
    public static Rectangle rect = new Rectangle(0, 0, 0, 0);
    public static Rectangle rect2 = new Rectangle(0, 0, 0, 0);
    public static Rectangle yellowRed = new Rectangle(0, 0, 0, 0);
    
    public static Rectangle footleft = new Rectangle(0,0,0,0);
    public static Rectangle footright = new Rectangle(0,0,0,0);
    
    
    private Background bg1 = StartingClass.getBg1();
    private Background bg2 = StartingClass.getBg2();
    private Background bg3 = StartingClass.getBg3();
    private Background bg4 = StartingClass.getBg4();

    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public void update() {
        if (speedX == 0){
            bg1.setSpeedX(0);
            bg2.setSpeedX(0);
            bg3.setSpeedX(0);
            bg4.setSpeedX(0);
        }
        
        if (centerX <= 800 && speedX > 0) {
            centerX += speedX;
        }
        if (centerX >=400 && speedX<0){
            centerX += speedX;
        }
        
        if (speedX > 0 && centerX > 800) {
            bg1.setSpeedX(-MOVESPEED / 5);
            bg2.setSpeedX(-MOVESPEED / 5);
            bg3.setSpeedX(-MOVESPEED / 5);
            bg4.setSpeedX(-MOVESPEED / 5);
        }
         if (speedX < 0 && centerX < 400){
            bg1.setSpeedX(MOVESPEED / 5);
            bg2.setSpeedX(MOVESPEED / 5);
            bg3.setSpeedX(MOVESPEED / 5);
            bg4.setSpeedX(MOVESPEED / 5);
        }
        

        // Updates Y Position
        centerY += speedY;

        // Handles Jumping

          speedY += 1;

        if (speedY > 3){
            jumped = true;
        }

        rect.setRect(centerX -55, centerY - 63	, 35, 70);
        rect2.setRect(rect.getX(), rect.getY() + 70, 35, 70);
        yellowRed.setRect(centerX - 92, centerY - 80, 110, 180);

        footleft.setRect(centerX -60, centerY - 33, 5, 95);
        footright.setRect(centerX -20, centerY - 33, 5, 95);


    }

    public void moveRight() {
        direction = "right";
        if (ducked == false) {
            speedX = MOVESPEED;
        }
    }

    public void moveLeft() {
        direction = "left";
        if (ducked == false) {
            speedX = -MOVESPEED;
        }
    }

    public void stopRight() {
        setMovingRight(false);
        stop();
    }

    public void stopLeft() {
        setMovingLeft(false);
        stop();
    }

    private void stop() {
        if (isMovingRight() == false && isMovingLeft() == false) {
            speedX = 0;
        }

        if (isMovingRight() == false && isMovingLeft() == true) {
            moveLeft();
        }

        if (isMovingRight() == true && isMovingLeft() == false) {
            moveRight();
        }

    }

    public void jump() {
        if (jumped == false) {
            speedY = JUMPSPEED;
            jumped = true;
        }

    }

    public void shoot() {
        Projectile p;
        if (getDirection() == "right")
            p = new Projectile(centerX-5, centerY-5,true);
        else
            p = new Projectile(centerX-5, centerY-5,false);
	projectiles.add(p);
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public boolean isJumped() {
        return jumped;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setJumped(boolean jumped) {
        this.jumped = jumped;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public boolean isDucked() {
        return ducked;
    }

    public void setDucked(boolean ducked) {
        this.ducked = ducked;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public ArrayList getProjectiles() {
        return projectiles;
    }

   
    public static String getDirection(){
        return direction;
    }

}