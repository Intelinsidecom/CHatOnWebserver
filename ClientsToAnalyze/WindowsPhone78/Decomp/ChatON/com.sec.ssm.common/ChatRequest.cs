using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class ChatRequest : GeneratedMessage<ChatRequest, ChatRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<ChatRequest, Builder>
	{
		private ChatRequest result = new ChatRequest();

		protected override Builder ThisBuilder => this;

		protected override ChatRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override ChatRequest DefaultInstanceForType => DefaultInstance;

		public bool HasMsgID => result.HasMsgID;

		public long MsgID
		{
			get
			{
				return result.MsgID;
			}
			set
			{
				SetMsgID(value);
			}
		}

		public bool HasMsgType => result.HasMsgType;

		public MsgType MsgType
		{
			get
			{
				return result.MsgType;
			}
			set
			{
				SetMsgType(value);
			}
		}

		public bool HasChatType => result.HasChatType;

		public ChatType ChatType
		{
			get
			{
				return result.ChatType;
			}
			set
			{
				SetChatType(value);
			}
		}

		public bool HasSessionID => result.HasSessionID;

		public string SessionID
		{
			get
			{
				return result.SessionID;
			}
			set
			{
				SetSessionID(value);
			}
		}

		public bool HasSender => result.HasSender;

		public string Sender
		{
			get
			{
				return result.Sender;
			}
			set
			{
				SetSender(value);
			}
		}

		public IPopsicleList<string> ReceiverList => result.receiver_;

		public int ReceiverCount => result.ReceiverCount;

		public bool HasUID => result.HasUID;

		public string UID
		{
			get
			{
				return result.UID;
			}
			set
			{
				SetUID(value);
			}
		}

		public bool HasIMEI => result.HasIMEI;

		public string IMEI
		{
			get
			{
				return result.IMEI;
			}
			set
			{
				SetIMEI(value);
			}
		}

		public bool HasChatMsg => result.HasChatMsg;

		public string ChatMsg
		{
			get
			{
				return result.ChatMsg;
			}
			set
			{
				SetChatMsg(value);
			}
		}

		public bool HasWhisperReceiver => result.HasWhisperReceiver;

		public string WhisperReceiver
		{
			get
			{
				return result.WhisperReceiver;
			}
			set
			{
				SetWhisperReceiver(value);
			}
		}

		public override Builder Clear()
		{
			result = new ChatRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override ChatRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.receiver_.MakeReadOnly();
			ChatRequest chatRequest = result;
			result = null;
			return chatRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is ChatRequest)
			{
				return MergeFrom((ChatRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(ChatRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasMsgType)
			{
				MsgType = other.MsgType;
			}
			if (other.HasChatType)
			{
				ChatType = other.ChatType;
			}
			if (other.HasSessionID)
			{
				SessionID = other.SessionID;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.receiver_.Count != 0)
			{
				AddRange(other.receiver_, result.receiver_);
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.HasIMEI)
			{
				IMEI = other.IMEI;
			}
			if (other.HasChatMsg)
			{
				ChatMsg = other.ChatMsg;
			}
			if (other.HasWhisperReceiver)
			{
				WhisperReceiver = other.WhisperReceiver;
			}
			MergeUnknownFields(other.UnknownFields);
			return this;
		}

		public override Builder MergeFrom(CodedInputStream input)
		{
			return MergeFrom(input, ExtensionRegistry.Empty);
		}

		public override Builder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
		{
			UnknownFieldSet.Builder builder = null;
			while (true)
			{
				uint num = input.ReadTag();
				switch (num)
				{
				case 0u:
					if (builder != null)
					{
						UnknownFields = builder.Build();
					}
					return this;
				case 8u:
					MsgID = input.ReadInt64();
					continue;
				case 16u:
				{
					int num3 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(MsgType), num3))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(2, (ulong)num3);
					}
					else
					{
						MsgType = (MsgType)num3;
					}
					continue;
				}
				case 24u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(ChatType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(3, (ulong)num2);
					}
					else
					{
						ChatType = (ChatType)num2;
					}
					continue;
				}
				case 34u:
					SessionID = input.ReadString();
					continue;
				case 42u:
					Sender = input.ReadString();
					continue;
				case 50u:
					AddReceiver(input.ReadString());
					continue;
				case 58u:
					UID = input.ReadString();
					continue;
				case 66u:
					IMEI = input.ReadString();
					continue;
				case 74u:
					ChatMsg = input.ReadString();
					continue;
				case 82u:
					WhisperReceiver = input.ReadString();
					continue;
				}
				if (WireFormat.IsEndGroupTag(num))
				{
					if (builder != null)
					{
						UnknownFields = builder.Build();
					}
					return this;
				}
				if (builder == null)
				{
					builder = UnknownFieldSet.CreateBuilder(UnknownFields);
				}
				ParseUnknownField(input, builder, extensionRegistry, num);
			}
		}

		public Builder SetMsgID(long value)
		{
			result.hasMsgID = true;
			result.msgID_ = value;
			return this;
		}

		public Builder ClearMsgID()
		{
			result.hasMsgID = false;
			result.msgID_ = 0L;
			return this;
		}

		public Builder SetMsgType(MsgType value)
		{
			result.hasMsgType = true;
			result.msgType_ = value;
			return this;
		}

		public Builder ClearMsgType()
		{
			result.hasMsgType = false;
			result.msgType_ = MsgType.TEXT;
			return this;
		}

		public Builder SetChatType(ChatType value)
		{
			result.hasChatType = true;
			result.chatType_ = value;
			return this;
		}

		public Builder ClearChatType()
		{
			result.hasChatType = false;
			result.chatType_ = ChatType.SINGLE;
			return this;
		}

		public Builder SetSessionID(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasSessionID = true;
			result.sessionID_ = value;
			return this;
		}

		public Builder ClearSessionID()
		{
			result.hasSessionID = false;
			result.sessionID_ = "";
			return this;
		}

		public Builder SetSender(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasSender = true;
			result.sender_ = value;
			return this;
		}

		public Builder ClearSender()
		{
			result.hasSender = false;
			result.sender_ = "";
			return this;
		}

		public string GetReceiver(int index)
		{
			return result.GetReceiver(index);
		}

		public Builder SetReceiver(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receiver_[index] = value;
			return this;
		}

		public Builder AddReceiver(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receiver_.Add(value);
			return this;
		}

		public Builder AddRangeReceiver(IEnumerable<string> values)
		{
			AddRange(values, result.receiver_);
			return this;
		}

		public Builder ClearReceiver()
		{
			result.receiver_.Clear();
			return this;
		}

		public Builder SetUID(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasUID = true;
			result.uID_ = value;
			return this;
		}

		public Builder ClearUID()
		{
			result.hasUID = false;
			result.uID_ = "";
			return this;
		}

		public Builder SetIMEI(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasIMEI = true;
			result.iMEI_ = value;
			return this;
		}

		public Builder ClearIMEI()
		{
			result.hasIMEI = false;
			result.iMEI_ = "";
			return this;
		}

		public Builder SetChatMsg(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasChatMsg = true;
			result.chatMsg_ = value;
			return this;
		}

		public Builder ClearChatMsg()
		{
			result.hasChatMsg = false;
			result.chatMsg_ = "";
			return this;
		}

		public Builder SetWhisperReceiver(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasWhisperReceiver = true;
			result.whisperReceiver_ = value;
			return this;
		}

		public Builder ClearWhisperReceiver()
		{
			result.hasWhisperReceiver = false;
			result.whisperReceiver_ = "";
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int MsgTypeFieldNumber = 2;

	public const int ChatTypeFieldNumber = 3;

	public const int SessionIDFieldNumber = 4;

	public const int SenderFieldNumber = 5;

	public const int ReceiverFieldNumber = 6;

	public const int UIDFieldNumber = 7;

	public const int IMEIFieldNumber = 8;

	public const int ChatMsgFieldNumber = 9;

	public const int WhisperReceiverFieldNumber = 10;

	private static readonly ChatRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasMsgType;

	private MsgType msgType_;

	private bool hasChatType;

	private ChatType chatType_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private bool hasSender;

	private string sender_ = "";

	private PopsicleList<string> receiver_ = new PopsicleList<string>();

	private bool hasUID;

	private string uID_ = "";

	private bool hasIMEI;

	private string iMEI_ = "";

	private bool hasChatMsg;

	private string chatMsg_ = "";

	private bool hasWhisperReceiver;

	private string whisperReceiver_ = "";

	private int memoizedSerializedSize = -1;

	public static ChatRequest DefaultInstance => defaultInstance;

	public override ChatRequest DefaultInstanceForType => defaultInstance;

	protected override ChatRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_ChatRequest__Descriptor;

	protected override FieldAccessorTable<ChatRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_ChatRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasMsgType => hasMsgType;

	public MsgType MsgType => msgType_;

	public bool HasChatType => hasChatType;

	public ChatType ChatType => chatType_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public IList<string> ReceiverList => Lists.AsReadOnly(receiver_);

	public int ReceiverCount => receiver_.Count;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public bool HasIMEI => hasIMEI;

	public string IMEI => iMEI_;

	public bool HasChatMsg => hasChatMsg;

	public string ChatMsg => chatMsg_;

	public bool HasWhisperReceiver => hasWhisperReceiver;

	public string WhisperReceiver => whisperReceiver_;

	public override bool IsInitialized => true;

	public override int SerializedSize
	{
		get
		{
			int num = memoizedSerializedSize;
			if (num != -1)
			{
				return num;
			}
			num = 0;
			if (HasMsgID)
			{
				num += CodedOutputStream.ComputeInt64Size(1, MsgID);
			}
			if (HasMsgType)
			{
				num += CodedOutputStream.ComputeEnumSize(2, (int)MsgType);
			}
			if (HasChatType)
			{
				num += CodedOutputStream.ComputeEnumSize(3, (int)ChatType);
			}
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(4, SessionID);
			}
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(5, Sender);
			}
			int num2 = 0;
			foreach (string receiver in ReceiverList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(receiver);
			}
			num += num2;
			num += receiver_.Count;
			if (HasUID)
			{
				num += CodedOutputStream.ComputeStringSize(7, UID);
			}
			if (HasIMEI)
			{
				num += CodedOutputStream.ComputeStringSize(8, IMEI);
			}
			if (HasChatMsg)
			{
				num += CodedOutputStream.ComputeStringSize(9, ChatMsg);
			}
			if (HasWhisperReceiver)
			{
				num += CodedOutputStream.ComputeStringSize(10, WhisperReceiver);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetReceiver(int index)
	{
		return receiver_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (HasMsgType)
		{
			output.WriteEnum(2, (int)MsgType);
		}
		if (HasChatType)
		{
			output.WriteEnum(3, (int)ChatType);
		}
		if (HasSessionID)
		{
			output.WriteString(4, SessionID);
		}
		if (HasSender)
		{
			output.WriteString(5, Sender);
		}
		if (receiver_.Count > 0)
		{
			foreach (string item in receiver_)
			{
				output.WriteString(6, item);
			}
		}
		if (HasUID)
		{
			output.WriteString(7, UID);
		}
		if (HasIMEI)
		{
			output.WriteString(8, IMEI);
		}
		if (HasChatMsg)
		{
			output.WriteString(9, ChatMsg);
		}
		if (HasWhisperReceiver)
		{
			output.WriteString(10, WhisperReceiver);
		}
		UnknownFields.WriteTo(output);
	}

	public static ChatRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ChatRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ChatRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ChatRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ChatRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ChatRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static ChatRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static ChatRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static ChatRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ChatRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static Builder CreateBuilder()
	{
		return new Builder();
	}

	public override Builder ToBuilder()
	{
		return CreateBuilder(this);
	}

	public override Builder CreateBuilderForType()
	{
		return new Builder();
	}

	public static Builder CreateBuilder(ChatRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static ChatRequest()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
