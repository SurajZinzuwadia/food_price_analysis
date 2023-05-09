package project;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class countFrequency {

	public static String readFileAsString(String fileName) throws Exception {
			String strData = "";
			String strFileName = "E:\\\\Windsor\\\\ACC\\\\Project\\\\Latest Project\\" + fileName;
		
			strData = new String(Files.readAllBytes(Paths.get(strFileName)));
			return strData;
		}
	
public static void count(String word) {
		
		System.out.println("**********************PAGE RANKING*****************************");
		
		int frequency=0;
		File folder = new File("E:\\\\Windsor\\\\ACC\\\\Project\\\\Latest Project\\");
		File[] files = folder.listFiles();
		
		 HashMap<String, Integer> hm = new HashMap<String, Integer>();
		 
		for (File file : files) {
			String fileName = file.getName();
			
			if(fileName.contains("EnglishWords.txt"))
				continue;
			
			
			
			File wholeFile = new File("E:\\\\Windsor\\\\ACC\\\\Project\\\\Latest Project\\" + fileName);
			
			TST<Integer> objTST = new TST<Integer>();
			
			TreeMap<String, Float> keywordrank = new TreeMap<String, Float>();
			
			try {
				if (wholeFile.isFile()) {
					String strFileText = readFileAsString(wholeFile.getName());
					
					StringTokenizer strTokenizer = new StringTokenizer(strFileText);
					

					while (strTokenizer.hasMoreTokens()) {
						//remove special characters
						
						String strToken = strTokenizer.nextToken("#"); 
						
						String[] result = strToken.split("::");
						if(result.length>1)
						keywordrank.put(result[0],Float.parseFloat(result[1]));
						
						//System.out.println(result[0]+result[1]);
						
						 if(result[0].toLowerCase().contains(word.toLowerCase()))  
			            	{ 
			    			
			            	//System.out.println(mp.getKey().toString()+ "   "+frequency);
			                frequency++;
			    		}
						
						
						
					}
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			
			

			
	        
	        
	        hm.put(fileName, frequency);
			
	        frequency=0;
	        
	  
	        // Display elements
	       
	
			
			
			
			
		}
		Map<String, Integer> hm1 = sortByValue(hm);
		 for (Map.Entry<String, Integer> en : hm1.entrySet()) {
	            
	            
	            System.out.println("Total number of occurence of the word "+word+" in "+en.getKey()+" is "+en.getValue());
	        }
		 
		 System.out.println("");
		 System.out.println("");
		
	}


public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
{
    // Create a list from elements of HashMap
    List<Map.Entry<String, Integer> > list =
           new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

    // Sort the list
    Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
        public int compare(Map.Entry<String, Integer> o1,
                           Map.Entry<String, Integer> o2)
        {
            return (o2.getValue()).compareTo(o1.getValue());
        }
    });
     
    // put data from sorted list to hashmap
    HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
    for (Map.Entry<String, Integer> aa : list) {
        temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
}

    
}
