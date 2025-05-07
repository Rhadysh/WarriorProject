public class AggressiveWarrior extends Warrior {

	private AggressiveWarrior(int level) {
		super(level);
	}

	@Override
	int calculateAttack() {
		return getAttack() + 2 * level;
	}

	@Override
	int calculateDefense() {
		return getDefense() + level;
	}

	@Override
	double calculateBoost() {
		return (double) getAttack() / 2;
	}

	public static class Builder extends Warrior.Builder {

		public Builder(int level) {
			warrior = new AggressiveWarrior(level);
			warrior.attack = 3;
			warrior.defense = 2;
		}

	}

}
