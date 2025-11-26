using SDatabase;

namespace ChatOn.Models;

public class AniconDataContext : SDBDataContext
{
	public SDBTable<OfflineAniconPackage> _packages = new SDBTable<OfflineAniconPackage>();

	[SDBRow("AniconPackages")]
	public SDBTable<OfflineAniconPackage> Packages
	{
		get
		{
			return _packages;
		}
		set
		{
			_packages = value;
		}
	}

	public AniconDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
