package advent.code.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
	
	String path;
	Integer priority;
	
	public Day3(String path) {
		this.priority = 0;
		this.path = path;
	}
	
	public Integer day3a() {
		try {
			readFile(false);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(priority);
		return priority;
	}
	
	public Integer day3b() {
		try {
			readFile(true);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(priority);
		return priority;
	}

	
	private void readFile(boolean isPartb) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line1;
		String line2;
		String line3;
	     while ((line1 = reader.readLine()) != null) {
	    	 if (isPartb) {
	    		 line2 = reader.readLine();
		    	 line3 = reader.readLine();
		    	 processGroup(line1, line2, line3);
	    	 } else {
	    		 processLine(line1);
	    	 }
	     }
	     reader.close();
	}

	private void processLine(String line) {
		char[] firstPack = line.substring(0, line.length()/2).toCharArray();
		char[] secondPack = line.substring(line.length()/2).toCharArray();
		boolean errorFound = false;
		for (char c: firstPack) {
			for (char cc: secondPack) {
				if (String.valueOf(c).equals(String.valueOf(cc))) {
					errorFound = true;
					this.priority += getPriority(c);
					break;
				}
			}
			if (errorFound) {
				break;
			}
		}
	}
	
	private void processGroup(String line1, String line2, String line3) {
		char[] firstPack = line1.toCharArray();
		char[] secondPack = line2.toCharArray();
		char[] thirdPack = line3.toCharArray();
		boolean badgeFound = false;
		for (char c: firstPack) {
			for (char cc: secondPack) {
				if (String.valueOf(c).equals(String.valueOf(cc))) {
					for (char ccc: thirdPack) {
						if (String.valueOf(c).equals(String.valueOf(ccc))) {
							badgeFound = true;
							this.priority += getPriority(c);
							break;
						}
					}
				}
				if (badgeFound) {
					break;
				}
			}
			if (badgeFound) {
				break;
			}
		}
		
	}

	
	private Integer getPriority(char c) {
		if (Character.isUpperCase(c)) {
			return Integer.valueOf(c) - Integer.valueOf('A') + 27;
		} else {
			return Integer.valueOf(c) - Integer.valueOf('a') + 1;
		}
	}
}
