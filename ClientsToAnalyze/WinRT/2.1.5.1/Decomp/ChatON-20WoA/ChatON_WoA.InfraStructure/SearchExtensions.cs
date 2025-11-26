using System;
using System.Collections.Generic;
using System.Linq;
using ChatOn.Services;

namespace ChatON_WoA.InfraStructure;

public static class SearchExtensions
{
	public static IEnumerable<TSource> DistinctBy<TSource, TKey>(this IEnumerable<TSource> source, Func<TSource, TKey> keySelector)
	{
		HashSet<TKey> knownKeys = new HashSet<TKey>();
		foreach (TSource element in source)
		{
			if (knownKeys.Add(keySelector(element)))
			{
				yield return element;
			}
		}
	}

	public static IEnumerable<BuddySummary> IsNotSpecialBuddy(this IEnumerable<BuddySummary> buddies)
	{
		return buddies.Where((BuddySummary x) => x.Buddy != null && !x.Buddy.PhoneNumber.Contains("0999"));
	}
}
