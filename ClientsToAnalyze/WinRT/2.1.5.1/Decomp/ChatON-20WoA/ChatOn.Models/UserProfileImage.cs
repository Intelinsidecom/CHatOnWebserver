using System;

namespace ChatOn.Models;

public class UserProfileImage
{
	private Uri _profileImageUri;

	private bool _isRepresent;

	public Uri ProfileImageUri
	{
		get
		{
			return _profileImageUri;
		}
		set
		{
			_profileImageUri = value;
		}
	}

	public bool IsRepresent
	{
		get
		{
			return _isRepresent;
		}
		set
		{
			_isRepresent = value;
		}
	}

	public string ProfileImageId { get; set; }
}
