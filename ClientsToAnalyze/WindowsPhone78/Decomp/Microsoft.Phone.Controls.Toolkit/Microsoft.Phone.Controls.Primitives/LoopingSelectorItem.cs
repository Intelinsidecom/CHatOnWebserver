using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;

namespace Microsoft.Phone.Controls.Primitives;

[TemplateVisualState(GroupName = "Common", Name = "Expanded")]
[TemplateVisualState(GroupName = "Common", Name = "Selected")]
[TemplatePart(Name = "Transform", Type = typeof(TranslateTransform))]
[TemplateVisualState(GroupName = "Common", Name = "Normal")]
public class LoopingSelectorItem : ContentControl
{
	internal enum State
	{
		Normal,
		Expanded,
		Selected
	}

	private const string TransformPartName = "Transform";

	private const string CommonGroupName = "Common";

	private const string NormalStateName = "Normal";

	private const string ExpandedStateName = "Expanded";

	private const string SelectedStateName = "Selected";

	private bool _shouldClick;

	private State _state;

	internal LoopingSelectorItem Previous { get; private set; }

	internal LoopingSelectorItem Next { get; private set; }

	internal TranslateTransform Transform { get; private set; }

	public event EventHandler<EventArgs> Click;

	public LoopingSelectorItem()
	{
		base.DefaultStyleKey = typeof(LoopingSelectorItem);
		base.MouseLeftButtonDown += LoopingSelectorItem_MouseLeftButtonDown;
		base.MouseLeftButtonUp += LoopingSelectorItem_MouseLeftButtonUp;
		base.LostMouseCapture += LoopingSelectorItem_LostMouseCapture;
		base.Tap += LoopingSelectorItem_Tap;
	}

	internal void SetState(State newState, bool useTransitions)
	{
		if (_state != newState)
		{
			_state = newState;
			switch (_state)
			{
			case State.Normal:
				VisualStateManager.GoToState(this, "Normal", useTransitions);
				break;
			case State.Expanded:
				VisualStateManager.GoToState(this, "Expanded", useTransitions);
				break;
			case State.Selected:
				VisualStateManager.GoToState(this, "Selected", useTransitions);
				break;
			}
		}
	}

	internal State GetState()
	{
		return _state;
	}

	private void LoopingSelectorItem_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		e.Handled = true;
	}

	private void LoopingSelectorItem_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
	{
		CaptureMouse();
		_shouldClick = true;
	}

	private void LoopingSelectorItem_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
	{
		ReleaseMouseCapture();
		if (_shouldClick)
		{
			_shouldClick = false;
			Microsoft.Phone.Controls.SafeRaise.Raise(this.Click, this);
		}
	}

	private void LoopingSelectorItem_LostMouseCapture(object sender, MouseEventArgs e)
	{
		_shouldClick = false;
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		Transform = (GetTemplateChild("Transform") as TranslateTransform) ?? new TranslateTransform();
	}

	internal void Remove()
	{
		if (Previous != null)
		{
			Previous.Next = Next;
		}
		if (Next != null)
		{
			Next.Previous = Previous;
		}
		LoopingSelectorItem next = (Previous = null);
		Next = next;
	}

	internal void InsertAfter(LoopingSelectorItem after)
	{
		Next = after.Next;
		Previous = after;
		if (after.Next != null)
		{
			after.Next.Previous = this;
		}
		after.Next = this;
	}

	internal void InsertBefore(LoopingSelectorItem before)
	{
		Next = before;
		Previous = before.Previous;
		if (before.Previous != null)
		{
			before.Previous.Next = this;
		}
		before.Previous = this;
	}
}
