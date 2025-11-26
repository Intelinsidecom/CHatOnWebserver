using System;
using System.Collections.Generic;
using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Core;

internal static class ResourceUtility
{
	private static readonly Dictionary<Type, Dictionary<CultureInfo, object>> cache = new Dictionary<Type, Dictionary<CultureInfo, object>>();

	private static bool TryToGetCultureInfo(string cultureName, out CultureInfo cultureInfo)
	{
		try
		{
			cultureInfo = new CultureInfo(cultureName);
		}
		catch (ArgumentException)
		{
			cultureInfo = null;
			return false;
		}
		return true;
	}

	internal static CultureInfo GetCultureInfo(string cultureName)
	{
		if (TryToGetCultureInfo(cultureName, out var cultureInfo))
		{
			return cultureInfo;
		}
		int num = cultureName.IndexOf('-');
		if (num > 0)
		{
			string cultureName2 = cultureName.Substring(0, num);
			if (TryToGetCultureInfo(cultureName2, out cultureInfo))
			{
				return cultureInfo;
			}
		}
		return CultureInfo.CurrentUICulture;
	}

	private static bool TryToGetRegionInfo(string regionName, out RegionInfo regionInfo)
	{
		try
		{
			regionInfo = new RegionInfo(regionName);
		}
		catch (ArgumentException)
		{
			regionInfo = null;
			return false;
		}
		return true;
	}

	internal static RegionInfo GetRegionInfo(string regionName)
	{
		if (TryToGetRegionInfo(regionName, out var regionInfo))
		{
			return regionInfo;
		}
		return RegionInfo.CurrentRegion;
	}

	internal static TResourceClass GetResource<TResourceClass, THelper>(CultureInfo culture) where TResourceClass : class where THelper : class, IResourceHelper<TResourceClass>, new()
	{
		if (!cache.TryGetValue(typeof(TResourceClass), out var value))
		{
			value = new Dictionary<CultureInfo, object>();
			cache[typeof(TResourceClass)] = value;
		}
		if (!value.TryGetValue(culture, out var value2))
		{
			THelper val = new THelper();
			TResourceClass val2 = val.CreateResource();
			val.SetResourceCulture(val2, culture);
			value[culture] = val2;
			value2 = val2;
		}
		return value2 as TResourceClass;
	}
}
