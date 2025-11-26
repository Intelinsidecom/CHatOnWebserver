using System;
using System.Collections.Generic;
using System.IO.IsolatedStorage;
using System.Linq;
using System.Windows;
using System.Windows.Media.Imaging;
using System.Xml.Linq;
using ChatOn.Models;
using ChatOn.Res;

namespace ChatOn.Services;

public class TrunkService
{
	private DataService _dataService;

	private static string _mediafilePath;

	private static string _sesssionID;

	private string _data;

	private int _commentCount;

	public int CommentCount
	{
		get
		{
			return _commentCount;
		}
		set
		{
			_commentCount = value;
		}
	}

	public TrunkService(DataService dataService)
	{
		_dataService = dataService;
	}

	public static List<Trunk> ParseTrunkListFromXml(XElement xe)
	{
		List<Trunk> list = new List<Trunk>();
		foreach (XNode item in xe.Nodes())
		{
			Trunk trunk = new Trunk();
			XElement xElement = item as XElement;
			if (xElement.Name == "trunk")
			{
				if (xElement.Attribute("sessionid") != null)
				{
					trunk.TrunkID = xElement.Attribute("sessionid").Value;
				}
				if (xElement.Attribute("lastupdttm") != null)
				{
					trunk.LastUpdattm = xElement.Attribute("lastupdttm").Value;
				}
				if (xElement.Attribute("lastcmtdttm") != null)
				{
					trunk.LastCmtdttm = xElement.Attribute("lastcmtdttm").Value;
				}
				if (xElement.Attribute("totitemcnt") != null)
				{
					trunk.TotaItemCnt = Convert.ToInt16(xElement.Attribute("totitemcnt").Value);
				}
				if (xElement.Attribute("unreaditemcnt") != null)
				{
					trunk.UnreadItemCnt = Convert.ToInt16(xElement.Attribute("unreaditemcnt").Value);
				}
			}
			list.Add(trunk);
		}
		return list;
	}

	public static Trunk ParseTrunkFromXml(XElement xe)
	{
		Trunk trunk = new Trunk();
		foreach (XNode item in xe.Nodes())
		{
			XElement xElement = item as XElement;
			if (xElement.Name == "trunk")
			{
				if (xElement.Attribute("sessionid") != null)
				{
					_ = xElement.Attribute("sessionid").Value;
				}
				if (xElement.Attribute("lastupdttm") != null)
				{
					_ = xElement.Attribute("lastupdttm").Value;
				}
				if (xElement.Attribute("lastcmtdttm") != null)
				{
					_ = xElement.Attribute("lastcmtdttm").Value;
				}
				if (xElement.Attribute("totitemcnt") != null)
				{
					trunk.TotaItemCnt = Convert.ToInt16(xElement.Attribute("totitemcnt").Value);
				}
				if (xElement.Attribute("unreaditemcnt") != null)
				{
					_ = xElement.Attribute("unreaditemcnt").Value;
				}
			}
		}
		return trunk;
	}

	public static List<UnreadTrunkInfo> GetUnreadTrunkFromXml(XElement xe)
	{
		List<UnreadTrunkInfo> list = new List<UnreadTrunkInfo>();
		foreach (XNode item in xe.Nodes())
		{
			XElement xElement = item as XElement;
			if (xElement.Name == "trunk")
			{
				string sessionID = string.Empty;
				int unreadCount = 0;
				if (xElement.Attribute("sessionid") != null)
				{
					sessionID = xElement.Attribute("sessionid").Value;
				}
				if (xElement.Attribute("unreaditemcnt") != null)
				{
					unreadCount = int.Parse(xElement.Attribute("unreaditemcnt").Value);
				}
				list.Add(new UnreadTrunkInfo
				{
					SessionID = sessionID,
					UnreadCount = unreadCount
				});
			}
		}
		return list;
	}

	public List<TrunkItem> ParseTrunkItemListFromXml(XElement xe, string sessionID, Trunk _Trunk, List<TrunkItem> temp)
	{
		List<TrunkItem> list = new List<TrunkItem>();
		foreach (TrunkItem item in temp)
		{
			list.Add(item);
		}
		_sesssionID = sessionID;
		foreach (XNode item2 in xe.Nodes())
		{
			TrunkItem trunkItem = new TrunkItem();
			XElement xElement = item2 as XElement;
			if (xElement.Name == "item")
			{
				if (xElement.Attribute("itemid") != null)
				{
					trunkItem.TrunkItemID = xElement.Attribute("itemid").Value;
				}
				if (xElement.Attribute("regdttm") != null)
				{
					trunkItem.Regdttm = xElement.Attribute("regdttm").Value;
				}
				if (xElement.Attribute("lastcmtdttm") != null)
				{
					trunkItem.Lastcmtdttm = xElement.Attribute("lastcmtdttm").Value;
				}
				if (xElement.Attribute("totcmtcnt") != null)
				{
					trunkItem.Totcmtcnt = xElement.Attribute("totcmtcnt").Value;
				}
				if (xElement.Attribute("unreadcmtcnt") != null)
				{
					trunkItem.Unreadcmtcnt = xElement.Attribute("unreadcmtcnt").Value;
				}
			}
			IEnumerable<XElement> enumerable = from item in xElement.Descendants("sender")
				select (item);
			foreach (XElement item3 in enumerable)
			{
				if (item3.Attribute("id") != null)
				{
					trunkItem.Senderid = item3.Attribute("id").Value;
				}
				if (item3.Element("orgnum") != null)
				{
					trunkItem.Orgnumber = item3.Element("orgnum").Value;
				}
				if (item3.Element("name") != null)
				{
					trunkItem.Name = item3.Element("name").Value;
				}
			}
			enumerable = from item in xElement.Descendants("file")
				select (item);
			foreach (XElement item4 in enumerable)
			{
				if (item4.Attribute("contenttype").Value == "image/jpeg")
				{
					if (item4.Element("thumburl") != null)
					{
						trunkItem.TrunkThumbUri = item4.Element("thumburl").Value;
					}
					if (item4.Element("downurl") != null)
					{
						trunkItem.TrunkDonwUri = item4.Element("downurl").Value;
					}
					_mediafilePath = _sesssionID + "\\thumb_";
					_mediafilePath += Utility.GetFileNameFromUri(trunkItem.TrunkThumbUri);
					IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
					if (!userStoreForApplication.DirectoryExists(_sesssionID))
					{
						userStoreForApplication.CreateDirectory(_sesssionID);
					}
					if (userStoreForApplication.FileExists(_mediafilePath))
					{
						trunkItem.TrunkThumbImg = Utility.LoadJpeg(_mediafilePath);
					}
					else
					{
						BitmapImage bitmapImage = new BitmapImage(new Uri(trunkItem.TrunkThumbUri));
						bitmapImage.ImageOpened += _thumbImage_ImageOpened;
						trunkItem.TrunkThumbImg = bitmapImage;
					}
					trunkItem.Video_Visible = Visibility.Collapsed;
					trunkItem.iType = TrunkItem.ItemType.Image;
				}
				if (item4.Attribute("contenttype").Value == "video/mp4")
				{
					if (item4.Element("thumburl") != null)
					{
						trunkItem.TrunkThumbUri = "/ChatOn;component/Images/trunk_video.png";
					}
					if (item4.Element("downurl") != null)
					{
						trunkItem.TrunkDonwUri = item4.Element("downurl").Value;
					}
					trunkItem.Video_Visible = Visibility.Visible;
					trunkItem.iType = TrunkItem.ItemType.Video;
				}
			}
			trunkItem.Unread_Visible = Visibility.Collapsed;
			if (Convert.ToInt16(trunkItem.Unreadcmtcnt) > 0)
			{
				trunkItem.Unread_Visible = Visibility.Visible;
			}
			if (list.Count == 0 || !trunkItem.TrunkItemID.Equals(list[list.Count - 1].TrunkItemID))
			{
				trunkItem.SessionID = _sesssionID;
				list.Add(trunkItem);
				_dataService.AddTrunkItem(trunkItem);
			}
		}
		_Trunk.LoadItemCount = list.Count;
		if (IsolatedStorageSettings.ApplicationSettings.Contains("TrunkSort") && (int)IsolatedStorageSettings.ApplicationSettings["TrunkSort"] == 1 && _Trunk.LoadItemCount < _Trunk.TotaItemCnt)
		{
			TrunkItem trunkItem2 = new TrunkItem();
			trunkItem2.TrunkThumbImg = new BitmapImage(new Uri("/Images/icon_load_more.png.png", UriKind.Relative));
			trunkItem2.iType = TrunkItem.ItemType.LoadBtn;
			trunkItem2.Unreadcmtcnt = "0";
			trunkItem2.Video_Visible = Visibility.Collapsed;
			trunkItem2.Bubble_Visible = Visibility.Collapsed;
			list.Add(trunkItem2);
		}
		return list;
	}

	public List<TrunkItem> CacheListLoad(string ID)
	{
		List<TrunkItem> list = new List<TrunkItem>();
		list = _dataService.SelectTrunkItemList(ID);
		foreach (TrunkItem item in list)
		{
			_mediafilePath = ID + "\\thumb_";
			_mediafilePath += Utility.GetFileNameFromUri(item.TrunkThumbUri);
			IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
			if (!userStoreForApplication.DirectoryExists(ID))
			{
				userStoreForApplication.CreateDirectory(ID);
			}
			if (userStoreForApplication.FileExists(_mediafilePath))
			{
				item.TrunkThumbImg = Utility.LoadJpeg(_mediafilePath);
			}
		}
		return list;
	}

	public TrunkItem ParseTrunkItemFromXml(XElement xe)
	{
		TrunkItem trunkItem = new TrunkItem();
		foreach (XNode item in xe.Nodes())
		{
			XElement xElement = item as XElement;
			if (xElement.Name == "item")
			{
				if (xElement.Attribute("itemid") != null)
				{
					trunkItem.TrunkItemID = xElement.Attribute("itemid").Value;
				}
				if (xElement.Attribute("regdttm") != null)
				{
					trunkItem.Regdttm = xElement.Attribute("regdttm").Value;
				}
				if (xElement.Attribute("lastcmtdttm") != null)
				{
					trunkItem.Lastcmtdttm = xElement.Attribute("lastcmtdttm").Value;
				}
				if (xElement.Attribute("totcmtcnt") != null)
				{
					trunkItem.Totcmtcnt = xElement.Attribute("totcmtcnt").Value;
				}
				if (xElement.Attribute("unreadcmtcnt") != null)
				{
					trunkItem.Unreadcmtcnt = xElement.Attribute("unreadcmtcnt").Value;
				}
			}
		}
		IEnumerable<XElement> enumerable = from item in xe.Descendants("sender")
			select (item);
		foreach (XElement item2 in enumerable)
		{
			if (item2.Attribute("id") != null)
			{
				trunkItem.Senderid = item2.Attribute("id").Value;
			}
			if (item2.Element("orgnum") != null)
			{
				trunkItem.Orgnumber = item2.Element("orgnum").Value;
			}
			if (item2.Element("name") != null)
			{
				trunkItem.Name = item2.Element("name").Value;
			}
		}
		enumerable = from item in xe.Descendants("file")
			select (item);
		foreach (XElement item3 in enumerable)
		{
			if (item3.Attribute("contenttype").Value == "image/jpeg")
			{
				if (item3.Element("thumburl") != null)
				{
					trunkItem.TrunkThumbUri = item3.Element("thumburl").Value;
				}
				if (item3.Element("downurl") != null)
				{
					trunkItem.TrunkDonwUri = item3.Element("downurl").Value;
				}
				_mediafilePath = _sesssionID + "\\thumb_";
				_mediafilePath += Utility.GetFileNameFromUri(trunkItem.TrunkThumbUri);
				IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
				if (!userStoreForApplication.DirectoryExists(_sesssionID))
				{
					userStoreForApplication.CreateDirectory(_sesssionID);
				}
				if (userStoreForApplication.FileExists(_mediafilePath))
				{
					trunkItem.TrunkThumbImg = Utility.LoadJpeg(_mediafilePath);
				}
				else
				{
					BitmapImage bitmapImage = new BitmapImage(new Uri(trunkItem.TrunkThumbUri));
					bitmapImage.ImageOpened += _thumbImage_ImageOpened;
					trunkItem.TrunkThumbImg = bitmapImage;
				}
				trunkItem.Video_Visible = Visibility.Collapsed;
				trunkItem.iType = TrunkItem.ItemType.Image;
			}
			else if (item3.Attribute("contenttype").Value == "video/mp4")
			{
				if (item3.Element("thumburl") != null)
				{
					trunkItem.TrunkThumbUri = item3.Element("thumburl").Value;
				}
				if (item3.Element("downurl") != null)
				{
					trunkItem.TrunkDonwUri = item3.Element("downurl").Value;
				}
				trunkItem.Video_Visible = Visibility.Visible;
				trunkItem.iType = TrunkItem.ItemType.Video;
			}
		}
		return trunkItem;
	}

	public List<TrunkComment> ParseTrunkCOmmentListFromXml(XElement xe, string ItemID, List<TrunkComment> temp)
	{
		List<TrunkComment> list = new List<TrunkComment>();
		foreach (TrunkComment item in temp)
		{
			list.Add(item);
		}
		list.Reverse();
		bool flag = false;
		foreach (XNode item2 in xe.Nodes())
		{
			TrunkComment trunkComment = new TrunkComment();
			XElement xElement = item2 as XElement;
			if (xElement.Name == "comment")
			{
				if (xElement.Attribute("cid") != null)
				{
					trunkComment.Cid = xElement.Attribute("cid").Value;
				}
				if (xElement.Attribute("regdttm") != null)
				{
					DateTime dateTimeFromMiliseconds = Utility.GetDateTimeFromMiliseconds(long.Parse(xElement.Attribute("regdttm").Value));
					DateTime now = DateTime.Now;
					TimeSpan timeSpan = now - dateTimeFromMiliseconds;
					if (timeSpan.Days > 365)
					{
						trunkComment.Regdttm = dateTimeFromMiliseconds.ToShortDateString();
					}
					else if (dateTimeFromMiliseconds.Day != now.Day)
					{
						trunkComment.Regdttm = dateTimeFromMiliseconds.ToShortDateString();
					}
					else if (timeSpan.Days > 1)
					{
						trunkComment.Regdttm = dateTimeFromMiliseconds.ToString("m");
					}
					else if (timeSpan.Hours != 0)
					{
						trunkComment.Regdttm = dateTimeFromMiliseconds.ToShortTimeString();
					}
					else
					{
						trunkComment.Regdttm = dateTimeFromMiliseconds.ToShortTimeString();
					}
				}
			}
			IEnumerable<XElement> enumerable = from item in xElement.Descendants("content")
				select (item);
			foreach (XElement item3 in enumerable)
			{
				if (item3.Value != null)
				{
					trunkComment.Content = item3.Value;
				}
			}
			enumerable = from item in xElement.Descendants("writer")
				select (item);
			foreach (XElement item4 in enumerable)
			{
				if (item4.Attribute("id") != null)
				{
					trunkComment.WriterId = item4.Attribute("id").Value;
					if (trunkComment.WriterId.Contains("ME"))
					{
						flag = true;
						trunkComment.ThumbImage = Utility.LoadJpeg(RegistrationService.DefaultProfilePath);
					}
					else
					{
						flag = false;
						trunkComment.ThumbImage = Utility.LoadJpeg("Cache\\thumb_" + trunkComment.WriterId + ".jpg");
					}
				}
				if (item4.Element("orgname") != null)
				{
					trunkComment.Orgname = item4.Element("orgname").Value;
				}
				if (item4.Element("orgnum") != null)
				{
					trunkComment.Orgnum = item4.Element("orgnum").Value;
				}
				if (item4.Element("name") != null)
				{
					if (flag)
					{
						trunkComment.Name = ResContainer.IDS_CHATON_BODY_ME;
					}
					else
					{
						trunkComment.Name = item4.Element("name").Value;
					}
				}
			}
			if (list.Count == 0 || trunkComment.Cid != list[list.Count - 1].Cid)
			{
				list.Add(trunkComment);
				trunkComment.ItemId = ItemID;
				_dataService.AddTrunkComment(trunkComment);
			}
		}
		list.Reverse();
		return list;
	}

	public List<TrunkComment> CacheCommentLoad(string ID)
	{
		List<TrunkComment> list = new List<TrunkComment>();
		list = _dataService.SelectTrunkCommentList(ID);
		foreach (TrunkComment item in list)
		{
			if (item.WriterId.Contains("ME"))
			{
				item.ThumbImage = Utility.LoadJpeg(RegistrationService.DefaultProfilePath);
			}
			else
			{
				item.ThumbImage = Utility.LoadJpeg("Cache\\thumb_" + item.WriterId + ".jpg");
			}
		}
		return list;
	}

	public void SetTrunkItemImgUri()
	{
	}

	private void _thumbImage_ImageOpened(object sender, RoutedEventArgs e)
	{
		BitmapImage bitmapImage = sender as BitmapImage;
		bitmapImage.ImageOpened -= _thumbImage_ImageOpened;
		_mediafilePath = _sesssionID + "\\thumb_";
		_mediafilePath += Utility.GetFileNameFromUri(bitmapImage.UriSource.ToString());
		Utility.SaveToJpeg(_mediafilePath, bitmapImage, bitmapImage.PixelWidth, bitmapImage.PixelHeight);
	}

	private void _item_ImageOpened(object sender, RoutedEventArgs e)
	{
		BitmapImage bitmapImage = sender as BitmapImage;
		bitmapImage.ImageOpened -= _item_ImageOpened;
		_mediafilePath = _sesssionID + "\\thumb_";
		_mediafilePath += Utility.GetFileNameFromUri(bitmapImage.UriSource.ToString());
		Utility.SaveToJpeg(_mediafilePath, bitmapImage, bitmapImage.PixelWidth, bitmapImage.PixelHeight);
	}
}
