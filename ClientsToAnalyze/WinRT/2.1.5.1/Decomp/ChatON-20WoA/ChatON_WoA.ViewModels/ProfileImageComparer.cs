using System.Collections.Generic;
using ChatOn.Models;

namespace ChatON_WoA.ViewModels;

public class ProfileImageComparer : IEqualityComparer<UserProfileImage>
{
	public bool Equals(UserProfileImage x, UserProfileImage y)
	{
		if (object.ReferenceEquals(x, y))
		{
			return true;
		}
		if (object.ReferenceEquals(x, null) || object.ReferenceEquals(y, null))
		{
			return false;
		}
		return x.ProfileImageId == y.ProfileImageId;
	}

	public int GetHashCode(UserProfileImage obj)
	{
		return obj?.ProfileImageId.GetHashCode() ?? 0;
	}
}
