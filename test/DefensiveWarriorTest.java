import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DefensiveWarriorTest {

	@Test
	void correct_instance() {
		Warrior warrior = new DefensiveWarrior.Builder(1).build();
		assertTrue(warrior instanceof DefensiveWarrior);
	}

	@Test
	void default_values() {
		Warrior warrior = new DefensiveWarrior.Builder(1).build();
		assertSame(1, warrior.getLevel());
		assertSame(2, warrior.getAttack());
		assertSame(3, warrior.getDefense());
	}

	@Test
	void custom_level() {
		Warrior warrior = new DefensiveWarrior.Builder(10).build();
		assertSame(10, warrior.getLevel());
		assertSame(2, warrior.getAttack());
		assertSame(3, warrior.getDefense());
	}

	@Test
	void only_attack() {
		Warrior warrior = new DefensiveWarrior.Builder(1).attack(10).build();
		assertSame(1, warrior.getLevel());
		assertSame(10, warrior.getAttack());
		assertSame(3, warrior.getDefense());
	}

	@Test
	void only_defense() {
		Warrior warrior = new DefensiveWarrior.Builder(1).defense(10).build();
		assertSame(1, warrior.getLevel());
		assertSame(2, warrior.getAttack());
		assertSame(10, warrior.getDefense());
	}

	@Test
	void both_attack_and_defense() {
		Warrior warrior = new DefensiveWarrior.Builder(1).attack(5).defense(10).build();
		assertSame(1, warrior.getLevel());
		assertSame(5, warrior.getAttack());
		assertSame(10, warrior.getDefense());
	}

	@Test
	void illegal_state_exception_level() {
		Throwable exception = assertThrows(IllegalStateException.class, () -> new DefensiveWarrior.Builder(-1).build());

		assertEquals("Level must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_attack() {
		Throwable exception = assertThrows(IllegalStateException.class,
				() -> new DefensiveWarrior.Builder(1).attack(-1).build());

		assertEquals("Attack must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_defense() {
		Throwable exception = assertThrows(IllegalStateException.class,
				() -> new DefensiveWarrior.Builder(1).defense(-1).build());

		assertEquals("Defense must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_level_and_defense() {
		Throwable exception = assertThrows(IllegalStateException.class,
				() -> new DefensiveWarrior.Builder(-1).defense(-1).build());

		assertEquals("Level must be greater than 0. Defense must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_level_and_attack() {
		Throwable exception = assertThrows(IllegalStateException.class,
				() -> new DefensiveWarrior.Builder(-1).attack(-1).build());

		assertEquals("Level must be greater than 0. Attack must be greater than 0. ", exception.getMessage());
	}

	@Test
	void illegal_state_exception_level_and_attack_and_defense() {
		Throwable exception = assertThrows(IllegalStateException.class,
				() -> new DefensiveWarrior.Builder(-1).attack(-1).defense(-1).build());

		assertEquals("Level must be greater than 0. Attack must be greater than 0. Defense must be greater than 0. ",
				exception.getMessage());
	}

	@Test
	void calculate_attack_should_add_level__to_attack() {
		Warrior warrior = new DefensiveWarrior.Builder(1).attack(10).build();
		assertSame(11, warrior.calculateAttack());
	}

	@Test
	void calculate_defense_should_add_level_times_2_to_defense() {
		Warrior warrior = new DefensiveWarrior.Builder(1).defense(10).build();
		assertSame(12, warrior.calculateDefense());
	}

	@Test
	void calculate_boost_should_add_half_of_defense_value() {
		Warrior warrior = new DefensiveWarrior.Builder(1).defense(7).build();
		assertEquals(3.5, warrior.calculateBoost());
	}

	@Test
	void get_power_should_add_attack_defense_and_boost() {
		Warrior warrior = new DefensiveWarrior.Builder(1).attack(10).defense(10).build();
		assertEquals(28, warrior.calculatePower());
	}

	@Test
	void get_power_should_add_attack_defense_and_boost_more_complicated() {
		Warrior warrior = new DefensiveWarrior.Builder(6).attack(11).defense(17).build();
		assertEquals(54.5, warrior.calculatePower());
	}
}
