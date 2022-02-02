package adventure;

import java.util.Scanner;

public class Player {
	
	private int damage, health, defaultHealth, money;
	private String name, selectedCharacter;
	
	private Inventory inventory;
	
	private Scanner sc = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}
	
	public int getTotalDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
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
		if(health < 0) //Encapsulation
			health = 0;
		this.health = health;
	}
	
	public int getDefaultHealth() {
		return defaultHealth;
	}

	public void setDefaultHealth(int defaultHealth) {
		this.defaultHealth = defaultHealth;
	}

	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSelectedCharacter() {
		return selectedCharacter;
	}
	
	public void setSelectedCharacter(String selectedCharacter) {
		this.selectedCharacter = selectedCharacter;
	}
	
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	
	public Weapon getWeapon() {
		return this.getInventory().getWeapon();
	}
	
	public Armor getArmor() {
		return this.getInventory().getArmor();
	}
	
	public void playersCharacter(Character character) {
		this.setSelectedCharacter(character.getName());
		this.setDamage(character.getDamage());
		this.setHealth(character.getHealth());
		this.setDefaultHealth(character.getHealth());
		this.setMoney(character.getMoney());
	}
	
	public void playerInfo() {
		System.out.println(this.getSelectedCharacter() + " => "
				+ " Weapon: " +  this.getInventory().getWeapon().getName() 
				+ " Armor: " + this.getInventory().getArmor().getName()
				+ " Block: " + this.getInventory().getArmor().getBlock()
				+ " Damage: " + this.getTotalDamage()
				+ " Health: " + this.getHealth()
				+ " Money: " + this.getMoney());
	}
	
	public void selectCharacter() {
		/*Samurai samurai = new Samurai();
		Archer archer = new Archer();
		Knight knight = new Knight();
		System.out.println("Characters: ");
		System.out.println(samurai.getName() + " => Damage: " + samurai.getDamage() + " Health: " + samurai.getHealth() + " Money: " + samurai.getMoney());
		System.out.println(archer.getName() + " => Damage: " + archer.getDamage() + " Health: " + archer.getHealth() + " Money: " + archer.getMoney());
		System.out.println(knight.getName() + " => Damage: " + knight.getDamage() + " Health: " + knight.getHealth() + " Money: " + knight.getMoney());*/
		
		System.out.println("Meet awesome warriors: ");

		Character[] characters = {new Samurai(), new Archer(), new Knight()};
		for(Character ch: characters) {
			System.out.println("Id: " + ch.getId() + ", " +  ch.getName() + " => Damage: " + ch.getDamage() + " Health: " + ch.getHealth() + " Money: " + ch.getMoney());

		}
		
		System.out.println("Now please choose a character: ");
		int select = sc.nextInt(); 
		
		switch(select) {
			case 1:
				playersCharacter(new Samurai());
				break;
			case 2:
				playersCharacter(new Archer());
				break;
			case 3:
				playersCharacter(new Knight());
				break;
			default:
				playersCharacter(new Samurai());
				break;
		}

	}
	
}
