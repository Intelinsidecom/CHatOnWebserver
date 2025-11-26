using System.Text;

namespace vitemapi;

public class CommonMethods
{
	public static void VItemAppendCharSet(StringBuilder Tag, int CharSet)
	{
		if (Tag != null)
		{
			switch (CharSet)
			{
			case 4:
				Tag.Append(";CHARSET=UTF-8");
				break;
			case 3:
				Tag.Append(";CHARSET=UTF-7");
				break;
			case 2:
				Tag.Append(";CHARSET=LATIN1");
				break;
			case 7:
				Tag.Append(";CHARSET=SHIFT_JIS");
				break;
			case 5:
			case 6:
				break;
			}
		}
	}

	public static void VItemAppendEncodeType(StringBuilder Tag, int nEncodeType)
	{
		if (Tag != null)
		{
			switch (nEncodeType)
			{
			case 2:
			case 3:
				Tag.Append(";ENCODING=QUOTED-PRINTABLE");
				break;
			case 1:
				Tag.Append(";ENCODING=BASE64");
				break;
			}
		}
	}
}
