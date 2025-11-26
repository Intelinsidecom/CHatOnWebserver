using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class CopyrightKey
{
	internal CultureInfo Culture { get; private set; }

	internal MapStyle Style { get; private set; }

	internal CopyrightKey(CultureInfo _culture, MapStyle _style)
	{
		Culture = _culture;
		Style = _style;
	}
}
