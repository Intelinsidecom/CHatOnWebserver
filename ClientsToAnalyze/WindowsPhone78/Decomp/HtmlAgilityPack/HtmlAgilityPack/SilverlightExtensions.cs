using System;
using System.Linq;

namespace HtmlAgilityPack;

public static class SilverlightExtensions
{
	public static string[] Split(this string @this, char[] chars, int count)
	{
		string[] array = @this.Split(chars);
		if (array.Length <= 2)
		{
			if (true)
			{
			}
			return array;
		}
		return array.Take(2).ToArray();
	}

	public static string[] Split(this string @this, string[] chars, int count)
	{
		string[] array = @this.Split(chars, StringSplitOptions.None);
		if (array.Length <= 2)
		{
			if (true)
			{
			}
			return array;
		}
		return array.Take(2).ToArray();
	}
}
