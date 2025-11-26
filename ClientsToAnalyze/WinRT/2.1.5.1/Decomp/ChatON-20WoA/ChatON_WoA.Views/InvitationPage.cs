using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Services;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using Windows.ApplicationModel.DataTransfer;
using Windows.Foundation;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class InvitationPage : Page, IComponentConnector
{
	private DataTransferManager _dataTransferManager;

	private StorageFile _imageFileToShare;

	private bool _isFacebookAvailable;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton PostButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CancelButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView CardGridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox txtMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public InvitationPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)this);
		CancelButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_CANCEL_ABB");
		txtMessage.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_WRITE_A_MESSAGE"));
	}

	protected unsafe override void OnNavigatedTo(NavigationEventArgs e)
	{
		_isFacebookAvailable = (bool)e.Parameter;
		if (_isFacebookAvailable)
		{
			PostButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_POST_ABB");
			return;
		}
		PostButton.Text = Utility.GetResourceString("IDS_CHATON_BODY_SHARE");
		_dataTransferManager = DataTransferManager.GetForCurrentView();
		DataTransferManager dataTransferManager = _dataTransferManager;
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<DataTransferManager, DataRequestedEventArgs>, EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.add_DataRequested)), new Action<EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.remove_DataRequested)), OnDataRequested);
	}

	protected unsafe override void OnNavigatedFrom(NavigationEventArgs e)
	{
		((Page)this).OnNavigatedFrom(e);
		if (!_isFacebookAvailable)
		{
			WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<DataTransferManager, DataRequestedEventArgs>>(new Action<EventRegistrationToken>(_dataTransferManager, (nint)__ldftn(DataTransferManager.remove_DataRequested)), OnDataRequested);
		}
	}

	private void OnDataRequested(DataTransferManager sender, DataRequestedEventArgs e)
	{
		if (((Selector)CardGridView).SelectedIndex == -1)
		{
			return;
		}
		if (_imageFileToShare != null)
		{
			if (!string.IsNullOrEmpty(_imageFileToShare.Name))
			{
				DataPackage data = e.Request.Data;
				data.Properties.put_Title(_imageFileToShare.Name);
				List<IStorageItem> list = new List<IStorageItem>();
				list.Add((IStorageItem)(object)_imageFileToShare);
				data.SetStorageItems((IEnumerable<IStorageItem>)list);
				RandomAccessStreamReference val = RandomAccessStreamReference.CreateFromFile((IStorageFile)(object)_imageFileToShare);
				data.Properties.put_Thumbnail((IRandomAccessStreamReference)(object)val);
				data.SetBitmap(val);
			}
			else
			{
				e.Request.FailWithDisplayText("The file name is needed to share it");
			}
		}
		else
		{
			e.Request.FailWithDisplayText("Select an image you would like to share and try again.");
		}
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async void Post_Click(object sender, RoutedEventArgs e)
	{
		if (((Selector)CardGridView).SelectedIndex == -1)
		{
			return;
		}
		if (_isFacebookAvailable)
		{
			if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_SHARE_CHATON_INVITATION_MESSAGE_Q"), showCancel: true, "Facebook"))
			{
				if (LoadingIndicator.ActiveIndicator != null)
				{
					LoadingIndicator.StopLoading();
				}
				LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot, Utility.GetResourceString("IDS_CHATON_POP_POSTING_ING_FACEBOOK"));
				IRandomAccessStream iStream = await _imageFileToShare.OpenAsync((FileAccessMode)0);
				DataReader reader = new DataReader(iStream.GetInputStreamAt(0uL));
				await (IAsyncOperation<uint>)(object)reader.LoadAsync((uint)iStream.Size);
				byte[] pixels = new byte[iStream.Size];
				reader.ReadBytes(pixels);
				bool result = (string.IsNullOrEmpty(txtMessage.Text) ? (await FacebookService.PostPhoto("", pixels)) : (await FacebookService.PostPhoto(txtMessage.Text, pixels)));
				LoadingIndicator.StopLoading();
				if (result)
				{
					await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_CHATON_UPLOADINGCOMPLETED"), showCancel: false);
				}
				else
				{
					await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_POST_TO_FACEBOOK_TRY_AGAIN"), showCancel: false);
				}
			}
		}
		else
		{
			DataTransferManager.ShowShareUI();
		}
	}

	private void Cancel_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async Task<StorageFile> GetSharedFile()
	{
		string path = $"/Images/InvitationCard/Card_global_{((Selector)CardGridView).SelectedIndex + 1}.png";
		Uri uri = new Uri("ms-appx://" + path);
		return await StorageFile.GetFileFromApplicationUriAsync(uri);
	}

	private async void CardGridView_SelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		if (((Selector)CardGridView).SelectedIndex != -1)
		{
			_imageFileToShare = await GetSharedFile();
		}
	}

	private void Message_GotFocus(object sender, RoutedEventArgs e)
	{
		txtMessage.put_Text("");
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
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///InvitationPage.xaml"), (ComponentResourceLocation)0);
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			PostButton = (ImageButton)((FrameworkElement)this).FindName("PostButton");
			CancelButton = (ImageButton)((FrameworkElement)this).FindName("CancelButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			CardGridView = (GridView)((FrameworkElement)this).FindName("CardGridView");
			txtMessage = (TextBox)((FrameworkElement)this).FindName("txtMessage");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Expected O, but got Unknown
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Expected O, but got Unknown
		//IL_005c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Expected O, but got Unknown
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_008b: Expected O, but got Unknown
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected O, but got Unknown
		//IL_00b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bd: Expected O, but got Unknown
		//IL_00c0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c6: Expected O, but got Unknown
		//IL_00e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ef: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
			((ImageButton)target).Click += new RoutedEventHandler(Post_Click);
			break;
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(Cancel_Click);
			break;
		case 3:
		{
			Selector val3 = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(CardGridView_SelectionChanged));
			break;
		}
		case 4:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(Message_GotFocus));
			break;
		}
		case 5:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
