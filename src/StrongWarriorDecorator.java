public class StrongWarriorDecorator extends WarriorDecorator {

	public StrongWarriorDecorator(Warrior warrior) {
		super(warrior);
		this.warrior = warrior;
		warrior.attack = warrior.getAttack() * 2;
	}

}
