using System.Collections.Generic;
using System.Windows.Media.Imaging;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class FontSettingPageViewModel : NotificationObject
{
	private FontSettingPage _page;

	private BitmapImage _backgroundImage;

	private int _orginalFontSizeType;

	private long _previewBubbleDate1;

	private List<string> _fontSizeItems = new List<string>();

	private int _selectedFontIndex = -1;

	public int SelectedFontIndex
	{
		get
		{
			return _selectedFontIndex;
		}
		set
		{
			_selectedFontIndex = value;
			SettingService.SetFontSizeType(_selectedFontIndex);
			_page.MyBubbleControl.UpdateContentFontSize();
			_page.BuddyBubbleControl.UpdateContentFontSize();
			NotifyPropertyChanged(() => SelectedFontIndex);
		}
	}

	public List<string> FontSizeItems
	{
		get
		{
			return _fontSizeItems;
		}
		set
		{
			_fontSizeItems = value;
		}
	}

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

	public FontSettingPageViewModel(FontSettingPage page)
	{
		_page = page;
		BackgroundImage = SettingService.GetSelectedBG();
		_previewBubbleDate1 = Utility.GetTimeStamp();
		_fontSizeItems.Add("50%");
		_fontSizeItems.Add("70%");
		_fontSizeItems.Add("100%");
		_fontSizeItems.Add("150%");
		_fontSizeItems.Add("200%");
		_orginalFontSizeType = SettingService.GetFontSizeType();
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

	internal void OnLoaded()
	{
		SelectedFontIndex = SettingService.GetFontSizeType();
	}

	internal void RestoreData()
	{
		SettingService.SetFontSizeType(_orginalFontSizeType);
	}
}
