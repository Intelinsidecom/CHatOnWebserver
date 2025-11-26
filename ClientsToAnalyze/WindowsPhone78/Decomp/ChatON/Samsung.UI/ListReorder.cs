using System;
using System.Collections;
using System.Collections.Generic;
using System.Threading;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using ChatOn;

namespace Samsung.UI;

public sealed class ListReorder : IDisposable
{
	public delegate void ChangeItemOrderEventHandler(object sender, ChangeItemOrderEventArgs e);

	private const int SCROLL_INTERVAL = 200;

	private FrameworkElement _rootVisual;

	private ListBox _listbox;

	private IList _list;

	private ListBoxItem _dragItem;

	private Image _capturedDragItem;

	private Line _guideLine;

	private int _sourceIndex = -1;

	private int _targetIndex = -1;

	private Thread _thread;

	private bool _isAlive;

	private ReorderType _type;

	private bool _useExternalScroll;

	private double _oldOpacity;

	private int _animationCount;

	private List<int> _tempReorder;

	private bool _isManipulationCompleted;

	private Popup _popup;

	private Panel _overlay;

	private ScrollViewer _scrollviewer;

	private ScrollViewer ScrollViewer
	{
		get
		{
			if (_scrollviewer == null)
			{
				try
				{
					_scrollviewer = Utility.GetScrollViewer(_listbox);
				}
				catch
				{
				}
			}
			return _scrollviewer;
		}
	}

	public event ChangeItemOrderEventHandler ChangeItemOrderCompleted;

	public ListReorder(ListBox listbox, IList list, ScrollViewer scroll, ReorderType type)
	{
		if (listbox == null)
		{
			throw new ArgumentNullException("listbox");
		}
		if (list == null)
		{
			throw new ArgumentNullException("list");
		}
		_listbox = listbox;
		_list = list;
		_type = type;
		if (scroll != null)
		{
			_scrollviewer = scroll;
			_useExternalScroll = true;
		}
		else
		{
			_useExternalScroll = false;
		}
		_tempReorder = new List<int>(_list.Count);
	}

	public void ChangeItemOrder(Point position)
	{
		Reset();
		InitializeRootVisual();
		int count = _listbox.Items.Count;
		for (int i = 0; i < count; i++)
		{
			DependencyObject dependencyObject = _listbox.ItemContainerGenerator.ContainerFromIndex(i);
			if (dependencyObject != null)
			{
				ListBoxItem listBoxItem = (ListBoxItem)dependencyObject;
				Point point = listBoxItem.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
				if (new Rect(point.X, point.Y, listBoxItem.ActualWidth, listBoxItem.ActualHeight).Contains(position))
				{
					_sourceIndex = i;
					_dragItem = listBoxItem;
					position = point;
					break;
				}
			}
		}
		if (_sourceIndex != -1)
		{
			_overlay = new Canvas
			{
				Background = new SolidColorBrush(Colors.Transparent)
			};
			if (_type != ReorderType.DirectChange)
			{
				Rectangle rectangle = new Rectangle();
				rectangle.Width = _rootVisual.ActualWidth;
				rectangle.Height = _rootVisual.ActualHeight;
				rectangle.Fill = (Brush)Application.Current.Resources["PhoneBackgroundBrush"];
				rectangle.Opacity = 0.4;
				UIElement value = rectangle;
				_overlay.Children.Add(value);
			}
			_capturedDragItem = new Image();
			_capturedDragItem.CacheMode = new BitmapCache();
			_capturedDragItem.Source = new WriteableBitmap(_dragItem, null);
			_capturedDragItem.RenderTransform = new CompositeTransform();
			if (_type == ReorderType.DirectChange)
			{
				_capturedDragItem.Width = _dragItem.ActualWidth;
				_capturedDragItem.Height = _dragItem.ActualHeight;
				_capturedDragItem.RenderTransformOrigin = new Point(0.5, 0.5);
				(_capturedDragItem.RenderTransform as CompositeTransform).ScaleX = 1.1;
				(_capturedDragItem.RenderTransform as CompositeTransform).ScaleY = 1.1;
			}
			Canvas.SetLeft(_capturedDragItem, position.X);
			Canvas.SetTop(_capturedDragItem, position.Y);
			_overlay.Children.Add(_capturedDragItem);
			if (_type == ReorderType.DirectChange)
			{
				_oldOpacity = _dragItem.Opacity;
				_dragItem.Opacity = 0.0;
			}
			_guideLine = new Line();
			_guideLine.Stroke = (Brush)Application.Current.Resources["PhoneAccentBrush"];
			_guideLine.StrokeThickness = 3.0;
			_guideLine.Opacity = 0.0;
			_overlay.Children.Add(_guideLine);
			_popup = new Popup
			{
				Child = _overlay
			};
			_popup.IsOpen = true;
			ScrollViewer.IsHitTestVisible = false;
			_isAlive = true;
			_thread = new Thread(Work);
			_thread.Start();
		}
	}

	private void Reset()
	{
		_isAlive = false;
		_sourceIndex = -1;
		_targetIndex = -1;
		if (_popup != null)
		{
			_popup.IsOpen = false;
			_popup.Child = null;
			_popup = null;
		}
		if (_overlay != null)
		{
			_overlay.Children.Clear();
			_overlay = null;
		}
		if (_capturedDragItem != null)
		{
			_capturedDragItem = null;
		}
		if (_dragItem != null)
		{
			if (_type == ReorderType.DirectChange)
			{
				_dragItem.Opacity = _oldOpacity;
			}
			_dragItem = null;
		}
		if (_guideLine != null)
		{
			_guideLine = null;
		}
		ScrollViewer.IsHitTestVisible = true;
		if (_thread != null)
		{
			_thread = null;
		}
		_tempReorder.Clear();
		for (int i = 0; i < _list.Count; i++)
		{
			_tempReorder.Add(i);
		}
		_isManipulationCompleted = false;
	}

	private void InitializeRootVisual()
	{
		if (_rootVisual == null)
		{
			_rootVisual = Application.Current.RootVisual as FrameworkElement;
			if (_rootVisual != null)
			{
				_rootVisual.ManipulationDelta += _rootVisual_ManipulationDelta;
				_rootVisual.ManipulationCompleted += _rootVisual_ManipulationCompleted;
			}
		}
	}

	private void DeinitializeRootVisual()
	{
		if (_rootVisual != null)
		{
			_rootVisual.ManipulationDelta -= _rootVisual_ManipulationDelta;
			_rootVisual.ManipulationCompleted -= _rootVisual_ManipulationCompleted;
			_rootVisual = null;
		}
	}

	private void OnManipulationDelta(bool last)
	{
		Rect rect;
		if (_useExternalScroll)
		{
			Point point = ScrollViewer.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
			rect = new Rect(point.X, point.Y, ScrollViewer.ActualWidth, ScrollViewer.ActualHeight);
		}
		else
		{
			Point point = _listbox.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
			rect = new Rect(point.X, point.Y, _listbox.ActualWidth, _listbox.ActualHeight);
		}
		Point point2 = _capturedDragItem.TransformToVisual(_rootVisual).Transform(new Point(_capturedDragItem.ActualWidth / 2.0, _capturedDragItem.ActualHeight / 2.0));
		int count = _listbox.Items.Count;
		for (int i = 0; i < count; i++)
		{
			DependencyObject dependencyObject = _listbox.ItemContainerGenerator.ContainerFromIndex(i);
			if (dependencyObject == null)
			{
				continue;
			}
			ListBoxItem listBoxItem = (ListBoxItem)dependencyObject;
			Point point3 = listBoxItem.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
			Rect rect2 = ((_type != ReorderType.DirectChange) ? new Rect(point3.X, point3.Y, listBoxItem.ActualWidth, listBoxItem.ActualHeight) : new Rect(point3.X + 10.0, point3.Y + 10.0, listBoxItem.ActualWidth - 20.0, listBoxItem.ActualHeight - 20.0));
			if (!rect2.Contains(point2))
			{
				continue;
			}
			if (_type == ReorderType.GuidelineVerticalAlignment)
			{
				if (point2.Y > rect2.Top + rect2.Height / 2.0)
				{
					_targetIndex = i + 1;
					Line guideLine = _guideLine;
					double y = (_guideLine.Y2 = rect2.Bottom);
					guideLine.Y1 = y;
				}
				else
				{
					_targetIndex = i;
					Line guideLine2 = _guideLine;
					double y2 = (_guideLine.Y2 = rect2.Top);
					guideLine2.Y1 = y2;
				}
				if (_targetIndex > _sourceIndex)
				{
					_targetIndex--;
				}
				_guideLine.X1 = Math.Max(rect2.Left, rect.Left);
				_guideLine.X2 = Math.Min(rect2.Right, rect.Right);
				if (rect.Contains(new Point((_guideLine.X1 + _guideLine.X2) / 2.0, _guideLine.Y1)))
				{
					_guideLine.Opacity = 1.0;
					break;
				}
				_guideLine.Opacity = 0.0;
				_targetIndex = -1;
			}
			else if (_type == ReorderType.GuidelineHorizontalAlignment)
			{
				if (point2.X > rect2.Left + rect2.Width / 2.0)
				{
					_targetIndex = i + 1;
					Line guideLine3 = _guideLine;
					double x = (_guideLine.X2 = rect2.Right);
					guideLine3.X1 = x;
				}
				else
				{
					_targetIndex = i;
					Line guideLine4 = _guideLine;
					double x2 = (_guideLine.X2 = rect2.Left);
					guideLine4.X1 = x2;
				}
				if (_targetIndex > _sourceIndex)
				{
					_targetIndex--;
				}
				_guideLine.Y1 = Math.Max(rect2.Top, rect.Top);
				_guideLine.Y2 = Math.Min(rect2.Bottom, rect.Bottom);
				if (rect.Contains(new Point(_guideLine.X1, (_guideLine.Y1 + _guideLine.Y2) / 2.0)))
				{
					_guideLine.Opacity = 1.0;
					break;
				}
				_guideLine.Opacity = 0.0;
				_targetIndex = -1;
			}
			else if (last)
			{
				_targetIndex = _tempReorder.IndexOf(i);
			}
			else if (_animationCount == 0 && listBoxItem.Opacity != 0.0)
			{
				_targetIndex = i;
				AnimateItems(_sourceIndex, _targetIndex);
			}
			break;
		}
	}

	private void _rootVisual_ManipulationDelta(object sender, ManipulationDeltaEventArgs e)
	{
		if (_capturedDragItem != null)
		{
			if (_type != ReorderType.GuidelineVerticalAlignment)
			{
				(_capturedDragItem.RenderTransform as CompositeTransform).TranslateX += e.DeltaManipulation.Translation.X;
			}
			(_capturedDragItem.RenderTransform as CompositeTransform).TranslateY += e.DeltaManipulation.Translation.Y;
			OnManipulationDelta(last: false);
			e.Handled = true;
		}
	}

	private void _rootVisual_ManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		if (_animationCount > 0)
		{
			_isManipulationCompleted = true;
			return;
		}
		if (_type == ReorderType.DirectChange)
		{
			OnManipulationDelta(last: true);
		}
		ReorderList(_sourceIndex, _targetIndex);
		if (_type == ReorderType.DirectChange)
		{
			ResetTranslate();
		}
		if (this.ChangeItemOrderCompleted != null)
		{
			this.ChangeItemOrderCompleted(sender, new ChangeItemOrderEventArgs(_sourceIndex, (_targetIndex == -1) ? _sourceIndex : _targetIndex));
		}
		Dispose();
	}

	private void ReorderList(int sourceIndex, int targetIndex)
	{
		if (targetIndex != -1 && sourceIndex != -1 && targetIndex != sourceIndex)
		{
			object value = _list[sourceIndex];
			_list.Remove(value);
			if (targetIndex >= _list.Count)
			{
				_list.Add(value);
			}
			else
			{
				_list.Insert(targetIndex, value);
			}
		}
	}

	private void ReorderTempList(int sourceIndex, int targetIndex)
	{
		if (targetIndex != -1 && sourceIndex != -1 && targetIndex != sourceIndex)
		{
			int item = _tempReorder[sourceIndex];
			_tempReorder.Remove(item);
			if (targetIndex >= _tempReorder.Count)
			{
				_tempReorder.Add(item);
			}
			else
			{
				_tempReorder.Insert(targetIndex, item);
			}
		}
	}

	private void Work()
	{
		while (_isAlive)
		{
			Thread.Sleep(200);
			_listbox.Dispatcher.BeginInvoke(delegate
			{
				if (_listbox != null && _capturedDragItem != null)
				{
					Point point = _capturedDragItem.TransformToVisual(_rootVisual).Transform(new Point(_capturedDragItem.ActualWidth / 2.0, _capturedDragItem.ActualHeight / 2.0));
					Rect rect;
					if (_useExternalScroll)
					{
						Point point2 = ScrollViewer.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
						rect = new Rect(point2.X, point2.Y, ScrollViewer.ActualWidth, ScrollViewer.ActualHeight);
					}
					else
					{
						Point point2 = _listbox.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
						rect = new Rect(point2.X, point2.Y, _listbox.ActualWidth, _listbox.ActualHeight);
					}
					double num = ((ScrollViewer.ExtentHeight == (double)_list.Count) ? 0.25 : (_capturedDragItem.ActualHeight / 4.0));
					double num2 = ((ScrollViewer.ExtentWidth == (double)_list.Count) ? 0.25 : (_capturedDragItem.ActualWidth / 4.0));
					if (point.Y < rect.Top + _capturedDragItem.ActualHeight / 2.0)
					{
						ScrollViewer.ScrollToVerticalOffset(ScrollViewer.VerticalOffset - num);
					}
					else if (point.Y > rect.Bottom - _capturedDragItem.ActualHeight / 2.0)
					{
						ScrollViewer.ScrollToVerticalOffset(ScrollViewer.VerticalOffset + num);
					}
					else if (point.X < rect.Left + _capturedDragItem.ActualWidth / 2.0)
					{
						ScrollViewer.ScrollToHorizontalOffset(ScrollViewer.HorizontalOffset - num2);
					}
					else if (point.X > rect.Right - _capturedDragItem.ActualWidth / 2.0)
					{
						ScrollViewer.ScrollToHorizontalOffset(ScrollViewer.HorizontalOffset + num2);
					}
				}
			});
		}
	}

	private void AnimateItems(int sourceIndex, int targetIndex)
	{
		if (sourceIndex == targetIndex || sourceIndex == -1 || targetIndex == -1 || _animationCount > 0)
		{
			return;
		}
		sourceIndex = _tempReorder.IndexOf(sourceIndex);
		targetIndex = _tempReorder.IndexOf(targetIndex);
		int num;
		int num2;
		bool flag;
		if (sourceIndex > targetIndex)
		{
			num = targetIndex;
			num2 = sourceIndex;
			flag = true;
		}
		else
		{
			num = sourceIndex;
			num2 = targetIndex;
			flag = false;
		}
		for (int i = num; i <= num2; i++)
		{
			int index = _tempReorder[i];
			if (_listbox.ItemContainerGenerator.ContainerFromIndex(index) is UIElement uIElement)
			{
				int index2 = ((i != sourceIndex) ? (flag ? _tempReorder[i + 1] : _tempReorder[i - 1]) : _tempReorder[targetIndex]);
				if (_listbox.ItemContainerGenerator.ContainerFromIndex(index2) is UIElement uIElement2)
				{
					Point point = uIElement.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
					Point point2 = uIElement2.TransformToVisual(_rootVisual).Transform(new Point(0.0, 0.0));
					AnimateChangePosition(uIElement, point2.X - point.X, point2.Y - point.Y, sourceIndex, targetIndex);
				}
			}
		}
	}

	private void ResetTranslate()
	{
		for (int i = 0; i <= _list.Count; i++)
		{
			if (_listbox.ItemContainerGenerator.ContainerFromIndex(i) is UIElement uIElement)
			{
				Utility.GetCompositeTransform(uIElement);
				(uIElement.RenderTransform as CompositeTransform).TranslateX = 0.0;
				(uIElement.RenderTransform as CompositeTransform).TranslateY = 0.0;
			}
		}
	}

	private void AnimateChangePosition(UIElement ele, double dx, double dy, int sourceIndex, int targetIndex)
	{
		_animationCount++;
		CompositeTransform compositeTransform = Utility.GetCompositeTransform(ele);
		DoubleAnimation doubleAnimation = new DoubleAnimation();
		doubleAnimation.From = compositeTransform.TranslateX;
		doubleAnimation.To = doubleAnimation.From + dx;
		doubleAnimation.Duration = new Duration(TimeSpan.FromMilliseconds(300.0));
		Storyboard.SetTarget(doubleAnimation, compositeTransform);
		Storyboard.SetTargetProperty(doubleAnimation, new PropertyPath(CompositeTransform.TranslateXProperty));
		DoubleAnimation doubleAnimation2 = new DoubleAnimation();
		doubleAnimation2.From = compositeTransform.TranslateY;
		doubleAnimation2.To = doubleAnimation2.From + dy;
		doubleAnimation2.Duration = new Duration(TimeSpan.FromMilliseconds(300.0));
		Storyboard.SetTarget(doubleAnimation2, compositeTransform);
		Storyboard.SetTargetProperty(doubleAnimation2, new PropertyPath(CompositeTransform.TranslateYProperty));
		Storyboard storyboard = new Storyboard();
		storyboard.Completed += delegate
		{
			if (_animationCount == 1)
			{
				ReorderTempList(sourceIndex, targetIndex);
			}
			_animationCount--;
			if (_animationCount == 0 && _isManipulationCompleted)
			{
				_rootVisual_ManipulationCompleted(null, null);
			}
		};
		storyboard.Children.Add(doubleAnimation);
		storyboard.Children.Add(doubleAnimation2);
		storyboard.Begin();
	}

	public void Dispose()
	{
		Reset();
		DeinitializeRootVisual();
	}
}
