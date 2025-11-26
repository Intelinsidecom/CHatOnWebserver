using System.IO.IsolatedStorage;
using Microsoft.Phone.UserData;
using Samsung.Phone.PDI;

namespace ChatOn.Models;

public class AttachedCalendar : Attachment
{
	public AttachedCalendar(Appointment appt, string dirPath)
	{
		base.AttachedMediaType = MediaType.CALENDAR;
		base.ContentType = "text/x-vcal";
		vCalendar vCalendar = new vCalendar();
		string str = vCalendar.Encode(appt);
		IsolatedStorageFile.GetUserStoreForApplication();
		base.Title = appt.Subject;
		base.FileName = Utility.GetTimeStamp() + ".vcs";
		base.FilePath = dirPath + "\\" + base.FileName;
		byte[] inputBuffer = Utility.StrToByteArray(str);
		Utility.SaveByteAsFile(base.FilePath, inputBuffer);
	}
}
