package project;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task {
	
    public static void main(String[] args) throws IOException  {
    	
    	HashMap<String, Integer> hashMap = new HashMap<>();
    	 
    	Scanner sc=new Scanner(System.in);
    	int choice;
    	 
    	 do {
    		 
        	 
        	 
    		 System.out.println("**********************OPTIONS*****************************");
        	 System.out.println("1.Parse data from amazon.");
        	 System.out.println("2.Search a food in amazon");
        	 System.out.println("3.Spell Checker");
        	 System.out.println("4.Search Frequency");
        	 System.out.println("5.Page Ranking");
        	 System.out.println("6.Word Suggestions");
        	 System.out.println("7.Frequency of words for each file");
        	 System.out.println("8.Inverted Index Code");

        	 System.out.println("**********************Enter Your Choice*****************************");
        	choice =sc.nextInt();
        	switch(choice) {
        	case 1:
        		parseData.parse();
        		
        		break;
        	case 2:{
        		sc.nextLine();
        		 String user_input;
       	      System.out.println("Enter item you want to search");
       	      user_input=sc.nextLine();
       	      if (!hashMap.containsKey(user_input)) {
       	  		hashMap.put(user_input, 1);
       	  	}
       	  	else {
       	  		hashMap.put(user_input, hashMap.get(user_input)+1);
       	  	}
       	      
       		 searchFood.searchingFood(user_input);
       		 break;
        	}
        	case 3:{
        		String user_input;
                System.out.println("Enter the word");
                sc.nextLine();
                user_input=sc.nextLine();
                		 
                if (!hashMap.containsKey(user_input)) {
            		hashMap.put(user_input, 1);
            	}
            	else {
            		hashMap.put(user_input, hashMap.get(user_input)+1);
            	}
                
                		 spellChecker.spellCheck(user_input);
                
               
				break;
				
               
        		
        	}
        		
        	case 4:
        	{
        		System.out.println("Here is the list of Search Words and their counts:");
            	for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            		String key = entry.getKey();
            		Integer val = entry.getValue();
            		System.out.println("Search frequency for Word: "+ key + " is:"+ val);
            	}
            	break;
        		
        	}
        	case 5:
        	{
        		
        		String user_input;
                System.out.println("Enter the word");
                sc.nextLine();
                user_input=sc.nextLine();
                if (!hashMap.containsKey(user_input)) {
            		hashMap.put(user_input, 1);
            	}
            	else {
            		hashMap.put(user_input, hashMap.get(user_input)+1);
            	}
                		 
                		 countFrequency.count(user_input);
                		 break;
        	}
        	case 6:{
        		String user_input;
                System.out.println("Enter the word");
                sc.nextLine();
                user_input=sc.nextLine();
                		 
                if (!hashMap.containsKey(user_input)) {
            		hashMap.put(user_input, 1);
            	}
            	else {
            		hashMap.put(user_input, hashMap.get(user_input)+1);
            	}
                
               
                
                ArrayList<String> suggestions= Suggestions.sugges(user_input);
				
				
				for (String string : suggestions) {
					System.out.println(string);
				}
				
        		break;
        	}
        	
        	case 7:{
        		count.rahul();
        		break;
        	}
        	case 8:{
        		String user_input;
                System.out.println("Enter the word");
                sc.nextLine();
                user_input=sc.nextLine();
                		 
                if (!hashMap.containsKey(user_input)) {
            		hashMap.put(user_input, 1);
            	}
            	else {
            		hashMap.put(user_input, hashMap.get(user_input)+1);
            	}
               InvertedIndex.invertedMethod(user_input);
                
//                ArrayList<String> suggestions= Suggestions.sugges(user_input);
//				
//				
//				for (String string : suggestions) {
//					System.out.println(string);
//				}
				
        		break;
        	}
        	
        	
        	}
        	 
      
    	 }while(choice>0 && choice<=8);
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
//    	 
    	 //getTST("Eggs.txt");
    	 
//    	 

//         

    }
    
    
    
    

	/*
	 * To sort HashMap by values, use the Collections.sort(List) method by passing customized comparator. 
	 * create a new LinkedHashMap and copy the sorted elements into that. 
	 * LinkedHashMap guarantees the insertion order of mappings and we get a sorted HashMap .
	 */
	public static HashMap<String, Integer> sortingHashMap(HashMap<String, Integer> freqList) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(freqList.entrySet());
		Collections.sort(list, (i1, i2) -> i2.getValue().compareTo(i1.getValue()));	
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());

		}

		return temp;
	}
	
	
	public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {
            
                  // return comparison results of values of
                  // two keys
                  public int compare(K k1, K k2)
                  {
                      int comp = map.get(k1).compareTo(
                          map.get(k2));
                      if (comp == 0)
                          return 1;
                      else
                          return comp;
                  }
            
              };
        
        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        
        sorted.putAll(map);
        
        return sorted;
    }
    
    
    
    
    
    public static String readFileAsString(String fileName) throws Exception {
		String strData = "";
		String strFileName = "E:\\Windsor\\ACC\\Project\\Latest Project\\" + fileName;
	
		strData = new String(Files.readAllBytes(Paths.get(strFileName)));
		return strData;
	}

	//Extract words in the text file using StringTokenizer.
	//Insert extracted words into Ternary Search Trie (TST) using TST.java from 'references'
	
	
	
   
}