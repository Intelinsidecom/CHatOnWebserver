using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class DeliveryChatReply : GeneratedMessage<DeliveryChatReply, DeliveryChatReply.Builder>
{
	public sealed class Builder : GeneratedBuilder<DeliveryChatReply, Builder>
	{
		private DeliveryChatReply result = new DeliveryChatReply();

		protected override Builder ThisBuilder => this;

		protected override DeliveryChatReply MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override DeliveryChatReply DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<DeliveryChatReplyItem> DeliveryChatReplyItemsList => result.deliveryChatReplyItems_;

		public int DeliveryChatReplyItemsCount => result.DeliveryChatReplyItemsCount;

		public bool HasResult => result.HasResult;

		public Result Result
		{
			get
			{
				return result.Result;
			}
			set
			{
				SetResult(value);
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

		public override Builder Clear()
		{
			result = new DeliveryChatReply();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override DeliveryChatReply BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.deliveryChatReplyItems_.MakeReadOnly();
			DeliveryChatReply deliveryChatReply = result;
			result = null;
			return deliveryChatReply;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is DeliveryChatReply)
			{
				return MergeFrom((DeliveryChatReply)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(DeliveryChatReply other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.deliveryChatReplyItems_.Count != 0)
			{
				AddRange(other.deliveryChatReplyItems_, result.deliveryChatReplyItems_);
			}
			if (other.HasResult)
			{
				MergeResult(other.Result);
			}
			if (other.HasMaxMessageCount)
			{
				MaxMessageCount = other.MaxMessageCount;
			}
			if (other.HasLastMessageTimestamp)
			{
				LastMessageTimestamp = other.LastMessageTimestamp;
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
					UID = input.ReadString();
					continue;
				case 18u:
				{
					DeliveryChatReplyItem.Builder builder3 = DeliveryChatReplyItem.CreateBuilder();
					input.ReadMessage(builder3, extensionRegistry);
					AddDeliveryChatReplyItems(builder3.BuildPartial());
					continue;
				}
				case 26u:
				{
					Result.Builder builder2 = Result.CreateBuilder();
					if (HasResult)
					{
						builder2.MergeFrom(Result);
					}
					input.ReadMessage(builder2, extensionRegistry);
					Result = builder2.BuildPartial();
					continue;
				}
				case 32u:
					MaxMessageCount = input.ReadInt32();
					continue;
				case 40u:
					LastMessageTimestamp = input.ReadInt64();
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

		public DeliveryChatReplyItem GetDeliveryChatReplyItems(int index)
		{
			return result.GetDeliveryChatReplyItems(index);
		}

		public Builder SetDeliveryChatReplyItems(int index, DeliveryChatReplyItem value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.deliveryChatReplyItems_[index] = value;
			return this;
		}

		public Builder SetDeliveryChatReplyItems(int index, DeliveryChatReplyItem.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.deliveryChatReplyItems_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddDeliveryChatReplyItems(DeliveryChatReplyItem value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.deliveryChatReplyItems_.Add(value);
			return this;
		}

		public Builder AddDeliveryChatReplyItems(DeliveryChatReplyItem.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.deliveryChatReplyItems_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeDeliveryChatReplyItems(IEnumerable<DeliveryChatReplyItem> values)
		{
			AddRange(values, result.deliveryChatReplyItems_);
			return this;
		}

		public Builder ClearDeliveryChatReplyItems()
		{
			result.deliveryChatReplyItems_.Clear();
			return this;
		}

		public Builder SetResult(Result value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasResult = true;
			result.result_ = value;
			return this;
		}

		public Builder SetResult(Result.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasResult = true;
			result.result_ = builderForValue.Build();
			return this;
		}

		public Builder MergeResult(Result value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasResult && result.result_ != Result.DefaultInstance)
			{
				result.result_ = Result.CreateBuilder(result.result_).MergeFrom(value).BuildPartial();
			}
			else
			{
				result.result_ = value;
			}
			result.hasResult = true;
			return this;
		}

		public Builder ClearResult()
		{
			result.hasResult = false;
			result.result_ = Result.DefaultInstance;
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
	}

	public const int UIDFieldNumber = 1;

	public const int DeliveryChatReplyItemsFieldNumber = 2;

	public const int ResultFieldNumber = 3;

	public const int MaxMessageCountFieldNumber = 4;

	public const int LastMessageTimestampFieldNumber = 5;

	private static readonly DeliveryChatReply defaultInstance;

	private bool hasUID;

	private string uID_ = "";

	private PopsicleList<DeliveryChatReplyItem> deliveryChatReplyItems_ = new PopsicleList<DeliveryChatReplyItem>();

	private bool hasResult;

	private Result result_ = Result.DefaultInstance;

	private bool hasMaxMessageCount;

	private int maxMessageCount_;

	private bool hasLastMessageTimestamp;

	private long lastMessageTimestamp_;

	private int memoizedSerializedSize = -1;

	public static DeliveryChatReply DefaultInstance => defaultInstance;

	public override DeliveryChatReply DefaultInstanceForType => defaultInstance;

	protected override DeliveryChatReply ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_DeliveryChatReply__Descriptor;

	protected override FieldAccessorTable<DeliveryChatReply, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_DeliveryChatReply__FieldAccessorTable;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public IList<DeliveryChatReplyItem> DeliveryChatReplyItemsList => deliveryChatReplyItems_;

	public int DeliveryChatReplyItemsCount => deliveryChatReplyItems_.Count;

	public bool HasResult => hasResult;

	public Result Result => result_;

	public bool HasMaxMessageCount => hasMaxMessageCount;

	public int MaxMessageCount => maxMessageCount_;

	public bool HasLastMessageTimestamp => hasLastMessageTimestamp;

	public long LastMessageTimestamp => lastMessageTimestamp_;

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
			if (HasUID)
			{
				num += CodedOutputStream.ComputeStringSize(1, UID);
			}
			foreach (DeliveryChatReplyItem deliveryChatReplyItems in DeliveryChatReplyItemsList)
			{
				num += CodedOutputStream.ComputeMessageSize(2, deliveryChatReplyItems);
			}
			if (HasResult)
			{
				num += CodedOutputStream.ComputeMessageSize(3, Result);
			}
			if (HasMaxMessageCount)
			{
				num += CodedOutputStream.ComputeInt32Size(4, MaxMessageCount);
			}
			if (HasLastMessageTimestamp)
			{
				num += CodedOutputStream.ComputeInt64Size(5, LastMessageTimestamp);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public DeliveryChatReplyItem GetDeliveryChatReplyItems(int index)
	{
		return deliveryChatReplyItems_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasUID)
		{
			output.WriteString(1, UID);
		}
		foreach (DeliveryChatReplyItem deliveryChatReplyItems in DeliveryChatReplyItemsList)
		{
			output.WriteMessage(2, deliveryChatReplyItems);
		}
		if (HasResult)
		{
			output.WriteMessage(3, Result);
		}
		if (HasMaxMessageCount)
		{
			output.WriteInt32(4, MaxMessageCount);
		}
		if (HasLastMessageTimestamp)
		{
			output.WriteInt64(5, LastMessageTimestamp);
		}
		UnknownFields.WriteTo(output);
	}

	public static DeliveryChatReply ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DeliveryChatReply ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReply ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DeliveryChatReply ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReply ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DeliveryChatReply ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReply ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static DeliveryChatReply ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static DeliveryChatReply ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DeliveryChatReply ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(DeliveryChatReply prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static DeliveryChatReply()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
