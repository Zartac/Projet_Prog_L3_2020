package menu;

import agglomeration.Town;

/**
 * Classe pour l'utilisation de String n�cessaire � l'affichage des messages.
 * Format des messages:
 * Invite de commande: ==> message:
 * Invite de commande secondaire: ===> message:
 * Erreur: <!>message<!>
 * Operation r�ussi: *message*
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class ToString {
	
	/**
	 * Affichage du contenu de la liste adjacence demand�.
	 * @param ti liste d'adjacence
	 * @return b sous format 0, 0, 0.
	 */
	public static String toStringLink(int[] ti)
	{
		if (ti == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		for (int i = 0; i < ti.length-1; ++i) // -1 pour pas qu'il affiche le 0 situ� � la fin du tableau
		{
			if (i > 0)
				b.append(", ");
			b.append(ti[i]);
		}
		b.append(".");
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de cr�ation de ville.
	 * @param tab objet ville
	 * @return b sous format *0. La ville X a �t� cr�e*.
	 */
	public static String toStringTownCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*" + tab.getSerial() + ". La ville " + tab.getName() + " a �t� cr�e*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de cr�ation de route.
	 * @param tab objet ville
	 * @return b sous format *La ville 0. X est reli�(s) �(aux) la ville(s) 0, 0, 0*.
	 */
	public static String toStringLinkCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*La ville " + tab.getSerial() + ". " + tab.getName() + " est reli�(s) �(aux) la ville(s) " + ToString.toStringLink(tab.getLink())+"*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de cr�ation d'�cole par d�faut.
	 * @param tab objet ville
	 * @return b sous format *Une �cole a �t� �tablie par d�faut dans la ville 0. X*.
	 */
	public static String toStringDefaultSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une �cole a �t� �tabli par d�faut dans la ville " +tab.getSerial() + ". " + tab.getName() + "*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation d'ajout d'�cole dans une ville.
	 * @param tab objet ville
	 * @return b sous format Une �cole a �t� ajout� dans la ville 0. X*.
	 */
	public static String toStringSchoolAdded(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une �cole a �t� ajout� dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de retrait d'�cole dans une ville.
	 * @param tab objet ville
	 * @return b sous format *Une �cole a �t� retir� dans la ville 0. X*.
	 */
	public static String toStringSchoolRemoved(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une �cole a �t� retir� dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	/**
	 * Affichage erreur, retrait impossible �cole dans une ville.
	 * @param tab objet ville
	 * @return b sous format <!>La ville 0. X est isol� ou n'est pas reli� � une autre ville avec �cole<!>
	 */
	public static String toStringNoSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "<!>La ville "+tab.getSerial() + ". " + tab.getName() + " est isol� ou n'est pas reli� � une autre ville avec une �cole<!>";
		return b.toString();
	}
	
	/**
	 * Affichage erreur, route d�j� cr�e entre ces 2 villes.
	 * @param tab1 objet ville1
	 * @param tab2 objet ville2
	 * @return b sous format <!>La ville 0. X est d�j� reli� � 0. X<!>
	 */
	public static String toStringLinkExist(Town tab1, Town tab2)
	{
		if (tab1 == null || tab2 == null)
			return "null";
		String b;
		b = "<!>La ville " +tab1.getSerial() + ". " + tab1.getName() + " est d�j� reli� � " +tab2.getSerial() + ". " + tab2.getName() + "<!>";
		return b.toString();
	}
	
	/**
	 * Affichage liste d'�cole �xistante dans une agglom�ration.
	 * @param ville[] tableau de ville qu'on veut examin�
	 * @return b sous format *Les villes avec �cole: X X X X X*
	 */
	public static String toStringSchoolList(Town ville[])
	{
		if (ville == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		b.append("*Les villes avec �cole :");
		for (int i = 0; i < ville.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if (ville[i].isSchool() == true)
			{
				b.append(" ");
				b.append(ville[i].getName());
			}
		}
		b.append("*");
		return b.toString();
	}
}
