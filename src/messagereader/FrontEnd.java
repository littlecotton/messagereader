package messagereader;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrontEnd {
	private JFrame newFrame;
	private JFrame myFrame;
	private JButton addNew;
	private JButton getAll;
	private JButton add;
	private String fileName;
	
	
	public FrontEnd()
	{
		if (fileName == null){
			JFileChooser chooser = new JFileChooser("../");
		int x = chooser.showSaveDialog(myFrame);
		if (x == JFileChooser.APPROVE_OPTION)
			fileName = chooser.getSelectedFile().getName();
		}
		newFrame = new JFrame("Message Reader");
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newFrame.setLocation(350,250);
		newFrame.setPreferredSize(new Dimension(600, 400));
		
		myFrame = new JFrame("Message Reader");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(350,250);
		myFrame.setPreferredSize(new Dimension(600, 400));
		addNew = new JButton("Add New Message");
		add = new JButton("Add Message");
		getAll = new JButton("Get All Messages By A User");
		
		Box mBox = Box.createHorizontalBox();
		Box lBox = Box.createVerticalBox();
		Box rBox = Box.createVerticalBox();
		JTextArea newMsg = new JTextArea();
		JTextField user = new JTextField();
		
		mBox.add(Box.createHorizontalStrut(80));
		mBox.add(lBox);
		mBox.add(Box.createHorizontalStrut(100));
		mBox.add(rBox);
		mBox.add(Box.createHorizontalStrut(80));
		
		
		
		lBox.add(addNew);
		
		Box nBox = Box.createHorizontalBox();
		Box jBox = Box.createVerticalBox();
		Box kBox = Box.createVerticalBox();
		//JScrollPane scrollPane = new JScrollPane(user);
		//scrollPane.setPreferredSize(new Dimension(200, 30));
		//scrollPane.setMaximumSize(new Dimension(200,30));
		
		nBox.add(jBox);
		jBox.setPreferredSize(new Dimension(200, 400));
		jBox.setMaximumSize(new Dimension(200,400));
		nBox.add(kBox);
		newFrame.add(nBox);
		
		jBox.add(Box.createVerticalStrut(160));
		jBox.add(add);
		jBox.add(user);
		user.setPreferredSize(new Dimension(300, 30));
		user.setMaximumSize(new Dimension(300,30));
		user.setText("Username");
		kBox.add(newMsg);
		newMsg.setText("Enter Message");
		newMsg.setLineWrap(true);
		
		BackEnd b = new BackEnd(fileName);
		
		add.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String name = user.getText();
				String message = newMsg.getText();
				b.addMessage(name, message);
			}});
		
		addNew.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				myFrame.setVisible(false);
				
				newFrame.pack();
				newFrame.setVisible(true);
				
				
			}});
		
		
		rBox.add(getAll);
		getAll.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				
			}});
		
		
		
		
		
		
		
		
		
		myFrame.add(mBox);
		myFrame.pack();
		myFrame.setVisible(true);
		
	}
	
}
