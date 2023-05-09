package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class parseData {

	
	public static void parse() {
	ArrayList<String> urls = new ArrayList<String>();
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=7352666011&bbn=6967215011&ref_=Oct_d_odnav_d_7352647011_0&pd_rd_w=MbqQ9&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=YX4RD5P28WGHK59G2FMM&pd_rd_wg=gtaYI&pd_rd_r=fbfd0a50-d73e-4598-a1d9-b1637c67c971");
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=7351127011&bbn=6967215011&ref_=Oct_d_odnav_d_7351255011_2&pd_rd_w=SyIbx&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=TXZPATGVPBZ9WBZTMK30&pd_rd_wg=8gkEY&pd_rd_r=e0a22264-a78b-4bca-b74d-5f4884bfc6e9");
   	
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=7351268011&bbn=6967215011&ref_=Oct_d_odnav_d_14255706011_2&pd_rd_w=Ouzl2&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=GDJA5QJ1898J9VD9431G&pd_rd_wg=YXGvo&pd_rd_r=7c187880-073f-4ff0-b377-f368d57cafb9");
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=7351134011&bbn=6967215011&ref_=Oct_d_odnav_d_7351094011_2&pd_rd_w=iYG87&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=4XNGDXT45APQW9N94S9K&pd_rd_wg=uHvO1&pd_rd_r=ff33318c-c140-4d2c-a7a7-a806cb5278bd");
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=14255182011&bbn=6967215011&ref_=Oct_d_odnav_d_7351094011_5&pd_rd_w=iYG87&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=4XNGDXT45APQW9N94S9K&pd_rd_wg=uHvO1&pd_rd_r=ff33318c-c140-4d2c-a7a7-a806cb5278bd");
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=7352647011&bbn=6967215011&ref_=Oct_d_odnav_d_7352635011_1&pd_rd_w=oCJRE&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=9XYBACET8ENTZXH06Q9M&pd_rd_wg=Bv9ES&pd_rd_r=e4127603-bce2-430d-8332-8ea14b0a6263");
   	
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=7351965011&bbn=6967215011&ref_=Oct_d_odnav_d_7351961011_0&pd_rd_w=Mnhr5&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=CHXK6PBND6TGX4ZN43V8&pd_rd_wg=5RfKm&pd_rd_r=cba6fe97-2990-404f-8aa9-a9389d397f9c");
   	 urls.add("https://www.amazon.ca/b/?_encoding=UTF8&node=7351260011&bbn=6967215011&ref_=Oct_d_odnav_d_7351259011_0&pd_rd_w=noN59&content-id=amzn1.sym.110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_p=110291c5-558c-4e37-9cc9-ac65b1ccefbc&pf_rd_r=HMK0B03GXWTR6AXYEYM0&pd_rd_wg=DB9PE&pd_rd_r=a8fe4e4f-dd5d-4b5f-8f5b-84e4506835c7");
   	 
   	 ArrayList<String> names = new ArrayList<String>();
   	 names.add("Bread");
   	 names.add("Milk");
   	 names.add("Chocolate");
   	 names.add("Tea");
   	 names.add("Drinks");
   	 names.add("Cookies");
   	 names.add("Oil");
   	 names.add("Cereal");
   	 System.out.println("**********************PARSING THE DATA FROM AMAZON.COM...*****************************");
   	 for(int i=0;i<urls.size();i++) {
   		
   		 parsing(urls.get(i),names.get(i));
   	 }
   	 
   	 System.out.println("Data files stored at C:\\W3C Web Pages\\rahul\\");
   	 System.out.println("**********************PARSING DONE*****************************");
   	 
	}
	
	
public static void parsing(String url,String name) {
    	
    	String data="";
    	
    	 try {
        	 Document page = Jsoup.connect(url).get();
        	 //System.out.println(page.outerHtml());
        	 
        	 
        	 String class_name="octopus-pc-item octopus-pc-item-v3";
             
             Elements bookElements = page.getElementsByClass(class_name);
             
             
             
             StringBuffer tmp = new StringBuffer(data);
             
             
             bookElements.forEach(element -> {
                 
                 String product_name = element.getElementsByClass("a-size-base a-color-base").text();
                 String price=element.getElementsByClass("a-price-whole").text();
                 String price_decimal=element.getElementsByClass("a-price-fraction").text();
                 
                 
                 String ratings=element.getElementsByClass("a-size-mini a-color-tertiary").text();
                 //System.out.println(product_name+"--"+price+"."+price_decimal +"  "+ratings);
                 
                
                 
                 tmp.append(product_name+" "+"::"+price+price_decimal +"#"+"\n");
                 
             });
             

data = tmp.toString();
             
             
//             String filelocation="C:\\W3C Web Pages\\rahul\\";
             String filelocation="E:\\ACC_Files\\";
             try {
        		 
    		
    		     BufferedWriter writerTxt = new BufferedWriter(new FileWriter(filelocation +name + ".txt"));
    		     writerTxt.write(data);
    		     writerTxt.close();	
    		    
    		 
    		 }catch(Exception ex) {
    			 
    		 }
             
            
             
             
             
        }
        catch(Exception e) {
        	System.out.println(e);
        }
       
    }
}
