using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.Networking.BackgroundTransfer;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.Storage.Streams;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class TrunkItemListPageViewModel : NotificationObject
{
	private TrunkPage _page;

	private ObservableCollection<TrunkItem> _trunkItems;

	private SSMService _ssmService;

	private Chat _chat;

	private DataService _dataService;

	private TrunkService _trunkService;

	private Trunk _trunk;

	private TrunkItem _selectItem;

	private Visibility _noItemVisible;

	private Visibility _noItemVisible2;

	private Visibility _noItemTextVisible;

	private int _requestcount = 30;

	private bool _isReset;

	private bool _isLoading = true;

	private Grid loadingindicator;

	public Visibility TrunkItemNoContentVisible
	{
		get
		{
			if (!_isLoading)
			{
				if (TrunkItems != null && TrunkItems.Count != 0)
				{
					return (Visibility)1;
				}
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

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
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _noItemVisible;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_noItemVisible = value;
			NotifyPropertyChanged(() => NoItem_Visible);
		}
	}

	public Visibility NoItem_Visible2
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _noItemVisible2;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_noItemVisible2 = value;
			NotifyPropertyChanged(() => NoItem_Visible2);
		}
	}

	public Visibility NoItem_Text_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _noItemTextVisible;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_noItemTextVisible = value;
			NotifyPropertyChanged(() => NoItem_Text_Visible);
		}
	}

	public ObservableCollection<TrunkItem> TrunkItems
	{
		get
		{
			return _trunkItems;
		}
		set
		{
			_trunkItems = value;
			NotifyPropertyChanged(() => TrunkItems);
			NotifyPropertyChanged(() => TrunkItemNoContentVisible);
		}
	}

	public TrunkItemListPageViewModel(TrunkPage page, Grid grid)
	{
		_page = page;
		loadingindicator = grid;
		TrunkItems = new ObservableCollection<TrunkItem>();
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
			NoItem_Visible2 = (Visibility)1;
		}
		else
		{
			NoItem_Visible = (Visibility)1;
		}
	}

	internal void OpenTrunkList(Guid id)
	{
		Chat = _dataService.GetChat(id);
		GetItemList();
	}

	public void GetItemList()
	{
		try
		{
			_isReset = true;
			if (_chat != null)
			{
				_ssmService.GetTrunkAsync(_chat.SessionID);
			}
		}
		catch
		{
		}
	}

	public void MoveToTrunkItemPage(TrunkItem item)
	{
		if (item.iType == TrunkItem.ItemType.LoadBtn)
		{
			_ssmService.GetTrunkItemListAsync(_chat.SessionID, _requestcount + 1, TrunkItems[TrunkItems.Count - 2].TrunkItemID, TrunkItems[TrunkItems.Count - 2].Lastcmtdttm);
			return;
		}
		TrunkItemParameter trunkItemParameter = new TrunkItemParameter();
		trunkItemParameter.Chat = _chat;
		trunkItemParameter.Item = item;
		((Page)_page).Frame.Navigate(typeof(TrunkDetailPage), (object)trunkItemParameter);
	}

	private void _ssmService_GetTrunkCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				_trunk = TrunkService.ParseTrunkFromXml(e.Xml);
				_ssmService.GetTrunkItemListAsync(_chat.SessionID, 100, "0", "0");
				return;
			}
			NoItem_Visible = (Visibility)0;
			_isLoading = false;
			TrunkItems = null;
			((UIElement)loadingindicator).put_Visibility((Visibility)1);
		}
		else
		{
			ShowError(e);
		}
	}

	private async void _ssmService_GetTrunkItemListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (_isReset)
		{
			TrunkItems.Clear();
			_isReset = false;
		}
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			_isLoading = false;
			List<TrunkItem> _tempTrunkItems = new List<TrunkItem>();
			if (e.Xml != null)
			{
				Task.Factory.StartNew((Func<Task>)async delegate
				{
					((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
					{
						int num = default(int);
						_ = num;
						_ = 0;
						try
						{
							if (TrunkItems.Count != 0 && TrunkItems[TrunkItems.Count - 1].iType == TrunkItem.ItemType.LoadBtn)
							{
								TrunkItems.Remove(TrunkItems[TrunkItems.Count - 1]);
							}
							_tempTrunkItems = _trunkService.ParseTrunkItemListFromXml(e.Xml, _trunk, _tempTrunkItems);
							foreach (TrunkItem item in _tempTrunkItems)
							{
								ObservableCollection<TrunkItem> trunkItems = TrunkItems;
								Func<TrunkItem, bool> predicate = (TrunkItem p) => p.TrunkItemID == item.TrunkItemID;
								if (trunkItems.Where(predicate).Count() == 0)
								{
									TrunkItems.Add(item);
								}
							}
							ChatOnService.Instance.TrunkItems = TrunkItems.ToList();
							await UpdateList();
							DownloadAllTrunkItem();
							NotifyPropertyChanged("");
						}
						catch
						{
						}
					});
				});
			}
		}
		else
		{
			ShowError(e);
		}
		((UIElement)loadingindicator).put_Visibility((Visibility)1);
	}

	private async Task UpdateList()
	{
		int photoCount = 0;
		int videoCount = 0;
		Chat.UnreadTrunkMessageCount = 0;
		foreach (TrunkItem item in TrunkItems)
		{
			if (item.Unreadcmtcnt != 0)
			{
				Chat.UnreadTrunkMessageCount++;
			}
			if (item.iType == TrunkItem.ItemType.Image)
			{
				photoCount++;
				item.IsDownloading = false;
				item.TrunkThumbImg = await Utility.LoadOrSaveWebImage("thumb_" + item.CachedFileName, new Uri(item.TrunkThumbUri), Chat.ChatID.ToString());
			}
			else
			{
				if (item.iType != TrunkItem.ItemType.Video)
				{
					continue;
				}
				videoCount++;
				StorageFolder folder = await Utility.IsFolderExist(Chat.ChatID.ToString());
				if (folder == null)
				{
					continue;
				}
				StorageFile file = await Utility.IsFileExistCheck(folder, item.CachedFileName);
				if (file == null)
				{
					item.TrunkThumbImg = await Utility.LoadOrSaveWebImage("thumb_" + item.CachedFileName, new Uri(item.TrunkThumbUri), Chat.ChatID.ToString());
					continue;
				}
				try
				{
					StorageItemThumbnail thumbnail = await file.GetThumbnailAsync((ThumbnailMode)1);
					item.IsDownloading = false;
					BitmapImage img = new BitmapImage();
					((BitmapSource)img).SetSource((IRandomAccessStream)(object)thumbnail);
					item.TrunkThumbImg = img;
				}
				catch
				{
				}
			}
		}
		if (TrunkItems.Count == 0)
		{
			if (Utility.IsDarkTheme())
			{
				NoItem_Visible = (Visibility)0;
			}
			else
			{
				NoItem_Visible2 = (Visibility)0;
			}
		}
		else
		{
			NoItem_Visible = (Visibility)1;
			NoItem_Visible2 = (Visibility)1;
			NoItem_Text_Visible = (Visibility)1;
			_page.SetTrunkDescription(photoCount, videoCount);
		}
		PivotPage.ActiveInstance.ViewModel.UpdateTrunkUnreadCount();
	}

	internal void OpenTrunkItemContexMenu(FrameworkElement element)
	{
		if ((_selectItem = element.DataContext as TrunkItem) != null)
		{
			_selectItem.Senderid.Contains("ME");
		}
	}

	private void _ssmService_DeleteTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ = e.Xml;
		GetItemList();
	}

	private void ShowError(SSMCompletedEventArgs message)
	{
		((UIElement)loadingindicator).put_Visibility((Visibility)1);
		_isLoading = false;
		SSMService.ShowCommonErrorMessage(message);
		NotifyPropertyChanged("");
	}

	private Message GetMessageFromTrunk(TrunkItem item)
	{
		Message message = _dataService.MessageItems.FirstOrDefault((Message x) => x.Type == "media" && item.CachedFileName.Trim().Contains(ExtractInfo(x.Text)));
		if (message != null)
		{
			return message;
		}
		return null;
	}

	private string ExtractInfo(string txt)
	{
		if (!txt.Contains("video") && !txt.Contains("image"))
		{
			return "no-image";
		}
		string[] array = Utility.Split(txt, '\n');
		return array[3];
	}

	private async void DownloadAllTrunkItem()
	{
		try
		{
			StorageFolder localFolder = ApplicationData.Current.LocalFolder;
			StorageFolder folder = await Utility.IsFolderExist(Chat.ChatID.ToString());
			if (folder == null)
			{
				folder = await localFolder.CreateFolderAsync(Chat.ChatID.ToString());
			}
			foreach (TrunkItem item in TrunkItems)
			{
				if (item.iType == TrunkItem.ItemType.Image)
				{
					StorageFile file = await Utility.IsFileExist(folder, item.CachedFileName);
					if (file == null)
					{
						file = await folder.CreateFileAsync(item.CachedFileName, (CreationCollisionOption)1);
						if (file == null)
						{
							break;
						}
						try
						{
							BackgroundDownloader downloader = new BackgroundDownloader();
							DownloadOperation newDownload = downloader.CreateDownload(new Uri(item.TrunkDownUri), (IStorageFile)(object)file);
							Message message = GetMessageFromTrunk(item);
							if (message != null)
							{
								string[] array = Utility.Split(file.Path, '\\');
								message.MediaFilePath = array[array.Length - 2] + "\\" + array[array.Length - 1];
								_dataService.MessageDBSubmitChanges();
							}
							await newDownload.StartAsync();
						}
						catch
						{
						}
					}
					else
					{
						Message messageFromTrunk = GetMessageFromTrunk(item);
						if (messageFromTrunk != null && messageFromTrunk.MediaFilePath.Length <= 0)
						{
							string[] array2 = Utility.Split(file.Path, '\\');
							messageFromTrunk.MediaFilePath = array2[array2.Length - 2] + "\\" + array2[array2.Length - 1];
							_dataService.MessageDBSubmitChanges();
						}
					}
				}
				else
				{
					if (item.iType != TrunkItem.ItemType.Video)
					{
						continue;
					}
					StorageFile file = await Utility.IsFileExist(folder, item.CachedFileName);
					if (file == null)
					{
						file = await folder.CreateFileAsync(item.CachedFileName, (CreationCollisionOption)1);
						if (file == null)
						{
							break;
						}
						try
						{
							BackgroundDownloader downloader2 = new BackgroundDownloader();
							DownloadOperation newDownload2 = downloader2.CreateDownload(new Uri(item.TrunkDownUri), (IStorageFile)(object)file);
							await newDownload2.StartAsync();
							Message message2 = GetMessageFromTrunk(item);
							if (message2 != null)
							{
								string[] info = Utility.Split(file.Path, '\\');
								message2.MediaFilePath = info[info.Length - 2] + "\\" + info[info.Length - 1];
								await message2.LoadVideoThumbnail();
								_dataService.MessageDBSubmitChanges();
							}
						}
						catch
						{
						}
					}
					else
					{
						Message messageFromTrunk2 = GetMessageFromTrunk(item);
						if (messageFromTrunk2 != null && messageFromTrunk2.MediaFilePath.Length <= 0)
						{
							string[] array3 = Utility.Split(file.Path, '\\');
							messageFromTrunk2.MediaFilePath = array3[array3.Length - 2] + "\\" + array3[array3.Length - 1];
							_dataService.MessageDBSubmitChanges();
						}
					}
				}
			}
		}
		catch (Exception)
		{
		}
	}
}
