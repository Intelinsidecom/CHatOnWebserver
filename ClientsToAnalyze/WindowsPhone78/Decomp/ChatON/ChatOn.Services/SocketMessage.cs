using System;
using System.Collections.Generic;
using com.sec.ssm.common;

namespace ChatOn.Services;

public class SocketMessage
{
	public enum Type
	{
		InitChatRequest,
		InitChatReply,
		AllowChatRequest,
		AllowChatReply,
		ChatRequest,
		ChatReply,
		DeliveryChat,
		DeliveryChatReply,
		EndChatRequest,
		EndChatReply,
		AnswerBack,
		AnswerBackReply,
		InviteChatRequest,
		InviteChatReply,
		DisconnectRequest,
		DisconnectReply,
		AnnounceChange,
		AnnounceChangeReply,
		NickNameRequest,
		NickNameReply,
		WebProvisionRequest,
		WebProvisionReply,
		InvalidUserRequest,
		InvalidUserReply
	}

	public enum ResultCode
	{
		Success = 1000,
		Success_Receiver_is_Invalid = 1001,
		Session_id_not_exist = 3003,
		Session_user_not_exist = 3006,
		User_is_invalid = 4002,
		Receiver_is_alreay_blocked = 5009,
		Receiver_is_Invalid = 6002
	}

	public static long CreateMsgID()
	{
		return Utility.GetTimeStamp();
	}

	private static byte[] EncryptAndCombineHead(string key, string uid, byte type, byte[] body)
	{
		byte[] array = Utility.Encrypt(key, body);
		byte[] array2 = Utility.StrToByteArray(uid);
		ushort num = (ushort)array.Length;
		byte[] bytes = BitConverter.GetBytes(num);
		byte[] array3 = new byte[40 + num];
		array3[36] = 0;
		array3[37] = type;
		array3[38] = bytes[1];
		array3[39] = bytes[0];
		Buffer.BlockCopy(array2, 0, array3, 0, array2.Length);
		Buffer.BlockCopy(array, 0, array3, 40, num);
		return array3;
	}

	private static Result MakeResult(ResultCode code)
	{
		Result.Builder builder = new Result.Builder();
		builder.ResultCode = (int)code;
		builder.ResultMsg = code.ToString();
		return builder.Build();
	}

	public static byte[] InitChatRequestMsg(long msgID, string sender, string receiver, string uid, string imei, string body, string key, ChatType chatType, MsgType msgType)
	{
		InitChatRequest.Builder builder = new InitChatRequest.Builder();
		builder.MsgID = msgID;
		builder.MsgType = msgType;
		builder.ChatType = chatType;
		builder.Sender = sender;
		builder.UID = uid;
		builder.IMEI = imei;
		builder.ChatMsg = body;
		string[] array = Utility.Split(receiver);
		string[] array2 = array;
		foreach (string value in array2)
		{
			builder.AddReceiver(value);
		}
		InitChatRequest initChatRequest = builder.Build();
		return EncryptAndCombineHead(key, uid, 0, initChatRequest.ToByteArray());
	}

	public static string InitChatReplyMsg(byte[] replyMsg)
	{
		InitChatReply initChatReply = InitChatReply.CreateBuilder().MergeFrom(replyMsg).Build();
		return initChatReply.SessionID;
	}

	public static byte[] AllowChatRequestMsg(string sender, string receiver, string uid, string imei, string sessionID, string key, ChatType chatType)
	{
		string text = sessionID;
		if (string.IsNullOrEmpty(text))
		{
			text = Guid.NewGuid().ToString();
		}
		AllowChatRequest.Builder builder = new AllowChatRequest.Builder();
		builder.MsgID = CreateMsgID();
		builder.ChatType = chatType;
		builder.SessionID = text;
		builder.Sender = sender;
		builder.Receiver = receiver;
		builder.UID = uid;
		builder.IMEI = imei;
		AllowChatRequest allowChatRequest = builder.Build();
		return EncryptAndCombineHead(key, uid, 2, allowChatRequest.ToByteArray());
	}

	public static byte[] ChatRequestMsg(long msgID, string sender, string receiver, string uid, string imei, string body, string sessionID, string key, ChatType chatType, MsgType msgType)
	{
		ChatRequest.Builder builder = new ChatRequest.Builder();
		builder.MsgID = msgID;
		builder.MsgType = msgType;
		builder.ChatType = chatType;
		builder.SessionID = sessionID;
		builder.Sender = sender;
		builder.UID = uid;
		builder.IMEI = imei;
		builder.ChatMsg = body;
		string[] array = Utility.Split(receiver);
		string[] array2 = array;
		foreach (string value in array2)
		{
			builder.AddReceiver(value);
		}
		ChatRequest chatRequest = builder.Build();
		return EncryptAndCombineHead(key, uid, 4, chatRequest.ToByteArray());
	}

	public static string ChatReplyMsg(byte[] replyMsg)
	{
		ChatReply chatReply = ChatReply.CreateBuilder().MergeFrom(replyMsg).Build();
		return chatReply.Result.ToString();
	}

	public static byte[] DeliveryChatReplyMsg(string uid, string key)
	{
		DeliveryChatReply.Builder builder = new DeliveryChatReply.Builder();
		builder.UID = uid;
		builder.Result = MakeResult(ResultCode.Success);
		DeliveryChatReply deliveryChatReply = builder.Build();
		return EncryptAndCombineHead(key, uid, 7, deliveryChatReply.ToByteArray());
	}

	public static byte[] DeliveryChatReplyMsg(IList<InboxMessage> messages, string uid, string key, string myNumber)
	{
		DeliveryChatReply.Builder builder = new DeliveryChatReply.Builder();
		builder.UID = uid;
		builder.Result = MakeResult(ResultCode.Success);
		foreach (InboxMessage message in messages)
		{
			DeliveryChatReplyItem.Builder builder2 = new DeliveryChatReplyItem.Builder();
			builder2.Sender = message.Sender;
			builder2.Receiver = message.ReceiversList[0];
			builder2.MsgID = message.MsgID;
			builder2.MsgType = message.MsgType;
			DeliveryChatReplyItem value = builder2.Build();
			builder.AddDeliveryChatReplyItems(value);
		}
		DeliveryChatReply deliveryChatReply = builder.Build();
		return EncryptAndCombineHead(key, uid, 7, deliveryChatReply.ToByteArray());
	}

	public static byte[] AnswerBackReplyMsg(IList<AnswerbackItem> messages, string uid, string key, string receiver)
	{
		AnswerBackReply.Builder builder = new AnswerBackReply.Builder();
		builder.UID = uid;
		builder.Result = MakeResult(ResultCode.Success);
		foreach (AnswerbackItem message in messages)
		{
			AnswerbackItem.Builder builder2 = new AnswerbackItem.Builder();
			builder2.Receiver = message.Receiver;
			builder2.MsgID = message.MsgID;
			AnswerbackItem value = builder2.Build();
			builder.AddAnswerbackItems(value);
		}
		AnswerBackReply answerBackReply = builder.Build();
		return EncryptAndCombineHead(key, uid, 11, answerBackReply.ToByteArray());
	}

	public static byte[] InviteChatRequest(long msgid, string sessionid, string sender, List<string> orgMembers, List<string> invitingMembers, string key, string uid)
	{
		InviteChatRequest.Builder builder = new InviteChatRequest.Builder();
		builder.MsgID = msgid;
		builder.MsgType = MsgType.TEXT;
		builder.SessionID = sessionid;
		builder.Sender = sender;
		foreach (string orgMember in orgMembers)
		{
			builder.ReceiverList.Add(orgMember);
		}
		foreach (string invitingMember in invitingMembers)
		{
			builder.InvitingMembersList.Add(invitingMember);
		}
		InviteChatRequest inviteChatRequest = builder.Build();
		return EncryptAndCombineHead(key, uid, 12, inviteChatRequest.ToByteArray());
	}

	public static byte[] DisconnectReplyMsg(long msgId, string uid, string key)
	{
		DisconnectReply.Builder builder = new DisconnectReply.Builder();
		builder.MsgID = msgId;
		builder.DisconnectActionType = DisconnectActionType.CLOSE;
		builder.Result = MakeResult(ResultCode.Success);
		DisconnectReply disconnectReply = builder.Build();
		return EncryptAndCombineHead(key, uid, 15, disconnectReply.ToByteArray());
	}

	public static byte[] EndChatRequest(string sender, string receiver, string uid, string sessionID, string key, ChatType chatType)
	{
		EndChatRequest.Builder builder = new EndChatRequest.Builder();
		builder.MsgID = CreateMsgID();
		builder.ChatType = chatType;
		builder.SessionID = sessionID;
		builder.Sender = sender;
		builder.ReceiversList.Add(receiver);
		builder.UID = uid;
		EndChatRequest endChatRequest = builder.Build();
		return EncryptAndCombineHead(key, uid, 8, endChatRequest.ToByteArray());
	}

	public static byte[] AnnounceChangeReply(string uid, string key, long msgID)
	{
		AnnounceChangeReply.Builder builder = new AnnounceChangeReply.Builder();
		builder.MsgID = msgID;
		builder.Result = MakeResult(ResultCode.Success);
		AnnounceChangeReply announceChangeReply = builder.Build();
		return EncryptAndCombineHead(key, uid, 17, announceChangeReply.ToByteArray());
	}

	public static byte[] NickNameRequest(string uid, string key, string user)
	{
		NicknameRequest.Builder builder = new NicknameRequest.Builder();
		builder.MsgID = CreateMsgID();
		builder.UserList.Add(user);
		NicknameRequest nicknameRequest = builder.Build();
		return EncryptAndCombineHead(key, uid, 18, nicknameRequest.ToByteArray());
	}
}
