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
	 * @param name le nom qu'on veut donner
	 */
	public Town(String name) //Penser � bouger en String pour les prochaines parties
	{
		++serialcounter;
		this.name=name;
		serial = serialcounter;
		setSchool(false);
		this.link = new int[1];
	}
	
	/**
	 * R�cup�re le nom de la ville.
	 * @return Nom de la ville.
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * R�cup�re le num�ro de s�rie de la ville.
	 * @return Num�ro de s�rie.
	 */
	public int getSerial() 
	{
		return serial;
	}

	/**
	 * V�rifie la pr�sence ou non d'une �cole dans la ville.
	 * @return True/False sur l'existence de l'�cole.
	 */
	public boolean isSchool() 
	{
		return school;
	}

	/**
	 * Ajoute ou retire une �cole dans cette ville.
	 * @param value (True/False).
	 */
	public void setSchool(boolean value) 
	{
		this.school = value;
	}

	/**
	 * R�cup�re la liste des voisins de cette ville.
	 * @return Tableau de "int".
	 */
	public int[] getLink() 
	{
		return link;
	}
	
	/**
	 * Ajoute un num�ro dans la liste de d'adjacence.
	 */
	public void addToLink(int[] tab, int add) // � coder
	{
	    int[] tabTemp = Arrays.copyOf(tab, tab.length + 1);
	    tabTemp[tab.length - 1] = add;
	    this.link = tabTemp;
	}
	
	public static Town[] createTownLoop(int choice, String[] name) {
		Town[] tab = new Town[choice]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(name[i]); // On cr�e autant de ville que l'utilsateur a choisi
			System.out.println(ToString.toStringTownCreated(tab[i]));
		}
		return tab;
	}
	
	public static boolean checkLink(Town[] ville, int a) {
		int[] temp=ville[a-1].getLink();
		boolean check=false;
		for(int i=0; i<temp.length-1;i++) {
			if(ville[i].isSchool()==true) check=true;
		}
		return check;
	}
	
}
