namespace SharpCompress.Compressor.LZMA;

internal enum CoderPropID
{
	DefaultProp,
	DictionarySize,
	UsedMemorySize,
	Order,
	BlockSize,
	PosStateBits,
	LitContextBits,
	LitPosBits,
	NumFastBytes,
	MatchFinder,
	MatchFinderCycles,
	NumPasses,
	Algorithm,
	NumThreads,
	EndMarker
}
