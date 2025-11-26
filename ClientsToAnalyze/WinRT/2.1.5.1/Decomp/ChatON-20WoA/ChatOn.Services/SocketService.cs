using System;
using System.Collections.Generic;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.Models;
using com.sec.ssm.common;
using Windows.Foundation;
using Windows.Networking;
using Windows.Networking.Sockets;
using Windows.Storage.Streams;
using Windows.System.Threading;
using Windows.UI.Xaml;

namespace ChatOn.Services;

public class SocketService
{
	public delegate void SocketEventHandler(object sender, SocketEventArgs e);

	public delegate void SocketMessageHandler(object sender, object arg);

	private const int BUFFER_SIZE = 5242880;

	private static SocketService _instance;

	private SSMServer _svrAddress;

	private UserAccountInfo _account;

	private StreamSocket _socket;

	private HostName _endPoint;

	private Chat _chat;

	private byte[] _buffer;

	private uint _transferredSize;

	private int _totalSize;

	private bool _forceDisconnect;

	private bool _toEndChat;

	private bool _disconnectRequested;

	private bool _isConnected;

	private string _port;

	private DataReader _readPacket;

	private DataWriter _writePacket;

	private List<string> NickNameRequestList_Active = new List<string>();

	private List<string> NickNameRequestList_Done = new List<string>();

	private bool NickNameRequest_IsFirstTime = true;

	private bool isHasAllowed;

	private bool isHasInitChat;

	private DateTime _lastActivityTime = DateTime.Now;

	private DispatcherTimer _timerChecker;

	public static SocketService Instance
	{
		get
		{
			if (_instance == null)
			{
				_instance = new SocketService();
			}
			return _instance;
		}
	}

	public bool DisconnectRequested
	{
		get
		{
			return _disconnectRequested;
		}
		set
		{
			_disconnectRequested = value;
		}
	}

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
		}
	}

	public bool IsConnected => _isConnected;

	public bool ToEndChat
	{
		get
		{
			return _toEndChat;
		}
		set
		{
			_toEndChat = value;
		}
	}

	public bool IsHasAllowed
	{
		get
		{
			return isHasAllowed;
		}
		set
		{
			isHasAllowed = value;
		}
	}

	public bool IsHasInitChat
	{
		get
		{
			return isHasInitChat;
		}
		set
		{
			isHasInitChat = value;
		}
	}

	public DateTime LastActivityTime
	{
		get
		{
			return _lastActivityTime;
		}
		set
		{
			_lastActivityTime = value;
		}
	}

	public event SocketEventHandler Connected;

	public event SocketMessageHandler DeliveryChatCompleted;

	public event SocketMessageHandler InitChatReplyReceived;

	public event SocketMessageHandler AllowChatReplyReceived;

	public event SocketMessageHandler ChatReplyReceived;

	public event SocketMessageHandler AnnounceChangeReceived;

	public event SocketMessageHandler EndChatReplyReceived;

	public event SocketMessageHandler AnswerBackReceived;

	public event SocketMessageHandler NickNameReplyReceived;

	public event SocketMessageHandler InviteChatReplyReceived;

	public event SocketMessageHandler OnSocketError;

	public event SocketMessageHandler OnSocketDisconnected;

	private unsafe SocketService()
	{
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_006d: Expected O, but got Unknown
		_svrAddress = SSMService.GetServerInfo();
		_account = RegistrationService.GetUserAccount();
		_buffer = new byte[5242880];
		_transferredSize = 0u;
		_totalSize = 0;
		_timerChecker = new DispatcherTimer();
		_timerChecker.put_Interval(TimeSpan.FromSeconds(30.0));
		DispatcherTimer timerChecker = _timerChecker;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timerChecker, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timerChecker, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timerChecker_Tick);
	}

	private void _timerChecker_Tick(object sender, object e)
	{
		if (_chat == null)
		{
			return;
		}
		int seconds = DateTime.Now.Subtract(LastActivityTime).Seconds;
		if (seconds > 30)
		{
			if (!IsHasAllowed)
			{
				SendAllowChatRequestMsg();
			}
			else
			{
				SendTypingRequest();
			}
			LastActivityTime = DateTime.Now;
		}
	}

	public async Task Connect()
	{
		_socket = new StreamSocket();
		_socket.Control.put_KeepAlive(true);
		_socket.Control.put_QualityOfService((SocketQualityOfService)1);
		_readPacket = new DataReader(_socket.InputStream);
		_readPacket.put_InputStreamOptions((InputStreamOptions)1);
		_writePacket = new DataWriter(_socket.OutputStream);
		if (_chat != null)
		{
			if (string.IsNullOrEmpty(_chat.Address))
			{
				_endPoint = new HostName(_svrAddress.MsgServer.Url);
				_port = _svrAddress.MsgServer.Port;
			}
			else
			{
				_endPoint = new HostName(_chat.Address);
				_port = _chat.Port.ToString();
			}
			try
			{
				await _socket.ConnectAsync(_endPoint, _port);
				_isConnected = true;
			}
			catch (Exception ex)
			{
				SocketError.GetStatus(ex.HResult);
				_isConnected = false;
			}
			HandleConnect();
			IsHasAllowed = false;
			_forceDisconnect = false;
			_transferredSize = 0u;
			_totalSize = 0;
			_disconnectRequested = false;
		}
	}

	private unsafe void HandleConnect()
	{
		//IL_009c: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a6: Expected O, but got Unknown
		try
		{
			if (!_isConnected)
			{
				if (this.OnSocketError != null)
				{
					this.OnSocketError(this, null);
				}
				return;
			}
			if (this.Connected != null)
			{
				this.Connected(this, new SocketEventArgs(""));
			}
			if (_chat != null && _chat.IsChanged && !_toEndChat && _chat.ChatType != ChatType.BROADCAST && !string.IsNullOrEmpty(_chat.Sender))
			{
				SendAllowChatRequestMsg();
				IsHasAllowed = true;
			}
			StartReceiving();
			if (_timerChecker == null)
			{
				_timerChecker = new DispatcherTimer();
				WindowsRuntimeMarshal.RemoveEventHandler<EventHandler<object>>(new Action<EventRegistrationToken>(_timerChecker, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timerChecker_Tick);
				_timerChecker.put_Interval(TimeSpan.FromSeconds(30.0));
				DispatcherTimer timerChecker = _timerChecker;
				WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timerChecker, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timerChecker, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timerChecker_Tick);
			}
			_timerChecker.Start();
		}
		catch (Exception)
		{
		}
	}

	public void Disconnect()
	{
		if (IsConnected)
		{
			IsHasAllowed = false;
			_forceDisconnect = true;
			ShutDown();
		}
	}

	private void ShutDown()
	{
		try
		{
			_socket.Dispose();
			_isConnected = false;
			_disconnectRequested = true;
			_timerChecker.Stop();
		}
		catch (Exception)
		{
		}
	}

	internal void SendAllowChatRequestMsg()
	{
		try
		{
			SendMsg(SocketMessage.AllowChatRequestMsg(_chat.Sender, RegistrationService.ChatOnID, _account.Uid, _account.IMEI, _chat.SessionID, _svrAddress.Key, _chat.ChatType, _chat.LastMergedTimeStamp));
		}
		catch (Exception)
		{
		}
	}

	private async void StartReceiving()
	{
		try
		{
			if (!_isConnected)
			{
				await Connect();
			}
			try
			{
				await HandleReceive(await (IAsyncOperation<uint>)(object)_readPacket.LoadAsync(5242880u), _readPacket);
			}
			catch (Exception ex)
			{
				SocketErrorStatus status = SocketError.GetStatus(ex.HResult);
				if ((int)status == 3)
				{
					_isConnected = false;
				}
				IsHasAllowed = false;
				if (this.OnSocketError != null)
				{
					this.OnSocketError(this, ex);
				}
			}
		}
		catch (Exception)
		{
		}
	}

	public async void SendMsg(byte[] sendBytes)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (!_isConnected)
			{
				IsHasAllowed = false;
				await Connect();
			}
		}
		catch (Exception)
		{
		}
		StartSending(sendBytes);
	}

	private async void StartSending(byte[] sendBytes)
	{
		try
		{
			if (!IsConnected)
			{
				IsHasAllowed = false;
				await Connect();
			}
			LastActivityTime = DateTime.Now;
			_writePacket.WriteBytes(sendBytes);
			await (IAsyncOperation<uint>)(object)_writePacket.StoreAsync();
		}
		catch (Exception)
		{
			if (this.OnSocketError != null)
			{
				this.OnSocketError(this, null);
			}
		}
	}

	private async Task HandleReceive(uint bytesRead, DataReader readPacket)
	{
		await Task.Run(delegate
		{
			//IL_0026: Unknown result type (might be due to invalid IL or missing references)
			//IL_002d: Expected O, but got Unknown
			//IL_011a: Unknown result type (might be due to invalid IL or missing references)
			//IL_0121: Expected O, but got Unknown
			TimerElapsedHandler val = null;
			TimerElapsedHandler val2 = null;
			if (bytesRead == 0 || readPacket.UnconsumedBufferLength == 0)
			{
				if (val == null)
				{
					val = (TimerElapsedHandler)delegate
					{
						StartReceiving();
					};
				}
				ThreadPoolTimer.CreateTimer(val, TimeSpan.FromMilliseconds(500.0));
			}
			else
			{
				IBuffer source = readPacket.ReadBuffer(readPacket.UnconsumedBufferLength);
				byte[] array = source.ToArray();
				Buffer.BlockCopy(array, 0, _buffer, (int)_transferredSize, array.Length);
				_transferredSize += bytesRead;
				if (_totalSize == 0)
				{
					byte[] array2 = new byte[2];
					array2[1] = _buffer[38];
					array2[0] = _buffer[39];
					ushort num = BitConverter.ToUInt16(array2, 0);
					_totalSize = num + 40;
				}
				if (_totalSize > _transferredSize)
				{
					if (_transferredSize != 0)
					{
						if (val2 == null)
						{
							val2 = (TimerElapsedHandler)delegate
							{
								StartReceiving();
							};
						}
						ThreadPoolTimer.CreateTimer(val2, TimeSpan.FromMilliseconds(500.0));
					}
				}
				else
				{
					bool disconnect = _forceDisconnect;
					LastActivityTime = DateTime.Now;
					int num2 = 0;
					while (num2 < _transferredSize && !_forceDisconnect)
					{
						byte[] array3 = new byte[2];
						array3[1] = _buffer[num2 + 38];
						array3[0] = _buffer[num2 + 39];
						ushort num3 = BitConverter.ToUInt16(array3, 0);
						if (num3 > _transferredSize - num2)
						{
							_totalSize = num3 + 40;
							_transferredSize -= (uint)num2;
							byte[] array4 = new byte[_transferredSize];
							Buffer.BlockCopy(_buffer, num2, array4, 0, (int)_transferredSize);
							Buffer.BlockCopy(array4, 0, _buffer, 0, (int)_transferredSize);
							StartReceiving();
							return;
						}
						SocketMessage.Type type = (SocketMessage.Type)_buffer[num2 + 37];
						byte[] array5 = new byte[num3];
						Buffer.BlockCopy(_buffer, num2 + 40, array5, 0, num3);
						num2 += 40 + num3;
						switch (type)
						{
						case SocketMessage.Type.InitChatReply:
							HandleInitChatReply(array5);
							break;
						case SocketMessage.Type.AllowChatReply:
							HandleAllowChatReply(array5);
							break;
						case SocketMessage.Type.DisconnectRequest:
							HandleDisconnectRequest(array5, ref disconnect);
							break;
						case SocketMessage.Type.AnswerBack:
							HandleAnswerBack(array5);
							break;
						case SocketMessage.Type.ChatReply:
							HandleChatReply(array5);
							break;
						case SocketMessage.Type.DeliveryChat:
							HandleDeliveryChat(array5);
							break;
						case SocketMessage.Type.AnnounceChange:
							HandleAnnounceChange(array5);
							break;
						case SocketMessage.Type.EndChatReply:
							HandleEndChatReply(array5);
							break;
						case SocketMessage.Type.NickNameReply:
							HandleNickNameReply(array5);
							break;
						case SocketMessage.Type.InviteChatReply:
							HandleInviteChatReply(array5);
							break;
						}
					}
					_totalSize = 0;
					_transferredSize = 0u;
					if (disconnect)
					{
						Disconnect();
					}
					else
					{
						StartReceiving();
					}
				}
			}
		});
	}

	private byte[] HandleDeliveryChat(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			DeliveryChat deliveryChat = DeliveryChat.ParseFrom(ret);
			if (this.DeliveryChatCompleted != null)
			{
				this.DeliveryChatCompleted(this, deliveryChat);
			}
			if (!_forceDisconnect)
			{
				SendDeliveryChatReplyMsg(deliveryChat);
			}
		}
		return ret;
	}

	private void LogDeliveryChat(DeliveryChat chatMsg)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.AppendLine("Session ID : " + chatMsg.SessionID);
		stringBuilder.AppendLine("Receive Time : " + Utility.GetTimeStamp());
		stringBuilder.AppendLine("User IMEI : " + _account.IMEI);
		stringBuilder.AppendLine("User UID : " + _account.Uid);
		foreach (InboxMessage inboxMessage in chatMsg.InboxMessageList)
		{
			switch (inboxMessage.MsgType)
			{
			case MsgType.ANS:
				stringBuilder.AppendLine("ANS");
				break;
			case MsgType.NOTI:
				stringBuilder.AppendLine("NOTI");
				break;
			case MsgType.MEDIA:
				stringBuilder.AppendLine("MEDIA");
				break;
			case MsgType.TEXT:
				stringBuilder.AppendLine("TEXT");
				break;
			}
			if (inboxMessage.MsgType == MsgType.MEDIA || inboxMessage.MsgType == MsgType.TEXT)
			{
				stringBuilder.AppendLine($"Msg ID : {inboxMessage.MsgID}, Msg Receiver {inboxMessage.ReceiversList[0]}, Msg Time:  {inboxMessage.SentTime}, Msg Content: {inboxMessage.ChatMsg}");
			}
		}
	}

	private void SendDeliveryChatReplyMsg(DeliveryChat chatMsg)
	{
		if (chatMsg.InboxMessageList.Count != 0)
		{
			SendMsg(SocketMessage.DeliveryChatReplyMsg(chatMsg.InboxMessageList, _account.Uid, _svrAddress.Key, RegistrationService.ChatOnID));
		}
		else
		{
			SendMsg(SocketMessage.DeliveryChatReplyMsg(_account.Uid, _svrAddress.Key));
		}
	}

	private byte[] HandleAnnounceChange(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			AnnounceChange announceChange = AnnounceChange.ParseFrom(ret);
			if (this.AnnounceChangeReceived != null)
			{
				this.AnnounceChangeReceived(this, announceChange);
			}
			SendMsg(SocketMessage.AnnounceChangeReply(_account.Uid, _svrAddress.Key, announceChange.MsgID));
		}
		return ret;
	}

	private byte[] HandleNickNameReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			NicknameReply nicknameReply = NicknameReply.ParseFrom(ret);
			if (this.NickNameReplyReceived != null)
			{
				this.NickNameReplyReceived(this, nicknameReply);
				foreach (Nickname nickname in nicknameReply.NicknameList)
				{
					NickNameRequestList_Done.Add(nickname.User);
					NickNameRequestList_Active.Remove(nickname.User);
					if (NickNameRequestList_Active.Count > 0)
					{
						SendMsg(SocketMessage.NickNameRequest(_account.Uid, _svrAddress.Key, NickNameRequestList_Active[0]));
					}
				}
			}
		}
		return ret;
	}

	private byte[] HandleChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			ChatReply chatReply = ChatReply.ParseFrom(ret);
			_chat.Address = chatReply.ServerInfo.Address;
			_chat.Port = chatReply.ServerInfo.Port;
			if (this.ChatReplyReceived != null)
			{
				this.ChatReplyReceived(this, chatReply);
			}
		}
		return ret;
	}

	private byte[] HandleEndChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		if (ret != null)
		{
			EndChatReply arg = EndChatReply.ParseFrom(ret);
			if (this.EndChatReplyReceived != null)
			{
				this.EndChatReplyReceived(this, arg);
			}
		}
		return ret;
	}

	private void HandleAnswerBack(byte[] body)
	{
		try
		{
			Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
			AnswerBack answerBack = AnswerBack.ParseFrom(ret);
			if (this.AnswerBackReceived != null)
			{
				this.AnswerBackReceived(this, answerBack);
			}
			SendMsg(SocketMessage.AnswerBackReplyMsg(answerBack.AnswerbackItemsList, _account.Uid, _svrAddress.Key, RegistrationService.ChatOnID));
		}
		catch (Exception)
		{
		}
	}

	private byte[] HandleDisconnectRequest(byte[] body, ref bool disconnect)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		DisconnectRequest disconnectRequest = DisconnectRequest.ParseFrom(ret);
		SendMsg(SocketMessage.DisconnectReplyMsg(disconnectRequest.MsgID, _account.Uid, _svrAddress.Key));
		disconnect = true;
		_disconnectRequested = true;
		return ret;
	}

	private void HandleInitChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		InitChatReply initChatReply = InitChatReply.ParseFrom(ret);
		_chat.SessionID = initChatReply.SessionID;
		_chat.Address = initChatReply.ServerInfo.Address;
		_chat.Port = initChatReply.ServerInfo.Port;
		IsHasInitChat = false;
		if (this.InitChatReplyReceived != null)
		{
			this.InitChatReplyReceived(this, initChatReply);
		}
	}

	private void HandleAllowChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		AllowChatReply arg = AllowChatReply.ParseFrom(ret);
		if (this.AllowChatReplyReceived != null)
		{
			this.AllowChatReplyReceived(this, arg);
		}
	}

	private void HandleInviteChatReply(byte[] body)
	{
		Utility.Decrypt(_svrAddress.Key, body, out byte[] ret);
		InviteChatReply arg = InviteChatReply.ParseFrom(ret);
		if (this.InviteChatReplyReceived != null)
		{
			this.InviteChatReplyReceived(this, arg);
		}
	}

	public void SendChatMsg(string inputMsg, long msgID, MsgType msgType)
	{
		string body = inputMsg.Replace('\r', '\n');
		StringBuilder stringBuilder = new StringBuilder();
		if (string.IsNullOrEmpty(_chat.SessionID) && !IsHasInitChat)
		{
			IsHasInitChat = true;
			SendMsg(SocketMessage.InitChatRequestMsg(msgID, RegistrationService.ChatOnID, _chat.Members, _account.Uid, _account.IMEI, body, _svrAddress.Key, _chat.ChatType, msgType));
			stringBuilder.AppendLine("Msg Type : Init Chat Connection");
		}
		else
		{
			SendMsg(SocketMessage.ChatRequestMsg(msgID, RegistrationService.ChatOnID, _chat.Members, _account.Uid, _account.IMEI, body, _chat.SessionID, _svrAddress.Key, _chat.ChatType, msgType));
			stringBuilder.AppendLine("Msg Type : Send Chat Message");
		}
	}

	public void SendCloseMsg()
	{
		if (!string.IsNullOrEmpty(_chat.SessionID))
		{
			SendMsg(SocketMessage.EndChatRequest(RegistrationService.ChatOnID, _chat.Sender, _account.Uid, _chat.SessionID, _svrAddress.Key, _chat.ChatType));
		}
	}

	public void SendNickNameRequestMsg(string number)
	{
		if (!NickNameRequestList_Done.Contains(number) && !NickNameRequestList_Active.Contains(number))
		{
			NickNameRequestList_Active.Add(number);
			if (NickNameRequest_IsFirstTime)
			{
				NickNameRequest_IsFirstTime = false;
				SendMsg(SocketMessage.NickNameRequest(_account.Uid, _svrAddress.Key, number));
			}
		}
	}

	public void SendTypingRequest()
	{
		if (_chat != null)
		{
			byte[] sendBytes = SocketMessage.IsTypingRequestMsg(RegistrationService.ChatOnID, _chat.SessionID, _chat.ChatType, ContentType.CONTENT_TEXT, _account.Uid, _svrAddress.Key, "active");
			SendMsg(sendBytes);
		}
	}

	public void SendInviteChatRequestMsg(long msgid, List<string> newMembers)
	{
		SendMsg(SocketMessage.InviteChatRequest(msgid, _chat.SessionID, RegistrationService.ChatOnID, _chat.MemberList, newMembers, _svrAddress.Key, _account.Uid));
	}

	internal async void Init()
	{
		_transferredSize = 0u;
		_totalSize = 0;
		IsHasInitChat = false;
		IsHasAllowed = false;
		await Connect();
	}

	internal void Reset()
	{
		this.Connected = null;
		this.AllowChatReplyReceived = null;
		this.DeliveryChatCompleted = null;
		this.InitChatReplyReceived = null;
		this.ChatReplyReceived = null;
		this.AnnounceChangeReceived = null;
		this.EndChatReplyReceived = null;
		this.AnswerBackReceived = null;
		this.NickNameReplyReceived = null;
		this.InviteChatReplyReceived = null;
		this.OnSocketError = null;
		this.OnSocketDisconnected = null;
		IsHasAllowed = false;
		_toEndChat = false;
		_disconnectRequested = false;
		Disconnect();
	}
}
