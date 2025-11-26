using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class SNSAccountPage : PhoneApplicationPage
{
	[CompilerGenerated]
	private sealed class _003CLogout_Tap_003Ed__0
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public SNSAccountPage _003C_003E4__this;

		public object sender;

		public object _003C_003E3__sender;

		public System.Windows.Input.GestureEventArgs e;

		public System.Windows.Input.GestureEventArgs _003C_003E3__e;

		public bool _003CbResult_003E5__1;

		private TaskAwaiter<bool> _003Ca1_003Et___0024await3;

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
					_003Ca1_003Et___0024await3 = MobileBlogService.Instance.Logout(_003C_003E4__this._siteName, null).GetAwaiter();
					if (!_003Ca1_003Et___0024await3.IsCompleted)
					{
						_003C_003E1__state = 1;
						flag = false;
						_003Ca1_003Et___0024await3.OnCompleted(_003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					_003C_003E1__state = 0;
				}
				bool result = _003Ca1_003Et___0024await3.GetResult();
				_003Ca1_003Et___0024await3 = default(TaskAwaiter<bool>);
				_003CbResult_003E5__1 = result;
				if (_003CbResult_003E5__1)
				{
					Utility.SafetyGoBack((PhoneApplicationPage)(object)_003C_003E4__this);
				}
				else
				{
					MessageBox.Show(ResContainer.IDS_CHATON_POP_LOGOUT + " " + ResContainer.IDS_CHATON_POP_FAILED, _003C_003E4__this._siteName, MessageBoxButton.OK);
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
		public _003CLogout_Tap_003Ed__0(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	private string _siteName;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListBox SelectList;

	private bool _contentLoaded;

	public SNSAccountPage()
	{
		InitializeComponent();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		SelectList.SelectedIndex = -1;
		IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
		if (((Page)this).NavigationService.BackStack.First().Source.OriginalString.Contains("LoginOauthPage"))
		{
			((Page)this).NavigationService.RemoveBackEntry();
		}
		if (queryString.ContainsKey("SITE"))
		{
			_siteName = queryString["SITE"];
			ApplicationTitle.Text = _siteName.ToUpper();
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void InvitationCard_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenInvitationPage(_siteName, 1, (PhoneApplicationPage)(object)this);
	}

	private void Logout_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_003CLogout_Tap_003Ed__0 CS_0024_003C_003E8__locals25 = new _003CLogout_Tap_003Ed__0(0);
		CS_0024_003C_003E8__locals25._003C_003E4__this = this;
		CS_0024_003C_003E8__locals25.sender = sender;
		CS_0024_003C_003E8__locals25.e = e;
		CS_0024_003C_003E8__locals25._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals25._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals25._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals25._003Ca1_003Et___0024await3 = MobileBlogService.Instance.Logout(CS_0024_003C_003E8__locals25._003C_003E4__this._siteName, null).GetAwaiter();
					if (!CS_0024_003C_003E8__locals25._003Ca1_003Et___0024await3.IsCompleted)
					{
						CS_0024_003C_003E8__locals25._003C_003E1__state = 1;
						flag = false;
						CS_0024_003C_003E8__locals25._003Ca1_003Et___0024await3.OnCompleted(CS_0024_003C_003E8__locals25._003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					CS_0024_003C_003E8__locals25._003C_003E1__state = 0;
				}
				bool result = CS_0024_003C_003E8__locals25._003Ca1_003Et___0024await3.GetResult();
				CS_0024_003C_003E8__locals25._003Ca1_003Et___0024await3 = default(TaskAwaiter<bool>);
				CS_0024_003C_003E8__locals25._003CbResult_003E5__1 = result;
				if (CS_0024_003C_003E8__locals25._003CbResult_003E5__1)
				{
					Utility.SafetyGoBack((PhoneApplicationPage)(object)CS_0024_003C_003E8__locals25._003C_003E4__this);
				}
				else
				{
					MessageBox.Show(ResContainer.IDS_CHATON_POP_LOGOUT + " " + ResContainer.IDS_CHATON_POP_FAILED, CS_0024_003C_003E8__locals25._003C_003E4__this._siteName, MessageBoxButton.OK);
				}
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals25._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals25._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals25._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals25._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals25._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals25.MoveNext();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SNSAccountPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			SelectList = (ListBox)((FrameworkElement)this).FindName("SelectList");
		}
	}
}
