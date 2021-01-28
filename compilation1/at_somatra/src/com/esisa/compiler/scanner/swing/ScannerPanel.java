package com.esisa.compiler.scanner.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.esisa.compiler.scanner.Error;
import com.esisa.compiler.scanner.Scanner;
import com.esisa.compiler.scanner.Token;

public class ScannerPanel extends JPanel implements ActionListener{
	private Scanner scanner;
	private JTextArea source;
	private DefaultTableModel tokens;
	private DefaultListModel<String> errors;
	private JFileChooser fileChooser;
	private String items[]= {"nouveau","Ouvrir","enregistrer","enregistrer sous","analyser","-","Quitter"};
	private String icons[]= {"new.png","open.png","save.png","save.png","scan.png","-","exit.png"};
	private String iconsfolder="ressources/toolbar/";
	public ScannerPanel(Scanner scanner) {
		// TODO Auto-generated constructor stub
		this.scanner=scanner;
		setLayout(new BorderLayout());
		source=new JTextArea();
		source.setFont(new Font("Consolas", Font.PLAIN,20 ));
		source.setForeground(Color.blue);
		add("Center",new JScrollPane(source));
		tokens= new DefaultTableModel(new String[] {"lexème","unité lexicale"}, 0);
		JTable table=new JTable(tokens);
		add("East",new JScrollPane(table));
		errors=new DefaultListModel<>();
		JList<String> list=new JList<>(errors);
		add("South",new JScrollPane(list));


		CreateToolBar();
		fileChooser=new JFileChooser(".");
	}

	public void printtokens(Vector<Token> t)
	{
		tokens.setRowCount(0);
		for (Token token : t) {
			tokens.addRow(new String[] {token.getValue(),token.getLexicalUnit()});
		}
	}

	public void printErrors(Vector<Error> e)
	{
		errors.clear();
		if(e.size()==0) {
			errors.addElement("Aucune erreur Lexical.");
		}
		else
		{
			for (Error error : e) {
				errors.addElement(error.getMessage());
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton src=(JButton)e.getSource();
		if(src.getName().equals("analyser")) scan();
		if(src.getName().equals("Ouvrir")) open();
		if(src.getName().equals("enregistrer sous")) save();

	}
	public void save() {
		try {
			Vector<Token> vt= scanner.getTokenlist();
			Vector<String> v1= new Vector<>();
			v1.add("Mail");
			v1.add("nb");
			FileWriter out=null;
			for (String s : v1) {
				 out = new FileWriter("ressources/"+s+".txt");
					JOptionPane.showMessageDialog(this,"ressources/"+s+".txt" );
				for (Token tok : vt) {
					if(tok.getLexicalUnit().equals(s))
					{
						out.write(tok.getValue()+"\n");
					}
				}
				out.close();
			}
			
			
		} 
		catch (Exception e) {
			System.out.println("erreuri :"+e.getMessage());
		}
	}
	public JMenuBar createMenu() {
		JMenuBar menubar=new JMenuBar();
		JMenu menu=new JMenu("Fichier");
		menubar.add(menu);
		for (int i = 0; i < icons.length; i++) {
			if(items[i].equals("-"))
			{
				menu.addSeparator();
			}
			else 
			{
				JMenuItem item=new JMenuItem(items[i],new ImageIcon(iconsfolder + icons[i]));
				item.setName(items[i]);
				item.addActionListener(this);
				menu.add(item);	
			}


		}
		return menubar;
	}
	private void CreateToolBar() {
		Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
		JToolBar bar=new JToolBar();
		bar.setLayout(new FlowLayout(FlowLayout.LEFT,5,2));
		for (int i = 0; i < items.length; i++) {
			if(items[i].equals("-"))
			{
				bar.addSeparator();
			}
			else {
				JButton b1 = new JButton(new ImageIcon(iconsfolder + icons[i]));
				b1.setToolTipText(items[i]);
				b1.setName(items[i]);
				b1.addActionListener(this);
				b1.setBorder(null);
				b1.setCursor(cursor);
				bar.add(b1);
			}

		}
		/*
		JButton b1=new JButton("Scan");
		b1.setName("Scan");
		b1.addActionListener(this);
		bar.add(b1);
		 */
		add("North",bar);
	}

	//////-----------------actions: ------------------------------------------------------------------------
	public void scan() {
		scanner.scan(source.getText());
		printErrors(scanner.getErrorList());
		printtokens(scanner.getTokenlist());
	}
	public void open() {
		int result=fileChooser.showOpenDialog(this);
		if(result==fileChooser.APPROVE_OPTION)
		{
			File f = fileChooser.getSelectedFile();
			try {
				FileReader in=new FileReader(f);
				char t[]=new char[(int)f.length()];
				in.read(t);
				in.close();
				source.setText(new String(t));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("erreur  :  "+ e.getMessage());
			}
		}

	}
}
