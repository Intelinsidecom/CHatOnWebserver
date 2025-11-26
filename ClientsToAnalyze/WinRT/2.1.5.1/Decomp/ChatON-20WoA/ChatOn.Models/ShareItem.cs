namespace ChatOn.Models;

public class ShareItem
{
	public delegate void ShareCommandHandler();

	private string _name;

	private string _logoPath;

	private string _siteID;

	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			_name = value;
		}
	}

	public string LogoPath
	{
		get
		{
			return _logoPath;
		}
		set
		{
			_logoPath = value;
		}
	}

	public string SiteID
	{
		get
		{
			return _siteID;
		}
		set
		{
			_siteID = value;
		}
	}

	public string LogoutUrl { get; set; }

	public bool IsKeepLogin { get; set; }

	public event ShareCommandHandler OnExecute;

	public void Execute()
	{
		if (this.OnExecute != null)
		{
			this.OnExecute();
		}
	}
}
