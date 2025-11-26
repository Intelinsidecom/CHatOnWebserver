using System.IO;
using System.Text;
using SharpCompress.Compressor.LZMA.RangeCoder;
using SharpCompress.Compressor.Rar;

namespace SharpCompress.Compressor.PPMd.H;

internal class ModelPPM
{
	public const int MAX_O = 64;

	public const int INT_BITS = 7;

	public const int PERIOD_BITS = 7;

	public const int MAX_FREQ = 124;

	public static readonly int TOT_BITS = 14;

	public static readonly int INTERVAL = 128;

	public static readonly int BIN_SCALE = 1 << TOT_BITS;

	private SEE2Context[][] SEE2Cont = new SEE2Context[25][];

	private SEE2Context dummySEE2Cont;

	private PPMContext minContext;

	private PPMContext maxContext;

	private State foundState;

	private int numMasked;

	private int initEsc;

	private int orderFall;

	private int maxOrder;

	private int runLength;

	private int initRL;

	private int[] charMask = new int[256];

	private int[] NS2Indx = new int[256];

	private int[] NS2BSIndx = new int[256];

	private int[] HB2Flag = new int[256];

	private int escCount;

	private int prevSuccess;

	private int hiBitsFlag;

	private int[][] binSumm = new int[128][];

	private RangeCoder coder;

	private SubAllocator subAlloc = new SubAllocator();

	private static int[] InitBinEsc = new int[8] { 15581, 7999, 22975, 18675, 25761, 23228, 26162, 24657 };

	private State tempState1 = new State(null);

	private State tempState2 = new State(null);

	private State tempState3 = new State(null);

	private State tempState4 = new State(null);

	private StateRef tempStateRef1 = new StateRef();

	private StateRef tempStateRef2 = new StateRef();

	private PPMContext tempPPMContext1 = new PPMContext(null);

	private PPMContext tempPPMContext2 = new PPMContext(null);

	private PPMContext tempPPMContext3 = new PPMContext(null);

	private PPMContext tempPPMContext4 = new PPMContext(null);

	private int[] ps = new int[64];

	public SubAllocator SubAlloc => subAlloc;

	public virtual SEE2Context DummySEE2Cont => dummySEE2Cont;

	public virtual int InitRL => initRL;

	public virtual int EscCount
	{
		get
		{
			return escCount;
		}
		set
		{
			escCount = value & 0xFF;
		}
	}

	public virtual int[] CharMask => charMask;

	public virtual int NumMasked
	{
		get
		{
			return numMasked;
		}
		set
		{
			numMasked = value;
		}
	}

	public virtual int PrevSuccess
	{
		get
		{
			return prevSuccess;
		}
		set
		{
			prevSuccess = value & 0xFF;
		}
	}

	public virtual int InitEsc
	{
		get
		{
			return initEsc;
		}
		set
		{
			initEsc = value;
		}
	}

	public virtual int RunLength
	{
		get
		{
			return runLength;
		}
		set
		{
			runLength = value;
		}
	}

	public virtual int HiBitsFlag
	{
		get
		{
			return hiBitsFlag;
		}
		set
		{
			hiBitsFlag = value & 0xFF;
		}
	}

	public virtual int[][] BinSumm => binSumm;

	internal RangeCoder Coder => coder;

	internal State FoundState => foundState;

	public virtual byte[] Heap => subAlloc.Heap;

	public virtual int OrderFall => orderFall;

	private void InitBlock()
	{
		for (int i = 0; i < 25; i++)
		{
			SEE2Cont[i] = new SEE2Context[16];
		}
		for (int j = 0; j < 128; j++)
		{
			binSumm[j] = new int[64];
		}
	}

	public ModelPPM()
	{
		InitBlock();
		minContext = null;
		maxContext = null;
	}

	private void restartModelRare()
	{
		Utility.Fill(charMask, 0);
		subAlloc.initSubAllocator();
		initRL = -((maxOrder < 12) ? maxOrder : 12) - 1;
		int address = subAlloc.allocContext();
		minContext.Address = address;
		maxContext.Address = address;
		minContext.setSuffix(0);
		orderFall = maxOrder;
		minContext.NumStats = 256;
		minContext.FreqData.SummFreq = minContext.NumStats + 1;
		address = subAlloc.allocUnits(128);
		foundState.Address = address;
		minContext.FreqData.SetStats(address);
		State state = new State(subAlloc.Heap);
		address = minContext.FreqData.GetStats();
		runLength = initRL;
		prevSuccess = 0;
		for (int i = 0; i < 256; i++)
		{
			state.Address = address + i * 6;
			state.Symbol = i;
			state.Freq = 1;
			state.SetSuccessor(0);
		}
		for (int j = 0; j < 128; j++)
		{
			for (int k = 0; k < 8; k++)
			{
				for (int l = 0; l < 64; l += 8)
				{
					binSumm[j][k + l] = BIN_SCALE - InitBinEsc[k] / (j + 2);
				}
			}
		}
		for (int m = 0; m < 25; m++)
		{
			for (int n = 0; n < 16; n++)
			{
				SEE2Cont[m][n].Initialize(5 * m + 10);
			}
		}
	}

	private void startModelRare(int MaxOrder)
	{
		escCount = 1;
		maxOrder = MaxOrder;
		restartModelRare();
		NS2BSIndx[0] = 0;
		NS2BSIndx[1] = 2;
		for (int i = 0; i < 9; i++)
		{
			NS2BSIndx[2 + i] = 4;
		}
		for (int j = 0; j < 245; j++)
		{
			NS2BSIndx[11 + j] = 6;
		}
		int k;
		for (k = 0; k < 3; k++)
		{
			NS2Indx[k] = k;
		}
		int num = k;
		int num2 = 1;
		int num3 = 1;
		for (; k < 256; k++)
		{
			NS2Indx[k] = num;
			if (--num2 == 0)
			{
				num2 = ++num3;
				num++;
			}
		}
		for (int l = 0; l < 64; l++)
		{
			HB2Flag[l] = 0;
		}
		for (int m = 0; m < 192; m++)
		{
			HB2Flag[64 + m] = 8;
		}
		dummySEE2Cont.Shift = 7;
	}

	private void clearMask()
	{
		escCount = 1;
		Utility.Fill(charMask, 0);
	}

	internal bool decodeInit(Unpack unpackRead, int escChar)
	{
		int num = unpackRead.Char & 0xFF;
		bool flag = (num & 0x20) != 0;
		int num2 = 0;
		if (flag)
		{
			num2 = unpackRead.Char;
		}
		else if (subAlloc.GetAllocatedMemory() == 0)
		{
			return false;
		}
		if ((num & 0x40) != 0)
		{
			escChar = unpackRead.Char;
			unpackRead.PpmEscChar = escChar;
		}
		coder = new RangeCoder(unpackRead);
		if (flag)
		{
			num = (num & 0x1F) + 1;
			if (num > 16)
			{
				num = 16 + (num - 16) * 3;
			}
			if (num == 1)
			{
				subAlloc.stopSubAllocator();
				return false;
			}
			subAlloc.startSubAllocator(num2 + 1 << 20);
			minContext = new PPMContext(Heap);
			maxContext = new PPMContext(Heap);
			foundState = new State(Heap);
			dummySEE2Cont = new SEE2Context();
			for (int i = 0; i < 25; i++)
			{
				for (int j = 0; j < 16; j++)
				{
					SEE2Cont[i][j] = new SEE2Context();
				}
			}
			startModelRare(num);
		}
		return minContext.Address != 0;
	}

	public virtual int decodeChar()
	{
		if (minContext.Address <= subAlloc.PText || minContext.Address > subAlloc.HeapEnd)
		{
			return -1;
		}
		if (minContext.NumStats != 1)
		{
			if (minContext.FreqData.GetStats() <= subAlloc.PText || minContext.FreqData.GetStats() > subAlloc.HeapEnd)
			{
				return -1;
			}
			if (!minContext.decodeSymbol1(this))
			{
				return -1;
			}
		}
		else
		{
			minContext.decodeBinSymbol(this);
		}
		coder.Decode();
		while (foundState.Address == 0)
		{
			coder.AriDecNormalize();
			do
			{
				orderFall++;
				minContext.Address = minContext.getSuffix();
				if (minContext.Address <= subAlloc.PText || minContext.Address > subAlloc.HeapEnd)
				{
					return -1;
				}
			}
			while (minContext.NumStats == numMasked);
			if (!minContext.decodeSymbol2(this))
			{
				return -1;
			}
			coder.Decode();
		}
		int symbol = foundState.Symbol;
		if (orderFall == 0 && foundState.GetSuccessor() > subAlloc.PText)
		{
			int successor = foundState.GetSuccessor();
			minContext.Address = successor;
			maxContext.Address = successor;
		}
		else
		{
			updateModel();
			if (escCount == 0)
			{
				clearMask();
			}
		}
		coder.AriDecNormalize();
		return symbol;
	}

	public virtual SEE2Context[][] getSEE2Cont()
	{
		return SEE2Cont;
	}

	public virtual void incEscCount(int dEscCount)
	{
		EscCount += dEscCount;
	}

	public virtual void incRunLength(int dRunLength)
	{
		RunLength += dRunLength;
	}

	public virtual int[] getHB2Flag()
	{
		return HB2Flag;
	}

	public virtual int[] getNS2BSIndx()
	{
		return NS2BSIndx;
	}

	public virtual int[] getNS2Indx()
	{
		return NS2Indx;
	}

	private int createSuccessors(bool Skip, State p1)
	{
		StateRef stateRef = tempStateRef2;
		State state = tempState1.Initialize(Heap);
		PPMContext pPMContext = tempPPMContext1.Initialize(Heap);
		pPMContext.Address = minContext.Address;
		PPMContext pPMContext2 = tempPPMContext2.Initialize(Heap);
		pPMContext2.Address = foundState.GetSuccessor();
		State state2 = tempState2.Initialize(Heap);
		int num = 0;
		bool flag = false;
		if (!Skip)
		{
			ps[num++] = foundState.Address;
			if (pPMContext.getSuffix() == 0)
			{
				flag = true;
			}
		}
		if (!flag)
		{
			bool flag2 = false;
			if (p1.Address != 0)
			{
				state2.Address = p1.Address;
				pPMContext.Address = pPMContext.getSuffix();
				flag2 = true;
			}
			do
			{
				if (!flag2)
				{
					pPMContext.Address = pPMContext.getSuffix();
					if (pPMContext.NumStats != 1)
					{
						state2.Address = pPMContext.FreqData.GetStats();
						if (state2.Symbol != foundState.Symbol)
						{
							do
							{
								state2.IncrementAddress();
							}
							while (state2.Symbol != foundState.Symbol);
						}
					}
					else
					{
						state2.Address = pPMContext.getOneState().Address;
					}
				}
				flag2 = false;
				if (state2.GetSuccessor() != pPMContext2.Address)
				{
					pPMContext.Address = state2.GetSuccessor();
					break;
				}
				ps[num++] = state2.Address;
			}
			while (pPMContext.getSuffix() != 0);
		}
		if (num == 0)
		{
			return pPMContext.Address;
		}
		stateRef.Symbol = Heap[pPMContext2.Address];
		stateRef.SetSuccessor(pPMContext2.Address + 1);
		if (pPMContext.NumStats != 1)
		{
			if (pPMContext.Address <= subAlloc.PText)
			{
				return 0;
			}
			state2.Address = pPMContext.FreqData.GetStats();
			if (state2.Symbol != stateRef.Symbol)
			{
				do
				{
					state2.IncrementAddress();
				}
				while (state2.Symbol != stateRef.Symbol);
			}
			int num2 = state2.Freq - 1;
			int num3 = pPMContext.FreqData.SummFreq - pPMContext.NumStats - num2;
			stateRef.Freq = 1 + ((2 * num2 > num3) ? ((2 * num2 + 3 * num3 - 1) / (2 * num3)) : ((5 * num2 > num3) ? 1 : 0));
		}
		else
		{
			stateRef.Freq = pPMContext.getOneState().Freq;
		}
		do
		{
			state.Address = ps[--num];
			pPMContext.Address = pPMContext.createChild(this, state, stateRef);
			if (pPMContext.Address == 0)
			{
				return 0;
			}
		}
		while (num != 0);
		return pPMContext.Address;
	}

	private void updateModelRestart()
	{
		restartModelRare();
		escCount = 0;
	}

	private void updateModel()
	{
		StateRef stateRef = tempStateRef1;
		stateRef.Values = foundState;
		State state = tempState3.Initialize(Heap);
		State state2 = tempState4.Initialize(Heap);
		PPMContext pPMContext = tempPPMContext3.Initialize(Heap);
		PPMContext pPMContext2 = tempPPMContext4.Initialize(Heap);
		pPMContext.Address = minContext.getSuffix();
		if (stateRef.Freq < 31 && pPMContext.Address != 0)
		{
			if (pPMContext.NumStats != 1)
			{
				state.Address = pPMContext.FreqData.GetStats();
				if (state.Symbol != stateRef.Symbol)
				{
					do
					{
						state.IncrementAddress();
					}
					while (state.Symbol != stateRef.Symbol);
					state2.Address = state.Address - 6;
					if (state.Freq >= state2.Freq)
					{
						State.PPMDSwap(state, state2);
						state.DecrementAddress();
					}
				}
				if (state.Freq < 115)
				{
					state.IncrementFreq(2);
					pPMContext.FreqData.IncrementSummFreq(2);
				}
			}
			else
			{
				state.Address = pPMContext.getOneState().Address;
				if (state.Freq < 32)
				{
					state.IncrementFreq(1);
				}
			}
		}
		if (orderFall == 0)
		{
			foundState.SetSuccessor(createSuccessors(Skip: true, state));
			minContext.Address = foundState.GetSuccessor();
			maxContext.Address = foundState.GetSuccessor();
			if (minContext.Address == 0)
			{
				updateModelRestart();
			}
			return;
		}
		subAlloc.Heap[subAlloc.PText] = (byte)stateRef.Symbol;
		subAlloc.incPText();
		pPMContext2.Address = subAlloc.PText;
		if (subAlloc.PText >= subAlloc.FakeUnitsStart)
		{
			updateModelRestart();
			return;
		}
		if (stateRef.GetSuccessor() != 0)
		{
			if (stateRef.GetSuccessor() <= subAlloc.PText)
			{
				stateRef.SetSuccessor(createSuccessors(Skip: false, state));
				if (stateRef.GetSuccessor() == 0)
				{
					updateModelRestart();
					return;
				}
			}
			if (--orderFall == 0)
			{
				pPMContext2.Address = stateRef.GetSuccessor();
				if (maxContext.Address != minContext.Address)
				{
					subAlloc.decPText(1);
				}
			}
		}
		else
		{
			foundState.SetSuccessor(pPMContext2.Address);
			stateRef.SetSuccessor(minContext);
		}
		int numStats = minContext.NumStats;
		int num = minContext.FreqData.SummFreq - numStats - (stateRef.Freq - 1);
		pPMContext.Address = maxContext.Address;
		while (pPMContext.Address != minContext.Address)
		{
			int numStats2;
			if ((numStats2 = pPMContext.NumStats) != 1)
			{
				if ((numStats2 & 1) == 0)
				{
					pPMContext.FreqData.SetStats(subAlloc.expandUnits(pPMContext.FreqData.GetStats(), Utility.URShift(numStats2, 1)));
					if (pPMContext.FreqData.GetStats() == 0)
					{
						updateModelRestart();
						return;
					}
				}
				int dSummFreq = ((2 * numStats2 < numStats) ? 1 : 0) + 2 * (((4 * numStats2 <= numStats) ? 1 : 0) & ((pPMContext.FreqData.SummFreq <= 8 * numStats2) ? 1 : 0));
				pPMContext.FreqData.IncrementSummFreq(dSummFreq);
			}
			else
			{
				state.Address = subAlloc.allocUnits(1);
				if (state.Address == 0)
				{
					updateModelRestart();
					return;
				}
				state.SetValues(pPMContext.getOneState());
				pPMContext.FreqData.SetStats(state);
				if (state.Freq < 30)
				{
					state.IncrementFreq(state.Freq);
				}
				else
				{
					state.Freq = 120;
				}
				pPMContext.FreqData.SummFreq = state.Freq + initEsc + ((numStats > 3) ? 1 : 0);
			}
			int num2 = 2 * stateRef.Freq * (pPMContext.FreqData.SummFreq + 6);
			int num3 = num + pPMContext.FreqData.SummFreq;
			if (num2 < 6 * num3)
			{
				num2 = 1 + ((num2 > num3) ? 1 : 0) + ((num2 >= 4 * num3) ? 1 : 0);
				pPMContext.FreqData.IncrementSummFreq(3);
			}
			else
			{
				num2 = 4 + ((num2 >= 9 * num3) ? 1 : 0) + ((num2 >= 12 * num3) ? 1 : 0) + ((num2 >= 15 * num3) ? 1 : 0);
				pPMContext.FreqData.IncrementSummFreq(num2);
			}
			state.Address = pPMContext.FreqData.GetStats() + numStats2 * 6;
			state.SetSuccessor(pPMContext2);
			state.Symbol = stateRef.Symbol;
			state.Freq = num2;
			numStats2 = (pPMContext.NumStats = numStats2 + 1);
			pPMContext.Address = pPMContext.getSuffix();
		}
		int successor = stateRef.GetSuccessor();
		maxContext.Address = successor;
		minContext.Address = successor;
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("ModelPPM[");
		stringBuilder.Append("\n  numMasked=");
		stringBuilder.Append(numMasked);
		stringBuilder.Append("\n  initEsc=");
		stringBuilder.Append(initEsc);
		stringBuilder.Append("\n  orderFall=");
		stringBuilder.Append(orderFall);
		stringBuilder.Append("\n  maxOrder=");
		stringBuilder.Append(maxOrder);
		stringBuilder.Append("\n  runLength=");
		stringBuilder.Append(runLength);
		stringBuilder.Append("\n  initRL=");
		stringBuilder.Append(initRL);
		stringBuilder.Append("\n  escCount=");
		stringBuilder.Append(escCount);
		stringBuilder.Append("\n  prevSuccess=");
		stringBuilder.Append(prevSuccess);
		stringBuilder.Append("\n  foundState=");
		stringBuilder.Append(foundState);
		stringBuilder.Append("\n  coder=");
		stringBuilder.Append(coder);
		stringBuilder.Append("\n  subAlloc=");
		stringBuilder.Append(subAlloc);
		stringBuilder.Append("\n]");
		return stringBuilder.ToString();
	}

	internal bool decodeInit(Stream stream, int maxOrder, int maxMemory)
	{
		if (stream != null)
		{
			coder = new RangeCoder(stream);
		}
		if (maxOrder == 1)
		{
			subAlloc.stopSubAllocator();
			return false;
		}
		subAlloc.startSubAllocator(maxMemory);
		minContext = new PPMContext(Heap);
		maxContext = new PPMContext(Heap);
		foundState = new State(Heap);
		dummySEE2Cont = new SEE2Context();
		for (int i = 0; i < 25; i++)
		{
			for (int j = 0; j < 16; j++)
			{
				SEE2Cont[i][j] = new SEE2Context();
			}
		}
		startModelRare(maxOrder);
		return minContext.Address != 0;
	}

	internal void nextContext()
	{
		int successor = foundState.GetSuccessor();
		if (orderFall == 0 && successor > subAlloc.PText)
		{
			minContext.Address = successor;
			maxContext.Address = successor;
		}
		else
		{
			updateModel();
		}
	}

	public int decodeChar(SharpCompress.Compressor.LZMA.RangeCoder.Decoder decoder)
	{
		if (minContext.NumStats != 1)
		{
			State state = tempState1.Initialize(Heap);
			state.Address = minContext.FreqData.GetStats();
			int threshold;
			int num;
			if ((threshold = (int)decoder.GetThreshold((uint)minContext.FreqData.SummFreq)) < (num = state.Freq))
			{
				decoder.Decode(0u, (uint)state.Freq);
				byte result = (byte)state.Symbol;
				minContext.update1_0(this, state.Address);
				nextContext();
				return result;
			}
			prevSuccess = 0;
			int num2 = minContext.NumStats - 1;
			do
			{
				state.IncrementAddress();
				if ((num += state.Freq) > threshold)
				{
					decoder.Decode((uint)(num - state.Freq), (uint)state.Freq);
					byte result2 = (byte)state.Symbol;
					minContext.update1(this, state.Address);
					nextContext();
					return result2;
				}
			}
			while (--num2 > 0);
			if (threshold >= minContext.FreqData.SummFreq)
			{
				return -2;
			}
			hiBitsFlag = HB2Flag[foundState.Symbol];
			decoder.Decode((uint)num, (uint)(minContext.FreqData.SummFreq - num));
			for (num2 = 0; num2 < 256; num2++)
			{
				charMask[num2] = -1;
			}
			charMask[state.Symbol] = 0;
			num2 = minContext.NumStats - 1;
			do
			{
				state.DecrementAddress();
				charMask[state.Symbol] = 0;
			}
			while (--num2 > 0);
		}
		else
		{
			State state2 = tempState1.Initialize(Heap);
			state2.Address = minContext.getOneState().Address;
			hiBitsFlag = getHB2Flag()[foundState.Symbol];
			int num3 = state2.Freq - 1;
			int arrayIndex = minContext.getArrayIndex(this, state2);
			int num4 = binSumm[num3][arrayIndex];
			if (decoder.DecodeBit((uint)num4, 14) == 0)
			{
				binSumm[num3][arrayIndex] = (num4 + INTERVAL - minContext.getMean(num4, 7, 2)) & 0xFFFF;
				foundState.Address = state2.Address;
				byte result3 = (byte)state2.Symbol;
				state2.IncrementFreq((state2.Freq < 128) ? 1 : 0);
				prevSuccess = 1;
				incRunLength(1);
				nextContext();
				return result3;
			}
			num4 = (num4 - minContext.getMean(num4, 7, 2)) & 0xFFFF;
			binSumm[num3][arrayIndex] = num4;
			initEsc = PPMContext.ExpEscape[Utility.URShift(num4, 10)];
			for (int i = 0; i < 256; i++)
			{
				charMask[i] = -1;
			}
			charMask[state2.Symbol] = 0;
			prevSuccess = 0;
		}
		while (true)
		{
			State state3 = tempState1.Initialize(Heap);
			int numStats = minContext.NumStats;
			do
			{
				orderFall++;
				minContext.Address = minContext.getSuffix();
				if (minContext.Address <= subAlloc.PText || minContext.Address > subAlloc.HeapEnd)
				{
					return -1;
				}
			}
			while (minContext.NumStats == numStats);
			int num5 = 0;
			state3.Address = minContext.FreqData.GetStats();
			int num6 = 0;
			int num7 = minContext.NumStats - numStats;
			do
			{
				int num8 = charMask[state3.Symbol];
				num5 += state3.Freq & num8;
				minContext.ps[num6] = state3.Address;
				state3.IncrementAddress();
				num6 -= num8;
			}
			while (num6 != num7);
			int escFreq;
			SEE2Context sEE2Context = minContext.makeEscFreq(this, numStats, out escFreq);
			escFreq += num5;
			int threshold2 = (int)decoder.GetThreshold((uint)escFreq);
			if (threshold2 < num5)
			{
				State state4 = tempState2.Initialize(Heap);
				num5 = 0;
				num6 = 0;
				state4.Address = minContext.ps[num6];
				while ((num5 += state4.Freq) <= threshold2)
				{
					num6++;
					state4.Address = minContext.ps[num6];
				}
				state3.Address = state4.Address;
				decoder.Decode((uint)(num5 - state3.Freq), (uint)state3.Freq);
				sEE2Context.update();
				byte result4 = (byte)state3.Symbol;
				minContext.update2(this, state3.Address);
				updateModel();
				return result4;
			}
			if (threshold2 >= escFreq)
			{
				break;
			}
			decoder.Decode((uint)num5, (uint)(escFreq - num5));
			sEE2Context.Summ += escFreq;
			do
			{
				state3.Address = minContext.ps[--num6];
				charMask[state3.Symbol] = 0;
			}
			while (num6 != 0);
		}
		return -2;
	}
}
