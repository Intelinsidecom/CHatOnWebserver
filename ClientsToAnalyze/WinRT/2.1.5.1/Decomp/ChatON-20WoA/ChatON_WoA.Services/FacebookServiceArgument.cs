namespace ChatON_WoA.Services;

public class FacebookServiceArgument
{
	public FacebookServiceResultType ResultType { get; set; }

	public FacebookServiceArgument(FacebookServiceResultType type)
	{
		ResultType = type;
	}
}
