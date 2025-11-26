using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using Google.ProtocolBuffers.Collections;

namespace Google.ProtocolBuffers;

public sealed class UnknownField
{
	public sealed class Builder
	{
		private List<ulong> varintList;

		private List<uint> fixed32List;

		private List<ulong> fixed64List;

		private List<ByteString> lengthDelimitedList;

		private List<UnknownFieldSet> groupList;

		public UnknownField Build()
		{
			return new UnknownField(MakeReadOnly(ref varintList), MakeReadOnly(ref fixed32List), MakeReadOnly(ref fixed64List), MakeReadOnly(ref lengthDelimitedList), MakeReadOnly(ref groupList));
		}

		public Builder MergeFrom(UnknownField other)
		{
			varintList = AddAll(varintList, other.VarintList);
			fixed32List = AddAll(fixed32List, other.Fixed32List);
			fixed64List = AddAll(fixed64List, other.Fixed64List);
			lengthDelimitedList = AddAll(lengthDelimitedList, other.LengthDelimitedList);
			groupList = AddAll(groupList, other.GroupList);
			return this;
		}

		private static List<T> AddAll<T>(List<T> current, IList<T> extras)
		{
			if (extras.Count == 0)
			{
				return current;
			}
			if (current == null)
			{
				current = new List<T>(extras);
			}
			else
			{
				current.AddRange(extras);
			}
			return current;
		}

		public Builder Clear()
		{
			varintList = null;
			fixed32List = null;
			fixed64List = null;
			lengthDelimitedList = null;
			groupList = null;
			return this;
		}

		[CLSCompliant(false)]
		public Builder AddVarint(ulong value)
		{
			varintList = Add(varintList, value);
			return this;
		}

		[CLSCompliant(false)]
		public Builder AddFixed32(uint value)
		{
			fixed32List = Add(fixed32List, value);
			return this;
		}

		[CLSCompliant(false)]
		public Builder AddFixed64(ulong value)
		{
			fixed64List = Add(fixed64List, value);
			return this;
		}

		public Builder AddLengthDelimited(ByteString value)
		{
			lengthDelimitedList = Add(lengthDelimitedList, value);
			return this;
		}

		public Builder AddGroup(UnknownFieldSet value)
		{
			groupList = Add(groupList, value);
			return this;
		}

		private static List<T> Add<T>(List<T> list, T value)
		{
			if (list == null)
			{
				list = new List<T>();
			}
			list.Add(value);
			return list;
		}

		private static ReadOnlyCollection<T> MakeReadOnly<T>(ref List<T> list)
		{
			ReadOnlyCollection<T> result = ((list == null) ? Lists<T>.Empty : new ReadOnlyCollection<T>(list));
			list = null;
			return result;
		}
	}

	private static readonly UnknownField defaultInstance = CreateBuilder().Build();

	private readonly ReadOnlyCollection<ulong> varintList;

	private readonly ReadOnlyCollection<uint> fixed32List;

	private readonly ReadOnlyCollection<ulong> fixed64List;

	private readonly ReadOnlyCollection<ByteString> lengthDelimitedList;

	private readonly ReadOnlyCollection<UnknownFieldSet> groupList;

	public static UnknownField DefaultInstance => defaultInstance;

	public IList<ulong> VarintList => varintList;

	public IList<uint> Fixed32List => fixed32List;

	public IList<ulong> Fixed64List => fixed64List;

	public IList<ByteString> LengthDelimitedList => lengthDelimitedList;

	public IList<UnknownFieldSet> GroupList => groupList;

	private UnknownField(ReadOnlyCollection<ulong> varintList, ReadOnlyCollection<uint> fixed32List, ReadOnlyCollection<ulong> fixed64List, ReadOnlyCollection<ByteString> lengthDelimitedList, ReadOnlyCollection<UnknownFieldSet> groupList)
	{
		this.varintList = varintList;
		this.fixed32List = fixed32List;
		this.fixed64List = fixed64List;
		this.lengthDelimitedList = lengthDelimitedList;
		this.groupList = groupList;
	}

	public override bool Equals(object other)
	{
		if (object.ReferenceEquals(this, other))
		{
			return true;
		}
		if (other is UnknownField unknownField && Lists.Equals(varintList, unknownField.varintList) && Lists.Equals(fixed32List, unknownField.fixed32List) && Lists.Equals(fixed64List, unknownField.fixed64List) && Lists.Equals(lengthDelimitedList, unknownField.lengthDelimitedList))
		{
			return Lists.Equals(groupList, unknownField.groupList);
		}
		return false;
	}

	public override int GetHashCode()
	{
		int num = 43;
		num = num * 47 + Lists.GetHashCode(varintList);
		num = num * 47 + Lists.GetHashCode(fixed32List);
		num = num * 47 + Lists.GetHashCode(fixed64List);
		num = num * 47 + Lists.GetHashCode(lengthDelimitedList);
		return num * 47 + Lists.GetHashCode(groupList);
	}

	public static Builder CreateBuilder()
	{
		return new Builder();
	}

	public static Builder CreateBuilder(UnknownField copyFrom)
	{
		return new Builder().MergeFrom(copyFrom);
	}

	public void WriteTo(int fieldNumber, CodedOutputStream output)
	{
		foreach (ulong varint in varintList)
		{
			output.WriteUInt64(fieldNumber, varint);
		}
		foreach (uint @fixed in fixed32List)
		{
			output.WriteFixed32(fieldNumber, @fixed);
		}
		foreach (ulong fixed2 in fixed64List)
		{
			output.WriteFixed64(fieldNumber, fixed2);
		}
		foreach (ByteString lengthDelimited in lengthDelimitedList)
		{
			output.WriteBytes(fieldNumber, lengthDelimited);
		}
		foreach (UnknownFieldSet group in groupList)
		{
			output.WriteUnknownGroup(fieldNumber, group);
		}
	}

	public int GetSerializedSize(int fieldNumber)
	{
		int num = 0;
		foreach (ulong varint in varintList)
		{
			num += CodedOutputStream.ComputeUInt64Size(fieldNumber, varint);
		}
		foreach (uint @fixed in fixed32List)
		{
			num += CodedOutputStream.ComputeFixed32Size(fieldNumber, @fixed);
		}
		foreach (ulong fixed2 in fixed64List)
		{
			num += CodedOutputStream.ComputeFixed64Size(fieldNumber, fixed2);
		}
		foreach (ByteString lengthDelimited in lengthDelimitedList)
		{
			num += CodedOutputStream.ComputeBytesSize(fieldNumber, lengthDelimited);
		}
		foreach (UnknownFieldSet group in groupList)
		{
			num += CodedOutputStream.ComputeUnknownGroupSize(fieldNumber, group);
		}
		return num;
	}

	public void WriteAsMessageSetExtensionTo(int fieldNumber, CodedOutputStream output)
	{
		foreach (ByteString lengthDelimited in lengthDelimitedList)
		{
			output.WriteRawMessageSetExtension(fieldNumber, lengthDelimited);
		}
	}

	public int GetSerializedSizeAsMessageSetExtension(int fieldNumber)
	{
		int num = 0;
		foreach (ByteString lengthDelimited in lengthDelimitedList)
		{
			num += CodedOutputStream.ComputeRawMessageSetExtensionSize(fieldNumber, lengthDelimited);
		}
		return num;
	}
}
