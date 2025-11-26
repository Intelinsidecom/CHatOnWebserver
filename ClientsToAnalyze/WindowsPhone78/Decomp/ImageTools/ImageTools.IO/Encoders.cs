using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics.CodeAnalysis;
using System.Diagnostics.Contracts;

namespace ImageTools.IO;

public static class Encoders
{
	private static List<Type> _encoderTypes = new List<Type>();

	public static void AddEncoder<TEncoder>() where TEncoder : IImageEncoder
	{
		if (!_encoderTypes.Contains(typeof(TEncoder)))
		{
			_encoderTypes.Add(typeof(TEncoder));
		}
	}

	[SuppressMessage("Microsoft.Design", "CA1024:UsePropertiesWhereAppropriate")]
	public static ReadOnlyCollection<IImageEncoder> GetAvailableEncoders()
	{
		Contract.Ensures(Contract.Result<ReadOnlyCollection<IImageEncoder>>() != null);
		List<IImageEncoder> list = new List<IImageEncoder>();
		foreach (Type encoderType in _encoderTypes)
		{
			if (encoderType != null)
			{
				list.Add(Activator.CreateInstance(encoderType) as IImageEncoder);
			}
		}
		return new ReadOnlyCollection<IImageEncoder>(list);
	}
}
