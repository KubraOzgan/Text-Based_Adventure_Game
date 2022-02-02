package adventure;

import java.util.Scanner;

public class ToolStore extends NormalLoc {

	public ToolStore(Player player) {
		
		super(player, "Tool Store");
	}
	
	public boolean onLocation() {
		System.out.println("Welcome to tool store.");
		
		boolean menu = true;
		while(menu) {
			System.out.println("\nPlease select"
					+ "\n1 for weapons "
					+ "\n2 for armors "
					+ "\nand 3 for exit.");
			int select = sc.nextInt();
			
			while(select < 1 || select > 3) {
				System.out.println("You entered an invalid value, please try again: ");
				select = sc.nextInt();
			}
			
			switch(select)
			{
				case 1:
					printWeapons();
					buyWeapon();
					break;
				
				case 2:
					printArmors();
					buyArmor();
					break;
					
				case 3:
					System.out.println("You left the tool store.");
					menu = false;
					break;
			}
		}
		
		return true;
	}
	
	public void printWeapons() {
		System.out.println("Great weapons that make you win your fight!");
		for(Weapon weapon : Weapon.weapons()) {
			System.out.println(weapon.getId() + ", " + weapon.getName() + " => Damage: " + weapon.getDamage() + " Price: " + weapon.getPrice());
		}
		System.out.println("0 => Exit");
	}
	
	public void buyWeapon() {

		System.out.println("It's time to choose your weapon. Choose wisely: ");
		int select = sc.nextInt();
		
		while(select < 0 || select > Weapon.weapons().length) {
			System.out.println("You entered an invalid value, please try again: ");
			select = sc.nextInt();
		}
		
		if(select != 0) { //Returns to main menu when it's 0
			Weapon selectedWeapon = Weapon.getWeapon(select);
			if(selectedWeapon != null) {
				if(selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("You don't have enought money!");
				}
				else {
					System.out.println("You bought " + selectedWeapon.getName());
					this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
					System.out.println("Remaining money: " + this.getPlayer().getMoney());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
				}
			}
		}
	}
	
	public void printArmors() {
		System.out.println("Protect yourself!");
		for(Armor armor : Armor.armors()) {
			System.out.println(armor.getId() + ", " + armor.getName() + " => Block: " + armor.getBlock() + " Price: " + armor.getPrice());
		}
		System.out.println("0 => Exit");
	}
	
	public void buyArmor() {

		System.out.println("It's time to choose your armor. Choose wisely: ");
		int select = sc.nextInt();
		
		while(select < 0 || select > Armor.armors().length) {
			System.out.println("You entered an invalid value, please try again: ");
			select = sc.nextInt();
		}
		
		if(select != 0) {
			Armor selectedArmor = Armor.getArmor(select);
			if(selectedArmor != null) {
				if(selectedArmor.getPrice() > this.getPlayer().getMoney()) {
					System.out.println("You don't have enought money!");
				}
				else {
					System.out.println("You bought " + selectedArmor.getName());
					this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
					System.out.println("Remaining money: " + this.getPlayer().getMoney());
					this.getPlayer().getInventory().setArmor(selectedArmor);
				}
			}
		}
	}

}
