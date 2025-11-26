using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class AnswerbackItem : GeneratedMessage<AnswerbackItem, AnswerbackItem.Builder>
{
	public sealed class Builder : GeneratedBuilder<AnswerbackItem, Builder>
	{
		private AnswerbackItem result = new AnswerbackItem();

		protected override Builder ThisBuilder => this;

		protected override AnswerbackItem MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override AnswerbackItem DefaultInstanceForType => DefaultInstance;

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

		public override Builder Clear()
		{
			result = new AnswerbackItem();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override AnswerbackItem BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			AnswerbackItem answerbackItem = result;
			result = null;
			return answerbackItem;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is AnswerbackItem)
			{
				return MergeFrom((AnswerbackItem)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(AnswerbackItem other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasReceiver)
			{
				Receiver = other.Receiver;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
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
					Receiver = input.ReadString();
					continue;
				case 16u:
					MsgID = input.ReadInt64();
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
	}

	public const int ReceiverFieldNumber = 1;

	public const int MsgIDFieldNumber = 2;

	private static readonly AnswerbackItem defaultInstance;

	private bool hasReceiver;

	private string receiver_ = "";

	private bool hasMsgID;

	private long msgID_;

	private int memoizedSerializedSize = -1;

	public static AnswerbackItem DefaultInstance => defaultInstance;

	public override AnswerbackItem DefaultInstanceForType => defaultInstance;

	protected override AnswerbackItem ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_AnswerbackItem__Descriptor;

	protected override FieldAccessorTable<AnswerbackItem, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_AnswerbackItem__FieldAccessorTable;

	public bool HasReceiver => hasReceiver;

	public string Receiver => receiver_;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

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
			if (HasReceiver)
			{
				num += CodedOutputStream.ComputeStringSize(1, Receiver);
			}
			if (HasMsgID)
			{
				num += CodedOutputStream.ComputeInt64Size(2, MsgID);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasReceiver)
		{
			output.WriteString(1, Receiver);
		}
		if (HasMsgID)
		{
			output.WriteInt64(2, MsgID);
		}
		UnknownFields.WriteTo(output);
	}

	public static AnswerbackItem ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnswerbackItem ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnswerbackItem ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnswerbackItem ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnswerbackItem ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnswerbackItem ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnswerbackItem ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static AnswerbackItem ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnswerbackItem ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnswerbackItem ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(AnswerbackItem prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static AnswerbackItem()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
