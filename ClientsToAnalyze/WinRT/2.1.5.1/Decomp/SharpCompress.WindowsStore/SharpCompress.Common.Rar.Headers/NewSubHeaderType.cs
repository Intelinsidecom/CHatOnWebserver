using System;

namespace SharpCompress.Common.Rar.Headers;

internal class NewSubHeaderType : IEquatable<NewSubHeaderType>
{
	internal static readonly NewSubHeaderType SUBHEAD_TYPE_CMT = new NewSubHeaderType('C', 'M', 'T');

	internal static readonly NewSubHeaderType SUBHEAD_TYPE_RR = new NewSubHeaderType('R', 'R');

	private byte[] bytes;

	private NewSubHeaderType(params char[] chars)
	{
		bytes = new byte[chars.Length];
		for (int i = 0; i < chars.Length; i++)
		{
			bytes[i] = (byte)chars[i];
		}
	}

	internal bool Equals(byte[] bytes)
	{
		if (this.bytes.Length != bytes.Length)
		{
			return false;
		}
		for (int i = 0; i < bytes.Length; i++)
		{
			if (this.bytes[i] != bytes[i])
			{
				return false;
			}
		}
		return true;
	}

	public bool Equals(NewSubHeaderType other)
	{
		return Equals(other.bytes);
	}
}
