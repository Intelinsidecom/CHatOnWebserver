using System;
using System.Collections.Generic;
using System.IO.IsolatedStorage;
using System.Net;
using System.Windows;
using System.Windows.Media.Imaging;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class TrunkItemListPageViewModel : NotificationObject
{
	private TrunkItemListPage _page;

	private List<TrunkItem> _trunkItems;

	private SSMService _ssmService;

	private Chat _chat;

	private DataService _dataService;

	private TrunkService _trunkService;

	private Trunk _trunk;

	private TrunkItem _tempItem;

	private TrunkItem _selectItem;

	private Visibility _noItemVisible;

	private Visibility _noItemVisible2;

	private Visibility _noItemTextVisible;

	private int _requestcount = 30;

	private bool _isReset;

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
			NotifyPropertyChanged(() => Chat);
		}
	}

	public Visibility NoItem_Visible
	{
		get
		{
			return _noItemVisible;
		}
		set
		{
			_noItemVisible = value;
			NotifyPropertyChanged(() => NoItem_Visible);
		}
	}

	public Visibility NoItem_Visible2
	{
		get
		{
			return _noItemVisible2;
		}
		set
		{
			_noItemVisible2 = value;
			NotifyPropertyChanged(() => NoItem_Visible2);
		}
	}

	public Visibility NoItem_Text_Visible
	{
		get
		{
			return _noItemTextVisible;
		}
		set
		{
			_noItemTextVisible = value;
			NotifyPropertyChanged(() => NoItem_Text_Visible);
		}
	}

	public List<TrunkItem> TrunkItems
	{
		get
		{
			return _trunkItems;
		}
		set
		{
			_trunkItems = value;
			NotifyPropertyChanged(() => TrunkItems);
		}
	}

	public TrunkItemListPageViewModel(TrunkItemListPage page)
	{
		_page = page;
		TrunkItems = new List<TrunkItem>();
		_dataService = new DataService();
		_ssmService = new SSMService();
		_ssmService.GetTrunkCompleted += _ssmService_GetTrunkCompleted;
		_ssmService.DeleteTrunkItemCompleted += _ssmService_DeleteTrunkItemCompleted;
		_ssmService.GetTrunkItemListCompleted += _ssmService_GetTrunkItemListCompleted;
		_trunkService = new TrunkService(_dataService);
		_trunk = new Trunk();
		_selectItem = new TrunkItem();
		if (Utility.IsDarkTheme())
		{
			NoItem_Visible2 = Visibility.Collapsed;
		}
		else
		{
			NoItem_Visible = Visibility.Collapsed;
		}
	}

	internal void OpenTrunkList(Guid id)
	{
		((FrameworkElement)(object)_page).DataContext = this;
		Chat = _dataService.GetChat(id);
		if (!_dataService.isLoadTrunk())
		{
			_dataService.LoadTrunk();
		}
		TrunkItems = _trunkService.CacheListLoad(_chat.SessionID);
		if (TrunkItems.Count == 0)
		{
			if (Utility.IsDarkTheme())
			{
				NoItem_Visible = Visibility.Visible;
			}
			else
			{
				NoItem_Visible2 = Visibility.Visible;
			}
		}
		else
		{
			NoItem_Visible = Visibility.Collapsed;
			NoItem_Visible2 = Visibility.Collapsed;
			NoItem_Text_Visible = Visibility.Collapsed;
		}
		GetItemList();
	}

	internal void OnNavigatedTo()
	{
		if (!IsolatedStorageSettings.ApplicationSettings.Contains("LoadTrunkList"))
		{
			IsolatedStorageSettings.ApplicationSettings.Add("LoadTrunkList", 0);
			IsolatedStorageSettings.ApplicationSettings.Save();
		}
		if ((int)IsolatedStorageSettings.ApplicationSettings["LoadTrunkList"] == 1)
		{
			IsolatedStorageSettings.ApplicationSettings["LoadTrunkList"] = 0;
			IsolatedStorageSettings.ApplicationSettings.Save();
			GetItemList();
		}
	}

	public void GetItemList()
	{
		_isReset = true;
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
		_ssmService.GetTrunkAsync(_chat.SessionID);
	}

	public void MoveToTrunkItemPage(TrunkItem item)
	{
		if (item.iType == TrunkItem.ItemType.LoadBtn)
		{
			Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
			item.TrunkThumbImg = new BitmapImage(new Uri("/Images/icon_loading.png", UriKind.Relative));
			_ssmService.GetTrunkItemListAsync(_chat.SessionID, _requestcount + 1, TrunkItems[TrunkItems.Count - 2].TrunkItemID, TrunkItems[TrunkItems.Count - 2].Lastcmtdttm);
		}
		else
		{
			PageNavigationService.OpenTrunkItem(item, _chat, (PhoneApplicationPage)(object)_page);
		}
	}

	public void MoveToTrunkSort()
	{
		PageNavigationService.OpenTrunkSort((PhoneApplicationPage)(object)_page);
	}

	private void _ssmService_GetTrunkCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				_trunk = TrunkService.ParseTrunkFromXml(e.Xml);
				if (IsolatedStorageSettings.ApplicationSettings.Contains("TrunkSort"))
				{
					if ((int)IsolatedStorageSettings.ApplicationSettings["TrunkSort"] == 0)
					{
						_ssmService.GetTrunkItemListAsync(_chat.SessionID, 100, "0", "0");
					}
					else if ((int)IsolatedStorageSettings.ApplicationSettings["TrunkSort"] == 1)
					{
						_ssmService.GetTrunkItemListAsync(_chat.SessionID, _requestcount, "0", "0");
					}
				}
				else
				{
					IsolatedStorageSettings.ApplicationSettings.Add("TrunkSort", 0);
					IsolatedStorageSettings.ApplicationSettings.Save();
					_ssmService.GetTrunkItemListAsync(_chat.SessionID, 100, "0", "0");
				}
			}
			else
			{
				Utility.HideSystemTrayProgress((PhoneApplicationPage)(object)_page, HideProgressOnly: true);
			}
		}
		else
		{
			if (string.IsNullOrEmpty(e.ErrorMessage))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			}
			else if (e.ErrorMessage.Contains("CCS-00012"))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
			}
			Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
		}
	}

	private void _ssmService_GetTrunkItemListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (_isReset)
		{
			TrunkItems.Clear();
			_isReset = false;
			_dataService.resetTrunkList(_chat.SessionID);
		}
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				if (TrunkItems.Count != 0 && TrunkItems[TrunkItems.Count - 1].iType == TrunkItem.ItemType.LoadBtn)
				{
					TrunkItems.Remove(TrunkItems[TrunkItems.Count - 1]);
				}
				TrunkItems = _trunkService.ParseTrunkItemListFromXml(e.Xml, _chat.SessionID, _trunk, TrunkItems);
				Chat.UnreadTrunkMessageCount = 0;
				foreach (TrunkItem trunkItem in TrunkItems)
				{
					if (Convert.ToInt16(trunkItem.Unreadcmtcnt) != 0)
					{
						Chat.UnreadTrunkMessageCount++;
					}
				}
				if (TrunkItems.Count == 0)
				{
					if (Utility.IsDarkTheme())
					{
						NoItem_Visible = Visibility.Visible;
					}
					else
					{
						NoItem_Visible2 = Visibility.Visible;
					}
				}
				else
				{
					NoItem_Visible = Visibility.Collapsed;
					NoItem_Visible2 = Visibility.Collapsed;
					NoItem_Text_Visible = Visibility.Collapsed;
				}
			}
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
		else if (e.ErrorMessage.Contains("CCS-80900"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, "");
		Utility.HideSystemTrayProgress((PhoneApplicationPage)(object)_page, HideProgressOnly: true);
	}

	internal void OpenTrunkItemContexMenu(FrameworkElement element)
	{
		_selectItem = element.DataContext as TrunkItem;
		if (_selectItem.Senderid.Contains("ME"))
		{
			LightContextMenu lightContextMenu = new LightContextMenu();
			LightMenuItem lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_DELETE_ABB);
			lightMenuItem.OnExecute += deleteMenu_OnExecute;
			lightMenuItem.Tag = _selectItem;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			lightContextMenu.Open((PhoneApplicationPage)(object)_page, _page.LayoutRoot, element);
		}
	}

	private void deleteMenu_OnExecute(object sender, EventArgs e)
	{
		if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_DELETE_Q, ResContainer.IDS_CHATON_OPT_DELETE_ABB, MessageBoxButton.OKCancel))
		{
			Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
			if (_selectItem.Senderid.Contains("ME"))
			{
				_ssmService.DeleteTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
			}
		}
	}

	private void _ssmService_DeleteTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ = e.Xml;
		GetItemList();
	}
}
