using System.Text;
using vitem;

namespace vitemapi;

public class vCalEncoder
{
	private static void VEventBegin(StringBuilder nbuf)
	{
		global::vitem.vitem.VItemAppend(nbuf, "BEGIN:VEVENT", null);
	}

	public static byte EncodevCal(vCalendar_t vCal)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder = new StringBuilder(256);
		if (vCal == null)
		{
			return 2;
		}
		stringBuilder = VCalBegin("1.0");
		if (stringBuilder == null)
		{
			return 1;
		}
		VEventBegin(stringBuilder);
		if (vCal.DESCRIPTION != null)
		{
			VCalItemString(stringBuilder, 7, vCal.DESCRIPTION);
		}
		if (vCal.SUMMARY != null)
		{
			VCalItemString(stringBuilder, 4, vCal.SUMMARY);
		}
		if (vCal.LOCATION != null)
		{
			VCalItemString(stringBuilder, 8, vCal.LOCATION);
		}
		if (vCal.StartDate.nYear != 0)
		{
			if (vCal.bAllDay != 0)
			{
				VCalItemDate(stringBuilder, 10, vCal.StartDate);
			}
			else
			{
				VCalItemDate(stringBuilder, 5, vCal.StartDate);
			}
		}
		if (vCal.EndDate.nYear != 0)
		{
			if (vCal.bAllDay != 0)
			{
				VCalItemDate(stringBuilder, 11, vCal.EndDate);
			}
			else
			{
				VCalItemDate(stringBuilder, 6, vCal.EndDate);
			}
		}
		VEventEnd(stringBuilder);
		VCalEnd(stringBuilder);
		vCal.pEncodedData = stringBuilder.ToString();
		vCal.nEncodedDataLen = stringBuilder.Length;
		return (byte)vITEM_ERROR_CODE;
	}

	private static StringBuilder VCalBegin(string versionno)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		global::vitem.vitem.VItemAppend(stringBuilder, "BEGIN:VCALENDAR\r\nVERSION:", versionno);
		return stringBuilder;
	}

	private static void VCalItemString(StringBuilder nbuf, int nTag, string pData)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		if (nbuf != null || stringBuilder != null)
		{
			int charset = Lookuptable.GetCharset(nTag, VITEMMETHOD.VITEM_CALENDER);
			int encodeType = Lookuptable.GetEncodeType(nTag, VITEMMETHOD.VITEM_CALENDER);
			byte isEscape = global::vitem.vitem.GetIsEscape();
			string value = Lookuptable.VItemGetTagString(nTag, VITEMMETHOD.VITEM_CALENDER);
			stringBuilder.Append(value);
			CommonMethods.VItemAppendCharSet(stringBuilder, charset);
			CommonMethods.VItemAppendEncodeType(stringBuilder, encodeType);
			stringBuilder.Append(":");
			global::vitem.vitem.VItemAppendTagEncodeData(nbuf, stringBuilder, pData, charset, encodeType, isEscape);
		}
	}

	private static void VCalItemDate(StringBuilder nbuf, int nTag, VItemDate_t pDate)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		StringBuilder stringBuilder2 = new StringBuilder(128);
		string text = null;
		if ((nbuf != null || stringBuilder2 != null) && pDate.nYear >= 1900 && pDate.nYear <= 2999)
		{
			text = Lookuptable.VItemGetTagString(nTag, VITEMMETHOD.VITEM_CALENDER);
			if (stringBuilder != null)
			{
				stringBuilder.Append(text);
				stringBuilder.Append(":");
				VItemTimeToStringTime(pDate, stringBuilder2);
				global::vitem.vitem.VItemAppend(nbuf, stringBuilder.ToString(), stringBuilder2.ToString());
			}
		}
	}

	public static void VItemTimeToStringTime(VItemDate_t vtime, StringBuilder szTime)
	{
		if (szTime != null)
		{
			szTime.Append((int)vtime.nYear);
			if (vtime.nMonth != 0 && vtime.nMonth < 10)
			{
				szTime.Append("0");
			}
			szTime.Append((int)vtime.nMonth);
			if (vtime.nDay != 0 && vtime.nDay < 10)
			{
				szTime.Append("0");
			}
			szTime.Append((int)vtime.nDay);
			szTime.Append("T");
			if (vtime.nHour != 0 && vtime.nHour < 10)
			{
				szTime.Append("0");
			}
			szTime.Append((int)vtime.nHour);
			if (vtime.nMin == 0)
			{
				szTime.Append("00");
			}
			else if (vtime.nMin != 0 && vtime.nMin < 10)
			{
				szTime.Append("0");
				szTime.Append((int)vtime.nMin);
			}
			else
			{
				szTime.Append((int)vtime.nMin);
			}
			if (vtime.nSec == 0)
			{
				szTime.Append("00");
			}
			else if (vtime.nSec != 0 && vtime.nSec < 10)
			{
				szTime.Append("0");
				szTime.Append((int)vtime.nSec);
			}
			else
			{
				szTime.Append((int)vtime.nSec);
			}
			if (vtime.bGlobalTime != 0)
			{
				szTime.Append("Z");
			}
		}
	}

	public static void VEventEnd(StringBuilder nbuf)
	{
		if (nbuf != null)
		{
			global::vitem.vitem.VItemAppend(nbuf, "END:VEVENT", null);
		}
	}

	public static void VCalEnd(StringBuilder nbuf)
	{
		if (nbuf != null)
		{
			global::vitem.vitem.VItemAppend(nbuf, "END:VCALENDAR", null);
		}
	}
}
