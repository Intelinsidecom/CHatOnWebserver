using System;
using Microsoft.Phone.Scheduler;

namespace ChatOn.Services;

public class BackgroundAgentService
{
	private static string CHATON_TASKNAME = "ChatOnAgent";

	internal static void StopBackgroundAgent()
	{
		PeriodicTask val = null;
		try
		{
			ScheduledAction obj = ScheduledActionService.Find(CHATON_TASKNAME);
			val = (PeriodicTask)(object)((obj is PeriodicTask) ? obj : null);
		}
		catch (Exception)
		{
		}
		if (val != null)
		{
			RemoveBackgroundAgent(CHATON_TASKNAME);
		}
	}

	internal static void CreateBackgroundAgent()
	{
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Expected O, but got Unknown
		StopBackgroundAgent();
		try
		{
			PeriodicTask val = new PeriodicTask(CHATON_TASKNAME);
			((ScheduledTask)val).Description = "ChatON";
			ScheduledActionService.Add((ScheduledAction)(object)val);
		}
		catch (Exception)
		{
		}
	}

	private static void RemoveBackgroundAgent(string name)
	{
		try
		{
			ScheduledActionService.Remove(name);
		}
		catch (Exception)
		{
		}
	}
}
