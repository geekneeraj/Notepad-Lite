	import java.util.*;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.io.*;

public class Notepad extends JFrame implements ActionListener, WindowListener
{
	MenuBar _menuBar = new MenuBar();

	Menu menuBar_file= new Menu("File");
	Menu menuBar_help = new Menu("Help");

	MenuItem file_newFile= new MenuItem("New File");
	MenuItem file_open=new MenuItem("Open");
	MenuItem file_save=new MenuItem("Save");
	MenuItem file_saveAs=new MenuItem("Save As");
	MenuItem file_exit =new MenuItem("Exit");

	MenuItem help_contact= new MenuItem("Contact");
	MenuItem help_about=new MenuItem("Help");

	TextArea frame_textArea=new TextArea(7,4);

	Font font =new Font("Times New Roman",0,16);

	JPanel p1 = new JPanel();

	public Notepad()
	{
		setTitle("Notepad Lite");
		setVisible(true);
		setSize(600,400);

		menuBar_file.add(file_newFile);
		menuBar_file.add(file_open);
		menuBar_file.add(file_save);
		menuBar_file.add(file_saveAs);
		menuBar_file.addSeparator();
		menuBar_file.add(file_exit);
		file_newFile.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_saveAs.addActionListener(this);
		file_exit.addActionListener(this);

		menuBar_help.add(help_contact);
		menuBar_help.add(help_about);
		help_contact.addActionListener(this);
		help_about.addActionListener(this);

		_menuBar.add(menuBar_file);
		_menuBar.add(menuBar_help);

		setMenuBar(_menuBar);
		frame_textArea.setFont(font);

		Container cont=getContentPane();
		cont.add(frame_textArea);

		addWindowListener(this);



	}

		public void windowClosing(WindowEvent we)
		{
						System.exit(0);
		}

		public void windowIconified(WindowEvent we){}
		public void windowDeiconified(WindowEvent we){}
		public void windowClosed(WindowEvent we){}
		public void windowDeactivated(WindowEvent we){}
		public void windowActivated(WindowEvent we){}
		public void windowOpened(WindowEvent we){}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		frame_textArea.setBackground(Color.WHITE);
		frame_textArea.setForeground(Color.BLACK);
		frame_textArea.setEditable(true);

		FileDialog fpOpen = new FileDialog(this,"Open",FileDialog.LOAD);
		FileDialog fpSave = new FileDialog(this,"Save",FileDialog.SAVE);

		if(e.getSource()==file_saveAs)
		{
			fpOpen.setVisible(true);

			try
			{
				RandomAccessFile rAf= new RandomAccessFile(fpSave.getDirectory()+fpSave.getFile()+".txt","rw");
				rAf.seek(rAf.length());
				String msg=frame_textArea.getText();
				rAf.writeBytes(msg);
				rAf.close();
			}
			catch(Exception rt)
			{
				System.out.println(rt);
			}



		}




	}


	public static void main(String[] args) 
	{
		Notepad np=new Notepad();
	}






}