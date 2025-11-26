using System;
using System.Text;
using System.Text.RegularExpressions;
using mem;

namespace utf8;

public class utf8
{
	private static string ESPECIALS = "()<>@,:\"/[]?.=";

	private static string ESPECIALS2 = "()<>@,;:\\\"/[]?.=";

	public static int EncodeQP(StringBuilder src, int slen, StringBuilder dst, int dstlen)
	{
		int num = 0;
		int index = 0;
		int num2 = 0;
		if (src == null || slen <= 0 || dstlen <= 0)
		{
			return 0;
		}
		while (slen-- > 0 && num2 < dstlen)
		{
			char c = src[num++];
			if (isEncodedWords(c))
			{
				dst[index++] = '=';
				dst[index++] = ToHexChar(((int)c >> 4) & 0xF);
				dst[index++] = ToHexChar(c & 0xF);
				num2 += 3;
			}
			else
			{
				dst[index++] = c;
				num2++;
			}
		}
		dst[index] = '\0';
		return num2;
	}

	public static int EncodeQP2(StringBuilder src, int slen, StringBuilder dst, int dstlen)
	{
		int num = 0;
		int index = 0;
		int num2 = 0;
		if (src == null || slen <= 0 || dstlen <= 0)
		{
			return 0;
		}
		while (slen-- > 0 && num2 < dstlen)
		{
			char c = src[num++];
			if (isEncodedWords2(c))
			{
				dst[index++] = '=';
				dst[index++] = ToHexChar(((int)c >> 4) & 0xF);
				dst[index++] = ToHexChar(c & 0xF);
				num2 += 3;
			}
			else
			{
				dst[index++] = c;
				num2++;
			}
		}
		dst[index] = '\0';
		return num2;
	}

	private static bool isEncodedWords(char c)
	{
		if (c > ' ' && c < '\u007f' && c != '_')
		{
			return -1 != global::mem.mem.LibStrchr(ESPECIALS, c);
		}
		return true;
	}

	private static bool isEncodedWords2(char c)
	{
		if (c > ' ' && c < '\u007f' && c != '_')
		{
			return -1 != global::mem.mem.LibStrchr(ESPECIALS2, c);
		}
		return true;
	}

	private static char ToHexChar(int nHex)
	{
		if (nHex >= 0 && nHex <= 9)
		{
			return (char)(nHex + 48);
		}
		if (nHex >= 10 && nHex <= 15)
		{
			return (char)(nHex + 65 - 10);
		}
		return '?';
	}

	private static int HexCharToHex(char nHexChar)
	{
		if (nHexChar >= '0' && nHexChar <= '9')
		{
			return nHexChar - 48;
		}
		if (nHexChar >= 'A' && nHexChar <= 'F')
		{
			return nHexChar - 65 + 10;
		}
		return 0;
	}

	public static int DecodeQP(StringBuilder src, int slen, StringBuilder dst)
	{
		byte[] array = new byte[slen];
		int count = 0;
		for (int i = 0; i < slen; i++)
		{
			if (src[i].Equals('='))
			{
				i++;
				if (i < slen)
				{
					char c = src[i++];
					char c2 = src[i];
					string text = string.Format("{0}{1}", new object[2] { c, c2 });
					if (Regex.IsMatch(text, "\\A\\b[0-9a-fA-F]+\\b\\Z"))
					{
						array[count++] = (byte)Convert.ToInt32(text, 16);
						continue;
					}
					array[count++] = (byte)Convert.ToInt32(c);
					array[count++] = (byte)Convert.ToInt32(c2);
				}
			}
			else
			{
				array[count++] = (byte)Convert.ToInt32(src[i]);
			}
		}
		string value = Encoding.UTF8.GetString(array, 0, count);
		dst.Clear();
		dst.Append(value);
		return dst.Length;
	}
}
