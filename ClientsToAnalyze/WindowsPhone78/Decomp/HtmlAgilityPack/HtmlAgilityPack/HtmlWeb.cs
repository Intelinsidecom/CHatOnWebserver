using System;
using System.Net;
using System.Text;
using System.Threading;

namespace HtmlAgilityPack;

public class HtmlWeb
{
	public delegate void PreHandleDocumentHandler(HtmlDocument document);

	public PreHandleDocumentHandler PreHandleDocument;

	private EventHandler<HtmlDocumentLoadCompleted> m_LoadCompleted;

	public event EventHandler<HtmlDocumentLoadCompleted> LoadCompleted
	{
		add
		{
			EventHandler<HtmlDocumentLoadCompleted> eventHandler2 = default(EventHandler<HtmlDocumentLoadCompleted>);
			while (true)
			{
				EventHandler<HtmlDocumentLoadCompleted> eventHandler = this.m_LoadCompleted;
				int num = 1;
				while (true)
				{
					switch (num)
					{
					case 1:
					{
						eventHandler2 = eventHandler;
						EventHandler<HtmlDocumentLoadCompleted> value2 = (EventHandler<HtmlDocumentLoadCompleted>)Delegate.Combine(eventHandler2, value);
						eventHandler = Interlocked.CompareExchange(ref this.m_LoadCompleted, value2, eventHandler2);
						num = 2;
						continue;
					}
					case 2:
						if ((object)eventHandler == eventHandler2)
						{
							if (true)
							{
							}
							num = 0;
							continue;
						}
						goto case 1;
					case 0:
						return;
					}
					break;
				}
			}
		}
		remove
		{
			EventHandler<HtmlDocumentLoadCompleted> eventHandler2 = default(EventHandler<HtmlDocumentLoadCompleted>);
			while (true)
			{
				EventHandler<HtmlDocumentLoadCompleted> eventHandler = this.m_LoadCompleted;
				int num = 0;
				while (true)
				{
					switch (num)
					{
					case 0:
					{
						eventHandler2 = eventHandler;
						EventHandler<HtmlDocumentLoadCompleted> value2 = (EventHandler<HtmlDocumentLoadCompleted>)Delegate.Remove(eventHandler2, value);
						eventHandler = Interlocked.CompareExchange(ref this.m_LoadCompleted, value2, eventHandler2);
						num = 2;
						continue;
					}
					case 2:
						if ((object)eventHandler == eventHandler2)
						{
							num = 1;
							continue;
						}
						goto case 0;
					case 1:
						if (1 == 0)
						{
						}
						return;
					}
					break;
				}
			}
		}
	}

	public void LoadAsync(string url)
	{
		LoadAsync(new Uri(url), null, null);
	}

	public void LoadAsync(string url, Encoding encoding)
	{
		LoadAsync(new Uri(url), encoding, null);
	}

	public void LoadAsync(string url, Encoding encoding, string userName, string password)
	{
		LoadAsync(new Uri(url), encoding, new NetworkCredential(userName, password));
	}

	public void LoadAsync(string url, Encoding encoding, string userName, string password, string domain)
	{
		LoadAsync(new Uri(url), encoding, new NetworkCredential(userName, password, domain));
	}

	public void LoadAsync(string url, string userName, string password, string domain)
	{
		LoadAsync(new Uri(url), null, new NetworkCredential(userName, password, domain));
	}

	public void LoadAsync(string url, string userName, string password)
	{
		LoadAsync(new Uri(url), null, new NetworkCredential(userName, password));
	}

	public void LoadAsync(string url, NetworkCredential credentials)
	{
		LoadAsync(new Uri(url), null, credentials);
	}

	public void LoadAsync(Uri uri, Encoding encoding, NetworkCredential credentials)
	{
		while (true)
		{
			WebClient webClient = new WebClient();
			int num = 3;
			while (true)
			{
				switch (num)
				{
				case 3:
					if (credentials == null)
					{
						if (true)
						{
						}
						num = 0;
					}
					else
					{
						webClient.Credentials = credentials;
						num = 2;
					}
					continue;
				case 2:
				case 6:
					num = 5;
					continue;
				case 5:
					if (encoding != null)
					{
						num = 1;
						continue;
					}
					goto case 4;
				case 0:
					webClient.UseDefaultCredentials = true;
					num = 6;
					continue;
				case 1:
					webClient.Encoding = encoding;
					num = 4;
					continue;
				case 4:
					webClient.DownloadStringCompleted += ClientDownloadStringCompleted;
					webClient.DownloadStringAsync(uri);
					return;
				}
				break;
			}
		}
	}

	private void OnLoadCompleted(HtmlDocumentLoadCompleted htmlDocumentLoadCompleted)
	{
		if (this.LoadCompleted != null)
		{
			this.LoadCompleted(this, htmlDocumentLoadCompleted);
		}
	}

	private void ClientDownloadStringCompleted(object sender, DownloadStringCompletedEventArgs e)
	{
		int num = 1;
		while (true)
		{
			switch (num)
			{
			default:
				if (true)
				{
				}
				if (e.Error != null)
				{
					num = 2;
					break;
				}
				goto case 0;
			case 0:
				try
				{
					while (true)
					{
						HtmlDocument htmlDocument = new HtmlDocument();
						htmlDocument.LoadHtml(e.Result);
						num = 0;
						while (true)
						{
							switch (num)
							{
							case 0:
								if (PreHandleDocument != null)
								{
									num = 1;
									continue;
								}
								goto case 3;
							case 1:
								PreHandleDocument(htmlDocument);
								num = 3;
								continue;
							case 3:
								OnLoadCompleted(new HtmlDocumentLoadCompleted(htmlDocument));
								num = 2;
								continue;
							case 2:
								return;
							}
							break;
						}
					}
				}
				catch (Exception err)
				{
					OnLoadCompleted(new HtmlDocumentLoadCompleted(err));
					return;
				}
			case 2:
				OnLoadCompleted(new HtmlDocumentLoadCompleted(e.Error));
				num = 0;
				break;
			}
		}
	}

	public static void LoadAsync(string path, EventHandler<HtmlDocumentLoadCompleted> callback)
	{
		HtmlWeb htmlWeb = new HtmlWeb();
		htmlWeb.LoadCompleted += callback;
		htmlWeb.LoadAsync(path);
	}
}
