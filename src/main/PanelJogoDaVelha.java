package main;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelJogoDaVelha extends JPanel implements MouseListener{

	int w, h;
	int[][] casas = new int[3][3];

	
			
	public PanelJogoDaVelha(int w, int h) {
		super();
		addMouseListener(this);
		this.w = w;
		this.h = h;
		casas[0][0] = 1;
		casas[2][2] = 2;
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int casaX = 0;
		int casaY = 0;
		for (int i = 0; i < w; i += 200) {
			casaX = 0;
			for (int j = 0; j < h; j += 200) {
				g.drawRect(i, j, 200, 200);
				switch (casas[casaX][casaY]) {
					case 1:
						g.drawLine(i+10, j+10, i+190, j+190);
						g.drawLine(i+190, j+10, i+10, j+190);
						break;
						
					case 2:
						g.drawOval(i+10, j+10, 180, 180);
						break;
				}
				
				casaX++;
			}
			casaY++;
		}
		
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int sobreCasaX = w/arg0.getX();
		int sobreCasaY = h/arg0.getY();
		
		casas[sobreCasaX-1][sobreCasaY-1] = 1;
		
		
		
		repaint();
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
