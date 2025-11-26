using System.Text;

namespace mem;

public class mem
{
	public static int LibStrchr(string source, char c)
	{
		return source?.IndexOf(c) ?? (-1);
	}

	public static bool LibStrstr(string source, string token)
	{
		if (source == null || token == null)
		{
			return false;
		}
		return source.Contains(token);
	}

	public static bool LibStristr(string source, string token)
	{
		if (source == null || token == null)
		{
			return false;
		}
		return source.Contains(token);
	}

	public static StringBuilder eliminateNULLChar(int index, StringBuilder sb)
	{
		StringBuilder stringBuilder = new StringBuilder(256);
		if (stringBuilder == null || sb == null)
		{
			return null;
		}
		for (int i = index; i < sb.Length && sb[i] != 0; i++)
		{
			stringBuilder.Append(sb[i]);
		}
		return stringBuilder;
	}

	public static void LibMemcpy(StringBuilder Target, int target_index, StringBuilder Source, int source_index, int count)
	{
		if (Target != null && Source != null)
		{
			for (int i = 0; i < count; i++)
			{
				Target[target_index] = Source[source_index];
				target_index++;
				source_index++;
			}
		}
	}
}
