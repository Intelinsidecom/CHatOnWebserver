using System.Text;

namespace vitemapi;

public static class Lookuptable
{
	public class VCardLookupTable
	{
		public string vCardTagName;

		public int vCardTagNumber;

		public int vCardCharacterSet;

		public int vCardEncodeType;

		public VCardLookupTable(string name, int no, int charset, int enType)
		{
			vCardTagName = name;
			vCardTagNumber = no;
			vCardCharacterSet = charset;
			vCardEncodeType = enType;
		}
	}

	public class VCardTypeTable
	{
		public string pTag;

		public uint nTagNo;

		public VCardTypeTable(string name, uint no)
		{
			pTag = name;
			nTagNo = no;
		}
	}

	public class VCalLookupTable
	{
		public string vCalTagName;

		public int vCalTagNumber;

		public int vCalCharacterSet;

		public int vCalEncodeType;

		public VCalLookupTable(string name, int no, int charset, int enType)
		{
			vCalTagName = name;
			vCalTagNumber = no;
			vCalCharacterSet = charset;
			vCalEncodeType = enType;
		}
	}

	public static VCardLookupTable[] VCARD_LOOKUP_TABLE = new VCardLookupTable[10]
	{
		new VCardLookupTable("NONE", 0, 0, 0),
		new VCardLookupTable("BEGIN", 1, 0, 0),
		new VCardLookupTable("END", 2, 0, 0),
		new VCardLookupTable("VERSION", 3, 0, 0),
		new VCardLookupTable("FN", 4, 4, 0),
		new VCardLookupTable("N", 5, 4, 0),
		new VCardLookupTable("TEL", 6, 0, 0),
		new VCardLookupTable("EMAIL", 7, 4, 0),
		new VCardLookupTable("NOTE", 8, 0, 2),
		new VCardLookupTable("MAX", 10, 0, 0)
	};

	public static VCardTypeTable[] VCARD_TYPE_TABLE = new VCardTypeTable[32]
	{
		new VCardTypeTable("", 0u),
		new VCardTypeTable("PREF", 4u),
		new VCardTypeTable("INTERNET", 262144u),
		new VCardTypeTable("IM", 268435456u),
		new VCardTypeTable("HOME", 1u),
		new VCardTypeTable("WORK", 2u),
		new VCardTypeTable("FAX", 16u),
		new VCardTypeTable("MSG", 32u),
		new VCardTypeTable("CELL", 64u),
		new VCardTypeTable("PAGER", 128u),
		new VCardTypeTable("BBS", 256u),
		new VCardTypeTable("MODEM", 512u),
		new VCardTypeTable("CAR", 1024u),
		new VCardTypeTable("ISDN", 2048u),
		new VCardTypeTable("VIDEO", 4096u),
		new VCardTypeTable("PCS", 8192u),
		new VCardTypeTable("DOM", 16384u),
		new VCardTypeTable("INTL", 32768u),
		new VCardTypeTable("POSTAL", 65536u),
		new VCardTypeTable("PARCEL", 131072u),
		new VCardTypeTable("JPEG", 524288u),
		new VCardTypeTable("BASIC", 1048576u),
		new VCardTypeTable("GRP-ID", 2097152u),
		new VCardTypeTable("MYF-ID", 4194304u),
		new VCardTypeTable("PREF", 4u),
		new VCardTypeTable("HOME", 8388608u),
		new VCardTypeTable("COMPANY", 16777216u),
		new VCardTypeTable("RADIO", 33554432u),
		new VCardTypeTable("TYPE=X-ASSISTANT", 67108864u),
		new VCardTypeTable("TYPE=X-RADIO", 134217728u),
		new VCardTypeTable("VOICE", 8u),
		new VCardTypeTable("", 32u)
	};

	public static VCalLookupTable[] VCAL_LOOKUP_TABLE = new VCalLookupTable[14]
	{
		new VCalLookupTable("NONE", 0, 0, 0),
		new VCalLookupTable("BEGIN", 1, 0, 0),
		new VCalLookupTable("END", 2, 0, 0),
		new VCalLookupTable("VERSION", 3, 0, 0),
		new VCalLookupTable("SUMMARY", 4, 4, 0),
		new VCalLookupTable("DTSTART", 5, 0, 0),
		new VCalLookupTable("DTEND", 6, 0, 0),
		new VCalLookupTable("DESCRIPTION", 7, 4, 0),
		new VCalLookupTable("LOCATION", 8, 4, 0),
		new VCalLookupTable("ATTACH", 9, 0, 2),
		new VCalLookupTable("DTSTART;VALUE=DATE", 10, 0, 0),
		new VCalLookupTable("DTEND;VALUE=DATE", 11, 0, 0),
		new VCalLookupTable("X-MICROSOFT-BODYINK", 12, 0, 1),
		new VCalLookupTable("MAX", 13, 0, 0)
	};

	public static int GetCharset(int TagNumber, VITEMMETHOD Method)
	{
		switch (Method)
		{
		case VITEMMETHOD.VITEM_VCARD:
			if (0 > TagNumber || 10 < TagNumber)
			{
				return 0;
			}
			return VCARD_LOOKUP_TABLE[TagNumber].vCardCharacterSet;
		case VITEMMETHOD.VITEM_CALENDER:
			if (0 > TagNumber || 13 < TagNumber)
			{
				return 0;
			}
			return VCAL_LOOKUP_TABLE[TagNumber].vCalCharacterSet;
		default:
			return 0;
		}
	}

	public static int GetEncodeType(int TagNumber, VITEMMETHOD Method)
	{
		switch (Method)
		{
		case VITEMMETHOD.VITEM_VCARD:
			if (0 > TagNumber || 10 < TagNumber)
			{
				return 0;
			}
			return VCARD_LOOKUP_TABLE[TagNumber].vCardEncodeType;
		case VITEMMETHOD.VITEM_CALENDER:
			if (0 > TagNumber || 13 < TagNumber)
			{
				return 0;
			}
			return VCAL_LOOKUP_TABLE[TagNumber].vCalEncodeType;
		default:
			return 0;
		}
	}

	public static string VItemGetTagString(int TagNumber, VITEMMETHOD Method)
	{
		switch (Method)
		{
		case VITEMMETHOD.VITEM_VCARD:
			if (0 >= TagNumber || 10 < TagNumber)
			{
				return "NONE";
			}
			return VCARD_LOOKUP_TABLE[TagNumber].vCardTagName;
		case VITEMMETHOD.VITEM_CALENDER:
			if (0 > TagNumber || 13 < TagNumber)
			{
				return "NONE";
			}
			return VCAL_LOOKUP_TABLE[TagNumber].vCalTagName;
		default:
			return null;
		}
	}

	public static uint VItemTypeStringToEnum(StringBuilder szType, uint nType)
	{
		byte b = 0;
		if (szType == null)
		{
			return 0u;
		}
		for (b = 0; b < 32; b++)
		{
			if (szType.ToString() == VCARD_TYPE_TABLE[b].pTag)
			{
				nType |= VCARD_TYPE_TABLE[b].nTagNo;
			}
		}
		return nType;
	}

	public static void VCardEnumToTypeString(StringBuilder szType, uint nType)
	{
		byte b = 0;
		if (szType == null || nType == 0)
		{
			return;
		}
		for (b = 1; b < VCARD_TYPE_TABLE.Length; b++)
		{
			if ((nType & VCARD_TYPE_TABLE[b].nTagNo) != 0)
			{
				szType.Append(";");
				szType.Append(VCARD_TYPE_TABLE[b].pTag);
				nType &= ~VCARD_TYPE_TABLE[b].nTagNo;
			}
		}
	}
}
