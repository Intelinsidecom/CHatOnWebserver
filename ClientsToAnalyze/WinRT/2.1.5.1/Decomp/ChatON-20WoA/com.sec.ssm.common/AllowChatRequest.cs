using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class AllowChatRequest : GeneratedMessage<AllowChatRequest, AllowChatRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<AllowChatRequest, Builder>
	{
		private AllowChatRequest result = new AllowChatRequest();

		protected override Builder ThisBuilder => this;

		protected override AllowChatRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override AllowChatRequest DefaultInstanceForType => DefaultInstance;

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

		public bool HasReceiver => result.HasReceiver;

		public string Receiver
		{
			get
			{
				return result.Receiver;
			}
			set
			{
				SetReceiver(value);
			}
		}

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

		public bool HasMaxMessageCount => result.HasMaxMessageCount;

		public int MaxMessageCount
		{
			get
			{
				return result.MaxMessageCount;
			}
			set
			{
				SetMaxMessageCount(value);
			}
		}

		public bool HasLastMessageTimestamp => result.HasLastMessageTimestamp;

		public long LastMessageTimestamp
		{
			get
			{
				return result.LastMessageTimestamp;
			}
			set
			{
				SetLastMessageTimestamp(value);
			}
		}

		public bool HasLastSessionMergeTimestamp => result.HasLastSessionMergeTimestamp;

		public long LastSessionMergeTimestamp
		{
			get
			{
				return result.LastSessionMergeTimestamp;
			}
			set
			{
				SetLastSessionMergeTimestamp(value);
			}
		}

		public override Builder Clear()
		{
			result = new AllowChatRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override AllowChatRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			AllowChatRequest allowChatRequest = result;
			result = null;
			return allowChatRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is AllowChatRequest)
			{
				return MergeFrom((AllowChatRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(AllowChatRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
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
			if (other.HasReceiver)
			{
				Receiver = other.Receiver;
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.HasIMEI)
			{
				IMEI = other.IMEI;
			}
			if (other.HasMaxMessageCount)
			{
				MaxMessageCount = other.MaxMessageCount;
			}
			if (other.HasLastMessageTimestamp)
			{
				LastMessageTimestamp = other.LastMessageTimestamp;
			}
			if (other.HasLastSessionMergeTimestamp)
			{
				LastSessionMergeTimestamp = other.LastSessionMergeTimestamp;
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
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(ChatType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(2, (ulong)num2);
					}
					else
					{
						ChatType = (ChatType)num2;
					}
					continue;
				}
				case 26u:
					SessionID = input.ReadString();
					continue;
				case 34u:
					Sender = input.ReadString();
					continue;
				case 42u:
					Receiver = input.ReadString();
					continue;
				case 50u:
					UID = input.ReadString();
					continue;
				case 58u:
					IMEI = input.ReadString();
					continue;
				case 64u:
					MaxMessageCount = input.ReadInt32();
					continue;
				case 72u:
					LastMessageTimestamp = input.ReadInt64();
					continue;
				case 80u:
					LastSessionMergeTimestamp = input.ReadInt64();
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

		public Builder SetReceiver(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasReceiver = true;
			result.receiver_ = value;
			return this;
		}

		public Builder ClearReceiver()
		{
			result.hasReceiver = false;
			result.receiver_ = "";
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

		public Builder SetMaxMessageCount(int value)
		{
			result.hasMaxMessageCount = true;
			result.maxMessageCount_ = value;
			return this;
		}

		public Builder ClearMaxMessageCount()
		{
			result.hasMaxMessageCount = false;
			result.maxMessageCount_ = 0;
			return this;
		}

		public Builder SetLastMessageTimestamp(long value)
		{
			result.hasLastMessageTimestamp = true;
			result.lastMessageTimestamp_ = value;
			return this;
		}

		public Builder ClearLastMessageTimestamp()
		{
			result.hasLastMessageTimestamp = false;
			result.lastMessageTimestamp_ = 0L;
			return this;
		}

		public Builder SetLastSessionMergeTimestamp(long value)
		{
			result.hasLastSessionMergeTimestamp = true;
			result.lastSessionMergeTimestamp_ = value;
			return this;
		}

		public Builder ClearLastSessionMergeTimestamp()
		{
			result.hasLastSessionMergeTimestamp = false;
			result.lastSessionMergeTimestamp_ = 0L;
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int ChatTypeFieldNumber = 2;

	public const int SessionIDFieldNumber = 3;

	public const int SenderFieldNumber = 4;

	public const int ReceiverFieldNumber = 5;

	public const int UIDFieldNumber = 6;

	public const int IMEIFieldNumber = 7;

	public const int MaxMessageCountFieldNumber = 8;

	public const int LastMessageTimestampFieldNumber = 9;

	public const int LastSessionMergeTimestampFieldNumber = 10;

	private static readonly AllowChatRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasChatType;

	private ChatType chatType_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private bool hasSender;

	private string sender_ = "";

	private bool hasReceiver;

	private string receiver_ = "";

	private bool hasUID;

	private string uID_ = "";

	private bool hasIMEI;

	private string iMEI_ = "";

	private bool hasMaxMessageCount;

	private int maxMessageCount_;

	private bool hasLastMessageTimestamp;

	private long lastMessageTimestamp_;

	private bool hasLastSessionMergeTimestamp;

	private long lastSessionMergeTimestamp_;

	private int memoizedSerializedSize = -1;

	public static AllowChatRequest DefaultInstance => defaultInstance;

	public override AllowChatRequest DefaultInstanceForType => defaultInstance;

	protected override AllowChatRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_AllowChatRequest__Descriptor;

	protected override FieldAccessorTable<AllowChatRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_AllowChatRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasChatType => hasChatType;

	public ChatType ChatType => chatType_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public bool HasReceiver => hasReceiver;

	public string Receiver => receiver_;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public bool HasIMEI => hasIMEI;

	public string IMEI => iMEI_;

	public bool HasMaxMessageCount => hasMaxMessageCount;

	public int MaxMessageCount => maxMessageCount_;

	public bool HasLastMessageTimestamp => hasLastMessageTimestamp;

	public long LastMessageTimestamp => lastMessageTimestamp_;

	public bool HasLastSessionMergeTimestamp => hasLastSessionMergeTimestamp;

	public long LastSessionMergeTimestamp => lastSessionMergeTimestamp_;

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
			if (HasChatType)
			{
				num += CodedOutputStream.ComputeEnumSize(2, (int)ChatType);
			}
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(3, SessionID);
			}
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(4, Sender);
			}
			if (HasReceiver)
			{
				num += CodedOutputStream.ComputeStringSize(5, Receiver);
			}
			if (HasUID)
			{
				num += CodedOutputStream.ComputeStringSize(6, UID);
			}
			if (HasIMEI)
			{
				num += CodedOutputStream.ComputeStringSize(7, IMEI);
			}
			if (HasMaxMessageCount)
			{
				num += CodedOutputStream.ComputeInt32Size(8, MaxMessageCount);
			}
			if (HasLastMessageTimestamp)
			{
				num += CodedOutputStream.ComputeInt64Size(9, LastMessageTimestamp);
			}
			if (HasLastSessionMergeTimestamp)
			{
				num += CodedOutputStream.ComputeInt64Size(10, LastSessionMergeTimestamp);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (HasChatType)
		{
			output.WriteEnum(2, (int)ChatType);
		}
		if (HasSessionID)
		{
			output.WriteString(3, SessionID);
		}
		if (HasSender)
		{
			output.WriteString(4, Sender);
		}
		if (HasReceiver)
		{
			output.WriteString(5, Receiver);
		}
		if (HasUID)
		{
			output.WriteString(6, UID);
		}
		if (HasIMEI)
		{
			output.WriteString(7, IMEI);
		}
		if (HasMaxMessageCount)
		{
			output.WriteInt32(8, MaxMessageCount);
		}
		if (HasLastMessageTimestamp)
		{
			output.WriteInt64(9, LastMessageTimestamp);
		}
		if (HasLastSessionMergeTimestamp)
		{
			output.WriteInt64(10, LastSessionMergeTimestamp);
		}
		UnknownFields.WriteTo(output);
	}

	public static AllowChatRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AllowChatRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AllowChatRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AllowChatRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AllowChatRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AllowChatRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static AllowChatRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static AllowChatRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static AllowChatRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AllowChatRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(AllowChatRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static AllowChatRequest()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
