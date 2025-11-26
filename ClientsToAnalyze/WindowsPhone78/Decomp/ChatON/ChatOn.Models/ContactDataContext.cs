using System.Data.Linq;

namespace ChatOn.Models;

public class ContactDataContext : DataContext
{
	public Table<MyContact> Contacts;

	public ContactDataContext(string fileOrConnection)
		: base(fileOrConnection)
	{
	}
}
