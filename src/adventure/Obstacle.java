package adventure;

public class Obstacle {
	
	private int id, damage, health, money, defaultHealth;
	private String name;

	public Obstacle(int id, String name, int damage, int health, int money) {
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.setDefaultHealth(health);
		this.money = money;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health < 0) //After being hit
			health = 0;
		this.health = health;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getDefaultHealth() {
		return defaultHealth;
	}

	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}
	
}
