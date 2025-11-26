using System;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Services;

public class Sample_DownloadImageQueueItem : QueueItem
{
	private Uri uri;

	public Sample_DownloadImageQueueItem(string uri)
	{
		this.uri = new Uri(uri);
	}

	public override async Task Perform()
	{
		BitmapImage a = await Utility.LoadOrSaveWebImage(DateTime.Now.Ticks + ".jpg", uri, "Cache");
		if (a != null && InvokeBack != null)
		{
			InvokeBack(a, null);
		}
	}

	public override string ToString()
	{
		return "[SampleQueueItemThatDownloadsImage] " + uri.PathAndQuery;
	}
}
