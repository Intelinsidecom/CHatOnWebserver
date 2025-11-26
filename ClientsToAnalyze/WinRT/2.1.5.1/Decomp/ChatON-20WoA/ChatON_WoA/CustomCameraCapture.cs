using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Controls;
using ChatON_WoA.ViewModels;
using ChatOn.Infrastructure;
using Windows.Foundation;
using Windows.Media.Capture;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;
using Windows.UI.Xaml.Shapes;

namespace ChatON_WoA;

public sealed class CustomCameraCapture : Page, IComponentConnector
{
	public delegate void CameraPageEventHandler(object sender, object arg);

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

	private Size _orgImageSize;

	private bool _isCounter;

	private bool _isButtonOKClicked;

	private bool _isOnProgress;

	private double _marginCropScreen;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Canvas previewCanvas;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private CountdownControl myCountdownControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private CaptureElement capturePreview;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image captureCropElement;

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
	private AppBar AppbarButtom;

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

	private CustomCameraCaptureViewModel ViewModel => ((FrameworkElement)this).DataContext as CustomCameraCaptureViewModel;

	public static event CameraPageEventHandler CameraCompleted;

	public void OnCameraCompleted(object arg)
	{
		CustomCameraCapture.CameraCompleted?.Invoke(this, arg);
	}

	public unsafe CustomCameraCapture()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)new CustomCameraCaptureViewModel(this));
		CoreWindow coreWindow = Window.Current.CoreWindow;
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<CoreWindow, WindowActivatedEventArgs>, EventRegistrationToken>(coreWindow, (nint)__ldftn(CoreWindow.add_Activated)), new Action<EventRegistrationToken>(coreWindow, (nint)__ldftn(CoreWindow.remove_Activated)), CoreWindow_Activated);
	}

	private async void CoreWindow_Activated(CoreWindow sender, WindowActivatedEventArgs args)
	{
		if (_isOnProgress)
		{
			return;
		}
		_isOnProgress = true;
		if (ViewModel.MediaEngine != null && (int)args.WindowActivationState == 0)
		{
			try
			{
				await Task.Delay(400);
				if (capturePreview != null)
				{
					capturePreview.put_Source((MediaCapture)null);
				}
				await ViewModel.OnInitPreview();
				if (capturePreview != null)
				{
					capturePreview.put_Source(ViewModel.MediaEngine);
				}
				await ViewModel.OnStartPreview();
			}
			catch (Exception)
			{
			}
		}
		_isOnProgress = false;
	}

	private void previewCanvas_Loaded(object sender, RoutedEventArgs e)
	{
		_bx1 = _marginCropScreen;
		_bx2 = ((FrameworkElement)previewCanvas).ActualWidth - _marginCropScreen;
		_by1 = _marginCropScreen;
		_by2 = ((FrameworkElement)previewCanvas).ActualHeight - _marginCropScreen;
		if (_croppedAspectRatio.Width > 0.0)
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
		Update();
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
		((FrameworkElement)tg).put_Width(_bx2 + 30.0);
		((FrameworkElement)tg).put_Height((double)num3);
		((FrameworkElement)lg).put_Width((double)num);
		((FrameworkElement)lg).put_Height((double)(num4 - num3));
		Canvas.SetTop((UIElement)(object)lg, (double)num3);
		((FrameworkElement)rg).put_Width(((FrameworkElement)previewCanvas).ActualWidth - (double)num2);
		((FrameworkElement)rg).put_Height((double)(num4 - num3));
		Canvas.SetLeft((UIElement)(object)rg, (double)num2);
		Canvas.SetTop((UIElement)(object)rg, (double)num3);
		((FrameworkElement)bg).put_Width(_bx2 + 30.0);
		((FrameworkElement)bg).put_Height(((FrameworkElement)previewCanvas).ActualHeight - (double)num4);
		Canvas.SetTop((UIElement)(object)bg, (double)num4);
	}

	protected override async void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isOnProgress)
		{
			return;
		}
		_isOnProgress = true;
		try
		{
			await ViewModel.OnNavigatedTo(e);
			capturePreview.put_Source((MediaCapture)null);
			await ViewModel.OnInitPreview();
			capturePreview.put_Source(ViewModel.MediaEngine);
			await ViewModel.OnStartPreview();
		}
		catch (Exception)
		{
			Task.Run(delegate
			{
				//IL_000e: Unknown result type (might be due to invalid IL or missing references)
				//IL_0018: Expected O, but got Unknown
				((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
				{
					if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR")) && ((Page)this).Frame.CanGoBack)
					{
						((Page)this).Frame.GoBack();
					}
				});
			});
		}
		_isOnProgress = false;
	}

	private void BtnChangeSettings_Click(object sender, RoutedEventArgs e)
	{
		CameraOptionsUI.Show(ViewModel.MediaEngine);
	}

	private async void BtnTimer_Click(object sender, RoutedEventArgs e)
	{
		if (!_isCounter)
		{
			_isCounter = true;
			ViewModel.ShowOffCounter(value: true);
			await myCountdownControl.StartCountdownAsync(3);
			await Task.Delay(1000);
			ViewModel.ShowOffCounter(value: false);
			_isCounter = false;
		}
	}

	private void BtnCrop_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.OnCrop();
	}

	private void BtnCancelCrop_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.CancelCrop();
	}

	private unsafe async void BtnOK_Click(object sender, RoutedEventArgs e)
	{
		if (_isOnProgress)
		{
			return;
		}
		_isOnProgress = true;
		if (_isButtonOKClicked)
		{
			return;
		}
		_isButtonOKClicked = true;
		try
		{
			int num = default(int);
			_ = num;
			_ = 0;
			try
			{
				OnCameraCompleted(await ViewModel.SaveImage());
			}
			catch
			{
			}
		}
		finally
		{
			WindowsRuntimeMarshal.RemoveEventHandler<RoutedEventHandler>(new Action<EventRegistrationToken>(previewCanvas, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(previewCanvas_Loaded));
			WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<CoreWindow, WindowActivatedEventArgs>>(new Action<EventRegistrationToken>(Window.Current.CoreWindow, (nint)__ldftn(CoreWindow.remove_Activated)), CoreWindow_Activated);
		}
		_isOnProgress = false;
	}

	private async void BtnRetake_Click(object sender, RoutedEventArgs e)
	{
		if (!_isOnProgress)
		{
			_isOnProgress = true;
			await ViewModel.OnRetake();
			await Task.Delay(100);
			capturePreview.put_Source(ViewModel.MediaEngine);
			await ViewModel.OnStartPreview();
			_isOnProgress = false;
		}
	}

	private void BtnOKFinish_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.CropImage(_x1, _x2, _bx2, _y1, _y2, _by2);
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
				if (_croppedAspectRatio.Width > 0.0)
				{
					deltaX = num;
					deltaY = num;
				}
				break;
			case "rt":
				if (_croppedAspectRatio.Width > 0.0)
				{
					if (num == deltaX)
					{
						deltaX = num;
						deltaY = 0.0 - num;
					}
					else
					{
						deltaX = 0.0 - num;
						deltaY = num;
					}
				}
				break;
			case "lb":
				if (_croppedAspectRatio.Width > 0.0)
				{
					if (num == deltaX)
					{
						deltaX = num;
						deltaY = 0.0 - num;
					}
					else
					{
						deltaX = 0.0 - num;
						deltaY = num;
					}
				}
				break;
			case "rb":
				if (_croppedAspectRatio.Width > 0.0)
				{
					deltaX = num;
					deltaY = num;
				}
				break;
			}
			ClipToBoundary(ref deltaX, ref deltaY, name);
			if (Math.Abs(deltaX) != Math.Abs(deltaY))
			{
				num = ((Math.Abs(deltaX) < Math.Abs(deltaY)) ? deltaX : deltaY);
				num = Math.Abs(num);
				deltaX = ((deltaX < 0.0) ? (0.0 - num) : num);
				deltaY = ((deltaY < 0.0) ? (0.0 - num) : num);
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

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		if (((Page)this).Frame.CanGoBack)
		{
			((Page)this).Frame.GoBack();
		}
	}

	private void capturePreview_Tapped(object sender, TappedRoutedEventArgs e)
	{
		if (!_isOnProgress)
		{
			_isOnProgress = true;
			AppbarButtom.put_IsOpen(true);
			if (!_isCounter)
			{
				ViewModel.OnCapture();
			}
			_isOnProgress = false;
		}
	}

	private async void BtnChangeCamera_Click(object sender, RoutedEventArgs e)
	{
		if (!_isOnProgress)
		{
			_isOnProgress = true;
			await ViewModel.OnChangeCamera();
			capturePreview.put_Source(ViewModel.MediaEngine);
			await ViewModel.OnStartPreview();
			_isOnProgress = false;
		}
	}

	private void BtnRotate_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.RotateImage();
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///CustomCameraCapture.xaml"), (ComponentResourceLocation)0);
			previewCanvas = (Canvas)((FrameworkElement)this).FindName("previewCanvas");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			myCountdownControl = (CountdownControl)((FrameworkElement)this).FindName("myCountdownControl");
			capturePreview = (CaptureElement)((FrameworkElement)this).FindName("capturePreview");
			captureCropElement = (Image)((FrameworkElement)this).FindName("captureCropElement");
			tg = (Rectangle)((FrameworkElement)this).FindName("tg");
			lg = (Rectangle)((FrameworkElement)this).FindName("lg");
			rg = (Rectangle)((FrameworkElement)this).FindName("rg");
			bg = (Rectangle)((FrameworkElement)this).FindName("bg");
			area = (Rectangle)((FrameworkElement)this).FindName("area");
			lt = (Ellipse)((FrameworkElement)this).FindName("lt");
			rt = (Ellipse)((FrameworkElement)this).FindName("rt");
			lb = (Ellipse)((FrameworkElement)this).FindName("lb");
			rb = (Ellipse)((FrameworkElement)this).FindName("rb");
			AppbarButtom = (AppBar)((FrameworkElement)this).FindName("AppbarButtom");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0054: Unknown result type (might be due to invalid IL or missing references)
		//IL_005a: Expected O, but got Unknown
		//IL_0079: Unknown result type (might be due to invalid IL or missing references)
		//IL_0083: Expected O, but got Unknown
		//IL_0089: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_00ae: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b8: Expected O, but got Unknown
		//IL_00be: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c4: Expected O, but got Unknown
		//IL_00e3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ed: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fa: Expected O, but got Unknown
		//IL_011b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0125: Expected O, but got Unknown
		//IL_012b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0132: Expected O, but got Unknown
		//IL_0153: Unknown result type (might be due to invalid IL or missing references)
		//IL_015d: Expected O, but got Unknown
		//IL_0163: Unknown result type (might be due to invalid IL or missing references)
		//IL_016a: Expected O, but got Unknown
		//IL_018b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0195: Expected O, but got Unknown
		//IL_019b: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a2: Expected O, but got Unknown
		//IL_01c3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01cd: Expected O, but got Unknown
		//IL_01d3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01da: Expected O, but got Unknown
		//IL_01fb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0205: Expected O, but got Unknown
		//IL_020b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0212: Expected O, but got Unknown
		//IL_0233: Unknown result type (might be due to invalid IL or missing references)
		//IL_023d: Expected O, but got Unknown
		//IL_0243: Unknown result type (might be due to invalid IL or missing references)
		//IL_024a: Expected O, but got Unknown
		//IL_026b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0275: Expected O, but got Unknown
		//IL_027b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0282: Expected O, but got Unknown
		//IL_02a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_02ad: Expected O, but got Unknown
		//IL_02b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_02ba: Expected O, but got Unknown
		//IL_02db: Unknown result type (might be due to invalid IL or missing references)
		//IL_02e5: Expected O, but got Unknown
		//IL_02eb: Unknown result type (might be due to invalid IL or missing references)
		//IL_02f2: Expected O, but got Unknown
		//IL_0313: Unknown result type (might be due to invalid IL or missing references)
		//IL_031d: Expected O, but got Unknown
		//IL_0323: Unknown result type (might be due to invalid IL or missing references)
		//IL_032a: Expected O, but got Unknown
		//IL_034b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0355: Expected O, but got Unknown
		//IL_035b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0362: Expected O, but got Unknown
		//IL_0383: Unknown result type (might be due to invalid IL or missing references)
		//IL_038d: Expected O, but got Unknown
		//IL_0390: Unknown result type (might be due to invalid IL or missing references)
		//IL_0397: Expected O, but got Unknown
		//IL_03b8: Unknown result type (might be due to invalid IL or missing references)
		//IL_03c2: Expected O, but got Unknown
		//IL_03c5: Unknown result type (might be due to invalid IL or missing references)
		//IL_03cc: Expected O, but got Unknown
		//IL_03ed: Unknown result type (might be due to invalid IL or missing references)
		//IL_03f7: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val17 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val17, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val17, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(previewCanvas_Loaded));
			break;
		}
		case 2:
		{
			ButtonBase val16 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val16, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val16, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		case 3:
		{
			UIElement val15 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val15, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val15, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(capturePreview_Tapped));
			break;
		}
		case 4:
		{
			UIElement val14 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val14, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val14, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(area_ManipulationDelta_1));
			break;
		}
		case 5:
		{
			UIElement val13 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val13, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val13, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		case 6:
		{
			UIElement val12 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		case 7:
		{
			UIElement val11 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		case 8:
		{
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationDeltaEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_ManipulationDelta)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_ManipulationDelta)), new ManipulationDeltaEventHandler(ManipulationDelta_1));
			break;
		}
		case 9:
		{
			ButtonBase val9 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnOKFinish_Click));
			break;
		}
		case 10:
		{
			ButtonBase val8 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnCancelCrop_Click));
			break;
		}
		case 11:
		{
			ButtonBase val7 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnRotate_Click));
			break;
		}
		case 12:
		{
			ButtonBase val6 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnCrop_Click));
			break;
		}
		case 13:
		{
			ButtonBase val5 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnOK_Click));
			break;
		}
		case 14:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnRetake_Click));
			break;
		}
		case 15:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnChangeCamera_Click));
			break;
		}
		case 16:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnChangeSettings_Click));
			break;
		}
		case 17:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BtnTimer_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
