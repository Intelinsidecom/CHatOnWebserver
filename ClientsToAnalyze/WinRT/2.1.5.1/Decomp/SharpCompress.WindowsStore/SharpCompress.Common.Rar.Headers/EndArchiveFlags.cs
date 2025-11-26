using System;

namespace SharpCompress.Common.Rar.Headers;

[Flags]
internal enum EndArchiveFlags
{
	EARC_NEXT_VOLUME = 1,
	EARC_DATACRC = 2,
	EARC_REVSPACE = 4,
	EARC_VOLNUMBER = 8
}
