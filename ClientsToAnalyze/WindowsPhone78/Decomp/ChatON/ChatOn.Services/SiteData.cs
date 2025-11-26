namespace ChatOn.Services;

public class SiteData
{
	public string ID { get; set; }

	public string Name { get; set; }

	public string Icon => "/Images/icon_list_" + ID + ".png";

	public bool IsOAuthLogin { get; set; }

	public bool IsSupportTitle { get; set; }

	public bool IsSupportContents { get; set; }

	public bool IsSupportAlbum { get; set; }

	public bool IsKeepLogin { get; set; }

	public string UserID { get; set; }

	public string LogoutUrl { get; set; }
}
