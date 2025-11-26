using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class SentCountStringConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = (int)value;
		string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_ME_HPD");
		resourceString = resourceString.Replace("%d", "{0:d}");
		return string.Format(resourceString, new object[1] { num });
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
