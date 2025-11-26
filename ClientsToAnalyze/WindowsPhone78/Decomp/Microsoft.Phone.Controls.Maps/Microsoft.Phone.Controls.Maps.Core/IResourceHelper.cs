using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Core;

internal interface IResourceHelper<TResource> where TResource : class
{
	TResource CreateResource();

	void SetResourceCulture(TResource resource, CultureInfo culture);
}
