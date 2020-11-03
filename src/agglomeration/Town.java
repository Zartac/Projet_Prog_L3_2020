package agglomeration;

import java.util.Arrays;
import menu.ToString;

/**
 * Classe pour la création et la modification de ville.
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
	private int[] link; // convertir la liste d'adjacence link en Arraylist prochainement
	
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
		this.link = new int[1]; // ce tableau aura toujours un 0 à la fin
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
	 * @return school true/false si en effet, il existe une ecole dans cette ville.
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
	public int[] getLink() 
	{
		return link;
	}
	
	/**
	 * Ajoute un numéro dans la liste de d'adjacence, le dernier numéro de cette liste sera toujours "0".
	 * @param listeAdj tableau de int, qui représente la liste d'adjacence de la ville.
	 * @param add numéro de série de la ville à ajouter dans la liste d'adjacence.
	 */
	public void addToLink(int[] listeAdj, int add) // à coder
	{
	    int[] tabTemp = Arrays.copyOf(listeAdj, listeAdj.length + 1);
	    tabTemp[listeAdj.length - 1] = add;
	    this.link = tabTemp;
	}
	
	/**
	 * Crée plusieurs villes, attention, le tableau de ville commence avec l'indice 0!
	 * @param choice le nombre de ville voulu.
	 * @param name liste de noms qui sera utilisé pour nommer les villes.
	 * @return tab tableau de "Town", ensemble de ville qui aura pour nombre "choice".
	 */
	public static Town[] createTownLoop(int choice, String[] name) {
		Town[] tab = new Town[choice]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(name[i]); // On crée autant de ville que l'utilsateur a choisi
			System.out.println(ToString.toStringTownCreated(tab[i]));
		}
		return tab;
	}
	
	/**
	 * Vérifie, pour une ville donné, sa liste d'adjacence et si une ville voisine a une école.
	 * @param villeTab[] le tableau de ville a analyser.
	 * @param choice le numéro de série de la ville dont on va vérifier la liste d'adjacence pour voir si un voisin a une école.
	 * @return check si en effet dans la liste d'adjacence de la ville n°"choice", il y'a une ville voisine avec une école.
	 */
	public static boolean checkLinkSchool(Town villeTab[], int choice) {
		int[] tempList=villeTab[choice-1].getLink(); // -1 à choice car le tableau commence depuis 0 et les serials depuis 1
		boolean check=false;
		for(int i=0; i<tempList.length-1;i++) {
			int tempNumber = tempList[i]; // On met en mémoire la valeur de la liste d'adjacence en position "i".
			if(villeTab[tempNumber-1].isSchool()==true) check=true; // -1 à tempNumber car le tableau commence depuis 0 et les serials depuis 1
		}
		return check;
	}
	
	/**
	 * Vérifie, selon un choix donné, si cette ville existe dans un tableau de ville.
	 * @param villeTab[] le tableau de ville a analyser.
	 * @param serial le numéro de série de la ville dont on veut vérifier l'existence.
	 * @return true/false si en effet la ville n°"serial" existe dans le tableau de ville "villeTab[]".
	 */
	public static boolean checkTownExist(Town villeTab[], int serial) // fonction récupéré d'Amanda
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
		int[] tempList=villeUnique.getLink(); // on met en mémoire la liste d'adjacence de la ville ciblé
		for(int i=0; i<tempList.length-1;i++) 
		{
			if (tempList[i]==verif) // on vérifie si le numéro verif existe déjà dans la liste d'adjacence
				return true;
		}
		return false;
	}
	
}
