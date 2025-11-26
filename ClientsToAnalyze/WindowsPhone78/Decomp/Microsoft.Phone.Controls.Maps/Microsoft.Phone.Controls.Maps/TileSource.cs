using System;
using System.ComponentModel;
using System.Text.RegularExpressions;

namespace Microsoft.Phone.Controls.Maps;

public class TileSource : INotifyPropertyChanged
{
	public const string UriSchemeUriFragment = "{UriScheme}";

	public const string QuadKeyUriFragment = "{quadkey}";

	public const string SubdomainUriFragment = "{subdomain}";

	private const string InternalQuadKeyUriFragment = "{QUADKEY}";

	private const string InternalSubdomainUriFragment = "{SUBDOMAIN}";

	private string convertedUriFormat;

	private int maxX;

	private int maxY;

	private string[][] subdomainsList;

	private string uriFormat;

	public string UriFormat
	{
		get
		{
			return uriFormat;
		}
		set
		{
			if (uriFormat != value)
			{
				uriFormat = value;
				convertedUriFormat = ReplaceString(uriFormat, "{UriScheme}", "HTTP");
				convertedUriFormat = ReplaceString(convertedUriFormat, "{quadkey}", "{QUADKEY}");
				convertedUriFormat = ReplaceString(convertedUriFormat, "{subdomain}", "{SUBDOMAIN}");
				OnPropertyChanged("UriFormat");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	public TileSource()
	{
		subdomainsList = new string[2][]
		{
			new string[4] { "0", "2", "4", "6" },
			new string[4] { "1", "3", "5", "7" }
		};
		maxX = 2;
		maxY = 4;
	}

	public TileSource(string uriFormat)
		: this()
	{
		UriFormat = uriFormat;
	}

	public virtual Uri GetUri(int x, int y, int zoomLevel)
	{
		Uri result = null;
		QuadKey quadKey = new QuadKey(x, y, zoomLevel);
		if (!string.IsNullOrEmpty(convertedUriFormat) && !string.IsNullOrEmpty(quadKey.Key))
		{
			result = new Uri(convertedUriFormat.Replace("{QUADKEY}", quadKey.Key).Replace("{SUBDOMAIN}", GetSubdomain(quadKey)));
		}
		return result;
	}

	public virtual string GetSubdomain(QuadKey quadKey)
	{
		if (subdomainsList == null)
		{
			return string.Empty;
		}
		return subdomainsList[quadKey.X % maxX][quadKey.Y % maxY];
	}

	public void SetSubdomains(string[][] subdomains)
	{
		if (subdomains != null)
		{
			if (subdomains.Length == 0 || subdomains[0].Length == 0)
			{
				throw new ArgumentException(ExceptionStrings.TileSource_InvalidSubdomains_LengthMoreThan0);
			}
			int num = subdomains[0].Length;
			foreach (string[] array in subdomains)
			{
				if (array.Length != num)
				{
					throw new ArgumentException(ExceptionStrings.TileSource_InvalidSubdomains_DifferentLength);
				}
				string[] array2 = array;
				foreach (string text in array2)
				{
					if (text == null)
					{
						throw new ArgumentException(ExceptionStrings.TileSource_InvalidSubdomain_stringNull);
					}
				}
			}
			subdomainsList = subdomains;
			maxX = subdomains.Length;
			maxY = num;
		}
		else
		{
			subdomainsList = null;
		}
	}

	private static string ReplaceString(string input, string pattern, string replacement)
	{
		return Regex.Replace(input, pattern, replacement, RegexOptions.IgnoreCase);
	}

	protected void OnPropertyChanged(string propertyName)
	{
		PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
		if (propertyChanged != null)
		{
			PropertyChangedEventArgs e = new PropertyChangedEventArgs(propertyName);
			propertyChanged(this, e);
		}
	}
}
