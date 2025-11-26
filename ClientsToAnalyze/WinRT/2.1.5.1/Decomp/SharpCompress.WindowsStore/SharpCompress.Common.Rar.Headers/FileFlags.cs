using System;

namespace SharpCompress.Common.Rar.Headers;

[Flags]
internal enum FileFlags : ushort
{
	SPLIT_BEFORE = 1,
	SPLIT_AFTER = 2,
	PASSWORD = 4,
	COMMENT = 8,
	SOLID = 0x10,
	WINDOWMASK = 0xE0,
	WINDOW64 = 0,
	WINDOW128 = 0x20,
	WINDOW256 = 0x40,
	WINDOW512 = 0x60,
	WINDOW1024 = 0x80,
	WINDOW2048 = 0xA0,
	WINDOW4096 = 0xC0,
	DIRECTORY = 0xE0,
	LARGE = 0x100,
	UNICODE = 0x200,
	SALT = 0x400,
	VERSION = 0x800,
	EXTTIME = 0x1000,
	EXTFLAGS = 0x2000
}
