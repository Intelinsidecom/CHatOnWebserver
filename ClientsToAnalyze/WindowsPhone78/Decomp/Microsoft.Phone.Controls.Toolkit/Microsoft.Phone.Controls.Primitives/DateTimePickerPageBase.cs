using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Navigation;
using Microsoft.Phone.Controls.LocalizedResources;
using Microsoft.Phone.Shell;

namespace Microsoft.Phone.Controls.Primitives;

public abstract class DateTimePickerPageBase : PhoneApplicationPage, IDateTimePickerPage
{
	private const string VisibilityGroupName = "VisibilityStates";

	private const string OpenVisibilityStateName = "Open";

	private const string ClosedVisibilityStateName = "Closed";

	private const string StateKey_Value = "DateTimePickerPageBase_State_Value";

	private LoopingSelector _primarySelectorPart;

	private LoopingSelector _secondarySelectorPart;

	private LoopingSelector _tertiarySelectorPart;

	private Storyboard _closedStoryboard;

	private DateTime? _value;

	public DateTime? Value
	{
		get
		{
			return _value;
		}
		set
		{
			_value = value;
			DateTimeWrapper selectedItem = new DateTimeWrapper(_value.GetValueOrDefault(DateTime.Now));
			_primarySelectorPart.DataSource.SelectedItem = selectedItem;
			_secondarySelectorPart.DataSource.SelectedItem = selectedItem;
			_tertiarySelectorPart.DataSource.SelectedItem = selectedItem;
		}
	}

	protected void InitializeDateTimePickerPage(LoopingSelector primarySelector, LoopingSelector secondarySelector, LoopingSelector tertiarySelector)
	{
		if (primarySelector == null)
		{
			throw new ArgumentNullException("primarySelector");
		}
		if (secondarySelector == null)
		{
			throw new ArgumentNullException("secondarySelector");
		}
		if (tertiarySelector == null)
		{
			throw new ArgumentNullException("tertiarySelector");
		}
		_primarySelectorPart = primarySelector;
		_secondarySelectorPart = secondarySelector;
		_tertiarySelectorPart = tertiarySelector;
		_primarySelectorPart.DataSource.SelectionChanged += HandleDataSourceSelectionChanged;
		_secondarySelectorPart.DataSource.SelectionChanged += HandleDataSourceSelectionChanged;
		_tertiarySelectorPart.DataSource.SelectionChanged += HandleDataSourceSelectionChanged;
		_primarySelectorPart.IsExpandedChanged += HandleSelectorIsExpandedChanged;
		_secondarySelectorPart.IsExpandedChanged += HandleSelectorIsExpandedChanged;
		_tertiarySelectorPart.IsExpandedChanged += HandleSelectorIsExpandedChanged;
		_primarySelectorPart.Visibility = Visibility.Collapsed;
		_secondarySelectorPart.Visibility = Visibility.Collapsed;
		_tertiarySelectorPart.Visibility = Visibility.Collapsed;
		int num = 0;
		foreach (LoopingSelector item in GetSelectorsOrderedByCulturePattern())
		{
			if (DatePicker.DaySelectorVisibility != Visibility.Collapsed || _tertiarySelectorPart != item)
			{
				Grid.SetColumn(item, num);
				item.Visibility = Visibility.Visible;
				num++;
			}
		}
		if (VisualTreeHelper.GetChild((DependencyObject)(object)this, 0) is FrameworkElement obj)
		{
			foreach (VisualStateGroup visualStateGroup in VisualStateManager.GetVisualStateGroups(obj))
			{
				if (!("VisibilityStates" == visualStateGroup.Name))
				{
					continue;
				}
				foreach (VisualState state in visualStateGroup.States)
				{
					if ("Closed" == state.Name && state.Storyboard != null)
					{
						_closedStoryboard = state.Storyboard;
						_closedStoryboard.Completed += HandleClosedStoryboardCompleted;
					}
				}
			}
		}
		if (((PhoneApplicationPage)this).ApplicationBar != null)
		{
			foreach (object button in ((PhoneApplicationPage)this).ApplicationBar.Buttons)
			{
				IApplicationBarIconButton val = (IApplicationBarIconButton)((button is IApplicationBarIconButton) ? button : null);
				if (val != null)
				{
					if ("DONE" == ((IApplicationBarMenuItem)val).Text)
					{
						((IApplicationBarMenuItem)val).Text = ControlResources.DateTimePickerDoneText;
						((IApplicationBarMenuItem)val).Click += HandleDoneButtonClick;
					}
					else if ("CANCEL" == ((IApplicationBarMenuItem)val).Text)
					{
						((IApplicationBarMenuItem)val).Text = ControlResources.DateTimePickerCancelText;
						((IApplicationBarMenuItem)val).Click += HandleCancelButtonClick;
					}
				}
			}
		}
		VisualStateManager.GoToState((Control)(object)this, "Open", useTransitions: true);
	}

	private void HandleDataSourceSelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		DataSource dataSource = (DataSource)sender;
		_primarySelectorPart.DataSource.SelectedItem = dataSource.SelectedItem;
		_secondarySelectorPart.DataSource.SelectedItem = dataSource.SelectedItem;
		_tertiarySelectorPart.DataSource.SelectedItem = dataSource.SelectedItem;
	}

	private void HandleSelectorIsExpandedChanged(object sender, DependencyPropertyChangedEventArgs e)
	{
		if ((bool)e.NewValue)
		{
			_primarySelectorPart.IsExpanded = sender == _primarySelectorPart;
			_secondarySelectorPart.IsExpanded = sender == _secondarySelectorPart;
			_tertiarySelectorPart.IsExpanded = sender == _tertiarySelectorPart;
		}
	}

	private void HandleDoneButtonClick(object sender, EventArgs e)
	{
		_value = ((DateTimeWrapper)_primarySelectorPart.DataSource.SelectedItem).DateTime;
		ClosePickerPage();
	}

	private void HandleCancelButtonClick(object sender, EventArgs e)
	{
		_value = null;
		ClosePickerPage();
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		e.Cancel = true;
		ClosePickerPage();
	}

	private void ClosePickerPage()
	{
		if (_closedStoryboard != null)
		{
			VisualStateManager.GoToState((Control)(object)this, "Closed", useTransitions: true);
		}
		else
		{
			HandleClosedStoryboardCompleted(null, null);
		}
	}

	private void HandleClosedStoryboardCompleted(object sender, EventArgs e)
	{
		((Page)this).NavigationService.GoBack();
	}

	protected abstract IEnumerable<LoopingSelector> GetSelectorsOrderedByCulturePattern();

	protected static IEnumerable<LoopingSelector> GetSelectorsOrderedByCulturePattern(string pattern, char[] patternCharacters, LoopingSelector[] selectors)
	{
		if (pattern == null)
		{
			throw new ArgumentNullException("pattern");
		}
		if (patternCharacters == null)
		{
			throw new ArgumentNullException("patternCharacters");
		}
		if (selectors == null)
		{
			throw new ArgumentNullException("selectors");
		}
		if (patternCharacters.Length != selectors.Length)
		{
			throw new ArgumentException("Arrays must contain the same number of elements.");
		}
		List<Tuple<int, LoopingSelector>> list = new List<Tuple<int, LoopingSelector>>(patternCharacters.Length);
		for (int i = 0; i < patternCharacters.Length; i++)
		{
			list.Add(new Tuple<int, LoopingSelector>(pattern.IndexOf(patternCharacters[i]), selectors[i]));
		}
		return from p in list
			where -1 != p.Item1
			orderby p.Item1
			select p.Item2 into s
			where null != s
			select s;
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedFrom(e);
		if ("app://external/" == e.Uri.ToString())
		{
			((PhoneApplicationPage)this).State["DateTimePickerPageBase_State_Value"] = Value;
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
		if (((PhoneApplicationPage)this).State.ContainsKey("DateTimePickerPageBase_State_Value"))
		{
			Value = ((PhoneApplicationPage)this).State["DateTimePickerPageBase_State_Value"] as DateTime?;
			if (((Page)this).NavigationService.CanGoBack)
			{
				((Page)this).NavigationService.GoBack();
			}
		}
	}
}
