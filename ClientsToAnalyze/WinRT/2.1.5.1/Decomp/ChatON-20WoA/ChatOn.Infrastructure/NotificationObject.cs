using System;
using System.ComponentModel;
using System.Linq.Expressions;
using System.Reflection;

namespace ChatOn.Infrastructure;

public class NotificationObject : INotifyPropertyChanged
{
	public event PropertyChangedEventHandler PropertyChanged;

	internal void NotifyPropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}

	protected void NotifyPropertyChanged<T>(Expression<Func<T>> propertyExpression)
	{
		try
		{
			string propertyName = ExtractPropertyName(propertyExpression);
			NotifyPropertyChanged(propertyName);
		}
		catch (Exception)
		{
		}
	}

	public static string ExtractPropertyName<T>(Expression<Func<T>> propertyExpression)
	{
		if (propertyExpression == null)
		{
			throw new ArgumentNullException("propertyExpression");
		}
		if (!(propertyExpression.Body is MemberExpression memberExpression))
		{
			throw new ArgumentException("propertyExpression");
		}
		if (!(memberExpression.Member is PropertyInfo { GetMethod: var getMethod }))
		{
			throw new ArgumentException("propertyExpression");
		}
		if (getMethod.IsStatic)
		{
			throw new ArgumentException("propertyExpression");
		}
		return memberExpression.Member.Name;
	}
}
