using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.Compressor.LZMA;
using SharpCompress.Compressor.LZMA.Utilites;

namespace SharpCompress.Common.SevenZip;

internal class ArchiveDatabase
{
	internal byte MajorVersion;

	internal byte MinorVersion;

	internal long StartPositionAfterHeader;

	internal long DataStartPosition;

	internal List<long> PackSizes = new List<long>();

	internal List<uint?> PackCRCs = new List<uint?>();

	internal List<CFolder> Folders = new List<CFolder>();

	internal List<int> NumUnpackStreamsVector;

	internal List<CFileItem> Files = new List<CFileItem>();

	internal List<long> PackStreamStartPositions = new List<long>();

	internal List<int> FolderStartFileIndex = new List<int>();

	internal List<int> FileIndexToFolderIndexMap = new List<int>();

	internal void Clear()
	{
		PackSizes.Clear();
		PackCRCs.Clear();
		Folders.Clear();
		NumUnpackStreamsVector = null;
		Files.Clear();
		PackStreamStartPositions.Clear();
		FolderStartFileIndex.Clear();
		FileIndexToFolderIndexMap.Clear();
	}

	internal bool IsEmpty()
	{
		if (PackSizes.Count == 0 && PackCRCs.Count == 0 && Folders.Count == 0 && NumUnpackStreamsVector.Count == 0)
		{
			return Files.Count == 0;
		}
		return false;
	}

	private void FillStartPos()
	{
		PackStreamStartPositions.Clear();
		long num = 0L;
		for (int i = 0; i < PackSizes.Count; i++)
		{
			PackStreamStartPositions.Add(num);
			num += PackSizes[i];
		}
	}

	private void FillFolderStartFileIndex()
	{
		FolderStartFileIndex.Clear();
		FileIndexToFolderIndexMap.Clear();
		int num = 0;
		int num2 = 0;
		for (int i = 0; i < Files.Count; i++)
		{
			CFileItem cFileItem = Files[i];
			bool flag = !cFileItem.HasStream;
			if (flag && num2 == 0)
			{
				FileIndexToFolderIndexMap.Add(-1);
				continue;
			}
			if (num2 == 0)
			{
				while (true)
				{
					if (num >= Folders.Count)
					{
						throw new InvalidOperationException();
					}
					FolderStartFileIndex.Add(i);
					if (NumUnpackStreamsVector[num] != 0)
					{
						break;
					}
					num++;
				}
			}
			FileIndexToFolderIndexMap.Add(num);
			if (!flag)
			{
				num2++;
				if (num2 >= NumUnpackStreamsVector[num])
				{
					num++;
					num2 = 0;
				}
			}
		}
	}

	public void Fill()
	{
		FillStartPos();
		FillFolderStartFileIndex();
	}

	internal long GetFolderStreamPos(CFolder folder, int indexInFolder)
	{
		int index = folder.FirstPackStreamId + indexInFolder;
		return DataStartPosition + PackStreamStartPositions[index];
	}

	internal long GetFolderFullPackSize(int folderIndex)
	{
		int firstPackStreamId = Folders[folderIndex].FirstPackStreamId;
		CFolder cFolder = Folders[folderIndex];
		long num = 0L;
		for (int i = 0; i < cFolder.PackStreams.Count; i++)
		{
			num += PackSizes[firstPackStreamId + i];
		}
		return num;
	}

	internal Stream GetFolderStream(Stream stream, CFolder folder, IPasswordProvider pw)
	{
		int firstPackStreamId = folder.FirstPackStreamId;
		long folderStreamPos = GetFolderStreamPos(folder, 0);
		List<long> list = new List<long>();
		for (int i = 0; i < folder.PackStreams.Count; i++)
		{
			list.Add(PackSizes[firstPackStreamId + i]);
		}
		return DecoderStreamHelper.CreateDecoderStream(stream, folderStreamPos, list.ToArray(), folder, pw);
	}

	private long GetFolderPackStreamSize(int folderIndex, int streamIndex)
	{
		return PackSizes[Folders[folderIndex].FirstPackStreamId + streamIndex];
	}

	private long GetFilePackSize(int fileIndex)
	{
		int num = FileIndexToFolderIndexMap[fileIndex];
		if (num != -1 && FolderStartFileIndex[num] == fileIndex)
		{
			return GetFolderFullPackSize(num);
		}
		return 0L;
	}
}
