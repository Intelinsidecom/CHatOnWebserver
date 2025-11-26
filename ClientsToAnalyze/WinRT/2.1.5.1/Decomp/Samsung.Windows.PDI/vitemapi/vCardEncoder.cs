using System.Text;
using vitem;

namespace vitemapi;

public class vCardEncoder
{
	public static byte EncodevCard(vCard_t vCard)
	{
		StringBuilder stringBuilder = null;
		stringBuilder = VCardBegin("2.1");
		if (stringBuilder == null)
		{
			return 2;
		}
		if (vCard.FN == null || "" == vCard.FN)
		{
			StringBuilder stringBuilder2 = new StringBuilder(256);
			if (stringBuilder2 == null)
			{
				return 4;
			}
			if (vCard.N.family != null && vCard.N.family != "")
			{
				stringBuilder2.Append(vCard.N.family);
				stringBuilder2.Append(" ");
			}
			if (vCard.N.given != null && vCard.N.given != "")
			{
				stringBuilder2.Append(vCard.N.given);
				stringBuilder2.Append(" ");
			}
			if (vCard.N.addition != null && vCard.N.addition != "")
			{
				stringBuilder2.Append(vCard.N.addition);
				stringBuilder2.Append(" ");
			}
			if (vCard.N.prefix != null && vCard.N.prefix != "")
			{
				stringBuilder2.Append(vCard.N.prefix);
				stringBuilder2.Append(" ");
			}
			if (vCard.N.suffix != null && vCard.N.suffix != "")
			{
				stringBuilder2.Append(vCard.N.suffix);
				stringBuilder2.Append(" ");
			}
			vCard.FN = stringBuilder2.ToString();
		}
		VCardItemString(stringBuilder, 4, vCard.FN);
		if (!vCard.N.Equals(null) && vCard.N.isValid == 1)
		{
			VCardN(stringBuilder, vCard.N);
		}
		if (!vCard.EMAILList.Equals(null))
		{
			vCardEmail_t vCardEmail_t2 = default(vCardEmail_t);
			vCardEmail_t2.email = null;
			vCardEmail_t2.type = 0u;
			for (int i = 0; i < 6; i++)
			{
				vCardEmail_t2 = vCard.EMAILList[i];
				if (vCardEmail_t2.email != null)
				{
					VCardEMAIL(stringBuilder, vCardEmail_t2.email, vCardEmail_t2.type);
				}
			}
		}
		if (!vCard.TELList.Equals(null))
		{
			vCardTelNumber_t vCardTelNumber_t2 = default(vCardTelNumber_t);
			vCardTelNumber_t2.number = null;
			vCardTelNumber_t2.type = 0u;
			for (int j = 0; j < 12; j++)
			{
				vCardTelNumber_t2 = vCard.TELList[j];
				if (vCardTelNumber_t2.number != null)
				{
					VCardTEL(stringBuilder, vCardTelNumber_t2.number, vCardTelNumber_t2.type);
				}
			}
		}
		if (vCard.NOTE != null)
		{
			VCardItemString(stringBuilder, 8, vCard.NOTE);
			VCardItemString(stringBuilder, 9, vCard.NOTE);
		}
		VCardEnd(stringBuilder);
		if (stringBuilder == null)
		{
			return 4;
		}
		vCard.pEncodedData = stringBuilder.ToString();
		vCard.nEncodedDataLen = stringBuilder.Length;
		return 0;
	}

	private static StringBuilder VCardBegin(string versionno)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder == null)
		{
			return null;
		}
		global::vitem.vitem.VItemAppend(stringBuilder, "BEGIN:VCARD\r\nVERSION:", versionno);
		return stringBuilder;
	}

	private static void VCardEnd(StringBuilder nbuf)
	{
		global::vitem.vitem.VItemAppend(nbuf, "END:VCARD", null);
	}

	private static void VCardItemString(StringBuilder nbuf, int TagNum, string Data)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder != null)
		{
			int charset = Lookuptable.GetCharset(TagNum, VITEMMETHOD.VITEM_VCARD);
			int encodeType = Lookuptable.GetEncodeType(TagNum, VITEMMETHOD.VITEM_VCARD);
			byte b = 0;
			b = global::vitem.vitem.GetIsEscape();
			string value = Lookuptable.VItemGetTagString(TagNum, VITEMMETHOD.VITEM_VCARD);
			stringBuilder.Append(value);
			CommonMethods.VItemAppendCharSet(stringBuilder, charset);
			CommonMethods.VItemAppendEncodeType(stringBuilder, encodeType);
			stringBuilder.Append(":");
			global::vitem.vitem.VItemAppendTagEncodeData(nbuf, stringBuilder, Data, charset, encodeType, b);
		}
	}

	private static void VCardN(StringBuilder nbuf, vCardName_t name)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		StringBuilder stringBuilder2 = new StringBuilder(256);
		int charset = Lookuptable.GetCharset(5, VITEMMETHOD.VITEM_VCARD);
		int encodeType = Lookuptable.GetEncodeType(5, VITEMMETHOD.VITEM_VCARD);
		byte b = 0;
		if (stringBuilder == null)
		{
			return;
		}
		stringBuilder.Append("N");
		CommonMethods.VItemAppendCharSet(stringBuilder, charset);
		CommonMethods.VItemAppendEncodeType(stringBuilder, encodeType);
		stringBuilder.Append(":");
		nbuf.Append(stringBuilder);
		b = 1;
		if (!name.Equals(null) && name.family.Length > 0)
		{
			if (stringBuilder2 == null)
			{
				return;
			}
			stringBuilder2.Clear();
			global::vitem.vitem.VItemEncodeData(stringBuilder2, name.family, charset, encodeType, b);
			nbuf.Append(stringBuilder2);
		}
		stringBuilder.Clear();
		stringBuilder.Append(";");
		nbuf.Append(stringBuilder);
		if (!name.Equals(null) && name.given.Length > 0)
		{
			stringBuilder2.Clear();
			global::vitem.vitem.VItemEncodeData(stringBuilder2, name.given, charset, encodeType, b);
			nbuf.Append(stringBuilder2);
		}
		stringBuilder.Clear();
		stringBuilder.Append(";");
		nbuf.Append(stringBuilder);
		if (!name.Equals(null) && name.addition.Length > 0)
		{
			stringBuilder2.Clear();
			global::vitem.vitem.VItemEncodeData(stringBuilder2, name.addition, charset, encodeType, b);
			nbuf.Append(stringBuilder2);
		}
		stringBuilder.Clear();
		stringBuilder.Append(";");
		nbuf.Append(stringBuilder);
		if (!name.Equals(null) && name.prefix.Length > 0)
		{
			stringBuilder2.Clear();
			global::vitem.vitem.VItemEncodeData(stringBuilder2, name.prefix, charset, encodeType, b);
			nbuf.Append(stringBuilder2);
		}
		stringBuilder.Clear();
		stringBuilder.Append(";");
		nbuf.Append(stringBuilder);
		if (!name.Equals(null) && name.suffix.Length > 0)
		{
			stringBuilder2.Clear();
			global::vitem.vitem.VItemEncodeData(stringBuilder2, name.suffix, charset, encodeType, b);
			nbuf.Append(stringBuilder2);
		}
		nbuf.Append("\r\n");
	}

	private static void VCardEMAIL(StringBuilder nbuf, string pData, uint nType)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		int charset = Lookuptable.GetCharset(7, VITEMMETHOD.VITEM_VCARD);
		int encodeType = Lookuptable.GetEncodeType(7, VITEMMETHOD.VITEM_VCARD);
		byte b = 0;
		if (!pData.Equals(null))
		{
			b = global::vitem.vitem.GetIsEscape();
			stringBuilder.Append("EMAIL");
			if (nType == 0)
			{
				stringBuilder.Append(";X-UNTYPED");
			}
			else
			{
				Lookuptable.VCardEnumToTypeString(stringBuilder, nType);
			}
			CommonMethods.VItemAppendCharSet(stringBuilder, charset);
			CommonMethods.VItemAppendEncodeType(stringBuilder, encodeType);
			stringBuilder.Append(":");
			global::vitem.vitem.VItemAppendTagEncodeData(nbuf, stringBuilder, pData, charset, encodeType, b);
		}
	}

	private static void VCardTEL(StringBuilder nbuf, string pData, uint nType)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		int num = 0;
		int num2 = 0;
		byte b = 0;
		if (!pData.Equals(null))
		{
			num = Lookuptable.GetCharset(6, VITEMMETHOD.VITEM_VCARD);
			num2 = Lookuptable.GetEncodeType(6, VITEMMETHOD.VITEM_VCARD);
			b = global::vitem.vitem.GetIsEscape();
			stringBuilder.Append("TEL");
			Lookuptable.VCardEnumToTypeString(stringBuilder, nType);
			CommonMethods.VItemAppendCharSet(stringBuilder, num);
			CommonMethods.VItemAppendEncodeType(stringBuilder, num2);
			stringBuilder.Append(":");
			global::vitem.vitem.VItemAppendTagEncodeData(nbuf, stringBuilder, pData, num, num2, b);
			if ((0x4000000 & nType) != 0)
			{
				global::vitem.vitem.VItemAppend(nbuf, "X-MICROSOFT-ASST_TEL:", pData);
			}
		}
	}
}
