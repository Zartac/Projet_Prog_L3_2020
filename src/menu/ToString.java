package menu;

import town.Town;

/**
 * Classe pour l'utilisation de String.
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
		for (int i = 0; i < ti.length-1; ++i)
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
		b = tab.getSerial() + ". La ville " + tab.getName() + " a �t� cr�e.";
		return b.toString();
	}
	
	public static String toStringLinkCreated(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "La ville " + tab.getSerial() + ". " + tab.getName() + " est reli� � la ville " + ToString.toStringLink(tab.getLink());
		return b.toString();
	}
	
	public static String toStringDefaultSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "Une �cole a �t� �tabli par d�faut dans la ville " +tab.getSerial() + ". " + tab.getName() + ".";
		return b.toString();
	}
	
	public static String toStringSchoolAdded(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "Une �cole a �t� ajout� dans la ville "+tab.getSerial() + ". " + tab.getName()+ ".";
		return b.toString();
	}
	
	public static String toStringSchoolRemoved(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "Une �cole a �t� retir� dans la ville "+tab.getSerial() + ". " + tab.getName()+ ".";
		return b.toString();
	}
	
	public static String toStringNoSchool(Town tab)
	{
		if (tab == null)
			return "null";
		String b;
		b = "La ville "+tab.getSerial() + ". " + tab.getName() + " est isol� ou n'est pas reli� � une ville avec une �cole.";
		return b.toString();
	}
}
