using ChatON_WoA.DataModel;
using SDatabase;

namespace ChatOn.Models;

public class InteractionRankContext : SDBDataContext
{
	public SDBTable<InteractionRank> _interactionRanks = new SDBTable<InteractionRank>();

	[SDBRow("InteractionRanks")]
	public SDBTable<InteractionRank> InteractionRanks
	{
		get
		{
			return _interactionRanks;
		}
		set
		{
			_interactionRanks = value;
		}
	}

	public InteractionRankContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
