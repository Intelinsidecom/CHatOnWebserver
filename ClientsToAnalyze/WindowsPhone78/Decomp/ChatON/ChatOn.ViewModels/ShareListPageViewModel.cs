using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using ChatOn.Models;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class ShareListPageViewModel
{
	[CompilerGenerated]
	private sealed class _003CLogin_003Ed__0
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public ShareListPageViewModel _003C_003E4__this;

		public string siteID;

		public string _003C_003E3__siteID;

		public bool _003CfLoggedIn_003E5__1;

		public bool _003CfLoggedOut_003E5__2;

		private TaskAwaiter<bool> _003Ca1_003Et___0024await4;

		private TaskAwaiter<bool> _003Ca2_003Et___0024await6;

		public void MoveNext()
		{
			try
			{
				bool flag = true;
				bool result;
				switch (_003C_003E1__state)
				{
				default:
					if (_003C_003E1__state == -1)
					{
						return;
					}
					_003Ca1_003Et___0024await4 = MobileBlogService.Instance.CheckLogin(siteID).GetAwaiter();
					if (!_003Ca1_003Et___0024await4.IsCompleted)
					{
						_003C_003E1__state = 1;
						flag = false;
						_003Ca1_003Et___0024await4.OnCompleted(_003C_003Et__MoveNextDelegate);
						return;
					}
					goto IL_0077;
				case 1:
					_003C_003E1__state = 0;
					goto IL_0077;
				case 2:
					{
						_003C_003E1__state = 0;
						break;
					}
					IL_0077:
					result = _003Ca1_003Et___0024await4.GetResult();
					_003Ca1_003Et___0024await4 = default(TaskAwaiter<bool>);
					_003CfLoggedIn_003E5__1 = result;
					if (!_003CfLoggedIn_003E5__1)
					{
						_003Ca2_003Et___0024await6 = MobileBlogService.Instance.Logout(siteID, null).GetAwaiter();
						if (!_003Ca2_003Et___0024await6.IsCompleted)
						{
							_003C_003E1__state = 2;
							flag = false;
							_003Ca2_003Et___0024await6.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
						break;
					}
					PageNavigationService.OpenShareDetailPage(_003C_003E4__this._page);
					goto end_IL_0000;
				}
				bool result2 = _003Ca2_003Et___0024await6.GetResult();
				_003Ca2_003Et___0024await6 = default(TaskAwaiter<bool>);
				_003CfLoggedOut_003E5__2 = result2;
				PageNavigationService.OpenLoginOauthPage(siteID, 0, _003C_003E4__this._page);
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
		public _003CLogin_003Ed__0(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	private const string _FACEBOOK_SITE = "facebook";

	private PhoneApplicationPage _page;

	private List<ShareItem> _shareList;

	public List<ShareItem> ShareList => _shareList;

	public ShareListPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
		LoadShareList();
	}

	private void LoadShareList()
	{
		_shareList = new List<ShareItem>();
		ShareItem shareItem = new ShareItem();
		shareItem.Name = "Facebook";
		shareItem.LogoPath = "/Images/icon_list_facebook.png";
		shareItem.SiteID = "facebook";
		shareItem.OnExecute += LaunchFacebook;
		shareItem.LogoutUrl = "http://m.facebook.com/#!/home.php";
		_shareList.Add(shareItem);
	}

	private void LaunchFacebook()
	{
		Login("facebook");
	}

	private void Login(string siteID)
	{
		_003CLogin_003Ed__0 CS_0024_003C_003E8__locals35 = new _003CLogin_003Ed__0(0);
		CS_0024_003C_003E8__locals35._003C_003E4__this = this;
		CS_0024_003C_003E8__locals35.siteID = siteID;
		CS_0024_003C_003E8__locals35._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				bool result;
				switch (CS_0024_003C_003E8__locals35._003C_003E1__state)
				{
				default:
					if (CS_0024_003C_003E8__locals35._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await4 = MobileBlogService.Instance.CheckLogin(CS_0024_003C_003E8__locals35.siteID).GetAwaiter();
					if (!CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await4.IsCompleted)
					{
						CS_0024_003C_003E8__locals35._003C_003E1__state = 1;
						flag = false;
						CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await4.OnCompleted(CS_0024_003C_003E8__locals35._003C_003Et__MoveNextDelegate);
						return;
					}
					goto IL_0077;
				case 1:
					CS_0024_003C_003E8__locals35._003C_003E1__state = 0;
					goto IL_0077;
				case 2:
					{
						CS_0024_003C_003E8__locals35._003C_003E1__state = 0;
						break;
					}
					IL_0077:
					result = CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await4.GetResult();
					CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await4 = default(TaskAwaiter<bool>);
					CS_0024_003C_003E8__locals35._003CfLoggedIn_003E5__1 = result;
					if (!CS_0024_003C_003E8__locals35._003CfLoggedIn_003E5__1)
					{
						CS_0024_003C_003E8__locals35._003Ca2_003Et___0024await6 = MobileBlogService.Instance.Logout(CS_0024_003C_003E8__locals35.siteID, null).GetAwaiter();
						if (!CS_0024_003C_003E8__locals35._003Ca2_003Et___0024await6.IsCompleted)
						{
							CS_0024_003C_003E8__locals35._003C_003E1__state = 2;
							flag = false;
							CS_0024_003C_003E8__locals35._003Ca2_003Et___0024await6.OnCompleted(CS_0024_003C_003E8__locals35._003C_003Et__MoveNextDelegate);
							return;
						}
						break;
					}
					PageNavigationService.OpenShareDetailPage(CS_0024_003C_003E8__locals35._003C_003E4__this._page);
					goto end_IL_0000;
				}
				bool result2 = CS_0024_003C_003E8__locals35._003Ca2_003Et___0024await6.GetResult();
				CS_0024_003C_003E8__locals35._003Ca2_003Et___0024await6 = default(TaskAwaiter<bool>);
				CS_0024_003C_003E8__locals35._003CfLoggedOut_003E5__2 = result2;
				PageNavigationService.OpenLoginOauthPage(CS_0024_003C_003E8__locals35.siteID, 0, CS_0024_003C_003E8__locals35._003C_003E4__this._page);
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals35._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals35._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals35._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals35._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals35._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals35.MoveNext();
	}
}
