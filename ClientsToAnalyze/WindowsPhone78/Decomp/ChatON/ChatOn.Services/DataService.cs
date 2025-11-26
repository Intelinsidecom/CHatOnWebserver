using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data.Linq;
using System.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;

namespace ChatOn.Services;

public class DataService
{
	private ContactDataContext _contactDB;

	private BuddyDataContext _buddyDB;

	private ChatDataContext _chatDB;

	private MessageDataContext _messageDB;

	private TrunkDataContext _trunkDB;

	private TrunkCommentDataContext _trunkCommentDB;

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

	public IEnumerable<BuddyGroup> BuddyGroups => ChatOnService.Instance.GroupItems;

	public IEnumerable<TrunkItem> TrunkItems => ChatOnService.Instance.TrunkItems;

	public IEnumerable<TrunkComment> TrunkComments => ChatOnService.Instance.TrunkComments;

	internal DataService()
	{
		_buddyDB = ChatOnService.Instance.BuddyDB;
		_messageDB = ChatOnService.Instance.MessageDB;
		_chatDB = ChatOnService.Instance.ChatDB;
		_contactDB = ChatOnService.Instance.ContactDB;
		_trunkDB = ChatOnService.Instance.TrunkDB;
		_trunkCommentDB = ChatOnService.Instance.TrunkCommentDB;
	}

	internal Message FirstOrDefaultMessage(Func<Message, bool> predicate)
	{
		lock (_messageItemsLock)
		{
			return ChatOnService.Instance.MessageItems.FirstOrDefault(predicate);
		}
	}

	internal void ChatDBSubmitChanges()
	{
		long ticks = DateTime.UtcNow.Ticks;
		lock (_thisLock)
		{
			try
			{
				((DataContext)_chatDB).SubmitChanges();
			}
			catch (Exception)
			{
			}
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	internal void MessageDBSubmitChanges()
	{
		long ticks = DateTime.UtcNow.Ticks;
		lock (_thisLock)
		{
			try
			{
				((DataContext)_messageDB).SubmitChanges();
			}
			catch (Exception)
			{
			}
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	internal void SubmitChanges()
	{
		long ticks = DateTime.UtcNow.Ticks;
		lock (_thisLock)
		{
			try
			{
				((DataContext)_buddyDB).SubmitChanges();
				((DataContext)_messageDB).SubmitChanges();
				((DataContext)_contactDB).SubmitChanges();
				((DataContext)_chatDB).SubmitChanges();
				((DataContext)_trunkDB).SubmitChanges();
				((DataContext)_trunkCommentDB).SubmitChanges();
			}
			catch (Exception)
			{
			}
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	internal void LoadAll()
	{
		try
		{
			NotificationObject.IsBlockChangingNotification = true;
			NotificationObject.IsBlockChangedNotification = true;
			LoadBuddyList();
			LoadContactList();
			LoadUnknownUserList();
			LoadGroupList();
			LoadMessageList();
			LoadChatList();
			NotificationObject.IsBlockChangingNotification = false;
			NotificationObject.IsBlockChangedNotification = false;
		}
		catch (Exception)
		{
			ChatOnService.Instance.DeleteDatabase(dispose: false);
			ChatOnService.Instance.CreateDatabase();
			ChatOnService.Instance.BuddyItems = new ObservableCollection<Buddy>();
			ChatOnService.Instance.ContactItems = new List<MyContact>();
			ChatOnService.Instance.UnknownUserItems = new List<UnknownUser>();
			ChatOnService.Instance.GroupItems = new List<BuddyGroup>();
			ChatOnService.Instance.MessageItems = new List<Message>();
			ChatOnService.Instance.ChatItems = new ObservableCollection<Chat>();
		}
	}

	internal void LoadTrunk()
	{
		try
		{
			NotificationObject.IsBlockChangingNotification = true;
			NotificationObject.IsBlockChangedNotification = true;
			LoadTrunkItemList();
			LoadTrunkComment();
			NotificationObject.IsBlockChangingNotification = false;
			NotificationObject.IsBlockChangedNotification = false;
		}
		catch (Exception)
		{
		}
	}

	internal bool isLoadTrunk()
	{
		try
		{
			ChatOnService.Instance.TrunkItems.Count();
			return true;
		}
		catch (Exception)
		{
			return false;
		}
	}

	internal void resetTrunkList(string ID)
	{
		List<TrunkItem> list = new List<TrunkItem>();
		foreach (TrunkItem trunkItem in ChatOnService.Instance.TrunkItems)
		{
			list.Add(trunkItem);
		}
		foreach (TrunkItem item in list)
		{
			if (item.SessionID == ID)
			{
				DeleteTrunkItem(item);
			}
		}
	}

	internal void resetTrunkComment(string ID)
	{
		List<TrunkComment> list = new List<TrunkComment>();
		foreach (TrunkComment trunkComment in ChatOnService.Instance.TrunkComments)
		{
			list.Add(trunkComment);
		}
		foreach (TrunkComment item in list)
		{
			if (item.ItemId == ID)
			{
				DeleteTrunkComment(item);
			}
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

	private void LoadChatList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.ChatItems = new ObservableCollection<Chat>();
		IQueryable<Chat> queryable = ((IQueryable<Chat>)_chatDB.Chats).Select((Chat n) => n);
		SSMService ssmService = new SSMService();
		BuddyService buddyService = new BuddyService(this, ssmService);
		ChatService chatService = new ChatService(this, buddyService, RegistrationService.GetUserNumber());
		foreach (Chat item in queryable)
		{
			ChatOnService.Instance.ChatItems.Add(item);
			foreach (Message messageItem in ChatOnService.Instance.MessageItems)
			{
				if (messageItem.ChatID == item.ChatID)
				{
					chatService.AddMessage(item, messageItem);
					messageItem.Chat = item;
					if (messageItem.ActivityState == Message.State.Typed)
					{
						messageItem.ActivityState = Message.State.SendingFailed;
					}
				}
			}
			chatService.LoadAnsInfo(item);
			chatService.SortAllMessages(item);
			chatService.GetLastMessage(item);
			item.LoadMemberList();
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void LoadBuddyList()
	{
		ChatOnService.Instance.BuddyItems = new ObservableCollection<Buddy>();
		IQueryable<Buddy> queryable = ((IQueryable<Buddy>)_buddyDB.Buddies).Select((Buddy n) => n);
		foreach (Buddy item in queryable)
		{
			ChatOnService.Instance.BuddyItems.Add(item);
		}
	}

	private void LoadMessageList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.MessageItems = new List<Message>();
		IQueryable<Message> queryable = ((IQueryable<Message>)_messageDB.Messages).Select((Message n) => n);
		foreach (Message item in queryable)
		{
			ChatOnService.Instance.MessageItems.Add(item);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void LoadContactList()
	{
		ChatOnService.Instance.ContactItems = new List<MyContact>();
		IQueryable<MyContact> queryable = ((IQueryable<MyContact>)_contactDB.Contacts).Select((MyContact n) => n);
		foreach (MyContact item in queryable)
		{
			ChatOnService.Instance.ContactItems.Add(item);
		}
	}

	private void LoadUnknownUserList()
	{
		ChatOnService.Instance.UnknownUserItems = new List<UnknownUser>();
		foreach (UnknownUser unknownUser in _buddyDB.UnknownUsers)
		{
			ChatOnService.Instance.UnknownUserItems.Add(unknownUser);
		}
	}

	private void LoadGroupList()
	{
		ChatOnService.Instance.GroupItems = new List<BuddyGroup>();
		foreach (BuddyGroup group in _buddyDB.Groups)
		{
			ChatOnService.Instance.GroupItems.Add(group);
		}
	}

	private void LoadTrunkItemList()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.TrunkItems = new List<TrunkItem>();
		IQueryable<TrunkItem> queryable = ((IQueryable<TrunkItem>)_trunkDB.TrunkItem).Select((TrunkItem n) => n);
		foreach (TrunkItem item in queryable)
		{
			ChatOnService.Instance.TrunkItems.Add(item);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void LoadTrunkComment()
	{
		long ticks = DateTime.UtcNow.Ticks;
		ChatOnService.Instance.TrunkComments = new List<TrunkComment>();
		IQueryable<TrunkComment> queryable = ((IQueryable<TrunkComment>)_trunkCommentDB.TrunkComment).Select((TrunkComment n) => n);
		foreach (TrunkComment item in queryable)
		{
			ChatOnService.Instance.TrunkComments.Add(item);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	internal Chat GetChat(Guid chatID)
	{
		return ChatOnService.Instance.ChatItems.FirstOrDefault((Chat c) => c.ChatID == chatID);
	}

	internal Message GetMessage(Guid id)
	{
		return ((IQueryable<Message>)_messageDB.Messages).FirstOrDefault((Message c) => c.MessageID == id);
	}

	internal TrunkItem GetTrunkItem(string itemID)
	{
		return ChatOnService.Instance.TrunkItems.FirstOrDefault((TrunkItem c) => c.TrunkItemID == itemID);
	}

	internal TrunkComment GetTrunkComment(string cID)
	{
		return ChatOnService.Instance.TrunkComments.FirstOrDefault((TrunkComment c) => c.Cid == cID);
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
			SubmitChanges();
		}
	}

	internal void AddChat(Chat newChat)
	{
		lock (_thisLock)
		{
			_chatDB.Chats.InsertOnSubmit(newChat);
		}
		ChatOnService.Instance.ChatItems.Add(newChat);
		SubmitChanges();
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
			SubmitChanges();
		}
	}

	internal void AddUnknownUser(UnknownUser user)
	{
		lock (_thisLock)
		{
			_buddyDB.UnknownUsers.InsertOnSubmit(user);
		}
		ChatOnService.Instance.UnknownUserItems.Add(user);
		SubmitChanges();
	}

	internal void AddBuddyGroup(BuddyGroup group)
	{
		lock (_thisLock)
		{
			_buddyDB.Groups.InsertOnSubmit(group);
		}
		ChatOnService.Instance.GroupItems.Add(group);
		SubmitChanges();
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

	internal void AddTrunkItem(TrunkItem trunk)
	{
		lock (_thisLock)
		{
			_trunkDB.TrunkItem.InsertOnSubmit(trunk);
		}
		ChatOnService.Instance.TrunkItems.Add(trunk);
		SubmitChanges();
	}

	internal void AddTrunkComment(TrunkComment comment)
	{
		lock (_thisLock)
		{
			_trunkCommentDB.TrunkComment.InsertOnSubmit(comment);
		}
		ChatOnService.Instance.TrunkComments.Add(comment);
		SubmitChanges();
	}

	internal void UpdateTrunkItem(TrunkItem trunk)
	{
		TrunkItem trunkItem = ((IQueryable<TrunkItem>)_trunkDB.TrunkItem).Where((TrunkItem p) => p.TrunkItemID == trunk.TrunkItemID).SingleOrDefault();
		if (trunkItem != null)
		{
			trunkItem.Totcmtcnt = trunk.Totcmtcnt;
			SubmitChanges();
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
		NotificationObject.IsBlockChangedNotification = true;
		NotificationObject.IsBlockChangingNotification = true;
		lock (_thisLock)
		{
			foreach (Message message in _messageDB.Messages)
			{
				if (message.Chat == chat)
				{
					ChatOnService.Instance.MessageItems.Remove(message);
					_messageDB.Messages.DeleteOnSubmit(message);
				}
			}
		}
		NotificationObject.IsBlockChangedNotification = false;
		NotificationObject.IsBlockChangingNotification = false;
		SubmitChanges();
	}

	internal void DeleteBuddy(Buddy buddy)
	{
		ChatOnService.Instance.BuddyItems.Remove(buddy);
		lock (_thisLock)
		{
			_buddyDB.Buddies.DeleteOnSubmit(buddy);
		}
		SubmitChanges();
	}

	internal void DeleteContact(MyContact contact)
	{
		ChatOnService.Instance.ContactItems.Remove(contact);
		lock (_thisLock)
		{
			_contactDB.Contacts.DeleteOnSubmit(contact);
		}
	}

	internal void DeleteUnknownUser(UnknownUser unknown)
	{
		ChatOnService.Instance.UnknownUserItems.Remove(unknown);
		lock (_thisLock)
		{
			_buddyDB.UnknownUsers.DeleteOnSubmit(unknown);
		}
	}

	internal void DeleteGroup(BuddyGroup group)
	{
		ChatOnService.Instance.GroupItems.Remove(group);
		lock (_thisLock)
		{
			_buddyDB.Groups.DeleteOnSubmit(group);
		}
		SubmitChanges();
	}

	internal void DeleteTrunkItem(TrunkItem item)
	{
		ChatOnService.Instance.TrunkItems.Remove(item);
		lock (_thisLock)
		{
			_trunkDB.TrunkItem.DeleteOnSubmit(item);
		}
		SubmitChanges();
	}

	internal void DeleteTrunkComment(TrunkComment comment)
	{
		ChatOnService.Instance.TrunkComments.Remove(comment);
		lock (_thisLock)
		{
			_trunkCommentDB.TrunkComment.DeleteOnSubmit(comment);
		}
		SubmitChanges();
	}
}
