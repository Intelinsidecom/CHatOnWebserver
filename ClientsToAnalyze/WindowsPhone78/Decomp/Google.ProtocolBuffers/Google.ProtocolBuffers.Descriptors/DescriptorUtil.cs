using System.Collections.Generic;
using Google.ProtocolBuffers.Collections;

namespace Google.ProtocolBuffers.Descriptors;

internal static class DescriptorUtil
{
	internal delegate TOutput IndexedConverter<TInput, TOutput>(TInput element, int index);

	internal static IList<TOutput> ConvertAndMakeReadOnly<TInput, TOutput>(IList<TInput> input, IndexedConverter<TInput, TOutput> converter)
	{
		TOutput[] array = new TOutput[input.Count];
		for (int i = 0; i < array.Length; i++)
		{
			array[i] = converter(input[i], i);
		}
		return Lists<TOutput>.AsReadOnly(array);
	}
}
