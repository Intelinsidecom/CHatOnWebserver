using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using ChatON_WoA.DataModel;
using ChatON_WoA.InfraStructure;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using com.sec.ssm.common;
using Windows.UI.Popups;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.ViewModels;

public class NewUpdatesPageViewModel : NotificationObject
{
	private ObservableCollection<NewUpdate> _listOfNewUpdate;

	public NewUpdate _selectedNewUpdate;

	private SSMService _ssmService;

	private DataService _dataService;

	private NewUpdatesPage _page;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private TrunkService _trunkService;

	private List<NewUpdate> _tempNewUpdateList;

	private int _countAlltempNewUpdateList;

	private string _sessionID = "";

	private string _Buddyname = "";

	private string _IsHasMore = "false";

	public bool _isLoading;

	public bool _isTapped;

	public ObservableCollection<NewUpdate> ListOfNewUpdate
	{
		get
		{
			return _listOfNewUpdate;
		}
		set
		{
			_listOfNewUpdate = value;
			NotifyPropertyChanged("ListOfNewUpdate");
		}
	}

	public NewUpdate SelectedNewUpdate
	{
		get
		{
			return _selectedNewUpdate;
		}
		set
		{
			_selectedNewUpdate = value;
		}
	}

	public NewUpdatesPageViewModel(NewUpdatesPage page)
	{
		ListOfNewUpdate = new ObservableCollection<NewUpdate>();
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		_trunkService = new TrunkService(_dataService);
		_ssmService.NewUpdateCompleted += _ssmService_NewUpdateCompleted;
		_page = page;
		_tempNewUpdateList = new List<NewUpdate>();
		_ssmService.GetNewUpdateListAsync(Utility.GetTimeStamp());
	}

	private async void _ssmService_NewUpdateCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		_ = _dataService.BuddyItems;
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			UpdatesResponse result = XMLSerializer.Deserialize<UpdatesResponse>(e.Xml.ToString());
			if (result != null)
			{
				if (result.hasmore != null)
				{
					_IsHasMore = result.hasmore;
				}
				if (result.newupdate != null && result.newupdate.Count > 0)
				{
					foreach (NewUpdate i in result.newupdate)
					{
						BitmapImage image = await Utility.LoadImage("thumb_" + i.sender.buddy.id + ".jpg", "Cache");
						if (image != null)
						{
							if (((BitmapSource)image).PixelHeight == 0)
							{
								i.thumbProfile = new BitmapImage(_ssmService.GetBuddyProfileImageUri(i.sender.buddy.id));
							}
							else
							{
								i.thumbProfile = image;
							}
						}
						else
						{
							i.thumbProfile = new BitmapImage(_ssmService.GetBuddyProfileImageUri(i.sender.buddy.id));
						}
						_tempNewUpdateList.Add(i);
					}
					if (_tempNewUpdateList.Count > _countAlltempNewUpdateList)
					{
						_countAlltempNewUpdateList = _tempNewUpdateList.Count;
						LoadMoreNewUpdate();
					}
				}
				else if (result.newupdate != null)
				{
					_page.ShowNoList();
				}
			}
		}
		else if (e.StatusCode == HttpStatusCode.NoContent)
		{
			_page.ShowNoList();
		}
		else
		{
			try
			{
				await SSMService.ShowCommonErrorMessage(e);
				_page.ShowNoList();
			}
			catch (Exception)
			{
			}
		}
		_isLoading = false;
	}

	public void OnLoaded()
	{
	}

	public void OnNavigatedTo(NavigationEventArgs e)
	{
	}

	public NewUpdate NavigationPage(int index)
	{
		_isTapped = true;
		return ListOfNewUpdate.ToArray()[index];
	}

	public void StartChat(NewUpdate newUpdate)
	{
		_ssmService.GetUpdateBuddyCompleted += _ssmService_GetUpdateBuddyCompleted;
		_ssmService.GetBuddyProfileAsync(newUpdate.sender.buddy.id);
		_Buddyname = newUpdate.sender.buddy.name;
	}

	private async void _ssmService_GetUpdateBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			string value = e.Xml.Element("buddy").Value;
			if (value != null)
			{
				Chat chat = _chatService.StartChat(disconnect: false, value, value, ChatType.SINGLE);
				PivotPage.ActiveInstance.OpenChat(chat);
				((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(PivotPage));
			}
		}
		else if (e.StatusCode != HttpStatusCode.NoContent)
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			MessageDialog dialog = new MessageDialog(Utility.sprintf(Utility.GetResourceString("toast_deleted_account"), _Buddyname));
			await dialog.ShowAsync();
		}
		_isTapped = false;
	}

	public void OpenTrunkItemPage(NewUpdate newUpdate)
	{
		_ssmService.GetTrunkItemCompleted += _ssmService_GetTrunkItemCompleted;
		string[] array = newUpdate.url_scheme.Split('?')[1].Split('&');
		_sessionID = array[0].Split('=')[1];
		string itemId = array[1].Split('=')[1];
		_Buddyname = newUpdate.sender.buddy.name;
		_ssmService.GetTrunkItemAsync(_sessionID, itemId);
	}

	private async void _ssmService_GetTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.GetTrunkItemCompleted -= _ssmService_GetTrunkItemCompleted;
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			Chat chat = _dataService.GetChatUsingSessionID(_sessionID);
			if (chat != null)
			{
				TrunkItem trunkItem = _trunkService.ParseTrunkItemFromXml(e.Xml, chat.ChatID);
				if (trunkItem != null)
				{
					TrunkItemParameter trunkItemParameter = new TrunkItemParameter();
					trunkItemParameter.Chat = chat;
					trunkItemParameter.Item = trunkItem;
					((Page)_page).Frame.Navigate(typeof(TrunkDetailPage), (object)trunkItemParameter);
				}
			}
			else
			{
				MessageDialog dialog = new MessageDialog(Utility.sprintf(Utility.GetResourceString("toast_deleted_account"), _Buddyname));
				await dialog.ShowAsync();
			}
		}
		else if (e.StatusCode == HttpStatusCode.NoContent)
		{
			MessageDialog dialog2 = new MessageDialog(Utility.sprintf(Utility.GetResourceString("toast_deleted_account"), _Buddyname));
			await dialog2.ShowAsync();
		}
		else if (e.ErrorMessage.Contains("CCS-86411") || e.ErrorMessage.Contains("does not exist"))
		{
			try
			{
				MessageDialog dialog3 = new MessageDialog(Utility.GetResourceString("trunk_content_deleted"));
				await dialog3.ShowAsync();
			}
			catch
			{
			}
		}
		else if (!e.ErrorMessage.Contains("CCS-00900"))
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			try
			{
				MessageDialog dialog4 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CHAT_ROOM_CLOSED"));
				await dialog4.ShowAsync();
			}
			catch
			{
			}
		}
		_isTapped = false;
	}

	internal void LoadMoreNewUpdate()
	{
		List<NewUpdate> list = (from x in _tempNewUpdateList
			where x.service != "poston"
			orderby x.created descending
			select x).ToList();
		int count = ListOfNewUpdate.Count;
		int num = list.Count - 1;
		for (int num2 = count; num2 < num && (num2 % 10 != 0 || num2 == count); num2++)
		{
			ListOfNewUpdate.Add(list[num2]);
		}
		if (_IsHasMore.ToLower() == "true" && !_isLoading && ListOfNewUpdate.Count % 10 != 0)
		{
			_isLoading = true;
			_page.ShowLoading();
			_ssmService.GetNewUpdateListAsync(long.Parse(_tempNewUpdateList[_tempNewUpdateList.Count() - 1].created) - 1);
		}
	}
}
