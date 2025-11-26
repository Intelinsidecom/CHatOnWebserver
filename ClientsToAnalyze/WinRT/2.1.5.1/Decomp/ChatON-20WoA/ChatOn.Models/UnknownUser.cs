using System;
using System.Collections.Generic;
using System.Net;
using ChatOn.Infrastructure;
using ChatOn.Queue;
using ChatOn.Services;
using SDatabase;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class UnknownUser : SDBData
{
	public delegate void UnknownUserEventHandler(object sender, object e);

	private Guid _unknownUserID;

	private string _phoneNumber = "";

	private string _name = "";

	private Uri _profileImageUri;

	private bool _isDeregistered;

	private BitmapImage _profileImage;

	private BitmapImage _flagImage;

	private Buddy.ProfileImgStatus _imgStatus;

	private string _status;

	public bool _isUpdating;

	private bool _isBlocked;

	private string _infoMessage = "";

	private bool _isDownloading;

	private string _countryCode;

	public bool IsAddible
	{
		get
		{
			if (!_isDeregistered)
			{
				return !_isBlocked;
			}
			return false;
		}
	}

	public string InfoMessage
	{
		get
		{
			return _infoMessage;
		}
		set
		{
			_infoMessage = value;
			NotifyPropertyChanged(() => InfoMessage);
		}
	}

	public bool IsBlocked
	{
		get
		{
			return _isBlocked;
		}
		set
		{
			_isBlocked = value;
			NotifyPropertyChanged(() => IsBlocked);
			NotifyPropertyChanged(() => IsAddible);
		}
	}

	public string Status
	{
		get
		{
			return _status;
		}
		set
		{
			_status = value;
			NotifyPropertyChanged(() => Status);
		}
	}

	public Buddy.ProfileImgStatus ImgStatus
	{
		get
		{
			return _imgStatus;
		}
		set
		{
			_imgStatus = value;
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			return _profileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	public BitmapImage FlagImage
	{
		get
		{
			return _flagImage;
		}
		set
		{
			_flagImage = value;
			NotifyPropertyChanged(() => FlagImage);
		}
	}

	[SDBColumn]
	public bool IsDeregistered
	{
		get
		{
			return _isDeregistered;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isDeregistered != value)
			{
				SetDataUpdated();
			}
			_isDeregistered = value;
			NotifyPropertyChanged(() => IsDeregistered);
			NotifyPropertyChanged(() => IsAddible);
		}
	}

	[SDBColumn]
	public Guid UnknownUserID
	{
		get
		{
			return _unknownUserID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _unknownUserID != value)
			{
				SetDataUpdated();
			}
			_unknownUserID = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => UnknownUserID);
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _phoneNumber != value)
			{
				SetDataUpdated();
			}
			_phoneNumber = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => PhoneNumber);
			}
		}
	}

	[SDBColumn]
	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _name != value)
			{
				SetDataUpdated();
			}
			_name = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Name);
			}
		}
	}

	public string CountryCode
	{
		get
		{
			return _countryCode;
		}
		set
		{
			_countryCode = value;
		}
	}

	public Uri ProfileImageUri
	{
		get
		{
			return _profileImageUri;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _profileImageUri != value)
			{
				SetDataUpdated();
			}
			_profileImageUri = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ProfileImageUri);
			}
		}
	}

	public bool IsDownloading
	{
		get
		{
			return _isDownloading;
		}
		set
		{
			_isDownloading = value;
			NotifyPropertyChanged(() => IsDownloading);
		}
	}

	public event UnknownUserEventHandler LoadProfileImageCompleted;

	public event UnknownUserEventHandler LoadFlagImageCompleted;

	public UnknownUser()
	{
		_unknownUserID = Guid.NewGuid();
	}

	public UnknownUser(string name, string number)
	{
		_unknownUserID = Guid.NewGuid();
		_name = name;
		_phoneNumber = number;
		IsDownloading = true;
	}

	public void LoadProfileImage(bool applyTheme = false, object arg = null)
	{
		if (IsDeregistered)
		{
			SetDefaultImage();
			IsDownloading = false;
			return;
		}
		if (_isUpdating)
		{
			IsDownloading = false;
			return;
		}
		SetDefaultImage();
		_isUpdating = true;
		DataService dataService = new DataService();
		SSMService ssmService = new SSMService();
		ssmService.CheckBuddyProfileCompleted += delegate(object s, SSMCompletedEventArgs e)
		{
			//IL_00bf: Unknown result type (might be due to invalid IL or missing references)
			//IL_00c9: Expected O, but got Unknown
			if (e.Xml != null)
			{
				BuddyService buddyService = new BuddyService(dataService, ssmService);
				UnknownUser unknownUser = buddyService.ParseUnknownBuddyInfos(e.Xml);
				Status = unknownUser.Status;
				CountryCode = unknownUser.CountryCode;
				if (Name != unknownUser.Name)
				{
					Name = unknownUser.Name;
					SetMessage(Name);
				}
				if (unknownUser.ImgStatus == Buddy.ProfileImgStatus.NoChanges || unknownUser.ImgStatus == Buddy.ProfileImgStatus.Updated)
				{
					ProfileImage = new BitmapImage(ssmService.GetBuddyProfileImageUri(_phoneNumber));
				}
				else
				{
					SetDefaultImage();
				}
				QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
				queueEngine.Add(new GetNationalFlag_QueueItem(ssmService, CountryCode)
				{
					InvokeBack = delegate(object o, Exception ex)
					{
						if (ex == null)
						{
							FlagImage = (BitmapImage)((o is BitmapImage) ? o : null);
							Logger.Log("Unknown User -> National Flag Retreived --> w :" + ((BitmapSource)((o is BitmapImage) ? o : null)).PixelWidth + " h : " + ((BitmapSource)((o is BitmapImage) ? o : null)).PixelHeight);
							if (this.LoadFlagImageCompleted != null)
							{
								this.LoadFlagImageCompleted(this, arg);
							}
						}
					}
				});
			}
			else
			{
				SetDefaultImage();
				if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CCS-25009"))
				{
					IsDeregistered = true;
					SetMessage(Name);
				}
				else if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CCS-25007"))
				{
					IsBlocked = true;
					SetMessage(Name);
				}
			}
			if (this.LoadProfileImageCompleted != null)
			{
				this.LoadProfileImageCompleted(this, arg);
			}
			IsDownloading = false;
			dataService.UnknownUserDBSubmitChanges();
		};
		ssmService.CheckBuddyProfileAsync(_phoneNumber);
	}

	public void LoadProfileImageOnly(bool applyTheme = false, object arg = null)
	{
		if (IsDeregistered)
		{
			SetDefaultImage();
		}
		else
		{
			if (_isUpdating)
			{
				return;
			}
			SetDefaultImage();
			_isUpdating = true;
			DataService dataService = new DataService();
			SSMService ssmService = new SSMService();
			ssmService.CheckBuddyProfileCompleted += delegate(object s, SSMCompletedEventArgs e)
			{
				//IL_00ca: Unknown result type (might be due to invalid IL or missing references)
				//IL_00d4: Expected O, but got Unknown
				if (e.StatusCode != HttpStatusCode.NoContent)
				{
					if (e.Xml != null)
					{
						BuddyService buddyService = new BuddyService(dataService, ssmService);
						UnknownUser unknownUser = buddyService.ParseUnknownBuddyInfos(e.Xml);
						Status = unknownUser.Status;
						CountryCode = unknownUser.CountryCode;
						if (Name != unknownUser.Name)
						{
							Name = unknownUser.Name;
							SetMessage(Name);
						}
						if (unknownUser.ImgStatus == Buddy.ProfileImgStatus.NoChanges || unknownUser.ImgStatus == Buddy.ProfileImgStatus.Updated)
						{
							ProfileImage = new BitmapImage(ssmService.GetBuddyProfileImageUri(_phoneNumber));
						}
						else
						{
							SetDefaultImage();
						}
					}
					else
					{
						SetDefaultImage();
						if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CCS-25009"))
						{
							IsDeregistered = true;
							SetMessage(Name);
							dataService.UnknownUserDBSubmitChanges();
						}
						else if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CCS-25007"))
						{
							IsBlocked = true;
							SetMessage(Name);
						}
					}
					if (this.LoadProfileImageCompleted != null)
					{
						this.LoadProfileImageCompleted(this, arg);
					}
				}
			};
			ssmService.CheckBuddyProfileAsync(_phoneNumber);
		}
	}

	private void SetDefaultImage()
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Expected O, but got Unknown
		ProfileImage = new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/buddies_profile_image.png"));
	}

	public void SetMessage(string name)
	{
		string text = "";
		if (IsDeregistered)
		{
			text = Utility.GetResourceString("IDS_CHATON_POP_PS_IS_DELETED_ACCOUNT");
			text = text.Replace("%s", name);
		}
		else if (IsBlocked)
		{
			text = Utility.GetResourceString("IDS_CHATON_POP_PS_BLOCKED");
			text = text.Replace("%s", name);
		}
		else
		{
			text = Utility.GetResourceString("IDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q");
			text = text.Replace("%s", "{0:}");
			text = string.Format(text, new object[1] { name });
		}
		InfoMessage = text;
	}
}
