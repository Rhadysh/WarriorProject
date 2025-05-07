public class AttackCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attackingWarrior, Warrior defendingWarrior) {
		if (attackingWarrior.calculateAttack() > defendingWarrior.calculateAttack()) {
			return attackingWarrior;
		} else {
			return defendingWarrior;
		}
	}
}
