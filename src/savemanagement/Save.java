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

            System.out.println("Reading file using Buffered Reader");
            
            String sub="";
            String sub2="";

            while ((readLine = b.readLine()) != null) {
            	if(readLine.contains("ville")) {
            		sub=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));
            		nameTown.add(sub);
            	}
            	else if(readLine.contains("ecole")) {
            		sub=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(')'));
            		schoolLocation.add(sub);
            	}
            	else if(readLine.contains("route")) {
            		sub=readLine.substring(readLine.indexOf('(')+1, readLine.indexOf(','));
            		sub2=readLine.substring(readLine.indexOf(',')+1, readLine.indexOf(')'));
            		townRoad1.add(sub);
            		townRoad2.add(sub2);
            	}
                //System.out.println(readLine);
            }
            for(int i=0;i<nameTown.size();i++) {
            	System.out.println(nameTown.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
 }
	
	public File test1(String path) throws IOException {
		File f = new File(path);
		return f;
	}
	
	public void lectureBuff(File f) throws IOException {
		 BufferedReader b = new BufferedReader(new FileReader(f));

         String readLine = "";

         System.out.println("Reading file using Buffered Reader");
         
         String sub="";
         String sub2="";

         while ((readLine = b.readLine()) != null) {
         	if(readLine.contains("ville")) {
         		sub=readLine.substring(readLine.indexOf('('), readLine.indexOf(')'));
         		nameTown.add(sub);
         	}
         	else if(readLine.contains("ecole")) {
         		sub=readLine.substring(readLine.indexOf('('), readLine.indexOf(')'));
         		schoolLocation.add(sub);
         	}
         	else if(readLine.contains("route")) {
         		sub=readLine.substring(readLine.indexOf('('), readLine.indexOf(','));
         		sub2=readLine.substring(readLine.indexOf(','), readLine.indexOf(')'));
         		townRoad1.add(sub);
        		townRoad2.add(sub2);
         	}
             //System.out.println(readLine);
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


}
