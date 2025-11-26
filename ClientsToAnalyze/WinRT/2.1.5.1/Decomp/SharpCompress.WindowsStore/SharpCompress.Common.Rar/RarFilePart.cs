using System.IO;
using SharpCompress.Common.Rar.Headers;

namespace SharpCompress.Common.Rar;

internal abstract class RarFilePart : FilePart
{
	internal MarkHeader MarkHeader { get; private set; }

	internal FileHeader FileHeader { get; private set; }

	internal RarFilePart(MarkHeader mh, FileHeader fh)
	{
		MarkHeader = mh;
		FileHeader = fh;
	}

	internal override Stream GetRawStream()
	{
		return null;
	}
}
