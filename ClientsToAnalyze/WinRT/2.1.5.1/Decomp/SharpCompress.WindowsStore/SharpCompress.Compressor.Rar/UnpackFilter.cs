using SharpCompress.Compressor.Rar.VM;

namespace SharpCompress.Compressor.Rar;

internal class UnpackFilter
{
	internal int BlockStart { get; set; }

	internal int BlockLength { get; set; }

	internal int ExecCount { get; set; }

	internal bool NextWindow { get; set; }

	internal int ParentFilter { get; set; }

	internal VMPreparedProgram Program { get; set; }

	internal UnpackFilter()
	{
		Program = new VMPreparedProgram();
	}
}
