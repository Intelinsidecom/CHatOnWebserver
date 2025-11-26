using System;
using System.Collections.ObjectModel;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class SelectBubbleStylePopupViewModel : NotificationObject
{
	private static int AddNewBGIndex = -1;

	private static int CustomBGIndex = 0;

	private long _previewBubbleDate;

	private ObservableCollection<SkinItem> _bubbleItems = new ObservableCollection<SkinItem>();

	private ObservableCollection<SkinItem> _myBubbleItems = new ObservableCollection<SkinItem>();

	private ObservableCollection<SkinItem> _BGItems = new ObservableCollection<SkinItem>();

	private BitmapImage _backgroundImage;

	private bool _isBGSelection;

	public long PreviewBubbleDate
	{
		get
		{
			return _previewBubbleDate;
		}
		set
		{
			_previewBubbleDate = value;
			NotifyPropertyChanged(() => PreviewBubbleDate);
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

	public ObservableCollection<SkinItem> MyBubbleItems
	{
		get
		{
			return _myBubbleItems;
		}
		set
		{
			_myBubbleItems = value;
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

	public SelectBubbleStylePopupViewModel(bool isBGSelection)
	{
		_previewBubbleDate = Utility.GetTimeStamp();
		_isBGSelection = isBGSelection;
		if (_isBGSelection)
		{
			loadBGItems();
		}
		else
		{
			loadBubbleItems();
		}
		OpenBGImage();
	}

	private async void OpenBGImage()
	{
		BackgroundImage = await SettingService.GetSelectedBG();
	}

	private void loadBGItems()
	{
		//IL_009c: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a6: Expected O, but got Unknown
		int bGType = SettingService.GetBGType();
		if (IsoSettingHelper.Get("CustomBG", defaultValue: false))
		{
			SkinItem skinItem = new SkinItem();
			skinItem.Image = (BitmapSource)(object)Utility.LoadJpeg(SettingService.CustomBGPath);
			skinItem.Value = CustomBGIndex;
			skinItem.Name = "Custom BG";
			if (bGType == skinItem.Value)
			{
				skinItem.IsSelected = true;
			}
			_BGItems.Add(skinItem);
		}
		for (int i = 0; i < 5; i++)
		{
			SkinItem skinItem2 = new SkinItem();
			string text = $"/Images/Background/chat_bg_{i + 1:D2}.png";
			skinItem2.Image = (BitmapSource)new BitmapImage(new Uri("ms-appx://" + text));
			skinItem2.Value = i + 1;
			if (bGType == skinItem2.Value)
			{
				skinItem2.IsSelected = true;
			}
			skinItem2.Name = "BG " + (i + 1);
			_BGItems.Add(skinItem2);
		}
	}

	private void loadBubbleItems()
	{
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_00e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ec: Expected O, but got Unknown
		int bubbleType = SettingService.GetBubbleType();
		for (int i = 0; i < 5; i++)
		{
			SkinItem skinItem = new SkinItem();
			string text = $"/Images/ChatBubbles/preview_bubble_buddies_{i + 1:D2}.png";
			skinItem.Image = (BitmapSource)new BitmapImage(new Uri("ms-appx://" + text));
			skinItem.Value = i + 1;
			if (bubbleType == skinItem.Value)
			{
				skinItem.IsSelected = true;
			}
			skinItem.Name = "Bubble " + (i + 1);
			_bubbleItems.Add(skinItem);
		}
		bubbleType = SettingService.GetMyBubbleType();
		for (int j = 0; j < 5; j++)
		{
			SkinItem skinItem2 = new SkinItem();
			string text2 = $"/Images/ChatBubbles/preview_bubble_me_{j + 1:D2}.png";
			skinItem2.Image = (BitmapSource)new BitmapImage(new Uri("ms-appx://" + text2));
			skinItem2.Value = j + 1;
			if (bubbleType == skinItem2.Value)
			{
				skinItem2.IsSelected = true;
			}
			skinItem2.Name = "My Bubble " + (j + 1);
			_myBubbleItems.Add(skinItem2);
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
	}

	internal void OnSelectMyBubble(SkinItem item)
	{
		foreach (SkinItem myBubbleItem in _myBubbleItems)
		{
			myBubbleItem.IsSelected = false;
		}
		item.IsSelected = true;
		SettingService.SetMyBubbleType(item.Value);
	}

	internal void OnSelectBG(SkinItem item)
	{
		foreach (SkinItem bGItem in _BGItems)
		{
			bGItem.IsSelected = false;
		}
		if (item != null)
		{
			item.IsSelected = true;
			SettingService.SetBGType(item.Value);
		}
		UpdateBGImage();
	}

	private async void UpdateBGImage()
	{
		BackgroundImage = await SettingService.GetSelectedBG();
	}
}
