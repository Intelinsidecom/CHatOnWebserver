using System;
using SharpCompress.Compressor.PPMd.I1;

namespace SharpCompress.Compressor.PPMd;

public class PpmdProperties
{
	public PpmdVersion Version = PpmdVersion.I1;

	public int ModelOrder;

	internal ModelRestorationMethod ModelRestorationMethod;

	private int allocatorSize;

	internal Allocator Allocator;

	public int AllocatorSize
	{
		get
		{
			return allocatorSize;
		}
		set
		{
			allocatorSize = value;
			if (Version == PpmdVersion.I1)
			{
				if (Allocator == null)
				{
					Allocator = new Allocator();
				}
				Allocator.Start(allocatorSize);
			}
		}
	}

	public byte[] Properties => BitConverter.GetBytes((ushort)(ModelOrder - 1 + ((AllocatorSize >> 20) - 1 << 4) + ((ushort)ModelRestorationMethod << 12)));

	public PpmdProperties()
		: this(16777216, 6)
	{
	}

	public PpmdProperties(int allocatorSize, int modelOrder)
		: this(allocatorSize, modelOrder, ModelRestorationMethod.Restart)
	{
	}

	internal PpmdProperties(int allocatorSize, int modelOrder, ModelRestorationMethod modelRestorationMethod)
	{
		AllocatorSize = allocatorSize;
		ModelOrder = modelOrder;
		ModelRestorationMethod = modelRestorationMethod;
	}

	public PpmdProperties(byte[] properties)
	{
		if (properties.Length == 2)
		{
			ushort num = BitConverter.ToUInt16(properties, 0);
			AllocatorSize = ((num >> 4) & 0xFF) + 1 << 20;
			ModelOrder = (num & 0xF) + 1;
			ModelRestorationMethod = (ModelRestorationMethod)(num >> 12);
		}
		else if (properties.Length == 5)
		{
			Version = PpmdVersion.H7z;
			AllocatorSize = BitConverter.ToInt32(properties, 1);
			ModelOrder = properties[0];
		}
	}
}
