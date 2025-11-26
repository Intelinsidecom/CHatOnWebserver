using System;
using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class PPMContext : Pointer
{
	private static readonly int unionSize;

	public static readonly int size;

	private int numStats;

	private FreqData freqData;

	private State oneState;

	private int suffix;

	public static readonly int[] ExpEscape;

	private State tempState1 = new State(null);

	private State tempState2 = new State(null);

	private State tempState3 = new State(null);

	private State tempState4 = new State(null);

	private State tempState5 = new State(null);

	private PPMContext tempPPMContext;

	internal int[] ps = new int[256];

	internal FreqData FreqData
	{
		get
		{
			return freqData;
		}
		set
		{
			freqData.SummFreq = value.SummFreq;
			freqData.SetStats(value.GetStats());
		}
	}

	public virtual int NumStats
	{
		get
		{
			if (base.Memory != null)
			{
				numStats = Utility.readShortLittleEndian(base.Memory, Address) & 0xFFFF;
			}
			return numStats;
		}
		set
		{
			numStats = value & 0xFFFF;
			if (base.Memory != null)
			{
				Utility.WriteLittleEndian(base.Memory, Address, (short)value);
			}
		}
	}

	internal override int Address
	{
		get
		{
			return base.Address;
		}
		set
		{
			base.Address = value;
			oneState.Address = value + 2;
			freqData.Address = value + 2;
		}
	}

	public PPMContext(byte[] Memory)
		: base(Memory)
	{
		oneState = new State(Memory);
		freqData = new FreqData(Memory);
	}

	internal PPMContext Initialize(byte[] mem)
	{
		oneState.Initialize(mem);
		freqData.Initialize(mem);
		return Initialize<PPMContext>(mem);
	}

	internal State getOneState()
	{
		return oneState;
	}

	internal void setOneState(StateRef oneState)
	{
		this.oneState.SetValues(oneState);
	}

	internal int getSuffix()
	{
		if (base.Memory != null)
		{
			suffix = Utility.readIntLittleEndian(base.Memory, Address + 8);
		}
		return suffix;
	}

	internal void setSuffix(PPMContext suffix)
	{
		setSuffix(suffix.Address);
	}

	internal void setSuffix(int suffix)
	{
		this.suffix = suffix;
		if (base.Memory != null)
		{
			Utility.WriteLittleEndian(base.Memory, Address + 8, suffix);
		}
	}

	private PPMContext getTempPPMContext(byte[] Memory)
	{
		if (tempPPMContext == null)
		{
			tempPPMContext = new PPMContext(null);
		}
		return tempPPMContext.Initialize(Memory);
	}

	internal int createChild(ModelPPM model, State pStats, StateRef firstState)
	{
		PPMContext pPMContext = getTempPPMContext(model.SubAlloc.Heap);
		pPMContext.Address = model.SubAlloc.allocContext();
		if (pPMContext != null)
		{
			pPMContext.NumStats = 1;
			pPMContext.setOneState(firstState);
			pPMContext.setSuffix(this);
			pStats.SetSuccessor(pPMContext);
		}
		return pPMContext.Address;
	}

	internal void rescale(ModelPPM model)
	{
		int num = NumStats;
		int num2 = NumStats - 1;
		State state = new State(model.Heap);
		State state2 = new State(model.Heap);
		State state3 = new State(model.Heap);
		state2.Address = model.FoundState.Address;
		while (state2.Address != freqData.GetStats())
		{
			state3.Address = state2.Address - 6;
			State.PPMDSwap(state2, state3);
			state2.DecrementAddress();
		}
		state3.Address = freqData.GetStats();
		state3.IncrementFreq(4);
		freqData.IncrementSummFreq(4);
		int num3 = freqData.SummFreq - state2.Freq;
		int num4 = ((model.OrderFall != 0) ? 1 : 0);
		state2.Freq = Utility.URShift(state2.Freq + num4, 1);
		freqData.SummFreq = state2.Freq;
		do
		{
			state2.IncrementAddress();
			num3 -= state2.Freq;
			state2.Freq = Utility.URShift(state2.Freq + num4, 1);
			freqData.IncrementSummFreq(state2.Freq);
			state3.Address = state2.Address - 6;
			if (state2.Freq > state3.Freq)
			{
				state.Address = state2.Address;
				StateRef stateRef = new StateRef();
				stateRef.Values = state;
				State state4 = new State(model.Heap);
				State state5 = new State(model.Heap);
				do
				{
					state4.Address = state.Address - 6;
					state.SetValues(state4);
					state.DecrementAddress();
					state5.Address = state.Address - 6;
				}
				while (state.Address != freqData.GetStats() && stateRef.Freq > state5.Freq);
				state.SetValues(stateRef);
			}
		}
		while (--num2 != 0);
		if (state2.Freq == 0)
		{
			do
			{
				num2++;
				state2.DecrementAddress();
			}
			while (state2.Freq == 0);
			num3 += num2;
			NumStats -= num2;
			if (NumStats == 1)
			{
				StateRef stateRef2 = new StateRef();
				state3.Address = freqData.GetStats();
				stateRef2.Values = state3;
				do
				{
					stateRef2.DecrementFreq(Utility.URShift(stateRef2.Freq, 1));
					num3 = Utility.URShift(num3, 1);
				}
				while (num3 > 1);
				model.SubAlloc.freeUnits(freqData.GetStats(), Utility.URShift(num + 1, 1));
				oneState.SetValues(stateRef2);
				model.FoundState.Address = oneState.Address;
				return;
			}
		}
		num3 -= Utility.URShift(num3, 1);
		freqData.IncrementSummFreq(num3);
		int num5 = Utility.URShift(num + 1, 1);
		int num6 = Utility.URShift(NumStats + 1, 1);
		if (num5 != num6)
		{
			freqData.SetStats(model.SubAlloc.shrinkUnits(freqData.GetStats(), num5, num6));
		}
		model.FoundState.Address = freqData.GetStats();
	}

	internal int getArrayIndex(ModelPPM Model, State rs)
	{
		PPMContext pPMContext = getTempPPMContext(Model.SubAlloc.Heap);
		pPMContext.Address = getSuffix();
		int num = 0;
		num += Model.PrevSuccess;
		num += Model.getNS2BSIndx()[pPMContext.NumStats - 1];
		num += Model.HiBitsFlag + 2 * Model.getHB2Flag()[rs.Symbol];
		return num + (Utility.URShift(Model.RunLength, 26) & 0x20);
	}

	internal int getMean(int summ, int shift, int round)
	{
		return Utility.URShift(summ + (1 << shift - round), shift);
	}

	internal void decodeBinSymbol(ModelPPM model)
	{
		State state = tempState1.Initialize(model.Heap);
		state.Address = oneState.Address;
		model.HiBitsFlag = model.getHB2Flag()[model.FoundState.Symbol];
		int num = state.Freq - 1;
		int arrayIndex = getArrayIndex(model, state);
		int num2 = model.BinSumm[num][arrayIndex];
		if (model.Coder.GetCurrentShiftCount(ModelPPM.TOT_BITS) < num2)
		{
			model.FoundState.Address = state.Address;
			state.IncrementFreq((state.Freq < 128) ? 1 : 0);
			model.Coder.SubRange.LowCount = 0L;
			model.Coder.SubRange.HighCount = num2;
			num2 = (num2 + ModelPPM.INTERVAL - getMean(num2, 7, 2)) & 0xFFFF;
			model.BinSumm[num][arrayIndex] = num2;
			model.PrevSuccess = 1;
			model.incRunLength(1);
		}
		else
		{
			model.Coder.SubRange.LowCount = num2;
			num2 = (num2 - getMean(num2, 7, 2)) & 0xFFFF;
			model.BinSumm[num][arrayIndex] = num2;
			model.Coder.SubRange.HighCount = ModelPPM.BIN_SCALE;
			model.InitEsc = ExpEscape[Utility.URShift(num2, 10)];
			model.NumMasked = 1;
			model.CharMask[state.Symbol] = model.EscCount;
			model.PrevSuccess = 0;
			model.FoundState.Address = 0;
		}
	}

	internal void update1(ModelPPM model, int p)
	{
		model.FoundState.Address = p;
		model.FoundState.IncrementFreq(4);
		freqData.IncrementSummFreq(4);
		State state = tempState3.Initialize(model.Heap);
		State state2 = tempState4.Initialize(model.Heap);
		state.Address = p;
		state2.Address = p - 6;
		if (state.Freq > state2.Freq)
		{
			State.PPMDSwap(state, state2);
			model.FoundState.Address = state2.Address;
			if (state2.Freq > 124)
			{
				rescale(model);
			}
		}
	}

	internal void update1_0(ModelPPM model, int p)
	{
		model.FoundState.Address = p;
		model.PrevSuccess = ((2 * model.FoundState.Freq > freqData.SummFreq) ? 1 : 0);
		model.incRunLength(model.PrevSuccess);
		freqData.IncrementSummFreq(4);
		model.FoundState.IncrementFreq(4);
		if (model.FoundState.Freq > 124)
		{
			rescale(model);
		}
	}

	internal bool decodeSymbol2(ModelPPM model)
	{
		int num = NumStats - model.NumMasked;
		SEE2Context sEE2Context = makeEscFreq2(model, num);
		RangeCoder coder = model.Coder;
		State state = tempState1.Initialize(model.Heap);
		State state2 = tempState2.Initialize(model.Heap);
		state.Address = freqData.GetStats() - 6;
		int num2 = 0;
		int num3 = 0;
		while (true)
		{
			state.IncrementAddress();
			if (model.CharMask[state.Symbol] != model.EscCount)
			{
				num3 += state.Freq;
				ps[num2++] = state.Address;
				if (--num == 0)
				{
					break;
				}
			}
		}
		coder.SubRange.incScale(num3);
		long num4 = coder.CurrentCount;
		if (num4 >= coder.SubRange.Scale)
		{
			return false;
		}
		num2 = 0;
		state.Address = ps[num2];
		if (num4 < num3)
		{
			num3 = 0;
			while ((num3 += state.Freq) <= num4)
			{
				state.Address = ps[++num2];
			}
			coder.SubRange.HighCount = num3;
			coder.SubRange.LowCount = num3 - state.Freq;
			sEE2Context.update();
			update2(model, state.Address);
		}
		else
		{
			coder.SubRange.LowCount = num3;
			coder.SubRange.HighCount = coder.SubRange.Scale;
			num = NumStats - model.NumMasked;
			num2--;
			do
			{
				state2.Address = ps[++num2];
				model.CharMask[state2.Symbol] = model.EscCount;
			}
			while (--num != 0);
			sEE2Context.incSumm((int)coder.SubRange.Scale);
			model.NumMasked = NumStats;
		}
		return true;
	}

	internal void update2(ModelPPM model, int p)
	{
		State state = tempState5.Initialize(model.Heap);
		state.Address = p;
		model.FoundState.Address = p;
		model.FoundState.IncrementFreq(4);
		freqData.IncrementSummFreq(4);
		if (state.Freq > 124)
		{
			rescale(model);
		}
		model.incEscCount(1);
		model.RunLength = model.InitRL;
	}

	private SEE2Context makeEscFreq2(ModelPPM model, int Diff)
	{
		int num = NumStats;
		SEE2Context sEE2Context;
		if (num != 256)
		{
			PPMContext pPMContext = getTempPPMContext(model.Heap);
			pPMContext.Address = getSuffix();
			int num2 = model.getNS2Indx()[Diff - 1];
			int num3 = 0;
			num3 += ((Diff < pPMContext.NumStats - num) ? 1 : 0);
			num3 += 2 * ((freqData.SummFreq < 11 * num) ? 1 : 0);
			num3 += 4 * ((model.NumMasked > Diff) ? 1 : 0);
			num3 += model.HiBitsFlag;
			sEE2Context = model.getSEE2Cont()[num2][num3];
			model.Coder.SubRange.Scale = sEE2Context.Mean;
		}
		else
		{
			sEE2Context = model.DummySEE2Cont;
			model.Coder.SubRange.Scale = 1L;
		}
		return sEE2Context;
	}

	internal SEE2Context makeEscFreq(ModelPPM model, int numMasked, out int escFreq)
	{
		int num = NumStats;
		int num2 = num - numMasked;
		SEE2Context sEE2Context;
		if (num != 256)
		{
			PPMContext pPMContext = getTempPPMContext(model.Heap);
			pPMContext.Address = getSuffix();
			int num3 = model.getNS2Indx()[num2 - 1];
			int num4 = 0;
			num4 += ((num2 < pPMContext.NumStats - num) ? 1 : 0);
			num4 += 2 * ((freqData.SummFreq < 11 * num) ? 1 : 0);
			num4 += 4 * ((numMasked > num2) ? 1 : 0);
			num4 += model.HiBitsFlag;
			sEE2Context = model.getSEE2Cont()[num3][num4];
			escFreq = sEE2Context.Mean;
		}
		else
		{
			sEE2Context = model.DummySEE2Cont;
			escFreq = 1;
		}
		return sEE2Context;
	}

	internal bool decodeSymbol1(ModelPPM model)
	{
		RangeCoder coder = model.Coder;
		coder.SubRange.Scale = freqData.SummFreq;
		State state = new State(model.Heap);
		state.Address = freqData.GetStats();
		long num = coder.CurrentCount;
		if (num >= coder.SubRange.Scale)
		{
			return false;
		}
		int num2;
		if (num < (num2 = state.Freq))
		{
			coder.SubRange.HighCount = num2;
			model.PrevSuccess = ((2 * num2 > coder.SubRange.Scale) ? 1 : 0);
			model.incRunLength(model.PrevSuccess);
			num2 += 4;
			model.FoundState.Address = state.Address;
			model.FoundState.Freq = num2;
			freqData.IncrementSummFreq(4);
			if (num2 > 124)
			{
				rescale(model);
			}
			coder.SubRange.LowCount = 0L;
			return true;
		}
		if (model.FoundState.Address == 0)
		{
			return false;
		}
		model.PrevSuccess = 0;
		int num3 = NumStats;
		int num4 = num3 - 1;
		while ((num2 += state.IncrementAddress().Freq) <= num)
		{
			if (--num4 == 0)
			{
				model.HiBitsFlag = model.getHB2Flag()[model.FoundState.Symbol];
				coder.SubRange.LowCount = num2;
				model.CharMask[state.Symbol] = model.EscCount;
				model.NumMasked = num3;
				num4 = num3 - 1;
				model.FoundState.Address = 0;
				do
				{
					model.CharMask[state.DecrementAddress().Symbol] = model.EscCount;
				}
				while (--num4 != 0);
				coder.SubRange.HighCount = coder.SubRange.Scale;
				return true;
			}
		}
		coder.SubRange.LowCount = num2 - state.Freq;
		coder.SubRange.HighCount = num2;
		update1(model, state.Address);
		return true;
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("PPMContext[");
		stringBuilder.Append("\n  Address=");
		stringBuilder.Append(Address);
		stringBuilder.Append("\n  size=");
		stringBuilder.Append(size);
		stringBuilder.Append("\n  numStats=");
		stringBuilder.Append(NumStats);
		stringBuilder.Append("\n  Suffix=");
		stringBuilder.Append(getSuffix());
		stringBuilder.Append("\n  freqData=");
		stringBuilder.Append(freqData);
		stringBuilder.Append("\n  oneState=");
		stringBuilder.Append(oneState);
		stringBuilder.Append("\n]");
		return stringBuilder.ToString();
	}

	static PPMContext()
	{
		size = 2 + unionSize + 4;
		ExpEscape = new int[16]
		{
			25, 14, 9, 7, 5, 5, 4, 4, 4, 3,
			3, 3, 2, 2, 2, 2
		};
		unionSize = Math.Max(6, 6);
	}
}
