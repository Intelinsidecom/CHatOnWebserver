using System.IO;
using System.Runtime.InteropServices;

namespace HtmlAgilityPack;

[StructLayout(LayoutKind.Sequential, Size = 1)]
internal struct IOLibrary
{
	internal static void CopyAlways(string source, string target)
	{
		if (!File.Exists(source))
		{
			if (1 == 0)
			{
			}
		}
		else
		{
			Directory.CreateDirectory(Path.GetDirectoryName(target));
			MakeWritable(target);
			File.Copy(source, target, overwrite: true);
		}
	}

	internal static void MakeWritable(string path)
	{
	}
}
