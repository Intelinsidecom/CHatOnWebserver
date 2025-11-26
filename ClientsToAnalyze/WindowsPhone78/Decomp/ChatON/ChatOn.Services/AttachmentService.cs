using System;
using System.Device.Location;
using System.Windows;
using System.Windows.Media.Imaging;
using ChatOn.AnimationMessage;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Views;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Tasks;
using Microsoft.Phone.UserData;

namespace ChatOn.Services;

public class AttachmentService
{
	public delegate void AttachmentSelectCompletedEventHandler(Attachment attachment);

	private PhotoChooserTask photoChooser;

	private bool _isPhotoChooserActive;

	private CameraCaptureTask cameraCapture;

	private PhoneApplicationPage _returnPage;

	private string _sessionID;

	private static AttachmentService _instance;

	private PhoneNumberChooserTask numberTask;

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

	public PhoneApplicationPage ReturnPage
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
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0014: Expected O, but got Unknown
		if (!_isPhotoChooserActive)
		{
			photoChooser = new PhotoChooserTask();
			((ChooserBase<PhotoResult>)(object)photoChooser).Completed += photoChooser_Completed;
			((ChooserBase<PhotoResult>)(object)photoChooser).Show();
		}
	}

	public void AttachCapturedPicture()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		try
		{
			cameraCapture = new CameraCaptureTask();
			((ChooserBase<PhotoResult>)(object)cameraCapture).Completed += photoChooser_Completed;
			((ChooserBase<PhotoResult>)(object)cameraCapture).Show();
		}
		catch (Exception)
		{
		}
	}

	internal void ClearEventHandler()
	{
		this.AttachmentSelectCompleted = null;
	}

	private void photoChooser_Completed(object sender, PhotoResult e)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000e: Invalid comparison between Unknown and I4
		_isPhotoChooserActive = false;
		if ((int)((TaskEventArgs)e).TaskResult != 1)
		{
			((UIElement)(object)ReturnPage).Visibility = Visibility.Visible;
			return;
		}
		((UIElement)(object)ReturnPage).Visibility = Visibility.Collapsed;
		_isCropPageActive = true;
		ChatOnService.Instance.StreamToCrop = e.ChosenPhoto;
		((DependencyObject)(object)_returnPage).Dispatcher.BeginInvoke(delegate
		{
			ImageCropPage.CropCompleted += ImageCropPage_CropCompleted;
			PageNavigationService.OpenImageCropPage(_returnPage);
			_isCropPageActive = false;
		});
	}

	private void ImageCropPage_CropCompleted(object sender, object arg)
	{
		AttachedPhoto attachment = new AttachedPhoto(arg as WriteableBitmap, _sessionID);
		if (this.AttachmentSelectCompleted != null)
		{
			this.AttachmentSelectCompleted(attachment);
		}
	}

	public void AttachAnimationMessage(PhoneApplicationPage page)
	{
		AMSSend.ResetEventHander();
		AMSSend.SendRequested += AMSSend_SendRequested;
		PageNavigationService.OpenAMSPage(page);
	}

	private void AMSSend_SendRequested(AMSSendEventArgs arg)
	{
		AttachedAMS attachment = new AttachedAMS(arg.Buffer, _sessionID);
		if (this.AttachmentSelectCompleted != null)
		{
			this.AttachmentSelectCompleted(attachment);
		}
	}

	public void AttachContact()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		numberTask = new PhoneNumberChooserTask();
		((ChooserBase<PhoneNumberResult>)(object)numberTask).Completed += numberTask_Completed;
		try
		{
			((ChooserBase<PhoneNumberResult>)(object)numberTask).Show();
		}
		catch (InvalidOperationException)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN);
		}
	}

	private void numberTask_Completed(object sender, PhoneNumberResult e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		if ((int)((TaskEventArgs)e).TaskResult != 1)
		{
			((UIElement)(object)ReturnPage).Visibility = Visibility.Visible;
			return;
		}
		((UIElement)(object)ReturnPage).Visibility = Visibility.Collapsed;
		AttachedContact attachment = new AttachedContact(e.DisplayName, e.PhoneNumber, _sessionID);
		if (this.AttachmentSelectCompleted != null)
		{
			this.AttachmentSelectCompleted(attachment);
		}
	}

	public void AttachCalendar(PhoneApplicationPage page)
	{
		PageNavigationService.OpenAttachCalendarPage(page);
	}

	public void CalendarChooser_Completed(object sender, Appointment appt)
	{
		AttachedCalendar attachment = new AttachedCalendar(appt, _sessionID);
		if (this.AttachmentSelectCompleted != null)
		{
			this.AttachmentSelectCompleted(attachment);
		}
	}

	public void AttachLocation(PhoneApplicationPage page)
	{
		PageNavigationService.OpenAttachLocationPage(page);
	}

	public void LocationChooser_Completed(object sender, GeoCoordinate location)
	{
		AttachedLocation attachedLocation = new AttachedLocation();
		attachedLocation.LocationInfo = location;
		if (this.AttachmentSelectCompleted != null)
		{
			this.AttachmentSelectCompleted(attachedLocation);
		}
	}

	internal bool IsAttachmentEventRegistered()
	{
		return this.AttachmentSelectCompleted != null;
	}
}
