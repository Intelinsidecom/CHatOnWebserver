using System.Windows;
using ChatOn.Models;
using Microsoft.Phone.Controls;
using Samsung.Phone.PDI;

namespace ChatOn.ViewModels;

public class AttachCalendarDetailPageViewModel
{
	private PhoneApplicationPage _page;

	public AttachCalendarDetailPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
	}

	public void DecodeVcalData(string fileName)
	{
		string data = Utility.ByteArrayToStr(Utility.FileToByteArray(fileName));
		vCalendar vCalendar = new vCalendar();
		vCalendar.Decode(data);
		ChatOnAppointment chatOnAppointment = new ChatOnAppointment();
		chatOnAppointment.Detail = vCalendar.Events[0].Description;
		chatOnAppointment.Location = vCalendar.Events[0].Location;
		chatOnAppointment.Subject = vCalendar.Events[0].Summary;
		chatOnAppointment.StartTime = vCalendar.Events[0].StartDate.ToShortDateString() + " " + vCalendar.Events[0].StartDate.ToShortTimeString();
		chatOnAppointment.EndTime = "- " + vCalendar.Events[0].EndDate.ToShortDateString() + " " + vCalendar.Events[0].EndDate.ToShortTimeString();
		((FrameworkElement)(object)_page).DataContext = chatOnAppointment;
		RemoveSendButton();
	}

	public void RemoveSendButton()
	{
		_page.ApplicationBar.Buttons.Remove(_page.ApplicationBar.Buttons[0]);
	}
}
