namespace SharpCompress.Common.Rar.Headers;

internal enum HeaderType
{
	MarkHeader = 114,
	ArchiveHeader,
	FileHeader,
	CommHeader,
	AvHeader,
	SubHeader,
	ProtectHeader,
	SignHeader,
	NewSubHeader,
	EndArchiveHeader
}
