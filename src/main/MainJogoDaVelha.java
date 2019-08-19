package main;

import javax.swing.JFrame;

public class MainJogoDaVelha {

	public static void main(String[] args) {
		int w = 600;
		int h = 600;
		
		PanelJogoDaVelha p = new PanelJogoDaVelha(w, h);
		JFrame f = new JFrame();
		
		f.add(p);
		f.setSize(w+10,h+40);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		p.setFocusable(true);
		p.requestFocus();
		
	}
}
