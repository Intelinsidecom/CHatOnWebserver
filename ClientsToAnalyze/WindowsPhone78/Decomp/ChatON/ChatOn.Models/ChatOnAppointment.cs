using Microsoft.Phone.UserData;

namespace ChatOn.Models;

public class ChatOnAppointment
{
	public string StartDate { get; set; }

	public string StartTime { get; set; }

	public string EndTime { get; set; }

	public string Subject { get; set; }

	public string HowLong { get; set; }

	public string Location { get; set; }

	public string Detail { get; set; }

	public Appointment Appointment { get; set; }
}
