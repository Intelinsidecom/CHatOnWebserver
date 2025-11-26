using System;
using System.Collections.ObjectModel;
using System.Windows;
using System.Windows.Media.Imaging;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Tasks;

namespace ChatOn.ViewModels;

public class SkinSettingPageViewModel : NotificationObject
{
	private static int AddNewBGIndex = -1;

	private static int CustomBGIndex = 0;

	private SkinSettingPage _page;

	private ObservableCollection<SkinItem> _BGItems = new ObservableCollection<SkinItem>();

	private ObservableCollection<SkinItem> _bubbleItems = new ObservableCollection<SkinItem>();

	private BitmapImage _backgroundImage;

	private PhotoChooserTask _photoChooser;

	private int _orginalBGType;

	private int _orginalBubbleType;

	private long _previewBubbleDate1;

	public long PreviewBubbleDate1
	{
		get
		{
			return _previewBubbleDate1;
		}
		set
		{
			_previewBubbleDate1 = value;
		}
	}

	public BitmapImage BackgroundImage
	{
		get
		{
			return _backgroundImage;
		}
		set
		{
			_backgroundImage = value;
			NotifyPropertyChanged(() => BackgroundImage);
		}
	}

	public ObservableCollection<SkinItem> BubbleItems
	{
		get
		{
			return _bubbleItems;
		}
		set
		{
			_bubbleItems = value;
		}
	}

	public ObservableCollection<SkinItem> BGItems
	{
		get
		{
			return _BGItems;
		}
		set
		{
			_BGItems = value;
		}
	}

	public SkinSettingPageViewModel(SkinSettingPage page)
	{
		_page = page;
		loadBGItems();
		loadBubbleItems();
		BackgroundImage = SettingService.GetSelectedBG();
		_orginalBGType = SettingService.GetBGType();
		_orginalBubbleType = SettingService.GetBubbleType();
		_previewBubbleDate1 = Utility.GetTimeStamp();
	}

	private void loadBGItems()
	{
		SkinItem skinItem = new SkinItem();
		skinItem.Image = new BitmapImage(new Uri("\\Images\\ChatBGs\\add_skin.png", UriKind.Relative))
		{
			CreateOptions = BitmapCreateOptions.BackgroundCreation
		};
		skinItem.Value = AddNewBGIndex;
		_BGItems.Add(skinItem);
		int bGType = SettingService.GetBGType();
		if (IsoSettingHelper.Get("CustomBG", defaultValue: false))
		{
			skinItem = new SkinItem();
			skinItem.Image = Utility.LoadJpeg(SettingService.CustomBGPath);
			skinItem.Value = CustomBGIndex;
			if (bGType == skinItem.Value)
			{
				skinItem.IsSelected = true;
			}
			_BGItems.Add(skinItem);
		}
		for (int i = 0; i < 10; i++)
		{
			skinItem = new SkinItem();
			string uriString = $"\\Images\\ChatBGs\\thumb_skin_bg_{i + 1:D2}.png";
			skinItem.Image = new BitmapImage(new Uri(uriString, UriKind.Relative))
			{
				CreateOptions = BitmapCreateOptions.BackgroundCreation
			};
			skinItem.Value = i + 1;
			if (bGType == skinItem.Value)
			{
				skinItem.IsSelected = true;
			}
			_BGItems.Add(skinItem);
		}
	}

	private void loadBubbleItems()
	{
		int bubbleType = SettingService.GetBubbleType();
		for (int i = 0; i < 6; i++)
		{
			SkinItem skinItem = new SkinItem();
			string uriString = $"\\Images\\ChatBubbles\\thmub_bubble_{i + 1:D2}.png";
			skinItem.Image = new BitmapImage(new Uri(uriString, UriKind.Relative))
			{
				CreateOptions = BitmapCreateOptions.BackgroundCreation
			};
			skinItem.Value = i + 1;
			if (bubbleType == skinItem.Value)
			{
				skinItem.IsSelected = true;
			}
			_bubbleItems.Add(skinItem);
		}
	}

	internal void OnSelectBubble(SkinItem item)
	{
		foreach (SkinItem bubbleItem in _bubbleItems)
		{
			bubbleItem.IsSelected = false;
		}
		item.IsSelected = true;
		SettingService.SetBubbleType(item.Value);
		_page.BuddyBubbleControl.Type = BubbleType.Me;
		_page.BuddyBubbleControl.Type = BubbleType.Buddy;
		_page.MyBubbleControl.Type = BubbleType.Buddy;
		_page.MyBubbleControl.Type = BubbleType.Me;
	}

	internal void OnSelectBG(SkinItem item)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		if (item.Value == AddNewBGIndex)
		{
			_photoChooser = new PhotoChooserTask();
			((ChooserBase<PhotoResult>)(object)_photoChooser).Completed += _photoChooser_Completed;
			((ChooserBase<PhotoResult>)(object)_photoChooser).Show();
			return;
		}
		foreach (SkinItem bGItem in _BGItems)
		{
			bGItem.IsSelected = false;
		}
		item.IsSelected = true;
		SettingService.SetBGType(item.Value);
		BackgroundImage = SettingService.GetSelectedBG();
	}

	private void _photoChooser_Completed(object sender, PhotoResult e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		if ((int)((TaskEventArgs)e).TaskResult == 1)
		{
			((UIElement)(object)_page).Visibility = Visibility.Collapsed;
			((PhoneApplicationPage)_page).ApplicationBar.IsVisible = false;
			ChatOnService.Instance.StreamToCrop = e.ChosenPhoto;
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				ImageCropPage.CropCompleted += ImageCropPage_CropCompleted;
				PageNavigationService.OpenImageCropPage((PhoneApplicationPage)(object)_page, 480, 800, isStretch: true);
				DispatcherTimer dispatcherTimer = new DispatcherTimer();
				dispatcherTimer.Interval = TimeSpan.FromMilliseconds(200.0);
				dispatcherTimer.Tick += visibilityTimer_Tick;
				dispatcherTimer.Start();
			});
		}
	}

	private void visibilityTimer_Tick(object sender, EventArgs e)
	{
		((UIElement)(object)_page).Visibility = Visibility.Visible;
		((PhoneApplicationPage)_page).ApplicationBar.IsVisible = true;
		(sender as DispatcherTimer).Stop();
	}

	private void ImageCropPage_CropCompleted(object sender, object arg)
	{
		WriteableBitmap writeableBitmap = arg as WriteableBitmap;
		Utility.SaveToJpeg(SettingService.CustomBGPath, writeableBitmap, writeableBitmap.PixelWidth, writeableBitmap.PixelHeight);
		if (_BGItems[1].Value == CustomBGIndex)
		{
			_BGItems[1].Image = writeableBitmap;
		}
		else
		{
			SkinItem skinItem = new SkinItem();
			skinItem.Image = writeableBitmap;
			skinItem.Value = 0;
			_BGItems.Insert(1, skinItem);
		}
		SettingService.SetUsingCustomBG();
	}

	internal void RestoreData()
	{
		SettingService.SetBGType(_orginalBGType);
		SettingService.SetBubbleType(_orginalBubbleType);
	}

	internal void Cancel()
	{
		RestoreData();
		Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
	}

	internal void Save()
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
	}
}
