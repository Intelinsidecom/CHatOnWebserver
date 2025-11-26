using System;
using System.Threading.Tasks;

namespace ChatOn.Services;

public abstract class QueueItem
{
	public QueuePriority Priority;

	public Action<object, Exception> InvokeBack;

	public QueueItem()
	{
		Priority = QueuePriority.Normal;
	}

	public QueueItem(QueuePriority priority)
	{
		Priority = priority;
	}

	public abstract Task Perform();
}
