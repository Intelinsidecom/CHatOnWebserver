using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media.Animation;

namespace ChatON_WoA;

public sealed class ProgressRing2 : UserControl, IComponentConnector
{
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Storyboard RotateStoryBoard;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Storyboard EnterStoryBoard;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Storyboard ExitStoryBoard;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image RotatingImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ProgressRing2()
	{
		InitializeComponent();
	}

	private void UserControl_Loaded(object sender, RoutedEventArgs e)
	{
		EnterStoryBoard.Begin();
		RotateStoryBoard.Begin();
	}

	private void UserControl_Unloaded(object sender, RoutedEventArgs e)
	{
		ExitStoryBoard.Begin();
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///ProgressRing2.xaml"), (ComponentResourceLocation)0);
			RotateStoryBoard = (Storyboard)((FrameworkElement)this).FindName("RotateStoryBoard");
			EnterStoryBoard = (Storyboard)((FrameworkElement)this).FindName("EnterStoryBoard");
			ExitStoryBoard = (Storyboard)((FrameworkElement)this).FindName("ExitStoryBoard");
			RotatingImage = (Image)((FrameworkElement)this).FindName("RotatingImage");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		//IL_0037: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Expected O, but got Unknown
		//IL_005c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Expected O, but got Unknown
		if (connectionId == 1)
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(UserControl_Loaded));
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Unloaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Unloaded)), new RoutedEventHandler(UserControl_Unloaded));
		}
		_contentLoaded = true;
	}
}
