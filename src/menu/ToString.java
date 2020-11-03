package menu;

import agglomeration.Town;

/**
 * Classe pour l'utilisation de String n�cessaire � l'affichage des messages.
 * Format des messages:
 * Invite de commande: ==> message:
 * Erreur: <!>message<!>
 * Operation r�ussi: *message*
 * 
 * @author Amanda Messahel, Johan Laforge, Jack Thay
 * 
 *
 */
public class ToString {
	
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
	
	public static String toStringTownCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*" + tab.getSerial() + ". La ville " + tab.getName() + " a �t� cr�e*";
		return b.toString();
	}
	
	public static String toStringLinkCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*La ville " + tab.getSerial() + ". " + tab.getName() + " est reli� � la ville " + ToString.toStringLink(tab.getLink())+"*";
		return b.toString();
	}
	
	public static String toStringDefaultSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "<!>Une �cole a �t� �tabli par d�faut dans la ville " +tab.getSerial() + ". " + tab.getName() + "<!>";
		return b.toString();
	}
	
	public static String toStringSchoolAdded(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une �cole a �t� ajout� dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	public static String toStringSchoolRemoved(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une �cole a �t� retir� dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	public static String toStringNoSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "<!>La ville "+tab.getSerial() + ". " + tab.getName() + " est isol� ou n'est pas reli� � une autre ville avec une �cole<!>";
		return b.toString();
	}
	
	public static String toStringLinkExist(Town tab1, Town tab2)
	{
		if (tab1 == null || tab2 == null)
			return "null";
		String b;
		b = "<!>La ville " +tab1.getSerial() + ". " + tab1.getName() + " est d�j� reli� � " +tab2.getSerial() + ". " + tab2.getName() + "<!>";
		return b.toString();
	}
	
	public static String toStringSchoolList(Town ville[])
	{
		if (ville == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		b.append("*Les villes avec �cole : ");
		for (int i = 0; i < ville.length; ++i) // boucle qui permet de parcourir le tableau de ville
		{
			if (ville[i].isSchool() == true)
			{
				if (i > 0)
					b.append(" ");
				b.append(ville[i].getName());
			}
		}
		b.append("*");
		return b.toString();
	}
}
