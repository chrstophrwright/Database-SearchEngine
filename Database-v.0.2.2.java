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
	public HashMap<String, Content> database = new HashMap<String, Content>();
	private HashMap<int, String> index = new HashMap<int, String>();
		private HashMap<int, String> fieldIndex = new HashMap<int, String>();


//	private List<Content> database = new ArrayList<Content>();

	public newEntry(String entryname, String fieldName, <T> data){
		Content entrycontent = new Content();
		entrycontent.entryname = entryName;
		entrycontent.fieldData = 
	}

	public stringLookUp(String name){
		return database.get(name);
	}

	//allow iteration through 
	public numLookUp(int num){
		return database.get((index.get(num));
	}

	public numLookUpField(int num){
		return "(" + database.get((fieldIndex.get(num).value).toString() + "," + database.get((fieldIndex.get(num).entryName).toString() +")";
	}

	public numLookUpField(int num, String entryName){
		return database.get((fieldIndex.get(num).value);
	}

	public numLookUpField(int num,  <T> value = 0){
		return database.get((fieldIndex.get(num).entryName);
	}

	public class Content{
		private Lookup entryName;	// all data stored as strings
		private HashMap<String,<T>> fieldData = new HashMap<String,<T>>();

		public addNewField(String title, <T> data){
			content.put(title, new data);
		}

		// Assumes not trying to add data to a field that accepts different data
		public editField(String title, <T> new Data){

		}
	}

	private class Lookup{
		private int location;
		private String name;

		private newLookup(String name, int loc){
			this.name = name;
			this.location = loc;
		}

		private entryLocation(){
			return this.location;
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