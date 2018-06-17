package aaaaa;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartingClass extends JPanel implements Runnable, KeyListener, MouseListener {

        private boolean ctrl_press;
        ArrayList projectiles;
        
        static StartingClass starter = new StartingClass();
        
	private static Robot robot;
	private BufferedImage  currentSprite, c0,c1, c2, c3,c4,c5,c6,c7,c8,c9, c10,c11,
                        s0,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,crouch_r0,crouch_r1,crouch_r2,crouch_r3,
                        crouch_l0,crouch_l1,crouch_l2,crouch_l3,menu,bulletr,bulletl,
			characterJumped_r, characterJumped_l, background1,background2, 
                        el,e2l,er,e2r,play,exit,creditsButton,credits,backButton,credits1,introback,
                        introfront,guideback,guidefront,guideButton,introButton,logo,teamlogo,start,
                        deathimg,menubutton,playagain;
	private static Background bg1, bg2,bg3,bg4;
	public Animation anim_r,anim_l,anim,anim_still,anim_still_r,anim_still_l, 
                crouchdown_r,crouchdown_r1,crouchdown_l;
        public static Animation hanim_l,hanim_r;
        
        public static BufferedImage tiledirt,grasstop, tilestone,tiletree,tilerock;
        private static ArrayList<Tile> tilearray = new ArrayList<Tile>();
        
        static String State = "start";
        Menu MENU;
        credits CREDITS;
        Intro INTRO;
        Guide GUIDE;
        Death DEATH;
        
        public static void restart(){
                robot.getProjectiles().clear();
                tilearray.clear();
                Enemy.enemies.clear();
                bg1 = new Background(0, 0);
		bg2 = new Background(1920, 0);
                bg3 = new Background(-1920,0);
                bg4 = new Background(-1920*2,0);
                robot = new Robot();
                try {
                    starter.loadMap("data/map1.txt");
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
        }
        
	
	public void init() throws Exception{
                
		setFocusable(true);
		addKeyListener(this);
                addMouseListener(this);
                
		// Image Setups

                    characterJumped_r = ImageIO.read(new File("data/jumpedr.png"));
                    characterJumped_l = ImageIO.read(new File("data/jumpedl.png"));

                    background1 = ImageIO.read(new File("data/bg1.png"));
                    background2 = ImageIO.read(new File("data/bg2.png"));


                    tiledirt = ImageIO.read(new File("data/tiledirt.png"));
                    grasstop = ImageIO.read(new File("data/grasstop.png"));
                    tilestone = ImageIO.read(new File("data/tilestone.png"));
                    tiletree = ImageIO.read(new File("data/tiletree.png"));
                    tilerock = ImageIO.read(new File("data/tilerock.png"));;

                    bulletr = ImageIO.read(new File("data/bulletr.png"));
                    bulletl = ImageIO.read(new File("data/bulletl.png"));
                
                    c0= ImageIO.read(new File("data/walk/walk-r (1).png"));
                    c1 = ImageIO.read(new File("data/walk/walk-r (2).png"));
                    c2 = ImageIO.read(new File("data/walk/walk-r (3).png"));
                    c3 = ImageIO.read(new File("data/walk/walk-r (4).png"));
                    c4 = ImageIO.read(new File("data/walk/walk-r (5).png"));
                    c5 = ImageIO.read(new File("data/walk/walk-r (6).png"));
                    c6 = ImageIO.read(new File("data/walk/walk-r (7).png"));
                    c7 = ImageIO.read(new File("data/walk/walk-r (8).png"));
                    c8 = ImageIO.read(new File("data/walk/walk-r (9).png"));
                    c9 = ImageIO.read(new File("data/walk/walk-r (10).png"));
                    c10 = ImageIO.read(new File("data/walk/walk-r (11).png"));
                    c11 = ImageIO.read(new File("data/walk/walk-r (12).png"));
                    
                    s0 = ImageIO.read(new File("data/walk/0.png"));
                    s1 = ImageIO.read(new File("data/walk/1.png"));
                    s2 = ImageIO.read(new File("data/walk/2.png"));
                    s3 = ImageIO.read(new File("data/walk/3.png"));
                    s4 = ImageIO.read(new File("data/walk/4.png"));
                    s5 = ImageIO.read(new File("data/walk/5.png"));
                    s6 = ImageIO.read(new File("data/walk/6.png"));
                    s7 = ImageIO.read(new File("data/walk/7.png"));
                    s8 = ImageIO.read(new File("data/walk/8.png"));
                    s9 = ImageIO.read(new File("data/walk/9.png"));
                    s10 = ImageIO.read(new File("data/walk/10.png"));
                    s11 = ImageIO.read(new File("data/walk/11.png"));
                    
                    crouch_r0 = ImageIO.read(new File("data/crouch/r0.png"));
                    crouch_r1 = ImageIO.read(new File("data/crouch/r1.png"));
                    crouch_r2 = ImageIO.read(new File("data/crouch/r2.png"));
                    crouch_r3 = ImageIO.read(new File("data/crouch/r3.png"));
                    
                    crouch_l0 = ImageIO.read(new File("data/crouch/1.png"));
                    crouch_l1 = ImageIO.read(new File("data/crouch/2.png"));
                    crouch_l2 = ImageIO.read(new File("data/crouch/3.png"));
                    crouch_l3 = ImageIO.read(new File("data/crouch/4.png"));
                    
                    
                    // Menu Images
                    
                    menu = ImageIO.read(new File("data/menu.png"));
                    logo= ImageIO.read(new File("data/logo.png"));
                    teamlogo = ImageIO.read(new File("data/teamlogo.png"));
                    play= ImageIO.read(new File("data/play.png"));
                    exit= ImageIO.read(new File("data/exit.png"));
                    creditsButton= ImageIO.read(new File("data/creditsButton.png"));
                    guideButton= ImageIO.read(new File("data/guideButton.png"));
                    introButton=ImageIO.read(new File("data/introButton.png"));
                    
                    start = ImageIO.read(new File("data/intro1.png"));
                    
                    deathimg = ImageIO.read(new File("data/deathimg.png"));
                    menubutton = ImageIO.read(new File("data/menuButton.png"));
                    playagain = ImageIO.read(new File("data/playagainButton.png"));
                    
                    
                    //Credits Stuff
                    credits= ImageIO.read(new File("data/credits.png"));
                    credits1= ImageIO.read(new File("data/credits1.png"));
                    backButton= ImageIO.read(new File("data/backButton.png"));
                    
                    //Intro stuff
                    introback=ImageIO.read(new File("data/introback.png"));
                    introfront=ImageIO.read(new File("data/introfront.png"));
                    
                    //Guide stuff
                    guideback=ImageIO.read(new File("data/guideback.png"));
                    guidefront=ImageIO.read(new File("data/guidefront.png"));
                    
                    el = ImageIO.read(new File("data/heliboy.png"));
                    e2l =ImageIO.read(new File("data/heliboy2.png"));
                    
                    er = ImageIO.read(new File("data/heliboyl.png"));
                    e2r =ImageIO.read(new File("data/heliboy2l.png"));
                    
                hanim_l = new Animation(false);
		hanim_l.addFrame(el, 500);
		hanim_l.addFrame(e2l, 500);
                
                hanim_r = new Animation(false);
		hanim_r.addFrame(er, 500);
		hanim_r.addFrame(e2r, 500);
                    
                crouchdown_r = new Animation(true);    
                crouchdown_r.addFrame(crouch_r0, 20);
                crouchdown_r.addFrame(crouch_r1, 20);
                crouchdown_r.addFrame(crouch_r2, 20);
                crouchdown_r.addFrame(crouch_r3, 20);
                
                crouchdown_l = new Animation(true);    
                crouchdown_l.addFrame(crouch_l0, 20);
                crouchdown_l.addFrame(crouch_l1, 20);
                crouchdown_l.addFrame(crouch_l2, 20);
                crouchdown_l.addFrame(crouch_l3, 20);
                    
                anim_r = new Animation(false);
		anim_r.addFrame(c0, 50);
		anim_r.addFrame(c1, 50);
		anim_r.addFrame(c2, 50);
		anim_r.addFrame(c3, 50);
                anim_r.addFrame(c4, 50);
                anim_r.addFrame(c5, 50);
                anim_r.addFrame(c6, 50);
                anim_r.addFrame(c7, 50);
                anim_r.addFrame(c8, 50);
                anim_r.addFrame(c9, 50);
                anim_r.addFrame(c10, 50);
                anim_r.addFrame(c11, 50);
	
                
                anim_l = new Animation(false);
		anim_l.addFrame(s0, 50);
		anim_l.addFrame(s1, 50);
		anim_l.addFrame(s2, 50);
		anim_l.addFrame(s3, 50);
                anim_l.addFrame(s4, 50);
                anim_l.addFrame(s5, 50);
                anim_l.addFrame(s6, 50);
                anim_l.addFrame(s7, 50);
                anim_l.addFrame(s8, 50);
                anim_l.addFrame(s9, 50);
                anim_l.addFrame(s10, 50);
                anim_l.addFrame(s11, 50);
                
                anim = anim_r;
                
		currentSprite = c0;
	}

	
	public void start() {
		bg1 = new Background(0, 0);
		bg2 = new Background(1920, 0);
                bg3 = new Background(-1920,0);
                bg4 = new Background(-1920*2,0);
                robot = new Robot();
                MENU = new Menu();
                CREDITS= new credits();
                INTRO= new Intro();
                GUIDE= new Guide();
                DEATH = new Death();
                
                // Initialize Tiles
                try {
                    loadMap("data/map1.txt");
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
                
		Thread thread = new Thread(this);
		thread.start();
	}


	@Override
	public void run() {
		while (true) {
                    
                    switch (State){
                        
                        case "start":
                            break;
                        
                        case "menu":
                            MENU.update();
                            break;
                            
                        case "dead":
                            DEATH.update();
                            break;
                            
                        case "credits":
                            CREDITS.update();
                            break;
                            
                        case "intro":
                            INTRO.update();
                            break;
                            
                        case "guide":
                            GUIDE.update();
                            break;
                            
                        case "game":
                            gameUpdate();
                            break;
                        
                    }
			repaint();
                        
			try {
				Thread.sleep(17);
			} 
                        catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        }
        
        public void gameUpdate(){
                        
                        robot.update();
                        bg1.update();
			bg2.update();
                        bg3.update();
                        bg4.update();
                        Enemy.update();
                        updateTiles();
                        
                        hanim_l.update(50);
                        hanim_r.update(50);
                        

			ArrayList projectiles = robot.getProjectiles();
			for (int i = 0; i < projectiles.size(); i++) {
				Projectile p = (Projectile) projectiles.get(i);
				if (p.isVisible() == true) {
					p.update();
				} else {
					projectiles.remove(i);
				}
			}
                        
                        for (int i = 0; i < Enemy.enemies.size(); i++){
                            if (Enemy.enemies.get(i).getIsDead())
                                Enemy.enemies.remove(i);
                        }
                
                        if (robot.isJumped() && robot.getDirection() == "right") {
				currentSprite = characterJumped_r;
			}
                        else if (robot.isJumped() && robot.getDirection() == "left") {
				currentSprite = characterJumped_l;
			} 
                        else if ((robot.getDirection() == "right") && (robot.getSpeedX() == 0)&& robot.isDucked()==false){
                            currentSprite = c0;
                        }
                        else if ((robot.getDirection() == "left") && (robot.getSpeedX() == 0) && robot.isDucked()==false){
                            currentSprite = s0;
                        }
                        
                        else {
                                if (robot.getSpeedX()<0){
                                    anim = anim_l;
                                }
                                else if (robot.getSpeedX()>0){
                                    anim = anim_r;
                                }
                                else if (robot.isDucked() && robot.getDirection() == "right"){
                                    anim = crouchdown_r;
                                }
                                else if (robot.isDucked() && robot.getDirection() == "left"){
                                    anim = crouchdown_l;
                                }
				currentSprite = anim.getImage();
                                anim.update(10);
			}
                        
                        
                        if (robot.getCenterY()>1400){
                            State = "dead";
                        }
        }


        @Override
	public void paint(Graphics g) {
            
            switch (State) {
                
                case "start":
                    g.drawImage(start, 0, 0, this);
                    break;
                
                case "menu":
                    
                    try{
                    g.drawImage(menu, (int) MENU.drawX,(int)MENU.drawY,this);
                    g.drawImage(logo, 510, 32, this);
                    g.drawImage(play,60,250,this);
                    g.drawImage(introButton, 60, 300, this);
                    g.drawImage(guideButton,60,350, this);
                    g.drawImage(creditsButton,60,400,this);
                    g.drawImage(exit,60,450,this);
                    g.drawImage(teamlogo,60,680,this);
                    }
                    catch(Exception e){ }
                    break;
                    
                case "dead":
                    g.drawImage(deathimg, (int) DEATH.drawX,(int)DEATH.drawY,this);
                    g.drawImage(menubutton,60,350, this);
                    g.drawImage(playagain,60,400, this);
                    break;
                    
                case "credits":
                    
                    g.drawImage(credits, (int)CREDITS.drawX, (int)CREDITS.drawY, this);
                    g.drawImage(credits1,183,84, this);
                    g.drawImage(backButton,20,700, this);
                    break;
                    
                case "intro":
                    g.drawImage(introback,(int)INTRO.drawX, (int)INTRO.drawY, this);
                    g.drawImage(introfront,52, 70, this);
                    g.drawImage(backButton,20,700, this);
                    break;
                    
                case "guide":
                    g.drawImage(guideback,(int)GUIDE.drawX,(int)GUIDE.drawY, this);
                    g.drawImage(guidefront,478,170, this);
                    g.drawImage(backButton, 20,700, this);
                    break;
                    
                case "game":
                    
                    g.drawImage(background1, bg1.getBgX(), bg1.getBgY(), this);
                    g.drawImage(background2, bg2.getBgX(), bg2.getBgY(), this);
                    g.drawImage(background2, bg3.getBgX(), bg3.getBgY(), this);
                    g.drawImage(background1, bg4.getBgX(), bg4.getBgY(), this);
                    paintTiles(g);
                    paintProjectiles(g);
                    paintEnemies(g);
                    g.drawImage(currentSprite, robot.getCenterX() - 61,robot.getCenterY() - 63, this);
                       
                    break;
                    
            }
	}
        
        
        private void updateTiles() {

		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			t.update();
		}
	}
        
        private void paintEnemies(Graphics g){
            for (Enemy i: Enemy.enemies){
                        if (i.getCenterX()>-50 && i.getCenterX()<1366){
                            if (i.direction == "right")
                                g.drawImage(hanim_r.getImage(), i.getCenterX() - 48, i.getCenterY() - 48, this);
                            else if (i.direction == "left")
                                g.drawImage(hanim_l.getImage(), i.getCenterX() - 48, i.getCenterY() - 48, this);
                        }
                    }
        }
        
        private void paintProjectiles(Graphics g){
                    projectiles = robot.getProjectiles();
                    for (int i = 0; i < projectiles.size(); i++) {
                        Projectile p = (Projectile) projectiles.get(i);
                        
                        if (robot.getDirection() == "right")
                            g.drawImage(bulletr, p.getX(), p.getY(), this);
                        else if (robot.getDirection() == "left")
                            g.drawImage(bulletl, p.getX(), p.getY(), this);
                    }   
        }
        
	private void paintTiles(Graphics g) {
		for (int i = 0; i < tilearray.size(); i++) {
			Tile t = (Tile) tilearray.get(i);
			g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY(), this);
		}
	}
        private void loadMap(String filename) throws IOException {
            ArrayList lines = new ArrayList();
            int width = 0;
            int height = 0;

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = reader.readLine();
                // no more lines to read
                if (line == null) {
                    reader.close();
                    break;
                }

                if (!line.startsWith("!")) {
                    lines.add(line);
                    width = Math.max(width, line.length());

                }
            }
            height = lines.size();

            for (int j = 0; j < 20; j++) {
                String line = (String) lines.get(j);
                for (int i = 0; i < width; i++) {

                    if (i < line.length()) {
                        char ch = line.charAt(i);
                        if (ch == '*'){
                            Enemy.enemies.add(new Enemy(i*40, j*40-80));
                        }
                        else{
                            Tile t = new Tile(i, j, Character.getNumericValue(ch));
                            tilearray.add(t);
                        }
                    }

                }
            }

    }
        

	@Override
	public void keyPressed(KeyEvent e) {
            
                if (State == "start"){
                    if (e.getKeyCode() == KeyEvent.VK_SPACE)
                        State = "menu";
                }
                
                
                if (State=="credits"||State == "intro"||State=="guide"){
                    switch(e.getKeyCode()){
                        case KeyEvent.VK_ESCAPE:
                            State="menu";
                            break;
                    }
                }
                if (State=="game"){
                    
                    switch (e.getKeyCode()) {

                        case KeyEvent.VK_ESCAPE:
                                State="menu";
                                break;

                        case KeyEvent.VK_UP:
                                System.out.println("Move up");
                                break;

                        case KeyEvent.VK_DOWN:
                                robot.setDucked( true);
                                break;

                        case KeyEvent.VK_LEFT:
                                robot.moveLeft();
                                break;

                        case KeyEvent.VK_RIGHT:
                                robot.moveRight();
                                break;

                        case KeyEvent.VK_SPACE:
                                robot.jump();
                                break;
                        case KeyEvent.VK_ENTER:
                            State="game";
                            break;

                        case KeyEvent.VK_CONTROL:
                            ctrl_press = true;
                    }
                }
        }

	@Override
	public void keyReleased(KeyEvent e) {
                
            
            switch (e.getKeyCode()) {
                
		case KeyEvent.VK_UP:
			break;

		case KeyEvent.VK_DOWN:
                    if (State == "game"){
                        crouchdown_r.currentFrame = 0;
                        crouchdown_l.currentFrame = 0;
			robot.setDucked(false);
                    }
			break;

		case KeyEvent.VK_LEFT:
                        if (State == "game")
                        	robot.stopLeft();
			break;

		case KeyEvent.VK_RIGHT:
                        if (State == "game")
        			robot.stopRight();
			break;

		case KeyEvent.VK_SPACE:
                        if (State == "game"){
                            robot.setMovingLeft(false);
                            robot.setMovingRight(false);
                        }
			break;
                
                case KeyEvent.VK_CONTROL:
                    if (State == "game"){
                        if (ctrl_press){
                            robot.shoot();
                        }
                    }
                    break;

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
            
	}


    @Override
    public void mouseClicked(MouseEvent me) {
      
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
        switch (State){
            case "credits":
                CREDITS.mousePress(me);
                break;
            case "dead":
                DEATH.mousePress(me);
                break;
            case "menu":
                MENU.mousePress(me);
                break;
            case "intro":
                INTRO.mousePress(me);
                break;
            case "guide":
                GUIDE.mousePress(me);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        if(State=="menu")
            MENU.mousePress = false;
        if (State=="credits")
            CREDITS.mousePress=false;
        if(State=="intro")
            MENU.mousePress = false;
        if (State=="guide")
            CREDITS.mousePress=false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
        // Getters
        
        public static Background getBg1() {
		return bg1;
	}

	public static Background getBg2() {
		return bg2;
	}
        
        public static Background getBg3(){
            return bg3;
        }
        
        public static Background getBg4(){
            return bg4;
        }
        
        public static Robot getRobot(){
		return robot;
	}
        public static ArrayList getTileArray(){
            return tilearray;
        }

      
    
        
    // Main Function
    
    public static void main(String[] args){
        
                JFrame frame = new JFrame("LOST");
                frame.setSize(1366, 768); 
		frame.setBackground(Color.black);
                frame.add(starter);
                frame.setUndecorated(true);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                try{
                    starter.init();
                    starter.start();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
    }
    
}