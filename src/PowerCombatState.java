public class PowerCombatState implements CombatState {
	@Override
	public Warrior fight(Warrior attackingWarrior, Warrior defendingWarrior) {
		if (attackingWarrior.calculatePower() > defendingWarrior.calculatePower()) {
			return attackingWarrior;
		} else {
			return defendingWarrior;
		}
	}
}
