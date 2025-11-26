using System;
using System.Device.Location;
using System.Globalization;
using ChatOn.GeocodeService;
using Microsoft.Phone.Controls.Maps;

namespace ChatOn.Services;

public class LocationService
{
	public delegate void EventHandler(string address);

	private Map _map;

	public event EventHandler GetReverseGeocodeCompleted;

	public LocationService()
	{
		_map = new Map();
		ApplicationIdCredentialsProvider credentialsProvider = new ApplicationIdCredentialsProvider("AgieeNvpLn79l-SzK0KiJ2bDiVY9MHQjeUnhAtFN4baWVRbTcMp5cJkKvcpar4bU");
		_map.CredentialsProvider = credentialsProvider;
	}

	public LocationService(Map map)
	{
		_map = map;
	}

	public void GetAddress(GeoCoordinate location)
	{
		GeocodeServiceClient geocodeService = new GeocodeServiceClient("BasicHttpBinding_IGeocodeService");
		geocodeService.ReverseGeocodeCompleted += ReverseGeocode_Completed;
		ReverseGeocodeRequest reverseGeocodeRequest = new ReverseGeocodeRequest();
		reverseGeocodeRequest.Location = location;
		reverseGeocodeRequest.Location.Longitude = location.Longitude;
		reverseGeocodeRequest.ExecutionOptions = new ExecutionOptions();
		reverseGeocodeRequest.ExecutionOptions.SuppressFaults = true;
		reverseGeocodeRequest.Culture = CultureInfo.CurrentCulture.Name;
		_map.CredentialsProvider.GetCredentials(delegate(Credentials credentials)
		{
			reverseGeocodeRequest.Credentials = credentials;
			geocodeService.ReverseGeocodeAsync(reverseGeocodeRequest);
		});
	}

	private void ReverseGeocode_Completed(object sender, ReverseGeocodeCompletedEventArgs e)
	{
		string address = null;
		try
		{
			if (e != null && e.Result != null && e.Result.Results.Count > 0)
			{
				Address address2 = e.Result.Results[0].Address;
				address = address2.CountryRegion;
				address += ", ";
				address = (string.IsNullOrEmpty(address2.Locality) ? (address + address2.AdminDistrict) : (address + address2.Locality));
			}
		}
		catch (Exception)
		{
			address = string.Empty;
		}
		if (this.GetReverseGeocodeCompleted != null)
		{
			this.GetReverseGeocodeCompleted(address);
		}
	}
}
