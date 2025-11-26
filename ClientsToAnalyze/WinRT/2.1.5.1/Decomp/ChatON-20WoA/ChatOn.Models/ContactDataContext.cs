using SDatabase;

namespace ChatOn.Models;

public class ContactDataContext : SDBDataContext
{
	public SDBTable<MyContact> _contacts = new SDBTable<MyContact>();

	[SDBRow("Contacts")]
	public SDBTable<MyContact> Contacts
	{
		get
		{
			return _contacts;
		}
		set
		{
			_contacts = value;
		}
	}

	public ContactDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
