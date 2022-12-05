package advent.code.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day1Test {

	
	@Test
	void testSmallSample() {
		Day1 day1 = new Day1("src/main/resources/mock_calories.txt");
		assertEquals(24000, day1.day1a());
	}
	
	@Test
	void testBigSample() {
		Day1 day1 = new Day1("src/main/resources/calories.txt");
		assertEquals(67622, day1.day1a());
	}
	
	@Test
	void topThreeTestSmallSample() {
		Day1 day1 = new Day1("src/main/resources/mock_calories.txt");
		assertEquals(45000, day1.day1b());
	}
	
	@Test
	void topThreeTestBigSample() {
		Day1 day1 = new Day1("src/main/resources/calories.txt");
		assertEquals(45000, day1.day1b());
	}
	

}
