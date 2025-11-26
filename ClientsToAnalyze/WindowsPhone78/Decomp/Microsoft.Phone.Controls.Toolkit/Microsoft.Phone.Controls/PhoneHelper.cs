using System.Collections;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace Microsoft.Phone.Controls;

internal static class PhoneHelper
{
	public const double SipLandscapeHeight = 259.0;

	public const double SipPortraitHeight = 339.0;

	public const double SipTextCompletionHeight = 62.0;

	public static bool TryGetPhoneApplicationFrame(out PhoneApplicationFrame phoneApplicationFrame)
	{
		UIElement rootVisual = Application.Current.RootVisual;
		phoneApplicationFrame = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
		return phoneApplicationFrame != null;
	}

	public static bool IsPortrait(this PhoneApplicationFrame phoneApplicationFrame)
	{
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		//IL_0003: Unknown result type (might be due to invalid IL or missing references)
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Unknown result type (might be due to invalid IL or missing references)
		PageOrientation val = (PageOrientation)13;
		return (PageOrientation)(val & phoneApplicationFrame.Orientation) == phoneApplicationFrame.Orientation;
	}

	public static double GetUsefulWidth(this PhoneApplicationFrame phoneApplicationFrame)
	{
		if (!phoneApplicationFrame.IsPortrait())
		{
			return ((FrameworkElement)(object)phoneApplicationFrame).ActualHeight;
		}
		return ((FrameworkElement)(object)phoneApplicationFrame).ActualWidth;
	}

	public static double GetUsefulHeight(this PhoneApplicationFrame phoneApplicationFrame)
	{
		if (!phoneApplicationFrame.IsPortrait())
		{
			return ((FrameworkElement)(object)phoneApplicationFrame).ActualWidth;
		}
		return ((FrameworkElement)(object)phoneApplicationFrame).ActualHeight;
	}

	public static Size GetUsefulSize(this PhoneApplicationFrame phoneApplicationFrame)
	{
		return new Size(phoneApplicationFrame.GetUsefulWidth(), phoneApplicationFrame.GetUsefulHeight());
	}

	private static bool TryGetFocusedTextBox(out TextBox textBox)
	{
		textBox = FocusManager.GetFocusedElement() as TextBox;
		return textBox != null;
	}

	public static bool IsSipShown()
	{
		TextBox textBox;
		return TryGetFocusedTextBox(out textBox);
	}

	public static bool IsSipTextCompletionShown(this TextBox textBox)
	{
		if (textBox.InputScope == null)
		{
			return false;
		}
		IList names = textBox.InputScope.Names;
		foreach (InputScopeName item in names)
		{
			switch (item.NameValue)
			{
			case InputScopeNameValue.Text:
			case InputScopeNameValue.Chat:
				return true;
			}
		}
		return false;
	}

	public static Size GetSipCoveredSize(this PhoneApplicationFrame phoneApplicationFrame)
	{
		if (!IsSipShown())
		{
			return new Size(0.0, 0.0);
		}
		double usefulWidth = phoneApplicationFrame.GetUsefulWidth();
		double num = (phoneApplicationFrame.IsPortrait() ? 339.0 : 259.0);
		if (TryGetFocusedTextBox(out var textBox) && textBox.IsSipTextCompletionShown())
		{
			num += 62.0;
		}
		return new Size(usefulWidth, num);
	}

	public static Size GetSipUncoveredSize(this PhoneApplicationFrame phoneApplicationFrame)
	{
		double usefulWidth = phoneApplicationFrame.GetUsefulWidth();
		double height = phoneApplicationFrame.GetUsefulHeight() - phoneApplicationFrame.GetSipCoveredSize().Height;
		return new Size(usefulWidth, height);
	}
}
