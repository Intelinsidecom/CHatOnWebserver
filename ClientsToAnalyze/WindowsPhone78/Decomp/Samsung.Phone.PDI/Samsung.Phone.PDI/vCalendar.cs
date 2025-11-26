using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using Microsoft.Phone.UserData;

namespace Samsung.Phone.PDI;

public sealed class vCalendar
{
	private List<vEvent> Event;

	public string VERSION { get; set; }

	public List<vEvent> Events => Event;

	public vCalendar()
	{
		VERSION = string.Empty;
		Event = new List<vEvent>();
	}

	public void Decode(string Data)
	{
		string[] separator = new string[4] { "BEGIN:VEVENT\r\n", "END:VEVENT\r\n", "BEGIN:VEVENT\n", "END:VEVENT\n" };
		string[] array = Data.Split(separator, StringSplitOptions.RemoveEmptyEntries);
		if (array.Length > 1 && array[0].StartsWith("BEGIN:VCALENDAR") && array[array.Length - 1].StartsWith("END:VCALENDAR"))
		{
			ParseVCalendarProperties(array[0]);
			for (int i = 1; i < array.Length - 1; i++)
			{
				vEvent vEvent2 = new vEvent();
				vEvent2.Decode(array[i]);
				Events.Add(vEvent2);
			}
		}
	}

	public bool IsContainCRLF(string Data)
	{
		StringReader stringReader = new StringReader(Data);
		string text = stringReader.ReadLine();
		return text.Contains("\r\n");
	}

	public bool IsContainNewLine(string Data)
	{
		StringReader stringReader = new StringReader(Data);
		string text = stringReader.ReadLine();
		return text.Contains("\n");
	}

	private void ParseVCalendarProperties(string str)
	{
		string[] array = str.Split(new string[2] { "\r\n", "\n" }, StringSplitOptions.RemoveEmptyEntries);
		if (array.Length <= 1)
		{
			return;
		}
		for (int i = 0; i < array.Length; i++)
		{
			string[] array2 = array[i].Split(new string[1] { ":" }, StringSplitOptions.RemoveEmptyEntries);
			Property property = new Property();
			property.Name = array2[0].Split(';')[0];
			IEnumerable<Parameter> source = from par in array2[0].Split(';').Skip(1)
				let pvn = par.Split('=')
				select new Parameter
				{
					Name = pvn[0],
					Value = pvn[1]
				};
			property.Parameters = source.ToList();
			property.Value = array2[1];
			GetType().GetProperty(property.Name.ToUpper())?.SetValue(this, property.Value, null);
		}
	}

	public string Encode(Appointment AppointmentData)
	{
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		VERSION = "1.0";
		vEvent vEvent2 = new vEvent();
		vEvent2.StartDate = AppointmentData.StartTime;
		vEvent2.EndDate = AppointmentData.EndTime;
		vEvent2.Summary = AppointmentData.Subject;
		vEvent2.Description = AppointmentData.Details;
		vEvent2.Status = ((object)AppointmentData.Status).ToString().ToUpper();
		vEvent2.Location = AppointmentData.Location;
		vEvent2.Priority = 0;
		vEvent2.IsFullDay = AppointmentData.IsAllDayEvent;
		vEvent2.IsPrivate = AppointmentData.IsPrivate;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("BEGIN:VCALENDAR\r\n");
		stringBuilder.AppendFormat("VERSION:{0}\r\n", VERSION);
		string value = vEvent2.Encode();
		stringBuilder.Append(value);
		stringBuilder.Append("END:VCALENDAR\r\n");
		stringBuilder.AppendLine();
		return stringBuilder.ToString();
	}
}
