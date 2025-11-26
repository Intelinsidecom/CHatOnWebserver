using System;
using System.IO;
using System.Linq;
using SharpCompress.Common.SevenZip;
using SharpCompress.Compressor.BZip2;
using SharpCompress.Compressor.Filters;
using SharpCompress.Compressor.LZMA.Utilites;
using SharpCompress.Compressor.PPMd;

namespace SharpCompress.Compressor.LZMA;

internal static class DecoderRegistry
{
	private const uint k_Copy = 0u;

	private const uint k_Delta = 3u;

	private const uint k_LZMA2 = 33u;

	private const uint k_LZMA = 196865u;

	private const uint k_PPMD = 197633u;

	private const uint k_BCJ = 50528515u;

	private const uint k_BCJ2 = 50528539u;

	private const uint k_Deflate = 262408u;

	private const uint k_BZip2 = 262658u;

	internal static Stream CreateDecoderStream(CMethodId id, Stream[] inStreams, byte[] info, IPasswordProvider pass, long limit)
	{
		switch (id.Id)
		{
		case 0uL:
			if (info != null)
			{
				throw new NotSupportedException();
			}
			return inStreams.Single();
		case 33uL:
		case 196865uL:
			return new LzmaStream(info, inStreams.Single(), -1L, limit);
		case 50528515uL:
			return new BCJFilter(isEncoder: false, inStreams.Single());
		case 50528539uL:
			return new Bcj2DecoderStream(inStreams, info, limit);
		case 262658uL:
			return new BZip2Stream(inStreams.Single(), CompressionMode.Decompress, leaveOpen: true);
		case 197633uL:
			return new PpmdStream(new PpmdProperties(info), inStreams.Single(), compress: false);
		default:
			throw new NotSupportedException();
		}
	}
}
