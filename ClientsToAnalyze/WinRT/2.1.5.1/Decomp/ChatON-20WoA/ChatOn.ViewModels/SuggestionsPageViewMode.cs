using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class SuggestionsPageViewMode : NotificationObject
{
	private SuggestionsPage _page;

	private SSMService _ssmService;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private DataService _dataService;

	private ObservableCollection<UnknownUser> _buddyItems;

	private ObservableCollection<UnknownUser> _tempItems;

	private UnknownUser _buddyToAdd;

	private UnknownUser _buddyToDelete;

	private DispatcherTimer _timer;

	private bool _isModifyActionEnable;

	private bool _ignoreAllRunning;

	private bool _addAllRunning;

	private IList<XElement> indexedElements;

	public ObservableCollection<UnknownUser> BuddyItems
	{
		get
		{
			return _buddyItems;
		}
		set
		{
			_buddyItems = value;
			NotifyPropertyChanged(() => BuddyItems);
		}
	}

	public bool IsModifyActionEnable
	{
		get
		{
			return _isModifyActionEnable;
		}
		set
		{
			_isModifyActionEnable = value;
			NotifyPropertyChanged(() => IsModifyActionEnable);
		}
	}

	public SuggestionsPageViewMode(SuggestionsPage page)
	{
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Expected O, but got Unknown
		_page = page;
		_tempItems = new ObservableCollection<UnknownUser>();
		_buddyItems = new ObservableCollection<UnknownUser>();
		_ssmService = new SSMService();
		_ssmService.AddBuddyCompleted += _ssmService_AddBuddyCompleted;
		_ssmService.GetBuddyRecommendListCompleted += _ssmService_GetBuddyRecommendListCompleted;
		_ssmService.GetUserPrivacyCompleted += _ssmService_GetUserPrivacyCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		_timer = new DispatcherTimer();
		_timer.put_Interval(TimeSpan.FromMilliseconds(40.0));
		_page.ShowLoading();
		_ssmService.GetUserPrivacyAsync("recommendationbuddy");
	}

	private async void _ssmService_GetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.NoContent)
		{
			return;
		}
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			XElement xElement = e.Xml.Element("value");
			if (bool.Parse(xElement.Value))
			{
				_ssmService.GetBuddyRecommendListAsync();
				return;
			}
			PivotPage.ActiveInstance.SetSuggestionsCount(0);
			_page.ShowNoList();
			LoadingIndicator.StopLoading();
		}
		else
		{
			LoadingIndicator.StopLoading();
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void _timer_Tick(object sender, object e)
	{
		if (_tempItems.Count > 0)
		{
			UnknownUser item = _tempItems.First();
			if (!_buddyItems.Contains(item))
			{
				_buddyItems.Add(item);
			}
			_tempItems.Remove(item);
		}
		else
		{
			_timer.Stop();
		}
	}

	private async void _ssmService_GetBuddyRecommendListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			List<UnknownUser> result = await _buddyService.ParseRecommendBuddyFromXml(e.Xml, downloadImage: true);
			LoadingIndicator.StopLoading();
			foreach (UnknownUser item2 in result)
			{
				_buddyItems.Add(item2);
			}
			IsModifyActionEnable = BuddyItems.Any();
			using IEnumerator<UnknownUser> enumerator2 = _buddyItems.GetEnumerator();
			while (enumerator2.MoveNext())
			{
				DispatchedHandler val = null;
				UnknownUser item = enumerator2.Current;
				CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
				if (val == null)
				{
					val = (DispatchedHandler)delegate
					{
						UpdateList(item);
					};
				}
				await dispatcher.RunAsync((CoreDispatcherPriority)0, val);
			}
			return;
		}
		if (e.StatusCode == HttpStatusCode.NoContent)
		{
			LoadingIndicator.StopLoading();
			_page.ShowNoList();
		}
		else
		{
			LoadingIndicator.StopLoading();
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	private async void _ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			LoadingIndicator.StopLoading();
		});
		string param = e.Param as string;
		string newBuddiesName = string.Empty;
		if (!string.IsNullOrEmpty(param))
		{
			if (await BuddyService.ShowAddBuddyResult(e, param))
			{
				ChatOnService.Instance.IsBuddiesUpdated = true;
				List<Buddy> newBuddies = _buddyService.AddBuddyFromXml(e.Xml);
				if (newBuddies.Count > 0)
				{
					foreach (Buddy buddy in newBuddies)
					{
						buddy.LoadProfileImage(_ssmService.GetBuddyProfileImageUri(buddy.PhoneNumber));
						IEnumerable<UnknownUser> unknownUserItems = _dataService.UnknownUserItems;
						Func<UnknownUser, bool> predicate = (UnknownUser p) => p.PhoneNumber == buddy.PhoneNumber;
						UnknownUser user = unknownUserItems.Where(predicate).FirstOrDefault();
						if (user != null)
						{
							ChatOnService.Instance.RecommendeeItems.Remove(user);
							_dataService.DeleteRecommendee(user);
						}
						else
						{
							user = new UnknownUser(buddy.Name, buddy.PhoneNumber);
							_dataService.DeleteRecommendee(user);
						}
						UnknownUser deletedBuddy = BuddyItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == buddy.PhoneNumber);
						BuddyItems.Remove(deletedBuddy);
						ChatOnService.Instance.RecommendeeItems.Remove(user);
						_dataService.DeleteRecommendee(user);
						newBuddiesName = newBuddiesName + "; " + buddy.Name;
						StorageFile file = await Utility.IsFileExist("suggestion", "thumb_" + buddy.PhoneNumber + ".jpg");
						if (file != null)
						{
							await file.DeleteAsync();
						}
					}
				}
				_dataService.RecommendeeDBSubmitChanges();
				newBuddiesName = newBuddiesName.TrimStart(';');
				PivotPage.ActiveInstance.SetSuggestionsCount(_buddyItems.Count);
				ChatOnService.Instance.IsRecommendeeUpdated = true;
				PivotPage.ActiveInstance.ViewModel.UpdateList(skipLaunchArgs: true);
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED").Replace("%s", newBuddiesName.Trim()));
			}
		}
		else if (await BuddyService.ShowAddBuddyResult(e, _buddyToAdd.PhoneNumber))
		{
			ChatOnService.Instance.IsBuddiesUpdated = true;
			List<Buddy> newBuddies2 = _buddyService.AddBuddyFromXml(e.Xml);
			foreach (Buddy buddy2 in newBuddies2)
			{
				await buddy2.LoadProfileImage(_ssmService.GetBuddyProfileImageUri(buddy2.PhoneNumber));
				newBuddiesName = newBuddiesName + "; " + buddy2.Name;
				IEnumerable<UnknownUser> recommendeeItems = _dataService.RecommendeeItems;
				Func<UnknownUser, bool> predicate2 = (UnknownUser x) => x.PhoneNumber == buddy2.PhoneNumber;
				UnknownUser deleted = recommendeeItems.FirstOrDefault(predicate2);
				_dataService.DeleteRecommendee(deleted);
				UnknownUser deletedBuddy2 = BuddyItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == buddy2.PhoneNumber);
				BuddyItems.Remove(deletedBuddy2);
				ChatOnService.Instance.RecommendeeItems.Remove(deleted);
				StorageFile file2 = await Utility.IsFileExist("suggestion", "thumb_" + buddy2.PhoneNumber + ".jpg");
				if (file2 != null)
				{
					await file2.DeleteAsync();
				}
			}
			newBuddiesName = newBuddiesName.TrimStart(';');
			_dataService.RecommendeeDBSubmitChanges();
			ChatOnService.Instance.IsRecommendeeUpdated = true;
			PivotPage.ActiveInstance.SetSuggestionsCount(_buddyItems.Count);
			PivotPage.ActiveInstance.ViewModel.UpdateList(skipLaunchArgs: true);
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED").Replace("%s", newBuddiesName.Trim()));
		}
		IsModifyActionEnable = BuddyItems.Any();
		HandleGoBackIfAddAllRunning();
	}

	private void HandleGoBackIfAddAllRunning()
	{
		if (_addAllRunning)
		{
			_addAllRunning = false;
			_page.GoBack();
		}
	}

	internal void AddBuddy(UnknownUser buddy)
	{
		_buddyToAdd = buddy;
		_page.ShowLoading(Utility.GetResourceString("IDS_CHATON_BODY_LOADING_ING"));
		_ssmService.AddBuddyAsync("+" + buddy.PhoneNumber);
	}

	internal void AddAllBuddy()
	{
		string text = "";
		List<string> list = new List<string>();
		foreach (UnknownUser buddyItem in _buddyItems)
		{
			if (!string.IsNullOrEmpty(text))
			{
				text += ", ";
			}
			text += buddyItem.Name;
			list.Add(buddyItem.PhoneNumber);
		}
		if (list.Count() > 0)
		{
			string newValue = text;
			string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q");
			resourceString = resourceString.Replace("%s", newValue);
			newValue = resourceString;
			Utility.ShowSimpleToastNotification("All buddies are added to my buddies list");
			_page.ShowLoading();
			_ssmService.AddBuddyAsync(list, text);
			_addAllRunning = true;
		}
	}

	internal void IgnoreAllBuddy()
	{
		string text = "";
		List<string> list = new List<string>();
		foreach (UnknownUser buddyItem in _buddyItems)
		{
			if (!string.IsNullOrEmpty(text))
			{
				text += ", ";
			}
			text += buddyItem.Name;
			list.Add(buddyItem.PhoneNumber);
		}
		if (list.Any())
		{
			string newValue = text;
			string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q");
			resourceString = resourceString.Replace("%s", newValue);
			newValue = resourceString;
			_ssmService.UploadBuddyRecommendIgnoreListCompleted += _ssmService_UploadBuddyRecommendIgnoreListMemberCompleted;
			_page.ShowLoading();
			_ssmService.UploadBuddyRecommendIgnoreListAsync(list);
			_ignoreAllRunning = true;
		}
	}

	internal void RemoveRecomendee(UnknownUser buddy)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			_ssmService.UploadBuddyRecommendIgnoreListCompleted += _ssmService_UploadBuddyRecommendIgnoreListCompleted;
			_buddyToDelete = buddy;
			_ssmService.UploadBuddyRecommendIgnoreListAsync(_buddyToDelete.PhoneNumber);
			_dataService.DeleteRecommendee(_buddyToDelete);
			_dataService.RecommendeeDBSubmitChanges();
			_buddyItems.Remove(_buddyToDelete);
			IsModifyActionEnable = BuddyItems.Any();
			NotifyPropertyChanged(() => BuddyItems);
			PivotPage.ActiveInstance.SetSuggestionsCount(_buddyItems.Count);
			StorageFile file = await Utility.IsFileExist("suggestion", "thumb_" + buddy.PhoneNumber + ".jpg");
			if (file != null)
			{
				await file.DeleteAsync();
			}
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_DELETED"));
			await dialog.ShowAsync();
		});
	}

	private void _ssmService_UploadBuddyRecommendIgnoreListCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.UploadBuddyRecommendIgnoreListCompleted -= _ssmService_UploadBuddyRecommendIgnoreListCompleted;
	}

	private async void _ssmService_UploadBuddyRecommendIgnoreListMemberCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.UploadBuddyRecommendIgnoreListCompleted -= _ssmService_UploadBuddyRecommendIgnoreListMemberCompleted;
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			foreach (UnknownUser buddy in _buddyItems)
			{
				_dataService.DeleteRecommendee(buddy);
				StorageFile file = await Utility.IsFileExist("suggestion", "thumb_" + buddy.PhoneNumber + ".jpg");
				if (file != null)
				{
					await file.DeleteAsync();
				}
			}
			_buddyItems.Clear();
			IsModifyActionEnable = BuddyItems.Any();
			NotifyPropertyChanged(() => BuddyItems);
			PivotPage.ActiveInstance.ViewModel.UpdateSuggestionsCount(_buddyItems.Count);
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_DELETED"));
			await dialog.ShowAsync();
		}
		else
		{
			_ignoreAllRunning = false;
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	private async Task LoadLocalImage(UnknownUser item)
	{
		try
		{
			UnknownUser buddy = BuddyItems.Where((UnknownUser x) => x.PhoneNumber == item.PhoneNumber).FirstOrDefault();
			BitmapImage img = new BitmapImage(new Uri("ms-appx:///Images/buddies_profile_image.png"));
			StorageFile file = await Utility.IsFileExist("suggestion", "thumb_" + item.PhoneNumber + ".jpg");
			if (file != null)
			{
				IRandomAccessStream fs = await file.OpenAsync((FileAccessMode)0);
				if (fs != null && fs.Size != 0)
				{
					((BitmapSource)img).SetSource(fs);
				}
			}
			buddy.ProfileImage = img;
			Task.Factory.StartNew((Func<Task>)async delegate
			{
				await ((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
				{
					UpdateList(item);
				});
			});
		}
		catch
		{
		}
	}

	private async Task UpdateList(UnknownUser item)
	{
		try
		{
			UnknownUser buddy = BuddyItems.Where((UnknownUser x) => x.PhoneNumber == item.PhoneNumber).FirstOrDefault();
			BitmapImage img = await Utility.LoadOrSaveWebImage("thumb_" + item.PhoneNumber + ".jpg", _ssmService.GetBuddyProfileImageUriCheck(item.PhoneNumber), "suggestion", forceUpdate: true);
			if (img != null)
			{
				buddy.ProfileImage = img;
			}
		}
		catch
		{
		}
	}
}
