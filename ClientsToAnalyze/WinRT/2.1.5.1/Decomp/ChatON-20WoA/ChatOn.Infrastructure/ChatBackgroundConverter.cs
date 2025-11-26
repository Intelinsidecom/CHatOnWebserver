using System;
using ChatON_WoA.Views;
using ChatOn.Models;
using Windows.UI;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media;

namespace ChatOn.Infrastructure;

public class ChatBackgroundConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Expected O, but got Unknown
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_002d: Expected O, but got Unknown
		Chat item = (Chat)value;
		int num = PivotPage.ActiveInstance.ViewModel.ChatItems.IndexOf(item);
		if (num % 2 != 0)
		{
			return (object)new SolidColorBrush(Colors.Transparent);
		}
		return (object)new SolidColorBrush(Colors.LightGray);
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
