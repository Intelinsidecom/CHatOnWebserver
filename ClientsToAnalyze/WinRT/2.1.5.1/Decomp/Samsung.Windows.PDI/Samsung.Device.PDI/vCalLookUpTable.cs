using System.Linq;

namespace Samsung.Device.PDI;

internal class vCalLookUpTable
{
	private static string[] CalenderPropertyTable = new string[54]
	{
		"NONE", "BEGIN", "END", "VERSION", "SUMMARY", "DTSTART", "DTEND", "DESCRIPTION", "LOCATION", "ATTACH",
		"ATTENDEE", "AALARM", "CATEGORIES", "CLASS", "DCREATED", "COMPLETED", "DALARM", "DUE", "DTEND", "EXDATE",
		"EXRULE", "LASTMODIFIED", "MALARM", "RNUM", "PRIORITY", "PALARM", "RELATED_TO", "RDATE", "RRULE", "RESOURCES",
		"SEQUENCE", "STATUS", "TRANSP", "URL", "UID", "DAYLIGHT", "GEO", "PRODID", "TZ", "DAYLIGHT",
		"GEO", "TZID", "TZOFFSETFROM", "TZOFFSETTO", "DTSTAMP", "LAST-MODIFIED", "ORGANIZER", "RECURRENCE-ID", "SEQUENCE", "TRANSP",
		"TRIGGER", "ACTION", "METHOD", "X-"
	};

	public static bool Contains(string a)
	{
		if (a == null || a.Length == 0)
		{
			return false;
		}
		string empty = string.Empty;
		int num = -1;
		num = a.IndexOf(':');
		if (num > -1)
		{
			empty = a.Substring(0, num);
			if (CalenderPropertyTable.Contains(empty))
			{
				return true;
			}
		}
		empty = string.Empty;
		num = -1;
		num = a.IndexOf(';');
		if (num > -1)
		{
			empty = a.Substring(0, num);
			if (CalenderPropertyTable.Contains(empty))
			{
				return true;
			}
		}
		if (a.StartsWith("X-"))
		{
			return true;
		}
		return false;
	}
}
