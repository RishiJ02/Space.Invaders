public class Enemy{
	private int type;
	private int HP;
	private int ATK;
	private int XPOS;
	private int YPOS;
	public Enemy(int type, int XPOS, int YPOS){
		this.type=type;
		this.XPOS=XPOS;
		this.YPOS=YPOS;
		if(type==1){
			HP=30;
			ATK=25;
		}
		if(type==2){
			HP=350;
			ATK=10;
		}
		if(type==3){
			HP=100;
			ATK=200;
		}
		if(type==4){
			HP=1000;
			ATK=100;
		}
	}
	public int getHP(){
		return HP;
	}
	public int getATK(){
		return ATK;
	}
	public int getType(){
		return type;
	}
	public int getXPOS(){
		return XPOS;
	}
	public int getYPOS(){
		return YPOS;
	}
}