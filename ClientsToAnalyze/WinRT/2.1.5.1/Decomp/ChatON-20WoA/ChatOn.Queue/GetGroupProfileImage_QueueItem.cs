using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Queue;

public class GetGroupProfileImage_QueueItem : QueueItem
{
	private bool isThumbnail;

	private bool forceUpdate;

	private SSMService SSMService;

	private readonly Chat _chat;

	private static string buddyProfileImageDirectory = "Group";

	private string buddyProfileImageThumbnailPath => string.Concat("thumb_", _chat.ChatID, ".jpg");

	private string buddyProfileImagePath => string.Concat(_chat.ChatID, ".jpg");

	private string buddyProfileImageUri => "";

	public GetGroupProfileImage_QueueItem(SSMService ssmservice, Chat chat, bool isthumbnail = true, bool forceupdate = true)
		: base(QueuePriority.Low)
	{
		SSMService = ssmservice;
		_chat = chat;
		isThumbnail = isthumbnail;
		forceUpdate = forceupdate;
	}

	public override async Task Perform()
	{
		BitmapImage result = null;
		if (SSMService != null && _chat != null && !_chat.IsDownloadingProfile)
		{
			_chat.IsDownloadingProfile = true;
			string url = ParseChatProfileXml(await SSMService.CreateGetChatRoomProfileImageUrlAsync(_chat.SessionID));
			long start3 = DateTime.UtcNow.Ticks;
			result = ((!isThumbnail) ? (await Utility.LoadOrSaveWebImage(buddyProfileImagePath, new Uri(url), buddyProfileImageDirectory, forceUpdate: true)) : (await Utility.LoadOrSaveWebImage(buddyProfileImageThumbnailPath, new Uri(url), buddyProfileImageDirectory, forceUpdate: true)));
			long end3 = DateTime.UtcNow.Ticks;
			TimeSpan.FromTicks(end3 - start3);
			_chat.IsDownloadingProfile = false;
		}
		if (InvokeBack != null)
		{
			InvokeBack(result, null);
		}
	}

	private string ParseChatProfileXml(string response)
	{
		XElement xElement = null;
		try
		{
			if (!string.IsNullOrEmpty(response))
			{
				xElement = XElement.Load(new StringReader(response));
				if (xElement == null)
				{
					return "";
				}
				IEnumerable<XElement> source = from item in xElement.Descendants("profileimagelist")
					select (item);
				XElement xElement2 = source.FirstOrDefault();
				string value = xElement2.Attribute("profile_filename").Value;
				string value2 = xElement2.Attribute("profile_url").Value;
				UserAccountInfo userAccount = RegistrationService.GetUserAccount();
				return value2 + value + "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI;
			}
		}
		catch (Exception)
		{
		}
		return "";
	}
}
