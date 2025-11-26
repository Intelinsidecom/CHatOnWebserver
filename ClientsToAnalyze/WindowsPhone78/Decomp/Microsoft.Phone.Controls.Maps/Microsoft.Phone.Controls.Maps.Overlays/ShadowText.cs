using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Media;
using Microsoft.Phone.Controls.Maps.AutomationPeers;

namespace Microsoft.Phone.Controls.Maps.Overlays;

[TemplatePart(Name = "Text1", Type = typeof(TextBlock))]
[TemplatePart(Name = "Text2", Type = typeof(TextBlock))]
public class ShadowText : Overlay
{
	internal const string Text1ElementName = "Text1";

	internal const string Text2ElementName = "Text2";

	private TextBlock text1;

	private TextBlock text2;

	public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(string), typeof(ShadowText), new PropertyMetadata(OnTextChanged));

	public static readonly DependencyProperty ForegroundTopProperty = DependencyProperty.Register("ForegroundTop", typeof(Brush), typeof(ShadowText), new PropertyMetadata(OnTextChanged));

	public static readonly DependencyProperty ForegroundBottomProperty = DependencyProperty.Register("ForegroundBottom", typeof(Brush), typeof(ShadowText), new PropertyMetadata(OnTextChanged));

	private readonly Brush Black = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 0, 0, 0));

	private readonly Brush White = new SolidColorBrush(Color.FromArgb(byte.MaxValue, byte.MaxValue, byte.MaxValue, byte.MaxValue));

	public string Text
	{
		get
		{
			return (string)GetValue(TextProperty);
		}
		set
		{
			SetValue(TextProperty, value);
		}
	}

	public Brush ForegroundTop
	{
		get
		{
			return (Brush)GetValue(ForegroundTopProperty);
		}
		set
		{
			SetValue(ForegroundTopProperty, value);
		}
	}

	public Brush ForegroundBottom
	{
		get
		{
			return (Brush)GetValue(ForegroundBottomProperty);
		}
		set
		{
			SetValue(ForegroundBottomProperty, value);
		}
	}

	public ShadowText()
	{
		base.DefaultStyleKey = typeof(ShadowText);
		text1 = new TextBlock();
		text2 = new TextBlock();
	}

	public void SetForegroundColorsForDarkBackground()
	{
		SetForegroundColors(White, Black);
	}

	public void SetForegroundColorsForLightBackground()
	{
		SetForegroundColors(Black, White);
	}

	public void SetForegroundColors(Brush top, Brush bottom)
	{
		ForegroundTop = top;
		ForegroundBottom = bottom;
	}

	private static void OnTextChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		((ShadowText)d).OnTextChanged();
	}

	private void OnTextChanged()
	{
		text1.Text = Text;
		text2.Text = Text;
		if (ForegroundTop != null && ForegroundBottom != null)
		{
			text1.Foreground = ForegroundBottom;
			text2.Foreground = ForegroundTop;
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "ShadowText");
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		text1 = GetTemplateChild("Text1") as TextBlock;
		text2 = GetTemplateChild("Text2") as TextBlock;
		OnTextChanged();
		FireTemplateApplied();
	}
}
