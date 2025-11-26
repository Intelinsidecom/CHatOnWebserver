namespace SharpCompress.Compressor.LZMA.Utilites;

internal enum BlockType : byte
{
	End,
	Header,
	ArchiveProperties,
	AdditionalStreamsInfo,
	MainStreamsInfo,
	FilesInfo,
	PackInfo,
	UnpackInfo,
	SubStreamsInfo,
	Size,
	CRC,
	Folder,
	CodersUnpackSize,
	NumUnpackStream,
	EmptyStream,
	EmptyFile,
	Anti,
	Name,
	CTime,
	ATime,
	MTime,
	WinAttributes,
	Comment,
	EncodedHeader,
	StartPos,
	Dummy
}
