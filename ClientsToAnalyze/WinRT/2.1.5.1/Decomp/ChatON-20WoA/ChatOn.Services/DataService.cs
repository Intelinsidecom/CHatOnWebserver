using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.DataModel;
using ChatON_WoA.Services;
using ChatOn.Models;
using SDatabase;

namespace ChatOn.Services;

public class DataService
{
	private ContactDataContext _contactDB;

	private BuddyDataContext _buddyDB;

	private BuddyGroupDataContext _buddyGroupDB;

	private UnknownUserDataContext _unknownUserDB;

	private RecommendeeDataContext _recommendeeDB;

	private ChatDataContext _chatDB;

	private MessageDataContext _messageDB;

	private AniconDataContext _aniconDB;

	private InteractionRankContext _interactionRankDb;

	private object newLock = new object();

	private object _thisLock = new object();

	private object _messagesLock = new object();

	private object _messageItemsLock = new object();

	public List<Message> UnreadMessages
	{
		get
		{
			return ChatOnService.Instance.UnreadMessages;
		}
		set
		{
			ChatOnService.Instance.UnreadMessages = value;
		}
	}

	public IEnumerable<Chat> ChatItems => ChatOnService.Instance.ChatItems;

	public IEnumerable<Buddy> BuddyItems => ChatOnService.Instance.BuddyItems;

	public IEnumerable<MyContact> ContactItems => ChatOnService.Instance.ContactItems;

	public IEnumerable<Message> MessageItems => ChatOnService.Instance.MessageItems;

	public IEnumerable<UnknownUser> UnknownUserItems => ChatOnService.Instance.UnknownUserItems;

	public IEnumerable<UnknownUser> RecommendeeItems => ChatOnService.Instance.RecommendeeItems;

	public IEnumerable<BuddyGroup> BuddyGroups => ChatOnService.Instance.GroupItems;

	public IEnumerable<OfflineAniconPackage> AninconPackages => ChatOnService.Instance.AniconPackages;

	public List<Anicon> ReceivedAnicons
	{
		get
		{
			return ChatOnService.Instance.ReceivedAnicons;
		}
		set
		{
			ChatOnService.Instance.ReceivedAnicons = value;
		}
	}

	public IEnumerable<InteractionRank> InteractionRanks => ChatOnService.Instance.InteractionRanks;

	internal DataService()
	{
		_buddyDB = ChatOnService.Instance.BuddyDB;
		_buddyGroupDB = ChatOnService.Instance.BuddyGroupDB;
		_unknownUserDB = ChatOnService.Instance.UnknownUserDB;
		_recommendeeDB = ChatOnService.Instance.RecommendeeDB;
		_messageDB = ChatOnService.Instance.MessageDB;
		_chatDB = ChatOnService.Instance.ChatDB;
		_contactDB = ChatOnService.Instance.ContactDB;
		_aniconDB = ChatOnService.Instance.AniconDB;
		_interactionRankDb = ChatOnService.Instance.InteractionRankDb;
	}

	internal Message FirstOrDefaultMessage(Func<Message, bool> predicate)
	{
		lock (_messageItemsLock)
		{
			return ChatOnService.Instance.MessageItems.FirstOrDefault(predicate);
		}
	}

	internal void BuddyDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_buddyDB.SubmitChanges();
		});
	}

	internal void InteractionRankDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_interactionRankDb.SubmitChanges();
		});
	}

	internal void ContactDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_contactDB.SubmitChanges();
		});
	}

	internal void ChatDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_chatDB.SubmitChanges();
		});
	}

	internal void MessageDBSubmitChanges()
	{
		try
		{
			Task.Factory.StartNew((Func<Task>)async delegate
			{
				await _messageDB.SubmitChanges();
			});
		}
		catch (Exception)
		{
		}
	}

	internal void UnknownUserDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_unknownUserDB.SubmitChanges();
		});
	}

	internal void RecommendeeDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_recommendeeDB.SubmitChanges();
		});
	}

	internal void GroupDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_buddyGroupDB.SubmitChanges();
		});
	}

	internal void AniconDBSubmitChanges()
	{
		Task.Factory.StartNew(delegate
		{
			_aniconDB.SubmitChanges();
		});
	}

	internal async void SubmitAllChanges()
	{
		Task.Factory.StartNew((Func<Task>)async delegate
		{
			_aniconDB.SubmitChanges();
			_buddyGroupDB.SubmitChanges();
			_recommendeeDB.SubmitChanges();
			_unknownUserDB.SubmitChanges();
			await _messageDB.SubmitChanges();
			_buddyDB.SubmitChanges();
			_contactDB.SubmitChanges();
			_chatDB.SubmitChanges();
		});
	}

	internal void LoadAll()
	{
		try
		{
			LoadBuddyList();
			LoadContactList();
			LoadUnknownUserList();
			LoadRecommendeeList();
			LoadGroupList();
			LoadMessageList();
			LoadChatList();
			LoadAniconPackageList();
			LoadInteractionRankList();
		}
		catch (Exception)
		{
		}
	}

	private static int CompareByTime(Message x, Message y)
	{
		if (x.Time == 0 && y.Time == 0)
		{
			return 0;
		}
		if (x.Time == 0)
		{
			return 1;
		}
		if (y.Time == 0)
		{
			return -1;
		}
		return x.Time.CompareTo(y.Time);
	}

	private void LoadChatList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.ChatItems = new List<Chat>();
		IEnumerable<SDBData> enumerable = _chatDB.Chats.DataList.Select((SDBData n) => n);
		SSMService ssmService = new SSMService();
		BuddyService buddyService = new BuddyService(this, ssmService);
		ChatService chatService = new ChatService(this, buddyService, RegistrationService.ChatOnID);
		foreach (SDBData item in enumerable)
		{
			if (item is Chat)
			{
				Chat chat = item as Chat;
				ChatOnService.Instance.ChatItems.Add(chat);
				foreach (Message messageItem in ChatOnService.Instance.MessageItems)
				{
					if (string.IsNullOrEmpty(messageItem.SessionID))
					{
						if (messageItem.ChatID == chat.ChatID)
						{
							chatService.AddMessage(chat, messageItem);
							messageItem.Chat = chat;
						}
					}
					else if (messageItem.SessionID == chat.SessionID)
					{
						chatService.AddMessage(chat, messageItem);
						messageItem.Chat = chat;
					}
				}
				chatService.LoadAnsInfo(chat);
				chatService.SortAllMessages(chat);
				chatService.GetLastMessage(chat);
				chat.LoadMemberList();
			}
			long ticks2 = DateTime.UtcNow.Ticks;
			TimeSpan.FromTicks(ticks2 - ticks);
		}
	}

	private void LoadBuddyList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.BuddyItems = new ObservableCollection<Buddy>();
		IEnumerable<SDBData> enumerable = _buddyDB.Buddies.DataList.Select((SDBData n) => n);
		foreach (SDBData item in enumerable)
		{
			ChatOnService.Instance.BuddyItems.Add(item as Buddy);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void LoadInteractionRankList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.InteractionRanks = new List<InteractionRank>();
		IEnumerable<SDBData> enumerable = _interactionRankDb.InteractionRanks.DataList.Select((SDBData n) => n);
		foreach (SDBData item in enumerable)
		{
			ChatOnService.Instance.InteractionRanks.Add(item as InteractionRank);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void LoadMessageList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.MessageItems = new List<Message>();
		IEnumerable<SDBData> enumerable = _messageDB.Messages.DataList.Select((SDBData n) => n);
		foreach (SDBData item in enumerable)
		{
			ChatOnService.Instance.MessageItems.Add(item as Message);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void LoadContactList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.ContactItems = new List<MyContact>();
		IEnumerable<SDBData> enumerable = _contactDB.Contacts.DataList.Select((SDBData n) => n);
		foreach (SDBData item in enumerable)
		{
			ChatOnService.Instance.ContactItems.Add(item as MyContact);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void LoadUnknownUserList()
	{
		ChatOnService.Instance.UnknownUserItems = new List<UnknownUser>();
		foreach (SDBData data in _unknownUserDB.UnknownUsers.DataList)
		{
			ChatOnService.Instance.UnknownUserItems.Add(data as UnknownUser);
		}
	}

	private void LoadRecommendeeList()
	{
		ChatOnService.Instance.RecommendeeItems = new List<UnknownUser>();
		foreach (SDBData data in _recommendeeDB.Recommendee.DataList)
		{
			ChatOnService.Instance.RecommendeeItems.Add(data as UnknownUser);
		}
	}

	private void LoadGroupList()
	{
		ChatOnService.Instance.GroupItems = new List<BuddyGroup>();
		foreach (SDBData data in _buddyGroupDB.Groups.DataList)
		{
			if (data is BuddyGroup && !string.IsNullOrEmpty((data as BuddyGroup).Members))
			{
				ChatOnService.Instance.GroupItems.Add(data as BuddyGroup);
			}
		}
	}

	private void LoadAniconPackageList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.AniconPackages = new ObservableCollection<OfflineAniconPackage>();
		foreach (SDBData data in _aniconDB.Packages.DataList)
		{
			if (data is OfflineAniconPackage)
			{
				ChatOnService.Instance.AniconPackages.Add(data as OfflineAniconPackage);
				OfflineAniconPackage offlineAniconPackage = data as OfflineAniconPackage;
				XElement xe = XElement.Parse(offlineAniconPackage.XmlString);
				AniconService.GetPackageInfo(offlineAniconPackage, xe);
			}
			foreach (OfflineAniconPackage aninconPackage in AninconPackages)
			{
				foreach (Anicon anicon in aninconPackage.AniconList)
				{
					ChatOnService.Instance.Anicons.Add(anicon);
				}
			}
			long ticks2 = DateTime.UtcNow.Ticks;
			TimeSpan.FromTicks(ticks2 - ticks);
		}
	}

	internal void CheckAniconPackagesExpired(long serverTime)
	{
		if (serverTime <= 0)
		{
			return;
		}
		int count = ChatOnService.Instance.AniconPackages.Count;
		for (int num = count - 1; num >= 0; num--)
		{
			if (ChatOnService.Instance.AniconPackages[0].EndDate < serverTime)
			{
				DeleteAnicon(ChatOnService.Instance.AniconPackages[0]);
			}
		}
	}

	internal Chat GetChat(Guid chatID)
	{
		return ChatOnService.Instance.ChatItems.FirstOrDefault((Chat c) => c.ChatID == chatID);
	}

	internal Chat GetChatUsingSessionID(string sessionID)
	{
		return ChatOnService.Instance.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionID);
	}

	internal void AddBuddy(Buddy buddy, bool isSubmit = true)
	{
		lock (_thisLock)
		{
			_buddyDB.Buddies.InsertOnSubmit(buddy);
		}
		ChatOnService.Instance.BuddyItems.Add(buddy);
		if (isSubmit)
		{
			BuddyDBSubmitChanges();
		}
	}

	internal void AddChat(Chat newChat)
	{
		lock (_thisLock)
		{
			_chatDB.Chats.InsertOnSubmit(newChat);
		}
		ChatOnService.Instance.ChatItems.Add(newChat);
		ChatDBSubmitChanges();
	}

	internal void AddContact(MyContact myContact, bool isSubmit = true)
	{
		lock (_thisLock)
		{
			_contactDB.Contacts.InsertOnSubmit(myContact);
		}
		ChatOnService.Instance.ContactItems.Add(myContact);
		if (isSubmit)
		{
			ContactDBSubmitChanges();
		}
	}

	internal void AddUnknownUser(UnknownUser user)
	{
		lock (_thisLock)
		{
			_unknownUserDB.UnknownUsers.InsertOnSubmit(user);
		}
		ChatOnService.Instance.UnknownUserItems.Add(user);
		UnknownUserDBSubmitChanges();
	}

	internal void AddRecommendee(UnknownUser user)
	{
		lock (_thisLock)
		{
			_recommendeeDB.Recommendee.InsertOnSubmit(user);
		}
		ChatOnService.Instance.RecommendeeItems.Add(user);
		RecommendeeDBSubmitChanges();
	}

	internal void AddBuddyGroup(BuddyGroup group)
	{
		lock (_thisLock)
		{
			_buddyGroupDB.Groups.InsertOnSubmit(group);
		}
		ChatOnService.Instance.GroupItems.Add(group);
		GroupDBSubmitChanges();
	}

	internal void AddAniconPackage(OfflineAniconPackage package)
	{
		lock (_thisLock)
		{
			_aniconDB.Packages.InsertOnSubmit(package);
		}
		ChatOnService.Instance.AniconPackages.Add(package);
		foreach (Anicon anicon in package.AniconList)
		{
			ChatOnService.Instance.Anicons.Add(anicon);
		}
		AniconDBSubmitChanges();
	}

	internal void AddMessage(Message msg)
	{
		lock (_thisLock)
		{
			_messageDB.Messages.InsertOnSubmit(msg);
		}
		lock (_messageItemsLock)
		{
			ChatOnService.Instance.MessageItems.Add(msg);
		}
	}

	internal void AddInteraction(InteractionRank interaction)
	{
		lock (_thisLock)
		{
			_interactionRankDb.InteractionRanks.InsertOnSubmit(interaction);
		}
		lock (_messageItemsLock)
		{
			ChatOnService.Instance.InteractionRanks.Add(interaction);
		}
	}

	internal void DeleteInteraction(InteractionRank interaction)
	{
		try
		{
			ChatOnService.Instance.InteractionRanks.Remove(interaction);
			lock (_thisLock)
			{
				_interactionRankDb.InteractionRanks.DeleteOnSubmit(interaction);
			}
			InteractionRankDBSubmitChanges();
		}
		catch
		{
		}
	}

	internal void DeleteMessage(Message msg, bool isSubmit = true)
	{
		lock (_messageItemsLock)
		{
			ChatOnService.Instance.MessageItems.Remove(msg);
		}
		lock (_thisLock)
		{
			_messageDB.Messages.DeleteOnSubmit(msg);
		}
		if (isSubmit)
		{
			MessageDBSubmitChanges();
		}
	}

	internal void DeleteChat(Chat chat)
	{
		ChatOnService.Instance.ChatItems.Remove(chat);
		lock (_thisLock)
		{
			_chatDB.Chats.DeleteOnSubmit(chat);
		}
		lock (_thisLock)
		{
			for (int num = _messageDB.Messages.DataList.Count() - 1; num >= 0; num--)
			{
				Message message = _messageDB.Messages.DataList.ElementAt(num) as Message;
				if (message.Chat == chat)
				{
					ChatOnService.Instance.MessageItems.Remove(message);
					_messageDB.Messages.DeleteOnSubmit(message);
				}
			}
		}
		MessageDBSubmitChanges();
		ChatDBSubmitChanges();
	}

	internal void DeleteBuddy(Buddy buddy)
	{
		ChatOnService.Instance.BuddyItems.Remove(buddy);
		lock (_thisLock)
		{
			_buddyDB.Buddies.DeleteOnSubmit(buddy);
		}
		BuddyDBSubmitChanges();
	}

	internal void DeleteUnknownUser(UnknownUser unknown)
	{
		ChatOnService.Instance.UnknownUserItems.Remove(unknown);
		lock (_thisLock)
		{
			_unknownUserDB.UnknownUsers.DeleteOnSubmit(unknown);
		}
	}

	internal void DeleteRecommendee(UnknownUser recommendee)
	{
		ChatOnService.Instance.RecommendeeItems.Remove(recommendee);
		lock (_thisLock)
		{
			_recommendeeDB.Recommendee.DeleteOnSubmit(recommendee);
		}
		RecommendeeDBSubmitChanges();
	}

	internal void DeleteGroup(BuddyGroup group)
	{
		ChatOnService.Instance.GroupItems.Remove(group);
		lock (_thisLock)
		{
			_buddyGroupDB.Groups.DeleteOnSubmit(group);
		}
		GroupDBSubmitChanges();
	}

	internal void DeleteAnicon(OfflineAniconPackage anicon)
	{
		try
		{
			anicon.Delete();
			ChatOnService.Instance.AniconPackages.Remove(anicon);
			lock (_thisLock)
			{
				_aniconDB.Packages.DeleteOnSubmit(anicon);
			}
			AniconDBSubmitChanges();
		}
		catch
		{
		}
	}

	internal void SortChatItems()
	{
		ChatOnService.Instance.ChatItems.Sort(delegate(Chat c2, Chat c1)
		{
			int num = 0;
			if (c1 == null || c2 == null)
			{
				return 0;
			}
			if (!c1.DisplayDate.HasValue && !c2.DisplayDate.HasValue)
			{
				if (c2.Date > c1.Date)
				{
					return -1;
				}
				if (c2.Date < c1.Date)
				{
					return 1;
				}
				return 0;
			}
			if (!c2.DisplayDate.HasValue)
			{
				return c1.DisplayDate.HasValue ? 1 : 0;
			}
			return (!c1.DisplayDate.HasValue) ? (-1) : c1.DisplayDate.Value.CompareTo(c2.DisplayDate.Value);
		});
	}

	internal void SortShowingChatItems(ref ObservableCollection<Chat> chatItems)
	{
		try
		{
			int num;
			do
			{
				num = 0;
				for (num = chatItems.Count() - 1; num >= 0; num--)
				{
					if (ChatOnService.Instance.ChatItems[num].ChatID != chatItems[num].ChatID)
					{
						chatItems.Remove(ChatOnService.Instance.ChatItems[num]);
						chatItems.Insert(num, ChatOnService.Instance.ChatItems[num]);
						break;
					}
				}
			}
			while (num > 0);
		}
		catch (Exception)
		{
		}
	}

	internal List<TrunkItem> SelectTrunkItemList(string ID)
	{
		List<TrunkItem> list = new List<TrunkItem>();
		foreach (TrunkItem trunkItem in ChatOnService.Instance.TrunkItems)
		{
			if (trunkItem.SessionID == ID)
			{
				list.Add(trunkItem);
			}
		}
		return list;
	}

	internal List<TrunkComment> SelectTrunkCommentList(string ID)
	{
		List<TrunkComment> list = new List<TrunkComment>();
		foreach (TrunkComment trunkComment in ChatOnService.Instance.TrunkComments)
		{
			if (trunkComment.ItemId == ID)
			{
				list.Add(trunkComment);
			}
		}
		return list;
	}
}
