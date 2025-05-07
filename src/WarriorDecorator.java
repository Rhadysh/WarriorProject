public abstract class WarriorDecorator extends Warrior {
	Warrior warrior;

	public WarriorDecorator(Warrior warrior) {
		super(warrior.level);
		this.warrior = warrior;
	}

	@Override
	int calculateAttack() {
		return warrior.calculateAttack();
	}

	@Override
	int calculateDefense() {
		return warrior.calculateDefense();
	}

	@Override
	double calculateBoost() {
		return warrior.calculateBoost();
	}

	@Override
	public int getDefense() {
		return warrior.getDefense();
	}

	@Override
	public int getAttack() {
		return warrior.getAttack();
	}
}
