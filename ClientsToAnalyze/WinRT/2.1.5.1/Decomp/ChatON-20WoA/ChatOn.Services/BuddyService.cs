using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Queue;
using Windows.ApplicationModel.Contacts;
using Windows.Foundation;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Services;

public class BuddyService
{
	public delegate void AddBuddyByPeopleEmailCompletedHandler(object sender, SSMCompletedEventArgs e);

	public delegate void UpdateTotalEmailHandler(object sender, int total);

	public delegate void UpdateTotalContactHandler(object sender, IReadOnlyList<ContactInformation> contacts);

	public delegate void GetContactListCompletedEventHandler(object sender, BuddyManagerEventArgs e);

	private static readonly int CheckingNumberLength = 6;

	private DataService _dataService;

	private SSMService _ssmService;

	private List<Buddy> _exceptFilteringNumbers;

	private int _newlyAddedCount;

	public int NewlyAddedCount
	{
		get
		{
			return _newlyAddedCount;
		}
		set
		{
			_newlyAddedCount = value;
		}
	}

	public event AddBuddyByPeopleEmailCompletedHandler AddBuddyByPeopleEmailCompleted;

	public event UpdateTotalEmailHandler UpdateTotalEmail;

	public event UpdateTotalContactHandler UpdateTotalContact;

	public event GetContactListCompletedEventHandler GetContactListCompleted;

	protected virtual void OnAddBuddyByPeopleEmailCompleted(SSMCompletedEventArgs e)
	{
		this.AddBuddyByPeopleEmailCompleted?.Invoke(this, e);
	}

	protected virtual void OnUpdateTotalEmailHandler(int e)
	{
		this.UpdateTotalEmail?.Invoke(this, e);
	}

	protected virtual void OnUpdateTotalContactHandler(IReadOnlyList<ContactInformation> contacts)
	{
		this.UpdateTotalContact?.Invoke(this, contacts);
	}

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
		foreach (string number in numberList)
		{
			IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
			Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == number;
			Buddy buddy = buddyItems.FirstOrDefault(predicate);
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

	public bool RemoveBuddyFromGroup(string phoneNumber)
	{
		bool result = false;
		List<BuddyGroup> list = new List<BuddyGroup>();
		foreach (BuddyGroup group in _dataService.BuddyGroups)
		{
			if (group.Members.Contains(phoneNumber))
			{
				group.Members = group.Members.Replace(phoneNumber, "!");
				group.Members = group.Members.Replace("!,", "");
				group.Members = group.Members.Replace(",!", "");
				group.Members = group.Members.Replace("!", "");
				BuddySummary buddySummary = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.GroupID == group.GroupID && group.Members == "");
				if (buddySummary != null)
				{
					list.Add(group);
				}
				result = true;
			}
		}
		if (list != null)
		{
			foreach (BuddyGroup group2 in list)
			{
				PivotPage.ActiveInstance.ViewModel.DeleteGroupWithoutPopUp(group2);
				ObservableCollection<BuddySummary> showingItems = PivotPage.ActiveInstance.ViewModel.ShowingItems;
				Func<BuddySummary, bool> predicate = (BuddySummary x) => x.Group != null && x.Group.GroupID == group2.GroupID && group2.Members == "";
				BuddySummary item = showingItems.FirstOrDefault(predicate);
				PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(item);
			}
		}
		return result;
	}

	internal void BlockBuddy(Buddy buddy)
	{
		if (RemoveBuddyFromGroup(buddy.PhoneNumber))
		{
			_dataService.GroupDBSubmitChanges();
		}
		if (buddy.IsFavorite)
		{
			buddy.IsFavorite = false;
		}
		buddy.IsBlocked = true;
		_dataService.BuddyDBSubmitChanges();
	}

	public Buddy AddBuddy(string phoneNumber, string name, string status, string birthday, Buddy.ProfileImgStatus imgstatus, string email, string samsungEmail, bool showPhoneNumber, bool isBlind, string orgNum)
	{
		Buddy buddy = CreateBuddy(phoneNumber, name, status, birthday, imgstatus, email, samsungEmail, showPhoneNumber, isBlind, orgNum);
		_dataService.AddBuddy(buddy, isSubmit: false);
		UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == phoneNumber);
		if (unknownUser != null)
		{
			_dataService.DeleteUnknownUser(unknownUser);
		}
		return buddy;
	}

	public Buddy CreateBuddy(string phoneNumber, string name, string status, string birthday, Buddy.ProfileImgStatus imgstatus, string email, string samsungEmail, bool showPhoneNumber, bool isBlind, string orgNum)
	{
		Buddy buddy = new Buddy(name, phoneNumber, status);
		buddy.Birthday = birthday;
		buddy.ImgStatus = imgstatus;
		buddy.Email = email;
		buddy.SamsungEmail = samsungEmail;
		buddy.OrgNumber = orgNum;
		buddy.IsShowPhoneNumber = showPhoneNumber;
		return buddy;
	}

	public List<Buddy> AddBuddyFromXml(XElement xe, bool updateOnly = false, bool previewOnly = false)
	{
		//IL_02c8: Unknown result type (might be due to invalid IL or missing references)
		//IL_02d2: Expected O, but got Unknown
		//IL_05e3: Unknown result type (might be due to invalid IL or missing references)
		//IL_05ed: Expected O, but got Unknown
		List<Buddy> list = new List<Buddy>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddy")
			select (item);
		foreach (XElement item in enumerable)
		{
			string number = "";
			string orgNumber = "";
			string sainfo = "";
			string text = "";
			string text2 = "";
			string text3 = "";
			string email = "";
			string samsungEmail = "";
			string groups = "";
			string mSISDNS = "";
			bool flag = false;
			bool flag2 = false;
			bool isBlind = false;
			bool isSpecialBuddy = false;
			bool flag3 = false;
			Buddy.ProfileImgStatus profileImgStatus = Buddy.ProfileImgStatus.None;
			number = item.Value;
			if (item.Attribute("sainfo") != null && !string.IsNullOrEmpty(item.Attribute("sainfo").Value))
			{
				sainfo = item.Attribute("sainfo").Value;
			}
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
			if (buddy == null && !string.IsNullOrEmpty(sainfo))
			{
				Buddy buddy2 = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.Sainfo == sainfo);
				if (buddy2 != null)
				{
					buddy = buddy2;
				}
			}
			Buddy buddy3 = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == RegistrationService.ChatOnID);
			if (buddy3 != null)
			{
				_dataService.DeleteBuddy(buddy3);
			}
			if (item.Attribute("orgname") != null && !string.IsNullOrEmpty(item.Attribute("orgname").Value))
			{
				text = WebUtility.HtmlDecode(item.Attribute("orgname").Value);
			}
			else if (item.Attribute("name") != null)
			{
				text = WebUtility.HtmlDecode(item.Attribute("name").Value);
			}
			if (item.Attribute("orgnum") != null)
			{
				orgNumber = item.Attribute("orgnum").Value;
				if (buddy != null)
				{
					buddy.OrgNumber = orgNumber;
				}
			}
			if (item.Attribute("status") != null)
			{
				text2 = item.Attribute("status").Value;
				if (buddy != null && buddy.Status != text2)
				{
					buddy.StatusForeground = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
					buddy.Status = text2;
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
			if (item.Attribute("msisdns") != null)
			{
				mSISDNS = item.Attribute("msisdns").Value;
			}
			if (item.Attribute("group") != null)
			{
				groups = item.Attribute("group").Value;
			}
			flag3 = item.Attribute("blocked") != null && bool.Parse(item.Attribute("blocked").Value);
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
			}
			if (item.Attribute("deleted") != null)
			{
				flag = bool.Parse(item.Attribute("deleted").Value);
			}
			if (item.Attribute("devicetype") != null)
			{
				flag2 = true;
			}
			if (!string.IsNullOrEmpty(orgNumber))
			{
				MyContact myContact = _dataService.ContactItems.FirstOrDefault((MyContact c) => orgNumber.Contains(c.PhoneNumber) || c.PhoneNumber.Contains(orgNumber));
				if (myContact != null && !string.IsNullOrEmpty(myContact.DisplayName))
				{
					text = WebUtility.HtmlDecode(myContact.DisplayName);
				}
			}
			string text4 = number.Substring(0, 4);
			if (text4 == "0999")
			{
				isSpecialBuddy = true;
			}
			if (previewOnly)
			{
				Buddy buddy4 = CreateBuddy(item.Value, text, text2, text3, profileImgStatus, email, samsungEmail, flag2, isBlind, orgNumber);
				if (buddy4.ImgStatus == Buddy.ProfileImgStatus.Updated)
				{
					buddy4.ProfileImage = new BitmapImage(_ssmService.GetBuddyProfileImageUriCheck(buddy4.PhoneNumber));
				}
				if (buddy != null)
				{
					buddy4.IsNew = true;
				}
				list.Add(buddy4);
			}
			else if (!updateOnly)
			{
				if (!string.IsNullOrEmpty(sainfo))
				{
					Buddy buddy5 = _dataService.BuddyItems.FirstOrDefault((Buddy b) => b.Sainfo == sainfo);
					if (buddy5 != null && buddy != null)
					{
						_ = buddy5.PhoneNumber != buddy.PhoneNumber;
					}
				}
				if (flag)
				{
					if (buddy != null && !buddy.IsBlocked)
					{
						_dataService.DeleteBuddy(buddy);
					}
				}
				else if (buddy == null)
				{
					Buddy buddy6 = AddBuddy(item.Value, text, text2, text3, profileImgStatus, email, samsungEmail, flag2, isBlind, orgNumber);
					buddy6.IsNew = true;
					buddy6.ProfileName = text;
					buddy6.MSISDNS = mSISDNS;
					buddy6.IsSpecialBuddy = isSpecialBuddy;
					buddy6.IsBlocked = flag3;
					buddy6.IsShowPhoneNumber = flag2;
					buddy6.Sainfo = sainfo;
					list.Add(buddy6);
				}
				else
				{
					MyContact myContact2 = FindContact(number, orgNumber);
					if (myContact2 != null)
					{
						buddy.Name = myContact2.DisplayName;
						buddy.ProfileName = myContact2.DisplayName;
					}
					else if (!string.IsNullOrEmpty(text))
					{
						buddy.Name = text;
					}
					if (item.Attribute("orgname") != null && string.IsNullOrEmpty(item.Attribute("orgname").Value))
					{
						buddy.ProfileName = "";
					}
					buddy.PhoneNumber = number;
					buddy.MSISDNS = mSISDNS;
					buddy.IsSpecialBuddy = isSpecialBuddy;
					buddy.IsBlocked = flag3;
					buddy.IsShowPhoneNumber = flag2;
					buddy.Sainfo = sainfo;
				}
				if (!flag3)
				{
					UpdateGroupList(groups, number, flag);
				}
			}
			else if (buddy != null && !string.IsNullOrEmpty(text))
			{
				MyContact myContact3 = FindContact(number, orgNumber);
				if (myContact3 != null)
				{
					buddy.Name = myContact3.DisplayName;
					buddy.ProfileName = myContact3.DisplayName;
				}
				else if (!string.IsNullOrEmpty(text))
				{
					buddy.Name = text;
				}
				if (item.Attribute("orgname") != null && string.IsNullOrEmpty(item.Attribute("orgname").Value))
				{
					buddy.ProfileName = "";
				}
				buddy.MSISDNS = mSISDNS;
				buddy.IsSpecialBuddy = isSpecialBuddy;
				buddy.IsBlocked = flag3;
				if (!buddy.IsBlocked)
				{
					UpdateGroupList(groups, number, deleted: false);
				}
			}
		}
		_dataService.UnknownUserDBSubmitChanges();
		_dataService.BuddyDBSubmitChanges();
		_dataService.ContactDBSubmitChanges();
		return list;
	}

	private void UpdateGroupList(string groups, string number, bool deleted)
	{
		List<BuddyGroup> list = new List<BuddyGroup>();
		if (string.IsNullOrEmpty(groups))
		{
			return;
		}
		string[] array = Utility.Split(Utility.XMLStringDecode(groups));
		foreach (BuddyGroup group in _dataService.BuddyGroups)
		{
			if (group.Members.Contains(number))
			{
				if (deleted || string.IsNullOrEmpty(groups) || array.FirstOrDefault((string c) => c == group.Name) == null)
				{
					group.Members = group.Members.Replace(number + ",", "");
					group.Members = group.Members.Replace(number, "");
					if (string.IsNullOrEmpty(group.Members))
					{
						list.Add(group);
					}
				}
				continue;
			}
			for (int num = 0; num < array.Length; num++)
			{
				if (!(array[num] == "favorites") && array[num] == group.Name)
				{
					if (string.IsNullOrEmpty(group.Members))
					{
						group.Members += number;
						continue;
					}
					BuddyGroup buddyGroup = group;
					buddyGroup.Members = buddyGroup.Members + "," + number;
				}
			}
		}
		foreach (BuddyGroup group2 in list)
		{
			_dataService.DeleteGroup(group2);
			ObservableCollection<BuddySummary> showingItems = PivotPage.ActiveInstance.ViewModel.ShowingItems;
			Func<BuddySummary, bool> predicate = (BuddySummary x) => x.Group != null && x.Group.Equals(group2);
			BuddySummary item = showingItems.FirstOrDefault(predicate);
			PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(item);
			PivotPage.ActiveInstance.ViewModel.UpdateList();
		}
		if (deleted)
		{
			return;
		}
		string[] array2 = array;
		foreach (string group3 in array2)
		{
			if (!(group3 == "favorites") && !string.IsNullOrEmpty(group3))
			{
				BuddyGroup buddyGroup2 = _dataService.BuddyGroups.FirstOrDefault((BuddyGroup g) => g.Name == group3);
				if (buddyGroup2 == null)
				{
					BuddyGroup buddyGroup3 = new BuddyGroup();
					buddyGroup3.Name = group3;
					buddyGroup3.Members = number;
					_dataService.AddBuddyGroup(buddyGroup3);
				}
			}
		}
	}

	private MyContact FindContact(string phoneNumber, string orgNum)
	{
		string text = "";
		foreach (char c in orgNum)
		{
			if ((c >= '0' && c <= '9') || c == '+')
			{
				text += c;
			}
		}
		MyContact result = null;
		if (phoneNumber.Length >= CheckingNumberLength)
		{
			foreach (MyContact contactItem in _dataService.ContactItems)
			{
				if (contactItem.PhoneNumber.Length >= CheckingNumberLength)
				{
					string text2 = contactItem.PhoneNumber.Substring(contactItem.PhoneNumber.Length - CheckingNumberLength);
					string text3 = phoneNumber.Substring(phoneNumber.Length - CheckingNumberLength);
					if (!(text2 != text3) && (phoneNumber.Contains(contactItem.PhoneNumber) || contactItem.PhoneNumber.Contains(phoneNumber) || text.Contains(contactItem.PhoneNumber) || contactItem.PhoneNumber.Contains(text)))
					{
						result = contactItem;
						break;
					}
				}
			}
		}
		return result;
	}

	public int AddRecommendBuddyFromXml(XElement xe)
	{
		int num = 0;
		try
		{
			IEnumerable<XElement> enumerable = from item in xe.Descendants("recommendee")
				select (item);
			foreach (XElement item in enumerable)
			{
				string number = "";
				string name = "";
				if (item.Attribute("rname") != null)
				{
					name = item.Attribute("rname").Value;
				}
				if (item.Attribute("ruserid") != null)
				{
					number = item.Attribute("ruserid").Value;
				}
				UnknownUser unknownUser = _dataService.RecommendeeItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
				if (unknownUser == null)
				{
					UnknownUser unknownUser2 = new UnknownUser(name, number);
					unknownUser2.LoadProfileImage(applyTheme: true);
					_dataService.AddRecommendee(unknownUser2);
				}
				else
				{
					unknownUser.Name = name;
					unknownUser.LoadProfileImage(applyTheme: true);
				}
				num++;
			}
			return num;
		}
		catch (Exception)
		{
			return 0;
		}
	}

	public void ApplyRankFromXml(XElement xe, string week = "1")
	{
		foreach (Buddy buddyItem in _dataService.BuddyItems)
		{
			buddyItem.Rank = 0;
			buddyItem.SentCount = 0;
			buddyItem.ReceivedCount = 0;
		}
		IEnumerable<XElement> source = from b in xe.Descendants("interaction")
			where b.Attribute("week").Value == "1"
			select b;
		IEnumerable<XElement> enumerable = from item in source.Descendants("buddyid")
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

	public async void ApplyRankFromXml(XElement xe, CoreDispatcher dispatcher, string week = "1")
	{
		await dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			foreach (Buddy buddyItem in _dataService.BuddyItems)
			{
				buddyItem.Rank = 0;
				buddyItem.SentCount = 0;
				buddyItem.ReceivedCount = 0;
			}
			IEnumerable<XElement> source = from b in xe.Descendants("interaction")
				where b.Attribute("week").Value == "1"
				select b;
			IEnumerable<XElement> enumerable = from item in source.Descendants("buddyid")
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
		});
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
			if (!(number.Substring(0, 4) == "0999"))
			{
				Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
				if (buddy != null)
				{
					buddy.IsHideInteraction = true;
				}
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
			BlockBuddyInfo buddyInfo = new BlockBuddyInfo();
			buddyInfo.Number = item.Value;
			if (item.Attribute("name") != null)
			{
				buddyInfo.Name = item.Attribute("name").Value;
			}
			if (buddyInfo.Number.Substring(0, 4) == "0999")
			{
				continue;
			}
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == buddyInfo.Number);
			bool unknown;
			string buddyNameByNumber = buddyService.GetBuddyNameByNumber(buddyInfo.Number, out unknown);
			if (!unknown)
			{
				buddyInfo.Name = buddyNameByNumber;
			}
			buddyInfo.ProfileImageUri = _ssmService.GetBuddyProfileImageUri(buddyInfo.Number);
			if (buddy != null)
			{
				buddyInfo.ProfileImage = buddy.ProfileImage;
			}
			else
			{
				UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == buddyInfo.Number);
				if (unknownUser != null)
				{
					unknownUser.LoadProfileImageOnly();
					buddyInfo.ProfileImage = unknownUser.ProfileImage;
				}
			}
			observableCollection.Add(buddyInfo);
		}
		return observableCollection;
	}

	public ObservableCollection<BuddiesSay> ParseMemoFromXml(XElement xe, out bool isBlind)
	{
		//IL_0267: Unknown result type (might be due to invalid IL or missing references)
		//IL_026e: Expected O, but got Unknown
		//IL_01f4: Unknown result type (might be due to invalid IL or missing references)
		//IL_01fb: Expected O, but got Unknown
		//IL_0254: Unknown result type (might be due to invalid IL or missing references)
		//IL_025b: Expected O, but got Unknown
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
			BitmapImage val = null;
			if (profileImgStatus != Buddy.ProfileImgStatus.Deleted && profileImgStatus != Buddy.ProfileImgStatus.None)
			{
				RegistrationService.GetUserProfile();
				if (text2 == RegistrationService.ChatOnID)
				{
					val = new BitmapImage(_ssmService.GetUserProfileImageUri(isThumbnail: false, isForceUpdate: true));
					name = Utility.GetResourceString("IDS_CHATON_BODY_ME");
				}
				else
				{
					Buddy buddy = GetBuddy(text2);
					if (buddy != null)
					{
						name = (string.IsNullOrEmpty(buddy.ProfileName) ? buddy.Name : buddy.ProfileName);
						val = buddy.ProfileImage;
					}
					else
					{
						val = new BitmapImage(_ssmService.GetBuddyProfileImageUri(text2));
					}
				}
			}
			else
			{
				val = new BitmapImage(new Uri("ms-appx:///Images/buddies_profile_image.png"));
				if (text2 == RegistrationService.ChatOnID)
				{
					name = Utility.GetResourceString("IDS_CHATON_BODY_ME");
				}
			}
			observableCollection.Add(new BuddiesSay(name, text2, text, val, timeStamp));
		}
		return observableCollection;
	}

	internal void UpdateTile()
	{
	}

	public static async void PinToStart(Buddy buddy)
	{
	}

	internal static void CallToBuddy(Buddy buddy)
	{
	}

	internal static void MessageToBuddy(Buddy buddy)
	{
	}

	internal static bool IsValidEmail(string text)
	{
		Regex regex = new Regex("^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$");
		Match match = regex.Match(text);
		if (match.Success)
		{
			return true;
		}
		return false;
	}

	internal static async Task<bool> ShowAddBuddyResult(SSMCompletedEventArgs e, string phoneNumber, bool _isSearchEmail = false)
	{
		try
		{
			if (!string.IsNullOrEmpty(e.ErrorMessage))
			{
				if (e.ErrorMessage.Contains("25005"))
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ALREADY_YOUR_BUDDY"));
					await dialog.ShowAsync();
					SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
					ChatOnService.Instance.ReUpdateBuddyList = true;
					ChatOnService.Instance.ReUpdateInteraction = true;
				}
				else if (e.ErrorMessage.Contains("25004"))
				{
					await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CANNOT_ADD_YOURSELF"), showCancel: false, "Error");
				}
				else if (e.ErrorMessage.Contains("25008") || e.ErrorMessage.Contains("25002"))
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_ADD_BUDDY"));
					await dialog.ShowAsync();
				}
				else if (e.ErrorMessage.Contains("25007"))
				{
					string msg = Utility.GetResourceString("IDS_CHATON_POP_PS_ALREADY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST");
					msg = msg.Replace("%s", "{0:}");
					msg = string.Format(msg, new object[1] { phoneNumber });
					MessageDialog dialog = new MessageDialog(msg);
					await dialog.ShowAsync();
				}
				else if (e.ErrorMessage.Contains("25012"))
				{
					if (!IsValidEmail(phoneNumber) && !_isSearchEmail)
					{
						string msg2 = Utility.GetResourceString("IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT");
						MessageDialog dialog = new MessageDialog(msg2);
						await dialog.ShowAsync();
					}
					else
					{
						string msg3 = Utility.GetResourceString("IDS_CHATON_BODY_INVALID_EMAIL_ADDRESS");
						MessageDialog dialog = new MessageDialog(msg3);
						await dialog.ShowAsync();
					}
				}
				else if (e.ErrorMessage.Contains("00800"))
				{
					string msg4 = Utility.GetResourceString("IDS_CHATON_POP_PSS_SAMSUNG_ACCOUNT_IS_SYNCHRONISING_WITH_CHATON_TRY_LATER");
					msg4 = msg4.Replace("%s", "");
					msg4 = msg4.Replace("'s", "").Trim();
					MessageDialog dialog = new MessageDialog(msg4);
					await dialog.ShowAsync();
				}
				else if (e.ErrorMessage.Contains("50005"))
				{
					string msg5 = Utility.GetResourceString("IDS_CHATON_POP_PSS_SAMSUNG_ACCOUNT_IS_SYNCHRONISING_WITH_CHATON_TRY_LATER");
					msg5 = msg5.Replace("%s", "");
					MessageDialog dialog = new MessageDialog(msg5);
					await dialog.ShowAsync();
				}
				else
				{
					if (e.ErrorMessage.Contains("CCS-25900"))
					{
						try
						{
							MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN"));
							await dialog.ShowAsync();
						}
						catch
						{
						}
						return false;
					}
					if (e.ErrorMessage.Contains("25013"))
					{
						string msg6 = Utility.GetResourceString("SS_BUDDIES_WHO_HAVE_DISABLED_SHOW_MY_NUMBER_MAY_NOT_APPEAR_IN_THE_SEARCH_RESULTS");
						MessageDialog dialog = new MessageDialog(msg6);
						await dialog.ShowAsync();
					}
					else if (e.ErrorMessage.Contains("25014"))
					{
						string msg7 = Utility.GetResourceString("SS_BUDDIES_WHO_HAVE_DISABLED_SHOW_MY_SAMSUNG_ACCOUNT_MAY_NOT_APPEAR_IN_THE_SEARCH_RESULTS");
						MessageDialog dialog = new MessageDialog(msg7);
						await dialog.ShowAsync();
					}
				}
			}
			else if (e.StatusCode == HttpStatusCode.NoContent)
			{
				string msg8 = Utility.GetResourceString("IDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER");
				msg8 = msg8.Replace("%s", "{0:}");
				DataService dataService = new DataService();
				UnknownUser user = dataService.UnknownUserItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == phoneNumber);
				msg8 = ((user == null) ? string.Format(msg8, new object[1] { phoneNumber }) : string.Format(msg8, new object[1] { user.Name }));
				MessageDialog dialog = new MessageDialog(msg8);
				await dialog.ShowAsync();
			}
			else if (e.StatusCode != HttpStatusCode.OK || e.Xml == null)
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
			else if (e.StatusCode == HttpStatusCode.OK)
			{
				return true;
			}
			return false;
		}
		catch
		{
			return false;
		}
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
		try
		{
			ContactPicker val = new ContactPicker();
			val.put_CommitButtonText(Utility.GetResourceString("IDS_CHATON_BUTTON_ADD"));
			val.put_SelectionMode((ContactSelectionMode)0);
			IAsyncOperation<IReadOnlyList<ContactInformation>> val2 = val.PickMultipleContactsAsync();
			val2.put_Completed((AsyncOperationCompletedHandler<IReadOnlyList<ContactInformation>>)(object)Delegate.Combine((Delegate)(object)val2.Completed, (Delegate)(object)new AsyncOperationCompletedHandler<IReadOnlyList<ContactInformation>>(ContactsSelectionCompleted)));
		}
		catch (Exception)
		{
		}
	}

	public string MakeGroupMemberListParam(BuddyGroup group, bool delete, string newName = "")
	{
		string text = "";
		text += "<param>";
		string[] array = Utility.Split(group.Members);
		string[] array2 = array;
		foreach (string number in array2)
		{
			IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
			Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == number;
			buddyItems.FirstOrDefault(predicate);
			if (!string.IsNullOrEmpty(newName))
			{
				string text2 = text;
				text = text2 + "<address group=\"" + Utility.XMLStringEncode(group.Name) + "," + Utility.XMLStringEncode(newName) + "\">+" + number + "</address>";
			}
			else if (delete)
			{
				string text3 = text;
				text = text3 + "<address group=\"" + Utility.XMLStringEncode(group.Name) + ", \">+" + number + "</address>";
			}
			else
			{
				string text4 = text;
				text = text4 + "<address group=\"" + Utility.XMLStringEncode(group.Name) + "\">+" + number + "</address>";
			}
		}
		return text + "</param>";
	}

	public string MakeGroupMemberListParam(BuddyGroup group, IEnumerable<Buddy> removed, IEnumerable<Buddy> added)
	{
		string text = "";
		text += "<param>";
		foreach (Buddy item in added)
		{
			string text2 = text;
			text = text2 + "<address group=\"" + Utility.XMLStringEncode(group.Name) + "\">+" + item.PhoneNumber + "</address>";
		}
		foreach (Buddy item2 in removed)
		{
			string text3 = text;
			text = text3 + "<address group=\"" + Utility.XMLStringEncode(group.Name) + ", \">+" + item2.PhoneNumber + "</address>";
		}
		return text + "</param>";
	}

	public string MakeGroupMemberListParam(BuddyGroup group, IEnumerable<BuddySummary> buddyList, bool added = true)
	{
		string text = "";
		text += "<param>";
		if (added)
		{
			foreach (BuddySummary buddy in buddyList)
			{
				string text2 = text;
				text = text2 + "<address group=\"" + Utility.XMLStringEncode(group.Name) + "\">+" + buddy.Buddy.PhoneNumber + "</address>";
			}
		}
		else
		{
			foreach (BuddySummary buddy2 in buddyList)
			{
				string text3 = text;
				text = text3 + "<address group=\"" + Utility.XMLStringEncode(group.Name) + ", \">+" + buddy2.Buddy.PhoneNumber + "</address>";
			}
		}
		return text + "</param>";
	}

	public void MakeListByType(SettingService.ListByType type, ref List<BuddySummary> buddyItems, ref ObservableCollection<BuddyListHeader> headerItems, bool showBirthday, bool showGroup, bool exceptSpecialBuddies = false, bool includeMe = true, bool showAll = false)
	{
		//IL_01f7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01fe: Expected O, but got Unknown
		//IL_028e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0295: Expected O, but got Unknown
		//IL_0300: Unknown result type (might be due to invalid IL or missing references)
		//IL_030a: Expected O, but got Unknown
		//IL_0271: Unknown result type (might be due to invalid IL or missing references)
		//IL_0278: Expected O, but got Unknown
		buddyItems = new List<BuddySummary>();
		headerItems = new ObservableCollection<BuddyListHeader>();
		IEnumerable<Buddy> source = ((_exceptFilteringNumbers != null) ? _dataService.BuddyItems.Except(_exceptFilteringNumbers) : _dataService.BuddyItems);
		_dataService.BuddyItems.Where((Buddy buddy2) => buddy2.IsSpecialBuddy);
		IOrderedEnumerable<Buddy> orderedEnumerable = from d in source
			where !d.IsBlocked && !d.IsSpecialBuddy && d.PhoneNumber.Substring(0, 4) != "0999"
			orderby d.Name
			select d;
		ContactIndex contactIndex = new ContactIndex(IndexType.RegionFormat);
		foreach (Buddy item in orderedEnumerable)
		{
			if (string.IsNullOrEmpty(item.Name))
			{
				item.IndexString = "#";
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
		_newlyAddedCount = enumerable2.Count();
		int num = 0;
		if (showAll && orderedEnumerable.Count() > 0)
		{
			BuddySummary buddySummary = new BuddySummary();
			buddySummary.HeaderType = BuddyListHeaderType.All;
			buddySummary.HeaderName = "All";
			buddySummary.Type = BuddySummary.ItemType.Index;
			buddySummary.ItemIndex = 0;
			buddySummary.Count = orderedEnumerable.Count();
			buddyItems.Insert(0, buddySummary);
			num++;
		}
		if (includeMe && orderedEnumerable.Count() > 0)
		{
			BitmapImage val = new BitmapImage();
			UserProfile userProfile = RegistrationService.GetUserProfile();
			Buddy buddy = new Buddy();
			buddy.Name = userProfile.Name;
			buddy.ImgStatus = (Buddy.ProfileImgStatus)userProfile.ImageStatus;
			int imgStatus = (int)buddy.ImgStatus;
			if (imgStatus != 2 && imgStatus != 3)
			{
				UserProfileImage userProfileImage = userProfile.ProfileImageHistory.FirstOrDefault((UserProfileImage x) => x.IsRepresent);
				if (userProfileImage != null)
				{
					val = new BitmapImage(userProfileImage.ProfileImageUri);
				}
			}
			else
			{
				val = new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/chat_info_single.png"));
			}
			buddy.PhoneNumber = RegistrationService.ChatOnID;
			buddy.ProfileImage = val;
			buddy.ThumbProfileImage = val;
			buddy.Status = userProfile.Status;
			buddy.BuddyID = buddy.BuddyID;
			buddy.ProfileName = userProfile.Name;
			buddy.IsFavorite = true;
			buddy.Background = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 251, 232, 154));
			buddy.IsNew = true;
			BuddySummary buddySummary2 = new BuddySummary();
			buddySummary2.Type = BuddySummary.ItemType.Me;
			buddy.IsDownloading = false;
			buddySummary2.Buddy = buddy;
			buddySummary2.IsSpecialBuddy = true;
			buddySummary2.ItemIndex = 1;
			buddySummary2.HeaderType = BuddyListHeaderType.Me;
			buddyItems.Add(buddySummary2);
			num++;
		}
		if (!exceptSpecialBuddies)
		{
			if (enumerable2 != null && enumerable2.Any())
			{
				BuddyListHeader buddyListHeader = new BuddyListHeader();
				buddyListHeader.Index = num;
				buddyListHeader.HeaderType = BuddyListHeaderType.New;
				buddyListHeader.Title = Utility.GetResourceString("IDS_CHATON_HEADER_NEW");
				headerItems.Add(buddyListHeader);
				BuddySummary buddySummary3 = new BuddySummary();
				buddySummary3.HeaderType = BuddyListHeaderType.New;
				buddySummary3.HeaderName = Utility.GetResourceString("IDS_CHATON_HEADER_NEW");
				buddySummary3.Type = BuddySummary.ItemType.Index;
				buddySummary3.Count = enumerable2.Count();
				_newlyAddedCount = buddySummary3.Count;
				buddyListHeader.TotalMember = buddySummary3.Count;
				buddySummary3.ItemIndex = num;
				buddyItems.Add(buddySummary3);
				num++;
				foreach (Buddy item2 in enumerable2)
				{
					BuddySummary buddySummary4 = new BuddySummary();
					buddySummary4.Type = BuddySummary.ItemType.Buddy;
					buddySummary4.Buddy = item2;
					buddySummary4.IsSpecialBuddy = true;
					buddySummary4.ItemIndex = num;
					buddySummary4.HeaderType = BuddyListHeaderType.New;
					buddyItems.Add(buddySummary4);
					num++;
				}
			}
			if (showBirthday)
			{
				int num2 = 0;
				BuddyListHeader buddyListHeader2 = new BuddyListHeader();
				buddyListHeader2.Index = num;
				buddyListHeader2.HeaderType = BuddyListHeaderType.Birthday;
				buddyListHeader2.Title = Utility.GetResourceString("IDS_CHATON_HEADER_BIRTHDAY");
				headerItems.Add(buddyListHeader2);
				BuddySummary buddySummary5 = new BuddySummary();
				buddySummary5.HeaderType = BuddyListHeaderType.Birthday;
				buddySummary5.HeaderName = Utility.GetResourceString("IDS_CHATON_HEADER_BIRTHDAY");
				buddySummary5.Type = BuddySummary.ItemType.Index;
				buddySummary5.ItemIndex = num;
				buddyItems.Add(buddySummary5);
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
						dateTime = new DateTime(2012, int.Parse(array[0]), int.Parse(array[1]));
					}
					else if (array.Length == 3)
					{
						dateTime = new DateTime(int.Parse(array[0]), int.Parse(array[1]), int.Parse(array[2]));
					}
					if (dateTime.Month == DateTime.Today.Month && dateTime.Day == DateTime.Today.Day)
					{
						BuddySummary buddySummary6 = new BuddySummary();
						buddySummary6.Type = BuddySummary.ItemType.Buddy;
						buddySummary6.Buddy = item3;
						buddySummary6.IsSpecialBuddy = true;
						buddySummary6.ItemIndex = num;
						buddySummary6.HeaderType = BuddyListHeaderType.Birthday;
						buddyItems.Add(buddySummary6);
						num++;
						num2++;
					}
				}
				buddySummary5.Count = num2;
				buddyListHeader2.TotalMember = num2;
				if (num2 == 0)
				{
					headerItems.Remove(buddyListHeader2);
					buddyItems.Remove(buddySummary5);
					num--;
				}
			}
			if (enumerable != null && enumerable.Any())
			{
				BuddyListHeader buddyListHeader3 = new BuddyListHeader();
				buddyListHeader3.Index = num;
				buddyListHeader3.HeaderType = BuddyListHeaderType.Favorite;
				buddyListHeader3.Title = Utility.GetResourceString("IDS_CHATON_BUTTON_FAVOURITE");
				buddyListHeader3.TotalMember = enumerable.Count();
				headerItems.Add(buddyListHeader3);
				BuddySummary buddySummary7 = new BuddySummary();
				buddySummary7.HeaderType = BuddyListHeaderType.Favorite;
				buddySummary7.HeaderName = Utility.GetResourceString("IDS_CHATON_BUTTON_FAVOURITE");
				buddySummary7.Type = BuddySummary.ItemType.Index;
				buddySummary7.Count = enumerable.Count();
				buddySummary7.ItemIndex = num;
				buddyItems.Add(buddySummary7);
				num++;
				foreach (Buddy item4 in enumerable)
				{
					BuddySummary buddySummary8 = new BuddySummary();
					buddySummary8.Type = BuddySummary.ItemType.Buddy;
					buddySummary8.Buddy = item4;
					buddySummary8.IsSpecialBuddy = true;
					buddySummary8.HeaderType = BuddyListHeaderType.Favorite;
					buddySummary8.ItemIndex = num;
					buddyItems.Add(buddySummary8);
					num++;
				}
			}
			if (showGroup && orderedEnumerable.Count() > 0 && _dataService.BuddyGroups != null && _dataService.BuddyGroups.Any())
			{
				BuddyListHeader buddyListHeader4 = new BuddyListHeader();
				buddyListHeader4.Index = num;
				buddyListHeader4.HeaderType = BuddyListHeaderType.Group;
				buddyListHeader4.Title = Utility.GetResourceString("IDS_CHATON_HEADER_GROUPS");
				buddyListHeader4.TotalMember = _dataService.BuddyGroups.Count();
				headerItems.Add(buddyListHeader4);
				BuddySummary buddySummary9 = new BuddySummary();
				buddySummary9.Type = BuddySummary.ItemType.Index;
				buddySummary9.HeaderName = Utility.GetResourceString("IDS_CHATON_HEADER_GROUPS");
				buddySummary9.HeaderType = BuddyListHeaderType.Group;
				buddySummary9.Count = _dataService.BuddyGroups.Count();
				buddySummary9.ItemIndex = num;
				buddyItems.Add(buddySummary9);
				num++;
				foreach (BuddyGroup item5 in _dataService.BuddyGroups.OrderBy((BuddyGroup buddyGroup2) => buddyGroup2.Name))
				{
					BuddySummary buddySummary10 = new BuddySummary();
					buddySummary10.Type = BuddySummary.ItemType.Group;
					buddySummary10.Group = item5;
					buddySummary10.ItemIndex = num;
					buddySummary10.HeaderType = BuddyListHeaderType.Group;
					buddyItems.Add(buddySummary10);
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
				foreach (IGrouping<string, Buddy> buddyGroup in enumerable3)
				{
					ObservableCollection<BuddyListHeader> source2 = headerItems;
					Func<BuddyListHeader, bool> predicate = (BuddyListHeader h) => h.Title == buddyGroup.Key.ToString();
					BuddyListHeader buddyListHeader7 = source2.FirstOrDefault(predicate);
					buddyListHeader7.HeaderType = BuddyListHeaderType.Normal;
					buddyListHeader7.Index = num;
					buddyListHeader7.Title = buddyGroup.Key.ToString();
					buddyListHeader7.TotalMember = buddyGroup.Count();
					BuddySummary buddySummary13 = new BuddySummary();
					buddySummary13.HeaderName = buddyGroup.Key.ToString();
					buddySummary13.HeaderType = BuddyListHeaderType.Normal;
					buddySummary13.Type = BuddySummary.ItemType.Index;
					buddySummary13.ItemIndex = num;
					buddySummary13.Count = buddyGroup.Count();
					buddyItems.Add(buddySummary13);
					num++;
					foreach (Buddy item6 in buddyGroup)
					{
						BuddySummary buddySummary14 = new BuddySummary();
						buddySummary14.Type = BuddySummary.ItemType.Buddy;
						buddySummary14.Buddy = item6;
						buddySummary14.HeaderType = BuddyListHeaderType.Normal;
						buddySummary14.ItemIndex = num;
						buddyItems.Add(buddySummary14);
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
			buddyListHeader5.Title = Utility.GetResourceString("IDS_CHATON_HEADER_INTERACTION_RANK");
			buddyListHeader5.Index = num;
			buddyListHeader5.TotalMember = orderedEnumerable2.Count();
			headerItems.Add(buddyListHeader5);
			BuddySummary buddySummary11 = new BuddySummary();
			buddySummary11.HeaderType = BuddyListHeaderType.Interaction;
			buddySummary11.HeaderName = Utility.GetResourceString("IDS_CHATON_HEADER_INTERACTION_RANK");
			buddySummary11.Type = BuddySummary.ItemType.Index;
			buddySummary11.Count = orderedEnumerable2.Count();
			buddySummary11.ItemIndex = num;
			buddyItems.Add(buddySummary11);
			num++;
			IOrderedEnumerable<Buddy> orderedEnumerable3 = orderedEnumerable2.OrderByDescending((Buddy d) => d.InteractionPoint);
			{
				foreach (Buddy item7 in orderedEnumerable3)
				{
					BuddySummary buddySummary12 = new BuddySummary();
					buddySummary12.Type = BuddySummary.ItemType.Buddy;
					buddySummary12.Buddy = item7;
					buddySummary12.ItemIndex = num;
					buddySummary12.HeaderType = BuddyListHeaderType.Interaction;
					buddyItems.Add(buddySummary12);
					num++;
				}
				break;
			}
		}
		}
	}

	private void ContactsSelectionCompleted(IAsyncOperation<IReadOnlyList<ContactInformation>> result, AsyncStatus asyncStatus)
	{
		IReadOnlyList<ContactInformation> results = result.GetResults();
		if (results.Count != 0)
		{
			OnUpdateTotalContactHandler(results);
			AddPeopleByEmail(results);
			AddPeopleByPhoneNumbers(results);
		}
	}

	private void AddPeopleByEmail(IReadOnlyList<ContactInformation> contacts)
	{
		int e = contacts.Sum((ContactInformation contactInformation) => contactInformation.Emails.Count);
		OnUpdateTotalEmailHandler(e);
		foreach (ContactInformation contact in contacts)
		{
			foreach (ContactField email in contact.Emails)
			{
				SSMService sSMService = new SSMService(_ssmService.Account, _ssmService.SrvAddress);
				sSMService.AddBuddyCompleted += ssmService_PreviewBuddyCompleted;
				string value = email.Value;
				sSMService.AddBuddyAsync(value);
			}
		}
	}

	private void ssmService_PreviewBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		OnAddBuddyByPeopleEmailCompleted(e);
	}

	private void AddPeopleByPhoneNumbers(IReadOnlyList<ContactInformation> list)
	{
		List<MyContact> list2 = new List<MyContact>();
		string text = "<param>";
		foreach (ContactInformation item in list)
		{
			foreach (ContactField phoneNumber in item.PhoneNumbers)
			{
				string convNumber = phoneNumber.Value;
				while (convNumber.IndexOf('-') >= 0)
				{
					convNumber = convNumber.Remove(convNumber.IndexOf('-'), 1);
				}
				MyContact myContact = _dataService.ContactItems.FirstOrDefault((MyContact c) => c.PhoneNumber == convNumber);
				if (myContact != null && myContact.Uploaded)
				{
					if (myContact.DisplayName != item.Name)
					{
						Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.OrgNumber.Contains(myContact.PhoneNumber) || myContact.PhoneNumber.Contains(c.OrgNumber));
						if (buddy != null)
						{
							buddy.Name = item.Name;
						}
						myContact.DisplayName = item.Name;
					}
					continue;
				}
				string text2 = (convNumber.Contains("+") ? "" : "+");
				string text3 = text;
				text = text3 + "<address name=\"" + item.Name + "\">" + text2 + convNumber + "</address>";
				if (myContact == null)
				{
					list2.Add(new MyContact(item.Name, convNumber));
				}
			}
		}
		foreach (MyContact item2 in list2)
		{
			_dataService.AddContact(item2, isSubmit: false);
		}
		_dataService.ContactDBSubmitChanges();
		text += "</param>";
		if (this.GetContactListCompleted != null)
		{
			this.GetContactListCompleted(this, new BuddyManagerEventArgs(text));
		}
	}

	public string MakeParamUploadAddressList(string name, string phoneNumber)
	{
		string text = (phoneNumber.Contains("+") ? "" : "+");
		string text2 = "<param>";
		string text3 = text2;
		text2 = text3 + "<address name=\"" + name + "\">" + text + phoneNumber + "</address>";
		return text2 + "</param>";
	}

	internal async void LoadBuddiesProfileImage()
	{
		try
		{
			foreach (Buddy buddy in _dataService.BuddyItems.OrderBy((Buddy p) => p.Name))
			{
				if (buddy.ImgStatus == Buddy.ProfileImgStatus.Deleted)
				{
					continue;
				}
				BitmapImage profileimage = await Utility.LoadImage("thumb_" + buddy.PhoneNumber + ".jpg", "Cache");
				if (profileimage != null && (((BitmapSource)profileimage).PixelWidth == 0 || ((BitmapSource)profileimage).PixelHeight == 0))
				{
					await Utility.DeleteFile("thumb_" + buddy.PhoneNumber + ".jpg", "Cache");
					profileimage = null;
					buddy.ImgStatus = Buddy.ProfileImgStatus.None;
				}
				if (profileimage == null)
				{
					QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
					GetBuddyProfileImage_QueueItem getBuddyProfileImage_QueueItem = new GetBuddyProfileImage_QueueItem(_ssmService, buddy.PhoneNumber, isthumbnail: true, forceupdate: false);
					getBuddyProfileImage_QueueItem.InvokeBack = delegate(object o, Exception ex2)
					{
						if (ex2 == null && o != null)
						{
							buddy.IsDownloading = false;
							buddy.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
							buddy.ThumbProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
							buddy.NotifyPropertyChanged("ProfileImage");
						}
					};
					queueEngine.Add(getBuddyProfileImage_QueueItem);
				}
				else if (!(profileimage.UriSource == null) || (((BitmapSource)profileimage).PixelWidth != 0 && ((BitmapSource)profileimage).PixelHeight != 0))
				{
					buddy.ProfileImage = profileimage;
					buddy.ThumbProfileImage = profileimage;
					buddy.NotifyPropertyChanged("ProfileImage");
				}
			}
			_dataService.BuddyDBSubmitChanges();
		}
		catch (Exception)
		{
		}
	}

	internal async void LoadBuddiesProfileImage(ObservableCollection<BuddySummary> listofbuddysummary)
	{
		try
		{
			foreach (BuddySummary buddysummary in listofbuddysummary)
			{
				if (buddysummary.Type != BuddySummary.ItemType.Buddy || buddysummary.Buddy == null || buddysummary.Buddy.ImgStatus == Buddy.ProfileImgStatus.Deleted)
				{
					continue;
				}
				BitmapImage profileimage = await Utility.LoadImage("thumb_" + buddysummary.Buddy.PhoneNumber + ".jpg", "Cache");
				if (profileimage != null && (((BitmapSource)profileimage).PixelWidth == 0 || ((BitmapSource)profileimage).PixelHeight == 0))
				{
					await Utility.DeleteFile("thumb_" + buddysummary.Buddy.PhoneNumber + ".jpg", "Cache");
					profileimage = null;
					buddysummary.Buddy.ImgStatus = Buddy.ProfileImgStatus.None;
				}
				if (profileimage == null || buddysummary.Buddy.ImgStatus == Buddy.ProfileImgStatus.Updated)
				{
					QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
					GetBuddyProfileImage_QueueItem getBuddyProfileImage_QueueItem = new GetBuddyProfileImage_QueueItem(_ssmService, buddysummary.Buddy.PhoneNumber, isthumbnail: true, forceupdate: false);
					getBuddyProfileImage_QueueItem.InvokeBack = delegate(object o, Exception ex2)
					{
						if (ex2 == null && o != null)
						{
							buddysummary.Buddy.IsDownloading = false;
							buddysummary.Buddy.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
							buddysummary.Buddy.ThumbProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
							buddysummary.Buddy.NotifyPropertyChanged("ProfileImage");
							buddysummary.Buddy.ImgStatus = Buddy.ProfileImgStatus.NoChanges;
							_dataService.BuddyDBSubmitChanges();
							PivotPage.ActiveInstance.ViewModel.UpdateMessageList(buddysummary.Buddy);
						}
					};
					queueEngine.Add(getBuddyProfileImage_QueueItem);
				}
				else
				{
					if (profileimage.UriSource == null)
					{
						return;
					}
					buddysummary.Buddy.ProfileImage = profileimage;
					buddysummary.Buddy.ThumbProfileImage = profileimage;
					buddysummary.Buddy.NotifyPropertyChanged("ProfileImage");
					PivotPage.ActiveInstance.ViewModel.UpdateMessageList(buddysummary.Buddy);
				}
			}
			_dataService.BuddyDBSubmitChanges();
		}
		catch (Exception)
		{
		}
	}

	public async void LoadLocalBuddyProfileImage()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			foreach (Buddy buddy in _dataService.BuddyItems)
			{
				if (buddy.ImgStatus != Buddy.ProfileImgStatus.Deleted && buddy.ImgStatus != Buddy.ProfileImgStatus.None)
				{
					BitmapImage profileimage = await Utility.LoadImage("thumb_" + buddy.PhoneNumber + ".jpg", "Cache");
					if (profileimage != null)
					{
						buddy.ProfileImage = profileimage;
						buddy.ThumbProfileImage = profileimage;
						buddy.NotifyPropertyChanged("ProfileImage");
					}
				}
			}
		}
		catch (Exception)
		{
		}
	}

	internal static void TellFriends(bool viaSms = true)
	{
		string resourceString = Utility.GetResourceString("IDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG");
		resourceString = resourceString.Replace("\\n", "");
	}

	internal void SetContactsUploadedFlag()
	{
		foreach (MyContact contactItem in _dataService.ContactItems)
		{
			contactItem.Uploaded = true;
		}
		_dataService.ContactDBSubmitChanges();
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
			return WebUtility.HtmlDecode(buddy.Name);
		}
		UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
		if (unknownUser != null)
		{
			return WebUtility.HtmlDecode(unknownUser.Name);
		}
		unknown = true;
		return Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
	}

	public string GetBuddyIdFromUnblockResponse(XDocument unblockResponse)
	{
		XElement xElement = unblockResponse.Descendants("buddyid").FirstOrDefault();
		return xElement.Value;
	}

	public void LoadBuddyGroupProfileImage()
	{
		foreach (BuddyGroup buddyGroup in _dataService.BuddyGroups)
		{
			buddyGroup.LoadProfileImage(_ssmService.GetGroupProfileImageUri(buddyGroup.Name));
		}
	}

	public List<string> ParseBuddyGroupFromXml(XElement xe)
	{
		List<string> list = new List<string>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddy")
			select (item);
		foreach (XElement item in enumerable)
		{
			if (item.Attribute("group") != null)
			{
				list.Add(item.Attribute("group").Value);
			}
		}
		return list;
	}

	internal void RemoveEmptyBuddyGroup()
	{
		for (int num = _dataService.BuddyGroups.Count() - 1; num >= 0; num--)
		{
			BuddyGroup buddyGroup = _dataService.BuddyGroups.ElementAt(num);
			if (string.IsNullOrEmpty(buddyGroup.Members))
			{
				_dataService.DeleteGroup(buddyGroup);
			}
		}
	}

	internal string ParseUnknownBuddyInfo(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddy")
			select (item);
		string result = "";
		foreach (XElement item in enumerable)
		{
			if (item.Attribute("countrycode") != null)
			{
				result = item.Attribute("countrycode").Value;
			}
		}
		return result;
	}

	internal UnknownUser ParseUnknownBuddyInfos(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddy")
			select (item);
		UnknownUser unknownUser = new UnknownUser();
		foreach (XElement item in enumerable)
		{
			if (item.Attribute("countrycode") != null)
			{
				unknownUser.CountryCode = item.Attribute("countrycode").Value;
			}
			if (item.Attribute("name") != null)
			{
				unknownUser.Name = item.Attribute("name").Value;
			}
			if (item.Attribute("imgstatus") != null)
			{
				unknownUser.ImgStatus = (Buddy.ProfileImgStatus)int.Parse(item.Attribute("imgstatus").Value);
			}
			if (item.Attribute("status") != null)
			{
				unknownUser.Status = item.Attribute("status").Value;
			}
		}
		return unknownUser;
	}

	internal Buddy ParseCheckBuddyInfos(XElement xe, Buddy buddy = null)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("buddy")
			select (item);
		Buddy buddy2 = ((buddy == null) ? new Buddy() : buddy);
		foreach (XElement item in enumerable)
		{
			if (item.Attribute("orgname") != null && !string.IsNullOrEmpty(item.Attribute("orgname").Value))
			{
				if (!item.Attribute("orgname").Value.Equals(buddy2.Name))
				{
					buddy2.Name = WebUtility.HtmlDecode(item.Attribute("orgname").Value);
				}
				buddy2.ProfileName = WebUtility.HtmlDecode(item.Attribute("orgname").Value);
			}
			else if (item.Attribute("name") != null && !item.Attribute("name").Value.Equals(buddy2.Name))
			{
				buddy2.Name = WebUtility.HtmlDecode(item.Attribute("name").Value);
			}
			if (item.Attribute("imgstatus") != null)
			{
				buddy2.ImgStatus = (Buddy.ProfileImgStatus)int.Parse(item.Attribute("imgstatus").Value);
			}
			if (item.Attribute("status") != null)
			{
				buddy2.Status = item.Attribute("status").Value;
			}
			if (item.Attribute("birthday") != null)
			{
				buddy2.Birthday = item.Attribute("birthday").Value;
			}
		}
		if (buddy != null)
		{
			_dataService.BuddyDBSubmitChanges();
		}
		return buddy2;
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

	public async Task<List<UnknownUser>> ParseRecommendBuddyFromXml(XElement xe, bool downloadImage = false)
	{
		List<UnknownUser> resultList = new List<UnknownUser>();
		IEnumerable<XElement> xmlQuery = from result in xe.Descendants("recommendee")
			select (result);
		foreach (XElement item in xmlQuery)
		{
			string number = "";
			string name = "";
			if (item.Attribute("rname") != null)
			{
				name = item.Attribute("rname").Value;
			}
			if (item.Attribute("ruserid") != null)
			{
				number = item.Attribute("ruserid").Value;
			}
			Buddy buddy = ChatOnService.Instance.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
			if (buddy != null)
			{
				UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
				if (unknownUser != null)
				{
					ChatOnService.Instance.RecommendeeItems.Remove(unknownUser);
				}
				continue;
			}
			UnknownUser user = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
			if (user == null)
			{
				user = new UnknownUser(name, number);
			}
			else
			{
				user.Name = name;
			}
			if (downloadImage)
			{
				user.ProfileImage = await LoadLocalImage(number);
			}
			resultList.Add(user);
		}
		return resultList;
	}

	private async Task<BitmapImage> LoadLocalImage(string phoneNumber)
	{
		BitmapImage img = new BitmapImage(new Uri("ms-appx:///Images/buddies_profile_image.png"));
		try
		{
			StorageFile file = await Utility.IsFileExist("suggestion", "thumb_" + phoneNumber + ".jpg");
			if (file != null)
			{
				IRandomAccessStream fs = await file.OpenAsync((FileAccessMode)0);
				if (fs != null && fs.Size != 0)
				{
					((BitmapSource)img).SetSource(fs);
				}
			}
			return img;
		}
		catch
		{
			return img;
		}
	}

	internal void ShowContact(Buddy buddy)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		ContactPicker val = new ContactPicker();
		val.put_CommitButtonText(Utility.GetResourceString("IDS_CHATON_SK_SELECT"));
		val.put_SelectionMode((ContactSelectionMode)0);
		IAsyncOperation<ContactInformation> val2 = val.PickSingleContactAsync();
		val2.put_Completed((AsyncOperationCompletedHandler<ContactInformation>)(object)Delegate.Combine((Delegate)(object)val2.Completed, (Delegate)(object)new AsyncOperationCompletedHandler<ContactInformation>(ShowContactCompleted)));
	}

	private void ShowContactCompleted(IAsyncOperation<ContactInformation> result, AsyncStatus asyncStatus)
	{
		result.GetResults();
	}

	public List<UserProfileImage> ParseImageListHistoryfromXml(XElement xml)
	{
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		List<UserProfileImage> list = new List<UserProfileImage>();
		IEnumerable<XElement> enumerable = from item in xml.Descendants("profileimagelist")
			select (item);
		bool isRepresent = false;
		Uri profileImageUri = null;
		foreach (XElement item in enumerable)
		{
			string profileImageId = "";
			if (item.Descendants("profileimageid") != null)
			{
				profileImageId = item.Descendants("profileimageid").FirstOrDefault().Value;
			}
			string text = "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI + "&size=800&" + Utility.GetTimeStamp();
			if (item.Descendants("profileimageurl") != null)
			{
				profileImageUri = new Uri(item.Descendants("profileimageurl").FirstOrDefault().Value + text);
			}
			if (item.Descendants("represent") != null)
			{
				if (item.Descendants("represent").FirstOrDefault().Value == "1")
				{
					isRepresent = true;
					profileImageUri = _ssmService.GetUserProfileImageUri(isThumbnail: false);
				}
				else
				{
					isRepresent = false;
				}
			}
			list.Add(new UserProfileImage
			{
				ProfileImageId = profileImageId,
				ProfileImageUri = profileImageUri,
				IsRepresent = isRepresent
			});
		}
		return list;
	}

	internal Buddy AddBlockedBuddy(BlockBuddyInfo item)
	{
		string status = (string.IsNullOrWhiteSpace(item.Status) ? string.Empty : item.Status);
		Buddy buddy = AddBuddy(item.Number, item.Name, status, "", Buddy.ProfileImgStatus.None, "", "", showPhoneNumber: true, isBlind: false, item.Number);
		buddy.IsNew = true;
		buddy.ProfileName = item.Name;
		buddy.MSISDNS = "";
		buddy.IsSpecialBuddy = false;
		buddy.IsBlocked = true;
		buddy.IsShowPhoneNumber = true;
		buddy.Sainfo = "";
		_dataService.BuddyDBSubmitChanges();
		return buddy;
	}

	public List<UserProfileImage> ParseImageListHistoryfromXml(XElement xml, int imageSize = -1)
	{
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		List<UserProfileImage> list = new List<UserProfileImage>();
		IEnumerable<XElement> enumerable = from item in xml.Descendants("profileimagelist")
			select (item);
		bool isRepresent = false;
		Uri profileImageUri = null;
		foreach (XElement item in enumerable)
		{
			string profileImageId = "";
			if (item.Descendants("profileimageid") != null)
			{
				profileImageId = item.Descendants("profileimageid").FirstOrDefault().Value;
			}
			string text = "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI + "&" + Utility.GetTimeStamp();
			if (imageSize > 0)
			{
				text = text + "&size=" + imageSize;
			}
			if (item.Descendants("profileimageurl") != null)
			{
				profileImageUri = new Uri(item.Descendants("profileimageurl").FirstOrDefault().Value + text);
			}
			if (item.Descendants("represent") != null)
			{
				if (item.Descendants("represent").FirstOrDefault().Value == "1")
				{
					isRepresent = true;
					profileImageUri = _ssmService.GetUserProfileImageUri(isThumbnail: false);
				}
				else
				{
					isRepresent = false;
				}
			}
			list.Add(new UserProfileImage
			{
				ProfileImageId = profileImageId,
				ProfileImageUri = profileImageUri,
				IsRepresent = isRepresent
			});
		}
		return list;
	}
}
