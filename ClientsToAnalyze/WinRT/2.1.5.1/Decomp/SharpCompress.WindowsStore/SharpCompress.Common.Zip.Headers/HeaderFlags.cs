using System;

namespace SharpCompress.Common.Zip.Headers;

[Flags]
internal enum HeaderFlags : ushort
{
	Encrypted = 1,
	Bit1 = 2,
	Bit2 = 4,
	UsePostDataDescriptor = 8,
	EnhancedDeflate = 0x10,
	UTF8 = 0x800
}
