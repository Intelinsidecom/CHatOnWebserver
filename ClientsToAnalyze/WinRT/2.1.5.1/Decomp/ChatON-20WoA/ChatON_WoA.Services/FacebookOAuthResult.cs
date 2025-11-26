namespace ChatON_WoA.Services;

public class FacebookOAuthResult
{
	public bool IsSuccess { get; set; }

	public string AccessToken { get; set; }

	public string ErrorDescription { get; set; }

	public string ErrorReason { get; set; }

	public FacebookOAuthResult(bool isSuccess, string accessToken)
	{
		IsSuccess = isSuccess;
		AccessToken = accessToken;
	}
}
