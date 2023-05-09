package project;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Suggestions {
	
	public static TST<Integer> tst = new TST<Integer>();
	public static void buildTST(File file) throws Exception{
		String str = new String(Files.readAllBytes(Paths.get(file.getPath())));
		//It will tokenize text to extract only words
		Pattern pattern = Pattern.compile("[\\w]+");
		Matcher  matcher = pattern.matcher(str);
		ArrayList<String> words= new ArrayList<String>();
		while(matcher.find()) {
				words.add(matcher.group());
			}
		for (int i = 0; i < words.size(); i++) {
			if(tst.contains(words.get(i))) {
				tst.put(words.get(i), tst.get(words.get(i))+1);
			}
			else
			tst.put(words.get(i),1);
		}	
	}
	
	//For getting suggestions.
	public static ArrayList<String> gettingSuggestions(String keyword){
		Queue<String> suggestions = (Queue<String>) tst.prefixMatch(keyword);
		ArrayList<String> strings = new ArrayList<String>();
		for (int i = 0; i < suggestions.size(); i++) {
			strings.add(suggestions.dequeue());
		}
		return strings;
	}
	
	public static ArrayList<String> sugges(String args) {
		File path = new File("E:\\ACC_Files\\");
		File[] listOfFiles = path.listFiles();
		for (File file : listOfFiles) {
			try {
				buildTST(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ArrayList<String> abc=new ArrayList<>();
		abc=gettingSuggestions(args);
		return abc;
		
	}
}