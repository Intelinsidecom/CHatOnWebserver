using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Globalization;
using System.Resources;
using System.Runtime.CompilerServices;

namespace Microsoft.Phone.Controls.Maps;

[CompilerGenerated]
[GeneratedCode("System.Resources.Tools.StronglyTypedResourceBuilder", "4.0.0.0")]
[DebuggerNonUserCode]
internal class ExceptionStrings
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
				ResourceManager resourceManager = new ResourceManager("Microsoft.Phone.Controls.Maps.ExceptionStrings", typeof(ExceptionStrings).Assembly);
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

	internal static string ConfigurationException_InvalidLoad => ResourceManager.GetString("ConfigurationException_InvalidLoad", resourceCulture);

	internal static string ConfigurationException_NullXml => ResourceManager.GetString("ConfigurationException_NullXml", resourceCulture);

	internal static string InvalidMode => ResourceManager.GetString("InvalidMode", resourceCulture);

	internal static string LocationToViewportPoint_DefaultException => ResourceManager.GetString("LocationToViewportPoint_DefaultException", resourceCulture);

	internal static string MapConfiguration_GetSection_NonNull => ResourceManager.GetString("MapConfiguration_GetSection_NonNull", resourceCulture);

	internal static string MapConfiguration_ParseConfiguration_DuplicateNodeKey => ResourceManager.GetString("MapConfiguration_ParseConfiguration_DuplicateNodeKey", resourceCulture);

	internal static string MapConfiguration_ParseConfiguration_DuplicateSection => ResourceManager.GetString("MapConfiguration_ParseConfiguration_DuplicateSection", resourceCulture);

	internal static string MapConfiguration_ParseConfiguration_InvalidRoot => ResourceManager.GetString("MapConfiguration_ParseConfiguration_InvalidRoot", resourceCulture);

	internal static string MapConfiguration_ParseConfiguration_InvalidSection_NoVersion => ResourceManager.GetString("MapConfiguration_ParseConfiguration_InvalidSection_NoVersion", resourceCulture);

	internal static string MapConfiguration_ParseConfiguration_InvalidTag => ResourceManager.GetString("MapConfiguration_ParseConfiguration_InvalidTag", resourceCulture);

	internal static string MapConfiguration_WebService_InvalidResult => ResourceManager.GetString("MapConfiguration_WebService_InvalidResult", resourceCulture);

	internal static string TileSource_InvalidSubdomain_stringNull => ResourceManager.GetString("TileSource_InvalidSubdomain_stringNull", resourceCulture);

	internal static string TileSource_InvalidSubdomains_DifferentLength => ResourceManager.GetString("TileSource_InvalidSubdomains_DifferentLength", resourceCulture);

	internal static string TileSource_InvalidSubdomains_LengthMoreThan0 => ResourceManager.GetString("TileSource_InvalidSubdomains_LengthMoreThan0", resourceCulture);

	internal static string TypeConverter_InvalidApplicationIdCredentialsProvider => ResourceManager.GetString("TypeConverter_InvalidApplicationIdCredentialsProvider", resourceCulture);

	internal static string TypeConverter_InvalidLocationCollection => ResourceManager.GetString("TypeConverter_InvalidLocationCollection", resourceCulture);

	internal static string TypeConverter_InvalidLocationFormat => ResourceManager.GetString("TypeConverter_InvalidLocationFormat", resourceCulture);

	internal static string TypeConverter_InvalidLocationRectFormat => ResourceManager.GetString("TypeConverter_InvalidLocationRectFormat", resourceCulture);

	internal static string TypeConverter_InvalidMapMode => ResourceManager.GetString("TypeConverter_InvalidMapMode", resourceCulture);

	internal static string TypeConverter_InvalidPositionOriginFormat => ResourceManager.GetString("TypeConverter_InvalidPositionOriginFormat", resourceCulture);

	internal static string TypeConverter_InvalidRangeFormat => ResourceManager.GetString("TypeConverter_InvalidRangeFormat", resourceCulture);

	internal static string ViewportPointToLocation_DefaultException => ResourceManager.GetString("ViewportPointToLocation_DefaultException", resourceCulture);

	internal ExceptionStrings()
	{
	}
}
