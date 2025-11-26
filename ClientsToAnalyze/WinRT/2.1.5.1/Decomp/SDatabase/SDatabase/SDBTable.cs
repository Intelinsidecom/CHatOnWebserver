using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading;

namespace SDatabase;

public class SDBTable<TEntity> : ISDBTable
{
	private AutoResetEvent _submittedEvent = new AutoResetEvent(initialState: true);

	private static readonly object _locker = new object();

	private Semaphore _sem = new Semaphore(0, 3);

	private List<TEntity> _dataList = new List<TEntity>();

	private SDBDataContext _context;

	private List<SDBIndex> _indexList = new List<SDBIndex>();

	public AutoResetEvent SubmittedEvent => _submittedEvent;

	public IEnumerable<SDBIndex> IndexList => _indexList;

	public IEnumerable<SDBData> DataList => _dataList as IEnumerable<SDBData>;

	public SDBDataContext Context
	{
		get
		{
			return _context;
		}
		set
		{
			_context = value;
		}
	}

	public void InsertOnSubmit(TEntity entity)
	{
		SDBData sDBData = entity as SDBData;
		SDBIndex sDBIndex = new SDBIndex();
		sDBIndex.Id = (entity as SDBData).Id;
		sDBIndex.Status = SDBIndex.DataStatus.New;
		SDBIndex item = (sDBData.Index = sDBIndex);
		_submittedEvent.WaitOne();
		_indexList.Add(item);
		_dataList.Add(entity);
		_submittedEvent.Set();
	}

	public void DeleteOnSubmit(TEntity entity)
	{
		if (entity is SDBData { Index: not null } sDBData)
		{
			sDBData.Index.Status = SDBIndex.DataStatus.Deleted;
		}
		_submittedEvent.WaitOne(100);
		_dataList.Remove(entity);
		_submittedEvent.Set();
	}

	public void AddIndex(SDBIndex value)
	{
		_indexList.Add(value);
	}

	public void AddData(SDBData value)
	{
		TEntity item = (TEntity)(object)value;
		_dataList.Add(item);
	}

	public SDBData CreateNewEntity()
	{
		TEntity val = (TEntity)Activator.CreateInstance(typeof(TEntity));
		return val as SDBData;
	}

	public void RemoveGarbageIndex()
	{
		for (int num = _indexList.Count() - 1; num >= 0; num--)
		{
			if (_indexList[num].Status == SDBIndex.DataStatus.Garbage)
			{
				_indexList.RemoveAt(num);
			}
		}
	}

	public void Clear()
	{
		_indexList.Clear();
		_dataList.Clear();
	}
}
