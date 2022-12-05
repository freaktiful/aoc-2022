package advent.code.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class Day3Test {

	@Test
	void testSmallSample() {
		Day3 day3 = new Day3("src/main/resources/mock_input.txt");
		assertEquals(157, day3.day3a());
	}
	
	@Test
	void testBigSample() {
		Day3 day3 = new Day3("src/main/resources/input.txt");
		assertEquals(157, day3.day3a());
	}
	
	@Test
	void testbSmallSample() {
		Day3 day3 = new Day3("src/main/resources/mock_input.txt");
		assertEquals(70, day3.day3b());
	}
	
	@Test
	void testbBigSample() {
		Day3 day3 = new Day3("src/main/resources/input.txt");
		assertEquals(2363, day3.day3b());
	}

}
