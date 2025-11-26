using System.Collections;
using System.Collections.Generic;

namespace Google.ProtocolBuffers;

internal sealed class SortedList<TKey, TValue> : IDictionary<TKey, TValue>, ICollection<KeyValuePair<TKey, TValue>>, IEnumerable<KeyValuePair<TKey, TValue>>, IEnumerable
{
	private readonly IDictionary<TKey, TValue> wrapped = new Dictionary<TKey, TValue>();

	public ICollection<TKey> Keys
	{
		get
		{
			List<TKey> list = new List<TKey>(wrapped.Count);
			using IEnumerator<KeyValuePair<TKey, TValue>> enumerator = GetEnumerator();
			while (enumerator.MoveNext())
			{
				list.Add(enumerator.Current.Key);
			}
			return list;
		}
	}

	public ICollection<TValue> Values
	{
		get
		{
			List<TValue> list = new List<TValue>(wrapped.Count);
			using IEnumerator<KeyValuePair<TKey, TValue>> enumerator = GetEnumerator();
			while (enumerator.MoveNext())
			{
				list.Add(enumerator.Current.Value);
			}
			return list;
		}
	}

	public TValue this[TKey key]
	{
		get
		{
			return wrapped[key];
		}
		set
		{
			wrapped[key] = value;
		}
	}

	public int Count => wrapped.Count;

	public bool IsReadOnly => wrapped.IsReadOnly;

	public void Add(TKey key, TValue value)
	{
		wrapped.Add(key, value);
	}

	public bool ContainsKey(TKey key)
	{
		return wrapped.ContainsKey(key);
	}

	public bool Remove(TKey key)
	{
		return wrapped.Remove(key);
	}

	public bool TryGetValue(TKey key, out TValue value)
	{
		return wrapped.TryGetValue(key, out value);
	}

	public void Add(KeyValuePair<TKey, TValue> item)
	{
		wrapped.Add(item);
	}

	public void Clear()
	{
		wrapped.Clear();
	}

	public bool Contains(KeyValuePair<TKey, TValue> item)
	{
		return wrapped.Contains(item);
	}

	public void CopyTo(KeyValuePair<TKey, TValue>[] array, int arrayIndex)
	{
		wrapped.CopyTo(array, arrayIndex);
	}

	public bool Remove(KeyValuePair<TKey, TValue> item)
	{
		return wrapped.Remove(item);
	}

	public IEnumerator<KeyValuePair<TKey, TValue>> GetEnumerator()
	{
		IComparer<TKey> comparer = Comparer<TKey>.Default;
		List<KeyValuePair<TKey, TValue>> list = new List<KeyValuePair<TKey, TValue>>(wrapped);
		list.Sort((KeyValuePair<TKey, TValue> x, KeyValuePair<TKey, TValue> y) => comparer.Compare(x.Key, y.Key));
		return list.GetEnumerator();
	}

	IEnumerator IEnumerable.GetEnumerator()
	{
		return GetEnumerator();
	}
}
