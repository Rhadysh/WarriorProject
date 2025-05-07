public class DefensiveWarrior extends Warrior {

	private DefensiveWarrior(int level) {
		super(level);
	}

	@Override
	int calculateAttack() {
		return getAttack() + level;
	}

	@Override
	int calculateDefense() {
		return getDefense() + 2 * level;
	}

	@Override
	double calculateBoost() {
		return (double) getDefense() / 2;
	}

	public static class Builder extends Warrior.Builder {

		public Builder(int level) {
			warrior = new DefensiveWarrior(level);
			warrior.attack = 2;
			warrior.defense = 3;
		}

	}
}