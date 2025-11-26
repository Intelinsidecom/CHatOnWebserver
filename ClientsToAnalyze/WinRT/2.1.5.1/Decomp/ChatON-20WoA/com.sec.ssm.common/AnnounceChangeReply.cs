using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class AnnounceChangeReply : GeneratedMessage<AnnounceChangeReply, AnnounceChangeReply.Builder>
{
	public sealed class Builder : GeneratedBuilder<AnnounceChangeReply, Builder>
	{
		private AnnounceChangeReply result = new AnnounceChangeReply();

		protected override Builder ThisBuilder => this;

		protected override AnnounceChangeReply MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override AnnounceChangeReply DefaultInstanceForType => DefaultInstance;

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

		public override Builder Clear()
		{
			result = new AnnounceChangeReply();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override AnnounceChangeReply BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			AnnounceChangeReply announceChangeReply = result;
			result = null;
			return announceChangeReply;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is AnnounceChangeReply)
			{
				return MergeFrom((AnnounceChangeReply)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(AnnounceChangeReply other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasResult)
			{
				MergeResult(other.Result);
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
				case 18u:
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
	}

	public const int MsgIDFieldNumber = 1;

	public const int ResultFieldNumber = 2;

	private static readonly AnnounceChangeReply defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasResult;

	private Result result_ = Result.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static AnnounceChangeReply DefaultInstance => defaultInstance;

	public override AnnounceChangeReply DefaultInstanceForType => defaultInstance;

	protected override AnnounceChangeReply ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_AnnounceChangeReply__Descriptor;

	protected override FieldAccessorTable<AnnounceChangeReply, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_AnnounceChangeReply__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasResult => hasResult;

	public Result Result => result_;

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
			if (HasResult)
			{
				num += CodedOutputStream.ComputeMessageSize(2, Result);
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
		if (HasResult)
		{
			output.WriteMessage(2, Result);
		}
		UnknownFields.WriteTo(output);
	}

	public static AnnounceChangeReply ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnnounceChangeReply ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnnounceChangeReply ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnnounceChangeReply ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnnounceChangeReply ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnnounceChangeReply ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnnounceChangeReply ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static AnnounceChangeReply ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnnounceChangeReply ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnnounceChangeReply ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(AnnounceChangeReply prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static AnnounceChangeReply()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
