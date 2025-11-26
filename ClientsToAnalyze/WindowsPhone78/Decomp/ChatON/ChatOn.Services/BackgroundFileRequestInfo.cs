using System;

namespace ChatOn.Services;

public class BackgroundFileRequestInfo
{
	public enum RequestStatus
	{
		Transferring,
		Completed,
		Updated,
		Canceled,
		Failed
	}

	public enum RequestMode
	{
		UploadMode,
		DownloadMode
	}

	public string FileName { get; set; }

	public string DirectoryName { get; set; }

	public Guid MessagID { get; set; }

	public RequestMode Mode { get; set; }

	public string RequestUri { get; set; }

	public string RequestId { get; set; }

	public RequestStatus Status { get; set; }

	public string ResponseUri { get; set; }
}
