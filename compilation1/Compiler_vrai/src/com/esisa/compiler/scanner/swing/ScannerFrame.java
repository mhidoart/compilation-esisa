package com.esisa.compiler.scanner.swing;

import javax.swing.JFrame;

import com.esisa.compiler.scanner.Scanner;

public class ScannerFrame extends JFrame
{
	public ScannerFrame()
	{
		Scanner scanner= new Scanner();
		ScannerPanel panel = new ScannerPanel(scanner);
		
		setContentPane(panel);
		setJMenuBar(panel.createMenu());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	public static void main(String[] args) 
	{
		new ScannerFrame();
	}
}
