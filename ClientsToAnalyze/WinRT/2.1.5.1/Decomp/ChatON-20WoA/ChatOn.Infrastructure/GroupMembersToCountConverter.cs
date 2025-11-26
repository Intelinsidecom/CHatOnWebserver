using System;
using System.Linq;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class GroupMembersToCountConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (string.IsNullOrEmpty(value.ToString()))
		{
			return "(0)";
		}
		return "(" + value.ToString().Split(',').Count() + ")";
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
