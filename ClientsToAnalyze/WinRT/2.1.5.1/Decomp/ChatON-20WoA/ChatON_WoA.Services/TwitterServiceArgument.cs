namespace ChatON_WoA.Services;

public class TwitterServiceArgument
{
	public TwitterServiceResultType ResultType { get; set; }

	public TwitterServiceArgument(TwitterServiceResultType type)
	{
		ResultType = type;
	}
}
