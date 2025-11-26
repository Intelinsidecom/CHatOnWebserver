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
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Controls;

public class ChatBubble : UserControl, IComponentConnector
{
	public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(string), typeof(ChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty SubTextProperty = DependencyProperty.Register("SubText", typeof(string), typeof(ChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty MediaTextProperty = DependencyProperty.Register("MediaText", typeof(string), typeof(ChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty SubParamProperty = DependencyProperty.Register("SubParam", typeof(int), typeof(ChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty MaxBubbleWidthProperty = DependencyProperty.Register("MaxBubbleWidth", typeof(double), typeof(ChatBubble), new PropertyMetadata((object)null, new PropertyChangedCallback(MaxBubbleWidthChanged)));

	public static readonly DependencyProperty TypeProperty = DependencyProperty.Register("Type", typeof(int), typeof(ChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty MessageProperty = DependencyProperty.Register("Message", typeof(Message), typeof(ChatBubble), (PropertyMetadata)null);

	public static readonly DependencyProperty FixedFontSizeProperty = DependencyProperty.Register("FixedFontSize", typeof(double), typeof(ChatBubble), new PropertyMetadata((object)null, new PropertyChangedCallback(FixedFontSizePropertyChanged)));

	public static Uri SavedBaseUri;

	private bool _isAdded;

	private PhotoFrame photo;

	private AniconPlayer anicon;

	private Image img;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ProgressRing ProgressControl;

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
		if (num < 50.0 || !(obj is ChatBubble))
		{
			return;
		}
		((FrameworkElement)(obj as ChatBubble).ContentTextBlock).put_MaxWidth(((double)e.NewValue >= 100.0) ? ((double)e.NewValue - 100.0) : ((double)e.NewValue));
		if (obj is ChatBubble chatBubble)
		{
			if (((FrameworkElement)chatBubble.LayoutRoot).FindName("PhotoControl") is PhotoFrame photoFrame)
			{
				photoFrame.MaxBubbleWidth = (double)e.NewValue - 110.0;
			}
			if (((FrameworkElement)chatBubble.LayoutRoot).FindName("AniconControl") is AniconPlayer aniconPlayer)
			{
				((FrameworkElement)aniconPlayer).put_MaxWidth((double)e.NewValue - 50.0);
				((FrameworkElement)aniconPlayer).put_MaxHeight((double)e.NewValue - 50.0);
			}
		}
		if (e.NewValue is string)
		{
			(obj as ChatBubble).ContentTextBlock.UpdateContent();
		}
	}

	private static void FixedFontSizePropertyChanged(DependencyObject sender, DependencyPropertyChangedEventArgs args)
	{
		((ChatBubble)(object)sender).UpdateContentFontSize();
	}

	public ChatBubble()
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
		//IL_02c2: Unknown result type (might be due to invalid IL or missing references)
		//IL_02c8: Invalid comparison between Unknown and I4
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
		UpdateContentFontSize(updateContent: false);
		if ((int)ApplicationView.Value != 2)
		{
			if (ChatDetailPage.ActiveInstance != null)
			{
				ChatDetailPage.ActiveInstance.LastAddedTick = DateTime.UtcNow.Ticks;
			}
		}
		else if (ChatDetailPage.SnappedActiveInstance != null)
		{
			ChatDetailPage.SnappedActiveInstance.LastAddedTick = DateTime.UtcNow.Ticks;
		}
	}

	private void ChatBubble_Unloaded(object sender, RoutedEventArgs e)
	{
	}

	private void ChatBubble_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_0011: Unknown result type (might be due to invalid IL or missing references)
		//IL_0449: Unknown result type (might be due to invalid IL or missing references)
		//IL_0450: Expected O, but got Unknown
		//IL_045f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0469: Expected O, but got Unknown
		//IL_0470: Unknown result type (might be due to invalid IL or missing references)
		//IL_047a: Expected O, but got Unknown
		//IL_04e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_04e8: Expected O, but got Unknown
		//IL_04f7: Unknown result type (might be due to invalid IL or missing references)
		//IL_0501: Expected O, but got Unknown
		//IL_052e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_005c: Expected O, but got Unknown
		//IL_0069: Unknown result type (might be due to invalid IL or missing references)
		//IL_0073: Expected O, but got Unknown
		//IL_0084: Unknown result type (might be due to invalid IL or missing references)
		//IL_008a: Expected O, but got Unknown
		//IL_0097: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a1: Expected O, but got Unknown
		//IL_0635: Unknown result type (might be due to invalid IL or missing references)
		//IL_063c: Expected O, but got Unknown
		//IL_064b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0655: Expected O, but got Unknown
		//IL_02e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_0573: Unknown result type (might be due to invalid IL or missing references)
		//IL_057a: Expected O, but got Unknown
		//IL_0589: Unknown result type (might be due to invalid IL or missing references)
		//IL_0593: Expected O, but got Unknown
		//IL_01f7: Unknown result type (might be due to invalid IL or missing references)
		//IL_0201: Expected O, but got Unknown
		//IL_0216: Unknown result type (might be due to invalid IL or missing references)
		//IL_0220: Expected O, but got Unknown
		//IL_029b: Unknown result type (might be due to invalid IL or missing references)
		//IL_02a1: Expected O, but got Unknown
		//IL_02ae: Unknown result type (might be due to invalid IL or missing references)
		//IL_02b8: Expected O, but got Unknown
		//IL_02fb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0302: Expected O, but got Unknown
		//IL_0319: Unknown result type (might be due to invalid IL or missing references)
		//IL_0320: Expected O, but got Unknown
		//IL_032f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0339: Expected O, but got Unknown
		//IL_0388: Unknown result type (might be due to invalid IL or missing references)
		//IL_038f: Expected O, but got Unknown
		//IL_03a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_03ad: Expected O, but got Unknown
		//IL_03bc: Unknown result type (might be due to invalid IL or missing references)
		//IL_03c6: Expected O, but got Unknown
		if (Message == null)
		{
			return;
		}
		if ((int)Message.PhotoVisibility == 0)
		{
			((UIElement)LayoutRoot).put_Visibility((Visibility)0);
			if (photo != null)
			{
				return;
			}
			photo = new PhotoFrame();
			((FrameworkElement)photo).put_Name("PhotoControl");
			PhotoFrame photoFrame = photo;
			DependencyProperty iconVisibilityProperty = PhotoFrame.IconVisibilityProperty;
			Binding val = new Binding();
			val.put_Source((object)this);
			val.put_Path(new PropertyPath("Message.VideoIconVisibility"));
			((FrameworkElement)photoFrame).SetBinding(iconVisibilityProperty, (BindingBase)(object)val);
			PhotoFrame photoFrame2 = photo;
			DependencyProperty photoProperty = PhotoFrame.PhotoProperty;
			Binding val2 = new Binding();
			val2.put_Source((object)this);
			val2.put_Path(new PropertyPath("Message.ThumbImage"));
			((FrameworkElement)photoFrame2).SetBinding(photoProperty, (BindingBase)(object)val2);
			Grid.SetRow((FrameworkElement)(object)photo, 1);
			Grid.SetColumn((FrameworkElement)(object)photo, 1);
			((FrameworkElement)photo).put_VerticalAlignment((VerticalAlignment)1);
			((FrameworkElement)photo).put_HorizontalAlignment((HorizontalAlignment)1);
			if (Message.Sender == RegistrationService.ChatOnID)
			{
				((FrameworkElement)photo).put_Margin(new Thickness(25.0, 10.0, 30.0, 10.0));
			}
			else
			{
				((FrameworkElement)photo).put_Margin(new Thickness(30.0, 10.0, 25.0, 10.0));
			}
			object obj = ((FrameworkElement)LayoutRoot).FindName("PhotoControl");
			if (obj == null)
			{
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)photo);
			}
		}
		if (Message.IsReadyToDownload || (!Message.IsReadyToDownload && Message.IsDownloading))
		{
			if (Message.IncompletedMediaMessage())
			{
				ProgressControl.put_IsActive(true);
				((UIElement)LayoutRoot).put_Visibility((Visibility)1);
				return;
			}
			ProgressControl.put_IsActive(false);
			((UIElement)LayoutRoot).put_Visibility((Visibility)0);
			if (img != null)
			{
				return;
			}
			img = new Image();
			img.put_Source((ImageSource)new BitmapImage(new Uri(SavedBaseUri, "Images/chat_download.png")));
			Grid.SetRow((FrameworkElement)(object)img, 1);
			Grid.SetColumn((FrameworkElement)(object)img, 2);
			img.put_Stretch((Stretch)0);
			((FrameworkElement)img).put_Margin(new Thickness(0.0, 0.0, 0.0, 30.0));
			((FrameworkElement)img).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)img).put_VerticalAlignment((VerticalAlignment)2);
			Image obj2 = img;
			DependencyProperty visibilityProperty = UIElement.VisibilityProperty;
			Binding val3 = new Binding();
			val3.put_Source((object)this);
			val3.put_Path(new PropertyPath("Message.IsReadyToDownload"));
			val3.put_Converter((IValueConverter)(object)new BoolToVisibility());
			((FrameworkElement)obj2).SetBinding(visibilityProperty, (BindingBase)(object)val3);
			((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)img);
		}
		if ((int)Message.MediaIconVisibility == 0)
		{
			((UIElement)LayoutRoot).put_Visibility((Visibility)0);
			StackPanel val4 = new StackPanel();
			((FrameworkElement)val4).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)val4).put_VerticalAlignment((VerticalAlignment)0);
			DependencyProperty visibilityProperty2 = UIElement.VisibilityProperty;
			Binding val5 = new Binding();
			val5.put_Source((object)this);
			val5.put_Path(new PropertyPath("Message.MediaIconVisibility"));
			((FrameworkElement)val4).SetBinding(visibilityProperty2, (BindingBase)(object)val5);
			Grid.SetRow((FrameworkElement)(object)val4, 1);
			Grid.SetColumn((FrameworkElement)(object)val4, 1);
			((FrameworkElement)val4).put_Margin(new Thickness(30.0, 10.0, 30.0, 10.0));
			val4.put_Orientation((Orientation)1);
			Image val6 = new Image();
			((FrameworkElement)val6).put_HorizontalAlignment((HorizontalAlignment)0);
			((FrameworkElement)val6).put_VerticalAlignment((VerticalAlignment)0);
			DependencyProperty sourceProperty = Image.SourceProperty;
			Binding val7 = new Binding();
			val7.put_Source((object)this);
			val7.put_Path(new PropertyPath("Message.MediaIconUri"));
			((FrameworkElement)val6).SetBinding(sourceProperty, (BindingBase)(object)val7);
			try
			{
				ImageSource source = val6.Source;
				BitmapImage val8 = (BitmapImage)(object)((source is BitmapImage) ? source : null);
				if (val8 != null && val8.UriSource != null && val8.UriSource.OriginalString.Contains("chat_video"))
				{
					((FrameworkElement)val6).put_Margin(new Thickness(18.0, 0.0, 0.0, 0.0));
				}
			}
			catch (Exception)
			{
			}
			((ICollection<UIElement>)((Panel)val4).Children).Add((UIElement)(object)val6);
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
			((ICollection<UIElement>)((Panel)val4).Children).Add((UIElement)(object)val9);
			((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)val4);
		}
		if ((int)Message.AniconVisibility == 0)
		{
			((UIElement)LayoutRoot).put_Visibility((Visibility)0);
			if (anicon != null)
			{
				return;
			}
			anicon = new AniconPlayer();
			((FrameworkElement)anicon).put_Name("AniconControl");
			AniconPlayer aniconPlayer = anicon;
			DependencyProperty sourceIDProperty = AniconPlayer.SourceIDProperty;
			Binding val11 = new Binding();
			val11.put_Source((object)this);
			val11.put_Path(new PropertyPath("Text"));
			val11.put_Converter((IValueConverter)(object)new ChatTextToAniconConverter());
			((FrameworkElement)aniconPlayer).SetBinding(sourceIDProperty, (BindingBase)(object)val11);
			((FrameworkElement)anicon).put_VerticalAlignment((VerticalAlignment)1);
			((FrameworkElement)anicon).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)anicon).put_Width(170.0);
			((FrameworkElement)anicon).put_Height(170.0);
			Grid.SetRow((FrameworkElement)(object)anicon, 1);
			Grid.SetColumn((FrameworkElement)(object)anicon, 1);
			object obj3 = ((FrameworkElement)LayoutRoot).FindName("AniconControl");
			if (obj3 == null)
			{
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)anicon);
			}
		}
		TextBlock subTextBlock = SubTextBlock;
		DependencyProperty visibilityProperty3 = UIElement.VisibilityProperty;
		Binding val12 = new Binding();
		val12.put_Source((object)this);
		val12.put_Path(new PropertyPath("Message.ActivityState"));
		val12.put_Converter((IValueConverter)(object)new MessageStateToTimeVisibility());
		val12.put_ConverterParameter((object)Message.IsDownloading);
		((FrameworkElement)subTextBlock).SetBinding(visibilityProperty3, (BindingBase)(object)val12);
	}

	private void ChatBubble_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value != 2)
		{
			if (ChatDetailPage.ActiveInstance != null)
			{
				ChatDetailPage.ActiveInstance.CheckScrollToEnd(Message, e.NewSize.Height != e.PreviousSize.Height);
			}
		}
		else if (ChatDetailPage.SnappedActiveInstance != null)
		{
			ChatDetailPage.SnappedActiveInstance.CheckScrollToEnd(Message, e.NewSize.Height != e.PreviousSize.Height);
		}
		if (Message != null)
		{
			Message.NotifyIsDownloadingUpdated();
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
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ChatBubble.xaml"), (ComponentResourceLocation)0);
			ProgressControl = (ProgressRing)((FrameworkElement)this).FindName("ProgressControl");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			BubbleImage = (Image)((FrameworkElement)this).FindName("BubbleImage");
			ContentTextBlock = (ChatTextBlock)((FrameworkElement)this).FindName("ContentTextBlock");
			SubTextPanel = (StackPanel)((FrameworkElement)this).FindName("SubTextPanel");
			SubText2Block = (TextBlock)((FrameworkElement)this).FindName("SubText2Block");
			SubTextBlock = (TextBlock)((FrameworkElement)this).FindName("SubTextBlock");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Expected O, but got Unknown
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0039: Expected O, but got Unknown
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0040: Expected O, but got Unknown
		//IL_005f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0069: Expected O, but got Unknown
		//IL_006a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0070: Expected O, but got Unknown
		//IL_008f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0099: Expected O, but got Unknown
		if (connectionId == 1)
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(ChatBubble_Loaded));
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Unloaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Unloaded)), new RoutedEventHandler(ChatBubble_Unloaded));
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(ChatBubble_SizeChanged));
		}
		_contentLoaded = true;
	}
}
