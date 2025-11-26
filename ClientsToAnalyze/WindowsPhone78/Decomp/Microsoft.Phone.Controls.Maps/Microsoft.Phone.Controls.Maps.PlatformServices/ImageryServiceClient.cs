using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Net;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.Threading;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.ServiceModel", "4.0.0.0")]
[DebuggerStepThrough]
internal class ImageryServiceClient : ClientBase<IImageryService>, IImageryService
{
	private class ImageryServiceClientChannel : ChannelBase<IImageryService>, IImageryService
	{
		public ImageryServiceClientChannel(ClientBase<IImageryService> client)
			: base(client)
		{
		}

		public IAsyncResult BeginGetImageryMetadata(ImageryMetadataRequest request, AsyncCallback callback, object asyncState)
		{
			return BeginInvoke("GetImageryMetadata", new object[1] { request }, callback, asyncState);
		}

		public ImageryMetadataResponse EndGetImageryMetadata(IAsyncResult result)
		{
			object[] args = new object[0];
			return (ImageryMetadataResponse)EndInvoke("GetImageryMetadata", args, result);
		}

		public IAsyncResult BeginGetMapUri(MapUriRequest request, AsyncCallback callback, object asyncState)
		{
			return BeginInvoke("GetMapUri", new object[1] { request }, callback, asyncState);
		}

		public MapUriResponse EndGetMapUri(IAsyncResult result)
		{
			object[] args = new object[0];
			return (MapUriResponse)EndInvoke("GetMapUri", args, result);
		}
	}

	private BeginOperationDelegate onBeginGetImageryMetadataDelegate;

	private EndOperationDelegate onEndGetImageryMetadataDelegate;

	private SendOrPostCallback onGetImageryMetadataCompletedDelegate;

	private BeginOperationDelegate onBeginGetMapUriDelegate;

	private EndOperationDelegate onEndGetMapUriDelegate;

	private SendOrPostCallback onGetMapUriCompletedDelegate;

	private BeginOperationDelegate onBeginOpenDelegate;

	private EndOperationDelegate onEndOpenDelegate;

	private SendOrPostCallback onOpenCompletedDelegate;

	private BeginOperationDelegate onBeginCloseDelegate;

	private EndOperationDelegate onEndCloseDelegate;

	private SendOrPostCallback onCloseCompletedDelegate;

	public CookieContainer CookieContainer
	{
		get
		{
			return base.InnerChannel.GetProperty<IHttpCookieContainerManager>()?.CookieContainer;
		}
		set
		{
			IHttpCookieContainerManager property = base.InnerChannel.GetProperty<IHttpCookieContainerManager>();
			if (property != null)
			{
				property.CookieContainer = value;
				return;
			}
			throw new InvalidOperationException("Unable to set the CookieContainer. Please make sure the binding contains an HttpCookieContainerBindingElement.");
		}
	}

	public event EventHandler<GetImageryMetadataCompletedEventArgs> GetImageryMetadataCompleted;

	public event EventHandler<GetMapUriCompletedEventArgs> GetMapUriCompleted;

	public event EventHandler<AsyncCompletedEventArgs> OpenCompleted;

	public event EventHandler<AsyncCompletedEventArgs> CloseCompleted;

	public ImageryServiceClient()
	{
	}

	public ImageryServiceClient(string endpointConfigurationName)
		: base(endpointConfigurationName)
	{
	}

	public ImageryServiceClient(string endpointConfigurationName, string remoteAddress)
		: base(endpointConfigurationName, remoteAddress)
	{
	}

	public ImageryServiceClient(string endpointConfigurationName, EndpointAddress remoteAddress)
		: base(endpointConfigurationName, remoteAddress)
	{
	}

	public ImageryServiceClient(Binding binding, EndpointAddress remoteAddress)
		: base(binding, remoteAddress)
	{
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	IAsyncResult IImageryService.BeginGetImageryMetadata(ImageryMetadataRequest request, AsyncCallback callback, object asyncState)
	{
		return base.Channel.BeginGetImageryMetadata(request, callback, asyncState);
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	ImageryMetadataResponse IImageryService.EndGetImageryMetadata(IAsyncResult result)
	{
		return base.Channel.EndGetImageryMetadata(result);
	}

	private IAsyncResult OnBeginGetImageryMetadata(object[] inValues, AsyncCallback callback, object asyncState)
	{
		ImageryMetadataRequest request = (ImageryMetadataRequest)inValues[0];
		return ((IImageryService)this).BeginGetImageryMetadata(request, callback, asyncState);
	}

	private object[] OnEndGetImageryMetadata(IAsyncResult result)
	{
		ImageryMetadataResponse imageryMetadataResponse = ((IImageryService)this).EndGetImageryMetadata(result);
		return new object[1] { imageryMetadataResponse };
	}

	private void OnGetImageryMetadataCompleted(object state)
	{
		if (this.GetImageryMetadataCompleted != null)
		{
			InvokeAsyncCompletedEventArgs e = (InvokeAsyncCompletedEventArgs)state;
			this.GetImageryMetadataCompleted(this, new GetImageryMetadataCompletedEventArgs(e.Results, e.Error, e.Cancelled, e.UserState));
		}
	}

	public void GetImageryMetadataAsync(ImageryMetadataRequest request)
	{
		GetImageryMetadataAsync(request, null);
	}

	public void GetImageryMetadataAsync(ImageryMetadataRequest request, object userState)
	{
		if (onBeginGetImageryMetadataDelegate == null)
		{
			onBeginGetImageryMetadataDelegate = OnBeginGetImageryMetadata;
		}
		if (onEndGetImageryMetadataDelegate == null)
		{
			onEndGetImageryMetadataDelegate = OnEndGetImageryMetadata;
		}
		if (onGetImageryMetadataCompletedDelegate == null)
		{
			onGetImageryMetadataCompletedDelegate = OnGetImageryMetadataCompleted;
		}
		InvokeAsync(onBeginGetImageryMetadataDelegate, new object[1] { request }, onEndGetImageryMetadataDelegate, onGetImageryMetadataCompletedDelegate, userState);
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	IAsyncResult IImageryService.BeginGetMapUri(MapUriRequest request, AsyncCallback callback, object asyncState)
	{
		return base.Channel.BeginGetMapUri(request, callback, asyncState);
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	MapUriResponse IImageryService.EndGetMapUri(IAsyncResult result)
	{
		return base.Channel.EndGetMapUri(result);
	}

	private IAsyncResult OnBeginGetMapUri(object[] inValues, AsyncCallback callback, object asyncState)
	{
		MapUriRequest request = (MapUriRequest)inValues[0];
		return ((IImageryService)this).BeginGetMapUri(request, callback, asyncState);
	}

	private object[] OnEndGetMapUri(IAsyncResult result)
	{
		MapUriResponse mapUriResponse = ((IImageryService)this).EndGetMapUri(result);
		return new object[1] { mapUriResponse };
	}

	private void OnGetMapUriCompleted(object state)
	{
		if (this.GetMapUriCompleted != null)
		{
			InvokeAsyncCompletedEventArgs e = (InvokeAsyncCompletedEventArgs)state;
			this.GetMapUriCompleted(this, new GetMapUriCompletedEventArgs(e.Results, e.Error, e.Cancelled, e.UserState));
		}
	}

	public void GetMapUriAsync(MapUriRequest request)
	{
		GetMapUriAsync(request, null);
	}

	public void GetMapUriAsync(MapUriRequest request, object userState)
	{
		if (onBeginGetMapUriDelegate == null)
		{
			onBeginGetMapUriDelegate = OnBeginGetMapUri;
		}
		if (onEndGetMapUriDelegate == null)
		{
			onEndGetMapUriDelegate = OnEndGetMapUri;
		}
		if (onGetMapUriCompletedDelegate == null)
		{
			onGetMapUriCompletedDelegate = OnGetMapUriCompleted;
		}
		InvokeAsync(onBeginGetMapUriDelegate, new object[1] { request }, onEndGetMapUriDelegate, onGetMapUriCompletedDelegate, userState);
	}

	private IAsyncResult OnBeginOpen(object[] inValues, AsyncCallback callback, object asyncState)
	{
		return ((ICommunicationObject)this).BeginOpen(callback, asyncState);
	}

	private object[] OnEndOpen(IAsyncResult result)
	{
		((ICommunicationObject)this).EndOpen(result);
		return null;
	}

	private void OnOpenCompleted(object state)
	{
		if (this.OpenCompleted != null)
		{
			InvokeAsyncCompletedEventArgs e = (InvokeAsyncCompletedEventArgs)state;
			this.OpenCompleted(this, new AsyncCompletedEventArgs(e.Error, e.Cancelled, e.UserState));
		}
	}

	public void OpenAsync()
	{
		OpenAsync(null);
	}

	public void OpenAsync(object userState)
	{
		if (onBeginOpenDelegate == null)
		{
			onBeginOpenDelegate = OnBeginOpen;
		}
		if (onEndOpenDelegate == null)
		{
			onEndOpenDelegate = OnEndOpen;
		}
		if (onOpenCompletedDelegate == null)
		{
			onOpenCompletedDelegate = OnOpenCompleted;
		}
		InvokeAsync(onBeginOpenDelegate, null, onEndOpenDelegate, onOpenCompletedDelegate, userState);
	}

	private IAsyncResult OnBeginClose(object[] inValues, AsyncCallback callback, object asyncState)
	{
		return ((ICommunicationObject)this).BeginClose(callback, asyncState);
	}

	private object[] OnEndClose(IAsyncResult result)
	{
		((ICommunicationObject)this).EndClose(result);
		return null;
	}

	private void OnCloseCompleted(object state)
	{
		if (this.CloseCompleted != null)
		{
			InvokeAsyncCompletedEventArgs e = (InvokeAsyncCompletedEventArgs)state;
			this.CloseCompleted(this, new AsyncCompletedEventArgs(e.Error, e.Cancelled, e.UserState));
		}
	}

	public void CloseAsync()
	{
		CloseAsync(null);
	}

	public void CloseAsync(object userState)
	{
		if (onBeginCloseDelegate == null)
		{
			onBeginCloseDelegate = OnBeginClose;
		}
		if (onEndCloseDelegate == null)
		{
			onEndCloseDelegate = OnEndClose;
		}
		if (onCloseCompletedDelegate == null)
		{
			onCloseCompletedDelegate = OnCloseCompleted;
		}
		InvokeAsync(onBeginCloseDelegate, null, onEndCloseDelegate, onCloseCompletedDelegate, userState);
	}

	protected override IImageryService CreateChannel()
	{
		return new ImageryServiceClientChannel(this);
	}
}
