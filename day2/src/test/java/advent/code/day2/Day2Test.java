package advent.code.day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class Day2Test {

	@Test
	void testSmallSample() {
		Day2 day2 = new Day2("src/main/resources/mock_input.txt");
		assertEquals(15, day2.day2a());
	}
	
	@Test
	void testBigSample() {
		Day2 day2 = new Day2("src/main/resources/input.txt");
		assertEquals(12772, day2.day2a());
	}
	
	@Test
	void testbSmallSample() {
		Day2 day2 = new Day2("src/main/resources/mock_input.txt");
		assertEquals(12, day2.day2b());
	}
	
	@Test
	void testbBigSample() {
		Day2 day2 = new Day2("src/main/resources/input.txt");
		assertEquals(11618, day2.day2b());
	}
	
	
	

}
