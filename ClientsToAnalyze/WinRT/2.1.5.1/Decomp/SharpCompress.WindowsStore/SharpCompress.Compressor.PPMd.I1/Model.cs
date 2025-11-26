using System;
using System.IO;

namespace SharpCompress.Compressor.PPMd.I1;

internal class Model
{
	internal struct PpmContext
	{
		public const int Size = 12;

		public uint Address;

		public byte[] Memory;

		public static readonly PpmContext Zero = new PpmContext(0u, null);

		public byte NumberStatistics
		{
			get
			{
				return Memory[Address];
			}
			set
			{
				Memory[Address] = value;
			}
		}

		public byte Flags
		{
			get
			{
				return Memory[Address + 1];
			}
			set
			{
				Memory[Address + 1] = value;
			}
		}

		public ushort SummaryFrequency
		{
			get
			{
				return (ushort)(Memory[Address + 2] | (Memory[Address + 3] << 8));
			}
			set
			{
				Memory[Address + 2] = (byte)value;
				Memory[Address + 3] = (byte)(value >> 8);
			}
		}

		public PpmState Statistics
		{
			get
			{
				return new PpmState((uint)(Memory[Address + 4] | (Memory[Address + 5] << 8) | (Memory[Address + 6] << 16) | (Memory[Address + 7] << 24)), Memory);
			}
			set
			{
				Memory[Address + 4] = (byte)value.Address;
				Memory[Address + 5] = (byte)(value.Address >> 8);
				Memory[Address + 6] = (byte)(value.Address >> 16);
				Memory[Address + 7] = (byte)(value.Address >> 24);
			}
		}

		public PpmContext Suffix
		{
			get
			{
				return new PpmContext((uint)(Memory[Address + 8] | (Memory[Address + 9] << 8) | (Memory[Address + 10] << 16) | (Memory[Address + 11] << 24)), Memory);
			}
			set
			{
				Memory[Address + 8] = (byte)value.Address;
				Memory[Address + 9] = (byte)(value.Address >> 8);
				Memory[Address + 10] = (byte)(value.Address >> 16);
				Memory[Address + 11] = (byte)(value.Address >> 24);
			}
		}

		public PpmState FirstState => new PpmState(Address + 2, Memory);

		public byte FirstStateSymbol
		{
			get
			{
				return Memory[Address + 2];
			}
			set
			{
				Memory[Address + 2] = value;
			}
		}

		public byte FirstStateFrequency
		{
			get
			{
				return Memory[Address + 3];
			}
			set
			{
				Memory[Address + 3] = value;
			}
		}

		public PpmContext FirstStateSuccessor
		{
			get
			{
				return new PpmContext((uint)(Memory[Address + 4] | (Memory[Address + 5] << 8) | (Memory[Address + 6] << 16) | (Memory[Address + 7] << 24)), Memory);
			}
			set
			{
				Memory[Address + 4] = (byte)value.Address;
				Memory[Address + 5] = (byte)(value.Address >> 8);
				Memory[Address + 6] = (byte)(value.Address >> 16);
				Memory[Address + 7] = (byte)(value.Address >> 24);
			}
		}

		public PpmContext(uint address, byte[] memory)
		{
			Address = address;
			Memory = memory;
		}

		public static implicit operator PpmContext(Pointer pointer)
		{
			return new PpmContext(pointer.Address, pointer.Memory);
		}

		public static PpmContext operator +(PpmContext context, int offset)
		{
			context.Address = (uint)(context.Address + offset * 12);
			return context;
		}

		public static PpmContext operator -(PpmContext context, int offset)
		{
			context.Address = (uint)(context.Address - offset * 12);
			return context;
		}

		public static bool operator <=(PpmContext context1, PpmContext context2)
		{
			return context1.Address <= context2.Address;
		}

		public static bool operator >=(PpmContext context1, PpmContext context2)
		{
			return context1.Address >= context2.Address;
		}

		public static bool operator ==(PpmContext context1, PpmContext context2)
		{
			return context1.Address == context2.Address;
		}

		public static bool operator !=(PpmContext context1, PpmContext context2)
		{
			return context1.Address != context2.Address;
		}

		public override bool Equals(object obj)
		{
			if (obj is PpmContext ppmContext)
			{
				return ppmContext.Address == Address;
			}
			return base.Equals(obj);
		}

		public override int GetHashCode()
		{
			return Address.GetHashCode();
		}
	}

	public const uint Signature = 2225909647u;

	public const char Variant = 'I';

	public const int MaximumOrder = 16;

	private const byte UpperFrequency = 5;

	private const byte IntervalBitCount = 7;

	private const byte PeriodBitCount = 7;

	private const byte TotalBitCount = 14;

	private const uint Interval = 128u;

	private const uint BinaryScale = 16384u;

	private const uint MaximumFrequency = 124u;

	private const uint OrderBound = 9u;

	private See2Context[,] see2Contexts;

	private See2Context emptySee2Context;

	private PpmContext maximumContext;

	private ushort[,] binarySummary = new ushort[25, 64];

	private byte[] numberStatisticsToBinarySummaryIndex = new byte[256];

	private byte[] probabilities = new byte[260];

	private byte[] characterMask = new byte[256];

	private byte escapeCount;

	private int modelOrder;

	private int orderFall;

	private int initialEscape;

	private int initialRunLength;

	private int runLength;

	private byte previousSuccess;

	private byte numberMasked;

	private ModelRestorationMethod method;

	private PpmState foundState;

	private Allocator Allocator;

	private Coder Coder;

	private PpmContext minimumContext;

	private byte numberStatistics;

	private PpmState[] decodeStates = new PpmState[256];

	private static readonly ushort[] InitialBinaryEscapes = new ushort[8] { 15581, 7999, 22975, 18675, 25761, 23228, 26162, 24657 };

	private static readonly byte[] ExponentialEscapes = new byte[16]
	{
		25, 14, 9, 7, 5, 5, 4, 4, 4, 3,
		3, 3, 2, 2, 2, 2
	};

	public Model()
	{
		numberStatisticsToBinarySummaryIndex[0] = 0;
		numberStatisticsToBinarySummaryIndex[1] = 2;
		for (int i = 2; i < 11; i++)
		{
			numberStatisticsToBinarySummaryIndex[i] = 4;
		}
		for (int j = 11; j < 256; j++)
		{
			numberStatisticsToBinarySummaryIndex[j] = 6;
		}
		uint num = 1u;
		uint num2 = 1u;
		uint num3 = 5u;
		for (int k = 0; k < 5; k++)
		{
			probabilities[k] = (byte)k;
		}
		for (int l = 5; l < 260; l++)
		{
			probabilities[l] = (byte)num3;
			num--;
			if (num == 0)
			{
				num2++;
				num = num2;
				num3++;
			}
		}
		see2Contexts = new See2Context[24, 32];
		for (int m = 0; m < 24; m++)
		{
			for (int n = 0; n < 32; n++)
			{
				see2Contexts[m, n] = new See2Context();
			}
		}
		emptySee2Context = new See2Context();
		emptySee2Context.Summary = 44943;
		emptySee2Context.Shift = 172;
		emptySee2Context.Count = 132;
	}

	public void Encode(Stream target, Stream source, PpmdProperties properties)
	{
		if (target == null)
		{
			throw new ArgumentNullException("target");
		}
		if (source == null)
		{
			throw new ArgumentNullException("source");
		}
		EncodeStart(properties);
		EncodeBlock(target, source, final: true);
	}

	internal Coder EncodeStart(PpmdProperties properties)
	{
		Allocator = properties.Allocator;
		Coder = new Coder();
		Coder.RangeEncoderInitialize();
		StartModel(properties.ModelOrder, properties.ModelRestorationMethod);
		return Coder;
	}

	internal void EncodeBlock(Stream target, Stream source, bool final)
	{
		while (true)
		{
			minimumContext = maximumContext;
			numberStatistics = minimumContext.NumberStatistics;
			int num = source.ReadByte();
			if (num < 0 && !final)
			{
				break;
			}
			if (numberStatistics != 0)
			{
				EncodeSymbol1(num, minimumContext);
				Coder.RangeEncodeSymbol();
			}
			else
			{
				EncodeBinarySymbol(num, minimumContext);
				Coder.RangeShiftEncodeSymbol(14);
			}
			while (foundState == PpmState.Zero)
			{
				Coder.RangeEncoderNormalize(target);
				do
				{
					orderFall++;
					minimumContext = minimumContext.Suffix;
					if (minimumContext == PpmContext.Zero)
					{
						Coder.RangeEncoderFlush(target);
						return;
					}
				}
				while (minimumContext.NumberStatistics == numberMasked);
				EncodeSymbol2(num, minimumContext);
				Coder.RangeEncodeSymbol();
			}
			if (orderFall == 0 && (Pointer)foundState.Successor >= Allocator.BaseUnit)
			{
				maximumContext = foundState.Successor;
			}
			else
			{
				UpdateModel(minimumContext);
				if (escapeCount == 0)
				{
					ClearMask();
				}
			}
			Coder.RangeEncoderNormalize(target);
		}
	}

	public void Decode(Stream target, Stream source, PpmdProperties properties)
	{
		if (target == null)
		{
			throw new ArgumentNullException("target");
		}
		if (source == null)
		{
			throw new ArgumentNullException("source");
		}
		DecodeStart(source, properties);
		byte[] array = new byte[65536];
		int count;
		while ((count = DecodeBlock(source, array, 0, array.Length)) != 0)
		{
			target.Write(array, 0, count);
		}
	}

	internal Coder DecodeStart(Stream source, PpmdProperties properties)
	{
		Allocator = properties.Allocator;
		Coder = new Coder();
		Coder.RangeDecoderInitialize(source);
		StartModel(properties.ModelOrder, properties.ModelRestorationMethod);
		minimumContext = maximumContext;
		numberStatistics = minimumContext.NumberStatistics;
		return Coder;
	}

	internal int DecodeBlock(Stream source, byte[] buffer, int offset, int count)
	{
		if (minimumContext == PpmContext.Zero)
		{
			return 0;
		}
		int num = 0;
		while (num < count)
		{
			if (numberStatistics != 0)
			{
				DecodeSymbol1(minimumContext);
			}
			else
			{
				DecodeBinarySymbol(minimumContext);
			}
			Coder.RangeRemoveSubrange();
			for (; foundState == PpmState.Zero; DecodeSymbol2(minimumContext), Coder.RangeRemoveSubrange())
			{
				Coder.RangeDecoderNormalize(source);
				while (true)
				{
					orderFall++;
					minimumContext = minimumContext.Suffix;
					if (minimumContext == PpmContext.Zero)
					{
						break;
					}
					if (minimumContext.NumberStatistics == numberMasked)
					{
						continue;
					}
					goto IL_009d;
				}
				goto end_IL_015d;
				IL_009d:;
			}
			buffer[offset] = foundState.Symbol;
			offset++;
			num++;
			if (orderFall == 0 && (Pointer)foundState.Successor >= Allocator.BaseUnit)
			{
				maximumContext = foundState.Successor;
			}
			else
			{
				UpdateModel(minimumContext);
				if (escapeCount == 0)
				{
					ClearMask();
				}
			}
			minimumContext = maximumContext;
			numberStatistics = minimumContext.NumberStatistics;
			Coder.RangeDecoderNormalize(source);
			continue;
			end_IL_015d:
			break;
		}
		return num;
	}

	private void StartModel(int modelOrder, ModelRestorationMethod modelRestorationMethod)
	{
		Array.Clear(characterMask, 0, characterMask.Length);
		escapeCount = 1;
		if (modelOrder < 2)
		{
			orderFall = this.modelOrder;
			PpmContext suffix = maximumContext;
			while (suffix.Suffix != PpmContext.Zero)
			{
				orderFall--;
				suffix = suffix.Suffix;
			}
			return;
		}
		this.modelOrder = modelOrder;
		orderFall = modelOrder;
		method = modelRestorationMethod;
		Allocator.Initialize();
		initialRunLength = -((modelOrder < 12) ? modelOrder : 12) - 1;
		runLength = initialRunLength;
		maximumContext = Allocator.AllocateContext();
		maximumContext.Suffix = PpmContext.Zero;
		maximumContext.NumberStatistics = byte.MaxValue;
		maximumContext.SummaryFrequency = (ushort)(maximumContext.NumberStatistics + 2);
		maximumContext.Statistics = Allocator.AllocateUnits(128u);
		previousSuccess = 0;
		for (int i = 0; i < 256; i++)
		{
			PpmState ppmState = maximumContext.Statistics[i];
			ppmState.Symbol = (byte)i;
			ppmState.Frequency = 1;
			ppmState.Successor = PpmContext.Zero;
		}
		uint num = 0u;
		int j = 0;
		for (; num < 25; num++)
		{
			for (; probabilities[j] == num; j++)
			{
			}
			for (int k = 0; k < 8; k++)
			{
				binarySummary[(int)checked((nint)unchecked((long)num)), (int)checked((nint)k)] = (ushort)(16384uL - (ulong)(InitialBinaryEscapes[k] / (j + 1)));
			}
			for (int l = 8; l < 64; l += 8)
			{
				for (int m = 0; m < 8; m++)
				{
					binarySummary[(int)checked((nint)unchecked((long)num)), (int)checked((nint)unchecked(l + m))] = binarySummary[(int)checked((nint)unchecked((long)num)), (int)checked((nint)m)];
				}
			}
		}
		num = 0u;
		uint num2 = 0u;
		for (; num < 24; num++)
		{
			for (; probabilities[num2 + 3] == num + 3; num2++)
			{
			}
			for (int n = 0; n < 32; n++)
			{
				see2Contexts[(int)checked((nint)unchecked((long)num)), (int)checked((nint)n)].Initialize(2 * num2 + 5);
			}
		}
	}

	private void UpdateModel(PpmContext minimumContext)
	{
		PpmState state = PpmState.Zero;
		PpmContext suffix = maximumContext;
		uint frequency = foundState.Frequency;
		byte symbol = foundState.Symbol;
		PpmContext ppmContext = foundState.Successor;
		PpmContext suffix2 = minimumContext.Suffix;
		if (frequency < 31 && suffix2 != PpmContext.Zero)
		{
			if (suffix2.NumberStatistics != 0)
			{
				state = suffix2.Statistics;
				if (state.Symbol != symbol)
				{
					byte symbol2;
					do
					{
						symbol2 = state[1].Symbol;
						++state;
					}
					while (symbol2 != symbol);
					if (state[0].Frequency >= state[-1].Frequency)
					{
						Swap(state[0], state[-1]);
						--state;
					}
				}
				uint num = (((uint)state.Frequency < 115u) ? 2u : 0u);
				state.Frequency += (byte)num;
				suffix2.SummaryFrequency += (byte)num;
			}
			else
			{
				state = suffix2.FirstState;
				state.Frequency += ((state.Frequency < 32) ? ((byte)1) : ((byte)0));
			}
		}
		if (orderFall == 0 && ppmContext != PpmContext.Zero)
		{
			foundState.Successor = CreateSuccessors(skip: true, state, minimumContext);
			if (!(foundState.Successor == PpmContext.Zero))
			{
				maximumContext = foundState.Successor;
				return;
			}
		}
		else
		{
			Allocator.Text[0] = symbol;
			++Allocator.Text;
			PpmContext successor = Allocator.Text;
			if (!(Allocator.Text >= Allocator.BaseUnit))
			{
				if (ppmContext != PpmContext.Zero)
				{
					if (ppmContext < Allocator.BaseUnit)
					{
						ppmContext = CreateSuccessors(skip: false, state, minimumContext);
					}
				}
				else
				{
					ppmContext = ReduceOrder(state, minimumContext);
				}
				if (!(ppmContext == PpmContext.Zero))
				{
					if (--orderFall == 0)
					{
						successor = ppmContext;
						Allocator.Text -= ((maximumContext != minimumContext) ? 1 : 0);
					}
					else if (method > ModelRestorationMethod.Freeze)
					{
						successor = ppmContext;
						Allocator.Text = Allocator.Heap;
						orderFall = 0;
					}
					uint num2 = minimumContext.NumberStatistics;
					uint num3 = minimumContext.SummaryFrequency - num2 - frequency;
					byte b = (byte)((symbol >= 64) ? 8u : 0u);
					while (true)
					{
						if (suffix != minimumContext)
						{
							uint num4 = suffix.NumberStatistics;
							if (num4 != 0)
							{
								if ((num4 & 1) != 0)
								{
									state = Allocator.ExpandUnits(suffix.Statistics, num4 + 1 >> 1);
									if (state == PpmState.Zero)
									{
										break;
									}
									suffix.Statistics = state;
								}
								suffix.SummaryFrequency += (ushort)((3 * num4 + 1 < num2) ? 1 : 0);
							}
							else
							{
								state = Allocator.AllocateUnits(1u);
								if (state == PpmState.Zero)
								{
									break;
								}
								Copy(state, suffix.FirstState);
								suffix.Statistics = state;
								if ((uint)state.Frequency < 30u)
								{
									state.Frequency += state.Frequency;
								}
								else
								{
									state.Frequency = 120;
								}
								suffix.SummaryFrequency = (ushort)((uint)(state.Frequency + initialEscape) + ((num2 > 2) ? 1u : 0u));
							}
							uint num = (uint)(2 * frequency * (suffix.SummaryFrequency + 6));
							uint num5 = num3 + suffix.SummaryFrequency;
							if (num < 6 * num5)
							{
								num = (uint)(1 + ((num > num5) ? 1 : 0) + ((num >= 4 * num5) ? 1 : 0));
								suffix.SummaryFrequency += 4;
							}
							else
							{
								num = (uint)(4 + ((num > 9 * num5) ? 1 : 0) + ((num > 12 * num5) ? 1 : 0) + ((num > 15 * num5) ? 1 : 0));
								suffix.SummaryFrequency += (ushort)num;
							}
							state = suffix.Statistics + ++suffix.NumberStatistics;
							state.Successor = successor;
							state.Symbol = symbol;
							state.Frequency = (byte)num;
							suffix.Flags |= b;
							suffix = suffix.Suffix;
							continue;
						}
						maximumContext = ppmContext;
						return;
					}
				}
			}
		}
		RestoreModel(suffix, minimumContext, ppmContext);
	}

	private PpmContext CreateSuccessors(bool skip, PpmState state, PpmContext context)
	{
		PpmContext successor = foundState.Successor;
		PpmState[] array = new PpmState[16];
		uint num = 0u;
		byte symbol = foundState.Symbol;
		if (!skip)
		{
			ref PpmState reference = ref array[num++];
			reference = foundState;
			if (context.Suffix == PpmContext.Zero)
			{
				goto IL_0176;
			}
		}
		bool flag = false;
		if (state != PpmState.Zero)
		{
			context = context.Suffix;
			flag = true;
		}
		do
		{
			if (flag)
			{
				flag = false;
			}
			else
			{
				context = context.Suffix;
				if (context.NumberStatistics != 0)
				{
					state = context.Statistics;
					byte symbol2;
					if (state.Symbol != symbol)
					{
						do
						{
							symbol2 = state[1].Symbol;
							++state;
						}
						while (symbol2 != symbol);
					}
					symbol2 = (((uint)state.Frequency < 115u) ? ((byte)1) : ((byte)0));
					state.Frequency += symbol2;
					context.SummaryFrequency += symbol2;
				}
				else
				{
					state = context.FirstState;
					state.Frequency += (((context.Suffix.NumberStatistics == 0) & (state.Frequency < 24)) ? ((byte)1) : ((byte)0));
				}
			}
			if (state.Successor != successor)
			{
				context = state.Successor;
				break;
			}
			array[num++] = state;
		}
		while (context.Suffix != PpmContext.Zero);
		goto IL_0176;
		IL_0176:
		if (num == 0)
		{
			return context;
		}
		byte b = 0;
		byte b2 = (byte)((symbol >= 64) ? 16u : 0u);
		symbol = successor.NumberStatistics;
		byte firstStateSymbol = symbol;
		PpmContext firstStateSuccessor = (Pointer)successor + 1;
		b2 |= (byte)((symbol >= 64) ? 8 : 0);
		byte firstStateFrequency;
		if (context.NumberStatistics != 0)
		{
			state = context.Statistics;
			if (state.Symbol != symbol)
			{
				byte symbol3;
				do
				{
					symbol3 = state[1].Symbol;
					++state;
				}
				while (symbol3 != symbol);
			}
			uint num2 = (uint)(state.Frequency - 1);
			uint num3 = (uint)(context.SummaryFrequency - context.NumberStatistics - num2);
			firstStateFrequency = (byte)(1 + ((2 * num2 > num3) ? ((int)((num2 + 2 * num3 - 3) / num3)) : ((5 * num2 > num3) ? 1 : 0)));
		}
		else
		{
			firstStateFrequency = context.FirstStateFrequency;
		}
		do
		{
			PpmContext ppmContext = Allocator.AllocateContext();
			if (ppmContext == PpmContext.Zero)
			{
				return PpmContext.Zero;
			}
			ppmContext.NumberStatistics = b;
			ppmContext.Flags = b2;
			ppmContext.FirstStateSymbol = firstStateSymbol;
			ppmContext.FirstStateFrequency = firstStateFrequency;
			ppmContext.FirstStateSuccessor = firstStateSuccessor;
			ppmContext.Suffix = context;
			context = ppmContext;
			array[--num].Successor = context;
		}
		while (num != 0);
		return context;
	}

	private PpmContext ReduceOrder(PpmState state, PpmContext context)
	{
		PpmState[] array = new PpmState[16];
		uint num = 0u;
		PpmContext ppmContext = context;
		PpmContext ppmContext2 = Allocator.Text;
		byte symbol = foundState.Symbol;
		ref PpmState reference = ref array[num++];
		reference = foundState;
		foundState.Successor = ppmContext2;
		orderFall++;
		bool flag = false;
		if (state != PpmState.Zero)
		{
			context = context.Suffix;
			flag = true;
		}
		while (true)
		{
			if (flag)
			{
				flag = false;
			}
			else
			{
				if (context.Suffix == PpmContext.Zero)
				{
					if (method > ModelRestorationMethod.Freeze)
					{
						do
						{
							array[--num].Successor = context;
						}
						while (num != 0);
						Allocator.Text = Allocator.Heap + 1;
						orderFall = 1;
					}
					return context;
				}
				context = context.Suffix;
				if (context.NumberStatistics != 0)
				{
					state = context.Statistics;
					byte symbol2;
					if (state.Symbol != symbol)
					{
						do
						{
							symbol2 = state[1].Symbol;
							++state;
						}
						while (symbol2 != symbol);
					}
					symbol2 = (byte)(((uint)state.Frequency < 115u) ? 2u : 0u);
					state.Frequency += symbol2;
					context.SummaryFrequency += symbol2;
				}
				else
				{
					state = context.FirstState;
					state.Frequency += ((state.Frequency < 32) ? ((byte)1) : ((byte)0));
				}
			}
			if (state.Successor != PpmContext.Zero)
			{
				break;
			}
			array[num++] = state;
			state.Successor = ppmContext2;
			orderFall++;
		}
		if (method > ModelRestorationMethod.Freeze)
		{
			context = state.Successor;
			do
			{
				array[--num].Successor = context;
			}
			while (num != 0);
			Allocator.Text = Allocator.Heap + 1;
			orderFall = 1;
			return context;
		}
		if (state.Successor <= ppmContext2)
		{
			PpmState ppmState = foundState;
			foundState = state;
			state.Successor = CreateSuccessors(skip: false, PpmState.Zero, context);
			foundState = ppmState;
		}
		if (orderFall == 1 && ppmContext == maximumContext)
		{
			foundState.Successor = state.Successor;
			--Allocator.Text;
		}
		return state.Successor;
	}

	private void RestoreModel(PpmContext context, PpmContext minimumContext, PpmContext foundStateSuccessor)
	{
		Allocator.Text = Allocator.Heap;
		PpmContext suffix = maximumContext;
		while (suffix != context)
		{
			if (--suffix.NumberStatistics == 0)
			{
				suffix.Flags = (byte)((suffix.Flags & 0x10) + ((suffix.Statistics.Symbol >= 64) ? 8 : 0));
				PpmState statistics = suffix.Statistics;
				Copy(suffix.FirstState, statistics);
				Allocator.SpecialFreeUnits(statistics);
				suffix.FirstStateFrequency = (byte)(suffix.FirstStateFrequency + 11 >> 3);
			}
			else
			{
				Refresh((uint)(suffix.NumberStatistics + 3 >> 1), scale: false, suffix);
			}
			suffix = suffix.Suffix;
		}
		while (suffix != minimumContext)
		{
			if (suffix.NumberStatistics == 0)
			{
				suffix.FirstStateFrequency -= (byte)(suffix.FirstStateFrequency >> 1);
			}
			else if ((suffix.SummaryFrequency += 4) > 128 + 4 * suffix.NumberStatistics)
			{
				Refresh((uint)(suffix.NumberStatistics + 2 >> 1), scale: true, suffix);
			}
			suffix = suffix.Suffix;
		}
		if (method > ModelRestorationMethod.Freeze)
		{
			maximumContext = foundStateSuccessor;
			Allocator.GlueCount += (((Allocator.MemoryNodes[1].Stamp & 1) == 0) ? 1u : 0u);
			return;
		}
		if (method == ModelRestorationMethod.Freeze)
		{
			while (maximumContext.Suffix != PpmContext.Zero)
			{
				maximumContext = maximumContext.Suffix;
			}
			RemoveBinaryContexts(0, maximumContext);
			method++;
			Allocator.GlueCount = 0u;
			orderFall = modelOrder;
			return;
		}
		if (method == ModelRestorationMethod.Restart || Allocator.GetMemoryUsed() < Allocator.AllocatorSize >> 1)
		{
			StartModel(modelOrder, method);
			escapeCount = 0;
			return;
		}
		while (maximumContext.Suffix != PpmContext.Zero)
		{
			maximumContext = maximumContext.Suffix;
		}
		do
		{
			CutOff(0, maximumContext);
			Allocator.ExpandText();
		}
		while (Allocator.GetMemoryUsed() > 3 * (Allocator.AllocatorSize >> 2));
		Allocator.GlueCount = 0u;
		orderFall = modelOrder;
	}

	private static void Swap(PpmState state1, PpmState state2)
	{
		byte symbol = state1.Symbol;
		byte frequency = state1.Frequency;
		PpmContext successor = state1.Successor;
		state1.Symbol = state2.Symbol;
		state1.Frequency = state2.Frequency;
		state1.Successor = state2.Successor;
		state2.Symbol = symbol;
		state2.Frequency = frequency;
		state2.Successor = successor;
	}

	private static void Copy(PpmState state1, PpmState state2)
	{
		state1.Symbol = state2.Symbol;
		state1.Frequency = state2.Frequency;
		state1.Successor = state2.Successor;
	}

	private static int Mean(int sum, int shift, int round)
	{
		return sum + (1 << shift - round) >> shift;
	}

	private void ClearMask()
	{
		escapeCount = 1;
		Array.Clear(characterMask, 0, characterMask.Length);
	}

	private void EncodeBinarySymbol(int symbol, PpmContext context)
	{
		PpmState firstState = context.FirstState;
		int num = probabilities[firstState.Frequency - 1];
		int num2 = numberStatisticsToBinarySummaryIndex[context.Suffix.NumberStatistics] + previousSuccess + context.Flags + ((runLength >> 26) & 0x20);
		if (firstState.Symbol == symbol)
		{
			foundState = firstState;
			firstState.Frequency += ((firstState.Frequency < 196) ? ((byte)1) : ((byte)0));
			Coder.LowCount = 0u;
			Coder.HighCount = binarySummary[num, num2];
			binarySummary[num, num2] += (ushort)(128L - (long)Mean(binarySummary[num, num2], 7, 2));
			previousSuccess = 1;
			runLength++;
		}
		else
		{
			Coder.LowCount = binarySummary[num, num2];
			binarySummary[num, num2] -= (ushort)Mean(binarySummary[num, num2], 7, 2);
			Coder.HighCount = 16384u;
			initialEscape = ExponentialEscapes[binarySummary[num, num2] >> 10];
			characterMask[firstState.Symbol] = escapeCount;
			previousSuccess = 0;
			numberMasked = 0;
			foundState = PpmState.Zero;
		}
	}

	private void EncodeSymbol1(int symbol, PpmContext context)
	{
		uint symbol2 = context.Statistics.Symbol;
		PpmState statistics = context.Statistics;
		Coder.Scale = context.SummaryFrequency;
		if (symbol2 == symbol)
		{
			Coder.HighCount = statistics.Frequency;
			previousSuccess = (byte)((2 * Coder.HighCount >= Coder.Scale) ? 1u : 0u);
			foundState = statistics;
			foundState.Frequency += 4;
			context.SummaryFrequency += 4;
			runLength += previousSuccess;
			if ((uint)statistics.Frequency > 124u)
			{
				Rescale(context);
			}
			Coder.LowCount = 0u;
			return;
		}
		uint num = statistics.Frequency;
		symbol2 = context.NumberStatistics;
		previousSuccess = 0;
		while (true)
		{
			PpmState ppmState = ++statistics;
			if (ppmState.Symbol == symbol)
			{
				break;
			}
			num += statistics.Frequency;
			if (--symbol2 == 0)
			{
				Coder.LowCount = num;
				characterMask[statistics.Symbol] = escapeCount;
				numberMasked = context.NumberStatistics;
				symbol2 = context.NumberStatistics;
				foundState = PpmState.Zero;
				do
				{
					byte[] array = characterMask;
					PpmState ppmState2 = --statistics;
					array[ppmState2.Symbol] = escapeCount;
				}
				while (--symbol2 != 0);
				Coder.HighCount = Coder.Scale;
				return;
			}
		}
		Coder.HighCount = (Coder.LowCount = num) + statistics.Frequency;
		Update1(statistics, context);
	}

	private void EncodeSymbol2(int symbol, PpmContext context)
	{
		See2Context see2Context = MakeEscapeFrequency(context);
		uint num = 0u;
		uint num2 = (uint)(context.NumberStatistics - numberMasked);
		PpmState ppmState = context.Statistics - 1;
		while (true)
		{
			uint symbol2 = ppmState[1].Symbol;
			++ppmState;
			if (characterMask[symbol2] != escapeCount)
			{
				characterMask[symbol2] = escapeCount;
				if (symbol2 == symbol)
				{
					break;
				}
				num += ppmState.Frequency;
				if (--num2 == 0)
				{
					Coder.LowCount = num;
					Coder.Scale += Coder.LowCount;
					Coder.HighCount = Coder.Scale;
					see2Context.Summary += (ushort)Coder.Scale;
					numberMasked = context.NumberStatistics;
					return;
				}
			}
		}
		Coder.LowCount = num;
		num += ppmState.Frequency;
		Coder.HighCount = num;
		PpmState ppmState2 = ppmState;
		while (--num2 != 0)
		{
			uint symbol2;
			do
			{
				symbol2 = ppmState2[1].Symbol;
				++ppmState2;
			}
			while (characterMask[symbol2] == escapeCount);
			num += ppmState2.Frequency;
		}
		Coder.Scale += num;
		see2Context.Update();
		Update2(ppmState, context);
	}

	private void DecodeBinarySymbol(PpmContext context)
	{
		PpmState firstState = context.FirstState;
		int num = probabilities[firstState.Frequency - 1];
		int num2 = numberStatisticsToBinarySummaryIndex[context.Suffix.NumberStatistics] + previousSuccess + context.Flags + ((runLength >> 26) & 0x20);
		if (Coder.RangeGetCurrentShiftCount(14) < binarySummary[num, num2])
		{
			foundState = firstState;
			firstState.Frequency += ((firstState.Frequency < 196) ? ((byte)1) : ((byte)0));
			Coder.LowCount = 0u;
			Coder.HighCount = binarySummary[num, num2];
			binarySummary[num, num2] += (ushort)(128L - (long)Mean(binarySummary[num, num2], 7, 2));
			previousSuccess = 1;
			runLength++;
		}
		else
		{
			Coder.LowCount = binarySummary[num, num2];
			binarySummary[num, num2] -= (ushort)Mean(binarySummary[num, num2], 7, 2);
			Coder.HighCount = 16384u;
			initialEscape = ExponentialEscapes[binarySummary[num, num2] >> 10];
			characterMask[firstState.Symbol] = escapeCount;
			previousSuccess = 0;
			numberMasked = 0;
			foundState = PpmState.Zero;
		}
	}

	private void DecodeSymbol1(PpmContext context)
	{
		uint num = context.Statistics.Frequency;
		PpmState statistics = context.Statistics;
		Coder.Scale = context.SummaryFrequency;
		uint num2 = Coder.RangeGetCurrentCount();
		if (num2 < num)
		{
			Coder.HighCount = num;
			previousSuccess = (byte)((2 * Coder.HighCount >= Coder.Scale) ? 1u : 0u);
			foundState = statistics;
			num += 4;
			foundState.Frequency = (byte)num;
			context.SummaryFrequency += 4;
			runLength += previousSuccess;
			if (num > 124)
			{
				Rescale(context);
			}
			Coder.LowCount = 0u;
			return;
		}
		uint num3 = context.NumberStatistics;
		previousSuccess = 0;
		while (true)
		{
			uint num4 = num;
			PpmState ppmState = ++statistics;
			if ((num = num4 + ppmState.Frequency) > num2)
			{
				break;
			}
			if (--num3 == 0)
			{
				Coder.LowCount = num;
				characterMask[statistics.Symbol] = escapeCount;
				numberMasked = context.NumberStatistics;
				num3 = context.NumberStatistics;
				foundState = PpmState.Zero;
				do
				{
					byte[] array = characterMask;
					PpmState ppmState2 = --statistics;
					array[ppmState2.Symbol] = escapeCount;
				}
				while (--num3 != 0);
				Coder.HighCount = Coder.Scale;
				return;
			}
		}
		Coder.HighCount = num;
		Coder.LowCount = Coder.HighCount - statistics.Frequency;
		Update1(statistics, context);
	}

	private void DecodeSymbol2(PpmContext context)
	{
		See2Context see2Context = MakeEscapeFrequency(context);
		uint num = 0u;
		uint num2 = (uint)(context.NumberStatistics - numberMasked);
		uint num3 = 0u;
		PpmState ppmState = context.Statistics - 1;
		while (true)
		{
			uint symbol = ppmState[1].Symbol;
			++ppmState;
			if (characterMask[symbol] != escapeCount)
			{
				num += ppmState.Frequency;
				decodeStates[num3++] = ppmState;
				if (--num2 == 0)
				{
					break;
				}
			}
		}
		Coder.Scale += num;
		uint num4 = Coder.RangeGetCurrentCount();
		num3 = 0u;
		ppmState = decodeStates[num3];
		if (num4 < num)
		{
			num = 0u;
			while ((num += ppmState.Frequency) <= num4)
			{
				ppmState = decodeStates[++num3];
			}
			Coder.HighCount = num;
			Coder.LowCount = Coder.HighCount - ppmState.Frequency;
			see2Context.Update();
			Update2(ppmState, context);
			return;
		}
		Coder.LowCount = num;
		Coder.HighCount = Coder.Scale;
		num2 = (uint)(context.NumberStatistics - numberMasked);
		numberMasked = context.NumberStatistics;
		do
		{
			characterMask[decodeStates[num3].Symbol] = escapeCount;
			num3++;
		}
		while (--num2 != 0);
		see2Context.Summary += (ushort)Coder.Scale;
	}

	private void Update1(PpmState state, PpmContext context)
	{
		foundState = state;
		foundState.Frequency += 4;
		context.SummaryFrequency += 4;
		if (state[0].Frequency > state[-1].Frequency)
		{
			Swap(state[0], state[-1]);
			foundState = --state;
			if ((uint)state.Frequency > 124u)
			{
				Rescale(context);
			}
		}
	}

	private void Update2(PpmState state, PpmContext context)
	{
		foundState = state;
		foundState.Frequency += 4;
		context.SummaryFrequency += 4;
		if ((uint)state.Frequency > 124u)
		{
			Rescale(context);
		}
		escapeCount++;
		runLength = initialRunLength;
	}

	private See2Context MakeEscapeFrequency(PpmContext context)
	{
		uint num = (uint)(2 * context.NumberStatistics);
		See2Context see2Context;
		if (context.NumberStatistics != byte.MaxValue)
		{
			num = context.Suffix.NumberStatistics;
			int num2 = probabilities[context.NumberStatistics + 2] - 3;
			int num3 = ((context.SummaryFrequency > 11 * (context.NumberStatistics + 1)) ? 1 : 0) + ((2 * context.NumberStatistics < num + numberMasked) ? 2 : 0) + context.Flags;
			see2Context = see2Contexts[num2, num3];
			Coder.Scale = see2Context.Mean();
		}
		else
		{
			see2Context = emptySee2Context;
			Coder.Scale = 1u;
		}
		return see2Context;
	}

	private void Rescale(PpmContext context)
	{
		uint num = context.NumberStatistics;
		PpmState ppmState;
		for (ppmState = foundState; ppmState != context.Statistics; --ppmState)
		{
			Swap(ppmState[0], ppmState[-1]);
		}
		ppmState.Frequency += 4;
		context.SummaryFrequency += 4;
		uint num2 = (uint)(context.SummaryFrequency - ppmState.Frequency);
		int num3 = ((orderFall != 0 || method > ModelRestorationMethod.Freeze) ? 1 : 0);
		ppmState.Frequency = (byte)(ppmState.Frequency + num3 >> 1);
		context.SummaryFrequency = ppmState.Frequency;
		do
		{
			uint num4 = num2;
			PpmState ppmState2 = ++ppmState;
			num2 = num4 - ppmState2.Frequency;
			ppmState.Frequency = (byte)(ppmState.Frequency + num3 >> 1);
			context.SummaryFrequency += ppmState.Frequency;
			if (ppmState[0].Frequency > ppmState[-1].Frequency)
			{
				PpmState ppmState3 = ppmState;
				byte symbol = ppmState3.Symbol;
				byte frequency = ppmState3.Frequency;
				PpmContext successor = ppmState3.Successor;
				byte num5;
				PpmState ppmState4;
				do
				{
					Copy(ppmState3[0], ppmState3[-1]);
					num5 = frequency;
					ppmState4 = --ppmState3;
				}
				while (num5 > ppmState4[-1].Frequency);
				ppmState3.Symbol = symbol;
				ppmState3.Frequency = frequency;
				ppmState3.Successor = successor;
			}
		}
		while (--num != 0);
		if (ppmState.Frequency == 0)
		{
			PpmState ppmState5;
			do
			{
				num++;
				ppmState5 = --ppmState;
			}
			while (ppmState5.Frequency == 0);
			num2 += num;
			uint num6 = (uint)(context.NumberStatistics + 2 >> 1);
			context.NumberStatistics -= (byte)num;
			if (context.NumberStatistics == 0)
			{
				byte symbol = context.Statistics.Symbol;
				byte frequency = context.Statistics.Frequency;
				PpmContext successor = context.Statistics.Successor;
				frequency = (byte)((2 * frequency + num2 - 1) / num2);
				if ((uint)frequency > 41u)
				{
					frequency = 41;
				}
				Allocator.FreeUnits(context.Statistics, num6);
				context.FirstStateSymbol = symbol;
				context.FirstStateFrequency = frequency;
				context.FirstStateSuccessor = successor;
				context.Flags = (byte)((context.Flags & 0x10) + ((symbol >= 64) ? 8 : 0));
				foundState = context.FirstState;
				return;
			}
			context.Statistics = Allocator.ShrinkUnits(context.Statistics, num6, (uint)(context.NumberStatistics + 2 >> 1));
			context.Flags &= 247;
			num = context.NumberStatistics;
			ppmState = context.Statistics;
			context.Flags |= (byte)((ppmState.Symbol >= 64) ? 8 : 0);
			do
			{
				byte flags = context.Flags;
				PpmState ppmState6 = ++ppmState;
				context.Flags = (byte)(flags | (byte)((ppmState6.Symbol >= 64) ? 8 : 0));
			}
			while (--num != 0);
		}
		num2 -= num2 >> 1;
		context.SummaryFrequency += (ushort)num2;
		context.Flags |= 4;
		foundState = context.Statistics;
	}

	private void Refresh(uint oldUnitCount, bool scale, PpmContext context)
	{
		int num = context.NumberStatistics;
		int num2 = (scale ? 1 : 0);
		context.Statistics = Allocator.ShrinkUnits(context.Statistics, oldUnitCount, (uint)(num + 2 >> 1));
		PpmState statistics = context.Statistics;
		context.Flags = (byte)((context.Flags & (16 + (scale ? 4 : 0))) + ((statistics.Symbol >= 64) ? 8 : 0));
		int num3 = context.SummaryFrequency - statistics.Frequency;
		statistics.Frequency = (byte)(statistics.Frequency + num2 >> num2);
		context.SummaryFrequency = statistics.Frequency;
		do
		{
			int num4 = num3;
			PpmState ppmState = ++statistics;
			num3 = num4 - ppmState.Frequency;
			statistics.Frequency = (byte)(statistics.Frequency + num2 >> num2);
			context.SummaryFrequency += statistics.Frequency;
			context.Flags |= (byte)((statistics.Symbol >= 64) ? 8 : 0);
		}
		while (--num != 0);
		num3 = num3 + num2 >> num2;
		context.SummaryFrequency += (ushort)num3;
	}

	private PpmContext CutOff(int order, PpmContext context)
	{
		if (context.NumberStatistics == 0)
		{
			PpmState firstState = context.FirstState;
			if ((Pointer)firstState.Successor >= Allocator.BaseUnit)
			{
				if (order < modelOrder)
				{
					firstState.Successor = CutOff(order + 1, firstState.Successor);
				}
				else
				{
					firstState.Successor = PpmContext.Zero;
				}
				if (firstState.Successor == PpmContext.Zero && (long)order > 9L)
				{
					Allocator.SpecialFreeUnits(context);
					return PpmContext.Zero;
				}
				return context;
			}
			Allocator.SpecialFreeUnits(context);
			return PpmContext.Zero;
		}
		uint num = (uint)(context.NumberStatistics + 2 >> 1);
		context.Statistics = Allocator.MoveUnitsUp(context.Statistics, num);
		int num2 = context.NumberStatistics;
		for (PpmState firstState = context.Statistics + num2; firstState >= context.Statistics; --firstState)
		{
			if (firstState.Successor < Allocator.BaseUnit)
			{
				firstState.Successor = PpmContext.Zero;
				Swap(firstState, context.Statistics[num2--]);
			}
			else if (order < modelOrder)
			{
				firstState.Successor = CutOff(order + 1, firstState.Successor);
			}
			else
			{
				firstState.Successor = PpmContext.Zero;
			}
		}
		if (num2 != context.NumberStatistics && order != 0)
		{
			context.NumberStatistics = (byte)num2;
			PpmState firstState = context.Statistics;
			if (num2 < 0)
			{
				Allocator.FreeUnits(firstState, num);
				Allocator.SpecialFreeUnits(context);
				return PpmContext.Zero;
			}
			if (num2 == 0)
			{
				context.Flags = (byte)((context.Flags & 0x10) + ((firstState.Symbol >= 64) ? 8 : 0));
				Copy(context.FirstState, firstState);
				Allocator.FreeUnits(firstState, num);
				context.FirstStateFrequency = (byte)(context.FirstStateFrequency + 11 >> 3);
			}
			else
			{
				Refresh(num, context.SummaryFrequency > 16 * num2, context);
			}
		}
		return context;
	}

	private PpmContext RemoveBinaryContexts(int order, PpmContext context)
	{
		if (context.NumberStatistics == 0)
		{
			PpmState firstState = context.FirstState;
			if ((Pointer)firstState.Successor >= Allocator.BaseUnit && order < modelOrder)
			{
				firstState.Successor = RemoveBinaryContexts(order + 1, firstState.Successor);
			}
			else
			{
				firstState.Successor = PpmContext.Zero;
			}
			if (firstState.Successor == PpmContext.Zero && (context.Suffix.NumberStatistics == 0 || context.Suffix.Flags == byte.MaxValue))
			{
				Allocator.FreeUnits(context, 1u);
				return PpmContext.Zero;
			}
			return context;
		}
		for (PpmState ppmState = context.Statistics + context.NumberStatistics; ppmState >= context.Statistics; --ppmState)
		{
			if ((Pointer)ppmState.Successor >= Allocator.BaseUnit && order < modelOrder)
			{
				ppmState.Successor = RemoveBinaryContexts(order + 1, ppmState.Successor);
			}
			else
			{
				ppmState.Successor = PpmContext.Zero;
			}
		}
		return context;
	}
}
