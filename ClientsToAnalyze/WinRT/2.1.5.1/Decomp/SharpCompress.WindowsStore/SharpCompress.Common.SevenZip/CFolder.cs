using System;
using System.Collections.Generic;
using SharpCompress.Compressor.LZMA;

namespace SharpCompress.Common.SevenZip;

internal class CFolder
{
	internal List<CCoderInfo> Coders = new List<CCoderInfo>();

	internal List<CBindPair> BindPairs = new List<CBindPair>();

	internal List<int> PackStreams = new List<int>();

	internal int FirstPackStreamId;

	internal List<long> UnpackSizes = new List<long>();

	internal uint? UnpackCRC;

	internal bool UnpackCRCDefined => UnpackCRC.HasValue;

	public long GetUnpackSize()
	{
		if (UnpackSizes.Count == 0)
		{
			return 0L;
		}
		for (int num = UnpackSizes.Count - 1; num >= 0; num--)
		{
			if (FindBindPairForOutStream(num) < 0)
			{
				return UnpackSizes[num];
			}
		}
		throw new Exception();
	}

	public int GetNumOutStreams()
	{
		int num = 0;
		for (int i = 0; i < Coders.Count; i++)
		{
			num += Coders[i].NumOutStreams;
		}
		return num;
	}

	public int FindBindPairForInStream(int inStreamIndex)
	{
		for (int i = 0; i < BindPairs.Count; i++)
		{
			if (BindPairs[i].InIndex == inStreamIndex)
			{
				return i;
			}
		}
		return -1;
	}

	public int FindBindPairForOutStream(int outStreamIndex)
	{
		for (int i = 0; i < BindPairs.Count; i++)
		{
			if (BindPairs[i].OutIndex == outStreamIndex)
			{
				return i;
			}
		}
		return -1;
	}

	public int FindPackStreamArrayIndex(int inStreamIndex)
	{
		for (int i = 0; i < PackStreams.Count; i++)
		{
			if (PackStreams[i] == inStreamIndex)
			{
				return i;
			}
		}
		return -1;
	}

	public bool IsEncrypted()
	{
		for (int num = Coders.Count - 1; num >= 0; num--)
		{
			if (Coders[num].MethodId == CMethodId.kAES)
			{
				return true;
			}
		}
		return false;
	}

	public bool CheckStructure()
	{
		if (Coders.Count > 32 || BindPairs.Count > 32)
		{
			return false;
		}
		BitVector bitVector = new BitVector(BindPairs.Count + PackStreams.Count);
		for (int i = 0; i < BindPairs.Count; i++)
		{
			if (bitVector.GetAndSet(BindPairs[i].InIndex))
			{
				return false;
			}
		}
		for (int j = 0; j < PackStreams.Count; j++)
		{
			if (bitVector.GetAndSet(PackStreams[j]))
			{
				return false;
			}
		}
		BitVector bitVector2 = new BitVector(UnpackSizes.Count);
		for (int k = 0; k < BindPairs.Count; k++)
		{
			if (bitVector2.GetAndSet(BindPairs[k].OutIndex))
			{
				return false;
			}
		}
		uint[] array = new uint[32];
		List<int> list = new List<int>();
		List<int> list2 = new List<int>();
		for (int l = 0; l < Coders.Count; l++)
		{
			CCoderInfo cCoderInfo = Coders[l];
			for (int m = 0; m < cCoderInfo.NumInStreams; m++)
			{
				list.Add(l);
			}
			for (int n = 0; n < cCoderInfo.NumOutStreams; n++)
			{
				list2.Add(l);
			}
		}
		for (int num = 0; num < BindPairs.Count; num++)
		{
			CBindPair cBindPair = BindPairs[num];
			array[list[cBindPair.InIndex]] |= (uint)(1 << list2[cBindPair.OutIndex]);
		}
		for (int num2 = 0; num2 < 32; num2++)
		{
			for (int num3 = 0; num3 < 32; num3++)
			{
				if (((uint)(1 << num3) & array[num2]) != 0)
				{
					array[num2] |= array[num3];
				}
			}
		}
		for (int num4 = 0; num4 < 32; num4++)
		{
			if (((uint)(1 << num4) & array[num4]) != 0)
			{
				return false;
			}
		}
		return true;
	}
}
