using System;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Windows;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class LoginPageViewModel : NotificationObject
{
	[CompilerGenerated]
	private sealed class _003CLogin_003Ed__0
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public LoginPageViewModel _003C_003E4__this;

		public string id;

		public string _003C_003E3__id;

		public string password;

		public string _003C_003E3__password;

		public bool isKeepLogin;

		public bool _003C_003E3__isKeepLogin;

		public bool _003CfResult_003E5__1;

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
					_003C_003E4__this.StartUploading();
					_003Ca1_003Et___0024await3 = MobileBlogService.Instance.Login(id, password, _003C_003E4__this.Site, isKeepLogin).GetAwaiter();
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
				_003CfResult_003E5__1 = result;
				if (_003CfResult_003E5__1)
				{
					PageNavigationService.OpenShareDetailPage((PhoneApplicationPage)(object)_003C_003E4__this._page);
				}
				else
				{
					MessageBox.Show("login failed", _003C_003E4__this._site, MessageBoxButton.OK);
				}
				_003C_003E4__this.StopUploading();
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
		public _003CLogin_003Ed__0(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	private LoginPage _page;

	private Uri _previousPageUri;

	private string _site;

	public string Site
	{
		get
		{
			return _site;
		}
		set
		{
			_site = value;
			NotifyPropertyChanged(() => Site);
		}
	}

	public LoginPageViewModel(PhoneApplicationPage page)
	{
		_page = page as LoginPage;
		((FrameworkElement)(object)_page).DataContext = this;
	}

	public void OnNavigatedTo(string site)
	{
		Site = site;
	}

	public void Login(string id, string password, bool isKeepLogin)
	{
		_003CLogin_003Ed__0 CS_0024_003C_003E8__locals31 = new _003CLogin_003Ed__0(0);
		CS_0024_003C_003E8__locals31._003C_003E4__this = this;
		CS_0024_003C_003E8__locals31.id = id;
		CS_0024_003C_003E8__locals31.password = password;
		CS_0024_003C_003E8__locals31.isKeepLogin = isKeepLogin;
		CS_0024_003C_003E8__locals31._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals31._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals31._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals31._003C_003E4__this.StartUploading();
					CS_0024_003C_003E8__locals31._003Ca1_003Et___0024await3 = MobileBlogService.Instance.Login(CS_0024_003C_003E8__locals31.id, CS_0024_003C_003E8__locals31.password, CS_0024_003C_003E8__locals31._003C_003E4__this.Site, CS_0024_003C_003E8__locals31.isKeepLogin).GetAwaiter();
					if (!CS_0024_003C_003E8__locals31._003Ca1_003Et___0024await3.IsCompleted)
					{
						CS_0024_003C_003E8__locals31._003C_003E1__state = 1;
						flag = false;
						CS_0024_003C_003E8__locals31._003Ca1_003Et___0024await3.OnCompleted(CS_0024_003C_003E8__locals31._003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					CS_0024_003C_003E8__locals31._003C_003E1__state = 0;
				}
				bool result = CS_0024_003C_003E8__locals31._003Ca1_003Et___0024await3.GetResult();
				CS_0024_003C_003E8__locals31._003Ca1_003Et___0024await3 = default(TaskAwaiter<bool>);
				CS_0024_003C_003E8__locals31._003CfResult_003E5__1 = result;
				if (CS_0024_003C_003E8__locals31._003CfResult_003E5__1)
				{
					PageNavigationService.OpenShareDetailPage((PhoneApplicationPage)(object)CS_0024_003C_003E8__locals31._003C_003E4__this._page);
				}
				else
				{
					MessageBox.Show("login failed", CS_0024_003C_003E8__locals31._003C_003E4__this._site, MessageBoxButton.OK);
				}
				CS_0024_003C_003E8__locals31._003C_003E4__this.StopUploading();
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals31._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals31._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals31._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals31._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals31._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals31.MoveNext();
	}

	private void StartUploading()
	{
		_page.UploadingBgRect.Visibility = Visibility.Visible;
		_page.UploadingProgress.Visibility = Visibility.Visible;
	}

	private void StopUploading()
	{
		_page.UploadingBgRect.Visibility = Visibility.Collapsed;
		_page.UploadingProgress.Visibility = Visibility.Collapsed;
	}
}
