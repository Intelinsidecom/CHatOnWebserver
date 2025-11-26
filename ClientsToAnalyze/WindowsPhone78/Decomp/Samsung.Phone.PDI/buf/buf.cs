using System.Text;

namespace buf;

public class buf
{
	public class slist_t
	{
		public StringBuilder data;

		public uint nTagNo;

		public StringBuilder pTag;

		public StringBuilder pValue;

		public slist_t()
		{
			data = new StringBuilder(256);
			nTagNo = 0u;
			pTag = new StringBuilder(64);
			pValue = new StringBuilder(64);
		}
	}
}
