using System;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls;

public interface ITransition
{
	event EventHandler Completed;

	ClockState GetCurrentState();

	TimeSpan GetCurrentTime();

	void Pause();

	void Resume();

	void Seek(TimeSpan offset);

	void SeekAlignedToLastTick(TimeSpan offset);

	void SkipToFill();

	void Begin();

	void Stop();
}
