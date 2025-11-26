using System;
using ChatOn.Models;
using SDatabase;

namespace ChatON_WoA.DataModel;

public class InteractionRank : SDBData
{
	private Guid _id;

	private Buddy _buddy;

	private int _rank;

	private int _receivedCount;

	private int _sentCount;

	private int _bestInteractionPoint;

	private int _displayRank;

	private int _interactionWeek;

	private bool _isHideInteraction;

	private string _buddyPhoneNumber;

	public Buddy Buddy
	{
		get
		{
			return _buddy;
		}
		set
		{
			_buddy = value;
			NotifyPropertyChanged(() => Buddy);
		}
	}

	[SDBColumn]
	public new Guid Id
	{
		get
		{
			return _id;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _id != value)
			{
				SetDataUpdated();
			}
			_id = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Id);
			}
		}
	}

	[SDBColumn]
	public string BuddyPhoneNumber
	{
		get
		{
			return _buddyPhoneNumber;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _buddyPhoneNumber != value)
			{
				SetDataUpdated();
			}
			_buddyPhoneNumber = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => BuddyPhoneNumber);
			}
		}
	}

	[SDBColumn]
	public int Rank
	{
		get
		{
			return _rank;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _rank != value)
			{
				SetDataUpdated();
			}
			_rank = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Rank);
			}
		}
	}

	[SDBColumn]
	public int ReceivedCount
	{
		get
		{
			return _receivedCount;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _receivedCount != value)
			{
				SetDataUpdated();
			}
			_receivedCount = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ReceivedCount);
			}
		}
	}

	[SDBColumn]
	public int SentCount
	{
		get
		{
			return _sentCount;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _sentCount != value)
			{
				SetDataUpdated();
			}
			_sentCount = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => SentCount);
			}
		}
	}

	[SDBColumn]
	public int BestInteractionPoint
	{
		get
		{
			return _bestInteractionPoint;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _bestInteractionPoint != value)
			{
				SetDataUpdated();
			}
			_bestInteractionPoint = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => BestInteractionPoint);
			}
		}
	}

	[SDBColumn]
	public int DisplayRank
	{
		get
		{
			return _displayRank;
		}
		set
		{
			_displayRank = value;
			NotifyPropertyChanged(() => DisplayRank);
		}
	}

	[SDBColumn]
	public int IntractionWeek
	{
		get
		{
			return _interactionWeek;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _interactionWeek != value)
			{
				SetDataUpdated();
			}
			_interactionWeek = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IntractionWeek);
			}
		}
	}

	[SDBColumn]
	public bool IsHideInteraction
	{
		get
		{
			return _isHideInteraction;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isHideInteraction != value)
			{
				SetDataUpdated();
			}
			_isHideInteraction = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsHideInteraction);
			}
		}
	}

	public bool Equals(InteractionRank existing)
	{
		if (_buddy.PhoneNumber == existing.Buddy.PhoneNumber && _rank == existing.Rank && ReceivedCount == existing.ReceivedCount && SentCount == existing.SentCount && DisplayRank == existing.DisplayRank)
		{
			return IntractionWeek == existing.IntractionWeek;
		}
		return false;
	}

	internal void Hide()
	{
		IsHideInteraction = true;
	}

	public void Show()
	{
		IsHideInteraction = false;
	}
}
