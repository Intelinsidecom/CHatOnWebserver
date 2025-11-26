using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;
using Microsoft.Phone.Controls.Primitives;

namespace Microsoft.Phone.Controls;

public class DatePickerPage : DateTimePickerPageBase
{
	internal VisualStateGroup VisibilityStates;

	internal VisualState Open;

	internal VisualState Closed;

	internal PlaneProjection PlaneProjection;

	internal Rectangle SystemTrayPlaceholder;

	internal LoopingSelector SecondarySelector;

	internal LoopingSelector TertiarySelector;

	internal LoopingSelector PrimarySelector;

	private bool _contentLoaded;

	public DatePickerPage()
	{
		InitializeComponent();
		PrimarySelector.DataSource = new YearDataSource();
		SecondarySelector.DataSource = new MonthDataSource();
		TertiarySelector.DataSource = new DayDataSource();
		InitializeDateTimePickerPage(PrimarySelector, SecondarySelector, TertiarySelector);
	}

	protected override IEnumerable<LoopingSelector> GetSelectorsOrderedByCulturePattern()
	{
		return DateTimePickerPageBase.GetSelectorsOrderedByCulturePattern(CultureInfo.CurrentCulture.DateTimeFormat.ShortDatePattern.ToUpperInvariant(), new char[3] { 'Y', 'M', 'D' }, new LoopingSelector[3] { PrimarySelector, SecondarySelector, TertiarySelector });
	}

	protected override void OnOrientationChanged(OrientationChangedEventArgs e)
	{
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((PhoneApplicationPage)this).OnOrientationChanged(e);
		SystemTrayPlaceholder.Visibility = (((1 & e.Orientation) == 0) ? Visibility.Collapsed : Visibility.Visible);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/Microsoft.Phone.Controls.Toolkit;component/DateTimePickers/DatePickerPage.xaml", UriKind.Relative));
			VisibilityStates = (VisualStateGroup)((FrameworkElement)(object)this).FindName("VisibilityStates");
			Open = (VisualState)((FrameworkElement)(object)this).FindName("Open");
			Closed = (VisualState)((FrameworkElement)(object)this).FindName("Closed");
			PlaneProjection = (PlaneProjection)((FrameworkElement)(object)this).FindName("PlaneProjection");
			SystemTrayPlaceholder = (Rectangle)((FrameworkElement)(object)this).FindName("SystemTrayPlaceholder");
			SecondarySelector = (LoopingSelector)((FrameworkElement)(object)this).FindName("SecondarySelector");
			TertiarySelector = (LoopingSelector)((FrameworkElement)(object)this).FindName("TertiarySelector");
			PrimarySelector = (LoopingSelector)((FrameworkElement)(object)this).FindName("PrimarySelector");
		}
	}
}
