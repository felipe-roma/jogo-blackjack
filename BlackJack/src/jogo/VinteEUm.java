package jogo;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class VinteEUm {

	public static void main(String[] args) {
		
		int fichas=100,aposta=0,jogador=0,croupier=0,valor=0,comprar=0,i=0,r=0,a=0;
		String lista1="",lista2="",c="",v="";
		
		ArrayList<String> carta = new ArrayList<String>();
		carta.add("A Paus");
		carta.add("A Copas");
		carta.add("A Espadas");
		carta.add("A Ouros");
		carta.add("2 Paus");
		carta.add("2 Copas");
		carta.add("2 Espadas");
		carta.add("2 Ouros");
		carta.add("3 Paus");
		carta.add("3 Copas");
		carta.add("3 Espadas");
		carta.add("3 Ouros");
		carta.add("4 Paus");
		carta.add("4 Copas");
		carta.add("4 Espadas");
		carta.add("4 Ouros");
		carta.add("5 Paus");
		carta.add("5 Copas");
		carta.add("5 Espadas");
		carta.add("5 Ouros");
		carta.add("6 Paus");
		carta.add("6 Copas");
		carta.add("6 Espadas");
		carta.add("6 Ouros");
		carta.add("7 Paus");
		carta.add("7 Copas");
		carta.add("7 Espadas");
		carta.add("7 Ouros");
		carta.add("8 Paus");
		carta.add("8 Copas");
		carta.add("8 Espadas");
		carta.add("8 Ouros");
		carta.add("9 Paus");
		carta.add("9 Copas");
		carta.add("9 Espadas");
		carta.add("9 Ouros");
		carta.add("10 Paus");
		carta.add("10 Copas");
		carta.add("10 Espadas");
		carta.add("10 Ouros");
		carta.add("J Paus");
		carta.add("J Copas");
		carta.add("J Espadas");
		carta.add("J Ouros");
		carta.add("Q Paus");
		carta.add("Q Copas");
		carta.add("Q Espadas");
		carta.add("Q Ouros");
		carta.add("K Paus");
		carta.add("K Copas");
		carta.add("K Espadas");
		carta.add("K Ouros");
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao BLACKJACK!\n\n\nReceba o dobro de suas apostas.\n\nAposta mínima: 10 fichas.\n\n\n...");
		JOptionPane.showMessageDialog(null, "...\n\n\nBom Jogo!\n\n\n>>>");
		
		do {
			boolean apto = true;
			JOptionPane.showMessageDialog(null, "Você tem " + fichas + " fichas.");
			aposta = Integer.parseInt(JOptionPane.showInputDialog("Quantas fichas deseja apostar?\n\n\n10          20          50          100\n\n\n0 - Sair "));
			
			switch (aposta) {
			case 0:
				System.exit(0);
			break;
			case 10:
				aposta = 10;
			break;
			case 20:
				aposta = 20;
			break;
			case 50:
				aposta = 50;
			break;
			case 100:
				aposta = 100;
			break;
			default:
				JOptionPane.showMessageDialog(null, "Aposta Inválida.");
				apto = false;
			break;
			}
			
			if (fichas >= aposta && apto == true) {
				do {		
					fichas -= aposta;
					JOptionPane.showMessageDialog(null, "- " + aposta + " fichas\n\nVocê tem " + fichas + " fichas.");
					
					Collections.shuffle(carta);
					
					boolean ace = true;
					if (ace == true) {
						a = 11;
					} else {
						a = 1;
					}
					
					for (i = 0; i < 4; i++) {
						c = (carta.get(i));
						v = (carta.get(i).substring(0,1));
						
						if (v.equalsIgnoreCase("A")) {
							valor=a;
						} else if (v.equalsIgnoreCase("2")) {
							valor=2;
						} else if (v.equalsIgnoreCase("3")) {
							valor=3;
						} else if (v.equalsIgnoreCase("4")) {
							valor=4;
						} else if (v.equalsIgnoreCase("5")) {
							valor=5;
						} else if (v.equalsIgnoreCase("6")) {
							valor=6;
						} else if (v.equalsIgnoreCase("7")) {
							valor=7;
						} else if (v.equalsIgnoreCase("8")) {
							valor=8;
						} else if (v.equalsIgnoreCase("9")) {
							valor=9;
						} else {
							valor=10;
						}
						
						if (i<2) {
							lista1 += c+"          ";
							jogador += valor;
						} else if (i<4) {
							lista2 += c+"          ";
							croupier += valor;
						}
					}
					
					JOptionPane.showMessageDialog(null, "Você: " + jogador + "\n\n" + lista1 + "\n\n-----------------------------------------------------------------------------------------------------\n\nCroupier: \n\n" + carta.get(2) + "                    ?         ");
					
					if (jogador == 21 && croupier == 21) {
						JOptionPane.showMessageDialog(null, "Empate.");
						fichas += aposta;
						JOptionPane.showMessageDialog(null, "+ " + aposta + " fichas\n\nVocê tem " + fichas + " fichas.");
					} else if (jogador == 21 && croupier < 21) {
						JOptionPane.showMessageDialog(null, "BLACKJACK!");
						fichas += (aposta*2);
						JOptionPane.showMessageDialog(null, "+ " + (aposta*2) + " fichas\n\nVocê tem " + fichas + " fichas.");						
					} else if (croupier == 21 && jogador < 21) {
						JOptionPane.showMessageDialog(null, "Você: " + jogador + "\n\n" + lista1 + "\n\n-----------------------------------------------------------------------------------------------------\n\nCroupier: " + croupier + "\n\n" + lista2);
						JOptionPane.showMessageDialog(null, "Você Perdeu.");
					} else if (jogador == 22 && croupier == 22) {
						jogador = 13;
						croupier = 13;
						ace = false;
					} else if (jogador == 22) {
						jogador = 13;
						ace = false;
					} else if (croupier == 22) {
						croupier = 13;
						ace = false;
					} else {
						comprar = JOptionPane.showConfirmDialog(null, "Deseja comprar mais uma carta?", "Continuar jogador", JOptionPane.YES_NO_OPTION);
						if (comprar == 0) {
							do {
								i++;
								c = (carta.get(i));
								v = (carta.get(i).substring(0,1));
								
								if (v.equalsIgnoreCase("A")) {
									valor=a;
								} else if (v.equalsIgnoreCase("2")) {
									valor=2;
								} else if (v.equalsIgnoreCase("3")) {
									valor=3;
								} else if (v.equalsIgnoreCase("4")) {
									valor=4;
								} else if (v.equalsIgnoreCase("5")) {
									valor=5;
								} else if (v.equalsIgnoreCase("6")) {
									valor=6;
								} else if (v.equalsIgnoreCase("7")) {
									valor=7;
								} else if (v.equalsIgnoreCase("8")) {
									valor=8;
								} else if (v.equalsIgnoreCase("9")) {
									valor=9;
								} else {
									valor=10;
								}
								
								lista1 += c+"          " ;
								jogador += valor;
								
								if (valor==11 && jogador > 21) {
									jogador -= 10;
									ace = false;
								}
								
								if (jogador >= 21) {
									comprar = 1;
								} else {
									JOptionPane.showMessageDialog(null, "Você: " + jogador + "\n\n" + lista1 + "\n\n-----------------------------------------------------------------------------------------------------\n\nCroupier: \n\n" + carta.get(2) + "                    ?         ");
									comprar = JOptionPane.showConfirmDialog(null, "Deseja comprar mais uma carta?", "Continuar jogador", JOptionPane.YES_NO_OPTION);
								}
							} while (comprar==0);
						}
						
						if (jogador > 21) {
							JOptionPane.showMessageDialog(null, "Você: " + jogador + "\n\n" + lista1 + "\n\n-----------------------------------------------------------------------------------------------------\n\nCroupier: " + croupier + "\n\n" + lista2);
							JOptionPane.showMessageDialog(null, "Você Perdeu.");							
						} else if (croupier <= 16) {
							ace = true;
							JOptionPane.showMessageDialog(null, "Você: " + jogador + "\n\n" + lista1 + "\n\n-----------------------------------------------------------------------------------------------------\n\nCroupier: " + croupier + "\n\n" + lista2);
							do {
								i++;
								c = (carta.get(i));
								v = (carta.get(i).substring(0,1));
								
								if (v.equalsIgnoreCase("A")) {
									valor=a;
								} else if (v.equalsIgnoreCase("2")) {
									valor=2;
								} else if (v.equalsIgnoreCase("3")) {
									valor=3;
								} else if (v.equalsIgnoreCase("4")) {
									valor=4;
								} else if (v.equalsIgnoreCase("5")) {
									valor=5;
								} else if (v.equalsIgnoreCase("6")) {
									valor=6;
								} else if (v.equalsIgnoreCase("7")) {
									valor=7;
								} else if (v.equalsIgnoreCase("8")) {
									valor=8;
								} else if (v.equalsIgnoreCase("9")) {
									valor=9;
								} else {
									valor=10;
								}
							
								lista2 += c+"          ";
								croupier += valor;
								
								if (valor==11 && croupier > 21) {
									croupier -= 10;
									ace = false;
								}
								
								JOptionPane.showMessageDialog(null, "Você: " + jogador + "\n\n" + lista1 + "\n\n--------------------------------------------------------------------------------\n\nCroupier: " + croupier + "\n\n" + lista2);
							} while (croupier <= 16 );
							
							if (croupier > 21) {
								JOptionPane.showMessageDialog(null, "Você Venceu!");
								fichas += (aposta*2);
								JOptionPane.showMessageDialog(null, "+ " + (aposta*2) + " fichas\n\nVocê tem " + fichas + " fichas.");								
							} 					
						} else {
							JOptionPane.showMessageDialog(null, "Você: " + jogador + "\n\n" + lista1 + "\n\n--------------------------------------------------------------------------------\n\nCroupier: " + croupier + "\n\n" + lista2);
						}
						
						if (jogador == croupier) {
							JOptionPane.showMessageDialog(null, "Empate.");
							fichas += aposta;
							JOptionPane.showMessageDialog(null, "+ " + aposta + " fichas\n\nVocê tem " + fichas + " fichas.");							
						} else if (jogador > croupier && jogador <= 21) {
							JOptionPane.showMessageDialog(null, "Você Venceu!");
							fichas += (aposta*2);
							JOptionPane.showMessageDialog(null, "+ " + (aposta*2) + " fichas\n\nVocê tem " + fichas + " fichas.");							
						} else if (croupier > jogador && croupier <= 21) {
							JOptionPane.showMessageDialog(null, "Você Perdeu.");							
						}
					}
					
					jogador=0;
					croupier=0;
					i=0;
					lista1="";
					lista2="";
					
					if (fichas >= aposta) {
						r = JOptionPane.showConfirmDialog(null, "Repetir aposta anterior?", "", JOptionPane.YES_NO_OPTION);
					} else {
						r=1;
					}				
				} while (r == 0);
			} else {
				apto = true;
			}
		} while (fichas > 0);
		JOptionPane.showMessageDialog(null, "...\n\n\nObrigado, foi bom jogar com você!\n\n\n\n\nFeito por: Felipe Roma");
	}

}