using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class DeliveryChatReplyItem : GeneratedMessage<DeliveryChatReplyItem, DeliveryChatReplyItem.Builder>
{
	public sealed class Builder : GeneratedBuilder<DeliveryChatReplyItem, Builder>
	{
		private DeliveryChatReplyItem result = new DeliveryChatReplyItem();

		protected override Builder ThisBuilder => this;

		protected override DeliveryChatReplyItem MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override DeliveryChatReplyItem DefaultInstanceForType => DefaultInstance;

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

		public override Builder Clear()
		{
			result = new DeliveryChatReplyItem();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override DeliveryChatReplyItem BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			DeliveryChatReplyItem deliveryChatReplyItem = result;
			result = null;
			return deliveryChatReplyItem;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is DeliveryChatReplyItem)
			{
				return MergeFrom((DeliveryChatReplyItem)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(DeliveryChatReplyItem other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.HasReceiver)
			{
				Receiver = other.Receiver;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasMsgType)
			{
				MsgType = other.MsgType;
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
					Receiver = input.ReadString();
					continue;
				case 24u:
					MsgID = input.ReadInt64();
					continue;
				case 32u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(MsgType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(4, (ulong)num2);
					}
					else
					{
						MsgType = (MsgType)num2;
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
	}

	public const int SenderFieldNumber = 1;

	public const int ReceiverFieldNumber = 2;

	public const int MsgIDFieldNumber = 3;

	public const int MsgTypeFieldNumber = 4;

	private static readonly DeliveryChatReplyItem defaultInstance;

	private bool hasSender;

	private string sender_ = "";

	private bool hasReceiver;

	private string receiver_ = "";

	private bool hasMsgID;

	private long msgID_;

	private bool hasMsgType;

	private MsgType msgType_;

	private int memoizedSerializedSize = -1;

	public static DeliveryChatReplyItem DefaultInstance => defaultInstance;

	public override DeliveryChatReplyItem DefaultInstanceForType => defaultInstance;

	protected override DeliveryChatReplyItem ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_DeliveryChatReplyItem__Descriptor;

	protected override FieldAccessorTable<DeliveryChatReplyItem, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_DeliveryChatReplyItem__FieldAccessorTable;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public bool HasReceiver => hasReceiver;

	public string Receiver => receiver_;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasMsgType => hasMsgType;

	public MsgType MsgType => msgType_;

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
			if (HasReceiver)
			{
				num += CodedOutputStream.ComputeStringSize(2, Receiver);
			}
			if (HasMsgID)
			{
				num += CodedOutputStream.ComputeInt64Size(3, MsgID);
			}
			if (HasMsgType)
			{
				num += CodedOutputStream.ComputeEnumSize(4, (int)MsgType);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasSender)
		{
			output.WriteString(1, Sender);
		}
		if (HasReceiver)
		{
			output.WriteString(2, Receiver);
		}
		if (HasMsgID)
		{
			output.WriteInt64(3, MsgID);
		}
		if (HasMsgType)
		{
			output.WriteEnum(4, (int)MsgType);
		}
		UnknownFields.WriteTo(output);
	}

	public static DeliveryChatReplyItem ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DeliveryChatReplyItem ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(DeliveryChatReplyItem prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static DeliveryChatReplyItem()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
