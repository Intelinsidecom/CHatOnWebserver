using System.Collections.ObjectModel;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.Views;

namespace ChatOn.ViewModels;

public class EditGroupPageViewModel : NotificationObject
{
	private EditGroupPage _page;

	private ObservableCollection<BuddyGroup> _groupItems;

	private DataService _dataService;

	public ObservableCollection<BuddyGroup> GroupItems
	{
		get
		{
			return _groupItems;
		}
		set
		{
			_groupItems = value;
		}
	}

	public EditGroupPageViewModel(EditGroupPage page)
	{
		_page = page;
		_dataService = new DataService();
		_groupItems = new ObservableCollection<BuddyGroup>(_dataService.BuddyGroups);
	}
}
