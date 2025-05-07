public class CombatContext {
	private CombatState combatState;
	private TraditionalCombatState traditionalCombatState = new TraditionalCombatState();
	private InverseCombatState inverseCombatState = new InverseCombatState();
	private PowerCombatState powerCombatState = new PowerCombatState();
	private AttackCombatState attackCombatState = new AttackCombatState();
	private DefenseCombatState defenseCombatState = new DefenseCombatState();

	CombatContext() {
		combatState = traditionalCombatState;
	}

	public Warrior fightFiveRounds(Warrior attackingWarrior, Warrior defendingWarrior) {
		int attackWins = 0;

		for (int round = 1; round <= 5; round++) {
			if (combatState.fight(attackingWarrior, defendingWarrior) == attackingWarrior) {
				attackWins += 1;
			}
			nextState();
		}

		if (attackWins > 2) {
			return attackingWarrior;
		} else {
			return defendingWarrior;
		}

	}

	public void nextState() {
		if (combatState.equals(traditionalCombatState)) {
			combatState = inverseCombatState;
		} else if (combatState.equals(inverseCombatState)) {
			combatState = powerCombatState;
		} else if (combatState.equals(powerCombatState)) {
			combatState = attackCombatState;
		} else {
			combatState = defenseCombatState;
		}
	}
}
