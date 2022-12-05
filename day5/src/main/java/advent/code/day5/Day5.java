package advent.code.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5 {
	
	String path;
	String crates;
	List<Stack<String>> state = new ArrayList<Stack<String>>();
	
	public Day5(String path) {
		this.path = path;
		crates = "";
	}
	
	public String day5a() {
		try {
			readFile(false);
		} catch (Exception e) {
			System.out.println(e);
		}
		getTopCrates();
		System.out.println(crates);
		return crates;
	}

	public String day5b() {
		try {
			readFile(true);
		} catch (Exception e) {
			System.out.println(e);
		}
		getTopCrates();
		System.out.println(crates);
		return crates;
	}
	
	private void readFile(boolean isPartb) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		List<String> lines = new ArrayList<String>();
		String line;
		//read initial state
	     while (!(line = reader.readLine()).equals("")) {
	    	 lines.add(line);
	     }
	     processInitialState(lines);
	     while((line = reader.readLine()) != null) {
	    	 processLine(line, isPartb);
	     }
	     //
	     reader.close();
	}

	private void processInitialState(List<String> lines) {
		List<Integer> indexes = new ArrayList<Integer>();
		
		List<char[]> boxes = new ArrayList<char[]>();
		for(String line: lines) {
			boxes.add(line.toCharArray());
		}
		
		//get stack indexes
		char[] latest = boxes.get(boxes.size()-1);
		int length = latest.length;
		for(int i = 0; i<length; i++) {
			if (!String.valueOf(latest[i]).equals("") && !String.valueOf(latest[i]).equals(" ")) {
				indexes.add(i);
			}
		}
		
		//initialize stacks
		for (Integer stack: indexes) {
			state.add(new Stack<String>());
		}
		
		//initial state
		for(int h = boxes.size()-2; h >= 0; h--) {
			char[] current = boxes.get(h);
			for(int j = 0; j < indexes.size(); j++) {
				String character = String.valueOf(current[indexes.get(j)]);
				if (!character.equals("") && !character.equals(" ")) {
					state.get(j).push(character);
				}
			}
			
		}
	}
	
	private void processLine(String line, boolean isPartb) {
		int cratesMoved, fromStack, toStack;
		String[] aux = line.split(" ");
		cratesMoved = Integer.valueOf(aux[1]);
		fromStack = Integer.valueOf(aux[3])-1;
		toStack = Integer.valueOf(aux[5])-1;
		
		if(!isPartb) {
			for(int i= 0; i<cratesMoved; i++) {
				moveCrate(fromStack, toStack);
			}
		} else {
			moveCrate9001(fromStack, toStack, cratesMoved);
		}
	}

	private void moveCrate9001(int fromStack, int toStack, int cratesMoved) {
		Stack<String> aux = new Stack<String>();
		String crate;
		for(int i= 0; i<cratesMoved; i++) {
			crate = state.get(fromStack).pop();
			aux.push(crate);
		}
		while(!aux.empty()) {
			crate = aux.pop();
			state.get(toStack).push(crate);
		}
		
	}

	private void moveCrate(int fromStack, int toStack) {
		String crate = state.get(fromStack).pop();
		state.get(toStack).push(crate);
	}
	
	private void getTopCrates() {
		for(Stack<String> s: state) {
			crates = crates.concat(s.lastElement());
		}
	}

}
