using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class TotalMemberConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (!value.ToString().Equals("0"))
		{
			return "(" + value.ToString() + ")";
		}
		return string.Empty;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
