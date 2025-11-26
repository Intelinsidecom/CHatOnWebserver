using ChatOn.Models;
using Windows.UI.Xaml.Controls;

namespace ChatOn.Services;

public class AttachmentService
{
	public delegate void AttachmentSelectCompletedEventHandler(Attachment attachment);

	private bool _isPhotoChooserActive;

	private Page _returnPage;

	private string _sessionID;

	private static AttachmentService _instance;

	private bool _isCropPageActive;

	public bool IsCropPageActive
	{
		get
		{
			return _isCropPageActive;
		}
		set
		{
			_isCropPageActive = value;
		}
	}

	public Page ReturnPage
	{
		get
		{
			return _returnPage;
		}
		set
		{
			_returnPage = value;
		}
	}

	public string SessionID
	{
		get
		{
			return _sessionID;
		}
		set
		{
			_sessionID = value;
		}
	}

	public static AttachmentService Instance
	{
		get
		{
			if (_instance == null)
			{
				_instance = new AttachmentService();
			}
			return _instance;
		}
	}

	public event AttachmentSelectCompletedEventHandler AttachmentSelectCompleted;

	public void AttachPicture()
	{
		_ = _isPhotoChooserActive;
	}

	public void AttachCapturedPicture()
	{
	}

	internal void ClearEventHandler()
	{
		this.AttachmentSelectCompleted = null;
	}

	public void AttachAnimationMessage(Page page)
	{
	}

	public void AttachContact()
	{
	}

	public void AttachCalendar(Page page)
	{
	}

	public void AttachLocation(Page page)
	{
	}

	internal bool IsAttachmentEventRegistered()
	{
		return this.AttachmentSelectCompleted != null;
	}
}
