
package messagereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;



public class BackEnd {
	private String fn;
	private String plaintext;
	private List<String> inputs;
	private TreeMap<String, List<String>> myData;
	//private Scanner sc;
	private PrintWriter pw;
	private Encoder en;
	
	public BackEnd(String filename){
		fn = filename;
		try {
			pw = new PrintWriter(fn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		en = new Encoder(filename);
		myData = new TreeMap<String, List<String>>();
	}
	
	public List<String> getMessages(String username){
		return myData.get(username);
	}
	
	public void addMessage(String username, String msg){
		if(!(myData.containsKey(username))){
			myData.put(username, new ArrayList<String>());
		}
		List<String> current = myData.get(username);
		//System.out.println(msg);
		current.add(msg);
		myData.put(username, current);
		for(String x : myData.keySet()){
			en.write(x);
			for(String y : myData.get(x)){
				en.write("\t" + y);
			}
		}
	}
	public List<String> getUsers(){
		List<String> users = new ArrayList<String>();
		users.addAll(myData.keySet());
		return users;
	}
	
	

	
}

