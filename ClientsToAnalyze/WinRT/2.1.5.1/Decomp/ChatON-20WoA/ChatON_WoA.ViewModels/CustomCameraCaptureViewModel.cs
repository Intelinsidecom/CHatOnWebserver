using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using Windows.Devices.Enumeration;
using Windows.Graphics.Imaging;
using Windows.Media.Capture;
using Windows.Media.MediaProperties;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.ViewModels;

public class CustomCameraCaptureViewModel : NotificationObject
{
	private DeviceInformationCollection _mDeviceInfoCollection;

	private CustomCameraCapture _page;

	private CustomCameraCaptureState _mState;

	private MediaCapture m_MediaEngine;

	private IRandomAccessStream m_TempMediaCapture;

	public string TargetFileName;

	public ImageEncodingProperties TargetFileType;

	private DispatcherTimer _timer;

	private int _angle;

	private uint value1;

	private uint value2;

	private int index;

	public DeviceInformationCollection DeviceInfoCollection => _mDeviceInfoCollection;

	public CustomCameraCaptureState State
	{
		get
		{
			return _mState;
		}
		set
		{
			_mState = value;
		}
	}

	public MediaCapture MediaEngine => m_MediaEngine;

	public IRandomAccessStream TempMediaCapture => m_TempMediaCapture;

	public BitmapImage TempBitmapImage { get; set; }

	public Visibility ShowPreviewElement
	{
		get
		{
			if (_mState == CustomCameraCaptureState.Preview)
			{
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

	public Visibility ShowCaptureElement
	{
		get
		{
			if (_mState == CustomCameraCaptureState.Captured)
			{
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

	public Visibility ShowCroppingElement
	{
		get
		{
			if (_mState == CustomCameraCaptureState.Cropping)
			{
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

	public Visibility ShowChangeCamera { get; set; }

	public Visibility ShowNumber { get; set; }

	public int Number { get; set; }

	public CustomCameraCaptureViewModel(CustomCameraCapture page)
	{
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		DispatchedHandler val = null;
		TargetFileName = "Capture.jpg";
		index = -1;
		base._002Ector();
		try
		{
			_page = page;
			ShowNumber = (Visibility)1;
			TargetFileType = ImageEncodingProperties.CreateJpeg();
		}
		catch (Exception)
		{
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)async delegate
				{
					if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR")) && ((Page)_page).Frame.CanGoBack)
					{
						((Page)_page).Frame.GoBack();
					}
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
	}

	public void ShowOffCounter(bool value)
	{
		if (!value)
		{
			ShowNumber = (Visibility)1;
			OnCapture();
		}
		else
		{
			ShowNumber = (Visibility)0;
		}
		NotifyPropertyChanged("");
	}

	public async Task OnNavigatedTo(NavigationEventArgs e)
	{
		_mDeviceInfoCollection = await DeviceInformation.FindAllAsync((DeviceClass)4);
		ShowChangeCamera = (Visibility)(((IReadOnlyCollection<DeviceInformation>)_mDeviceInfoCollection).Count <= 1);
		if (((IReadOnlyCollection<DeviceInformation>)_mDeviceInfoCollection).Count > 0)
		{
			index = 0;
		}
		NotifyPropertyChanged("");
		TempBitmapImage = new BitmapImage();
	}

	public async Task OnInitPreview(DeviceInformation deviceInfo = null)
	{
		if (m_MediaEngine != null)
		{
			try
			{
				await m_MediaEngine.StopPreviewAsync();
			}
			catch (Exception)
			{
			}
		}
		m_MediaEngine = new MediaCapture();
		MediaCaptureInitializationSettings settings = new MediaCaptureInitializationSettings();
		settings.put_StreamingCaptureMode((StreamingCaptureMode)0);
		settings.put_PhotoCaptureSource((PhotoCaptureSource)0);
		if (deviceInfo != null)
		{
			settings.put_VideoDeviceId(deviceInfo.Id);
		}
		else if (index != -1 && _mDeviceInfoCollection != null && ((IReadOnlyCollection<DeviceInformation>)_mDeviceInfoCollection).Count > index)
		{
			settings.put_VideoDeviceId(((IReadOnlyList<DeviceInformation>)_mDeviceInfoCollection)[index].Id);
		}
		else
		{
			settings.put_VideoDeviceId(((IReadOnlyList<DeviceInformation>)_mDeviceInfoCollection)[0].Id);
		}
		await m_MediaEngine.InitializeAsync(settings);
	}

	public async Task OnStartPreview()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			await m_MediaEngine.StartPreviewAsync();
		}
		catch (Exception)
		{
		}
	}

	public async void OnCapture()
	{
		State = CustomCameraCaptureState.Captured;
		m_TempMediaCapture = (IRandomAccessStream)new InMemoryRandomAccessStream();
		await m_MediaEngine.CapturePhotoToStreamAsync(TargetFileType, m_TempMediaCapture);
		await ((IOutputStream)m_TempMediaCapture).FlushAsync();
		m_TempMediaCapture.Seek(0uL);
		((BitmapSource)TempBitmapImage).SetSource(m_TempMediaCapture);
		try
		{
			int num = default(int);
			_ = num;
			_ = 2;
			try
			{
				await m_MediaEngine.StopPreviewAsync();
			}
			catch (Exception)
			{
			}
		}
		finally
		{
			m_MediaEngine = null;
		}
		NotifyPropertyChanged("");
	}

	public async Task<bool> OnChangeCamera()
	{
		if (((IReadOnlyCollection<DeviceInformation>)_mDeviceInfoCollection).Count > 1)
		{
			await m_MediaEngine.StopPreviewAsync();
			int tempindex = 0;
			string deviceID = m_MediaEngine.MediaCaptureSettings.VideoDeviceId;
			foreach (DeviceInformation item in (IEnumerable<DeviceInformation>)_mDeviceInfoCollection)
			{
				if (!(item.Id.ToUpper() == deviceID.ToUpper()))
				{
					tempindex++;
					continue;
				}
				break;
			}
			int nextindex = (index = ((tempindex + 1 < ((IReadOnlyCollection<DeviceInformation>)_mDeviceInfoCollection).Count) ? (tempindex + 1) : 0));
			await OnInitPreview(((IReadOnlyList<DeviceInformation>)_mDeviceInfoCollection)[nextindex]);
		}
		return true;
	}

	public async Task OnRetake()
	{
		TempBitmapImage = null;
		if (m_TempMediaCapture != null)
		{
			((IDisposable)m_TempMediaCapture).Dispose();
		}
		m_TempMediaCapture = null;
		await OnInitPreview();
		TempBitmapImage = new BitmapImage();
		State = CustomCameraCaptureState.Preview;
		NotifyPropertyChanged("");
	}

	public void OnCrop()
	{
		State = CustomCameraCaptureState.Cropping;
		NotifyPropertyChanged("");
	}

	public void CancelCrop()
	{
		State = CustomCameraCaptureState.Captured;
		NotifyPropertyChanged("");
	}

	public async void CropImage(double _x1, double _x2, double _bx2, double _y1, double _y2, double _by2)
	{
		IRandomAccessStream stream = (m_TempMediaCapture = await CropImageSelected(_x1, _x2, _bx2, _y1, _y2, _by2));
		await ((BitmapSource)TempBitmapImage).SetSourceAsync(stream);
		State = CustomCameraCaptureState.Captured;
		NotifyPropertyChanged("");
	}

	private async Task<IRandomAccessStream> CropImageSelected(double _x1, double _x2, double _bx2, double _y1, double _y2, double _by2)
	{
		BitmapDecoder decoder = await BitmapDecoder.CreateAsync(m_TempMediaCapture);
		IRandomAccessStream stream = (IRandomAccessStream)new InMemoryRandomAccessStream();
		int newWidth = 1024;
		int newHeight = 1024;
		Utility.GetPhotoSizeByRatio(((BitmapSource)TempBitmapImage).PixelWidth, ((BitmapSource)TempBitmapImage).PixelHeight, ref newWidth, ref newHeight);
		BitmapTransform transform = new BitmapTransform();
		transform.put_ScaledWidth((uint)newWidth);
		transform.put_ScaledHeight((uint)newHeight);
		transform.put_InterpolationMode((BitmapInterpolationMode)2);
		BitmapBounds bounds = new BitmapBounds
		{
			Width = (uint)((_x2 - _x1) * (double)newWidth / _bx2),
			Height = (uint)((_y2 - _y1) * (double)newHeight / _by2),
			X = (uint)(_x1 * (double)newWidth / _bx2),
			Y = (uint)(_y1 * (double)newHeight / _by2)
		};
		transform.put_Bounds(bounds);
		byte[] pixels = (await decoder.GetPixelDataAsync((BitmapPixelFormat)12, (BitmapAlphaMode)0, transform, (ExifOrientationMode)1, (ColorManagementMode)0)).DetachPixelData();
		BitmapEncoder encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.JpegEncoderId, stream);
		encoder.SetPixelData((BitmapPixelFormat)12, (BitmapAlphaMode)0, bounds.Width, bounds.Height, 96.0, 96.0, pixels);
		await encoder.FlushAsync();
		await ((IOutputStream)stream).FlushAsync();
		stream.Seek(0uL);
		return stream;
	}

	public async Task<StorageFile> SaveImage()
	{
		WriteableBitmap wb = new WriteableBitmap(((BitmapSource)TempBitmapImage).PixelWidth, ((BitmapSource)TempBitmapImage).PixelHeight);
		m_TempMediaCapture.Seek(0uL);
		((BitmapSource)wb).SetSource(m_TempMediaCapture);
		wb.Invalidate();
		StorageFile file = await Utility.CreateLocalFile("Captured.jpg", "", replaceExisting: true);
		IRandomAccessStream output = await file.OpenAsync((FileAccessMode)1);
		try
		{
			BitmapEncoder encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.JpegEncoderId, output);
			Stream pixelStream = wb.PixelBuffer.AsStream();
			byte[] pixels = new byte[pixelStream.Length];
			await pixelStream.ReadAsync(pixels, 0, pixels.Length);
			encoder.SetPixelData((BitmapPixelFormat)87, (BitmapAlphaMode)2, (uint)((BitmapSource)wb).PixelWidth, (uint)((BitmapSource)wb).PixelHeight, 96.0, 96.0, pixels);
			await encoder.FlushAsync();
			output.GetOutputStreamAt(0uL).FlushAsync();
			return file;
		}
		finally
		{
			((IDisposable)output)?.Dispose();
		}
	}

	public async void RotateImage()
	{
		_angle += 90;
		WriteableBitmap wb = new WriteableBitmap(((BitmapSource)TempBitmapImage).PixelWidth, ((BitmapSource)TempBitmapImage).PixelHeight);
		m_TempMediaCapture.Seek(0uL);
		((BitmapSource)wb).SetSource(m_TempMediaCapture);
		wb.Invalidate();
		BitmapDecoder decoder = await BitmapDecoder.CreateAsync(m_TempMediaCapture);
		if (_angle % 90 == 0)
		{
			_ = _angle;
			_ = 0;
		}
		if (_angle % 180 == 0)
		{
			value1 = (uint)((BitmapSource)wb).PixelWidth;
			value2 = (uint)((BitmapSource)wb).PixelHeight;
		}
		else
		{
			value1 = (uint)((BitmapSource)wb).PixelHeight;
			value2 = (uint)((BitmapSource)wb).PixelWidth;
		}
		BitmapTransform val = new BitmapTransform();
		val.put_Rotation((BitmapRotation)1);
		val.put_InterpolationMode((BitmapInterpolationMode)0);
		val.put_Flip((BitmapFlip)0);
		BitmapTransform transform = val;
		byte[] pixels = (await decoder.GetPixelDataAsync((BitmapPixelFormat)12, (BitmapAlphaMode)2, transform, (ExifOrientationMode)0, (ColorManagementMode)1)).DetachPixelData();
		BitmapEncoder encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.JpegEncoderId, m_TempMediaCapture);
		encoder.SetPixelData((BitmapPixelFormat)12, (BitmapAlphaMode)2, (uint)((BitmapSource)wb).PixelHeight, (uint)((BitmapSource)wb).PixelWidth, decoder.DpiX, decoder.DpiY, pixels);
		await encoder.FlushAsync();
		await ((IOutputStream)m_TempMediaCapture).FlushAsync();
		m_TempMediaCapture.Seek(0uL);
		((BitmapSource)TempBitmapImage).SetSource(m_TempMediaCapture);
		NotifyPropertyChanged("TempBitmapImage");
	}
}
