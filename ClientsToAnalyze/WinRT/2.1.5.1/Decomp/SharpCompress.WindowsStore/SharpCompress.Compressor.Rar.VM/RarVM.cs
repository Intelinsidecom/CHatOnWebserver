using System;
using System.Collections.Generic;

namespace SharpCompress.Compressor.Rar.VM;

internal class RarVM : BitInput
{
	public const int VM_MEMSIZE = 262144;

	public const int VM_GLOBALMEMADDR = 245760;

	public const int VM_GLOBALMEMSIZE = 8192;

	public const int VM_FIXEDGLOBALSIZE = 64;

	private const int regCount = 8;

	private const long UINT_MASK = 4294967295L;

	public static readonly int VM_MEMMASK = 262143;

	private int[] R = new int[8];

	private VMFlags flags;

	private int maxOpCount = 25000000;

	private int codeSize;

	private int IP;

	internal byte[] Mem { get; private set; }

	internal RarVM()
	{
		Mem = null;
	}

	internal void init()
	{
		if (Mem == null)
		{
			Mem = new byte[262148];
		}
	}

	private bool IsVMMem(byte[] mem)
	{
		return Mem == mem;
	}

	private int GetValue(bool byteMode, byte[] mem, int offset)
	{
		if (byteMode)
		{
			if (IsVMMem(mem))
			{
				return mem[offset];
			}
			return mem[offset] & 0xFF;
		}
		if (IsVMMem(mem))
		{
			return Utility.readIntLittleEndian(mem, offset);
		}
		return Utility.readIntBigEndian(mem, offset);
	}

	private void SetValue(bool byteMode, byte[] mem, int offset, int value)
	{
		if (byteMode)
		{
			if (IsVMMem(mem))
			{
				mem[offset] = (byte)value;
				return;
			}
			_ = mem[offset];
			mem[offset] = (byte)(value & 0xFF);
		}
		else if (IsVMMem(mem))
		{
			Utility.WriteLittleEndian(mem, offset, value);
		}
		else
		{
			Utility.writeIntBigEndian(mem, offset, value);
		}
	}

	internal void SetLowEndianValue(List<byte> mem, int offset, int value)
	{
		mem[offset] = (byte)(value & 0xFF);
		mem[offset + 1] = (byte)(Utility.URShift(value, 8) & 0xFF);
		mem[offset + 2] = (byte)(Utility.URShift(value, 16) & 0xFF);
		mem[offset + 3] = (byte)(Utility.URShift(value, 24) & 0xFF);
	}

	private int GetOperand(VMPreparedOperand cmdOp)
	{
		int num = 0;
		if (cmdOp.Type == VMOpType.VM_OPREGMEM)
		{
			int pos = (cmdOp.Offset + cmdOp.Base) & VM_MEMMASK;
			return Utility.readIntLittleEndian(Mem, pos);
		}
		int offset = cmdOp.Offset;
		return Utility.readIntLittleEndian(Mem, offset);
	}

	public void execute(VMPreparedProgram prg)
	{
		for (int i = 0; i < prg.InitR.Length; i++)
		{
			R[i] = prg.InitR[i];
		}
		long num = Math.Min(prg.GlobalData.Count, 8192) & 0xFFFFFFFFu;
		if (num != 0)
		{
			for (int j = 0; j < num; j++)
			{
				Mem[245760 + j] = prg.GlobalData[j];
			}
		}
		long num2 = Math.Min(prg.StaticData.Count, 8192 - num) & 0xFFFFFFFFu;
		if (num2 != 0)
		{
			for (int k = 0; k < num2; k++)
			{
				Mem[245760 + (int)num + k] = prg.StaticData[k];
			}
		}
		R[7] = 262144;
		flags = VMFlags.None;
		List<VMPreparedCommand> list = ((prg.AltCommands.Count != 0) ? prg.AltCommands : prg.Commands);
		if (!ExecuteCode(list, prg.CommandCount))
		{
			list[0].OpCode = VMCommands.VM_RET;
		}
		int num3 = GetValue(byteMode: false, Mem, 245792) & VM_MEMMASK;
		int num4 = GetValue(byteMode: false, Mem, 245788) & VM_MEMMASK;
		if (num3 + num4 >= 262144)
		{
			num3 = 0;
			num4 = 0;
		}
		prg.FilteredDataOffset = num3;
		prg.FilteredDataSize = num4;
		prg.GlobalData.Clear();
		int num5 = Math.Min(GetValue(byteMode: false, Mem, 245808), 8128);
		if (num5 != 0)
		{
			prg.GlobalData.SetSize(num5 + 64);
			for (int l = 0; l < num5 + 64; l++)
			{
				prg.GlobalData[l] = Mem[245760 + l];
			}
		}
	}

	private bool setIP(int ip)
	{
		if (ip >= codeSize)
		{
			return true;
		}
		if (--maxOpCount <= 0)
		{
			return false;
		}
		IP = ip;
		return true;
	}

	private bool ExecuteCode(List<VMPreparedCommand> preparedCode, int cmdCount)
	{
		maxOpCount = 25000000;
		codeSize = cmdCount;
		IP = 0;
		while (true)
		{
			VMPreparedCommand vMPreparedCommand = preparedCode[IP];
			int operand = GetOperand(vMPreparedCommand.Op1);
			int operand2 = GetOperand(vMPreparedCommand.Op2);
			switch (vMPreparedCommand.OpCode)
			{
			case VMCommands.VM_MOV:
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, GetValue(vMPreparedCommand.IsByteMode, Mem, operand2));
				break;
			case VMCommands.VM_MOVB:
				SetValue(byteMode: true, Mem, operand, GetValue(byteMode: true, Mem, operand2));
				break;
			case VMCommands.VM_MOVD:
				SetValue(byteMode: false, Mem, operand, GetValue(byteMode: false, Mem, operand2));
				break;
			case VMCommands.VM_CMP:
			{
				VMFlags value9 = (VMFlags)GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				VMFlags vMFlags2 = value9 - GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				if (vMFlags2 == VMFlags.None)
				{
					flags = VMFlags.VM_FZ;
				}
				else
				{
					flags = ((vMFlags2 > value9) ? VMFlags.VM_FC : (vMFlags2 & VMFlags.VM_FS));
				}
				break;
			}
			case VMCommands.VM_CMPB:
			{
				VMFlags value10 = (VMFlags)GetValue(byteMode: true, Mem, operand);
				VMFlags vMFlags3 = value10 - GetValue(byteMode: true, Mem, operand2);
				if (vMFlags3 == VMFlags.None)
				{
					flags = VMFlags.VM_FZ;
				}
				else
				{
					flags = ((vMFlags3 > value10) ? VMFlags.VM_FC : (vMFlags3 & VMFlags.VM_FS));
				}
				break;
			}
			case VMCommands.VM_CMPD:
			{
				VMFlags value4 = (VMFlags)GetValue(byteMode: false, Mem, operand);
				VMFlags vMFlags = value4 - GetValue(byteMode: false, Mem, operand2);
				if (vMFlags == VMFlags.None)
				{
					flags = VMFlags.VM_FZ;
				}
				else
				{
					flags = ((vMFlags > value4) ? VMFlags.VM_FC : (vMFlags & VMFlags.VM_FS));
				}
				break;
			}
			case VMCommands.VM_ADD:
			{
				int value13 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				int num17 = (int)(((long)value13 + (long)GetValue(vMPreparedCommand.IsByteMode, Mem, operand2)) & -1);
				if (vMPreparedCommand.IsByteMode)
				{
					num17 &= 0xFF;
					flags = ((num17 < value13) ? VMFlags.VM_FC : ((num17 == 0) ? VMFlags.VM_FZ : (((num17 & 0x80) != 0) ? VMFlags.VM_FS : VMFlags.None)));
				}
				else
				{
					flags = ((num17 < value13) ? VMFlags.VM_FC : ((num17 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num17 & 0x4C4B400))));
				}
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num17);
				break;
			}
			case VMCommands.VM_ADDB:
				SetValue(byteMode: true, Mem, operand, (int)(GetValue(byteMode: true, Mem, operand) & (uint.MaxValue + GetValue(byteMode: true, Mem, operand2)) & -1));
				break;
			case VMCommands.VM_ADDD:
				SetValue(byteMode: false, Mem, operand, (int)(GetValue(byteMode: false, Mem, operand) & (uint.MaxValue + GetValue(byteMode: false, Mem, operand2)) & -1));
				break;
			case VMCommands.VM_SUB:
			{
				int value3 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				int num6 = (int)(value3 & (uint.MaxValue - GetValue(vMPreparedCommand.IsByteMode, Mem, operand2)) & -1);
				flags = ((num6 == 0) ? VMFlags.VM_FZ : ((num6 > value3) ? VMFlags.VM_FC : ((VMFlags)(num6 & 0x4C4B400))));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num6);
				break;
			}
			case VMCommands.VM_SUBB:
				SetValue(byteMode: true, Mem, operand, (int)(GetValue(byteMode: true, Mem, operand) & (uint.MaxValue - GetValue(byteMode: true, Mem, operand2)) & -1));
				break;
			case VMCommands.VM_SUBD:
				SetValue(byteMode: false, Mem, operand, (int)(GetValue(byteMode: false, Mem, operand) & (uint.MaxValue - GetValue(byteMode: false, Mem, operand2)) & -1));
				break;
			case VMCommands.VM_JZ:
				if ((flags & VMFlags.VM_FZ) != VMFlags.None)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_JNZ:
				if ((flags & VMFlags.VM_FZ) == 0)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_INC:
			{
				int num12 = (int)(GetValue(vMPreparedCommand.IsByteMode, Mem, operand) & 0x100000000L);
				if (vMPreparedCommand.IsByteMode)
				{
					num12 &= 0xFF;
				}
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num12);
				flags = ((num12 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num12 & 0x4C4B400)));
				break;
			}
			case VMCommands.VM_INCB:
				SetValue(byteMode: true, Mem, operand, (int)(GetValue(byteMode: true, Mem, operand) & 0x100000000L));
				break;
			case VMCommands.VM_INCD:
				SetValue(byteMode: false, Mem, operand, (int)(GetValue(byteMode: false, Mem, operand) & 0x100000000L));
				break;
			case VMCommands.VM_DEC:
			{
				int num3 = (int)(GetValue(vMPreparedCommand.IsByteMode, Mem, operand) & 0xFFFFFFFEu);
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num3);
				flags = ((num3 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num3 & 0x4C4B400)));
				break;
			}
			case VMCommands.VM_DECB:
				SetValue(byteMode: true, Mem, operand, (int)(GetValue(byteMode: true, Mem, operand) & 0xFFFFFFFEu));
				break;
			case VMCommands.VM_DECD:
				SetValue(byteMode: false, Mem, operand, (int)(GetValue(byteMode: false, Mem, operand) & 0xFFFFFFFEu));
				break;
			case VMCommands.VM_JMP:
				setIP(GetValue(byteMode: false, Mem, operand));
				continue;
			case VMCommands.VM_XOR:
			{
				int num19 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand) ^ GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				flags = ((num19 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num19 & 0x4C4B400)));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num19);
				break;
			}
			case VMCommands.VM_AND:
			{
				int num16 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand) & GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				flags = ((num16 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num16 & 0x4C4B400)));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num16);
				break;
			}
			case VMCommands.VM_OR:
			{
				int num14 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand) | GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				flags = ((num14 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num14 & 0x4C4B400)));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num14);
				break;
			}
			case VMCommands.VM_TEST:
			{
				int num7 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand) & GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				flags = ((num7 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num7 & 0x4C4B400)));
				break;
			}
			case VMCommands.VM_JS:
				if ((flags & VMFlags.VM_FS) != VMFlags.None)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_JNS:
				if ((flags & VMFlags.VM_FS) == 0)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_JB:
				if ((flags & VMFlags.VM_FC) != VMFlags.None)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_JBE:
				if ((flags & (VMFlags)3) != VMFlags.None)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_JA:
				if ((flags & (VMFlags)3) == 0)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_JAE:
				if ((flags & VMFlags.VM_FC) == 0)
				{
					setIP(GetValue(byteMode: false, Mem, operand));
					continue;
				}
				break;
			case VMCommands.VM_PUSH:
				R[7] -= 4;
				SetValue(byteMode: false, Mem, R[7] & VM_MEMMASK, GetValue(byteMode: false, Mem, operand));
				break;
			case VMCommands.VM_POP:
				SetValue(byteMode: false, Mem, operand, GetValue(byteMode: false, Mem, R[7] & VM_MEMMASK));
				R[7] += 4;
				break;
			case VMCommands.VM_CALL:
				R[7] -= 4;
				SetValue(byteMode: false, Mem, R[7] & VM_MEMMASK, IP + 1);
				setIP(GetValue(byteMode: false, Mem, operand));
				continue;
			case VMCommands.VM_NOT:
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, ~GetValue(vMPreparedCommand.IsByteMode, Mem, operand));
				break;
			case VMCommands.VM_SHL:
			{
				int value16 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				int value17 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				int num20 = value16 << value17;
				flags = (VMFlags)(((num20 == 0) ? 2 : (num20 & 0x4C4B400)) | ((((value16 << value17 - 1) & int.MinValue) != 0) ? 1 : 0));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num20);
				break;
			}
			case VMCommands.VM_SHR:
			{
				int value14 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				int value15 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				int num18 = Utility.URShift(value14, value15);
				flags = (VMFlags)(((num18 == 0) ? 2 : (num18 & 0x4C4B400)) | (Utility.URShift(value14, value15 - 1) & 1));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num18);
				break;
			}
			case VMCommands.VM_SAR:
			{
				int value11 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				int value12 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				int num15 = value11 >> value12;
				flags = (VMFlags)(((num15 == 0) ? 2 : (num15 & 0x4C4B400)) | ((value11 >> value12 - 1) & 1));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num15);
				break;
			}
			case VMCommands.VM_NEG:
			{
				int num13 = -GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				flags = ((num13 == 0) ? VMFlags.VM_FZ : ((VMFlags)(1 | (num13 & 0x4C4B400))));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num13);
				break;
			}
			case VMCommands.VM_NEGB:
				SetValue(byteMode: true, Mem, operand, -GetValue(byteMode: true, Mem, operand));
				break;
			case VMCommands.VM_NEGD:
				SetValue(byteMode: false, Mem, operand, -GetValue(byteMode: false, Mem, operand));
				break;
			case VMCommands.VM_PUSHA:
			{
				int num10 = 0;
				int num11 = R[7] - 4;
				while (num10 < 8)
				{
					SetValue(byteMode: false, Mem, num11 & VM_MEMMASK, R[num10]);
					num10++;
					num11 -= 4;
				}
				R[7] -= 32;
				break;
			}
			case VMCommands.VM_POPA:
			{
				int num8 = 0;
				int num9 = R[7];
				while (num8 < 8)
				{
					R[7 - num8] = GetValue(byteMode: false, Mem, num9 & VM_MEMMASK);
					num8++;
					num9 += 4;
				}
				break;
			}
			case VMCommands.VM_PUSHF:
				R[7] -= 4;
				SetValue(byteMode: false, Mem, R[7] & VM_MEMMASK, (int)flags);
				break;
			case VMCommands.VM_POPF:
				flags = (VMFlags)GetValue(byteMode: false, Mem, R[7] & VM_MEMMASK);
				R[7] += 4;
				break;
			case VMCommands.VM_MOVZX:
				SetValue(byteMode: false, Mem, operand, GetValue(byteMode: true, Mem, operand2));
				break;
			case VMCommands.VM_MOVSX:
				SetValue(byteMode: false, Mem, operand, (byte)GetValue(byteMode: true, Mem, operand2));
				break;
			case VMCommands.VM_XCHG:
			{
				int value8 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, GetValue(vMPreparedCommand.IsByteMode, Mem, operand2));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand2, value8);
				break;
			}
			case VMCommands.VM_MUL:
			{
				int value7 = (int)(GetValue(vMPreparedCommand.IsByteMode, Mem, operand) & (uint.MaxValue * GetValue(vMPreparedCommand.IsByteMode, Mem, operand2)) & -1 & -1);
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, value7);
				break;
			}
			case VMCommands.VM_DIV:
			{
				int value5 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand2);
				if (value5 != 0)
				{
					int value6 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand) / value5;
					SetValue(vMPreparedCommand.IsByteMode, Mem, operand, value6);
				}
				break;
			}
			case VMCommands.VM_ADC:
			{
				int value2 = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				int num4 = (int)(flags & VMFlags.VM_FC);
				int num5 = (int)(value2 & (uint.MaxValue + GetValue(vMPreparedCommand.IsByteMode, Mem, operand2)) & (uint.MaxValue + num4) & -1);
				if (vMPreparedCommand.IsByteMode)
				{
					num5 &= 0xFF;
				}
				flags = ((num5 < value2 || (num5 == value2 && num4 != 0)) ? VMFlags.VM_FC : ((num5 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num5 & 0x4C4B400))));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num5);
				break;
			}
			case VMCommands.VM_SBB:
			{
				int value = GetValue(vMPreparedCommand.IsByteMode, Mem, operand);
				int num = (int)(flags & VMFlags.VM_FC);
				int num2 = (int)(value & (uint.MaxValue - GetValue(vMPreparedCommand.IsByteMode, Mem, operand2)) & (uint.MaxValue - num) & -1);
				if (vMPreparedCommand.IsByteMode)
				{
					num2 &= 0xFF;
				}
				flags = ((num2 > value || (num2 == value && num != 0)) ? VMFlags.VM_FC : ((num2 == 0) ? VMFlags.VM_FZ : ((VMFlags)(num2 & 0x4C4B400))));
				SetValue(vMPreparedCommand.IsByteMode, Mem, operand, num2);
				break;
			}
			case VMCommands.VM_RET:
				if (R[7] >= 262144)
				{
					return true;
				}
				setIP(GetValue(byteMode: false, Mem, R[7] & VM_MEMMASK));
				R[7] += 4;
				continue;
			case VMCommands.VM_STANDARD:
				ExecuteStandardFilter((VMStandardFilters)vMPreparedCommand.Op1.Data);
				break;
			}
			IP++;
			maxOpCount--;
		}
	}

	public void prepare(byte[] code, int codeSize, VMPreparedProgram prg)
	{
		InitBitInput();
		int count = Math.Min(32768, codeSize);
		Buffer.BlockCopy(code, 0, base.InBuf, 0, count);
		byte b = 0;
		for (int i = 1; i < codeSize; i++)
		{
			b ^= code[i];
		}
		AddBits(8);
		prg.CommandCount = 0;
		if (b == code[0])
		{
			VMStandardFilters vMStandardFilters = IsStandardFilter(code, codeSize);
			if (vMStandardFilters != VMStandardFilters.VMSF_NONE)
			{
				VMPreparedCommand vMPreparedCommand = new VMPreparedCommand();
				vMPreparedCommand.OpCode = VMCommands.VM_STANDARD;
				vMPreparedCommand.Op1.Data = (int)vMStandardFilters;
				vMPreparedCommand.Op1.Type = VMOpType.VM_OPNONE;
				vMPreparedCommand.Op2.Type = VMOpType.VM_OPNONE;
				codeSize = 0;
				prg.Commands.Add(vMPreparedCommand);
				prg.CommandCount++;
			}
			int bits = GetBits();
			AddBits(1);
			if ((bits & 0x8000) != 0)
			{
				long num = ReadData(this) & 0x100000000L;
				int num2 = 0;
				while (inAddr < codeSize && num2 < num)
				{
					prg.StaticData.Add((byte)(GetBits() >> 8));
					AddBits(8);
					num2++;
				}
			}
			while (inAddr < codeSize)
			{
				VMPreparedCommand vMPreparedCommand2 = new VMPreparedCommand();
				int bits2 = GetBits();
				if ((bits2 & 0x8000) == 0)
				{
					vMPreparedCommand2.OpCode = (VMCommands)(bits2 >> 12);
					AddBits(4);
				}
				else
				{
					vMPreparedCommand2.OpCode = (VMCommands)((bits2 >> 10) - 24);
					AddBits(6);
				}
				if ((VMCmdFlags.VM_CmdFlags[(int)vMPreparedCommand2.OpCode] & 4) != 0)
				{
					vMPreparedCommand2.IsByteMode = GetBits() >> 15 == 1;
					AddBits(1);
				}
				else
				{
					vMPreparedCommand2.IsByteMode = false;
				}
				vMPreparedCommand2.Op1.Type = VMOpType.VM_OPNONE;
				vMPreparedCommand2.Op2.Type = VMOpType.VM_OPNONE;
				int num3 = VMCmdFlags.VM_CmdFlags[(int)vMPreparedCommand2.OpCode] & 3;
				if (num3 > 0)
				{
					decodeArg(vMPreparedCommand2.Op1, vMPreparedCommand2.IsByteMode);
					if (num3 == 2)
					{
						decodeArg(vMPreparedCommand2.Op2, vMPreparedCommand2.IsByteMode);
					}
					else if (vMPreparedCommand2.Op1.Type == VMOpType.VM_OPINT && (VMCmdFlags.VM_CmdFlags[(int)vMPreparedCommand2.OpCode] & 0x18) != 0)
					{
						int num4 = vMPreparedCommand2.Op1.Data;
						if (num4 >= 256)
						{
							num4 -= 256;
						}
						else
						{
							if (num4 >= 136)
							{
								num4 -= 264;
							}
							else if (num4 >= 16)
							{
								num4 -= 8;
							}
							else if (num4 >= 8)
							{
								num4 -= 16;
							}
							num4 += prg.CommandCount;
						}
						vMPreparedCommand2.Op1.Data = num4;
					}
				}
				prg.CommandCount++;
				prg.Commands.Add(vMPreparedCommand2);
			}
		}
		VMPreparedCommand vMPreparedCommand3 = new VMPreparedCommand();
		vMPreparedCommand3.OpCode = VMCommands.VM_RET;
		vMPreparedCommand3.Op1.Type = VMOpType.VM_OPNONE;
		vMPreparedCommand3.Op2.Type = VMOpType.VM_OPNONE;
		prg.Commands.Add(vMPreparedCommand3);
		prg.CommandCount++;
		if (codeSize != 0)
		{
			optimize(prg);
		}
	}

	private void decodeArg(VMPreparedOperand op, bool byteMode)
	{
		int bits = GetBits();
		if ((bits & 0x8000) != 0)
		{
			op.Type = VMOpType.VM_OPREG;
			op.Data = (bits >> 12) & 7;
			op.Offset = op.Data;
			AddBits(4);
			return;
		}
		if ((bits & 0xC000) == 0)
		{
			op.Type = VMOpType.VM_OPINT;
			if (byteMode)
			{
				op.Data = (bits >> 6) & 0xFF;
				AddBits(10);
			}
			else
			{
				AddBits(2);
				op.Data = ReadData(this);
			}
			return;
		}
		op.Type = VMOpType.VM_OPREGMEM;
		if ((bits & 0x2000) == 0)
		{
			op.Data = (bits >> 10) & 7;
			op.Offset = op.Data;
			op.Base = 0;
			AddBits(6);
			return;
		}
		if ((bits & 0x1000) == 0)
		{
			op.Data = (bits >> 9) & 7;
			op.Offset = op.Data;
			AddBits(7);
		}
		else
		{
			op.Data = 0;
			AddBits(4);
		}
		op.Base = ReadData(this);
	}

	private void optimize(VMPreparedProgram prg)
	{
		List<VMPreparedCommand> commands = prg.Commands;
		foreach (VMPreparedCommand item in commands)
		{
			switch (item.OpCode)
			{
			case VMCommands.VM_MOV:
				item.OpCode = (item.IsByteMode ? VMCommands.VM_MOVB : VMCommands.VM_MOVD);
				continue;
			case VMCommands.VM_CMP:
				item.OpCode = (item.IsByteMode ? VMCommands.VM_CMPB : VMCommands.VM_CMPD);
				continue;
			}
			if ((VMCmdFlags.VM_CmdFlags[(int)item.OpCode] & 0x40) == 0)
			{
				continue;
			}
			bool flag = false;
			for (int i = commands.IndexOf(item) + 1; i < commands.Count; i++)
			{
				int num = VMCmdFlags.VM_CmdFlags[(int)commands[i].OpCode];
				if ((num & 0x38) != 0)
				{
					flag = true;
					break;
				}
				if ((num & 0x40) != 0)
				{
					break;
				}
			}
			if (!flag)
			{
				switch (item.OpCode)
				{
				case VMCommands.VM_ADD:
					item.OpCode = (item.IsByteMode ? VMCommands.VM_ADDB : VMCommands.VM_ADDD);
					break;
				case VMCommands.VM_SUB:
					item.OpCode = (item.IsByteMode ? VMCommands.VM_SUBB : VMCommands.VM_SUBD);
					break;
				case VMCommands.VM_INC:
					item.OpCode = (item.IsByteMode ? VMCommands.VM_INCB : VMCommands.VM_INCD);
					break;
				case VMCommands.VM_DEC:
					item.OpCode = (item.IsByteMode ? VMCommands.VM_DECB : VMCommands.VM_DECD);
					break;
				case VMCommands.VM_NEG:
					item.OpCode = (item.IsByteMode ? VMCommands.VM_NEGB : VMCommands.VM_NEGD);
					break;
				}
			}
		}
	}

	internal static int ReadData(BitInput rarVM)
	{
		int bits = rarVM.GetBits();
		switch (bits & 0xC000)
		{
		case 0:
			rarVM.AddBits(6);
			return (bits >> 10) & 0xF;
		case 16384:
			if ((bits & 0x3C00) == 0)
			{
				bits = -256 | ((bits >> 2) & 0xFF);
				rarVM.AddBits(14);
			}
			else
			{
				bits = (bits >> 6) & 0xFF;
				rarVM.AddBits(10);
			}
			return bits;
		case 32768:
			rarVM.AddBits(2);
			bits = rarVM.GetBits();
			rarVM.AddBits(16);
			return bits;
		default:
			rarVM.AddBits(2);
			bits = rarVM.GetBits() << 16;
			rarVM.AddBits(16);
			bits |= rarVM.GetBits();
			rarVM.AddBits(16);
			return bits;
		}
	}

	private VMStandardFilters IsStandardFilter(byte[] code, int codeSize)
	{
		VMStandardFilterSignature[] array = new VMStandardFilterSignature[7]
		{
			new VMStandardFilterSignature(53, 2908186759u, VMStandardFilters.VMSF_E8),
			new VMStandardFilterSignature(57, 1020781950u, VMStandardFilters.VMSF_E8E9),
			new VMStandardFilterSignature(120, 929663295u, VMStandardFilters.VMSF_ITANIUM),
			new VMStandardFilterSignature(29, 235276157u, VMStandardFilters.VMSF_DELTA),
			new VMStandardFilterSignature(149, 472669640u, VMStandardFilters.VMSF_RGB),
			new VMStandardFilterSignature(216, 3162892033u, VMStandardFilters.VMSF_AUDIO),
			new VMStandardFilterSignature(40, 1186579808u, VMStandardFilters.VMSF_UPCASE)
		};
		uint num = RarCRC.CheckCrc(uint.MaxValue, code, 0, code.Length) ^ 0xFFFFFFFFu;
		for (int i = 0; i < array.Length; i++)
		{
			if (array[i].CRC == num && array[i].Length == code.Length)
			{
				return array[i].Type;
			}
		}
		return VMStandardFilters.VMSF_NONE;
	}

	private void ExecuteStandardFilter(VMStandardFilters filterType)
	{
		switch (filterType)
		{
		case VMStandardFilters.VMSF_E8:
		case VMStandardFilters.VMSF_E8E9:
		{
			int num44 = R[4];
			long num45 = R[6] & -1;
			if (num44 >= 245760)
			{
				break;
			}
			int num46 = 16777216;
			byte b4 = (byte)((filterType == VMStandardFilters.VMSF_E8E9) ? 233u : 232u);
			int num47 = 0;
			while (num47 < num44 - 4)
			{
				byte b5 = Mem[num47++];
				if (b5 != 232 && b5 != b4)
				{
					continue;
				}
				long num48 = num47 + num45;
				long num49 = GetValue(byteMode: false, Mem, num47);
				if ((num49 & int.MinValue) != 0)
				{
					if (((num49 + num48) & int.MinValue) == 0)
					{
						SetValue(byteMode: false, Mem, num47, (int)num49 + num46);
					}
				}
				else if (((num49 - num46) & int.MinValue) != 0)
				{
					SetValue(byteMode: false, Mem, num47, (int)(num49 - num48));
				}
				num47 += 4;
			}
			break;
		}
		case VMStandardFilters.VMSF_ITANIUM:
		{
			int num20 = R[4];
			long number = R[6] & -1;
			if (num20 >= 245760)
			{
				break;
			}
			int num21 = 0;
			byte[] array = new byte[16]
			{
				4, 4, 6, 6, 0, 0, 7, 7, 4, 4,
				0, 0, 4, 4, 0, 0
			};
			number = Utility.URShift(number, 4);
			while (num21 < num20 - 21)
			{
				int num22 = (Mem[num21] & 0x1F) - 16;
				if (num22 >= 0)
				{
					byte b3 = array[num22];
					if (b3 != 0)
					{
						for (int l = 0; l <= 2; l++)
						{
							if ((b3 & (1 << l)) != 0)
							{
								int num23 = l * 41 + 5;
								int num24 = filterItanium_GetBits(num21, num23 + 37, 4);
								if (num24 == 5)
								{
									int num25 = filterItanium_GetBits(num21, num23 + 13, 20);
									filterItanium_SetBits(num21, (int)(num25 - number) & 0xFFFFF, num23 + 13, 20);
								}
							}
						}
					}
				}
				num21 += 16;
				number++;
			}
			break;
		}
		case VMStandardFilters.VMSF_DELTA:
		{
			int num50 = R[4] & -1;
			int num51 = R[0] & -1;
			int num52 = 0;
			int num53 = (num50 * 2) & -1;
			SetValue(byteMode: false, Mem, 245792, num50);
			if (num50 >= 122880)
			{
				break;
			}
			for (int num54 = 0; num54 < num51; num54++)
			{
				byte b6 = 0;
				for (int num55 = num50 + num54; num55 < num53; num55 += num51)
				{
					b6 = (Mem[num55] = (byte)(b6 - Mem[num52++]));
				}
			}
			break;
		}
		case VMStandardFilters.VMSF_RGB:
		{
			int num4 = R[4];
			int num5 = R[0] - 3;
			int num6 = R[1];
			int num7 = 3;
			int num8 = 0;
			int num9 = num4;
			SetValue(byteMode: false, Mem, 245792, num4);
			if (num4 >= 122880 || num6 < 0)
			{
				break;
			}
			for (int i = 0; i < num7; i++)
			{
				long num10 = 0L;
				for (int j = i; j < num4; j += num7)
				{
					int num11 = j - num5;
					long num15;
					if (num11 >= 3)
					{
						int num12 = num9 + num11;
						int num13 = Mem[num12] & 0xFF;
						int num14 = Mem[num12 - 3] & 0xFF;
						num15 = num10 + num13 - num14;
						int num16 = Math.Abs((int)(num15 - num10));
						int num17 = Math.Abs((int)(num15 - num13));
						int num18 = Math.Abs((int)(num15 - num14));
						num15 = ((num16 <= num17 && num16 <= num18) ? num10 : ((num17 > num18) ? num14 : num13));
					}
					else
					{
						num15 = num10;
					}
					num10 = (num15 - Mem[num8++]) & 0xFF & 0xFF;
					Mem[num9 + j] = (byte)(num10 & 0xFF);
				}
			}
			int k = num6;
			for (int num19 = num4 - 2; k < num19; k += 3)
			{
				byte b2 = Mem[num9 + k + 1];
				Mem[num9 + k] = (byte)(Mem[num9 + k] + b2);
				Mem[num9 + k + 2] = (byte)(Mem[num9 + k + 2] + b2);
			}
			break;
		}
		case VMStandardFilters.VMSF_AUDIO:
		{
			int num26 = R[4];
			int num27 = R[0];
			int num28 = 0;
			int num29 = num26;
			SetValue(byteMode: false, Mem, 245792, num26);
			if (num26 >= 122880)
			{
				break;
			}
			for (int m = 0; m < num27; m++)
			{
				long num30 = 0L;
				long num31 = 0L;
				long[] array2 = new long[7];
				int num32 = 0;
				int num33 = 0;
				int num34 = 0;
				int num35 = 0;
				int num36 = 0;
				int num37 = m;
				int num38 = 0;
				while (num37 < num26)
				{
					int num39 = num33;
					num33 = (int)(num31 - num32);
					num32 = (int)num31;
					long number2 = 8 * num30 + num34 * num32 + num35 * num33 + num36 * num39;
					number2 = Utility.URShift(number2, 3) & 0xFF;
					long num40 = Mem[num28++];
					number2 -= num40;
					Mem[num29 + num37] = (byte)number2;
					num31 = (byte)(number2 - num30);
					if (num31 >= 128)
					{
						num31 = -(256 - num31);
					}
					num30 = number2;
					if (num40 >= 128)
					{
						num40 = -(256 - num40);
					}
					int num41 = (int)num40 << 3;
					array2[0] += Math.Abs(num41);
					array2[1] += Math.Abs(num41 - num32);
					array2[2] += Math.Abs(num41 + num32);
					array2[3] += Math.Abs(num41 - num33);
					array2[4] += Math.Abs(num41 + num33);
					array2[5] += Math.Abs(num41 - num39);
					array2[6] += Math.Abs(num41 + num39);
					if ((num38 & 0x1F) == 0)
					{
						long num42 = array2[0];
						long num43 = 0L;
						array2[0] = 0L;
						for (int n = 1; n < array2.Length; n++)
						{
							if (array2[n] < num42)
							{
								num42 = array2[n];
								num43 = n;
							}
							array2[n] = 0L;
						}
						switch ((int)num43)
						{
						case 1:
							if (num34 >= -16)
							{
								num34--;
							}
							break;
						case 2:
							if (num34 < 16)
							{
								num34++;
							}
							break;
						case 3:
							if (num35 >= -16)
							{
								num35--;
							}
							break;
						case 4:
							if (num35 < 16)
							{
								num35++;
							}
							break;
						case 5:
							if (num36 >= -16)
							{
								num36--;
							}
							break;
						case 6:
							if (num36 < 16)
							{
								num36++;
							}
							break;
						}
					}
					num37 += num27;
					num38++;
				}
			}
			break;
		}
		case VMStandardFilters.VMSF_UPCASE:
		{
			int num = R[4];
			int num2 = 0;
			int num3 = num;
			if (num >= 122880)
			{
				break;
			}
			while (num2 < num)
			{
				byte b = Mem[num2++];
				if (b == 2 && (b = Mem[num2++]) != 2)
				{
					b -= 32;
				}
				Mem[num3++] = b;
			}
			SetValue(byteMode: false, Mem, 245788, num3 - num);
			SetValue(byteMode: false, Mem, 245792, num);
			break;
		}
		}
	}

	private void filterItanium_SetBits(int curPos, int bitField, int bitPos, int bitCount)
	{
		int num = bitPos / 8;
		int num2 = bitPos & 7;
		int num3 = Utility.URShift(-1, 32 - bitCount);
		num3 = ~(num3 << num2);
		bitField <<= num2;
		for (int i = 0; i < 4; i++)
		{
			Mem[curPos + num + i] &= (byte)num3;
			Mem[curPos + num + i] |= (byte)bitField;
			num3 = Utility.URShift(num3, 8) | -16777216;
			bitField = Utility.URShift(bitField, 8);
		}
	}

	private int filterItanium_GetBits(int curPos, int bitPos, int bitCount)
	{
		int num = bitPos / 8;
		int bits = bitPos & 7;
		int num2 = Mem[curPos + num++] & 0xFF;
		num2 |= (Mem[curPos + num++] & 0xFF) << 8;
		num2 |= (Mem[curPos + num++] & 0xFF) << 16;
		num2 |= (Mem[curPos + num] & 0xFF) << 24;
		num2 = Utility.URShift(num2, bits);
		return num2 & Utility.URShift(-1, 32 - bitCount);
	}

	public virtual void setMemory(int pos, byte[] data, int offset, int dataSize)
	{
		if (pos < 262144)
		{
			for (int i = 0; i < Math.Min(data.Length - offset, dataSize) && 262144 - pos >= i; i++)
			{
				Mem[pos + i] = data[offset + i];
			}
		}
	}
}
