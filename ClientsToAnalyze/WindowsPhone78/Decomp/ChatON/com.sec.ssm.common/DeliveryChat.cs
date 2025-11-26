using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class DeliveryChat : GeneratedMessage<DeliveryChat, DeliveryChat.Builder>
{
	public sealed class Builder : GeneratedBuilder<DeliveryChat, Builder>
	{
		private DeliveryChat result = new DeliveryChat();

		protected override Builder ThisBuilder => this;

		protected override DeliveryChat MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override DeliveryChat DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<InboxMessage> InboxMessageList => result.inboxMessage_;

		public int InboxMessageCount => result.InboxMessageCount;

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

		public bool HasHasMoreResult => result.HasHasMoreResult;

		public bool HasMoreResult
		{
			get
			{
				return result.HasMoreResult;
			}
			set
			{
				SetHasMoreResult(value);
			}
		}

		public override Builder Clear()
		{
			result = new DeliveryChat();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override DeliveryChat BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.inboxMessage_.MakeReadOnly();
			DeliveryChat deliveryChat = result;
			result = null;
			return deliveryChat;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is DeliveryChat)
			{
				return MergeFrom((DeliveryChat)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(DeliveryChat other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasSessionID)
			{
				SessionID = other.SessionID;
			}
			if (other.HasChatType)
			{
				ChatType = other.ChatType;
			}
			if (other.inboxMessage_.Count != 0)
			{
				AddRange(other.inboxMessage_, result.inboxMessage_);
			}
			if (other.HasWhisperReceiver)
			{
				WhisperReceiver = other.WhisperReceiver;
			}
			if (other.HasHasMoreResult)
			{
				HasMoreResult = other.HasMoreResult;
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
					SessionID = input.ReadString();
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
				{
					InboxMessage.Builder builder2 = InboxMessage.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddInboxMessage(builder2.BuildPartial());
					continue;
				}
				case 34u:
					WhisperReceiver = input.ReadString();
					continue;
				case 40u:
					HasMoreResult = input.ReadBool();
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

		public InboxMessage GetInboxMessage(int index)
		{
			return result.GetInboxMessage(index);
		}

		public Builder SetInboxMessage(int index, InboxMessage value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.inboxMessage_[index] = value;
			return this;
		}

		public Builder SetInboxMessage(int index, InboxMessage.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.inboxMessage_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddInboxMessage(InboxMessage value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.inboxMessage_.Add(value);
			return this;
		}

		public Builder AddInboxMessage(InboxMessage.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.inboxMessage_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeInboxMessage(IEnumerable<InboxMessage> values)
		{
			AddRange(values, result.inboxMessage_);
			return this;
		}

		public Builder ClearInboxMessage()
		{
			result.inboxMessage_.Clear();
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

		public Builder SetHasMoreResult(bool value)
		{
			result.hasHasMoreResult = true;
			result.hasMoreResult_ = value;
			return this;
		}

		public Builder ClearHasMoreResult()
		{
			result.hasHasMoreResult = false;
			result.hasMoreResult_ = false;
			return this;
		}
	}

	public const int SessionIDFieldNumber = 1;

	public const int ChatTypeFieldNumber = 2;

	public const int InboxMessageFieldNumber = 3;

	public const int WhisperReceiverFieldNumber = 4;

	public const int HasMoreResultFieldNumber = 5;

	private static readonly DeliveryChat defaultInstance;

	private bool hasSessionID;

	private string sessionID_ = "";

	private bool hasChatType;

	private ChatType chatType_;

	private PopsicleList<InboxMessage> inboxMessage_ = new PopsicleList<InboxMessage>();

	private bool hasWhisperReceiver;

	private string whisperReceiver_ = "";

	private bool hasHasMoreResult;

	private bool hasMoreResult_;

	private int memoizedSerializedSize = -1;

	public static DeliveryChat DefaultInstance => defaultInstance;

	public override DeliveryChat DefaultInstanceForType => defaultInstance;

	protected override DeliveryChat ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_DeliveryChat__Descriptor;

	protected override FieldAccessorTable<DeliveryChat, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_DeliveryChat__FieldAccessorTable;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public bool HasChatType => hasChatType;

	public ChatType ChatType => chatType_;

	public IList<InboxMessage> InboxMessageList => inboxMessage_;

	public int InboxMessageCount => inboxMessage_.Count;

	public bool HasWhisperReceiver => hasWhisperReceiver;

	public string WhisperReceiver => whisperReceiver_;

	public bool HasHasMoreResult => hasHasMoreResult;

	public bool HasMoreResult => hasMoreResult_;

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
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(1, SessionID);
			}
			if (HasChatType)
			{
				num += CodedOutputStream.ComputeEnumSize(2, (int)ChatType);
			}
			foreach (InboxMessage inboxMessage in InboxMessageList)
			{
				num += CodedOutputStream.ComputeMessageSize(3, inboxMessage);
			}
			if (HasWhisperReceiver)
			{
				num += CodedOutputStream.ComputeStringSize(4, WhisperReceiver);
			}
			if (HasHasMoreResult)
			{
				num += CodedOutputStream.ComputeBoolSize(5, HasMoreResult);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public InboxMessage GetInboxMessage(int index)
	{
		return inboxMessage_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasSessionID)
		{
			output.WriteString(1, SessionID);
		}
		if (HasChatType)
		{
			output.WriteEnum(2, (int)ChatType);
		}
		foreach (InboxMessage inboxMessage in InboxMessageList)
		{
			output.WriteMessage(3, inboxMessage);
		}
		if (HasWhisperReceiver)
		{
			output.WriteString(4, WhisperReceiver);
		}
		if (HasHasMoreResult)
		{
			output.WriteBool(5, HasMoreResult);
		}
		UnknownFields.WriteTo(output);
	}

	public static DeliveryChat ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DeliveryChat ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DeliveryChat ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DeliveryChat ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DeliveryChat ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DeliveryChat ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static DeliveryChat ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static DeliveryChat ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static DeliveryChat ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DeliveryChat ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(DeliveryChat prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static DeliveryChat()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
