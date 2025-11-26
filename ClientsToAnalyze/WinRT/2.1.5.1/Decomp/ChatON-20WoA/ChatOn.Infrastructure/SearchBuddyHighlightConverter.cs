using System;
using System.Collections.Generic;
using Windows.UI;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Documents;
using Windows.UI.Xaml.Media;

namespace ChatOn.Infrastructure;

public class SearchBuddyHighlightConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0014: Expected O, but got Unknown
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Expected O, but got Unknown
		//IL_0048: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		//IL_0123: Unknown result type (might be due to invalid IL or missing references)
		//IL_012a: Expected O, but got Unknown
		//IL_0131: Unknown result type (might be due to invalid IL or missing references)
		//IL_013b: Expected O, but got Unknown
		//IL_00cd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d4: Expected O, but got Unknown
		//IL_00db: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e5: Expected O, but got Unknown
		//IL_008b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0092: Expected O, but got Unknown
		//IL_0099: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a3: Expected O, but got Unknown
		string text = value as string;
		string text2 = parameter as string;
		Paragraph val = new Paragraph();
		if (string.IsNullOrEmpty(text))
		{
			return null;
		}
		int length = text.Length;
		int num = 0;
		int num2 = text.LastIndexOf(text2, StringComparison.OrdinalIgnoreCase);
		if (num2 < 0)
		{
			Run val2 = new Run();
			((TextElement)val2).put_Foreground((Brush)new SolidColorBrush(Colors.Black));
			val2.put_Text(text);
			Run item = val2;
			((ICollection<Inline>)val.Inlines).Add((Inline)(object)item);
		}
		else
		{
			while (num < num2)
			{
				if (text.Substring(num, text2.Length).ToLower().Contains(text2))
				{
					Run val3 = new Run();
					((TextElement)val3).put_Foreground((Brush)new SolidColorBrush(Colors.Red));
					val3.put_Text(text.Substring(num, text2.Length + 1));
					Run item2 = val3;
					((ICollection<Inline>)val.Inlines).Add((Inline)(object)item2);
				}
				else
				{
					Run val4 = new Run();
					((TextElement)val4).put_Foreground((Brush)new SolidColorBrush(Colors.Black));
					val4.put_Text(text.Substring(num, text2.Length + 1));
					Run item3 = val4;
					((ICollection<Inline>)val.Inlines).Add((Inline)(object)item3);
				}
				num = text.IndexOf(text2, num) + 1;
			}
			Run val5 = new Run();
			((TextElement)val5).put_Foreground((Brush)new SolidColorBrush(Colors.Black));
			val5.put_Text(text.Substring(num, length - num));
			Run item4 = val5;
			((ICollection<Inline>)val.Inlines).Add((Inline)(object)item4);
		}
		return val;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
