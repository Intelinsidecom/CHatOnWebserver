using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Input;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

internal class PopupHelper
{
	private const double PopupOffset = 2.0;

	private bool _hasControlLoaded;

	public bool UsesClosingVisualState { get; private set; }

	private Control Parent { get; set; }

	private Canvas OutsidePopupCanvas { get; set; }

	private Canvas PopupChildCanvas { get; set; }

	public double MaxDropDownHeight { get; set; }

	public Popup Popup { get; private set; }

	public bool IsOpen
	{
		get
		{
			return Popup.IsOpen;
		}
		set
		{
			Popup.IsOpen = value;
		}
	}

	private FrameworkElement PopupChild { get; set; }

	public event EventHandler Closed;

	public event EventHandler FocusChanged;

	public event EventHandler UpdateVisualStates;

	public PopupHelper(Control parent)
	{
		Parent = parent;
	}

	public PopupHelper(Control parent, Popup popup)
		: this(parent)
	{
		Popup = popup;
	}

	private MatrixTransform GetControlMatrixTransform()
	{
		try
		{
			return Parent.TransformToVisual(null) as MatrixTransform;
		}
		catch
		{
			OnClosed(EventArgs.Empty);
			return null;
		}
	}

	private static Point MatrixTransformPoint(MatrixTransform matrixTransform, Thickness margin)
	{
		double x = matrixTransform.Matrix.OffsetX + margin.Left;
		double y = matrixTransform.Matrix.OffsetY + margin.Top;
		return new Point(x, y);
	}

	private Size GetControlSize(Thickness margin, Size? finalSize)
	{
		double width = (finalSize.HasValue ? finalSize.Value.Width : Parent.ActualWidth) - margin.Left - margin.Right;
		double height = (finalSize.HasValue ? finalSize.Value.Height : Parent.ActualHeight) - margin.Top - margin.Bottom;
		return new Size(width, height);
	}

	private Thickness GetMargin()
	{
		Thickness? thickness = Popup.Resources["PhoneTouchTargetOverhang"] as Thickness?;
		if (thickness.HasValue)
		{
			return thickness.Value;
		}
		return new Thickness(0.0);
	}

	private static bool IsChildAbove(Size displaySize, Size controlSize, Point controlOffset)
	{
		double y = controlOffset.Y;
		double num = displaySize.Height - controlSize.Height - y;
		return y > num;
	}

	private static double Min0(double x, double y)
	{
		return Math.Max(Math.Min(x, y), 0.0);
	}

	private Size AboveChildSize(Size controlSize, Point controlPoint)
	{
		double width = controlSize.Width;
		double x = controlPoint.Y - 2.0;
		double maxDropDownHeight = MaxDropDownHeight;
		double height = Min0(x, maxDropDownHeight);
		return new Size(width, height);
	}

	private Size BelowChildSize(Size displaySize, Size controlSize, Point controlPoint)
	{
		double width = controlSize.Width;
		double x = displaySize.Height - controlSize.Height - controlPoint.Y - 2.0;
		double maxDropDownHeight = MaxDropDownHeight;
		double height = Min0(x, maxDropDownHeight);
		return new Size(width, height);
	}

	private Point AboveChildPoint(Thickness margin)
	{
		double left = margin.Left;
		double y = margin.Top - PopupChild.ActualHeight - 2.0;
		return new Point(left, y);
	}

	private static Point BelowChildPoint(Thickness margin, Size controlSize)
	{
		double left = margin.Left;
		double y = margin.Top + controlSize.Height + 2.0;
		return new Point(left, y);
	}

	public void Arrange(Size? finalSize)
	{
		if (Popup == null || PopupChild == null || Application.Current == null || OutsidePopupCanvas == null || Application.Current.Host == null || Application.Current.Host.Content == null || !PhoneHelper.TryGetPhoneApplicationFrame(out var phoneApplicationFrame))
		{
			return;
		}
		Size usefulSize = phoneApplicationFrame.GetUsefulSize();
		Thickness margin = GetMargin();
		Size controlSize = GetControlSize(margin, finalSize);
		MatrixTransform controlMatrixTransform = GetControlMatrixTransform();
		if (controlMatrixTransform != null)
		{
			Point point = MatrixTransformPoint(controlMatrixTransform, margin);
			Size sipUncoveredSize = phoneApplicationFrame.GetSipUncoveredSize();
			bool flag = IsChildAbove(sipUncoveredSize, controlSize, point);
			Size size = (flag ? AboveChildSize(controlSize, point) : BelowChildSize(sipUncoveredSize, controlSize, point));
			if (usefulSize.Width != 0.0 && usefulSize.Height != 0.0 && size.Height != 0.0)
			{
				Point point2 = (flag ? AboveChildPoint(margin) : BelowChildPoint(margin, controlSize));
				Popup.HorizontalOffset = 0.0;
				Popup.VerticalOffset = 0.0;
				FrameworkElement popupChild = PopupChild;
				FrameworkElement popupChild2 = PopupChild;
				double num = (PopupChild.MinWidth = controlSize.Width);
				double width2 = (popupChild2.MaxWidth = num);
				popupChild.Width = width2;
				PopupChild.MinHeight = 0.0;
				PopupChild.MaxHeight = size.Height;
				PopupChild.HorizontalAlignment = HorizontalAlignment.Left;
				PopupChild.VerticalAlignment = VerticalAlignment.Top;
				Canvas.SetLeft(PopupChild, point2.X);
				Canvas.SetTop(PopupChild, point2.Y);
				OutsidePopupCanvas.Width = controlSize.Width;
				OutsidePopupCanvas.Height = usefulSize.Height;
				Matrix matrix = controlMatrixTransform.Matrix;
				matrix.Invert(out var outputMatrix);
				controlMatrixTransform.Matrix = outputMatrix;
				OutsidePopupCanvas.RenderTransform = controlMatrixTransform;
			}
		}
	}

	private void OnClosed(EventArgs e)
	{
		this.Closed?.Invoke(this, e);
	}

	private void OnPopupClosedStateChanged(object sender, VisualStateChangedEventArgs e)
	{
		if (e != null && e.NewState != null && e.NewState.Name == "PopupClosed")
		{
			if (Popup != null)
			{
				Popup.IsOpen = false;
			}
			OnClosed(EventArgs.Empty);
		}
	}

	public void BeforeOnApplyTemplate()
	{
		if (UsesClosingVisualState)
		{
			VisualStateGroup visualStateGroup = VisualStates.TryGetVisualStateGroup(Parent, "PopupStates");
			if (visualStateGroup != null)
			{
				visualStateGroup.CurrentStateChanged -= OnPopupClosedStateChanged;
				UsesClosingVisualState = false;
			}
		}
		if (Popup != null)
		{
			Popup.Closed -= Popup_Closed;
		}
	}

	public void AfterOnApplyTemplate()
	{
		if (Popup != null)
		{
			Popup.Closed += Popup_Closed;
		}
		VisualStateGroup visualStateGroup = VisualStates.TryGetVisualStateGroup(Parent, "PopupStates");
		if (visualStateGroup != null)
		{
			visualStateGroup.CurrentStateChanged += OnPopupClosedStateChanged;
			UsesClosingVisualState = true;
		}
		if (Popup != null)
		{
			PopupChild = Popup.Child as FrameworkElement;
			if (PopupChild != null && !_hasControlLoaded)
			{
				_hasControlLoaded = true;
				PopupChildCanvas = new Canvas();
				Popup.Child = PopupChildCanvas;
				OutsidePopupCanvas = new Canvas();
				OutsidePopupCanvas.Background = new SolidColorBrush(Colors.Transparent);
				OutsidePopupCanvas.MouseLeftButtonDown += OutsidePopup_MouseLeftButtonDown;
				PopupChildCanvas.Children.Add(OutsidePopupCanvas);
				PopupChildCanvas.Children.Add(PopupChild);
				PopupChild.GotFocus += PopupChild_GotFocus;
				PopupChild.LostFocus += PopupChild_LostFocus;
				PopupChild.MouseEnter += PopupChild_MouseEnter;
				PopupChild.MouseLeave += PopupChild_MouseLeave;
				PopupChild.SizeChanged += PopupChild_SizeChanged;
			}
		}
	}

	private void PopupChild_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		Arrange(null);
	}

	private void OutsidePopup_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
	{
		if (Popup != null)
		{
			Popup.IsOpen = false;
		}
	}

	private void Popup_Closed(object sender, EventArgs e)
	{
		OnClosed(EventArgs.Empty);
	}

	private void OnFocusChanged(EventArgs e)
	{
		this.FocusChanged?.Invoke(this, e);
	}

	private void OnUpdateVisualStates(EventArgs e)
	{
		this.UpdateVisualStates?.Invoke(this, e);
	}

	private void PopupChild_GotFocus(object sender, RoutedEventArgs e)
	{
		OnFocusChanged(EventArgs.Empty);
	}

	private void PopupChild_LostFocus(object sender, RoutedEventArgs e)
	{
		OnFocusChanged(EventArgs.Empty);
	}

	private void PopupChild_MouseEnter(object sender, MouseEventArgs e)
	{
		OnUpdateVisualStates(EventArgs.Empty);
	}

	private void PopupChild_MouseLeave(object sender, MouseEventArgs e)
	{
		OnUpdateVisualStates(EventArgs.Empty);
	}
}
