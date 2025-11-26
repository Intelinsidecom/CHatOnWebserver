using System;

namespace Microsoft.Phone.Controls;

internal static class AutoCompleteSearch
{
	public static AutoCompleteFilterPredicate<string> GetFilter(AutoCompleteFilterMode FilterMode)
	{
		return FilterMode switch
		{
			AutoCompleteFilterMode.Contains => Contains, 
			AutoCompleteFilterMode.ContainsCaseSensitive => ContainsCaseSensitive, 
			AutoCompleteFilterMode.ContainsOrdinal => ContainsOrdinal, 
			AutoCompleteFilterMode.ContainsOrdinalCaseSensitive => ContainsOrdinalCaseSensitive, 
			AutoCompleteFilterMode.Equals => Equals, 
			AutoCompleteFilterMode.EqualsCaseSensitive => EqualsCaseSensitive, 
			AutoCompleteFilterMode.EqualsOrdinal => EqualsOrdinal, 
			AutoCompleteFilterMode.EqualsOrdinalCaseSensitive => EqualsOrdinalCaseSensitive, 
			AutoCompleteFilterMode.StartsWith => StartsWith, 
			AutoCompleteFilterMode.StartsWithCaseSensitive => StartsWithCaseSensitive, 
			AutoCompleteFilterMode.StartsWithOrdinal => StartsWithOrdinal, 
			AutoCompleteFilterMode.StartsWithOrdinalCaseSensitive => StartsWithOrdinalCaseSensitive, 
			_ => null, 
		};
	}

	public static bool StartsWith(string text, string value)
	{
		return value.StartsWith(text, StringComparison.CurrentCultureIgnoreCase);
	}

	public static bool StartsWithCaseSensitive(string text, string value)
	{
		return value.StartsWith(text, StringComparison.CurrentCulture);
	}

	public static bool StartsWithOrdinal(string text, string value)
	{
		return value.StartsWith(text, StringComparison.OrdinalIgnoreCase);
	}

	public static bool StartsWithOrdinalCaseSensitive(string text, string value)
	{
		return value.StartsWith(text, StringComparison.Ordinal);
	}

	public static bool Contains(string text, string value)
	{
		return value.Contains(text, StringComparison.CurrentCultureIgnoreCase);
	}

	public static bool ContainsCaseSensitive(string text, string value)
	{
		return value.Contains(text, StringComparison.CurrentCulture);
	}

	public static bool ContainsOrdinal(string text, string value)
	{
		return value.Contains(text, StringComparison.OrdinalIgnoreCase);
	}

	public static bool ContainsOrdinalCaseSensitive(string text, string value)
	{
		return value.Contains(text, StringComparison.Ordinal);
	}

	public static bool Equals(string text, string value)
	{
		return value.Equals(text, StringComparison.CurrentCultureIgnoreCase);
	}

	public static bool EqualsCaseSensitive(string text, string value)
	{
		return value.Equals(text, StringComparison.CurrentCulture);
	}

	public static bool EqualsOrdinal(string text, string value)
	{
		return value.Equals(text, StringComparison.OrdinalIgnoreCase);
	}

	public static bool EqualsOrdinalCaseSensitive(string text, string value)
	{
		return value.Equals(text, StringComparison.Ordinal);
	}
}
