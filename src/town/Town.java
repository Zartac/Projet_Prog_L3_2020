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
	 * @param name le nom qu'on veut donner
	 */
	public Town(String name) //Penser à bouger en String pour les prochaines parties
	{
		++serialcounter;
		this.name=name;
		serial = serialcounter;
		setSchool(false);
		this.link = new int[1];
	}
	
	/**
	 * Récupère le nom de la ville.
	 * @return Nom de la ville.
	 */
	public String getName() 
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
	 * Ajoute un numéro dans la liste de d'adjacence.
	 */
	public void addToLink(int[] tab, int add) // à coder
	{
	    int[] tabTemp = Arrays.copyOf(tab, tab.length + 1);
	    tabTemp[tab.length - 1] = add;
	    this.link = tabTemp;
	}
	
	public static Town[] createTownLoop(int choice, String[] name) {
		Town[] tab = new Town[choice]; 
		for (int i = 0; i < tab.length; ++i) 
		{
			tab[i] = new Town(name[i]); // On crée autant de ville que l'utilsateur a choisi
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
