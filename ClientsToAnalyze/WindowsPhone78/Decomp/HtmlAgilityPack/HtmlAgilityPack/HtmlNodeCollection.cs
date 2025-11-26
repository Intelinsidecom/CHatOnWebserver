using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Threading;

namespace HtmlAgilityPack;

public class HtmlNodeCollection : IList<HtmlNode>, ICollection<HtmlNode>, IEnumerable<HtmlNode>, IEnumerable
{
	[CompilerGenerated]
	private sealed class _003CDescendants_003Ed__0 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNodeCollection _003C_003E4__this;

		public HtmlNode _003Citem_003E5__1;

		public HtmlNode _003Cn_003E5__2;

		public List<HtmlNode>.Enumerator _003C_003E7__wrap3;

		public IEnumerator<HtmlNode> _003C_003E7__wrap5;

		HtmlNode IEnumerator<HtmlNode>.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		object IEnumerator.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		[DebuggerHidden]
		IEnumerator<HtmlNode> IEnumerable<HtmlNode>.GetEnumerator()
		{
			int num = 3;
			_003CDescendants_003Ed__0 result = default(_003CDescendants_003Ed__0);
			while (true)
			{
				switch (num)
				{
				default:
					if (Thread.CurrentThread.ManagedThreadId == _003C_003El__initialThreadId)
					{
						if (true)
						{
						}
						num = 1;
						break;
					}
					goto IL_004c;
				case 2:
					_003C_003E1__state = 0;
					result = this;
					num = 4;
					break;
				case 1:
					num = 0;
					break;
				case 0:
					if (_003C_003E1__state == -2)
					{
						num = 2;
						break;
					}
					goto IL_004c;
				case 4:
				case 5:
					{
						return result;
					}
					IL_004c:
					result = new _003CDescendants_003Ed__0(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 5;
					break;
				}
			}
		}

		[DebuggerHidden]
		IEnumerator IEnumerable.GetEnumerator()
		{
			return ((IEnumerable<HtmlNode>)this).GetEnumerator();
		}

		private bool MoveNext()
		{
			bool result = default(bool);
			try
			{
				while (true)
				{
					IL_0048:
					int num = _003C_003E1__state;
					int num2 = 12;
					while (true)
					{
						switch (num2)
						{
						case 12:
							if (num != 0)
							{
								num2 = 13;
								continue;
							}
							_003C_003E1__state = -1;
							_003C_003E7__wrap3 = _003C_003E4__this._items.GetEnumerator();
							_003C_003E1__state = 1;
							if (true)
							{
							}
							num2 = 4;
							continue;
						case 3:
							_003C_003Em__Finally6();
							num2 = 10;
							continue;
						case 5:
							num2 = 0;
							continue;
						case 4:
						case 10:
							num2 = 9;
							continue;
						case 9:
							if (!_003C_003E7__wrap3.MoveNext())
							{
								num2 = 11;
								continue;
							}
							_003Citem_003E5__1 = _003C_003E7__wrap3.Current;
							_003C_003E7__wrap5 = _003Citem_003E5__1.Descendants().GetEnumerator();
							_003C_003E1__state = 2;
							num2 = 2;
							continue;
						case 13:
							num2 = 15;
							continue;
						case 15:
							if (num == 3)
							{
								_003C_003E1__state = 2;
								num2 = 6;
							}
							else
							{
								num2 = 5;
							}
							continue;
						case 2:
						case 6:
							num2 = 8;
							continue;
						case 8:
							if (!_003C_003E7__wrap5.MoveNext())
							{
								num2 = 3;
								continue;
							}
							_003Cn_003E5__2 = _003C_003E7__wrap5.Current;
							_003C_003E2__current = _003Cn_003E5__2;
							_003C_003E1__state = 3;
							result = true;
							num2 = 7;
							continue;
						case 11:
							_003C_003Em__Finally4();
							num2 = 1;
							continue;
						case 7:
							goto end_IL_0002;
						case 0:
						case 1:
							result = false;
							num2 = 14;
							continue;
						case 14:
							goto end_IL_0002;
						}
						goto IL_0048;
						continue;
						end_IL_0002:
						break;
					}
					break;
				}
			}
			catch
			{
				//try-fault
				((IDisposable)this).Dispose();
				throw;
			}
			return result;
		}

		bool IEnumerator.MoveNext()
		{
			//ILSpy generated this explicit interface implementation from .override directive in MoveNext
			return this.MoveNext();
		}

		[DebuggerHidden]
		void IEnumerator.Reset()
		{
			throw new NotSupportedException();
		}

		void IDisposable.Dispose()
		{
			switch (_003C_003E1__state)
			{
			case 1:
			case 2:
			case 3:
				try
				{
					while (true)
					{
						IL_0035:
						int num = _003C_003E1__state;
						int num2 = 1;
						while (true)
						{
							switch (num2)
							{
							case 1:
								switch (num)
								{
								default:
									num2 = 0;
									continue;
								case 2:
								case 3:
									break;
								}
								try
								{
								}
								finally
								{
									_003C_003Em__Finally6();
								}
								goto case 3;
							case 0:
								num2 = 3;
								continue;
							case 3:
								num2 = 2;
								continue;
							case 2:
								goto end_IL_001f;
							}
							goto IL_0035;
							continue;
							end_IL_001f:
							break;
						}
						break;
					}
				}
				finally
				{
					_003C_003Em__Finally4();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CDescendants_003Ed__0(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally4()
		{
			_003C_003E1__state = -1;
			((IDisposable)_003C_003E7__wrap3/*cast due to .constrained prefix*/).Dispose();
		}

		private void _003C_003Em__Finally6()
		{
			_003C_003E1__state = 1;
			if (_003C_003E7__wrap5 != null)
			{
				_003C_003E7__wrap5.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CDescendants_003Ed__9 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNodeCollection _003C_003E4__this;

		public string name;

		public string _003C_003E3__name;

		public HtmlNode _003Citem_003E5__a;

		public HtmlNode _003Cn_003E5__b;

		public List<HtmlNode>.Enumerator _003C_003E7__wrapc;

		public IEnumerator<HtmlNode> _003C_003E7__wrape;

		HtmlNode IEnumerator<HtmlNode>.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		object IEnumerator.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		[DebuggerHidden]
		IEnumerator<HtmlNode> IEnumerable<HtmlNode>.GetEnumerator()
		{
			int num = 1;
			_003CDescendants_003Ed__9 _003CDescendants_003Ed__ = default(_003CDescendants_003Ed__9);
			while (true)
			{
				switch (num)
				{
				default:
					if (Thread.CurrentThread.ManagedThreadId == _003C_003El__initialThreadId)
					{
						if (true)
						{
						}
						num = 0;
						break;
					}
					goto IL_004c;
				case 4:
					_003C_003E1__state = 0;
					_003CDescendants_003Ed__ = this;
					num = 3;
					break;
				case 0:
					num = 2;
					break;
				case 2:
					if (_003C_003E1__state == -2)
					{
						num = 4;
						break;
					}
					goto IL_004c;
				case 3:
				case 5:
					{
						_003CDescendants_003Ed__.name = _003C_003E3__name;
						return _003CDescendants_003Ed__;
					}
					IL_004c:
					_003CDescendants_003Ed__ = new _003CDescendants_003Ed__9(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 5;
					break;
				}
			}
		}

		[DebuggerHidden]
		IEnumerator IEnumerable.GetEnumerator()
		{
			return ((IEnumerable<HtmlNode>)this).GetEnumerator();
		}

		private bool MoveNext()
		{
			bool result = default(bool);
			try
			{
				while (true)
				{
					IL_0048:
					int num = _003C_003E1__state;
					int num2 = 10;
					while (true)
					{
						switch (num2)
						{
						case 10:
							if (num != 0)
							{
								num2 = 8;
								continue;
							}
							_003C_003E1__state = -1;
							_003C_003E7__wrapc = _003C_003E4__this._items.GetEnumerator();
							_003C_003E1__state = 1;
							if (true)
							{
							}
							num2 = 2;
							continue;
						case 0:
							_003C_003Em__Finallyf();
							num2 = 5;
							continue;
						case 9:
							num2 = 3;
							continue;
						case 2:
						case 5:
							num2 = 7;
							continue;
						case 7:
							if (!_003C_003E7__wrapc.MoveNext())
							{
								num2 = 1;
								continue;
							}
							_003Citem_003E5__a = _003C_003E7__wrapc.Current;
							_003C_003E7__wrape = _003Citem_003E5__a.Descendants(name).GetEnumerator();
							_003C_003E1__state = 2;
							num2 = 11;
							continue;
						case 8:
							num2 = 15;
							continue;
						case 15:
							if (num == 3)
							{
								_003C_003E1__state = 2;
								num2 = 6;
							}
							else
							{
								num2 = 9;
							}
							continue;
						case 6:
						case 11:
							num2 = 12;
							continue;
						case 12:
							if (!_003C_003E7__wrape.MoveNext())
							{
								num2 = 0;
								continue;
							}
							_003Cn_003E5__b = _003C_003E7__wrape.Current;
							_003C_003E2__current = _003Cn_003E5__b;
							_003C_003E1__state = 3;
							result = true;
							num2 = 14;
							continue;
						case 1:
							_003C_003Em__Finallyd();
							num2 = 4;
							continue;
						case 14:
							goto end_IL_0002;
						case 3:
						case 4:
							result = false;
							num2 = 13;
							continue;
						case 13:
							goto end_IL_0002;
						}
						goto IL_0048;
						continue;
						end_IL_0002:
						break;
					}
					break;
				}
			}
			catch
			{
				//try-fault
				((IDisposable)this).Dispose();
				throw;
			}
			return result;
		}

		bool IEnumerator.MoveNext()
		{
			//ILSpy generated this explicit interface implementation from .override directive in MoveNext
			return this.MoveNext();
		}

		[DebuggerHidden]
		void IEnumerator.Reset()
		{
			throw new NotSupportedException();
		}

		void IDisposable.Dispose()
		{
			switch (_003C_003E1__state)
			{
			case 1:
			case 2:
			case 3:
				try
				{
					while (true)
					{
						IL_0035:
						int num = _003C_003E1__state;
						int num2 = 0;
						while (true)
						{
							switch (num2)
							{
							case 0:
								switch (num)
								{
								default:
									num2 = 2;
									continue;
								case 2:
								case 3:
									break;
								}
								try
								{
								}
								finally
								{
									_003C_003Em__Finallyf();
								}
								goto case 1;
							case 2:
								num2 = 1;
								continue;
							case 1:
								num2 = 3;
								continue;
							case 3:
								goto end_IL_001f;
							}
							goto IL_0035;
							continue;
							end_IL_001f:
							break;
						}
						break;
					}
				}
				finally
				{
					_003C_003Em__Finallyd();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CDescendants_003Ed__9(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finallyd()
		{
			_003C_003E1__state = -1;
			((IDisposable)_003C_003E7__wrapc/*cast due to .constrained prefix*/).Dispose();
		}

		private void _003C_003Em__Finallyf()
		{
			_003C_003E1__state = 1;
			if (_003C_003E7__wrape != null)
			{
				_003C_003E7__wrape.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CElements_003Ed__12 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNodeCollection _003C_003E4__this;

		public HtmlNode _003Citem_003E5__13;

		public HtmlNode _003Cn_003E5__14;

		public List<HtmlNode>.Enumerator _003C_003E7__wrap15;

		public IEnumerator<HtmlNode> _003C_003E7__wrap17;

		HtmlNode IEnumerator<HtmlNode>.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		object IEnumerator.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		[DebuggerHidden]
		IEnumerator<HtmlNode> IEnumerable<HtmlNode>.GetEnumerator()
		{
			int num = 2;
			_003CElements_003Ed__12 result = default(_003CElements_003Ed__12);
			while (true)
			{
				switch (num)
				{
				default:
					if (Thread.CurrentThread.ManagedThreadId == _003C_003El__initialThreadId)
					{
						if (true)
						{
						}
						num = 5;
						break;
					}
					goto IL_004c;
				case 3:
					_003C_003E1__state = 0;
					result = this;
					num = 0;
					break;
				case 5:
					num = 4;
					break;
				case 4:
					if (_003C_003E1__state == -2)
					{
						num = 3;
						break;
					}
					goto IL_004c;
				case 0:
				case 1:
					{
						return result;
					}
					IL_004c:
					result = new _003CElements_003Ed__12(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 1;
					break;
				}
			}
		}

		[DebuggerHidden]
		IEnumerator IEnumerable.GetEnumerator()
		{
			return ((IEnumerable<HtmlNode>)this).GetEnumerator();
		}

		private bool MoveNext()
		{
			bool result = default(bool);
			try
			{
				while (true)
				{
					IL_0048:
					int num = _003C_003E1__state;
					int num2 = 8;
					while (true)
					{
						switch (num2)
						{
						case 8:
							if (num != 0)
							{
								num2 = 13;
								continue;
							}
							_003C_003E1__state = -1;
							_003C_003E7__wrap15 = _003C_003E4__this._items.GetEnumerator();
							_003C_003E1__state = 1;
							if (true)
							{
							}
							num2 = 2;
							continue;
						case 15:
							_003C_003Em__Finally18();
							num2 = 7;
							continue;
						case 3:
							num2 = 4;
							continue;
						case 2:
						case 7:
							num2 = 0;
							continue;
						case 0:
							if (!_003C_003E7__wrap15.MoveNext())
							{
								num2 = 1;
								continue;
							}
							_003Citem_003E5__13 = _003C_003E7__wrap15.Current;
							_003C_003E7__wrap17 = ((IEnumerable<HtmlNode>)_003Citem_003E5__13.ChildNodes).GetEnumerator();
							_003C_003E1__state = 2;
							num2 = 10;
							continue;
						case 13:
							num2 = 14;
							continue;
						case 14:
							if (num == 3)
							{
								_003C_003E1__state = 2;
								num2 = 11;
							}
							else
							{
								num2 = 3;
							}
							continue;
						case 10:
						case 11:
							num2 = 5;
							continue;
						case 5:
							if (!_003C_003E7__wrap17.MoveNext())
							{
								num2 = 15;
								continue;
							}
							_003Cn_003E5__14 = _003C_003E7__wrap17.Current;
							_003C_003E2__current = _003Cn_003E5__14;
							_003C_003E1__state = 3;
							result = true;
							num2 = 12;
							continue;
						case 1:
							_003C_003Em__Finally16();
							num2 = 6;
							continue;
						case 12:
							goto end_IL_0002;
						case 4:
						case 6:
							result = false;
							num2 = 9;
							continue;
						case 9:
							goto end_IL_0002;
						}
						goto IL_0048;
						continue;
						end_IL_0002:
						break;
					}
					break;
				}
			}
			catch
			{
				//try-fault
				((IDisposable)this).Dispose();
				throw;
			}
			return result;
		}

		bool IEnumerator.MoveNext()
		{
			//ILSpy generated this explicit interface implementation from .override directive in MoveNext
			return this.MoveNext();
		}

		[DebuggerHidden]
		void IEnumerator.Reset()
		{
			throw new NotSupportedException();
		}

		void IDisposable.Dispose()
		{
			switch (_003C_003E1__state)
			{
			case 1:
			case 2:
			case 3:
				try
				{
					while (true)
					{
						IL_0035:
						int num = _003C_003E1__state;
						int num2 = 0;
						while (true)
						{
							switch (num2)
							{
							case 0:
								switch (num)
								{
								default:
									num2 = 2;
									continue;
								case 2:
								case 3:
									break;
								}
								try
								{
								}
								finally
								{
									_003C_003Em__Finally18();
								}
								goto case 3;
							case 2:
								num2 = 3;
								continue;
							case 3:
								num2 = 1;
								continue;
							case 1:
								goto end_IL_001f;
							}
							goto IL_0035;
							continue;
							end_IL_001f:
							break;
						}
						break;
					}
				}
				finally
				{
					_003C_003Em__Finally16();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CElements_003Ed__12(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally16()
		{
			_003C_003E1__state = -1;
			((IDisposable)_003C_003E7__wrap15/*cast due to .constrained prefix*/).Dispose();
		}

		private void _003C_003Em__Finally18()
		{
			_003C_003E1__state = 1;
			if (_003C_003E7__wrap17 != null)
			{
				_003C_003E7__wrap17.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CElements_003Ed__1b : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNodeCollection _003C_003E4__this;

		public string name;

		public string _003C_003E3__name;

		public HtmlNode _003Citem_003E5__1c;

		public HtmlNode _003Cn_003E5__1d;

		public List<HtmlNode>.Enumerator _003C_003E7__wrap1e;

		public IEnumerator<HtmlNode> _003C_003E7__wrap20;

		HtmlNode IEnumerator<HtmlNode>.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		object IEnumerator.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		[DebuggerHidden]
		IEnumerator<HtmlNode> IEnumerable<HtmlNode>.GetEnumerator()
		{
			int num = 1;
			_003CElements_003Ed__1b _003CElements_003Ed__1b = default(_003CElements_003Ed__1b);
			while (true)
			{
				switch (num)
				{
				default:
					if (Thread.CurrentThread.ManagedThreadId == _003C_003El__initialThreadId)
					{
						if (true)
						{
						}
						num = 4;
						break;
					}
					goto IL_004c;
				case 3:
					_003C_003E1__state = 0;
					_003CElements_003Ed__1b = this;
					num = 2;
					break;
				case 4:
					num = 5;
					break;
				case 5:
					if (_003C_003E1__state == -2)
					{
						num = 3;
						break;
					}
					goto IL_004c;
				case 0:
				case 2:
					{
						_003CElements_003Ed__1b.name = _003C_003E3__name;
						return _003CElements_003Ed__1b;
					}
					IL_004c:
					_003CElements_003Ed__1b = new _003CElements_003Ed__1b(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 0;
					break;
				}
			}
		}

		[DebuggerHidden]
		IEnumerator IEnumerable.GetEnumerator()
		{
			return ((IEnumerable<HtmlNode>)this).GetEnumerator();
		}

		private bool MoveNext()
		{
			bool result = default(bool);
			try
			{
				while (true)
				{
					IL_0048:
					int num = _003C_003E1__state;
					int num2 = 6;
					while (true)
					{
						switch (num2)
						{
						case 6:
							if (num != 0)
							{
								num2 = 8;
								continue;
							}
							_003C_003E1__state = -1;
							_003C_003E7__wrap1e = _003C_003E4__this._items.GetEnumerator();
							_003C_003E1__state = 1;
							if (true)
							{
							}
							num2 = 2;
							continue;
						case 5:
							_003C_003Em__Finally21();
							num2 = 10;
							continue;
						case 11:
							num2 = 13;
							continue;
						case 2:
						case 10:
							num2 = 4;
							continue;
						case 4:
							if (!_003C_003E7__wrap1e.MoveNext())
							{
								num2 = 9;
								continue;
							}
							_003Citem_003E5__1c = _003C_003E7__wrap1e.Current;
							_003C_003E7__wrap20 = _003Citem_003E5__1c.Elements(name).GetEnumerator();
							_003C_003E1__state = 2;
							num2 = 12;
							continue;
						case 8:
							num2 = 3;
							continue;
						case 3:
							if (num == 3)
							{
								_003C_003E1__state = 2;
								num2 = 7;
							}
							else
							{
								num2 = 11;
							}
							continue;
						case 7:
						case 12:
							num2 = 15;
							continue;
						case 15:
							if (!_003C_003E7__wrap20.MoveNext())
							{
								num2 = 5;
								continue;
							}
							_003Cn_003E5__1d = _003C_003E7__wrap20.Current;
							_003C_003E2__current = _003Cn_003E5__1d;
							_003C_003E1__state = 3;
							result = true;
							num2 = 0;
							continue;
						case 9:
							_003C_003Em__Finally1f();
							num2 = 14;
							continue;
						case 0:
							goto end_IL_0002;
						case 13:
						case 14:
							result = false;
							num2 = 1;
							continue;
						case 1:
							goto end_IL_0002;
						}
						goto IL_0048;
						continue;
						end_IL_0002:
						break;
					}
					break;
				}
			}
			catch
			{
				//try-fault
				((IDisposable)this).Dispose();
				throw;
			}
			return result;
		}

		bool IEnumerator.MoveNext()
		{
			//ILSpy generated this explicit interface implementation from .override directive in MoveNext
			return this.MoveNext();
		}

		[DebuggerHidden]
		void IEnumerator.Reset()
		{
			throw new NotSupportedException();
		}

		void IDisposable.Dispose()
		{
			switch (_003C_003E1__state)
			{
			case 1:
			case 2:
			case 3:
				try
				{
					while (true)
					{
						IL_0035:
						int num = _003C_003E1__state;
						int num2 = 3;
						while (true)
						{
							switch (num2)
							{
							case 3:
								switch (num)
								{
								default:
									num2 = 0;
									continue;
								case 2:
								case 3:
									break;
								}
								try
								{
								}
								finally
								{
									_003C_003Em__Finally21();
								}
								goto case 1;
							case 0:
								num2 = 1;
								continue;
							case 1:
								num2 = 2;
								continue;
							case 2:
								goto end_IL_001f;
							}
							goto IL_0035;
							continue;
							end_IL_001f:
							break;
						}
						break;
					}
				}
				finally
				{
					_003C_003Em__Finally1f();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CElements_003Ed__1b(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally1f()
		{
			_003C_003E1__state = -1;
			((IDisposable)_003C_003E7__wrap1e/*cast due to .constrained prefix*/).Dispose();
		}

		private void _003C_003Em__Finally21()
		{
			_003C_003E1__state = 1;
			if (_003C_003E7__wrap20 != null)
			{
				_003C_003E7__wrap20.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CNodes_003Ed__24 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNodeCollection _003C_003E4__this;

		public HtmlNode _003Citem_003E5__25;

		public HtmlNode _003Cn_003E5__26;

		public List<HtmlNode>.Enumerator _003C_003E7__wrap27;

		public IEnumerator<HtmlNode> _003C_003E7__wrap29;

		HtmlNode IEnumerator<HtmlNode>.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		object IEnumerator.Current
		{
			[DebuggerHidden]
			get
			{
				return _003C_003E2__current;
			}
		}

		[DebuggerHidden]
		IEnumerator<HtmlNode> IEnumerable<HtmlNode>.GetEnumerator()
		{
			int num = 1;
			_003CNodes_003Ed__24 result = default(_003CNodes_003Ed__24);
			while (true)
			{
				switch (num)
				{
				default:
					if (Thread.CurrentThread.ManagedThreadId == _003C_003El__initialThreadId)
					{
						if (true)
						{
						}
						num = 3;
						break;
					}
					goto IL_004c;
				case 0:
					_003C_003E1__state = 0;
					result = this;
					num = 4;
					break;
				case 3:
					num = 5;
					break;
				case 5:
					if (_003C_003E1__state == -2)
					{
						num = 0;
						break;
					}
					goto IL_004c;
				case 2:
				case 4:
					{
						return result;
					}
					IL_004c:
					result = new _003CNodes_003Ed__24(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 2;
					break;
				}
			}
		}

		[DebuggerHidden]
		IEnumerator IEnumerable.GetEnumerator()
		{
			return ((IEnumerable<HtmlNode>)this).GetEnumerator();
		}

		private bool MoveNext()
		{
			bool result = default(bool);
			try
			{
				while (true)
				{
					IL_0048:
					int num = _003C_003E1__state;
					int num2 = 12;
					while (true)
					{
						switch (num2)
						{
						case 12:
							if (num != 0)
							{
								num2 = 5;
								continue;
							}
							_003C_003E1__state = -1;
							_003C_003E7__wrap27 = _003C_003E4__this._items.GetEnumerator();
							_003C_003E1__state = 1;
							if (true)
							{
							}
							num2 = 4;
							continue;
						case 14:
							_003C_003Em__Finally2a();
							num2 = 6;
							continue;
						case 15:
							num2 = 9;
							continue;
						case 4:
						case 6:
							num2 = 10;
							continue;
						case 10:
							if (!_003C_003E7__wrap27.MoveNext())
							{
								num2 = 3;
								continue;
							}
							_003Citem_003E5__25 = _003C_003E7__wrap27.Current;
							_003C_003E7__wrap29 = ((IEnumerable<HtmlNode>)_003Citem_003E5__25.ChildNodes).GetEnumerator();
							_003C_003E1__state = 2;
							num2 = 8;
							continue;
						case 5:
							num2 = 0;
							continue;
						case 0:
							if (num == 3)
							{
								_003C_003E1__state = 2;
								num2 = 7;
							}
							else
							{
								num2 = 15;
							}
							continue;
						case 7:
						case 8:
							num2 = 1;
							continue;
						case 1:
							if (!_003C_003E7__wrap29.MoveNext())
							{
								num2 = 14;
								continue;
							}
							_003Cn_003E5__26 = _003C_003E7__wrap29.Current;
							_003C_003E2__current = _003Cn_003E5__26;
							_003C_003E1__state = 3;
							result = true;
							num2 = 11;
							continue;
						case 3:
							_003C_003Em__Finally28();
							num2 = 2;
							continue;
						case 11:
							goto end_IL_0002;
						case 2:
						case 9:
							result = false;
							num2 = 13;
							continue;
						case 13:
							goto end_IL_0002;
						}
						goto IL_0048;
						continue;
						end_IL_0002:
						break;
					}
					break;
				}
			}
			catch
			{
				//try-fault
				((IDisposable)this).Dispose();
				throw;
			}
			return result;
		}

		bool IEnumerator.MoveNext()
		{
			//ILSpy generated this explicit interface implementation from .override directive in MoveNext
			return this.MoveNext();
		}

		[DebuggerHidden]
		void IEnumerator.Reset()
		{
			throw new NotSupportedException();
		}

		void IDisposable.Dispose()
		{
			switch (_003C_003E1__state)
			{
			case 1:
			case 2:
			case 3:
				try
				{
					while (true)
					{
						IL_0035:
						int num = _003C_003E1__state;
						int num2 = 3;
						while (true)
						{
							switch (num2)
							{
							case 3:
								switch (num)
								{
								default:
									num2 = 0;
									continue;
								case 2:
								case 3:
									break;
								}
								try
								{
								}
								finally
								{
									_003C_003Em__Finally2a();
								}
								goto case 2;
							case 0:
								num2 = 2;
								continue;
							case 2:
								num2 = 1;
								continue;
							case 1:
								goto end_IL_001f;
							}
							goto IL_0035;
							continue;
							end_IL_001f:
							break;
						}
						break;
					}
				}
				finally
				{
					_003C_003Em__Finally28();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CNodes_003Ed__24(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally28()
		{
			_003C_003E1__state = -1;
			((IDisposable)_003C_003E7__wrap27/*cast due to .constrained prefix*/).Dispose();
		}

		private void _003C_003Em__Finally2a()
		{
			_003C_003E1__state = 1;
			if (_003C_003E7__wrap29 != null)
			{
				_003C_003E7__wrap29.Dispose();
			}
		}
	}

	private readonly HtmlNode _parentnode;

	private readonly List<HtmlNode> _items = new List<HtmlNode>();

	public int this[HtmlNode node]
	{
		get
		{
			int nodeIndex = GetNodeIndex(node);
			if (nodeIndex == -1)
			{
				if (true)
				{
				}
				throw new ArgumentOutOfRangeException("node", "Node \"" + node.CloneNode(deep: false).OuterHtml + "\" was not found in the collection");
			}
			return nodeIndex;
		}
	}

	public HtmlNode this[string nodeName]
	{
		get
		{
			while (true)
			{
				nodeName = nodeName.ToLower();
				int num = 0;
				int num2 = 0;
				while (true)
				{
					switch (num2)
					{
					case 1:
						return _items[num];
					case 3:
						if (!_items[num].Name.Equals(nodeName))
						{
							if (true)
							{
							}
							num++;
							num2 = 2;
						}
						else
						{
							num2 = 1;
						}
						continue;
					case 0:
					case 2:
						num2 = 4;
						continue;
					case 4:
						num2 = ((num >= _items.Count) ? 5 : 3);
						continue;
					case 5:
						return null;
					}
					break;
				}
			}
		}
	}

	public int Count => _items.Count;

	public bool IsReadOnly => false;

	public HtmlNode this[int index]
	{
		get
		{
			return _items[index];
		}
		set
		{
			_items[index] = value;
		}
	}

	public HtmlNodeCollection(HtmlNode parentnode)
	{
		_parentnode = parentnode;
	}

	public void Add(HtmlNode node)
	{
		_items.Add(node);
	}

	public void Clear()
	{
		using (List<HtmlNode>.Enumerator enumerator = _items.GetEnumerator())
		{
			int num = 0;
			while (true)
			{
				switch (num)
				{
				default:
					num = 2;
					continue;
				case 2:
					if (enumerator.MoveNext())
					{
						HtmlNode current = enumerator.Current;
						current.ParentNode = null;
						current.NextSibling = null;
						current.PreviousSibling = null;
						num = 1;
					}
					else
					{
						num = 3;
					}
					continue;
				case 3:
					num = 4;
					continue;
				case 4:
					break;
				}
				break;
			}
		}
		if (true)
		{
		}
		_items.Clear();
	}

	public bool Contains(HtmlNode item)
	{
		return _items.Contains(item);
	}

	public void CopyTo(HtmlNode[] array, int arrayIndex)
	{
		_items.CopyTo(array, arrayIndex);
	}

	IEnumerator<HtmlNode> IEnumerable<HtmlNode>.GetEnumerator()
	{
		return _items.GetEnumerator();
	}

	IEnumerator IEnumerable.GetEnumerator()
	{
		return _items.GetEnumerator();
	}

	public int IndexOf(HtmlNode item)
	{
		return _items.IndexOf(item);
	}

	public void Insert(int index, HtmlNode node)
	{
		while (true)
		{
			HtmlNode htmlNode = null;
			HtmlNode htmlNode2 = null;
			int num = 5;
			while (true)
			{
				switch (num)
				{
				case 5:
					if (index > 0)
					{
						num = 3;
						continue;
					}
					goto case 8;
				case 9:
					if (htmlNode != null)
					{
						num = 11;
						continue;
					}
					goto case 15;
				case 0:
					throw new InvalidProgramException("Unexpected error.");
				case 8:
					num = 2;
					continue;
				case 2:
					if (index < _items.Count)
					{
						num = 4;
						continue;
					}
					goto case 1;
				case 15:
					node._prevnode = htmlNode2;
					num = 13;
					continue;
				case 13:
					if (htmlNode == node)
					{
						num = 6;
						continue;
					}
					node._nextnode = htmlNode;
					node._parentnode = _parentnode;
					return;
				case 3:
					htmlNode2 = _items[index - 1];
					num = 8;
					continue;
				case 11:
					htmlNode._prevnode = node;
					num = 15;
					continue;
				case 6:
					throw new InvalidProgramException("Unexpected error.");
				case 7:
					num = 10;
					continue;
				case 10:
					if (node == htmlNode2)
					{
						num = 0;
						continue;
					}
					htmlNode2._nextnode = node;
					num = 12;
					continue;
				case 4:
					htmlNode = _items[index];
					num = 1;
					continue;
				case 12:
					if (1 == 0)
					{
					}
					goto IL_0062;
				case 1:
					_items.Insert(index, node);
					num = 14;
					continue;
				case 14:
					{
						if (htmlNode2 != null)
						{
							num = 7;
							continue;
						}
						goto IL_0062;
					}
					IL_0062:
					num = 9;
					continue;
				}
				break;
			}
		}
	}

	public bool Remove(HtmlNode item)
	{
		int index = _items.IndexOf(item);
		RemoveAt(index);
		return true;
	}

	public void RemoveAt(int index)
	{
		while (true)
		{
			HtmlNode htmlNode = null;
			HtmlNode htmlNode2 = null;
			HtmlNode htmlNode3 = _items[index];
			int num = 12;
			while (true)
			{
				switch (num)
				{
				case 12:
					if (index > 0)
					{
						num = 10;
						continue;
					}
					goto case 1;
				case 9:
					num = 6;
					continue;
				case 6:
					if (htmlNode != htmlNode2)
					{
						htmlNode2._nextnode = htmlNode;
						num = 5;
					}
					else
					{
						num = 7;
					}
					continue;
				case 1:
					num = 8;
					continue;
				case 8:
					if (index < _items.Count - 1)
					{
						num = 4;
						continue;
					}
					goto case 13;
				case 5:
					num = 0;
					continue;
				case 0:
					if (htmlNode != null)
					{
						num = 3;
						continue;
					}
					goto case 2;
				case 10:
					htmlNode2 = _items[index - 1];
					num = 1;
					continue;
				case 7:
					throw new InvalidProgramException("Unexpected error.");
				case 3:
					if (true)
					{
					}
					htmlNode._prevnode = htmlNode2;
					num = 2;
					continue;
				case 13:
					_items.RemoveAt(index);
					num = 11;
					continue;
				case 11:
					if (htmlNode2 != null)
					{
						num = 9;
						continue;
					}
					goto case 5;
				case 4:
					htmlNode = _items[index + 1];
					num = 13;
					continue;
				case 2:
					htmlNode3._prevnode = null;
					htmlNode3._nextnode = null;
					htmlNode3._parentnode = null;
					return;
				}
				break;
			}
		}
	}

	public static HtmlNode FindFirst(HtmlNodeCollection items, string name)
	{
		switch (0)
		{
		default:
			{
				if (true)
				{
				}
				IEnumerator<HtmlNode> enumerator = ((IEnumerable<HtmlNode>)items).GetEnumerator();
				HtmlNode result = default(HtmlNode);
				try
				{
					int num = 11;
					HtmlNode htmlNode = default(HtmlNode);
					HtmlNode current = default(HtmlNode);
					while (true)
					{
						switch (num)
						{
						case 2:
							break;
						case 3:
							result = htmlNode;
							num = 1;
							continue;
						case 1:
							goto end_IL_0021;
						case 4:
							num = ((!current.Name.ToLower().Contains(name)) ? 8 : 7);
							continue;
						case 0:
							htmlNode = FindFirst(current.ChildNodes, name);
							num = 10;
							continue;
						case 10:
							if (htmlNode != null)
							{
								num = 3;
								continue;
							}
							goto default;
						default:
							num = 9;
							continue;
						case 9:
							if (enumerator.MoveNext())
							{
								current = enumerator.Current;
								num = 4;
							}
							else
							{
								num = 5;
							}
							continue;
						case 8:
							if (current.HasChildNodes)
							{
								num = 0;
								continue;
							}
							goto default;
						case 7:
							result = current;
							num = 6;
							continue;
						case 6:
							goto end_IL_0021;
						case 5:
							num = 2;
							continue;
						}
						break;
					}
					goto IL_001f;
					end_IL_0021:;
				}
				finally
				{
					int num = 0;
					while (true)
					{
						switch (num)
						{
						default:
							if (enumerator != null)
							{
								num = 2;
								continue;
							}
							break;
						case 2:
							enumerator.Dispose();
							num = 1;
							continue;
						case 1:
							break;
						}
						break;
					}
				}
				return result;
			}
			IL_001f:
			return null;
		}
	}

	public void Append(HtmlNode node)
	{
		while (true)
		{
			HtmlNode htmlNode = null;
			int num = 2;
			while (true)
			{
				switch (num)
				{
				case 2:
					if (_items.Count > 0)
					{
						if (true)
						{
						}
						num = 5;
						continue;
					}
					goto case 3;
				case 0:
					if (htmlNode == node)
					{
						num = 6;
						continue;
					}
					htmlNode._nextnode = node;
					return;
				case 1:
					return;
				case 5:
					htmlNode = _items[_items.Count - 1];
					num = 3;
					continue;
				case 6:
					throw new InvalidProgramException("Unexpected error.");
				case 3:
					_items.Add(node);
					node._prevnode = htmlNode;
					node._nextnode = null;
					node._parentnode = _parentnode;
					num = 4;
					continue;
				case 4:
					num = ((htmlNode == null) ? 1 : 0);
					continue;
				}
				break;
			}
		}
	}

	public HtmlNode FindFirst(string name)
	{
		return FindFirst(this, name);
	}

	public int GetNodeIndex(HtmlNode node)
	{
		while (true)
		{
			int num = 0;
			int num2 = 0;
			while (true)
			{
				switch (num2)
				{
				case 2:
					return num;
				case 5:
					if (true)
					{
					}
					if (node != _items[num])
					{
						num++;
						num2 = 3;
					}
					else
					{
						num2 = 2;
					}
					continue;
				case 0:
				case 3:
					num2 = 4;
					continue;
				case 4:
					num2 = ((num >= _items.Count) ? 1 : 5);
					continue;
				case 1:
					return -1;
				}
				break;
			}
		}
	}

	public void Prepend(HtmlNode node)
	{
		while (true)
		{
			HtmlNode htmlNode = null;
			int num = 7;
			while (true)
			{
				switch (num)
				{
				case 7:
					if (_items.Count > 0)
					{
						if (true)
						{
						}
						num = 6;
						continue;
					}
					goto case 2;
				case 5:
					if (htmlNode != null)
					{
						num = 0;
						continue;
					}
					return;
				case 1:
					throw new InvalidProgramException("Unexpected error.");
				case 6:
					htmlNode = _items[0];
					num = 2;
					continue;
				case 0:
					htmlNode._prevnode = node;
					num = 3;
					continue;
				case 3:
					return;
				case 2:
					_items.Insert(0, node);
					num = 4;
					continue;
				case 4:
					if (node != htmlNode)
					{
						node._nextnode = htmlNode;
						node._prevnode = null;
						node._parentnode = _parentnode;
						num = 5;
					}
					else
					{
						num = 1;
					}
					continue;
				}
				break;
			}
		}
	}

	public bool Remove(int index)
	{
		RemoveAt(index);
		return true;
	}

	public void Replace(int index, HtmlNode node)
	{
		while (true)
		{
			HtmlNode htmlNode = null;
			HtmlNode htmlNode2 = null;
			HtmlNode htmlNode3 = _items[index];
			int num = 9;
			while (true)
			{
				switch (num)
				{
				case 9:
					if (index > 0)
					{
						num = 4;
						continue;
					}
					goto case 11;
				case 2:
					num = 15;
					continue;
				case 15:
					if (htmlNode != null)
					{
						num = 13;
						continue;
					}
					goto case 10;
				case 12:
					throw new InvalidProgramException("Unexpected error.");
				case 11:
					num = 0;
					continue;
				case 0:
					if (index < _items.Count - 1)
					{
						num = 8;
						continue;
					}
					goto case 3;
				case 10:
					node._prevnode = htmlNode2;
					num = 5;
					continue;
				case 5:
					if (htmlNode == node)
					{
						num = 14;
						continue;
					}
					node._nextnode = htmlNode;
					node._parentnode = _parentnode;
					htmlNode3._prevnode = null;
					htmlNode3._nextnode = null;
					htmlNode3._parentnode = null;
					return;
				case 4:
					htmlNode2 = _items[index - 1];
					num = 11;
					continue;
				case 13:
					htmlNode._prevnode = node;
					num = 10;
					continue;
				case 14:
					throw new InvalidProgramException("Unexpected error.");
				case 6:
					num = 7;
					continue;
				case 7:
					if (node == htmlNode2)
					{
						num = 12;
						continue;
					}
					if (true)
					{
					}
					htmlNode2._nextnode = node;
					num = 2;
					continue;
				case 8:
					htmlNode = _items[index + 1];
					num = 3;
					continue;
				case 3:
					_items[index] = node;
					num = 1;
					continue;
				case 1:
					if (htmlNode2 != null)
					{
						num = 6;
						continue;
					}
					goto case 2;
				}
				break;
			}
		}
	}

	public IEnumerable<HtmlNode> Descendants()
	{
		//yield-return decompiler failed: Unexpected instruction in Iterator.Dispose()
		_003CDescendants_003Ed__0 _003CDescendants_003Ed__ = new _003CDescendants_003Ed__0(-2);
		_003CDescendants_003Ed__._003C_003E4__this = this;
		return _003CDescendants_003Ed__;
	}

	public IEnumerable<HtmlNode> Descendants(string name)
	{
		if (true)
		{
		}
		_003CDescendants_003Ed__9 _003CDescendants_003Ed__ = new _003CDescendants_003Ed__9(-2);
		_003CDescendants_003Ed__._003C_003E4__this = this;
		_003CDescendants_003Ed__._003C_003E3__name = name;
		return _003CDescendants_003Ed__;
	}

	public IEnumerable<HtmlNode> Elements()
	{
		//yield-return decompiler failed: Unexpected instruction in Iterator.Dispose()
		_003CElements_003Ed__12 _003CElements_003Ed__ = new _003CElements_003Ed__12(-2);
		_003CElements_003Ed__._003C_003E4__this = this;
		return _003CElements_003Ed__;
	}

	public IEnumerable<HtmlNode> Elements(string name)
	{
		if (true)
		{
		}
		_003CElements_003Ed__1b _003CElements_003Ed__1b = new _003CElements_003Ed__1b(-2);
		_003CElements_003Ed__1b._003C_003E4__this = this;
		_003CElements_003Ed__1b._003C_003E3__name = name;
		return _003CElements_003Ed__1b;
	}

	public IEnumerable<HtmlNode> Nodes()
	{
		//yield-return decompiler failed: Unexpected instruction in Iterator.Dispose()
		_003CNodes_003Ed__24 _003CNodes_003Ed__ = new _003CNodes_003Ed__24(-2);
		_003CNodes_003Ed__._003C_003E4__this = this;
		return _003CNodes_003Ed__;
	}
}
