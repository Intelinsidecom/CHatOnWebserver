using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;

namespace ChatOn.Controls;

public class ImageButtonBase : Button
{
	public static readonly DependencyProperty NormalImageProperty = DependencyProperty.RegisterAttached("NormalImage", typeof(ImageSource), typeof(ImageButtonBase), (PropertyMetadata)null);

	public static readonly DependencyProperty PressedImageProperty = DependencyProperty.RegisterAttached("PressedImage", typeof(ImageSource), typeof(ImageButtonBase), (PropertyMetadata)null);

	public static readonly DependencyProperty DisabledImageProperty = DependencyProperty.RegisterAttached("DisabledImage", typeof(ImageSource), typeof(ImageButtonBase), (PropertyMetadata)null);

	public static readonly DependencyProperty TextProperty = DependencyProperty.RegisterAttached("Text", typeof(string), typeof(ImageButtonBase), (PropertyMetadata)null);

	public ImageSource NormalImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(NormalImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(NormalImageProperty, (object)value);
		}
	}

	public ImageSource PressedImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(PressedImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(PressedImageProperty, (object)value);
		}
	}

	public ImageSource DisabledImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(DisabledImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(DisabledImageProperty, (object)value);
		}
	}

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
}
