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
	int BcollisionX;
	int BcollisionY;
	Canvas canvas;
	Rectangle2D rect10;
	Rectangle2D rect3;
	Rectangle2D rect4;
	Rectangle2D rect5;
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
	int ATK;
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
	ArrayList<Integer> Epositiony=new ArrayList<>();
	ArrayList<Integer> Epositionx=new ArrayList<>();
	ArrayList<Bullet> playerBullets=new ArrayList<>();
	ArrayList<Enemy> Enemies=new ArrayList<>();
	ArrayList<Integer> EnemyHealth=new ArrayList<>();
	ArrayList<Integer> EnemiesInWaves=new ArrayList<>();
	ArrayList<Rectangle2D> EnemyRects=new ArrayList<>();
	ArrayList<Integer> EnemySpeeds=new ArrayList<>();
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
		enemiesRemoved=0;
		onceDone=false;
		ATK=player.getATK();
		HP=(double)player.getHP();
		sheild=(double)player.getSheild();
		cannons=player.getCannons();
		wave=1;
		EnemiesInWaves.add(2*wave);
		EnemiesInWaves.add(0);
		EnemiesInWaves.add(0);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,this);
		scene.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
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
			if (((KeyEvent)event).getCode() == KeyCode.LEFT)
				playerXSpeed=-8;
			if (((KeyEvent)event).getCode() == KeyCode.RIGHT)
				playerXSpeed=8;
			if (((KeyEvent)event).getCode() == KeyCode.SPACE){
				clip.play();
				bullets+=player.getCannons();
				playerBullets.add(new Bullet(10,playerX-5,playerY));
				playerBullets.add(new Bullet(10,playerX+20,playerY));
				playerBullets.add(new Bullet(10,playerX+105,playerY));
				playerBullets.add(new Bullet(10,playerX+125,playerY));
				playerBullets.add(new Bullet(2,playerX+60,playerY));
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
				playerX+=playerXSpeed;
				playerBulletY+=playerBulletSpeed;
				gc.drawImage( background, 0, 0, canvas.getWidth(),canvas.getHeight() );
				//ship
				Rectangle2D rect2 = new Rectangle2D(canvas.getWidth()/2-130, canvas.getHeight()-230,230,230);
				//gc.fillRect(playerX,playerY,150,150);
				//bases
				//gc.fillRect(canvas.getWidth()/2-130, canvas.getHeight()-230,230,230);
				//UI HEALTH+SHEILD
				gc.drawImage(healthBar,1,-10,150,canvas.getHeight()-((int)((double)HP/(double)canvas.getHeight()))+30);
				gc.drawImage(sheildBar,canvas.getWidth()-71,2,70,canvas.getHeight()-((int)((double)HP/(double)canvas.getHeight())));
				//bullets
				for(int a=0;a<EnemyRects.size();a++){
					for(int i=0;i<bullets; i++){
						gc.fillRect(playerBullets.get(i).getXPOS(), playerBullets.get(i).getYPOS(), 30,100);
						gc.drawImage( beam1, playerBullets.get(i).getXPOS(), playerBullets.get(i).getYPOS(), 30,100);
						rect10 = new Rectangle2D( playerBullets.get(i).getXPOS(), playerBullets.get(i).getYPOS(), 30,100 );
						if(playerBullets.get(i).getYPOS()<-50){
							playerBullets.remove(i);
							bullets--;
						}
						if(EnemyRects.get(a).intersects(rect10)){
							Bcollision=true;
							BcollisionX=playerBullets.get(i).getXPOS();
							BcollisionY=playerBullets.get(i).getYPOS();
							playerBullets.remove(i);
							bullets--;
						}
					}
				}
				//enemies
				//int[] EnemiesInWave={1*wave,1*wave,wave};
				for(int j=0;j<EnemiesInWaves.get(0);j++){
					for(int k=0;k<EnemiesInWaves.get(0);k++){
						Epositionx.add((int)(Math.random()*1300)+100);
						Epositiony.add(0);
						EnemySpeeds.add((int)(Math.random()*5)+wave);
					}
					if(Epositiony.get(j)<200)
						Epositiony.set(j,Epositiony.get(j)+EnemySpeeds.get(j));
					if(enemies+enemiesRemoved<=EnemiesInWaves.get(0)){
						ENEMY = new Enemy(1,Epositionx.get(j),Epositiony.get(j));
						Enemies.add(ENEMY);
						EnemyHealth.add(Enemies.get(j).getHP()*wave);
						EnemyRects.add(rect3 = new Rectangle2D(Epositionx.get(j),Epositiony.get(j), 100,100));
						enemies++;
					}

					if(EnemyHealth.get(j)<=0){
						enemies--;
						enemiesRemoved++;
						System.out.println(enemies);
					}

					if(enemies>0){
						gc.fillRect(Epositionx.get(j),Epositiony.get(j), 100, 100);
						gc.drawImage( enemy1, Epositionx.get(j),Epositiony.get(j), 100, 100);
					}
					else
						rect3 = new Rectangle2D(canvas.getWidth()/2-2000,50, 150,150);
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
				gc.drawImage( ship1, playerX, playerY,150,150 );
				gc.drawImage( ship1Extra, playerX+10, playerY+ship1.getHeight(),130,75);
				Rectangle2D rect1 = new Rectangle2D( playerX,playerY,150,150 );
				gc.drawImage( ship1Extra, playerX+10, playerY+ship1.getHeight(),130,75);
				gc.drawImage( homeBase, canvas.getWidth()/2-130, canvas.getHeight()-230,230,230);
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
