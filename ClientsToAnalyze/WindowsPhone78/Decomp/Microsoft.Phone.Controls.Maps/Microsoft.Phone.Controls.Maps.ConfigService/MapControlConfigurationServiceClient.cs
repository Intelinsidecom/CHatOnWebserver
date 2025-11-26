using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Net;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.Threading;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[GeneratedCode("System.ServiceModel", "4.0.0.0")]
[DebuggerStepThrough]
internal class MapControlConfigurationServiceClient : ClientBase<IMapControlConfigurationService>, IMapControlConfigurationService
{
	private class MapControlConfigurationServiceClientChannel : ChannelBase<IMapControlConfigurationService>, IMapControlConfigurationService
	{
		public MapControlConfigurationServiceClientChannel(ClientBase<IMapControlConfigurationService> client)
			: base(client)
		{
		}

		public IAsyncResult BeginGetConfiguration(MapControlConfigurationRequest request, AsyncCallback callback, object asyncState)
		{
			return BeginInvoke("GetConfiguration", new object[1] { request }, callback, asyncState);
		}

		public MapControlConfigurationResponse EndGetConfiguration(IAsyncResult result)
		{
			object[] args = new object[0];
			return (MapControlConfigurationResponse)EndInvoke("GetConfiguration", args, result);
		}
	}

	private BeginOperationDelegate onBeginGetConfigurationDelegate;

	private EndOperationDelegate onEndGetConfigurationDelegate;

	private SendOrPostCallback onGetConfigurationCompletedDelegate;

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

	public event EventHandler<GetConfigurationCompletedEventArgs> GetConfigurationCompleted;

	public event EventHandler<AsyncCompletedEventArgs> OpenCompleted;

	public event EventHandler<AsyncCompletedEventArgs> CloseCompleted;

	public MapControlConfigurationServiceClient()
	{
	}

	public MapControlConfigurationServiceClient(string endpointConfigurationName)
		: base(endpointConfigurationName)
	{
	}

	public MapControlConfigurationServiceClient(string endpointConfigurationName, string remoteAddress)
		: base(endpointConfigurationName, remoteAddress)
	{
	}

	public MapControlConfigurationServiceClient(string endpointConfigurationName, EndpointAddress remoteAddress)
		: base(endpointConfigurationName, remoteAddress)
	{
	}

	public MapControlConfigurationServiceClient(Binding binding, EndpointAddress remoteAddress)
		: base(binding, remoteAddress)
	{
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	IAsyncResult IMapControlConfigurationService.BeginGetConfiguration(MapControlConfigurationRequest request, AsyncCallback callback, object asyncState)
	{
		return base.Channel.BeginGetConfiguration(request, callback, asyncState);
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	MapControlConfigurationResponse IMapControlConfigurationService.EndGetConfiguration(IAsyncResult result)
	{
		return base.Channel.EndGetConfiguration(result);
	}

	private IAsyncResult OnBeginGetConfiguration(object[] inValues, AsyncCallback callback, object asyncState)
	{
		MapControlConfigurationRequest request = (MapControlConfigurationRequest)inValues[0];
		return ((IMapControlConfigurationService)this).BeginGetConfiguration(request, callback, asyncState);
	}

	private object[] OnEndGetConfiguration(IAsyncResult result)
	{
		MapControlConfigurationResponse mapControlConfigurationResponse = ((IMapControlConfigurationService)this).EndGetConfiguration(result);
		return new object[1] { mapControlConfigurationResponse };
	}

	private void OnGetConfigurationCompleted(object state)
	{
		if (this.GetConfigurationCompleted != null)
		{
			InvokeAsyncCompletedEventArgs e = (InvokeAsyncCompletedEventArgs)state;
			this.GetConfigurationCompleted(this, new GetConfigurationCompletedEventArgs(e.Results, e.Error, e.Cancelled, e.UserState));
		}
	}

	public void GetConfigurationAsync(MapControlConfigurationRequest request)
	{
		GetConfigurationAsync(request, null);
	}

	public void GetConfigurationAsync(MapControlConfigurationRequest request, object userState)
	{
		if (onBeginGetConfigurationDelegate == null)
		{
			onBeginGetConfigurationDelegate = OnBeginGetConfiguration;
		}
		if (onEndGetConfigurationDelegate == null)
		{
			onEndGetConfigurationDelegate = OnEndGetConfiguration;
		}
		if (onGetConfigurationCompletedDelegate == null)
		{
			onGetConfigurationCompletedDelegate = OnGetConfigurationCompleted;
		}
		InvokeAsync(onBeginGetConfigurationDelegate, new object[1] { request }, onEndGetConfigurationDelegate, onGetConfigurationCompletedDelegate, userState);
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

	protected override IMapControlConfigurationService CreateChannel()
	{
		return new MapControlConfigurationServiceClientChannel(this);
	}
}
