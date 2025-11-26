using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class AddBirthdayDialog : UserControl, IComponentConnector
{
	public delegate void AddBirthdayEventHandler(object sender, object e);

	private UserProfile _myProfile;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Border LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private DateChooser DateChooserControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private CheckBox ToggleShowYear;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public UserProfile MyProfile => _myProfile;

	public bool IsShowYear => ((ToggleButton)ToggleShowYear).IsChecked.Value;

	public DateTime SelectedDate => DateChooserControl.SelectedDate;

	public event AddBirthdayEventHandler EditCompleted;

	public AddBirthdayDialog()
	{
		InitializeComponent();
		_myProfile = RegistrationService.GetUserProfile();
		DateTime currentDate = DateTime.Today;
		if (MyProfile.Birthday.Ticks != 0)
		{
			currentDate = MyProfile.Birthday;
		}
		((ToggleButton)ToggleShowYear).put_IsChecked((bool?)_myProfile.ShowYear);
		DateChooserControl.Load(currentDate);
	}

	private void Button_Click_1(object sender, RoutedEventArgs e)
	{
		Close();
		if (this.EditCompleted != null)
		{
			this.EditCompleted(this, true);
		}
	}

	private void Button_Click_2(object sender, RoutedEventArgs e)
	{
		Close();
		if (this.EditCompleted != null)
		{
			this.EditCompleted(this, false);
		}
	}

	private void Close()
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		if (((FrameworkElement)((parent is FrameworkElement) ? parent : null)).Parent is CustomPopup customPopup)
		{
			customPopup.Close();
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///AddBirthdayDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Border)((FrameworkElement)this).FindName("LayoutRoot");
			DateChooserControl = (DateChooser)((FrameworkElement)this).FindName("DateChooserControl");
			ToggleShowYear = (CheckBox)((FrameworkElement)this).FindName("ToggleShowYear");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Expected O, but got Unknown
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Expected O, but got Unknown
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0076: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_1));
			break;
		}
		case 2:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_2));
			break;
		}
		}
		_contentLoaded = true;
	}
}
