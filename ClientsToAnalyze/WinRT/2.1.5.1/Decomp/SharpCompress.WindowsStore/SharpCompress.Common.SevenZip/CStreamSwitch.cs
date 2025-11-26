using System;
using System.Collections.Generic;
using SharpCompress.Compressor.LZMA;

namespace SharpCompress.Common.SevenZip;

internal struct CStreamSwitch : IDisposable
{
	private ArchiveReader _archive;

	private bool _needRemove;

	private bool _active;

	public void Dispose()
	{
		if (_active)
		{
			_active = false;
			Log.WriteLine("[end of switch]");
		}
		if (_needRemove)
		{
			_needRemove = false;
			_archive.DeleteByteStream();
		}
	}

	public void Set(ArchiveReader archive, byte[] dataVector)
	{
		Dispose();
		_archive = archive;
		_archive.AddByteStream(dataVector, 0, dataVector.Length);
		_needRemove = true;
		_active = true;
	}

	public void Set(ArchiveReader archive, List<byte[]> dataVector)
	{
		Dispose();
		_active = true;
		if (archive.ReadByte() != 0)
		{
			int num = archive.ReadNum();
			if (num < 0 || num >= dataVector.Count)
			{
				throw new InvalidOperationException();
			}
			Log.WriteLine("[switch to stream {0}]", num);
			_archive = archive;
			_archive.AddByteStream(dataVector[num], 0, dataVector[num].Length);
			_needRemove = true;
			_active = true;
		}
		else
		{
			Log.WriteLine("[inline data]");
		}
	}
}
