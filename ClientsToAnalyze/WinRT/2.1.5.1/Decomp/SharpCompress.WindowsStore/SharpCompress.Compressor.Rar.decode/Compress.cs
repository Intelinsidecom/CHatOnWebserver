namespace SharpCompress.Compressor.Rar.decode;

internal class Compress
{
	public const int CODEBUFSIZE = 16384;

	public const int MAXWINSIZE = 4194304;

	public const int LOW_DIST_REP_COUNT = 16;

	public const int NC = 299;

	public const int DC = 60;

	public const int LDC = 17;

	public const int RC = 28;

	public const int BC = 20;

	public const int NC20 = 298;

	public const int DC20 = 48;

	public const int RC20 = 28;

	public const int BC20 = 19;

	public const int MC20 = 257;

	public static readonly int MAXWINMASK = 4194303;

	public static readonly int HUFF_TABLE_SIZE = 404;
}
