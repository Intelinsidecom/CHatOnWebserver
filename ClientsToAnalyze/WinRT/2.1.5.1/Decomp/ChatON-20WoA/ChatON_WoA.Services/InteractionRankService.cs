using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.DataModel;
using ChatOn.Models;
using ChatOn.Services;

namespace ChatON_WoA.Services;

public class InteractionRankService
{
	private readonly SSMService _ssmService;

	private readonly DataService _dataService;

	private static InteractionRankService _instance;

	public static InteractionRankService Instance => _instance ?? (_instance = new InteractionRankService());

	public InteractionRankService()
	{
		_ssmService = new SSMService();
		_dataService = new DataService();
		_ssmService.GetInteractionCompleted += _ssmService_GetInteractionCompleted;
	}

	public Task LoadInteractionRankAsync()
	{
		return Task.Run(delegate
		{
			_ssmService.GetInteractionAsync(isForceUpdate: true);
		});
	}

	private void _ssmService_GetInteractionCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			if (e.Xml != null)
			{
				MakeOldRankBuddies(e.Xml, 1);
				MakeOldRankBuddies(e.Xml, 2);
				MakeOldRankBuddies(e.Xml, 3);
				MakeOldRankBuddies(e.Xml, 4);
			}
			else
			{
				_ = e.StatusCode;
				_ = 204;
			}
		}
	}

	private void MakeOldRankBuddies(XElement xml, int week)
	{
		try
		{
			IEnumerable<XElement> source = from b in xml.Descendants("interaction")
				where b.Attribute("week").Value == week.ToString()
				select b;
			IEnumerable<XElement> enumerable = from c in source.Descendants("buddyid")
				select (c);
			foreach (XElement item in enumerable)
			{
				string number = "";
				int sentCount = 0;
				int receivedCount = 0;
				int num = 0;
				int bestInteractionPoint = 0;
				number = item.Value;
				if (item.Attribute("rank") != null)
				{
					num = int.Parse(item.Attribute("rank").Value);
				}
				if (item.Attribute("send") != null)
				{
					sentCount = int.Parse(item.Attribute("send").Value);
				}
				if (item.Attribute("receive") != null)
				{
					receivedCount = int.Parse(item.Attribute("receive").Value);
				}
				if (item.Attribute("total") != null)
				{
					bestInteractionPoint = int.Parse(item.Attribute("total").Value);
				}
				Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == number);
				InteractionRank interactionRank = _dataService.InteractionRanks.FirstOrDefault((InteractionRank i) => i.BuddyPhoneNumber == number && i.IntractionWeek == week);
				InteractionRank interactionRank2 = new InteractionRank();
				if (buddy != null)
				{
					interactionRank2.Buddy = buddy;
					interactionRank2.BuddyPhoneNumber = buddy.PhoneNumber;
					interactionRank2.Rank = num;
					interactionRank2.ReceivedCount = receivedCount;
					interactionRank2.SentCount = sentCount;
					interactionRank2.BestInteractionPoint = bestInteractionPoint;
					interactionRank2.DisplayRank = num;
					if (!interactionRank2.IsHideInteraction && buddy.IsHideInteraction)
					{
						interactionRank2.IsHideInteraction = true;
					}
					else
					{
						interactionRank2.IsHideInteraction = false;
					}
					interactionRank2.IntractionWeek = week;
					if (interactionRank != null && !interactionRank2.Equals(interactionRank))
					{
						_dataService.DeleteInteraction(interactionRank);
					}
					else if (interactionRank == null || !interactionRank2.Equals(interactionRank))
					{
						_dataService.AddInteraction(interactionRank2);
					}
				}
			}
		}
		catch (Exception)
		{
		}
		_dataService.InteractionRankDBSubmitChanges();
	}

	public IEnumerable<InteractionRank> GetInteractionRanks(int week)
	{
		List<InteractionRank> list = (from x in _dataService.InteractionRanks
			where x.IntractionWeek == week && !x.IsHideInteraction && x.Rank > 0
			orderby x.Rank
			select x).Take(20).ToList();
		List<InteractionRank> list2 = new List<InteractionRank>();
		foreach (InteractionRank interactionRank in list)
		{
			IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
			Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == interactionRank.BuddyPhoneNumber;
			Buddy buddy = buddyItems.FirstOrDefault(predicate);
			if (buddy != null && !buddy.IsHideInteraction)
			{
				interactionRank.Buddy = buddy;
				list2.Add(interactionRank);
			}
		}
		return list2;
	}

	public IEnumerable<InteractionRank> GetLatestInteractionRanks()
	{
		try
		{
			return GetInteractionRanks(1).Take(10);
		}
		catch
		{
			return null;
		}
	}

	public InteractionRank GetBuddyInteraction(Buddy buddy)
	{
		InteractionRank interactionRank = _dataService.InteractionRanks.FirstOrDefault((InteractionRank x) => x.IntractionWeek == 1 && !x.IsHideInteraction && x.Rank > 0 && x.BuddyPhoneNumber == buddy.PhoneNumber);
		if (interactionRank != null)
		{
			interactionRank.Buddy = buddy;
		}
		return interactionRank;
	}

	internal void HideBuddyInteractions(Buddy buddy)
	{
		IEnumerable<InteractionRank> enumerable = _dataService.InteractionRanks.Where((InteractionRank x) => !x.IsHideInteraction && x.BuddyPhoneNumber == buddy.PhoneNumber);
		foreach (InteractionRank item in enumerable)
		{
			item.Hide();
		}
		_dataService.InteractionRankDBSubmitChanges();
	}

	internal void ShowBuddyInteractions(Buddy buddy)
	{
		IEnumerable<InteractionRank> enumerable = _dataService.InteractionRanks.Where((InteractionRank x) => x.IsHideInteraction && x.BuddyPhoneNumber == buddy.PhoneNumber);
		foreach (InteractionRank item in enumerable)
		{
			item.Show();
		}
		_dataService.InteractionRankDBSubmitChanges();
	}
}
