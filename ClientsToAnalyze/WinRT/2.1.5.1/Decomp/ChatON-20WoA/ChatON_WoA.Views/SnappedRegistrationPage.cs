using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SnappedRegistrationPage : Page, IComponentConnector
{
	private static SnappedRegistrationPage _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static SnappedRegistrationPage ActiveInstance => _activeInstance;

	public SnappedRegistrationPage()
	{
		InitializeComponent();
		_activeInstance = this;
		((FrameworkElement)this).put_DataContext((object)this);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		_activeInstance = null;
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SnappedRegistrationPage.xaml"), (ComponentResourceLocation)0);
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
