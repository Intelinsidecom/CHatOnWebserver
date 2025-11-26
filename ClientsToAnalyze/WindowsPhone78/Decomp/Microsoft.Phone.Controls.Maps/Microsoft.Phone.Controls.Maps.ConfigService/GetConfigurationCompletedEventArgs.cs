using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[GeneratedCode("System.ServiceModel", "4.0.0.0")]
[DebuggerStepThrough]
internal class GetConfigurationCompletedEventArgs : AsyncCompletedEventArgs
{
	private object[] results;

	public MapControlConfigurationResponse Result
	{
		get
		{
			RaiseExceptionIfNecessary();
			return (MapControlConfigurationResponse)results[0];
		}
	}

	public GetConfigurationCompletedEventArgs(object[] results, Exception exception, bool cancelled, object userState)
		: base(exception, cancelled, userState)
	{
		this.results = results;
	}
}
