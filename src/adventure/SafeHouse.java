package adventure;

public class SafeHouse extends NormalLoc {

	
	public SafeHouse(Player player) {
		
		super(player, "Safe House");
	}

	@Override
	public boolean onLocation()
	{
		System.out.println("You are at the safe house, your health reseted.");
		this.getPlayer().setHealth(this.getPlayer().getDefaultHealth());
		return true;
	}
	
}
