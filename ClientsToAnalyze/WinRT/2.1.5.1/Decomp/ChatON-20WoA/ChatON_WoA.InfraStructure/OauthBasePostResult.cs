using System.Net;

namespace ChatON_WoA.InfraStructure;

public class OauthBasePostResult
{
	private HttpStatusCode _statusCode;

	private string _result;

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

	public string Response
	{
		get
		{
			return _result;
		}
		set
		{
			_result = value;
		}
	}
}
