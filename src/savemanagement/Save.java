package savemanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import agglomeration.Town;
import menu.DisplayRendu2;

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
	 * Affichage du chargement de la sauvegarde.
	 * @param path le chemin du fichier de sauvegarde, soit l'argument qui est saisie dans la ligne de commande à l'execution du programme.
	 */
	public static void saveLoader(String path) throws IOException
	{
		System.out.println("~~>Lecture du fichier de sauvegarde :");
		try {

            File f = new File(path);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("*Lecture de la sauvegarde réussi*");
            String listTownAndlistSchool=""; // pour la lecture des noms de villes et positions d'écoles.
            String listLink1=""; // liste des noms de villes à relier à listLink 2.
            String listLink2=""; // liste des noms de villes à relier à listLink 1.
            String firstLetters; // pour ne récupérer que les 1ère lettres de la ligne.

            while ((readLine = b.readLine()) != null) {
            	firstLetters=readLine.substring(0, 5); //coup de chance tous les mots font 5 lettres (5 exclu)
            	if(firstLetters.toLowerCase().equals("ville")) {
                	listTownAndlistSchool=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));
                	if(listTownAndlistSchool.equals("")) // Au cas où on nous troll et que le nom de ville est vide.
                	{
                		System.out.println("<!>Nom de ville vide détecté<!>");
                	}
                	else
                	{
                		nameTown.add(listTownAndlistSchool);
                	}
            	}
            	else if(firstLetters.toLowerCase().equals("ecole")) {
                	listTownAndlistSchool=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));
                	if(listTownAndlistSchool.equals(""))
                	{
                		System.out.println("<!>Ecole sans ville détecté<!>");
                	}
                	else
                	{
                		schoolLocation.add(listTownAndlistSchool);
                	}
            	}
            	else if(firstLetters.toLowerCase().equals("route")) {
            		listLink1=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(','));//+1 pour ne pas inclure la parenthese
            		listLink2=readLine.substring(readLine.indexOf(',')+1, readLine.indexOf(')'));//+1 pour ne pas inclure la virgule
                	if(listLink1.equals("")||listLink2.equals(""))
                	{
                		System.out.println("<!>Route sans ville détecté<!>");
                	}
                	else
                	{
                		townRoad1.add(listLink1);
                		townRoad2.add(listLink2);
                	}
            	}
                //System.out.println(readLine);
            }
            //saveRecap();
            ArrayList<String> nameTownSingle=new ArrayList<>(new HashSet<>(nameTown)); // retrait des doublons
            setNbTown(nameTownSingle.size());
            if (nameTown.size()!=nameTownSingle.size())
            {
            	System.out.println("<!>Ville doublons détectée<!>");
            	System.out.println("*Retrait des villes doublons*");
            	nameTown = nameTownSingle;
            	System.out.println("");
                System.out.println("Noms des villes sans les doublons :");
                for(int i=0;i<nameTown.size();i++) {
                	System.out.print(nameTown.get(i)+" ");
                }
                System.out.println("");
            }
            b.close();
        } catch (IOException e) {
			System.out.println("<!>Erreur lecture de la sauvegarde<!>");
			System.out.println("<!>Vérifiez le chemin de votre sauvegarde entré en argument et relancez<!>");
        }
		System.out.println("");
	}
	
	/**
	 * Permet de créer un nouveau fichier à partir du chemin spécifié par l'utilisateur,
	 * ce fichier contient la liste l des informations à stocker.
	 * @param stringSave texte à écrire dans la sauvegarde.
	 */
	public static void createSave(ArrayList<String> stringSave) {
        FileWriter w;
        boolean correct = false;
        Scanner s=new Scanner(System.in);
        do { // Boucle au cas où l'utilisateur n'a pas correctement créé sa sauvegarde
            System.out.println("===>Veuillez entrer le chemin pour la sauvegarde : ");
            String chemin=s.nextLine();
    		try {
    			w = new FileWriter(chemin);
    			BufferedWriter out = new BufferedWriter(w);
    			for(int i=0;i<stringSave.size();i++) {
    				out.write(stringSave.get(i));
    				out.write("\n");
    			}
    			out.close();
    			File f = new File(chemin);
    			if (f.exists()) // On veut vérifier que la sauvegarde existe.
    			{
    				System.out.println("~~>Ecriture de la sauvegarde : " + f.getAbsolutePath());
    				System.out.println("*Sauvegarde réussi*");
    				correct=true;
    			}
    		} catch (IOException e) { // Une erreur a eu lieu dans l'écriture de la sauvegarde.
    			System.out.println("<!>Le chemin fourni n'est pas valide<!>");
    			System.out.println("<!>Le nom du fichier de sauvegarde doit aussi être indiqué<!>");
    		}
        }while(correct==false);
	}
	
	/**
	 * Permet de convertir l'agglomération courante, en ArrayList de String.
	 * @param villeTab l'agglomération courante
	 * @return stringSave ArrayList de String contenant l'agglomération courante.
	 */
	public static ArrayList<String> createStringSave(Town[] villeTab) {
		ArrayList<String> stringSave = new ArrayList<String>();
		for (int i = 0; i<nameTown.size();++i) // Comme le rendu 2 ne permet pas d'ajouter de ville, on récupère les noms de villes de la sauvegarde.
		{
			stringSave.add("ville("+nameTown.get(i)+").");
		}
		for (int i = 0; i<townRoad1.size();++i) // Comme le rendu 2 ne permet pas d'ajouter de route, on récupère les noms de villes de la sauvegarde.
		{
			stringSave.add("route("+townRoad1.get(i)+","+townRoad2.get(i)+").");
		}
		for (int i = 0; i<villeTab.length;++i) // On récupère la position des écoles dans l'agglomération courante.
		{
			if(villeTab[i].getSchool()==true)
			{
				stringSave.add("ecole("+villeTab[i].getName()+").");
			}
		}
		return stringSave;
	}
	
	/**
	 * Affichage recapitulatif de la sauvegarde.
	 */
	public static void saveRecap()
	{
		System.out.println("*Informations lues dans la sauvegarde :*");
		System.out.println(">Noms des villes lues :");
		System.out.print(">>");
        for(int i=0;i<nameTown.size();i++) {
        	System.out.print(nameTown.get(i)+" ");
        }
        System.out.println("");
        System.out.println(">Noms des villes à relier 1 :");
        System.out.print(">>");
        for(int i=0;i<townRoad1.size();i++) {
        	System.out.print(townRoad1.get(i)+" ");
        }
        System.out.println("");
        System.out.println(">Noms des villes à relier 2 :");
        System.out.print(">>");
        for(int i=0;i<townRoad2.size();i++) {
        	System.out.print(townRoad2.get(i)+" ");
        }
        System.out.println("");
        System.out.println(">Positions des écoles :");
        System.out.print(">>");
        for(int i=0;i<schoolLocation.size();i++) {
        	System.out.print(schoolLocation.get(i)+" ");
        }
        System.out.println("");
	}
	
	/**
	 * Converti une sauvegarde en agglomeration.
	 * @return villeTab l'agglomeration décrite par la sauvegarde.
	 */
	
	public static Town[] convertSaveToAgglo()
	{
		System.out.println("~~>Conversion de la sauvegarde en agglomération :");
		Town[] villeTab = Town.createTownLoop(Save.getNameTown().size(), Save.getNameTown());
		if (villeTab.length==0)
		{
			System.out.println("<!>L'agglomération est inexistante<!>");
		}
		for (int i = 0; i < townRoad1.size(); ++i) // Création de route
		{
			int serial1 = convertTownNameToSerial(villeTab, townRoad1.get(i));
			int serial2 = convertTownNameToSerial(villeTab, townRoad2.get(i));
			if (serial1>0 && serial2>0)
			{
				Town.securedLinkCreation(villeTab, serial1, serial2);				
			}
			else
			{
				System.out.println("<!>Erreur lors de la création de route la ville " + townRoad1.get(i) + " vers la ville " + townRoad2.get(i)+"<!>");				
			}
		}
		for (int i = 0; i < schoolLocation.size(); ++i)
		{
			int serial = convertTownNameToSerial(villeTab, schoolLocation.get(i));
			if (serial>0)
			{
				Town.securedAddSchool(villeTab,serial);
			}
			else
			{
				System.out.println("<!>Erreur lors de la création d'école à la ville " + schoolLocation.get(i)+"<!>");				
			}
		}
		System.out.println("");
		System.out.println("~~>Vérification des contraintes d'accessibilité :");
		if (villeTab.length==0)
		{
			System.out.println("<!>L'agglomération est inexistante<!>");
		}
		else if (Town.checkConstraintAccess(villeTab)==false)
		{
			System.out.println("<!>L'agglomération ne respecte pas les contraintes d'accessibilité<!>");
			for (int i = 0; i < villeTab.length; ++i) 
			{
				villeTab[i].setSchool(true);
			}
			System.out.println("*Une école a été ajouté dans chaques villes de l'agglomération*");
			DisplayRendu2.displayScore(villeTab);
		}
		else if (Town.checkConstraintAccess(villeTab)==true)
		{
			System.out.println("*L'agglomération respecte les contraintes d'accessibilité*");
			DisplayRendu2.displayScore(villeTab);
		}
		return villeTab;
	}
	/**
	 * Cherche le numéro de série pour une ville donnée.
	 * @param villeTab agglomeration contenant la ville.
	 * @param name nom de la ville recherchée.
	 * @return serial le numéro de série de la ville recherchée.
	 */
	public static int convertTownNameToSerial(Town[] villeTab, String name)
	{
		int serial = 0; // La ville avec un numéro de série 0 n'existe pas
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
