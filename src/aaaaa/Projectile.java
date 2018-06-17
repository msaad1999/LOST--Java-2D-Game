package aaaaa;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Projectile {

	private int x, y, speedX;
	private boolean visible;
        private Rectangle r;
        
	
	public Projectile(int startX, int startY, boolean right){
		x = startX;
		y = startY;
                if (right)
                    speedX =30;
                else
                    speedX = -30;
		visible = true;
                r = new Rectangle(0, 0, 0, 0);
	}
	
	public void update(){
		x += speedX;
                r.setBounds(x, y, 10, 5);
		if (x > 1366 || x<0){
			visible = false;
                        r = null;
		}
                else
                    checkCollision();
                        
		
	}
        private void checkCollision() {
            ArrayList tiles = StartingClass.getTileArray();
			for (int i = 0; i < tiles.size(); i++) {
				Tile p = (Tile) tiles.get(i);
                                if (r != null){
                                    if (r.intersects(p.getRectangle()) && (p.getType()==2||p.getType()==3||p.getType()==6)){
                                        if (Robot.getDirection() == "right")
                                            x = p.getTileX()-35;    
                                        else if (Robot.getDirection() == "left")
                                            x = p.getTileX()+50;
                                        visible = false;
                                    }
                                } 
                        }
            for (Enemy i: Enemy.enemies){
                
                if(r.intersects(i.r)){
                            visible = false;
                            if (i.health > 0) {
                                    i.health -= 1;
                            }
                            if (i.health == 0) {
                                i.setIsDead(true);
                            }

                    }
            }
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
	
}
