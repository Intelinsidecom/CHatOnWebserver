using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Windows;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class InteractionHideListPageViewModel : NotificationObject
{
	private InteractionHideListPage _page;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private ObservableCollection<Buddy> _hideList;

	private Buddy _buddyToShow;

	public ObservableCollection<Buddy> HideList
	{
		get
		{
			return _hideList;
		}
		set
		{
			_hideList = value;
			NotifyPropertyChanged(() => HideList);
		}
	}

	public InteractionHideListPageViewModel(InteractionHideListPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_ssmService.GetInteractionHideListCompleted += _ssmService_GetInteractionHideListCompleted;
		_ssmService.SetInteractionHideCompleted += _ssmService_SetInteractionHideCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_hideList = new ObservableCollection<Buddy>();
		_ssmService.GetInteractionHideListAsync();
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	private void _ssmService_SetInteractionHideCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_buddyToShow.IsHideInteraction = false;
			_hideList.Remove(_buddyToShow);
			_buddyToShow = null;
			ChatOnService.Instance.ReUpdateInteraction = true;
			_dataService.SubmitChanges();
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	private void _ssmService_GetInteractionHideListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			_buddyService.ApplyInteractionHideListFromXml(e.Xml);
			IEnumerable<Buddy> enumerable = _dataService.BuddyItems.Where((Buddy b) => b.IsHideInteraction);
			{
				foreach (Buddy item in enumerable)
				{
					_hideList.Add(item);
				}
				return;
			}
		}
		if (e.StatusCode != HttpStatusCode.NoContent)
		{
			if (string.IsNullOrEmpty(e.ErrorMessage))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			}
			else if (e.ErrorMessage.Contains("CCS-00012"))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
			}
		}
	}

	internal void ShowBuddyInteraction(Buddy buddy)
	{
		_buddyToShow = buddy;
		_ssmService.SetInteractionHideAsync(buddy.PhoneNumber, hide: false);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}
}
