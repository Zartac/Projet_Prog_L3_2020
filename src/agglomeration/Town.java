package agglomeration;

import java.util.ArrayList;
import menu.ToString;

/**
 * Classe pour la création et la modification de villes.
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class Town 
{
	private static int serialcounter = 0;
	private String name;
	private int serial;
	private boolean school;
	/*private int[] link; // convertir la liste d'adjacence link en Arraylist prochainement*/
	ArrayList<Integer> link;
	
	/**
	 * Création basique d'une ville sans école, cette ville a un numéro de série unique.
	 * @param name le nom qu'on veut donner à la ville
	 */
	public Town(String name)
	{
		++serialcounter;
		this.name=name;
		serial = serialcounter;
		setSchool(false);
		this.link = new ArrayList<Integer>();
	}
	
	/**
	 * Récupère le nom de la ville.
	 * @return name nom de la ville.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Récupère le numéro de série de la ville.
	 * @return serial numéro de série de la ville.
	 */
	public int getSerial() 
	{
		return serial;
	}

	/**
	 * Vérifie la présence ou non d'une école dans la ville.
	 * @return school true/false si en effet, il existe une école dans cette ville.
	 */
	public boolean isSchool() 
	{
		return school;
	}

	/**
	 * Ajoute ou retire une école dans cette ville.
	 * @param value la valeur qui modifiera la présence de l'école. 
	 */
	public void setSchool(boolean value) 
	{
		this.school = value;
	}

	/**
	 * Récupère la liste des voisins de cette ville (liste d'adjacence).
	 * @return link tableau de "int" qui représente une liste d'adjacence.
	 */
	public ArrayList<Integer> getLink() 
	{
		return link;
	}
	
	/**
	 * Ajoute un numéro dans la liste de d'adjacence, le dernier numéro de cette liste sera toujours "0".
	 * @param listeAdj tableau de int, qui représente la liste d'adjacence de la ville.
	 * @param add numéro de série de la ville à ajouter dans la liste d'adjacence.
	 */
	public void addToLink(ArrayList<Integer> listeAdj, int add) // à coder
	{
		ArrayList<Integer> tabTemp = this.link;
		tabTemp.add(add);
	    this.link = tabTemp;
	}
	
	/**
	 * Créer plusieurs villes, attention, le tableau de ville commence avec l'indice 0!
	 * @param choice le nombre de ville voulu.
	 * @param name liste de noms qui sera utilisé pour nommer les villes.
	 * @return tab tableau de "Town", ensemble de ville qui aura pour nombre "choice".
	 */
	public static Town[] createTownLoop(int choice, ArrayList<String> name) {
		Town[] tab = new Town[choice]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(name.get(i)); // On crée autant de ville que l'utilsateur a choisi
			System.out.println(ToString.toStringTownCreated(tab[i]));
		}
		return tab;
	}
	
	/**
	 * Vérifie, pour une ville donné, que le retrait de son école respecte les contraintes d'accessibilité.
	 * @param villeTab le tableau de ville a analyser.
	 * @param choice le numéro de série de la ville dont on vérifie que son retrait d'école respecte les contraintes d'accessibilité.
	 * @return check vérifie dans la liste d'adjacence si la ville n°"choice" possède une ville voisine avec une école.
	 */
	public static boolean removableSchool(Town[] villeTab, int choice) {
		ArrayList<Integer> tempList=villeTab[choice-1].getLink(); // -1 à choice car le tableau commence depuis 0 et les serials depuis 1
		boolean check=false;
		for(int i=0; i<tempList.size();i++) {
			int tempNumber = tempList.get(i); // On met en mémoire la valeur de la liste d'adjacence en position "i".
			if(villeTab[tempNumber-1].isSchool()==true) check=true; // -1 à tempNumber car le tableau commence depuis 0 et les serials depuis 1
		}
		return check;
	}
	
	/**
	 * Vérifie, pour une ville donné, sa liste d'adjacence et si une ville voisine a une école.
	 * @param villeTab le tableau de ville a analyser.
	 * @param choice le numéro de série de la ville dont on vérifie la liste d'adjacence pour voir si un voisin a une école.
	 * @return check vérifie dans la liste d'adjacence si la ville n°"choice" possède une ville voisine avec une école.
	 */
	public static boolean checkLinkSchool(Town[] villeTab, int choice) {
		ArrayList<Integer> tempList=villeTab[choice-1].getLink(); // -1 à choice car le tableau commence depuis 0 et les serials depuis 1
		boolean check=false;
		for(int i=0; i<tempList.size();i++) {
			int tempNumber = tempList.get(i); // On met en mémoire la valeur de la liste d'adjacence en position "i".
			if(villeTab[tempNumber-1].isSchool()==true) check=true; // -1 à tempNumber car le tableau commence depuis 0 et les serials depuis 1
		}
		return check;
	}
	
	/**
	 * Vérifie, selon un choix donné, si cette ville existe dans un tableau de ville.
	 * @param villeTab le tableau de ville à analyser.
	 * @param serial le numéro de série de la ville dont on veut vérifier l'existence.
	 * @return true/false si en effet la ville n°"serial" existe dans le tableau de ville "villeTab[]".
	 */
	public static boolean checkTownExist(Town[] villeTab, int serial) // fonction récupéré d'Amanda
	{
		for (int i = 0; i < villeTab.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if (villeTab[i].getSerial() == serial) // on vérifie que le numéro de série de la ville correspond
				return true;
		}
		return false;
	}
	
	/**
	 * Vérifie, dans la liste d'adjacence d'une ville, si elle n'est pas déjà relié avec une autre.
	 * @param villeUnique la ville qu'on va examiner.
	 * @param verif le numéro de série de la ville à vérifier.
	 * @return true/false si en effet la ville "villeUnique" n'est pas déjà relié à la ville n°"verif".
	 */
	public static boolean checkLinkExist(Town villeUnique, int verif) {
		ArrayList<Integer> tempList=villeUnique.getLink(); // on met en mémoire la liste d'adjacence de la ville ciblé
		for(int i=0; i<tempList.size();i++) 
		{
			if (tempList.get(i)==verif) // on vérifie si le numéro verif existe déjà dans la liste d'adjacence
				return true;
		}
		return false;
	}
	
	/**
	 * Créer une route entre 2 villes tout en vérifiant les contraintes.
	 * @param villeTab le tableau de ville à analyser.
	 * @param town1 le numéro de série de la 1ère ville à relier.
	 * @param town1 le numéro de série de la 2ème ville à relier.
	 */
	public static void securedLinkCreation(Town[] villeTab, int town1, int town2) 
	{
		if (town1==town2) // On vérifie que l'utilisateur n'essaye pas de créer une route d'une ville a elle même
		{
			System.out.println("<!>Nous ne pouvons créer une route d'une ville vers elle même<!>");
		}
		else if(Town.checkLinkExist(villeTab[town1-1], town2)) // On vérifie que choix 1 est pas déjà relié choix 2
		{
			System.out.println(ToString.toStringLinkExist(villeTab[town1-1], villeTab[town2-1]));
		}
		else if(Town.checkTownExist(villeTab,town2)==true) // On vérifie que les 2 villes éxiste
		{
			villeTab[town1-1].addToLink(villeTab[town1-1].getLink(), town2); // On ajoute le choix 2 de l'utilisateur dans la liste d'adjacence du choix 1
			System.out.println(ToString.toStringLinkCreated(villeTab[town1-1])); // On affiche la liste d'adjacence du choix 1
			villeTab[town2-1].addToLink(villeTab[town2-1].getLink(), town1); // On ajoute le choix 1 de l'utilisateur dans la liste d'adjacence du choix 2
			System.out.println(ToString.toStringLinkCreated(villeTab[town2-1])); // On affiche la liste d'adjacence du choix 2
		}
		else // on suppose que le 2ème choix l'utilisateur n'existe pas
		{
			System.out.println("<!>La ville "+ town2 +" n'existe pas<!>");
		}
	}
	
	/**
	 * Ajoute une école dans une ville tout en vérifiant les contraintes.
	 * @param villeTab le tableau de ville à analyser.
	 * @param town le numéro de série de la ville qui va une école ajouté.
	 */
	public static void securedAddSchool(Town[] villeTab, int town) 
	{
		if (Town.checkTownExist(villeTab,town)==true) // On vérifie que la ville existe
		{
			if(villeTab[town-1].isSchool()==true)
				{
				System.out.println("<!>Cette ville possède déjà une école<!>"); // on vérifie que la ville n'a pas déjà une école
				}
			else if (villeTab[town-1].isSchool()==false) // si cette ville n'a pas d'école
			{ 
				villeTab[town-1].setSchool(true);
				System.out.println(ToString.toStringSchoolAdded(villeTab[town-1]));
			}
			System.out.println(ToString.toStringSchoolList(villeTab));
		}
		else // on suppose que le choix l'utilisateur n'existe pas
		{
			System.out.println("<!>La ville "+ town +" n'existe pas<!>");
		}
	}
	
	/**
	 * Retire une école dans une ville tout en vérifiant les contraintes.
	 * @param villeTab le tableau de ville à analyser.
	 * @param town le numéro de série de la ville qui va une école retiré.
	 */
	public static void securedRemoveSchool(Town[] villeTab, int town) 
	{
		if (Town.checkTownExist(villeTab,town)==true) // On vérifie que la ville existe
		{
			if(villeTab[town-1].isSchool()==true) // On vérifie qu'il y'a une école à retirer.
			{
				if(Town.removableSchool(villeTab, town)==true) // On vérifie la liste d'adjacence de la ville
				{
					villeTab[town-1].setSchool(false);
					System.out.println(ToString.toStringSchoolRemoved(villeTab[town-1]));
				}
				else System.out.println(ToString.toStringNoSchool(villeTab[town-1]));
			}
			else if (villeTab[town-1].isSchool()==false) System.out.println("<!>Cette ville n'a pas d'école<!>");
			System.out.println(ToString.toStringSchoolList(villeTab));
		}
		else // on suppose que le choix l'utilisateur n'existe pas
		{
			System.out.println("<!>La ville "+ town +" n'existe pas<!>");
		}
	}
	
	/**
	 * Vérifie, que l'agglomération est conforme aux contraintes du sujet.
	 * @param villeTab le tableau de ville à analyser.
	 * @return true/false si en effet l'agglomération est conforme aux contraintes.
	 */
	public static boolean checkConstraintAccess(Town[] villeTab)
	{
		for (int i = 0; i < villeTab.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if (villeTab[i].isSchool()==false && checkLinkSchool(villeTab, villeTab[i].getSerial())==false)
				return false;
		}
		return true;
	}
	
}
