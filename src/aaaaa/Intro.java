package aaaaa;

import java.awt.event.MouseEvent;

public class Intro extends DynamicBackground{
    
    public double orbitX = -50; /* x-coordinate in orbit's center */
    public double orbitY = -50; /* y-coordinate in orbit's center */
    
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
        
        if (mx>60 && mx<210 && my>300 && my<340){
            
            StartingClass.State = "intro";
            
        }
            else if(mx>20 && mx<170 && my>700 && my<740){
            
            StartingClass.State="menu";
        }
    }   
}
