using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Threading;

namespace HtmlAgilityPack;

public class HtmlAttributeCollection : IList<HtmlAttribute>, ICollection<HtmlAttribute>, IEnumerable<HtmlAttribute>, IEnumerable
{
	[CompilerGenerated]
	private sealed class _003CAttributesWithName_003Ed__0 : IEnumerable<HtmlAttribute>, IEnumerable, IEnumerator<HtmlAttribute>, IEnumerator, IDisposable
	{
		private HtmlAttribute _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlAttributeCollection _003C_003E4__this;

		public string attributeName;

		public string _003C_003E3__attributeName;

		public int _003Ci_003E5__1;

		HtmlAttribute IEnumerator<HtmlAttribute>.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		object IEnumerator.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		[DebuggerHidden]
		IEnumerator<HtmlAttribute> IEnumerable<HtmlAttribute>.GetEnumerator()
		{
			int num = 3;
			_003CAttributesWithName_003Ed__0 _003CAttributesWithName_003Ed__ = default(_003CAttributesWithName_003Ed__0);
			while (true)
			{
				switch (num)
				{
				default:
					if (Thread.CurrentThread.ManagedThreadId == _003C_003El__initialThreadId)
					{
						if (true)
						{
						}
						num = 5;
						break;
					}
					goto IL_004c;
				case 0:
					_003C_003E1__state = 0;
					_003CAttributesWithName_003Ed__ = this;
					num = 2;
					break;
				case 5:
					num = 1;
					break;
				case 1:
					if (_003C_003E1__state == -2)
					{
						num = 0;
						break;
					}
					goto IL_004c;
				case 2:
				case 4:
					{
						_003CAttributesWithName_003Ed__.attributeName = _003C_003E3__attributeName;
						return _003CAttributesWithName_003Ed__;
					}
					IL_004c:
					_003CAttributesWithName_003Ed__ = new _003CAttributesWithName_003Ed__0(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 4;
					break;
				}
			}
		}

		[DebuggerHidden]
		IEnumerator IEnumerable.GetEnumerator()
		{
			return ((IEnumerable<HtmlAttribute>)this).GetEnumerator();
		}

		private bool MoveNext()
		{
			while (true)
			{
				int num = _003C_003E1__state;
				int num2 = 4;
				while (true)
				{
					switch (num2)
					{
					case 4:
						switch (num)
						{
						default:
							num2 = 1;
							break;
						case 1:
							_003C_003E1__state = -1;
							if (true)
							{
							}
							num2 = 9;
							break;
						case 0:
							_003C_003E1__state = -1;
							attributeName = attributeName.ToLower();
							_003Ci_003E5__1 = 0;
							num2 = 8;
							break;
						}
						continue;
					case 6:
						_003C_003E2__current = _003C_003E4__this.items[_003Ci_003E5__1];
						_003C_003E1__state = 1;
						return true;
					case 3:
					case 8:
						num2 = 7;
						continue;
					case 7:
						num2 = ((_003Ci_003E5__1 < _003C_003E4__this.items.Count) ? 2 : 5);
						continue;
					case 1:
						num2 = 0;
						continue;
					case 9:
						_003Ci_003E5__1++;
						num2 = 3;
						continue;
					case 2:
						if (_003C_003E4__this.items[_003Ci_003E5__1].Name.Equals(attributeName))
						{
							num2 = 6;
							continue;
						}
						goto case 9;
					case 0:
					case 5:
						return false;
					}
					break;
				}
			}
		}

		bool IEnumerator.MoveNext()
		{
			//ILSpy generated this explicit interface implementation from .override directive in MoveNext
			return this.MoveNext();
		}

		[DebuggerHidden]
		void IEnumerator.Reset()
		{
			throw new NotSupportedException();
		}

		void IDisposable.Dispose()
		{
		}

		[DebuggerHidden]
		public _003CAttributesWithName_003Ed__0(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}
	}

	internal Dictionary<string, HtmlAttribute> Hashitems = new Dictionary<string, HtmlAttribute>();

	private HtmlNode _ownernode;

	private List<HtmlAttribute> items = new List<HtmlAttribute>();

	public HtmlAttribute this[string name]
	{
		get
		{
			int num = 2;
			while (true)
			{
				switch (num)
				{
				default:
					if (true)
					{
					}
					num = ((name == null) ? 1 : 0);
					break;
				case 3:
					return null;
				case 0:
					if (!Hashitems.ContainsKey(name.ToLower()))
					{
						num = 3;
						break;
					}
					return Hashitems[name.ToLower()];
				case 1:
					throw new ArgumentNullException("name");
				}
			}
		}
		set
		{
			Append(value);
		}
	}

	public int Count => items.Count;

	public bool IsReadOnly => false;

	public HtmlAttribute this[int index]
	{
		get
		{
			return items[index];
		}
		set
		{
			items[index] = value;
		}
	}

	internal HtmlAttributeCollection(HtmlNode ownernode)
	{
		_ownernode = ownernode;
	}

	public void Add(HtmlAttribute item)
	{
		Append(item);
	}

	void ICollection<HtmlAttribute>.Clear()
	{
		items.Clear();
	}

	public bool Contains(HtmlAttribute item)
	{
		return items.Contains(item);
	}

	public void CopyTo(HtmlAttribute[] array, int arrayIndex)
	{
		items.CopyTo(array, arrayIndex);
	}

	IEnumerator<HtmlAttribute> IEnumerable<HtmlAttribute>.GetEnumerator()
	{
		return items.GetEnumerator();
	}

	IEnumerator IEnumerable.GetEnumerator()
	{
		return items.GetEnumerator();
	}

	public int IndexOf(HtmlAttribute item)
	{
		return items.IndexOf(item);
	}

	public void Insert(int index, HtmlAttribute item)
	{
		if (item == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("item");
		}
		Hashitems[item.Name] = item;
		item._ownernode = _ownernode;
		items.Insert(index, item);
		_ownernode._innerchanged = true;
		_ownernode._outerchanged = true;
	}

	bool ICollection<HtmlAttribute>.Remove(HtmlAttribute item)
	{
		return items.Remove(item);
	}

	public void RemoveAt(int index)
	{
		if (true)
		{
		}
		HtmlAttribute htmlAttribute = items[index];
		Hashitems.Remove(htmlAttribute.Name);
		items.RemoveAt(index);
		_ownernode._innerchanged = true;
		_ownernode._outerchanged = true;
	}

	public void Add(string name, string value)
	{
		Append(name, value);
	}

	public HtmlAttribute Append(HtmlAttribute newAttribute)
	{
		if (newAttribute == null)
		{
			throw new ArgumentNullException("newAttribute");
		}
		if (true)
		{
		}
		Hashitems[newAttribute.Name] = newAttribute;
		newAttribute._ownernode = _ownernode;
		items.Add(newAttribute);
		_ownernode._innerchanged = true;
		_ownernode._outerchanged = true;
		return newAttribute;
	}

	public HtmlAttribute Append(string name)
	{
		HtmlAttribute newAttribute = _ownernode._ownerdocument.CreateAttribute(name);
		return Append(newAttribute);
	}

	public HtmlAttribute Append(string name, string value)
	{
		if (true)
		{
		}
		HtmlAttribute newAttribute = _ownernode._ownerdocument.CreateAttribute(name, value);
		return Append(newAttribute);
	}

	public bool Contains(string name)
	{
		while (true)
		{
			int num = 0;
			int num2 = 5;
			while (true)
			{
				switch (num2)
				{
				case 1:
					return true;
				case 3:
					if (!items[num].Name.Equals(name.ToLower()))
					{
						if (true)
						{
						}
						num++;
						num2 = 2;
					}
					else
					{
						num2 = 1;
					}
					continue;
				case 2:
				case 5:
					num2 = 4;
					continue;
				case 4:
					num2 = ((num < items.Count) ? 3 : 0);
					continue;
				case 0:
					return false;
				}
				break;
			}
		}
	}

	public HtmlAttribute Prepend(HtmlAttribute newAttribute)
	{
		Insert(0, newAttribute);
		return newAttribute;
	}

	public void Remove(HtmlAttribute attribute)
	{
		int num = 1;
		int attributeIndex = default(int);
		while (true)
		{
			switch (num)
			{
			case 3:
				throw new IndexOutOfRangeException();
			case 0:
				if (attributeIndex == -1)
				{
					num = 3;
					continue;
				}
				RemoveAt(attributeIndex);
				return;
			case 2:
				throw new ArgumentNullException("attribute");
			}
			if (true)
			{
			}
			if (attribute == null)
			{
				num = 2;
				continue;
			}
			attributeIndex = GetAttributeIndex(attribute);
			num = 0;
		}
	}

	public void Remove(string name)
	{
		int num = 3;
		int num2 = default(int);
		HtmlAttribute htmlAttribute = default(HtmlAttribute);
		string text = default(string);
		while (true)
		{
			switch (num)
			{
			case 4:
				num2++;
				num = 0;
				continue;
			case 2:
				if (htmlAttribute.Name == text)
				{
					num = 5;
					continue;
				}
				goto case 4;
			case 1:
				throw new ArgumentNullException("name");
			case 0:
			case 8:
				if (true)
				{
				}
				num = 6;
				continue;
			case 6:
				if (num2 < items.Count)
				{
					htmlAttribute = items[num2];
					num = 2;
				}
				else
				{
					num = 7;
				}
				continue;
			case 7:
				return;
			case 5:
				RemoveAt(num2);
				num = 4;
				continue;
			}
			if (name == null)
			{
				num = 1;
				continue;
			}
			text = name.ToLower();
			num2 = 0;
			num = 8;
		}
	}

	public void RemoveAll()
	{
		if (true)
		{
		}
		Hashitems.Clear();
		items.Clear();
		_ownernode._innerchanged = true;
		_ownernode._outerchanged = true;
	}

	public IEnumerable<HtmlAttribute> AttributesWithName(string attributeName)
	{
		if (true)
		{
		}
		_003CAttributesWithName_003Ed__0 _003CAttributesWithName_003Ed__ = new _003CAttributesWithName_003Ed__0(-2);
		_003CAttributesWithName_003Ed__._003C_003E4__this = this;
		_003CAttributesWithName_003Ed__._003C_003E3__attributeName = attributeName;
		return _003CAttributesWithName_003Ed__;
	}

	public void Remove()
	{
		if (true)
		{
		}
		using List<HtmlAttribute>.Enumerator enumerator = items.GetEnumerator();
		int num = 2;
		while (true)
		{
			switch (num)
			{
			default:
				num = 1;
				break;
			case 1:
				if (enumerator.MoveNext())
				{
					HtmlAttribute current = enumerator.Current;
					current.Remove();
					num = 0;
				}
				else
				{
					num = 4;
				}
				break;
			case 4:
				num = 3;
				break;
			case 3:
				return;
			}
		}
	}

	internal void Clear()
	{
		Hashitems.Clear();
		items.Clear();
	}

	internal int GetAttributeIndex(HtmlAttribute attribute)
	{
		int num = 3;
		int num2 = default(int);
		while (true)
		{
			switch (num)
			{
			default:
				if (attribute == null)
				{
					num = 7;
					break;
				}
				num2 = 0;
				num = 1;
				break;
			case 2:
				if (items[num2] != attribute)
				{
					num2++;
					if (true)
					{
					}
					num = 5;
				}
				else
				{
					num = 6;
				}
				break;
			case 7:
				throw new ArgumentNullException("attribute");
			case 1:
			case 5:
				num = 4;
				break;
			case 4:
				num = ((num2 < items.Count) ? 2 : 0);
				break;
			case 6:
				return num2;
			case 0:
				return -1;
			}
		}
	}

	internal int GetAttributeIndex(string name)
	{
		int num = 5;
		int num2 = default(int);
		string text = default(string);
		while (true)
		{
			switch (num)
			{
			case 7:
				if (true)
				{
				}
				throw new ArgumentNullException("name");
			case 0:
				if (!(items[num2].Name == text))
				{
					num2++;
					num = 6;
				}
				else
				{
					num = 3;
				}
				continue;
			case 2:
			case 6:
				num = 1;
				continue;
			case 1:
				num = ((num2 >= items.Count) ? 4 : 0);
				continue;
			case 3:
				return num2;
			case 4:
				return -1;
			}
			if (name == null)
			{
				num = 7;
				continue;
			}
			text = name.ToLower();
			num2 = 0;
			num = 2;
		}
	}
}
