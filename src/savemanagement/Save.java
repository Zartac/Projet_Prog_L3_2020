package savemanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe pour la lecture et l'écriture de sauvegarde.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Save {
	private static int numberTown = 0; // Nombre de ville dans la sauvegarde
	private static ArrayList<String> nameTown; // liste des noms de villes
	private static ArrayList<String> townRoad1; // liste des noms de villes qui ont une route
	private static ArrayList<String> townRoad2; // liste des noms de villes qui sont relié à townRoad1
	/* pour rappel townRoad1[i] sera relié à townRoad2[i]*/
	private static ArrayList<String> schoolLocation; // liste des noms de villes qui ont une école
	
	/**
	 * Affichage des invites de commandes utilisateurs pour charger une sauvegarde,
	 * si sauvegarde vide, on redemande à l'utilisateur à resaisir le chemin.
	 * @return object une File qui vraisemblablement n'est pas vide.
	 */
	public static File saveLoader(String path) // Fonction ABSOLUMENT pas testé! -- Jack
	{
		//TODO: prévoir l'éventualité ou la sauvegarde est videe ou inexistante
		File object = new File(path);
		return object;
	}
	
	public static ArrayList<String> convertFileToString(File save) // Fonction ABSOLUMENT pas testé! -- Jack
	{
		//TODO: coder une fonction qui converti chaque ligne du fichier en un ArrayList de String
		ArrayList<String> test = new ArrayList<String>();
		return test;
	}

}
