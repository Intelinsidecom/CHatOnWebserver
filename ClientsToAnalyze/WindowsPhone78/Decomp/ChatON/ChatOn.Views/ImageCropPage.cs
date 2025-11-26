using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class ImageCropPage : PhoneApplicationPage
{
	public delegate void ImageCropPageEventHandler(object sender, object arg);

	private bool _isNew = true;

	private WriteableBitmap _originalBitmap;

	private bool _isStretch;

	internal Grid LayoutRoot;

	internal Image TargetImage;

	internal SelectionControl CropSelectionControl;

	private bool _contentLoaded;

	public static event ImageCropPageEventHandler CropCompleted;

	public ImageCropPage()
	{
		InitializeComponent();
		BitmapImage bitmapImage = new BitmapImage();
		try
		{
			bitmapImage.SetSource(ChatOnService.Instance.StreamToCrop);
		}
		catch (Exception)
		{
			((DependencyObject)this).Dispatcher.BeginInvoke(delegate
			{
				Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
			});
			return;
		}
		TargetImage.Source = bitmapImage;
		TargetImage.SizeChanged += TargetImage_SizeChanged;
		_originalBitmap = Utility.ResizeByRatioWriteableBitmap(bitmapImage, 1280.0);
		((FrameworkElement)this).Loaded += ImageCropPage_Loaded;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_DONE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_ROTATION;
		object obj3 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[2];
		ApplicationBarIconButton val3 = (ApplicationBarIconButton)((obj3 is ApplicationBarIconButton) ? obj3 : null);
		val3.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			if (ImageCropPage.CropCompleted == null)
			{
				((DependencyObject)this).Dispatcher.BeginInvoke(delegate
				{
					Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
				});
			}
			else
			{
				string originalString = ((Page)this).NavigationService.BackStack.First().Source.OriginalString;
				if (originalString.Contains("AttachListPage.xaml"))
				{
					((Page)this).NavigationService.RemoveBackEntry();
				}
				IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
				if (queryString.ContainsKey("width"))
				{
					double fixedRatioWidth = double.Parse(queryString["width"]);
					double fixedRatioHeight = double.Parse(queryString["height"]);
					CropSelectionControl.FixedRatioWidth = fixedRatioWidth;
					CropSelectionControl.FixedRatioHeight = fixedRatioHeight;
					if (queryString.ContainsKey("stretch"))
					{
						_isStretch = true;
					}
				}
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		ImageCropPage.CropCompleted = null;
		((Page)this).OnNavigatedFrom(e);
	}

	private void TargetImage_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		CropSelectionControl.SetParentElement(TargetImage, e.NewSize.Width, e.NewSize.Height);
	}

	private void ImageCropPage_Loaded(object sender, RoutedEventArgs e)
	{
		CropSelectionControl.SetParentElement(TargetImage, TargetImage.ActualWidth, TargetImage.ActualHeight);
		CropSelectionControl.ShowBorderBackground = true;
		CropSelectionControl.ShowThumbControl = true;
	}

	private void Save_Click(object sender, EventArgs e)
	{
		Rect selectedPreviewRegion = CropSelectionControl.GetSelectedPreviewRegion();
		int x = (int)(selectedPreviewRegion.Left * (double)_originalBitmap.PixelWidth / TargetImage.ActualWidth);
		int y = (int)(selectedPreviewRegion.Top * (double)_originalBitmap.PixelHeight / TargetImage.ActualHeight);
		int width = (int)(selectedPreviewRegion.Width * (double)_originalBitmap.PixelWidth / TargetImage.ActualWidth);
		int height = (int)(selectedPreviewRegion.Height * (double)_originalBitmap.PixelHeight / TargetImage.ActualHeight);
		WriteableBitmap source = Utility.CropWriteableBitmap(_originalBitmap, x, y, width, height);
		WriteableBitmap arg = ((!_isStretch) ? Utility.ResizeByRatioWriteableBitmap(source, 1024.0) : Utility.ResizeByRatioWriteableBitmap(source, 0.0, CropSelectionControl.FixedRatioWidth, CropSelectionControl.FixedRatioHeight, _isStretch));
		if (ImageCropPage.CropCompleted != null)
		{
			ImageCropPage.CropCompleted(this, arg);
		}
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void Rotate_Click(object sender, EventArgs e)
	{
		_originalBitmap = Utility.RotateWriteableBitmap(_originalBitmap);
		TargetImage.Source = _originalBitmap;
	}

	private void Cancel_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ImageCropPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TargetImage = (Image)((FrameworkElement)this).FindName("TargetImage");
			CropSelectionControl = (SelectionControl)((FrameworkElement)this).FindName("CropSelectionControl");
		}
	}
}
