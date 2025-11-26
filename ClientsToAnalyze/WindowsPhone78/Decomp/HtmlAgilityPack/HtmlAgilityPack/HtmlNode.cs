using System;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Runtime.CompilerServices;
using System.Threading;
using System.Xml;

namespace HtmlAgilityPack;

[DebuggerDisplay("Name: {OriginalName}}")]
public class HtmlNode
{
	[CompilerGenerated]
	private sealed class _003CAncestors_003Ed__4 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public string name;

		public string _003C_003E3__name;

		public HtmlNode _003Cn_003E5__5;

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
			_003CAncestors_003Ed__4 _003CAncestors_003Ed__ = default(_003CAncestors_003Ed__4);
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
				case 2:
					_003C_003E1__state = 0;
					_003CAncestors_003Ed__ = this;
					num = 4;
					break;
				case 3:
					num = 5;
					break;
				case 5:
					if (_003C_003E1__state == -2)
					{
						num = 2;
						break;
					}
					goto IL_004c;
				case 0:
				case 4:
					{
						_003CAncestors_003Ed__.name = _003C_003E3__name;
						return _003CAncestors_003Ed__;
					}
					IL_004c:
					_003CAncestors_003Ed__ = new _003CAncestors_003Ed__4(0)
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
			while (true)
			{
				int num = _003C_003E1__state;
				int num2 = 5;
				while (true)
				{
					switch (num2)
					{
					case 5:
						switch (num)
						{
						default:
							num2 = 7;
							break;
						case 1:
							_003C_003E1__state = -1;
							if (true)
							{
							}
							num2 = 4;
							break;
						case 0:
							_003C_003E1__state = -1;
							_003Cn_003E5__5 = _003C_003E4__this.ParentNode;
							num2 = 8;
							break;
						}
						continue;
					case 9:
						_003C_003E2__current = _003Cn_003E5__5;
						_003C_003E1__state = 1;
						return true;
					case 1:
					case 8:
						num2 = 0;
						continue;
					case 0:
						num2 = ((_003Cn_003E5__5 != null) ? 2 : 3);
						continue;
					case 7:
						num2 = 6;
						continue;
					case 4:
						_003Cn_003E5__5 = _003Cn_003E5__5.ParentNode;
						num2 = 1;
						continue;
					case 2:
						if (_003Cn_003E5__5.Name == name)
						{
							num2 = 9;
							continue;
						}
						goto case 4;
					case 3:
					case 6:
						return false;
					}
					break;
				}
			}
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
		}

		[DebuggerHidden]
		public _003CAncestors_003Ed__4(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}
	}

	[CompilerGenerated]
	private sealed class _003CAncestorsAndSelf_003Ed__c : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public string name;

		public string _003C_003E3__name;

		public HtmlNode _003Cn_003E5__d;

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
			int num = 0;
			_003CAncestorsAndSelf_003Ed__c _003CAncestorsAndSelf_003Ed__c = default(_003CAncestorsAndSelf_003Ed__c);
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
				case 1:
					_003C_003E1__state = 0;
					_003CAncestorsAndSelf_003Ed__c = this;
					num = 3;
					break;
				case 5:
					num = 4;
					break;
				case 4:
					if (_003C_003E1__state == -2)
					{
						num = 1;
						break;
					}
					goto IL_004c;
				case 2:
				case 3:
					{
						_003CAncestorsAndSelf_003Ed__c.name = _003C_003E3__name;
						return _003CAncestorsAndSelf_003Ed__c;
					}
					IL_004c:
					_003CAncestorsAndSelf_003Ed__c = new _003CAncestorsAndSelf_003Ed__c(0)
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
			while (true)
			{
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
							num2 = 9;
							break;
						case 1:
							_003C_003E1__state = -1;
							if (true)
							{
							}
							num2 = 6;
							break;
						case 0:
							_003C_003E1__state = -1;
							_003Cn_003E5__d = _003C_003E4__this;
							num2 = 5;
							break;
						}
						continue;
					case 3:
						_003C_003E2__current = _003Cn_003E5__d;
						_003C_003E1__state = 1;
						return true;
					case 2:
					case 5:
						num2 = 8;
						continue;
					case 8:
						num2 = ((_003Cn_003E5__d != null) ? 1 : 7);
						continue;
					case 9:
						num2 = 4;
						continue;
					case 6:
						_003Cn_003E5__d = _003Cn_003E5__d.ParentNode;
						num2 = 2;
						continue;
					case 1:
						if (_003Cn_003E5__d.Name == name)
						{
							num2 = 3;
							continue;
						}
						goto case 6;
					case 4:
					case 7:
						return false;
					}
					break;
				}
			}
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
		}

		[DebuggerHidden]
		public _003CAncestorsAndSelf_003Ed__c(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}
	}

	[CompilerGenerated]
	private sealed class _003CDescendantNodes_003Ed__10 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public HtmlNode _003Cnode_003E5__11;

		public HtmlNode _003Cdescendant_003E5__12;

		public IEnumerator<HtmlNode> _003C_003E7__wrap13;

		public IEnumerator<HtmlNode> _003C_003E7__wrap15;

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
			int num = 0;
			_003CDescendantNodes_003Ed__10 result = default(_003CDescendantNodes_003Ed__10);
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
					num = 3;
					break;
				case 1:
					num = 4;
					break;
				case 4:
					if (_003C_003E1__state == -2)
					{
						num = 2;
						break;
					}
					goto IL_004c;
				case 3:
				case 5:
					{
						return result;
					}
					IL_004c:
					result = new _003CDescendantNodes_003Ed__10(0)
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
					IL_0044:
					int num = _003C_003E1__state;
					int num2 = 10;
					while (true)
					{
						switch (num2)
						{
						case 10:
							switch (num)
							{
							default:
								num2 = 8;
								continue;
							case 4:
								_003C_003E1__state = 3;
								num2 = 0;
								continue;
							case 0:
								_003C_003E1__state = -1;
								_003C_003E7__wrap13 = ((IEnumerable<HtmlNode>)_003C_003E4__this.ChildNodes).GetEnumerator();
								_003C_003E1__state = 1;
								num2 = 5;
								continue;
							case 2:
								_003C_003E1__state = 1;
								_003C_003E7__wrap15 = _003Cnode_003E5__11.DescendantNodes().GetEnumerator();
								_003C_003E1__state = 3;
								num2 = 11;
								continue;
							case 1:
							case 3:
								break;
							}
							goto case 4;
						case 2:
							_003C_003Em__Finally16();
							num2 = 6;
							continue;
						case 5:
						case 6:
							num2 = 13;
							continue;
						case 13:
							if (!_003C_003E7__wrap13.MoveNext())
							{
								num2 = 12;
								continue;
							}
							_003Cnode_003E5__11 = _003C_003E7__wrap13.Current;
							_003C_003E2__current = _003Cnode_003E5__11;
							_003C_003E1__state = 2;
							result = true;
							if (true)
							{
							}
							num2 = 14;
							continue;
						case 8:
							num2 = 4;
							continue;
						case 0:
						case 11:
							num2 = 1;
							continue;
						case 1:
							if (!_003C_003E7__wrap15.MoveNext())
							{
								num2 = 2;
								continue;
							}
							_003Cdescendant_003E5__12 = _003C_003E7__wrap15.Current;
							_003C_003E2__current = _003Cdescendant_003E5__12;
							_003C_003E1__state = 4;
							result = true;
							num2 = 3;
							continue;
						case 12:
							_003C_003Em__Finally14();
							num2 = 7;
							continue;
						case 14:
							goto end_IL_0002;
						case 3:
							goto end_IL_0002;
						case 4:
						case 7:
							result = false;
							num2 = 9;
							continue;
						case 9:
							goto end_IL_0002;
						}
						goto IL_0044;
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
			case 4:
				try
				{
					while (true)
					{
						IL_0039:
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
									num2 = 2;
									continue;
								case 3:
								case 4:
									break;
								}
								try
								{
								}
								finally
								{
									_003C_003Em__Finally16();
								}
								goto case 1;
							case 2:
								num2 = 1;
								continue;
							case 1:
								num2 = 0;
								continue;
							case 0:
								goto end_IL_0023;
							}
							goto IL_0039;
							continue;
							end_IL_0023:
							break;
						}
						break;
					}
				}
				finally
				{
					_003C_003Em__Finally14();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CDescendantNodes_003Ed__10(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally14()
		{
			_003C_003E1__state = -1;
			if (_003C_003E7__wrap13 != null)
			{
				_003C_003E7__wrap13.Dispose();
			}
		}

		private void _003C_003Em__Finally16()
		{
			_003C_003E1__state = 1;
			if (_003C_003E7__wrap15 != null)
			{
				_003C_003E7__wrap15.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CDescendants_003Ed__19 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public HtmlNode _003Cnode_003E5__1a;

		public IEnumerator<HtmlNode> _003C_003E7__wrap1b;

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
			int num = 5;
			_003CDescendants_003Ed__19 result = default(_003CDescendants_003Ed__19);
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
				case 0:
					_003C_003E1__state = 0;
					result = this;
					num = 1;
					break;
				case 4:
					num = 3;
					break;
				case 3:
					if (_003C_003E1__state == -2)
					{
						num = 0;
						break;
					}
					goto IL_004c;
				case 1:
				case 2:
					{
						return result;
					}
					IL_004c:
					result = new _003CDescendants_003Ed__19(0)
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
					IL_0030:
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
								num2 = 7;
								continue;
							case 0:
								_003C_003E1__state = -1;
								_003C_003E7__wrap1b = _003C_003E4__this.DescendantNodes().GetEnumerator();
								_003C_003E1__state = 1;
								num2 = 4;
								continue;
							case 2:
								if (true)
								{
								}
								_003C_003E1__state = 1;
								num2 = 6;
								continue;
							case 1:
								break;
							}
							goto case 2;
						case 4:
						case 6:
							num2 = 9;
							continue;
						case 9:
							if (!_003C_003E7__wrap1b.MoveNext())
							{
								num2 = 0;
								continue;
							}
							_003Cnode_003E5__1a = _003C_003E7__wrap1b.Current;
							_003C_003E2__current = _003Cnode_003E5__1a;
							_003C_003E1__state = 2;
							result = true;
							num2 = 5;
							continue;
						case 5:
							goto end_IL_0002;
						case 7:
							num2 = 2;
							continue;
						case 0:
							_003C_003Em__Finally1c();
							num2 = 8;
							continue;
						case 2:
						case 8:
							result = false;
							num2 = 3;
							continue;
						case 3:
							goto end_IL_0002;
						}
						goto IL_0030;
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
				try
				{
				}
				finally
				{
					_003C_003Em__Finally1c();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CDescendants_003Ed__19(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally1c()
		{
			_003C_003E1__state = -1;
			if (_003C_003E7__wrap1b != null)
			{
				_003C_003E7__wrap1b.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CDescendants_003Ed__1f : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public string name;

		public string _003C_003E3__name;

		public HtmlNode _003Cnode_003E5__20;

		public IEnumerator<HtmlNode> _003C_003E7__wrap21;

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
			int num = 0;
			_003CDescendants_003Ed__1f _003CDescendants_003Ed__1f = default(_003CDescendants_003Ed__1f);
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
				case 4:
					_003C_003E1__state = 0;
					_003CDescendants_003Ed__1f = this;
					num = 2;
					break;
				case 5:
					num = 1;
					break;
				case 1:
					if (_003C_003E1__state == -2)
					{
						num = 4;
						break;
					}
					goto IL_004c;
				case 2:
				case 3:
					{
						_003CDescendants_003Ed__1f.name = _003C_003E3__name;
						return _003CDescendants_003Ed__1f;
					}
					IL_004c:
					_003CDescendants_003Ed__1f = new _003CDescendants_003Ed__1f(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 3;
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
					IL_0038:
					int num = _003C_003E1__state;
					int num2 = 9;
					while (true)
					{
						switch (num2)
						{
						case 9:
							switch (num)
							{
							default:
								num2 = 10;
								continue;
							case 2:
								_003C_003E1__state = 1;
								num2 = 11;
								continue;
							case 0:
								_003C_003E1__state = -1;
								_003C_003E7__wrap21 = _003C_003E4__this.Descendants().GetEnumerator();
								_003C_003E1__state = 1;
								num2 = 8;
								continue;
							case 1:
								break;
							}
							goto case 5;
						case 0:
							_003C_003E2__current = _003Cnode_003E5__20;
							_003C_003E1__state = 2;
							result = true;
							num2 = 3;
							continue;
						case 3:
							goto end_IL_0002;
						case 6:
							_003C_003Em__Finally22();
							num2 = 7;
							continue;
						case 10:
							num2 = 5;
							continue;
						case 8:
						case 11:
							num2 = 1;
							continue;
						case 1:
							if (!_003C_003E7__wrap21.MoveNext())
							{
								num2 = 6;
								continue;
							}
							_003Cnode_003E5__20 = _003C_003E7__wrap21.Current;
							if (true)
							{
							}
							num2 = 4;
							continue;
						case 4:
							if (_003Cnode_003E5__20.Name == name)
							{
								num2 = 0;
								continue;
							}
							goto case 8;
						case 5:
						case 7:
							result = false;
							num2 = 2;
							continue;
						case 2:
							goto end_IL_0002;
						}
						goto IL_0038;
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
				try
				{
				}
				finally
				{
					_003C_003Em__Finally22();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CDescendants_003Ed__1f(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally22()
		{
			_003C_003E1__state = -1;
			if (_003C_003E7__wrap21 != null)
			{
				_003C_003E7__wrap21.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CDescendantsAndSelf_003Ed__25 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public HtmlNode _003Cn_003E5__26;

		public HtmlNode _003Cel_003E5__27;

		public IEnumerator<HtmlNode> _003C_003E7__wrap28;

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
			_003CDescendantsAndSelf_003Ed__25 result = default(_003CDescendantsAndSelf_003Ed__25);
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
				case 2:
					_003C_003E1__state = 0;
					result = this;
					num = 1;
					break;
				case 4:
					num = 5;
					break;
				case 5:
					if (_003C_003E1__state == -2)
					{
						num = 2;
						break;
					}
					goto IL_004c;
				case 0:
				case 1:
					{
						return result;
					}
					IL_004c:
					result = new _003CDescendantsAndSelf_003Ed__25(0)
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
					IL_003c:
					int num = _003C_003E1__state;
					int num2 = 7;
					while (true)
					{
						switch (num2)
						{
						case 7:
							switch (num)
							{
							default:
								num2 = 9;
								continue;
							case 3:
								_003C_003E1__state = 2;
								num2 = 8;
								continue;
							case 0:
								_003C_003E1__state = -1;
								_003C_003E2__current = _003C_003E4__this;
								_003C_003E1__state = 1;
								result = true;
								num2 = 0;
								continue;
							case 1:
								_003C_003E1__state = -1;
								_003C_003E7__wrap28 = _003C_003E4__this.DescendantNodes().GetEnumerator();
								_003C_003E1__state = 2;
								num2 = 6;
								continue;
							case 2:
								break;
							}
							goto case 4;
						case 2:
							goto end_IL_0002;
						case 0:
							goto end_IL_0002;
						case 5:
							_003C_003Em__Finally29();
							num2 = 4;
							continue;
						case 9:
							num2 = 12;
							continue;
						case 6:
						case 8:
							num2 = 3;
							continue;
						case 3:
							if (!_003C_003E7__wrap28.MoveNext())
							{
								num2 = 5;
								continue;
							}
							_003Cn_003E5__26 = _003C_003E7__wrap28.Current;
							_003Cel_003E5__27 = _003Cn_003E5__26;
							num2 = 10;
							continue;
						case 10:
							if (_003Cel_003E5__27 != null)
							{
								num2 = 11;
								continue;
							}
							goto case 6;
						case 11:
							if (true)
							{
							}
							_003C_003E2__current = _003Cel_003E5__27;
							_003C_003E1__state = 3;
							result = true;
							num2 = 2;
							continue;
						case 4:
						case 12:
							result = false;
							num2 = 1;
							continue;
						case 1:
							goto end_IL_0002;
						}
						goto IL_003c;
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
			case 2:
			case 3:
				try
				{
				}
				finally
				{
					_003C_003Em__Finally29();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CDescendantsAndSelf_003Ed__25(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally29()
		{
			_003C_003E1__state = -1;
			if (_003C_003E7__wrap28 != null)
			{
				_003C_003E7__wrap28.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CDescendantsAndSelf_003Ed__2c : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public string name;

		public string _003C_003E3__name;

		public HtmlNode _003Cnode_003E5__2d;

		public IEnumerator<HtmlNode> _003C_003E7__wrap2e;

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
			_003CDescendantsAndSelf_003Ed__2c _003CDescendantsAndSelf_003Ed__2c = default(_003CDescendantsAndSelf_003Ed__2c);
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
					_003CDescendantsAndSelf_003Ed__2c = this;
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
						_003CDescendantsAndSelf_003Ed__2c.name = _003C_003E3__name;
						return _003CDescendantsAndSelf_003Ed__2c;
					}
					IL_004c:
					_003CDescendantsAndSelf_003Ed__2c = new _003CDescendantsAndSelf_003Ed__2c(0)
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
					IL_003c:
					int num = _003C_003E1__state;
					int num2 = 10;
					while (true)
					{
						switch (num2)
						{
						case 10:
							switch (num)
							{
							default:
								num2 = 5;
								continue;
							case 3:
								_003C_003E1__state = 2;
								num2 = 6;
								continue;
							case 0:
								_003C_003E1__state = -1;
								_003C_003E2__current = _003C_003E4__this;
								_003C_003E1__state = 1;
								result = true;
								num2 = 12;
								continue;
							case 1:
								_003C_003E1__state = -1;
								_003C_003E7__wrap2e = _003C_003E4__this.Descendants().GetEnumerator();
								_003C_003E1__state = 2;
								num2 = 1;
								continue;
							case 2:
								break;
							}
							goto case 0;
						case 9:
							goto end_IL_0002;
						case 12:
							goto end_IL_0002;
						case 8:
							_003C_003Em__Finally2f();
							num2 = 3;
							continue;
						case 5:
							num2 = 0;
							continue;
						case 1:
						case 6:
							num2 = 7;
							continue;
						case 7:
							if (!_003C_003E7__wrap2e.MoveNext())
							{
								num2 = 8;
								continue;
							}
							_003Cnode_003E5__2d = _003C_003E7__wrap2e.Current;
							num2 = 4;
							continue;
						case 4:
							if (_003Cnode_003E5__2d.Name == name)
							{
								num2 = 2;
								continue;
							}
							goto case 1;
						case 2:
							if (true)
							{
							}
							_003C_003E2__current = _003Cnode_003E5__2d;
							_003C_003E1__state = 3;
							result = true;
							num2 = 9;
							continue;
						case 0:
						case 3:
							result = false;
							num2 = 11;
							continue;
						case 11:
							goto end_IL_0002;
						}
						goto IL_003c;
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
			case 2:
			case 3:
				try
				{
				}
				finally
				{
					_003C_003Em__Finally2f();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CDescendantsAndSelf_003Ed__2c(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally2f()
		{
			_003C_003E1__state = -1;
			if (_003C_003E7__wrap2e != null)
			{
				_003C_003E7__wrap2e.Dispose();
			}
		}
	}

	[CompilerGenerated]
	private sealed class _003CElements_003Ed__32 : IEnumerable<HtmlNode>, IEnumerable, IEnumerator<HtmlNode>, IEnumerator, IDisposable
	{
		private HtmlNode _003C_003E2__current;

		private int _003C_003E1__state;

		private int _003C_003El__initialThreadId;

		public HtmlNode _003C_003E4__this;

		public string name;

		public string _003C_003E3__name;

		public HtmlNode _003Cnode_003E5__33;

		public IEnumerator<HtmlNode> _003C_003E7__wrap34;

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
			_003CElements_003Ed__32 _003CElements_003Ed__ = default(_003CElements_003Ed__32);
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
				case 5:
					_003C_003E1__state = 0;
					_003CElements_003Ed__ = this;
					num = 2;
					break;
				case 0:
					num = 1;
					break;
				case 1:
					if (_003C_003E1__state == -2)
					{
						num = 5;
						break;
					}
					goto IL_004c;
				case 2:
				case 4:
					{
						_003CElements_003Ed__.name = _003C_003E3__name;
						return _003CElements_003Ed__;
					}
					IL_004c:
					_003CElements_003Ed__ = new _003CElements_003Ed__32(0)
					{
						_003C_003E4__this = _003C_003E4__this
					};
					num = 4;
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
					IL_0038:
					int num = _003C_003E1__state;
					int num2 = 4;
					while (true)
					{
						switch (num2)
						{
						case 4:
							switch (num)
							{
							default:
								num2 = 8;
								continue;
							case 2:
								_003C_003E1__state = 1;
								num2 = 10;
								continue;
							case 0:
								_003C_003E1__state = -1;
								_003C_003E7__wrap34 = ((IEnumerable<HtmlNode>)_003C_003E4__this.ChildNodes).GetEnumerator();
								_003C_003E1__state = 1;
								num2 = 9;
								continue;
							case 1:
								break;
							}
							goto case 0;
						case 6:
							_003C_003E2__current = _003Cnode_003E5__33;
							_003C_003E1__state = 2;
							result = true;
							num2 = 3;
							continue;
						case 3:
							goto end_IL_0002;
						case 5:
							_003C_003Em__Finally35();
							num2 = 2;
							continue;
						case 8:
							num2 = 0;
							continue;
						case 9:
						case 10:
							num2 = 7;
							continue;
						case 7:
							if (!_003C_003E7__wrap34.MoveNext())
							{
								num2 = 5;
								continue;
							}
							_003Cnode_003E5__33 = _003C_003E7__wrap34.Current;
							if (true)
							{
							}
							num2 = 11;
							continue;
						case 11:
							if (_003Cnode_003E5__33.Name == name)
							{
								num2 = 6;
								continue;
							}
							goto case 9;
						case 0:
						case 2:
							result = false;
							num2 = 1;
							continue;
						case 1:
							goto end_IL_0002;
						}
						goto IL_0038;
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
				try
				{
				}
				finally
				{
					_003C_003Em__Finally35();
				}
				if (1 == 0)
				{
				}
				break;
			}
		}

		[DebuggerHidden]
		public _003CElements_003Ed__32(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
			_003C_003El__initialThreadId = Thread.CurrentThread.ManagedThreadId;
		}

		private void _003C_003Em__Finally35()
		{
			_003C_003E1__state = -1;
			if (_003C_003E7__wrap34 != null)
			{
				_003C_003E7__wrap34.Dispose();
			}
		}
	}

	internal HtmlAttributeCollection _attributes;

	internal HtmlNodeCollection _childnodes;

	internal HtmlNode _endnode;

	internal bool _innerchanged;

	internal string _innerhtml;

	internal int _innerlength;

	internal int _innerstartindex;

	internal int _line;

	internal int _lineposition;

	private string _name;

	internal int _namelength;

	internal int _namestartindex;

	internal HtmlNode _nextnode;

	internal HtmlNodeType _nodetype;

	internal bool _outerchanged;

	internal string _outerhtml;

	internal int _outerlength;

	internal int _outerstartindex;

	internal HtmlDocument _ownerdocument;

	internal HtmlNode _parentnode;

	internal HtmlNode _prevnode;

	internal HtmlNode _prevwithsamename;

	internal bool _starttag;

	internal int _streamposition;

	public static readonly string HtmlNodeTypeNameComment;

	public static readonly string HtmlNodeTypeNameDocument;

	public static readonly string HtmlNodeTypeNameText;

	public static Dictionary<string, HtmlElementFlag> ElementsFlags;

	public HtmlAttributeCollection Attributes
	{
		get
		{
			if (!HasAttributes)
			{
				_attributes = new HtmlAttributeCollection(this);
			}
			return _attributes;
		}
		internal set
		{
			_attributes = value;
		}
	}

	public HtmlNodeCollection ChildNodes
	{
		get
		{
			if (true)
			{
			}
			return _childnodes ?? (_childnodes = new HtmlNodeCollection(this));
		}
		internal set
		{
			_childnodes = value;
		}
	}

	public bool Closed => _endnode != null;

	public HtmlAttributeCollection ClosingAttributes
	{
		get
		{
			if (HasClosingAttributes)
			{
				return _endnode.Attributes;
			}
			return new HtmlAttributeCollection(this);
		}
	}

	internal HtmlNode EndNode => _endnode;

	public HtmlNode FirstChild
	{
		get
		{
			if (HasChildNodes)
			{
				return _childnodes[0];
			}
			return null;
		}
	}

	public bool HasAttributes
	{
		get
		{
			int num = 2;
			while (true)
			{
				switch (num)
				{
				default:
					num = ((_attributes == null) ? 1 : 0);
					break;
				case 0:
					if (_attributes.Count <= 0)
					{
						num = 3;
						break;
					}
					return true;
				case 3:
					if (true)
					{
					}
					return false;
				case 1:
					return false;
				}
			}
		}
	}

	public bool HasChildNodes
	{
		get
		{
			int num = 0;
			while (true)
			{
				switch (num)
				{
				default:
					num = ((_childnodes == null) ? 1 : 2);
					break;
				case 2:
					if (_childnodes.Count <= 0)
					{
						num = 3;
						break;
					}
					return true;
				case 3:
					if (true)
					{
					}
					return false;
				case 1:
					return false;
				}
			}
		}
	}

	public bool HasClosingAttributes
	{
		get
		{
			int num = 1;
			while (true)
			{
				switch (num)
				{
				default:
					if (_endnode != null)
					{
						num = 3;
						break;
					}
					goto case 7;
				case 2:
					if (_endnode._attributes.Count <= 0)
					{
						num = 5;
						break;
					}
					return true;
				case 4:
					num = ((_endnode._attributes != null) ? 2 : 0);
					break;
				case 3:
					if (true)
					{
					}
					num = 6;
					break;
				case 6:
					num = ((_endnode == this) ? 7 : 4);
					break;
				case 5:
					return false;
				case 7:
					return false;
				case 0:
					return false;
				}
			}
		}
	}

	public string Id
	{
		get
		{
			if (_ownerdocument.Nodesid == null)
			{
				throw new Exception(HtmlDocument.HtmlExceptionUseIdAttributeFalse);
			}
			return GetId();
		}
		set
		{
			int num = 2;
			while (true)
			{
				switch (num)
				{
				default:
					if (true)
					{
					}
					num = ((_ownerdocument.Nodesid == null) ? 1 : 0);
					break;
				case 3:
					throw new ArgumentNullException("value");
				case 0:
					if (value == null)
					{
						num = 3;
						break;
					}
					SetId(value);
					return;
				case 1:
					throw new Exception(HtmlDocument.HtmlExceptionUseIdAttributeFalse);
				}
			}
		}
	}

	public virtual string InnerHtml
	{
		get
		{
			int num = 0;
			while (true)
			{
				switch (num)
				{
				case 3:
					if (_innerstartindex < 0)
					{
						num = 1;
						continue;
					}
					return _ownerdocument.Text.Substring(_innerstartindex, _innerlength);
				case 4:
					return _innerhtml;
				case 2:
					_innerhtml = WriteContentTo();
					_innerchanged = false;
					return _innerhtml;
				case 1:
					return string.Empty;
				case 5:
					num = ((_innerhtml != null) ? 4 : 3);
					continue;
				}
				if (_innerchanged)
				{
					if (true)
					{
					}
					num = 2;
				}
				else
				{
					num = 5;
				}
			}
		}
		set
		{
			if (true)
			{
			}
			HtmlDocument htmlDocument = new HtmlDocument();
			htmlDocument.LoadHtml(value);
			RemoveAllChildren();
			AppendChildren(htmlDocument.DocumentNode.ChildNodes);
		}
	}

	public virtual string InnerText
	{
		get
		{
			int num = 5;
			IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
			string text = default(string);
			while (true)
			{
				switch (num)
				{
				default:
					num = ((_nodetype == HtmlNodeType.Text) ? 4 : 0);
					break;
				case 4:
					if (true)
					{
					}
					return ((HtmlTextNode)this).Text;
				case 3:
					return string.Empty;
				case 0:
					num = ((_nodetype == HtmlNodeType.Comment) ? 1 : 2);
					break;
				case 6:
					try
					{
						num = 4;
						while (true)
						{
							switch (num)
							{
							default:
								num = 0;
								break;
							case 0:
								if (enumerator.MoveNext())
								{
									HtmlNode current = enumerator.Current;
									text += current.InnerText;
									num = 1;
								}
								else
								{
									num = 2;
								}
								break;
							case 2:
								num = 3;
								break;
							case 3:
								return text;
							}
						}
					}
					finally
					{
						num = 0;
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
				case 2:
					if (HasChildNodes)
					{
						text = null;
						enumerator = ((IEnumerable<HtmlNode>)ChildNodes).GetEnumerator();
						num = 6;
					}
					else
					{
						num = 3;
					}
					break;
				case 1:
					return ((HtmlCommentNode)this).Comment;
				}
			}
		}
	}

	public HtmlNode LastChild
	{
		get
		{
			if (HasChildNodes)
			{
				return _childnodes[_childnodes.Count - 1];
			}
			if (true)
			{
			}
			return null;
		}
	}

	public int Line
	{
		get
		{
			return _line;
		}
		internal set
		{
			_line = value;
		}
	}

	public int LinePosition
	{
		get
		{
			return _lineposition;
		}
		internal set
		{
			_lineposition = value;
		}
	}

	public string Name
	{
		get
		{
			int num = 1;
			while (true)
			{
				switch (num)
				{
				case 1:
					if (1 == 0)
					{
					}
					goto default;
				default:
					if (_name == null)
					{
						num = 0;
						break;
					}
					goto case 4;
				case 2:
					return string.Empty;
				case 4:
					num = 3;
					break;
				case 3:
					if (_name == null)
					{
						num = 2;
						break;
					}
					return _name.ToLower();
				case 0:
					Name = _ownerdocument.Text.Substring(_namestartindex, _namelength);
					num = 4;
					break;
				}
			}
		}
		set
		{
			_name = value;
		}
	}

	public HtmlNode NextSibling
	{
		get
		{
			return _nextnode;
		}
		internal set
		{
			_nextnode = value;
		}
	}

	public HtmlNodeType NodeType
	{
		get
		{
			return _nodetype;
		}
		internal set
		{
			_nodetype = value;
		}
	}

	public string OriginalName => _name;

	public virtual string OuterHtml
	{
		get
		{
			int num = 2;
			while (true)
			{
				switch (num)
				{
				default:
					num = ((!_outerchanged) ? 3 : 5);
					break;
				case 5:
					if (true)
					{
					}
					_outerhtml = WriteTo();
					_outerchanged = false;
					return _outerhtml;
				case 1:
					if (_outerstartindex < 0)
					{
						num = 4;
						break;
					}
					return _ownerdocument.Text.Substring(_outerstartindex, _outerlength);
				case 0:
					return _outerhtml;
				case 4:
					return string.Empty;
				case 3:
					num = ((_outerhtml == null) ? 1 : 0);
					break;
				}
			}
		}
	}

	public HtmlDocument OwnerDocument
	{
		get
		{
			return _ownerdocument;
		}
		internal set
		{
			_ownerdocument = value;
		}
	}

	public HtmlNode ParentNode
	{
		get
		{
			return _parentnode;
		}
		internal set
		{
			_parentnode = value;
		}
	}

	public HtmlNode PreviousSibling
	{
		get
		{
			return _prevnode;
		}
		internal set
		{
			_prevnode = value;
		}
	}

	public int StreamPosition => _streamposition;

	public string XPath
	{
		get
		{
			int num = 3;
			object obj;
			while (true)
			{
				switch (num)
				{
				default:
					if (true)
					{
					}
					if (ParentNode != null)
					{
						num = 0;
						continue;
					}
					goto IL_0042;
				case 1:
					obj = "/";
					break;
				case 4:
					num = 5;
					continue;
				case 5:
					obj = ParentNode.XPath + "/";
					break;
				case 0:
					num = 2;
					continue;
				case 2:
					{
						if (ParentNode.NodeType != HtmlNodeType.Document)
						{
							num = 4;
							continue;
						}
						goto IL_0042;
					}
					IL_0042:
					num = 1;
					continue;
				}
				break;
			}
			string text = (string)obj;
			return text + GetRelativeXpath();
		}
	}

	static HtmlNode()
	{
		if (true)
		{
		}
		HtmlNodeTypeNameComment = "#comment";
		HtmlNodeTypeNameDocument = "#document";
		HtmlNodeTypeNameText = "#text";
		ElementsFlags = new Dictionary<string, HtmlElementFlag>();
		ElementsFlags.Add("script", HtmlElementFlag.CData);
		ElementsFlags.Add("style", HtmlElementFlag.CData);
		ElementsFlags.Add("noxhtml", HtmlElementFlag.CData);
		ElementsFlags.Add("base", HtmlElementFlag.Empty);
		ElementsFlags.Add("link", HtmlElementFlag.Empty);
		ElementsFlags.Add("meta", HtmlElementFlag.Empty);
		ElementsFlags.Add("isindex", HtmlElementFlag.Empty);
		ElementsFlags.Add("hr", HtmlElementFlag.Empty);
		ElementsFlags.Add("col", HtmlElementFlag.Empty);
		ElementsFlags.Add("img", HtmlElementFlag.Empty);
		ElementsFlags.Add("param", HtmlElementFlag.Empty);
		ElementsFlags.Add("embed", HtmlElementFlag.Empty);
		ElementsFlags.Add("frame", HtmlElementFlag.Empty);
		ElementsFlags.Add("wbr", HtmlElementFlag.Empty);
		ElementsFlags.Add("bgsound", HtmlElementFlag.Empty);
		ElementsFlags.Add("spacer", HtmlElementFlag.Empty);
		ElementsFlags.Add("keygen", HtmlElementFlag.Empty);
		ElementsFlags.Add("area", HtmlElementFlag.Empty);
		ElementsFlags.Add("input", HtmlElementFlag.Empty);
		ElementsFlags.Add("basefont", HtmlElementFlag.Empty);
		ElementsFlags.Add("form", HtmlElementFlag.Empty | HtmlElementFlag.CanOverlap);
		ElementsFlags.Add("option", HtmlElementFlag.Empty);
		ElementsFlags.Add("br", HtmlElementFlag.Empty | HtmlElementFlag.Closed);
		ElementsFlags.Add("p", HtmlElementFlag.Empty | HtmlElementFlag.Closed);
	}

	public HtmlNode(HtmlNodeType type, HtmlDocument ownerdocument, int index)
	{
		_nodetype = type;
		_ownerdocument = ownerdocument;
		_outerstartindex = index;
		switch (type)
		{
		case HtmlNodeType.Document:
			Name = HtmlNodeTypeNameDocument;
			_endnode = this;
			break;
		case HtmlNodeType.Comment:
			Name = HtmlNodeTypeNameComment;
			_endnode = this;
			break;
		case HtmlNodeType.Text:
			Name = HtmlNodeTypeNameText;
			_endnode = this;
			break;
		}
		if (_ownerdocument.Openednodes != null && !Closed && -1 != index)
		{
			_ownerdocument.Openednodes.Add(index, this);
		}
		if (-1 == index && type != HtmlNodeType.Comment && type != HtmlNodeType.Text)
		{
			_outerchanged = true;
			_innerchanged = true;
		}
	}

	public static bool CanOverlapElement(string name)
	{
		int num = 0;
		while (true)
		{
			switch (num)
			{
			default:
				if (true)
				{
				}
				num = ((name == null) ? 1 : 3);
				break;
			case 2:
				return false;
			case 3:
			{
				if (!ElementsFlags.ContainsKey(name.ToLower()))
				{
					num = 2;
					break;
				}
				HtmlElementFlag htmlElementFlag = ElementsFlags[name.ToLower()];
				return (htmlElementFlag & HtmlElementFlag.CanOverlap) != 0;
			}
			case 1:
				throw new ArgumentNullException("name");
			}
		}
	}

	public static HtmlNode CreateNode(string html)
	{
		HtmlDocument htmlDocument = new HtmlDocument();
		htmlDocument.LoadHtml(html);
		return htmlDocument.DocumentNode.FirstChild;
	}

	public static bool IsCDataElement(string name)
	{
		int num = 0;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((name != null) ? 1 : 2);
				break;
			case 2:
				if (true)
				{
				}
				throw new ArgumentNullException("name");
			case 3:
				return false;
			case 1:
			{
				if (!ElementsFlags.ContainsKey(name.ToLower()))
				{
					num = 3;
					break;
				}
				HtmlElementFlag htmlElementFlag = ElementsFlags[name.ToLower()];
				return (htmlElementFlag & HtmlElementFlag.CData) != 0;
			}
			}
		}
	}

	public static bool IsClosedElement(string name)
	{
		if (true)
		{
		}
		int num = 2;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((name != null) ? 1 : 3);
				break;
			case 0:
				return false;
			case 1:
			{
				if (!ElementsFlags.ContainsKey(name.ToLower()))
				{
					num = 0;
					break;
				}
				HtmlElementFlag htmlElementFlag = ElementsFlags[name.ToLower()];
				return (htmlElementFlag & HtmlElementFlag.Closed) != 0;
			}
			case 3:
				throw new ArgumentNullException("name");
			}
		}
	}

	public static bool IsEmptyElement(string name)
	{
		int num = 9;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((name == null) ? 6 : 0);
				break;
			case 3:
				return true;
			case 7:
				return true;
			case 0:
				if (name.Length == 0)
				{
					num = 2;
					break;
				}
				if (true)
				{
				}
				num = 1;
				break;
			case 8:
			{
				if (!ElementsFlags.ContainsKey(name.ToLower()))
				{
					num = 5;
					break;
				}
				HtmlElementFlag htmlElementFlag = ElementsFlags[name.ToLower()];
				return (htmlElementFlag & HtmlElementFlag.Empty) != 0;
			}
			case 6:
				throw new ArgumentNullException("name");
			case 4:
				num = (('?' == name[0]) ? 3 : 8);
				break;
			case 5:
				return false;
			case 1:
				num = (('!' == name[0]) ? 7 : 4);
				break;
			case 2:
				return true;
			}
		}
	}

	public static bool IsOverlappedClosingElement(string text)
	{
		int num = 4;
		while (true)
		{
			switch (num)
			{
			default:
				num = ((text != null) ? 1 : 6);
				break;
			case 8:
				num = 2;
				break;
			case 2:
				if (text[text.Length - 1] == '>')
				{
					if (true)
					{
					}
					num = 7;
					break;
				}
				goto case 9;
			case 3:
				if (text[0] == '<')
				{
					num = 8;
					break;
				}
				goto case 9;
			case 1:
				num = ((text.Length > 4) ? 3 : 0);
				break;
			case 9:
				return false;
			case 6:
				throw new ArgumentNullException("text");
			case 7:
				num = 5;
				break;
			case 5:
			{
				if (text[1] != '/')
				{
					num = 9;
					break;
				}
				string name = text.Substring(2, text.Length - 3);
				return CanOverlapElement(name);
			}
			case 0:
				return false;
			}
		}
	}

	public IEnumerable<HtmlNode> Ancestors()
	{
		int num2 = default(int);
		HtmlNode node = default(HtmlNode);
		while (true)
		{
			int num = num2;
			int num3 = 1;
			while (true)
			{
				switch (num3)
				{
				case 1:
					switch (num)
					{
					default:
						num3 = 5;
						break;
					case 1:
						node = node.ParentNode;
						num3 = 3;
						break;
					case 0:
						node = ParentNode;
						num3 = 4;
						break;
					}
					continue;
				case 5:
					if (true)
					{
					}
					num3 = 6;
					continue;
				case 0:
				case 6:
					yield break;
				case 3:
				case 4:
					num3 = 2;
					continue;
				case 2:
					if (node.ParentNode != null)
					{
						yield return node.ParentNode;
						break;
					}
					num3 = 0;
					continue;
				}
				break;
			}
		}
	}

	public IEnumerable<HtmlNode> Ancestors(string name)
	{
		if (true)
		{
		}
		_003CAncestors_003Ed__4 _003CAncestors_003Ed__ = new _003CAncestors_003Ed__4(-2);
		_003CAncestors_003Ed__._003C_003E4__this = this;
		_003CAncestors_003Ed__._003C_003E3__name = name;
		return _003CAncestors_003Ed__;
	}

	public IEnumerable<HtmlNode> AncestorsAndSelf()
	{
		int num2 = default(int);
		HtmlNode n = default(HtmlNode);
		while (true)
		{
			int num = num2;
			int num3 = 3;
			while (true)
			{
				switch (num3)
				{
				case 3:
					switch (num)
					{
					default:
						num3 = 5;
						break;
					case 1:
						n = n.ParentNode;
						num3 = 2;
						break;
					case 0:
						n = this;
						num3 = 0;
						break;
					}
					continue;
				case 5:
					if (true)
					{
					}
					num3 = 1;
					continue;
				case 1:
				case 4:
					yield break;
				case 0:
				case 2:
					num3 = 6;
					continue;
				case 6:
					if (n != null)
					{
						yield return n;
						break;
					}
					num3 = 4;
					continue;
				}
				break;
			}
		}
	}

	public IEnumerable<HtmlNode> AncestorsAndSelf(string name)
	{
		if (true)
		{
		}
		_003CAncestorsAndSelf_003Ed__c _003CAncestorsAndSelf_003Ed__c = new _003CAncestorsAndSelf_003Ed__c(-2);
		_003CAncestorsAndSelf_003Ed__c._003C_003E4__this = this;
		_003CAncestorsAndSelf_003Ed__c._003C_003E3__name = name;
		return _003CAncestorsAndSelf_003Ed__c;
	}

	public HtmlNode AppendChild(HtmlNode newChild)
	{
		if (newChild == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("newChild");
		}
		ChildNodes.Append(newChild);
		_ownerdocument.SetIdForNode(newChild, newChild.GetId());
		_outerchanged = true;
		_innerchanged = true;
		return newChild;
	}

	public void AppendChildren(HtmlNodeCollection newChildren)
	{
		int num = 1;
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		while (true)
		{
			switch (num)
			{
			default:
				if (newChildren == null)
				{
					num = 2;
					break;
				}
				enumerator = ((IEnumerable<HtmlNode>)newChildren).GetEnumerator();
				num = 0;
				break;
			case 0:
				if (true)
				{
				}
				try
				{
					num = 1;
					while (true)
					{
						switch (num)
						{
						default:
							num = 3;
							break;
						case 3:
							if (enumerator.MoveNext())
							{
								HtmlNode current = enumerator.Current;
								AppendChild(current);
								num = 0;
							}
							else
							{
								num = 4;
							}
							break;
						case 4:
							num = 2;
							break;
						case 2:
							return;
						}
					}
				}
				finally
				{
					num = 0;
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
			case 2:
				throw new ArgumentNullException("newChildren");
			}
		}
	}

	public IEnumerable<HtmlAttribute> ChildAttributes(string name)
	{
		return Attributes.AttributesWithName(name);
	}

	public HtmlNode Clone()
	{
		return CloneNode(deep: true);
	}

	public HtmlNode CloneNode(string newName)
	{
		return CloneNode(newName, deep: true);
	}

	public HtmlNode CloneNode(string newName, bool deep)
	{
		if (true)
		{
		}
		if (newName == null)
		{
			throw new ArgumentNullException("newName");
		}
		HtmlNode htmlNode = CloneNode(deep);
		htmlNode.Name = newName;
		return htmlNode;
	}

	public HtmlNode CloneNode(bool deep)
	{
		switch (0)
		{
		}
		IEnumerator<HtmlAttribute> enumerator2 = default(IEnumerator<HtmlAttribute>);
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		IEnumerator<HtmlAttribute> enumerator3 = default(IEnumerator<HtmlAttribute>);
		while (true)
		{
			HtmlNode htmlNode = _ownerdocument.CreateNode(_nodetype);
			htmlNode.Name = Name;
			HtmlNodeType nodetype = _nodetype;
			int num = 4;
			while (true)
			{
				switch (num)
				{
				case 4:
					switch (nodetype)
					{
					default:
						num = 10;
						break;
					case HtmlNodeType.Comment:
						((HtmlCommentNode)htmlNode).Comment = ((HtmlCommentNode)this).Comment;
						return htmlNode;
					case HtmlNodeType.Text:
						((HtmlTextNode)htmlNode).Text = ((HtmlTextNode)this).Text;
						return htmlNode;
					}
					continue;
				case 0:
					return htmlNode;
				case 7:
					try
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								num = 3;
								continue;
							case 3:
								if (enumerator2.MoveNext())
								{
									HtmlAttribute current = enumerator2.Current;
									HtmlAttribute newAttribute = current.Clone();
									htmlNode._endnode._attributes.Append(newAttribute);
									num = 1;
								}
								else
								{
									num = 4;
								}
								continue;
							case 4:
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
					finally
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator2 != null)
								{
									num = 0;
									continue;
								}
								break;
							case 0:
								enumerator2.Dispose();
								num = 1;
								continue;
							case 1:
								break;
							}
							break;
						}
					}
					goto IL_01be;
				case 6:
					num = 3;
					continue;
				case 3:
					if (HasAttributes)
					{
						num = 9;
						continue;
					}
					goto IL_03d4;
				case 13:
					num = (deep ? 5 : 0);
					continue;
				case 8:
					try
					{
						num = 0;
						while (true)
						{
							switch (num)
							{
							default:
								num = 4;
								break;
							case 4:
							{
								if (!enumerator.MoveNext())
								{
									num = 1;
									break;
								}
								HtmlNode current3 = enumerator.Current;
								HtmlNode newChild = current3.Clone();
								htmlNode.AppendChild(newChild);
								num = 2;
								break;
							}
							case 1:
								num = 3;
								break;
							case 3:
								return htmlNode;
							}
						}
					}
					finally
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator != null)
								{
									num = 1;
									continue;
								}
								break;
							case 1:
								enumerator.Dispose();
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
				case 1:
					htmlNode._endnode = _endnode.CloneNode(deep: false);
					enumerator2 = ((IEnumerable<HtmlAttribute>)_endnode._attributes).GetEnumerator();
					num = 7;
					continue;
				case 9:
					enumerator3 = ((IEnumerable<HtmlAttribute>)_attributes).GetEnumerator();
					num = 2;
					continue;
				case 11:
					return htmlNode;
				case 10:
					num = 6;
					continue;
				case 2:
					try
					{
						num = 0;
						while (true)
						{
							switch (num)
							{
							default:
								num = 2;
								continue;
							case 2:
								if (enumerator3.MoveNext())
								{
									HtmlAttribute current2 = enumerator3.Current;
									HtmlAttribute newAttribute2 = current2.Clone();
									htmlNode.Attributes.Append(newAttribute2);
									num = 4;
								}
								else
								{
									num = 3;
								}
								continue;
							case 3:
								num = 1;
								continue;
							case 1:
								if (1 == 0)
								{
								}
								break;
							}
							break;
						}
					}
					finally
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator3 != null)
								{
									num = 0;
									continue;
								}
								break;
							case 0:
								enumerator3.Dispose();
								num = 1;
								continue;
							case 1:
								break;
							}
							break;
						}
					}
					goto IL_03d4;
				case 12:
					if (HasClosingAttributes)
					{
						num = 1;
						continue;
					}
					goto IL_01be;
				case 5:
					{
						if (HasChildNodes)
						{
							enumerator = ((IEnumerable<HtmlNode>)_childnodes).GetEnumerator();
							num = 8;
						}
						else
						{
							num = 11;
						}
						continue;
					}
					IL_03d4:
					num = 12;
					continue;
					IL_01be:
					num = 13;
					continue;
				}
				break;
			}
		}
	}

	public void CopyFrom(HtmlNode node)
	{
		CopyFrom(node, deep: true);
	}

	public void CopyFrom(HtmlNode node, bool deep)
	{
		switch (0)
		{
		default:
		{
			int num = 6;
			IEnumerator<HtmlNode> enumerator2 = default(IEnumerator<HtmlNode>);
			IEnumerator<HtmlAttribute> enumerator = default(IEnumerator<HtmlAttribute>);
			while (true)
			{
				switch (num)
				{
				default:
					if (node == null)
					{
						num = 4;
						break;
					}
					Attributes.RemoveAll();
					num = 1;
					break;
				case 5:
					enumerator2 = ((IEnumerable<HtmlNode>)node.ChildNodes).GetEnumerator();
					num = 3;
					break;
				case 7:
					if (!deep)
					{
						num = 8;
						break;
					}
					return;
				case 1:
					if (node.HasAttributes)
					{
						num = 2;
						break;
					}
					goto IL_0070;
				case 3:
					try
					{
						num = 0;
						while (true)
						{
							switch (num)
							{
							default:
								num = 4;
								break;
							case 4:
							{
								if (!enumerator2.MoveNext())
								{
									num = 1;
									break;
								}
								HtmlNode current2 = enumerator2.Current;
								AppendChild(current2.CloneNode(deep: true));
								num = 3;
								break;
							}
							case 1:
								num = 2;
								break;
							case 2:
								return;
							}
						}
					}
					finally
					{
						num = 1;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator2 != null)
								{
									num = 0;
									continue;
								}
								break;
							case 0:
								enumerator2.Dispose();
								num = 2;
								continue;
							case 2:
								break;
							}
							break;
						}
					}
				case 4:
					throw new ArgumentNullException("node");
				case 8:
					RemoveAllChildren();
					num = 0;
					break;
				case 0:
					if (node.HasChildNodes)
					{
						num = 5;
						break;
					}
					return;
				case 9:
					try
					{
						num = 1;
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
									HtmlAttribute current = enumerator.Current;
									SetAttributeValue(current.Name, current.Value);
									num = 4;
								}
								else
								{
									num = 3;
								}
								continue;
							case 3:
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
					finally
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								if (true)
								{
								}
								if (enumerator != null)
								{
									num = 0;
									continue;
								}
								break;
							case 0:
								enumerator.Dispose();
								num = 1;
								continue;
							case 1:
								break;
							}
							break;
						}
					}
					goto IL_0070;
				case 2:
					{
						enumerator = ((IEnumerable<HtmlAttribute>)node.Attributes).GetEnumerator();
						num = 9;
						break;
					}
					IL_0070:
					num = 7;
					break;
				}
			}
		}
		}
	}

	public IEnumerable<HtmlNode> DescendantNodes()
	{
		//yield-return decompiler failed: Unexpected instruction in Iterator.Dispose()
		_003CDescendantNodes_003Ed__10 _003CDescendantNodes_003Ed__ = new _003CDescendantNodes_003Ed__10(-2);
		_003CDescendantNodes_003Ed__._003C_003E4__this = this;
		return _003CDescendantNodes_003Ed__;
	}

	public IEnumerable<HtmlNode> DescendantNodesAndSelf()
	{
		return DescendantsAndSelf();
	}

	public IEnumerable<HtmlNode> Descendants()
	{
		//yield-return decompiler failed: Unexpected instruction in Iterator.Dispose()
		_003CDescendants_003Ed__19 _003CDescendants_003Ed__ = new _003CDescendants_003Ed__19(-2);
		_003CDescendants_003Ed__._003C_003E4__this = this;
		return _003CDescendants_003Ed__;
	}

	public IEnumerable<HtmlNode> Descendants(string name)
	{
		if (true)
		{
		}
		_003CDescendants_003Ed__1f _003CDescendants_003Ed__1f = new _003CDescendants_003Ed__1f(-2);
		_003CDescendants_003Ed__1f._003C_003E4__this = this;
		_003CDescendants_003Ed__1f._003C_003E3__name = name;
		return _003CDescendants_003Ed__1f;
	}

	public IEnumerable<HtmlNode> DescendantsAndSelf()
	{
		//yield-return decompiler failed: Unexpected instruction in Iterator.Dispose()
		_003CDescendantsAndSelf_003Ed__25 _003CDescendantsAndSelf_003Ed__ = new _003CDescendantsAndSelf_003Ed__25(-2);
		_003CDescendantsAndSelf_003Ed__._003C_003E4__this = this;
		return _003CDescendantsAndSelf_003Ed__;
	}

	public IEnumerable<HtmlNode> DescendantsAndSelf(string name)
	{
		if (true)
		{
		}
		_003CDescendantsAndSelf_003Ed__2c _003CDescendantsAndSelf_003Ed__2c = new _003CDescendantsAndSelf_003Ed__2c(-2);
		_003CDescendantsAndSelf_003Ed__2c._003C_003E4__this = this;
		_003CDescendantsAndSelf_003Ed__2c._003C_003E3__name = name;
		return _003CDescendantsAndSelf_003Ed__2c;
	}

	public HtmlNode Element(string name)
	{
		if (true)
		{
		}
		IEnumerator<HtmlNode> enumerator = ((IEnumerable<HtmlNode>)ChildNodes).GetEnumerator();
		try
		{
			int num = 2;
			HtmlNode current = default(HtmlNode);
			HtmlNode result = default(HtmlNode);
			while (true)
			{
				switch (num)
				{
				default:
					num = 5;
					continue;
				case 5:
					if (!enumerator.MoveNext())
					{
						num = 4;
						continue;
					}
					current = enumerator.Current;
					num = 6;
					continue;
				case 6:
					if (current.Name == name)
					{
						num = 3;
						continue;
					}
					goto default;
				case 3:
					result = current;
					num = 0;
					continue;
				case 4:
					num = 1;
					continue;
				case 1:
					break;
				case 0:
					return result;
				}
				break;
			}
		}
		finally
		{
			int num = 1;
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
					num = 0;
					continue;
				case 0:
					break;
				}
				break;
			}
		}
		return null;
	}

	public IEnumerable<HtmlNode> Elements(string name)
	{
		if (true)
		{
		}
		_003CElements_003Ed__32 _003CElements_003Ed__ = new _003CElements_003Ed__32(-2);
		_003CElements_003Ed__._003C_003E4__this = this;
		_003CElements_003Ed__._003C_003E3__name = name;
		return _003CElements_003Ed__;
	}

	public string GetAttributeValue(string name, string def)
	{
		int num = 2;
		HtmlAttribute htmlAttribute = default(HtmlAttribute);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((name != null) ? 4 : 5);
				break;
			case 3:
				if (htmlAttribute == null)
				{
					num = 1;
					break;
				}
				return htmlAttribute.Value;
			case 0:
				if (true)
				{
				}
				return def;
			case 5:
				throw new ArgumentNullException("name");
			case 1:
				return def;
			case 4:
				if (HasAttributes)
				{
					htmlAttribute = Attributes[name];
					num = 3;
				}
				else
				{
					num = 0;
				}
				break;
			}
		}
	}

	public int GetAttributeValue(string name, int def)
	{
		int num = 0;
		HtmlAttribute htmlAttribute = default(HtmlAttribute);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((name != null) ? 1 : 5);
				break;
			case 5:
				if (true)
				{
				}
				throw new ArgumentNullException("name");
			case 3:
				return def;
			case 4:
				if (htmlAttribute == null)
				{
					num = 3;
					break;
				}
				try
				{
					return Convert.ToInt32(htmlAttribute.Value);
				}
				catch
				{
					return def;
				}
			case 1:
				if (HasAttributes)
				{
					htmlAttribute = Attributes[name];
					num = 4;
				}
				else
				{
					num = 2;
				}
				break;
			case 2:
				return def;
			}
		}
	}

	public bool GetAttributeValue(string name, bool def)
	{
		int num = 5;
		HtmlAttribute htmlAttribute = default(HtmlAttribute);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((name != null) ? 3 : 2);
				break;
			case 1:
				return def;
			case 4:
				if (htmlAttribute == null)
				{
					if (true)
					{
					}
					num = 1;
					break;
				}
				try
				{
					return Convert.ToBoolean(htmlAttribute.Value);
				}
				catch
				{
					return def;
				}
			case 3:
				if (HasAttributes)
				{
					htmlAttribute = Attributes[name];
					num = 4;
				}
				else
				{
					num = 0;
				}
				break;
			case 2:
				throw new ArgumentNullException("name");
			case 0:
				return def;
			}
		}
	}

	public HtmlNode InsertAfter(HtmlNode newChild, HtmlNode refChild)
	{
		int num = 0;
		int num2 = default(int);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((newChild != null) ? 12 : 6);
				continue;
			case 11:
				num = 10;
				continue;
			case 10:
				num = ((num2 != -1) ? 2 : 4);
				continue;
			case 1:
				if (_childnodes != null)
				{
					num = 7;
					continue;
				}
				goto case 11;
			case 12:
				num = ((refChild != null) ? 13 : 9);
				continue;
			case 2:
				if (true)
				{
				}
				if (_childnodes != null)
				{
					num = 5;
					continue;
				}
				break;
			case 6:
				throw new ArgumentNullException("newChild");
			case 4:
				throw new ArgumentException(HtmlDocument.HtmlExceptionRefNotChild);
			case 5:
				_childnodes.Insert(num2 + 1, newChild);
				num = 3;
				continue;
			case 8:
				return newChild;
			case 9:
				return PrependChild(newChild);
			case 7:
				num2 = _childnodes[refChild];
				num = 11;
				continue;
			case 13:
				if (newChild != refChild)
				{
					num2 = -1;
					num = 1;
				}
				else
				{
					num = 8;
				}
				continue;
			case 3:
				break;
			}
			break;
		}
		_ownerdocument.SetIdForNode(newChild, newChild.GetId());
		_outerchanged = true;
		_innerchanged = true;
		return newChild;
	}

	public HtmlNode InsertBefore(HtmlNode newChild, HtmlNode refChild)
	{
		int num = 12;
		int num2 = default(int);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((newChild == null) ? 1 : 2);
				continue;
			case 5:
				if (true)
				{
				}
				num = 6;
				continue;
			case 6:
				num = ((num2 != -1) ? 13 : 11);
				continue;
			case 3:
				if (_childnodes != null)
				{
					num = 9;
					continue;
				}
				goto case 5;
			case 2:
				num = ((refChild == null) ? 7 : 0);
				continue;
			case 13:
				if (_childnodes != null)
				{
					num = 8;
					continue;
				}
				break;
			case 1:
				throw new ArgumentNullException("newChild");
			case 11:
				throw new ArgumentException(HtmlDocument.HtmlExceptionRefNotChild);
			case 8:
				_childnodes.Insert(num2, newChild);
				num = 10;
				continue;
			case 4:
				return newChild;
			case 7:
				return AppendChild(newChild);
			case 9:
				num2 = _childnodes[refChild];
				num = 5;
				continue;
			case 0:
				if (newChild != refChild)
				{
					num2 = -1;
					num = 3;
				}
				else
				{
					num = 4;
				}
				continue;
			case 10:
				break;
			}
			break;
		}
		_ownerdocument.SetIdForNode(newChild, newChild.GetId());
		_outerchanged = true;
		_innerchanged = true;
		return newChild;
	}

	public HtmlNode PrependChild(HtmlNode newChild)
	{
		if (newChild == null)
		{
			if (true)
			{
			}
			throw new ArgumentNullException("newChild");
		}
		ChildNodes.Prepend(newChild);
		_ownerdocument.SetIdForNode(newChild, newChild.GetId());
		_outerchanged = true;
		_innerchanged = true;
		return newChild;
	}

	public void PrependChildren(HtmlNodeCollection newChildren)
	{
		if (true)
		{
		}
		int num = 2;
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		while (true)
		{
			switch (num)
			{
			default:
				if (newChildren == null)
				{
					num = 0;
					break;
				}
				enumerator = ((IEnumerable<HtmlNode>)newChildren).GetEnumerator();
				num = 1;
				break;
			case 1:
				try
				{
					num = 2;
					while (true)
					{
						switch (num)
						{
						default:
							num = 4;
							break;
						case 4:
							if (enumerator.MoveNext())
							{
								HtmlNode current = enumerator.Current;
								PrependChild(current);
								num = 3;
							}
							else
							{
								num = 1;
							}
							break;
						case 1:
							num = 0;
							break;
						case 0:
							return;
						}
					}
				}
				finally
				{
					num = 2;
					while (true)
					{
						switch (num)
						{
						default:
							if (enumerator != null)
							{
								num = 0;
								continue;
							}
							break;
						case 0:
							enumerator.Dispose();
							num = 1;
							continue;
						case 1:
							break;
						}
						break;
					}
				}
			case 0:
				throw new ArgumentNullException("newChildren");
			}
		}
	}

	public void Remove()
	{
		if (ParentNode != null)
		{
			ParentNode.ChildNodes.Remove(this);
		}
	}

	public void RemoveAll()
	{
		while (true)
		{
			RemoveAllChildren();
			int num = 4;
			while (true)
			{
				switch (num)
				{
				case 4:
					if (HasAttributes)
					{
						num = 3;
						continue;
					}
					goto case 5;
				case 8:
					num = 6;
					continue;
				case 6:
					if (true)
					{
					}
					if (_endnode._attributes != null)
					{
						num = 7;
						continue;
					}
					goto case 9;
				case 0:
					num = 2;
					continue;
				case 2:
					if (_endnode != this)
					{
						num = 8;
						continue;
					}
					goto case 9;
				case 3:
					_attributes.Clear();
					num = 5;
					continue;
				case 7:
					_endnode._attributes.Clear();
					num = 9;
					continue;
				case 5:
					num = 1;
					continue;
				case 1:
					if (_endnode != null)
					{
						num = 0;
						continue;
					}
					goto case 9;
				case 9:
					_outerchanged = true;
					_innerchanged = true;
					return;
				}
				break;
			}
		}
	}

	public void RemoveAllChildren()
	{
		int num = 4;
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		while (true)
		{
			switch (num)
			{
			default:
				num = (HasChildNodes ? 1 : 2);
				continue;
			case 2:
				return;
			case 0:
				try
				{
					num = 2;
					while (true)
					{
						switch (num)
						{
						default:
							num = 4;
							continue;
						case 4:
						{
							if (!enumerator.MoveNext())
							{
								num = 3;
								continue;
							}
							HtmlNode current = enumerator.Current;
							_ownerdocument.SetIdForNode(null, current.GetId());
							num = 1;
							continue;
						}
						case 3:
							num = 0;
							continue;
						case 0:
							break;
						}
						break;
					}
				}
				finally
				{
					num = 0;
					while (true)
					{
						switch (num)
						{
						default:
							if (enumerator != null)
							{
								num = 1;
								continue;
							}
							break;
						case 1:
							enumerator.Dispose();
							num = 2;
							continue;
						case 2:
							break;
						}
						break;
					}
				}
				break;
			case 1:
				if (_ownerdocument.OptionUseIdAttribute)
				{
					num = 3;
					continue;
				}
				break;
			case 3:
				if (true)
				{
				}
				enumerator = ((IEnumerable<HtmlNode>)_childnodes).GetEnumerator();
				num = 0;
				continue;
			}
			break;
		}
		_childnodes.Clear();
		_outerchanged = true;
		_innerchanged = true;
	}

	public HtmlNode RemoveChild(HtmlNode oldChild)
	{
		int num = 0;
		int num2 = default(int);
		while (true)
		{
			switch (num)
			{
			default:
				if (true)
				{
				}
				if (oldChild == null)
				{
					num = 9;
					continue;
				}
				num2 = -1;
				num = 1;
				continue;
			case 8:
				throw new ArgumentException(HtmlDocument.HtmlExceptionRefNotChild);
			case 2:
				num = 7;
				continue;
			case 7:
				num = ((num2 != -1) ? 3 : 8);
				continue;
			case 1:
				if (_childnodes != null)
				{
					num = 6;
					continue;
				}
				goto case 2;
			case 4:
				_childnodes.Remove(num2);
				num = 5;
				continue;
			case 9:
				throw new ArgumentNullException("oldChild");
			case 3:
				if (_childnodes != null)
				{
					num = 4;
					continue;
				}
				break;
			case 6:
				num2 = _childnodes[oldChild];
				num = 2;
				continue;
			case 5:
				break;
			}
			break;
		}
		_ownerdocument.SetIdForNode(null, oldChild.GetId());
		_outerchanged = true;
		_innerchanged = true;
		return oldChild;
	}

	public HtmlNode RemoveChild(HtmlNode oldChild, bool keepGrandChildren)
	{
		int num = 0;
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		HtmlNode previousSibling = default(HtmlNode);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((oldChild == null) ? 1 : 3);
				continue;
			case 4:
				try
				{
					num = 1;
					while (true)
					{
						switch (num)
						{
						default:
							num = 3;
							continue;
						case 3:
						{
							if (!enumerator.MoveNext())
							{
								num = 0;
								continue;
							}
							HtmlNode current = enumerator.Current;
							InsertAfter(current, previousSibling);
							num = 4;
							continue;
						}
						case 0:
							num = 2;
							continue;
						case 2:
							break;
						}
						break;
					}
				}
				finally
				{
					num = 2;
					while (true)
					{
						switch (num)
						{
						default:
							if (enumerator != null)
							{
								num = 1;
								continue;
							}
							break;
						case 1:
							enumerator.Dispose();
							num = 0;
							continue;
						case 0:
							break;
						}
						break;
					}
				}
				break;
			case 6:
				num = 2;
				continue;
			case 2:
				if (keepGrandChildren)
				{
					num = 5;
					continue;
				}
				break;
			case 5:
				if (true)
				{
				}
				previousSibling = oldChild.PreviousSibling;
				enumerator = ((IEnumerable<HtmlNode>)oldChild._childnodes).GetEnumerator();
				num = 4;
				continue;
			case 1:
				throw new ArgumentNullException("oldChild");
			case 3:
				if (oldChild._childnodes != null)
				{
					num = 6;
					continue;
				}
				break;
			}
			break;
		}
		RemoveChild(oldChild);
		_outerchanged = true;
		_innerchanged = true;
		return oldChild;
	}

	public HtmlNode ReplaceChild(HtmlNode newChild, HtmlNode oldChild)
	{
		int num = 5;
		int num2 = default(int);
		while (true)
		{
			switch (num)
			{
			default:
				num = ((newChild != null) ? 11 : 6);
				continue;
			case 10:
				throw new ArgumentException(HtmlDocument.HtmlExceptionRefNotChild);
			case 7:
				num2 = _childnodes[oldChild];
				num = 9;
				continue;
			case 11:
				if (oldChild == null)
				{
					num = 2;
					continue;
				}
				num2 = -1;
				num = 3;
				continue;
			case 0:
				if (_childnodes != null)
				{
					num = 1;
					continue;
				}
				break;
			case 6:
				if (true)
				{
				}
				return RemoveChild(oldChild);
			case 9:
				num = 4;
				continue;
			case 4:
				num = ((num2 == -1) ? 10 : 0);
				continue;
			case 1:
				_childnodes.Replace(num2, newChild);
				num = 8;
				continue;
			case 3:
				if (_childnodes != null)
				{
					num = 7;
					continue;
				}
				goto case 9;
			case 2:
				return AppendChild(newChild);
			case 8:
				break;
			}
			break;
		}
		_ownerdocument.SetIdForNode(null, oldChild.GetId());
		_ownerdocument.SetIdForNode(newChild, newChild.GetId());
		_outerchanged = true;
		_innerchanged = true;
		return newChild;
	}

	public HtmlAttribute SetAttributeValue(string name, string value)
	{
		int num = 3;
		HtmlAttribute htmlAttribute = default(HtmlAttribute);
		while (true)
		{
			switch (num)
			{
			case 1:
				return Attributes.Append(_ownerdocument.CreateAttribute(name, value));
			case 0:
				if (htmlAttribute == null)
				{
					num = 1;
					continue;
				}
				htmlAttribute.Value = value;
				return htmlAttribute;
			case 2:
				throw new ArgumentNullException("name");
			}
			if (name == null)
			{
				num = 2;
				continue;
			}
			if (true)
			{
			}
			htmlAttribute = Attributes[name];
			num = 0;
		}
	}

	public void WriteContentTo(TextWriter outText)
	{
		int num = 0;
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		while (true)
		{
			switch (num)
			{
			default:
				if (_childnodes == null)
				{
					num = 2;
					break;
				}
				enumerator = ((IEnumerable<HtmlNode>)_childnodes).GetEnumerator();
				num = 1;
				break;
			case 2:
				if (1 == 0)
				{
				}
				return;
			case 1:
				try
				{
					num = 0;
					while (true)
					{
						switch (num)
						{
						default:
							num = 3;
							break;
						case 3:
							if (enumerator.MoveNext())
							{
								HtmlNode current = enumerator.Current;
								current.WriteTo(outText);
								num = 1;
							}
							else
							{
								num = 4;
							}
							break;
						case 4:
							num = 2;
							break;
						case 2:
							return;
						}
					}
				}
				finally
				{
					num = 2;
					while (true)
					{
						switch (num)
						{
						default:
							if (enumerator != null)
							{
								num = 1;
								continue;
							}
							break;
						case 1:
							enumerator.Dispose();
							num = 0;
							continue;
						case 0:
							break;
						}
						break;
					}
				}
			}
		}
	}

	public string WriteContentTo()
	{
		StringWriter stringWriter = new StringWriter();
		WriteContentTo(stringWriter);
		stringWriter.Flush();
		return stringWriter.ToString();
	}

	public void WriteTo(TextWriter outText)
	{
		switch (0)
		{
		}
		string text2 = default(string);
		string text = default(string);
		bool flag = default(bool);
		HtmlNode xmlDeclaration = default(HtmlNode);
		int num2 = default(int);
		while (true)
		{
			HtmlNodeType nodetype = _nodetype;
			int num = 54;
			while (true)
			{
				string text3;
				switch (num)
				{
				case 54:
					switch (nodetype)
					{
					default:
						num = 62;
						break;
					case HtmlNodeType.Text:
						text2 = ((HtmlTextNode)this).Text;
						num = 4;
						break;
					case HtmlNodeType.Comment:
						text2 = ((HtmlCommentNode)this).Comment;
						num = 19;
						break;
					case HtmlNodeType.Element:
						num = 40;
						break;
					case HtmlNodeType.Document:
						num = 33;
						break;
					}
					continue;
				case 62:
					return;
				case 43:
					num = 10;
					continue;
				case 10:
					if (text.Length > 0)
					{
						num = 21;
						continue;
					}
					return;
				case 53:
					num = 11;
					continue;
				case 11:
					if (_ownerdocument.OptionOutputUpperCase)
					{
						num = 63;
						continue;
					}
					outText.Write("<span>");
					WriteContentTo(outText);
					outText.Write("</span>");
					return;
				case 39:
					return;
				case 38:
					outText.Write("?");
					num = 59;
					continue;
				case 4:
					outText.Write((!_ownerdocument.OptionOutputAsXml) ? text2 : HtmlDocument.HtmlEncode(text2));
					return;
				case 19:
					if (_ownerdocument.OptionOutputAsXml)
					{
						num = 9;
						continue;
					}
					outText.Write(text2);
					return;
				case 35:
					return;
				case 45:
					num = 0;
					continue;
				case 0:
					if (Name[0] == '?')
					{
						num = 38;
						continue;
					}
					goto case 59;
				case 15:
					WriteAttributes(outText, closing: true);
					num = 29;
					continue;
				case 34:
					flag = true;
					outText.Write("\r\n//<![CDATA[\r\n");
					num = 20;
					continue;
				case 40:
					num = (_ownerdocument.OptionOutputUpperCase ? 32 : 48);
					continue;
				case 3:
					text = OriginalName;
					num = 60;
					continue;
				case 8:
					xmlDeclaration = _ownerdocument.GetXmlDeclaration();
					num = 46;
					continue;
				case 46:
					if (xmlDeclaration != null)
					{
						num = 52;
						continue;
					}
					goto case 13;
				case 33:
					if (_ownerdocument.OptionOutputAsXml)
					{
						num = 57;
						continue;
					}
					goto IL_0245;
				case 47:
					return;
				case 61:
					num = 6;
					continue;
				case 6:
					if (IsCDataElement(Name))
					{
						if (true)
						{
						}
						num = 34;
						continue;
					}
					goto case 20;
				case 57:
					outText.Write("<?xml version=\"1.0\" encoding=\"" + _ownerdocument.GetOutEncoding().WebName + "\"?>");
					num = 50;
					continue;
				case 50:
					if (_ownerdocument.DocumentNode.HasChildNodes)
					{
						num = 1;
						continue;
					}
					goto IL_0245;
				case 31:
					outText.Write(" />");
					return;
				case 24:
					if (Name.Length > 0)
					{
						num = 45;
						continue;
					}
					goto case 59;
				case 32:
					text3 = Name.ToUpper();
					goto IL_0737;
				case 56:
					return;
				case 14:
					outText.Write("\r\n//]]>//\r\n");
					num = 26;
					continue;
				case 59:
					outText.Write(">");
					return;
				case 22:
					ChildNodes[0].WriteTo(outText);
					num = 14;
					continue;
				case 9:
					outText.Write("<!--" + GetXmlComment((HtmlCommentNode)this) + " -->");
					return;
				case 41:
					num = 44;
					continue;
				case 44:
					num = (_ownerdocument.OptionOutputAsXml ? 31 : 24);
					continue;
				case 55:
					outText.Write("<" + text);
					WriteAttributes(outText, closing: false);
					num = 36;
					continue;
				case 36:
					num = ((!HasChildNodes) ? 51 : 37);
					continue;
				case 25:
					if (text.Trim().Length == 0)
					{
						num = 39;
						continue;
					}
					text = HtmlDocument.GetXmlName(text);
					num = 55;
					continue;
				case 1:
					num2 = _ownerdocument.DocumentNode._childnodes.Count;
					num = 23;
					continue;
				case 23:
					if (num2 > 0)
					{
						num = 8;
						continue;
					}
					goto IL_0245;
				case 2:
				case 26:
					outText.Write("</" + text);
					num = 17;
					continue;
				case 17:
					if (!_ownerdocument.OptionOutputAsXml)
					{
						num = 15;
						continue;
					}
					goto case 29;
				case 52:
					num2--;
					num = 13;
					continue;
				case 29:
					outText.Write(">");
					return;
				case 21:
					num = 30;
					continue;
				case 30:
					num = ((text[0] == '?') ? 47 : 25);
					continue;
				case 48:
					num = 7;
					continue;
				case 7:
					text3 = Name;
					goto IL_0737;
				case 37:
					outText.Write(">");
					flag = false;
					num = 49;
					continue;
				case 49:
					if (_ownerdocument.OptionOutputAsXml)
					{
						num = 61;
						continue;
					}
					goto case 20;
				case 13:
					num = 58;
					continue;
				case 58:
					if (num2 > 1)
					{
						num = 53;
						continue;
					}
					goto IL_0245;
				case 42:
					num = 5;
					continue;
				case 5:
					if (!_ownerdocument.OptionWriteEmptyNodes)
					{
						num = 41;
						continue;
					}
					goto case 31;
				case 20:
					num = 27;
					continue;
				case 27:
					if (!flag)
					{
						WriteContentTo(outText);
						num = 2;
					}
					else
					{
						num = 28;
					}
					continue;
				case 16:
					if (_ownerdocument.OptionOutputOriginalCase)
					{
						num = 3;
						continue;
					}
					goto case 60;
				case 28:
					num = 18;
					continue;
				case 18:
					if (HasChildNodes)
					{
						num = 22;
						continue;
					}
					goto case 14;
				case 63:
					outText.Write("<SPAN>");
					WriteContentTo(outText);
					outText.Write("</SPAN>");
					return;
				case 51:
					if (!IsEmptyElement(Name))
					{
						outText.Write("></" + text + ">");
						num = 56;
					}
					else
					{
						num = 42;
					}
					continue;
				case 60:
					num = 12;
					continue;
				case 12:
					{
						if (_ownerdocument.OptionOutputAsXml)
						{
							num = 43;
							continue;
						}
						goto case 55;
					}
					IL_0245:
					WriteContentTo(outText);
					num = 35;
					continue;
					IL_0737:
					text = text3;
					num = 16;
					continue;
				}
				break;
			}
		}
	}

	public void WriteTo(XmlWriter writer)
	{
		switch (0)
		{
		}
		string localName = default(string);
		IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
		IEnumerator<HtmlNode> enumerator2 = default(IEnumerator<HtmlNode>);
		while (true)
		{
			HtmlNodeType nodetype = _nodetype;
			int num = 9;
			while (true)
			{
				string text;
				switch (num)
				{
				case 9:
					switch (nodetype)
					{
					default:
						num = 8;
						break;
					case HtmlNodeType.Comment:
						writer.WriteComment(GetXmlComment((HtmlCommentNode)this));
						return;
					case HtmlNodeType.Element:
						num = 3;
						break;
					case HtmlNodeType.Document:
						writer.WriteProcessingInstruction("xml", "version=\"1.0\" encoding=\"" + _ownerdocument.GetOutEncoding().WebName + "\"");
						num = 1;
						break;
					case HtmlNodeType.Text:
					{
						string text2 = ((HtmlTextNode)this).Text;
						writer.WriteString(text2);
						return;
					}
					}
					continue;
				case 8:
					return;
				case 5:
					localName = OriginalName;
					num = 4;
					continue;
				case 6:
					text = Name.ToUpper();
					goto IL_0366;
				case 14:
					enumerator = ((IEnumerable<HtmlNode>)ChildNodes).GetEnumerator();
					num = 0;
					continue;
				case 12:
					try
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								num = 4;
								continue;
							case 4:
							{
								if (!enumerator2.MoveNext())
								{
									num = 0;
									continue;
								}
								HtmlNode current2 = enumerator2.Current;
								current2.WriteTo(writer);
								num = 3;
								continue;
							}
							case 0:
								num = 1;
								continue;
							case 1:
								break;
							}
							break;
						}
					}
					finally
					{
						num = 1;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator2 != null)
								{
									num = 0;
									continue;
								}
								break;
							case 0:
								enumerator2.Dispose();
								num = 2;
								continue;
							case 2:
								break;
							}
							break;
						}
					}
					goto IL_02d4;
				case 4:
					if (true)
					{
					}
					writer.WriteStartElement(localName);
					WriteAttributes(writer, this);
					num = 2;
					continue;
				case 2:
					if (HasChildNodes)
					{
						num = 7;
						continue;
					}
					goto IL_02d4;
				case 3:
					num = ((!_ownerdocument.OptionOutputUpperCase) ? 15 : 6);
					continue;
				case 0:
					try
					{
						num = 1;
						while (true)
						{
							switch (num)
							{
							default:
								num = 0;
								break;
							case 0:
								if (enumerator.MoveNext())
								{
									HtmlNode current = enumerator.Current;
									current.WriteTo(writer);
									num = 2;
								}
								else
								{
									num = 3;
								}
								break;
							case 3:
								num = 4;
								break;
							case 4:
								return;
							}
						}
					}
					finally
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator != null)
								{
									num = 1;
									continue;
								}
								break;
							case 1:
								enumerator.Dispose();
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
				case 7:
					enumerator2 = ((IEnumerable<HtmlNode>)ChildNodes).GetEnumerator();
					num = 12;
					continue;
				case 13:
					return;
				case 1:
					if (HasChildNodes)
					{
						num = 14;
						continue;
					}
					return;
				case 15:
					num = 10;
					continue;
				case 10:
					text = Name;
					goto IL_0366;
				case 11:
					{
						if (_ownerdocument.OptionOutputOriginalCase)
						{
							num = 5;
							continue;
						}
						goto case 4;
					}
					IL_02d4:
					writer.WriteEndElement();
					num = 13;
					continue;
					IL_0366:
					localName = text;
					num = 11;
					continue;
				}
				break;
			}
		}
	}

	public string WriteTo()
	{
		if (true)
		{
		}
		StringWriter stringWriter = new StringWriter();
		try
		{
			WriteTo(stringWriter);
			stringWriter.Flush();
			return stringWriter.ToString();
		}
		finally
		{
			int num = 0;
			while (true)
			{
				switch (num)
				{
				default:
					if (stringWriter != null)
					{
						num = 1;
						continue;
					}
					break;
				case 1:
					((IDisposable)stringWriter).Dispose();
					num = 2;
					continue;
				case 2:
					break;
				}
				break;
			}
		}
	}

	internal static string GetXmlComment(HtmlCommentNode comment)
	{
		if (true)
		{
		}
		string comment2 = comment.Comment;
		return comment2.Substring(4, comment2.Length - 7).Replace("--", " - -");
	}

	internal static void WriteAttributes(XmlWriter writer, HtmlNode node)
	{
		int num = 2;
		Dictionary<string, HtmlAttribute>.ValueCollection.Enumerator enumerator = default(Dictionary<string, HtmlAttribute>.ValueCollection.Enumerator);
		while (true)
		{
			switch (num)
			{
			default:
				if (!node.HasAttributes)
				{
					num = 0;
					break;
				}
				enumerator = node.Attributes.Hashitems.Values.GetEnumerator();
				if (true)
				{
				}
				num = 1;
				break;
			case 0:
				return;
			case 1:
				try
				{
					num = 1;
					while (true)
					{
						switch (num)
						{
						default:
							num = 3;
							break;
						case 3:
							if (enumerator.MoveNext())
							{
								HtmlAttribute current = enumerator.Current;
								writer.WriteAttributeString(current.XmlName, current.Value);
								num = 2;
							}
							else
							{
								num = 0;
							}
							break;
						case 0:
							num = 4;
							break;
						case 4:
							return;
						}
					}
				}
				finally
				{
					((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
				}
			}
		}
	}

	internal void CloseNode(HtmlNode endnode)
	{
		switch (0)
		{
		default:
		{
			int num = 14;
			HtmlNode current = default(HtmlNode);
			IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
			HtmlNode dictionaryValueOrNull = default(HtmlNode);
			while (true)
			{
				switch (num)
				{
				default:
					if (!_ownerdocument.OptionAutoCloseOnEnd)
					{
						num = 8;
						break;
					}
					goto IL_0270;
				case 13:
					_ownerdocument.Lastnodes.Remove(Name);
					_ownerdocument.UpdateLastParentNode();
					num = 11;
					break;
				case 6:
					_ownerdocument.Openednodes.Remove(_outerstartindex);
					num = 2;
					break;
				case 15:
					try
					{
						num = 3;
						while (true)
						{
							switch (num)
							{
							case 1:
								if (!current.Closed)
								{
									num = 4;
									continue;
								}
								goto default;
							case 4:
							{
								HtmlNode htmlNode = new HtmlNode(NodeType, _ownerdocument, -1);
								htmlNode._endnode = htmlNode;
								current.CloseNode(htmlNode);
								num = 6;
								continue;
							}
							default:
								num = 5;
								continue;
							case 5:
								if (enumerator.MoveNext())
								{
									current = enumerator.Current;
									num = 1;
								}
								else
								{
									num = 2;
								}
								continue;
							case 2:
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
					finally
					{
						num = 0;
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
					goto IL_0270;
				case 1:
					return;
				case 3:
					enumerator = ((IEnumerable<HtmlNode>)_childnodes).GetEnumerator();
					num = 15;
					break;
				case 2:
					dictionaryValueOrNull = Utilities.GetDictionaryValueOrNull(_ownerdocument.Lastnodes, Name);
					num = 10;
					break;
				case 10:
					if (dictionaryValueOrNull == this)
					{
						num = 13;
						break;
					}
					goto case 11;
				case 12:
					return;
				case 4:
					if (!Closed)
					{
						num = 9;
						break;
					}
					return;
				case 8:
					num = 0;
					break;
				case 0:
					if (_childnodes != null)
					{
						num = 3;
						break;
					}
					goto IL_0270;
				case 11:
					num = 7;
					break;
				case 7:
					if (endnode != this)
					{
						_innerstartindex = _outerstartindex + _outerlength;
						_innerlength = endnode._outerstartindex - _innerstartindex;
						_outerlength = endnode._outerstartindex + endnode._outerlength - _outerstartindex;
						num = 12;
					}
					else
					{
						num = 1;
					}
					break;
				case 9:
					if (true)
					{
					}
					_endnode = endnode;
					num = 5;
					break;
				case 5:
					{
						if (_ownerdocument.Openednodes != null)
						{
							num = 6;
							break;
						}
						goto case 2;
					}
					IL_0270:
					num = 4;
					break;
				}
			}
		}
		}
	}

	internal string GetId()
	{
		HtmlAttribute htmlAttribute = Attributes["id"];
		if (htmlAttribute != null)
		{
			if (true)
			{
			}
			return htmlAttribute.Value;
		}
		return string.Empty;
	}

	internal void SetId(string id)
	{
		if (true)
		{
		}
		HtmlAttribute htmlAttribute = Attributes["id"] ?? _ownerdocument.CreateAttribute("id");
		htmlAttribute.Value = id;
		_ownerdocument.SetIdForNode(this, htmlAttribute.Value);
		_outerchanged = true;
	}

	internal void WriteAttribute(TextWriter outText, HtmlAttribute att)
	{
		switch (0)
		{
		default:
		{
			int num = 7;
			string text = default(string);
			string text2 = default(string);
			while (true)
			{
				string text4;
				object obj;
				string text3;
				switch (num)
				{
				default:
					num = ((att.QuoteType == AttributeValueQuote.DoubleQuote) ? 28 : 25);
					break;
				case 6:
					num = 18;
					break;
				case 18:
					if (att.Name[1] == '%')
					{
						num = 8;
						break;
					}
					goto IL_0220;
				case 30:
					text = att.OriginalName;
					num = 0;
					break;
				case 0:
					outText.Write(" " + text + "=" + text2 + HtmlDocument.HtmlEncode(att.XmlValue) + text2);
					return;
				case 1:
					num = 5;
					break;
				case 5:
					text4 = att.Name;
					goto IL_03a2;
				case 25:
					num = 29;
					break;
				case 29:
					obj = "'";
					goto IL_01a2;
				case 11:
					num = ((!_ownerdocument.OptionOutputAsXml) ? 22 : 20);
					break;
				case 23:
					num = 12;
					break;
				case 12:
					text3 = att.XmlName;
					goto IL_0374;
				case 8:
					num = 24;
					break;
				case 24:
					if (att.Name[att.Name.Length - 1] == '>')
					{
						num = 26;
						break;
					}
					goto IL_0220;
				case 10:
					if (_ownerdocument.OptionOutputOptimizeAttributeValues)
					{
						num = 19;
						break;
					}
					if (true)
					{
					}
					outText.Write(" " + text + "=" + text2 + att.Value + text2);
					return;
				case 13:
					num = 17;
					break;
				case 17:
					if (att.Name[0] == '<')
					{
						num = 6;
						break;
					}
					goto IL_0220;
				case 15:
					text4 = att.Name.ToUpper();
					goto IL_03a2;
				case 19:
					num = 4;
					break;
				case 4:
					if (att.Value.IndexOfAny(new char[4] { '\n', '\r', '\t', ' ' }) >= 0)
					{
						outText.Write(" " + text + "=" + text2 + att.Value + text2);
						return;
					}
					num = 21;
					break;
				case 27:
					text3 = att.XmlName.ToUpper();
					goto IL_0374;
				case 22:
					num = ((!_ownerdocument.OptionOutputUpperCase) ? 1 : 15);
					break;
				case 16:
					outText.Write(" " + text);
					return;
				case 21:
					outText.Write(" " + text + "=" + att.Value);
					return;
				case 20:
					num = 9;
					break;
				case 9:
					num = ((!_ownerdocument.OptionOutputUpperCase) ? 23 : 27);
					break;
				case 2:
					if (_ownerdocument.OptionOutputOriginalCase)
					{
						num = 30;
						break;
					}
					goto case 0;
				case 3:
					if (att.Name.Length >= 4)
					{
						num = 13;
						break;
					}
					goto IL_0220;
				case 26:
					num = 14;
					break;
				case 14:
					if (att.Name[att.Name.Length - 2] == '%')
					{
						num = 16;
						break;
					}
					goto IL_0220;
				case 28:
					{
						obj = "\"";
						goto IL_01a2;
					}
					IL_0220:
					num = 10;
					break;
					IL_01a2:
					text2 = (string)obj;
					num = 11;
					break;
					IL_03a2:
					text = text4;
					num = 3;
					break;
					IL_0374:
					text = text3;
					num = 2;
					break;
				}
			}
		}
		}
	}

	internal void WriteAttributes(TextWriter outText, bool closing)
	{
		switch (0)
		{
		default:
		{
			int num = 16;
			IEnumerator<HtmlAttribute> enumerator2 = default(IEnumerator<HtmlAttribute>);
			IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
			int num2 = default(int);
			IEnumerator<HtmlAttribute> enumerator3 = default(IEnumerator<HtmlAttribute>);
			Dictionary<string, HtmlAttribute>.ValueCollection.Enumerator enumerator4 = default(Dictionary<string, HtmlAttribute>.ValueCollection.Enumerator);
			while (true)
			{
				switch (num)
				{
				default:
					num = ((!_ownerdocument.OptionOutputAsXml) ? 20 : 14);
					break;
				case 12:
					num = 19;
					break;
				case 19:
					if (_endnode == this)
					{
						num = 11;
						break;
					}
					enumerator2 = ((IEnumerable<HtmlAttribute>)_endnode._attributes).GetEnumerator();
					num = 18;
					break;
				case 11:
					return;
				case 22:
					try
					{
						num = 4;
						while (true)
						{
							switch (num)
							{
							default:
								num = 0;
								break;
							case 0:
								if (enumerator.MoveNext())
								{
									HtmlNode current = enumerator.Current;
									WriteAttribute(outText, _ownerdocument.CreateAttribute("_child_" + num2, current.Name));
									num2++;
									num = 1;
								}
								else
								{
									num = 2;
								}
								break;
							case 2:
								num = 3;
								break;
							case 3:
								return;
							}
						}
					}
					finally
					{
						num = 1;
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
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
				case 18:
					try
					{
						num = 3;
						while (true)
						{
							switch (num)
							{
							default:
								num = 4;
								continue;
							case 4:
								if (enumerator2.MoveNext())
								{
									HtmlAttribute current3 = enumerator2.Current;
									WriteAttribute(outText, current3);
									num = 2;
								}
								else
								{
									num = 1;
								}
								continue;
							case 1:
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
					finally
					{
						num = 2;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator2 != null)
								{
									num = 0;
									continue;
								}
								break;
							case 0:
								enumerator2.Dispose();
								num = 1;
								continue;
							case 1:
								break;
							}
							break;
						}
					}
					num = 13;
					break;
				case 1:
					num = 8;
					break;
				case 8:
					if (_endnode._attributes != null)
					{
						num = 12;
						break;
					}
					return;
				case 6:
					return;
				case 20:
					num = (closing ? 9 : 21);
					break;
				case 3:
					return;
				case 5:
					try
					{
						num = 3;
						while (true)
						{
							switch (num)
							{
							default:
								num = 2;
								continue;
							case 2:
								if (enumerator3.MoveNext())
								{
									HtmlAttribute current4 = enumerator3.Current;
									WriteAttribute(outText, current4);
									num = 4;
								}
								else
								{
									num = 1;
								}
								continue;
							case 1:
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
					finally
					{
						num = 1;
						while (true)
						{
							switch (num)
							{
							default:
								if (enumerator3 != null)
								{
									num = 2;
									continue;
								}
								break;
							case 2:
								enumerator3.Dispose();
								num = 0;
								continue;
							case 0:
								break;
							}
							break;
						}
					}
					goto IL_0531;
				case 14:
					num = 0;
					break;
				case 0:
					if (_attributes != null)
					{
						enumerator4 = _attributes.Hashitems.Values.GetEnumerator();
						num = 4;
					}
					else
					{
						num = 10;
					}
					break;
				case 10:
					return;
				case 4:
					try
					{
						num = 3;
						while (true)
						{
							switch (num)
							{
							case 1:
								return;
							default:
								num = 2;
								break;
							case 2:
								if (enumerator4.MoveNext())
								{
									HtmlAttribute current2 = enumerator4.Current;
									WriteAttribute(outText, current2);
									num = 0;
								}
								else
								{
									num = 4;
								}
								break;
							case 4:
								num = 1;
								break;
							}
						}
					}
					finally
					{
						((IDisposable)enumerator4/*cast due to .constrained prefix*/).Dispose();
					}
				case 2:
					if (true)
					{
					}
					enumerator3 = ((IEnumerable<HtmlAttribute>)_attributes).GetEnumerator();
					num = 5;
					break;
				case 17:
					if (_ownerdocument.OptionAddDebuggingAttributes)
					{
						WriteAttribute(outText, _ownerdocument.CreateAttribute("_closed", Closed.ToString()));
						WriteAttribute(outText, _ownerdocument.CreateAttribute("_children", ChildNodes.Count.ToString()));
						num2 = 0;
						enumerator = ((IEnumerable<HtmlNode>)ChildNodes).GetEnumerator();
						num = 22;
					}
					else
					{
						num = 15;
					}
					break;
				case 15:
					return;
				case 21:
					num = 7;
					break;
				case 7:
					if (_attributes != null)
					{
						num = 2;
						break;
					}
					goto IL_0531;
				case 13:
					if (_ownerdocument.OptionAddDebuggingAttributes)
					{
						WriteAttribute(outText, _ownerdocument.CreateAttribute("_closed", Closed.ToString()));
						WriteAttribute(outText, _ownerdocument.CreateAttribute("_children", ChildNodes.Count.ToString()));
						num = 3;
					}
					else
					{
						num = 6;
					}
					break;
				case 9:
					{
						if (_endnode == null)
						{
							return;
						}
						num = 1;
						break;
					}
					IL_0531:
					num = 17;
					break;
				}
			}
		}
		}
	}

	private string GetRelativeXpath()
	{
		switch (0)
		{
		default:
		{
			int num = 3;
			IEnumerator<HtmlNode> enumerator = default(IEnumerator<HtmlNode>);
			HtmlNode current = default(HtmlNode);
			int num2 = default(int);
			while (true)
			{
				switch (num)
				{
				default:
					num = ((ParentNode == null) ? 1 : 4);
					break;
				case 0:
					try
					{
						num = 7;
						while (true)
						{
							switch (num)
							{
							default:
								num = 6;
								continue;
							case 6:
								if (!enumerator.MoveNext())
								{
									num = 1;
									continue;
								}
								current = enumerator.Current;
								num = 8;
								continue;
							case 0:
								num = 5;
								continue;
							case 5:
								if (current != this)
								{
									num = 2;
									continue;
								}
								break;
							case 8:
								if (!(current.Name != Name))
								{
									num = 0;
									continue;
								}
								goto default;
							case 2:
								num2++;
								num = 4;
								continue;
							case 1:
								break;
							case 3:
								goto end_IL_0058;
							}
							num = 3;
							continue;
							end_IL_0058:
							break;
						}
					}
					finally
					{
						num = 0;
						while (true)
						{
							if (true)
							{
							}
							switch (num)
							{
							default:
								if (enumerator != null)
								{
									num = 1;
									continue;
								}
								break;
							case 1:
								enumerator.Dispose();
								num = 2;
								continue;
							case 2:
								break;
							}
							break;
						}
					}
					return Name + "[" + num2 + "]";
				case 2:
					return string.Empty;
				case 1:
					return Name;
				case 4:
					if (NodeType == HtmlNodeType.Document)
					{
						num = 2;
						break;
					}
					num2 = 1;
					enumerator = ((IEnumerable<HtmlNode>)ParentNode.ChildNodes).GetEnumerator();
					num = 0;
					break;
				}
			}
		}
		}
	}
}
