using System;
using ChatOn.Models;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class RankStatusConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (!(value is Buddy buddy))
		{
			return null;
		}
		return Utility.GetResourceString("IDS_CHATON_BODY_RANK_ABB") + ": " + buddy.DisplayRank + " / " + Utility.GetResourceString("IDS_CHATON_BODY_POINTS_ABB") + ": " + (buddy.SentCount + buddy.ReceivedCount);
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
