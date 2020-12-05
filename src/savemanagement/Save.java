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
	public static File saveLoader() // Fonction ABSOLUMENT pas testé! -- Jack
	{
		File object;
		String fileLocation;
		Boolean correct = false;
		do { // On demande à l'utilisateur de taper le chemin vers sa sauvegarde
			Scanner sc = new Scanner(System.in);
			System.out.println("==>Veuillez entrer le chemin vers votre sauvegarde :");
			fileLocation = sc.nextLine(); // L'utilisateur tape le chemin vers sa sauvegarde
			object = new File(fileLocation);
			if (object != null) // Si le fichier texte existe ou n'est pas vide...
			{
				correct=true; // ... on sort de la boucle
			}
		} while(correct==false);
		return object;
	}

}
