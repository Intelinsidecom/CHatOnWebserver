using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Reflection;
using System.Text;

namespace Samsung.Device.PDI;

public sealed class vEvent : vProperties
{
	internal bool IsPrivate { get; set; }

	internal bool IsFullDay { get; set; }

	internal void Decode(string Data)
	{
		string[] array = Data.Split(new string[2] { "BEGIN:V", "END:V" }, StringSplitOptions.RemoveEmptyEntries);
		string[] array2 = array[0].Split(new string[2] { "\r\n", "\n" }, StringSplitOptions.RemoveEmptyEntries);
		if (array2.Length <= 1)
		{
			return;
		}
		Property property = null;
		for (int i = 0; i < array2.Length; i++)
		{
			if (vCalLookUpTable.Contains(array2[i]))
			{
				if (property != null)
				{
					Fill(property);
				}
				property = null;
				int num = array2[i].IndexOf(':');
				if (num <= -1)
				{
					continue;
				}
				property = new Property();
				string text = array2[i].Substring(0, num);
				if (text != null)
				{
					property.Name = text.Split(';')[0];
					IEnumerable<Parameter> source = from par in text.Split(';').Skip(1)
						let pvn = par.Split('=')
						select new Parameter
						{
							Name = pvn[0],
							Value = pvn[1]
						};
					property.Parameters = source.ToList();
					property.Value = array2[i].Substring(num + 1);
				}
			}
			else if (property != null)
			{
				property.Value += array2[i];
			}
		}
		if (property != null)
		{
			Fill(property);
		}
	}

	internal string Encode()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("BEGIN:VEVENT\r\n");
		if (base.StartDate != DateTime.MinValue)
		{
			string text = base.StartDate.ToString("yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture);
			stringBuilder.AppendFormat("DTSTART:{0}Z\r\n", new object[1] { text });
		}
		if (base.EndDate != DateTime.MinValue)
		{
			string text2 = base.EndDate.ToString("yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture);
			stringBuilder.AppendFormat("DTEND:{0}Z\r\n", new object[1] { text2 });
		}
		if (base.DueDate != DateTime.MinValue)
		{
			string text3 = base.DueDate.ToString("yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture);
			stringBuilder.AppendFormat("DUE:{0}Z\r\n", new object[1] { text3 });
		}
		else
		{
			string text4 = base.EndDate.ToString("yyyyMMdd'T'HHmmss", CultureInfo.InvariantCulture);
			stringBuilder.AppendFormat("DUE:{0}Z\r\n", new object[1] { text4 });
		}
		if (base.Categories != null)
		{
			StringBuilder stringBuilder2 = new StringBuilder();
			for (int i = 0; i < base.Categories.Length; i++)
			{
				stringBuilder2.AppendFormat("{0};", new object[1] { base.Categories[i] });
			}
			stringBuilder2.Remove(stringBuilder2.Length - 1, 1);
			stringBuilder.AppendFormat("CATEGORIES:{0}\r\n", new object[1] { stringBuilder2 });
		}
		else if (IsPrivate)
		{
			stringBuilder.Append("CATEGORIES:PERSONAL\r\n");
		}
		else
		{
			stringBuilder.Append("CATEGORIES:APPOINTMENT\r\n");
		}
		if (base.Description != null)
		{
			stringBuilder.AppendFormat("DESCRIPTION:{0}\r\n", new object[1] { base.Description });
		}
		if (base.Summary != null)
		{
			stringBuilder.AppendFormat("SUMMARY:{0}\r\n", new object[1] { base.Summary });
		}
		if (base.Location != null)
		{
			stringBuilder.AppendFormat("LOCATION:{0}\r\n", new object[1] { base.Location });
		}
		if (base.Status != null)
		{
			stringBuilder.AppendFormat("STATUS:{0}\r\n", new object[1] { base.Status });
		}
		if (base.Priority > 0)
		{
			stringBuilder.AppendFormat("PRIORITY:{0}\r\n", new object[1] { base.Priority });
		}
		stringBuilder.Append("END:VEVENT\r\n");
		return stringBuilder.ToString();
	}

	private void Fill(Property p)
	{
		GetType().GetRuntimeMethod(p.Name, new Type[1] { typeof(Property) })?.Invoke(this, new object[1] { p });
	}
}
