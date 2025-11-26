using System.Collections.Generic;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;

namespace ChatON_WoA.InfraStructure;

internal class IndeterminateProgressbar
{
	private ProgressBar _progressControl;

	private Panel _root;

	public void Show(Panel root)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		//IL_0046: Unknown result type (might be due to invalid IL or missing references)
		//IL_0050: Expected O, but got Unknown
		ProgressBar val = new ProgressBar();
		val.put_IsIndeterminate(true);
		((FrameworkElement)val).put_HorizontalAlignment((HorizontalAlignment)3);
		((FrameworkElement)val).put_VerticalAlignment((VerticalAlignment)0);
		((FrameworkElement)val).put_Margin(new Thickness(3.0));
		((Control)val).put_Foreground((Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25)));
		Grid.SetRowSpan((FrameworkElement)(object)val, 99);
		Grid.SetColumnSpan((FrameworkElement)(object)val, 99);
		_root = root;
		((ICollection<UIElement>)root.Children).Add((UIElement)(object)val);
		_progressControl = val;
	}

	public void Hide()
	{
		if (_progressControl != null)
		{
			DependencyObject parent = ((FrameworkElement)_progressControl).Parent;
			Panel val = (Panel)(object)((parent is Panel) ? parent : null);
			if (val != null)
			{
				((ICollection<UIElement>)val.Children).Remove((UIElement)(object)_progressControl);
			}
			else if (_root != null)
			{
				val = _root;
				((ICollection<UIElement>)val.Children).Remove((UIElement)(object)_progressControl);
			}
		}
	}
}
