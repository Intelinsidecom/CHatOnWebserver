using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class Result : GeneratedMessage<Result, Result.Builder>
{
	public sealed class Builder : GeneratedBuilder<Result, Builder>
	{
		private Result result = new Result();

		protected override Builder ThisBuilder => this;

		protected override Result MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override Result DefaultInstanceForType => DefaultInstance;

		public bool HasResultCode => result.HasResultCode;

		public int ResultCode
		{
			get
			{
				return result.ResultCode;
			}
			set
			{
				SetResultCode(value);
			}
		}

		public bool HasResultMsg => result.HasResultMsg;

		public string ResultMsg
		{
			get
			{
				return result.ResultMsg;
			}
			set
			{
				SetResultMsg(value);
			}
		}

		public override Builder Clear()
		{
			result = new Result();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override Result BuildPartial()
		{
			if (this.result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			Result result = this.result;
			this.result = null;
			return result;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is Result)
			{
				return MergeFrom((Result)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(Result other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasResultCode)
			{
				ResultCode = other.ResultCode;
			}
			if (other.HasResultMsg)
			{
				ResultMsg = other.ResultMsg;
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
					ResultCode = input.ReadInt32();
					continue;
				case 18u:
					ResultMsg = input.ReadString();
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

		public Builder SetResultCode(int value)
		{
			result.hasResultCode = true;
			result.resultCode_ = value;
			return this;
		}

		public Builder ClearResultCode()
		{
			result.hasResultCode = false;
			result.resultCode_ = 0;
			return this;
		}

		public Builder SetResultMsg(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasResultMsg = true;
			result.resultMsg_ = value;
			return this;
		}

		public Builder ClearResultMsg()
		{
			result.hasResultMsg = false;
			result.resultMsg_ = "";
			return this;
		}
	}

	public const int ResultCodeFieldNumber = 1;

	public const int ResultMsgFieldNumber = 2;

	private static readonly Result defaultInstance;

	private bool hasResultCode;

	private int resultCode_;

	private bool hasResultMsg;

	private string resultMsg_ = "";

	private int memoizedSerializedSize = -1;

	public static Result DefaultInstance => defaultInstance;

	public override Result DefaultInstanceForType => defaultInstance;

	protected override Result ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_Result__Descriptor;

	protected override FieldAccessorTable<Result, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_Result__FieldAccessorTable;

	public bool HasResultCode => hasResultCode;

	public int ResultCode => resultCode_;

	public bool HasResultMsg => hasResultMsg;

	public string ResultMsg => resultMsg_;

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
			if (HasResultCode)
			{
				num += CodedOutputStream.ComputeInt32Size(1, ResultCode);
			}
			if (HasResultMsg)
			{
				num += CodedOutputStream.ComputeStringSize(2, ResultMsg);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasResultCode)
		{
			output.WriteInt32(1, ResultCode);
		}
		if (HasResultMsg)
		{
			output.WriteString(2, ResultMsg);
		}
		UnknownFields.WriteTo(output);
	}

	public static Result ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static Result ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static Result ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static Result ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static Result ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static Result ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static Result ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static Result ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static Result ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static Result ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(Result prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static Result()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
