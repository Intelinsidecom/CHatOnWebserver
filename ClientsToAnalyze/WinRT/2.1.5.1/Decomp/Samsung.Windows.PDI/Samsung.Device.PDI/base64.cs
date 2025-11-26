using System;

namespace Samsung.Device.PDI;

public class base64
{
	public static string Base64Encode(string sb)
	{
		if (sb == null)
		{
			return null;
		}
		byte[] inArray = StringToBytes(sb);
		return Convert.ToBase64String(inArray);
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

	public static string Base64Decode(string encodedData)
	{
		if (encodedData == null)
		{
			return null;
		}
		byte[] array = Convert.FromBase64String(encodedData.ToString());
		return array.ToString();
	}
}
