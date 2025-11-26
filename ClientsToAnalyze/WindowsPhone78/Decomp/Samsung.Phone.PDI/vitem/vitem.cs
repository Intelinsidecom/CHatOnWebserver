using System;
using System.Collections.Generic;
using System.Text;
using base64;
using buf;
using mem;
using utf8;
using vitemapi;

namespace vitem;

public class vitem
{
	public struct vitem_item_t
	{
		public uint nTagNo;

		public string pTag;

		public string pValue;
	}

	private enum DT_STRING_LEN
	{
		GEN_DT_LEN = 15,
		GLOBAL_DT_LEN
	}

	private static int VITEM_FOLDING_LINE = 75;

	public static void VItemEncodeData(StringBuilder Out, string Data, int nCharset, int nEncodeType, byte nIsEscape)
	{
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		string text = "\\;";
		if (Out == null || Data == null)
		{
			return;
		}
		num2 = Data.Length;
		num = (num2 + 2) * 3;
		StringBuilder stringBuilder = new StringBuilder(num);
		if (stringBuilder == null)
		{
			return;
		}
		switch ((VITEMCHARACTERSET)nCharset)
		{
		case VITEMCHARACTERSET.VITEM_CHARSET_UTF8:
			stringBuilder.Clear();
			stringBuilder.Append(Data, 0, num2);
			break;
		case VITEMCHARACTERSET.VITEM_CHARSET_LATIN1:
			stringBuilder.Clear();
			stringBuilder.Append(Data, 0, num2);
			break;
		case VITEMCHARACTERSET.VITEM_CHARSET_ASCII:
			stringBuilder.Clear();
			stringBuilder.Append(Data, 0, num2);
			break;
		case VITEMCHARACTERSET.VITEM_CHARSET_SHIFT_JIS:
			stringBuilder.Clear();
			stringBuilder.Append(Data, 0, num2);
			break;
		default:
			stringBuilder.Clear();
			stringBuilder.Append(Data, 0, num2);
			break;
		case VITEMCHARACTERSET.VITEM_CHARSET_UCS2:
			break;
		}
		num = stringBuilder.Length;
		if (nIsEscape == 1 && nEncodeType != 3)
		{
			string source = stringBuilder.ToString();
			if (-1 != global::mem.mem.LibStrchr(source, text[0]) || -1 != global::mem.mem.LibStrchr(source, text[1]))
			{
				string text2 = null;
				num3 = num * 2;
				text2 = new string('\0', num3);
				num = EncodeEscape(stringBuilder, num, text2, num3, text, nCharset);
				stringBuilder.Clear();
				stringBuilder.Append(text2);
			}
		}
		num = stringBuilder.Length;
		switch ((VITEMENCODETYPE)nEncodeType)
		{
		case VITEMENCODETYPE.VITEM_ENCODING_NONE:
			Out.Append(stringBuilder);
			break;
		case VITEMENCODETYPE.VITEM_ENCODING_BASE64:
		{
			StringBuilder dst = global::base64.base64.Base64Encode(stringBuilder);
			Out.Append(stringBuilder);
			break;
		}
		case VITEMENCODETYPE.VITEM_ENCODING_QP:
		{
			num2 = (num + 2) * 3;
			StringBuilder dst = new StringBuilder(new string('\0', num2));
			num3 = global::utf8.utf8.EncodeQP(stringBuilder, num, dst, num2);
			Out.Append(stringBuilder);
			break;
		}
		case VITEMENCODETYPE.VITEM_ENCODING_QP_NO_ESCAPE:
		{
			num2 = (num + 2) * 3;
			StringBuilder dst = new StringBuilder(new string('\0', num2));
			num3 = global::utf8.utf8.EncodeQP2(stringBuilder, num, dst, num2);
			Out.Append(stringBuilder);
			break;
		}
		default:
			Out.Append(stringBuilder);
			break;
		}
	}

	public static void VItemAppendTagEncodeData(StringBuilder nbuf, StringBuilder pTag, string pData, int nCharset, int nEncodeType, byte nIsEscape)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		int num = 0;
		string text = null;
		if (nbuf == null || pTag == null || pData == null || stringBuilder == null)
		{
			return;
		}
		_ = pTag.Length;
		_ = 64;
		VItemEncodeData(stringBuilder, pData, nCharset, nEncodeType, nIsEscape);
		if (stringBuilder == null)
		{
			return;
		}
		num = stringBuilder.Length;
		if (nEncodeType == 2 || nEncodeType == 3)
		{
			text = VitemApplyQPFolding(pTag, pTag.Length, stringBuilder.ToString(), num);
			if (text != null)
			{
				nbuf.Append(text);
				nbuf.Append("\r\n");
			}
		}
		else
		{
			text = VitemApplyEtcFolding(pTag, pTag.Length, stringBuilder.ToString(), num);
			if (text != null)
			{
				nbuf.Append(text);
				nbuf.Append("\r\n");
			}
		}
	}

	private static int EncodeEscape(StringBuilder szSrc, int nSrcLen, string szDest, int nDestLen, string szEscape, int nCharset)
	{
		StringBuilder stringBuilder = null;
		StringBuilder stringBuilder2 = null;
		int num = 0;
		int num2 = 0;
		if (szSrc == null || nSrcLen <= 0)
		{
			return 0;
		}
		stringBuilder = szSrc;
		stringBuilder2 = new StringBuilder(szDest);
		int length = stringBuilder.Length;
		int num3 = 0;
		int num4 = 0;
		while (length != 0 && num < nSrcLen)
		{
			if (-1 != global::mem.mem.LibStrchr(szEscape, stringBuilder[num3]) && (num3 == 0 || stringBuilder[num3] == ';' || (stringBuilder[num3] == '\\' && _isEscapeCharIsEscape(szSrc, stringBuilder, nCharset, 0))))
			{
				stringBuilder2[num4] = '\\';
				num4++;
				num2++;
			}
			stringBuilder2 = stringBuilder;
			num3++;
			num4++;
			num++;
			num2++;
		}
		return num2;
	}

	private static bool _isEscapeCharIsEscape(StringBuilder pBase, StringBuilder pWork, int nCharset, int EncodeType)
	{
		bool result = true;
		if (pBase == pWork)
		{
			return result;
		}
		if (nCharset != 7)
		{
			result = EncodeType != 2 || true;
		}
		return result;
	}

	public static byte GetIsEscape()
	{
		return 0;
	}

	public static void VItemAppend(StringBuilder nBuf, string Prefix, string Data)
	{
		if (nBuf != null)
		{
			nBuf.Append(Prefix);
			if (Data != null)
			{
				nBuf.Append(Data);
			}
			nBuf.Append("\r\n");
		}
	}

	public static string VitemApplyQPFolding(StringBuilder tag, int taglen, string data, int datalen)
	{
		string text = null;
		StringBuilder stringBuilder = null;
		int num = taglen + datalen;
		stringBuilder = new StringBuilder(new string('\0', num));
		if (stringBuilder == null)
		{
			return null;
		}
		stringBuilder.Clear();
		stringBuilder.Append(tag);
		stringBuilder.Append(data);
		return VItemApplyFolding(stringBuilder, num, VITEMENCODETYPE.VITEM_ENCODING_QP);
	}

	public static string VitemApplyEtcFolding(StringBuilder tag, int taglen, string data, int datalen)
	{
		string text = null;
		StringBuilder stringBuilder = null;
		int num = taglen + datalen;
		stringBuilder = new StringBuilder(num);
		if (stringBuilder == null || tag == null)
		{
			return null;
		}
		stringBuilder.Clear();
		stringBuilder.Append(tag);
		stringBuilder.Append(data);
		return VItemApplyFolding(stringBuilder, num, VITEMENCODETYPE.VITEM_ENCODING_NONE);
	}

	private static string VItemApplyFolding(StringBuilder data, int datalen, VITEMENCODETYPE EncType)
	{
		StringBuilder stringBuilder = null;
		StringBuilder stringBuilder2 = null;
		StringBuilder stringBuilder3 = null;
		int num = datalen;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		if (data == null || datalen == 0)
		{
			return null;
		}
		num2 = (int)(datalen + (uint)(datalen / VITEM_FOLDING_LINE * 3) + 10);
		stringBuilder3 = new StringBuilder(new string('\0', num2));
		if (stringBuilder3 == null)
		{
			return null;
		}
		stringBuilder = data;
		stringBuilder2 = stringBuilder3;
		if (EncType == VITEMENCODETYPE.VITEM_ENCODING_QP)
		{
			while (num > 0)
			{
				if (num > VITEM_FOLDING_LINE)
				{
					byte b = 0;
					b = 0;
					while (stringBuilder[VITEM_FOLDING_LINE - b] != '=' && b < 3)
					{
						b++;
					}
					if (b > 0 && b < 3)
					{
						global::mem.mem.LibMemcpy(stringBuilder2, num3, stringBuilder, num4, VITEM_FOLDING_LINE - b);
						num3 += VITEM_FOLDING_LINE - b;
						num4 += VITEM_FOLDING_LINE - b;
						num -= VITEM_FOLDING_LINE - b;
					}
					else
					{
						global::mem.mem.LibMemcpy(stringBuilder2, num3, stringBuilder, num4, VITEM_FOLDING_LINE);
						num3 += VITEM_FOLDING_LINE;
						num4 += VITEM_FOLDING_LINE;
						num -= VITEM_FOLDING_LINE;
					}
					stringBuilder2[num3++] = '=';
					stringBuilder2[num3++] = '\r';
					stringBuilder2[num3++] = '\n';
				}
				else
				{
					global::mem.mem.LibMemcpy(stringBuilder2, num3, stringBuilder, num4, num);
					num3 += num;
					num4 += num;
					num = 0;
				}
			}
		}
		else
		{
			while (num > 0)
			{
				if (num > VITEM_FOLDING_LINE)
				{
					global::mem.mem.LibMemcpy(stringBuilder2, num3, stringBuilder, num4, VITEM_FOLDING_LINE);
					num3 += VITEM_FOLDING_LINE;
					num4 += VITEM_FOLDING_LINE;
					num -= VITEM_FOLDING_LINE;
					stringBuilder2[num3++] = '\r';
					stringBuilder2[num3++] = '\n';
					stringBuilder2[num3++] = ' ';
				}
				else
				{
					global::mem.mem.LibMemcpy(stringBuilder2, num3, stringBuilder, num4, num);
					num = 0;
				}
			}
		}
		char[] array = new char[1];
		char[] trimChars = array;
		string text = stringBuilder3.ToString();
		return text.Trim(trimChars);
	}

	public static string skipSpace(string str)
	{
		char[] trimChars = new char[4] { ' ', '\t', '\r', '\n' };
		return str.TrimStart(trimChars);
	}

	public static List<global::buf.buf.slist_t> VCardList(StringBuilder szVCard)
	{
		if (szVCard == null)
		{
			return null;
		}
		return VItemGetList(szVCard, VITEMMETHOD.VITEM_VCARD);
	}

	public static List<global::buf.buf.slist_t> VCalendarList(StringBuilder szVCard)
	{
		if (szVCard == null)
		{
			return null;
		}
		return VItemGetList(szVCard, VITEMMETHOD.VITEM_CALENDER);
	}

	public static List<global::buf.buf.slist_t> VItemGetList(StringBuilder szVCard, VITEMMETHOD Method)
	{
		int num = 0;
		List<global::buf.buf.slist_t> list = new List<global::buf.buf.slist_t>();
		StringBuilder stringBuilder = null;
		StringBuilder stringBuilder2 = null;
		int num2 = 0;
		int num3 = 0;
		StringBuilder stringBuilder3 = null;
		StringBuilder stringBuilder4 = null;
		StringBuilder stringBuilder5 = null;
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		new List<global::buf.buf.slist_t>();
		byte b = 0;
		uint num7 = 0u;
		if (szVCard == null)
		{
			return null;
		}
		stringBuilder = szVCard;
		num7 = (uint)szVCard.Length;
		int length = szVCard.Length;
		int num8 = 0;
		vitem_item_t vitem_item_t = default(vitem_item_t);
		while (length > num8 && stringBuilder.Length != 0 && stringBuilder[num2] != 0 && num2 < num7)
		{
			stringBuilder = stringBuilder.Remove(0, num2);
			num2 = 0;
			string value = skipSpace(stringBuilder.ToString());
			stringBuilder.Clear();
			stringBuilder.Append(value);
			if (stringBuilder.ToString() == null)
			{
				break;
			}
			stringBuilder3 = stringBuilder;
			num4 = num2;
			num5 = 0;
			num6 = 0;
			stringBuilder4 = null;
			stringBuilder5 = null;
			b = 0;
			int length2 = stringBuilder.Length;
			while (length2 > num2 && stringBuilder[num2] != 0)
			{
				if (stringBuilder[num2] == ':' && stringBuilder4 == null)
				{
					stringBuilder4 = stringBuilder;
					num5 = num2 + 1;
					stringBuilder5 = stringBuilder4;
					num6 = num5;
					stringBuilder[num2] = '\0';
					StringBuilder stringBuilder6 = new StringBuilder(256);
					if (stringBuilder6 == null)
					{
						return null;
					}
					stringBuilder6.Append(stringBuilder3);
					stringBuilder6 = global::mem.mem.eliminateNULLChar(num4, stringBuilder6);
					if (stringBuilder6 == null)
					{
						return null;
					}
					if (global::mem.mem.LibStrstr(stringBuilder6.ToString(), "QUOTED-PRINTABLE"))
					{
						b = 1;
					}
					stringBuilder = stringBuilder4;
					num2 = num5;
					continue;
				}
				if (stringBuilder[num2] == '\r')
				{
					stringBuilder2 = stringBuilder;
					num3 = num2;
					num2++;
					if (stringBuilder[num2] == '\n')
					{
						num2++;
						if (length > num8 + num2 && (stringBuilder[num2] == ' ' || stringBuilder[num2] == '\t'))
						{
							num2++;
							continue;
						}
					}
					else if (length > num8 + num2 && (stringBuilder[num2] == ' ' || stringBuilder[num2] == '\t'))
					{
						num2++;
						continue;
					}
					stringBuilder2[num3] = '\0';
					if (stringBuilder5 != null)
					{
						stringBuilder5[num6] = '\0';
					}
					break;
				}
				if (stringBuilder[num2] == '\n')
				{
					stringBuilder2 = stringBuilder;
					num3 = num2;
					num2++;
					if (stringBuilder[num2] != ' ' && stringBuilder[num2] != '\t')
					{
						stringBuilder2[num3] = '\0';
						if (stringBuilder5 != null)
						{
							stringBuilder5[num6] = '\0';
						}
						break;
					}
					num2++;
				}
				else if (stringBuilder[num2] == '=' && b == 1)
				{
					num2++;
					if (stringBuilder[num2] == '\r')
					{
						num2++;
						if (stringBuilder[num2] == '\n')
						{
							num2++;
						}
					}
					else if (stringBuilder[num2] == '\n')
					{
						num2++;
					}
					else if (stringBuilder5 != null)
					{
						stringBuilder5[num6] = stringBuilder[num2 - 1];
						num6++;
					}
				}
				else
				{
					if (stringBuilder5 != null)
					{
						stringBuilder5[num6] = stringBuilder[num2];
						num6++;
					}
					num2++;
				}
			}
			if (stringBuilder4 == null)
			{
				continue;
			}
			StringBuilder stringBuilder7 = new StringBuilder(256);
			if (stringBuilder7 == null)
			{
				return null;
			}
			stringBuilder7.Append(stringBuilder3);
			stringBuilder7 = global::mem.mem.eliminateNULLChar(num4, stringBuilder7);
			if (stringBuilder7 == null)
			{
				return null;
			}
			vitem_item_t.pTag = stringBuilder7.ToString();
			stringBuilder7.Clear();
			stringBuilder7.Append(stringBuilder4);
			stringBuilder7 = global::mem.mem.eliminateNULLChar(num5, stringBuilder7);
			if (stringBuilder7 == null)
			{
				return null;
			}
			vitem_item_t.pValue = stringBuilder7.ToString();
			vitem_item_t.nTagNo = 0u;
			StringBuilder stringBuilder8 = new StringBuilder(256);
			if (stringBuilder8 == null)
			{
				return null;
			}
			stringBuilder8.Append(vitem_item_t.pTag);
			StringBuilder stringBuilder9 = new StringBuilder(new string('\0', 3));
			StringBuilder stringBuilder10 = new StringBuilder(100);
			byte b2 = 0;
			stringBuilder9[0] = ';';
			stringBuilder9[1] = ' ';
			stringBuilder9[2] = '\0';
			stringBuilder8 = VItemGetWordData(stringBuilder8, stringBuilder9, stringBuilder10, stringBuilder10.Capacity, 0, VITEMCHARACTERSET.VITEM_CHARSET_NONE, 0);
			stringBuilder10 = global::mem.mem.eliminateNULLChar(0, stringBuilder10);
			if (stringBuilder8 != null)
			{
				_ = stringBuilder8.Length;
				_ = vitem_item_t.pTag.Length;
			}
			else
			{
				_ = vitem_item_t.pTag.Length;
			}
			if (stringBuilder10 == null)
			{
				return null;
			}
			switch (Method)
			{
			case VITEMMETHOD.VITEM_VCARD:
				for (num = 0; num < 10; num++)
				{
					if (stringBuilder10.ToString() == Lookuptable.VItemGetTagString(num, VITEMMETHOD.VITEM_VCARD))
					{
						vitem_item_t.nTagNo = (uint)num;
						b2 = 1;
						break;
					}
				}
				break;
			case VITEMMETHOD.VITEM_CALENDER:
				for (num = 0; num < 13; num++)
				{
					if (stringBuilder10.ToString() == Lookuptable.VItemGetTagString(num, VITEMMETHOD.VITEM_CALENDER))
					{
						vitem_item_t.nTagNo = (uint)num;
						b2 = 1;
						break;
					}
				}
				break;
			}
			if (b2 == 1)
			{
				global::buf.buf.slist_t slist_t = new global::buf.buf.slist_t();
				slist_t.nTagNo = vitem_item_t.nTagNo;
				slist_t.pTag.Append(vitem_item_t.pTag);
				slist_t.pValue.Append(vitem_item_t.pValue);
				list.Add(slist_t);
			}
			else
			{
				vitem_item_t.nTagNo = 0u;
				vitem_item_t.pTag = null;
				vitem_item_t.pValue = null;
			}
			num8 += num2;
		}
		return list;
	}

	public static StringBuilder VItemGetWordData(StringBuilder szTag, StringBuilder szSeperator, StringBuilder pWord, int nWordlen, byte IsPosition, VITEMCHARACTERSET nCharset, byte EncodingType)
	{
		int num = 0;
		int num2 = 0;
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder == null || szSeperator == null || pWord == null)
		{
			return null;
		}
		int i = 0;
		stringBuilder.Clear();
		stringBuilder.Append(szTag);
		int length = szSeperator.Length;
		byte b = 0;
		if (szTag == null || nWordlen <= 0)
		{
			return null;
		}
		if (IsPosition == 0)
		{
			int length2 = stringBuilder.Length;
			while (true)
			{
				if (length2 > i)
				{
					b = 0;
					for (num = 0; num < length; num++)
					{
						if (stringBuilder[i] == szSeperator[num])
						{
							b = 1;
							break;
						}
					}
					if (b != 1)
					{
						break;
					}
					i++;
					continue;
				}
				return null;
			}
		}
		for (int length2 = stringBuilder.Length; length2 > i; i++)
		{
			if (stringBuilder[i] == '\\' && _isEscapeCharIsEscape(szTag, stringBuilder, (int)nCharset, EncodingType))
			{
				pWord.Append(stringBuilder[i]);
				num2++;
				pWord.Append(stringBuilder[i + 1]);
				num2++;
				i++;
				continue;
			}
			for (num = 0; num < length; num++)
			{
				if (stringBuilder[i] == szSeperator[num])
				{
					if (IsPosition == 1)
					{
						i++;
					}
					if (num2 >= nWordlen - 1)
					{
						pWord.Append('\0');
					}
					else
					{
						pWord.Append('\0');
						num2++;
					}
					return stringBuilder.Remove(0, i);
				}
			}
			if (num2 < nWordlen)
			{
				pWord.Append(stringBuilder[i]);
				num2++;
			}
		}
		return null;
	}

	public static uint VCardGetType(StringBuilder szTag)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder == null)
		{
			return 0u;
		}
		if (szTag == null)
		{
			return 0u;
		}
		stringBuilder.Clear();
		stringBuilder.Append(szTag);
		uint num = 0u;
		StringBuilder stringBuilder2 = new StringBuilder(30);
		StringBuilder stringBuilder3 = new StringBuilder(new string('\0', 6));
		int index = 0;
		stringBuilder3[0] = ':';
		stringBuilder3[1] = ';';
		stringBuilder3[2] = '=';
		stringBuilder3[3] = ' ';
		stringBuilder3[4] = ',';
		stringBuilder3[5] = '\0';
		_ = stringBuilder.Length;
		while (stringBuilder != null)
		{
			if (stringBuilder2 == null)
			{
				return 0u;
			}
			stringBuilder = VItemGetWordData(stringBuilder, stringBuilder3, stringBuilder2, stringBuilder2.Capacity, 0, VITEMCHARACTERSET.VITEM_CHARSET_NONE, 0);
			if (stringBuilder2 == null)
			{
				return 0u;
			}
			stringBuilder2 = global::mem.mem.eliminateNULLChar(0, stringBuilder2);
			if (stringBuilder2 == null)
			{
				return 0u;
			}
			if (stringBuilder2[index] != 0)
			{
				num = Lookuptable.VItemTypeStringToEnum(stringBuilder2, num);
				stringBuilder2.Clear();
			}
		}
		return num;
	}

	public static VITEM_ERROR_CODE VCardGetFN(global::buf.buf.slist_t item, vCard_t vCard)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		int bufLen = 600;
		vITEM_ERROR_CODE = VItemGetString(item, stringBuilder, bufLen, VITEMMETHOD.VITEM_VCARD);
		vCard.FN = stringBuilder.ToString();
		return vITEM_ERROR_CODE;
	}

	public static VITEM_ERROR_CODE VItemGetString(global::buf.buf.slist_t item, StringBuilder pString, int BufLen, VITEMMETHOD Method)
	{
		VITEMENCODETYPE vITEMENCODETYPE = VITEMENCODETYPE.VITEM_ENCODING_NONE;
		VITEMCHARACTERSET vITEMCHARACTERSET = VITEMCHARACTERSET.VITEM_CHARSET_NONE;
		byte b = 0;
		if (item == null || BufLen == 0 || pString == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		vITEMENCODETYPE = CheckEncoding(item.pTag.ToString());
		vITEMCHARACTERSET = CheckCharset(item.pTag.ToString());
		b = GetIsEscape();
		if (vITEMCHARACTERSET == VITEMCHARACTERSET.VITEM_CHARSET_NONE)
		{
			vITEMCHARACTERSET = GetDefaultCharset();
		}
		if (vITEMENCODETYPE == VITEMENCODETYPE.VITEM_ENCODING_QP)
		{
			switch (Method)
			{
			case VITEMMETHOD.VITEM_VCARD:
				if (Lookuptable.GetEncodeType((int)item.nTagNo, VITEMMETHOD.VITEM_VCARD) == 3)
				{
					vITEMENCODETYPE = VITEMENCODETYPE.VITEM_ENCODING_QP_NO_ESCAPE;
				}
				break;
			case VITEMMETHOD.VITEM_CALENDER:
				if (Lookuptable.GetEncodeType((int)item.nTagNo, VITEMMETHOD.VITEM_CALENDER) == 3)
				{
					vITEMENCODETYPE = VITEMENCODETYPE.VITEM_ENCODING_QP_NO_ESCAPE;
				}
				break;
			}
		}
		if (DecodingValue(item.pValue, item.pValue.Length, pString, BufLen, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, b) == 0)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		return VITEM_ERROR_CODE.VITEM_OK;
	}

	public static VITEMENCODETYPE CheckEncoding(string pTag)
	{
		VITEMENCODETYPE vITEMENCODETYPE = VITEMENCODETYPE.VITEM_ENCODING_NONE;
		if (global::mem.mem.LibStristr(pTag, "QUOTED-PRINTABLE"))
		{
			return VITEMENCODETYPE.VITEM_ENCODING_QP;
		}
		if (global::mem.mem.LibStristr(pTag, "BASE64"))
		{
			return VITEMENCODETYPE.VITEM_ENCODING_BASE64;
		}
		if (global::mem.mem.LibStristr(pTag, "7BIT"))
		{
			return VITEMENCODETYPE.VITEM_ENCODING_7BIT;
		}
		if (global::mem.mem.LibStristr(pTag, "8BIT"))
		{
			return VITEMENCODETYPE.VITEM_ENCODING_8BIT;
		}
		return VITEMENCODETYPE.VITEM_ENCODING_NONE;
	}

	public static VITEMCHARACTERSET CheckCharset(string pTag)
	{
		VITEMCHARACTERSET vITEMCHARACTERSET = VITEMCHARACTERSET.VITEM_CHARSET_NONE;
		if (global::mem.mem.LibStristr(pTag, "UTF-8"))
		{
			return VITEMCHARACTERSET.VITEM_CHARSET_UTF8;
		}
		if (global::mem.mem.LibStristr(pTag, "ISO-8859-1"))
		{
			return VITEMCHARACTERSET.VITEM_CHARSET_LATIN1;
		}
		if (global::mem.mem.LibStristr(pTag, "ASCII"))
		{
			return VITEMCHARACTERSET.VITEM_CHARSET_ASCII;
		}
		if (global::mem.mem.LibStristr(pTag, "UTF-7"))
		{
			return VITEMCHARACTERSET.VITEM_CHARSET_UTF7;
		}
		if (global::mem.mem.LibStristr(pTag, "UCS2"))
		{
			return VITEMCHARACTERSET.VITEM_CHARSET_UCS2;
		}
		if (global::mem.mem.LibStristr(pTag, "SHIFT_JIS"))
		{
			return VITEMCHARACTERSET.VITEM_CHARSET_SHIFT_JIS;
		}
		return VITEMCHARACTERSET.VITEM_CHARSET_NONE;
	}

	public static VITEMCHARACTERSET GetDefaultCharset()
	{
		return VITEMCHARACTERSET.VITEM_CHARSET_UTF8;
	}

	public static int DecodingValue(StringBuilder Data, int DataLen, StringBuilder Target, int TargetLen, byte EncodingType, VITEMCHARACTERSET nCharset, byte nIsEscape)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder == null)
		{
			return 0;
		}
		int num = 0;
		if (Data == null || DataLen == 0)
		{
			return 0;
		}
		if (DataLen >= 3400)
		{
			StringBuilder stringBuilder2 = new StringBuilder(3400);
			global::mem.mem.LibMemcpy(stringBuilder2, 0, Data, 0, 3400);
			Data.Clear();
			Data.Append(stringBuilder2);
		}
		if (nIsEscape == 1 && EncodingType != 3)
		{
			DataLen = DecodeEscape(Data, DataLen, (byte)nCharset, EncodingType);
		}
		switch (EncodingType)
		{
		case 2:
		case 3:
			stringBuilder.Clear();
			stringBuilder.Append('\0', Data.Length);
			global::utf8.utf8.DecodeQP(Data, DataLen, stringBuilder);
			num = stringBuilder.Length;
			break;
		case 1:
			stringBuilder = global::base64.base64.Base64Decode(Data);
			break;
		default:
			stringBuilder.Clear();
			stringBuilder.Append(Data);
			break;
		}
		switch (nCharset)
		{
		case VITEMCHARACTERSET.VITEM_CHARSET_UTF8:
			Target.Clear();
			Target.Append(stringBuilder);
			break;
		default:
			Target.Clear();
			Target.Append(stringBuilder);
			break;
		case VITEMCHARACTERSET.VITEM_CHARSET_LATIN1:
		case VITEMCHARACTERSET.VITEM_CHARSET_SHIFT_JIS:
			break;
		}
		return 1;
	}

	public static int DecodeEscape(StringBuilder szSrc, int nSrcLen, byte nCharset, byte EncodingType)
	{
		int num = 0;
		int num2 = 0;
		int num3 = nSrcLen;
		int num4 = 0;
		if (szSrc != null || nSrcLen <= 0)
		{
			return nSrcLen;
		}
		int length = szSrc.Length;
		do
		{
			if (szSrc == null || szSrc == null)
			{
				return 0;
			}
			if (szSrc[num] == '\\')
			{
				if (_isEscapeCharIsEscape(szSrc, szSrc, nCharset, EncodingType))
				{
					szSrc[num] = szSrc[num + 1];
					num++;
					num2++;
					num3--;
				}
				else
				{
					szSrc[num2] = szSrc[num];
					num2++;
				}
			}
			else
			{
				szSrc[num2] = szSrc[num];
				num2++;
			}
			num++;
			num3--;
			num4++;
		}
		while (length > num && num3 > 0);
		StringBuilder stringBuilder = new StringBuilder(num2);
		global::mem.mem.LibMemcpy(stringBuilder, 0, szSrc, 0, num2);
		szSrc.Clear();
		szSrc.Append(stringBuilder);
		return num4;
	}

	public static VITEM_ERROR_CODE VCardGetN(global::buf.buf.slist_t item, vCard_t vCard)
	{
		VITEMENCODETYPE vITEMENCODETYPE = VITEMENCODETYPE.VITEM_ENCODING_NONE;
		StringBuilder stringBuilder = new StringBuilder(1024);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_INVALID_FORMAT;
		}
		byte nIsEscape = 1;
		VITEM_ERROR_CODE result = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder2 = new StringBuilder(new string('\0', 2));
		if (stringBuilder2 == null)
		{
			return VITEM_ERROR_CODE.VITEM_INVALID_FORMAT;
		}
		StringBuilder stringBuilder3 = null;
		byte b = 0;
		StringBuilder stringBuilder4 = new StringBuilder(256);
		if (stringBuilder4 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		vITEMENCODETYPE = CheckEncoding(item.pTag.ToString());
		VITEMCHARACTERSET vITEMCHARACTERSET = CheckCharset(item.pTag.ToString());
		if (vITEMCHARACTERSET == VITEMCHARACTERSET.VITEM_CHARSET_NONE)
		{
			vITEMCHARACTERSET = GetDefaultCharset();
		}
		stringBuilder2[0] = ';';
		stringBuilder2[1] = '\0';
		stringBuilder3 = item.pValue;
		if (stringBuilder3 == null)
		{
			return VITEM_ERROR_CODE.VITEM_INVALID_PARAM;
		}
		for (b = 0; b < 5; b++)
		{
			stringBuilder3 = VItemGetWordData(stringBuilder3, stringBuilder2, stringBuilder, 1024, 1, vITEMCHARACTERSET, (byte)vITEMENCODETYPE);
			if (stringBuilder == null)
			{
				return VITEM_ERROR_CODE.VITEM_INVALID_FORMAT;
			}
			stringBuilder = global::mem.mem.eliminateNULLChar(0, stringBuilder);
			if (stringBuilder == null)
			{
				return VITEM_ERROR_CODE.VITEM_INVALID_FORMAT;
			}
			if (stringBuilder != null && stringBuilder.ToString() != "")
			{
				switch (b)
				{
				case 0:
					stringBuilder4.Clear();
					DecodingValue(stringBuilder, stringBuilder.Length, stringBuilder4, 600, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, nIsEscape);
					vCard.N.family = stringBuilder4.ToString();
					break;
				case 1:
					stringBuilder4.Clear();
					DecodingValue(stringBuilder, stringBuilder.Length, stringBuilder4, 600, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, nIsEscape);
					vCard.N.given = stringBuilder4.ToString();
					break;
				case 2:
					stringBuilder4.Clear();
					DecodingValue(stringBuilder, stringBuilder.Length, stringBuilder4, 600, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, nIsEscape);
					vCard.N.addition = stringBuilder4.ToString();
					break;
				case 3:
					stringBuilder4.Clear();
					DecodingValue(stringBuilder, stringBuilder.Length, stringBuilder4, 600, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, nIsEscape);
					vCard.N.prefix = stringBuilder4.ToString();
					break;
				case 4:
					stringBuilder4.Clear();
					DecodingValue(stringBuilder, stringBuilder.Length, stringBuilder4, 600, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, nIsEscape);
					vCard.N.suffix = stringBuilder4.ToString();
					break;
				}
				stringBuilder.Clear();
			}
		}
		if (vCard.N.family != null || vCard.N.given != null || vCard.N.addition != null || vCard.N.prefix != null || vCard.N.suffix != null)
		{
			vCard.N.isValid = 1;
			result = VITEM_ERROR_CODE.VITEM_OK;
		}
		else
		{
			vCard.N.addition = null;
			vCard.N.family = null;
			vCard.N.given = null;
			vCard.N.prefix = null;
			vCard.N.suffix = null;
			vCard.N.isValid = 0;
		}
		return result;
	}

	public static VITEM_ERROR_CODE VCardGetTEL(global::buf.buf.slist_t item, vCard_t vCard)
	{
		VITEMENCODETYPE vITEMENCODETYPE = VITEMENCODETYPE.VITEM_ENCODING_NONE;
		VITEMCHARACTERSET vITEMCHARACTERSET = VITEMCHARACTERSET.VITEM_CHARSET_NONE;
		byte nIsEscape = 0;
		vCardTelNumber_t vCardTelNumber_t = default(vCardTelNumber_t);
		VITEM_ERROR_CODE result = VITEM_ERROR_CODE.VITEM_OK;
		vITEMENCODETYPE = CheckEncoding(item.pTag.ToString());
		vITEMCHARACTERSET = CheckCharset(item.pTag.ToString());
		if (isValidPhoneNumber(item.pValue))
		{
			if (!vCardTelNumber_t.Equals(null))
			{
				vCardTelNumber_t.type = VCardGetType(item.pTag);
				StringBuilder stringBuilder = new StringBuilder(20);
				if (stringBuilder == null)
				{
					return VITEM_ERROR_CODE.VITEM_ERROR;
				}
				stringBuilder.Clear();
				DecodingValue(item.pValue, item.pValue.Length, stringBuilder, 600, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, nIsEscape);
				vCardTelNumber_t.number = stringBuilder.ToString();
			}
		}
		else
		{
			result = VITEM_ERROR_CODE.VITEM_INVALID_FORMAT;
		}
		if ((vCardTelNumber_t.type & 0x10) != 0)
		{
			vCard.TELList[0].number = vCardTelNumber_t.number;
			vCard.TELList[0].type = vCardTelNumber_t.type;
		}
		else if ((vCardTelNumber_t.type & 2) != 0)
		{
			vCard.TELList[1].number = vCardTelNumber_t.number;
			vCard.TELList[1].type = vCardTelNumber_t.type;
		}
		else if ((vCardTelNumber_t.type & 1) != 0)
		{
			vCard.TELList[2].number = vCardTelNumber_t.number;
			vCard.TELList[2].type = vCardTelNumber_t.type;
		}
		else if ((vCardTelNumber_t.type & 0x40) != 0)
		{
			vCard.TELList[3].number = vCardTelNumber_t.number;
			vCard.TELList[3].type = vCardTelNumber_t.type;
		}
		return result;
	}

	public static bool isValidPhoneNumber(StringBuilder number)
	{
		int num = 0;
		int num2 = 0;
		StringBuilder stringBuilder = new StringBuilder(128);
		if (stringBuilder == null)
		{
			return false;
		}
		int num3 = 0;
		if (number[0] != 0)
		{
			num = number.Length;
			stringBuilder.Append(number);
			for (num2 = 0; num2 < num; num2++)
			{
				if (num2 == 0 && number[num2] == '+')
				{
					stringBuilder[num3] = number[num2];
					num3++;
				}
				else if ((number[num2] >= '0' && number[num2] <= '9') || number[num2] == '*' || number[num2] == '#' || number[num2] == 'P' || number[num2] == 'p')
				{
					stringBuilder[num3] = number[num2];
					num3++;
				}
			}
			return true;
		}
		return false;
	}

	public static VITEM_ERROR_CODE VCardGetEMAIL(global::buf.buf.slist_t item, vCard_t vCard)
	{
		VITEMENCODETYPE vITEMENCODETYPE = VITEMENCODETYPE.VITEM_ENCODING_NONE;
		VITEMCHARACTERSET vITEMCHARACTERSET = VITEMCHARACTERSET.VITEM_CHARSET_NONE;
		byte b = 0;
		vCardEmail_t vCardEmail_t = default(vCardEmail_t);
		VITEM_ERROR_CODE result = VITEM_ERROR_CODE.VITEM_OK;
		vITEMENCODETYPE = CheckEncoding(item.pTag.ToString());
		vITEMCHARACTERSET = CheckCharset(item.pTag.ToString());
		b = GetIsEscape();
		if (!vCardEmail_t.Equals(null))
		{
			vCardEmail_t.type = VCardGetType(item.pTag);
			StringBuilder stringBuilder = new StringBuilder(256);
			stringBuilder.Clear();
			DecodingValue(item.pValue, item.pValue.Length, stringBuilder, 600, (byte)vITEMENCODETYPE, vITEMCHARACTERSET, b);
			vCardEmail_t.email = stringBuilder.ToString();
			if (vCardEmail_t.email[0] != 0)
			{
				if (!IsValidEmail(vCardEmail_t.email, vITEMCHARACTERSET))
				{
					vCardEmail_t.email = null;
					vCardEmail_t.type = 0u;
					result = VITEM_ERROR_CODE.VITEM_NOT_FOUND_VALUE;
				}
			}
			else
			{
				vCardEmail_t.email = null;
				vCardEmail_t.type = 0u;
				result = VITEM_ERROR_CODE.VITEM_NOT_FOUND_VALUE;
			}
		}
		vCard.EMAILList[0].email = vCardEmail_t.email;
		vCard.EMAILList[0].type = vCardEmail_t.type;
		return result;
	}

	public static bool IsValidEmail(string pEmail, VITEMCHARACTERSET nCharSet)
	{
		if (pEmail == null)
		{
			return false;
		}
		if (pEmail.Contains(" ") || !pEmail.Contains("@"))
		{
			return false;
		}
		return true;
	}

	public static VITEM_ERROR_CODE VCardGetNOTE(global::buf.buf.slist_t item, vCard_t vCard)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		vITEM_ERROR_CODE = VItemGetString(item, stringBuilder, 600, VITEMMETHOD.VITEM_VCARD);
		vCard.NOTE = stringBuilder.ToString();
		return vITEM_ERROR_CODE;
	}

	public static VITEM_ERROR_CODE VCalGetSUMMARY(global::buf.buf.slist_t item, vCalendar_t vCal)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		int bufLen = 600;
		StringBuilder stringBuilder = new StringBuilder(128);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder.Append(vCal.SUMMARY);
		vITEM_ERROR_CODE = VItemGetString(item, stringBuilder, bufLen, VITEMMETHOD.VITEM_CALENDER);
		vCal.SUMMARY = stringBuilder.ToString();
		return vITEM_ERROR_CODE;
	}

	public static VITEM_ERROR_CODE VCalGetDESCRIPTION(global::buf.buf.slist_t item, vCalendar_t vCal)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		int bufLen = 600;
		StringBuilder stringBuilder = new StringBuilder(128);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder.Append(vCal.DESCRIPTION);
		vITEM_ERROR_CODE = VItemGetString(item, stringBuilder, bufLen, VITEMMETHOD.VITEM_CALENDER);
		vCal.DESCRIPTION = stringBuilder.ToString();
		return vITEM_ERROR_CODE;
	}

	public static VITEM_ERROR_CODE VCalGetLOCATION(global::buf.buf.slist_t item, vCalendar_t vCal)
	{
		VITEM_ERROR_CODE vITEM_ERROR_CODE = VITEM_ERROR_CODE.VITEM_OK;
		int bufLen = 600;
		StringBuilder stringBuilder = new StringBuilder(128);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder.Append(vCal.LOCATION);
		vITEM_ERROR_CODE = VItemGetString(item, stringBuilder, bufLen, VITEMMETHOD.VITEM_CALENDER);
		vCal.LOCATION = stringBuilder.ToString();
		return vITEM_ERROR_CODE;
	}

	public static VITEM_ERROR_CODE VCalGetDTSTART(global::buf.buf.slist_t item, vCalendar_t vCal)
	{
		VITEM_ERROR_CODE result = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder = new StringBuilder(4);
		StringBuilder stringBuilder2 = new StringBuilder(2);
		StringBuilder stringBuilder3 = new StringBuilder(2);
		StringBuilder stringBuilder4 = new StringBuilder(2);
		StringBuilder stringBuilder5 = new StringBuilder(2);
		StringBuilder stringBuilder6 = new StringBuilder(2);
		StringBuilder stringBuilder7 = new StringBuilder(1);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder.Append(vCal.StartDate.nYear);
		if (stringBuilder2 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder2.Append(vCal.StartDate.nMonth);
		if (stringBuilder3 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder3.Append(vCal.StartDate.nDay);
		if (stringBuilder4 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder4.Append(vCal.StartDate.nHour);
		if (stringBuilder5 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder5.Append(vCal.StartDate.nMin);
		if (stringBuilder6 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder6.Append(vCal.StartDate.nSec);
		if (stringBuilder7 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder7.Append(vCal.StartDate.bGlobalTime);
		if (item.pValue != null)
		{
			VItemStringTimeToVItemTime(item.pValue.ToString(), stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, stringBuilder5, stringBuilder6, stringBuilder7);
			vCal.StartDate.nYear = Convert.ToUInt32(stringBuilder.ToString());
			vCal.StartDate.nMonth = Convert.ToUInt32(stringBuilder2.ToString());
			vCal.StartDate.nDay = Convert.ToUInt32(stringBuilder3.ToString());
			vCal.StartDate.nHour = Convert.ToUInt32(stringBuilder4.ToString());
			vCal.StartDate.nMin = Convert.ToUInt32(stringBuilder5.ToString());
			vCal.StartDate.nSec = Convert.ToUInt32(stringBuilder6.ToString());
			vCal.StartDate.bGlobalTime = Convert.ToUInt32(stringBuilder7.ToString());
			if (isValidDateTime(vCal.StartDate) == 0)
			{
				result = VITEM_ERROR_CODE.VITEM_INVALID_FORMAT;
			}
			vCal.StartDate.isValid = 1;
		}
		else
		{
			result = VITEM_ERROR_CODE.VITEM_NOT_FOUND_VALUE;
		}
		return result;
	}

	public static VITEM_ERROR_CODE VCalGetDTEND(global::buf.buf.slist_t item, vCalendar_t vCal)
	{
		VITEM_ERROR_CODE result = VITEM_ERROR_CODE.VITEM_OK;
		StringBuilder stringBuilder = new StringBuilder(4);
		StringBuilder stringBuilder2 = new StringBuilder(2);
		StringBuilder stringBuilder3 = new StringBuilder(2);
		StringBuilder stringBuilder4 = new StringBuilder(2);
		StringBuilder stringBuilder5 = new StringBuilder(2);
		StringBuilder stringBuilder6 = new StringBuilder(2);
		StringBuilder stringBuilder7 = new StringBuilder(1);
		if (stringBuilder == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder.Append(vCal.EndDate.nYear);
		if (stringBuilder2 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder2.Append(vCal.EndDate.nMonth);
		if (stringBuilder3 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder3.Append(vCal.EndDate.nDay);
		if (stringBuilder4 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder4.Append(vCal.EndDate.nHour);
		if (stringBuilder5 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder5.Append(vCal.EndDate.nMin);
		if (stringBuilder6 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder6.Append(vCal.EndDate.nSec);
		if (stringBuilder7 == null)
		{
			return VITEM_ERROR_CODE.VITEM_ERROR;
		}
		stringBuilder7.Append(vCal.EndDate.bGlobalTime);
		if (item.pValue != null)
		{
			VItemStringTimeToVItemTime(item.pValue.ToString(), stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, stringBuilder5, stringBuilder6, stringBuilder7);
			vCal.EndDate.nYear = Convert.ToUInt32(stringBuilder.ToString());
			vCal.EndDate.nMonth = Convert.ToUInt32(stringBuilder2.ToString());
			vCal.EndDate.nDay = Convert.ToUInt32(stringBuilder3.ToString());
			vCal.EndDate.nHour = Convert.ToUInt32(stringBuilder4.ToString());
			vCal.EndDate.nMin = Convert.ToUInt32(stringBuilder5.ToString());
			vCal.EndDate.nSec = Convert.ToUInt32(stringBuilder6.ToString());
			vCal.EndDate.bGlobalTime = Convert.ToUInt32(stringBuilder7.ToString());
			if (isValidDateTime(vCal.EndDate) == 0)
			{
				result = VITEM_ERROR_CODE.VITEM_INVALID_FORMAT;
			}
			vCal.EndDate.isValid = 1;
		}
		else
		{
			result = VITEM_ERROR_CODE.VITEM_NOT_FOUND_VALUE;
		}
		return result;
	}

	public static uint VItemStringTimeToVItemTime(string szTime, StringBuilder _year, StringBuilder _month, StringBuilder _date, StringBuilder _hour, StringBuilder _minute, StringBuilder _sec, StringBuilder _global)
	{
		int length = szTime.Length;
		if (length < 15 || length > 16)
		{
			return 0u;
		}
		for (int i = 0; i < 15; i++)
		{
			if ((i != 8 || (szTime[i] != 'T' && szTime[i] != 't')) && (szTime[i] < '0' || szTime[i] > '9'))
			{
				return 0u;
			}
		}
		_year.Clear();
		_month.Clear();
		_date.Clear();
		_hour.Clear();
		_minute.Clear();
		_sec.Clear();
		_global.Clear();
		if (_year == null)
		{
			return 0u;
		}
		_year.Append(szTime, 0, 4);
		if (_month == null)
		{
			return 0u;
		}
		_month.Append(szTime, 4, 2);
		if (_date == null)
		{
			return 0u;
		}
		_date.Append(szTime, 6, 2);
		if (_hour == null)
		{
			return 0u;
		}
		_hour.Append(szTime, 9, 2);
		if (_minute == null)
		{
			return 0u;
		}
		_minute.Append(szTime, 11, 2);
		if (_sec == null)
		{
			return 0u;
		}
		_sec.Append(szTime, 13, 2);
		if (_global == null)
		{
			return 0u;
		}
		if (length == 16 && (szTime[15] == 'Z' || szTime[15] == 'z'))
		{
			_global.Append("1");
		}
		else
		{
			_global.Append("0");
		}
		return 1u;
	}

	private static int isValidDateTime(VItemDate_t pDate)
	{
		int result = 1;
		if (!pDate.Equals(null))
		{
			if (pDate.nYear == 0 || pDate.nYear > 9999)
			{
				result = 0;
			}
			if (pDate.nMonth == 0 || pDate.nMonth > 12)
			{
				result = 0;
			}
			if (pDate.nDay == 0 || pDate.nDay > 31)
			{
				result = 0;
			}
			if (pDate.nMonth == 2 && pDate.nDay > 29)
			{
				result = 0;
			}
			if (pDate.nHour > 24)
			{
				result = 0;
			}
			if (pDate.nMin > 59)
			{
				result = 0;
			}
			if (pDate.nSec > 59)
			{
				result = 0;
			}
		}
		else
		{
			result = 0;
		}
		return result;
	}
}
