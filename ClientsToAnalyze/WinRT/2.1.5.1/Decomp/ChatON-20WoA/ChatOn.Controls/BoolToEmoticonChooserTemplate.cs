using System;
using System.Collections.Generic;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Controls;

public class BoolToEmoticonChooserTemplate : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string key = parameter as string;
		if ((bool)value && EmoticonChooser.ActiveInstance != null)
		{
			object obj = ((IDictionary<object, object>)((FrameworkElement)EmoticonChooser.ActiveInstance).Resources)[(object)key];
			return (obj is DataTemplate) ? obj : null;
		}
		return null;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
