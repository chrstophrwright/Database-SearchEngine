/* Chris Wright on 10/20/2014
 * 
 * Defines the structure of a single entry into a database
 * for Professor Herman's Object Oriented class
 * 
 * "    The hidden Database class does not have multiple objects: 
 * there is only one storage area. How can this kind of class be implemented in Java? 
 * The simplest answer is to use class variables and methods, that is, 
 * use static to define the variables and methods for Database members. 
 * Later, we might decide to also have multiple objects associated with the Database; 
 * for example, if multiple users need to concurrently access the storage area, 
 * then each might have its own object to communicate with the database. 
 * Initially, we can just use static for implementing all the database functionality."
 * */

package SingleEntryClass;

//import java.util;
import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

public class SingleEntryClass {
	private String entryContent;	// all data stored as strings
	private int pageNum;
	private int lineNum;
	private List<String> tags = new ArrayList<String>();

	public void setContent(String content){
		this.entryContent = content;
	}
	public String getContent(){
		return this.entryContent;
	}
	
	public void setTag(String newTag){
		this.tags.add(newTag);
	}
	public String getTags(){
		String printTagList = "[";
		for (int i=0;i<=this.tags.size(); i++){
			if (i<this.tags.size()){ printTagList += tags.get(i) + ", ";}
			else{ printTagList += tags.get(i) + "]";}
		}
		return printTagList;
	}
	
	public void setPageNum(int pgNum){
		this.pageNum = pgNum;
	}
	public int getPageNum(){
		return this.pageNum;
	}
	
	public void setLineNum(int lnNum){
		this.lineNum = lnNum;

	}
	public int getLineNum(){		
		return this.lineNum;
	}
	
}
