package agglomeration;

import java.util.ArrayList;
import menu.ToString;

/**
 * Classe pour la cr�ation et la modification de villes.
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
	 * Cr�ation basique d'une ville sans �cole, cette ville a un num�ro de s�rie unique.
	 * @param name le nom qu'on veut donner � la ville
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
	 * R�cup�re le nom de la ville.
	 * @return name nom de la ville.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * R�cup�re le num�ro de s�rie de la ville.
	 * @return serial num�ro de s�rie de la ville.
	 */
	public int getSerial() 
	{
		return serial;
	}

	/**
	 * V�rifie la pr�sence ou non d'une �cole dans la ville.
	 * @return school true/false si en effet, il existe une �cole dans cette ville.
	 */
	public boolean getSchool() 
	{
		return school;
	}

	/**
	 * Ajoute ou retire une �cole dans cette ville.
	 * @param value la valeur qui modifiera la pr�sence de l'�cole. 
	 */
	public void setSchool(boolean value) 
	{
		this.school = value;
	}

	/**
	 * R�cup�re la liste des voisins de cette ville (liste d'adjacence).
	 * @return link tableau de "int" qui repr�sente une liste d'adjacence.
	 */
	public ArrayList<Integer> getLink() 
	{
		return link;
	}
	
	/**
	 * Ajoute un num�ro dans la liste de d'adjacence, le dernier num�ro de cette liste sera toujours "0".
	 * @param listeAdj tableau de int, qui repr�sente la liste d'adjacence de la ville.
	 * @param add num�ro de s�rie de la ville � ajouter dans la liste d'adjacence.
	 */
	public void addToLink(ArrayList<Integer> listeAdj, int add) // � coder
	{
		ArrayList<Integer> tabTemp = this.link;
		tabTemp.add(add);
	    this.link = tabTemp;
	}
	
	/**
	 * Cr�er plusieurs villes, attention, le tableau de ville commence avec l'indice 0!
	 * @param choice le nombre de ville voulu.
	 * @param name liste de noms qui sera utilis� pour nommer les villes.
	 * @return tab tableau de "Town", ensemble de ville qui aura pour nombre "choice".
	 */
	public static Town[] createTownLoop(int choice, ArrayList<String> name) {
		Town[] tab = new Town[choice]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(name.get(i)); // On cr�e autant de ville que l'utilsateur a choisi
			System.out.println(ToString.toStringTownCreated(tab[i]));
		}
		return tab;
	}
	
	/**
	 * V�rifie, pour une ville donn�e, que le retrait de son �cole respecte les contraintes d'accessibilit�.
	 * @param villeTab le tableau de ville � analyser.
	 * @param choice le num�ro de s�rie de la ville dont on v�rifie que son retrait d'�cole respecte les contraintes d'accessibilit�.
	 * @return check v�rifie dans la liste d'adjacence si la ville n�"choice" poss�de une ville voisine avec une �cole.
	 */
	public static boolean removableSchool(Town[] villeTab, int choice) {
		villeTab[choice-1].setSchool(false); // on retire l'�cole dans la ville en question sans regarder les contraintes
		if (checkConstraintAccess(villeTab)==false) // on v�rifie que l'agglom�ration respecte les contraintes
		{
			villeTab[choice-1].setSchool(true); // on remet l'�cole l� o� elle �tait
			return false; // on lui indique que c'est pas possible d'enlever l'�cole puisque �ela fausse le respect des contraintes
		}
		villeTab[choice-1].setSchool(true); // on remet l'�cole m�me si les contraintes sont toujours respect�s
		return true; // on lui indique que c'est possible
	}
	
	/**
	 * V�rifie, pour une ville donn�, sa liste d'adjacence et si une ville voisine a une �cole.
	 * @param villeTab le tableau de ville a analyser.
	 * @param choice le num�ro de s�rie de la ville dont on v�rifie la liste d'adjacence pour voir si un voisin a une �cole.
	 * @return check v�rifie dans la liste d'adjacence si la ville n�"choice" poss�de une ville voisine avec une �cole.
	 */
	public static boolean checkLinkSchool(Town[] villeTab, int choice) {
		ArrayList<Integer> tempList=villeTab[choice-1].getLink(); // -1 � choice car le tableau commence depuis 0 et les serials depuis 1
		boolean check=false;
		for(int i=0; i<tempList.size();i++) {
			int tempNumber = tempList.get(i); // On met en m�moire la valeur de la liste d'adjacence en position "i".
			if(villeTab[tempNumber-1].getSchool()==true) check=true; // -1 � tempNumber car le tableau commence depuis 0 et les serials depuis 1
		}
		return check;
	}
	
	/**
	 * V�rifie, selon un choix donn�, si cette ville existe dans un tableau de ville.
	 * @param villeTab le tableau de ville � analyser.
	 * @param serial le num�ro de s�rie de la ville dont on veut v�rifier l'existence.
	 * @return true/false si en effet la ville n�"serial" existe dans le tableau de ville "villeTab[]".
	 */
	public static boolean checkTownExist(Town[] villeTab, int serial) // fonction r�cup�r� d'Amanda
	{
		for (int i = 0; i < villeTab.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if (villeTab[i].getSerial() == serial) // on v�rifie que le num�ro de s�rie de la ville correspond
				return true;
		}
		return false;
	}
	
	/**
	 * V�rifie, dans la liste d'adjacence d'une ville, si elle n'est pas d�j� reli� avec une autre.
	 * @param villeUnique la ville qu'on va examiner.
	 * @param verif le num�ro de s�rie de la ville � v�rifier.
	 * @return true/false si en effet la ville "villeUnique" n'est pas d�j� reli� � la ville n�"verif".
	 */
	public static boolean checkLinkExist(Town villeUnique, int verif) {
		ArrayList<Integer> tempList=villeUnique.getLink(); // on met en m�moire la liste d'adjacence de la ville cibl�
		for(int i=0; i<tempList.size();i++) 
		{
			if (tempList.get(i)==verif) // on v�rifie si le num�ro verif existe d�j� dans la liste d'adjacence
				return true;
		}
		return false;
	}
	
	/**
	 * Cr�er une route entre 2 villes tout en v�rifiant les contraintes.
	 * @param villeTab le tableau de ville � analyser.
	 * @param town1 le num�ro de s�rie de la 1�re ville � relier.
	 * @param town1 le num�ro de s�rie de la 2�me ville � relier.
	 */
	public static void securedLinkCreation(Town[] villeTab, int town1, int town2) 
	{
		if (town1==town2) // On v�rifie que l'utilisateur n'essaye pas de cr�er une route d'une ville a elle m�me
		{
			System.out.println("<!>Nous ne pouvons cr�er une route d'une ville vers elle m�me<!>");
		}
		else if(Town.checkLinkExist(villeTab[town1-1], town2)) // On v�rifie que choix 1 est pas d�j� reli� choix 2
		{
			System.out.println(ToString.toStringLinkExist(villeTab[town1-1], villeTab[town2-1]));
		}
		else if(Town.checkTownExist(villeTab,town2)==true) // On v�rifie que les 2 villes �xiste
		{
			villeTab[town1-1].addToLink(villeTab[town1-1].getLink(), town2); // On ajoute le choix 2 de l'utilisateur dans la liste d'adjacence du choix 1
			System.out.println(ToString.toStringLinkCreated(villeTab[town1-1])); // On affiche la liste d'adjacence du choix 1
			villeTab[town2-1].addToLink(villeTab[town2-1].getLink(), town1); // On ajoute le choix 1 de l'utilisateur dans la liste d'adjacence du choix 2
			System.out.println(ToString.toStringLinkCreated(villeTab[town2-1])); // On affiche la liste d'adjacence du choix 2
		}
		else // on suppose que le 2�me choix l'utilisateur n'existe pas
		{
			System.out.println("<!>La ville "+ town2 +" n'existe pas<!>");
		}
	}
	
	/**
	 * Ajoute une �cole dans une ville tout en v�rifiant les contraintes.
	 * @param villeTab le tableau de ville � analyser.
	 * @param town le num�ro de s�rie de la ville qui va une �cole ajout�.
	 */
	public static void securedAddSchool(Town[] villeTab, int town) 
	{
		if (Town.checkTownExist(villeTab,town)==true) // On v�rifie que la ville existe
		{
			if(villeTab[town-1].getSchool()==true)
				{
				System.out.println("<!>Cette ville poss�de d�j� une �cole<!>"); // on v�rifie que la ville n'a pas d�j� une �cole
				}
			else if (villeTab[town-1].getSchool()==false) // si cette ville n'a pas d'�cole
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
	 * Retire une �cole dans une ville tout en v�rifiant les contraintes.
	 * @param villeTab le tableau de ville � analyser.
	 * @param town le num�ro de s�rie de la ville qui va une �cole retir�.
	 */
	public static void securedRemoveSchool(Town[] villeTab, int town) 
	{
		if (Town.checkTownExist(villeTab,town)==true) // On v�rifie que la ville existe
		{
			if(villeTab[town-1].getSchool()==true) // On v�rifie qu'il y'a une �cole � retirer.
			{
				if(Town.removableSchool(villeTab, town)==true) // On v�rifie la liste d'adjacence de la ville
				{
					villeTab[town-1].setSchool(false);
					System.out.println(ToString.toStringSchoolRemoved(villeTab[town-1]));
				}
				else System.out.println(ToString.toStringNoSchool(villeTab[town-1]));
			}
			else if (villeTab[town-1].getSchool()==false) System.out.println("<!>Cette ville n'a pas d'�cole<!>");
			System.out.println(ToString.toStringSchoolList(villeTab));
		}
		else // on suppose que le choix l'utilisateur n'existe pas
		{
			System.out.println("<!>La ville "+ town +" n'existe pas<!>");
		}
	}
	
	/**
	 * V�rifie, que l'agglom�ration est conforme aux contraintes du sujet.
	 * @param villeTab le tableau de villes � analyser.
	 * @return true/false si en effet l'agglom�ration est conforme aux contraintes.
	 */
	public static boolean checkConstraintAccess(Town[] villeTab)
	{
		for (int i = 0; i < villeTab.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if (villeTab[i].getSchool()==false && checkLinkSchool(villeTab, villeTab[i].getSerial())==false)
				return false;
		}
		return true;
	}
	
}
