import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.media.AudioClip;
import java.net.URL;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class SpaceInvadersGame extends Application implements EventHandler<InputEvent>{
	GraphicsContext gc;
	Image ship1;
	Image ship1Extra;
	Image ship2;
	Image ship2Extra;
	Image ship3;
	Image ship3Extra;
	Image ship4;
	Image ship4Extra;
	Image ship5;
	Image ship5Extra;
	Image ship6;
	Image ship6Extra;
	Image ship7;
	Image ship7Extra;
	Image ship8;
	Image ship8Extra;
	Image ship9;
	Image ship9Extra;
	Image ship10;
	Image ship10Extra;
	Image ship11;
	Image ship11Extra;
	Image ship12;
	Image ship12Extra;
	Image beam1;
	Image beam2;
	Image beam3;
	Image beam4;
	Image beam5;
	Image beam6;
	Image beam7;
	Image beam8;
	Image beam9;
	Image beam10;
	Image beam11;
	Image beam12;
	Image beam13;
	Image beam14;
	Image icon;
	Image missile;
	Image homeBase;
	Image healthBarBase1;
	Image healthBarBase2;
	Image gameOverBackground;
	int BcollisionX;
	int BcollisionY;
	Canvas canvas;
	Rectangle2D rect1;
	Rectangle2D rect2;
	Rectangle2D rect3;
	Rectangle2D rect4;
	Rectangle2D rect5;
	Rectangle2D rect8;
	Rectangle2D rect9;
	Rectangle2D rect10;
	Image background;
	AnimateObjects animate;
	AudioClip clip;
	SpaceShip player;
	ThePosition position;
	int playerX;
	int playerY;
	int playerXSpeed;
	Dimension screensize;
	int screenX;
	int screenY;
	int playerBulletY;
	int playerBulletSpeed;
	int bullets;
	int shotPositionX;
	int charge;
	int bulletSizeX;
	int bulletSizeY;
	Image boss;
	Image enemy1;
	Image enemy2;
	Image enemy3;
	Bullet playershot;
	Image healthBar;
	Image sheildBar;
	double HP;
	double sheild;
	int rebuildTime;
	double ATK;
	int cannons;
	URL resource;
	URL resource2;
	AudioClip clip2;
	int shots;
	boolean EnemyBcollision;
	boolean Bcollision;
	boolean enemyDead;
	Enemy ENEMY;
	int enemies;
	int wave;
	int randomd;
	boolean allSpawned;
	int enemiesRemoved;
	boolean onceDone;
	boolean HBcollision;
	int EnemyATK;
	int score;
	boolean Pcollision;
	int spacing;
	int secondsPassed;
	Timer timer;
	TimerTask task;
	int rebuilds;
	ArrayList<Integer> Epositiony=new ArrayList<>();
	ArrayList<Integer> Epositionx=new ArrayList<>();
	ArrayList<Bullet> playerBullets=new ArrayList<>();
	ArrayList<Enemy> Enemies=new ArrayList<>();
	ArrayList<Integer> EnemyHealth=new ArrayList<>();
	ArrayList<Integer> EnemiesInWaves=new ArrayList<>();
	ArrayList<Rectangle2D> EnemyRects=new ArrayList<>();
	ArrayList<Integer> EnemySpeeds=new ArrayList<>();
	ArrayList<Integer> EnemyBullets=new ArrayList<>();
	ArrayList<Double> Satellites=new ArrayList<>();
	ArrayList<Integer> EBX=new ArrayList<>();
	ArrayList<Integer> EBY=new ArrayList<>();
	ArrayList<Integer> SX=new ArrayList<>();
	ArrayList<Integer> SY=new ArrayList<>();
	ArrayList<Rectangle2D> SatelliteRects=new ArrayList<>();
	public static void main(String[]args){
		launch();
	}
	public void start(Stage stage){
		stage.setTitle("Sentine1");
		Group root = new Group();
		screensize=Toolkit.getDefaultToolkit().getScreenSize();
		screenX=screensize.width;
		screenY=screensize.height-80;
		canvas = new Canvas(screenX,screenY);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		gc = canvas.getGraphicsContext2D();
		ship1 = new Image("ship1.png");
		ship1Extra = new Image("ship1Extra.png");
		ship2 = new Image("ship2.png");
		ship2Extra = new Image("ship2Extra.png");
		ship3 = new Image("ship3.png");
		ship3Extra = new Image("ship3Extra.png");
		ship4 = new Image("ship4.png");
		ship4Extra = new Image("ship4Extra.png");
		ship5 = new Image("ship5.png");
		ship5Extra = new Image("ship5Extra.png");
		ship6 = new Image("ship6.png");
		ship6Extra = new Image("ship6Extra.png");
		ship7 = new Image("ship7.png");
		ship7Extra = new Image("ship7Extra.png");
		ship8 = new Image("ship8.png");
		ship8Extra = new Image("ship8Extra.png");
		ship9 = new Image("ship9.png");
		ship10Extra = new Image("ship10Extra.png");
		ship10 = new Image("ship10.png");
		ship2Extra = new Image("ship2Extra.png");
		ship11 = new Image("ship11.png");
		ship11Extra = new Image("ship11Extra.png");
		ship12 = new Image("ship12.png");
		ship12Extra = new Image("ship12Extra.png");
		background = new Image("spaceBackground.gif");
		homeBase = new Image("spaceStation.png");
		beam1 = new Image("beam1.png");
		beam2 = new Image("beam2.png");
		beam3 = new Image("beam3.png");
		beam4 = new Image("beam4.png");
		beam5 = new Image("beam5.png");
		beam6 = new Image("beam6.png");
		beam7 = new Image("beam7.png");
		beam8 = new Image("beam8.png");
		beam9 = new Image("beam9.png");
		beam10 = new Image("beam10.png");
		beam11 = new Image("beam11.png");
		beam12 = new Image("beam12.png");
		beam13 = new Image("beam13.png");
		beam14 = new Image("beam14.png");
		missile = new Image("missile.png");
		icon = new Image("icon.png");
		boss = new Image("boss.gif");
		enemy1 = new Image("enemy1.png");
		enemy2 = new Image("enemy2.png");
		enemy3 = new Image("enemy3.png");
		healthBar = new Image("healthBar.png");
		sheildBar = new Image("sheild.jpg");
		healthBarBase1 = new Image("BaseHealthBar1.png");
		healthBarBase2 = new Image("BaseHealthBar2.png");
		healthBarBase2 = new Image("BaseHealthBar2.png");
		player = new SpaceShip(1);
		position = new ThePosition(playerX,playerY);
		playerXSpeed=0;
		playerBulletY=0;
		playerBulletSpeed=-15;
		playerX=(int)canvas.getWidth()/2-100;
		playerY=(int)canvas.getHeight()-380;
		bullets=0;
		shotPositionX=0;
		bulletSizeX=0;
		bulletSizeY=0;
		charge=0;
		shots=0;
		enemies=0;
		score=0;
		rebuilds=1;
		enemiesRemoved=0;
		onceDone=false;
		ATK=(double)player.getATK();
		HP=(double)player.getHP();
		sheild=(double)player.getSheild();
		cannons=player.getCannons();
		wave=1;
		spacing=0;
		secondsPassed=0;
		timer= new Timer();
		EnemiesInWaves.add(2*wave);
		EnemiesInWaves.add(0);
		EnemiesInWaves.add(0);
		Epositionx.add((int)(Math.random()*1300)+100);
		Epositiony.add(0);
		ENEMY = new Enemy(1,Epositionx.get(enemies),Epositiony.get(enemies));
		Enemies.add(ENEMY);
		EnemyHealth.add(Enemies.get(enemies).getHP()*wave);
		EnemyRects.add(rect3 = new Rectangle2D(Epositionx.get(enemies),Epositiony.get(enemies), 100,100));
		EnemySpeeds.add((int)(Math.random()*5)+wave);
		enemies++;
		Epositionx.add((int)(Math.random()*1300)+100);
		Epositiony.add(0);
		Enemies.add(ENEMY);
		EnemyHealth.add(Enemies.get(enemies).getHP()*wave);
		EnemyRects.add(rect3 = new Rectangle2D(Epositionx.get(enemies),Epositiony.get(enemies), 100,100));
		EnemySpeeds.add((int)(Math.random()*1)+wave);
		enemies++;
		EnemySpeeds.add((int)(Math.random()*1)+wave);
		EnemyATK=ENEMY.getATK();
		Pcollision = false;
		HBcollision = false;
		Satellites.add((double)1500);
		SX.add(100);
		SY.add((int)canvas.getHeight()-230);
		SatelliteRects.add(new Rectangle2D(SX.get(0), SY.get(0),230,230));
		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		scene.addEventHandler(KeyEvent.KEY_RELEASED,this);
		//scene.addEventHandler(MouseEvent.MOUSE_MOVED, this);
		resource = getClass().getResource("laserSound.wav");
		clip = new AudioClip(resource.toString());
		resource2 = getClass().getResource("Infinite.mp3");
		clip2 = new AudioClip(resource2.toString());
		//clip2.play();
		animate = new AnimateObjects();
		animate.start();
		stage.show();
	}
	public void handle(final InputEvent event){
		if (event instanceof KeyEvent){
			if (((KeyEvent)event).getCode() == KeyCode.LEFT){
				if(event.getEventType().toString().equals("KEY_PRESSED"))
					playerXSpeed=-10;
				else if(event.getEventType().toString().equals("KEY_RELEASED"))
					playerXSpeed=-1;
			}
			if (((KeyEvent)event).getCode() == KeyCode.RIGHT){
				if(event.getEventType().toString().equals("KEY_PRESSED"))
					playerXSpeed=10;
				else if(event.getEventType().toString().equals("KEY_RELEASED"))
					playerXSpeed=1;
			}
			if (((KeyEvent)event).getCode() == KeyCode.SPACE){
				clip.play();
				bullets+=player.getCannons();
				playerBullets.add(new Bullet(8,playerX-5,playerY));
				playerBullets.add(new Bullet(8,playerX+20,playerY));
				playerBullets.add(new Bullet(8,playerX+105,playerY));
				playerBullets.add(new Bullet(8,playerX+125,playerY));
				playerBullets.add(new Bullet(8,playerX+60,playerY));
				playerBulletSpeed=(int)(playerBullets.get(bullets-1).getSpeed());
			}
			else{
				clip.stop();
			}
			/*
			if (((KeyEvent)event).getCode() == KeyCode.DOWN){
				System.out.println(charge);
				charge++;
				if (charge>30)
					charge=30;
			}
			if (((KeyEvent)event).getCode() == KeyCode.UP){
				bullets++;
				playerBullets.add(new Bullet(10,playerX+100-charge*2,playerY));
				playerBulletSpeed=(int)(playerBullets.get(bullets-1).getSpeed());
				bulletSizeX=charge*5;
				bulletSizeY=charge*10;
				charge=0;
			}
			*/
			}
		//else if(event instanceof MouseEvent){
		//}
		}
		public class AnimateObjects extends AnimationTimer{
			public void handle(long now) {
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				randomd=(int)(Math.random()*100);
				task= new TimerTask(){
					public void run(){
						secondsPassed++;
					}
				};
				playerX+=playerXSpeed;
				playerBulletY+=playerBulletSpeed;
				gc.drawImage( background, 0, 0, canvas.getWidth(),canvas.getHeight() );
				//ship
				if(sheild<=0)
					sheild+=0;
				else
					if(canvas.getHeight()-canvas.getHeight()*((double)sheild/(double)player.getSheild())>0)
						sheild++;
				//gc.fillRect(playerX,playerY,150,150);
				//UI HEALTH+SHEILD
				gc.drawImage(healthBar,1,canvas.getHeight()-canvas.getHeight()*((double)HP/(double)player.getHP()),150,canvas.getHeight());
				gc.drawImage(sheildBar,canvas.getWidth()-71,canvas.getHeight()-canvas.getHeight()*((double)sheild/(double)player.getSheild()),150,canvas.getHeight());
				//enemies
				//int[] EnemiesInWave={1*wave,1*wave,wave};
				if(enemies==0){
					wave++;
					EnemiesInWaves.set(0,wave*2);
					enemies=wave*2;
					if(ATK>1)
						ATK-=0.5;
					for(int i=0;i<enemies;i++){
						Epositionx.add((int)(Math.random()*1300)+100);
						Epositiony.add(0);
						Enemies.add(ENEMY);
						EnemyHealth.add((Enemies.get(i).getHP()*wave));
						EnemyRects.add(rect3 = new Rectangle2D(Epositionx.get(i),Epositiony.get(i), 100,100));
						EnemySpeeds.add((int)(Math.random()*1)+(wave/3)+1);
					}
				}
				//Enemy Bullets + Collisions
				for(int b=0;b<enemies;b++){
					EnemyBullets.add(1);
					EBY.add(Epositiony.get(b));
					EBX.add(Epositionx.get(b));
					for(int a=0;a<Satellites.size();a++){
						for(int i=0;i<EnemyBullets.size(); i++){
							gc.drawImage( beam4, EBX.get(i)+40, EBY.get(i), 20,100);
							rect8 = new Rectangle2D( EBX.get(i)+40, EBY.get(i), 20,100 );
							int bulletSpeed = 8;
							if(EnemyHealth.get(b)<=0){
								EBY.remove(i);
								EBX.remove(i);
								EnemyBullets.remove(i);
							}
							else
								EBY.set(i,EBY.get(i)+bulletSpeed);

							if(rect8.intersects(SatelliteRects.get(a))){
								HBcollision=true;
								EnemyBullets.remove(i);
								EBX.remove(i);
								EBY.remove(i);
								}
							if(rect8.intersects(rect1)){
								Pcollision=true;
								EnemyBullets.remove(i);
								EBX.remove(i);
								EBY.remove(i);
								}
							if(Pcollision==true){
								if(sheild<=0)
									HP=HP-EnemyATK;
								else
									sheild=sheild-EnemyATK;
								gc.setFill( Color.WHITE);
								gc.setStroke( Color.BLACK );
								gc.setLineWidth(3);
								Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 50 );
								gc.setFont( font );
								gc.fillText( ""+EnemyATK, playerX+70, playerY-20 );
								gc.strokeText( ""+EnemyATK, playerX+70, playerY-20 );
								Pcollision=false;
								gc.setFill( Color.BLACK);
							}
							if(HBcollision==true){
								Satellites.set(a,Satellites.get(a)-(int)(EnemyATK));
								if(Satellites.get(a)<-1)
									Satellites.set(a,-1.0);
								gc.setFill( Color.WHITE);
								gc.setStroke( Color.BLACK );
								gc.setLineWidth(3);
								Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 50 );
								gc.setFont( font );
								gc.fillText( ""+EnemyATK, SX.get(a)+60, SY.get(a) );
								gc.strokeText( ""+EnemyATK, SX.get(a)+60, SY.get(a) );
								HBcollision=false;
								gc.setFill( Color.BLACK);
							}
						}
					}
				//enemies
				for(int j=0;j<EnemiesInWaves.get(0);j++){
					//gc.fillRect(Epositionx.get(j),Epositiony.get(j), 100, 100);
					gc.drawImage( enemy1, Epositionx.get(j),Epositiony.get(j), 100, 100);
					if(Epositiony.get(j)<200)
						Epositiony.set(j,Epositiony.get(j)+EnemySpeeds.get(j));
					if(EnemyHealth.get(j)<=0){
						shots=0;
						score+=(wave*100);
						enemies--;
						enemiesRemoved++;
						EnemiesInWaves.set(0,enemies);
						Epositionx.remove(j);
						Epositiony.remove(j);
						Enemies.remove(j);
						EnemyHealth.remove(j);
						EnemyRects.remove(j);
						EnemySpeeds.remove(j);
					}
				}
				//bullets
				for(int a=0;a<EnemyRects.size();a++){
					for(int i=0;i<bullets; i++){
						//gc.fillRect(playerBullets.get(i).getXPOS(), playerBullets.get(i).getYPOS(), 30,100);
						gc.drawImage( beam1, playerBullets.get(i).getXPOS(), playerBullets.get(i).getYPOS(), 30,100);
						rect10 = new Rectangle2D( playerBullets.get(i).getXPOS(), playerBullets.get(i).getYPOS(), 30,100 );
						if(playerBullets.get(i).getYPOS()<-50){
							playerBullets.remove(i);
							bullets--;
						}
						if(EnemyRects.get(a).intersects(rect10)){
							Bcollision=true;
							BcollisionX=Epositionx.get(a);
							BcollisionY=Epositiony.get(a);
							if (bullets>0)
								playerBullets.remove(i);
							bullets--;
						}
					}
					if(Bcollision==true){
						shots++;
						EnemyHealth.set(a,Enemies.get(a).getHP()-(int)(ATK*shots));
						gc.setFill( Color.WHITE);
						gc.setStroke( Color.BLACK );
						gc.setLineWidth(3);
						Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 50 );
						gc.setFont( font );
						gc.fillText( ""+(double)ATK, BcollisionX-40, Epositiony.get(a) );
						gc.strokeText( ""+(double)ATK, BcollisionX-40, Epositiony.get(a) );
						Bcollision=false;
						gc.setFill( Color.BLACK);
						}
					}
				}
				/*
				for(int j=EnemiesInWaves.get(0);j<EnemiesInWaves.get(1)+EnemiesInWaves.get(0);j++){
					if(enemies+enemiesRemoved<EnemiesInWaves.get(0)+EnemiesInWaves.get(1)+EnemiesInWaves.get(2)){
						ENEMY = new Enemy(2,(int)canvas.getWidth()/2-150,50);
						Enemies.add(ENEMY);
						EnemyHealth.add(Enemies.get(j).getHP());
						enemies++;
					}
					if(EnemyHealth.get(j)<=0){
						enemies--;
						enemiesRemoved++;
					}
					if((enemies-(EnemiesInWaves.get(2)+EnemiesInWaves.get(0))+1)>0){
						rect4 = new Rectangle2D(canvas.getWidth()/2-150,50, 150, 150);
						gc.fillRect(canvas.getWidth()/2-150,50, 150, 150);
						gc.drawImage( enemy2, canvas.getWidth()/2-150,50, 150, 150);
						System.out.println(enemies);
					}
					else
						rect4 = new Rectangle2D(canvas.getWidth()/2-2000,50, 150,150);
					if(Bcollision==true){
						shots++;
						EnemyHealth.set(j,Enemies.get(j).getHP()-(ATK*shots));
						gc.setFill( Color.WHITE);
						gc.setStroke( Color.BLACK );
						gc.setLineWidth(3);
						Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 50 );
						gc.setFont( font );
						gc.fillText( ""+player.getATK(), BcollisionX-20, BcollisionY );
						gc.strokeText( ""+player.getATK(), BcollisionX-20, BcollisionY );
						Bcollision=false;
						gc.setFill( Color.BLACK);
					}
				}

				for(int j=0;j<EnemiesInWaves.get(2);j++){
					if(enemies+enemiesRemoved<EnemiesInWaves.get(0)+EnemiesInWaves.get(1)+EnemiesInWaves.get(2)){
						ENEMY = new Enemy(3,(int)canvas.getWidth()/2+250,50);
						Enemies.add(ENEMY);
						EnemyHealth.add(Enemies.get(j+EnemiesInWaves.get(0)+EnemiesInWaves.get(1)).getHP());
						enemies++;
					}
					if(EnemyHealth.get(j)<=0){
						enemies--;
						enemiesRemoved++;
					}
					if(enemies-(EnemiesInWaves.get(1)+EnemiesInWaves.get(0))>0){
						rect5 = new Rectangle2D(canvas.getWidth()/2+250,50, 230, 230);
						gc.fillRect(canvas.getWidth()/2+250,50, 230, 230);
						gc.drawImage( boss, canvas.getWidth()/2+250,50, 230, 230);
					}
					else
						rect5 = new Rectangle2D(canvas.getWidth()/2-2000,50, 230, 2302);
					if(Bcollision==true){
						shots++;
						EnemyHealth.set(j,Enemies.get(j).getHP()-(ATK*shots));
						gc.setFill( Color.WHITE);
						gc.setStroke( Color.BLACK );
						gc.setLineWidth(3);
						Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 50 );
						gc.setFont( font );
						gc.fillText( ""+player.getATK(), BcollisionX-20, BcollisionY );
						gc.strokeText( ""+player.getATK(), BcollisionX-20, BcollisionY );
						Bcollision=false;
						gc.setFill( Color.BLACK);
					}
				}
				*/
				//bases+ GG
				for(int i=0;i<Satellites.size();i++){
					gc.drawImage( homeBase, SX.get(i), SY.get(i),230,230);
					rect2 = new Rectangle2D(SX.get(i), SY.get(i),230,230);
					//gc.fillRect(SX.get(i), SY.get(i),230,230);
					gc.drawImage( healthBarBase2, SX.get(i)+10, SY.get(i)+200,200,50 );
					gc.drawImage( healthBarBase1, SX.get(i)+10, SY.get(i)+200,(int)((double)200*(Satellites.get(i)/1500.0)),50 );
					if(Satellites.get(i)<1500)
						Satellites.set(i,Satellites.get(i)+2);
					if(rebuilds==-1 || Satellites.get(i)<=0){
						gc.drawImage( gameOverBackground, 0,0,canvas.getWidth(),canvas.getHeight() );
						gc.setFill( Color.WHITE);
						gc.setStroke( Color.BLACK );
						gc.setLineWidth(3);
						Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 50 );
						gc.setFont( font );
						gc.fillText( "Game Over ", 750, 300 );
						gc.strokeText( "Game Over ", 750, 300 );
						gc.fillText( "Press M to go to main menu ", 500, 350 );
						gc.strokeText( "Press M to go to main menu ", 500, 350 );
						gc.fillText( "Press R to Restart ", 550, 400 );
						gc.strokeText( "Press R to Restart ", 550, 400 );
					}

				}
				if(wave%5==0 && Satellites.size()<5 && ((wave/5)==EnemyATK)){
					EnemyATK++;
					spacing+=300;
					Satellites.add((double)1500);
					SX.add(50+spacing);
					SY.add((int)canvas.getHeight()-230);
					SatelliteRects.add(new Rectangle2D(SX.get(Satellites.size()-1), (int)canvas.getHeight()-230,230,230));
				}
				gc.setFill( Color.WHITE);
				gc.setStroke( Color.BLACK );
				gc.setLineWidth(3);
				Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 50 );
				gc.setFont( font );
				gc.fillText( "Wave: "+wave, 100, 50 );
				gc.strokeText( "Wave: "+wave, 100, 50 );
				gc.fillText( "Score: "+score, 100, 100 );
				gc.strokeText( "Score: "+score, 100, 100 );
				gc.fillText( "Rebuilds Left: "+rebuilds, 100, 150 );
				gc.strokeText( "Rebuilds Left: "+rebuilds, 100, 150 );
				gc.setFill( Color.BLACK);
				//player
				if(HP>0){
					gc.drawImage( ship1, playerX, playerY,150,150 );
					gc.drawImage( ship1Extra, playerX+10, playerY+ship1.getHeight(),130,75);
					rect1 = new Rectangle2D( playerX,playerY,150,150 );
					gc.drawImage( ship1Extra, playerX+10, playerY+ship1.getHeight(),130,75);
				}
				else{
					gc.setFill( Color.WHITE);
					gc.setStroke( Color.BLACK );
					rect1 = new Rectangle2D( playerX-20000,playerY,150,150 );
					timer.scheduleAtFixedRate(task,0,200);
					gc.fillText( "Rebuilding", 700, 400 );
					gc.strokeText( "Rebuilding", 700, 400 );
					gc.setFill( Color.BLACK);
					if((double)secondsPassed/1000.0>=player.getRebuildTime()){
						rebuilds--;
						HP=player.getHP();
						sheild=player.getSheild();
					}
				}
				if(playerX>canvas.getWidth()-230){
					playerXSpeed=0;
					playerX = (int)canvas.getWidth()-230;
				}
				if(playerX<80){
					playerXSpeed=0;
					playerX=80;
				}
				/*
				else{
					gc.setFill( Color.YELLOW);
					gc.setStroke( Color.BLACK );
					gc.setLineWidth(1);
					Font font = Font.font("Arial", FontWeight.NORMAL, 48 );
					gc.setFont( font );
					gc.fillText( "Game Over", 100, 50 );
					gc.strokeText( "Game Over", 100, 50 );
				}
				*/

		}
	}
}
