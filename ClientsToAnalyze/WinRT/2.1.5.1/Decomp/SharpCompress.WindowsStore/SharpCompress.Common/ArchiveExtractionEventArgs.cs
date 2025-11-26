using System;

namespace SharpCompress.Common;

public class ArchiveExtractionEventArgs<T> : EventArgs
{
	public T Item { get; private set; }

	internal ArchiveExtractionEventArgs(T entry)
	{
		Item = entry;
	}
}
