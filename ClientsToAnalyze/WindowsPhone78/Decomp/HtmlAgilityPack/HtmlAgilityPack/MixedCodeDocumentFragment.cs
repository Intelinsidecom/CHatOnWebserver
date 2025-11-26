namespace HtmlAgilityPack;

public abstract class MixedCodeDocumentFragment
{
	internal MixedCodeDocument Doc;

	private string _fragmentText;

	internal int Index;

	internal int Length;

	private int _line;

	internal int _lineposition;

	internal MixedCodeDocumentFragmentType _type;

	public string FragmentText
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
					if (_fragmentText == null)
					{
						num = 1;
						continue;
					}
					break;
				case 1:
					_fragmentText = Doc._text.Substring(Index, Length);
					num = 2;
					continue;
				case 2:
					break;
				}
				break;
			}
			return FragmentText;
		}
		internal set
		{
			_fragmentText = value;
		}
	}

	public MixedCodeDocumentFragmentType FragmentType => _type;

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

	public int StreamPosition => Index;

	internal MixedCodeDocumentFragment(MixedCodeDocument doc, MixedCodeDocumentFragmentType type)
	{
		Doc = doc;
		_type = type;
		switch (type)
		{
		case MixedCodeDocumentFragmentType.Code:
			Doc._codefragments.Append(this);
			break;
		case MixedCodeDocumentFragmentType.Text:
			Doc._textfragments.Append(this);
			break;
		}
		Doc._fragments.Append(this);
	}
}
