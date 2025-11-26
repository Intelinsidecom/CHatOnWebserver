using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(Name = "Flipped", GroupName = "ImageState")]
[TemplatePart(Name = "NotificationBlock", Type = typeof(TextBlock))]
[TemplatePart(Name = "MessageBlock", Type = typeof(TextBlock))]
[TemplateVisualState(Name = "Expanded", GroupName = "ImageState")]
[TemplateVisualState(Name = "Semiexpanded", GroupName = "ImageState")]
[TemplatePart(Name = "BackTitleBlock", Type = typeof(TextBlock))]
[TemplateVisualState(Name = "Collapsed", GroupName = "ImageState")]
public class HubTile : Control
{
	private const string ImageStates = "ImageState";

	private const string Expanded = "Expanded";

	private const string Semiexpanded = "Semiexpanded";

	private const string Collapsed = "Collapsed";

	private const string Flipped = "Flipped";

	private const string NotificationBlock = "NotificationBlock";

	private const string MessageBlock = "MessageBlock";

	private const string BackTitleBlock = "BackTitleBlock";

	private TextBlock _notificationBlock;

	private TextBlock _messageBlock;

	private TextBlock _backTitleBlock;

	internal int _stallingCounter;

	internal bool _canDrop;

	internal bool _canFlip;

	public static readonly DependencyProperty SourceProperty = DependencyProperty.Register("Source", typeof(ImageSource), typeof(HubTile), new PropertyMetadata(null));

	public static readonly DependencyProperty TitleProperty = DependencyProperty.Register("Title", typeof(string), typeof(HubTile), new PropertyMetadata(string.Empty, OnTitleChanged));

	public static readonly DependencyProperty NotificationProperty = DependencyProperty.Register("Notification", typeof(string), typeof(HubTile), new PropertyMetadata(string.Empty, OnBackContentChanged));

	public static readonly DependencyProperty MessageProperty = DependencyProperty.Register("Message", typeof(string), typeof(HubTile), new PropertyMetadata(string.Empty, OnBackContentChanged));

	public static readonly DependencyProperty DisplayNotificationProperty = DependencyProperty.Register("DisplayNotification", typeof(bool), typeof(HubTile), new PropertyMetadata(false, OnBackContentChanged));

	public static readonly DependencyProperty IsFrozenProperty = DependencyProperty.Register("IsFrozen", typeof(bool), typeof(HubTile), new PropertyMetadata(false, OnIsFrozenChanged));

	public static readonly DependencyProperty GroupTagProperty = DependencyProperty.Register("GroupTag", typeof(string), typeof(HubTile), new PropertyMetadata(string.Empty));

	private static readonly DependencyProperty StateProperty = DependencyProperty.Register("State", typeof(ImageState), typeof(HubTile), new PropertyMetadata(ImageState.Expanded, OnImageStateChanged));

	public ImageSource Source
	{
		get
		{
			return (ImageSource)GetValue(SourceProperty);
		}
		set
		{
			SetValue(SourceProperty, value);
		}
	}

	public string Title
	{
		get
		{
			return (string)GetValue(TitleProperty);
		}
		set
		{
			SetValue(TitleProperty, value);
		}
	}

	public string Notification
	{
		get
		{
			return (string)GetValue(NotificationProperty);
		}
		set
		{
			SetValue(NotificationProperty, value);
		}
	}

	public string Message
	{
		get
		{
			return (string)GetValue(MessageProperty);
		}
		set
		{
			SetValue(MessageProperty, value);
		}
	}

	public bool DisplayNotification
	{
		get
		{
			return (bool)GetValue(DisplayNotificationProperty);
		}
		set
		{
			SetValue(DisplayNotificationProperty, value);
		}
	}

	public bool IsFrozen
	{
		get
		{
			return (bool)GetValue(IsFrozenProperty);
		}
		set
		{
			SetValue(IsFrozenProperty, value);
		}
	}

	public string GroupTag
	{
		get
		{
			return (string)GetValue(GroupTagProperty);
		}
		set
		{
			SetValue(GroupTagProperty, value);
		}
	}

	internal ImageState State
	{
		get
		{
			return (ImageState)GetValue(StateProperty);
		}
		set
		{
			SetValue(StateProperty, value);
		}
	}

	private static void OnTitleChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		HubTile hubTile = (HubTile)obj;
		if (string.IsNullOrEmpty((string)e.NewValue))
		{
			hubTile._canDrop = false;
			hubTile.State = ImageState.Expanded;
		}
		else
		{
			hubTile._canDrop = true;
		}
	}

	private static void OnBackContentChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		HubTile hubTile = (HubTile)obj;
		if ((!string.IsNullOrEmpty(hubTile.Notification) && hubTile.DisplayNotification) || (!string.IsNullOrEmpty(hubTile.Message) && !hubTile.DisplayNotification))
		{
			hubTile._canFlip = true;
			return;
		}
		hubTile._canFlip = false;
		hubTile.State = ImageState.Expanded;
	}

	private static void OnIsFrozenChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		HubTile tile = (HubTile)obj;
		if ((bool)e.NewValue)
		{
			HubTileService.FreezeHubTile(tile);
		}
		else
		{
			HubTileService.UnfreezeHubTile(tile);
		}
	}

	private static void OnImageStateChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		((HubTile)obj).UpdateVisualState();
	}

	private void UpdateVisualState()
	{
		VisualStateManager.GoToState(this, State switch
		{
			ImageState.Expanded => "Expanded", 
			ImageState.Semiexpanded => "Semiexpanded", 
			ImageState.Collapsed => "Collapsed", 
			ImageState.Flipped => "Flipped", 
			_ => "Expanded", 
		}, useTransitions: true);
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		_notificationBlock = GetTemplateChild("NotificationBlock") as TextBlock;
		_messageBlock = GetTemplateChild("MessageBlock") as TextBlock;
		_backTitleBlock = GetTemplateChild("BackTitleBlock") as TextBlock;
		if (_notificationBlock != null)
		{
			Binding binding = new Binding();
			binding.Source = this;
			binding.Path = new PropertyPath("DisplayNotification");
			binding.Converter = new VisibilityConverter();
			binding.ConverterParameter = false;
			_notificationBlock.SetBinding(UIElement.VisibilityProperty, binding);
		}
		if (_messageBlock != null)
		{
			Binding binding2 = new Binding();
			binding2.Source = this;
			binding2.Path = new PropertyPath("DisplayNotification");
			binding2.Converter = new VisibilityConverter();
			binding2.ConverterParameter = true;
			_messageBlock.SetBinding(UIElement.VisibilityProperty, binding2);
		}
		if (_backTitleBlock != null)
		{
			Binding binding3 = new Binding();
			binding3.Source = this;
			binding3.Path = new PropertyPath("Title");
			binding3.Converter = new MultipleToSingleLineStringConverter();
			_backTitleBlock.SetBinding(TextBlock.TextProperty, binding3);
		}
		UpdateVisualState();
	}

	public HubTile()
	{
		base.DefaultStyleKey = typeof(HubTile);
		base.Loaded += HubTile_Loaded;
		base.Unloaded += HubTile_Unloaded;
	}

	private void HubTile_Loaded(object sender, RoutedEventArgs e)
	{
		HubTileService.InitializeReference(this);
	}

	private void HubTile_Unloaded(object sender, RoutedEventArgs e)
	{
		HubTileService.FinalizeReference(this);
	}
}
