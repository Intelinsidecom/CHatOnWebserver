using System;

namespace Microsoft.Phone.Controls;

public class DateTimeValueChangedEventArgs : EventArgs
{
	public DateTime? OldDateTime { get; private set; }

	public DateTime? NewDateTime { get; private set; }

	public DateTimeValueChangedEventArgs(DateTime? oldDateTime, DateTime? newDateTime)
	{
		OldDateTime = oldDateTime;
		NewDateTime = newDateTime;
	}
}
