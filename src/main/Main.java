package main;

import java.io.IOException;

import agglomeration.Town;
import menu.Display;
import savemanagement.Save;

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
		/*String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K"
				,"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" };
		Display.displayLaunch();
		int choice1=Display.displayCreateTown();
		Town[] villeTab = Town.createTownLoop(choice1,alphabet);	
		Display.displayCreateLink(villeTab);
		Display.displaySchool(villeTab);*/
		try {
			Save.saveLoader(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

