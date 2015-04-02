package messagereader;

import java.io.File;
import java.io.FileNotFoundException;

import com.sun.java_cup.internal.runtime.Scanner;

public class BackEnd {
	private String filename;
	private String plaintext;
	
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
		
	}

	
}
