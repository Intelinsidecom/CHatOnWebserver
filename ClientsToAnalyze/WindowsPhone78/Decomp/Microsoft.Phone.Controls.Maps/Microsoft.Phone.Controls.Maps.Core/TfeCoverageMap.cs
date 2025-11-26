using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Net;
using System.Xml;

namespace Microsoft.Phone.Controls.Maps.Core;

internal sealed class TfeCoverageMap
{
	private static readonly object requestLock = new object();

	private static readonly Dictionary<Uri, TfeCoverageMap> instances = new Dictionary<Uri, TfeCoverageMap>();

	private static readonly Dictionary<Uri, Collection<TfeCoverageMapState>> requests = new Dictionary<Uri, Collection<TfeCoverageMapState>>();

	private readonly List<TfeZoomLevelRange> levelMaps;

	private readonly string mapGeneration;

	private readonly int maxTfeZoomLevel;

	private readonly int minTfeZoomLevel;

	public bool Loaded { get; private set; }

	public string MapGeneration => mapGeneration;

	public int MinZoomLevel => minTfeZoomLevel;

	public int MaxZoomLevel => maxTfeZoomLevel;

	internal TfeCoverageMap(XmlReader reader)
	{
		levelMaps = new List<TfeZoomLevelRange>();
		if (reader != null)
		{
			Loaded = TfeCoverageMapParser.Parse(reader, levelMaps, out mapGeneration, out minTfeZoomLevel, out maxTfeZoomLevel);
			if (levelMaps.Count == 0)
			{
				Loaded = false;
			}
		}
		else
		{
			Loaded = false;
		}
	}

	public static void GetInstance(Uri coverageMapUri, TfeCoverageMapCallback callback)
	{
		GetInstance(coverageMapUri, callback, null);
	}

	public static void GetInstance(Uri coverageMapUri, TfeCoverageMapCallback callback, object userState)
	{
		if (!(coverageMapUri != null) || callback == null)
		{
			return;
		}
		bool flag = false;
		TfeCoverageMap tfeCoverageMap = null;
		lock (requestLock)
		{
			if (instances.ContainsKey(coverageMapUri))
			{
				tfeCoverageMap = instances[coverageMapUri];
			}
			else
			{
				if (!requests.ContainsKey(coverageMapUri))
				{
					requests.Add(coverageMapUri, new Collection<TfeCoverageMapState>());
					flag = true;
				}
				requests[coverageMapUri].Add(new TfeCoverageMapState(callback, userState));
			}
		}
		if (tfeCoverageMap != null)
		{
			callback(tfeCoverageMap, userState);
		}
		else if (flag)
		{
			WebClient webClient = new WebClient();
			webClient.OpenReadCompleted += WebClient_OpenReadCompleted;
			webClient.OpenReadAsync(coverageMapUri, coverageMapUri);
		}
	}

	public bool Covers(QuadKey quadKey)
	{
		if (Loaded)
		{
			return GetGeneration(quadKey.Key) > 0;
		}
		return true;
	}

	public int GetMaximumZoomLevel(QuadKey quadKey)
	{
		int maximumZoom = minTfeZoomLevel;
		if (Loaded)
		{
			for (int num = levelMaps.Count - 1; num >= 0; num--)
			{
				if (levelMaps[num].MaximumZoom > maximumZoom)
				{
					int generation = levelMaps[num].GetGeneration((quadKey.ZoomLevel < levelMaps[num].MaximumZoom) ? quadKey.Key : quadKey.Key.Substring(0, levelMaps[num].MaximumZoom));
					if (generation > 0)
					{
						maximumZoom = levelMaps[num].MaximumZoom;
					}
				}
			}
		}
		return maximumZoom;
	}

	private static void WebClient_OpenReadCompleted(object sender, OpenReadCompletedEventArgs e)
	{
		Uri uri = e.UserState as Uri;
		if (!(uri != null))
		{
			return;
		}
		TfeCoverageMap tfeCoverageMap;
		if (e.Error == null && e.Result != null)
		{
			XmlReader reader = null;
			try
			{
				reader = XmlReader.Create(e.Result);
			}
			catch (XmlException)
			{
			}
			tfeCoverageMap = new TfeCoverageMap(reader);
			if (!tfeCoverageMap.Loaded)
			{
				tfeCoverageMap = null;
			}
		}
		else
		{
			tfeCoverageMap = null;
		}
		Collection<TfeCoverageMapState> collection;
		lock (requestLock)
		{
			if (tfeCoverageMap != null && !instances.ContainsKey(uri))
			{
				instances.Add(uri, tfeCoverageMap);
			}
			if (requests.ContainsKey(uri))
			{
				collection = requests[uri];
				requests.Remove(uri);
			}
			else
			{
				collection = new Collection<TfeCoverageMapState>();
			}
		}
		foreach (TfeCoverageMapState item in collection)
		{
			item.Callback(tfeCoverageMap, item.UserState);
		}
	}

	private int GetGeneration(string quadcode)
	{
		int num = -1;
		for (int i = 0; i < levelMaps.Count; i++)
		{
			num = levelMaps[i].GetGeneration(quadcode);
			if (num > 0)
			{
				break;
			}
		}
		return num;
	}
}
