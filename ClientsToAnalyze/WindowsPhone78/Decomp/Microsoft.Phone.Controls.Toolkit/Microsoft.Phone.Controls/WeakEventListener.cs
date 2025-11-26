using System;

namespace Microsoft.Phone.Controls;

internal class WeakEventListener<TInstance, TSource, TEventArgs> where TInstance : class
{
	private WeakReference _weakInstance;

	public Action<TInstance, TSource, TEventArgs> OnEventAction { get; set; }

	public Action<WeakEventListener<TInstance, TSource, TEventArgs>> OnDetachAction { get; set; }

	public WeakEventListener(TInstance instance)
	{
		if (instance == null)
		{
			throw new ArgumentNullException("instance");
		}
		_weakInstance = new WeakReference(instance);
	}

	public void OnEvent(TSource source, TEventArgs eventArgs)
	{
		TInstance val = (TInstance)_weakInstance.Target;
		if (val != null)
		{
			if (OnEventAction != null)
			{
				OnEventAction(val, source, eventArgs);
			}
		}
		else
		{
			Detach();
		}
	}

	public void Detach()
	{
		if (OnDetachAction != null)
		{
			OnDetachAction(this);
			OnDetachAction = null;
		}
	}
}
