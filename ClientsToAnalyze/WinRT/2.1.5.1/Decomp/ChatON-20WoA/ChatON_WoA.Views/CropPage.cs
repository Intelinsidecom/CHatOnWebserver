using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using Windows.Foundation;
using Windows.Graphics.Imaging;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.Storage.Streams;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;
using Windows.UI.Xaml.Shapes;

namespace ChatON_WoA.Views;

public sealed class CropPage : Page, IComponentConnector
{
	public delegate void CropPageEventHandler(object sender, object arg);

	private static Size _croppedAspectRatio;

	private double _x1;

	private double _x2;

	private double _y1;

	private double _y2;

	private double _bx1;

	private double _bx2;

	private double _by1;

	private double _by2;

	private double _minWidth = 100.0;

	private double _minHeight = 100.0;

	private ImageProperties prop;

	private IRandomAccessStream _fileStream;

	private Size _orgImageSize;

	private static bool _isAlreadyUpload = false;

	private static bool _isChat = false;

	private static bool _lastStatus = false;

	private bool _isFreeCroppedArea;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SaveButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CancelButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnAttach;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnCancel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid MainCanvas;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ImageControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Rectangle tg;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Rectangle lg;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Rectangle rg;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Rectangle bg;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Rectangle area;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Ellipse lt;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Ellipse rt;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Ellipse lb;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Ellipse rb;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static Size CroppedAspectRatio
	{
		get
		{
			return _croppedAspectRatio;
		}
		set
		{
			_croppedAspectRatio = value;
		}
	}

	public static bool IsChat
	{
		get
		{
			return _isChat;
		}
		set
		{
			_isChat = value;
		}
	}

	public static event CropPageEventHandler CropCompleted;

	public unsafe CropPage()
	{
		//IL_0111: Unknown result type (might be due to invalid IL or missing references)
		//IL_011b: Expected O, but got Unknown
		InitializeComponent();
		Rect bounds = Window.Current.Bounds;
		((FrameworkElement)ImageControl).put_MaxWidth(bounds.Width - 350.0);
		if (_isChat)
		{
			((UIElement)appBar).put_Visibility((Visibility)1);
			((UIElement)btnAttach).put_Visibility((Visibility)0);
			((UIElement)btnCancel).put_Visibility((Visibility)0);
			((ContentControl)btnAttach).put_Content((object)Utility.GetResourceString("IDS_CHATON_HEADER_ATTACH"));
			((ContentControl)btnCancel).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK_CANCEL"));
		}
		else
		{
			((UIElement)btnAttach).put_Visibility((Visibility)1);
			((UIElement)btnCancel).put_Visibility((Visibility)1);
			SaveButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SAVE");
			CancelButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_CANCEL_ABB");
		}
		_isAlreadyUpload = false;
		WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(CropPage_SizeChanged));
	}

	private void CropPage_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		Rect bounds = Window.Current.Bounds;
		((FrameworkElement)ImageControl).put_MaxWidth(bounds.Width - 350.0);
	}

	private void CropPage_Loaded(object sender, RoutedEventArgs e)
	{
		if (_isFreeCroppedArea)
		{
			appBar.put_IsSticky(true);
			appBar.put_IsOpen(true);
		}
	}

	private void MainCanvas_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		_bx1 = 0.0;
		_bx2 = ((FrameworkElement)MainCanvas).ActualWidth;
		_by1 = 0.0;
		_by2 = ((FrameworkElement)MainCanvas).ActualHeight;
		if (_isFreeCroppedArea)
		{
			double num;
			double num2;
			if (_bx2 / _croppedAspectRatio.Width > _by2 / _croppedAspectRatio.Height)
			{
				num = _by2 * _croppedAspectRatio.Width / _croppedAspectRatio.Height;
				num2 = _by2;
			}
			else
			{
				num2 = _bx2 * _croppedAspectRatio.Height / _croppedAspectRatio.Width;
				num = _bx2;
			}
			_x1 = (_bx2 - num) / 2.0;
			_x2 = _x1 + num;
			_y1 = (_by2 - num2) / 2.0;
			_y2 = _y1 + num2;
		}
		else
		{
			_x1 = _bx1;
			_x2 = _bx2;
			_y1 = _by1;
			_y2 = _by2;
		}
		double num3 = ((Math.Abs(((FrameworkElement)MainCanvas).ActualWidth) < Math.Abs(((FrameworkElement)MainCanvas).ActualHeight)) ? ((FrameworkElement)MainCanvas).ActualWidth : ((FrameworkElement)MainCanvas).ActualHeight);
		if (num3 < 100.0)
		{
			_minWidth = num3;
			_minHeight = num3;
		}
		Update();
	}

	protected override async void OnNavigatedTo(NavigationEventArgs e)
	{
		StorageFile file = null;
		if (e.Parameter is StorageFile)
		{
			object parameter = e.Parameter;
			file = (StorageFile)((parameter is StorageFile) ? parameter : null);
		}
		else if (e.Parameter is List<object>)
		{
			List<object> list = e.Parameter as List<object>;
			object obj = list[0];
			file = (StorageFile)((obj is StorageFile) ? obj : null);
			_isFreeCroppedArea = (bool)list[1];
		}
		prop = await file.Properties.GetImagePropertiesAsync();
		_fileStream = await file.OpenAsync((FileAccessMode)0);
		BitmapImage image = new BitmapImage();
		((BitmapSource)image).SetSource(_fileStream);
		ImageControl.put_Source((ImageSource)(object)image);
		_orgImageSize.Width = prop.Width;
		_orgImageSize.Height = prop.Height;
		if ((int)e.NavigationMode != 1)
		{
			_lastStatus = _isChat;
		}
		else if (_lastStatus)
		{
			((UIElement)appBar).put_Visibility((Visibility)1);
			((UIElement)btnAttach).put_Visibility((Visibility)0);
			((UIElement)btnCancel).put_Visibility((Visibility)0);
			((ContentControl)btnAttach).put_Content((object)Utility.GetResourceString("IDS_CHATON_HEADER_ATTACH"));
			((ContentControl)btnCancel).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK_CANCEL"));
		}
		_isChat = false;
	}

	private void Update()
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Invalid comparison between Unknown and I4
		if ((int)((UIElement)lt).Visibility == 1)
		{
			((UIElement)lt).put_Visibility((Visibility)0);
			((UIElement)rt).put_Visibility((Visibility)0);
			((UIElement)lb).put_Visibility((Visibility)0);
			((UIElement)rb).put_Visibility((Visibility)0);
		}
		Canvas.SetLeft((UIElement)(object)lt, _x1 - ((FrameworkElement)lt).ActualWidth / 2.0);
		Canvas.SetTop((UIElement)(object)lt, _y1 - ((FrameworkElement)lt).ActualHeight / 2.0);
		Canvas.SetLeft((UIElement)(object)rt, _x2 - ((FrameworkElement)lt).ActualWidth / 2.0);
		Canvas.SetTop((UIElement)(object)rt, _y1 - ((FrameworkElement)lt).ActualHeight / 2.0);
		Canvas.SetLeft((UIElement)(object)lb, _x1 - ((FrameworkElement)lt).ActualWidth / 2.0);
		Canvas.SetTop((UIElement)(object)lb, _y2 - ((FrameworkElement)lt).ActualHeight / 2.0);
		Canvas.SetLeft((UIElement)(object)rb, _x2 - ((FrameworkElement)lt).ActualWidth / 2.0);
		Canvas.SetTop((UIElement)(object)rb, _y2 - ((FrameworkElement)lt).ActualHeight / 2.0);
		Canvas.SetLeft((UIElement)(object)area, _x1);
		Canvas.SetTop((UIElement)(object)area, _y1);
		((FrameworkElement)area).put_Width(_x2 - _x1);
		((FrameworkElement)area).put_Height(_y2 - _y1);
		int num = (int)_x1;
		int num2 = (int)_x2;
		int num3 = (int)_y1;
		int num4 = (int)_y2;
		((FrameworkElement)tg).put_Width(_bx2);
		((FrameworkElement)tg).put_Height((double)num3);
		((FrameworkElement)lg).put_Width((double)num);
		((FrameworkElement)lg).put_Height((double)(num4 - num3));
		Canvas.SetTop((UIElement)(object)lg, (double)num3);
		((FrameworkElement)rg).put_Width(((FrameworkElement)MainCanvas).ActualWidth - (double)num2);
		((FrameworkElement)rg).put_Height((double)(num4 - num3));
		Canvas.SetLeft((UIElement)(object)rg, (double)num2);
		Canvas.SetTop((UIElement)(object)rg, (double)num3);
		((FrameworkElement)bg).put_Width(_bx2);
		((FrameworkElement)bg).put_Height(((FrameworkElement)MainCanvas).ActualHeight - (double)num4);
		Canvas.SetTop((UIElement)(object)bg, (double)num4);
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async void Save_Click(object sender, RoutedEventArgs e)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (!_isAlreadyUpload)
			{
				_isAlreadyUpload = true;
				StorageFile file = await CropImage(_fileStream);
				LoadingIndicator.StopLoading();
				if (CropPage.CropCompleted != null)
				{
					CropPage.CropCompleted(this, file);
				}
				((Page)this).Frame.GoBack();
			}
		}
		catch (Exception)
		{
			((Page)this).Frame.GoBack();
		}
	}

	private void Cancel_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async Task<StorageFile> CropImage(IRandomAccessStream fs)
	{
		BitmapDecoder decoder = await BitmapDecoder.CreateAsync(fs);
		StorageFile file = await Utility.CreateLocalFile("cropped.jpg", "Cache", replaceExisting: true);
		IRandomAccessStream stream = await file.OpenAsync((FileAccessMode)1);
		int newHeight = 1024;
		int newWidth = 1024;
		BitmapBounds bounds = default(BitmapBounds);
		BitmapTransform transform;
		if ((int)prop.Orientation == 8 || (int)prop.Orientation == 6)
		{
			Utility.GetPhotoSizeByRatio((int)_orgImageSize.Height, (int)_orgImageSize.Width, ref newWidth, ref newHeight);
			transform = new BitmapTransform();
			transform.put_ScaledWidth((uint)newWidth);
			transform.put_ScaledHeight((uint)newHeight);
			transform.put_InterpolationMode((BitmapInterpolationMode)2);
			uint width = (uint)((_x2 - _x1) * (double)newWidth / _by2);
			uint height = (uint)((_y2 - _y1) * (double)newHeight / _bx2);
			bounds.Width = width;
			bounds.Height = height;
			bounds.X = (uint)(_x1 * (double)newHeight / _bx2);
			bounds.Y = (uint)(_y1 * (double)newWidth / _by2);
		}
		else
		{
			Utility.GetPhotoSizeByRatio((int)_orgImageSize.Width, (int)_orgImageSize.Height, ref newWidth, ref newHeight);
			transform = new BitmapTransform();
			transform.put_ScaledWidth((uint)newWidth);
			transform.put_ScaledHeight((uint)newHeight);
			transform.put_InterpolationMode((BitmapInterpolationMode)2);
			bounds.Width = (uint)((_x2 - _x1) * (double)newWidth / _bx2);
			bounds.Height = (uint)((_y2 - _y1) * (double)newHeight / _by2);
			bounds.X = (uint)(_x1 * (double)newWidth / _bx2);
			bounds.Y = (uint)(_y1 * (double)newHeight / _by2);
		}
		transform.put_Bounds(bounds);
		PixelDataProvider provider = null;
		try
		{
			provider = await decoder.GetPixelDataAsync((BitmapPixelFormat)12, (BitmapAlphaMode)0, transform, (ExifOrientationMode)1, (ColorManagementMode)1);
		}
		catch (Exception)
		{
		}
		byte[] pixels = provider.DetachPixelData();
		BitmapEncoder encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.JpegEncoderId, stream);
		encoder.SetPixelData((BitmapPixelFormat)12, (BitmapAlphaMode)0, bounds.Width, bounds.Height, decoder.DpiX, decoder.DpiY, pixels);
		await encoder.FlushAsync();
		await ((IOutputStream)stream).FlushAsync();
		((IDisposable)stream).Dispose();
		if ((bounds.Width > 600 || bounds.Height > 600) && _croppedAspectRatio.Width == _croppedAspectRatio.Height)
		{
			await Utility.ResizeImg600x600(file);
		}
		((IDisposable)fs).Dispose();
		return file;
	}

	private void ManipulationDelta_1(object sender, ManipulationDeltaRoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		Point translation = e.Delta.Translation;
		double deltaX = translation.X;
		Point translation2 = e.Delta.Translation;
		double deltaY = translation2.Y;
		string name = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).Name;
		double num = ((Math.Abs(deltaX) > Math.Abs(deltaY)) ? deltaX : deltaY);
		if (_croppedAspectRatio.Width > 0.0)
		{
			switch (name)
			{
			case "lt":
				if (_croppedAspectRatio.Width > 0.0 && _isFreeCroppedArea)
				{
					deltaX = num;
					deltaY = num * _croppedAspectRatio.Height / _croppedAspectRatio.Width;
				}
				break;
			case "rt":
				if (_croppedAspectRatio.Width > 0.0 && _isFreeCroppedArea)
				{
					if (num == deltaX)
					{
						deltaX = num;
						deltaY = (0.0 - num) * _croppedAspectRatio.Height / _croppedAspectRatio.Width;
					}
					else
					{
						deltaX = 0.0 - num;
						deltaY = num * _croppedAspectRatio.Height / _croppedAspectRatio.Width;
					}
				}
				break;
			case "lb":
				if (_croppedAspectRatio.Width > 0.0 && _isFreeCroppedArea)
				{
					if (num == deltaX)
					{
						deltaX = num;
						deltaY = (0.0 - num) * _croppedAspectRatio.Height / _croppedAspectRatio.Width;
					}
					else
					{
						deltaX = 0.0 - num;
						deltaY = num * _croppedAspectRatio.Height / _croppedAspectRatio.Width;
					}
				}
				break;
			case "rb":
				if (_croppedAspectRatio.Width > 0.0 && _isFreeCroppedArea)
				{
					deltaX = num;
					deltaY = num * _croppedAspectRatio.Height / _croppedAspectRatio.Width;
				}
				break;
			}
			ClipToBoundary(ref deltaX, ref deltaY, name);
			if (Math.Abs(deltaX) != Math.Abs(deltaY) && _isFreeCroppedArea)
			{
				num = ((Math.Abs(deltaX) < Math.Abs(deltaY)) ? deltaX : deltaY);
				num = Math.Abs(num);
				deltaX = ((deltaX < 0.0) ? (0.0 - num) : num);
				deltaY = ((deltaY < 0.0) ? ((0.0 - num) * _croppedAspectRatio.Height / _croppedAspectRatio.Width) : (num * _croppedAspectRatio.Height / _croppedAspectRatio.Width));
			}
		}
		else
		{
			ClipToBoundary(ref deltaX, ref deltaY, name);
		}
		switch (name)
		{
		case "lt":
			_x1 += deltaX;
			_y1 += deltaY;
			break;
		case "rt":
			_x2 += deltaX;
			_y1 += deltaY;
			break;
		case "lb":
			_x1 += deltaX;
			_y2 += deltaY;
			break;
		case "rb":
			_x2 += deltaX;
			_y2 += deltaY;
			break;
		}
		Update();
	}

	private void ClipToBoundary(ref double deltaX, ref double deltaY, string param)
	{
		switch (param)
		{
		case "lt":
			if (_x1 + deltaX < _bx1)
			{
				deltaX = 0.0 - (_x1 - _bx1);
			}
			else if (_x1 + deltaX > _x2 - _minWidth)
			{
				deltaX = _x2 - _minWidth - _x1;
			}
			if (_y1 + deltaY < _by1)
			{
				deltaY = 0.0 - (_y1 - _by1);
			}
			else if (_y1 + deltaY > _y2 - _minHeight)
			{
				deltaY = _y2 - _minHeight - _y1;
			}
			break;
		case "rt":
			if (_x2 + deltaX > _bx2)
			{
				deltaX = _bx2 - _x2;
			}
			else if (_x2 + deltaX < _x1 + _minWidth)
			{
				deltaX = 0.0 - (_x2 - (_x1 + _minWidth));
			}
			if (_y1 + deltaY < _by1)
			{
				deltaY = 0.0 - (_y1 - _by1);
			}
			else if (_y1 + deltaY > _y2 - _minHeight)
			{
				deltaY = _y2 - _minHeight - _y1;
			}
			break;
		case "lb":
			if (_x1 + deltaX < _bx1)
			{
				deltaX = 0.0 - (_x1 - _bx1);
			}
			else if (_x1 + deltaX > _x2 - _minWidth)
			{
				deltaX = _x2 - _minWidth - _x1;
			}
			if (_y2 + deltaY > _by2)
			{
				deltaY = _by2 - _y2;
			}
			else if (_y2 + deltaY < _y1 + _minHeight)
			{
				deltaY = 0.0 - (_y2 - (_y1 + _minHeight));
			}
			break;
		case "rb":
			if (_x2 + deltaX > _bx2)
			{
				deltaX = _bx2 - _x2;
			}
			else if (_x2 + deltaX < _x1 + _minWidth)
			{
				deltaX = 0.0 - (_x2 - (_x1 + _minWidth));
			}
			if (_y2 + deltaY > _by2)
			{
				deltaY = _by2 - _y2;
			}
			else if (_y2 + deltaY < _y1 + _minHeight)
			{
				deltaY = 0.0 - (_y2 - (_y1 + _minHeight));
			}
			break;
		}
	}

	private void area_ManipulationDelta_1(object sender, ManipulationDeltaRoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_002b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		Point translation = e.Delta.Translation;
		double num = translation.X;
		Point translation2 = e.Delta.Translation;
		double num2 = translation2.X;
		Point translation3 = e.Delta.Translation;
		double num3 = translation3.Y;
		Point translation4 = e.Delta.Translation;
		double num4 = translation4.Y;
		double num5 = num;
		double num6 = num3;
		if (_x1 + num < _bx1)
		{
			num = 0.0 - (_x1 - _bx1);
		}
		if (_y1 + num3 < _by1)
		{
			num3 = 0.0 - (_y1 - _by1);
		}
		if (_x2 + num2 > _bx2)
		{
			num2 = _bx2 - _x2;
		}
		if (_y2 + num4 > _by2)
		{
			num4 = _by2 - _y2;
		}
		num5 = ((Math.Abs(num) < Math.Abs(num2)) ? num : num2);
		num6 = ((Math.Abs(num3) < Math.Abs(num4)) ? num3 : num4);
		_x1 += num5;
		_x2 += num5;
		_y1 += num6;
		_y2 += num6;
		Update();
	}

	internal static void Init()
	{
		CropPage.CropCompleted = null;
	}

	private async void btnAttach_Click(object sender, RoutedEventArgs e)
	{
		Save_Click(sender, e);
	}

	private void btnCancel_Click(object sender, RoutedEventArgs e)
	{
		Cancel_Click(sender, e);
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0161: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		//IL_0177: Unknown result type (might be due to invalid IL or missing references)
		//IL_0181: Expected O, but got Unknown
		//IL_018d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0197: Expected O, but got Unknown
		//IL_01a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ad: Expected O, but got Unknown
		//IL_01b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c3: Expected O, but got Unknown
		//IL_01cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d9: Expected O, but got Unknown
		//IL_01e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ef: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///CropPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			SaveButton = (ImageButton)((FrameworkElement)this).FindName("SaveButton");
			CancelButton = (ImageButton)((FrameworkElement)this).FindName("CancelButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			btnAttach = (Button)((FrameworkElement)this).FindName("btnAttach");
			btnCancel = (Button)((FrameworkElement)this).FindName("btnCancel");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			MainCanvas = (Grid)((FrameworkElement)this).FindName("MainCanvas");
			ImageControl = (Image)((FrameworkElement)this).FindName("ImageControl");
			tg = (Rectangle)((FrameworkElement)this).FindName("tg");
			lg = (Rectangle)((FrameworkElement)this).FindName("lg");
			rg = (Rectangle)((FrameworkElement)this).FindName("rg");
			bg = (Rectangle)((FrameworkElement)this).FindName("bg");
			area = (Rectangle)((FrameworkElement)this).FindName("area");
			lt = (Ellipse)((FrameworkElement)this).FindName("lt");
			rt = (Ellipse)((FrameworkElement)this).FindName("rt");
			lb = (Ellipse)((FrameworkElement)this).FindName("lb");
			rb = (Ellipse)((FrameworkElement)this).FindName("rb");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Expected O, but got Unknown
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006f: Expected O, but got Unknown
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_008b: Expected O, but got Unknown
		//IL_009d: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a7: Expected O, but got Unknown
		//IL_00ad: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b3: Expected O, but got Unknown
		//IL_00d2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00dc: Expected O, but got Unknown
		//IL_00e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e8: Expected O, but got Unknown
		//IL_0107: Unknown result type (might be due to invalid IL or missing references)
		//IL_0111: Expected O, but got Unknown
		//IL_0117: Unknown result type (might be due to invalid IL or missing references)
		//IL_011e: Expected O, but got Unknown
		//IL_013f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0149: Expected O, but got Unknown
		//IL_014f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0156: Expected O, but got Unknown
		//IL_0177: Unknown result type (might be due to invalid IL or missing references)
		//IL_0181: Expected O, but got Unknown
		//IL_0187: Unknown result type (might be due to invalid IL or missing references)
		//IL_018e: Expected O, but got Unknown
		//IL_01af: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b9: Expected O, but got Unknown
		//IL_01bf: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c6: Expected O, but got Unknown
		//IL_01e7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f1: Expected O, but got Unknown
		//IL_01f7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01fe: Expected O, but got Unknown
		//IL_021f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0229: Expected O, but got Unknown
		//IL_022c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0233: Expected O, but got Unknown
		//IL_0254: Unknown result type (might be due to invalid IL or missing references)
		//IL_025e: Expected O, but got Unknown
		//IL_0261: Unknown result type (might be due to invalid IL or missing references)
		//IL_0268: Expected O, but got Unknown
		//IL_0289: Unknown result type (might be due to invalid IL or missing references)
		//IL_0293: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val10 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(CropPage_Loaded));
			break;
		}
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(Save_Click);
			break;
		case 3:
			((ImageButton)target).Click += new RoutedEventHandler(Cancel_Click);
			break;
		case 4:
		{
			ButtonBase val9 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(btnAttach_Click));
			break;
		}
		case 5:
		{
			ButtonBase val8 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(btnCancel_Click));
			break;
		}
		case 6:
		{
			ButtonBase val7 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		case 7:
		{
			FrameworkElement val6 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(MainCanvas_SizeChanged));
			break;
		}
		case 8:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(area_ManipulationDelta_1));
			break;
		}
		case 9:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		case 10:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		case 11:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		case 12:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
