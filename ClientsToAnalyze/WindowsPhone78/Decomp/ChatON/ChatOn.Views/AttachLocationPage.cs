using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Device.Location;
using System.Diagnostics;
using System.Globalization;
using System.ServiceModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using ChatOn.FindService;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Controls.Maps;
using Microsoft.Phone.Controls.Maps.Core;
using Microsoft.Phone.Controls.Maps.Platform;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class AttachLocationPage : PhoneApplicationPage
{
	private GeoCoordinate _location;

	private GPSService _gpsService;

	private LocationService _locationService;

	private bool _fMapPush;

	private string _locationText;

	private Map _map;

	private MapLayer _pinLayer;

	private MapLayer _searchLayer;

	private Canvas _locationCanvas;

	private Image _pushPin;

	private TextBlock _locationMainText;

	private TextBlock _locationSubText;

	private System.Windows.Shapes.Rectangle _locationRect;

	private Dictionary<string, SearchResultBase> searchResults = new Dictionary<string, SearchResultBase>();

	private bool _useCurrentLocation;

	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal Grid ContentPanel;

	internal TextBox SearchInput;

	private bool _contentLoaded;

	public AttachLocationPage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_BODY_MY_LOCATION;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).Text = ResContainer.IDS_CHATON_BUTTON_SEND;
		object obj3 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[2];
		((ApplicationBarIconButton)((obj3 is ApplicationBarIconButton) ? obj3 : null)).Text = ResContainer.IDS_CHATON_SK_CANCEL;
		ApplicationIdCredentialsProvider credentialsProvider = new ApplicationIdCredentialsProvider("AgieeNvpLn79l-SzK0KiJ2bDiVY9MHQjeUnhAtFN4baWVRbTcMp5cJkKvcpar4bU");
		_map = new Map();
		if (AttachmentService.Instance.IsAttachmentEventRegistered())
		{
			_map.AnimationLevel = AnimationLevel.None;
			_map.CredentialsProvider = credentialsProvider;
			_map.MouseLeftButtonDown += map_MouseLeftButtonDown;
			_map.MouseMove += map_MouseMove;
			_map.MouseLeftButtonUp += map_MouseLeftButtonUp;
			_map.Culture = CultureInfo.CurrentCulture;
			_pinLayer = new MapLayer();
			_map.Children.Add(_pinLayer);
			ContentPanel.Children.Add(_map);
			_locationService = new LocationService(_map);
			_locationService.GetReverseGeocodeCompleted += locationService_GetReverseGeocodeCompleted;
		}
		((FrameworkElement)this).Loaded += AttachLocationPage_Loaded;
	}

	private void AttachLocationPage_Loaded(object sender, RoutedEventArgs e)
	{
		if (!_isNew || !AttachmentService.Instance.IsAttachmentEventRegistered())
		{
			return;
		}
		_isNew = false;
		string wP7_CHATON_POPUP_ALLOWLOCATION = ResContainer.WP7_CHATON_POPUP_ALLOWLOCATION;
		if (MessageBoxResult.OK == MessageBox.Show(wP7_CHATON_POPUP_ALLOWLOCATION, "", MessageBoxButton.OKCancel))
		{
			_useCurrentLocation = true;
			if (!SettingService.IsAllowLocation())
			{
				PageNavigationService.OpenAllowLocationPage((PhoneApplicationPage)(object)this);
			}
			else
			{
				SetMapPosition();
			}
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			if (!AttachmentService.Instance.IsAttachmentEventRegistered())
			{
				((DependencyObject)this).Dispatcher.BeginInvoke(delegate
				{
					Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
				});
			}
			else
			{
				((Page)this).NavigationService.RemoveBackEntry();
			}
		}
		else if (_useCurrentLocation && SettingService.IsAllowLocation())
		{
			SetMapPosition();
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void SetMapPosition()
	{
		_gpsService = new GPSService();
		_gpsService.GetGPSPositionChanged += _gpsService_GetGPSPositionChanged;
		_gpsService.GetGPSStatusChanged += _gpsService_GetGPSStatusChanged;
		_gpsService.StartGPS();
	}

	private void _gpsService_GetGPSPositionChanged(GeoCoordinate location)
	{
		SetMapView(location);
		_gpsService.StopGPS();
	}

	private void _gpsService_GetGPSStatusChanged(GeoPositionStatus status, GeoPositionPermission permission)
	{
		switch (status)
		{
		case GeoPositionStatus.Ready:
			if (permission == GeoPositionPermission.Denied)
			{
				((DependencyObject)this).Dispatcher.BeginInvoke(delegate
				{
					MessageBox.Show(ResContainer.WP7_CHATON_POP_LOCATIONOFF);
				});
			}
			else
			{
				((DependencyObject)this).Dispatcher.BeginInvoke(delegate
				{
					MessageBox.Show(ResContainer.WP7_CHATON_POP_LOCATION_STATUS_UNAVAILABLE);
				});
			}
			break;
		case GeoPositionStatus.Disabled:
			((DependencyObject)this).Dispatcher.BeginInvoke(delegate
			{
				MessageBox.Show(ResContainer.WP7_CHATON_POP_LOCATION_STATUS_UNAVAILABLE);
			});
			break;
		case GeoPositionStatus.Initializing:
		case GeoPositionStatus.NoData:
			break;
		}
	}

	private void SetMapView(GeoCoordinate location)
	{
		_location = location;
		_map.SetView(location, 12.0);
		AddPushPin(location);
		AddLocationPopup(location);
		_locationService.GetAddress(location);
	}

	private void AddPushPin(GeoCoordinate location)
	{
		_location = location;
		_pinLayer.Children.Clear();
		if (_pushPin == null)
		{
			_pushPin = CreatePushpin();
		}
		PositionOrigin bottomCenter = PositionOrigin.BottomCenter;
		_pinLayer.AddChild(_pushPin, location, bottomCenter);
	}

	private Image CreatePushpin()
	{
		Image image = new Image();
		image.Source = new BitmapImage(new Uri("/Images/icon_pin.png", UriKind.Relative));
		image.Opacity = 0.9;
		image.Stretch = Stretch.None;
		return image;
	}

	private void AddLocationPopup(GeoCoordinate location)
	{
		_locationCanvas = new Canvas();
		_locationCanvas.Opacity = 0.9;
		_locationRect = new System.Windows.Shapes.Rectangle();
		_locationRect.SetValue(Canvas.LeftProperty, 0.0);
		_locationRect.SetValue(Canvas.TopProperty, 0.0);
		_locationRect.Height = 50.0;
		System.Windows.Shapes.Rectangle locationRect = _locationRect;
		double radiusX = (_locationRect.RadiusY = 10.0);
		locationRect.RadiusX = radiusX;
		_locationRect.Fill = new SolidColorBrush(Color.FromArgb(byte.MaxValue, byte.MaxValue, byte.MaxValue, byte.MaxValue));
		_locationCanvas.Children.Add(_locationRect);
		StackPanel stackPanel = new StackPanel();
		stackPanel.SetValue(Canvas.LeftProperty, 10.0);
		stackPanel.SetValue(Canvas.TopProperty, 10.0);
		SolidColorBrush foreground = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 0, 0, 0));
		_locationMainText = new TextBlock();
		_locationMainText.FontSize = 20.0;
		_locationMainText.FontWeight = FontWeights.Bold;
		_locationMainText.Foreground = foreground;
		_locationSubText = new TextBlock();
		_locationSubText.FontSize = 20.0;
		_locationSubText.Foreground = foreground;
		stackPanel.Children.Add(_locationMainText);
		stackPanel.Children.Add(_locationSubText);
		_locationCanvas.Children.Add(stackPanel);
		_pinLayer.AddChild(_locationCanvas, location, new Point(20.0, -85.0));
	}

	private void map_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
	{
		_fMapPush = true;
	}

	private void map_MouseMove(object sender, MouseEventArgs e)
	{
		_fMapPush = false;
	}

	private void map_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
	{
		if (_fMapPush)
		{
			Point position = e.GetPosition(_map);
			if (_map.TryViewportPointToLocation(position, out _location))
			{
				AddPushPin(_location);
				_locationService.GetAddress(_location);
			}
			_fMapPush = false;
		}
	}

	private void sendButton_Click(object sender, EventArgs e)
	{
		if (!(_location == null))
		{
			AttachmentService.Instance.LocationChooser_Completed(this, _location);
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		}
	}

	private void locationService_GetReverseGeocodeCompleted(string result)
	{
		_locationText = result;
		if (!string.IsNullOrEmpty(_locationText))
		{
			((DependencyObject)this).Dispatcher.BeginInvoke(delegate
			{
				AddLocationPopup(_location);
				_locationMainText.Text = result;
				_locationRect.Width = _locationMainText.ActualWidth + 20.0;
			});
		}
	}

	private void cancelButton_Click(object sender, EventArgs e)
	{
		if (_gpsService != null)
		{
			_gpsService.StopGPS();
		}
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		_map.SetMode(new NullMode(), transferSettings: false);
		if (_map.IsDownloading || !_map.IsIdle)
		{
			e.Cancel = true;
		}
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	protected override void OnNavigatingFrom(NavigatingCancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (e.NavigationMode == NavigationMode.Back && AttachmentService.Instance.IsAttachmentEventRegistered())
		{
			_map.SetMode(new NullMode(), transferSettings: false);
			if (_map.IsDownloading || !_map.IsIdle)
			{
				e.Cancel = true;
			}
		}
		((Page)this).OnNavigatingFrom(e);
	}

	internal void ExecuteSearch(string query)
	{
		bool flag = false;
		BasicHttpBinding basicHttpBinding = ((!flag) ? new BasicHttpBinding(BasicHttpSecurityMode.None) : new BasicHttpBinding(BasicHttpSecurityMode.Transport));
		basicHttpBinding.MaxReceivedMessageSize = 2147483647L;
		basicHttpBinding.MaxBufferSize = int.MaxValue;
		UriBuilder uriBuilder = new UriBuilder("http://dev.virtualearth.net/webservices/v1/SearchService/SearchService.svc");
		if (flag)
		{
			uriBuilder.Scheme = Uri.UriSchemeHttps;
			uriBuilder.Port = -1;
		}
		SearchServiceClient searchClient = new SearchServiceClient(basicHttpBinding, new EndpointAddress(uriBuilder.Uri));
		searchClient.SearchCompleted += searchClient_SearchCompleted;
		SearchRequest request = new SearchRequest();
		request.Culture = _map.Culture.Name;
		request.Query = query;
		request.ExecutionOptions = new ExecutionOptions();
		request.ExecutionOptions.SuppressFaults = true;
		LocationRect boundingRectangle = _map.BoundingRectangle;
		LocationRect locationRect = new LocationRect(boundingRectangle);
		request.UserProfile = new UserProfile();
		Microsoft.Phone.Controls.Maps.Platform.Rectangle rectangle = new Microsoft.Phone.Controls.Maps.Platform.Rectangle();
		rectangle.Northeast = new Location();
		rectangle.Southwest = new Location();
		rectangle.Northeast.Latitude = locationRect.Northeast.Latitude;
		rectangle.Northeast.Longitude = locationRect.Northeast.Longitude;
		rectangle.Southwest.Latitude = locationRect.Southwest.Latitude;
		rectangle.Southwest.Longitude = locationRect.Southwest.Longitude;
		request.UserProfile.MapView = rectangle;
		_map.CredentialsProvider.GetCredentials(delegate(Credentials credentials)
		{
			request.Credentials = credentials;
			searchClient.SearchAsync(request);
		});
	}

	private void searchClient_SearchCompleted(object sender, SearchCompletedEventArgs e)
	{
		try
		{
			if (e.Result.ResponseSummary.StatusCode == ResponseStatusCode.Success)
			{
				string.Format(CultureInfo.InvariantCulture, "Found {0} results", e.Result.ResultSets[0].Results.Count);
				IList<GeoCoordinate> list = new List<GeoCoordinate>();
				if (e.Result == null || e.Result.ResultSets.Count <= 0)
				{
					return;
				}
				foreach (SearchResultBase result in e.Result.ResultSets[0].Results)
				{
					searchResults.Add(result.Id, result);
					if (result.LocationData.Locations.Count > 0)
					{
						Location location = new Location();
						location.Latitude = result.LocationData.Locations[0].Latitude;
						location.Longitude = result.LocationData.Locations[0].Longitude;
						Pushpin pushpin = new Pushpin();
						pushpin.Location = location;
						pushpin.Tag = result.Id;
						_searchLayer.Children.Add(pushpin);
						list.Add(location);
					}
				}
				if (list.Count > 0)
				{
					LocationRect.CreateLocationRect(list);
					_map.SetView(new LocationRect(LocationRect.CreateLocationRect(list)));
				}
				else if (e.Result.ResultSets[0].SearchRegion.BoundingArea != null)
				{
					LocationRect locationRect = new LocationRect();
					Microsoft.Phone.Controls.Maps.Platform.Rectangle rectangle = e.Result.ResultSets[0].SearchRegion.BoundingArea as Microsoft.Phone.Controls.Maps.Platform.Rectangle;
					GeoCoordinate geoCoordinate = new GeoCoordinate();
					GeoCoordinate geoCoordinate2 = new GeoCoordinate();
					geoCoordinate.Latitude = rectangle.Northeast.Latitude;
					geoCoordinate.Longitude = rectangle.Northeast.Longitude;
					geoCoordinate2.Latitude = rectangle.Southwest.Latitude;
					geoCoordinate2.Longitude = rectangle.Southwest.Longitude;
					locationRect.Northeast = geoCoordinate;
					locationRect.Southwest = geoCoordinate2;
					AddPushPin(locationRect.Center);
					_map.SetView(locationRect.Center, 11.0);
					if (e.Result.ResultSets[0].SearchRegion.GeocodeLocation != null)
					{
						AddLocationPopup(_location);
						_locationMainText.Text = e.Result.ResultSets[0].SearchRegion.GeocodeLocation.DisplayName;
						_locationRect.Width = _locationMainText.ActualWidth + 20.0;
					}
				}
			}
			else
			{
				_ = "error searching... status <" + e.Result.ResponseSummary.StatusCode.ToString() + ">";
			}
		}
		catch (Exception)
		{
		}
	}

	private void myLocationButton_Click(object sender, EventArgs e)
	{
		if (!_useCurrentLocation)
		{
			string wP7_CHATON_POPUP_ALLOWLOCATION = ResContainer.WP7_CHATON_POPUP_ALLOWLOCATION;
			if (MessageBoxResult.OK == MessageBox.Show(wP7_CHATON_POPUP_ALLOWLOCATION, "", MessageBoxButton.OKCancel))
			{
				_useCurrentLocation = true;
				if (!SettingService.IsAllowLocation())
				{
					PageNavigationService.OpenAllowLocationPage((PhoneApplicationPage)(object)this);
				}
				else
				{
					SetMapPosition();
				}
			}
		}
		else if (!SettingService.IsAllowLocation())
		{
			PageNavigationService.OpenAllowLocationPage((PhoneApplicationPage)(object)this);
		}
		else
		{
			SetMapPosition();
		}
	}

	private void ImageButton_Click(object sender, RoutedEventArgs e)
	{
		_map.Focus();
		string text = SearchInput.Text;
		if (!string.IsNullOrEmpty(text))
		{
			ExecuteSearch(text);
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AttachLocationPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			SearchInput = (TextBox)((FrameworkElement)this).FindName("SearchInput");
		}
	}
}
