using System;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Queue;

public class GetBuddyProfileImage_QueueItem : QueueItem
{
	private string buddyID;

	private bool isThumbnail;

	private bool forceUpdate;

	private SSMService SSMService;

	private static string buddyProfileImageDirectory = "Cache";

	private string buddyProfileImageThumbnailPath => "thumb_" + buddyID + ".jpg";

	private string buddyProfileImagePath => buddyID + ".jpg";

	private string buddyProfileImageUri
	{
		get
		{
			long ticks = DateTime.UtcNow.Ticks;
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == buddyID);
			_ = string.Empty;
			string empty = string.Empty;
			if (buddy == null)
			{
				UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == buddyID);
				_ = unknownUser.Name;
				empty = unknownUser.PhoneNumber;
			}
			else
			{
				_ = buddy.Name;
				empty = buddy.PhoneNumber;
			}
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.Append("http://" + SSMService._svrAddress.FileServer);
			stringBuilder.Append("/buddy/" + empty);
			stringBuilder.Append("/image?uid=" + SSMService._account.Uid);
			stringBuilder.Append("&imei=" + SSMService._account.IMEI);
			if (isThumbnail)
			{
				stringBuilder.Append("&size=160");
			}
			if (forceUpdate)
			{
				stringBuilder.Append("&timestamp=" + Utility.GetTimeStamp());
			}
			long ticks2 = DateTime.UtcNow.Ticks;
			TimeSpan.FromTicks(ticks2 - ticks);
			return stringBuilder.ToString();
		}
	}

	public GetBuddyProfileImage_QueueItem(SSMService ssmservice, string buddyid, bool isthumbnail = true, bool forceupdate = true)
		: base(QueuePriority.Low)
	{
		SSMService = ssmservice;
		buddyID = buddyid;
		isThumbnail = isthumbnail;
		forceUpdate = forceupdate;
	}

	public override async Task Perform()
	{
		BitmapImage result = null;
		if (SSMService != null && !string.IsNullOrEmpty(buddyID))
		{
			long start3 = DateTime.UtcNow.Ticks;
			result = ((!isThumbnail) ? (await Utility.LoadOrSaveWebImage(buddyProfileImagePath, new Uri(buddyProfileImageUri), buddyProfileImageDirectory, forceUpdate: true)) : (await Utility.LoadOrSaveWebImage(buddyProfileImageThumbnailPath, new Uri(buddyProfileImageUri), buddyProfileImageDirectory, forceUpdate: true)));
			long end3 = DateTime.UtcNow.Ticks;
			TimeSpan.FromTicks(end3 - start3);
		}
		if (InvokeBack != null)
		{
			InvokeBack(result, null);
		}
	}
}
