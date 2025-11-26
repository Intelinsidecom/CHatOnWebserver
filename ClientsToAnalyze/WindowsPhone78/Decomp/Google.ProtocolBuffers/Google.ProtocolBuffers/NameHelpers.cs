using System.Globalization;
using System.Text;

namespace Google.ProtocolBuffers;

internal class NameHelpers
{
	internal static string UnderscoresToPascalCase(string input)
	{
		return UnderscoresToPascalOrCamelCase(input, pascal: true);
	}

	internal static string UnderscoresToCamelCase(string input)
	{
		return UnderscoresToPascalOrCamelCase(input, pascal: false);
	}

	private static string UnderscoresToPascalOrCamelCase(string input, bool pascal)
	{
		StringBuilder stringBuilder = new StringBuilder();
		bool flag = pascal;
		for (int i = 0; i < input.Length; i++)
		{
			char c = input[i];
			if ('a' <= c && c <= 'z')
			{
				if (flag)
				{
					stringBuilder.Append(char.ToUpper(c, CultureInfo.InvariantCulture));
				}
				else
				{
					stringBuilder.Append(c);
				}
				flag = false;
			}
			else if ('A' <= c && c <= 'Z')
			{
				if (i == 0 && !pascal)
				{
					stringBuilder.Append(char.ToLower(c, CultureInfo.InvariantCulture));
				}
				else
				{
					stringBuilder.Append(c);
				}
				flag = false;
			}
			else if ('0' <= c && c <= '9')
			{
				stringBuilder.Append(c);
				flag = true;
			}
			else
			{
				flag = true;
			}
		}
		return stringBuilder.ToString();
	}

	internal static string StripProto(string text)
	{
		if (!StripSuffix(ref text, ".protodevel"))
		{
			StripSuffix(ref text, ".proto");
		}
		return text;
	}

	internal static bool StripSuffix(ref string text, string suffix)
	{
		if (text.EndsWith(suffix))
		{
			text = text.Substring(0, text.Length - suffix.Length);
			return true;
		}
		return false;
	}
}
