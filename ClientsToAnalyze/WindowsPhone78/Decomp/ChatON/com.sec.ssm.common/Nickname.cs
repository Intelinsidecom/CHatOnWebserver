using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class Nickname : GeneratedMessage<Nickname, Nickname.Builder>
{
	public sealed class Builder : GeneratedBuilder<Nickname, Builder>
	{
		private Nickname result = new Nickname();

		protected override Builder ThisBuilder => this;

		protected override Nickname MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override Nickname DefaultInstanceForType => DefaultInstance;

		public bool HasUser => result.HasUser;

		public string User
		{
			get
			{
				return result.User;
			}
			set
			{
				SetUser(value);
			}
		}

		public bool HasNickname_ => result.HasNickname_;

		public string Nickname_
		{
			get
			{
				return result.Nickname_;
			}
			set
			{
				SetNickname_(value);
			}
		}

		public override Builder Clear()
		{
			result = new Nickname();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override Nickname BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			Nickname nickname = result;
			result = null;
			return nickname;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is Nickname)
			{
				return MergeFrom((Nickname)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(Nickname other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasUser)
			{
				User = other.User;
			}
			if (other.HasNickname_)
			{
				Nickname_ = other.Nickname_;
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
					User = input.ReadString();
					continue;
				case 18u:
					Nickname_ = input.ReadString();
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

		public Builder SetUser(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasUser = true;
			result.user_ = value;
			return this;
		}

		public Builder ClearUser()
		{
			result.hasUser = false;
			result.user_ = "";
			return this;
		}

		public Builder SetNickname_(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasNickname_ = true;
			result.nickname_ = value;
			return this;
		}

		public Builder ClearNickname_()
		{
			result.hasNickname_ = false;
			result.nickname_ = "";
			return this;
		}
	}

	public const int UserFieldNumber = 1;

	public const int Nickname_FieldNumber = 2;

	private static readonly Nickname defaultInstance;

	private bool hasUser;

	private string user_ = "";

	private bool hasNickname_;

	private string nickname_ = "";

	private int memoizedSerializedSize = -1;

	public static Nickname DefaultInstance => defaultInstance;

	public override Nickname DefaultInstanceForType => defaultInstance;

	protected override Nickname ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_Nickname__Descriptor;

	protected override FieldAccessorTable<Nickname, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_Nickname__FieldAccessorTable;

	public bool HasUser => hasUser;

	public string User => user_;

	public bool HasNickname_ => hasNickname_;

	public string Nickname_ => nickname_;

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
			if (HasUser)
			{
				num += CodedOutputStream.ComputeStringSize(1, User);
			}
			if (HasNickname_)
			{
				num += CodedOutputStream.ComputeStringSize(2, Nickname_);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasUser)
		{
			output.WriteString(1, User);
		}
		if (HasNickname_)
		{
			output.WriteString(2, Nickname_);
		}
		UnknownFields.WriteTo(output);
	}

	public static Nickname ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static Nickname ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static Nickname ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static Nickname ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static Nickname ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static Nickname ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static Nickname ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static Nickname ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static Nickname ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static Nickname ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(Nickname prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static Nickname()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
