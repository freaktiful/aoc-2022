package advent.code.day4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class Day4Test {

	@Test
	void testSmallSample() {
		Day4 day4 = new Day4("src/main/resources/mock_input.txt");
		assertEquals(2, day4.day4a());
	}
	
	@Test
	void testBigSample() {
		Day4 day4 = new Day4("src/main/resources/input.txt");
		assertEquals(485, day4.day4a());
	}
	
	@Test
	void testbSmallSample() {
		Day4 day4 = new Day4("src/main/resources/mock_input.txt");
		assertEquals(4, day4.day4b());
	}
	
	@Test
	void testbBigSample() {
		Day4 day4 = new Day4("src/main/resources/input.txt");
		assertEquals(857, day4.day4b());
	}

}
