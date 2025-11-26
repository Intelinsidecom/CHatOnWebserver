using System;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class TellFriendsPage : PhoneApplicationPage
{
	[CompilerGenerated]
	private sealed class _003COnNavigatedTo_003Ed__0
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public TellFriendsPage _003C_003E4__this;

		public NavigationEventArgs e;

		public NavigationEventArgs _003C_003E3__e;

		private TaskAwaiter<bool> _003Ca1_003Et___0024await2;

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
					if (e == null)
					{
						throw new ArgumentNullException("e");
					}
					_003Ca1_003Et___0024await2 = MobileBlogService.Instance.CheckLogin("facebook").GetAwaiter();
					if (!_003Ca1_003Et___0024await2.IsCompleted)
					{
						_003C_003E1__state = 1;
						flag = false;
						_003Ca1_003Et___0024await2.OnCompleted(_003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					_003C_003E1__state = 0;
				}
				bool result = _003Ca1_003Et___0024await2.GetResult();
				_003Ca1_003Et___0024await2 = default(TaskAwaiter<bool>);
				_003C_003E4__this._hasLoggedIn = result;
				_003C_003E4__this._003C_003En__FabricatedMethod3(e);
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
	private sealed class _003CViaFacebook_Tap_003Ed__5
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public TellFriendsPage _003C_003E4__this;

		public object sender;

		public object _003C_003E3__sender;

		public System.Windows.Input.GestureEventArgs e;

		public System.Windows.Input.GestureEventArgs _003C_003E3__e;

		public bool _003CfResult_003E5__6;

		private TaskAwaiter<bool> _003Ca1_003Et___0024await8;

		public void MoveNext()
		{
			try
			{
				bool flag = true;
				int num = _003C_003E1__state;
				if (num == 1)
				{
					_003C_003E1__state = 0;
					goto IL_0086;
				}
				if (_003C_003E1__state == -1)
				{
					return;
				}
				if (!_003C_003E4__this._hasLoggedIn)
				{
					_003Ca1_003Et___0024await8 = MobileBlogService.Instance.Logout("facebook", null).GetAwaiter();
					if (!_003Ca1_003Et___0024await8.IsCompleted)
					{
						_003C_003E1__state = 1;
						flag = false;
						_003Ca1_003Et___0024await8.OnCompleted(_003C_003Et__MoveNextDelegate);
						return;
					}
					goto IL_0086;
				}
				PageNavigationService.OpenInvitationPage("facebook", 2, (PhoneApplicationPage)(object)_003C_003E4__this);
				goto end_IL_0000;
				IL_0086:
				bool result = _003Ca1_003Et___0024await8.GetResult();
				_003Ca1_003Et___0024await8 = default(TaskAwaiter<bool>);
				_003CfResult_003E5__6 = result;
				PageNavigationService.OpenLoginOauthPage("facebook", 2, (PhoneApplicationPage)(object)_003C_003E4__this);
				end_IL_0000:;
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
		public _003CViaFacebook_Tap_003Ed__5(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	private const string _FACEBOOK_SITE = "facebook";

	private bool _hasLoggedIn;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	private bool _contentLoaded;

	public TellFriendsPage()
	{
		InitializeComponent();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		_003COnNavigatedTo_003Ed__0 CS_0024_003C_003E8__locals23 = new _003COnNavigatedTo_003Ed__0(0);
		CS_0024_003C_003E8__locals23._003C_003E4__this = this;
		CS_0024_003C_003E8__locals23.e = e;
		CS_0024_003C_003E8__locals23._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals23._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals23._003C_003E1__state == -1)
					{
						return;
					}
					if (CS_0024_003C_003E8__locals23.e == null)
					{
						throw new ArgumentNullException("e");
					}
					CS_0024_003C_003E8__locals23._003Ca1_003Et___0024await2 = MobileBlogService.Instance.CheckLogin("facebook").GetAwaiter();
					if (!CS_0024_003C_003E8__locals23._003Ca1_003Et___0024await2.IsCompleted)
					{
						CS_0024_003C_003E8__locals23._003C_003E1__state = 1;
						flag = false;
						CS_0024_003C_003E8__locals23._003Ca1_003Et___0024await2.OnCompleted(CS_0024_003C_003E8__locals23._003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					CS_0024_003C_003E8__locals23._003C_003E1__state = 0;
				}
				bool result = CS_0024_003C_003E8__locals23._003Ca1_003Et___0024await2.GetResult();
				CS_0024_003C_003E8__locals23._003Ca1_003Et___0024await2 = default(TaskAwaiter<bool>);
				CS_0024_003C_003E8__locals23._003C_003E4__this._hasLoggedIn = result;
				CS_0024_003C_003E8__locals23._003C_003E4__this._003C_003En__FabricatedMethod3(CS_0024_003C_003E8__locals23.e);
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals23._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals23._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals23._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals23._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals23._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals23.MoveNext();
	}

	private void ViaFacebook_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_003CViaFacebook_Tap_003Ed__5 CS_0024_003C_003E8__locals24 = new _003CViaFacebook_Tap_003Ed__5(0);
		CS_0024_003C_003E8__locals24._003C_003E4__this = this;
		CS_0024_003C_003E8__locals24.sender = sender;
		CS_0024_003C_003E8__locals24.e = e;
		CS_0024_003C_003E8__locals24._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals24._003C_003E1__state;
				if (num == 1)
				{
					CS_0024_003C_003E8__locals24._003C_003E1__state = 0;
					goto IL_0086;
				}
				if (CS_0024_003C_003E8__locals24._003C_003E1__state == -1)
				{
					return;
				}
				if (!CS_0024_003C_003E8__locals24._003C_003E4__this._hasLoggedIn)
				{
					CS_0024_003C_003E8__locals24._003Ca1_003Et___0024await8 = MobileBlogService.Instance.Logout("facebook", null).GetAwaiter();
					if (!CS_0024_003C_003E8__locals24._003Ca1_003Et___0024await8.IsCompleted)
					{
						CS_0024_003C_003E8__locals24._003C_003E1__state = 1;
						flag = false;
						CS_0024_003C_003E8__locals24._003Ca1_003Et___0024await8.OnCompleted(CS_0024_003C_003E8__locals24._003C_003Et__MoveNextDelegate);
						return;
					}
					goto IL_0086;
				}
				PageNavigationService.OpenInvitationPage("facebook", 2, (PhoneApplicationPage)(object)CS_0024_003C_003E8__locals24._003C_003E4__this);
				goto end_IL_0000;
				IL_0086:
				bool result = CS_0024_003C_003E8__locals24._003Ca1_003Et___0024await8.GetResult();
				CS_0024_003C_003E8__locals24._003Ca1_003Et___0024await8 = default(TaskAwaiter<bool>);
				CS_0024_003C_003E8__locals24._003CfResult_003E5__6 = result;
				PageNavigationService.OpenLoginOauthPage("facebook", 2, (PhoneApplicationPage)(object)CS_0024_003C_003E8__locals24._003C_003E4__this);
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals24._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals24._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals24._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals24._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals24._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals24.MoveNext();
	}

	private void ViaEMail_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		BuddyService.TellFriends(viaSms: false);
	}

	private void ViaSMS_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		BuddyService.TellFriends();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/TellFriendsPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
		}
	}

	[CompilerGenerated]
	private void _003C_003En__FabricatedMethod3(NavigationEventArgs P_0)
	{
		((Page)this).OnNavigatedTo(P_0);
	}
}
