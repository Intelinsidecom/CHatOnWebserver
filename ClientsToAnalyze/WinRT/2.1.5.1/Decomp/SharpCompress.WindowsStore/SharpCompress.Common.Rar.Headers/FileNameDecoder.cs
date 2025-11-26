using System.Text;

namespace SharpCompress.Common.Rar.Headers;

internal static class FileNameDecoder
{
	internal static int GetChar(byte[] name, int pos)
	{
		return name[pos] & 0xFF;
	}

	internal static string Decode(byte[] name, int encPos)
	{
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		int num6 = GetChar(name, encPos++);
		StringBuilder stringBuilder = new StringBuilder();
		while (encPos < name.Length)
		{
			if (num3 == 0)
			{
				num2 = GetChar(name, encPos++);
				num3 = 8;
			}
			switch (num2 >> 6)
			{
			case 0:
				stringBuilder.Append((char)GetChar(name, encPos++));
				num++;
				break;
			case 1:
				stringBuilder.Append((char)(GetChar(name, encPos++) + (num6 << 8)));
				num++;
				break;
			case 2:
				num4 = GetChar(name, encPos);
				num5 = GetChar(name, encPos + 1);
				stringBuilder.Append((char)((num5 << 8) + num4));
				num++;
				encPos += 2;
				break;
			case 3:
			{
				int num7 = GetChar(name, encPos++);
				if ((num7 & 0x80) != 0)
				{
					int num8 = GetChar(name, encPos++);
					num7 = (num7 & 0x7F) + 2;
					while (num7 > 0 && num < name.Length)
					{
						num4 = (GetChar(name, num) + num8) & 0xFF;
						stringBuilder.Append((char)((num6 << 8) + num4));
						num7--;
						num++;
					}
				}
				else
				{
					num7 += 2;
					while (num7 > 0 && num < name.Length)
					{
						stringBuilder.Append((char)GetChar(name, num));
						num7--;
						num++;
					}
				}
				break;
			}
			}
			num2 = (num2 << 2) & 0xFF;
			num3 -= 2;
		}
		return stringBuilder.ToString();
	}
}
