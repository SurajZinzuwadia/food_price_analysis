package project;

import java.util.ArrayList;
import java.util.Scanner;

public class spellChecker {

	public static void spellCheck(String word) {
		String correction = "";
		boolean wordExist;
		//Spell Checker
		ArrayList<String> spellList = SpellCheck.correction(word.substring(0, 1).toUpperCase()+word.substring(1));
		for (int i = 0; i < spellList.size(); i++) {
			if (i == spellList.size() - 1) {
				correction += spellList.get(i);
			} else {
				correction += spellList.get(i) + " or ";
			}
		}
//
		wordExist = SpellCheck.check(word.substring(0, 1).toUpperCase()+word.substring(1)); 
		
		if(wordExist) {
			System.out.println("The word is "+word);
			
		}
		else if (spellList.isEmpty() && !wordExist) {
			System.out.println("\nNot a valid word\n");
		} else if (spellList.isEmpty() && wordExist) {
			System.out.println("\nCannot find this word in the files\n");
		} else {
			System.out.println("\nDid you mean: " + correction);
			
				
		}
		
	}
}
