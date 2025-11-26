namespace SharpCompress.Compressor.Rar.VM;

internal class BitInput
{
	internal const int MAX_SIZE = 32768;

	protected int inAddr;

	protected int inBit;

	internal byte[] InBuf { get; private set; }

	internal BitInput()
	{
		InBuf = new byte[32768];
	}

	internal void InitBitInput()
	{
		inAddr = 0;
		inBit = 0;
	}

	internal void AddBits(int bits)
	{
		bits += inBit;
		inAddr += bits >> 3;
		inBit = bits & 7;
	}

	internal int GetBits()
	{
		return Utility.URShift(((InBuf[inAddr] & 0xFF) << 16) + ((InBuf[inAddr + 1] & 0xFF) << 8) + (InBuf[inAddr + 2] & 0xFF), 8 - inBit) & 0xFFFF;
	}

	internal bool Overflow(int IncPtr)
	{
		return inAddr + IncPtr >= 32768;
	}
}
