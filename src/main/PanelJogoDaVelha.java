package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelJogoDaVelha extends JPanel implements MouseListener{

	int w, h;
	
	Color vermelho = new Color(255,  13, 47);
	Color azul = new Color(107, 92, 255);
	Color verde  =  new Color(117, 255, 110);
	Color preto = new Color(0, 0, 0);
	
	int[][] casas = new int[3][3];
	/*
	 * [0][0] [1][0] [2][0]
	 * [0][1] [1][1] [2][1]
	 * [0][2] [1][2] [2][2]
	 */
	
	Font F = new Font("Serif", 40, 40);
	
	boolean turno; // O = false, X = true
	boolean vencedor;
	boolean acabou;
			
	public PanelJogoDaVelha(int w, int h) {
		super();
		addMouseListener(this);
		this.w = w;
		this.h = h;
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(verde);
		g.setFont(F);
		
		if(testarVitoria()) { // testa pra ver se alguem ganhou
			acabou = true;
			g.setColor(preto);
			
			if (vencedor) {
				g.drawString("X Venceu!", w/2 - 60, h/2);
			} else {
				g.drawString("O Venceu!", w/2 - 60, h/2);
			}
			
		} else { 
			
			boolean deuVelha = true;
			for (int i = 0; i < casas.length; i++) {
				for (int j = 0; j < casas[i].length; j++) {
					if (casas[i][j] == 0) {
						deuVelha = false;
					}
				}
			}
			
			if (deuVelha) {
				g.setColor(preto);
				g.drawString("Deu Velha!", w/2 - 70, h/2);
				acabou = true;
			}
			
			else {
				int casaY = 0;
				for (int i = 0; i < w; i += 200) {
					int casaX = 0;
		
					for (int j = 0; j < h; j += 200) {
						g.setColor(preto);
						g.drawRect(i, j, 200, 200); //desenha a grid
		
						switch (casas[casaX][casaY]) { // na array casas[][], 0 é uma casa em branco (não desenha nada)
						
							case 1: // 1 é uma casa com X
								g.setColor(azul);
								g.drawLine(i+10, j+10, i+190, j+190);
								g.drawLine(i+190, j+10, i+10, j+190);
								break;
								
							case 2: // 2  é uma cas com O
								g.setColor(vermelho);
								g.drawOval(i+10, j+10, 180, 180);
								break;
						}
		
						casaX++;
					}		
					casaY++;
				}
			}	
		}
		
		// Quando acabar fecha o programa após cinco segundos	
		if (acabou) {
			new FechadorPrograma(3);
			

		}
	}
	
	public boolean testarVitoria(){
		//pasa pela array procurando por linhas e colunas que tenham valores iguais, contanto que sejam diferentes de 0 (casa em branco)
		for (int i = 0; i < casas.length; i++) {
			if(casas[i][0] == casas[i][1] && casas[i][1] == casas[i][2] && casas[i][0] != 0){
				vencedor = !turno; // tem que ser !turno porque o turno troca antes de executar o teste, então quem ganhou não está no turno.
				return true;

			}
			
			if(casas[0][i] == casas[1][i] && casas[1][i] == casas[2][i] && casas[0][i] != 0){
				vencedor = !turno;
				return true;
			}
			
		}
		
		//testa as diagonais
		
		if (casas[0][0] == casas[1][1] && casas[1][1] == casas [2][2] & casas[0][0] != 0) {
			vencedor = !turno;
			return true;
		}
		
		if (casas[0][2] == casas[1][1] && casas[1][1] == casas [2][0] & casas[0][2] != 0) {
			vencedor = !turno;
			return true;
		}
		
		return false;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		int X = arg0.getX();
		int Y = arg0.getY();
		
		int sobreCasaX = 0;
		int sobreCasaY = 0;
		
		
		if (X > 400) {
			sobreCasaX = 2;
			
		} else if (X > 200) {
			sobreCasaX = 1;
		}
		
		if (Y > 400) {
			sobreCasaY = 2;
			
		} else if (Y > 200) {
			sobreCasaY = 1;
		}
		
		if (casas[sobreCasaY][sobreCasaX] == 0) {
			casas[sobreCasaY][sobreCasaX] = turno ? 1 : 2;
			turno = turno ? false : true;
		}	
		repaint();
		
	}

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	

}
