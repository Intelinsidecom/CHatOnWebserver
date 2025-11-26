using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class AnswerBack : GeneratedMessage<AnswerBack, AnswerBack.Builder>
{
	public sealed class Builder : GeneratedBuilder<AnswerBack, Builder>
	{
		private AnswerBack result = new AnswerBack();

		protected override Builder ThisBuilder => this;

		protected override AnswerBack MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override AnswerBack DefaultInstanceForType => DefaultInstance;

		public IPopsicleList<AnswerbackItem> AnswerbackItemsList => result.answerbackItems_;

		public int AnswerbackItemsCount => result.AnswerbackItemsCount;

		public override Builder Clear()
		{
			result = new AnswerBack();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override AnswerBack BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.answerbackItems_.MakeReadOnly();
			AnswerBack answerBack = result;
			result = null;
			return answerBack;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is AnswerBack)
			{
				return MergeFrom((AnswerBack)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(AnswerBack other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.answerbackItems_.Count != 0)
			{
				AddRange(other.answerbackItems_, result.answerbackItems_);
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
				{
					AnswerbackItem.Builder builder2 = AnswerbackItem.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddAnswerbackItems(builder2.BuildPartial());
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
	}

	public const int AnswerbackItemsFieldNumber = 1;

	private static readonly AnswerBack defaultInstance;

	private PopsicleList<AnswerbackItem> answerbackItems_ = new PopsicleList<AnswerbackItem>();

	private int memoizedSerializedSize = -1;

	public static AnswerBack DefaultInstance => defaultInstance;

	public override AnswerBack DefaultInstanceForType => defaultInstance;

	protected override AnswerBack ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_AnswerBack__Descriptor;

	protected override FieldAccessorTable<AnswerBack, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_AnswerBack__FieldAccessorTable;

	public IList<AnswerbackItem> AnswerbackItemsList => answerbackItems_;

	public int AnswerbackItemsCount => answerbackItems_.Count;

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
			foreach (AnswerbackItem answerbackItems in AnswerbackItemsList)
			{
				num += CodedOutputStream.ComputeMessageSize(1, answerbackItems);
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
		foreach (AnswerbackItem answerbackItems in AnswerbackItemsList)
		{
			output.WriteMessage(1, answerbackItems);
		}
		UnknownFields.WriteTo(output);
	}

	public static AnswerBack ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnswerBack ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnswerBack ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnswerBack ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnswerBack ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnswerBack ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnswerBack ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static AnswerBack ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnswerBack ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnswerBack ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(AnswerBack prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static AnswerBack()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
