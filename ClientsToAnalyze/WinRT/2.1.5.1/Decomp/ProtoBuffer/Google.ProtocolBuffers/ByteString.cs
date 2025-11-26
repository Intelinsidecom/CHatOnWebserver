using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Google.ProtocolBuffers;

public sealed class ByteString : IEnumerable<byte>, IEnumerable, IEquatable<ByteString>
{
	internal sealed class CodedBuilder
	{
		private readonly CodedOutputStream output;

		private readonly byte[] buffer;

		internal CodedOutputStream CodedOutput => output;

		internal CodedBuilder(int size)
		{
			buffer = new byte[size];
			output = CodedOutputStream.CreateInstance(buffer);
		}

		internal ByteString Build()
		{
			output.CheckNoSpaceLeft();
			return new ByteString(buffer);
		}
	}

	private static readonly ByteString empty = new ByteString(new byte[0]);

	private readonly byte[] bytes;

	public static ByteString Empty => empty;

	public int Length => bytes.Length;

	public bool IsEmpty => Length == 0;

	public byte this[int index] => bytes[index];

	private ByteString(byte[] bytes)
	{
		this.bytes = bytes;
	}

	public byte[] ToByteArray()
	{
		return (byte[])bytes.Clone();
	}

	public static ByteString FromBase64(string bytes)
	{
		return new ByteString(Convert.FromBase64String(bytes));
	}

	public static ByteString CopyFrom(byte[] bytes)
	{
		return new ByteString((byte[])bytes.Clone());
	}

	public static ByteString CopyFrom(byte[] bytes, int offset, int count)
	{
		byte[] destinationArray = new byte[count];
		Array.Copy(bytes, offset, destinationArray, 0, count);
		return new ByteString(destinationArray);
	}

	public static ByteString CopyFrom(string text, Encoding encoding)
	{
		return new ByteString(encoding.GetBytes(text));
	}

	public static ByteString CopyFromUtf8(string text)
	{
		return CopyFrom(text, Encoding.UTF8);
	}

	public string ToString(Encoding encoding)
	{
		return encoding.GetString(bytes, 0, bytes.Length);
	}

	public string ToStringUtf8()
	{
		return ToString(Encoding.UTF8);
	}

	public IEnumerator<byte> GetEnumerator()
	{
		return ((IEnumerable<byte>)bytes).GetEnumerator();
	}

	IEnumerator IEnumerable.GetEnumerator()
	{
		return GetEnumerator();
	}

	public CodedInputStream CreateCodedInput()
	{
		return CodedInputStream.CreateInstance(bytes);
	}

	public override bool Equals(object obj)
	{
		ByteString other = obj as ByteString;
		if (obj == null)
		{
			return false;
		}
		return Equals(other);
	}

	public override int GetHashCode()
	{
		int num = 23;
		byte[] array = bytes;
		foreach (byte b in array)
		{
			num = (num << 8) | b;
		}
		return num;
	}

	public bool Equals(ByteString other)
	{
		if (other.bytes.Length != bytes.Length)
		{
			return false;
		}
		for (int i = 0; i < bytes.Length; i++)
		{
			if (other.bytes[i] != bytes[i])
			{
				return false;
			}
		}
		return true;
	}
}
