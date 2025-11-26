using System;
using Windows.Storage;

namespace ChatOn.Services;

public class BackgroungFileTransferArgument
{
	public StorageFile File { get; set; }

	public Exception Error { get; set; }
}
