public class Combat {
	CombatContext combatContext;

	public Combat(CombatContext combatContext) {
		this.combatContext = combatContext;
	}

	public Warrior duel(Warrior attackingWarrior, Warrior defendingWarrior) {
		return combatContext.fightFiveRounds(attackingWarrior, defendingWarrior);
	}
}
