public class TraditionalCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attackingWarrior, Warrior defendingWarrior) {
		if (attackingWarrior.calculateAttack() > defendingWarrior.calculateDefense()) {
			return attackingWarrior;
		} else {
			return defendingWarrior;
		}
	}
}
