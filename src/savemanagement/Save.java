package savemanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe pour la lecture et l'écriture de sauvegarde.
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
	/* pour rappel townRoad1[i] sera relié à townRoad2[i]*/
	private static ArrayList<String> schoolLocation=new ArrayList<String>(); // liste des noms de villes qui ont une école
	
	/**
	 * Affichage des invites de commandes utilisateurs pour charger une sauvegarde,
	 * si sauvegarde vide, on redemande à l'utilisateur à resaisir le chemin.
	 * @return object une File qui vraisemblablement n'est pas vide.
	 */
	public static void saveLoader(String path) throws IOException// Fonction ABSOLUMENT pas testé! -- Jack
	{
		//TODO: prévoir l'éventualité ou la sauvegarde est videe ou inexistante
		try {

            File f = new File(path);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("*Lecture de la sauvegarde réussi*");
            String sub="";
            String sub2="";
            String test;

            while ((readLine = b.readLine()) != null) {
            	test=readLine.substring(0, 5); //coup de chance tous les mots font 5 lettres (5 exclu)
            	if(test.toLowerCase().equals("ville")) {
            		sub=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));//+1 pour ne pas inclure la parenthese
            		nameTown.add(sub);
            	}
            	else if(test.toLowerCase().equals("ecole")) {
            		sub=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));//+1 pour ne pas inclure la parenthese
            		schoolLocation.add(sub);
            	}
            	else if(test.toLowerCase().equals("route")) {
            		sub=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(','));//+1 pour ne pas inclure la parenthese
            		sub2=readLine.substring(readLine.indexOf(',')+1, readLine.indexOf(')'));//+1 pour ne pas inclure la virgule
            		townRoad1.add(sub);
            		townRoad2.add(sub2);
            	}
                //System.out.println(readLine);
            }
            setNbTown(nameTown.size());
            System.out.println("Nom des villes :"); //A ENLEVER
            for(int i=0;i<nameTown.size();i++) {
            	System.out.print(nameTown.get(i)+" ");
            }
            System.out.println("");
            System.out.println("Nom des villes à relier 1 :"); //A ENLEVER
            for(int i=0;i<townRoad1.size();i++) {
            	System.out.print(townRoad1.get(i)+" ");
            }
            System.out.println("");
            System.out.println("Nom des villes à relier 2 :"); //A ENLEVER
            for(int i=0;i<townRoad2.size();i++) {
            	System.out.print(townRoad2.get(i)+" ");
            }
            System.out.println("");
            System.out.println("Position des écoles :"); //A ENLEVER
            for(int i=0;i<schoolLocation.size();i++) {
            	System.out.print(schoolLocation.get(i)+" ");
            }
            System.out.println("");

        } catch (IOException e) {
			System.out.println("<!>Erreur lecture de la sauvegarde<!>");
			System.out.println("<!>Vérifiez le chemin de votre sauvegarde entré en argument et relancez<!>");
        }
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
