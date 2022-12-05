package advent.code.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day2 {
	
	String path;

	HashMap<String, String> moves = new HashMap<String, String>();
	
	HashMap<String, Integer> drawValues = new HashMap<String, Integer>();
	
	HashMap<String, String> winValues = new HashMap<String, String>();
	
	HashMap<String, String> loseValues = new HashMap<String, String>();
	
	Integer score;
	
	public Day2(String path) {
		
		score = 0;
		this.path = path;
		
		moves.put("A", "ROCK");
		moves.put("B", "PAPER");
		moves.put("C", "SCISSORS");
		moves.put("X", "ROCK");
		moves.put("Y", "PAPER");
		moves.put("Z", "SCISSORS");
		
		drawValues.put("ROCK", 1);
		drawValues.put("PAPER", 2);
		drawValues.put("SCISSORS", 3);
		
		//part 2
		winValues.put("ROCK", "PAPER");
		winValues.put("PAPER", "SCISSORS");
		winValues.put("SCISSORS", "ROCK");
		loseValues.put("ROCK",  "SCISSORS");
		loseValues.put("PAPER",  "ROCK");
		loseValues.put("SCISSORS",  "PAPER");
		
		
	}
	
	public Integer day2a () {
		try {
			readFile(false);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(score);
		return score;
	}
	
	public Integer day2b() {
		try {
			readFile(true);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(score);
		return score;
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
		char[] aux = line.toCharArray(); 
		String opponentMove = moves.get(String.valueOf(aux[0]));
		String myMove;
		if (isPartb) {
			myMove = checkMyMove(opponentMove, String.valueOf(aux[2]));
		} else {
			myMove = moves.get(String.valueOf(aux[2]));
		}
		Integer points = playRound(opponentMove, myMove);
		score += points;
	}
	
	public String checkMyMove(String op, String me) {
		switch(me) {
			case "X":
				return loseValues.get(op);
			case "Y":
				return op;
			case "Z":
				return winValues.get(op);
			default:
				return op;
		}
	}
	
	private Integer playRound(String op, String me) {
		Integer roundScore = 0;
		if (op.equals(me)) {
			roundScore = 3 + drawValues.get(me);
		} else {
			if (isWinner(op, me)) {
				roundScore = drawValues.get(me);
			} else {
				roundScore = 6 + drawValues.get(me);
			}
		}
		return roundScore;
	}
	
	public boolean isWinner(String op, String me) {
		if (op.equals("ROCK") && me.equals("PAPER") || op.equals("PAPER") && me.equals("SCISSORS") ||
				op.equals("SCISSORS") && me.equals("ROCK") ) {
			return false;
		} else return true;
		
	}
	
}

