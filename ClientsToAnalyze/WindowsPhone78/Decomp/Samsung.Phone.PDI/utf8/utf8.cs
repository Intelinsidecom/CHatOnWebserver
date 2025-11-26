using System.Text;
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
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		if (src == null || slen <= 0)
		{
			return 0;
		}
		while (slen-- != 0)
		{
			if (src[num] == '=')
			{
				if (src[num + 1] == '\r' && src[num + 2] == '\n')
				{
					num += 3;
					slen -= 2;
					while (src[num] == ' ' || src[num] == '\t')
					{
						num++;
						slen--;
					}
					continue;
				}
				num++;
				char c = (char)((HexCharToHex(src[num++]) << 4) & 0xF0);
				dst[num2++] = (char)(c | (ushort)HexCharToHex(src[num++]));
				slen -= 2;
				num3++;
				if (slen < 0)
				{
					dst[num2 - 1] = '\0';
					break;
				}
			}
			else
			{
				dst[num2++] = src[num++];
				num3++;
			}
		}
		return num3;
	}
}
