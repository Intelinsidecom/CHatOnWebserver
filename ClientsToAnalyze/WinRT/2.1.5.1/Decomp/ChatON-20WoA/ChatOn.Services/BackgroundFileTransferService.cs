using System;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using Windows.Networking.BackgroundTransfer;
using Windows.Storage;
using Windows.Web;

namespace ChatOn.Services;

public class BackgroundFileTransferService
{
	public delegate void BackgroundFileTransferServiceEventHandler(object sender, BackgroungFileTransferArgument e);

	private List<DownloadOperation> activeDownloads;

	private CancellationTokenSource cts;

	public BackgroundFileTransferServiceEventHandler BackgroundDownloadCompleted;

	public BackgroundFileTransferService()
	{
		cts = new CancellationTokenSource();
		activeDownloads = new List<DownloadOperation>();
	}

	public async Task DiscoverActiveDownloadsAsync()
	{
		activeDownloads = new List<DownloadOperation>();
		IReadOnlyList<DownloadOperation> downloads;
		try
		{
			downloads = await BackgroundDownloader.GetCurrentDownloadsAsync();
		}
		catch (Exception ex)
		{
			if (!IsExceptionHandled("Discovery error", ex))
			{
				throw;
			}
			return;
		}
		if (downloads.Count <= 0)
		{
			return;
		}
		List<Task> tasks = new List<Task>();
		foreach (DownloadOperation item in downloads)
		{
			tasks.Add(HandleDownloadAsync(item, start: false));
		}
		await Task.WhenAll(tasks);
	}

	private async Task HandleDownloadAsync(DownloadOperation download, bool start)
	{
		try
		{
			activeDownloads.Add(download);
			Progress<DownloadOperation> progressCallback = new Progress<DownloadOperation>(DownloadProgress);
			if (!start)
			{
				await download.AttachAsync().AsTask<DownloadOperation, DownloadOperation>(cts.Token, progressCallback);
			}
			else
			{
				await download.StartAsync().AsTask<DownloadOperation, DownloadOperation>(cts.Token, progressCallback);
			}
			download.GetResponseInformation();
		}
		catch (TaskCanceledException)
		{
		}
		catch (Exception ex2)
		{
			if (!IsExceptionHandled("Execution error", ex2, download))
			{
				throw;
			}
		}
		finally
		{
			activeDownloads.Remove(download);
		}
	}

	private bool IsExceptionHandled(string title, Exception ex, DownloadOperation download = null)
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Unknown result type (might be due to invalid IL or missing references)
		WebErrorStatus status = BackgroundTransferError.GetStatus(ex.HResult);
		if ((int)status == 0)
		{
			return false;
		}
		return true;
	}

	private void DownloadProgress(DownloadOperation download)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Unknown result type (might be due to invalid IL or missing references)
		if (download.Progress.TotalBytesToReceive != 0)
		{
			_ = download.Progress.BytesReceived * 100 / download.Progress.TotalBytesToReceive;
		}
		_ = download.Progress.HasRestarted;
		_ = download.Progress.HasResponseChanged;
		_ = download.Progress.TotalBytesToReceive;
		_ = 0;
	}

	public async Task<StorageFile> AddDownload(Uri uri, string filename, string folder)
	{
		try
		{
			BackgroundDownloader downloader = new BackgroundDownloader();
			StorageFile destinationFile = await Utility.CreateLocalFile(filename, folder, replaceExisting: true);
			DownloadOperation download = downloader.CreateDownload(uri, (IStorageFile)(object)destinationFile);
			await HandleDownloadAsync(download, start: true);
			return destinationFile;
		}
		catch (Exception)
		{
			return null;
		}
	}
}
