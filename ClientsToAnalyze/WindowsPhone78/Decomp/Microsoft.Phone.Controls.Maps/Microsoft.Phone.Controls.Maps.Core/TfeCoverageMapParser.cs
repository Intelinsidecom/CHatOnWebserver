using System.Collections.Generic;
using System.Xml;

namespace Microsoft.Phone.Controls.Maps.Core;

internal static class TfeCoverageMapParser
{
	public static bool Parse(XmlReader reader, List<TfeZoomLevelRange> maps, out string mapGeneration, out int minTfeZoomLevel, out int maxTfeZoomLevel)
	{
		bool result = false;
		mapGeneration = null;
		minTfeZoomLevel = -1;
		maxTfeZoomLevel = -1;
		try
		{
			result = ParseXml(reader, maps, out mapGeneration, out minTfeZoomLevel, out maxTfeZoomLevel);
		}
		catch (XmlException)
		{
		}
		return result;
	}

	private static bool ParseXml(XmlReader xml, List<TfeZoomLevelRange> maps, out string mapGeneration, out int minTfeZoomLevel, out int maxTfeZoomLevel)
	{
		bool flag = true;
		mapGeneration = "1";
		minTfeZoomLevel = int.MaxValue;
		maxTfeZoomLevel = int.MinValue;
		TfeZoomLevelRange currentMap = null;
		while (xml.Read() && flag)
		{
			switch (xml.NodeType)
			{
			case XmlNodeType.Element:
				switch (xml.Name)
				{
				case "MapGeneration":
					mapGeneration = xml.ReadElementContentAsString();
					break;
				case "ZoomLevelRange":
					flag = ParseZoomLevelRange(xml, out currentMap);
					break;
				case "R":
					flag = ParseRegion(xml, currentMap);
					break;
				}
				break;
			case XmlNodeType.EndElement:
			{
				string name;
				if ((name = xml.Name) != null && name == "ZoomLevelRange")
				{
					maps.Add(currentMap);
					if (currentMap.MinimumZoom < minTfeZoomLevel)
					{
						minTfeZoomLevel = currentMap.MinimumZoom;
					}
					if (currentMap.MaximumZoom > maxTfeZoomLevel)
					{
						maxTfeZoomLevel = currentMap.MaximumZoom;
					}
					currentMap = null;
				}
				break;
			}
			}
		}
		return flag;
	}

	private static bool ParseZoomLevelRange(XmlReader xml, out TfeZoomLevelRange currentMap)
	{
		bool result = true;
		int num = 0;
		int num2 = 0;
		currentMap = null;
		while (xml.MoveToNextAttribute())
		{
			switch (xml.Name)
			{
			case "min":
				num = xml.ReadContentAsInt();
				break;
			case "max":
				num2 = xml.ReadContentAsInt();
				break;
			}
		}
		if (num != 0 && num2 != 0)
		{
			currentMap = new TfeZoomLevelRange((byte)num, (byte)num2);
		}
		else
		{
			result = false;
		}
		return result;
	}

	private static bool ParseRegion(XmlReader xml, TfeZoomLevelRange currentMap)
	{
		bool result = false;
		string text = null;
		int num = 0;
		if (currentMap != null)
		{
			while (xml.MoveToNextAttribute())
			{
				switch (xml.Name)
				{
				case "c":
					text = xml.ReadContentAsString();
					break;
				case "g":
					num = xml.ReadContentAsInt();
					break;
				}
			}
			if (text != null && num != 0)
			{
				result = true;
				currentMap.AddRegion(text, num);
			}
		}
		return result;
	}
}
