namespace ChatOn.Services;

public class BackgroundAgentService
{
	private static string CHATON_TASKNAME = "ChatOnAgent";

	internal static void StopBackgroundAgent()
	{
	}

	internal static void CreateBackgroundAgent()
	{
		StopBackgroundAgent();
	}

	private static void RemoveBackgroundAgent(string name)
	{
	}
}
