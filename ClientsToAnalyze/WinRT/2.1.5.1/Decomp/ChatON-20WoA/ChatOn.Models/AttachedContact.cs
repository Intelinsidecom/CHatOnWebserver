using System.Threading.Tasks;
using ChatOn.Infrastructure;
using vitemapi;
using Windows.ApplicationModel.Contacts;
using Windows.Storage;

namespace ChatOn.Models;

internal class AttachedContact : Attachment
{
	public AttachedContact(string dirPath)
	{
		base.AttachedMediaType = MediaType.CONTACT;
		base.ContentType = "text/x-vcard";
		base.DirPath = dirPath;
	}

	public async Task<StorageFile> SetFile(ContactInformation contact)
	{
		vCard_t vCardData = new vCard_t();
		if (contact.Name != null && contact.Name.Length > 0)
		{
			vCardData.FN = contact.Name;
		}
		else
		{
			vCardData.FN = string.Empty;
		}
		vCardData.N.isValid = 0;
		for (int i = 0; i < contact.PhoneNumbers.Count; i++)
		{
			ContactField val = contact.PhoneNumbers[i];
			if (((object)val.Category).Equals((object)(ContactFieldCategory)3))
			{
				vCardData.TELList[i].type = 64u;
			}
			else if (((object)val.Category).Equals((object)(ContactFieldCategory)1))
			{
				vCardData.TELList[i].type = 1u;
			}
			else if (((object)val.Category).Equals((object)(ContactFieldCategory)2))
			{
				vCardData.TELList[i].type = 2u;
			}
			else
			{
				vCardData.TELList[i].type = 0u;
			}
			vCardData.TELList[i].number = val.Value;
		}
		for (int j = 0; j < contact.Emails.Count; j++)
		{
			ContactField val2 = contact.Emails[j];
			if (((object)val2.Category).Equals((object)(ContactFieldCategory)1))
			{
				vCardData.EMAILList[j].type = 1u;
			}
			else if (((object)val2.Category).Equals((object)(ContactFieldCategory)2))
			{
				vCardData.EMAILList[j].type = 2u;
			}
			else
			{
				vCardData.EMAILList[j].type = 0u;
			}
			vCardData.EMAILList[j].email = val2.Value;
		}
		vCardData.NOTE = null;
		vCardEncoder.EncodevCard(vCardData);
		base.Title = contact.Name;
		base.FileName = Utility.GetTimeStamp() + ".vcf";
		base.FilePath = base.DirPath + "\\" + base.FileName;
		return await Utility.SaveByteAsFile(inputBuffer: Utility.StrToByteArray(vCardData.pEncodedData), fileName: base.FilePath);
	}
}
