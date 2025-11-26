using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Navigation;
using Microsoft.Phone.Controls.LocalizedResources;
using Microsoft.Phone.Shell;

namespace Microsoft.Phone.Controls;

public class ListPickerPage : PhoneApplicationPage
{
	private const string StateKey_Value = "ListPickerPage_State_Value";

	private PageOrientation lastOrientation;

	private static readonly DependencyProperty IsOpenProperty = DependencyProperty.Register("isOIsOpenpen", typeof(bool), typeof(ListPickerPage), new PropertyMetadata(false, OnIsOpenChanged));

	internal Grid MainGrid;

	internal TextBlock HeaderTitle;

	internal ListBox Picker;

	private bool _contentLoaded;

	public string HeaderText { get; set; }

	public IList Items { get; private set; }

	public SelectionMode SelectionMode { get; set; }

	public object SelectedItem { get; set; }

	public IList SelectedItems { get; private set; }

	public DataTemplate FullModeItemTemplate { get; set; }

	private bool IsOpen
	{
		get
		{
			return (bool)((DependencyObject)this).GetValue(IsOpenProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(IsOpenProperty, (object)value);
		}
	}

	private static void OnIsOpenChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		(o as ListPickerPage).OnIsOpenChanged();
	}

	private void OnIsOpenChanged()
	{
		UpdateVisualState(useTransitions: true);
	}

	public ListPickerPage()
	{
		InitializeComponent();
		Items = new List<object>();
		SelectedItems = new List<object>();
		((FrameworkElement)this).Loaded += OnLoaded;
		((FrameworkElement)this).Unloaded += OnUnloaded;
	}

	private void OnLoaded(object sender, RoutedEventArgs e)
	{
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		((PhoneApplicationPage)this).OrientationChanged += OnOrientationChanged;
		lastOrientation = ((PhoneApplicationPage)this).Orientation;
		if (((PhoneApplicationPage)this).ApplicationBar != null)
		{
			foreach (object button in ((PhoneApplicationPage)this).ApplicationBar.Buttons)
			{
				IApplicationBarIconButton val = (IApplicationBarIconButton)((button is IApplicationBarIconButton) ? button : null);
				if (val != null)
				{
					if ("DONE" == ((IApplicationBarMenuItem)val).Text)
					{
						((IApplicationBarMenuItem)val).Text = ControlResources.DateTimePickerDoneText;
						((IApplicationBarMenuItem)val).Click += HandleDoneButtonClick;
					}
					else if ("CANCEL" == ((IApplicationBarMenuItem)val).Text)
					{
						((IApplicationBarMenuItem)val).Text = ControlResources.DateTimePickerCancelText;
						((IApplicationBarMenuItem)val).Click += HandleCancelButtonClick;
					}
				}
			}
		}
		SetupListItems(-90.0);
		PlaneProjection planeProjection = (PlaneProjection)HeaderTitle.Projection;
		if (planeProjection == null)
		{
			planeProjection = new PlaneProjection();
			HeaderTitle.Projection = planeProjection;
		}
		planeProjection.RotationX = -90.0;
		Picker.Opacity = 1.0;
		((DependencyObject)this).Dispatcher.BeginInvoke(delegate
		{
			IsOpen = true;
		});
	}

	private void OnUnloaded(object sender, RoutedEventArgs e)
	{
		((PhoneApplicationPage)this).OrientationChanged -= OnOrientationChanged;
	}

	private void SetupListItems(double degree)
	{
		for (int i = 0; i < Picker.Items.Count; i++)
		{
			ListBoxItem listBoxItem = (ListBoxItem)Picker.ItemContainerGenerator.ContainerFromIndex(i);
			if (listBoxItem != null)
			{
				PlaneProjection planeProjection = (PlaneProjection)listBoxItem.Projection;
				if (planeProjection == null)
				{
					planeProjection = (PlaneProjection)(listBoxItem.Projection = new PlaneProjection());
				}
				planeProjection.RotationX = degree;
			}
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
		if (((PhoneApplicationPage)this).State.ContainsKey("ListPickerPage_State_Value"))
		{
			((PhoneApplicationPage)this).State.Remove("ListPickerPage_State_Value");
			if (((Page)this).NavigationService.CanGoBack)
			{
				((Page)this).NavigationService.GoBack();
				return;
			}
		}
		if (HeaderText != null)
		{
			HeaderTitle.Text = HeaderText.ToUpper(CultureInfo.CurrentCulture);
		}
		Picker.DataContext = Items;
		Picker.SelectionMode = SelectionMode;
		if (FullModeItemTemplate != null)
		{
			Picker.ItemTemplate = FullModeItemTemplate;
		}
		if (SelectionMode == SelectionMode.Single)
		{
			((PhoneApplicationPage)this).ApplicationBar.IsVisible = false;
			Picker.SelectedItem = SelectedItem;
			return;
		}
		((PhoneApplicationPage)this).ApplicationBar.IsVisible = true;
		Picker.ItemContainerStyle = (Style)((FrameworkElement)this).Resources["ListBoxItemCheckedStyle"];
		foreach (object item in Items)
		{
			if (SelectedItems != null && SelectedItems.Contains(item))
			{
				Picker.SelectedItems.Add(item);
			}
		}
	}

	private void HandleDoneButtonClick(object sender, EventArgs e)
	{
		SelectedItem = Picker.SelectedItem;
		SelectedItems = Picker.SelectedItems;
		ClosePickerPage();
	}

	private void HandleCancelButtonClick(object sender, EventArgs e)
	{
		SelectedItem = null;
		SelectedItems = null;
		ClosePickerPage();
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		e.Cancel = true;
		SelectedItem = null;
		SelectedItems = null;
		ClosePickerPage();
	}

	private void ClosePickerPage()
	{
		IsOpen = false;
	}

	private void HandleClosedStoryboardCompleted(object sender, EventArgs e)
	{
		((Page)this).NavigationService.GoBack();
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedFrom(e);
		if (e.Uri.IsExternalNavigation())
		{
			((PhoneApplicationPage)this).State["ListPickerPage_State_Value"] = "ListPickerPage_State_Value";
		}
	}

	private void OnOrientationChanged(object sender, OrientationChangedEventArgs e)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e3: Expected O, but got Unknown
		//IL_01e3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e9: Expected O, but got Unknown
		//IL_0219: Unknown result type (might be due to invalid IL or missing references)
		//IL_021a: Unknown result type (might be due to invalid IL or missing references)
		//IL_001e: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Expected I4, but got Unknown
		//IL_00bf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c6: Invalid comparison between Unknown and I4
		//IL_0140: Unknown result type (might be due to invalid IL or missing references)
		//IL_0147: Invalid comparison between Unknown and I4
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0042: Invalid comparison between Unknown and I4
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Invalid comparison between Unknown and I4
		//IL_01be: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c4: Invalid comparison between Unknown and I4
		PageOrientation orientation = e.Orientation;
		RotateTransition rotateTransition = new RotateTransition();
		if (MainGrid != null)
		{
			PageOrientation val = orientation;
			switch (val - 1)
			{
			default:
				if ((int)val != 18)
				{
					if ((int)val == 34)
					{
						HeaderTitle.Margin = new Thickness(20.0, 0.0, 0.0, 0.0);
						Picker.Margin = new Thickness(8.0, 0.0, 0.0, 0.0);
						rotateTransition.Mode = (((int)lastOrientation == 5) ? RotateTransitionMode.In90Counterclockwise : RotateTransitionMode.In180Clockwise);
					}
					break;
				}
				goto case 1;
			case 0:
			case 4:
				HeaderTitle.Margin = new Thickness(20.0, 12.0, 12.0, 12.0);
				Picker.Margin = new Thickness(8.0, 12.0, 0.0, 0.0);
				rotateTransition.Mode = (((int)lastOrientation == 18) ? RotateTransitionMode.In90Counterclockwise : RotateTransitionMode.In90Clockwise);
				break;
			case 1:
				HeaderTitle.Margin = new Thickness(72.0, 0.0, 0.0, 0.0);
				Picker.Margin = new Thickness(60.0, 0.0, 0.0, 0.0);
				rotateTransition.Mode = (((int)lastOrientation == 34) ? RotateTransitionMode.In180Counterclockwise : RotateTransitionMode.In90Clockwise);
				break;
			case 2:
			case 3:
				break;
			}
		}
		PhoneApplicationPage element = (PhoneApplicationPage)((ContentControl)(PhoneApplicationFrame)Application.Current.RootVisual).Content;
		ITransition transition = rotateTransition.GetTransition((UIElement)(object)element);
		transition.Completed += delegate
		{
			transition.Stop();
		};
		transition.Begin();
		lastOrientation = orientation;
	}

	private void UpdateVisualState(bool useTransitions)
	{
		if (useTransitions)
		{
			if (!IsOpen)
			{
				SetupListItems(0.0);
			}
			Storyboard storyboard = new Storyboard();
			Storyboard value = AnimationForElement(HeaderTitle, 0);
			storyboard.Children.Add(value);
			IList<WeakReference> itemsInViewPort = ItemsControlExtensions.GetItemsInViewPort(Picker);
			for (int i = 0; i < itemsInViewPort.Count; i++)
			{
				FrameworkElement element = (FrameworkElement)itemsInViewPort[i].Target;
				Storyboard value2 = AnimationForElement(element, i + 1);
				storyboard.Children.Add(value2);
			}
			((DependencyObject)this).Dispatcher.BeginInvoke(UpdateOutOfViewItems);
			if (!IsOpen)
			{
				storyboard.Completed += HandleClosedStoryboardCompleted;
			}
			storyboard.Begin();
		}
		else if (!IsOpen)
		{
			HandleClosedStoryboardCompleted(null, null);
		}
	}

	private Storyboard AnimationForElement(FrameworkElement element, int index)
	{
		double num = 30.0;
		double value = (IsOpen ? 350 : 250);
		double value2 = (IsOpen ? (-45) : 0);
		double value3 = ((!IsOpen) ? 90 : 0);
		ExponentialEase exponentialEase = new ExponentialEase();
		exponentialEase.EasingMode = ((!IsOpen) ? EasingMode.EaseIn : EasingMode.EaseOut);
		exponentialEase.Exponent = 5.0;
		ExponentialEase easingFunction = exponentialEase;
		DoubleAnimation doubleAnimation = new DoubleAnimation();
		doubleAnimation.Duration = new Duration(TimeSpan.FromMilliseconds(value));
		doubleAnimation.From = value2;
		doubleAnimation.To = value3;
		doubleAnimation.EasingFunction = easingFunction;
		DoubleAnimation doubleAnimation2 = doubleAnimation;
		Storyboard.SetTarget(doubleAnimation2, element);
		Storyboard.SetTargetProperty(doubleAnimation2, new PropertyPath("(UIElement.Projection).(PlaneProjection.RotationX)"));
		Storyboard storyboard = new Storyboard();
		storyboard.BeginTime = TimeSpan.FromMilliseconds(num * (double)index);
		storyboard.Children.Add(doubleAnimation2);
		return storyboard;
	}

	private void UpdateOutOfViewItems()
	{
		IList<WeakReference> itemsInViewPort = ItemsControlExtensions.GetItemsInViewPort(Picker);
		for (int i = 0; i < Picker.Items.Count; i++)
		{
			FrameworkElement frameworkElement = (FrameworkElement)Picker.ItemContainerGenerator.ContainerFromIndex(i);
			if (frameworkElement == null)
			{
				continue;
			}
			bool flag = false;
			foreach (WeakReference item in itemsInViewPort)
			{
				if (item.Target == frameworkElement)
				{
					flag = true;
				}
			}
			if (!flag)
			{
				frameworkElement.Opacity = (IsOpen ? 1 : 0);
				if (frameworkElement.Projection is PlaneProjection planeProjection)
				{
					planeProjection.RotationX = 0.0;
				}
			}
		}
	}

	private void Picker_Tap(object sender, GestureEventArgs e)
	{
		if (SelectionMode == SelectionMode.Single)
		{
			SelectedItem = Picker.SelectedItem;
			ClosePickerPage();
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/Microsoft.Phone.Controls.Toolkit;component/ListPicker/ListPickerPage.xaml", UriKind.Relative));
			MainGrid = (Grid)((FrameworkElement)this).FindName("MainGrid");
			HeaderTitle = (TextBlock)((FrameworkElement)this).FindName("HeaderTitle");
			Picker = (ListBox)((FrameworkElement)this).FindName("Picker");
		}
	}
}
