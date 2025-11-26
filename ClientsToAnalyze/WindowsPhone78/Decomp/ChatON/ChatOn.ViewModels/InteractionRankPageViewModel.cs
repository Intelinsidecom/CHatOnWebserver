using System.Collections.ObjectModel;
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
using Microsoft.Phone.Shell;

namespace ChatOn.ViewModels;

public class InteractionRankPageViewModel : NotificationObject
{
	private const string CHATON_INTERACTION_RANGKING_FILENAME = "interaction.jpg";

	private InteractionRankPage _page;

	private ObservableCollection<Buddy> _rankedBuddies;

	private DataService _dataService;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private Buddy _buddyToHide;

	public ObservableCollection<Buddy> RankedBuddies
	{
		get
		{
			return _rankedBuddies;
		}
		set
		{
			_rankedBuddies = value;
			NotifyPropertyChanged(() => RankedBuddies);
		}
	}

	public InteractionRankPageViewModel(InteractionRankPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_ssmService.GetInteractionCompleted += _ssmService_GetInteractionCompleted;
		_ssmService.SetInteractionHideCompleted += _ssmService_SetInteractionHideCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
	}

	private void _ssmService_SetInteractionHideCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_buddyToHide.IsHideInteraction = true;
			_buddyToHide = null;
			RankedBuddies = _buddyService.GetRankedBuddies();
			ChatOnService.Instance.ReUpdateInteraction = true;
			RefreshApplicationBar();
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

	private void _ssmService_GetInteractionCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			if (e.Xml != null)
			{
				_buddyService.ApplyRankFromXml(e.Xml);
			}
			MakeRankedBuddies();
		}
		else if (e.StatusCode != HttpStatusCode.NoContent)
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
		RefreshApplicationBar();
	}

	internal void MakeRankedBuddies()
	{
		RankedBuddies = _buddyService.GetRankedBuddies();
		RefreshApplicationBar();
	}

	internal void ShareInteraction()
	{
		InteractionRankPage page = _page;
		WriteableBitmap writeableBitmap = new WriteableBitmap((int)page.InteractionList.ActualWidth, (int)page.InteractionList.ActualHeight);
		writeableBitmap.Render(page.InteractionList, null);
		writeableBitmap.Invalidate();
		InteractionRankShareFrame interactionRankShareFrame = new InteractionRankShareFrame();
		interactionRankShareFrame.CapturedImage.Source = writeableBitmap;
		page.LayoutRoot.Children.Add(interactionRankShareFrame);
		interactionRankShareFrame.UpdateLayout();
		writeableBitmap = new WriteableBitmap((int)interactionRankShareFrame.ActualWidth, (int)interactionRankShareFrame.ActualHeight);
		writeableBitmap.Render(interactionRankShareFrame, null);
		writeableBitmap.Invalidate();
		page.LayoutRoot.Children.Remove(interactionRankShareFrame);
		Utility.SaveToJpeg("interaction.jpg", writeableBitmap, writeableBitmap.PixelWidth, writeableBitmap.PixelHeight);
		ChatOnService.Instance.FileNameToShare = "interaction.jpg";
		PageNavigationService.OpenShareListPage((PhoneApplicationPage)(object)_page);
	}

	internal void Refresh()
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
		_ssmService.GetInteractionAsync(isForceUpdate: true);
	}

	internal void HideInteraction(Buddy buddy)
	{
		_buddyToHide = buddy;
		_ssmService.SetInteractionHideAsync(buddy.PhoneNumber, hide: true);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	private void RefreshApplicationBar()
	{
		InteractionRankPage page = _page;
		object obj = ((PhoneApplicationPage)page).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).IsEnabled = _rankedBuddies != null && _rankedBuddies.Count >= 1;
	}
}
