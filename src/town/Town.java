package town;

import java.util.Arrays;
import menu.ToString;

/**
 * Classe pour la cr�ation et la modification de ville.
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
	private int[] link; // ce tableau aura toujours un 0 � la fin
	
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
		this.link = new int[1];
	}
	
	/**
	 * R�cup�re le nom de la ville.
	 * @return name R�cup�re le nom de la ville.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * R�cup�re le num�ro de s�rie de la ville.
	 * @return serial Num�ro de s�rie de la ville.
	 */
	public int getSerial() 
	{
		return serial;
	}

	/**
	 * V�rifie la pr�sence ou non d'une �cole dans la ville.
	 * @return school True/False sur l'existence de l'�cole.
	 */
	public boolean isSchool() 
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
	public int[] getLink() 
	{
		return link;
	}
	
	/**
	 * Ajoute un num�ro dans la liste de d'adjacence, le dernier num�ro de cette liste sera toujours "0".
	 * @param tab tableau de int, qui repr�sente la liste d'adjacence de la ville.
	 * @param add num�ro de s�rie de la ville � ajouter dans la liste d'adjacence.
	 */
	public void addToLink(int[] tab, int add) // � coder
	{
	    int[] tabTemp = Arrays.copyOf(tab, tab.length + 1);
	    tabTemp[tab.length - 1] = add;
	    this.link = tabTemp;
	}
	
	/**
	 * Cr�e plusieurs villes, attention, le tableau de ville commence avec l'indice 0!
	 * @param choice le nombre de ville voulu.
	 * @param name liste de noms qui sera utilis� pour nommer les villes.
	 * @return tab tableau de "Town", ensemble de ville.
	 */
	public static Town[] createTownLoop(int choice, String[] name) {
		Town[] tab = new Town[choice]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(name[i]); // On cr�e autant de ville que l'utilsateur a choisi
			System.out.println(ToString.toStringTownCreated(tab[i]));
		}
		return tab;
	}
	
	/**
	 * V�rifie, pour une ville donn�, sa liste d'adjacence.
	 * @param ville le tableau de ville a analyser.
	 * @param choice le num�ro de s�rie de la ville dont on va v�rifier la liste d'adjacence.
	 */
	public boolean checkLink(Town[] ville, int choice) {
		int[] tempList=ville[choice-1].getLink(); // -1 � choice car le tableau commence depuis 0 et les serials depuis 1
		boolean check=false;
		for(int i=0; i<tempList.length-1;i++) { // -1 car nous ne voulons pas qu'il consulte le "0" se trouvant � la fin de la liste.
			int tempNumber = tempList[i];
			if(ville[tempNumber-1].isSchool()==true) check=true; // -1 � tempNumber car le tableau commence depuis 0 et les serials depuis 1
		}
		return check;
	}
	
}
