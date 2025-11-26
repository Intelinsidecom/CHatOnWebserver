using System;
using System.Collections.Generic;
using System.IO;
using System.IO.IsolatedStorage;
using System.Linq;
using System.Windows;
using System.Xml.Serialization;
using Microsoft.Phone.BackgroundTransfer;

namespace ChatOn.Services;

public class BackgroundFileService
{
	public delegate void TransferStatusChangedEventHandler(object sender, BackgroundTransferEventArgs e);

	public delegate void TransferProgressChangedEventHandler(object sender, BackgroundTransferEventArgs e);

	public delegate void TransferCompletedEventHandler(BackgroundTransferRequest request);

	private const string _REQUEST_LIST_FILENAME = "Request.dat";

	private static IEnumerable<BackgroundTransferRequest> _transferRequests;

	private static List<BackgroundFileRequestInfo> _requestList;

	private bool WaitingForExternalPower;

	private bool WaitingForExternalPowerDueToBatterySaverMode;

	private bool WaitingForNonVoiceBlockingNetwork;

	private bool WaitingForWiFi;

	public static List<BackgroundFileRequestInfo> RequestList
	{
		get
		{
			return _requestList;
		}
		set
		{
			_requestList = value;
		}
	}

	public event TransferStatusChangedEventHandler GetTransferStatusChanged;

	public event TransferProgressChangedEventHandler GetTransferProgressChanged;

	public event TransferCompletedEventHandler GetTransferCompleted;

	public void InitialTranferStatusCheck()
	{
		UpdateRequestsList();
		LoadRequestList();
		foreach (BackgroundTransferRequest transferRequest in _transferRequests)
		{
			transferRequest.TransferStatusChanged += TransferStatusChanged;
			transferRequest.TransferProgressChanged += TransferProgressChanged;
			ProcessTransfer(transferRequest);
		}
	}

	public void UpdateRequestsList()
	{
		if (_transferRequests != null)
		{
			foreach (BackgroundTransferRequest transferRequest in _transferRequests)
			{
				transferRequest.Dispose();
			}
		}
		_transferRequests = BackgroundTransferService.Requests;
	}

	private void TransferStatusChanged(object sender, BackgroundTransferEventArgs e)
	{
		UpdateRequestsList();
		ProcessTransfer(e.Request);
		if (this.GetTransferStatusChanged != null)
		{
			this.GetTransferStatusChanged(sender, e);
		}
	}

	private void TransferProgressChanged(object sender, BackgroundTransferEventArgs e)
	{
		UpdateRequestsList();
		if (this.GetTransferProgressChanged != null)
		{
			this.GetTransferProgressChanged(sender, e);
		}
	}

	private void ProcessTransfer(BackgroundTransferRequest transfer)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0029: Expected I4, but got Unknown
		TransferStatus transferStatus = transfer.TransferStatus;
		switch (transferStatus - 3)
		{
		case 5:
			if (transfer.StatusCode == 200 || transfer.StatusCode == 206)
			{
				using (IsolatedStorageFile isolatedStorageFile = IsolatedStorageFile.GetUserStoreForApplication())
				{
					if (this.GetTransferCompleted == null)
					{
						RemoveTransferRequest(transfer.RequestId, BackgroundFileRequestInfo.RequestStatus.Completed);
						if (transfer.DownloadLocation != null)
						{
							string text = transfer.Tag.Substring(0, transfer.Tag.LastIndexOf('/'));
							if (!isolatedStorageFile.DirectoryExists(text))
							{
								isolatedStorageFile.CreateDirectory(text);
							}
							string text2 = transfer.DownloadLocation.OriginalString.Substring(transfer.DownloadLocation.OriginalString.LastIndexOf("\\") + 1);
							text2 = text + "\\" + text2;
							if (isolatedStorageFile.FileExists(text2))
							{
								isolatedStorageFile.DeleteFile(text2);
							}
							isolatedStorageFile.MoveFile(transfer.DownloadLocation.OriginalString, text2);
						}
					}
					else
					{
						RemoveTransferRequest(transfer.RequestId, BackgroundFileRequestInfo.RequestStatus.Updated);
						BackgroundFileRequestInfo backgroundFileRequestInfo = new BackgroundFileRequestInfo();
						foreach (BackgroundFileRequestInfo request in _requestList)
						{
							if (request.RequestId == transfer.RequestId)
							{
								backgroundFileRequestInfo = request;
							}
						}
						if (backgroundFileRequestInfo == null || backgroundFileRequestInfo.Status != BackgroundFileRequestInfo.RequestStatus.Updated)
						{
							this.GetTransferCompleted(transfer);
						}
					}
					break;
				}
			}
			RemoveTransferRequest(transfer.RequestId, BackgroundFileRequestInfo.RequestStatus.Failed);
			if (transfer.TransferError == null)
			{
			}
			break;
		case 1:
			WaitingForExternalPower = true;
			break;
		case 2:
			WaitingForExternalPowerDueToBatterySaverMode = true;
			break;
		case 3:
			WaitingForNonVoiceBlockingNetwork = true;
			break;
		case 0:
			WaitingForWiFi = true;
			break;
		case 4:
			break;
		}
	}

	private void RemoveTransferRequest(string transferID, BackgroundFileRequestInfo.RequestStatus status)
	{
		BackgroundTransferRequest val = BackgroundTransferService.Find(transferID);
		try
		{
			BackgroundTransferService.Remove(val);
		}
		catch (Exception)
		{
		}
		if (_requestList == null)
		{
			return;
		}
		for (int num = _requestList.Count - 1; num >= 0; num--)
		{
			if (transferID == _requestList[num].RequestId)
			{
				if (status == BackgroundFileRequestInfo.RequestStatus.Completed)
				{
					_requestList[num].Status = status;
				}
				else
				{
					_requestList.RemoveAt(num);
				}
			}
		}
	}

	public void AddRequest(Uri requestUri, string fileName, string requestTag, BackgroundFileRequestInfo.RequestMode mode, string responseUri = null)
	{
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_001c: Expected O, but got Unknown
		if (GetBackgroundRequestCount() >= 5)
		{
			MessageBox.Show("The maximum number of background file transfer requests for this application has been exceeded. ");
			return;
		}
		BackgroundTransferRequest val = new BackgroundTransferRequest(requestUri);
		Uri uri = new Uri("shared/transfers/" + fileName, UriKind.RelativeOrAbsolute);
		if (BackgroundFileRequestInfo.RequestMode.DownloadMode == mode)
		{
			val.Method = "GET";
			val.DownloadLocation = uri;
		}
		else
		{
			val.Method = "POST";
			val.UploadLocation = uri;
		}
		val.Tag = requestTag;
		val.TransferPreferences = (TransferPreferences)3;
		try
		{
			val.TransferProgressChanged += TransferProgressChanged;
			val.TransferStatusChanged += TransferStatusChanged;
			BackgroundTransferService.Add(val);
			AddRequestToStack(val, responseUri);
		}
		catch (Exception ex)
		{
			MessageBox.Show("Unable to add background transfer request. " + ex.Message);
		}
	}

	private int GetBackgroundRequestCount()
	{
		return BackgroundTransferService.Requests.Count();
	}

	private void AddRequestToStack(BackgroundTransferRequest request, string responseUri = null)
	{
		BackgroundFileRequestInfo backgroundFileRequestInfo = new BackgroundFileRequestInfo();
		string[] array = Utility.Split(request.Tag, '/');
		backgroundFileRequestInfo.DirectoryName = array[0];
		backgroundFileRequestInfo.MessagID = new Guid(array[1]);
		backgroundFileRequestInfo.RequestUri = request.RequestUri.OriginalString;
		backgroundFileRequestInfo.Status = BackgroundFileRequestInfo.RequestStatus.Transferring;
		backgroundFileRequestInfo.RequestId = request.RequestId;
		backgroundFileRequestInfo.ResponseUri = responseUri;
		if (request.DownloadLocation != null)
		{
			backgroundFileRequestInfo.FileName = request.DownloadLocation.OriginalString;
			backgroundFileRequestInfo.Mode = BackgroundFileRequestInfo.RequestMode.DownloadMode;
		}
		else
		{
			backgroundFileRequestInfo.FileName = request.UploadLocation.OriginalString;
			backgroundFileRequestInfo.Mode = BackgroundFileRequestInfo.RequestMode.UploadMode;
		}
		_requestList.Add(backgroundFileRequestInfo);
	}

	public static void SaveRequestList()
	{
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		if (_requestList == null)
		{
			return;
		}
		for (int num = _requestList.Count - 1; num >= 0; num--)
		{
			if (_requestList[num].Status == BackgroundFileRequestInfo.RequestStatus.Updated)
			{
				_requestList.RemoveAt(num);
			}
		}
		try
		{
			IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
			IsolatedStorageFileStream isolatedStorageFileStream = userStoreForApplication.CreateFile("Request.dat");
			XmlSerializer val = new XmlSerializer(typeof(List<BackgroundFileRequestInfo>));
			val.Serialize((Stream)isolatedStorageFileStream, (object)_requestList);
			isolatedStorageFileStream.Close();
			isolatedStorageFileStream.Dispose();
		}
		catch (Exception)
		{
		}
	}

	public static void LoadRequestList()
	{
		//IL_003b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Expected O, but got Unknown
		if (_requestList == null)
		{
			_requestList = new List<BackgroundFileRequestInfo>();
		}
		try
		{
			IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
			if (userStoreForApplication.FileExists("Request.dat"))
			{
				IsolatedStorageFileStream isolatedStorageFileStream = userStoreForApplication.OpenFile("Request.dat", FileMode.Open);
				XmlSerializer val = new XmlSerializer(typeof(List<BackgroundFileRequestInfo>));
				_requestList = val.Deserialize((Stream)isolatedStorageFileStream) as List<BackgroundFileRequestInfo>;
				isolatedStorageFileStream.Close();
				isolatedStorageFileStream.Dispose();
			}
		}
		catch (Exception)
		{
		}
		for (int num = _requestList.Count - 1; num >= 0; num--)
		{
			bool flag = false;
			foreach (BackgroundTransferRequest transferRequest in _transferRequests)
			{
				if (_requestList[num].RequestId == transferRequest.RequestId)
				{
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				_requestList.RemoveAt(num);
			}
		}
	}

	public void CancelTransfer(string filename)
	{
		foreach (BackgroundTransferRequest transferRequest in _transferRequests)
		{
			string empty = string.Empty;
			empty = ((!(transferRequest.DownloadLocation != null)) ? transferRequest.UploadLocation.OriginalString.Substring(transferRequest.UploadLocation.OriginalString.LastIndexOf("\\") + 1) : transferRequest.DownloadLocation.OriginalString.Substring(transferRequest.DownloadLocation.OriginalString.LastIndexOf("\\") + 1));
			if (filename == empty)
			{
				RemoveTransferRequest(transferRequest.RequestId, BackgroundFileRequestInfo.RequestStatus.Canceled);
			}
		}
	}

	public void ResumeTransferEventHandler()
	{
		foreach (BackgroundTransferRequest transferRequest in _transferRequests)
		{
			transferRequest.TransferStatusChanged -= TransferStatusChanged;
			transferRequest.TransferProgressChanged -= TransferProgressChanged;
			transferRequest.TransferStatusChanged += TransferStatusChanged;
			transferRequest.TransferProgressChanged += TransferProgressChanged;
		}
	}
}
