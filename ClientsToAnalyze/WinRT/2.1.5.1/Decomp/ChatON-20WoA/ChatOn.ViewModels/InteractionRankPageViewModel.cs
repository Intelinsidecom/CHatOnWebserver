using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.DataModel;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml;

namespace ChatOn.ViewModels;

public class InteractionRankPageViewModel : NotificationObject
{
	private const string CHATON_INTERACTION_RANGKING_FILENAME = "interaction.jpg";

	private InteractionRankPage _page;

	private ObservableCollection<InteractionRank> _rankedBuddies;

	private ObservableCollection<InteractionRank> _largeRankedBuddies;

	private DataService _dataService;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private InteractionRank _interactionToHide;

	private ObservableCollection<InteractionRank> _thisWeekRankedBuddies = new ObservableCollection<InteractionRank>();

	private ObservableCollection<InteractionRank> _lastWeekRankedBuddies = new ObservableCollection<InteractionRank>();

	private ObservableCollection<InteractionRank> _lastTwoWeekRankedBuddies = new ObservableCollection<InteractionRank>();

	private ObservableCollection<InteractionRank> _lastThreeWeekRankedBuddies = new ObservableCollection<InteractionRank>();

	private DispatcherTimer _timer;

	private bool _loadStillPerformed;

	private int _selectedIndex;

	private int _week;

	private Queue<InteractionRank> _thisWeekTempQueue = new Queue<InteractionRank>();

	private Queue<InteractionRank> _lastWeekTempQueue = new Queue<InteractionRank>();

	private Queue<InteractionRank> _lastTwoWeekTempQueue = new Queue<InteractionRank>();

	private Queue<InteractionRank> _lastThreeWeekTempQueue = new Queue<InteractionRank>();

	public int SelectedIndex
	{
		get
		{
			return _selectedIndex;
		}
		set
		{
			_selectedIndex = value;
			NotifyPropertyChanged(() => SelectedIndex);
		}
	}

	public ObservableCollection<InteractionRank> RankedBuddies
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

	public ObservableCollection<InteractionRank> LargeRankedBuddies
	{
		get
		{
			return _largeRankedBuddies;
		}
		set
		{
			_largeRankedBuddies = value;
			NotifyPropertyChanged(() => LargeRankedBuddies);
		}
	}

	public ObservableCollection<InteractionRank> ThisWeekRankedBuddies
	{
		get
		{
			return _thisWeekRankedBuddies;
		}
		set
		{
			_thisWeekRankedBuddies = value;
			NotifyPropertyChanged(() => ThisWeekRankedBuddies);
		}
	}

	public ObservableCollection<InteractionRank> LastWeekRankedBuddies
	{
		get
		{
			return _lastWeekRankedBuddies;
		}
		set
		{
			_lastWeekRankedBuddies = value;
			NotifyPropertyChanged(() => LastWeekRankedBuddies);
		}
	}

	public ObservableCollection<InteractionRank> LastTwoWeekRankedBuddies
	{
		get
		{
			return _lastTwoWeekRankedBuddies;
		}
		set
		{
			_lastTwoWeekRankedBuddies = value;
			NotifyPropertyChanged(() => LastTwoWeekRankedBuddies);
		}
	}

	public ObservableCollection<InteractionRank> LastThreeWeekRankedBuddies
	{
		get
		{
			return _lastThreeWeekRankedBuddies;
		}
		set
		{
			_lastThreeWeekRankedBuddies = value;
			NotifyPropertyChanged(() => LastThreeWeekRankedBuddies);
		}
	}

	public Visibility NoInteractionVisibility { get; set; }

	public Visibility InteractionVisibility { get; set; }

	public unsafe InteractionRankPageViewModel(InteractionRankPage page)
	{
		//IL_00bd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c7: Expected O, but got Unknown
		_page = page;
		_ssmService = new SSMService();
		NoInteractionVisibility = (Visibility)1;
		_dataService = new DataService();
		NotifyPropertyChanged(() => NoInteractionVisibility);
		_timer = new DispatcherTimer();
		_timer.put_Interval(TimeSpan.FromMilliseconds(1.0));
		DispatcherTimer timer = _timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timer_Tick);
		_ssmService.SetInteractionHideCompleted += _ssmService_SetInteractionHideCompleted;
	}

	private async void _timer_Tick(object sender, object e)
	{
	}

	private void _ssmService_SetInteractionHideCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_interactionToHide.IsHideInteraction = true;
			_interactionToHide.Buddy.IsHideInteraction = true;
			_interactionToHide = null;
			ChatOnService.Instance.ReUpdateInteraction = true;
			RefreshApplicationBar();
			_dataService.BuddyDBSubmitChanges();
			_dataService.UnknownUserDBSubmitChanges();
			ReLoadInteration();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void ReLoadInteration()
	{
		if (ThisWeekRankedBuddies.Count > 0)
		{
			ThisWeekRankedBuddies.Clear();
		}
		if (LastWeekRankedBuddies.Count > 0)
		{
			LastWeekRankedBuddies.Clear();
		}
		if (LastTwoWeekRankedBuddies.Count > 0)
		{
			LastTwoWeekRankedBuddies.Clear();
		}
		if (LastThreeWeekRankedBuddies.Count > 0)
		{
			LastThreeWeekRankedBuddies.Clear();
		}
		LoadInteractions();
		LoadingIndicator.StopLoading();
	}

	internal void LoadInteractions()
	{
		LoadInteractionRank(1, _thisWeekTempQueue);
		LoadInteractionRank(2, _lastWeekTempQueue);
		LoadInteractionRank(3, _lastTwoWeekTempQueue);
		LoadInteractionRank(4, _lastThreeWeekTempQueue);
		ReUpdateInteractionFromServer();
	}

	internal async void LoadInteractions(int week)
	{
	}

	private ObservableCollection<InteractionRank> GetSelectedWeek(int week)
	{
		ObservableCollection<InteractionRank> observableCollection = new ObservableCollection<InteractionRank>();
		return week switch
		{
			1 => _thisWeekRankedBuddies, 
			2 => _lastWeekRankedBuddies, 
			3 => _lastTwoWeekRankedBuddies, 
			4 => _lastThreeWeekRankedBuddies, 
			_ => _thisWeekRankedBuddies, 
		};
	}

	private async void ReUpdateInteractionFromServer()
	{
		await InteractionRankService.Instance.LoadInteractionRankAsync();
	}

	private unsafe void LoadInteractionRank(int week, Queue<InteractionRank> weekInteractions)
	{
		//IL_007c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0082: Expected O, but got Unknown
		IEnumerable<InteractionRank> interactionRanks = InteractionRankService.Instance.GetInteractionRanks(week);
		ObservableCollection<InteractionRank> selectedInteractionsWeek = GetSelectedWeek(week);
		foreach (InteractionRank item2 in interactionRanks)
		{
			if (item2.Buddy != null && !item2.Buddy.IsHideInteraction)
			{
				weekInteractions.Enqueue(item2);
			}
		}
		DispatcherTimer val = new DispatcherTimer();
		val.put_Interval(TimeSpan.FromMilliseconds(1.0));
		DispatcherTimer val2 = val;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val2, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(DispatcherTimer.remove_Tick)), delegate
		{
			if (weekInteractions.Count > 0)
			{
				InteractionRank item = weekInteractions.Dequeue();
				selectedInteractionsWeek.Add(item);
			}
			else
			{
				_timer.Stop();
			}
		});
		val2.Start();
	}

	internal void MakeRankedBuddies()
	{
		RefreshApplicationBar();
	}

	internal void ShareInteraction()
	{
		ChatOnService.Instance.FileNameToShare = "interaction.jpg";
	}

	internal void HideInteraction(InteractionRank interaction)
	{
		_interactionToHide = interaction;
		_ssmService.SetInteractionHideAsync(interaction.Buddy.PhoneNumber, hide: true);
		_page.ShowLoading();
	}

	private void RefreshApplicationBar()
	{
	}

	public void Loaded()
	{
		IEnumerable<InteractionRank> interactionRanks = InteractionRankService.Instance.GetInteractionRanks(1);
		if (interactionRanks != null && interactionRanks.Count() > 0)
		{
			NoInteractionVisibility = (Visibility)1;
			InteractionVisibility = (Visibility)0;
			NotifyPropertyChanged(() => NoInteractionVisibility);
			NotifyPropertyChanged(() => InteractionVisibility);
		}
		else
		{
			NoInteractionVisibility = (Visibility)0;
			InteractionVisibility = (Visibility)1;
			NotifyPropertyChanged(() => NoInteractionVisibility);
			NotifyPropertyChanged(() => InteractionVisibility);
		}
	}

	public void CheckInteractionCount(ICollection<InteractionRank> InteractionCollection)
	{
		if (InteractionCollection.Count == 0)
		{
			NoInteractionVisibility = (Visibility)0;
			InteractionVisibility = (Visibility)1;
			NotifyPropertyChanged(() => NoInteractionVisibility);
			NotifyPropertyChanged(() => InteractionVisibility);
		}
		else
		{
			NoInteractionVisibility = (Visibility)1;
			InteractionVisibility = (Visibility)0;
			NotifyPropertyChanged(() => NoInteractionVisibility);
			NotifyPropertyChanged(() => InteractionVisibility);
		}
	}
}
