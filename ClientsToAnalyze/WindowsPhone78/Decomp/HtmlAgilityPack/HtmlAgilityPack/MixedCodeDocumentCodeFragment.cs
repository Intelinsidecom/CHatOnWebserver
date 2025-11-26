namespace HtmlAgilityPack;

public class MixedCodeDocumentCodeFragment : MixedCodeDocumentFragment
{
	private string _code;

	public string Code
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
					if (_code == null)
					{
						num = 0;
						continue;
					}
					break;
				case 4:
					_code = Doc.TokenResponseWrite + _code.Substring(1, _code.Length - 1);
					num = 3;
					continue;
				case 0:
					_code = base.FragmentText.Substring(Doc.TokenCodeStart.Length, base.FragmentText.Length - Doc.TokenCodeEnd.Length - Doc.TokenCodeStart.Length - 1).Trim();
					num = 1;
					continue;
				case 1:
					if (_code.StartsWith("="))
					{
						num = 4;
						continue;
					}
					break;
				case 3:
					break;
				}
				break;
			}
			return _code;
		}
		set
		{
			_code = value;
		}
	}

	internal MixedCodeDocumentCodeFragment(MixedCodeDocument doc)
		: base(doc, MixedCodeDocumentFragmentType.Code)
	{
	}
}
