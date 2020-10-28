package town;

import java.util.Arrays;

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
	private char name; // J'ai un peu oublier comment on utiliser les string en Java -- Jack
	private int serial;
	private boolean school;
	private int[] link;
	
	/**
	 * Création basique d'une ville sans école, cette ville a un numéro de série unique.
	 * @param name
	 */
	public Town(char name) //Penser à bouger en String pour les prochaines parties
	{
		++serialcounter;
		this.name=name;
		serial = serialcounter;
		setSchool(false);
	}
	
	/**
	 * Récupère le nom de la ville.
	 * @return Nom de la ville.
	 */
	public char getName() 
	{
		return name;
	}

	/**
	 * Récupère le numéro de série de la ville.
	 * @return Numéro de série.
	 */
	public int getSerial() 
	{
		return serial;
	}

	/**
	 * Vérifie la présence ou non d'une école dans la ville.
	 * @return True/False sur l'existence de l'école.
	 */
	public boolean isSchool() 
	{
		return school;
	}

	/**
	 * Ajoute ou retire une école dans cette ville.
	 * @param value (True/False).
	 */
	public void setSchool(boolean value) 
	{
		this.school = value;
	}

	/**
	 * Récupère la liste des voisins de cette ville.
	 * @return Tableau de "int".
	 */
	public int[] getLink() 
	{
		return link;
	}
	
	/**
	 * Ajoute un numéro dans une liste de d'adjacence.
	 */
	public void addToLink(int[] tab, int add) // à coder
	{
		/*
		 * Il faudra peut être remplacer le int[] par une linked liste
		 */
	    int[] tabTemp = Arrays.copyOf(tab, tab.length + 1);
	    tabTemp[tab.length - 1] = add;
	    System.out.println(Arrays.toString(tabTemp));
	    this.link = tabTemp;
	}
/*
 * TEST
 */
	
}
