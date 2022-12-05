package advent.code.day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class Day5Test {

	@Test
	void testSmallSample() {
		Day5 day5 = new Day5("src/main/resources/mock_input.txt");
		assertEquals("CMZ", day5.day5a());
	}
	
	@Test
	void testBigSample() {
		Day5 day5 = new Day5("src/main/resources/input.txt");
		assertEquals("VJSFHWGFT", day5.day5a());
	}
	
	@Test
	void testbSmallSample() {
		Day5 day5 = new Day5("src/main/resources/mock_input.txt");
		assertEquals("MCD", day5.day5b());
	}
	
	@Test
	void testbBigSample() {
		Day5 day5 = new Day5("src/main/resources/input.txt");
		assertEquals("LCTQFBVZV", day5.day5b());
	}

}
