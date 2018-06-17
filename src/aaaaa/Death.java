package aaaaa;

import java.awt.event.MouseEvent;


public class Death extends DynamicBackground{
    
    public double orbitX = -110; /* x-coordinate in orbit's center */
    public double orbitY = -60; /* y-coordinate in orbit's center */
    
    @Override
    public void update(){
                        radian = orbitSpeed * t;
                        drawX = orbitX + orbitRadius * Math.cos(radian);
                        drawY = orbitY + orbitRadius * Math.sin(radian);
                        t+=1;
    }

    void mousePress(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        StartingClass.restart();
        
        if (mx>60 && mx<210 && my>350 && my<390){
            StartingClass.State = "menu";
        }
        else if(mx>60 && mx<210 && my>400 && my<440){
            StartingClass.State="game";
        }
    }
}
