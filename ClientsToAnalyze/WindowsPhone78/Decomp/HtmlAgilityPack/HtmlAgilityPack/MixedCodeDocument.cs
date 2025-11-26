using System;
using System.IO;
using System.Text;

namespace HtmlAgilityPack;

public class MixedCodeDocument
{
	private enum ParseState
	{
		Text,
		Code
	}

	private int _c;

	internal MixedCodeDocumentFragmentList _codefragments;

	private MixedCodeDocumentFragment _currentfragment;

	internal MixedCodeDocumentFragmentList _fragments;

	private int _index;

	private int _line;

	private int _lineposition;

	private ParseState _state;

	private Encoding _streamencoding;

	internal string _text;

	internal MixedCodeDocumentFragmentList _textfragments;

	public string TokenCodeEnd = "%>";

	public string TokenCodeStart = "<%";

	public string TokenDirective = "@";

	public string TokenResponseWrite = "Response.Write ";

	private string TokenTextBlock = "TextBlock({0})";

	public string Code
	{
		get
		{
			switch (0)
			{
			default:
			{
				if (true)
				{
				}
				string text = "";
				int num = 0;
				MixedCodeDocumentFragmentList.MixedCodeDocumentFragmentEnumerator enumerator = _fragments.GetEnumerator();
				try
				{
					int num2 = 6;
					MixedCodeDocumentFragment current = default(MixedCodeDocumentFragment);
					MixedCodeDocumentFragmentType type = default(MixedCodeDocumentFragmentType);
					while (true)
					{
						switch (num2)
						{
						case 7:
							num2 = 4;
							break;
						default:
							num2 = 5;
							break;
						case 5:
							if (!enumerator.MoveNext())
							{
								num2 = 0;
								break;
							}
							current = enumerator.Current;
							type = current._type;
							num2 = 1;
							break;
						case 1:
							switch (type)
							{
							default:
								num2 = 7;
								break;
							case MixedCodeDocumentFragmentType.Code:
								text = text + ((MixedCodeDocumentCodeFragment)current).Code + "\n";
								num2 = 3;
								break;
							case MixedCodeDocumentFragmentType.Text:
								text = text + TokenResponseWrite + string.Format(TokenTextBlock, num) + "\n";
								num++;
								num2 = 8;
								break;
							}
							break;
						case 0:
							num2 = 2;
							break;
						case 2:
							return text;
						}
					}
				}
				finally
				{
					while (true)
					{
						IL_0143:
						IDisposable disposable = enumerator as IDisposable;
						int num2 = 2;
						while (true)
						{
							switch (num2)
							{
							case 2:
								if (disposable != null)
								{
									num2 = 1;
									continue;
								}
								goto end_IL_0130;
							case 1:
								disposable.Dispose();
								num2 = 0;
								continue;
							case 0:
								goto end_IL_0130;
							}
							goto IL_0143;
							continue;
							end_IL_0130:
							break;
						}
						break;
					}
				}
			}
			}
		}
	}

	public MixedCodeDocumentFragmentList CodeFragments => _codefragments;

	public MixedCodeDocumentFragmentList Fragments => _fragments;

	public Encoding StreamEncoding => _streamencoding;

	public MixedCodeDocumentFragmentList TextFragments => _textfragments;

	public MixedCodeDocument()
	{
		_codefragments = new MixedCodeDocumentFragmentList(this);
		_textfragments = new MixedCodeDocumentFragmentList(this);
		_fragments = new MixedCodeDocumentFragmentList(this);
	}

	public MixedCodeDocumentCodeFragment CreateCodeFragment()
	{
		return (MixedCodeDocumentCodeFragment)CreateFragment(MixedCodeDocumentFragmentType.Code);
	}

	public MixedCodeDocumentTextFragment CreateTextFragment()
	{
		return (MixedCodeDocumentTextFragment)CreateFragment(MixedCodeDocumentFragmentType.Text);
	}

	public void Load(Stream stream)
	{
		Load(new StreamReader(stream));
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
		Load(new StreamReader(path));
	}

	public void Load(string path, bool detectEncodingFromByteOrderMarks)
	{
		Load(new StreamReader(path, detectEncodingFromByteOrderMarks));
	}

	public void Load(string path, Encoding encoding)
	{
		Load(new StreamReader(path, encoding));
	}

	public void Load(string path, Encoding encoding, bool detectEncodingFromByteOrderMarks)
	{
		Load(new StreamReader(path, encoding, detectEncodingFromByteOrderMarks));
	}

	public void Load(string path, Encoding encoding, bool detectEncodingFromByteOrderMarks, int buffersize)
	{
		Load(new StreamReader(path, encoding, detectEncodingFromByteOrderMarks, buffersize));
	}

	public void Load(TextReader reader)
	{
		while (true)
		{
			if (true)
			{
			}
			_codefragments.Clear();
			_textfragments.Clear();
			StreamReader streamReader = reader as StreamReader;
			int num = 2;
			while (true)
			{
				switch (num)
				{
				case 2:
					if (streamReader != null)
					{
						num = 1;
						continue;
					}
					goto case 0;
				case 1:
					_streamencoding = streamReader.CurrentEncoding;
					num = 0;
					continue;
				case 0:
					_text = reader.ReadToEnd();
					reader.Close();
					Parse();
					return;
				}
				break;
			}
		}
	}

	public void LoadHtml(string html)
	{
		Load(new StringReader(html));
	}

	public void Save(Stream outStream)
	{
		StreamWriter writer = new StreamWriter(outStream, GetOutEncoding());
		Save(writer);
	}

	public void Save(Stream outStream, Encoding encoding)
	{
		StreamWriter writer = new StreamWriter(outStream, encoding);
		Save(writer);
	}

	public void Save(string filename)
	{
		StreamWriter writer = new StreamWriter(filename, append: false, GetOutEncoding());
		Save(writer);
	}

	public void Save(string filename, Encoding encoding)
	{
		StreamWriter writer = new StreamWriter(filename, append: false, encoding);
		Save(writer);
	}

	public void Save(StreamWriter writer)
	{
		Save((TextWriter)writer);
	}

	public void Save(TextWriter writer)
	{
		writer.Flush();
	}

	internal MixedCodeDocumentFragment CreateFragment(MixedCodeDocumentFragmentType type)
	{
		while (true)
		{
			int num = 1;
			while (true)
			{
				switch (num)
				{
				case 1:
					switch (type)
					{
					case MixedCodeDocumentFragmentType.Code:
						return new MixedCodeDocumentCodeFragment(this);
					case MixedCodeDocumentFragmentType.Text:
						return new MixedCodeDocumentTextFragment(this);
					}
					num = 2;
					continue;
				case 2:
					if (true)
					{
					}
					num = 0;
					continue;
				case 0:
					throw new NotSupportedException();
				}
				break;
			}
		}
	}

	internal Encoding GetOutEncoding()
	{
		if (_streamencoding != null)
		{
			return _streamencoding;
		}
		return Encoding.UTF8;
	}

	private void IncrementPosition()
	{
		_index++;
		if (_c == 10)
		{
			_lineposition = 1;
			_line++;
			return;
		}
		if (true)
		{
		}
		_lineposition++;
	}

	private void Parse()
	{
		ParseState state = default(ParseState);
		while (true)
		{
			_state = ParseState.Text;
			_index = 0;
			_currentfragment = CreateFragment(MixedCodeDocumentFragmentType.Text);
			int num = 3;
			while (true)
			{
				switch (num)
				{
				case 7:
					num = 8;
					continue;
				case 8:
					if (_text.Substring(_index - 1, TokenCodeEnd.Length) == TokenCodeEnd)
					{
						num = 14;
						continue;
					}
					goto case 0;
				case 13:
					_state = ParseState.Code;
					_currentfragment.Length = _index - 1 - _currentfragment.Index;
					_currentfragment = CreateFragment(MixedCodeDocumentFragmentType.Code);
					SetPosition();
					num = 0;
					continue;
				case 1:
					num = 10;
					continue;
				case 14:
					_state = ParseState.Text;
					_currentfragment.Length = _index + TokenCodeEnd.Length - _currentfragment.Index;
					_index += TokenCodeEnd.Length;
					_lineposition += TokenCodeEnd.Length;
					_currentfragment = CreateFragment(MixedCodeDocumentFragmentType.Text);
					SetPosition();
					num = 15;
					continue;
				case 4:
					num = state switch
					{
						ParseState.Code => 11, 
						ParseState.Text => 5, 
						_ => 1, 
					};
					continue;
				case 11:
					if (_index + TokenCodeEnd.Length < _text.Length)
					{
						num = 7;
						continue;
					}
					goto case 0;
				case 0:
				case 3:
				case 10:
				case 15:
					if (true)
					{
					}
					num = 2;
					continue;
				case 2:
					if (_index < _text.Length)
					{
						_c = _text[_index];
						IncrementPosition();
						state = _state;
						num = 4;
					}
					else
					{
						num = 9;
					}
					continue;
				case 12:
					num = 6;
					continue;
				case 6:
					if (_text.Substring(_index - 1, TokenCodeStart.Length) == TokenCodeStart)
					{
						num = 13;
						continue;
					}
					goto case 0;
				case 5:
					if (_index + TokenCodeStart.Length < _text.Length)
					{
						num = 12;
						continue;
					}
					goto case 0;
				case 9:
					_currentfragment.Length = _index - _currentfragment.Index;
					return;
				}
				break;
			}
		}
	}

	private void SetPosition()
	{
		if (true)
		{
		}
		_currentfragment.Line = _line;
		_currentfragment._lineposition = _lineposition;
		_currentfragment.Index = _index - 1;
		_currentfragment.Length = 0;
	}
}
