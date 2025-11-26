using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Queue;

public class GetNationalFlag_QueueItem : QueueItem
{
	private string countryCode = "";

	private SSMService SSMService;

	public GetNationalFlag_QueueItem(SSMService ssmservice, string countrycode)
		: base(QueuePriority.Low)
	{
		SSMService = ssmservice;
		countryCode = countrycode;
	}

	internal string ParseFlagUri(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("fileurl")
			select (item);
		string result = "";
		foreach (XElement item in enumerable)
		{
			result = item.Value;
			result = result.Replace("&amp;", "&");
		}
		return result;
	}

	public override async Task Perform()
	{
		BitmapImage result = null;
		if (SSMService != null)
		{
			string flagpath = "flag_" + countryCode + ".jpg";
			string flagdirectorypath = "Cache";
			StringBuilder builder = new StringBuilder();
			builder.Append(SSMService.http);
			builder.Append(SSMService._svrAddress.ContactServer);
			builder.Append("/nationalflag");
			builder.Append("?uid=" + SSMService._account.Uid);
			builder.Append("&imei=" + SSMService._account.IMEI);
			builder.Append("&contrycode=" + countryCode);
			Logger.Log("GetNationalFlag_QueueItem --> Retreiving for " + countryCode);
			if (string.IsNullOrEmpty(countryCode))
			{
				Logger.Log("GetNationalFlag_QueueItem --> empty Country Code");
				result = new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/icon_noti.png"));
			}
			else
			{
				Logger.Log("GetNationalFlag_QueueItem --> startLoadImage");
				result = await Utility.LoadImage(flagpath, flagdirectorypath);
				if (result == null)
				{
					Logger.Log("GetNationalFlag_QueueItem --> No Image Available Retreving From Web");
					string xmlString = (await SSMService.HttpGetRequestString("GetNationalFlagUri", builder.ToString())).ResultString;
					string uri = "";
					if (!string.IsNullOrEmpty(xmlString))
					{
						XElement xe = XElement.Load(new StringReader(xmlString));
						uri = ParseFlagUri(xe);
					}
					Logger.Log("GetNationalFlag_QueueItem --> Get Uri : " + uri);
					if (uri == "")
					{
						result = new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/icon_noti.png"));
					}
					else
					{
						result = await Utility.LoadOrSaveWebImage(flagpath, new Uri(uri), flagdirectorypath);
						Logger.Log("GetNationalFlag_QueueItem --> Retreiving Image From Web");
					}
				}
			}
		}
		if (InvokeBack != null)
		{
			InvokeBack(result, null);
		}
	}
}
