using System.IO.IsolatedStorage;
using vitemapi;

namespace ChatOn.Models;

public class AttachedContact : Attachment
{
	private string _name;

	private string _number;

	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			_name = value;
		}
	}

	public string Number
	{
		get
		{
			return _number;
		}
		set
		{
			_number = value;
		}
	}

	public AttachedContact(string name, string number, string dirPath)
	{
		base.AttachedMediaType = MediaType.CONTACT;
		base.ContentType = "text/x-vcard";
		vCard_t vCard_t = new vCard_t();
		if (name.Length > 0)
		{
			int num = name.LastIndexOf(' ');
			if (num == -1)
			{
				vCard_t.N.given = name;
				vCard_t.N.family = string.Empty;
			}
			else
			{
				vCard_t.N.given = name.Substring(0, num);
				if (num < name.Length - 1)
				{
					vCard_t.N.family = name.Substring(num + 1);
				}
				else
				{
					vCard_t.N.family = string.Empty;
				}
			}
			vCard_t.N.isValid = 1;
		}
		else
		{
			vCard_t.N.given = string.Empty;
			vCard_t.N.family = string.Empty;
			vCard_t.N.isValid = 0;
		}
		vCard_t.TELList[0].number = number;
		vCard_t.TELList[0].type = 64u;
		vCard_t.NOTE = null;
		vCardEncoder.EncodevCard(vCard_t);
		IsolatedStorageFile.GetUserStoreForApplication();
		base.Title = name;
		base.FileName = Utility.GetTimeStamp() + ".vcf";
		base.FilePath = dirPath + "\\" + base.FileName;
		byte[] inputBuffer = Utility.StrToByteArray(vCard_t.pEncodedData);
		Utility.SaveByteAsFile(base.FilePath, inputBuffer);
	}
}
