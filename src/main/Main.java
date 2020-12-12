package main;

import java.io.IOException;
import java.util.ArrayList;

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
		if (args.length == 0) // Aucun argument, on lance le 1er rendu du projet.
		{
			ArrayList<String>alphabet = Display.createAlphabet();
			Display.displayLaunch();
			int choice1=Display.displayCreateTown();
			Town[] villeTab = Town.createTownLoop(choice1,alphabet);	
			Display.displayCreateLink(villeTab);
			Display.displaySchool(villeTab);
		}
		else if (args.length != 0) // Argument détecté, on lance le 2ème rendu du projet.
		{
			//if(args[0].contains("nyancat")) nyan();
			Display.displayLaunch();
			System.out.println("==>Lecture du fichier de sauvegarde :");
			try {
				Save.saveLoader(args[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Town[] villeTab = Town.createTownLoop(Save.getNbTown(), Save.getNameTown());
		}
	}

}

