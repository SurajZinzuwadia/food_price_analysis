package project;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class count {
	//Constructor
	
	// Main method
	public static void rahul()  {
		
		
		
		File folder = new File("E:\\ACC_Files\\");
		File[] files = folder.listFiles();
		

		for (File file : files) {
			String fileName = file.getName();
			
			//System.out.println(fileName);
			if(fileName.equalsIgnoreCase("EnglishWords.txt")) {
				continue;
			}
			String file_name="E:\\ACC_Files\\"+fileName;
			String[] strArray = parsingFile(file_name);
			System.out.println("Word frequency for the file: "+fileName);
			insertIntoHashtable(strArray);
			
			
		}
		
		
		
		}

		static String[] parsingFile (String filePath){
		
		//"C:/W3C/Text/Data.txt";

		System.out.println("Reading the file");
		System.out.println("");


		    Document document;
		try {
		document= Jsoup.parse(new File(filePath), "utf-8");
		   String body = document.body().text();
		   
		  //Using stringtokenizer to parse the string
		   StringTokenizer st = new StringTokenizer(body, " ");
		   
		   ArrayList<String> list=new ArrayList<>();
		   for (int i = 0; st.hasMoreTokens(); i++)
		           
		     list.add( st.nextToken());
		   


		   for (int i = 0; i < list.size(); i++) {

		      String temp= list.get(i).replaceAll("[^\\w]", "");
		      list.set(i,temp);
		   }

		   String[] array = new String[list.size()];
		   
		   list.toArray(array);
		   
		   return array;

		} catch (IOException error) {

		error.printStackTrace();
		}

		return null;

		}



		static void insertIntoHashtable(String[] data){

		//creating a hashtable
		Hashtable<String, Integer> hm = new Hashtable<String, Integer>();


		for (int i = 0; i<data.length; i++) {

		if(data[i].equals("")) {
		continue;
		}

		if(hm.containsKey(data[i].toLowerCase())) {

		int count= hm.get(data[i].toLowerCase());
		hm.put(data[i].toLowerCase(), count+1);
		} else {
		hm.put(data[i].toLowerCase(), 1);
		}

		}

		System.out.println("WORD --> FREQUENCY");
		System.out.println("");

		for (String word: hm.keySet()) {

		   
		   String value = hm.get(word).toString();
		   System.out.println(word + " --> " + value);
		}
		}

		}