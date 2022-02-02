package adventure;

public class Armor {
	
	private String name;
	private int id, block, price;
	
	public Armor(String name, int id, int block, int price) {
		super();
		this.name = name;
		this.id = id;
		this.block = block;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	} 
	
	public static Armor[] armors() {
		Armor[] armors = {new Armor("Light Armor", 1, 1, 15), 
				new Armor("Medium Weight Armor", 2, 3, 25), 
				new Armor("Heavy Armor", 3, 5, 40)};
		return armors;
	}
	
	public static Armor getArmor(int id) {
		for(Armor armor: Armor.armors()) {
			if(armor.getId() == id) {
				return armor;
			}
		}
		return null;
	}
	
}
