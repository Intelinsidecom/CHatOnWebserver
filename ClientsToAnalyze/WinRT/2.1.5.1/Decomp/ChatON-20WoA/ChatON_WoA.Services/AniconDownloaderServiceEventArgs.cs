using System;
using ChatOn.Models;

namespace ChatON_WoA.Services;

public class AniconDownloaderServiceEventArgs
{
	public Exception Error { get; set; }

	public OfflineAniconPackage AniconPackage { get; set; }
}
