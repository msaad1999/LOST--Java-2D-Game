package aaaaa;

class DynamicBackground {
    
    public double orbitX; // x-coordinate in orbit's center */
    public double orbitY; // y-coordinate in orbit's center */
    public double orbitRadius = 20;
    public double orbitSpeed = 0.03;
    public double sphereRadius = 5;
    public double t;
    public double drawX;
    public double drawY;
    public double radian;
    boolean mousePress;
    
    public void update(){
                        radian = orbitSpeed * t;
                        drawX = orbitX + orbitRadius * Math.cos(radian);
                        drawY = orbitY + orbitRadius * Math.sin(radian);
                        t+=1;
    }
    
}
