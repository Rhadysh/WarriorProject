import java.util.ArrayList;
import java.util.List;

public abstract class Warrior {

	int level;
	int attack;
	int defense;

	Warrior(int level) {
		this.level = level;
	}

	void validate() {
		List<String> errors = new ArrayList<>();

		if (level < 0) {
			errors.add("Level must be greater than 0. ");
		}
		if (attack < 0) {
			errors.add("Attack must be greater than 0. ");
		}
		if (defense < 0) {
			errors.add("Defense must be greater than 0. ");
		}

		if (!errors.isEmpty()) {
			throw new IllegalStateException(String.join("", errors));
		}
	}

	abstract int calculateAttack();

	abstract int calculateDefense();

	abstract double calculateBoost();

	public final double calculatePower() {
		return calculateAttack() + calculateDefense() + calculateBoost();
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public int getLevel() {
		return level;
	}

	public static abstract class Builder {
		Warrior warrior;

		public Builder attack(int attack) {
			warrior.attack = attack;
			return this;
		}

		public Builder defense(int defense) {
			warrior.defense = defense;
			return this;
		}

		public Warrior build() {
			warrior.validate();
			return warrior;
		}
	}

}
