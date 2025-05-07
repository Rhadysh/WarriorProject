public class DefenseCombatState implements CombatState {
	@Override
	public Warrior fight(Warrior attackingWarrior, Warrior defendingWarrior) {
		if (attackingWarrior.calculateDefense() > defendingWarrior.calculateDefense()) {
			return attackingWarrior;
		} else {
			return defendingWarrior;
		}
	}
}
