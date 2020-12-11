package menu;

import java.util.ArrayList;

import agglomeration.Town;

/**
 * Classe pour l'utilisation de String n�cessaire � l'affichage des messages.
 * Format des messages:
 * Invite de commande: ==> message :
 * Invite de commande secondaire: ===> message :
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
	 * @param listeAdj liste d'adjacence
	 * @return b sous format 0, 0, 0.
	 */
	public static String toStringLink(ArrayList<Integer> listeAdj)
	{
		if (listeAdj == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		for (int i = 0; i < listeAdj.size(); ++i)
		{
			if (i > 0)
				b.append(", ");
			b.append(listeAdj.get(i));
		}
		b.append(".");
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de cr�ation de ville.
	 * @param villeUnique objet ville
	 * @return b sous format *0. La ville X a �t� cr��e*.
	 */
	public static String toStringTownCreated(Town villeUnique)
	{
		if (villeUnique == null)
			return "null";
		String b;
		b = "*" + villeUnique.getSerial() + ". La ville " + villeUnique.getName() + " a �t� cr��e*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de cr�ation de route.
	 * @param villeUnique objet ville
	 * @return b sous format *La ville 0. X est reli�(s) �(aux) la ville(s) 0, 0, 0*.
	 */
	public static String toStringLinkCreated(Town villeUnique)
	{
		if (villeUnique == null)
			return "null";
		String b;
		b = "*La ville " + villeUnique.getSerial() + ". " + villeUnique.getName() + " est reli�(s) �(aux) la ville(s) " + ToString.toStringLink(villeUnique.getLink())+"*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de cr�ation d'�cole par d�faut.
	 * @param villeUnique objet ville
	 * @return b sous format *Une �cole a �t� �tabli par d�faut dans la ville 0. X*.
	 */
	public static String toStringDefaultSchool(Town villeUnique)
	{
		if (villeUnique == null)
			return "null";
		String b;
		b = "*Une �cole a �t� �tabli par d�faut dans la ville " +villeUnique.getSerial() + ". " + villeUnique.getName() + "*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation d'ajout d'�cole dans une ville.
	 * @param villeUnique objet ville
	 * @return b sous format "Une �cole a �t� ajout� dans la ville 0. X*.
	 */
	public static String toStringSchoolAdded(Town villeUnique)
	{
		if (villeUnique == null)
			return "null";
		String b;
		b = "*Une �cole a �t� ajout� dans la ville "+villeUnique.getSerial() + ". " + villeUnique.getName()+ "*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de retrait d'�cole dans une ville.
	 * @param villeUnique objet ville
	 * @return b sous format *Une �cole a �t� retir� dans la ville 0. X*.
	 */
	public static String toStringSchoolRemoved(Town villeUnique)
	{
		if (villeUnique == null)
			return "null";
		String b;
		b = "*Une �cole a �t� retir� dans la ville "+villeUnique.getSerial() + ". " + villeUnique.getName()+ "*";
		return b.toString();
	}
	
	/**
	 * Affichage erreur, retrait impossible �cole dans une ville.
	 * @param villeUnique objet ville
	 * @return b sous format <!>La ville 0. X est isol� ou n'est pas reli� � une autre ville avec �cole<!>
	 */
	public static String toStringNoSchool(Town villeUnique)
	{
		if (villeUnique == null)
			return "null";
		String b;
		b = "<!>La ville "+villeUnique.getSerial() + ". " + villeUnique.getName() + " est isol� ou n'est pas reli� � une autre ville avec une �cole<!>";
		return b.toString();
	}
	
	/**
	 * Affichage erreur, route d�j� cr�e entre ces 2 villes.
	 * @param villeUnique1 objet ville1
	 * @param villeUnique2 objet ville2
	 * @return b sous format <!>La ville 0. X est d�j� reli� � 0. X<!>
	 */
	public static String toStringLinkExist(Town villeUnique1, Town villeUnique2)
	{
		if (villeUnique1 == null || villeUnique2 == null)
			return "null";
		String b;
		b = "<!>La ville " +villeUnique1.getSerial() + ". " + villeUnique1.getName() + " est d�j� reli� � " +villeUnique2.getSerial() + ". " + villeUnique2.getName() + "<!>";
		return b.toString();
	}
	
	/**
	 * Affichage liste d'�cole existante dans une agglom�ration.
	 * @param villeTab tableau de ville qu'on veut examiner
	 * @return b sous format *Les villes avec �cole: X X X X X*
	 */
	public static String toStringSchoolList(Town[] villeTab)
	{
		if (villeTab == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		b.append("*Les villes avec �cole :");
		for (int i = 0; i < villeTab.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if (villeTab[i].isSchool() == true)
			{
				b.append(" ");
				b.append(villeTab[i].getName());
			}
		}
		b.append("*");
		return b.toString();
	}
}
