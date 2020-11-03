package menu;

import agglomeration.Town;

/**
 * Classe pour l'utilisation de String nécessaire à l'affichage des messages.
 * Format des messages:
 * Invite de commande: ==> message:
 * Erreur: <!>message<!>
 * Operation réussi: *message*
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
		for (int i = 0; i < ti.length-1; ++i) // -1 pour pas qu'il affiche le 0 situé à la fin du tableau
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
		b = "*" + tab.getSerial() + ". La ville " + tab.getName() + " a été crée*";
		return b.toString();
	}
	
	public static String toStringLinkCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*La ville " + tab.getSerial() + ". " + tab.getName() + " est relié à la ville " + ToString.toStringLink(tab.getLink())+"*";
		return b.toString();
	}
	
	public static String toStringDefaultSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "<!>Une école a été établi par défaut dans la ville " +tab.getSerial() + ". " + tab.getName() + "<!>";
		return b.toString();
	}
	
	public static String toStringSchoolAdded(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une école a été ajouté dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	public static String toStringSchoolRemoved(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "*Une école a été retiré dans la ville "+tab.getSerial() + ". " + tab.getName()+ "*";
		return b.toString();
	}
	
	public static String toStringNoSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "<!>La ville "+tab.getSerial() + ". " + tab.getName() + " est isolé ou n'est pas relié à une autre ville avec une école<!>";
		return b.toString();
	}
	
	public static String toStringLinkExist(Town tab1, Town tab2)
	{
		if (tab1 == null || tab2 == null)
			return "null";
		String b;
		b = "<!>La ville " +tab1.getSerial() + ". " + tab1.getName() + " est déjà relié à " +tab2.getSerial() + ". " + tab2.getName() + "<!>";
		return b.toString();
	}
	
	public static String toStringSchoolList(Town ville[])
	{
		if (ville == null)
			return "null";
		StringBuilder b = new StringBuilder("");
		b.append("*Les villes avec école : ");
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
