using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;
using ChatON_WoA.DataModel;
using ChatOn.Models;
using ChatOn.Services;

namespace ChatON_WoA.Services;

internal class AniconService
{
	public static List<AniconPackage> GetPackageList(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("package")
			select (item);
		List<AniconPackage> list = new List<AniconPackage>();
		foreach (XElement item in enumerable)
		{
			AniconPackage package = new AniconPackage();
			if (item.Attribute("id") != null)
			{
				package.ID = item.Attribute("id").Value;
				AniconPackage aniconPackage = ChatOnService.Instance.DownloadingPackages.FirstOrDefault((AniconPackage c) => c.ID == package.ID);
				if (aniconPackage != null)
				{
					list.Add(aniconPackage);
					continue;
				}
			}
			XElement xElement = item.Element("name");
			if (xElement != null)
			{
				package.Name = xElement.Value;
			}
			xElement = item.Element("thumbnailurl");
			if (xElement != null)
			{
				package.ThumbImageUri = xElement.Value;
			}
			xElement = item.Element("aniconcount");
			if (xElement != null)
			{
				package.Count = int.Parse(xElement.Value);
			}
			xElement = item.Element("volume");
			if (xElement != null)
			{
				package.Size = long.Parse(xElement.Value);
			}
			xElement = item.Element("startdate");
			if (xElement != null)
			{
				package.StartDate = long.Parse(xElement.Value);
			}
			xElement = item.Element("expirationdate");
			if (xElement != null)
			{
				package.EndDate = long.Parse(xElement.Value);
			}
			xElement = item.Element("downloadrank");
			if (xElement != null)
			{
				package.DownloadRank = int.Parse(xElement.Value);
			}
			xElement = item.Element("author");
			if (xElement != null)
			{
				package.Character = xElement.Value;
			}
			list.Add(package);
		}
		return list;
	}

	public static void GetPackageInfo(OfflineAniconPackage package, XElement xe)
	{
		IEnumerable<XElement> enumerable = xe.Elements("package");
		package.XmlString = xe.ToString();
		foreach (XElement item in enumerable)
		{
			if (item.Attribute("id") != null)
			{
				package.PackageID = item.Attribute("id").Value;
			}
			XElement xElement = item.Element("cdproxyurl");
			if (xElement != null)
			{
				package.ProxyUrl = xElement.Value;
			}
			xElement = item.Element("expirationtime");
			if (xElement != null)
			{
				package.EndDate = long.Parse(xElement.Value);
			}
			xElement = item.Element("panelurl");
			if (xElement != null)
			{
				package.ThumbImageUri = xElement.Value;
			}
			xElement = item.Element("packagezipurl");
			if (xElement != null)
			{
				package.PackageZipUrl = xElement.Value;
			}
			IEnumerable<XElement> enumerable2 = item.Elements("anicon");
			foreach (XElement item2 in enumerable2)
			{
				Anicon anicon = new Anicon();
				if (item2.Attribute("id") != null)
				{
					anicon.ID = item2.Attribute("id").Value;
				}
				anicon.MsgUrl = package.ProxyUrl + "/" + anicon.ID;
				xElement = item2.Element("delegateimage");
				if (xElement != null)
				{
					anicon.DelegateImageName = xElement.Value;
				}
				IEnumerable<XElement> enumerable3 = item2.Elements("imageurl");
				foreach (XElement item3 in enumerable3)
				{
					anicon.ImageUrlList.Add(item3.Value);
				}
				anicon.ImageUrlList.Sort();
				package.AniconList.Add(anicon);
			}
		}
	}

	public static Anicon GetAniconInfo(XElement xe)
	{
		IEnumerable<XElement> enumerable = xe.Elements("anicon");
		Anicon anicon = new Anicon();
		foreach (XElement item in enumerable)
		{
			if (item.Attribute("id") != null)
			{
				anicon.ID = item.Attribute("id").Value;
			}
			IEnumerable<XElement> enumerable2 = item.Elements("imageurl");
			foreach (XElement item2 in enumerable2)
			{
				anicon.ImageUrlList.Add(item2.Value);
			}
			anicon.ImageUrlList.Sort();
		}
		return anicon;
	}

	public static void CheckPackageDownloaded(ref List<AniconPackage> list, DataService dataService)
	{
		foreach (AniconPackage package in list)
		{
			IEnumerable<OfflineAniconPackage> aninconPackages = dataService.AninconPackages;
			Func<OfflineAniconPackage, bool> predicate = (OfflineAniconPackage c) => c.PackageID == package.ID;
			if (aninconPackages.FirstOrDefault(predicate) != null)
			{
				package.IsNeedDownload = false;
			}
			else
			{
				package.IsNeedDownload = true;
			}
		}
	}
}
