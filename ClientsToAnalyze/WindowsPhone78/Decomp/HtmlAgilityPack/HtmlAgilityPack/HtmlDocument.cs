using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Xml;

namespace HtmlAgilityPack;

public class HtmlDocument
{
	private enum ParseState
	{
		Text,
		WhichTag,
		Tag,
		BetweenAttributes,
		EmptyTag,
		AttributeName,
		AttributeBeforeEquals,
		AttributeAfterEquals,
		AttributeValue,
		Comment,
		QuotedAttributeValue,
		ServerSideCode,
		PcData
	}

	private int _c;

	private Crc32 _crc32;

	private HtmlAttribute _currentattribute;

	private HtmlNode _currentnode;

	private Encoding _declaredencoding;

	private HtmlNode _documentnode;

	private bool _fullcomment;

	private int _index;

	internal Dictionary<string, HtmlNode> Lastnodes = new Dictionary<string, HtmlNode>();

	private HtmlNode _lastparentnode;

	private int _line;

	private int _lineposition;

	private int _maxlineposition;

	internal Dictionary<string, HtmlNode> Nodesid;

	private ParseState _oldstate;

	private bool _onlyDetectEncoding;

	internal Dictionary<int, HtmlNode> Openednodes;

	private List<HtmlParseError> _parseerrors = new List<HtmlParseError>();

	private string _remainder;

	private int _remainderOffset;

	private ParseState _state;

	private Encoding _streamencoding;

	internal string Text;

	public bool OptionAddDebuggingAttributes;

	public bool OptionAutoCloseOnEnd;

	public bool OptionCheckSyntax = true;

	public bool OptionComputeChecksum;

	public Encoding OptionDefaultStreamEncoding;

	public bool OptionExtractErrorSourceText;

	public int OptionExtractErrorSourceTextMaxLength = 100;

	public bool OptionFixNestedTags;

	public bool OptionOutputAsXml;

	public bool OptionOutputOptimizeAttributeValues;

	public bool OptionOutputOriginalCase;

	public bool OptionOutputUpperCase;

	public bool OptionReadEncoding = true;

	public string OptionStopperNodeName;

	public bool OptionUseIdAttribute = true;

	public bool OptionWriteEmptyNodes;

	internal static readonly string HtmlExceptionRefNotChild = "Reference node must be a child of this node";

	internal static readonly string HtmlExceptionUseIdAttributeFalse = "You need to set UseIdAttribute property to true to enable this feature";

	public int CheckSum
	{
		get
		{
			if (_crc32 != null)
			{
				return (int)_crc32.CheckSum;
			}
			return 0;
		}
	}

	public Encoding DeclaredEncoding => _declaredencoding;

	public HtmlNode DocumentNode => _documentnode;

	public Encoding Encoding => GetOutEncoding();

	public IEnumerable<HtmlParseError> ParseErrors => _parseerrors;

	public string Remainder => _remainder;

	public int RemainderOffset => _remainderOffset;

	public Encoding StreamEncoding => _streamencoding;

	public HtmlDocument()
	{
		_documentnode = CreateNode(HtmlNodeType.Document, 0);
		OptionDefaultStreamEncoding = Encoding.UTF8;
	}

	public static string GetXmlName(string name)
	{
		switch (0)
		{
		}
		int num3 = default(int);
		byte[] bytes = default(byte[]);
		while (true)
		{
			string text = string.Empty;
			bool flag = true;
			int num = 0;
			int num2 = 14;
			while (true)
			{
				switch (num2)
				{
				case 12:
					text += "_";
					num2 = 6;
					continue;
				case 5:
					num2 = 4;
					continue;
				case 4:
					if (name[num] > '9')
					{
						num2 = 13;
						continue;
					}
					goto case 17;
				case 14:
				case 20:
					num2 = 8;
					continue;
				case 8:
					if (true)
					{
					}
					num2 = ((num < name.Length) ? 22 : 24);
					continue;
				case 3:
					num2 = 23;
					continue;
				case 23:
					if (name[num] > 'z')
					{
						num2 = 15;
						continue;
					}
					goto case 17;
				case 16:
				case 25:
					num2 = 7;
					continue;
				case 7:
					if (num3 >= bytes.Length)
					{
						num2 = 12;
						continue;
					}
					text += bytes[num3].ToString("x2");
					num3++;
					num2 = 25;
					continue;
				case 9:
					return text;
				case 17:
					text += name[num];
					num2 = 19;
					continue;
				case 15:
					num2 = 21;
					continue;
				case 21:
					if (name[num] >= '0')
					{
						num2 = 5;
						continue;
					}
					goto case 13;
				case 24:
					num2 = 0;
					continue;
				case 0:
					if (flag)
					{
						num2 = 9;
						continue;
					}
					return "_" + text;
				case 6:
				case 19:
					num++;
					num2 = 20;
					continue;
				case 11:
					num2 = 18;
					continue;
				case 18:
					if (name[num] != '-')
					{
						num2 = 10;
						continue;
					}
					goto case 17;
				case 22:
					if (name[num] >= 'a')
					{
						num2 = 3;
						continue;
					}
					goto case 15;
				case 13:
					num2 = 2;
					continue;
				case 2:
					if (name[num] != '_')
					{
						num2 = 11;
						continue;
					}
					goto case 17;
				case 10:
					num2 = 1;
					continue;
				case 1:
					if (name[num] != '.')
					{
						flag = false;
						bytes = Encoding.UTF8.GetBytes(new char[1] { name[num] });
						num3 = 0;
						num2 = 16;
					}
					else
					{
						num2 = 17;
					}
					continue;
				}
				break;
			}
		}
	}

	public static string HtmlEncode(string html)
	{
		if (html == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("html");
		}
		Regex regex = new Regex("&(?!(amp;)|(lt;)|(gt;)|(quot;))", RegexOptions.IgnoreCase);
		return regex.Replace(html, "&amp;").Replace("<", "&lt;").Replace(">", "&gt;")
			.Replace("\"", "&quot;");
	}

	public static bool IsWhiteSpace(int c)
	{
		int num = 3;
		while (true)
		{
			switch (num)
			{
			default:
				if (c != 10)
				{
					num = 4;
					break;
				}
				goto case 6;
			case 1:
				num = 2;
				break;
			case 2:
				if (c == 9)
				{
					num = 6;
					break;
				}
				return false;
			case 0:
				num = 7;
				break;
			case 7:
				if (c != 32)
				{
					num = 1;
					break;
				}
				goto case 6;
			case 4:
				num = 5;
				break;
			case 5:
				if (c != 13)
				{
					if (true)
					{
					}
					num = 0;
					break;
				}
				goto case 6;
			case 6:
				return true;
			}
		}
	}

	public HtmlAttribute CreateAttribute(string name)
	{
		if (name == null)
		{
			throw new ArgumentNullException("name");
		}
		if (true)
		{
		}
		HtmlAttribute htmlAttribute = CreateAttribute();
		htmlAttribute.Name = name;
		return htmlAttribute;
	}

	public HtmlAttribute CreateAttribute(string name, string value)
	{
		if (name == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("name");
		}
		HtmlAttribute htmlAttribute = CreateAttribute(name);
		htmlAttribute.Value = value;
		return htmlAttribute;
	}

	public HtmlCommentNode CreateComment()
	{
		return (HtmlCommentNode)CreateNode(HtmlNodeType.Comment);
	}

	public HtmlCommentNode CreateComment(string comment)
	{
		if (comment == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("comment");
		}
		HtmlCommentNode htmlCommentNode = CreateComment();
		htmlCommentNode.Comment = comment;
		return htmlCommentNode;
	}

	public HtmlNode CreateElement(string name)
	{
		if (name == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("name");
		}
		HtmlNode htmlNode = CreateNode(HtmlNodeType.Element);
		htmlNode.Name = name;
		return htmlNode;
	}

	public HtmlTextNode CreateTextNode()
	{
		return (HtmlTextNode)CreateNode(HtmlNodeType.Text);
	}

	public HtmlTextNode CreateTextNode(string text)
	{
		if (text == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("text");
		}
		HtmlTextNode htmlTextNode = CreateTextNode();
		htmlTextNode.Text = text;
		return htmlTextNode;
	}

	public Encoding DetectEncoding(Stream stream)
	{
		if (stream == null)
		{
			throw new ArgumentNullException("stream");
		}
		return DetectEncoding(new StreamReader(stream));
	}

	public Encoding DetectEncoding(string path)
	{
		if (path == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("path");
		}
		StreamReader streamReader = new StreamReader(path, OptionDefaultStreamEncoding);
		Encoding result = DetectEncoding(streamReader);
		streamReader.Close();
		return result;
	}

	public Encoding DetectEncoding(TextReader reader)
	{
		int num = 6;
		StreamReader streamReader = default(StreamReader);
		while (true)
		{
			switch (num)
			{
			default:
				if (reader == null)
				{
					num = 1;
					break;
				}
				_onlyDetectEncoding = true;
				num = 9;
				break;
			case 12:
			case 14:
				streamReader = reader as StreamReader;
				num = 3;
				break;
			case 3:
				if (streamReader == null)
				{
					_streamencoding = null;
					num = 8;
				}
				else
				{
					num = 10;
				}
				break;
			case 4:
				Openednodes = new Dictionary<int, HtmlNode>();
				num = 13;
				break;
			case 7:
				try
				{
					Parse();
				}
				catch (EncodingFoundException ex)
				{
					return ex.Encoding;
				}
				return null;
			case 9:
				if (OptionCheckSyntax)
				{
					num = 4;
					break;
				}
				Openednodes = null;
				num = 0;
				break;
			case 5:
			case 8:
				_declaredencoding = null;
				Text = reader.ReadToEnd();
				_documentnode = CreateNode(HtmlNodeType.Document, 0);
				num = 7;
				break;
			case 10:
				_streamencoding = streamReader.CurrentEncoding;
				num = 5;
				break;
			case 0:
			case 13:
				if (true)
				{
				}
				num = 11;
				break;
			case 11:
				if (!OptionUseIdAttribute)
				{
					Nodesid = null;
					num = 14;
				}
				else
				{
					num = 2;
				}
				break;
			case 1:
				throw new ArgumentNullException("reader");
			case 2:
				Nodesid = new Dictionary<string, HtmlNode>();
				num = 12;
				break;
			}
		}
	}

	public void DetectEncodingAndLoad(string path)
	{
		DetectEncodingAndLoad(path, detectEncoding: true);
	}

	public void DetectEncodingAndLoad(string path, bool detectEncoding)
	{
		int num = 1;
		Encoding encoding = default(Encoding);
		while (true)
		{
			switch (num)
			{
			case 1:
				if (1 == 0)
				{
				}
				goto default;
			default:
				num = ((path != null) ? 7 : 5);
				break;
			case 0:
			case 4:
				num = 2;
				break;
			case 2:
				if (encoding == null)
				{
					num = 3;
					break;
				}
				Load(path, encoding);
				return;
			case 6:
				encoding = DetectEncoding(path);
				num = 4;
				break;
			case 5:
				throw new ArgumentNullException("path");
			case 3:
				Load(path);
				return;
			case 7:
				if (detectEncoding)
				{
					num = 6;
					break;
				}
				encoding = null;
				num = 0;
				break;
			}
		}
	}

	public Encoding DetectEncodingHtml(string html)
	{
		if (html == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("html");
		}
		StringReader stringReader = new StringReader(html);
		Encoding result = DetectEncoding(stringReader);
		stringReader.Close();
		return result;
	}

	public HtmlNode GetElementbyId(string id)
	{
		int num = 0;
		while (true)
		{
			switch (num)
			{
			case 2:
				if (!Nodesid.ContainsKey(id.ToLower()))
				{
					num = 1;
					continue;
				}
				return Nodesid[id.ToLower()];
			case 3:
				throw new Exception(HtmlExceptionUseIdAttributeFalse);
			case 4:
				throw new ArgumentNullException("id");
			case 1:
				return null;
			case 5:
				num = ((Nodesid == null) ? 3 : 2);
				continue;
			}
			if (id == null)
			{
				if (true)
				{
				}
				num = 4;
			}
			else
			{
				num = 5;
			}
		}
	}

	public void Load(Stream stream)
	{
		Load(new StreamReader(stream, OptionDefaultStreamEncoding));
	}

	public void Load(Stream stream, bool detectEncodingFromByteOrderMarks)
	{
		Load(new StreamReader(stream, detectEncodingFromByteOrderMarks));
	}

	public void Load(Stream stream, Encoding encoding)
	{
		Load(new StreamReader(stream, encoding));
	}

	public void Load(Stream stream, Encoding encoding, bool detectEncodingFromByteOrderMarks)
	{
		Load(new StreamReader(stream, encoding, detectEncodingFromByteOrderMarks));
	}

	public void Load(Stream stream, Encoding encoding, bool detectEncodingFromByteOrderMarks, int buffersize)
	{
		Load(new StreamReader(stream, encoding, detectEncodingFromByteOrderMarks, buffersize));
	}

	public void Load(string path)
	{
		if (path == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("path");
		}
		StreamReader streamReader = new StreamReader(path, OptionDefaultStreamEncoding);
		Load(streamReader);
		streamReader.Close();
	}

	public void Load(string path, bool detectEncodingFromByteOrderMarks)
	{
		if (path == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("path");
		}
		StreamReader streamReader = new StreamReader(path, detectEncodingFromByteOrderMarks);
		Load(streamReader);
		streamReader.Close();
	}

	public void Load(string path, Encoding encoding)
	{
		if (true)
		{
		}
		int num = 2;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((path != null) ? 1 : 3);
				break;
			case 0:
				throw new ArgumentNullException("encoding");
			case 1:
			{
				if (encoding == null)
				{
					num = 0;
					break;
				}
				StreamReader streamReader = new StreamReader(path, encoding);
				Load(streamReader);
				streamReader.Close();
				return;
			}
			case 3:
				throw new ArgumentNullException("path");
			}
		}
	}

	public void Load(string path, Encoding encoding, bool detectEncodingFromByteOrderMarks)
	{
		int num = 0;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((path != null) ? 3 : 2);
				break;
			case 3:
			{
				if (encoding == null)
				{
					num = 1;
					break;
				}
				StreamReader streamReader = new StreamReader(path, encoding, detectEncodingFromByteOrderMarks);
				Load(streamReader);
				streamReader.Close();
				return;
			}
			case 1:
				if (true)
				{
				}
				throw new ArgumentNullException("encoding");
			case 2:
				throw new ArgumentNullException("path");
			}
		}
	}

	public void Load(string path, Encoding encoding, bool detectEncodingFromByteOrderMarks, int buffersize)
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
				num = ((path != null) ? 3 : 0);
				break;
			case 1:
				throw new ArgumentNullException("encoding");
			case 3:
			{
				if (encoding == null)
				{
					num = 1;
					break;
				}
				StreamReader streamReader = new StreamReader(path, encoding, detectEncodingFromByteOrderMarks, buffersize);
				Load(streamReader);
				streamReader.Close();
				return;
			}
			case 0:
				throw new ArgumentNullException("path");
			}
		}
	}

	public void Load(TextReader reader)
	{
		switch (0)
		{
		default:
		{
			int num = 1;
			string text = default(string);
			HtmlNode current = default(HtmlNode);
			Dictionary<int, HtmlNode>.ValueCollection.Enumerator enumerator = default(Dictionary<int, HtmlNode>.ValueCollection.Enumerator);
			StreamReader streamReader = default(StreamReader);
			while (true)
			{
				switch (num)
				{
				default:
					if (reader == null)
					{
						num = 8;
						break;
					}
					_onlyDetectEncoding = false;
					num = 3;
					break;
				case 5:
				case 7:
					_declaredencoding = null;
					Text = reader.ReadToEnd();
					_documentnode = CreateNode(HtmlNodeType.Document, 0);
					Parse();
					num = 18;
					break;
				case 18:
					if (OptionCheckSyntax)
					{
						num = 15;
						break;
					}
					return;
				case 3:
					if (!OptionCheckSyntax)
					{
						Openednodes = null;
						num = 17;
					}
					else
					{
						num = 6;
					}
					break;
				case 14:
					try
					{
						num = 9;
						while (true)
						{
							switch (num)
							{
							case 3:
								text = current.OuterHtml;
								num = 4;
								continue;
							case 4:
								if (text.Length > OptionExtractErrorSourceTextMaxLength)
								{
									num = 12;
									continue;
								}
								goto case 0;
							case 12:
								text = text.Substring(0, OptionExtractErrorSourceTextMaxLength);
								num = 0;
								continue;
							case 0:
							case 10:
								AddError(HtmlParseErrorCode.TagNotClosed, current._line, current._lineposition, current._streamposition, text, "End tag </" + current.Name + "> was not found");
								num = 2;
								continue;
							case 7:
								num = 5;
								continue;
							case 5:
								if (OptionExtractErrorSourceText)
								{
									num = 3;
									continue;
								}
								text = string.Empty;
								num = 10;
								continue;
							case 1:
								if (current._starttag)
								{
									num = 7;
									continue;
								}
								goto default;
							default:
								num = 8;
								continue;
							case 8:
								if (enumerator.MoveNext())
								{
									current = enumerator.Current;
									num = 1;
								}
								else
								{
									num = 11;
								}
								continue;
							case 11:
								num = 6;
								continue;
							case 6:
								break;
							}
							break;
						}
					}
					finally
					{
						((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
					}
					if (true)
					{
					}
					Openednodes.Clear();
					return;
				case 0:
					try
					{
						streamReader.Peek();
					}
					catch (Exception)
					{
					}
					_streamencoding = streamReader.CurrentEncoding;
					num = 7;
					break;
				case 2:
				case 17:
					num = 10;
					break;
				case 10:
					if (OptionUseIdAttribute)
					{
						num = 4;
						break;
					}
					Nodesid = null;
					num = 11;
					break;
				case 13:
					return;
				case 8:
					throw new ArgumentNullException("reader");
				case 6:
					Openednodes = new Dictionary<int, HtmlNode>();
					num = 2;
					break;
				case 4:
					Nodesid = new Dictionary<string, HtmlNode>();
					num = 9;
					break;
				case 9:
				case 11:
					streamReader = reader as StreamReader;
					num = 12;
					break;
				case 12:
					if (streamReader == null)
					{
						_streamencoding = null;
						num = 5;
					}
					else
					{
						num = 0;
					}
					break;
				case 15:
					num = 16;
					break;
				case 16:
					if (Openednodes != null)
					{
						enumerator = Openednodes.Values.GetEnumerator();
						num = 14;
					}
					else
					{
						num = 13;
					}
					break;
				}
			}
		}
		}
	}

	public void LoadHtml(string html)
	{
		if (true)
		{
		}
		if (html == null)
		{
			throw new ArgumentNullException("html");
		}
		StringReader stringReader = new StringReader(html);
		Load(stringReader);
		stringReader.Close();
	}

	public void Save(Stream outStream)
	{
		StreamWriter writer = new StreamWriter(outStream, GetOutEncoding());
		Save(writer);
	}

	public void Save(Stream outStream, Encoding encoding)
	{
		int num = 1;
		while (true)
		{
			switch (num)
			{
			case 2:
				throw new ArgumentNullException("encoding");
			case 3:
			{
				if (encoding == null)
				{
					num = 2;
					continue;
				}
				StreamWriter writer = new StreamWriter(outStream, encoding);
				Save(writer);
				return;
			}
			case 0:
				throw new ArgumentNullException("outStream");
			}
			if (outStream == null)
			{
				num = 0;
				continue;
			}
			if (true)
			{
			}
			num = 3;
		}
	}

	public void Save(string filename)
	{
		if (true)
		{
		}
		StreamWriter streamWriter = new StreamWriter(filename, append: false, GetOutEncoding());
		Save(streamWriter);
		streamWriter.Close();
	}

	public void Save(string filename, Encoding encoding)
	{
		if (true)
		{
		}
		int num = 3;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((filename != null) ? 1 : 2);
				break;
			case 0:
				throw new ArgumentNullException("encoding");
			case 1:
			{
				if (encoding == null)
				{
					num = 0;
					break;
				}
				StreamWriter streamWriter = new StreamWriter(filename, append: false, encoding);
				Save(streamWriter);
				streamWriter.Close();
				return;
			}
			case 2:
				throw new ArgumentNullException("filename");
			}
		}
	}

	public void Save(StreamWriter writer)
	{
		Save((TextWriter)writer);
	}

	public void Save(TextWriter writer)
	{
		if (writer == null)
		{
			throw new ArgumentNullException("writer");
		}
		DocumentNode.WriteTo(writer);
	}

	public void Save(XmlWriter writer)
	{
		DocumentNode.WriteTo(writer);
		writer.Flush();
	}

	internal HtmlAttribute CreateAttribute()
	{
		return new HtmlAttribute(this);
	}

	internal HtmlNode CreateNode(HtmlNodeType type)
	{
		return CreateNode(type, -1);
	}

	internal HtmlNode CreateNode(HtmlNodeType type, int index)
	{
		while (true)
		{
			int num = 2;
			while (true)
			{
				switch (num)
				{
				case 2:
					switch (type)
					{
					case HtmlNodeType.Text:
						return new HtmlTextNode(this, index);
					case HtmlNodeType.Comment:
						return new HtmlCommentNode(this, index);
					}
					num = 0;
					continue;
				case 0:
					if (true)
					{
					}
					num = 1;
					continue;
				case 1:
					return new HtmlNode(type, this, index);
				}
				break;
			}
		}
	}

	internal Encoding GetOutEncoding()
	{
		if (true)
		{
		}
		int num = 1;
		Encoding encoding;
		while (true)
		{
			switch (num)
			{
			default:
				encoding = _declaredencoding;
				if (encoding == null)
				{
					num = 2;
					continue;
				}
				break;
			case 2:
				encoding = _streamencoding;
				if (encoding == null)
				{
					num = 0;
					continue;
				}
				break;
			case 0:
				encoding = OptionDefaultStreamEncoding;
				break;
			}
			break;
		}
		return encoding;
	}

	internal HtmlNode GetXmlDeclaration()
	{
		int num = 0;
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		HtmlNode current = default(HtmlNode);
		HtmlNode result = default(HtmlNode);
		while (true)
		{
			switch (num)
			{
			default:
				if (!_documentnode.HasChildNodes)
				{
					num = 1;
					break;
				}
				enumerator = ((IEnumerable<HtmlNode>)_documentnode._childnodes).GetEnumerator();
				num = 2;
				break;
			case 1:
				return null;
			case 2:
				if (true)
				{
				}
				try
				{
					num = 5;
					while (true)
					{
						switch (num)
						{
						default:
							num = 0;
							continue;
						case 0:
							if (!enumerator.MoveNext())
							{
								num = 3;
								continue;
							}
							current = enumerator.Current;
							num = 4;
							continue;
						case 1:
							result = current;
							num = 6;
							continue;
						case 4:
							if (current.Name == "?xml")
							{
								num = 1;
								continue;
							}
							goto default;
						case 3:
							num = 2;
							continue;
						case 2:
							break;
						case 6:
							return result;
						}
						break;
					}
				}
				finally
				{
					num = 2;
					while (true)
					{
						switch (num)
						{
						default:
							if (enumerator != null)
							{
								num = 1;
								continue;
							}
							break;
						case 1:
							enumerator.Dispose();
							num = 0;
							continue;
						case 0:
							break;
						}
						break;
					}
				}
				return null;
			}
		}
	}

	internal void SetIdForNode(HtmlNode node, string id)
	{
		int num = 7;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((!OptionUseIdAttribute) ? 2 : 0);
				break;
			case 2:
				if (1 == 0)
				{
				}
				return;
			case 4:
				if (node == null)
				{
					num = 6;
					break;
				}
				Nodesid[id.ToLower()] = node;
				return;
			case 3:
				num = 1;
				break;
			case 1:
				num = ((id == null) ? 5 : 4);
				break;
			case 5:
				return;
			case 6:
				Nodesid.Remove(id.ToLower());
				return;
			case 0:
				if (Nodesid != null)
				{
					num = 3;
					break;
				}
				return;
			}
		}
	}

	internal void UpdateLastParentNode()
	{
		while (true)
		{
			int num = 6;
			while (true)
			{
				switch (num)
				{
				default:
					if (_lastparentnode.Closed)
					{
						num = 3;
						continue;
					}
					goto case 4;
				case 7:
					num = 8;
					continue;
				case 8:
					if (_lastparentnode == null)
					{
						num = 2;
						continue;
					}
					return;
				case 1:
					num = 9;
					continue;
				case 9:
					break;
				case 3:
					_lastparentnode = _lastparentnode.ParentNode;
					num = 4;
					continue;
				case 2:
					_lastparentnode = _documentnode;
					if (true)
					{
					}
					num = 5;
					continue;
				case 5:
					return;
				case 4:
					num = 0;
					continue;
				case 0:
					if (_lastparentnode != null)
					{
						num = 1;
						continue;
					}
					goto case 7;
				}
				if (_lastparentnode.Closed)
				{
					break;
				}
				num = 7;
			}
		}
	}

	private void AddError(HtmlParseErrorCode code, int line, int linePosition, int streamPosition, string sourceText, string reason)
	{
		if (true)
		{
		}
		HtmlParseError item = new HtmlParseError(code, line, linePosition, streamPosition, sourceText, reason);
		_parseerrors.Add(item);
	}

	private void CloseCurrentNode()
	{
		switch (0)
		{
		default:
		{
			int num = 49;
			HtmlNode htmlNode = default(HtmlNode);
			HtmlNode htmlNode4 = default(HtmlNode);
			HtmlNode htmlNode2 = default(HtmlNode);
			HtmlNode dictionaryValueOrNull = default(HtmlNode);
			Stack<HtmlNode> stack = default(Stack<HtmlNode>);
			bool flag = default(bool);
			while (true)
			{
				switch (num)
				{
				case 47:
					return;
				case 39:
					if (OptionFixNestedTags)
					{
						num = 46;
						continue;
					}
					goto case 23;
				case 5:
					htmlNode = CreateNode(HtmlNodeType.Text, _currentnode._outerstartindex);
					htmlNode._outerlength = _currentnode._outerlength;
					((HtmlTextNode)htmlNode).Text = ((HtmlTextNode)htmlNode).Text.ToLower();
					num = 42;
					continue;
				case 42:
					if (_lastparentnode != null)
					{
						num = 12;
						continue;
					}
					goto case 1;
				case 33:
					num = 16;
					continue;
				case 16:
					if (!htmlNode4.HasChildNodes)
					{
						num = 9;
						continue;
					}
					goto IL_0516;
				case 9:
					if (true)
					{
					}
					htmlNode2 = htmlNode4;
					num = 17;
					continue;
				case 43:
					Lastnodes[_currentnode.Name] = dictionaryValueOrNull._prevwithsamename;
					dictionaryValueOrNull.CloseNode(_currentnode);
					num = 31;
					continue;
				case 0:
					_currentnode.CloseNode(_currentnode);
					num = 15;
					continue;
				case 15:
					if (_lastparentnode != null)
					{
						num = 41;
						continue;
					}
					goto case 1;
				case 48:
					num = 25;
					continue;
				case 25:
					if (HtmlNode.IsClosedElement(_currentnode.Name))
					{
						num = 22;
						continue;
					}
					goto case 36;
				case 4:
					num = ((!HtmlNode.CanOverlapElement(_currentnode.Name)) ? 30 : 5);
					continue;
				case 34:
					num = 45;
					continue;
				case 45:
					if (_lastparentnode != null)
					{
						num = 48;
						continue;
					}
					return;
				case 36:
					UpdateLastParentNode();
					num = 28;
					continue;
				case 28:
					return;
				case 8:
					if (htmlNode4.Name == _currentnode.Name)
					{
						num = 33;
						continue;
					}
					goto IL_0516;
				case 41:
					htmlNode2 = null;
					stack = new Stack<HtmlNode>();
					htmlNode4 = _lastparentnode.LastChild;
					num = 10;
					continue;
				case 10:
				case 50:
					num = 32;
					continue;
				case 32:
					num = ((htmlNode4 == null) ? 38 : 8);
					continue;
				case 1:
				case 2:
				case 13:
				case 20:
				case 31:
				case 44:
					num = 3;
					continue;
				case 3:
					if (!flag)
					{
						num = 34;
						continue;
					}
					return;
				case 24:
					AddError(HtmlParseErrorCode.EndTagInvalidHere, _currentnode._line, _currentnode._lineposition, _currentnode._streamposition, _currentnode.OuterHtml, "End tag </" + _currentnode.Name + "> invalid here");
					flag = true;
					num = 23;
					continue;
				case 18:
				case 35:
					num = 27;
					continue;
				case 27:
					if (stack.Count != 0)
					{
						HtmlNode htmlNode3 = stack.Pop();
						_lastparentnode.RemoveChild(htmlNode3);
						htmlNode2.AppendChild(htmlNode3);
						num = 18;
					}
					else
					{
						num = 26;
					}
					continue;
				case 26:
					num = 44;
					continue;
				case 30:
					if (!HtmlNode.IsEmptyElement(_currentnode.Name))
					{
						AddError(HtmlParseErrorCode.TagNotOpened, _currentnode._line, _currentnode._lineposition, _currentnode._streamposition, _currentnode.OuterHtml, "Start tag <" + _currentnode.Name + "> was not found");
						flag = true;
						num = 2;
					}
					else
					{
						num = 40;
					}
					continue;
				case 17:
				case 38:
					num = 19;
					continue;
				case 19:
					if (htmlNode2 != null)
					{
						num = 14;
						continue;
					}
					_lastparentnode.AppendChild(_currentnode);
					num = 13;
					continue;
				case 23:
					num = 21;
					continue;
				case 21:
					if (!flag)
					{
						num = 43;
						continue;
					}
					goto case 1;
				case 14:
					num = 35;
					continue;
				case 6:
					num = 11;
					continue;
				case 11:
					num = ((!HtmlNode.IsClosedElement(_currentnode.Name)) ? 4 : 0);
					continue;
				case 40:
					AddError(HtmlParseErrorCode.EndTagNotRequired, _currentnode._line, _currentnode._lineposition, _currentnode._streamposition, _currentnode.OuterHtml, "End tag </" + _currentnode.Name + "> is not required");
					num = 1;
					continue;
				case 29:
					num = ((dictionaryValueOrNull == null) ? 6 : 39);
					continue;
				case 46:
					num = 7;
					continue;
				case 7:
					if (FindResetterNodes(dictionaryValueOrNull, GetResetters(_currentnode.Name)))
					{
						num = 24;
						continue;
					}
					goto case 23;
				case 12:
					_lastparentnode.AppendChild(htmlNode);
					num = 20;
					continue;
				case 22:
					num = 37;
					continue;
				case 37:
					{
						if (_currentnode._starttag)
						{
							num = 36;
							continue;
						}
						return;
					}
					IL_0516:
					stack.Push(htmlNode4);
					htmlNode4 = htmlNode4.PreviousSibling;
					num = 50;
					continue;
				}
				if (_currentnode.Closed)
				{
					num = 47;
					continue;
				}
				flag = false;
				dictionaryValueOrNull = Utilities.GetDictionaryValueOrNull(Lastnodes, _currentnode.Name);
				num = 29;
			}
		}
		}
	}

	private string CurrentNodeName()
	{
		return Text.Substring(_currentnode._namestartindex, _currentnode._namelength);
	}

	private void DecrementPosition()
	{
		if (true)
		{
		}
		_index--;
		if (_lineposition == 1)
		{
			_lineposition = _maxlineposition;
			_line--;
		}
		else
		{
			_lineposition--;
		}
	}

	private HtmlNode FindResetterNode(HtmlNode node)
	{
		while (true)
		{
			HtmlNode dictionaryValueOrNull = Utilities.GetDictionaryValueOrNull(Lastnodes, _currentnode.Name);
			int num = 4;
			while (true)
			{
				switch (num)
				{
				case 4:
					num = ((dictionaryValueOrNull != null) ? 3 : 5);
					continue;
				case 2:
					if (dictionaryValueOrNull._streamposition >= node._streamposition)
					{
						num = 1;
						continue;
					}
					return null;
				case 0:
					if (true)
					{
					}
					return null;
				case 5:
					return null;
				case 1:
					return dictionaryValueOrNull;
				case 3:
					num = ((!dictionaryValueOrNull.Closed) ? 2 : 0);
					continue;
				}
				break;
			}
		}
	}

	private bool FindResetterNodes(HtmlNode node, string[] names)
	{
		int num = 4;
		int num2 = default(int);
		while (true)
		{
			switch (num)
			{
			case 6:
				if (true)
				{
				}
				return false;
			case 3:
				if (FindResetterNode(node) == null)
				{
					num2++;
					num = 7;
				}
				else
				{
					num = 1;
				}
				continue;
			case 5:
			case 7:
				num = 2;
				continue;
			case 2:
				num = ((num2 < names.Length) ? 3 : 0);
				continue;
			case 1:
				return true;
			case 0:
				return false;
			}
			if (names == null)
			{
				num = 6;
				continue;
			}
			num2 = 0;
			num = 5;
		}
	}

	private void FixNestedTag(string name, string[] resetters)
	{
		int num = 0;
		HtmlNode dictionaryValueOrNull = default(HtmlNode);
		while (true)
		{
			switch (num)
			{
			default:
				if (resetters == null)
				{
					num = 4;
					break;
				}
				dictionaryValueOrNull = Utilities.GetDictionaryValueOrNull(Lastnodes, _currentnode.Name);
				num = 5;
				break;
			case 4:
				return;
			case 6:
			{
				if (FindResetterNodes(dictionaryValueOrNull, resetters))
				{
					num = 1;
					break;
				}
				HtmlNode htmlNode = new HtmlNode(dictionaryValueOrNull.NodeType, this, -1);
				htmlNode._endnode = htmlNode;
				dictionaryValueOrNull.CloseNode(htmlNode);
				return;
			}
			case 1:
				return;
			case 2:
				num = 3;
				break;
			case 3:
				if (true)
				{
				}
				num = (Lastnodes[name].Closed ? 7 : 6);
				break;
			case 7:
				return;
			case 5:
				if (dictionaryValueOrNull != null)
				{
					num = 2;
					break;
				}
				return;
			}
		}
	}

	private void FixNestedTags()
	{
		if (!_currentnode._starttag)
		{
			if (1 == 0)
			{
			}
		}
		else
		{
			string name = CurrentNodeName();
			FixNestedTag(name, GetResetters(name));
		}
	}

	private string[] GetResetters(string name)
	{
		switch (0)
		{
		default:
		{
			int num = 5;
			string text = default(string);
			while (true)
			{
				switch (num)
				{
				default:
					if (true)
					{
					}
					if ((text = name) != null)
					{
						num = 0;
						continue;
					}
					break;
				case 10:
					num = 3;
					continue;
				case 2:
					num = 6;
					continue;
				case 6:
					if (!(text == "tr"))
					{
						num = 9;
						continue;
					}
					return new string[1] { "table" };
				case 0:
					num = 8;
					continue;
				case 8:
					if (text == "li")
					{
						return new string[1] { "ul" };
					}
					num = 2;
					continue;
				case 7:
					num = 1;
					continue;
				case 1:
					if (!(text == "td"))
					{
						num = 10;
						continue;
					}
					goto IL_00aa;
				case 9:
					num = 4;
					continue;
				case 4:
					if (!(text == "th"))
					{
						num = 7;
						continue;
					}
					goto IL_00aa;
				case 3:
					break;
					IL_00aa:
					return new string[2] { "tr", "table" };
				}
				break;
			}
			return null;
		}
		}
	}

	private void IncrementPosition()
	{
		int num = 2;
		while (true)
		{
			switch (num)
			{
			default:
				if (_crc32 != null)
				{
					num = 4;
					break;
				}
				goto case 0;
			case 3:
				_lineposition = 1;
				_line++;
				return;
			case 0:
				if (true)
				{
				}
				_index++;
				_maxlineposition = _lineposition;
				num = 1;
				break;
			case 1:
				if (_c == 10)
				{
					num = 3;
					break;
				}
				_lineposition++;
				return;
			case 4:
				_crc32.AddToCRC32(_c);
				num = 0;
				break;
			}
		}
	}

	private bool NewCheck()
	{
		int num = 10;
		ParseState state = default(ParseState);
		while (true)
		{
			switch (num)
			{
			case 10:
				if (1 == 0)
				{
				}
				goto default;
			default:
				num = ((_c == 60) ? 13 : 0);
				continue;
			case 8:
				PushNodeStart(HtmlNodeType.Comment, _index - 1);
				PushNodeNameStart(starttag: true, _index);
				PushNodeNameEnd(_index + 1);
				_state = ParseState.Comment;
				num = 21;
				continue;
			case 21:
				if (_index < Text.Length - 2)
				{
					num = 19;
					continue;
				}
				goto case 6;
			case 14:
				_index = Text.Length;
				return true;
			case 22:
				state = _state;
				num = 12;
				continue;
			case 12:
				switch (state)
				{
				default:
					num = 2;
					continue;
				case ParseState.BetweenAttributes:
					PushAttributeNameStart(_index - 1);
					num = 25;
					continue;
				case ParseState.WhichTag:
					PushNodeNameStart(starttag: true, _index - 1);
					_state = ParseState.Tag;
					num = 16;
					continue;
				case ParseState.Tag:
					break;
				}
				goto case 16;
			case 17:
				num = 4;
				continue;
			case 4:
				if (Text[_index + 2] == '-')
				{
					num = 5;
					continue;
				}
				goto IL_01e4;
			case 3:
				num = 24;
				continue;
			case 24:
				if (Text[_index] == '%')
				{
					num = 22;
					continue;
				}
				goto IL_01f8;
			case 18:
				num = 1;
				continue;
			case 1:
				if (Text[_index] == '!')
				{
					num = 8;
					continue;
				}
				break;
			case 26:
				if (!PushNodeEnd(_index - 1, close: true))
				{
					num = 14;
					continue;
				}
				_state = ParseState.WhichTag;
				num = 20;
				continue;
			case 2:
				num = 7;
				continue;
			case 7:
				if (state == ParseState.AttributeAfterEquals)
				{
					num = 9;
					continue;
				}
				goto case 16;
			case 5:
				_fullcomment = true;
				num = 6;
				continue;
			case 6:
			case 15:
				return true;
			case 0:
				return false;
			case 9:
				PushAttributeValueStart(_index - 1);
				num = 23;
				continue;
			case 13:
				if (_index < Text.Length)
				{
					num = 3;
					continue;
				}
				goto IL_01f8;
			case 19:
				num = 11;
				continue;
			case 11:
				if (Text[_index + 1] == '-')
				{
					num = 17;
					continue;
				}
				goto IL_01e4;
			case 20:
				if (_index - 1 <= Text.Length - 2)
				{
					num = 18;
					continue;
				}
				break;
			case 16:
			case 23:
			case 25:
				{
					_oldstate = _state;
					_state = ParseState.ServerSideCode;
					return true;
				}
				IL_01f8:
				num = 26;
				continue;
				IL_01e4:
				_fullcomment = false;
				num = 15;
				continue;
			}
			break;
		}
		PushNodeStart(HtmlNodeType.Element, _index - 1);
		return true;
	}

	private void Parse()
	{
		switch (0)
		{
		}
		ParseState state = default(ParseState);
		ParseState oldstate = default(ParseState);
		int num3 = default(int);
		while (true)
		{
			int num = 0;
			int num2 = 139;
			while (true)
			{
				switch (num2)
				{
				case 139:
					if (OptionComputeChecksum)
					{
						num2 = 27;
						continue;
					}
					goto case 59;
				case 104:
					PushAttributeValueEnd(_index - 1);
					num2 = 108;
					continue;
				case 108:
					num2 = (PushNodeEnd(_index, close: false) ? 150 : 105);
					continue;
				case 30:
					num2 = 160;
					continue;
				case 160:
					if (!IsWhiteSpace(_c))
					{
						num2 = 86;
						continue;
					}
					goto case 7;
				case 2:
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 153;
					continue;
				case 6:
					num2 = 34;
					continue;
				case 34:
					if (Text[_index - 3] == '-')
					{
						num2 = 89;
						continue;
					}
					goto case 7;
				case 151:
					_state = ParseState.BetweenAttributes;
					num2 = 61;
					continue;
				case 82:
					PushAttributeValueEnd(_index - 1);
					_state = ParseState.BetweenAttributes;
					num2 = 180;
					continue;
				case 20:
					num2 = 10;
					continue;
				case 10:
					num2 = ((_c != 34) ? 154 : 167);
					continue;
				case 115:
					num2 = 97;
					continue;
				case 97:
					if (_c != 47)
					{
						num2 = 92;
						continue;
					}
					goto case 140;
				case 106:
					num2 = 48;
					continue;
				case 48:
					if (Text[_index] == '>')
					{
						num2 = 78;
						continue;
					}
					goto case 7;
				case 7:
				case 9:
				case 12:
				case 14:
				case 15:
				case 16:
				case 26:
				case 28:
				case 47:
				case 51:
				case 61:
				case 65:
				case 70:
				case 72:
				case 74:
				case 77:
				case 96:
				case 100:
				case 119:
				case 122:
				case 123:
				case 124:
				case 127:
				case 136:
				case 141:
				case 146:
				case 152:
				case 153:
				case 156:
				case 158:
				case 163:
				case 166:
				case 168:
				case 171:
				case 178:
				case 180:
					num2 = 19;
					continue;
				case 19:
					if (_index >= Text.Length)
					{
						num2 = 0;
						continue;
					}
					_c = Text[_index];
					IncrementPosition();
					state = _state;
					num2 = 147;
					continue;
				case 5:
					PushAttributeNameEnd(_index - 1);
					num2 = 174;
					continue;
				case 174:
					num2 = (PushNodeEnd(_index, close: false) ? 142 : 112);
					continue;
				case 27:
					_crc32 = new Crc32();
					num2 = 59;
					continue;
				case 29:
					_index = Text.Length;
					num2 = 47;
					continue;
				case 8:
					_state = ParseState.EmptyTag;
					num2 = 123;
					continue;
				case 92:
					num2 = 111;
					continue;
				case 111:
					num2 = ((_c != 63) ? 164 : 140);
					continue;
				case 62:
					_state = ParseState.AttributeValue;
					num2 = 133;
					continue;
				case 18:
					if (_c == 62)
					{
						num2 = 23;
						continue;
					}
					goto case 7;
				case 57:
					PushAttributeNameEnd(_index - 1);
					_state = ParseState.AttributeBeforeEquals;
					num2 = 168;
					continue;
				case 132:
					num2 = 43;
					continue;
				case 43:
					num2 = ((!IsWhiteSpace(_c)) ? 135 : 57);
					continue;
				case 50:
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 72;
					continue;
				case 148:
					if (!NewCheck())
					{
						num2 = 98;
						continue;
					}
					goto case 7;
				case 120:
					if (!NewCheck())
					{
						num2 = 93;
						continue;
					}
					goto case 7;
				case 89:
					num2 = 53;
					continue;
				case 53:
					if (!PushNodeEnd(_index, close: false))
					{
						num2 = 143;
						continue;
					}
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 122;
					continue;
				case 25:
					if (_state == ParseState.BetweenAttributes)
					{
						num2 = 162;
						continue;
					}
					goto case 7;
				case 164:
					if (_c == 62)
					{
						num2 = 38;
						continue;
					}
					PushAttributeNameStart(_index - 1);
					_state = ParseState.AttributeName;
					num2 = 136;
					continue;
				case 140:
					_state = ParseState.EmptyTag;
					num2 = 152;
					continue;
				case 102:
					if (_state == ParseState.AttributeBeforeEquals)
					{
						num2 = 131;
						continue;
					}
					goto case 7;
				case 159:
					num2 = 158;
					continue;
				case 99:
					num2 = 165;
					continue;
				case 165:
					if (!IsWhiteSpace(_c))
					{
						num2 = 157;
						continue;
					}
					goto case 7;
				case 125:
					_index = Text.Length;
					num2 = 7;
					continue;
				case 69:
					if (_c == 60)
					{
						num2 = 66;
						continue;
					}
					goto case 7;
				case 117:
					num2 = 35;
					continue;
				case 35:
					if (_index < Text.Length)
					{
						num2 = 106;
						continue;
					}
					goto case 7;
				case 110:
					num2 = ((_c != 47) ? 94 : 84);
					continue;
				case 147:
					num2 = state switch
					{
						ParseState.Comment => 18, 
						ParseState.EmptyTag => 148, 
						ParseState.BetweenAttributes => 120, 
						ParseState.AttributeName => 22, 
						ParseState.QuotedAttributeValue => 134, 
						ParseState.PcData => 176, 
						ParseState.Tag => 79, 
						ParseState.Text => 67, 
						ParseState.AttributeBeforeEquals => 85, 
						ParseState.ServerSideCode => 32, 
						ParseState.AttributeValue => 54, 
						ParseState.AttributeAfterEquals => 161, 
						ParseState.WhichTag => 170, 
						_ => 159, 
					};
					continue;
				case 91:
				case 118:
				case 133:
					IncrementPosition();
					num2 = 127;
					continue;
				case 38:
					num2 = 45;
					continue;
				case 45:
					if (PushNodeEnd(_index, close: false))
					{
						num2 = 25;
						continue;
					}
					if (true)
					{
					}
					num2 = 81;
					continue;
				case 84:
					PushNodeNameEnd(_index - 1);
					num2 = 109;
					continue;
				case 109:
					if (_state == ParseState.Tag)
					{
						num2 = 8;
						continue;
					}
					goto case 7;
				case 114:
					_oldstate = _state;
					_state = ParseState.ServerSideCode;
					num2 = 171;
					continue;
				case 44:
					PushNodeNameStart(starttag: false, _index);
					num2 = 90;
					continue;
				case 169:
					PushNodeNameEnd(_index - 1);
					num2 = 137;
					continue;
				case 137:
					if (_state == ParseState.Tag)
					{
						num2 = 60;
						continue;
					}
					goto case 7;
				case 130:
					_index = Text.Length;
					num2 = 26;
					continue;
				case 81:
					_index = Text.Length;
					num2 = 178;
					continue;
				case 143:
					_index = Text.Length;
					num2 = 119;
					continue;
				case 173:
					PushAttributeValueEnd(_index - 1);
					_state = ParseState.BetweenAttributes;
					num2 = 166;
					continue;
				case 78:
					oldstate = _oldstate;
					num2 = 103;
					continue;
				case 103:
					if (oldstate == ParseState.BetweenAttributes)
					{
						PushAttributeNameEnd(_index + 1);
						_state = ParseState.BetweenAttributes;
						num2 = 118;
					}
					else
					{
						num2 = 83;
					}
					continue;
				case 60:
					num2 = 58;
					continue;
				case 58:
					num2 = (PushNodeEnd(_index, close: false) ? 155 : 29);
					continue;
				case 154:
					if (_c == 62)
					{
						num2 = 13;
						continue;
					}
					PushAttributeValueStart(_index - 1);
					_state = ParseState.AttributeValue;
					num2 = 28;
					continue;
				case 22:
					if (!NewCheck())
					{
						num2 = 132;
						continue;
					}
					goto case 7;
				case 1:
					PushNodeNameEnd(_index - 1);
					num2 = 68;
					continue;
				case 68:
					if (_state == ParseState.Tag)
					{
						num2 = 151;
						continue;
					}
					goto case 7;
				case 134:
					num2 = ((_c == num) ? 173 : 69);
					continue;
				case 86:
					num2 = 172;
					continue;
				case 172:
					if (_c != 39)
					{
						num2 = 20;
						continue;
					}
					goto case 167;
				case 112:
					_index = Text.Length;
					num2 = 15;
					continue;
				case 52:
					PushAttributeNameEnd(_index - 1);
					_state = ParseState.AttributeAfterEquals;
					num2 = 156;
					continue;
				case 64:
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 14;
					continue;
				case 128:
					_state = ParseState.AttributeAfterEquals;
					num2 = 141;
					continue;
				case 176:
					if (_currentnode._namelength + 3 <= Text.Length - (_index - 1))
					{
						num2 = 4;
						continue;
					}
					goto case 7;
				case 157:
					num2 = 107;
					continue;
				case 107:
					num2 = ((_c != 62) ? 175 : 39);
					continue;
				case 142:
					if (_state == ParseState.AttributeName)
					{
						num2 = 64;
						continue;
					}
					goto case 7;
				case 13:
					num2 = 179;
					continue;
				case 179:
					num2 = (PushNodeEnd(_index, close: false) ? 63 : 130);
					continue;
				case 23:
					num2 = 37;
					continue;
				case 37:
					if (_fullcomment)
					{
						num2 = 75;
						continue;
					}
					goto case 89;
				case 167:
					_state = ParseState.QuotedAttributeValue;
					PushAttributeValueStart(_index, _c);
					num = _c;
					num2 = 96;
					continue;
				case 155:
					if (_state == ParseState.Tag)
					{
						num2 = 2;
						continue;
					}
					goto case 7;
				case 79:
					if (!NewCheck())
					{
						num2 = 36;
						continue;
					}
					goto case 7;
				case 67:
					if (NewCheck())
					{
						num2 = 80;
						continue;
					}
					goto case 7;
				case 36:
					num2 = 56;
					continue;
				case 56:
					num2 = (IsWhiteSpace(_c) ? 1 : 110);
					continue;
				case 135:
					num2 = ((_c != 61) ? 88 : 52);
					continue;
				case 150:
					if (_state == ParseState.AttributeValue)
					{
						num2 = 40;
						continue;
					}
					goto case 7;
				case 105:
					_index = Text.Length;
					num2 = 74;
					continue;
				case 145:
					num2 = 95;
					continue;
				case 95:
					num2 = ((!IsWhiteSpace(_c)) ? 11 : 82);
					continue;
				case 46:
					if (_state == ParseState.EmptyTag)
					{
						num2 = 41;
						continue;
					}
					goto case 7;
				case 175:
					if (_c != 61)
					{
						_state = ParseState.BetweenAttributes;
						DecrementPosition();
						num2 = 124;
					}
					else
					{
						num2 = 128;
					}
					continue;
				case 75:
					num2 = 144;
					continue;
				case 144:
					if (Text[_index - 2] == '-')
					{
						num2 = 6;
						continue;
					}
					goto case 7;
				case 59:
					Lastnodes = new Dictionary<string, HtmlNode>();
					_c = 0;
					_fullcomment = false;
					_parseerrors = new List<HtmlParseError>();
					_line = 1;
					_lineposition = 1;
					_maxlineposition = 1;
					_state = ParseState.Text;
					_oldstate = _state;
					_documentnode._innerlength = Text.Length;
					_documentnode._outerlength = Text.Length;
					_remainderOffset = Text.Length;
					_lastparentnode = _documentnode;
					_currentnode = CreateNode(HtmlNodeType.Text, 0);
					_currentattribute = null;
					_index = 0;
					PushNodeStart(HtmlNodeType.Text, 0);
					num2 = 9;
					continue;
				case 80:
					num2 = 163;
					continue;
				case 87:
					_index = Text.Length;
					num2 = 70;
					continue;
				case 85:
					if (!NewCheck())
					{
						num2 = 99;
						continue;
					}
					goto case 7;
				case 41:
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 65;
					continue;
				case 131:
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 77;
					continue;
				case 94:
					if (_c == 62)
					{
						num2 = 169;
						continue;
					}
					goto case 7;
				case 4:
					num2 = 42;
					continue;
				case 42:
					if (string.Compare(Text.Substring(_index - 1, _currentnode._namelength + 2), "</" + _currentnode.Name, StringComparison.OrdinalIgnoreCase) == 0)
					{
						num2 = 55;
						continue;
					}
					goto case 7;
				case 40:
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 51;
					continue;
				case 66:
					num2 = 138;
					continue;
				case 138:
					if (_index < Text.Length)
					{
						num2 = 17;
						continue;
					}
					goto case 7;
				case 98:
					num2 = 129;
					continue;
				case 129:
					if (_c != 62)
					{
						_state = ParseState.BetweenAttributes;
						num2 = 146;
					}
					else
					{
						num2 = 21;
					}
					continue;
				case 55:
					num3 = Text[_index - 1 + 2 + _currentnode.Name.Length];
					num2 = 113;
					continue;
				case 113:
					if (num3 != 62)
					{
						num2 = 101;
						continue;
					}
					goto case 121;
				case 17:
					num2 = 49;
					continue;
				case 49:
					if (Text[_index] == '%')
					{
						num2 = 114;
						continue;
					}
					goto case 7;
				case 63:
					if (_state == ParseState.AttributeAfterEquals)
					{
						num2 = 50;
						continue;
					}
					goto case 7;
				case 83:
					num2 = 33;
					continue;
				case 33:
					if (oldstate == ParseState.AttributeAfterEquals)
					{
						num2 = 62;
						continue;
					}
					_state = _oldstate;
					num2 = 91;
					continue;
				case 162:
					_state = ParseState.Text;
					PushNodeStart(HtmlNodeType.Text, _index);
					num2 = 16;
					continue;
				case 21:
					num2 = 73;
					continue;
				case 73:
					num2 = ((!PushNodeEnd(_index, close: true)) ? 125 : 46);
					continue;
				case 32:
					if (_c == 37)
					{
						num2 = 117;
						continue;
					}
					goto case 7;
				case 54:
					if (!NewCheck())
					{
						num2 = 145;
						continue;
					}
					goto case 7;
				case 121:
				{
					HtmlNode htmlNode = CreateNode(HtmlNodeType.Text, _currentnode._outerstartindex + _currentnode._outerlength);
					htmlNode._outerlength = _index - 1 - htmlNode._outerstartindex;
					_currentnode.AppendChild(htmlNode);
					PushNodeStart(HtmlNodeType.Element, _index - 1);
					PushNodeNameStart(starttag: false, _index - 1 + 2);
					_state = ParseState.Tag;
					IncrementPosition();
					num2 = 12;
					continue;
				}
				case 11:
					if (_c == 62)
					{
						num2 = 104;
						continue;
					}
					goto case 7;
				case 161:
					if (!NewCheck())
					{
						num2 = 30;
						continue;
					}
					goto case 7;
				case 39:
					num2 = 31;
					continue;
				case 31:
					num2 = ((!PushNodeEnd(_index, close: false)) ? 87 : 102);
					continue;
				case 0:
					num2 = 116;
					continue;
				case 116:
					if (_currentnode._namestartindex > 0)
					{
						num2 = 177;
						continue;
					}
					goto case 76;
				case 170:
					if (!NewCheck())
					{
						num2 = 71;
						continue;
					}
					goto case 7;
				case 90:
				case 126:
					_state = ParseState.Tag;
					num2 = 100;
					continue;
				case 88:
					if (_c == 62)
					{
						num2 = 5;
						continue;
					}
					goto case 7;
				case 177:
					PushNodeNameEnd(_index);
					num2 = 76;
					continue;
				case 93:
					num2 = 149;
					continue;
				case 149:
					if (!IsWhiteSpace(_c))
					{
						num2 = 115;
						continue;
					}
					goto case 7;
				case 71:
					num2 = 24;
					continue;
				case 24:
					if (_c != 47)
					{
						PushNodeNameStart(starttag: true, _index - 1);
						DecrementPosition();
						num2 = 126;
					}
					else
					{
						num2 = 44;
					}
					continue;
				case 101:
					num2 = 3;
					continue;
				case 3:
					if (IsWhiteSpace(num3))
					{
						num2 = 121;
						continue;
					}
					goto case 7;
				case 76:
					PushNodeEnd(_index, close: false);
					Lastnodes.Clear();
					return;
				}
				break;
			}
		}
	}

	private void PushAttributeNameEnd(int index)
	{
		if (true)
		{
		}
		_currentattribute._namelength = index - _currentattribute._namestartindex;
		_currentnode.Attributes.Append(_currentattribute);
	}

	private void PushAttributeNameStart(int index)
	{
		if (true)
		{
		}
		_currentattribute = CreateAttribute();
		_currentattribute._namestartindex = index;
		_currentattribute.Line = _line;
		_currentattribute._lineposition = _lineposition;
		_currentattribute._streamposition = index;
	}

	private void PushAttributeValueEnd(int index)
	{
		_currentattribute._valuelength = index - _currentattribute._valuestartindex;
	}

	private void PushAttributeValueStart(int index)
	{
		PushAttributeValueStart(index, 0);
	}

	private void PushAttributeValueStart(int index, int quote)
	{
		while (true)
		{
			_currentattribute._valuestartindex = index;
			int num = 2;
			while (true)
			{
				switch (num)
				{
				case 2:
					if (quote == 39)
					{
						if (true)
						{
						}
						num = 0;
						continue;
					}
					return;
				case 0:
					_currentattribute.QuoteType = AttributeValueQuote.SingleQuote;
					num = 1;
					continue;
				case 1:
					return;
				}
				break;
			}
		}
	}

	private bool PushNodeEnd(int index, bool close)
	{
		while (true)
		{
			_currentnode._outerlength = index - _currentnode._outerstartindex;
			int num = 10;
			while (true)
			{
				switch (num)
				{
				case 10:
					if (_currentnode._nodetype != HtmlNodeType.Text)
					{
						num = 22;
						continue;
					}
					goto IL_046f;
				case 14:
				case 29:
					num = 33;
					continue;
				case 33:
					if (!close)
					{
						num = 30;
						continue;
					}
					goto case 8;
				case 28:
					_state = ParseState.PcData;
					return true;
				case 34:
					if (_currentnode._starttag)
					{
						num = 32;
						continue;
					}
					goto case 14;
				case 25:
					num = 1;
					continue;
				case 1:
					if (_remainder == null)
					{
						num = 23;
						continue;
					}
					goto IL_027d;
				case 37:
					_currentnode._innerlength = _currentnode._outerlength;
					_currentnode._innerstartindex = _currentnode._outerstartindex;
					num = 11;
					continue;
				case 11:
					if (_lastparentnode != null)
					{
						num = 21;
						continue;
					}
					goto case 14;
				case 6:
					close = true;
					num = 14;
					continue;
				case 36:
					_remainderOffset = index;
					_remainder = Text.Substring(_remainderOffset);
					CloseCurrentNode();
					return false;
				case 9:
					num = 4;
					continue;
				case 4:
					num = (HtmlNode.IsCDataElement(CurrentNodeName()) ? 28 : 0);
					continue;
				case 32:
					num = 31;
					continue;
				case 31:
					if (_lastparentnode != _currentnode)
					{
						num = 35;
						continue;
					}
					goto case 14;
				case 23:
					num = 18;
					continue;
				case 18:
					if (string.Compare(_currentnode.Name, OptionStopperNodeName, StringComparison.OrdinalIgnoreCase) == 0)
					{
						num = 36;
						continue;
					}
					goto IL_027d;
				case 24:
				{
					ReadDocumentEncoding(_currentnode);
					HtmlNode dictionaryValueOrNull = Utilities.GetDictionaryValueOrNull(Lastnodes, _currentnode.Name);
					_currentnode._prevwithsamename = dictionaryValueOrNull;
					Lastnodes[_currentnode.Name] = _currentnode;
					num = 13;
					continue;
				}
				case 13:
					if (_currentnode.NodeType != HtmlNodeType.Document)
					{
						num = 20;
						continue;
					}
					goto case 16;
				case 22:
					num = 7;
					continue;
				case 7:
					num = ((_currentnode._nodetype == HtmlNodeType.Comment) ? 19 : 34);
					continue;
				case 19:
					if (1 == 0)
					{
					}
					goto IL_046f;
				case 21:
					_lastparentnode.AppendChild(_currentnode);
					num = 29;
					continue;
				case 35:
					num = 17;
					continue;
				case 17:
					if (_lastparentnode != null)
					{
						num = 5;
						continue;
					}
					goto case 24;
				case 5:
					_lastparentnode.AppendChild(_currentnode);
					num = 24;
					continue;
				case 8:
					num = 38;
					continue;
				case 38:
					if (OptionStopperNodeName != null)
					{
						num = 25;
						continue;
					}
					goto IL_027d;
				case 2:
					num = 3;
					continue;
				case 3:
					if (HtmlNode.IsEmptyElement(_currentnode.Name))
					{
						num = 6;
						continue;
					}
					goto case 14;
				case 20:
					num = 15;
					continue;
				case 15:
					if (_currentnode.NodeType == HtmlNodeType.Element)
					{
						num = 16;
						continue;
					}
					goto case 9;
				case 16:
					_lastparentnode = _currentnode;
					num = 9;
					continue;
				case 0:
					if (!HtmlNode.IsClosedElement(_currentnode.Name))
					{
						num = 2;
						continue;
					}
					goto case 6;
				case 27:
					if (_currentnode._outerlength > 0)
					{
						num = 37;
						continue;
					}
					goto case 14;
				case 30:
					num = 26;
					continue;
				case 26:
					if (!_currentnode._starttag)
					{
						num = 8;
						continue;
					}
					goto case 12;
				case 12:
					{
						return true;
					}
					IL_027d:
					CloseCurrentNode();
					num = 12;
					continue;
					IL_046f:
					num = 27;
					continue;
				}
				break;
			}
		}
	}

	private void PushNodeNameEnd(int index)
	{
		while (true)
		{
			_currentnode._namelength = index - _currentnode._namestartindex;
			int num = 2;
			while (true)
			{
				switch (num)
				{
				case 2:
					if (OptionFixNestedTags)
					{
						num = 1;
						continue;
					}
					return;
				case 1:
					if (true)
					{
					}
					FixNestedTags();
					num = 0;
					continue;
				case 0:
					return;
				}
				break;
			}
		}
	}

	private void PushNodeNameStart(bool starttag, int index)
	{
		_currentnode._starttag = starttag;
		_currentnode._namestartindex = index;
	}

	private void PushNodeStart(HtmlNodeType type, int index)
	{
		while (true)
		{
			_currentnode = CreateNode(type, index);
			_currentnode._line = _line;
			_currentnode._lineposition = _lineposition;
			int num = 0;
			while (true)
			{
				switch (num)
				{
				case 0:
					if (true)
					{
					}
					if (type == HtmlNodeType.Element)
					{
						num = 2;
						continue;
					}
					goto case 1;
				case 2:
					_currentnode._lineposition--;
					num = 1;
					continue;
				case 1:
					_currentnode._streamposition = index;
					return;
				}
				break;
			}
		}
	}

	private void ReadDocumentEncoding(HtmlNode node)
	{
		int num = 22;
		string text = default(string);
		HtmlAttribute htmlAttribute = default(HtmlAttribute);
		HtmlAttribute htmlAttribute2 = default(HtmlAttribute);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((!OptionReadEncoding) ? 9 : 0);
				break;
			case 9:
				return;
			case 20:
				text = NameValuePairList.GetNameValuePairsValue(htmlAttribute.Value, "charset");
				num = 23;
				break;
			case 23:
				if (!string.IsNullOrEmpty(text))
				{
					num = 7;
					break;
				}
				return;
			case 1:
				if (node.Name != "meta")
				{
					num = 21;
					break;
				}
				htmlAttribute2 = node.Attributes["http-equiv"];
				num = 10;
				break;
			case 21:
				return;
			case 18:
				throw new EncodingFoundException(_declaredencoding);
			case 4:
				return;
			case 15:
				try
				{
					_declaredencoding = Encoding.GetEncoding(text);
				}
				catch (ArgumentException)
				{
					_declaredencoding = null;
				}
				num = 11;
				break;
			case 19:
				num = 6;
				break;
			case 6:
				if (_declaredencoding.WebName != _streamencoding.WebName)
				{
					num = 3;
					break;
				}
				return;
			case 14:
				if (true)
				{
				}
				if (htmlAttribute != null)
				{
					num = 20;
					break;
				}
				return;
			case 5:
				if (_streamencoding != null)
				{
					num = 19;
					break;
				}
				return;
			case 3:
				AddError(HtmlParseErrorCode.CharsetMismatch, _line, _lineposition, _index, node.OuterHtml, "Encoding mismatch between StreamEncoding: " + _streamencoding.WebName + " and DeclaredEncoding: " + _declaredencoding.WebName);
				num = 8;
				break;
			case 8:
				return;
			case 16:
				if (string.Compare(htmlAttribute2.Value, "content-type", StringComparison.OrdinalIgnoreCase) == 0)
				{
					htmlAttribute = node.Attributes["content"];
					num = 14;
				}
				else
				{
					num = 17;
				}
				break;
			case 17:
				return;
			case 10:
				num = ((htmlAttribute2 == null) ? 13 : 16);
				break;
			case 13:
				return;
			case 0:
				num = ((node._namelength == 4) ? 1 : 4);
				break;
			case 11:
				num = (_onlyDetectEncoding ? 18 : 5);
				break;
			case 2:
				text = "utf-8";
				num = 15;
				break;
			case 7:
				num = 12;
				break;
			case 12:
				if (string.Equals(text, "utf8", StringComparison.OrdinalIgnoreCase))
				{
					num = 2;
					break;
				}
				goto case 15;
			}
		}
	}
}
