using System.Collections.Generic;
using System.Threading;

namespace SDatabase;

public interface ISDBTable
{
	AutoResetEvent SubmittedEvent { get; }

	IEnumerable<SDBIndex> IndexList { get; }

	IEnumerable<SDBData> DataList { get; }

	void AddIndex(SDBIndex value);

	void AddData(SDBData value);

	SDBData CreateNewEntity();

	void RemoveGarbageIndex();

	void Clear();
}
