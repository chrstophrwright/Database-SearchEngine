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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*      HashMap hm = new HashMap();
      // Put elements to the map
      hm.put("Zara", new Double(3434.34));*/

public class Database {
	HashMap<String, Content> database = new HashMap<String, Content>();
//	private List<Content> database = new ArrayList<Content>();

	public class Content{
		private String entryName;	// all data stored as strings
		private HashMap<String,<T>> content = new HashMap<String,<T>>();

		public addNewField(String title, <T> data, int loc){
			// FieldData field = new FieldData(String title, <T> data);
			this.title = title;
			this.content.add(newField(title, data));
			this.location = loc;
		}
	}

	private class FieldData{
		public String title;
		public <T> data;

		public void newField(String title, <T> data){
			this.title = title;
			this.data = data;
		}

		public <T> getFieldInfo(){
			return this.data;
		}
	}

	public void newEntry(String title){
		Content entry = new Content();
		entry.title = title;
		entry.location = nextAvailable;
		database.add(entry);
		database.nextAvailable ++;
	}

	public <T> getEntry(Database database, int lookup){ //String entry){
		return database.get(lookup);
	}

	public void deleteEntry(Database database, String entry){
		database.get(entry) = 
	}
	public void edit entry(Database database, String entry){}

	/* 	Add
		Delete
		Return
		Edit
		*	Support for search by field
	*/

}


/*
	* HashMap works on principle of hashing, we have put(key, value)get(key) 
	* HashMap implementation calls hashCode method on Key object,
		 and applies returned hashcode into its own hashing function
		 to find a bucket location for storing Entry object 
	* Java  HashMap stores both key and value object as Map.Entry in the bucket
	* 
	* To Support
	* (EntryName:(Field:Data))
	* (EntryName:(Data:Field))
	* (Field:(Data:EntryName))
	* (Field:(EntryName:Data))
	* (Data:(Field:EntryName))
	* (DataL(EntryName:Field))
*/