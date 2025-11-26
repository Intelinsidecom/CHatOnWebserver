using System;
using System.ComponentModel;

namespace Microsoft.Phone.Controls.Maps;

public sealed class ApplicationIdCredentialsProvider : CredentialsProvider, INotifyPropertyChanged
{
	private string applicationId;

	public string ApplicationId
	{
		get
		{
			return applicationId;
		}
		set
		{
			applicationId = value;
			OnPropertyChanged("ApplicationId");
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	public ApplicationIdCredentialsProvider()
		: this(string.Empty)
	{
	}

	public ApplicationIdCredentialsProvider(string applicationId)
	{
		ApplicationId = applicationId;
	}

	public override void GetCredentials(Action<Credentials> callback)
	{
		Credentials credentials = new Credentials();
		credentials.ApplicationId = ApplicationId;
		callback(credentials);
	}

	private void OnPropertyChanged(string propertyName)
	{
		PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
		if (propertyChanged != null)
		{
			PropertyChangedEventArgs e = new PropertyChangedEventArgs(propertyName);
			propertyChanged(this, e);
		}
	}
}
