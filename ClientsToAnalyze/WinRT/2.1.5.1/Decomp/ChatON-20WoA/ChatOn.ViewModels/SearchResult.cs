using System;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class SearchResult : NotificationObject, IDisposable
{
	private bool _isEmptySearch;

	public string Name { get; set; }

	public string Status { get; set; }

	public BitmapImage ProfileImage { get; set; }

	public bool IsEmptySearch
	{
		get
		{
			return _isEmptySearch;
		}
		set
		{
			_isEmptySearch = value;
			NotifyPropertyChanged(() => IsEmptySearch);
		}
	}

	public BuddySummary BuddySummary { get; set; }

	public void Dispose()
	{
		ProfileImage = null;
		BuddySummary = null;
	}
}
