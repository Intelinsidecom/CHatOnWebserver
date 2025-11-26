using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.Storage;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Services;

public class TrunkService
{
	private DataService _dataService;

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
		try
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
		catch (Exception)
		{
			return null;
		}
	}

	public static Trunk ParseTrunkFromXml(XElement xe)
	{
		try
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
		catch (Exception)
		{
			return null;
		}
	}

	public static List<UnreadTrunkInfo> GetUnreadTrunkFromXml(XElement xe)
	{
		try
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
		catch (Exception)
		{
			return null;
		}
	}

	public List<TrunkItem> ParseTrunkItemListFromXml(XElement xe, Trunk _Trunk, List<TrunkItem> temp)
	{
		//IL_053e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0548: Expected O, but got Unknown
		try
		{
			List<TrunkItem> list = new List<TrunkItem>();
			foreach (TrunkItem item in temp)
			{
				list.Add(item);
			}
			foreach (XNode item2 in xe.Nodes())
			{
				TrunkItem trunkItem = new TrunkItem();
				XElement xElement = item2 as XElement;
				trunkItem.IsDownloading = true;
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
						trunkItem.Unreadcmtcnt = int.Parse(xElement.Attribute("unreadcmtcnt").Value);
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
						trunkItem.Video_Visible = (Visibility)1;
						trunkItem.iType = TrunkItem.ItemType.Image;
					}
					else if (item4.Attribute("contenttype").Value == "image/png")
					{
						trunkItem.Video_Visible = (Visibility)1;
						trunkItem.iType = TrunkItem.ItemType.Image;
					}
					else if (item4.Attribute("contenttype").Value == "image/gif")
					{
						trunkItem.Video_Visible = (Visibility)1;
						trunkItem.iType = TrunkItem.ItemType.Image;
					}
					else if (item4.Attribute("contenttype").Value == "image/bmp")
					{
						trunkItem.Video_Visible = (Visibility)1;
						trunkItem.iType = TrunkItem.ItemType.Image;
					}
					else if (item4.Attribute("contenttype").Value == "image/bmp")
					{
						trunkItem.Video_Visible = (Visibility)1;
						trunkItem.iType = TrunkItem.ItemType.Image;
					}
					else if (item4.Attribute("contenttype").Value == "image/tiff")
					{
						trunkItem.Video_Visible = (Visibility)1;
						trunkItem.iType = TrunkItem.ItemType.Image;
					}
					else if (item4.Attribute("contenttype").Value.Contains("video"))
					{
						trunkItem.Video_Visible = (Visibility)0;
						trunkItem.iType = TrunkItem.ItemType.Video;
					}
					if (item4.Element("thumburl") != null)
					{
						trunkItem.TrunkThumbUri = item4.Element("thumburl").Value;
					}
					if (item4.Element("downurl") != null)
					{
						trunkItem.TrunkDownUri = item4.Element("downurl").Value;
					}
					trunkItem.CachedFileName = Utility.GetFileNameFromUri(trunkItem.TrunkDownUri);
				}
				trunkItem.Unread_Visible = (Visibility)1;
				if (trunkItem.Unreadcmtcnt > 0)
				{
					trunkItem.Unread_Visible = (Visibility)0;
				}
				if (list.Count == 0 || !trunkItem.TrunkItemID.Equals(list[list.Count - 1].TrunkItemID))
				{
					list.Add(trunkItem);
				}
			}
			_Trunk.LoadItemCount = list.Count;
			if (IsoSettingHelper.Get("TrunkSort", 0) == 1 && _Trunk.LoadItemCount < _Trunk.TotaItemCnt)
			{
				TrunkItem trunkItem2 = new TrunkItem();
				trunkItem2.TrunkThumbImg = new BitmapImage(new Uri("/Images/icon_load_more.png.png", UriKind.Relative));
				trunkItem2.iType = TrunkItem.ItemType.LoadBtn;
				trunkItem2.Unreadcmtcnt = 0;
				trunkItem2.Video_Visible = (Visibility)1;
				list.Add(trunkItem2);
			}
			return list;
		}
		catch (Exception)
		{
			return null;
		}
	}

	public TrunkItem ParseTrunkItemFromXml(XElement xe, Guid chatID)
	{
		try
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
						trunkItem.Unreadcmtcnt = int.Parse(xElement.Attribute("unreadcmtcnt").Value);
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
						trunkItem.TrunkDownUri = item3.Element("downurl").Value;
					}
					trunkItem.Video_Visible = (Visibility)1;
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
						trunkItem.TrunkDownUri = item3.Element("downurl").Value;
					}
					trunkItem.Video_Visible = (Visibility)0;
					trunkItem.iType = TrunkItem.ItemType.Video;
				}
				trunkItem.CachedFileName = Utility.GetFileNameFromUri(trunkItem.TrunkDownUri);
			}
			return trunkItem;
		}
		catch (Exception)
		{
			return null;
		}
	}

	public async Task<List<TrunkComment>> ParseTrunkCommentListFromXml(XElement xe, string ItemID, List<TrunkComment> temp)
	{
		try
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
						trunkComment.Regdttm = Utility.GetDateTimeFromMiliseconds(long.Parse(xElement.Attribute("regdttm").Value));
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
						flag = (trunkComment.WriterId.Contains("ME") ? true : false);
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
							trunkComment.Name = Utility.GetResourceString("IDS_CHATON_BODY_ME");
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
				}
			}
			list.Reverse();
			return list;
		}
		catch (Exception)
		{
			return null;
		}
	}

	public async Task<List<TrunkComment>> CacheCommentLoad(string ID)
	{
		try
		{
			new List<TrunkComment>();
			return _dataService.SelectTrunkCommentList(ID);
		}
		catch (Exception)
		{
			return null;
		}
	}

	public async void LoadProfileImages(ObservableCollection<TrunkComment> TrunkComments)
	{
		foreach (TrunkComment comment in TrunkComments)
		{
			if (comment.WriterId.Contains("ME"))
			{
				UserProfile userProfile = RegistrationService.GetUserProfile();
				if (!string.IsNullOrEmpty(userProfile.ProfileImagePath) && SettingService.GetProfileImageFileName() != "chat_info_single.png")
				{
					StorageFolder folder = ApplicationData.Current.LocalFolder;
					if ((await (await folder.GetFileAsync(SettingService.GetProfileImageFileName())).GetBasicPropertiesAsync()).Size != 0)
					{
						comment.ThumbImage = new BitmapImage(new Uri(userProfile.ProfileImagePath));
					}
				}
				continue;
			}
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == comment.WriterId);
			if (buddy != null)
			{
				comment.ThumbImage = buddy.ProfileImage;
				continue;
			}
			UnknownUser user = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == comment.WriterId);
			if (user == null)
			{
				user = new UnknownUser();
				user.PhoneNumber = comment.WriterId;
				dataService.AddUnknownUser(user);
			}
			user.LoadProfileImageCompleted += delegate(object s, object e)
			{
				if ((user = s as UnknownUser) != null)
				{
					comment.ThumbImage = user.ProfileImage;
				}
			};
			user.LoadProfileImage();
			comment.ThumbImage = user.ProfileImage;
		}
	}
}
