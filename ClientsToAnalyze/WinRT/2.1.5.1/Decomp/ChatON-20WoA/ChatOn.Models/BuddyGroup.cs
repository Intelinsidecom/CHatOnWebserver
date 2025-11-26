using System;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using SDatabase;
using Windows.Storage;
using Windows.UI;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class BuddyGroup : SDBData
{
	private Guid _groupID;

	private string _name = "";

	private string _members = "";

	private string _imagePath = "";

	private Guid _directChatID = Guid.Empty;

	private BitmapImage _profileImage = new BitmapImage(new Uri("ms-appx:///Images/chat_info_group.png"));

	private Brush _statusForeground = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 33, 146, 151));

	[SDBColumn]
	public Guid GroupID
	{
		get
		{
			return _groupID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _groupID != value)
			{
				SetDataUpdated();
			}
			_groupID = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => GroupID);
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

	[SDBColumn(Encrypt = true)]
	public string Members
	{
		get
		{
			return _members;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _members != value)
			{
				SetDataUpdated();
			}
			_members = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Members);
			}
		}
	}

	[SDBColumn]
	public string ImagePath
	{
		get
		{
			if (string.IsNullOrEmpty(_imagePath))
			{
				return _groupID.ToString();
			}
			return _imagePath;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _imagePath != value)
			{
				SetDataUpdated();
			}
			_imagePath = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ImagePath);
			}
		}
	}

	[SDBColumn]
	public Guid DirectChatID
	{
		get
		{
			return _directChatID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _directChatID != value)
			{
				SetDataUpdated();
			}
			_directChatID = value;
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			//IL_0012: Unknown result type (might be due to invalid IL or missing references)
			//IL_0018: Expected O, but got Unknown
			if (_profileImage == null)
			{
				return new BitmapImage(new Uri("ms-appx:///Images/chat_info_group.png"));
			}
			return _profileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	public Brush StatusForeground
	{
		get
		{
			return _statusForeground;
		}
		set
		{
			_statusForeground = value;
			NotifyPropertyChanged(() => StatusForeground);
		}
	}

	public BuddyGroup()
	{
		//IL_0037: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Expected O, but got Unknown
		//IL_0058: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Expected O, but got Unknown
		_groupID = Guid.NewGuid();
	}

	public async void LoadProfileImage()
	{
		string fileName = _imagePath.Split('/')[_imagePath.Split('/').Length - 1];
		if (!string.IsNullOrEmpty(fileName) && _imagePath.Contains("http"))
		{
			ProfileImage = await Utility.LoadOrSaveWebImage(fileName, new Uri(GetProfileImagePath()), "Group");
		}
		else if (await Utility.IsFileExist("Group", GetProfileImagePath()) != null)
		{
			_ = ApplicationData.Current.LocalFolder;
			Uri pathImage = new Uri($"ms-appdata:///local/Group/{GetProfileImagePath()}", UriKind.Absolute);
			ProfileImage = new BitmapImage(pathImage);
		}
	}

	public async void LoadProfileImage(Uri uri)
	{
		if (uri.Query == null)
		{
			return;
		}
		uri.ToString().Split('&');
		try
		{
			string fileName = GetProfileImagePath();
			BitmapImage profileImage = await Utility.LoadImage(fileName, "Group");
			if (profileImage == null || ((BitmapSource)profileImage).PixelHeight == 0)
			{
				ProfileImage = await Utility.LoadOrSaveWebImage(fileName, uri, "Group");
			}
			else
			{
				ProfileImage = profileImage;
			}
		}
		catch
		{
		}
		finally
		{
			ProfileImage = _profileImage;
		}
	}

	public async Task UpdateProfileImage(Uri uri)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			BitmapImage downloadedImage = await Utility.LoadOrSaveWebImage(GetProfileImagePath(), uri, "Group", forceUpdate: true);
			if (downloadedImage != null && ((BitmapSource)downloadedImage).PixelHeight != 0)
			{
				_profileImage = downloadedImage;
			}
		}
		catch (Exception)
		{
		}
	}

	private string GetProfileImagePath()
	{
		return ImagePath + ".jpg";
	}

	public async void LoadProfileImageIfFileExist(string path)
	{
		try
		{
			if (!path.Contains("ms-appdata"))
			{
				path = "ms-appdata:///local/Group/" + path;
			}
			if ((await (await StorageFile.GetFileFromApplicationUriAsync(new Uri(path))).GetBasicPropertiesAsync()).Size == 0)
			{
				_profileImage = null;
			}
			else
			{
				_profileImage = new BitmapImage(new Uri(path));
			}
		}
		catch (Exception)
		{
			_profileImage = null;
		}
	}
}
