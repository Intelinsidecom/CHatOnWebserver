using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics.CodeAnalysis;

namespace ImageTools.IO;

public static class Decoders
{
	private static List<Type> _decoderTypes = new List<Type>();

	public static void AddDecoder<TDecoder>() where TDecoder : IImageDecoder
	{
		if (!_decoderTypes.Contains(typeof(TDecoder)))
		{
			_decoderTypes.Add(typeof(TDecoder));
		}
	}

	[SuppressMessage("Microsoft.Design", "CA1024:UsePropertiesWhereAppropriate")]
	public static ReadOnlyCollection<IImageDecoder> GetAvailableDecoders()
	{
		List<IImageDecoder> list = new List<IImageDecoder>();
		foreach (Type decoderType in _decoderTypes)
		{
			if (decoderType != null)
			{
				list.Add(Activator.CreateInstance(decoderType) as IImageDecoder);
			}
		}
		return new ReadOnlyCollection<IImageDecoder>(list);
	}
}
