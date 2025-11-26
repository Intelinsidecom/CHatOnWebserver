using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.ChatON_WoA_XamlTypeInfo;
using ChatON_WoA.DataModel;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.ApplicationModel;
using Windows.ApplicationModel.Activation;
using Windows.System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Markup;

namespace ChatON_WoA;

public sealed class App : Application, IComponentConnector, IXamlMetadataProvider
{
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	private XamlTypeInfoProvider _provider;

	public unsafe App()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		InitializeComponent();
		WindowsRuntimeMarshal.AddEventHandler(new Func<SuspendingEventHandler, EventRegistrationToken>(this, (nint)__ldftn(Application.add_Suspending)), new Action<EventRegistrationToken>(this, (nint)__ldftn(Application.remove_Suspending)), new SuspendingEventHandler(OnSuspending));
	}

	protected override async void OnLaunched(LaunchActivatedEventArgs args)
	{
		ChatOnService.Instance.LaunchArg = args.Arguments;
		if ((int)args.PreviousExecutionState == 1 || (int)args.PreviousExecutionState == 2)
		{
			Window.Current.Activate();
			if ((PivotPage.ActiveInstance != null && (object)((Page)PivotPage.ActiveInstance).Frame.CurrentSourcePageType == typeof(InputPasswordPage)) || string.IsNullOrEmpty(args.Arguments) || PivotPage.ActiveInstance == null)
			{
				return;
			}
			if (args.Arguments.ToLower().Contains("type=e"))
			{
				((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(PivotPage));
				PivotPage.ActiveInstance.buddies_Tapped_1(null, null);
				return;
			}
			if (args.Arguments.Contains("\"TYPE\":\"F"))
			{
				SSMService sSMService = new SSMService();
				string mid = "";
				try
				{
					((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(PivotPage));
					PivotPage.ActiveInstance.buddies_Tapped_1(null, null);
					string[] array = args.Arguments.Split(';');
					if (array.Count() != 4)
					{
						sSMService.PushMarketingFeedbackAsync(mid, FeedbackEvent.FeedbackID.WRONGMETADATA, "");
						return;
					}
					_ = array[0];
					mid = array[1];
					string text = array[2];
					string uriString = array[3];
					if (!text.Equals("0"))
					{
						if (!text.Equals("1"))
						{
							sSMService.PushMarketingFeedbackAsync(mid, FeedbackEvent.FeedbackID.UNSUPPORTED_ACTION_TYPE, "");
							return;
						}
						Launcher.LaunchUriAsync(new Uri(uriString));
					}
					sSMService.PushMarketingFeedbackAsync(mid, FeedbackEvent.FeedbackID.CLICKED, "");
					return;
				}
				catch (Exception)
				{
					sSMService.PushMarketingFeedbackAsync(mid, FeedbackEvent.FeedbackID.CLIENT_INTERNAL_ERROR, "");
					return;
				}
			}
			if (args.Arguments.Contains("msgType") && args.Arguments.Contains("chatType"))
			{
				PivotPage.ActiveInstance.ViewModel.OpenChatUsingArg();
				return;
			}
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(PivotPage));
			PivotPage.ActiveInstance.buddies_Tapped_1(null, null);
		}
		else
		{
			_ = args.PreviousExecutionState;
			_ = 3;
			await StartChatON();
		}
	}

	private async Task StartChatON()
	{
		await Utility.FindDeviceInfo();
		Utility.GetDeviceUniqueID();
		await ChatOnService.Instance.LoadData();
		SSMService.SetForceUpdateInteraction();
		if (Window.Current.Content == null)
		{
			Frame val = new Frame();
			val.Navigate(typeof(MainPage));
			Window.Current.put_Content((UIElement)(object)val);
		}
		(((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine).Start();
		Window.Current.Activate();
	}

	private void Instance_DatabaseLoaded(object sender, EventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		Frame val = new Frame();
		if (!val.Navigate(typeof(MainPage)))
		{
			throw new Exception("Failed to create initial page");
		}
		Window.Current.put_Content((UIElement)(object)val);
		Window.Current.Activate();
	}

	private void OnSuspending(object sender, SuspendingEventArgs e)
	{
		SuspendingDeferral deferral = e.SuspendingOperation.GetDeferral();
		deferral.Complete();
	}

	protected override async void OnSearchActivated(SearchActivatedEventArgs args)
	{
		await StartChatON();
		if (!string.IsNullOrEmpty(args.QueryText))
		{
			ChatOnService.Instance.SearchArg = args.QueryText;
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}

	public IXamlType GetXamlType(Type type)
	{
		if (_provider == null)
		{
			_provider = new XamlTypeInfoProvider();
		}
		return _provider.GetXamlTypeByType(type);
	}

	public IXamlType GetXamlType(string fullName)
	{
		if (_provider == null)
		{
			_provider = new XamlTypeInfoProvider();
		}
		return _provider.GetXamlTypeByName(fullName);
	}

	public XmlnsDefinition[] GetXmlnsDefinitions()
	{
		return (XmlnsDefinition[])(object)new XmlnsDefinition[0];
	}
}
