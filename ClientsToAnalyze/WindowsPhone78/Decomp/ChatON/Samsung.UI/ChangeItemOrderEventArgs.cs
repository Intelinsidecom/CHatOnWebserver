using System;

namespace Samsung.UI;

public class ChangeItemOrderEventArgs : EventArgs
{
	private int _sourceIndex;

	private int _targetIndex;

	public int SourceIndex => _sourceIndex;

	public int TargetIndex => _targetIndex;

	public ChangeItemOrderEventArgs(int sourceIndex, int targetIndex)
	{
		_sourceIndex = sourceIndex;
		_targetIndex = targetIndex;
	}
}
