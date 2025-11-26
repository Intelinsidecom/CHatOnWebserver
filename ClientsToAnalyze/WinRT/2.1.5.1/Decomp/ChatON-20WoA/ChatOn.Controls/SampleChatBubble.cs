using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Controls;

public class SampleChatBubble : UserControl, IComponentConnector
{
	public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(string), typeof(SampleChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty SubTextProperty = DependencyProperty.Register("SubText", typeof(string), typeof(SampleChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty MediaTextProperty = DependencyProperty.Register("MediaText", typeof(string), typeof(SampleChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty SubParamProperty = DependencyProperty.Register("SubParam", typeof(int), typeof(SampleChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty MaxBubbleWidthProperty = DependencyProperty.Register("MaxBubbleWidth", typeof(double), typeof(SampleChatBubble), new PropertyMetadata((object)null, new PropertyChangedCallback(MaxBubbleWidthChanged)));

	public static readonly DependencyProperty TypeProperty = DependencyProperty.Register("Type", typeof(int), typeof(SampleChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty MessageProperty = DependencyProperty.Register("Message", typeof(Message), typeof(SampleChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty FixedFontSizeProperty = DependencyProperty.Register("FixedFontSize", typeof(double), typeof(SampleChatBubble), new PropertyMetadata((object)null, new PropertyChangedCallback(FixedFontSizePropertyChanged)));

	public static Uri SavedBaseUri;

	private bool _isAdded;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image BubbleImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatTextBlock ContentTextBlock;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel SubTextPanel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText2Block;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubTextBlock;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public string Text
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(TextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(TextProperty, (object)value);
		}
	}

	public string SubText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(SubTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(SubTextProperty, (object)value);
		}
	}

	public string MediaText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(MediaTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(MediaTextProperty, (object)value);
		}
	}

	public int SubParam
	{
		get
		{
			return (int)((DependencyObject)this).GetValue(SubParamProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(SubParamProperty, (object)value);
		}
	}

	public double MaxBubbleWidth
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(MaxBubbleWidthProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(MaxBubbleWidthProperty, (object)value);
		}
	}

	public int Type
	{
		get
		{
			return (int)((DependencyObject)this).GetValue(TypeProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(TypeProperty, (object)value);
		}
	}

	public Message Message
	{
		get
		{
			return (Message)((DependencyObject)this).GetValue(MessageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(MessageProperty, (object)value);
		}
	}

	public double FixedFontSize
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(FixedFontSizeProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(FixedFontSizeProperty, (object)value);
		}
	}

	private static void MaxBubbleWidthChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		if (!((double)e.NewValue > 0.0))
		{
			return;
		}
		double num = (double)e.NewValue;
		if (num < 50.0 || !(obj is SampleChatBubble))
		{
			return;
		}
		((FrameworkElement)(obj as SampleChatBubble).ContentTextBlock).put_MaxWidth((double)e.NewValue - 100.0);
		if (obj is SampleChatBubble sampleChatBubble)
		{
			if (((FrameworkElement)sampleChatBubble.LayoutRoot).FindName("PhotoControl") is PhotoFrame photoFrame)
			{
				photoFrame.MaxBubbleWidth = (double)e.NewValue - 110.0;
			}
			if (((FrameworkElement)sampleChatBubble.LayoutRoot).FindName("AniconControl") is AniconPlayer aniconPlayer)
			{
				((FrameworkElement)aniconPlayer).put_MaxWidth((double)e.NewValue - 50.0);
				((FrameworkElement)aniconPlayer).put_MaxHeight((double)e.NewValue - 50.0);
			}
		}
		(obj as SampleChatBubble).ContentTextBlock.UpdateContent();
	}

	private static void FixedFontSizePropertyChanged(DependencyObject sender, DependencyPropertyChangedEventArgs args)
	{
		((SampleChatBubble)(object)sender).UpdateContentFontSize();
	}

	public unsafe SampleChatBubble()
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_0028: Expected O, but got Unknown
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Expected O, but got Unknown
		//IL_0050: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Expected O, but got Unknown
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_006d: Expected O, but got Unknown
		//IL_0094: Unknown result type (might be due to invalid IL or missing references)
		//IL_009a: Expected O, but got Unknown
		//IL_00a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b1: Expected O, but got Unknown
		//IL_00c2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c8: Expected O, but got Unknown
		//IL_00d5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00df: Expected O, but got Unknown
		//IL_00f0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f7: Expected O, but got Unknown
		//IL_0106: Unknown result type (might be due to invalid IL or missing references)
		//IL_0110: Expected O, but got Unknown
		//IL_012e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0135: Expected O, but got Unknown
		//IL_0144: Unknown result type (might be due to invalid IL or missing references)
		//IL_014e: Expected O, but got Unknown
		//IL_0178: Unknown result type (might be due to invalid IL or missing references)
		//IL_017f: Expected O, but got Unknown
		//IL_018e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0198: Expected O, but got Unknown
		//IL_01c2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c9: Expected O, but got Unknown
		//IL_01d8: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e2: Expected O, but got Unknown
		//IL_020c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0213: Expected O, but got Unknown
		//IL_0222: Unknown result type (might be due to invalid IL or missing references)
		//IL_022c: Expected O, but got Unknown
		//IL_024a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0251: Expected O, but got Unknown
		//IL_0260: Unknown result type (might be due to invalid IL or missing references)
		//IL_026a: Expected O, but got Unknown
		//IL_0294: Unknown result type (might be due to invalid IL or missing references)
		//IL_029b: Expected O, but got Unknown
		//IL_02aa: Unknown result type (might be due to invalid IL or missing references)
		//IL_02b4: Expected O, but got Unknown
		//IL_02c6: Unknown result type (might be due to invalid IL or missing references)
		//IL_02cd: Expected O, but got Unknown
		//IL_02dc: Unknown result type (might be due to invalid IL or missing references)
		//IL_02e6: Expected O, but got Unknown
		//IL_0330: Unknown result type (might be due to invalid IL or missing references)
		//IL_033a: Expected O, but got Unknown
		//IL_037d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0387: Expected O, but got Unknown
		InitializeComponent();
		SavedBaseUri = ((FrameworkElement)this).BaseUri;
		ChatTextBlock contentTextBlock = ContentTextBlock;
		DependencyProperty textProperty = ChatTextBlock.TextProperty;
		Binding val = new Binding();
		val.put_Source((object)this);
		val.put_Path(new PropertyPath("Text"));
		((FrameworkElement)contentTextBlock).SetBinding(textProperty, (BindingBase)(object)val);
		ChatTextBlock contentTextBlock2 = ContentTextBlock;
		DependencyProperty horizontalAlignmentProperty = FrameworkElement.HorizontalAlignmentProperty;
		Binding val2 = new Binding();
		val2.put_Source((object)this);
		val2.put_Path(new PropertyPath("Type"));
		val2.put_Converter((IValueConverter)(object)new BubbleTypeToResource());
		val2.put_ConverterParameter((object)"Align");
		((FrameworkElement)contentTextBlock2).SetBinding(horizontalAlignmentProperty, (BindingBase)(object)val2);
		ChatTextBlock contentTextBlock3 = ContentTextBlock;
		DependencyProperty visibilityProperty = UIElement.VisibilityProperty;
		Binding val3 = new Binding();
		val3.put_Source((object)this);
		val3.put_Path(new PropertyPath("Message.TextVisibility"));
		((FrameworkElement)contentTextBlock3).SetBinding(visibilityProperty, (BindingBase)(object)val3);
		TextBlock subTextBlock = SubTextBlock;
		DependencyProperty textProperty2 = TextBlock.TextProperty;
		Binding val4 = new Binding();
		val4.put_Source((object)this);
		val4.put_Path(new PropertyPath("SubText"));
		((FrameworkElement)subTextBlock).SetBinding(textProperty2, (BindingBase)(object)val4);
		StackPanel subTextPanel = SubTextPanel;
		DependencyProperty visibilityProperty2 = UIElement.VisibilityProperty;
		Binding val5 = new Binding();
		val5.put_Source((object)this);
		val5.put_Path(new PropertyPath("Message.ActivityState"));
		val5.put_Converter((IValueConverter)(object)new MessageStateToSubTextVisibility());
		((FrameworkElement)subTextPanel).SetBinding(visibilityProperty2, (BindingBase)(object)val5);
		StackPanel subTextPanel2 = SubTextPanel;
		DependencyProperty columnProperty = Grid.ColumnProperty;
		Binding val6 = new Binding();
		val6.put_Source((object)this);
		val6.put_Path(new PropertyPath("Type"));
		val6.put_Converter((IValueConverter)(object)new BubbleTypeToResource());
		val6.put_ConverterParameter((object)"Col");
		((FrameworkElement)subTextPanel2).SetBinding(columnProperty, (BindingBase)(object)val6);
		TextBlock subText2Block = SubText2Block;
		DependencyProperty textProperty3 = TextBlock.TextProperty;
		Binding val7 = new Binding();
		val7.put_Source((object)this);
		val7.put_Path(new PropertyPath("SubParam"));
		val7.put_Converter((IValueConverter)(object)new StringFormatConverter());
		val7.put_ConverterParameter((object)"({0:})");
		((FrameworkElement)subText2Block).SetBinding(textProperty3, (BindingBase)(object)val7);
		TextBlock subText2Block2 = SubText2Block;
		DependencyProperty visibilityProperty3 = UIElement.VisibilityProperty;
		Binding val8 = new Binding();
		val8.put_Source((object)this);
		val8.put_Path(new PropertyPath("SubParam"));
		val8.put_Converter((IValueConverter)(object)new BiggerThanParamToVisibility());
		val8.put_ConverterParameter((object)"0");
		((FrameworkElement)subText2Block2).SetBinding(visibilityProperty3, (BindingBase)(object)val8);
		Image bubbleImage = BubbleImage;
		DependencyProperty sourceProperty = Image.SourceProperty;
		Binding val9 = new Binding();
		val9.put_Source((object)this);
		val9.put_Path(new PropertyPath("Type"));
		val9.put_Converter((IValueConverter)(object)new BubbleTypeToImageSource());
		((FrameworkElement)bubbleImage).SetBinding(sourceProperty, (BindingBase)(object)val9);
		Image bubbleImage2 = BubbleImage;
		DependencyProperty nineGridProperty = Image.NineGridProperty;
		Binding val10 = new Binding();
		val10.put_Source((object)this);
		val10.put_Path(new PropertyPath("Type"));
		val10.put_Converter((IValueConverter)(object)new BubbleTypeToResource());
		val10.put_ConverterParameter((object)"NineGrid");
		((FrameworkElement)bubbleImage2).SetBinding(nineGridProperty, (BindingBase)(object)val10);
		Image bubbleImage3 = BubbleImage;
		DependencyProperty visibilityProperty4 = UIElement.VisibilityProperty;
		Binding val11 = new Binding();
		val11.put_Source((object)this);
		val11.put_Path(new PropertyPath("Message.BubbleImageVisibility"));
		((FrameworkElement)bubbleImage3).SetBinding(visibilityProperty4, (BindingBase)(object)val11);
		Image bubbleImage4 = BubbleImage;
		DependencyProperty columnProperty2 = Grid.ColumnProperty;
		Binding val12 = new Binding();
		val12.put_Source((object)this);
		val12.put_Path(new PropertyPath("Type"));
		val12.put_Converter((IValueConverter)(object)new BubbleTypeToResource());
		val12.put_ConverterParameter((object)"LocCol");
		((FrameworkElement)bubbleImage4).SetBinding(columnProperty2, (BindingBase)(object)val12);
		UpdateContentFontSize(updateContent: false);
		WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(ChatBubble_SizeChanged));
		if (ChatDetailPage.ActiveInstance != null)
		{
			ChatDetailPage.ActiveInstance.LastAddedTick = DateTime.UtcNow.Ticks;
		}
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(ChatBubble_Loaded));
	}

	private void ChatBubble_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_003b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Expected O, but got Unknown
		//IL_004e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0058: Expected O, but got Unknown
		//IL_0064: Unknown result type (might be due to invalid IL or missing references)
		//IL_006a: Expected O, but got Unknown
		//IL_0077: Unknown result type (might be due to invalid IL or missing references)
		//IL_0081: Expected O, but got Unknown
		//IL_01b5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f9: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_016b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0172: Expected O, but got Unknown
		//IL_0181: Unknown result type (might be due to invalid IL or missing references)
		//IL_018b: Expected O, but got Unknown
		//IL_0384: Unknown result type (might be due to invalid IL or missing references)
		//IL_01bf: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c6: Expected O, but got Unknown
		//IL_01dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e4: Expected O, but got Unknown
		//IL_01f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01fd: Expected O, but got Unknown
		//IL_024c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0253: Expected O, but got Unknown
		//IL_026a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0271: Expected O, but got Unknown
		//IL_0280: Unknown result type (might be due to invalid IL or missing references)
		//IL_028a: Expected O, but got Unknown
		//IL_029f: Unknown result type (might be due to invalid IL or missing references)
		//IL_02a6: Expected O, but got Unknown
		//IL_02b5: Unknown result type (might be due to invalid IL or missing references)
		//IL_02bf: Expected O, but got Unknown
		//IL_02c6: Unknown result type (might be due to invalid IL or missing references)
		//IL_02d0: Expected O, but got Unknown
		//IL_0337: Unknown result type (might be due to invalid IL or missing references)
		//IL_033e: Expected O, but got Unknown
		//IL_034d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0357: Expected O, but got Unknown
		//IL_03a8: Unknown result type (might be due to invalid IL or missing references)
		//IL_03af: Expected O, but got Unknown
		//IL_03be: Unknown result type (might be due to invalid IL or missing references)
		//IL_03c8: Expected O, but got Unknown
		if (_isAdded)
		{
			return;
		}
		if (Message != null)
		{
			if ((int)Message.PhotoVisibility == 0)
			{
				PhotoFrame photoFrame = new PhotoFrame();
				((FrameworkElement)photoFrame).put_Name("PhotoControl");
				DependencyProperty iconVisibilityProperty = PhotoFrame.IconVisibilityProperty;
				Binding val = new Binding();
				val.put_Source((object)this);
				val.put_Path(new PropertyPath("Message.VideoIconVisibility"));
				((FrameworkElement)photoFrame).SetBinding(iconVisibilityProperty, (BindingBase)(object)val);
				DependencyProperty photoProperty = PhotoFrame.PhotoProperty;
				Binding val2 = new Binding();
				val2.put_Source((object)this);
				val2.put_Path(new PropertyPath("Message.ThumbImage"));
				((FrameworkElement)photoFrame).SetBinding(photoProperty, (BindingBase)(object)val2);
				Grid.SetRow((FrameworkElement)(object)photoFrame, 1);
				Grid.SetColumn((FrameworkElement)(object)photoFrame, 1);
				((FrameworkElement)photoFrame).put_VerticalAlignment((VerticalAlignment)1);
				((FrameworkElement)photoFrame).put_HorizontalAlignment((HorizontalAlignment)1);
				((FrameworkElement)photoFrame).put_Margin(new Thickness(30.0, 10.0, 30.0, 10.0));
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)photoFrame);
			}
			if (Message.IsReadyToDownload)
			{
				Image val3 = new Image();
				val3.put_Source((ImageSource)new BitmapImage(new Uri(SavedBaseUri, "Images/chat_download.png")));
				Grid.SetRow((FrameworkElement)(object)val3, 1);
				Grid.SetColumn((FrameworkElement)(object)val3, 2);
				val3.put_Stretch((Stretch)0);
				((FrameworkElement)val3).put_Margin(new Thickness(0.0, 0.0, 0.0, 30.0));
				((FrameworkElement)val3).put_HorizontalAlignment((HorizontalAlignment)1);
				((FrameworkElement)val3).put_VerticalAlignment((VerticalAlignment)2);
				DependencyProperty visibilityProperty = UIElement.VisibilityProperty;
				Binding val4 = new Binding();
				val4.put_Source((object)this);
				val4.put_Path(new PropertyPath("Message.IsReadyToDownload"));
				val4.put_Converter((IValueConverter)(object)new BoolToVisibility());
				((FrameworkElement)val3).SetBinding(visibilityProperty, (BindingBase)(object)val4);
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)val3);
			}
			if ((int)Message.MediaIconVisibility == 0)
			{
				StackPanel val5 = new StackPanel();
				((FrameworkElement)val5).put_HorizontalAlignment((HorizontalAlignment)1);
				((FrameworkElement)val5).put_VerticalAlignment((VerticalAlignment)0);
				DependencyProperty visibilityProperty2 = UIElement.VisibilityProperty;
				Binding val6 = new Binding();
				val6.put_Source((object)this);
				val6.put_Path(new PropertyPath("Message.MediaIconVisibility"));
				((FrameworkElement)val5).SetBinding(visibilityProperty2, (BindingBase)(object)val6);
				Grid.SetRow((FrameworkElement)(object)val5, 1);
				Grid.SetColumn((FrameworkElement)(object)val5, 1);
				((FrameworkElement)val5).put_Margin(new Thickness(30.0, 10.0, 30.0, 10.0));
				val5.put_Orientation((Orientation)1);
				Image val7 = new Image();
				((FrameworkElement)val7).put_HorizontalAlignment((HorizontalAlignment)0);
				((FrameworkElement)val7).put_VerticalAlignment((VerticalAlignment)0);
				DependencyProperty sourceProperty = Image.SourceProperty;
				Binding val8 = new Binding();
				val8.put_Source((object)this);
				val8.put_Path(new PropertyPath("Message.MediaIconUri"));
				((FrameworkElement)val7).SetBinding(sourceProperty, (BindingBase)(object)val8);
				((ICollection<UIElement>)((Panel)val5).Children).Add((UIElement)(object)val7);
				TextBlock val9 = new TextBlock();
				val9.put_TextWrapping((TextWrapping)2);
				val9.put_Foreground((Brush)new SolidColorBrush(Colors.Black));
				val9.put_FontFamily(new FontFamily("Segoe UI Light"));
				val9.put_FontSize(14.0);
				((FrameworkElement)val9).put_Margin(new Thickness(10.0, 0.0, 0.0, 0.0));
				((FrameworkElement)val9).put_HorizontalAlignment((HorizontalAlignment)0);
				((FrameworkElement)val9).put_MaxWidth(350.0);
				((FrameworkElement)val9).put_VerticalAlignment((VerticalAlignment)1);
				DependencyProperty textProperty = TextBlock.TextProperty;
				Binding val10 = new Binding();
				val10.put_Source((object)this);
				val10.put_Path(new PropertyPath("MediaText"));
				((FrameworkElement)val9).SetBinding(textProperty, (BindingBase)(object)val10);
				((ICollection<UIElement>)((Panel)val5).Children).Add((UIElement)(object)val9);
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)val5);
			}
			if ((int)Message.AniconVisibility == 0)
			{
				AniconPlayer aniconPlayer = new AniconPlayer();
				((FrameworkElement)aniconPlayer).put_Name("AniconControl");
				DependencyProperty sourceIDProperty = AniconPlayer.SourceIDProperty;
				Binding val11 = new Binding();
				val11.put_Source((object)this);
				val11.put_Path(new PropertyPath("Text"));
				val11.put_Converter((IValueConverter)(object)new ChatTextToAniconConverter());
				((FrameworkElement)aniconPlayer).SetBinding(sourceIDProperty, (BindingBase)(object)val11);
				((FrameworkElement)aniconPlayer).put_VerticalAlignment((VerticalAlignment)1);
				((FrameworkElement)aniconPlayer).put_HorizontalAlignment((HorizontalAlignment)1);
				((FrameworkElement)aniconPlayer).put_Width(170.0);
				((FrameworkElement)aniconPlayer).put_Height(170.0);
				Grid.SetRow((FrameworkElement)(object)aniconPlayer, 1);
				Grid.SetColumn((FrameworkElement)(object)aniconPlayer, 1);
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)aniconPlayer);
			}
		}
		_isAdded = true;
	}

	private void ChatBubble_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		if (ChatDetailPage.ActiveInstance != null)
		{
			ChatDetailPage.ActiveInstance.CheckScrollToEnd(Message, e.NewSize.Height > 0.0);
		}
	}

	public void UpdateContentFontSize(bool updateContent = true)
	{
		if (FixedFontSize > 0.0)
		{
			((Control)ContentTextBlock).put_FontSize(FixedFontSize);
		}
		else
		{
			((Control)ContentTextBlock).put_FontSize(SettingService.GetFontSize());
		}
		if (updateContent)
		{
			ContentTextBlock.UpdateContent();
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///Controls/SampleChatBubble.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			BubbleImage = (Image)((FrameworkElement)this).FindName("BubbleImage");
			ContentTextBlock = (ChatTextBlock)((FrameworkElement)this).FindName("ContentTextBlock");
			SubTextPanel = (StackPanel)((FrameworkElement)this).FindName("SubTextPanel");
			SubText2Block = (TextBlock)((FrameworkElement)this).FindName("SubText2Block");
			SubTextBlock = (TextBlock)((FrameworkElement)this).FindName("SubTextBlock");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
