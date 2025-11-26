using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common.Rar.Headers;
using SharpCompress.IO;

namespace SharpCompress.Common.Rar;

public abstract class RarVolume : Volume
{
	private readonly RarHeaderFactory headerFactory;

	public string Password { get; set; }

	internal StreamingMode Mode => headerFactory.StreamingMode;

	internal ArchiveHeader ArchiveHeader { get; private set; }

	public override bool IsFirstVolume
	{
		get
		{
			EnsureArchiveHeaderLoaded();
			return ArchiveHeader.ArchiveHeaderFlags.HasFlag(ArchiveFlags.FIRSTVOLUME);
		}
	}

	public override bool IsMultiVolume
	{
		get
		{
			EnsureArchiveHeaderLoaded();
			return ArchiveHeader.ArchiveHeaderFlags.HasFlag(ArchiveFlags.VOLUME);
		}
	}

	public bool IsSolidArchive
	{
		get
		{
			EnsureArchiveHeaderLoaded();
			return ArchiveHeader.ArchiveHeaderFlags.HasFlag(ArchiveFlags.SOLID);
		}
	}

	internal RarVolume(StreamingMode mode, Stream stream, Options options)
		: this(mode, stream, null, options)
	{
	}

	internal RarVolume(StreamingMode mode, Stream stream, string password, Options options)
		: base(stream, options)
	{
		headerFactory = new RarHeaderFactory(mode, options, password);
	}

	internal abstract IEnumerable<RarFilePart> ReadFileParts();

	internal abstract RarFilePart CreateFilePart(FileHeader fileHeader, MarkHeader markHeader);

	internal IEnumerable<RarFilePart> GetVolumeFileParts()
	{
		MarkHeader previousMarkHeader = null;
		foreach (RarHeader header in headerFactory.ReadHeaders(base.Stream))
		{
			switch (header.HeaderType)
			{
			case HeaderType.ArchiveHeader:
				ArchiveHeader = header as ArchiveHeader;
				break;
			case HeaderType.MarkHeader:
				previousMarkHeader = header as MarkHeader;
				break;
			case HeaderType.FileHeader:
			{
				FileHeader fh = header as FileHeader;
				yield return CreateFilePart(fh, previousMarkHeader);
				break;
			}
			}
		}
	}

	private void EnsureArchiveHeaderLoaded()
	{
		if (ArchiveHeader == null)
		{
			if (Mode == StreamingMode.Streaming)
			{
				throw new InvalidOperationException("ArchiveHeader should never been null in a streaming read.");
			}
			GetVolumeFileParts().First();
			base.Stream.Position = 0L;
		}
	}
}
