using System;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Infrastructure;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class LoginOauthPage : PhoneApplicationPage
{
	[CompilerGenerated]
	private sealed class _003COnNavigatedTo_003Ed__0
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public LoginOauthPage _003C_003E4__this;

		public NavigationEventArgs e;

		public NavigationEventArgs _003C_003E3__e;

		public string _003C_redirectUrl_003E5__1;

		private TaskAwaiter<string> _003Ca1_003Et___0024await3;

		public void MoveNext()
		{
			try
			{
				bool flag = true;
				int num = _003C_003E1__state;
				if (num != 1)
				{
					if (_003C_003E1__state == -1)
					{
						return;
					}
					if (((Page)_003C_003E4__this).NavigationContext.QueryString.ContainsKey("SITE"))
					{
						_003C_003E4__this.siteID = ((Page)_003C_003E4__this).NavigationContext.QueryString["SITE"];
					}
					if (((Page)_003C_003E4__this).NavigationContext.QueryString.ContainsKey("MODE"))
					{
						_003C_003E4__this._mode = (PageOpenModes.LoginMode)int.Parse(((Page)_003C_003E4__this).NavigationContext.QueryString["MODE"]);
					}
					MobileBlogService.Instance.SetCurrentSite(_003C_003E4__this.siteID);
					if (_003C_003E4__this._mode == PageOpenModes.LoginMode.SHARE)
					{
						((Page)_003C_003E4__this).NavigationService.RemoveBackEntry();
					}
				}
				try
				{
					int num2 = _003C_003E1__state;
					if (num2 == 1)
					{
						_003C_003E1__state = 0;
						goto IL_017c;
					}
					_003C_003E4__this.ApplicationTitle.Text = MobileBlogService.Instance.CurrentSite.Name.ToUpper() + " SETTING";
					if (MobileBlogService.Instance.CurrentSite != null)
					{
						_003Ca1_003Et___0024await3 = MobileBlogService.Instance.LoginOauth(MobileBlogService.Instance.CurrentSite.ID).GetAwaiter();
						if (!_003Ca1_003Et___0024await3.IsCompleted)
						{
							_003C_003E1__state = 1;
							flag = false;
							_003Ca1_003Et___0024await3.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
						goto IL_017c;
					}
					goto end_IL_00d8;
					IL_017c:
					string result = _003Ca1_003Et___0024await3.GetResult();
					_003Ca1_003Et___0024await3 = default(TaskAwaiter<string>);
					_003C_redirectUrl_003E5__1 = result;
					if (!string.IsNullOrEmpty(_003C_redirectUrl_003E5__1))
					{
						_003C_003E4__this.OauthBrowser.Navigate(new Uri(_003C_redirectUrl_003E5__1, UriKind.Absolute));
					}
					end_IL_00d8:;
				}
				catch (Exception)
				{
				}
				_003C_003E4__this._003C_003En__FabricatedMethod4(e);
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = _0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = _0024builder;
			asyncVoidMethodBuilder2.SetResult();
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003COnNavigatedTo_003Ed__0(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	[CompilerGenerated]
	private sealed class _003COauthBrowser_Navigated_003Ed__6
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public LoginOauthPage _003C_003E4__this;

		public object sender;

		public object _003C_003E3__sender;

		public NavigationEventArgs e;

		public NavigationEventArgs _003C_003E3__e;

		public void MoveNext()
		{
			try
			{
				bool flag = true;
				if (_003C_003E1__state == -1)
				{
					return;
				}
				if (_003C_003E4__this.isLogInSuccess)
				{
					try
					{
						MobileBlogService.Instance.SetUserIDtoSite(MobileBlogService.Instance.CurrentSite.ID, ResContainer.WP7_CHATON_LOGGEDIN);
					}
					catch (Exception)
					{
						MessageBox.Show(ResContainer.IDS_CHATON_POP_CONNECTION_FAILED_ABB);
						Utility.SafetyGoBack((PhoneApplicationPage)(object)_003C_003E4__this);
					}
					switch (_003C_003E4__this._mode)
					{
					case PageOpenModes.LoginMode.SHARE:
						PageNavigationService.OpenShareDetailPage((PhoneApplicationPage)(object)_003C_003E4__this);
						break;
					case PageOpenModes.LoginMode.INVITATION:
						PageNavigationService.OpenSNSAccountPage(MobileBlogService.Instance.CurrentSite.ID, (PhoneApplicationPage)(object)_003C_003E4__this);
						break;
					case PageOpenModes.LoginMode.TELLFRIENDS:
						PageNavigationService.OpenInvitationPage(MobileBlogService.Instance.CurrentSite.ID, 2, (PhoneApplicationPage)(object)_003C_003E4__this);
						break;
					default:
						Utility.SafetyGoBack((PhoneApplicationPage)(object)_003C_003E4__this);
						break;
					}
				}
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = _0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = _0024builder;
			asyncVoidMethodBuilder2.SetResult();
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003COauthBrowser_Navigated_003Ed__6(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	private string siteID = string.Empty;

	private PageOpenModes.LoginMode _mode;

	private bool isLogInSuccess;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal WebBrowser OauthBrowser;

	private bool _contentLoaded;

	public LoginOauthPage()
	{
		InitializeComponent();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		_003COnNavigatedTo_003Ed__0 CS_0024_003C_003E8__locals36 = new _003COnNavigatedTo_003Ed__0(0);
		CS_0024_003C_003E8__locals36._003C_003E4__this = this;
		CS_0024_003C_003E8__locals36.e = e;
		CS_0024_003C_003E8__locals36._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals36._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals36._003C_003E1__state == -1)
					{
						return;
					}
					if (((Page)CS_0024_003C_003E8__locals36._003C_003E4__this).NavigationContext.QueryString.ContainsKey("SITE"))
					{
						CS_0024_003C_003E8__locals36._003C_003E4__this.siteID = ((Page)CS_0024_003C_003E8__locals36._003C_003E4__this).NavigationContext.QueryString["SITE"];
					}
					if (((Page)CS_0024_003C_003E8__locals36._003C_003E4__this).NavigationContext.QueryString.ContainsKey("MODE"))
					{
						CS_0024_003C_003E8__locals36._003C_003E4__this._mode = (PageOpenModes.LoginMode)int.Parse(((Page)CS_0024_003C_003E8__locals36._003C_003E4__this).NavigationContext.QueryString["MODE"]);
					}
					MobileBlogService.Instance.SetCurrentSite(CS_0024_003C_003E8__locals36._003C_003E4__this.siteID);
					if (CS_0024_003C_003E8__locals36._003C_003E4__this._mode == PageOpenModes.LoginMode.SHARE)
					{
						((Page)CS_0024_003C_003E8__locals36._003C_003E4__this).NavigationService.RemoveBackEntry();
					}
				}
				try
				{
					int num2 = CS_0024_003C_003E8__locals36._003C_003E1__state;
					if (num2 == 1)
					{
						CS_0024_003C_003E8__locals36._003C_003E1__state = 0;
						goto IL_017c;
					}
					CS_0024_003C_003E8__locals36._003C_003E4__this.ApplicationTitle.Text = MobileBlogService.Instance.CurrentSite.Name.ToUpper() + " SETTING";
					if (MobileBlogService.Instance.CurrentSite != null)
					{
						CS_0024_003C_003E8__locals36._003Ca1_003Et___0024await3 = MobileBlogService.Instance.LoginOauth(MobileBlogService.Instance.CurrentSite.ID).GetAwaiter();
						if (!CS_0024_003C_003E8__locals36._003Ca1_003Et___0024await3.IsCompleted)
						{
							CS_0024_003C_003E8__locals36._003C_003E1__state = 1;
							flag = false;
							CS_0024_003C_003E8__locals36._003Ca1_003Et___0024await3.OnCompleted(CS_0024_003C_003E8__locals36._003C_003Et__MoveNextDelegate);
							return;
						}
						goto IL_017c;
					}
					goto end_IL_00d8;
					IL_017c:
					string result = CS_0024_003C_003E8__locals36._003Ca1_003Et___0024await3.GetResult();
					CS_0024_003C_003E8__locals36._003Ca1_003Et___0024await3 = default(TaskAwaiter<string>);
					CS_0024_003C_003E8__locals36._003C_redirectUrl_003E5__1 = result;
					if (!string.IsNullOrEmpty(CS_0024_003C_003E8__locals36._003C_redirectUrl_003E5__1))
					{
						CS_0024_003C_003E8__locals36._003C_003E4__this.OauthBrowser.Navigate(new Uri(CS_0024_003C_003E8__locals36._003C_redirectUrl_003E5__1, UriKind.Absolute));
					}
					end_IL_00d8:;
				}
				catch (Exception)
				{
				}
				CS_0024_003C_003E8__locals36._003C_003E4__this._003C_003En__FabricatedMethod4(CS_0024_003C_003E8__locals36.e);
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals36._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals36._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals36._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals36._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals36._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals36.MoveNext();
	}

	private void OauthBrowser_ScriptNotify(object sender, NotifyEventArgs e)
	{
	}

	private void OauthBrowser_Navigated(object sender, NavigationEventArgs e)
	{
		_003COauthBrowser_Navigated_003Ed__6 CS_0024_003C_003E8__locals18 = new _003COauthBrowser_Navigated_003Ed__6(0);
		CS_0024_003C_003E8__locals18._003C_003E4__this = this;
		CS_0024_003C_003E8__locals18.sender = sender;
		CS_0024_003C_003E8__locals18.e = e;
		CS_0024_003C_003E8__locals18._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				if (CS_0024_003C_003E8__locals18._003C_003E1__state == -1)
				{
					return;
				}
				if (CS_0024_003C_003E8__locals18._003C_003E4__this.isLogInSuccess)
				{
					try
					{
						MobileBlogService.Instance.SetUserIDtoSite(MobileBlogService.Instance.CurrentSite.ID, ResContainer.WP7_CHATON_LOGGEDIN);
					}
					catch (Exception)
					{
						MessageBox.Show(ResContainer.IDS_CHATON_POP_CONNECTION_FAILED_ABB);
						Utility.SafetyGoBack((PhoneApplicationPage)(object)CS_0024_003C_003E8__locals18._003C_003E4__this);
					}
					switch (CS_0024_003C_003E8__locals18._003C_003E4__this._mode)
					{
					case PageOpenModes.LoginMode.SHARE:
						PageNavigationService.OpenShareDetailPage((PhoneApplicationPage)(object)CS_0024_003C_003E8__locals18._003C_003E4__this);
						break;
					case PageOpenModes.LoginMode.INVITATION:
						PageNavigationService.OpenSNSAccountPage(MobileBlogService.Instance.CurrentSite.ID, (PhoneApplicationPage)(object)CS_0024_003C_003E8__locals18._003C_003E4__this);
						break;
					case PageOpenModes.LoginMode.TELLFRIENDS:
						PageNavigationService.OpenInvitationPage(MobileBlogService.Instance.CurrentSite.ID, 2, (PhoneApplicationPage)(object)CS_0024_003C_003E8__locals18._003C_003E4__this);
						break;
					default:
						Utility.SafetyGoBack((PhoneApplicationPage)(object)CS_0024_003C_003E8__locals18._003C_003E4__this);
						break;
					}
				}
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals18._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals18._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals18._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals18._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals18._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals18.MoveNext();
	}

	private void OauthBrowser_Navigating(object sender, NavigatingEventArgs e)
	{
		if (e.Uri.AbsoluteUri.Contains("loginSuccess"))
		{
			isLogInSuccess = true;
			((UIElement)(object)OauthBrowser).Visibility = Visibility.Collapsed;
		}
	}

	private void OauthBrowser_NavigationFailed(object sender, NavigationFailedEventArgs e)
	{
		WebBrowser val = (WebBrowser)((sender is WebBrowser) ? sender : null);
		val.Navigate(new Uri("about:blank", UriKind.Absolute));
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/LoginOauthPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			OauthBrowser = (WebBrowser)((FrameworkElement)this).FindName("OauthBrowser");
		}
	}

	[CompilerGenerated]
	private void _003C_003En__FabricatedMethod4(NavigationEventArgs P_0)
	{
		((Page)this).OnNavigatedTo(P_0);
	}
}
