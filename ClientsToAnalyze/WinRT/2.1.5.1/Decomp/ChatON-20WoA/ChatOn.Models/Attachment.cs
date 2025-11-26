using System;

namespace ChatOn.Models;

public class Attachment
{
	public enum MediaType
	{
		PHOTO,
		AMS,
		CONTACT,
		CALENDAR,
		LOCATION,
		VIDEO,
		ANICON
	}

	private Guid _id;

	private MediaType _mediaType;

	private string _contentType;

	private string _filePath;

	private string _fileName;

	private string _dirPath;

	private string _title;

	public Guid ID
	{
		get
		{
			return _id;
		}
		set
		{
			_id = value;
		}
	}

	public MediaType AttachedMediaType
	{
		get
		{
			return _mediaType;
		}
		set
		{
			_mediaType = value;
		}
	}

	public string ContentType
	{
		get
		{
			return _contentType;
		}
		set
		{
			_contentType = value;
		}
	}

	public string FilePath
	{
		get
		{
			return _filePath;
		}
		set
		{
			_filePath = value;
		}
	}

	public string FileName
	{
		get
		{
			return _fileName;
		}
		set
		{
			_fileName = value;
		}
	}

	public string DirPath
	{
		get
		{
			return _dirPath;
		}
		set
		{
			_dirPath = value;
		}
	}

	public string Title
	{
		get
		{
			return _title;
		}
		set
		{
			_title = value;
		}
	}

	public Attachment()
	{
		_id = Guid.NewGuid();
	}
}
