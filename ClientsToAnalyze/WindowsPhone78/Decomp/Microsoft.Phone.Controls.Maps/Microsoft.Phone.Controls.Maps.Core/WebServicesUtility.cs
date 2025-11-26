using System.ServiceModel;
using System.ServiceModel.Channels;
using Microsoft.Phone.Controls.Maps.PlatformServices;

namespace Microsoft.Phone.Controls.Maps.Core;

internal static class WebServicesUtility
{
	internal static ImageryServiceClient CreateImageryServiceClient(string imageryServiceAddress)
	{
		imageryServiceAddress = imageryServiceAddress.Replace("{UriScheme}", "HTTP");
		HttpTransportBindingElement httpTransportBindingElement = new HttpTransportBindingElement();
		CustomBinding binding = new CustomBinding(new BinaryMessageEncodingBindingElement(), httpTransportBindingElement);
		return new ImageryServiceClient(binding, new EndpointAddress(imageryServiceAddress));
	}
}
