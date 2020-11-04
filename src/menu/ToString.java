package menu;

import agglomeration.Town;

/**
 * Classe pour l'utilisation de String nécessaire à l'affichage des messages.
 * Format des messages:
 * Invite de commande: ==> message:
 * Invite de commande secondaire: ===> message:
 * Erreur: <!>message<!>
 * Operation réussi: *message*
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class ToString {
	
	/**
	 * Affichage du contenu de la liste adjacence demandé.
	 * @param ti liste d'adjacence
	 * @return b sous format 0, 0, 0.
	 */
	public static String toStringLink(int[] ti)
	{
		if (ti == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		for (int i = 0; i < ti.length-1; ++i) // -1 pour pas qu'il affiche le 0 situé à la fin du tableau
		{
			if (i > 0)
				b.append(", ");
			b.append(ti[i]);
		}
		b.append(".");
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de création de ville.
	 * @param tab objet ville
	 * @return b sous format *0. La ville X a été crée*.
	 */
	public static String toStringTownCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*" + tab.getSerial() + ". La ville " + tab.getName() + " a été crée*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de création de route.
	 * @param tab objet ville
	 * @return b sous format *La ville 0. X est relié(s) à(aux) la ville(s) 0, 0, 0*.
	 */
	public static String toStringLinkCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*La ville " + tab.getSerial() + ". " + tab.getName() + " est relié(s) à(aux) la ville(s) " + ToString.toStringLink(tab.getLink())+"*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de création d'école par défaut.
	 * @param tab objet ville
	 * @return b sous format *Une école a été établie par défaut dans la ville 0. X*.
	 */
	public static String toStringDefaultSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une école a été établi par défaut dans la ville " +tab.getSerial() + ". " + tab.getName() + "*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation d'ajout d'école dans une ville.
	 * @param tab objet ville
	 * @return b sous format Une école a été ajouté dans la ville 0. X*.
	 */
	public static String toStringSchoolAdded(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une école a été ajouté dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	/**
	 * Affichage confirmation de retrait d'école dans une ville.
	 * @param tab objet ville
	 * @return b sous format *Une école a été retiré dans la ville 0. X*.
	 */
	public static String toStringSchoolRemoved(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une école a été retiré dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	/**
	 * Affichage erreur, retrait impossible école dans une ville.
	 * @param tab objet ville
	 * @return b sous format <!>La ville 0. X est isolé ou n'est pas relié à une autre ville avec école<!>
	 */
	public static String toStringNoSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "<!>La ville "+tab.getSerial() + ". " + tab.getName() + " est isolé ou n'est pas relié à une autre ville avec une école<!>";
		return b.toString();
	}
	
	/**
	 * Affichage erreur, route déjà crée entre ces 2 villes.
	 * @param tab1 objet ville1
	 * @param tab2 objet ville2
	 * @return b sous format <!>La ville 0. X est déjà relié à 0. X<!>
	 */
	public static String toStringLinkExist(Town tab1, Town tab2)
	{
		if (tab1 == null || tab2 == null)
			return "null";
		String b;
		b = "<!>La ville " +tab1.getSerial() + ". " + tab1.getName() + " est déjà relié à " +tab2.getSerial() + ". " + tab2.getName() + "<!>";
		return b.toString();
	}
	
	/**
	 * Affichage liste d'école éxistante dans une agglomération.
	 * @param ville[] tableau de ville qu'on veut examiné
	 * @return b sous format *Les villes avec école: X X X X X*
	 */
	public static String toStringSchoolList(Town ville[])
	{
		if (ville == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		b.append("*Les villes avec école :");
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
