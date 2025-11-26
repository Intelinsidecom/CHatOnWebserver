using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using ChatOn.Infrastructure;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatON_WoA.Controls;

public sealed class SyncLoadingIndicator : UserControl, IComponentConnector
{
	private static SyncLoadingIndicator _activeIndicator;

	private Page _page;

	private bool _isCancelable;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LoadingIndicator;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SynchronizeText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtIntroText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock PleaseWaitText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static SyncLoadingIndicator ActiveIndicator => _activeIndicator;

	public static bool HandleBackKey()
	{
		if (_activeIndicator != null && !_activeIndicator._isCancelable)
		{
			return true;
		}
		if (_activeIndicator != null)
		{
			_activeIndicator.Close();
		}
		return false;
	}

	public static void StopLoading()
	{
		if (_activeIndicator != null)
		{
			_activeIndicator.Close();
		}
	}

	public SyncLoadingIndicator(Page page, Panel root, string text = "", bool isCancelable = false)
	{
		InitializeComponent();
		Grid.SetRowSpan((FrameworkElement)(object)this, 99);
		Grid.SetColumnSpan((FrameworkElement)(object)this, 99);
		_activeIndicator = this;
		SynchronizeText.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_SYNCHRONISE"));
		PleaseWaitText.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_PLEASE_WAIT_ING"));
		_page = page;
		if (text == "")
		{
			string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_SYCHRONISING_PLEASE_WAIT_INGNNIT_MAY_TAKE_A_LONG_TIME_TO_SYNCHRONISE_NOTI_MSG");
			int num = resourceString.LastIndexOf("\\n\\n");
			resourceString = resourceString.Substring(num, resourceString.Length - num).Replace("\\n\\n", "");
			txtIntroText.put_Text(resourceString);
		}
		else
		{
			txtIntroText.put_Text(text);
		}
		_isCancelable = isCancelable;
		((ICollection<UIElement>)root.Children).Add((UIElement)(object)this);
	}

	internal void Close()
	{
		_activeIndicator = null;
		if (_page != null)
		{
			if (_page.BottomAppBar != null)
			{
				((UIElement)_page.BottomAppBar).put_Visibility((Visibility)0);
			}
			((UIElement)_page).put_IsHitTestVisible(true);
		}
		DependencyObject parent = ((FrameworkElement)this).Parent;
		Panel val = (Panel)(object)((parent is Panel) ? parent : null);
		if (val != null)
		{
			((ICollection<UIElement>)val.Children).Remove((UIElement)(object)this);
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///Controls/SyncLoadingIndicator.xaml"), (ComponentResourceLocation)0);
			LoadingIndicator = (Grid)((FrameworkElement)this).FindName("LoadingIndicator");
			SynchronizeText = (TextBlock)((FrameworkElement)this).FindName("SynchronizeText");
			txtIntroText = (TextBlock)((FrameworkElement)this).FindName("txtIntroText");
			PleaseWaitText = (TextBlock)((FrameworkElement)this).FindName("PleaseWaitText");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
