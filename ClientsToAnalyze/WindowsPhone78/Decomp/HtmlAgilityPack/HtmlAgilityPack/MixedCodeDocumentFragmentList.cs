using System;
using System.Collections;
using System.Collections.Generic;

namespace HtmlAgilityPack;

public class MixedCodeDocumentFragmentList : IEnumerable
{
	public class MixedCodeDocumentFragmentEnumerator : IEnumerator
	{
		private int _index;

		private IList<MixedCodeDocumentFragment> _items;

		public MixedCodeDocumentFragment Current => _items[_index];

		object IEnumerator.Current => Current;

		internal MixedCodeDocumentFragmentEnumerator(IList<MixedCodeDocumentFragment> items)
		{
			_items = items;
			_index = -1;
		}

		public bool MoveNext()
		{
			if (true)
			{
			}
			_index++;
			return _index < _items.Count;
		}

		public void Reset()
		{
			_index = -1;
		}
	}

	private MixedCodeDocument _doc;

	private IList<MixedCodeDocumentFragment> _items = new List<MixedCodeDocumentFragment>();

	public MixedCodeDocument Doc => _doc;

	public int Count => _items.Count;

	public MixedCodeDocumentFragment this[int index] => _items[index];

	internal MixedCodeDocumentFragmentList(MixedCodeDocument doc)
	{
		_doc = doc;
	}

	IEnumerator IEnumerable.GetEnumerator()
	{
		return GetEnumerator();
	}

	public void Append(MixedCodeDocumentFragment newFragment)
	{
		if (newFragment == null)
		{
			throw new ArgumentNullException("newFragment");
		}
		_items.Add(newFragment);
	}

	public MixedCodeDocumentFragmentEnumerator GetEnumerator()
	{
		return new MixedCodeDocumentFragmentEnumerator(_items);
	}

	public void Prepend(MixedCodeDocumentFragment newFragment)
	{
		if (newFragment == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("newFragment");
		}
		_items.Insert(0, newFragment);
	}

	public void Remove(MixedCodeDocumentFragment fragment)
	{
		int num = 1;
		int fragmentIndex = default(int);
		while (true)
		{
			switch (num)
			{
			case 0:
				throw new IndexOutOfRangeException();
			case 3:
				if (fragmentIndex == -1)
				{
					num = 0;
					continue;
				}
				RemoveAt(fragmentIndex);
				return;
			case 2:
				throw new ArgumentNullException("fragment");
			}
			if (true)
			{
			}
			if (fragment == null)
			{
				num = 2;
				continue;
			}
			fragmentIndex = GetFragmentIndex(fragment);
			num = 3;
		}
	}

	public void RemoveAll()
	{
		_items.Clear();
	}

	public void RemoveAt(int index)
	{
		_items.RemoveAt(index);
	}

	internal void Clear()
	{
		_items.Clear();
	}

	internal int GetFragmentIndex(MixedCodeDocumentFragment fragment)
	{
		int num = 2;
		int num2 = default(int);
		while (true)
		{
			switch (num)
			{
			case 3:
				if (_items[num2] != fragment)
				{
					num2++;
					num = 0;
				}
				else
				{
					num = 4;
				}
				continue;
			case 6:
				throw new ArgumentNullException("fragment");
			case 0:
			case 7:
				num = 1;
				continue;
			case 1:
				num = ((num2 >= _items.Count) ? 5 : 3);
				continue;
			case 4:
				return num2;
			case 5:
				return -1;
			}
			if (fragment == null)
			{
				num = 6;
				continue;
			}
			if (true)
			{
			}
			num2 = 0;
			num = 7;
		}
	}
}
