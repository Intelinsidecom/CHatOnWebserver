using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class BulkEndChatRequest : GeneratedMessage<BulkEndChatRequest, BulkEndChatRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<BulkEndChatRequest, Builder>
	{
		private BulkEndChatRequest result = new BulkEndChatRequest();

		protected override Builder ThisBuilder => this;

		protected override BulkEndChatRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override BulkEndChatRequest DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<EndParam> EndParamsList => result.endParams_;

		public int EndParamsCount => result.EndParamsCount;

		public override Builder Clear()
		{
			result = new BulkEndChatRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override BulkEndChatRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.endParams_.MakeReadOnly();
			BulkEndChatRequest bulkEndChatRequest = result;
			result = null;
			return bulkEndChatRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is BulkEndChatRequest)
			{
				return MergeFrom((BulkEndChatRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(BulkEndChatRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.endParams_.Count != 0)
			{
				AddRange(other.endParams_, result.endParams_);
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
					Sender = input.ReadString();
					continue;
				case 26u:
				{
					EndParam.Builder builder2 = EndParam.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddEndParams(builder2.BuildPartial());
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

		public EndParam GetEndParams(int index)
		{
			return result.GetEndParams(index);
		}

		public Builder SetEndParams(int index, EndParam value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.endParams_[index] = value;
			return this;
		}

		public Builder SetEndParams(int index, EndParam.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.endParams_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddEndParams(EndParam value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.endParams_.Add(value);
			return this;
		}

		public Builder AddEndParams(EndParam.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.endParams_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeEndParams(IEnumerable<EndParam> values)
		{
			AddRange(values, result.endParams_);
			return this;
		}

		public Builder ClearEndParams()
		{
			result.endParams_.Clear();
			return this;
		}
	}

	public const int UIDFieldNumber = 1;

	public const int SenderFieldNumber = 2;

	public const int EndParamsFieldNumber = 3;

	private static readonly BulkEndChatRequest defaultInstance;

	private bool hasUID;

	private string uID_ = "";

	private bool hasSender;

	private string sender_ = "";

	private PopsicleList<EndParam> endParams_ = new PopsicleList<EndParam>();

	private int memoizedSerializedSize = -1;

	public static BulkEndChatRequest DefaultInstance => defaultInstance;

	public override BulkEndChatRequest DefaultInstanceForType => defaultInstance;

	protected override BulkEndChatRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_BulkEndChatRequest__Descriptor;

	protected override FieldAccessorTable<BulkEndChatRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_BulkEndChatRequest__FieldAccessorTable;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public IList<EndParam> EndParamsList => endParams_;

	public int EndParamsCount => endParams_.Count;

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
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(2, Sender);
			}
			foreach (EndParam endParams in EndParamsList)
			{
				num += CodedOutputStream.ComputeMessageSize(3, endParams);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public EndParam GetEndParams(int index)
	{
		return endParams_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasUID)
		{
			output.WriteString(1, UID);
		}
		if (HasSender)
		{
			output.WriteString(2, Sender);
		}
		foreach (EndParam endParams in EndParamsList)
		{
			output.WriteMessage(3, endParams);
		}
		UnknownFields.WriteTo(output);
	}

	public static BulkEndChatRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static BulkEndChatRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static BulkEndChatRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static BulkEndChatRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static BulkEndChatRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static BulkEndChatRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static BulkEndChatRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static BulkEndChatRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static BulkEndChatRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static BulkEndChatRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(BulkEndChatRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static BulkEndChatRequest()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
