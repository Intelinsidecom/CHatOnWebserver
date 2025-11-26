using System;
using System.CodeDom.Compiler;
using System.ServiceModel;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[GeneratedCode("System.ServiceModel", "4.0.0.0")]
[ServiceContract(Namespace = "http://dev.virtualearth.net/webservices/v1/mapcontrolconfiguration/contracts", ConfigurationName = "ConfigService.IMapControlConfigurationService")]
internal interface IMapControlConfigurationService
{
	[FaultContract(typeof(ResponseSummary), Action = "http://dev.virtualearth.net/webservices/v1/mapcontrolconfiguration/contracts/IMapControlConfigurationService/GetConfigurationResponseSummaryFault", Name = "ResponseSummary", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
	[OperationContract(AsyncPattern = true, Action = "http://dev.virtualearth.net/webservices/v1/mapcontrolconfiguration/contracts/IMapControlConfigurationService/GetConfiguration", ReplyAction = "http://dev.virtualearth.net/webservices/v1/mapcontrolconfiguration/contracts/IMapControlConfigurationService/GetConfigurationResponse")]
	IAsyncResult BeginGetConfiguration(MapControlConfigurationRequest request, AsyncCallback callback, object asyncState);

	MapControlConfigurationResponse EndGetConfiguration(IAsyncResult result);
}
