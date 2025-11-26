using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Threading.Tasks;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Controls;

public sealed class ImageDelayControl : UserControl, IComponentConnector
{
	public static readonly DependencyProperty ProfileImageProperty = DependencyProperty.Register("ProfileImageSource", typeof(BitmapImage), typeof(ImageDelayControl), new PropertyMetadata((object)null, new PropertyChangedCallback(ProfileImageSourceChanged)));

	public static readonly DependencyProperty isDownloadingProperty = DependencyProperty.Register("IsDownloading", typeof(bool), typeof(ImageDelayControl), (PropertyMetadata)null);

	public static readonly DependencyProperty StretchProperty = DependencyProperty.Register("StretchMode", typeof(int), typeof(ImageDelayControl), (PropertyMetadata)null);

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ProgressRing progressRing;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ProfileImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public BitmapImage ProfileImageSource
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (BitmapImage)((DependencyObject)this).GetValue(ProfileImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ProfileImageProperty, (object)value);
		}
	}

	public bool IsDownloading
	{
		get
		{
			return (bool)((DependencyObject)this).GetValue(isDownloadingProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(isDownloadingProperty, (object)value);
		}
	}

	public int StretchMode
	{
		get
		{
			return (int)((DependencyObject)this).GetValue(StretchProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(StretchProperty, (object)value);
		}
	}

	private static void ProfileImageSourceChanged(DependencyObject sender, DependencyPropertyChangedEventArgs args)
	{
		((ImageDelayControl)(object)sender).UpdateContent();
	}

	public ImageDelayControl()
	{
		try
		{
			InitializeComponent();
			Task.Run(delegate
			{
				//IL_0013: Unknown result type (might be due to invalid IL or missing references)
				//IL_0019: Expected O, but got Unknown
				DispatchedHandler val = null;
				try
				{
					CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
					if (val == null)
					{
						val = (DispatchedHandler)delegate
						{
							((FrameworkElement)LayoutRoot).put_Width(((FrameworkElement)this).Width);
							((FrameworkElement)LayoutRoot).put_Height(((FrameworkElement)this).Height);
						};
					}
					dispatcher.RunAsync((CoreDispatcherPriority)(-1), val);
				}
				catch
				{
				}
			});
		}
		catch
		{
		}
	}

	private void UpdateContent()
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_0019: Expected O, but got Unknown
		DispatchedHandler val = null;
		try
		{
			CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					//IL_0084: Unknown result type (might be due to invalid IL or missing references)
					//IL_008e: Expected O, but got Unknown
					//IL_00a5: Unknown result type (might be due to invalid IL or missing references)
					//IL_00ab: Expected O, but got Unknown
					//IL_00b8: Unknown result type (might be due to invalid IL or missing references)
					//IL_00c2: Expected O, but got Unknown
					try
					{
						if (!IsDownloading)
						{
							((FrameworkElement)ProfileImage).put_Width(((FrameworkElement)this).Width);
							((FrameworkElement)ProfileImage).put_Height(((FrameworkElement)this).Height);
							if (StretchMode == 1)
							{
								ProfileImage.put_Stretch((Stretch)1);
							}
							else if (StretchMode == 2)
							{
								ProfileImage.put_Stretch((Stretch)2);
							}
							else if (StretchMode == 3)
							{
								ProfileImage.put_Stretch((Stretch)3);
							}
							else
							{
								_ = StretchMode;
							}
							((Panel)LayoutRoot).put_Background((Brush)new SolidColorBrush(Colors.Transparent));
							progressRing.put_IsActive(false);
							Image profileImage = ProfileImage;
							DependencyProperty sourceProperty = Image.SourceProperty;
							Binding val2 = new Binding();
							val2.put_Source((object)this);
							val2.put_Path(new PropertyPath("ProfileImageSource"));
							((FrameworkElement)profileImage).SetBinding(sourceProperty, (BindingBase)(object)val2);
						}
					}
					catch
					{
					}
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)1, val);
		}
		catch
		{
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///Controls/ImageDelayControl.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			progressRing = (ProgressRing)((FrameworkElement)this).FindName("progressRing");
			ProfileImage = (Image)((FrameworkElement)this).FindName("ProfileImage");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
