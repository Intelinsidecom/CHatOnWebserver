using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Documents;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatOn.Controls;

public class HilightedTextBlock : UserControl, IComponentConnector
{
	public static readonly DependencyProperty TextProperty = DependencyProperty.RegisterAttached("Text", typeof(string), typeof(HilightedTextBlock), (PropertyMetadata)null);

	public static readonly DependencyProperty KeywordProperty = DependencyProperty.RegisterAttached("Keyword", typeof(string), typeof(HilightedTextBlock), (PropertyMetadata)null);

	public static readonly DependencyProperty MaxLengthProperty = DependencyProperty.RegisterAttached("MaxLength", typeof(int), typeof(HilightedTextBlock), (PropertyMetadata)null);

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private RichTextBlock RichText;

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

	public string Keyword
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(KeywordProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(KeywordProperty, (object)value);
		}
	}

	public int MaxLength
	{
		get
		{
			return (int)((DependencyObject)this).GetValue(MaxLengthProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(MaxLengthProperty, (object)value);
		}
	}

	public unsafe HilightedTextBlock()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		InitializeComponent();
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(HilightedTextBlock_Loaded));
	}

	private void HilightedTextBlock_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		//IL_018b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0192: Expected O, but got Unknown
		//IL_0159: Unknown result type (might be due to invalid IL or missing references)
		//IL_0160: Expected O, but got Unknown
		//IL_00e9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f0: Expected O, but got Unknown
		//IL_010b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0115: Expected O, but got Unknown
		//IL_011c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0123: Expected O, but got Unknown
		//IL_00b8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bf: Expected O, but got Unknown
		RichText.put_FontFamily(((Control)this).FontFamily);
		RichText.put_FontSize(((Control)this).FontSize);
		RichText.put_Foreground(((Control)this).Foreground);
		((ICollection<Block>)RichText.Blocks).Clear();
		if (Text == null)
		{
			return;
		}
		Paragraph val = new Paragraph();
		string text = Text;
		if (Text.Length > MaxLength)
		{
			text = Text.Substring(0, MaxLength);
		}
		if (Keyword != null)
		{
			int num = 0;
			while (true)
			{
				int num2 = text.IndexOf(Keyword, num, StringComparison.CurrentCultureIgnoreCase);
				if (num2 < 0)
				{
					break;
				}
				string text2 = text.Substring(num, num2 - num);
				if (text2.Length >= 0)
				{
					Run val2 = new Run();
					val2.put_Text(text2);
					((ICollection<Inline>)val.Inlines).Add((Inline)(object)val2);
				}
				text2 = text.Substring(num2, Keyword.Length);
				Bold val3 = new Bold();
				((TextElement)val3).put_Foreground((Brush)new SolidColorBrush((Color)((IDictionary<object, object>)Application.Current.Resources)[(object)"PhoneAccentColor"]));
				InlineCollection inlines = ((Span)val3).Inlines;
				Run val4 = new Run();
				val4.put_Text(text2);
				((ICollection<Inline>)inlines).Add((Inline)(object)val4);
				((ICollection<Inline>)val.Inlines).Add((Inline)(object)val3);
				num = num2 + Keyword.Length;
			}
			int num3 = num;
			if (num3 < text.Length)
			{
				string text3 = text.Substring(num3);
				Run val5 = new Run();
				val5.put_Text(text3);
				((ICollection<Inline>)val.Inlines).Add((Inline)(object)val5);
			}
		}
		else
		{
			Run val6 = new Run();
			val6.put_Text(text);
			((ICollection<Inline>)val.Inlines).Add((Inline)(object)val6);
		}
		((ICollection<Block>)RichText.Blocks).Add((Block)(object)val);
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///HilightedTextBlock.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			RichText = (RichTextBlock)((FrameworkElement)this).FindName("RichText");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
