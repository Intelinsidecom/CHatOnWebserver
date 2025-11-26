using System.Xml.Linq;

namespace ChatOn_WoA.Services;

internal class SamsungAccountServiceResult
{
	private SamsungAccountServiceResultType _resultType;

	private string _resultString;

	private XElement _xml;

	public SamsungAccountServiceResultType ResultType
	{
		get
		{
			return _resultType;
		}
		set
		{
			_resultType = value;
		}
	}

	public string ResultString => _resultString;

	public XElement Xml
	{
		get
		{
			return _xml;
		}
		set
		{
			_xml = value;
		}
	}

	public SamsungAccountServiceResult(string resultString)
	{
		_resultString = resultString;
	}

	public SamsungAccountServiceResult(XElement resultXml)
	{
		_xml = resultXml;
	}
}
