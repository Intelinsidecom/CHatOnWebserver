using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatOn.Controls;

public sealed class PopupControl : UserControl, IComponentConnector
{
	public delegate void ChatOnPopupEventHandler(object sender, object e);

	public static readonly DependencyProperty TitleTextProperty = DependencyProperty.Register("TitleText", typeof(string), typeof(PopupControl), new PropertyMetadata((object)null, new PropertyChangedCallback(ChangeTitleText)));

	public static readonly DependencyProperty DetailTextProperty = DependencyProperty.Register("DetailText", typeof(string), typeof(PopupControl), (PropertyMetadata)null);

	public static readonly DependencyProperty ShowCancelProperty = DependencyProperty.Register("ShowCancel", typeof(bool), typeof(PopupControl), new PropertyMetadata((object)false, (PropertyChangedCallback)null));

	public static readonly DependencyProperty OKButtonBackgroundProperty = DependencyProperty.Register("OKButtonBackground", typeof(SolidColorBrush), typeof(PopupControl), new PropertyMetadata((object)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25)), (PropertyChangedCallback)null));

	public static readonly DependencyProperty CancelButtonBackgroundProperty = DependencyProperty.Register("CancelButtonBackground", typeof(SolidColorBrush), typeof(PopupControl), new PropertyMetadata((object)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25)), (PropertyChangedCallback)null));

	public static readonly DependencyProperty OKButtonForegroundProperty = DependencyProperty.Register("OKButtonForeground", typeof(SolidColorBrush), typeof(PopupControl), new PropertyMetadata((object)new SolidColorBrush(Colors.White), (PropertyChangedCallback)null));

	public static readonly DependencyProperty CancelButtonForegroundProperty = DependencyProperty.Register("CancelButtonForeground", typeof(SolidColorBrush), typeof(PopupControl), new PropertyMetadata((object)new SolidColorBrush(Colors.White), (PropertyChangedCallback)null));

	public static readonly DependencyProperty OKButtonTextProperty = DependencyProperty.Register("OKButtonText", typeof(string), typeof(PopupControl), (PropertyMetadata)null);

	public static readonly DependencyProperty CancelButtonTextProperty = DependencyProperty.Register("CancelButtonText", typeof(string), typeof(PopupControl), (PropertyMetadata)null);

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnCommandOK;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnCommandCancel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public string TitleText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(TitleTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(TitleTextProperty, (object)value);
		}
	}

	public string DetailText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(DetailTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(DetailTextProperty, (object)value);
		}
	}

	public bool ShowCancel
	{
		get
		{
			return (bool)((DependencyObject)this).GetValue(ShowCancelProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ShowCancelProperty, (object)value);
		}
	}

	public string OKButtonText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(OKButtonTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(OKButtonTextProperty, (object)value);
		}
	}

	public string CancelButtonText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(CancelButtonTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(CancelButtonTextProperty, (object)value);
		}
	}

	public SolidColorBrush OKButtonBackground
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (SolidColorBrush)((DependencyObject)this).GetValue(OKButtonBackgroundProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(OKButtonBackgroundProperty, (object)value);
		}
	}

	public SolidColorBrush CancelButtonBackground
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (SolidColorBrush)((DependencyObject)this).GetValue(CancelButtonBackgroundProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(CancelButtonBackgroundProperty, (object)value);
		}
	}

	public SolidColorBrush OKButtonForeground
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (SolidColorBrush)((DependencyObject)this).GetValue(OKButtonForegroundProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(OKButtonForegroundProperty, (object)value);
		}
	}

	public SolidColorBrush CancelButtonForeground
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (SolidColorBrush)((DependencyObject)this).GetValue(CancelButtonForegroundProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(CancelButtonForegroundProperty, (object)value);
		}
	}

	public event ChatOnPopupEventHandler ChatOnPopupCompleted;

	public PopupControl()
	{
		InitializeComponent();
	}

	private static void ChangeTitleText(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		if (obj is PopupControl)
		{
			(obj as PopupControl).UpdateContent();
		}
	}

	private void UpdateContent()
	{
		((FrameworkElement)LayoutRoot).put_Width(((FrameworkElement)this).Width);
		((FrameworkElement)LayoutRoot).put_Height(((FrameworkElement)this).Height);
		txtTitle.put_Text(TitleText);
		txtMessage.put_Text(DetailText);
		txtMessage.put_TextWrapping((TextWrapping)2);
		((ContentControl)btnCommandOK).put_Content((object)OKButtonText);
		((ContentControl)btnCommandCancel).put_Content((object)CancelButtonText);
		((Control)btnCommandOK).put_Background((Brush)(object)OKButtonBackground);
		((Control)btnCommandCancel).put_Background((Brush)(object)CancelButtonBackground);
		if (!ShowCancel)
		{
			((UIElement)btnCommandCancel).put_Visibility((Visibility)1);
		}
		((Control)btnCommandOK).put_Foreground((Brush)(object)OKButtonForeground);
		((Control)btnCommandCancel).put_Foreground((Brush)(object)CancelButtonForeground);
	}

	private void btnOk_Click(object sender, RoutedEventArgs e)
	{
		Close();
		this.ChatOnPopupCompleted(this, true);
	}

	private void btnCancel_Click(object sender, RoutedEventArgs e)
	{
		Close();
		this.ChatOnPopupCompleted(this, false);
	}

	private void Close()
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		if (((FrameworkElement)((parent is FrameworkElement) ? parent : null)).Parent is CustomPopup customPopup)
		{
			customPopup.Close();
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
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///Controls/PopupControl.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			txtTitle = (TextBlock)((FrameworkElement)this).FindName("txtTitle");
			txtMessage = (TextBlock)((FrameworkElement)this).FindName("txtMessage");
			btnCommandOK = (Button)((FrameworkElement)this).FindName("btnCommandOK");
			btnCommandCancel = (Button)((FrameworkElement)this).FindName("btnCommandCancel");
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
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(btnOk_Click));
			break;
		}
		case 2:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(btnCancel_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
