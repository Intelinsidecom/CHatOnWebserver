using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;
using Windows.Foundation;
using Windows.Storage;
using Windows.Storage.Streams;

namespace SDatabase;

public class SDBDataContext
{
	private string _baseFileName;

	private StorageFile _dataFile;

	private StorageFile _indexFile;

	public string DataFileName => _baseFileName;

	private string GetDataFileName()
	{
		return "data." + _baseFileName;
	}

	private string GetIndexFileName()
	{
		return "index." + _baseFileName;
	}

	public SDBDataContext()
	{
	}

	public SDBDataContext(string baseFileName)
	{
		_baseFileName = baseFileName;
	}

	public async Task CreateDatabase()
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		_dataFile = await localFolder.CreateFileAsync(GetDataFileName(), (CreationCollisionOption)1);
		_indexFile = await localFolder.CreateFileAsync(GetIndexFileName(), (CreationCollisionOption)1);
	}

	public async Task<bool> DatabaseExists()
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		try
		{
			_dataFile = await localFolder.GetFileAsync(GetDataFileName());
		}
		catch
		{
		}
		try
		{
			_indexFile = await localFolder.GetFileAsync(GetIndexFileName());
		}
		catch
		{
		}
		if (_dataFile == null || _indexFile == null)
		{
			return false;
		}
		return true;
	}

	public async Task DeleteDatabase()
	{
		await _dataFile.DeleteAsync();
		await _indexFile.DeleteAsync();
	}

	public async Task LoadDatabase()
	{
		Stopwatch watch = new Stopwatch();
		watch.Start();
		foreach (PropertyInfo property in GetType().GetTypeInfo().DeclaredProperties)
		{
			if (property.CustomAttributes.Count() == 0)
			{
				continue;
			}
			ISDBTable table = property.GetValue(this) as ISDBTable;
			_ = table.IndexList;
			IEnumerable<SDBData> listData = table.DataList;
			IRandomAccessStream dataStream = await _dataFile.OpenAsync((FileAccessMode)0);
			IRandomAccessStream indexStream = await _indexFile.OpenAsync((FileAccessMode)0);
			DataReader indexDataReader = new DataReader((IInputStream)(object)indexStream);
			try
			{
				await (IAsyncOperation<uint>)(object)indexDataReader.LoadAsync((uint)indexStream.Size);
				while (indexDataReader.UnconsumedBufferLength != 0)
				{
					SDBIndex index = new SDBIndex();
					index.Load(indexDataReader);
					if (index.Status != SDBIndex.DataStatus.Garbage)
					{
						table.AddIndex(index);
						DataReader dataReader = new DataReader(dataStream.GetInputStreamAt(index.DataPos));
						try
						{
							await (IAsyncOperation<uint>)(object)dataReader.LoadAsync((uint)index.DataSize);
							SDBData data = table.CreateNewEntity();
							data.Load(dataReader);
							data.Index = index;
							table.AddData(data);
							dataReader.DetachStream();
						}
						finally
						{
							((IDisposable)dataReader)?.Dispose();
						}
					}
				}
				indexDataReader.DetachStream();
			}
			finally
			{
				((IDisposable)indexDataReader)?.Dispose();
			}
			listData.Count();
			((IDisposable)dataStream).Dispose();
			((IDisposable)indexStream).Dispose();
			break;
		}
		watch.Stop();
	}

	public async Task SubmitChanges()
	{
		Stopwatch watch = new Stopwatch();
		watch.Start();
		int added = 0;
		int deleted = 0;
		int updated = 0;
		foreach (PropertyInfo property in GetType().GetTypeInfo().DeclaredProperties)
		{
			if (property.CustomAttributes.Count() == 0)
			{
				continue;
			}
			ISDBTable table = property.GetValue(this) as ISDBTable;
			table.SubmittedEvent.WaitOne();
			IEnumerable<SDBIndex> indexData = table.IndexList;
			IEnumerable<SDBData> listData = table.DataList;
			bool changed = false;
			foreach (SDBIndex item in indexData)
			{
				if (item.Status != SDBIndex.DataStatus.Stored)
				{
					changed = true;
					break;
				}
			}
			if (!changed)
			{
				table.SubmittedEvent.Set();
				return;
			}
			List<SDBIndex> newIndexList = new List<SDBIndex>();
			_ = ApplicationData.Current.LocalFolder;
			IRandomAccessStream indexStream = await _indexFile.OpenAsync((FileAccessMode)1);
			IRandomAccessStream outputStream = await _dataFile.OpenAsync((FileAccessMode)1);
			foreach (SDBIndex index in indexData)
			{
				if (index.Status == SDBIndex.DataStatus.New)
				{
					added++;
					outputStream.Seek(outputStream.Size);
					SDBData data = listData.First((SDBData c) => c.Id == index.Id);
					DataWriter dataWriter = new DataWriter((IOutputStream)(object)outputStream);
					try
					{
						index.DataPos = outputStream.Position;
						data.Store(dataWriter);
						index.DataSize = dataWriter.UnstoredBufferLength;
						index.Status = SDBIndex.DataStatus.Stored;
						await (IAsyncOperation<uint>)(object)dataWriter.StoreAsync();
						await dataWriter.FlushAsync();
						dataWriter.DetachStream();
					}
					finally
					{
						((IDisposable)dataWriter)?.Dispose();
					}
					index.Pos = indexStream.Size;
					indexStream.Seek(indexStream.Size);
					await StoreIndexData(indexStream, index);
				}
				else if (index.Status == SDBIndex.DataStatus.Deleted)
				{
					index.Status = SDBIndex.DataStatus.Garbage;
					deleted++;
					if (index.DataSize != 0)
					{
						indexStream.Seek(index.Pos);
						await StoreIndexData(indexStream, index);
					}
				}
				else
				{
					if (index.Status != SDBIndex.DataStatus.Updated)
					{
						continue;
					}
					updated++;
					SDBData data2 = listData.First((SDBData c) => c.Id == index.Id);
					DataWriter dataWriter2 = new DataWriter();
					try
					{
						data2.Store(dataWriter2);
						uint size = dataWriter2.UnstoredBufferLength;
						if (index.DataSize < size)
						{
							index.Status = SDBIndex.DataStatus.Garbage;
							outputStream.Seek(outputStream.Size);
							SDBIndex newIndex = new SDBIndex
							{
								DataSize = size,
								Status = SDBIndex.DataStatus.Stored,
								Id = index.Id,
								DataPos = outputStream.Position
							};
							newIndexList.Add(newIndex);
							data2.Index = newIndex;
							IBuffer buffer = dataWriter2.DetachBuffer();
							await ((IOutputStream)outputStream).WriteAsync(buffer);
							await ((IOutputStream)outputStream).FlushAsync();
						}
						else
						{
							outputStream.Seek(index.DataPos);
							IBuffer buffer2 = dataWriter2.DetachBuffer();
							await ((IOutputStream)outputStream).WriteAsync(buffer2);
							await ((IOutputStream)outputStream).FlushAsync();
							index.Status = SDBIndex.DataStatus.Stored;
						}
						indexStream.Seek(index.Pos);
						await StoreIndexData(indexStream, index);
					}
					finally
					{
						((IDisposable)dataWriter2)?.Dispose();
					}
				}
			}
			((IDisposable)outputStream).Dispose();
			indexStream.Seek(indexStream.Size);
			foreach (SDBIndex value in newIndexList)
			{
				table.AddIndex(value);
				value.Pos = indexStream.Position;
				await StoreIndexData(indexStream, value);
			}
			((IDisposable)indexStream).Dispose();
			table.SubmittedEvent.Set();
			break;
		}
		watch.Stop();
	}

	public async Task CleanGarbage()
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		_dataFile = await localFolder.CreateFileAsync(GetDataFileName(), (CreationCollisionOption)1);
		_indexFile = await localFolder.CreateFileAsync(GetIndexFileName(), (CreationCollisionOption)1);
		foreach (PropertyInfo property in GetType().GetTypeInfo().DeclaredProperties)
		{
			if (property.CustomAttributes.Count() == 0)
			{
				continue;
			}
			ISDBTable table = property.GetValue(this) as ISDBTable;
			table.RemoveGarbageIndex();
			IEnumerable<SDBIndex> indexData = table.IndexList;
			IEnumerable<SDBData> listData = table.DataList;
			IRandomAccessStream outputStream = await _dataFile.OpenAsync((FileAccessMode)1);
			IRandomAccessStream indexStream = await _indexFile.OpenAsync((FileAccessMode)1);
			foreach (SDBIndex index in indexData)
			{
				outputStream.Seek(outputStream.Size);
				Func<SDBData, bool> predicate = (SDBData c) => c.Id == index.Id;
				SDBData data = listData.First(predicate);
				DataWriter dataWriter = new DataWriter((IOutputStream)(object)outputStream);
				try
				{
					ulong pos = outputStream.Position;
					data.Store(dataWriter);
					index.Pos = indexStream.Position;
					index.DataPos = pos;
					index.DataSize = dataWriter.UnstoredBufferLength;
					index.Status = SDBIndex.DataStatus.Stored;
					await StoreIndexData(indexStream, index);
					await (IAsyncOperation<uint>)(object)dataWriter.StoreAsync();
					await dataWriter.FlushAsync();
					dataWriter.DetachStream();
				}
				finally
				{
					((IDisposable)dataWriter)?.Dispose();
				}
			}
			((IDisposable)indexStream).Dispose();
			((IDisposable)outputStream).Dispose();
			break;
		}
	}

	private static async Task StoreIndexData(IRandomAccessStream indexStream, SDBIndex index)
	{
		DataWriter dataWriter = new DataWriter((IOutputStream)(object)indexStream);
		try
		{
			index.Store(dataWriter);
			await (IAsyncOperation<uint>)(object)dataWriter.StoreAsync();
			await dataWriter.FlushAsync();
			dataWriter.DetachStream();
		}
		finally
		{
			((IDisposable)dataWriter)?.Dispose();
		}
	}
}
