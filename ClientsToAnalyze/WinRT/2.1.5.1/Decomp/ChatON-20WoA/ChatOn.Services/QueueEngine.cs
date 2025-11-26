using System;
using System.Collections.Generic;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using Windows.UI.Xaml;

namespace ChatOn.Services;

public class QueueEngine
{
	private Queue<QueueItem> ListOfQueueItem;

	private List<QueueItem> ListOfActiveItem;

	private static int MaxActiveItem = 6;

	private DispatcherTimer timer;

	public unsafe QueueEngine()
	{
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0027: Expected O, but got Unknown
		ListOfQueueItem = new Queue<QueueItem>();
		ListOfActiveItem = new List<QueueItem>();
		timer = new DispatcherTimer();
		timer.put_Interval(new TimeSpan(0, 0, 0, 0, 50));
		DispatcherTimer val = timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.remove_Tick)), timer_Tick);
	}

	public void Start()
	{
		timer.Start();
	}

	public void Stop()
	{
		timer.Stop();
	}

	public void Clear()
	{
		lock (ListOfQueueItem)
		{
			ListOfQueueItem.Clear();
		}
	}

	public void Add(QueueItem item)
	{
		lock (ListOfQueueItem)
		{
			ListOfQueueItem.Enqueue(item);
		}
	}

	private async void timer_Tick(object sender, object e)
	{
		if (ListOfActiveItem.Count >= MaxActiveItem)
		{
			return;
		}
		QueueItem activeItem = null;
		lock (ListOfQueueItem)
		{
			if (ListOfQueueItem.Count == 0)
			{
				return;
			}
			activeItem = ListOfQueueItem.Dequeue();
		}
		try
		{
			int num = default(int);
			_ = num;
			_ = 0;
			try
			{
				lock (ListOfActiveItem)
				{
					ListOfActiveItem.Add(activeItem);
				}
				await activeItem.Perform();
			}
			catch (Exception ex)
			{
				Logger.Log("[QueueEngine] Exception : " + ex.Message);
			}
		}
		finally
		{
			lock (ListOfActiveItem)
			{
				ListOfActiveItem.Remove(activeItem);
			}
		}
	}
}
