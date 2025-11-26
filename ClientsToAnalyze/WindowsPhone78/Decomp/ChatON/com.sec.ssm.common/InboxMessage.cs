using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class InboxMessage : GeneratedMessage<InboxMessage, InboxMessage.Builder>
{
	public sealed class Builder : GeneratedBuilder<InboxMessage, Builder>
	{
		private InboxMessage result = new InboxMessage();

		protected override Builder ThisBuilder => this;

		protected override InboxMessage MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override InboxMessage DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<string> ReceiversList => result.receivers_;

		public int ReceiversCount => result.ReceiversCount;

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

		public bool HasSentTime => result.HasSentTime;

		public long SentTime
		{
			get
			{
				return result.SentTime;
			}
			set
			{
				SetSentTime(value);
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

		public override Builder Clear()
		{
			result = new InboxMessage();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override InboxMessage BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.receivers_.MakeReadOnly();
			InboxMessage inboxMessage = result;
			result = null;
			return inboxMessage;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is InboxMessage)
			{
				return MergeFrom((InboxMessage)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(InboxMessage other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.receivers_.Count != 0)
			{
				AddRange(other.receivers_, result.receivers_);
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasChatMsg)
			{
				ChatMsg = other.ChatMsg;
			}
			if (other.HasSentTime)
			{
				SentTime = other.SentTime;
			}
			if (other.HasMsgType)
			{
				MsgType = other.MsgType;
			}
			if (other.HasChatType)
			{
				ChatType = other.ChatType;
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
				case 10u:
					Sender = input.ReadString();
					continue;
				case 18u:
					AddReceivers(input.ReadString());
					continue;
				case 24u:
					MsgID = input.ReadInt64();
					continue;
				case 34u:
					ChatMsg = input.ReadString();
					continue;
				case 40u:
					SentTime = input.ReadInt64();
					continue;
				case 48u:
				{
					int num3 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(MsgType), num3))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(6, (ulong)num3);
					}
					else
					{
						MsgType = (MsgType)num3;
					}
					continue;
				}
				case 56u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(ChatType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(7, (ulong)num2);
					}
					else
					{
						ChatType = (ChatType)num2;
					}
					continue;
				}
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

		public string GetReceivers(int index)
		{
			return result.GetReceivers(index);
		}

		public Builder SetReceivers(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receivers_[index] = value;
			return this;
		}

		public Builder AddReceivers(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receivers_.Add(value);
			return this;
		}

		public Builder AddRangeReceivers(IEnumerable<string> values)
		{
			AddRange(values, result.receivers_);
			return this;
		}

		public Builder ClearReceivers()
		{
			result.receivers_.Clear();
			return this;
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

		public Builder SetSentTime(long value)
		{
			result.hasSentTime = true;
			result.sentTime_ = value;
			return this;
		}

		public Builder ClearSentTime()
		{
			result.hasSentTime = false;
			result.sentTime_ = 0L;
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
	}

	public const int SenderFieldNumber = 1;

	public const int ReceiversFieldNumber = 2;

	public const int MsgIDFieldNumber = 3;

	public const int ChatMsgFieldNumber = 4;

	public const int SentTimeFieldNumber = 5;

	public const int MsgTypeFieldNumber = 6;

	public const int ChatTypeFieldNumber = 7;

	private static readonly InboxMessage defaultInstance;

	private bool hasSender;

	private string sender_ = "";

	private PopsicleList<string> receivers_ = new PopsicleList<string>();

	private bool hasMsgID;

	private long msgID_;

	private bool hasChatMsg;

	private string chatMsg_ = "";

	private bool hasSentTime;

	private long sentTime_;

	private bool hasMsgType;

	private MsgType msgType_;

	private bool hasChatType;

	private ChatType chatType_;

	private int memoizedSerializedSize = -1;

	public static InboxMessage DefaultInstance => defaultInstance;

	public override InboxMessage DefaultInstanceForType => defaultInstance;

	protected override InboxMessage ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_InboxMessage__Descriptor;

	protected override FieldAccessorTable<InboxMessage, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_InboxMessage__FieldAccessorTable;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public IList<string> ReceiversList => Lists.AsReadOnly(receivers_);

	public int ReceiversCount => receivers_.Count;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasChatMsg => hasChatMsg;

	public string ChatMsg => chatMsg_;

	public bool HasSentTime => hasSentTime;

	public long SentTime => sentTime_;

	public bool HasMsgType => hasMsgType;

	public MsgType MsgType => msgType_;

	public bool HasChatType => hasChatType;

	public ChatType ChatType => chatType_;

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
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(1, Sender);
			}
			int num2 = 0;
			foreach (string receivers in ReceiversList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(receivers);
			}
			num += num2;
			num += receivers_.Count;
			if (HasMsgID)
			{
				num += CodedOutputStream.ComputeInt64Size(3, MsgID);
			}
			if (HasChatMsg)
			{
				num += CodedOutputStream.ComputeStringSize(4, ChatMsg);
			}
			if (HasSentTime)
			{
				num += CodedOutputStream.ComputeInt64Size(5, SentTime);
			}
			if (HasMsgType)
			{
				num += CodedOutputStream.ComputeEnumSize(6, (int)MsgType);
			}
			if (HasChatType)
			{
				num += CodedOutputStream.ComputeEnumSize(7, (int)ChatType);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetReceivers(int index)
	{
		return receivers_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasSender)
		{
			output.WriteString(1, Sender);
		}
		if (receivers_.Count > 0)
		{
			foreach (string item in receivers_)
			{
				output.WriteString(2, item);
			}
		}
		if (HasMsgID)
		{
			output.WriteInt64(3, MsgID);
		}
		if (HasChatMsg)
		{
			output.WriteString(4, ChatMsg);
		}
		if (HasSentTime)
		{
			output.WriteInt64(5, SentTime);
		}
		if (HasMsgType)
		{
			output.WriteEnum(6, (int)MsgType);
		}
		if (HasChatType)
		{
			output.WriteEnum(7, (int)ChatType);
		}
		UnknownFields.WriteTo(output);
	}

	public static InboxMessage ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InboxMessage ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InboxMessage ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InboxMessage ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InboxMessage ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InboxMessage ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static InboxMessage ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static InboxMessage ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static InboxMessage ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InboxMessage ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(InboxMessage prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static InboxMessage()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
