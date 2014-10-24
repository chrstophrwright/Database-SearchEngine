/* Chris Wright on 10/20/2014
 * 
 * Defines the structure of a single entry into a database
 * for Professor Herman's Object Oriented class
 */

package SingleEntryClass;

//import java.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Database {
	public HashMap<String, String> database = new HashMap<String, Content>();
	private HashMap<int, String> valueIndex = new HashMap<int, String>();
	private HashMap<int, String> fieldIndex = new HashMap<int, String>();
	private static int location = 0 ;


	public void newContent(String name, <T> value){
		database.put(name, value);
		valueIndex.put(location, value);
		fieldIndex.put(location, value);
		location ++;
	}

	public String getField(String value){}

	public String getFieldIterable(int num){
		return database.get(fieldIndex.get(num));
	}


	public <T> getValue(String fieldName){ //String entry){
		return database.get(fieldName);
	}

	public <T> getValueIterable(int num){
		return database.get(valueIndex.get(num));
	}


	public String[] getAllContent(int num){
		public String[]] printList = new String[](database.size());
		Set entries = database.keySet();

	   	for (Iterator i = entries.iterator(); i.hasNext();){
	       	String entry = (String) i.next();
   		   	String value = (String) map.get(entry);
      		printList.add(entry + ", " + value.toString());
   		}
   		return printList
	}

}