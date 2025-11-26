using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;
using Microsoft.Phone.UserData;

namespace ChatOn.ViewModels;

public class AttachCalendarPageViewModel : NotificationObject
{
	private PhoneApplicationPage _page;

	private List<ChatOnAppointment> _appointmentList;

	public List<ChatOnAppointment> AppointmentList
	{
		get
		{
			return _appointmentList;
		}
		set
		{
			_appointmentList = value;
			NotifyPropertyChanged(() => AppointmentList);
		}
	}

	public AttachCalendarPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
	}

	public void SearchCalendar()
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		Appointments val = new Appointments();
		val.SearchCompleted += Appointments_SearchCompleted;
		DateTime dateTime = DateTime.Now.AddMonths(-1);
		DateTime dateTime2 = DateTime.Now.AddMonths(2);
		val.SearchAsync(dateTime, dateTime2, 1000, (object)"Appointments Test #1");
	}

	private void Appointments_SearchCompleted(object sender, AppointmentsSearchEventArgs e)
	{
		_appointmentList = new List<ChatOnAppointment>();
		foreach (Appointment result in e.Results)
		{
			ChatOnAppointment chatOnAppointment = new ChatOnAppointment();
			chatOnAppointment.Appointment = result;
			chatOnAppointment.StartDate = result.StartTime.ToShortDateString();
			chatOnAppointment.StartTime = result.StartTime.ToShortTimeString();
			chatOnAppointment.Subject = result.Subject;
			chatOnAppointment.HowLong = (result.EndTime - result.StartTime).ToString();
			_appointmentList.Add(chatOnAppointment);
		}
		AttachCalendarPage attachCalendarPage = _page as AttachCalendarPage;
		attachCalendarPage.AppointmentResultsData.DataContext = _appointmentList;
		if (_appointmentList.Count < 1)
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				MessageBox.Show(ResContainer.IDS_CHATON_BODY_NO_SCHEDULES);
				Utility.SafetyGoBack(_page);
			});
		}
	}

	public void ViewCalendarDetail(object sender)
	{
		if ((sender as ListBox).SelectedValue is ChatOnAppointment)
		{
			ChatOnService.Instance.Appointment = ((sender as ListBox).SelectedValue as ChatOnAppointment).Appointment;
			PageNavigationService.OpenAttachCalendarDetailPage(_page, null);
		}
	}
}
