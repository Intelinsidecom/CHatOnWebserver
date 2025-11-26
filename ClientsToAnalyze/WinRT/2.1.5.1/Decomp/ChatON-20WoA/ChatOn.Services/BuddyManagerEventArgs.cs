namespace ChatOn.Services;

public class BuddyManagerEventArgs
{
	public string Result { get; set; }

	public BuddyManagerEventArgs(string result)
	{
		Result = result;
	}
}
