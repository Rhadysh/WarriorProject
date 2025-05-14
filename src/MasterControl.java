public class MasterControl {
	public static void main(String[] args) {
		new MasterControl().start();
	}

	private void start() {

		Combat combat = new Combat(new CombatContext());
		Warrior warriorOne = new StrongWarriorDecorator(new AggressiveWarrior.Builder(12).attack(16).build());
		Warrior warriorTwo = new StrongWarriorDecorator(new DefensiveWarrior.Builder(15).defense(25).build());
		Warrior winner = combat.duel(warriorOne, warriorTwo);
		System.out.println(winner);
		System.out.println(warriorOne.calculateAttack());
		System.out.println(warriorTwo.calculateDefense());
	}
}
