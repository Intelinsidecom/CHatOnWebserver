using System;
using System.Collections.Generic;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Documents;
using Windows.UI.Xaml.Media;

namespace ChatOn.Infrastructure;

public class BindingService
{
	public static readonly DependencyProperty FullTextProperty = DependencyProperty.RegisterAttached("FullText", typeof(string), typeof(BindingService), new PropertyMetadata((object)null, new PropertyChangedCallback(OnTextChangedCallback)));

	public static readonly DependencyProperty HighlightedTextProperty = DependencyProperty.RegisterAttached("HighlightedText", typeof(string), typeof(BindingService), new PropertyMetadata((object)null, new PropertyChangedCallback(OnTextChangedCallback)));

	public static readonly DependencyProperty HighlightBrushProperty = DependencyProperty.RegisterAttached("HighlightBrush", typeof(Brush), typeof(BindingService), new PropertyMetadata((object)null, new PropertyChangedCallback(OnHighlightBrushChangedCallback)));

	private static void OnHighlightBrushChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		TextBlock val = (TextBlock)(object)((d is TextBlock) ? d : null);
		if (val != null)
		{
			Brush highlightBrush = GetHighlightBrush(val);
			for (int i = 0; i < ((ICollection<Inline>)val.Inlines).Count; i += 2)
			{
				((TextElement)((IList<Inline>)val.Inlines)[i]).put_Foreground(highlightBrush);
			}
		}
	}

	private static void OnTextChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		//IL_0034: Unknown result type (might be due to invalid IL or missing references)
		//IL_0058: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		//IL_0098: Unknown result type (might be due to invalid IL or missing references)
		//IL_009f: Expected O, but got Unknown
		//IL_00c0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c7: Expected O, but got Unknown
		//IL_0105: Unknown result type (might be due to invalid IL or missing references)
		//IL_010c: Expected O, but got Unknown
		TextBlock val = (TextBlock)(object)((d is TextBlock) ? d : null);
		if (val == null)
		{
			return;
		}
		string fullText = GetFullText(val);
		string highlightedText = GetHighlightedText(val);
		if (string.IsNullOrEmpty(fullText) || highlightedText == null)
		{
			return;
		}
		Brush val2 = (Brush)(((object)GetHighlightBrush(val)) ?? ((object)new SolidColorBrush(Colors.Red)));
		highlightedText = highlightedText.Substring(1, highlightedText.Length - 2);
		if (string.IsNullOrWhiteSpace(highlightedText))
		{
			InlineCollection inlines = val.Inlines;
			Run val3 = new Run();
			val3.put_Text(fullText);
			((ICollection<Inline>)inlines).Add((Inline)(object)val3);
			return;
		}
		int length = highlightedText.Length;
		int num = 0;
		int num2 = fullText.IndexOf(highlightedText, 0, StringComparison.CurrentCultureIgnoreCase);
		((ICollection<Inline>)val.Inlines).Clear();
		while (num2 >= 0)
		{
			InlineCollection inlines2 = val.Inlines;
			Run val4 = new Run();
			val4.put_Text(fullText.Substring(num, num2 - num));
			((ICollection<Inline>)inlines2).Add((Inline)(object)val4);
			InlineCollection inlines3 = val.Inlines;
			Run val5 = new Run();
			val5.put_Text(fullText.Substring(num2, length));
			((TextElement)val5).put_Foreground(val2);
			((ICollection<Inline>)inlines3).Add((Inline)(object)val5);
			num = num2 + length;
			num2 = fullText.IndexOf(highlightedText, num, StringComparison.CurrentCultureIgnoreCase);
		}
		InlineCollection inlines4 = val.Inlines;
		Run val6 = new Run();
		val6.put_Text(fullText.Substring(num));
		((ICollection<Inline>)inlines4).Add((Inline)(object)val6);
	}

	public static void SetHighlightedText(TextBlock element, string value)
	{
		if (!string.IsNullOrWhiteSpace(value))
		{
			((DependencyObject)element).SetValue(HighlightedTextProperty, (object)value);
		}
	}

	public static string GetHighlightedText(TextBlock element)
	{
		return (string)((DependencyObject)element).GetValue(HighlightedTextProperty);
	}

	public static void SetFullText(TextBlock element, string value)
	{
		((DependencyObject)element).SetValue(FullTextProperty, (object)value);
	}

	public static string GetFullText(TextBlock element)
	{
		return (string)((DependencyObject)element).GetValue(FullTextProperty);
	}

	public static void SetHighlightBrush(TextBlock element, Brush value)
	{
		((DependencyObject)element).SetValue(HighlightBrushProperty, (object)value);
	}

	public static Brush GetHighlightBrush(TextBlock element)
	{
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Expected O, but got Unknown
		return (Brush)((DependencyObject)element).GetValue(HighlightBrushProperty);
	}
}
