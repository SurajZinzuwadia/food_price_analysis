package project;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class searchFood {

	
	public static void searchingFood(String user_input) {
	
      
      System.out.println("**********************PRODUCTS BASED ON YOUR SEARCH*****************************");
      
      search(user_input);
      
	}
	
	
	
public static void search(String word) {
    	
   
String correction = "";
		boolean wordExist;
		
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
			Inserting(word.substring(0, 1).toUpperCase()+word.substring(1));
		}
		else if (spellList.isEmpty() && !wordExist) {
			System.out.println("\nNot a valid word\n");
		} else if (spellList.isEmpty() && wordExist) {
			System.out.println("\nCannot find this word in the files\n");
		} else {
			System.out.println("\nDid you mean: " + correction + " Y or N ?\n");
			Scanner sc=new Scanner(System.in);
			String input=sc.nextLine();
			if(input.equalsIgnoreCase("y"))
			Inserting(correction);
			else
				System.out.println("No results found "+word);
				
		}
		
		
    }
public static void Inserting(String word) {
	
	File folder = new File("E:\\\\Windsor\\\\ACC\\\\Project\\\\Latest Project\\");
	File[] files = folder.listFiles();
	

	for (File file : files) {
		String fileName = file.getName();
		
		if(fileName.contains(word)) {
			
		
			

			parseDataFromFile(fileName,word);
		}
		
		
		
	}


}



public static String readFileAsString(String fileName) throws Exception {
	String strData = "";
	String strFileName = "E:\\\\Windsor\\\\ACC\\\\Project\\\\Latest Project\\" + fileName;

	strData = new String(Files.readAllBytes(Paths.get(strFileName)));
	return strData;
}


public static void parseDataFromFile(String path,String word) {
	File wholeFile = new File("E:\\\\Windsor\\\\ACC\\\\Project\\\\Latest Project\\" + path);
	
	HashMap<String, Float> keywordrank = new HashMap<String, Float>();
	
	try {
		if (wholeFile.isFile()) {
			String strFileText = readFileAsString(wholeFile.getName());
			
			StringTokenizer strTokenizer = new StringTokenizer(strFileText);
			

			while (strTokenizer.hasMoreTokens()) {
				
				
				String strToken = strTokenizer.nextToken("#"); 
				
				String[] result = strToken.split("::");
				if(result.length>1)
				keywordrank.put(result[0],Float.parseFloat(result[1]));
				
				//System.out.println(result[0]+result[1]);	
			}
		}
	} catch (Exception exception) {
		exception.printStackTrace();
	}

	
    int start=0;
    String cheap="";
    String costly="";
    
    HashMap<String, Float> hm1 = new HashMap<String, Float>();
    
    hm1 = sortByValue(keywordrank);
    
    
    for (Map.Entry<String, Float> en : hm1.entrySet()) {
        
    	
    	Pattern  p=Pattern.compile(word.toLowerCase());   
        //Regular expression  
        Matcher m=p.matcher(en.getKey().toString().toLowerCase());  
        if(m.find())  
        	{ 
        	start++;
        	if(start==1) {
        		cheap=en.getKey().toString()+" cost is "+en.getValue();
        	}
        		
			System.out.print(en.getKey() + ": ");
            System.out.println(en.getValue());
            costly=en.getKey().toString()+" cost is "+en.getValue();
		}
        
        
        
        
    }
    
    

    
    
    System.out.println("**********************Highest & Lowest Product Suggestions*****************************");
    System.out.println(cheap);
    System.out.println(costly);
    
    System.out.println("**********************Highest & Lowest Product Suggestions End*****************************\n\n ");
	
	
}



public static HashMap<String, Float> sortByValue(HashMap<String, Float> hm)
{
    // Create a list from elements of HashMap
    List<Map.Entry<String, Float> > list =
           new LinkedList<Map.Entry<String, Float> >(hm.entrySet());

    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<String, Float> >() {
        public int compare(Map.Entry<String, Float> o1,
                           Map.Entry<String, Float> o2)
        {
            return (o2.getValue()).compareTo(o1.getValue());
        }
    });
     
    // put data from sorted list to hashmap
    HashMap<String, Float> temp = new LinkedHashMap<String, Float>();
    for (Map.Entry<String, Float> aa : list) {
        temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
}








}
