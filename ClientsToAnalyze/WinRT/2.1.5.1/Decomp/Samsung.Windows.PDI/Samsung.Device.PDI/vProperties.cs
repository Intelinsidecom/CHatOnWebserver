using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text;
using System.Text.RegularExpressions;

namespace Samsung.Device.PDI;

public class vProperties
{
	internal Property _completed;

	internal Property _due;

	internal Property _dtend;

	internal Property _dtstart;

	internal Property _rdate;

	internal Property _categories;

	internal Property _description;

	internal Property _summary;

	internal Property _location;

	internal Property _status;

	internal Property _priority;

	internal Property _attendee;

	internal Property _geo;

	internal Property _tz;

	internal Property _daylight;

	private string str_summary = string.Empty;

	private string str_description = string.Empty;

	private int i_priority;

	private string[] str_categories;

	private string str_status = string.Empty;

	private string str_location = string.Empty;

	private DateTime dt_completed = default(DateTime);

	private DateTime dt_startdate = default(DateTime);

	private DateTime dt_enddate = default(DateTime);

	private DateTime dt_duedate = default(DateTime);

	private GeoCoordinate gc_geo;

	private string str_tz;

	private DayLight dl_daylight;

	public string Summary
	{
		get
		{
			return str_summary;
		}
		set
		{
			str_summary = value;
		}
	}

	public string Description
	{
		get
		{
			return str_description;
		}
		set
		{
			str_description = value;
		}
	}

	public int Priority
	{
		get
		{
			return i_priority;
		}
		set
		{
			i_priority = value;
		}
	}

	public string[] Categories
	{
		get
		{
			return str_categories;
		}
		set
		{
			str_categories = value;
		}
	}

	public string Status
	{
		get
		{
			return str_status;
		}
		set
		{
			str_status = value;
		}
	}

	public string Location
	{
		get
		{
			return str_location;
		}
		set
		{
			str_location = value;
		}
	}

	public List<Attendee> Attendees { get; set; }

	public List<DateTime> Recurrences { get; set; }

	public DateTime Completed
	{
		get
		{
			return dt_completed;
		}
		set
		{
			dt_completed = value;
		}
	}

	public DateTime StartDate
	{
		get
		{
			return dt_startdate;
		}
		set
		{
			dt_startdate = value;
		}
	}

	public DateTime EndDate
	{
		get
		{
			return dt_enddate;
		}
		set
		{
			dt_enddate = value;
		}
	}

	public DateTime DueDate
	{
		get
		{
			return dt_duedate;
		}
		set
		{
			dt_duedate = value;
		}
	}

	public GeoCoordinate GeoLocation
	{
		get
		{
			return gc_geo;
		}
		set
		{
			gc_geo = value;
		}
	}

	public string TimeZone
	{
		get
		{
			return str_tz;
		}
		set
		{
			str_tz = value;
		}
	}

	public DayLight DayLightSaving
	{
		get
		{
			return dl_daylight;
		}
		set
		{
			dl_daylight = value;
		}
	}

	internal vProperties()
	{
		Attendees = new List<Attendee>();
		Recurrences = new List<DateTime>();
	}

	public void COMPLETED(Property propval)
	{
		_completed = propval;
		if (!DateTime.TryParseExact(_completed.Value, "yyyyMMdd", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_completed))
		{
			if (_completed.Value.EndsWith("Z"))
			{
				bool flag = DateTime.TryParseExact(_completed.Value, "yyyyMMdd'T'HHmmss'Z'", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_completed);
			}
			else
			{
				bool flag = DateTime.TryParseExact(_completed.Value, "yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_completed);
			}
		}
	}

	public void DUE(Property propval)
	{
		_due = propval;
		if (!DateTime.TryParseExact(_due.Value, "yyyyMMdd", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_duedate))
		{
			if (_due.Value.EndsWith("Z"))
			{
				bool flag = DateTime.TryParseExact(_due.Value, "yyyyMMdd'T'HHmmss'Z'", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_duedate);
			}
			else
			{
				bool flag = DateTime.TryParseExact(_due.Value, "yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_duedate);
			}
		}
	}

	public void DTEND(Property propval)
	{
		_dtend = propval;
		if (!DateTime.TryParseExact(_dtend.Value, "yyyyMMdd", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_enddate))
		{
			if (_dtend.Value.EndsWith("Z"))
			{
				bool flag = DateTime.TryParseExact(_dtend.Value, "yyyyMMdd'T'HHmmss'Z'", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_enddate);
			}
			else
			{
				bool flag = DateTime.TryParseExact(_dtend.Value, "yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_enddate);
			}
		}
	}

	public void DTSTART(Property propval)
	{
		_dtstart = propval;
		if (!DateTime.TryParseExact(_dtstart.Value, "yyyyMMdd", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_startdate))
		{
			if (_dtstart.Value.EndsWith("Z"))
			{
				bool flag = DateTime.TryParseExact(_dtstart.Value, "yyyyMMdd'T'HHmmss'Z'", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_startdate);
			}
			else
			{
				bool flag = DateTime.TryParseExact(_dtstart.Value, "yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture, DateTimeStyles.None, out dt_startdate);
			}
		}
	}

	public void CATEGORIES(Property propval)
	{
		_categories = propval;
		str_categories = _categories.Value.Split(';', ',');
	}

	public void DESCRIPTION(Property propval)
	{
		_description = propval;
		if (_description.Parameters.Count != 0)
		{
			for (int i = 0; i < _description.Parameters.Count; i++)
			{
				if (_description.Parameters[i].Name == "ENCODING")
				{
					if (_description.Parameters[i].Value == "BASE64")
					{
						str_description = base64.Base64Decode(_description.Value);
					}
					else if (_description.Parameters[i].Value == "QUOTED-PRINTABLE")
					{
						byte[] array = new byte[_description.Value.Length];
						int count = 0;
						for (int j = 0; j < _description.Value.Length; j++)
						{
							if (_description.Value[j].Equals('='))
							{
								j++;
								if (j < _description.Value.Length)
								{
									char c = _description.Value[j++];
									char c2 = _description.Value[j];
									string text = string.Format("{0}{1}", new object[2] { c, c2 });
									if (Regex.IsMatch(text, "\\A\\b[0-9a-fA-F]+\\b\\Z"))
									{
										array[count++] = (byte)Convert.ToInt32(text, 16);
										continue;
									}
									array[count++] = (byte)Convert.ToInt32(c);
									array[count++] = (byte)Convert.ToInt32(c2);
								}
							}
							else
							{
								array[count++] = (byte)Convert.ToInt32(_description.Value[j]);
							}
						}
						str_description = Encoding.UTF8.GetString(array, 0, count);
					}
					else
					{
						str_description = _description.Value;
					}
				}
				else
				{
					str_description = _description.Value;
				}
			}
		}
		else
		{
			str_description = _description.Value;
		}
	}

	public void SUMMARY(Property propval)
	{
		_summary = propval;
		if (_summary.Parameters.Count != 0)
		{
			for (int i = 0; i < _summary.Parameters.Count; i++)
			{
				if (_summary.Parameters[i].Name == "ENCODING")
				{
					if (_summary.Parameters[i].Value == "BASE64")
					{
						str_summary = base64.Base64Decode(_summary.Value);
					}
					else if (_summary.Parameters[i].Value == "QUOTED-PRINTABLE")
					{
						byte[] array = new byte[_summary.Value.Length];
						int count = 0;
						for (int j = 0; j < _summary.Value.Length; j++)
						{
							if (_summary.Value[j].Equals('='))
							{
								j++;
								if (j < _summary.Value.Length)
								{
									char c = _summary.Value[j++];
									char c2 = _summary.Value[j];
									string text = string.Format("{0}{1}", new object[2] { c, c2 });
									if (Regex.IsMatch(text, "\\A\\b[0-9a-fA-F]+\\b\\Z"))
									{
										array[count++] = (byte)Convert.ToInt32(text, 16);
										continue;
									}
									array[count++] = (byte)Convert.ToInt32(c);
									array[count++] = (byte)Convert.ToInt32(c2);
								}
							}
							else
							{
								array[count++] = (byte)Convert.ToInt32(_summary.Value[j]);
							}
						}
						str_summary = Encoding.UTF8.GetString(array, 0, count);
					}
					else
					{
						str_summary = _summary.Value;
					}
				}
				else
				{
					str_summary = _summary.Value;
				}
			}
		}
		else
		{
			str_summary = _summary.Value;
		}
	}

	public void LOCATION(Property propval)
	{
		_location = propval;
		if (_location.Parameters.Count != 0)
		{
			for (int i = 0; i < _location.Parameters.Count; i++)
			{
				if (_location.Parameters[i].Name == "ENCODING")
				{
					if (_location.Parameters[i].Value == "BASE64")
					{
						str_location = base64.Base64Decode(_location.Value);
					}
					else if (_location.Parameters[i].Value == "QUOTED-PRINTABLE")
					{
						byte[] array = new byte[_location.Value.Length];
						int count = 0;
						for (int j = 0; j < _location.Value.Length; j++)
						{
							if (_location.Value[j].Equals('='))
							{
								j++;
								if (j < _location.Value.Length)
								{
									char c = _location.Value[j++];
									char c2 = _location.Value[j];
									string text = string.Format("{0}{1}", new object[2] { c, c2 });
									if (Regex.IsMatch(text, "\\A\\b[0-9a-fA-F]+\\b\\Z"))
									{
										array[count++] = (byte)Convert.ToInt32(text, 16);
										continue;
									}
									array[count++] = (byte)Convert.ToInt32(c);
									array[count++] = (byte)Convert.ToInt32(c2);
								}
							}
							else
							{
								array[count++] = (byte)Convert.ToInt32(_location.Value[j]);
							}
						}
						str_location = Encoding.UTF8.GetString(array, 0, count);
					}
					else
					{
						str_location = _location.Value;
					}
				}
				else
				{
					str_location = _location.Value;
				}
			}
		}
		else
		{
			str_location = _location.Value;
		}
	}

	public void STATUS(Property propval)
	{
		str_status = "NEEDS ACTION";
		_status = propval;
		str_status = _status.Value;
	}

	public void PRIORITY(Property propval)
	{
		_priority = propval;
		i_priority = Convert.ToInt32(_priority.Value);
	}

	public void ATTENDEE(Property propval)
	{
		Attendee attendee = new Attendee();
		_attendee = propval;
		if (_attendee.Parameters.Count != 0)
		{
			for (int i = 0; i < _attendee.Parameters.Count; i++)
			{
				if (_attendee.Parameters[i].Name == "CN")
				{
					attendee.DisplayName = _attendee.Parameters[i].Value;
				}
			}
		}
		if (_attendee.Value.StartsWith("mailto:"))
		{
			attendee.EmailAddress = _attendee.Value.Remove(0, 7);
		}
		else
		{
			attendee.EmailAddress = _attendee.Value;
		}
		Attendees.Add(attendee);
	}

	public void RDATE(Property propval)
	{
		DateTime result = default(DateTime);
		_rdate = propval;
		string[] array = _rdate.Value.Split(';');
		foreach (string s in array)
		{
			if (!DateTime.TryParseExact(s, "yyyyMMdd", CultureInfo.InvariantCulture, DateTimeStyles.None, out result))
			{
				if (_rdate.Value.EndsWith("Z"))
				{
					bool flag = DateTime.TryParseExact(s, "yyyyMMdd'T'HHmmss'Z'", CultureInfo.InvariantCulture, DateTimeStyles.None, out result);
				}
				else
				{
					bool flag = DateTime.TryParseExact(s, "yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture, DateTimeStyles.None, out result);
				}
			}
			Recurrences.Add(result);
		}
	}

	public void GEO(Property propval)
	{
		gc_geo = null;
		_geo = propval;
		string[] array = _geo.Value.Split(new char[2] { ',', ';' }, StringSplitOptions.RemoveEmptyEntries);
		if (array.Length > 1)
		{
			gc_geo = new GeoCoordinate();
			gc_geo.Latitude = Convert.ToDouble(array[0]);
			gc_geo.Longitude = Convert.ToDouble(array[1]);
		}
	}

	public void TZ(Property propval)
	{
		str_tz = null;
		_tz = propval;
		str_tz = propval.Value;
	}

	public void DAYLIGHT(Property propval)
	{
		dl_daylight = null;
		_daylight = propval;
		dl_daylight = new DayLight();
		dl_daylight.IsEnabled = false;
		string[] array = _daylight.Value.Split(';');
		if (array.Length != 6)
		{
			return;
		}
		if (array[0] == "TRUE")
		{
			dl_daylight.IsEnabled = true;
		}
		char c = ' ';
		if (array[1].StartsWith("-") || array[1].StartsWith("+"))
		{
			c = array[1][0];
			array[1] = array[1].Remove(0, 1);
		}
		string[] array2 = array[1].Split(':');
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		_ = string.Empty;
		for (int i = 0; i < array2.Length; i++)
		{
			switch (i)
			{
			case 0:
				hours = Convert.ToInt32(array2[i]);
				break;
			case 1:
				minutes = Convert.ToInt32(array2[i]);
				break;
			case 3:
				seconds = Convert.ToInt32(array2[i]);
				break;
			}
		}
		dl_daylight.DayLightOffset = new TimeSpan(hours, minutes, seconds);
		if (c == '-')
		{
			dl_daylight.DayLightOffset = dl_daylight.DayLightOffset.Negate();
		}
		if (array[2].EndsWith("Z"))
		{
			dl_daylight.Begin = DateTime.ParseExact(array[2], "yyyyMMdd'T'HHmmss'Z'", CultureInfo.InvariantCulture, DateTimeStyles.None);
		}
		else
		{
			dl_daylight.Begin = DateTime.ParseExact(array[2], "yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture, DateTimeStyles.None);
		}
		if (array[3].EndsWith("Z"))
		{
			dl_daylight.End = DateTime.ParseExact(array[3], "yyyyMMdd'T'HHmmss'Z'", CultureInfo.InvariantCulture, DateTimeStyles.None);
		}
		else
		{
			dl_daylight.End = DateTime.ParseExact(array[3], "yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture, DateTimeStyles.None);
		}
		dl_daylight.Names = new string[2];
		dl_daylight.Names[0] = array[4];
		dl_daylight.Names[1] = array[5];
	}
}
