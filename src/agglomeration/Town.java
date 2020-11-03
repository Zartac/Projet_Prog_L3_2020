package agglomeration;

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
	private int[] link; // convertir la liste d'adjacence link en Arraylist prochainement
	
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
		this.link = new int[1]; // ce tableau aura toujours un 0 � la fin
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
	 * @return school true/false si en effet, il existe une ecole dans cette ville.
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
	 * @param listeAdj tableau de int, qui repr�sente la liste d'adjacence de la ville.
	 * @param add num�ro de s�rie de la ville � ajouter dans la liste d'adjacence.
	 */
	public void addToLink(int[] listeAdj, int add) // � coder
	{
	    int[] tabTemp = Arrays.copyOf(listeAdj, listeAdj.length + 1);
	    tabTemp[listeAdj.length - 1] = add;
	    this.link = tabTemp;
	}
	
	/**
	 * Cr�e plusieurs villes, attention, le tableau de ville commence avec l'indice 0!
	 * @param choice le nombre de ville voulu.
	 * @param name liste de noms qui sera utilis� pour nommer les villes.
	 * @return tab tableau de "Town", ensemble de ville qui aura pour nombre "choice".
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
	 * V�rifie, pour une ville donn�, sa liste d'adjacence et si une ville voisine a une �cole.
	 * @param villeTab[] le tableau de ville a analyser.
	 * @param choice le num�ro de s�rie de la ville dont on va v�rifier la liste d'adjacence pour voir si un voisin a une �cole.
	 * @return check si en effet dans la liste d'adjacence de la ville n�"choice", il y'a une ville voisine avec une �cole.
	 */
	public static boolean checkLinkSchool(Town villeTab[], int choice) {
		int[] tempList=villeTab[choice-1].getLink(); // -1 � choice car le tableau commence depuis 0 et les serials depuis 1
		boolean check=false;
		for(int i=0; i<tempList.length-1;i++) {
			int tempNumber = tempList[i]; // On met en m�moire la valeur de la liste d'adjacence en position "i".
			if(villeTab[tempNumber-1].isSchool()==true) check=true; // -1 � tempNumber car le tableau commence depuis 0 et les serials depuis 1
		}
		return check;
	}
	
	/**
	 * V�rifie, selon un choix donn�, si cette ville existe dans un tableau de ville.
	 * @param villeTab[] le tableau de ville a analyser.
	 * @param serial le num�ro de s�rie de la ville dont on veut v�rifier l'existence.
	 * @return true/false si en effet la ville n�"serial" existe dans le tableau de ville "villeTab[]".
	 */
	public static boolean checkTownExist(Town villeTab[], int serial) // fonction r�cup�r� d'Amanda
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
		int[] tempList=villeUnique.getLink(); // on met en m�moire la liste d'adjacence de la ville cibl�
		for(int i=0; i<tempList.length-1;i++) 
		{
			if (tempList[i]==verif) // on v�rifie si le num�ro verif existe d�j� dans la liste d'adjacence
				return true;
		}
		return false;
	}
	
}
