using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Globalization;
using System.Runtime.InteropServices.WindowsRuntime;
using vitemapi;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class CalendarDetailPage : Page, IComponentConnector
{
	public class CalendarInfo
	{
		public string Location { get; set; }

		public string StartDate { get; set; }

		public string EndDate { get; set; }

		public string Summary { get; set; }

		public string Description { get; set; }

		public string Duration { get; set; }
	}

	private CalendarInfo _calendarInfo;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public CalendarInfo CalInfo
	{
		get
		{
			return _calendarInfo;
		}
		set
		{
			_calendarInfo = value;
		}
	}

	public CalendarDetailPage()
	{
		InitializeComponent();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e.Parameter != null)
		{
			MakeReceivedCalendarInfo(e.Parameter as string);
		}
		((FrameworkElement)this).put_DataContext((object)this);
	}

	private void MakeReceivedCalendarInfo(string vCalInfo)
	{
		vCalendar_t vCalendar_t = new vCalendar_t();
		vCalendar_t.pEncodedData = vCalInfo;
		vCalendar_t.nEncodedDataLen = vCalInfo.Length;
		vCalDecoder.DecodevCal(vCalendar_t);
		_calendarInfo = new CalendarInfo();
		_calendarInfo.Description = vCalendar_t.DESCRIPTION;
		DateTime dateTime = new DateTime((int)vCalendar_t.EndDate.nYear, (int)vCalendar_t.EndDate.nMonth, (int)vCalendar_t.EndDate.nDay, (int)vCalendar_t.EndDate.nHour, (int)vCalendar_t.EndDate.nMin, (int)vCalendar_t.EndDate.nSec);
		_calendarInfo.EndDate = dateTime.ToLocalTime().ToString(CultureInfo.CurrentUICulture.DateTimeFormat.ShortDatePattern) + " " + dateTime.ToLocalTime().ToString(CultureInfo.CurrentUICulture.DateTimeFormat.ShortTimePattern);
		_calendarInfo.Location = vCalendar_t.LOCATION;
		DateTime dateTime2 = new DateTime((int)vCalendar_t.StartDate.nYear, (int)vCalendar_t.StartDate.nMonth, (int)vCalendar_t.StartDate.nDay, (int)vCalendar_t.StartDate.nHour, (int)vCalendar_t.StartDate.nMin, (int)vCalendar_t.StartDate.nSec);
		_calendarInfo.StartDate = dateTime2.ToLocalTime().ToString(CultureInfo.CurrentUICulture.DateTimeFormat.ShortDatePattern) + " " + dateTime2.ToLocalTime().ToString(CultureInfo.CurrentUICulture.DateTimeFormat.ShortTimePattern);
		_calendarInfo.Summary = vCalendar_t.SUMMARY;
		_calendarInfo.Duration = _calendarInfo.StartDate + " - " + _calendarInfo.EndDate;
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///CalendarDetailPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		if (connectionId == 1)
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
		}
		_contentLoaded = true;
	}
}
