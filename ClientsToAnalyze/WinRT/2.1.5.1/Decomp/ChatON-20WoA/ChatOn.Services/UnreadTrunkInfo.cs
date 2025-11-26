namespace ChatOn.Services;

public class UnreadTrunkInfo
{
	private string _sessionID;

	private int _unreadCount;

	public string SessionID
	{
		get
		{
			return _sessionID;
		}
		set
		{
			_sessionID = value;
		}
	}

	public int UnreadCount
	{
		get
		{
			return _unreadCount;
		}
		set
		{
			_unreadCount = value;
		}
	}
}
