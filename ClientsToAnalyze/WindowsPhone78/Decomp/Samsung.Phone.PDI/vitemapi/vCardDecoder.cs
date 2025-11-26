using System.Collections.Generic;
using System.Text;
using buf;
using vitem;

namespace vitemapi;

public class vCardDecoder
{
	public static byte DecodevCard(vCard_t vCard, List<Vitemnode> DelTaglist)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder = new StringBuilder(256);
		StringBuilder stringBuilder2 = new StringBuilder(11);
		string obj = "BEGIN:VCARD";
		List<global::buf.buf.slist_t> list = new List<global::buf.buf.slist_t>();
		list.Clear();
		global::buf.buf.slist_t slist_t = new global::buf.buf.slist_t();
		List<Vitemnode> list2 = new List<Vitemnode>();
		list2.Clear();
		if (vCard == null)
		{
			return 2;
		}
		if (stringBuilder2 == null)
		{
			return 2;
		}
		stringBuilder2.Append(vCard.pEncodedData, 0, 11);
		if (!stringBuilder2.Equals(obj) && !vCard.pEncodedData.Contains("END:VCARD"))
		{
			return 2;
		}
		if (stringBuilder == null)
		{
			return 2;
		}
		stringBuilder.Append(vCard.pEncodedData);
		if (stringBuilder.Length == 0)
		{
			return 2;
		}
		list = global::vitem.vitem.VCardList(stringBuilder);
		if (list == null)
		{
			return 4;
		}
		for (int i = 0; i < list.Count; i++)
		{
			slist_t = list[i];
			if (slist_t.pValue == null)
			{
				Vitemnode vitemnode = new Vitemnode();
				vitemnode.nTagType = slist_t.nTagNo;
				vitemnode.nSubTagType = global::vitem.vitem.VCardGetType(slist_t.pTag);
				DelTaglist.Add(vitemnode);
				continue;
			}
			switch (slist_t.nTagNo)
			{
			case 4u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCardGetFN(slist_t, vCard);
				break;
			case 5u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCardGetN(slist_t, vCard);
				break;
			case 6u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCardGetTEL(slist_t, vCard);
				break;
			case 7u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCardGetEMAIL(slist_t, vCard);
				break;
			case 8u:
				vITEM_ERROR_CODE = global::vitem.vitem.VCardGetNOTE(slist_t, vCard);
				break;
			}
			if (vITEM_ERROR_CODE != VITEM_ERROR_CODE.VITEM_OK)
			{
				return (byte)vITEM_ERROR_CODE;
			}
		}
		list.Clear();
		for (int j = 0; j < 4; j++)
		{
			_ = vCard.TELList[j].number;
		}
		return 0;
	}
}
