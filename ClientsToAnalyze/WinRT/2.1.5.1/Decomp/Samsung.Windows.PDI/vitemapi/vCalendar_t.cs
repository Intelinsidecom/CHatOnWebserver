namespace vitemapi;

public class vCalendar_t
{
	public vCalendarVersion VERSION;

	public string DESCRIPTION;

	public string SUMMARY;

	public string LOCATION;

	public VItemDate_t StartDate;

	public VItemDate_t EndDate;

	public string pEncodedData;

	public int nEncodedDataLen;

	public uint bAllDay;

	public vCalendar_t()
	{
		VERSION = vCalendarVersion.VCAL_V10;
		DESCRIPTION = "";
		SUMMARY = "";
		LOCATION = "";
		bAllDay = 0u;
	}
}
