using System.Collections.Generic;
using System.IO;
using SharpCompress.IO;

namespace SharpCompress.Common.Rar;

internal class RarCryptoBinaryReader : MarkingBinaryReader
{
	private RarRijndael rijndael;

	private byte[] salt;

	private readonly string password;

	private readonly Queue<byte> data = new Queue<byte>();

	protected bool UseEncryption => salt != null;

	public RarCryptoBinaryReader(Stream stream, string password)
		: base(stream)
	{
		this.password = password;
	}

	internal void InitializeAes(byte[] salt)
	{
		this.salt = salt;
		rijndael = RarRijndael.InitializeFrom(password, salt);
	}

	public override byte[] ReadBytes(int count)
	{
		base.CurrentReadByteCount += count;
		if (UseEncryption)
		{
			return ReadAndDecryptBytes(count);
		}
		return base.ReadBytes(count);
	}

	private byte[] ReadAndDecryptBytes(int count)
	{
		int count2 = data.Count;
		int num = count - count2;
		if (num > 0)
		{
			int num2 = num + ((~num + 1) & 0xF);
			for (int i = 0; i < num2 / 16; i++)
			{
				byte[] cipherText = base.ReadBytes(16);
				byte[] array = rijndael.ProcessBlock(cipherText);
				byte[] array2 = array;
				foreach (byte item in array2)
				{
					data.Enqueue(item);
				}
			}
		}
		byte[] array3 = new byte[count];
		for (int k = 0; k < count; k++)
		{
			array3[k] = data.Dequeue();
		}
		return array3;
	}

	public void ClearQueue()
	{
		data.Clear();
	}

	public void SkipQueue()
	{
		long position = BaseStream.Position;
		BaseStream.Position = position + data.Count;
		ClearQueue();
	}
}
