namespace SharpCompress.Compressor.PPMd.I1;

internal class See2Context
{
	private const byte PeriodBitCount = 7;

	public ushort Summary;

	public byte Shift;

	public byte Count;

	public void Initialize(uint initialValue)
	{
		Shift = 3;
		Summary = (ushort)(initialValue << (int)Shift);
		Count = 7;
	}

	public uint Mean()
	{
		uint num = (uint)(Summary >> (int)Shift);
		Summary = (ushort)(Summary - num);
		return (uint)(num + ((num == 0) ? 1 : 0));
	}

	public void Update()
	{
		if (Shift < 7 && --Count == 0)
		{
			Summary += Summary;
			Count = (byte)(3 << (int)Shift++);
		}
	}
}
