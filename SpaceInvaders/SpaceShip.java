public class SpaceShip{
	private int type;
	private int HP;
	private int sheild;
	private int rebuildTime;
	private int cannons;
	private int atk;
	public SpaceShip(int type){
		this.type=type;
		if (type==1){
			atk=10;
			sheild=300;
			HP=500;
			rebuildTime=5;
			cannons=5;
		}
		if (type==2){
			HP=150;
			sheild=50;
			rebuildTime=3;
			cannons=2;
			atk=25;
		}
		if (type==3){
		}
		if (type==4){
		}
		if (type==5){
		}
		if (type==6){
		}
		if (type==7){
		}
		if (type==8){
		}
		if (type==9){
		}
		if (type==10){
		}
		if (type==11){
		}
		if (type==12){
		}
	}
	public int getType(){
		return type;
	}
	public int getHP(){
		return HP;
	}
	public int getSheild(){
		return sheild;
	}
	public int getRebuildTime(){
		return rebuildTime;
	}
	public int getCannons(){
		return cannons;
	}
	public int getATK(){
		return atk;
	}
	public void setType(int typeChanged){
			type = typeChanged;
	}
	public void setHP(int upgradeHP){
		HP = upgradeHP;
	}
	public void setSheild(int upgradeSheild){
		sheild = upgradeSheild;
	}
	public void setATK(int upgradeATK){
		atk = upgradeATK;
	}
	public void setRebuildTime(int upgradeRebuildTime){
		rebuildTime=upgradeRebuildTime;
	}

}