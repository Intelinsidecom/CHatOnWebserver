using System.Collections;
using System.Collections.Generic;

namespace Google.ProtocolBuffers.Collections;

public static class Dictionaries
{
	public static bool Equals<TKey, TValue>(IDictionary<TKey, TValue> left, IDictionary<TKey, TValue> right)
	{
		if (left.Count != right.Count)
		{
			return false;
		}
		foreach (KeyValuePair<TKey, TValue> item in left)
		{
			if (!right.TryGetValue(item.Key, out var value))
			{
				return false;
			}
			IEnumerable enumerable = item.Value as IEnumerable;
			IEnumerable enumerable2 = value as IEnumerable;
			if (enumerable == null || enumerable2 == null)
			{
				if (!object.Equals(item.Value, value))
				{
					return false;
				}
			}
			else if (!Enumerables.Equals(enumerable, enumerable2))
			{
				return false;
			}
		}
		return true;
	}

	public static IDictionary<TKey, TValue> AsReadOnly<TKey, TValue>(IDictionary<TKey, TValue> dictionary)
	{
		if (!dictionary.IsReadOnly)
		{
			return new ReadOnlyDictionary<TKey, TValue>(dictionary);
		}
		return dictionary;
	}

	public static int GetHashCode<TKey, TValue>(IDictionary<TKey, TValue> dictionary)
	{
		int num = 31;
		foreach (KeyValuePair<TKey, TValue> item in dictionary)
		{
			int num2 = item.Key.GetHashCode() ^ GetDeepHashCode(item.Value);
			num ^= num2;
		}
		return num;
	}

	private static int GetDeepHashCode(object value)
	{
		if (!(value is IEnumerable enumerable))
		{
			return value.GetHashCode();
		}
		int num = 29;
		foreach (object item in enumerable)
		{
			num = num * 37 + item.GetHashCode();
		}
		return num;
	}
}
