package project;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class InvertedIndex {
	
	// method to get list of words of a HTML file from its path
	public static String[] getWordFromFile(File filename) {
		
		Document document;
		try {
			// read file using jsoup and get text
			document = Jsoup.parse(filename, "UTF-8");
			Element body = document.body();
			String strContent = body.text();
			strContent = strContent.replaceAll("[^A-Za-z0-9]+", " ");
			strContent = strContent.toLowerCase();
			return strContent.split("[ ]+");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void invertedMethod(String user_input) {
		// define folder path where html files are located
		String HTHLFilesPath = "E:\\ACC_Files\\";
		File path = new File(HTHLFilesPath);
		File[] listOfFiles = path.listFiles();
		String[] words;

		// initialize the trie data structure
  		trieST trie = new trieST();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				words = getWordFromFile(listOfFiles[i]);
				for(String word : words) {
					trie.put(word, listOfFiles[i].getName());
				}
			}
		}
		HashMap<String, Integer> tmp;
		tmp = trie.get(user_input);
		for(String k : tmp.keySet()) {
			System.out.println(k+":"+tmp.get(k));
		}
	}
}

