package main;

import java.util.Arrays;
import java.util.Scanner;
import town.Town;
import menu.Display;

/**
 * Classe principale pour le lancement de l'application.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Main {
	public static void main(String[]args)
	{
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K'
				,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		Display.displayLaunch();
		int choice1=Display.displayCreateTown();
		Town[] tab = new Town[choice1]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(alphabet[i]); // On crée autant de ville que l'utilsateur a choisi
			System.out.println(tab[i].getSerial() + ". La ville " + tab[i].getName() + " a été crée.");
		}
		Display.displayCreateLink(tab);
		Display.displayInterface2();
		//test
	}

}

