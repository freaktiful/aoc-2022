package advent.code.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Day1 {
	
	List<Integer> calories = new ArrayList<Integer>();
	
	String path;
	
	public Day1(String path) {
		this.path = path;
	}
	
	public Integer day1a() {
		try {
			readFile();
		} catch(Exception e) {
			System.out.println(e);
		}

		return Collections.max(calories);
	}
	
	public Integer day1b() {
		try {
			readFile();
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(get3Max());
		return get3Max();
	}
	
	private Integer get3Max() {
		Integer max1 = 0;
		Integer max2 = 0;
		Integer max3 = 0;
		Iterator<Integer> it = calories.iterator();
		while (it.hasNext()) {
			Integer aux = it.next();
			if (aux > max1) {
				max3 = max2;
				max2 = max1;
				max1 = aux;
			} else if (aux > max2) {
				max3 = max2;
				max2 = aux;
			} else if (aux > max3) {
				max3 = aux;
			}
		}
		
		return max1 + max2 + max3;
	}
	
	private void readFile() throws IOException {
		calories.add(0);
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
	     while ((line = reader.readLine()) != null) {
	    	 processLine(line);
	     }
	     reader.close();
	}
	
	private void processLine(String line) {
		try {
			Integer a = calories.get(calories.size()-1);
			a = a + Integer.valueOf(line);
			calories.remove(calories.size()-1);
			calories.add(a);
		} catch(NumberFormatException e) {
			calories.add(0);
		}
	}
}
