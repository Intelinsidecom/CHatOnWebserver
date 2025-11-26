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

public class BlockListPageViewModel : NotificationObject
{
	private BlockListPage _page;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private ObservableCollection<Buddy> _blockedList;

	private Buddy _buddyToUnblock;

	public ObservableCollection<Buddy> BlockedList
	{
		get
		{
			return _blockedList;
		}
		set
		{
			_blockedList = value;
			NotifyPropertyChanged(() => BlockedList);
		}
	}

	public BlockListPageViewModel(BlockListPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_ssmService.GetBlockListCompleted += _ssmService_GetBlockListCompleted;
		_ssmService.UnBlockBuddyCompleted += _ssmService_UnBlockBuddyCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		IOrderedEnumerable<Buddy> collection = from d in _dataService.BuddyItems
			where d.IsBlocked
			orderby d.Name
			select d;
		_blockedList = new ObservableCollection<Buddy>(collection);
	}

	private void _ssmService_UnBlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_blockedList.Remove(_buddyToUnblock);
			_buddyToUnblock.IsBlocked = false;
			_buddyToUnblock = null;
			_dataService.SubmitChanges();
			ChatOnService.Instance.IsBuddiesUpdated = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
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

	private void _ssmService_GetBlockListCompleted(object sender, SSMCompletedEventArgs e)
	{
	}

	internal void UnBlock(Buddy buddy)
	{
		_buddyToUnblock = buddy;
		_ssmService.UnBlockBuddyAsync(buddy.PhoneNumber);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}
}
