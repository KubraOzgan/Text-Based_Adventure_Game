package adventure;

import java.util.Random;

public abstract class BattleLoc extends Location {
	
	private Obstacle obstacle;
	private String award;
	private int maxObstacle;
	
	public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
		super(player, name);
		this.obstacle = obstacle;
		this.award = award;
		this.maxObstacle = maxObstacle;
	}
	
	@Override
	public boolean onLocation() {
		int obstNumber = this.obstacleNumber();
		System.out.println("You are at: " + this.getName());
		System.out.println("Be careful, there are " + obstNumber + " " + this.getObstacle().getName() + "(s) here!");
		
		System.out.println("\n* * * GAME TIME * * *");
		System.out.println("Shall we begin? If you would like to combat please enter 'C', otherwise to escape 'E'.");
		String select = sc.next();
		
		if(select.toUpperCase().equals("C") && combat(obstNumber)) {
			System.out.println("You defeated all the enemies at the " + this.getName() + ". YOU WIN!!!\n");
			return true;
		}
		
		if(this.getPlayer().getHealth() <= 0) { // combat(this.obstacleNumber()) is false
			System.out.println("You lost!");
			return false;
		}
		
		return true;
	}
	
	public int obstacleNumber() {
		int random = (int) (Math.random() * this.getMaxObstacle() + 1);
		return random;
		/*Random r = new Random();
		return r.nextInt(this.getMaxObstacle() + 1);*/
	}
	
	public boolean combat(int obstNumber) {
		for(int i = 0; i < obstNumber; i++) {
			this.getObstacle().setHealth(this.getObstacle().getDefaultHealth()); // Get health for every obstacle (Otherwise it will be zero after the first one died)
			playerStats();
			obstacleStats(i);
			
			while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0 ) {
				System.out.println("Enter 'F' for a great war or 'E' to escape like a coward!");
				String select = sc.next().toUpperCase();
				
				if(select.equals("F")) {
					/*System.out.println("You hit!");
					this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
					afterHit();
					
					if(this.getObstacle().getHealth() > 0) {
						System.out.println("Obstacle hit you!");
						int obstDamage = this.getObstacle().getDamage() - this.getPlayer().getArmor().getBlock();
						if(obstDamage < 0)
							obstDamage = 0;
						this.getPlayer().setHealth(this.getPlayer().getHealth() - obstDamage);
						afterHit();
					}*/
					whoHit();
					afterHit();
				}
				else { //Run
					return false;
				}	
			}
			
			if(this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
				System.out.println();
				System.out.println("You have defeated the enemy!");
				System.out.println("You won " + this.getObstacle().getMoney() + " gold!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
				System.out.println("Your current money: " + this.getPlayer().getMoney());
				System.out.println();
			}
			else { //Dead
				return false;
			}
		}
		
		return true;
	}
	
	public void whoHit() {
		double random = Math.random() * 100;
		int obstDamage = this.getObstacle().getDamage() - this.getPlayer().getArmor().getBlock();
		if(obstDamage < 0)
			obstDamage = 0;
		if(random >= 50) { // Player starts
			System.out.println("You hit!");
			this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
		}
		
		else {
			System.out.println("Obstacle hit you!");
			this.getPlayer().setHealth(this.getPlayer().getHealth() - obstDamage);
		}
	}
	
	public void playerStats() {
		System.out.println("********** Player Stats **********");
		System.out.println("Health: " + this.getPlayer().getHealth() + "\n" 
				+ "Weapon: " + this.getPlayer().getWeapon().getName() + "\n" //getInventory().getWeapon().getName()
				+ "Damage: " + this.getPlayer().getTotalDamage() + "\n"
				+ "Armor: " + this.getPlayer().getArmor().getName() + "\n" 
				+ "Block: " + this.getPlayer().getInventory().getArmor().getBlock() + "\n"
				+ "Money: " + this.getPlayer().getMoney() + "\n");
	}
	
	public void obstacleStats(int i) {
		System.out.println("********** " + (i+1) + "." + this.getObstacle().getName() + "'s Stats **********");
		System.out.println("Health: " + this.getObstacle().getHealth() + "\n" 
				+ "Damage: " + this.getObstacle().getDamage() + "\n" 
				+ "Money: " + this.getObstacle().getMoney() + "\n");
	}
	
	public void afterHit() {
		System.out.println("!!! Your health: " + this.getPlayer().getHealth());
		System.out.println(this.getObstacle().getName() + "'s health: " + this.getObstacle().getHealth() + "\n");
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getMaxObstacle() {
		return maxObstacle;
	}

	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}
	
}
