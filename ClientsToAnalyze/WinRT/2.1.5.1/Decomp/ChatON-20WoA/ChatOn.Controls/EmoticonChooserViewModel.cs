using System;
using System.Collections.ObjectModel;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.InfraStructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Controls;

public class EmoticonChooserViewModel : NotificationObject
{
	private Uri baseUri;

	private EmoticonChooserActiveItem _activeItem;

	public ObservableCollection<OfflineAniconPackage> ListOfAniconPackages { get; set; }

	public ObservableCollection<AniconEmoticonItem> ListOfEmoticonItems { get; set; }

	public OfflineAniconPackage SelectedAnicon { get; set; }

	public Visibility ShowLoadingRing { get; set; }

	public EmoticonChooserActiveItem ActiveItem
	{
		get
		{
			return _activeItem;
		}
		set
		{
			_activeItem = value;
			NotifyPropertyChanged("");
		}
	}

	public Visibility ShowEmoticonItems
	{
		get
		{
			if (ActiveItem == EmoticonChooserActiveItem.Emoticon)
			{
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

	public Visibility ShowAnicon_Items
	{
		get
		{
			if (ActiveItem != EmoticonChooserActiveItem.Anicon_Filled && ActiveItem != EmoticonChooserActiveItem.Anicon_Empty)
			{
				return (Visibility)1;
			}
			return (Visibility)0;
		}
	}

	public Visibility ShowAnicon_FilledItems
	{
		get
		{
			if (ActiveItem == EmoticonChooserActiveItem.Anicon_Filled)
			{
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

	public Visibility ShowAnicon_EmptyItems
	{
		get
		{
			if (ActiveItem == EmoticonChooserActiveItem.Anicon_Empty)
			{
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

	public string TitleTextDisplay
	{
		get
		{
			string result = "";
			switch (ActiveItem)
			{
			case EmoticonChooserActiveItem.Anicon_Filled:
				result = Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
				break;
			case EmoticonChooserActiveItem.Anicon_Empty:
				result = Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
				break;
			case EmoticonChooserActiveItem.Emoticon:
				result = Utility.GetResourceString("IDS_CHATON_SK3_EMOTICON");
				break;
			}
			return result;
		}
	}

	public AsyncDelegateCommand OnNavigatedToCommand { get; set; }

	public AsyncDelegateCommand<OfflineAniconPackage> OnSelectAniconPackageCommand { get; set; }

	public EmoticonChooserViewModel(Uri baseuri)
	{
		baseUri = baseuri;
		ListOfEmoticonItems = new ObservableCollection<AniconEmoticonItem>();
		ListOfAniconPackages = new ObservableCollection<OfflineAniconPackage>();
		OnNavigatedToCommand = new AsyncDelegateCommand(OnNavigatedTo);
		OnSelectAniconPackageCommand = new AsyncDelegateCommand<OfflineAniconPackage>(OnSelectAniconPackage);
		ActiveItem = EmoticonChooserActiveItem.Emoticon;
	}

	public async Task OnNavigatedTo()
	{
		ShowLoadingRing = (Visibility)0;
		NotifyPropertyChanged(() => ShowLoadingRing);
		ActiveItem = EmoticonChooserActiveItem.Emoticon;
		SelectedAnicon = null;
		ListOfAniconPackages.Clear();
		if (ListOfEmoticonItems.Count == 0)
		{
			await LoadEmoticons();
		}
		ShowLoadingRing = (Visibility)1;
		NotifyPropertyChanged(() => ShowLoadingRing);
		await LoadListofAnicons();
	}

	public async Task OnSelectAniconPackage(OfflineAniconPackage package)
	{
		ActiveItem = EmoticonChooserActiveItem.Anicon_Filled;
		if (package == null)
		{
			return;
		}
		if (SelectedAnicon != null)
		{
			SelectedAnicon.LoadCancel();
		}
		SelectedAnicon = package;
		package.LoadEnable();
		foreach (OfflineAniconPackage listOfAniconPackage in ListOfAniconPackages)
		{
			listOfAniconPackage.IsSelected = ((listOfAniconPackage == package) ? true : false);
			listOfAniconPackage.NotifyPropertyChanged("");
		}
		ShowLoadingRing = (Visibility)0;
		NotifyPropertyChanged(() => ShowLoadingRing);
		SelectedAnicon.LoadDelegateImages();
		ShowLoadingRing = (Visibility)1;
		NotifyPropertyChanged("");
	}

	public async Task LoadEmoticons()
	{
		int num = 0;
		string[] emotiStringArray = EmoticonChooser.EmotiStringArray;
		foreach (string text in emotiStringArray)
		{
			AniconEmoticonItem aniconEmoticonItem = new AniconEmoticonItem();
			aniconEmoticonItem.Text = text;
			aniconEmoticonItem.ImageData = new BitmapImage(new Uri(baseUri, "/Images/Emoticon/1-" + (num + 1) + ".png"));
			ListOfEmoticonItems.Add(aniconEmoticonItem);
			num++;
		}
	}

	public async Task LoadListofAnicons()
	{
		foreach (OfflineAniconPackage package in ChatOnService.Instance.AniconPackages)
		{
			ListOfAniconPackages.Add(package);
			package.IsSelected = false;
			await package.LoadThumbImageFile();
			package.LoadThumbImage();
		}
	}

	public async Task LoadListofSelectedAnicon()
	{
	}
}
