using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class AnswerBackReply : GeneratedMessage<AnswerBackReply, AnswerBackReply.Builder>
{
	public sealed class Builder : GeneratedBuilder<AnswerBackReply, Builder>
	{
		private AnswerBackReply result = new AnswerBackReply();

		protected override Builder ThisBuilder => this;

		protected override AnswerBackReply MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override AnswerBackReply DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<AnswerbackItem> AnswerbackItemsList => result.answerbackItems_;

		public int AnswerbackItemsCount => result.AnswerbackItemsCount;

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
			result = new AnswerBackReply();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override AnswerBackReply BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.answerbackItems_.MakeReadOnly();
			AnswerBackReply answerBackReply = result;
			result = null;
			return answerBackReply;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is AnswerBackReply)
			{
				return MergeFrom((AnswerBackReply)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(AnswerBackReply other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.answerbackItems_.Count != 0)
			{
				AddRange(other.answerbackItems_, result.answerbackItems_);
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
				case 10u:
					UID = input.ReadString();
					continue;
				case 18u:
				{
					AnswerbackItem.Builder builder3 = AnswerbackItem.CreateBuilder();
					input.ReadMessage(builder3, extensionRegistry);
					AddAnswerbackItems(builder3.BuildPartial());
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

		public AnswerbackItem GetAnswerbackItems(int index)
		{
			return result.GetAnswerbackItems(index);
		}

		public Builder SetAnswerbackItems(int index, AnswerbackItem value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.answerbackItems_[index] = value;
			return this;
		}

		public Builder SetAnswerbackItems(int index, AnswerbackItem.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.answerbackItems_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddAnswerbackItems(AnswerbackItem value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.answerbackItems_.Add(value);
			return this;
		}

		public Builder AddAnswerbackItems(AnswerbackItem.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.answerbackItems_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeAnswerbackItems(IEnumerable<AnswerbackItem> values)
		{
			AddRange(values, result.answerbackItems_);
			return this;
		}

		public Builder ClearAnswerbackItems()
		{
			result.answerbackItems_.Clear();
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

	public const int UIDFieldNumber = 1;

	public const int AnswerbackItemsFieldNumber = 2;

	public const int ResultFieldNumber = 3;

	private static readonly AnswerBackReply defaultInstance;

	private bool hasUID;

	private string uID_ = "";

	private PopsicleList<AnswerbackItem> answerbackItems_ = new PopsicleList<AnswerbackItem>();

	private bool hasResult;

	private Result result_ = Result.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static AnswerBackReply DefaultInstance => defaultInstance;

	public override AnswerBackReply DefaultInstanceForType => defaultInstance;

	protected override AnswerBackReply ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_AnswerBackReply__Descriptor;

	protected override FieldAccessorTable<AnswerBackReply, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_AnswerBackReply__FieldAccessorTable;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public IList<AnswerbackItem> AnswerbackItemsList => answerbackItems_;

	public int AnswerbackItemsCount => answerbackItems_.Count;

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
			if (HasUID)
			{
				num += CodedOutputStream.ComputeStringSize(1, UID);
			}
			foreach (AnswerbackItem answerbackItems in AnswerbackItemsList)
			{
				num += CodedOutputStream.ComputeMessageSize(2, answerbackItems);
			}
			if (HasResult)
			{
				num += CodedOutputStream.ComputeMessageSize(3, Result);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public AnswerbackItem GetAnswerbackItems(int index)
	{
		return answerbackItems_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasUID)
		{
			output.WriteString(1, UID);
		}
		foreach (AnswerbackItem answerbackItems in AnswerbackItemsList)
		{
			output.WriteMessage(2, answerbackItems);
		}
		if (HasResult)
		{
			output.WriteMessage(3, Result);
		}
		UnknownFields.WriteTo(output);
	}

	public static AnswerBackReply ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnswerBackReply ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnswerBackReply ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnswerBackReply ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnswerBackReply ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnswerBackReply ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnswerBackReply ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static AnswerBackReply ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnswerBackReply ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnswerBackReply ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(AnswerBackReply prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static AnswerBackReply()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
