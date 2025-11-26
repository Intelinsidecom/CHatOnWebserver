using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class DateChooser : UserControl, IComponentConnector
{
	private int _year;

	private int _month;

	private int _day;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ComboBox MonthSelector;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ComboBox DaySelector;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ComboBox YearSelector;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public DateTime SelectedDate
	{
		get
		{
			int num = DateTime.DaysInMonth(_year, _month);
			_day = ((_day > num) ? num : _day);
			return new DateTime(_year, _month, _day);
		}
	}

	public DateChooser()
	{
		InitializeComponent();
	}

	public void Load(DateTime currentDate)
	{
		_year = currentDate.Year;
		_month = currentDate.Month;
		_day = currentDate.Day;
		UpdateDaySelector(currentDate);
		UpdateMonthSelector(currentDate);
		UpdateYearSelector(currentDate);
	}

	private void UpdateYearSelector(DateTime currentDate)
	{
		DateTime.DaysInMonth(currentDate.Year, currentDate.Month);
		List<string> list = new List<string>();
		for (int i = 1900; i <= DateTime.Now.Year; i++)
		{
			list.Add(i.ToString());
		}
		((ItemsControl)YearSelector).put_ItemsSource((object)list);
		((Selector)YearSelector).put_SelectedIndex(currentDate.Year - 1900);
	}

	private void UpdateDaySelector(DateTime currentDate)
	{
		int num = DateTime.DaysInMonth(currentDate.Year, currentDate.Month);
		List<string> list = new List<string>();
		for (int i = 1; i <= num; i++)
		{
			list.Add(i.ToString());
		}
		((ItemsControl)DaySelector).put_ItemsSource((object)list);
		((Selector)DaySelector).put_SelectedIndex((currentDate.Day > num) ? num : (currentDate.Day - 1));
		((UIElement)this).UpdateLayout();
	}

	private void UpdateMonthSelector(DateTime currentDate)
	{
		List<string> list = new List<string>();
		for (int i = 1; i <= 12; i++)
		{
			list.Add(new DateTime(1900, i, 1).ToString("MMMM"));
		}
		((ItemsControl)MonthSelector).put_ItemsSource((object)list);
		((Selector)MonthSelector).put_SelectedIndex(currentDate.Month - 1);
	}

	private void DateChooser_Loaded(object sender, RoutedEventArgs e)
	{
		OrderSelectorSourceByCulture();
	}

	private void OrderSelectorSourceByCulture()
	{
		string text = CultureInfo.CurrentCulture.DateTimeFormat.ShortDatePattern.ToUpperInvariant();
		int num = 0;
		bool flag = false;
		bool flag2 = false;
		bool flag3 = false;
		string text2 = text;
		foreach (char c in text2)
		{
			if (c == 'D' && !flag)
			{
				Grid.SetColumn((FrameworkElement)(object)DaySelector, num);
				flag = true;
				num++;
			}
			else if (c == 'M' && !flag3)
			{
				Grid.SetColumn((FrameworkElement)(object)MonthSelector, num);
				flag3 = true;
				num++;
			}
			else if (c == 'Y' && !flag2)
			{
				Grid.SetColumn((FrameworkElement)(object)YearSelector, num);
				flag2 = true;
				num++;
			}
		}
	}

	private void MonthSelector_SelectionChanged_1(object sender, SelectionChangedEventArgs e)
	{
		if (((Selector)MonthSelector).SelectedIndex >= 0)
		{
			_month = ((Selector)MonthSelector).SelectedIndex + 1;
		}
		if (_year >= DateTime.Now.Year && _month > DateTime.Now.Month)
		{
			_month = DateTime.Now.Month;
			((Selector)MonthSelector).put_SelectedIndex(_month - 1);
		}
		UpdateDaySelector(SelectedDate);
	}

	private void YearSelector_SelectionChanged_1(object sender, SelectionChangedEventArgs e)
	{
		if (((Selector)YearSelector).SelectedIndex >= 0)
		{
			_year = ((Selector)YearSelector).SelectedIndex + 1900;
		}
		if (_year > DateTime.Now.Year)
		{
			_year = DateTime.Now.Year;
		}
		UpdateDaySelector(SelectedDate);
	}

	private void DaySelector_SelectionChanged_1(object sender, SelectionChangedEventArgs e)
	{
		if (((Selector)DaySelector).SelectedIndex >= 0)
		{
			_day = ((Selector)DaySelector).SelectedIndex + 1;
		}
		if (_year >= DateTime.Now.Year && _month >= DateTime.Now.Month && _day > DateTime.Now.Day)
		{
			_month = DateTime.Now.Month;
			((Selector)MonthSelector).put_SelectedIndex(_month - 1);
			_day = DateTime.Now.Day;
			((Selector)DaySelector).put_SelectedIndex(DateTime.Now.Day - 1);
		}
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///DateChooser.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			MonthSelector = (ComboBox)((FrameworkElement)this).FindName("MonthSelector");
			DaySelector = (ComboBox)((FrameworkElement)this).FindName("DaySelector");
			YearSelector = (ComboBox)((FrameworkElement)this).FindName("YearSelector");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_0087: Unknown result type (might be due to invalid IL or missing references)
		//IL_008d: Expected O, but got Unknown
		//IL_00ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b6: Expected O, but got Unknown
		//IL_00b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c0: Expected O, but got Unknown
		//IL_00e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00eb: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(DateChooser_Loaded));
			break;
		}
		case 2:
		{
			Selector val3 = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(MonthSelector_SelectionChanged_1));
			break;
		}
		case 3:
		{
			Selector val2 = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(DaySelector_SelectionChanged_1));
			break;
		}
		case 4:
		{
			Selector val = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(YearSelector_SelectionChanged_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
