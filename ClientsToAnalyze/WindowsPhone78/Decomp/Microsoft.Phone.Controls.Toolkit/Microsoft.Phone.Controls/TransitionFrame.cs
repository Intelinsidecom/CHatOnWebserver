using System;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Navigation;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "FirstContentPresenter", Type = typeof(ContentPresenter))]
[TemplatePart(Name = "SecondContentPresenter", Type = typeof(ContentPresenter))]
public class TransitionFrame : PhoneApplicationFrame
{
	private const string FirstTemplatePartName = "FirstContentPresenter";

	private const string SecondTemplatePartName = "SecondContentPresenter";

	internal static readonly CacheMode BitmapCacheMode = new BitmapCache();

	private ContentPresenter _firstContentPresenter;

	private ContentPresenter _secondContentPresenter;

	private ContentPresenter _newContentPresenter;

	private ContentPresenter _oldContentPresenter;

	private bool _isForwardNavigation;

	private bool _useFirstAsNew;

	private bool _readyToTransitionToNewContent;

	private bool _contentReady;

	private bool _performingExitTransition;

	private ITransition _storedNewTransition;

	private NavigationInTransition _storedNavigationInTransition;

	private ITransition _storedOldTransition;

	private NavigationOutTransition _storedNavigationOutTransition;

	public TransitionFrame()
	{
		((Control)this).DefaultStyleKey = typeof(TransitionFrame);
		((Frame)this).Navigating += OnNavigating;
		((PhoneApplicationFrame)this).BackKeyPress += OnBackKeyPress;
	}

	private void FlipPresenters()
	{
		_newContentPresenter = (_useFirstAsNew ? _firstContentPresenter : _secondContentPresenter);
		_oldContentPresenter = (_useFirstAsNew ? _secondContentPresenter : _firstContentPresenter);
		_useFirstAsNew = !_useFirstAsNew;
	}

	private void OnNavigating(object sender, NavigatingCancelEventArgs e)
	{
		_isForwardNavigation = e.NavigationMode != NavigationMode.Back;
		if (((ContentControl)this).Content is UIElement element)
		{
			FlipPresenters();
			TransitionElement transitionElement = null;
			NavigationOutTransition navigationOutTransition = null;
			ITransition transition = null;
			navigationOutTransition = TransitionService.GetNavigationOutTransition(element);
			if (navigationOutTransition != null)
			{
				transitionElement = (_isForwardNavigation ? navigationOutTransition.Forward : navigationOutTransition.Backward);
			}
			if (transitionElement != null)
			{
				transition = transitionElement.GetTransition(element);
			}
			if (transition != null)
			{
				EnsureStoppedTransition(transition);
				_storedNavigationOutTransition = navigationOutTransition;
				_storedOldTransition = transition;
				transition.Completed += OnExitTransitionCompleted;
				_performingExitTransition = true;
				PerformTransition(navigationOutTransition, _oldContentPresenter, transition);
				PrepareContentPresenterForCompositor(_oldContentPresenter);
			}
			else
			{
				_readyToTransitionToNewContent = true;
			}
		}
	}

	private void OnExitTransitionCompleted(object sender, EventArgs e)
	{
		_readyToTransitionToNewContent = true;
		_performingExitTransition = false;
		CompleteTransition(_storedNavigationOutTransition, null, _storedOldTransition);
		_storedNavigationOutTransition = null;
		_storedOldTransition = null;
		if (_contentReady)
		{
			ITransition storedNewTransition = _storedNewTransition;
			NavigationInTransition storedNavigationInTransition = _storedNavigationInTransition;
			_storedNewTransition = null;
			_storedNavigationInTransition = null;
			TransitionNewContent(storedNewTransition, storedNavigationInTransition);
		}
	}

	public override void OnApplyTemplate()
	{
		((PhoneApplicationFrame)this).OnApplyTemplate();
		_firstContentPresenter = ((Control)this).GetTemplateChild("FirstContentPresenter") as ContentPresenter;
		_secondContentPresenter = ((Control)this).GetTemplateChild("SecondContentPresenter") as ContentPresenter;
		_newContentPresenter = _secondContentPresenter;
		_oldContentPresenter = _firstContentPresenter;
		_useFirstAsNew = true;
		_readyToTransitionToNewContent = true;
		if (((ContentControl)this).Content != null)
		{
			((ContentControl)(object)this).OnContentChanged((object)null, ((ContentControl)this).Content);
		}
	}

	protected override void OnContentChanged(object oldContent, object newContent)
	{
		((ContentControl)this).OnContentChanged(oldContent, newContent);
		_contentReady = true;
		UIElement content = oldContent as UIElement;
		UIElement uIElement = newContent as UIElement;
		if (_firstContentPresenter == null || _secondContentPresenter == null || uIElement == null)
		{
			return;
		}
		NavigationInTransition navigationInTransition = null;
		ITransition transition = null;
		if (uIElement != null)
		{
			navigationInTransition = TransitionService.GetNavigationInTransition(uIElement);
			TransitionElement transitionElement = null;
			if (navigationInTransition != null)
			{
				transitionElement = (_isForwardNavigation ? navigationInTransition.Forward : navigationInTransition.Backward);
			}
			if (transitionElement != null)
			{
				uIElement.UpdateLayout();
				transition = transitionElement.GetTransition(uIElement);
				PrepareContentPresenterForCompositor(_newContentPresenter);
			}
		}
		_newContentPresenter.Opacity = 0.0;
		_newContentPresenter.Visibility = Visibility.Visible;
		_newContentPresenter.Content = uIElement;
		_oldContentPresenter.Opacity = 1.0;
		_oldContentPresenter.Visibility = Visibility.Visible;
		_oldContentPresenter.Content = content;
		if (_readyToTransitionToNewContent)
		{
			TransitionNewContent(transition, navigationInTransition);
			return;
		}
		_storedNewTransition = transition;
		_storedNavigationInTransition = navigationInTransition;
	}

	private void OnBackKeyPress(object sender, CancelEventArgs e)
	{
		if (_performingExitTransition && ((ContentControl)this).Content is UIElement element)
		{
			TransitionElement transitionElement = null;
			NavigationOutTransition navigationOutTransition = null;
			ITransition transition = null;
			navigationOutTransition = TransitionService.GetNavigationOutTransition(element);
			if (navigationOutTransition != null)
			{
				transitionElement = (_isForwardNavigation ? navigationOutTransition.Forward : navigationOutTransition.Backward);
			}
			if (transitionElement != null)
			{
				transition = transitionElement.GetTransition(element);
			}
			if (transition != null)
			{
				CompleteTransition(_storedNavigationOutTransition, null, _storedOldTransition);
				TransitionNewContent(transition, null);
			}
		}
	}

	private void TransitionNewContent(ITransition newTransition, NavigationInTransition navigationInTransition)
	{
		if (_oldContentPresenter != null)
		{
			_oldContentPresenter.Visibility = Visibility.Collapsed;
			_oldContentPresenter.Content = null;
		}
		if (newTransition == null)
		{
			RestoreContentPresenterInteractivity(_newContentPresenter);
			return;
		}
		EnsureStoppedTransition(newTransition);
		newTransition.Completed += delegate
		{
			CompleteTransition(navigationInTransition, _newContentPresenter, newTransition);
		};
		_readyToTransitionToNewContent = false;
		_storedNavigationInTransition = null;
		_storedNewTransition = null;
		PerformTransition(navigationInTransition, _newContentPresenter, newTransition);
	}

	private static void EnsureStoppedTransition(ITransition transition)
	{
		if (transition != null && transition.GetCurrentState() != ClockState.Stopped)
		{
			transition.Stop();
		}
	}

	private static void PerformTransition(NavigationTransition navigationTransition, ContentPresenter presenter, ITransition transition)
	{
		navigationTransition?.OnBeginTransition();
		if (presenter != null && presenter.Opacity != 1.0)
		{
			presenter.Opacity = 1.0;
		}
		transition?.Begin();
	}

	private static void CompleteTransition(NavigationTransition navigationTransition, ContentPresenter presenter, ITransition transition)
	{
		transition?.Stop();
		RestoreContentPresenterInteractivity(presenter);
		navigationTransition?.OnEndTransition();
	}

	private static void PrepareContentPresenterForCompositor(ContentPresenter presenter, bool applyBitmapCache = true)
	{
		if (presenter != null)
		{
			if (applyBitmapCache)
			{
				presenter.CacheMode = BitmapCacheMode;
			}
			presenter.IsHitTestVisible = false;
		}
	}

	private static void RestoreContentPresenterInteractivity(ContentPresenter presenter)
	{
		if (presenter != null)
		{
			presenter.CacheMode = null;
			if (presenter.Opacity != 1.0)
			{
				presenter.Opacity = 1.0;
			}
			presenter.IsHitTestVisible = true;
		}
	}
}
