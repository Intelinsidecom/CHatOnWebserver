using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Documents;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public sealed class BindRichTextBlock : UserControl, IComponentConnector
{
	public static readonly DependencyProperty TextProperty = DependencyProperty.RegisterAttached("Text", typeof(Paragraph), typeof(BindRichTextBlock), new PropertyMetadata((object)"", new PropertyChangedCallback(OnTextChanged)));

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private RichTextBlock RichText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public Paragraph Text
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (Paragraph)((DependencyObject)this).GetValue(TextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(TextProperty, (object)value);
		}
	}

	public BindRichTextBlock()
	{
		InitializeComponent();
	}

	private static void OnTextChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		if (obj is BindRichTextBlock)
		{
			(obj as BindRichTextBlock).UpdateContent();
		}
	}

	internal void UpdateContent()
	{
		RichText.put_FontFamily(((Control)this).FontFamily);
		RichText.put_FontSize(((Control)this).FontSize);
		RichText.put_Foreground(((Control)this).Foreground);
		try
		{
			((ICollection<Block>)RichText.Blocks).Clear();
		}
		catch
		{
		}
		try
		{
			((ICollection<Block>)RichText.Blocks).Add((Block)(object)Text);
		}
		catch
		{
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///BindRichTextBlock.xaml"), (ComponentResourceLocation)0);
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
