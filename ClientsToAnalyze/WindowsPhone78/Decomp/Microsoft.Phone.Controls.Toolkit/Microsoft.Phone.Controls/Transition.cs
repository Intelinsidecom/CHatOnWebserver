using System;
using System.Windows;
using System.Windows.Media;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls;

public class Transition : ITransition
{
	private CacheMode _cacheMode;

	private UIElement _element;

	private bool _isHitTestVisible;

	private Storyboard _storyboard;

	public event EventHandler Completed
	{
		add
		{
			_storyboard.Completed += value;
		}
		remove
		{
			_storyboard.Completed -= value;
		}
	}

	public Transition(UIElement element, Storyboard storyboard)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		if (storyboard == null)
		{
			throw new ArgumentNullException("storyboard");
		}
		_element = element;
		_storyboard = storyboard;
	}

	public void Begin()
	{
		Save();
		_storyboard.Completed += OnCompletedRestore;
		_storyboard.Begin();
	}

	private void OnCompletedRestore(object sender, EventArgs e)
	{
		Restore();
	}

	public ClockState GetCurrentState()
	{
		return _storyboard.GetCurrentState();
	}

	public TimeSpan GetCurrentTime()
	{
		return _storyboard.GetCurrentTime();
	}

	public void Pause()
	{
		_storyboard.Pause();
	}

	private void Restore()
	{
		if (!(_cacheMode is BitmapCache))
		{
			_element.CacheMode = _cacheMode;
		}
		if (_isHitTestVisible)
		{
			_element.IsHitTestVisible = _isHitTestVisible;
		}
		else
		{
			_element.IsHitTestVisible = true;
		}
	}

	public void Resume()
	{
		_storyboard.Resume();
	}

	private void Save()
	{
		_cacheMode = _element.CacheMode;
		if (!(_cacheMode is BitmapCache))
		{
			_element.CacheMode = TransitionFrame.BitmapCacheMode;
		}
		_isHitTestVisible = _element.IsHitTestVisible;
		if (_isHitTestVisible)
		{
			_element.IsHitTestVisible = false;
		}
	}

	public void Seek(TimeSpan offset)
	{
		_storyboard.Seek(offset);
	}

	public void SeekAlignedToLastTick(TimeSpan offset)
	{
		_storyboard.SeekAlignedToLastTick(offset);
	}

	public void SkipToFill()
	{
		_storyboard.SkipToFill();
	}

	public void Stop()
	{
		_storyboard.Stop();
		Restore();
	}
}
