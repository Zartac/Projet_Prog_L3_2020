package town;

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
	private int[] link; // ce tableau aura toujours un 0 à la fin
	
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
		this.link = new int[1];
	}
	
	/**
	 * Récupère le nom de la ville.
	 * @return name Récupère le nom de la ville.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Récupère le numéro de série de la ville.
	 * @return serial Numéro de série de la ville.
	 */
	public int getSerial() 
	{
		return serial;
	}

	/**
	 * Vérifie la présence ou non d'une école dans la ville.
	 * @return school True/False sur l'existence de l'école.
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
	 * @param tab tableau de int, qui représente la liste d'adjacence de la ville.
	 * @param add numéro de série de la ville à ajouter dans la liste d'adjacence.
	 */
	public void addToLink(int[] tab, int add) // à coder
	{
	    int[] tabTemp = Arrays.copyOf(tab, tab.length + 1);
	    tabTemp[tab.length - 1] = add;
	    this.link = tabTemp;
	}
	
	/**
	 * Crée plusieurs villes, attention, le tableau de ville commence avec l'indice 0!
	 * @param choice le nombre de ville voulu.
	 * @param name liste de noms qui sera utilisé pour nommer les villes.
	 * @return tab tableau de "Town", ensemble de ville.
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
	 * Vérifie, pour une ville donné, sa liste d'adjacence.
	 * @param ville le tableau de ville a analyser.
	 * @param choice le numéro de série de la ville dont on va vérifier la liste d'adjacence.
	 */
	public boolean checkLink(Town[] ville, int choice) {
		int[] tempList=ville[choice-1].getLink(); // -1 à choice car le tableau commence depuis 0 et les serials depuis 1
		boolean check=false;
		for(int i=0; i<tempList.length-1;i++) { // -1 car nous ne voulons pas qu'il consulte le "0" se trouvant à la fin de la liste.
			int tempNumber = tempList[i];
			if(ville[tempNumber-1].isSchool()==true) check=true; // -1 à tempNumber car le tableau commence depuis 0 et les serials depuis 1
		}
		return check;
	}
	
}
