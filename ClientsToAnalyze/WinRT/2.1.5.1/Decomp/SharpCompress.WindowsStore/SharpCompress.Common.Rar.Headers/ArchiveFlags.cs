using System;

namespace SharpCompress.Common.Rar.Headers;

[Flags]
internal enum ArchiveFlags
{
	VOLUME = 1,
	COMMENT = 2,
	LOCK = 4,
	SOLID = 8,
	NEWNUMBERING = 0x10,
	AV = 0x20,
	PROTECT = 0x40,
	PASSWORD = 0x80,
	FIRSTVOLUME = 0x100,
	ENCRYPTVER = 0x200
}
