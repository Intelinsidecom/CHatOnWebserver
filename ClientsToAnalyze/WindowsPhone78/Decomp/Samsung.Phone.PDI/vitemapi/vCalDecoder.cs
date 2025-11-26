using System.Collections.Generic;
using System.Text;
using buf;
using vitem;

namespace vitemapi;

public class vCalDecoder
{
	public static byte DecodevCal(vCalendar_t vCal)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder = new StringBuilder(256);
		StringBuilder stringBuilder2 = new StringBuilder(15);
		string obj = "BEGIN:VCALENDAR";
		List<global::buf.buf.slist_t> list = new List<global::buf.buf.slist_t>();
		list.Clear();
		global::buf.buf.slist_t slist_t = new global::buf.buf.slist_t();
		if (vCal == null)
		{
			return 2;
		}
		if (stringBuilder2 == null)
		{
			return 2;
		}
		stringBuilder2.Append(vCal.pEncodedData, 0, 15);
		if (!stringBuilder2.Equals(obj) && !vCal.pEncodedData.Contains("END:VCALENDAR"))
		{
			return 2;
		}
		if (stringBuilder == null)
		{
			return 2;
		}
		stringBuilder.Append(vCal.pEncodedData);
		if (stringBuilder.Length == 0)
		{
			return 2;
		}
		list = global::vitem.vitem.VCalendarList(stringBuilder);
		if (list == null)
		{
			return 4;
		}
		for (int i = 0; i < list.Count; i++)
		{
			slist_t = list[i];
			switch (slist_t.nTagNo)
			{
			case 4u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCalGetSUMMARY(slist_t, vCal);
				break;
			case 7u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCalGetDESCRIPTION(slist_t, vCal);
				break;
			case 8u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCalGetLOCATION(slist_t, vCal);
				break;
			case 5u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCalGetDTSTART(slist_t, vCal);
				break;
			case 6u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCalGetDTEND(slist_t, vCal);
				break;
			}
		}
		return 0;
	}
}
