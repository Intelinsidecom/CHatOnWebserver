namespace SharpCompress.Compressor.Rar.decode;

internal class Decode
{
	internal int[] DecodeLen { get; private set; }

	internal int[] DecodeNum { get; private set; }

	internal int[] DecodePos { get; private set; }

	internal int MaxNum { get; set; }

	internal Decode()
		: this(new int[2])
	{
	}

	protected Decode(int[] customDecodeNum)
	{
		DecodeLen = new int[16];
		DecodePos = new int[16];
		DecodeNum = customDecodeNum;
	}
}
