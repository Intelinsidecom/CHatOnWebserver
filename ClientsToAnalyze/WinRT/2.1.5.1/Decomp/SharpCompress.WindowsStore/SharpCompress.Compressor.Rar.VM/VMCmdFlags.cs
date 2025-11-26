namespace SharpCompress.Compressor.Rar.VM;

internal class VMCmdFlags
{
	public const byte VMCF_OP0 = 0;

	public const byte VMCF_OP1 = 1;

	public const byte VMCF_OP2 = 2;

	public const byte VMCF_OPMASK = 3;

	public const byte VMCF_BYTEMODE = 4;

	public const byte VMCF_JUMP = 8;

	public const byte VMCF_PROC = 16;

	public const byte VMCF_USEFLAGS = 32;

	public const byte VMCF_CHFLAGS = 64;

	public static byte[] VM_CmdFlags = new byte[40]
	{
		6, 70, 70, 70, 41, 41, 69, 69, 9, 70,
		70, 70, 70, 41, 41, 41, 41, 41, 41, 1,
		1, 17, 16, 5, 70, 70, 70, 69, 0, 0,
		32, 64, 2, 2, 6, 6, 6, 102, 102, 0
	};
}
