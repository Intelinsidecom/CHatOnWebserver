using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.IO;
using System.IO.IsolatedStorage;
using System.Linq;
using System.Net;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Navigation;
using System.Xml.Linq;
using System.Xml.Serialization;
using ChatOn.Res;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Info;

namespace ChatOn.Services;

public class MobileBlogService
{
	public delegate void CreateAlbumCompletedEventHandler(string albumId);

	public delegate void UploadPhotoCompletedEventHandler(bool fResult);

	[CompilerGenerated]
	private sealed class _003CHttpPostRequest_003Ed__0
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncTaskMethodBuilder<Stream> _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public MobileBlogService _003C_003E4__this;

		public string request;

		public string _003C_003E3__request;

		public HttpWebRequest _003ChttpRequest_003E5__1;

		public HttpWebResponse _003ChttpResponse_003E5__2;

		public Stream _003CresultStream_003E5__3;

		private TaskAwaiter<WebResponse> _003Ca1_003Et___0024await5;

		public void MoveNext()
		{
			Stream result2;
			try
			{
				bool flag = true;
				int num = _003C_003E1__state;
				if (num != 1 && _003C_003E1__state == -1)
				{
					return;
				}
				try
				{
					int num2 = _003C_003E1__state;
					if (num2 != 1)
					{
						_003ChttpRequest_003E5__1 = (HttpWebRequest)WebRequest.Create(request);
						_003ChttpRequest_003E5__1.Method = "POST";
						_003ChttpRequest_003E5__1.ContentType = "application/x-www-form-urlencoded";
						_003ChttpRequest_003E5__1.CookieContainer = new CookieContainer();
						_003C_003E4__this.MakeRequestHeaders(_003ChttpRequest_003E5__1);
						_003Ca1_003Et___0024await5 = _003ChttpRequest_003E5__1.GetResponseAsync().GetAwaiter();
						if (!_003Ca1_003Et___0024await5.IsCompleted)
						{
							_003C_003E1__state = 1;
							flag = false;
							_003Ca1_003Et___0024await5.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						_003C_003E1__state = 0;
					}
					WebResponse result = _003Ca1_003Et___0024await5.GetResult();
					_003Ca1_003Et___0024await5 = default(TaskAwaiter<WebResponse>);
					_003ChttpResponse_003E5__2 = result as HttpWebResponse;
					_003CresultStream_003E5__3 = _003ChttpResponse_003E5__2.GetResponseStream();
					result2 = _003CresultStream_003E5__3;
				}
				catch (WebException)
				{
					goto IL_0115;
				}
				catch (ArgumentNullException)
				{
					goto IL_0115;
				}
				goto end_IL_0000;
				IL_0115:
				result2 = null;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncTaskMethodBuilder<Stream> asyncTaskMethodBuilder = _0024builder;
				asyncTaskMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncTaskMethodBuilder<Stream> asyncTaskMethodBuilder2 = _0024builder;
			asyncTaskMethodBuilder2.SetResult(result2);
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003CHttpPostRequest_003Ed__0(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	[CompilerGenerated]
	private sealed class _003CCheckLogin_003Ed__a
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncTaskMethodBuilder<bool> _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public MobileBlogService _003C_003E4__this;

		public string siteID;

		public string _003C_003E3__siteID;

		public string _003Caddress_003E5__b;

		public string _003Cparam_003E5__c;

		public Stream _003CresultStream_003E5__d;

		public XDocument _003CxmlDoc_003E5__e;

		private TaskAwaiter<Stream> _003Ca1_003Et___0024await10;

		public void MoveNext()
		{
			bool result2;
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
					_003Caddress_003E5__b = "http://mblog.samsungmobile.com/mblog/v1/auth/logincheck";
					_003Cparam_003E5__c = "?site=" + siteID;
				}
				try
				{
					int num2 = _003C_003E1__state;
					if (num2 != 1)
					{
						_003Ca1_003Et___0024await10 = _003C_003E4__this.HttpPostRequest(_003Caddress_003E5__b + _003Cparam_003E5__c).GetAwaiter();
						if (!_003Ca1_003Et___0024await10.IsCompleted)
						{
							_003C_003E1__state = 1;
							flag = false;
							_003Ca1_003Et___0024await10.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						_003C_003E1__state = 0;
					}
					Stream result = _003Ca1_003Et___0024await10.GetResult();
					_003Ca1_003Et___0024await10 = default(TaskAwaiter<Stream>);
					_003CresultStream_003E5__d = result;
					_003CxmlDoc_003E5__e = XDocument.Load(_003CresultStream_003E5__d);
					if (_003CxmlDoc_003E5__e.Element("response") == null || !_003CxmlDoc_003E5__e.Element("response").Attribute("status").Value.Contains("ok"))
					{
						goto end_IL_003e;
					}
					_003C_003E4__this.SetCurrentSite(siteID);
					result2 = true;
					goto end_IL_0000;
					end_IL_003e:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = false;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder = _0024builder;
				asyncTaskMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder2 = _0024builder;
			asyncTaskMethodBuilder2.SetResult(result2);
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003CCheckLogin_003Ed__a(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	[CompilerGenerated]
	private sealed class _003CLogin_003Ed__12
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncTaskMethodBuilder<bool> _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public MobileBlogService _003C_003E4__this;

		public string userId;

		public string _003C_003E3__userId;

		public string passWord;

		public string _003C_003E3__passWord;

		public string siteID;

		public string _003C_003E3__siteID;

		public bool isKeepLogin;

		public bool _003C_003E3__isKeepLogin;

		public string _003Caddress_003E5__13;

		public string _003Cparam_003E5__14;

		public Stream _003CresultStream_003E5__15;

		public XDocument _003CxmlDoc_003E5__16;

		public SiteData _003Csite_003E5__17;

		private TaskAwaiter<Stream> _003Ca1_003Et___0024await19;

		public void MoveNext()
		{
			bool result2;
			try
			{
				bool flag = true;
				int num = _003C_003E1__state;
				if (num != 1 && _003C_003E1__state == -1)
				{
					return;
				}
				try
				{
					int num2 = _003C_003E1__state;
					if (num2 != 1)
					{
						_003Caddress_003E5__13 = "http://mblog.samsungmobile.com/mblog/v1/auth/login";
						_003Cparam_003E5__14 = "?site=" + siteID + "&userId=" + userId + "&password=" + passWord;
						_003Ca1_003Et___0024await19 = _003C_003E4__this.HttpPostRequest(_003Caddress_003E5__13 + _003Cparam_003E5__14).GetAwaiter();
						if (!_003Ca1_003Et___0024await19.IsCompleted)
						{
							_003C_003E1__state = 1;
							flag = false;
							_003Ca1_003Et___0024await19.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						_003C_003E1__state = 0;
					}
					Stream result = _003Ca1_003Et___0024await19.GetResult();
					_003Ca1_003Et___0024await19 = default(TaskAwaiter<Stream>);
					_003CresultStream_003E5__15 = result;
					_003CxmlDoc_003E5__16 = XDocument.Load(_003CresultStream_003E5__15);
					if (_003CxmlDoc_003E5__16.Element("response") == null || !_003CxmlDoc_003E5__16.Element("response").Attribute("status").Value.Contains("ok"))
					{
						goto end_IL_001d;
					}
					List<SiteData>.Enumerator enumerator = _003C_003E4__this._supportedSites.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							_003Csite_003E5__17 = enumerator.Current;
							if (_003Csite_003E5__17.ID == siteID)
							{
								_003Csite_003E5__17.UserID = userId;
								_003Csite_003E5__17.IsKeepLogin = isKeepLogin;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
					_003C_003E4__this.SaveSiteList();
					_003C_003E4__this.SetCurrentSite(siteID);
					result2 = true;
					goto end_IL_0000;
					end_IL_001d:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = false;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder = _0024builder;
				asyncTaskMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder2 = _0024builder;
			asyncTaskMethodBuilder2.SetResult(result2);
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003CLogin_003Ed__12(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	[CompilerGenerated]
	private sealed class _003CLoginOauth_003Ed__1b
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncTaskMethodBuilder<string> _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public MobileBlogService _003C_003E4__this;

		public string siteID;

		public string _003C_003E3__siteID;

		public string _003ClastErrorMessage_003E5__1c;

		public string _003Caddress_003E5__1d;

		public string _003Cparam_003E5__1e;

		public Stream _003CresultStream_003E5__1f;

		public XDocument _003CxmlDoc_003E5__20;

		public string _003ClastErrorCode_003E5__21;

		private TaskAwaiter<Stream> _003Ca1_003Et___0024await23;

		public void MoveNext()
		{
			string result2;
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
					_003ClastErrorMessage_003E5__1c = string.Empty;
				}
				try
				{
					int num2 = _003C_003E1__state;
					if (num2 != 1)
					{
						_003Caddress_003E5__1d = "http://mblog.samsungmobile.com/mblog/v1/oauth/login";
						_003Cparam_003E5__1e = "?site=" + siteID + "&skipResult=true";
						_003Ca1_003Et___0024await23 = _003C_003E4__this.HttpPostRequest(_003Caddress_003E5__1d + _003Cparam_003E5__1e).GetAwaiter();
						if (!_003Ca1_003Et___0024await23.IsCompleted)
						{
							_003C_003E1__state = 1;
							flag = false;
							_003Ca1_003Et___0024await23.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						_003C_003E1__state = 0;
					}
					Stream result = _003Ca1_003Et___0024await23.GetResult();
					_003Ca1_003Et___0024await23 = default(TaskAwaiter<Stream>);
					_003CresultStream_003E5__1f = result;
					_003CxmlDoc_003E5__20 = XDocument.Load(_003CresultStream_003E5__1f);
					if (_003CxmlDoc_003E5__20.Element("response") == null)
					{
						goto end_IL_0028;
					}
					if (!_003CxmlDoc_003E5__20.Element("response").Attribute("status").Value.Contains("ok"))
					{
						if (_003CxmlDoc_003E5__20.Element("response").Attribute("status").Value.Contains("failure"))
						{
							_003ClastErrorCode_003E5__21 = _003CxmlDoc_003E5__20.Element("response").Element("error").Attribute("code")
								.Value;
							_003ClastErrorMessage_003E5__1c = _003CxmlDoc_003E5__20.Element("response").Element("error").Value;
						}
						goto end_IL_0028;
					}
					result2 = _003CxmlDoc_003E5__20.Element("response").Element("call_back_url").Value;
					goto end_IL_0000;
					end_IL_0028:;
				}
				catch (WebException ex)
				{
					_003ClastErrorMessage_003E5__1c = ex.Message;
				}
				catch (ArgumentNullException)
				{
				}
				result2 = "";
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncTaskMethodBuilder<string> asyncTaskMethodBuilder = _0024builder;
				asyncTaskMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncTaskMethodBuilder<string> asyncTaskMethodBuilder2 = _0024builder;
			asyncTaskMethodBuilder2.SetResult(result2);
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003CLoginOauth_003Ed__1b(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	[CompilerGenerated]
	private sealed class _003CLogout_003Ed__25
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncTaskMethodBuilder<bool> _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public MobileBlogService _003C_003E4__this;

		public string siteID;

		public string _003C_003E3__siteID;

		public string userID;

		public string _003C_003E3__userID;

		public string _003Caddress_003E5__26;

		public string _003Cparam_003E5__27;

		public Stream _003CresultStream_003E5__28;

		public XDocument _003CxmlDoc_003E5__29;

		public SiteData _003Csite_003E5__2a;

		public string _003ClastErrorMessage_003E5__2b;

		private TaskAwaiter<Stream> _003Ca1_003Et___0024await2d;

		public void MoveNext()
		{
			bool result2;
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
					_003C_003E4__this.SetCurrentSite(siteID);
				}
				try
				{
					int num2 = _003C_003E1__state;
					if (num2 != 1)
					{
						_003Caddress_003E5__26 = "http://mblog.samsungmobile.com/mblog/v1/auth/logout";
						_003Cparam_003E5__27 = "?site=" + siteID;
						if (!_003C_003E4__this._currentSite.IsOAuthLogin)
						{
							_003Cparam_003E5__27 = _003Cparam_003E5__27 + "&userId=" + userID;
						}
						_003Ca1_003Et___0024await2d = _003C_003E4__this.HttpPostRequest(_003Caddress_003E5__26 + _003Cparam_003E5__27).GetAwaiter();
						if (!_003Ca1_003Et___0024await2d.IsCompleted)
						{
							_003C_003E1__state = 1;
							flag = false;
							_003Ca1_003Et___0024await2d.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						_003C_003E1__state = 0;
					}
					Stream result = _003Ca1_003Et___0024await2d.GetResult();
					_003Ca1_003Et___0024await2d = default(TaskAwaiter<Stream>);
					_003CresultStream_003E5__28 = result;
					_003CxmlDoc_003E5__29 = XDocument.Load(_003CresultStream_003E5__28);
					if (_003CxmlDoc_003E5__29.Element("response") == null)
					{
						goto end_IL_002e;
					}
					if (!_003CxmlDoc_003E5__29.Element("response").Attribute("status").Value.Contains("ok"))
					{
						if (_003CxmlDoc_003E5__29.Element("response").Attribute("status").Value.Contains("failure"))
						{
							_003ClastErrorMessage_003E5__2b = _003CxmlDoc_003E5__29.Element("response").Element("error").Value;
						}
						goto end_IL_002e;
					}
					List<SiteData>.Enumerator enumerator = _003C_003E4__this._supportedSites.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							_003Csite_003E5__2a = enumerator.Current;
							if (_003Csite_003E5__2a.ID == siteID)
							{
								_003Csite_003E5__2a.UserID = string.Empty;
								_003Csite_003E5__2a.IsKeepLogin = false;
								_003C_003E4__this._currentSite = null;
								_003C_003E4__this.SaveSiteList();
								if (_003Csite_003E5__2a.IsOAuthLogin)
								{
									_003C_003E4__this._webBrowser.Navigate(new Uri(_003Csite_003E5__2a.LogoutUrl));
								}
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
					result2 = true;
					goto end_IL_0000;
					end_IL_002e:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = false;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder = _0024builder;
				asyncTaskMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder2 = _0024builder;
			asyncTaskMethodBuilder2.SetResult(result2);
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003CLogout_003Ed__25(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	[CompilerGenerated]
	private sealed class _003CUploadPhoto_003Ed__2f
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public MobileBlogService _003C_003E4__this;

		public string site;

		public string _003C_003E3__site;

		public string postText;

		public string _003C_003E3__postText;

		public string fileName;

		public string _003C_003E3__fileName;

		public byte[] imageBuffer;

		public byte[] _003C_003E3__imageBuffer;

		public List<AlbumData> _003Clist_003E5__30;

		public AlbumData _003Citem_003E5__31;

		public AlbumData _003Citem_003E5__32;

		private TaskAwaiter<List<AlbumData>> _003Ca1_003Et___0024await34;

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
					_003C_003E4__this._albumName = _003C_003E4__this._defaultAlbumName;
					_003Ca1_003Et___0024await34 = _003C_003E4__this.GetAlbumList(site).GetAwaiter();
					if (!_003Ca1_003Et___0024await34.IsCompleted)
					{
						_003C_003E1__state = 1;
						flag = false;
						_003Ca1_003Et___0024await34.OnCompleted(_003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					_003C_003E1__state = 0;
				}
				List<AlbumData> result = _003Ca1_003Et___0024await34.GetResult();
				_003Ca1_003Et___0024await34 = default(TaskAwaiter<List<AlbumData>>);
				_003Clist_003E5__30 = result;
				if (string.Equals(site, "facebook") || string.Equals(site, "picasa"))
				{
					_003C_003E4__this._postTitle = postText;
					List<AlbumData>.Enumerator enumerator = _003Clist_003E5__30.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							_003Citem_003E5__31 = enumerator.Current;
							if (_003Citem_003E5__31.Title.Equals(_003C_003E4__this._defaultAlbumName))
							{
								_003C_003E4__this._albumId = _003Citem_003E5__31.ID;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
				}
				else if (string.Equals(site, "photobucket"))
				{
					_003C_003E4__this._postTitle = string.Empty;
					_003C_003E4__this._postContent = string.Empty;
					List<AlbumData>.Enumerator enumerator2 = _003Clist_003E5__30.GetEnumerator();
					try
					{
						while (enumerator2.MoveNext())
						{
							_003Citem_003E5__32 = enumerator2.Current;
							if (_003Citem_003E5__32.Title.Contains(_003C_003E4__this._defaultAlbumName))
							{
								_003C_003E4__this._albumId = _003Citem_003E5__32.ID;
								_003C_003E4__this._albumName = string.Empty;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator2/*cast due to .constrained prefix*/).Dispose();
						}
					}
				}
				_003C_003E4__this.UploadPostContent(site, _003C_003E4__this._postTitle, _003C_003E4__this._postContent, _003C_003E4__this._albumId, _003C_003E4__this._albumName, fileName, imageBuffer);
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
		public _003CUploadPhoto_003Ed__2f(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	[CompilerGenerated]
	private sealed class _003CGetAlbumList_003Ed__3b
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncTaskMethodBuilder<List<AlbumData>> _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public MobileBlogService _003C_003E4__this;

		public string siteName;

		public string _003C_003E3__siteName;

		public string _003Caddress_003E5__3c;

		public string _003Cparam_003E5__3d;

		public Stream _003CresultStream_003E5__3e;

		public XDocument _003CxmlDoc_003E5__3f;

		public List<AlbumData> _003Clist_003E5__40;

		private TaskAwaiter<Stream> _003Ca1_003Et___0024await42;

		public void MoveNext()
		{
			List<AlbumData> result2;
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
					_003Caddress_003E5__3c = "http://mblog.samsungmobile.com/mblog/v1/albums";
					_003Cparam_003E5__3d = "?site=" + siteName;
				}
				try
				{
					int num2 = _003C_003E1__state;
					if (num2 != 1)
					{
						_003Ca1_003Et___0024await42 = _003C_003E4__this.HttpPostRequest(_003Caddress_003E5__3c + _003Cparam_003E5__3d).GetAwaiter();
						if (!_003Ca1_003Et___0024await42.IsCompleted)
						{
							_003C_003E1__state = 1;
							flag = false;
							_003Ca1_003Et___0024await42.OnCompleted(_003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						_003C_003E1__state = 0;
					}
					Stream result = _003Ca1_003Et___0024await42.GetResult();
					_003Ca1_003Et___0024await42 = default(TaskAwaiter<Stream>);
					_003CresultStream_003E5__3e = result;
					_003CxmlDoc_003E5__3f = XDocument.Load(_003CresultStream_003E5__3e);
					if (_003CxmlDoc_003E5__3f.Element("response") == null || !_003CxmlDoc_003E5__3f.Element("response").Attribute("status").Value.Contains("ok"))
					{
						goto end_IL_003e;
					}
					_003Clist_003E5__40 = (from item in _003CxmlDoc_003E5__3f.Descendants("album")
						select new AlbumData(item)).ToList();
					result2 = _003Clist_003E5__40;
					goto end_IL_0000;
					end_IL_003e:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = null;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncTaskMethodBuilder<List<AlbumData>> asyncTaskMethodBuilder = _0024builder;
				asyncTaskMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncTaskMethodBuilder<List<AlbumData>> asyncTaskMethodBuilder2 = _0024builder;
			asyncTaskMethodBuilder2.SetResult(result2);
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003CGetAlbumList_003Ed__3b(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	private const string _serverAddress = "mblog.samsungmobile.com";

	private const string _siteVersion = "v1";

	private const string _checkLoginURL = "/mblog/v1/auth/logincheck";

	private const string preBoundary = "--MULTIPART-FORM-DATA-BOUNDARY--";

	private const string _siteDataFileName = "SITE.DAT";

	private const string _SITE_FACEBOOK = "facebook";

	private const string _SITE_PHOTOBUCKET = "photobucket";

	private const string _SITE_PICASA = "picasa";

	private static MobileBlogService _instance;

	private static CookieContainer _cookieContainer;

	private SiteData _currentSite;

	private List<SiteData> _supportedSites = new List<SiteData>();

	private List<string> _facebookUrl;

	private List<string> _picasaUrl;

	private string _defaultAlbumName = ResContainer.IDS_CHATON_BODY_CHATON;

	private string _postTitle;

	private string _postContent;

	private string _albumId;

	private string _albumName;

	private WebBrowser _webBrowser;

	public static MobileBlogService Instance
	{
		get
		{
			if (_instance == null)
			{
				_instance = new MobileBlogService();
			}
			return _instance;
		}
	}

	public CookieContainer CookieContainer
	{
		get
		{
			return _cookieContainer;
		}
		set
		{
			_cookieContainer = value;
		}
	}

	public SiteData CurrentSite
	{
		get
		{
			return _currentSite;
		}
		set
		{
			_currentSite = value;
		}
	}

	public List<SiteData> SupportedSites
	{
		get
		{
			return _supportedSites;
		}
		set
		{
			_supportedSites = value;
		}
	}

	public event CreateAlbumCompletedEventHandler CreateAlbumCompleted;

	public event UploadPhotoCompletedEventHandler UploadPhotoCompleted;

	public MobileBlogService()
	{
		_cookieContainer = new CookieContainer();
		_facebookUrl = new List<string>();
		_picasaUrl = new List<string>();
		InitService();
	}

	private void InitService()
	{
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Expected O, but got Unknown
		if (!Utility.IsFileExist("IMEI.DAT"))
		{
			CreateDeviceInfo();
		}
		LoadSiteList();
		_webBrowser = new WebBrowser();
		_webBrowser.Navigated += webBrowser_Navigated;
	}

	private void CreateDeviceInfo()
	{
		Encoding uTF = Encoding.UTF8;
		string text = CreateIMEI();
		string text2 = CreateIMSI();
		if (!text.Contains("00000000"))
		{
			Utility.SaveByteAsFile("IMEI.DAT", uTF.GetBytes(text));
		}
		if (!text2.Contains("0000000"))
		{
			Utility.SaveByteAsFile("IMSI.DAT", uTF.GetBytes(text2));
		}
	}

	private string CreateIMEI()
	{
		return Guid.NewGuid().ToString().Replace("-", "");
	}

	private string CreateIMSI()
	{
		return Guid.NewGuid().ToString().Replace("-", "");
	}

	private string GetIMEI()
	{
		string result = "000000000000000";
		if (Utility.IsFileExist("IMEI.DAT"))
		{
			MemoryStream memoryStream = new MemoryStream(Utility.FileToByteArray("IMEI.DAT"));
			StreamReader streamReader = new StreamReader(memoryStream);
			string text = streamReader.ReadToEnd();
			string text2 = "\a";
			string[] array = text.Split(text2.ToCharArray());
			result = ((array.Length <= 1) ? text : array[1]);
			memoryStream.Dispose();
		}
		return result;
	}

	private string GetIMSI()
	{
		string result = "00000000000000000";
		if (Utility.IsFileExist("IMSI.DAT"))
		{
			MemoryStream memoryStream = new MemoryStream(Utility.FileToByteArray("IMSI.DAT"));
			StreamReader streamReader = new StreamReader(memoryStream);
			string text = streamReader.ReadToEnd();
			string text2 = "\a";
			string[] array = text.Split(text2.ToCharArray());
			result = ((array.Length <= 1) ? text : array[1]);
			memoryStream.Dispose();
		}
		return result;
	}

	private string GetDevicename()
	{
		return DeviceExtendedProperties.GetValue("DeviceName").ToString();
	}

	private string GetNationalCode()
	{
		string name = CultureInfo.CurrentCulture.Name;
		string text = "-";
		return name.Split(text.ToCharArray()).GetValue(1).ToString();
	}

	private string GetLanguageCode()
	{
		return CultureInfo.CurrentCulture.TwoLetterISOLanguageName;
	}

	private void MakeHttpRequest(string requestUrl, string method, AsyncCallback callback)
	{
		HttpWebRequest httpWebRequest = (HttpWebRequest)WebRequest.Create(requestUrl);
		httpWebRequest.Method = method;
		httpWebRequest.ContentType = "application/x-www-form-urlencoded";
		httpWebRequest.CookieContainer = new CookieContainer();
		MakeRequestHeaders(httpWebRequest);
		try
		{
			httpWebRequest.BeginGetResponse(callback.Invoke, httpWebRequest);
		}
		catch (WebException)
		{
		}
		catch (ArgumentNullException)
		{
		}
	}

	private void MakeRequestHeaders(HttpWebRequest httpRequest)
	{
		httpRequest.Headers["userNo"] = GetIMSI();
		httpRequest.Headers["imeiNo"] = GetIMEI();
		httpRequest.Headers["nation"] = GetNationalCode();
		httpRequest.Headers["language"] = GetLanguageCode();
		httpRequest.Headers["model"] = GetDevicename();
	}

	private Task<Stream> HttpPostRequest(string request)
	{
		_003CHttpPostRequest_003Ed__0 CS_0024_003C_003E8__locals33 = new _003CHttpPostRequest_003Ed__0(0);
		CS_0024_003C_003E8__locals33._003C_003E4__this = this;
		CS_0024_003C_003E8__locals33.request = request;
		CS_0024_003C_003E8__locals33._003C_003Et__MoveNextDelegate = delegate
		{
			Stream result2;
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals33._003C_003E1__state;
				if (num != 1 && CS_0024_003C_003E8__locals33._003C_003E1__state == -1)
				{
					return;
				}
				try
				{
					int num2 = CS_0024_003C_003E8__locals33._003C_003E1__state;
					if (num2 != 1)
					{
						CS_0024_003C_003E8__locals33._003ChttpRequest_003E5__1 = (HttpWebRequest)WebRequest.Create(CS_0024_003C_003E8__locals33.request);
						CS_0024_003C_003E8__locals33._003ChttpRequest_003E5__1.Method = "POST";
						CS_0024_003C_003E8__locals33._003ChttpRequest_003E5__1.ContentType = "application/x-www-form-urlencoded";
						CS_0024_003C_003E8__locals33._003ChttpRequest_003E5__1.CookieContainer = new CookieContainer();
						CS_0024_003C_003E8__locals33._003C_003E4__this.MakeRequestHeaders(CS_0024_003C_003E8__locals33._003ChttpRequest_003E5__1);
						CS_0024_003C_003E8__locals33._003Ca1_003Et___0024await5 = CS_0024_003C_003E8__locals33._003ChttpRequest_003E5__1.GetResponseAsync().GetAwaiter();
						if (!CS_0024_003C_003E8__locals33._003Ca1_003Et___0024await5.IsCompleted)
						{
							CS_0024_003C_003E8__locals33._003C_003E1__state = 1;
							flag = false;
							CS_0024_003C_003E8__locals33._003Ca1_003Et___0024await5.OnCompleted(CS_0024_003C_003E8__locals33._003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						CS_0024_003C_003E8__locals33._003C_003E1__state = 0;
					}
					WebResponse result = CS_0024_003C_003E8__locals33._003Ca1_003Et___0024await5.GetResult();
					CS_0024_003C_003E8__locals33._003Ca1_003Et___0024await5 = default(TaskAwaiter<WebResponse>);
					CS_0024_003C_003E8__locals33._003ChttpResponse_003E5__2 = result as HttpWebResponse;
					CS_0024_003C_003E8__locals33._003CresultStream_003E5__3 = CS_0024_003C_003E8__locals33._003ChttpResponse_003E5__2.GetResponseStream();
					result2 = CS_0024_003C_003E8__locals33._003CresultStream_003E5__3;
				}
				catch (WebException)
				{
					goto IL_0115;
				}
				catch (ArgumentNullException)
				{
					goto IL_0115;
				}
				goto end_IL_0000;
				IL_0115:
				result2 = null;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals33._003C_003E1__state = -1;
				AsyncTaskMethodBuilder<Stream> asyncTaskMethodBuilder2 = CS_0024_003C_003E8__locals33._0024builder;
				asyncTaskMethodBuilder2.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals33._003C_003E1__state = -1;
			AsyncTaskMethodBuilder<Stream> asyncTaskMethodBuilder3 = CS_0024_003C_003E8__locals33._0024builder;
			asyncTaskMethodBuilder3.SetResult(result2);
		};
		CS_0024_003C_003E8__locals33._0024builder = AsyncTaskMethodBuilder<Stream>.Create();
		CS_0024_003C_003E8__locals33.MoveNext();
		AsyncTaskMethodBuilder<Stream> asyncTaskMethodBuilder = CS_0024_003C_003E8__locals33._0024builder;
		return asyncTaskMethodBuilder.Task;
	}

	public void LoadSiteList()
	{
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0034: Expected O, but got Unknown
		using IsolatedStorageFile isolatedStorageFile = IsolatedStorageFile.GetUserStoreForApplication();
		if (isolatedStorageFile.FileExists("SITE.DAT"))
		{
			using IsolatedStorageFileStream isolatedStorageFileStream = isolatedStorageFile.OpenFile("SITE.DAT", FileMode.Open);
			XmlSerializer val = new XmlSerializer(_supportedSites.GetType());
			_supportedSites = (List<SiteData>)val.Deserialize((Stream)isolatedStorageFileStream);
			if (_supportedSites.Count < 3)
			{
				_supportedSites = GetCustomSiteList();
				SaveSiteList();
			}
			else
			{
				foreach (SiteData supportedSite in _supportedSites)
				{
					if (supportedSite.ID.Contains("facebook"))
					{
						supportedSite.IsOAuthLogin = true;
						supportedSite.IsKeepLogin = false;
						supportedSite.LogoutUrl = "http://m.facebook.com/#!/home.php";
					}
					if (supportedSite.ID.Contains("picasa"))
					{
						supportedSite.IsOAuthLogin = true;
						supportedSite.IsKeepLogin = false;
						supportedSite.LogoutUrl = "https://accounts.google.com/Logout";
					}
				}
			}
		}
		else
		{
			_supportedSites = GetCustomSiteList();
		}
		SaveSiteList();
	}

	private void SaveSiteList()
	{
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Expected O, but got Unknown
		using IsolatedStorageFile isolatedStorageFile = IsolatedStorageFile.GetUserStoreForApplication();
		using IsolatedStorageFileStream isolatedStorageFileStream = isolatedStorageFile.CreateFile("SITE.DAT");
		XmlSerializer val = new XmlSerializer(_supportedSites.GetType());
		val.Serialize((Stream)isolatedStorageFileStream, (object)_supportedSites);
	}

	public SiteData GetSiteBySiteID(string siteID)
	{
		foreach (SiteData supportedSite in _supportedSites)
		{
			if (supportedSite.ID == siteID)
			{
				return supportedSite;
			}
		}
		return null;
	}

	private void GetSiteList()
	{
		string text = "http://mblog.samsungmobile.com/mblog/v1/sites";
		string text2 = "?siteVer=8";
		MakeHttpRequest(text + text2, "POST", GetSiteListResponse);
	}

	private void GetSiteListResponse(IAsyncResult ar)
	{
		HttpWebRequest httpWebRequest = (HttpWebRequest)ar.AsyncState;
		HttpWebResponse httpWebResponse = (HttpWebResponse)httpWebRequest.EndGetResponse(ar);
		Stream responseStream = httpWebResponse.GetResponseStream();
		XDocument xDocument = XDocument.Load(responseStream);
		if (xDocument.Element("response") != null && xDocument.Element("response").Attribute("status").Value.Contains("ok"))
		{
			Utility.SaveStreamAsFile("SITE.DAT", responseStream);
			responseStream.Close();
		}
	}

	public List<SiteData> GetCustomSiteList()
	{
		List<SiteData> list = new List<SiteData>();
		SiteData siteData = new SiteData();
		siteData.ID = "facebook";
		siteData.Name = "Facebook";
		siteData.IsOAuthLogin = true;
		siteData.IsSupportTitle = true;
		siteData.IsSupportContents = false;
		siteData.IsSupportAlbum = true;
		siteData.LogoutUrl = "http://m.facebook.com/#!/home.php";
		SiteData item = siteData;
		list.Add(item);
		SiteData siteData2 = new SiteData();
		siteData2.ID = "photobucket";
		siteData2.Name = "Photobucket";
		siteData2.IsOAuthLogin = false;
		siteData2.IsSupportTitle = false;
		siteData2.IsSupportContents = false;
		siteData2.IsSupportAlbum = true;
		item = siteData2;
		list.Add(item);
		SiteData siteData3 = new SiteData();
		siteData3.ID = "picasa";
		siteData3.Name = "Picasa";
		siteData3.IsOAuthLogin = true;
		siteData3.IsSupportTitle = true;
		siteData3.IsSupportContents = false;
		siteData3.IsSupportAlbum = true;
		siteData3.LogoutUrl = "https://accounts.google.com/Logout";
		item = siteData3;
		list.Add(item);
		return list;
	}

	public void SetCurrentSite(string siteID)
	{
		foreach (SiteData supportedSite in _supportedSites)
		{
			if (string.Equals(supportedSite.ID, siteID))
			{
				_currentSite = supportedSite;
				break;
			}
		}
	}

	public bool SetUserIDtoSite(string siteID, string userID)
	{
		foreach (SiteData supportedSite in _supportedSites)
		{
			if (string.Equals(supportedSite.ID, siteID))
			{
				supportedSite.UserID = userID;
				SaveSiteList();
				return true;
			}
		}
		return false;
	}

	public Task<bool> CheckLogin(string siteID)
	{
		_003CCheckLogin_003Ed__a CS_0024_003C_003E8__locals34 = new _003CCheckLogin_003Ed__a(0);
		CS_0024_003C_003E8__locals34._003C_003E4__this = this;
		CS_0024_003C_003E8__locals34.siteID = siteID;
		CS_0024_003C_003E8__locals34._003C_003Et__MoveNextDelegate = delegate
		{
			bool result2;
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals34._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals34._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals34._003Caddress_003E5__b = "http://mblog.samsungmobile.com/mblog/v1/auth/logincheck";
					CS_0024_003C_003E8__locals34._003Cparam_003E5__c = "?site=" + CS_0024_003C_003E8__locals34.siteID;
				}
				try
				{
					int num2 = CS_0024_003C_003E8__locals34._003C_003E1__state;
					if (num2 != 1)
					{
						CS_0024_003C_003E8__locals34._003Ca1_003Et___0024await10 = CS_0024_003C_003E8__locals34._003C_003E4__this.HttpPostRequest(CS_0024_003C_003E8__locals34._003Caddress_003E5__b + CS_0024_003C_003E8__locals34._003Cparam_003E5__c).GetAwaiter();
						if (!CS_0024_003C_003E8__locals34._003Ca1_003Et___0024await10.IsCompleted)
						{
							CS_0024_003C_003E8__locals34._003C_003E1__state = 1;
							flag = false;
							CS_0024_003C_003E8__locals34._003Ca1_003Et___0024await10.OnCompleted(CS_0024_003C_003E8__locals34._003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						CS_0024_003C_003E8__locals34._003C_003E1__state = 0;
					}
					Stream result = CS_0024_003C_003E8__locals34._003Ca1_003Et___0024await10.GetResult();
					CS_0024_003C_003E8__locals34._003Ca1_003Et___0024await10 = default(TaskAwaiter<Stream>);
					CS_0024_003C_003E8__locals34._003CresultStream_003E5__d = result;
					CS_0024_003C_003E8__locals34._003CxmlDoc_003E5__e = XDocument.Load(CS_0024_003C_003E8__locals34._003CresultStream_003E5__d);
					if (CS_0024_003C_003E8__locals34._003CxmlDoc_003E5__e.Element("response") == null || !CS_0024_003C_003E8__locals34._003CxmlDoc_003E5__e.Element("response").Attribute("status").Value.Contains("ok"))
					{
						goto end_IL_003e;
					}
					CS_0024_003C_003E8__locals34._003C_003E4__this.SetCurrentSite(CS_0024_003C_003E8__locals34.siteID);
					result2 = true;
					goto end_IL_0000;
					end_IL_003e:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = false;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals34._003C_003E1__state = -1;
				AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder2 = CS_0024_003C_003E8__locals34._0024builder;
				asyncTaskMethodBuilder2.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals34._003C_003E1__state = -1;
			AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder3 = CS_0024_003C_003E8__locals34._0024builder;
			asyncTaskMethodBuilder3.SetResult(result2);
		};
		CS_0024_003C_003E8__locals34._0024builder = AsyncTaskMethodBuilder<bool>.Create();
		CS_0024_003C_003E8__locals34.MoveNext();
		AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder = CS_0024_003C_003E8__locals34._0024builder;
		return asyncTaskMethodBuilder.Task;
	}

	public Task<bool> Login(string userId, string passWord, string siteID, bool isKeepLogin)
	{
		_003CLogin_003Ed__12 CS_0024_003C_003E8__locals48 = new _003CLogin_003Ed__12(0);
		CS_0024_003C_003E8__locals48._003C_003E4__this = this;
		CS_0024_003C_003E8__locals48.userId = userId;
		CS_0024_003C_003E8__locals48.passWord = passWord;
		CS_0024_003C_003E8__locals48.siteID = siteID;
		CS_0024_003C_003E8__locals48.isKeepLogin = isKeepLogin;
		CS_0024_003C_003E8__locals48._003C_003Et__MoveNextDelegate = delegate
		{
			bool result2;
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals48._003C_003E1__state;
				if (num != 1 && CS_0024_003C_003E8__locals48._003C_003E1__state == -1)
				{
					return;
				}
				try
				{
					int num2 = CS_0024_003C_003E8__locals48._003C_003E1__state;
					if (num2 != 1)
					{
						CS_0024_003C_003E8__locals48._003Caddress_003E5__13 = "http://mblog.samsungmobile.com/mblog/v1/auth/login";
						CS_0024_003C_003E8__locals48._003Cparam_003E5__14 = "?site=" + CS_0024_003C_003E8__locals48.siteID + "&userId=" + CS_0024_003C_003E8__locals48.userId + "&password=" + CS_0024_003C_003E8__locals48.passWord;
						CS_0024_003C_003E8__locals48._003Ca1_003Et___0024await19 = CS_0024_003C_003E8__locals48._003C_003E4__this.HttpPostRequest(CS_0024_003C_003E8__locals48._003Caddress_003E5__13 + CS_0024_003C_003E8__locals48._003Cparam_003E5__14).GetAwaiter();
						if (!CS_0024_003C_003E8__locals48._003Ca1_003Et___0024await19.IsCompleted)
						{
							CS_0024_003C_003E8__locals48._003C_003E1__state = 1;
							flag = false;
							CS_0024_003C_003E8__locals48._003Ca1_003Et___0024await19.OnCompleted(CS_0024_003C_003E8__locals48._003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						CS_0024_003C_003E8__locals48._003C_003E1__state = 0;
					}
					Stream result = CS_0024_003C_003E8__locals48._003Ca1_003Et___0024await19.GetResult();
					CS_0024_003C_003E8__locals48._003Ca1_003Et___0024await19 = default(TaskAwaiter<Stream>);
					CS_0024_003C_003E8__locals48._003CresultStream_003E5__15 = result;
					CS_0024_003C_003E8__locals48._003CxmlDoc_003E5__16 = XDocument.Load(CS_0024_003C_003E8__locals48._003CresultStream_003E5__15);
					if (CS_0024_003C_003E8__locals48._003CxmlDoc_003E5__16.Element("response") == null || !CS_0024_003C_003E8__locals48._003CxmlDoc_003E5__16.Element("response").Attribute("status").Value.Contains("ok"))
					{
						goto end_IL_001d;
					}
					List<SiteData>.Enumerator enumerator = CS_0024_003C_003E8__locals48._003C_003E4__this._supportedSites.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							CS_0024_003C_003E8__locals48._003Csite_003E5__17 = enumerator.Current;
							if (CS_0024_003C_003E8__locals48._003Csite_003E5__17.ID == CS_0024_003C_003E8__locals48.siteID)
							{
								CS_0024_003C_003E8__locals48._003Csite_003E5__17.UserID = CS_0024_003C_003E8__locals48.userId;
								CS_0024_003C_003E8__locals48._003Csite_003E5__17.IsKeepLogin = CS_0024_003C_003E8__locals48.isKeepLogin;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
					CS_0024_003C_003E8__locals48._003C_003E4__this.SaveSiteList();
					CS_0024_003C_003E8__locals48._003C_003E4__this.SetCurrentSite(CS_0024_003C_003E8__locals48.siteID);
					result2 = true;
					goto end_IL_0000;
					end_IL_001d:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = false;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals48._003C_003E1__state = -1;
				AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder2 = CS_0024_003C_003E8__locals48._0024builder;
				asyncTaskMethodBuilder2.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals48._003C_003E1__state = -1;
			AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder3 = CS_0024_003C_003E8__locals48._0024builder;
			asyncTaskMethodBuilder3.SetResult(result2);
		};
		CS_0024_003C_003E8__locals48._0024builder = AsyncTaskMethodBuilder<bool>.Create();
		CS_0024_003C_003E8__locals48.MoveNext();
		AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder = CS_0024_003C_003E8__locals48._0024builder;
		return asyncTaskMethodBuilder.Task;
	}

	public Task<string> LoginOauth(string siteID)
	{
		_003CLoginOauth_003Ed__1b CS_0024_003C_003E8__locals40 = new _003CLoginOauth_003Ed__1b(0);
		CS_0024_003C_003E8__locals40._003C_003E4__this = this;
		CS_0024_003C_003E8__locals40.siteID = siteID;
		CS_0024_003C_003E8__locals40._003C_003Et__MoveNextDelegate = delegate
		{
			string result2;
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals40._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals40._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals40._003ClastErrorMessage_003E5__1c = string.Empty;
				}
				try
				{
					int num2 = CS_0024_003C_003E8__locals40._003C_003E1__state;
					if (num2 != 1)
					{
						CS_0024_003C_003E8__locals40._003Caddress_003E5__1d = "http://mblog.samsungmobile.com/mblog/v1/oauth/login";
						CS_0024_003C_003E8__locals40._003Cparam_003E5__1e = "?site=" + CS_0024_003C_003E8__locals40.siteID + "&skipResult=true";
						CS_0024_003C_003E8__locals40._003Ca1_003Et___0024await23 = CS_0024_003C_003E8__locals40._003C_003E4__this.HttpPostRequest(CS_0024_003C_003E8__locals40._003Caddress_003E5__1d + CS_0024_003C_003E8__locals40._003Cparam_003E5__1e).GetAwaiter();
						if (!CS_0024_003C_003E8__locals40._003Ca1_003Et___0024await23.IsCompleted)
						{
							CS_0024_003C_003E8__locals40._003C_003E1__state = 1;
							flag = false;
							CS_0024_003C_003E8__locals40._003Ca1_003Et___0024await23.OnCompleted(CS_0024_003C_003E8__locals40._003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						CS_0024_003C_003E8__locals40._003C_003E1__state = 0;
					}
					Stream result = CS_0024_003C_003E8__locals40._003Ca1_003Et___0024await23.GetResult();
					CS_0024_003C_003E8__locals40._003Ca1_003Et___0024await23 = default(TaskAwaiter<Stream>);
					CS_0024_003C_003E8__locals40._003CresultStream_003E5__1f = result;
					CS_0024_003C_003E8__locals40._003CxmlDoc_003E5__20 = XDocument.Load(CS_0024_003C_003E8__locals40._003CresultStream_003E5__1f);
					if (CS_0024_003C_003E8__locals40._003CxmlDoc_003E5__20.Element("response") == null)
					{
						goto end_IL_0028;
					}
					if (!CS_0024_003C_003E8__locals40._003CxmlDoc_003E5__20.Element("response").Attribute("status").Value.Contains("ok"))
					{
						if (CS_0024_003C_003E8__locals40._003CxmlDoc_003E5__20.Element("response").Attribute("status").Value.Contains("failure"))
						{
							CS_0024_003C_003E8__locals40._003ClastErrorCode_003E5__21 = CS_0024_003C_003E8__locals40._003CxmlDoc_003E5__20.Element("response").Element("error").Attribute("code")
								.Value;
							CS_0024_003C_003E8__locals40._003ClastErrorMessage_003E5__1c = CS_0024_003C_003E8__locals40._003CxmlDoc_003E5__20.Element("response").Element("error").Value;
						}
						goto end_IL_0028;
					}
					result2 = CS_0024_003C_003E8__locals40._003CxmlDoc_003E5__20.Element("response").Element("call_back_url").Value;
					goto end_IL_0000;
					end_IL_0028:;
				}
				catch (WebException ex)
				{
					CS_0024_003C_003E8__locals40._003ClastErrorMessage_003E5__1c = ex.Message;
				}
				catch (ArgumentNullException)
				{
				}
				result2 = "";
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals40._003C_003E1__state = -1;
				AsyncTaskMethodBuilder<string> asyncTaskMethodBuilder2 = CS_0024_003C_003E8__locals40._0024builder;
				asyncTaskMethodBuilder2.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals40._003C_003E1__state = -1;
			AsyncTaskMethodBuilder<string> asyncTaskMethodBuilder3 = CS_0024_003C_003E8__locals40._0024builder;
			asyncTaskMethodBuilder3.SetResult(result2);
		};
		CS_0024_003C_003E8__locals40._0024builder = AsyncTaskMethodBuilder<string>.Create();
		CS_0024_003C_003E8__locals40.MoveNext();
		AsyncTaskMethodBuilder<string> asyncTaskMethodBuilder = CS_0024_003C_003E8__locals40._0024builder;
		return asyncTaskMethodBuilder.Task;
	}

	public Task<bool> Logout(string siteID, string userID)
	{
		_003CLogout_003Ed__25 CS_0024_003C_003E8__locals53 = new _003CLogout_003Ed__25(0);
		CS_0024_003C_003E8__locals53._003C_003E4__this = this;
		CS_0024_003C_003E8__locals53.siteID = siteID;
		CS_0024_003C_003E8__locals53.userID = userID;
		CS_0024_003C_003E8__locals53._003C_003Et__MoveNextDelegate = delegate
		{
			bool result2;
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals53._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals53._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals53._003C_003E4__this.SetCurrentSite(CS_0024_003C_003E8__locals53.siteID);
				}
				try
				{
					int num2 = CS_0024_003C_003E8__locals53._003C_003E1__state;
					if (num2 != 1)
					{
						CS_0024_003C_003E8__locals53._003Caddress_003E5__26 = "http://mblog.samsungmobile.com/mblog/v1/auth/logout";
						CS_0024_003C_003E8__locals53._003Cparam_003E5__27 = "?site=" + CS_0024_003C_003E8__locals53.siteID;
						if (!CS_0024_003C_003E8__locals53._003C_003E4__this._currentSite.IsOAuthLogin)
						{
							CS_0024_003C_003E8__locals53._003Cparam_003E5__27 = CS_0024_003C_003E8__locals53._003Cparam_003E5__27 + "&userId=" + CS_0024_003C_003E8__locals53.userID;
						}
						CS_0024_003C_003E8__locals53._003Ca1_003Et___0024await2d = CS_0024_003C_003E8__locals53._003C_003E4__this.HttpPostRequest(CS_0024_003C_003E8__locals53._003Caddress_003E5__26 + CS_0024_003C_003E8__locals53._003Cparam_003E5__27).GetAwaiter();
						if (!CS_0024_003C_003E8__locals53._003Ca1_003Et___0024await2d.IsCompleted)
						{
							CS_0024_003C_003E8__locals53._003C_003E1__state = 1;
							flag = false;
							CS_0024_003C_003E8__locals53._003Ca1_003Et___0024await2d.OnCompleted(CS_0024_003C_003E8__locals53._003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						CS_0024_003C_003E8__locals53._003C_003E1__state = 0;
					}
					Stream result = CS_0024_003C_003E8__locals53._003Ca1_003Et___0024await2d.GetResult();
					CS_0024_003C_003E8__locals53._003Ca1_003Et___0024await2d = default(TaskAwaiter<Stream>);
					CS_0024_003C_003E8__locals53._003CresultStream_003E5__28 = result;
					CS_0024_003C_003E8__locals53._003CxmlDoc_003E5__29 = XDocument.Load(CS_0024_003C_003E8__locals53._003CresultStream_003E5__28);
					if (CS_0024_003C_003E8__locals53._003CxmlDoc_003E5__29.Element("response") == null)
					{
						goto end_IL_002e;
					}
					if (!CS_0024_003C_003E8__locals53._003CxmlDoc_003E5__29.Element("response").Attribute("status").Value.Contains("ok"))
					{
						if (CS_0024_003C_003E8__locals53._003CxmlDoc_003E5__29.Element("response").Attribute("status").Value.Contains("failure"))
						{
							CS_0024_003C_003E8__locals53._003ClastErrorMessage_003E5__2b = CS_0024_003C_003E8__locals53._003CxmlDoc_003E5__29.Element("response").Element("error").Value;
						}
						goto end_IL_002e;
					}
					List<SiteData>.Enumerator enumerator = CS_0024_003C_003E8__locals53._003C_003E4__this._supportedSites.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							CS_0024_003C_003E8__locals53._003Csite_003E5__2a = enumerator.Current;
							if (CS_0024_003C_003E8__locals53._003Csite_003E5__2a.ID == CS_0024_003C_003E8__locals53.siteID)
							{
								CS_0024_003C_003E8__locals53._003Csite_003E5__2a.UserID = string.Empty;
								CS_0024_003C_003E8__locals53._003Csite_003E5__2a.IsKeepLogin = false;
								CS_0024_003C_003E8__locals53._003C_003E4__this._currentSite = null;
								CS_0024_003C_003E8__locals53._003C_003E4__this.SaveSiteList();
								if (CS_0024_003C_003E8__locals53._003Csite_003E5__2a.IsOAuthLogin)
								{
									CS_0024_003C_003E8__locals53._003C_003E4__this._webBrowser.Navigate(new Uri(CS_0024_003C_003E8__locals53._003Csite_003E5__2a.LogoutUrl));
								}
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
					result2 = true;
					goto end_IL_0000;
					end_IL_002e:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = false;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals53._003C_003E1__state = -1;
				AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder2 = CS_0024_003C_003E8__locals53._0024builder;
				asyncTaskMethodBuilder2.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals53._003C_003E1__state = -1;
			AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder3 = CS_0024_003C_003E8__locals53._0024builder;
			asyncTaskMethodBuilder3.SetResult(result2);
		};
		CS_0024_003C_003E8__locals53._0024builder = AsyncTaskMethodBuilder<bool>.Create();
		CS_0024_003C_003E8__locals53.MoveNext();
		AsyncTaskMethodBuilder<bool> asyncTaskMethodBuilder = CS_0024_003C_003E8__locals53._0024builder;
		return asyncTaskMethodBuilder.Task;
	}

	private void webBrowser_Navigated(object sender, NavigationEventArgs e)
	{
		string text = ((WebBrowser)((sender is WebBrowser) ? sender : null)).SaveToString();
		if (!string.IsNullOrEmpty(text))
		{
			string facebookLogoutUrl = Utility.GetFacebookLogoutUrl(text);
			if (!string.IsNullOrEmpty(facebookLogoutUrl))
			{
				_webBrowser.Navigate(new Uri(facebookLogoutUrl));
			}
		}
	}

	public void ClearCookie(Uri uri)
	{
		CookieCollection cookies = _cookieContainer.GetCookies(uri);
		foreach (Cookie item in cookies)
		{
			item.Discard = true;
			item.Expired = true;
		}
	}

	public void CreateAlbum(string siteName, string albumName)
	{
		string text = "http://mblog.samsungmobile.com/mblog/v1/mkalbum";
		string text2 = "?site=" + siteName + "&albumName=" + albumName;
		HttpWebRequest httpWebRequest = (HttpWebRequest)WebRequest.Create(new Uri(text + text2));
		httpWebRequest.Method = "POST";
		httpWebRequest.ContentType = "application/x-www-form-urlencoded";
		httpWebRequest.CookieContainer = new CookieContainer();
		MakeRequestHeaders(httpWebRequest);
		try
		{
			httpWebRequest.BeginGetResponse(GetCreateAlbumResponse, httpWebRequest);
		}
		catch (WebException)
		{
		}
		catch (ArgumentNullException)
		{
		}
	}

	private void GetCreateAlbumResponse(IAsyncResult ar)
	{
		HttpWebRequest httpWebRequest = (HttpWebRequest)ar.AsyncState;
		HttpWebResponse httpWebResponse = (HttpWebResponse)httpWebRequest.EndGetResponse(ar);
		Stream responseStream = httpWebResponse.GetResponseStream();
		XDocument xDocument = XDocument.Load(responseStream);
		string albumId = string.Empty;
		if (xDocument.Element("response") != null && xDocument.Element("response").Attribute("status").Value.Contains("ok"))
		{
			albumId = xDocument.Element("album").Attribute("id").Value;
		}
		if (this.CreateAlbumCompleted != null)
		{
			this.CreateAlbumCompleted(albumId);
		}
	}

	internal byte[] BuildPostData(string param, string fileName, byte[] imageBuffer)
	{
		byte[] array = null;
		Encoding uTF = Encoding.UTF8;
		MemoryStream memoryStream = new MemoryStream();
		string text = "----MULTIPART-FORM-DATA-BOUNDARY--";
		param = param.Substring(1, param.Length - 1);
		string[] array2 = param.Split('&');
		try
		{
			for (int i = 0; i < array2.Length; i++)
			{
				string[] array3 = array2[i].Split('=');
				array = uTF.GetBytes(text);
				memoryStream.Write(array, 0, array.Length);
				if (i == array2.Length - 1)
				{
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.AppendLine();
					stringBuilder.AppendFormat("Content-Disposition: form-data; name=\"{0}\"; filename=\"{1}\"", array3[0], array3[1]);
					stringBuilder.AppendLine();
					stringBuilder.AppendLine("Content-Type: image/pjpeg");
					stringBuilder.AppendLine();
					array = uTF.GetBytes(stringBuilder.ToString());
					memoryStream.Write(array, 0, array.Length);
					if (fileName != null)
					{
						byte[] array4 = Utility.FileToByteArray(fileName);
						memoryStream.Write(array4, 0, array4.Length);
						StringBuilder stringBuilder2 = new StringBuilder();
						stringBuilder2.AppendLine();
						array = uTF.GetBytes(stringBuilder2.ToString());
						memoryStream.Write(array, 0, array.Length);
					}
					else if (imageBuffer != null)
					{
						memoryStream.Write(imageBuffer, 0, imageBuffer.Length);
						StringBuilder stringBuilder3 = new StringBuilder();
						stringBuilder3.AppendLine();
						array = uTF.GetBytes(stringBuilder3.ToString());
						memoryStream.Write(array, 0, array.Length);
					}
				}
				else
				{
					StringBuilder stringBuilder4 = new StringBuilder();
					stringBuilder4.AppendLine();
					stringBuilder4.AppendFormat("Content-Disposition: form-data; name=\"{0}\"", array3[0]);
					stringBuilder4.AppendLine();
					stringBuilder4.AppendLine();
					stringBuilder4.AppendLine(array3[1]);
					array = uTF.GetBytes(stringBuilder4.ToString());
					memoryStream.Write(array, 0, array.Length);
				}
			}
		}
		catch (IOException)
		{
		}
		string s = text + "--";
		array = uTF.GetBytes(s);
		memoryStream.Write(array, 0, array.Length);
		byte[] array5 = new byte[(int)memoryStream.Length];
		memoryStream.Position = 0L;
		memoryStream.Read(array5, 0, array5.Length);
		memoryStream.Close();
		memoryStream.Dispose();
		return array5;
	}

	public void UploadPhoto(string site, string postText, string fileName, byte[] imageBuffer)
	{
		_003CUploadPhoto_003Ed__2f CS_0024_003C_003E8__locals55 = new _003CUploadPhoto_003Ed__2f(0);
		CS_0024_003C_003E8__locals55._003C_003E4__this = this;
		CS_0024_003C_003E8__locals55.site = site;
		CS_0024_003C_003E8__locals55.postText = postText;
		CS_0024_003C_003E8__locals55.fileName = fileName;
		CS_0024_003C_003E8__locals55.imageBuffer = imageBuffer;
		CS_0024_003C_003E8__locals55._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals55._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals55._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals55._003C_003E4__this._albumName = CS_0024_003C_003E8__locals55._003C_003E4__this._defaultAlbumName;
					CS_0024_003C_003E8__locals55._003Ca1_003Et___0024await34 = CS_0024_003C_003E8__locals55._003C_003E4__this.GetAlbumList(CS_0024_003C_003E8__locals55.site).GetAwaiter();
					if (!CS_0024_003C_003E8__locals55._003Ca1_003Et___0024await34.IsCompleted)
					{
						CS_0024_003C_003E8__locals55._003C_003E1__state = 1;
						flag = false;
						CS_0024_003C_003E8__locals55._003Ca1_003Et___0024await34.OnCompleted(CS_0024_003C_003E8__locals55._003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					CS_0024_003C_003E8__locals55._003C_003E1__state = 0;
				}
				List<AlbumData> result = CS_0024_003C_003E8__locals55._003Ca1_003Et___0024await34.GetResult();
				CS_0024_003C_003E8__locals55._003Ca1_003Et___0024await34 = default(TaskAwaiter<List<AlbumData>>);
				CS_0024_003C_003E8__locals55._003Clist_003E5__30 = result;
				if (string.Equals(CS_0024_003C_003E8__locals55.site, "facebook") || string.Equals(CS_0024_003C_003E8__locals55.site, "picasa"))
				{
					CS_0024_003C_003E8__locals55._003C_003E4__this._postTitle = CS_0024_003C_003E8__locals55.postText;
					List<AlbumData>.Enumerator enumerator = CS_0024_003C_003E8__locals55._003Clist_003E5__30.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							CS_0024_003C_003E8__locals55._003Citem_003E5__31 = enumerator.Current;
							if (CS_0024_003C_003E8__locals55._003Citem_003E5__31.Title.Equals(CS_0024_003C_003E8__locals55._003C_003E4__this._defaultAlbumName))
							{
								CS_0024_003C_003E8__locals55._003C_003E4__this._albumId = CS_0024_003C_003E8__locals55._003Citem_003E5__31.ID;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
				}
				else if (string.Equals(CS_0024_003C_003E8__locals55.site, "photobucket"))
				{
					CS_0024_003C_003E8__locals55._003C_003E4__this._postTitle = string.Empty;
					CS_0024_003C_003E8__locals55._003C_003E4__this._postContent = string.Empty;
					List<AlbumData>.Enumerator enumerator2 = CS_0024_003C_003E8__locals55._003Clist_003E5__30.GetEnumerator();
					try
					{
						while (enumerator2.MoveNext())
						{
							CS_0024_003C_003E8__locals55._003Citem_003E5__32 = enumerator2.Current;
							if (CS_0024_003C_003E8__locals55._003Citem_003E5__32.Title.Contains(CS_0024_003C_003E8__locals55._003C_003E4__this._defaultAlbumName))
							{
								CS_0024_003C_003E8__locals55._003C_003E4__this._albumId = CS_0024_003C_003E8__locals55._003Citem_003E5__32.ID;
								CS_0024_003C_003E8__locals55._003C_003E4__this._albumName = string.Empty;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator2/*cast due to .constrained prefix*/).Dispose();
						}
					}
				}
				CS_0024_003C_003E8__locals55._003C_003E4__this.UploadPostContent(CS_0024_003C_003E8__locals55.site, CS_0024_003C_003E8__locals55._003C_003E4__this._postTitle, CS_0024_003C_003E8__locals55._003C_003E4__this._postContent, CS_0024_003C_003E8__locals55._003C_003E4__this._albumId, CS_0024_003C_003E8__locals55._003C_003E4__this._albumName, CS_0024_003C_003E8__locals55.fileName, CS_0024_003C_003E8__locals55.imageBuffer);
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals55._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals55._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals55._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals55._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals55._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals55.MoveNext();
	}

	private void UploadPostContent(string siteName, string title, string content, string albumId, string albumName, string fileName, byte[] imageData = null)
	{
		string uriString = "http://mblog.samsungmobile.com/mblog/v1/upload";
		string text = "?site=" + siteName + "&title=" + title + "&content=" + content + "&albumId=" + albumId + "&albumName=" + albumName + "&tags=himan";
		text += "&mimetype=image/jpeg&type=P&groupKey=MiniDiary&groupItemNum=1&groupCnt=1&photo=MiniDiary Photo";
		byte[] postData = null;
		if (!string.IsNullOrEmpty(fileName))
		{
			postData = BuildPostData(text, fileName, null);
		}
		else if (imageData != null)
		{
			postData = BuildPostData(text, null, imageData);
		}
		HttpWebRequest httpWebRequest = (HttpWebRequest)WebRequest.Create(new Uri(uriString));
		httpWebRequest.Method = "POST";
		httpWebRequest.ContentType = "multipart/form-data; boundary=--MULTIPART-FORM-DATA-BOUNDARY--";
		MakeRequestHeaders(httpWebRequest);
		httpWebRequest.BeginGetRequestStream(delegate(IAsyncResult ar)
		{
			GetRequestStremResponse(ar, postData);
		}, httpWebRequest);
	}

	private void GetRequestStremResponse(IAsyncResult ar, byte[] buffer)
	{
		try
		{
			HttpWebRequest httpWebRequest = (HttpWebRequest)ar.AsyncState;
			Stream stream = httpWebRequest.EndGetRequestStream(ar);
			stream.Write(buffer, 0, buffer.Length);
			stream.Close();
			httpWebRequest.BeginGetResponse(GetUploadPhotoResponse, httpWebRequest);
		}
		catch (Exception)
		{
			if (this.UploadPhotoCompleted != null)
			{
				this.UploadPhotoCompleted(fResult: false);
			}
		}
	}

	private void GetUploadPhotoResponse(IAsyncResult ar)
	{
		bool fResult = false;
		try
		{
			HttpWebRequest httpWebRequest = (HttpWebRequest)ar.AsyncState;
			HttpWebResponse httpWebResponse = (HttpWebResponse)httpWebRequest.EndGetResponse(ar);
			Stream responseStream = httpWebResponse.GetResponseStream();
			XDocument xDocument = XDocument.Load(responseStream);
			if (xDocument.Element("response") != null && xDocument.Element("response").Attribute("status").Value.Contains("ok"))
			{
				fResult = true;
			}
		}
		catch (Exception)
		{
		}
		finally
		{
			if (this.UploadPhotoCompleted != null)
			{
				this.UploadPhotoCompleted(fResult);
			}
		}
	}

	public Task<List<AlbumData>> GetAlbumList(string siteName)
	{
		_003CGetAlbumList_003Ed__3b CS_0024_003C_003E8__locals35 = new _003CGetAlbumList_003Ed__3b(0);
		CS_0024_003C_003E8__locals35._003C_003E4__this = this;
		CS_0024_003C_003E8__locals35.siteName = siteName;
		CS_0024_003C_003E8__locals35._003C_003Et__MoveNextDelegate = delegate
		{
			List<AlbumData> result2;
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals35._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals35._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals35._003Caddress_003E5__3c = "http://mblog.samsungmobile.com/mblog/v1/albums";
					CS_0024_003C_003E8__locals35._003Cparam_003E5__3d = "?site=" + CS_0024_003C_003E8__locals35.siteName;
				}
				try
				{
					int num2 = CS_0024_003C_003E8__locals35._003C_003E1__state;
					if (num2 != 1)
					{
						CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await42 = CS_0024_003C_003E8__locals35._003C_003E4__this.HttpPostRequest(CS_0024_003C_003E8__locals35._003Caddress_003E5__3c + CS_0024_003C_003E8__locals35._003Cparam_003E5__3d).GetAwaiter();
						if (!CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await42.IsCompleted)
						{
							CS_0024_003C_003E8__locals35._003C_003E1__state = 1;
							flag = false;
							CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await42.OnCompleted(CS_0024_003C_003E8__locals35._003C_003Et__MoveNextDelegate);
							return;
						}
					}
					else
					{
						CS_0024_003C_003E8__locals35._003C_003E1__state = 0;
					}
					Stream result = CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await42.GetResult();
					CS_0024_003C_003E8__locals35._003Ca1_003Et___0024await42 = default(TaskAwaiter<Stream>);
					CS_0024_003C_003E8__locals35._003CresultStream_003E5__3e = result;
					CS_0024_003C_003E8__locals35._003CxmlDoc_003E5__3f = XDocument.Load(CS_0024_003C_003E8__locals35._003CresultStream_003E5__3e);
					if (CS_0024_003C_003E8__locals35._003CxmlDoc_003E5__3f.Element("response") == null || !CS_0024_003C_003E8__locals35._003CxmlDoc_003E5__3f.Element("response").Attribute("status").Value.Contains("ok"))
					{
						goto end_IL_003e;
					}
					CS_0024_003C_003E8__locals35._003Clist_003E5__40 = (from item in CS_0024_003C_003E8__locals35._003CxmlDoc_003E5__3f.Descendants("album")
						select new AlbumData(item)).ToList();
					result2 = CS_0024_003C_003E8__locals35._003Clist_003E5__40;
					goto end_IL_0000;
					end_IL_003e:;
				}
				catch (WebException)
				{
				}
				catch (ArgumentNullException)
				{
				}
				result2 = null;
				end_IL_0000:;
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals35._003C_003E1__state = -1;
				AsyncTaskMethodBuilder<List<AlbumData>> asyncTaskMethodBuilder2 = CS_0024_003C_003E8__locals35._0024builder;
				asyncTaskMethodBuilder2.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals35._003C_003E1__state = -1;
			AsyncTaskMethodBuilder<List<AlbumData>> asyncTaskMethodBuilder3 = CS_0024_003C_003E8__locals35._0024builder;
			asyncTaskMethodBuilder3.SetResult(result2);
		};
		CS_0024_003C_003E8__locals35._0024builder = AsyncTaskMethodBuilder<List<AlbumData>>.Create();
		CS_0024_003C_003E8__locals35.MoveNext();
		AsyncTaskMethodBuilder<List<AlbumData>> asyncTaskMethodBuilder = CS_0024_003C_003E8__locals35._0024builder;
		return asyncTaskMethodBuilder.Task;
	}
}
