using System.Collections.Generic;

namespace SharpCompress.Compressor.Rar.VM;

internal class VMPreparedProgram
{
	internal List<VMPreparedCommand> Commands = new List<VMPreparedCommand>();

	internal List<VMPreparedCommand> AltCommands = new List<VMPreparedCommand>();

	internal List<byte> GlobalData = new List<byte>();

	internal List<byte> StaticData = new List<byte>();

	internal int[] InitR = new int[7];

	public int CommandCount { get; set; }

	internal int FilteredDataOffset { get; set; }

	internal int FilteredDataSize { get; set; }
}
