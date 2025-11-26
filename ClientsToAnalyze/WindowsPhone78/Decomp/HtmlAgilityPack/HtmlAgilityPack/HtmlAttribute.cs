using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace HtmlAgilityPack;

[DebuggerDisplay("Name: {OriginalName}, Value: {Value}")]
public class HtmlAttribute : IComparable
{
	private int _line;

	internal int _lineposition;

	internal string _name;

	internal int _namelength;

	internal int _namestartindex;

	internal HtmlDocument _ownerdocument;

	internal HtmlNode _ownernode;

	private AttributeValueQuote _quoteType = AttributeValueQuote.DoubleQuote;

	internal int _streamposition;

	internal string _value;

	internal int _valuelength;

	internal int _valuestartindex;

	public int Line
	{
		get
		{
			return _line;
		}
		internal set
		{
			_line = value;
		}
	}

	public int LinePosition => _lineposition;

	public string Name
	{
		get
		{
			int num = 0;
			while (true)
			{
				switch (num)
				{
				default:
					if (true)
					{
					}
					if (_name == null)
					{
						num = 1;
						continue;
					}
					break;
				case 1:
					_name = _ownerdocument.Text.Substring(_namestartindex, _namelength);
					num = 2;
					continue;
				case 2:
					break;
				}
				break;
			}
			return _name.ToLower();
		}
		set
		{
			int num = 4;
			while (true)
			{
				switch (num)
				{
				case 3:
					_ownernode._innerchanged = true;
					_ownernode._outerchanged = true;
					num = 2;
					continue;
				case 2:
					return;
				case 1:
					if (_ownernode != null)
					{
						num = 3;
						continue;
					}
					return;
				case 0:
					throw new ArgumentNullException("value");
				}
				if (value == null)
				{
					if (true)
					{
					}
					num = 0;
				}
				else
				{
					_name = value;
					num = 1;
				}
			}
		}
	}

	public string OriginalName => _name;

	public HtmlDocument OwnerDocument => _ownerdocument;

	public HtmlNode OwnerNode => _ownernode;

	public AttributeValueQuote QuoteType
	{
		get
		{
			return _quoteType;
		}
		set
		{
			_quoteType = value;
		}
	}

	public int StreamPosition => _streamposition;

	public string Value
	{
		get
		{
			int num = 2;
			while (true)
			{
				switch (num)
				{
				default:
					if (_value == null)
					{
						num = 1;
						continue;
					}
					break;
				case 1:
					_value = _ownerdocument.Text.Substring(_valuestartindex, _valuelength);
					num = 0;
					continue;
				case 0:
					if (1 == 0)
					{
					}
					break;
				}
				break;
			}
			return _value;
		}
		set
		{
			while (true)
			{
				_value = value;
				int num = 0;
				while (true)
				{
					switch (num)
					{
					case 0:
						if (_ownernode != null)
						{
							num = 2;
							continue;
						}
						return;
					case 2:
						_ownernode._innerchanged = true;
						_ownernode._outerchanged = true;
						num = 1;
						continue;
					case 1:
						if (1 == 0)
						{
						}
						return;
					}
					break;
				}
			}
		}
	}

	internal string XmlName => HtmlDocument.GetXmlName(Name);

	internal string XmlValue => Value;

	public string XPath
	{
		get
		{
			int num = 1;
			object obj;
			while (true)
			{
				switch (num)
				{
				default:
					num = ((OwnerNode == null) ? 2 : 3);
					continue;
				case 2:
					if (true)
					{
					}
					obj = "/";
					break;
				case 3:
					num = 0;
					continue;
				case 0:
					obj = OwnerNode.XPath + "/";
					break;
				}
				break;
			}
			string text = (string)obj;
			return text + GetRelativeXpath();
		}
	}

	internal HtmlAttribute(HtmlDocument ownerdocument)
	{
		_ownerdocument = ownerdocument;
	}

	public int CompareTo(object obj)
	{
		if (!(obj is HtmlAttribute htmlAttribute))
		{
			if (true)
			{
			}
			throw new ArgumentException("obj");
		}
		return Name.CompareTo(htmlAttribute.Name);
	}

	public HtmlAttribute Clone()
	{
		if (true)
		{
		}
		HtmlAttribute htmlAttribute = new HtmlAttribute(_ownerdocument);
		htmlAttribute.Name = Name;
		htmlAttribute.Value = Value;
		return htmlAttribute;
	}

	public void Remove()
	{
		_ownernode.Attributes.Remove(this);
	}

	private string GetRelativeXpath()
	{
		switch (0)
		{
		default:
		{
			int num = 1;
			int num2 = default(int);
			IEnumerator<HtmlAttribute> enumerator = default(IEnumerator<HtmlAttribute>);
			HtmlAttribute current = default(HtmlAttribute);
			while (true)
			{
				switch (num)
				{
				default:
					if (OwnerNode == null)
					{
						num = 0;
						break;
					}
					num2 = 1;
					enumerator = ((IEnumerable<HtmlAttribute>)OwnerNode.Attributes).GetEnumerator();
					num = 2;
					break;
				case 2:
					try
					{
						num = 1;
						while (true)
						{
							switch (num)
							{
							case 0:
								if (!(current.Name != Name))
								{
									num = 6;
									continue;
								}
								goto default;
							default:
								num = 7;
								continue;
							case 7:
								if (enumerator.MoveNext())
								{
									current = enumerator.Current;
									num = 0;
								}
								else
								{
									num = 5;
								}
								continue;
							case 2:
								num2++;
								num = 3;
								continue;
							case 6:
								num = 4;
								continue;
							case 4:
								if (current != this)
								{
									num = 2;
									continue;
								}
								break;
							case 5:
								break;
							case 8:
								goto end_IL_0050;
							}
							num = 8;
							continue;
							end_IL_0050:
							break;
						}
					}
					finally
					{
						num = 2;
						while (true)
						{
							if (true)
							{
							}
							switch (num)
							{
							default:
								if (enumerator != null)
								{
									num = 0;
									continue;
								}
								break;
							case 0:
								enumerator.Dispose();
								num = 1;
								continue;
							case 1:
								break;
							}
							break;
						}
					}
					return "@" + Name + "[" + num2 + "]";
				case 0:
					return Name;
				}
			}
		}
		}
	}
}
