using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Net;
using System.Threading;
using System.Windows;
using System.Xml.Linq;
using Microsoft.Phone;
using Microsoft.Phone.Scheduler;
using Microsoft.Phone.Shell;

namespace ChatOnBackgroundAgent;

public class ScheduledAgent : ScheduledTaskAgent
{
	private static volatile bool _classInitialized;

	public ScheduledAgent()
	{
		if (!_classInitialized)
		{
			_classInitialized = true;
			Deployment.Current.Dispatcher.BeginInvoke(delegate
			{
				Application.Current.UnhandledException += ScheduledAgent_UnhandledException;
			});
		}
	}

	private void ScheduledAgent_UnhandledException(object sender, ApplicationUnhandledExceptionEventArgs e)
	{
		if (Debugger.IsAttached)
		{
			Debugger.Break();
		}
	}

	protected override void OnInvoke(ScheduledTask task)
	{
		GetUnReadMessageList();
		((BackgroundAgent)this).NotifyComplete();
	}

	private void GetUnReadMessageList()
	{
		string text = IsoSettingHelper.Get<string>("ContactServer", null);
		string text2 = IsoSettingHelper.Get<string>("UserUID", null);
		string text3 = IsoSettingHelper.Get<string>("UserIMEI", null);
		if (string.IsNullOrEmpty(text) || string.IsNullOrEmpty(text2) || string.IsNullOrEmpty(text3))
		{
			return;
		}
		Uri requestUri = new Uri("https://" + text + "/inboxes?uid=" + text2 + "&imei=" + text3 + "&" + GetTimeStamp());
		HttpWebRequest httpWebRequest = (HttpWebRequest)WebRequest.Create(requestUri);
		httpWebRequest.Method = "GET";
		ManualResetEvent allDone = new ManualResetEvent(initialState: false);
		httpWebRequest.BeginGetResponse(delegate(IAsyncResult r)
		{
			try
			{
				HttpWebRequest httpWebRequest2 = (HttpWebRequest)r.AsyncState;
				HttpWebResponse httpWebResponse = (HttpWebResponse)httpWebRequest2.EndGetResponse(r);
				using StreamReader streamReader = new StreamReader(httpWebResponse.GetResponseStream());
				string text4 = streamReader.ReadToEnd();
				if (!string.IsNullOrEmpty(text4))
				{
					XElement xElement = XElement.Load((TextReader)new StringReader(text4));
					IEnumerable<XElement> enumerable = from item in xElement.Descendants("msg")
						select (item);
					int num = 0;
					foreach (XElement item in enumerable)
					{
						string value = item.Attribute("type").Value;
						if (!(value == "ans") && !(value == "noti"))
						{
							num++;
						}
					}
					UpdateTile(num);
				}
			}
			catch (Exception)
			{
			}
			allDone.Set();
		}, httpWebRequest);
		allDone.WaitOne();
	}

	private long GetTimeStamp()
	{
		DateTime dateTime = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
		return (long)(DateTime.UtcNow - dateTime).TotalMilliseconds;
	}

	private void UpdateTile(int count)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		foreach (ShellTile activeTile in ShellTile.ActiveTiles)
		{
			if (activeTile.NavigationUri.ToString() == "/")
			{
				StandardTileData val = new StandardTileData();
				val.Count = count;
				activeTile.Update((ShellTileData)(object)val);
			}
		}
	}

	private void UpdateToast(string title, string content)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		ShellToast val = new ShellToast();
		val.Title = title;
		val.Content = content;
		val.Show();
	}
}
