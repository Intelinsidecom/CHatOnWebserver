namespace vitemapi;

public class vCard_t
{
	public string FN;

	public vCardName_t N;

	public vCardTelNumber_t[] TELList;

	public vCardEmail_t[] EMAILList;

	public string NOTE;

	public vCardVersion VERSION;

	public string pEncodedData;

	public int nEncodedDataLen;

	public vCard_t()
	{
		FN = "";
		N.addition = "";
		N.family = "";
		N.given = "";
		N.isValid = 0;
		N.prefix = "";
		N.suffix = "";
		TELList = new vCardTelNumber_t[12];
		EMAILList = new vCardEmail_t[6];
		NOTE = "";
		VERSION = vCardVersion.VCARD_V21;
		pEncodedData = "";
		nEncodedDataLen = 0;
	}
}
