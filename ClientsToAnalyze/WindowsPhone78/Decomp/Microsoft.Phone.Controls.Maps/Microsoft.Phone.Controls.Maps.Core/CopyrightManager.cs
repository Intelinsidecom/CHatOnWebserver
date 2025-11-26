using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Device.Location;
using System.Globalization;
using System.Net.NetworkInformation;
using Microsoft.Phone.Controls.Maps.PlatformServices;

namespace Microsoft.Phone.Controls.Maps.Core;

public class CopyrightManager
{
	private static CopyrightManager instance;

	private static readonly Dictionary<CultureInfo, string> defaultCopyrightCache = new Dictionary<CultureInfo, string>();

	private readonly Dictionary<CopyrightKey, List<CopyrightRequestState>> fetching = new Dictionary<CopyrightKey, List<CopyrightRequestState>>(new CopyrightKeyComparer());

	private readonly Dictionary<CopyrightKey, Collection<ImageryProvider>> imageryProviders = new Dictionary<CopyrightKey, Collection<ImageryProvider>>(new CopyrightKeyComparer());

	private readonly TimeSpan minimumRetryInterval = new TimeSpan(0, 2, 0);

	private readonly Dictionary<CopyrightKey, BadFetchState> retryFailedFetchAt = new Dictionary<CopyrightKey, BadFetchState>(new CopyrightKeyComparer());

	private ImageryServiceClient client;

	private ImageryServiceClient Client => client;

	private CopyrightManager()
	{
		MapConfiguration.GetSection("v1", "WP7SLMapControl", null, AsynchronousConfigurationLoaded);
	}

	private void AsynchronousConfigurationLoaded(MapConfigurationSection config, object userState)
	{
		if (config != null && config.Contains("ImageryServiceUri"))
		{
			client = WebServicesUtility.CreateImageryServiceClient(config["ImageryServiceUri"]);
			client.GetImageryMetadataCompleted += clientGetImageryMetadataCompleted;
		}
	}

	public static CopyrightManager GetInstance()
	{
		if (instance == null)
		{
			instance = new CopyrightManager();
		}
		return instance;
	}

	internal static CopyrightManager GetCleanInstance()
	{
		return new CopyrightManager();
	}

	private static string DefaultCopyright(CultureInfo culture)
	{
		if (!defaultCopyrightCache.ContainsKey(culture))
		{
			string value = string.Format(culture, CoreResources.DefaultCopyright, DateTime.Now.Year);
			defaultCopyrightCache[culture] = value;
		}
		return defaultCopyrightCache[culture];
	}

	private IList<string> GetCopyrightStrings(CopyrightKey copyrightKey, GeoCoordinate location, double zoomLevel)
	{
		List<string> list = new List<string>();
		List<string> list2 = new List<string>();
		Collection<ImageryProvider> collection = (imageryProviders.ContainsKey(copyrightKey) ? imageryProviders[copyrightKey] : null);
		if (collection == null)
		{
			list.Add(DefaultCopyright(copyrightKey.Culture));
		}
		else
		{
			int num = (int)Math.Round(zoomLevel);
			foreach (ImageryProvider item in collection)
			{
				foreach (CoverageArea coverageArea in item.CoverageAreas)
				{
					RangeOfint zoomRange = coverageArea.ZoomRange;
					if (zoomRange.From > num || num > zoomRange.To)
					{
						continue;
					}
					Rectangle boundingRectangle = coverageArea.BoundingRectangle;
					if (boundingRectangle.Southwest.Latitude <= location.Latitude && location.Latitude <= boundingRectangle.Northeast.Latitude && boundingRectangle.Southwest.Longitude <= location.Longitude && location.Longitude <= boundingRectangle.Northeast.Longitude)
					{
						if (item.Attribution[0] == '©')
						{
							list.Add(item.Attribution);
						}
						else
						{
							list2.Add(item.Attribution);
						}
						break;
					}
				}
			}
		}
		list.AddRange(list2);
		return list;
	}

	private void SetFetchFailed(CopyrightKey copyrightKey, CopyrightRequestState requestState, bool failed)
	{
		if (failed)
		{
			retryFailedFetchAt[copyrightKey] = new BadFetchState(DateTime.Now + minimumRetryInterval, requestState.Credentials, requestState.Location);
		}
		else if (retryFailedFetchAt.ContainsKey(copyrightKey))
		{
			retryFailedFetchAt.Remove(copyrightKey);
		}
	}

	private bool ReadyToFetch(CopyrightKey copyrightKey, CopyrightRequestState requestState)
	{
		if (Client == null)
		{
			return false;
		}
		if (!retryFailedFetchAt.ContainsKey(copyrightKey))
		{
			return true;
		}
		BadFetchState badFetchState = retryFailedFetchAt[copyrightKey];
		if (!(DateTime.Now >= badFetchState.TryAgainAt))
		{
			return requestState.Credentials != badFetchState.CredentialsLastUsed;
		}
		return true;
	}

	internal void RequestCopyrightString(MapStyle style, GeoCoordinate location, double zoomLevel, CredentialsProvider credentialsProvider, CultureInfo culture, Action<CopyrightResult> copyrightCallback)
	{
		if (credentialsProvider != null)
		{
			credentialsProvider.GetCredentials(delegate(Credentials credentials2)
			{
				RequestCopyrightString(style, location, zoomLevel, credentials2, culture, copyrightCallback);
			});
		}
		else
		{
			Credentials credentials = null;
			RequestCopyrightString(style, location, zoomLevel, credentials, culture, copyrightCallback);
		}
	}

	private void RequestCopyrightString(MapStyle style, GeoCoordinate location, double zoomLevel, Credentials credentials, CultureInfo culture, Action<CopyrightResult> copyrightCallback)
	{
		bool flag = DesignerProperties.IsInDesignTool || !NetworkInterface.GetIsNetworkAvailable();
		CopyrightKey copyrightKey = new CopyrightKey(culture, style);
		CopyrightRequestState copyrightRequestState = new CopyrightRequestState(culture, style, location, zoomLevel, credentials, copyrightCallback);
		if (flag || !ReadyToFetch(copyrightKey, copyrightRequestState))
		{
			copyrightCallback(new CopyrightResult(new List<string> { DefaultCopyright(culture) }, culture, location, zoomLevel));
			return;
		}
		if (imageryProviders.ContainsKey(copyrightKey))
		{
			copyrightCallback(new CopyrightResult(GetCopyrightStrings(copyrightKey, location, zoomLevel), culture, location, zoomLevel));
			return;
		}
		if (fetching.ContainsKey(copyrightKey))
		{
			fetching[copyrightKey].Add(copyrightRequestState);
			return;
		}
		List<CopyrightRequestState> list = new List<CopyrightRequestState>();
		list.Add(copyrightRequestState);
		fetching.Add(copyrightKey, list);
		ImageryMetadataRequest imageryMetadataRequest = new ImageryMetadataRequest();
		imageryMetadataRequest.Culture = culture.Name;
		switch (style)
		{
		case MapStyle.Aerial:
			imageryMetadataRequest.Style = Microsoft.Phone.Controls.Maps.PlatformServices.MapStyle.Aerial;
			break;
		case MapStyle.AerialWithLabels:
			imageryMetadataRequest.Style = Microsoft.Phone.Controls.Maps.PlatformServices.MapStyle.AerialWithLabels;
			break;
		default:
			imageryMetadataRequest.Style = Microsoft.Phone.Controls.Maps.PlatformServices.MapStyle.Road;
			break;
		}
		imageryMetadataRequest.Options = new ImageryMetadataOptions();
		imageryMetadataRequest.Options.ReturnImageryProviders = true;
		imageryMetadataRequest.ExecutionOptions = new ExecutionOptions();
		imageryMetadataRequest.ExecutionOptions.SuppressFaults = true;
		if (credentials != null)
		{
			imageryMetadataRequest.Credentials = new Microsoft.Phone.Controls.Maps.PlatformServices.Credentials
			{
				ApplicationId = credentials.ApplicationId
			};
		}
		Client.GetImageryMetadataAsync(imageryMetadataRequest, copyrightRequestState);
	}

	private void clientGetImageryMetadataCompleted(object sender, GetImageryMetadataCompletedEventArgs e)
	{
		bool flag = false;
		CopyrightRequestState copyrightRequestState = e.UserState as CopyrightRequestState;
		CopyrightKey copyrightKey = new CopyrightKey(copyrightRequestState.Culture, copyrightRequestState.Style);
		try
		{
			bool flag2 = e.Error == null && e.Result != null && e.Result.Results != null && e.Result.Results.Count > 0;
			SetFetchFailed(copyrightKey, copyrightRequestState, !flag2);
			if (flag2)
			{
				imageryProviders[copyrightKey] = e.Result.Results[0].ImageryProviders;
			}
			List<CopyrightRequestState> list = new List<CopyrightRequestState>(fetching[copyrightKey]);
			flag = fetching.Remove(copyrightKey);
			foreach (CopyrightRequestState item in list)
			{
				item.CopyrightCallback(new CopyrightResult(GetCopyrightStrings(copyrightKey, item.Location, item.ZoomLevel), item.Culture, item.Location, item.ZoomLevel));
			}
		}
		finally
		{
			if (!flag)
			{
				fetching.Remove(copyrightKey);
			}
		}
	}
}
