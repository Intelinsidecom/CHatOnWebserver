using System;

namespace HtmlAgilityPack;

public class HtmlDocumentLoadCompleted : EventArgs
{
	public HtmlDocument Document;

	public Exception Error;

	public HtmlDocumentLoadCompleted(HtmlDocument doc)
	{
		Document = doc;
	}

	public HtmlDocumentLoadCompleted(Exception err)
	{
		Error = err;
	}
}
