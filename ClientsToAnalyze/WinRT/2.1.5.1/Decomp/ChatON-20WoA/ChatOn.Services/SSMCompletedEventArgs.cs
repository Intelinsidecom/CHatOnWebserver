using System;
using System.Net;
using System.Xml.Linq;

namespace ChatOn.Services;

public class SSMCompletedEventArgs
{
	private string _resultString;

	private object _value;

	private object _param;

	private XElement _xml;

	private Exception _error;

	private string _errorMessage;

	private HttpStatusCode _statusCode;

	private string _log;

	public string Log
	{
		get
		{
			return _log;
		}
		set
		{
			_log = value;
		}
	}

	public HttpStatusCode StatusCode
	{
		get
		{
			return _statusCode;
		}
		set
		{
			_statusCode = value;
		}
	}

	public string ErrorMessage
	{
		get
		{
			return _errorMessage;
		}
		set
		{
			_errorMessage = value;
		}
	}

	public Exception Error
	{
		get
		{
			return _error;
		}
		set
		{
			_error = value;
		}
	}

	public object Value
	{
		get
		{
			return _value;
		}
		set
		{
			_value = value;
		}
	}

	public object Param
	{
		get
		{
			return _param;
		}
		set
		{
			_param = value;
		}
	}

	public string ResultString
	{
		get
		{
			return _resultString;
		}
		set
		{
			_resultString = value;
		}
	}

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

	public SSMCompletedEventArgs()
	{
	}

	public SSMCompletedEventArgs(string result)
	{
		_resultString = result;
	}

	public SSMCompletedEventArgs(XElement xml)
	{
		_xml = xml;
	}

	public SSMCompletedEventArgs(object value)
	{
		_value = value;
	}

	public SSMCompletedEventArgs(Exception error)
	{
		_error = error;
	}
}
