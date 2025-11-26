using System.Collections.Generic;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class CopyrightKeyComparer : IEqualityComparer<CopyrightKey>
{
	public bool Equals(CopyrightKey first, CopyrightKey second)
	{
		if (first.Culture == second.Culture)
		{
			return first.Style == second.Style;
		}
		return false;
	}

	public int GetHashCode(CopyrightKey key)
	{
		return (int)(key.Culture.GetHashCode() + key.Style);
	}
}
