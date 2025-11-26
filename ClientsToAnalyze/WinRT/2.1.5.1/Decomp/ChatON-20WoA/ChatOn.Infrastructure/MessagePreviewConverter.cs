using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class MessagePreviewConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string text = value as string;
		string[] array = Utility.Split(text.Trim(), '\n');
		if (array.Length >= 2)
		{
			if (array[0] == "image" && text.Contains("download/anicon"))
			{
				return Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
			}
			if (array[0] == "image" && array[1].Contains("jpg"))
			{
				return Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			if (array[0] == "ams")
			{
				return Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			if (array[0] == "video")
			{
				return Utility.GetResourceString("IDS_CHATON_HEADER_VIDEO");
			}
			if (array[0] == "audio")
			{
				return Utility.GetResourceString("IDS_CHATON_HEADER_AUDIO");
			}
			if (array[0] == "contact")
			{
				return Utility.GetResourceString("IDS_CHATON_SK3_CONTACT");
			}
			if (array[0] == "geo")
			{
				return Utility.GetResourceString("IDS_CHATON_BODY_LOCATION_ABB");
			}
			if (array[0] == "mixed" && array[1] == "image")
			{
				return Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			if (array[0] == "mixed" && array[1] == "video")
			{
				return Utility.GetResourceString("IDS_CHATON_HEADER_VIDEO");
			}
			if (array[0] == "mixed" && array[1] == "geo")
			{
				return Utility.GetResourceString("IDS_CHATON_BODY_LOCATION_ABB");
			}
			if (array[0] == "mixed" && array[1] == "contact")
			{
				return Utility.GetResourceString("IDS_CHATON_SK3_CONTACT");
			}
			if (array[0] == "mixed" && array[1] == "audio")
			{
				return Utility.GetResourceString("IDS_CHATON_HEADER_AUDIO");
			}
			if (array[0] == "mixed" && array[1] == "anicon")
			{
				return Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
			}
			if (array[0] == "mixed" && array[1] == "ams")
			{
				return Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			return array[0].Trim();
		}
		return text.Trim();
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
