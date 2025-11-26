using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Media.Imaging;
using System.Xml.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using Microsoft.Phone.Shell;
using Microsoft.Phone.Tasks;
using Microsoft.Phone.UserData;

namespace ChatOn.Services;

public class BuddyService
{
	public delegate void GetContactListCompletedEventHandler(object sender, BuddyManagerEventArgs e);

	private static readonly int CheckingNumberLength = 6;

	private DataService _dataService;

	private SSMService _ssmService;

	private List<Buddy> _exceptFilteringNumbers;

	public event GetContactListCompletedEventHandler GetContactListCompleted;

	public BuddyService(DataService dataService, SSMService ssmService)
	{
		_dataService = dataService;
		_ssmService = ssmService;
	}

	public Buddy GetBuddy(string phoneNumber)
	{
		return _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == phoneNumber);
	}

	public List<Buddy> GetBuddyList(List<string> numberList)
	{
		List<Buddy> list = new List<Buddy>();
		string number;
		foreach (string number2 in numberList)
		{
			number = number2;
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
			if (buddy != null)
			{
				list.Add(buddy);
			}
		}
		return list;
	}

	public void SetExceptionFilterlingBuddies(List<string> numberList)
	{
		_exceptFilteringNumbers = GetBuddyList(numberList);
	}

	public void RemoveBuddyFromGroup(string phoneNumber)
	{
		foreach (BuddyGroup buddyGroup in _dataService.BuddyGroups)
		{
			if (buddyGroup.Members.Contains(phoneNumber))
			{
				buddyGroup.Members = buddyGroup.Members.Replace(phoneNumber + ',', "");
				buddyGroup.Members = buddyGroup.Members.Replace(',' + phoneNumber, "");
			}
		}
	}

	internal void BlockBuddy(Buddy buddy)
	{
		RemoveBuddyFromGroup(buddy.PhoneNumber);
		buddy.IsBlocked = true;
		_dataService.SubmitChanges();
	}

	public Buddy AddBuddy(string phoneNumber, string name, string status, string birthday, Buddy.ProfileImgStatus imgstatus, string email, string samsungEmail, bool showPhoneNumber, bool isBlind, string orgNum)
	{
		MyContact myContact = FindContact(phoneNumber, orgNum);
		Buddy buddy = ((myContact == null) ? new Buddy(name, phoneNumber, status) : new Buddy(myContact.DisplayName, phoneNumber, status));
		buddy.Birthday = birthday;
		buddy.ImgStatus = imgstatus;
		buddy.Email = email;
		buddy.SamsungEmail = samsungEmail;
		buddy.OrgNumber = orgNum;
		buddy.IsShowPhoneNumber = showPhoneNumber;
		buddy.IsBlind = isBlind;
		_dataService.AddBuddy(buddy, isSubmit: false);
		UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == phoneNumber);
		if (unknownUser != null)
		{
			_dataService.DeleteUnknownUser(unknownUser);
		}
		return buddy;
	}

	private MyContact FindContact(string phoneNumber, string orgNum)
	{
		MyContact result = null;
		if (phoneNumber.Length >= CheckingNumberLength)
		{
			foreach (MyContact contactItem in _dataService.ContactItems)
			{
				if (contactItem.PhoneNumber.Length >= CheckingNumberLength)
				{
					string text = contactItem.PhoneNumber.Substring(contactItem.PhoneNumber.Length - CheckingNumberLength);
					string text2 = phoneNumber.Substring(phoneNumber.Length - CheckingNumberLength);
					if (!(text != text2) && (phoneNumber.Contains(contactItem.PhoneNumber) || contactItem.PhoneNumber.Contains(phoneNumber) || orgNum.Contains(contactItem.PhoneNumber) || contactItem.PhoneNumber.Contains(orgNum)))
					{
						result = contactItem;
						break;
					}
				}
			}
		}
		return result;
	}

	public List<Buddy> AddBuddyFromXml(XElement xe, bool updateOnly = false)
	{
		List<Buddy> list = new List<Buddy>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddy")
			select (item);
		foreach (XElement item in enumerable)
		{
			string number = "";
			string text = "";
			string text2 = "";
			string status = "";
			string text3 = "";
			string email = "";
			string samsungEmail = "";
			bool flag = false;
			bool flag2 = false;
			bool isBlind = false;
			Buddy.ProfileImgStatus profileImgStatus = Buddy.ProfileImgStatus.None;
			number = item.Value;
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
			if (item.Attribute("orgname") != null && !string.IsNullOrEmpty(item.Attribute("orgname").Value))
			{
				text2 = item.Attribute("orgname").Value;
			}
			else if (item.Attribute("name") != null)
			{
				text2 = item.Attribute("name").Value;
				if (buddy != null)
				{
					buddy.ProfileName = text2;
				}
			}
			if (item.Attribute("orgnum") != null)
			{
				text = item.Attribute("orgnum").Value;
				if (buddy != null)
				{
					buddy.OrgNumber = text;
				}
			}
			if (item.Attribute("status") != null)
			{
				status = item.Attribute("status").Value;
				if (buddy != null)
				{
					buddy.Status = status;
				}
			}
			if (item.Attribute("birthday") != null)
			{
				text3 = item.Attribute("birthday").Value;
				if (!string.IsNullOrEmpty(text3))
				{
					string[] array = text3.Split('-');
					if (array == null || array[0] == "0000")
					{
						text3 = "";
					}
				}
				if (buddy != null)
				{
					buddy.Birthday = text3;
				}
			}
			if (item.Attribute("email") != null)
			{
				email = item.Attribute("email").Value;
				if (buddy != null)
				{
					buddy.Email = email;
				}
			}
			if (item.Attribute("samsungemail") != null)
			{
				samsungEmail = item.Attribute("samsungemail").Value;
				if (buddy != null)
				{
					buddy.SamsungEmail = samsungEmail;
				}
			}
			if (item.Attribute("imgstatus") != null)
			{
				profileImgStatus = (Buddy.ProfileImgStatus)int.Parse(item.Attribute("imgstatus").Value);
				if (buddy != null)
				{
					buddy.ImgStatus = profileImgStatus;
				}
			}
			if (item.Attribute("showphonenumber") != null)
			{
				flag2 = bool.Parse(item.Attribute("showphonenumber").Value);
				if (buddy != null)
				{
					buddy.IsShowPhoneNumber = flag2;
				}
			}
			if (item.Attribute("isblind") != null)
			{
				isBlind = bool.Parse(item.Attribute("isblind").Value);
				if (buddy != null)
				{
					buddy.IsBlind = isBlind;
				}
			}
			if (item.Attribute("deleted") != null)
			{
				flag = bool.Parse(item.Attribute("deleted").Value);
			}
			if (!updateOnly)
			{
				if (flag)
				{
					if (buddy != null && !buddy.IsBlocked)
					{
						buddy.IsBlocked = true;
					}
					continue;
				}
				if (buddy == null)
				{
					Buddy buddy2 = AddBuddy(item.Value, text2, status, text3, profileImgStatus, email, samsungEmail, flag2, isBlind, text);
					buddy2.IsNew = true;
					buddy2.ProfileName = text2;
					list.Add(buddy2);
					continue;
				}
				MyContact myContact = FindContact(number, text);
				if (myContact != null)
				{
					buddy.Name = myContact.DisplayName;
				}
				else if (!string.IsNullOrEmpty(text2))
				{
					buddy.Name = text2;
				}
			}
			else if (buddy != null)
			{
				MyContact myContact2 = FindContact(number, text);
				if (myContact2 != null)
				{
					buddy.Name = myContact2.DisplayName;
				}
				else if (!string.IsNullOrEmpty(text2))
				{
					buddy.Name = text2;
				}
			}
		}
		_dataService.SubmitChanges();
		return list;
	}

	public void ApplyRankFromXml(XElement xe)
	{
		foreach (Buddy buddyItem in _dataService.BuddyItems)
		{
			buddyItem.Rank = 0;
			buddyItem.SentCount = 0;
			buddyItem.ReceivedCount = 0;
		}
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddyid")
			select (item);
		foreach (XElement item in enumerable)
		{
			string number = "";
			int sentCount = 0;
			int receivedCount = 0;
			int rank = 0;
			number = item.Value;
			if (item.Attribute("rank") != null)
			{
				rank = int.Parse(item.Attribute("rank").Value);
			}
			if (item.Attribute("send") != null)
			{
				sentCount = int.Parse(item.Attribute("send").Value);
			}
			if (item.Attribute("receive") != null)
			{
				receivedCount = int.Parse(item.Attribute("receive").Value);
			}
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
			if (buddy != null)
			{
				buddy.Rank = rank;
				buddy.ReceivedCount = receivedCount;
				buddy.SentCount = sentCount;
			}
		}
	}

	public List<string> ParseBlindListFromXml(XElement xe)
	{
		List<string> list = new List<string>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("blind")
			select (item);
		foreach (XElement item in enumerable)
		{
			list.Add(item.Value);
		}
		return list;
	}

	public void ApplyInteractionHideListFromXml(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddyid")
			select (item);
		foreach (XElement item in enumerable)
		{
			string number = item.Value;
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
			if (buddy != null)
			{
				buddy.IsHideInteraction = true;
			}
		}
	}

	public ObservableCollection<BlockBuddyInfo> ParseBlockListFromXml(XElement xe)
	{
		ObservableCollection<BlockBuddyInfo> observableCollection = new ObservableCollection<BlockBuddyInfo>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddy")
			select (item);
		foreach (XElement item in enumerable)
		{
			BlockBuddyInfo blockBuddyInfo = new BlockBuddyInfo();
			blockBuddyInfo.Number = item.Value;
			if (item.Attribute("name") != null)
			{
				blockBuddyInfo.Name = item.Attribute("name").Value;
			}
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			bool unknown;
			string buddyNameByNumber = buddyService.GetBuddyNameByNumber(blockBuddyInfo.Number, out unknown);
			if (!unknown)
			{
				blockBuddyInfo.Name = buddyNameByNumber;
			}
			blockBuddyInfo.ProfileImageUri = _ssmService.GetBuddyProfileImageUri(blockBuddyInfo.Number);
			observableCollection.Add(blockBuddyInfo);
		}
		return observableCollection;
	}

	public ObservableCollection<BuddiesSay> ParseMemoFromXml(XElement xe, out bool isBlind)
	{
		ObservableCollection<BuddiesSay> observableCollection = new ObservableCollection<BuddiesSay>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("memolist")
			select (item);
		isBlind = false;
		foreach (XElement item in enumerable)
		{
			if (item.Attribute("isblind") != null)
			{
				isBlind = bool.Parse(item.Attribute("isblind").Value);
				break;
			}
		}
		if (isBlind)
		{
			return observableCollection;
		}
		IEnumerable<XElement> enumerable2 = from item in xe.Descendants("memo")
			select (item);
		foreach (XElement item2 in enumerable2)
		{
			string text = "";
			string name = "";
			string text2 = "";
			long timeStamp = 0L;
			Buddy.ProfileImgStatus profileImgStatus = (Buddy.ProfileImgStatus)0;
			text = item2.Value;
			if (item2.Attribute("buddyid") != null)
			{
				text2 = item2.Attribute("buddyid").Value;
			}
			if (item2.Attribute("buddyname") != null)
			{
				name = item2.Attribute("buddyname").Value;
			}
			if (item2.Attribute("timestamp") != null)
			{
				timeStamp = long.Parse(item2.Attribute("timestamp").Value);
			}
			if (item2.Attribute("imgstatus") != null)
			{
				profileImgStatus = (Buddy.ProfileImgStatus)int.Parse(item2.Attribute("imgstatus").Value);
			}
			BitmapImage bitmapImage = null;
			if (profileImgStatus == Buddy.ProfileImgStatus.Deleted || profileImgStatus == Buddy.ProfileImgStatus.None)
			{
				bitmapImage = ((!Utility.IsDarkTheme()) ? new BitmapImage(new Uri("\\Images\\LightTheme\\buddies_default image.png", UriKind.Relative)) : new BitmapImage(new Uri("/ChatOn;component/Images/buddies_default.png", UriKind.Relative)));
			}
			else
			{
				UserProfile userProfile = RegistrationService.GetUserProfile();
				if (text2 == userProfile.PhoneNumber)
				{
					bitmapImage = ChatOnService.Instance.ProfileImage;
				}
				else
				{
					Buddy buddy = GetBuddy(text2);
					bitmapImage = ((buddy == null) ? new BitmapImage(_ssmService.GetBuddyProfileImageUri(text2)) : buddy.ProfileImage);
				}
			}
			observableCollection.Add(new BuddiesSay(name, text2, text, bitmapImage, timeStamp));
		}
		return observableCollection;
	}

	internal void UpdateTile()
	{
		foreach (ShellTile activeTile in ShellTile.ActiveTiles)
		{
			foreach (Buddy buddyItem in _dataService.BuddyItems)
			{
				if (activeTile.NavigationUri.ToString().Contains(buddyItem.PhoneNumber))
				{
					activeTile.Update((ShellTileData)(object)MakeTileForBuddy(buddyItem));
				}
			}
		}
	}

	public static void PinToStart(Buddy buddy)
	{
		string text = "/Views/MainPage.xaml?Pinned=";
		text += buddy.PhoneNumber;
		Uri uri = new Uri(text, UriKind.Relative);
		ShellTile val = ShellTile.ActiveTiles.FirstOrDefault((ShellTile x) => x.NavigationUri.ToString().Contains(buddy.PhoneNumber));
		if (val != null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ALREADY_ADDED_TO_SHORTCUTS);
		}
		else
		{
			ShellTile.Create(uri, (ShellTileData)(object)MakeTileForBuddy(buddy));
		}
	}

	private static StandardTileData MakeTileForBuddy(Buddy buddy)
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Expected O, but got Unknown
		new SSMService();
		StandardTileData val = new StandardTileData();
		((ShellTileData)val).Title = buddy.Name;
		val.BackContent = buddy.Status;
		val.BackTitle = ResContainer.IDS_CHATON_BODY_CHATON;
		string text = "thumb_" + buddy.PhoneNumber + ".jpg";
		string text2 = "Cache\\" + text;
		if ((buddy.ImgStatus == Buddy.ProfileImgStatus.NoChanges || buddy.ImgStatus == Buddy.ProfileImgStatus.Updated) && Utility.IsFileExist(text2))
		{
			Utility.SaveFileToShellContent(text2, text);
			val.BackgroundImage = new Uri("isostore:/Shared/ShellContent/" + text, UriKind.Absolute);
		}
		else
		{
			val.BackgroundImage = new Uri("\\Images\\empty.png", UriKind.Relative);
		}
		val.BackBackgroundImage = new Uri("\\Images\\empty.png", UriKind.Relative);
		return val;
	}

	internal static void CallToBuddy(Buddy buddy)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		PhoneCallTask val = new PhoneCallTask();
		string text = buddy.OrgNumber;
		if (!text.Contains("+"))
		{
			text = "+" + buddy.PhoneNumber;
		}
		val.PhoneNumber = text;
		val.DisplayName = buddy.Name;
		val.Show();
	}

	internal static void MessageToBuddy(Buddy buddy)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		SmsComposeTask val = new SmsComposeTask();
		string text = buddy.OrgNumber;
		if (!text.Contains("+"))
		{
			text = "+" + buddy.PhoneNumber;
		}
		val.To = text;
		val.Show();
	}

	internal ObservableCollection<Buddy> GetRankedBuddies()
	{
		IEnumerable<Buddy> enumerable = from b in _dataService.BuddyItems
			orderby b.Rank
			where !b.IsBlocked && !b.IsHideInteraction && b.Rank > 0
			select b;
		Buddy buddy = null;
		int num = 1;
		foreach (Buddy item in enumerable)
		{
			if (num == 1)
			{
				buddy = item;
			}
			item.DisplayRank = num;
			num++;
		}
		IOrderedEnumerable<Buddy> orderedEnumerable = from b in enumerable
			where b.DisplayRank <= 5
			orderby b.DisplayRank
			select b;
		ObservableCollection<Buddy> observableCollection = new ObservableCollection<Buddy>();
		foreach (Buddy item2 in orderedEnumerable)
		{
			if (buddy != null)
			{
				item2.BestInteractionPoint = buddy.InteractionPoint;
			}
			observableCollection.Add(item2);
		}
		return observableCollection;
	}

	public void GetContactListAsync()
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		Contacts val = new Contacts();
		val.SearchCompleted += contacts_SearchCompleted;
		val.SearchAsync(string.Empty, (FilterKind)0, (object)null);
	}

	public void MakeListByType(SettingService.ListByType type, ref List<BuddySummary> buddyItems, ref List<BuddyListHeader> headerItems, bool showBirthday, bool showGroup, bool exceptSpecialBuddies = false)
	{
		buddyItems = new List<BuddySummary>();
		headerItems = new List<BuddyListHeader>();
		IEnumerable<Buddy> source = ((_exceptFilteringNumbers != null) ? _dataService.BuddyItems.Except(_exceptFilteringNumbers) : _dataService.BuddyItems);
		IOrderedEnumerable<Buddy> orderedEnumerable = from d in source
			where !d.IsBlocked
			orderby d.Name
			select d;
		ContactIndex contactIndex = new ContactIndex(IndexType.RegionFormat);
		foreach (Buddy item in orderedEnumerable)
		{
			if (string.IsNullOrEmpty(item.Name))
			{
				item.IndexString = "@";
			}
			else
			{
				item.IndexString = contactIndex.GetIndexChar(item.Name);
			}
		}
		string indexGroups = contactIndex.GetGroups();
		IOrderedEnumerable<Buddy> orderedEnumerable2 = orderedEnumerable.OrderBy((Buddy d) => indexGroups.IndexOf(d.IndexString));
		IEnumerable<Buddy> enumerable = orderedEnumerable2.Where((Buddy d) => d.IsFavorite);
		IEnumerable<Buddy> enumerable2 = orderedEnumerable2.Where((Buddy d) => d.IsNew);
		int num = 0;
		if (!exceptSpecialBuddies)
		{
			if (enumerable2 != null && enumerable2.Any())
			{
				BuddyListHeader buddyListHeader = new BuddyListHeader();
				buddyListHeader.Index = num;
				buddyListHeader.HeaderType = BuddyListHeaderType.New;
				buddyListHeader.Title = ResContainer.IDS_CHATON_HEADER_NEW;
				headerItems.Add(buddyListHeader);
				BuddySummary buddySummary = new BuddySummary();
				buddySummary.HeaderType = BuddyListHeaderType.New;
				buddySummary.HeaderName = ResContainer.IDS_CHATON_HEADER_NEW;
				buddySummary.Type = BuddySummary.ItemType.Index;
				buddySummary.Count = enumerable2.Count();
				buddyItems.Add(buddySummary);
				num++;
				foreach (Buddy item2 in enumerable2)
				{
					BuddySummary buddySummary2 = new BuddySummary();
					buddySummary2.Type = BuddySummary.ItemType.Buddy;
					buddySummary2.Buddy = item2;
					buddySummary2.IsSpecialBuddy = true;
					buddyItems.Add(buddySummary2);
					num++;
				}
			}
			if (showBirthday)
			{
				int num2 = 0;
				BuddyListHeader buddyListHeader2 = new BuddyListHeader();
				buddyListHeader2.Index = num;
				buddyListHeader2.HeaderType = BuddyListHeaderType.Birthday;
				buddyListHeader2.Title = ResContainer.IDS_CHATON_HEADER_BIRTHDAY;
				headerItems.Add(buddyListHeader2);
				BuddySummary buddySummary3 = new BuddySummary();
				buddySummary3.HeaderType = BuddyListHeaderType.Birthday;
				buddySummary3.HeaderName = ResContainer.IDS_CHATON_HEADER_BIRTHDAY;
				buddySummary3.Type = BuddySummary.ItemType.Index;
				buddyItems.Add(buddySummary3);
				num++;
				foreach (Buddy item3 in orderedEnumerable2)
				{
					if (string.IsNullOrEmpty(item3.Birthday))
					{
						continue;
					}
					string[] array = item3.Birthday.Split('-');
					if (array == null)
					{
						item3.Birthday = "";
						continue;
					}
					if (array[0] == "0000")
					{
						item3.Birthday = "";
						continue;
					}
					DateTime dateTime = default(DateTime);
					if (array.Length == 2)
					{
						dateTime = new DateTime(DateTime.Today.Year, int.Parse(array[0]), int.Parse(array[1]));
					}
					else if (array.Length == 3)
					{
						dateTime = new DateTime(int.Parse(array[0]), int.Parse(array[1]), int.Parse(array[2]));
					}
					if (dateTime.Month == DateTime.Today.Month && dateTime.Day == DateTime.Today.Day)
					{
						BuddySummary buddySummary4 = new BuddySummary();
						buddySummary4.Type = BuddySummary.ItemType.Buddy;
						buddySummary4.Buddy = item3;
						buddySummary4.IsSpecialBuddy = true;
						buddyItems.Add(buddySummary4);
						num++;
						num2++;
					}
				}
				buddySummary3.Count = num2;
				if (num2 == 0)
				{
					headerItems.Remove(buddyListHeader2);
					buddyItems.Remove(buddySummary3);
					num--;
				}
			}
			if (enumerable != null && enumerable.Any())
			{
				BuddyListHeader buddyListHeader3 = new BuddyListHeader();
				buddyListHeader3.Index = num;
				buddyListHeader3.HeaderType = BuddyListHeaderType.Favorite;
				buddyListHeader3.Title = ResContainer.IDS_CHATON_BUTTON_FAVOURITE;
				headerItems.Add(buddyListHeader3);
				BuddySummary buddySummary5 = new BuddySummary();
				buddySummary5.HeaderType = BuddyListHeaderType.Favorite;
				buddySummary5.HeaderName = ResContainer.IDS_CHATON_BUTTON_FAVOURITE;
				buddySummary5.Type = BuddySummary.ItemType.Index;
				buddySummary5.Count = enumerable.Count();
				buddyItems.Add(buddySummary5);
				num++;
				foreach (Buddy item4 in enumerable)
				{
					BuddySummary buddySummary6 = new BuddySummary();
					buddySummary6.Type = BuddySummary.ItemType.Buddy;
					buddySummary6.Buddy = item4;
					buddySummary6.IsSpecialBuddy = true;
					buddyItems.Add(buddySummary6);
					num++;
				}
			}
			if (showGroup && _dataService.BuddyGroups != null && _dataService.BuddyGroups.Any())
			{
				BuddyListHeader buddyListHeader4 = new BuddyListHeader();
				buddyListHeader4.Index = num;
				buddyListHeader4.HeaderType = BuddyListHeaderType.Group;
				buddyListHeader4.Title = ResContainer.IDS_CHATON_HEADER_GROUPS;
				headerItems.Add(buddyListHeader4);
				BuddySummary buddySummary7 = new BuddySummary();
				buddySummary7.Type = BuddySummary.ItemType.Index;
				buddySummary7.HeaderName = ResContainer.IDS_CHATON_HEADER_GROUPS;
				buddySummary7.HeaderType = BuddyListHeaderType.Group;
				buddySummary7.Count = _dataService.BuddyGroups.Count();
				buddyItems.Add(buddySummary7);
				num++;
				foreach (BuddyGroup buddyGroup2 in _dataService.BuddyGroups)
				{
					BuddySummary buddySummary8 = new BuddySummary();
					buddySummary8.Type = BuddySummary.ItemType.Group;
					buddySummary8.Group = buddyGroup2;
					buddyItems.Add(buddySummary8);
					num++;
				}
			}
		}
		switch (type)
		{
		case SettingService.ListByType.ByBuddies:
		{
			string text = indexGroups;
			foreach (char c in text)
			{
				BuddyListHeader buddyListHeader6 = new BuddyListHeader();
				buddyListHeader6.Title = c.ToString();
				buddyListHeader6.HeaderType = BuddyListHeaderType.Normal;
				buddyListHeader6.Index = -1;
				headerItems.Add(buddyListHeader6);
			}
			IEnumerable<IGrouping<string, Buddy>> enumerable3 = from d in orderedEnumerable2
				group d by d.IndexString;
			{
				IGrouping<string, Buddy> buddyGroup;
				foreach (IGrouping<string, Buddy> item5 in enumerable3)
				{
					buddyGroup = item5;
					BuddyListHeader buddyListHeader7 = headerItems.First((BuddyListHeader h) => h.Title == buddyGroup.Key.ToString());
					buddyListHeader7.HeaderType = BuddyListHeaderType.Normal;
					buddyListHeader7.Index = num;
					buddyListHeader7.Title = buddyGroup.Key.ToString();
					BuddySummary buddySummary11 = new BuddySummary();
					buddySummary11.HeaderName = buddyGroup.Key.ToString();
					buddySummary11.HeaderType = BuddyListHeaderType.Normal;
					buddySummary11.Type = BuddySummary.ItemType.Index;
					buddyItems.Add(buddySummary11);
					num++;
					foreach (Buddy item6 in buddyGroup)
					{
						BuddySummary buddySummary12 = new BuddySummary();
						buddySummary12.Type = BuddySummary.ItemType.Buddy;
						buddySummary12.Buddy = item6;
						buddyItems.Add(buddySummary12);
						num++;
					}
				}
				break;
			}
		}
		case SettingService.ListByType.ByInteraction:
		{
			if (orderedEnumerable2 == null || !orderedEnumerable2.Any())
			{
				break;
			}
			BuddyListHeader buddyListHeader5 = new BuddyListHeader();
			buddyListHeader5.HeaderType = BuddyListHeaderType.Interaction;
			buddyListHeader5.Title = ResContainer.IDS_CHATON_HEADER_INTERACTION_RANK;
			buddyListHeader5.Index = num;
			headerItems.Add(buddyListHeader5);
			BuddySummary buddySummary9 = new BuddySummary();
			buddySummary9.HeaderType = BuddyListHeaderType.Interaction;
			buddySummary9.HeaderName = ResContainer.IDS_CHATON_HEADER_INTERACTION_RANK;
			buddySummary9.Type = BuddySummary.ItemType.Index;
			buddySummary9.Count = orderedEnumerable2.Count();
			buddyItems.Add(buddySummary9);
			num++;
			IOrderedEnumerable<Buddy> orderedEnumerable3 = orderedEnumerable2.OrderByDescending((Buddy d) => d.InteractionPoint);
			{
				foreach (Buddy item7 in orderedEnumerable3)
				{
					BuddySummary buddySummary10 = new BuddySummary();
					buddySummary10.Type = BuddySummary.ItemType.Buddy;
					buddySummary10.Buddy = item7;
					buddyItems.Add(buddySummary10);
					num++;
				}
				break;
			}
		}
		}
	}

	private void contacts_SearchCompleted(object sender, ContactsSearchEventArgs e)
	{
		//IL_01a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b0: Expected O, but got Unknown
		List<MyContact> list = new List<MyContact>();
		string text = "<param>";
		List<string> list2 = new List<string>();
		foreach (Contact result in e.Results)
		{
			foreach (ContactPhoneNumber phoneNumber2 in result.PhoneNumbers)
			{
				string convNumber = "";
				string phoneNumber = phoneNumber2.PhoneNumber;
				foreach (char c in phoneNumber)
				{
					if ((c >= '0' && c <= '9') || c == '+')
					{
						convNumber += c;
					}
				}
				if (convNumber.Length < CheckingNumberLength)
				{
					continue;
				}
				list2.Add(convNumber);
				MyContact myContact = _dataService.ContactItems.FirstOrDefault((MyContact myContact3) => myContact3.PhoneNumber == convNumber);
				if (myContact != null && myContact.Uploaded)
				{
					if (myContact.DisplayName != result.DisplayName)
					{
						Buddy buddy = FindBuddyFromContactNumber(convNumber);
						if (buddy != null)
						{
							buddy.Name = result.DisplayName;
						}
						myContact.DisplayName = result.DisplayName;
					}
				}
				else
				{
					text = text + "<address>" + convNumber + "</address>";
					if (myContact == null)
					{
						list.Add(new MyContact(result.DisplayName, convNumber));
					}
				}
			}
		}
		Stopwatch val = new Stopwatch();
		val.Start();
		foreach (MyContact item in list)
		{
			_dataService.AddContact(item, isSubmit: false);
		}
		List<MyContact> list3 = new List<MyContact>();
		List<Buddy> list4 = new List<Buddy>();
		MyContact contact;
		foreach (MyContact contactItem in _dataService.ContactItems)
		{
			contact = contactItem;
			string value = list2.FirstOrDefault((string text2) => text2 == contact.PhoneNumber);
			if (string.IsNullOrEmpty(value))
			{
				list3.Add(contact);
				Buddy buddy2 = FindBuddyFromContactNumber(contact.PhoneNumber);
				if (buddy2 != null)
				{
					list4.Add(buddy2);
				}
			}
		}
		foreach (MyContact item2 in list3)
		{
			_dataService.DeleteContact(item2);
		}
		foreach (Buddy item3 in list4)
		{
			MyContact myContact2 = FindContact(item3.PhoneNumber, item3.OrgNumber);
			if (myContact2 == null && !string.IsNullOrEmpty(item3.ProfileName))
			{
				item3.Name = item3.ProfileName;
			}
			else
			{
				item3.Name = myContact2.DisplayName;
			}
			ChatOnService.Instance.IsBuddiesUpdated = true;
		}
		val.Stop();
		_dataService.SubmitChanges();
		text += "</param>";
		if (this.GetContactListCompleted != null)
		{
			this.GetContactListCompleted(this, new BuddyManagerEventArgs(text));
		}
	}

	private Buddy FindBuddyFromContactNumber(string convNumber)
	{
		Buddy result = null;
		foreach (Buddy buddyItem in _dataService.BuddyItems)
		{
			string text = convNumber.Substring(convNumber.Length - CheckingNumberLength);
			string text2 = buddyItem.PhoneNumber.Substring(buddyItem.PhoneNumber.Length - CheckingNumberLength);
			if (!(text != text2) && (buddyItem.PhoneNumber.Contains(convNumber) || convNumber.Contains(buddyItem.PhoneNumber) || buddyItem.OrgNumber.Contains(convNumber) || convNumber.Contains(buddyItem.OrgNumber)))
			{
				result = buddyItem;
				break;
			}
		}
		return result;
	}

	internal void LoadBuddiesProfileImage()
	{
		foreach (Buddy buddyItem in _dataService.BuddyItems)
		{
			if (!buddyItem.LoadProfileImage())
			{
				buddyItem.LoadProfileImage(_ssmService.GetBuddyProfileImageUri(buddyItem.PhoneNumber));
			}
		}
		_dataService.SubmitChanges();
	}

	internal static void TellFriends(bool viaSms = true)
	{
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0034: Expected O, but got Unknown
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0020: Expected O, but got Unknown
		string iDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG = ResContainer.IDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG;
		iDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG = iDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG.Replace("\\n", "");
		if (viaSms)
		{
			SmsComposeTask val = new SmsComposeTask();
			val.Body = iDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG;
			val.Show();
		}
		else
		{
			EmailComposeTask val2 = new EmailComposeTask();
			val2.Body = iDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG;
			val2.Show();
		}
	}

	internal void SetContactsUploadedFlag()
	{
		foreach (MyContact contactItem in _dataService.ContactItems)
		{
			contactItem.Uploaded = true;
		}
		_dataService.SubmitChanges();
	}

	internal bool SaveOrUpdateUnknownUser(string phoneNumber, string name)
	{
		bool result = false;
		UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == phoneNumber);
		if (unknownUser != null && unknownUser.Name != name)
		{
			unknownUser.Name = name;
			result = true;
		}
		else if (unknownUser == null)
		{
			_dataService.AddUnknownUser(new UnknownUser(name, phoneNumber));
			result = true;
		}
		return result;
	}

	internal string GetBuddyNameByNumber(string number, out bool unknown)
	{
		unknown = false;
		Buddy buddy = GetBuddy(number);
		if (buddy != null)
		{
			return buddy.Name;
		}
		UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
		if (unknownUser != null)
		{
			return unknownUser.Name;
		}
		unknown = true;
		return ResContainer.IDS_CHATON_BODY_UNKNOWN;
	}
}
