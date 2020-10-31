package main;

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
		String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K"
				,"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
		Display.displayLaunch();
		int choice1=Display.displayCreateTown();
		Town[] tab = Town.createTownLoop(choice1,alphabet);	
		Display.displayCreateLink(tab);
		Display.displayInterface2();
	}

}

