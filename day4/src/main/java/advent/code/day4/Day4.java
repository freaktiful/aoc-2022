package advent.code.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day4 {
	
	String path;
	Integer sectionsOverlapping;
	
	public Day4(String path) {
		sectionsOverlapping = 0;
		this.path = path;
	}
	
	public Integer day4a() {
		try {
			readFile(false);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(sectionsOverlapping);
		return sectionsOverlapping;
	}
	
	public Integer day4b() {
		try {
			readFile(true);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(sectionsOverlapping);
		return sectionsOverlapping;
	}
	
	private void readFile(boolean isPartb) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
	     while ((line = reader.readLine()) != null) {
	    	 processLine(line, isPartb);
	     }
	     reader.close();
	}

	private void processLine(String line, boolean isPartb) {
		String[] parts = line.split(",");
		String[] first = parts[0].split("-");
		String[] second = parts[1].split("-");
		if(contains(first, second, isPartb) || contains(second, first, isPartb)) {
			this.sectionsOverlapping++;
		}
		
	}

	private boolean contains(String[] first, String[] second, boolean isPartb) {
		Integer firstLower = Integer.valueOf(first[0]);
		Integer firstHigher = Integer.valueOf(first[1]);
		Integer secondLower = Integer.valueOf(second[0]);
		Integer secondHigher = Integer.valueOf(second[1]);
		if (isPartb) {
			if (((firstLower >= secondLower) && (firstLower <= secondHigher)) || ((firstHigher >= secondLower) && (firstHigher <= secondHigher))) {
				return true;
			}
		} else {
			if ((firstLower >= secondLower) && (firstLower <= secondHigher) && (firstHigher >= secondLower) && (firstHigher <= secondHigher)) {
				return true;
			} 
		}
		return false;
	}

}
