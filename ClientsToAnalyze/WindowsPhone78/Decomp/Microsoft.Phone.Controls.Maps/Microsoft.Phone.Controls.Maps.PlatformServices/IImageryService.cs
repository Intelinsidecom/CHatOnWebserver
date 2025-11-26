using System;
using System.CodeDom.Compiler;
using System.ServiceModel;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[ServiceContract(Namespace = "http://dev.virtualearth.net/webservices/v1/imagery/contracts", ConfigurationName = "PlatformServices.IImageryService")]
[GeneratedCode("System.ServiceModel", "4.0.0.0")]
internal interface IImageryService
{
	[OperationContract(AsyncPattern = true, Action = "http://dev.virtualearth.net/webservices/v1/imagery/contracts/IImageryService/GetImageryMetadata", ReplyAction = "http://dev.virtualearth.net/webservices/v1/imagery/contracts/IImageryService/GetImageryMetadataResponse")]
	[FaultContract(typeof(ResponseSummary), Action = "http://dev.virtualearth.net/webservices/v1/imagery/contracts/IImageryService/GetImageryMetadataResponseSummaryFault", Name = "ResponseSummary", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
	IAsyncResult BeginGetImageryMetadata(ImageryMetadataRequest request, AsyncCallback callback, object asyncState);

	ImageryMetadataResponse EndGetImageryMetadata(IAsyncResult result);

	[OperationContract(AsyncPattern = true, Action = "http://dev.virtualearth.net/webservices/v1/imagery/contracts/IImageryService/GetMapUri", ReplyAction = "http://dev.virtualearth.net/webservices/v1/imagery/contracts/IImageryService/GetMapUriResponse")]
	[FaultContract(typeof(ResponseSummary), Action = "http://dev.virtualearth.net/webservices/v1/imagery/contracts/IImageryService/GetMapUriResponseSummaryFault", Name = "ResponseSummary", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
	IAsyncResult BeginGetMapUri(MapUriRequest request, AsyncCallback callback, object asyncState);

	MapUriResponse EndGetMapUri(IAsyncResult result);
}
