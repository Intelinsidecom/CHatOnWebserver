using SDatabase;

namespace ChatOn.Models;

public class RecommendeeDataContext : SDBDataContext
{
	public SDBTable<UnknownUser> _Recommendee = new SDBTable<UnknownUser>();

	[SDBRow("Recommendees")]
	public SDBTable<UnknownUser> Recommendee
	{
		get
		{
			return _Recommendee;
		}
		set
		{
			_Recommendee = value;
		}
	}

	public RecommendeeDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
