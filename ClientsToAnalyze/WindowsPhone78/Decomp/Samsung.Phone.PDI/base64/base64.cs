using System;
using System.Text;

namespace base64;

public class base64
{
	public static StringBuilder Base64Encode(StringBuilder sb)
	{
		if (sb == null)
		{
			return null;
		}
		string str = sb.ToString();
		byte[] inArray = StringToBytes(str);
		string value = Convert.ToBase64String(inArray);
		return new StringBuilder(value);
	}

	public static byte[] StringToBytes(string str)
	{
		byte[] array = new byte[str.Length * 2];
		for (int i = 0; i < str.Length; i++)
		{
			char c = str[i];
			array[i * 2] = (byte)(c & 0xFF);
			array[i * 2 + 1] = (byte)((c & 0xFF00) >> 8);
		}
		return array;
	}

	public static StringBuilder Base64Decode(StringBuilder encodedData)
	{
		if (encodedData == null)
		{
			return null;
		}
		byte[] array = Convert.FromBase64String(encodedData.ToString());
		string value = array.ToString();
		return new StringBuilder(value);
	}
}
