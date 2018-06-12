public class Bullet{
	private int x;
	private int y;
	private double speed;
	private int t;
	public Bullet(double speed,int x,int y){
		this.x=x;
		this.y=y;
		this.speed=speed;
		t=0;
	}
	public int getXPOS(){
		return x;
	}

	public int getYPOS(){
		t+=speed;
		return y-t;
	}

	public double getSpeed(){
			return speed;
	}
}