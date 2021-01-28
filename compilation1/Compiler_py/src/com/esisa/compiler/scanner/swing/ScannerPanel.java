package com.esisa.compiler.scanner.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.esisa.compiler.scanner.Error;
import com.esisa.compiler.scanner.Scanner;
import com.esisa.compiler.scanner.Token;


public class ScannerPanel extends JPanel implements ActionListener
{
	private Scanner scanner;
	private JTextArea source;
	private DefaultTableModel tokens;
	private DefaultListModel<String> errors;
	private JFileChooser fileChooser;
	private String iconsFolder="sources/";
	private String items[]= {"New","Open","Save","Save as","Scan","-","Exit"};
	private String icons[]= {"New.png","Open.png","Save.png","Saveas.png","Scan.png","-","Exit.png"};
	public ScannerPanel(Scanner scanner)
	{ 
		this.scanner=scanner;
		setLayout(new BorderLayout());
		source = new JTextArea();
		source.setFont(new Font("Consolas", Font.BOLD, 14));
		source.setForeground(Color.blue);
		add("Center",new JScrollPane(source));
		//create modele
		tokens= new DefaultTableModel(new String[] { "Lexeme" , " Unite Lexicale"},0);
		JTable table = new JTable(tokens);
		table.setFont(new Font("Consolas", Font.PLAIN, 14));
		table.setForeground(Color.black);

		add("East",new JScrollPane(table));
		//create modele
		errors = new DefaultListModel<>();
		JList<String> list = new JList<>(errors);
		list.setFont(new Font("Consolas", Font.PLAIN, 14));
		list.setForeground(Color.red);
	
		add("South",new JScrollPane(list));
		createToolBar();
		fileChooser= new JFileChooser(".");



	}
	private void createToolBar()
	{
		JToolBar bar = new JToolBar();
		Cursor cursor= new Cursor(Cursor.HAND_CURSOR);
		bar.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		for (int i = 0; i < items.length; i++)
		{
			if( items[i].equals("-"))
			{
				bar.addSeparator();
			}
			else 
			{
				JButton b1= new JButton( new  ImageIcon(iconsFolder + icons[i]));
				b1.setToolTipText(items[i]); 
				b1.setName(items[i]);
				b1.addActionListener(this);
				b1.setBorder(null);
				b1.setCursor(cursor);
				bar.add(b1);
			}



		}
		add("North",bar);
	}
	public JMenuBar createMenu()
	{
		JMenuBar menuBar= new JMenuBar();
		JMenu menu = new JMenu("Fichier");
		menuBar.add(menu);
		for (int i = 0; i < items.length; i++) {
			if( items[i].equals("-"))
			{
				menu.addSeparator();
			}
			else
			{
				JMenuItem item = new JMenuItem(items[i],new  ImageIcon(iconsFolder + icons[i]));
				item.setName(items[i]);
				item.addActionListener(this);
				menu.add(item);
			}
		}
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JComponent src= (JComponent)e.getSource();
		if(src.getName().equals("Scan")) scan();
		if(src.getName().equals("Open")) open();
	//	if(src.getName().equals("Save")) save();
		//if(src.getName().equals("Saveas")) saveas();
		
	}



	private void printErrors(Vector<Error> errorList) 
	{
		errors.clear();
		if(errorList.size() ==0)
		{
			errors.addElement("Aucune  erreur");
		}
		else 
		{
			for (Error error : errorList) 
			{
				errors.addElement(error.getMessage());
			}
		}
		
		
	}
	private void printTokens(Vector<Token> tokenList) 
	{
		tokens.setRowCount(0);
		for (Token token : tokenList) 
		{
			tokens.addRow(new String [] { token.getValue(), token.getLexicalUnit()});
		}
	}
	/////////////////////Action//////////////////////
	public void scan()
	{
		scanner.scan(source.getText());
		printErrors(scanner.getErrorList());
		printTokens(scanner.getTokenList());
	}
	public void open()
	{
		int result = fileChooser.showOpenDialog(this);
		if( result == JFileChooser.APPROVE_OPTION)
		{
			File f = fileChooser.getSelectedFile();
			try {
				FileReader in = new FileReader(f);
				char t[] = new char	[(int)f.length()];
				in.read(t);
				in.close();
				source.setText(new String(t));
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Erreur : " + e.getMessage());
			}
		}
		
	}

}
