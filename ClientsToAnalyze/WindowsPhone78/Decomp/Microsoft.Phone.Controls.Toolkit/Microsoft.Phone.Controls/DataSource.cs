using System;
using System.Windows.Controls;
using Microsoft.Phone.Controls.Primitives;

namespace Microsoft.Phone.Controls;

internal abstract class DataSource : ILoopingSelectorDataSource
{
	private DateTimeWrapper _selectedItem;

	public object SelectedItem
	{
		get
		{
			return _selectedItem;
		}
		set
		{
			if (value != _selectedItem)
			{
				DateTimeWrapper dateTimeWrapper = (DateTimeWrapper)value;
				if (dateTimeWrapper == null || _selectedItem == null || dateTimeWrapper.DateTime != _selectedItem.DateTime)
				{
					object selectedItem = _selectedItem;
					_selectedItem = dateTimeWrapper;
					this.SelectionChanged?.Invoke(this, new SelectionChangedEventArgs(new object[1] { selectedItem }, new object[1] { _selectedItem }));
				}
			}
		}
	}

	public event EventHandler<SelectionChangedEventArgs> SelectionChanged;

	public object GetNext(object relativeTo)
	{
		DateTime? relativeTo2 = GetRelativeTo(((DateTimeWrapper)relativeTo).DateTime, 1);
		if (!relativeTo2.HasValue)
		{
			return null;
		}
		return new DateTimeWrapper(relativeTo2.Value);
	}

	public object GetPrevious(object relativeTo)
	{
		DateTime? relativeTo2 = GetRelativeTo(((DateTimeWrapper)relativeTo).DateTime, -1);
		if (!relativeTo2.HasValue)
		{
			return null;
		}
		return new DateTimeWrapper(relativeTo2.Value);
	}

	protected abstract DateTime? GetRelativeTo(DateTime relativeDate, int delta);
}
