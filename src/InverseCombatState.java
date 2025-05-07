public class InverseCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior attackingWarrior, Warrior defendingWarrior) {
		if (attackingWarrior.calculateDefense() >= defendingWarrior.calculateAttack()) {
			return attackingWarrior;
		} else {
			return defendingWarrior;
		}
	}
}
