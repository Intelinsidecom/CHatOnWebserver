using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Globalization;
using System.Resources;
using System.Runtime.CompilerServices;

namespace Microsoft.Phone.Controls.Maps.Overlays;

[GeneratedCode("System.Resources.Tools.StronglyTypedResourceBuilder", "4.0.0.0")]
[CompilerGenerated]
[DebuggerNonUserCode]
internal class OverlayResources
{
	private static ResourceManager resourceMan;

	private static CultureInfo resourceCulture;

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	internal static ResourceManager ResourceManager
	{
		get
		{
			if (object.ReferenceEquals(resourceMan, null))
			{
				ResourceManager resourceManager = new ResourceManager("Microsoft.Phone.Controls.Maps.Overlays.OverlayResources", typeof(OverlayResources).Assembly);
				resourceMan = resourceManager;
			}
			return resourceMan;
		}
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	internal static CultureInfo Culture
	{
		get
		{
			return resourceCulture;
		}
		set
		{
			resourceCulture = value;
		}
	}

	internal static string Feet => ResourceManager.GetString("Feet", resourceCulture);

	internal static string InvalidCredentialsErrorMessage => ResourceManager.GetString("InvalidCredentialsErrorMessage", resourceCulture);

	internal static string Kilometers => ResourceManager.GetString("Kilometers", resourceCulture);

	internal static string LoadingConfigurationErrorMessage => ResourceManager.GetString("LoadingConfigurationErrorMessage", resourceCulture);

	internal static string LoadingUriSchemeErrorMessage => ResourceManager.GetString("LoadingUriSchemeErrorMessage", resourceCulture);

	internal static string Meters => ResourceManager.GetString("Meters", resourceCulture);

	internal static string Miles => ResourceManager.GetString("Miles", resourceCulture);

	internal static string Yards => ResourceManager.GetString("Yards", resourceCulture);

	internal OverlayResources()
	{
	}
}
