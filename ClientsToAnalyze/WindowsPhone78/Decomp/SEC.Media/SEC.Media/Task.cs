using System;

namespace SEC.Media;

public class Task
{
	public Action<Task> TaskCancelAction;

	public Action<Task> TaskDoneAction;
}
