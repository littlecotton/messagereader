package messagereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Encoder {
	private String filename;
	private String plaintext;
	private String input;
	private PrintWriter writer = null;
	private List<String> text;
	
	public Encoder(String filename){
		try{
		writer = new PrintWriter(new File(filename));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			JFrame error = new JFrame();
			JLabel errors = new JLabel("file not found exception!");
			error.setVisible(true);
		}
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
			input+=input;
		}
		decrypt(input);
		input +=plaintext;
		encrypt(input);
		writer.write(input);
		writer.flush();
	}
	
	public String encrypt(String en){
		char letter = 'a';
		char keyword = 'g';
		for(int i=0; i<en.length();i++){
		if(en.charAt(i)==letter){
			en.replace(en.charAt(i), keyword);
	}
		}
		return en;
		
	}
	
	public String decrypt(String en){
		char letter = 'g';
		char keyword = 'a';
		for(int i=0; i<en.length();i++){
		if(en.charAt(i)==letter){
			en.replace(en.charAt(i), keyword);
	}
		}
		return en;
		
	}
	
	public List<String> read(){
		Scanner in = null;
		try{
		in = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		while(in.hasNext()){
			String input = in.nextLine();
			input+=input;
		}
		decrypt(input);
		List<String> text = null;
		text.add(input);
		return text;
	}
	
	
	
	
	
	
}
