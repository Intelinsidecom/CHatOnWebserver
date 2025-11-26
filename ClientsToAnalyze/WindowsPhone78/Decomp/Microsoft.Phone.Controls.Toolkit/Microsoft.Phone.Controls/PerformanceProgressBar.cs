using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "EmbeddedProgressBar", Type = typeof(ProgressBar))]
[TemplateVisualState(GroupName = "VisibilityStates", Name = "Normal")]
[TemplateVisualState(GroupName = "VisibilityStates", Name = "Hidden")]
public class PerformanceProgressBar : Control
{
	private const string EmbeddedProgressBarName = "EmbeddedProgressBar";

	private const string VisualStateGroupName = "VisibilityStates";

	private const string NormalState = "Normal";

	private const string HiddenState = "Hidden";

	private ProgressBar _progressBar;

	private static readonly PropertyPath ActualIsIndeterminatePath = new PropertyPath("ActualIsIndeterminate");

	private VisualStateGroup _visualStateGroup;

	private bool _cachedIsIndeterminate;

	public static readonly DependencyProperty ActualIsIndeterminateProperty = DependencyProperty.Register("ActualIsIndeterminate", typeof(bool), typeof(PerformanceProgressBar), new PropertyMetadata(false));

	public static readonly DependencyProperty IsIndeterminateProperty = DependencyProperty.Register("IsIndeterminate", typeof(bool), typeof(PerformanceProgressBar), new PropertyMetadata(false, OnIsIndeterminatePropertyChanged));

	public bool ActualIsIndeterminate
	{
		get
		{
			return (bool)GetValue(ActualIsIndeterminateProperty);
		}
		set
		{
			SetValue(ActualIsIndeterminateProperty, value);
		}
	}

	public bool IsIndeterminate
	{
		get
		{
			return (bool)GetValue(IsIndeterminateProperty);
		}
		set
		{
			SetValue(IsIndeterminateProperty, value);
		}
	}

	private static void OnIsIndeterminatePropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		if (d is PerformanceProgressBar performanceProgressBar)
		{
			performanceProgressBar.OnIsIndeterminateChanged((bool)e.NewValue);
		}
	}

	public PerformanceProgressBar()
	{
		base.DefaultStyleKey = typeof(PerformanceProgressBar);
		base.Unloaded += OnUnloaded;
		base.Loaded += OnLoaded;
	}

	public override void OnApplyTemplate()
	{
		if (_visualStateGroup != null)
		{
			_visualStateGroup.CurrentStateChanged -= OnVisualStateChanged;
		}
		base.OnApplyTemplate();
		_visualStateGroup = VisualStates.TryGetVisualStateGroup(this, "VisibilityStates");
		if (_visualStateGroup != null)
		{
			_visualStateGroup.CurrentStateChanged += OnVisualStateChanged;
		}
		_progressBar = GetTemplateChild("EmbeddedProgressBar") as ProgressBar;
		UpdateVisualStates(useTransitions: false);
	}

	private void OnVisualStateChanged(object sender, VisualStateChangedEventArgs e)
	{
		if (ActualIsIndeterminate && e != null && e.NewState != null && e.NewState.Name == "Hidden" && !IsIndeterminate)
		{
			ActualIsIndeterminate = false;
		}
	}

	private void OnIsIndeterminateChanged(bool newValue)
	{
		if (newValue)
		{
			ActualIsIndeterminate = true;
			_cachedIsIndeterminate = true;
		}
		else if (ActualIsIndeterminate && _visualStateGroup == null)
		{
			ActualIsIndeterminate = false;
			_cachedIsIndeterminate = false;
		}
		UpdateVisualStates(useTransitions: true);
	}

	private void UpdateVisualStates(bool useTransitions)
	{
		VisualStateManager.GoToState(this, IsIndeterminate ? "Normal" : "Hidden", useTransitions);
	}

	private void OnUnloaded(object sender, RoutedEventArgs ea)
	{
		if (_progressBar != null)
		{
			_cachedIsIndeterminate = IsIndeterminate;
			_progressBar.IsIndeterminate = false;
		}
	}

	private void OnLoaded(object sender, RoutedEventArgs ea)
	{
		if (_progressBar != null)
		{
			_progressBar.SetBinding(ProgressBar.IsIndeterminateProperty, new Binding
			{
				Source = this,
				Path = ActualIsIndeterminatePath
			});
		}
	}

	private static T FindFirstChildOfType<T>(DependencyObject root) where T : class
	{
		Queue<DependencyObject> queue = new Queue<DependencyObject>();
		queue.Enqueue(root);
		while (0 < queue.Count)
		{
			DependencyObject reference = queue.Dequeue();
			int num = VisualTreeHelper.GetChildrenCount(reference) - 1;
			while (0 <= num)
			{
				DependencyObject child = VisualTreeHelper.GetChild(reference, num);
				if (child is T result)
				{
					return result;
				}
				queue.Enqueue(child);
				num--;
			}
		}
		return null;
	}
}
