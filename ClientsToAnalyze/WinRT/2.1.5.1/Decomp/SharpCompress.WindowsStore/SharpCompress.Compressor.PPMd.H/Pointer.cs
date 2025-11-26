namespace SharpCompress.Compressor.PPMd.H;

internal abstract class Pointer
{
	internal byte[] Memory { get; private set; }

	internal virtual int Address { get; set; }

	internal Pointer(byte[] mem)
	{
		Memory = mem;
	}

	protected T Initialize<T>(byte[] mem) where T : Pointer
	{
		Memory = mem;
		Address = 0;
		return this as T;
	}
}
