package com.esisa.compiler.scanner.swing;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.esisa.compiler.scanner.Scanner;

public class ScannerFrame extends JFrame{
	public ScannerFrame() {
		// TODO Auto-generated constructor stub
		Scanner scanner=new Scanner();
		ScannerPanel panel=new ScannerPanel(scanner);
		setContentPane(panel);
		setJMenuBar(panel.createMenu());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ScannerFrame();
	}

}
