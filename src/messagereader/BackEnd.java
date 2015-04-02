
package messagereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;



public class BackEnd {
	private String filename;
	private String plaintext;
	private List<String> inputs;
	
	public BackEnd(String filename){
		
	}
	
	public void write(String plaintext){
		Scanner in = null;
		try{
		in = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		while(in.hasNext()){
			String input = in.nextLine();
			inputs.add(input);
			
		}
	}

	
}

