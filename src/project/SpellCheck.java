package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



public class SpellCheck {
	
	//Read the words from a text file and create a List
	private static ArrayList<String> createDict() {
		ArrayList<String> arr = new ArrayList<String>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("E:\\\\Windsor\\\\ACC\\\\Project\\\\Latest Project\\EnglishWords.txt"));
			String line = br.readLine();
			while (line != null) {
				arr.add(line);
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error while accessing Dictionary " + e);
		}
		
		return arr;
	}

	//Use EditDistance algorithm to find alternate words to the given word
	public static ArrayList<String> correction(String word) {
		ArrayList<String> wordCorrection = new ArrayList<String>();
		try {
			ArrayList<String> ar = new ArrayList<String>();
			int i = 0;
			int d = 0;
			ar = createDict();
		
			if (!ar.contains(word)) {

				for (i = 0; i < ar.size(); i++) {
					//Find the difference in distance between the words
					d = Sequences.editDistance(word, ar.get(i)); 
					//Add as alternate word if the distance is 1
					if (d == 1) {
						wordCorrection.add(ar.get(i));
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return wordCorrection;
	}

	//Check if a word exists in the dictionary
	public static boolean check(String letter) {
		ArrayList<String> ar = new ArrayList<String>();
		ar = createDict();
		if (ar.contains(letter)) {
			return true;
		} else {
			return false;
		}

	}
}
