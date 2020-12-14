package savemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import agglomeration.Town;

/**
 * Classe pour la lecture et l'�criture de sauvegarde.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Save {
	private static int nbTown; // nombre de villes
	private static ArrayList<String> nameTown=new ArrayList<String>(); // liste des noms de villes
	private static ArrayList<String> townRoad1=new ArrayList<String>();
	private static ArrayList<String> townRoad2=new ArrayList<String>();
	/* pour rappel townRoad1[i] sera reli� � townRoad2[i]*/
	private static ArrayList<String> schoolLocation=new ArrayList<String>(); // liste des noms de villes qui ont une �cole
	
	/**
	 * Affichage des invites de commandes utilisateurs pour charger une sauvegarde,
	 * si sauvegarde vide, on redemande � l'utilisateur � resaisir le chemin.
	 * @return object une File qui vraisemblablement n'est pas vide.
	 */
	public static void saveLoader(String path) throws IOException// Fonction ABSOLUMENT pas test�! -- Jack
	{
		try {

            File f = new File(path);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("*Lecture de la sauvegarde r�ussi*");
            String listTownAndlistSchool=""; // pour la lecture des noms de villes et positions d'�coles.
            String listLink1=""; // liste des noms de villes � relier � listLink 2.
            String listLink2=""; // liste des noms de villes � relier � listLink 1.
            String firstLetters; // pour ne r�cup�rer que les 1�re lettres de la ligne.

            while ((readLine = b.readLine()) != null) {
            	firstLetters=readLine.substring(0, 5); //coup de chance tous les mots font 5 lettres (5 exclu)
            	if(firstLetters.toLowerCase().equals("ville")) {
                	listTownAndlistSchool=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));
            		nameTown.add(listTownAndlistSchool);
            	}
            	else if(firstLetters.toLowerCase().equals("ecole")) {
                	listTownAndlistSchool=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));
            		schoolLocation.add(listTownAndlistSchool);
            	}
            	else if(firstLetters.toLowerCase().equals("route")) {
            		listLink1=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(','));//+1 pour ne pas inclure la parenthese
            		listLink2=readLine.substring(readLine.indexOf(',')+1, readLine.indexOf(')'));//+1 pour ne pas inclure la virgule
            		townRoad1.add(listLink1);
            		townRoad2.add(listLink2);
            	}
                //System.out.println(readLine);
            }
            //saveRecap();
            ArrayList<String> nameTownSingle=new ArrayList<>(new HashSet<>(nameTown)); // retrait des doublons
            setNbTown(nameTownSingle.size());
            if (nameTown.size()!=nameTownSingle.size())
            {
            	System.out.println("<!>Villes doublons d�tect�<!>");
            	System.out.println("*Retrait des villes doublons*");
            	nameTown = nameTownSingle;
                System.out.println("Nom des villes sans les doublons :");
                for(int i=0;i<nameTown.size();i++) {
                	System.out.print(nameTown.get(i)+" ");
                }
            }
            System.out.println("");

        } catch (IOException e) {
			System.out.println("<!>Erreur lecture de la sauvegarde<!>");
			System.out.println("<!>V�rifiez le chemin de votre sauvegarde entr� en argument et relancez<!>");
        }
	}
	
	public static void saveRecap()
	{
		System.out.println("*Information lus dans la sauvegarde :*");
		System.out.println(">Nom des villes lu :");
		System.out.print(">>");
        for(int i=0;i<nameTown.size();i++) {
        	System.out.print(nameTown.get(i)+" ");
        }
        System.out.println("");
        System.out.println(">Nom des villes � relier 1 :");
        System.out.print(">>");
        for(int i=0;i<townRoad1.size();i++) {
        	System.out.print(townRoad1.get(i)+" ");
        }
        System.out.println("");
        System.out.println(">Nom des villes � relier 2 :");
        System.out.print(">>");
        for(int i=0;i<townRoad2.size();i++) {
        	System.out.print(townRoad2.get(i)+" ");
        }
        System.out.println("");
        System.out.println(">Position des �coles :");
        System.out.print(">>");
        for(int i=0;i<schoolLocation.size();i++) {
        	System.out.print(schoolLocation.get(i)+" ");
        }
        System.out.println("");
	}
	
	public static Town[] convertSaveToAgglo()
	{
		Town[] villeTab = Town.createTownLoop(Save.getNbTown(), Save.getNameTown());
		for (int i = 0; i < townRoad1.size(); ++i)
		{
			Town.securedLinkCreation(villeTab, convertTownNameToSerial(villeTab, townRoad1.get(i)), convertTownNameToSerial(villeTab, townRoad2.get(i)));
		}
		for (int i = 0; i < schoolLocation.size(); ++i)
		{
			Town.securedAddSchool(villeTab,convertTownNameToSerial(villeTab, schoolLocation.get(i)));
		}
		return villeTab;
	}
	
	public static int convertTownNameToSerial(Town[] villeTab, String name)
	{
		int serial = 0; // La ville avec un num�ro de s�rie 0 n'existe pas
		for (int i = 0; i < villeTab.length; ++i) 
		{
			if (name.equals(villeTab[i].getName()))
			{
				serial = villeTab[i].getSerial();
			}
		}
		return serial;
	}
	
	public static ArrayList<String> getNameTown() {
		return nameTown;
	}

	public static void setNameTown(ArrayList<String> nameTown) {
		Save.nameTown = nameTown;
	}

	public static ArrayList<String> getTownRoad1() {
		return townRoad1;
	}

	public static void setTownRoad1(ArrayList<String> townRoad1) {
		Save.townRoad1 = townRoad1;
	}

	public static ArrayList<String> getTownRoad2() {
		return townRoad2;
	}

	public static void setTownRoad2(ArrayList<String> townRoad2) {
		Save.townRoad2 = townRoad2;
	}

	public static ArrayList<String> getSchoolLocation() {
		return schoolLocation;
	}

	public static void setSchoolLocation(ArrayList<String> schoolLocation) {
		Save.schoolLocation = schoolLocation;
	}
	
	public static int getNbTown() {
		return nbTown;
	}

	public static void setNbTown(int nbTown) {
		Save.nbTown = nbTown;
	}


}
