public class ArmoredWarriorDecorator extends WarriorDecorator {

	public ArmoredWarriorDecorator(Warrior warrior) {
		super(warrior);
		this.warrior = warrior;
		warrior.defense = warrior.getDefense() * 2;
	}

}
