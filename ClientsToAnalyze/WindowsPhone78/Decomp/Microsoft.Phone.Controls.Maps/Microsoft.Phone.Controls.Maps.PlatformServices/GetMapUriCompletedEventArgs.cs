using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[GeneratedCode("System.ServiceModel", "4.0.0.0")]
internal class GetMapUriCompletedEventArgs : AsyncCompletedEventArgs
{
	private object[] results;

	public MapUriResponse Result
	{
		get
		{
			RaiseExceptionIfNecessary();
			return (MapUriResponse)results[0];
		}
	}

	public GetMapUriCompletedEventArgs(object[] results, Exception exception, bool cancelled, object userState)
		: base(exception, cancelled, userState)
	{
		this.results = results;
	}
}
