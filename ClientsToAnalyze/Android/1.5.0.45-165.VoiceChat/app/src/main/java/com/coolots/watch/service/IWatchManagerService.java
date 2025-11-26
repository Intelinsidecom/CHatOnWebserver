package com.coolots.watch.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IWatchManagerService extends IInterface {
    int conferenceCallOutFromWatch(List<String> list, String str) throws RemoteException;

    List<String> getRejectWithMessageList() throws RemoteException;

    boolean hangupCallFromWatch(int i) throws RemoteException;

    int p2pCallOutFromWatch(String str) throws RemoteException;

    boolean receiveCallFromWatch(int i) throws RemoteException;

    boolean setMuteCallStateFromWatch(int i, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IWatchManagerService {
        private static final String DESCRIPTOR = "com.coolots.watch.service.IWatchManagerService";
        static final int TRANSACTION_conferenceCallOutFromWatch = 2;
        static final int TRANSACTION_getRejectWithMessageList = 6;
        static final int TRANSACTION_hangupCallFromWatch = 3;
        static final int TRANSACTION_p2pCallOutFromWatch = 1;
        static final int TRANSACTION_receiveCallFromWatch = 4;
        static final int TRANSACTION_setMuteCallStateFromWatch = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IWatchManagerService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IWatchManagerService)) {
                return (IWatchManagerService) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _result = p2pCallOutFromWatch(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _arg02 = data.createStringArrayList();
                    String _arg1 = data.readString();
                    int _result2 = conferenceCallOutFromWatch(_arg02, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    boolean _result3 = hangupCallFromWatch(_arg03);
                    reply.writeNoException();
                    reply.writeInt(_result3 ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    boolean _result4 = receiveCallFromWatch(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result4 ? 1 : 0);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    boolean _arg12 = data.readInt() != 0;
                    boolean _result5 = setMuteCallStateFromWatch(_arg05, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result5 ? 1 : 0);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    List<String> _result6 = getRejectWithMessageList();
                    reply.writeNoException();
                    reply.writeStringList(_result6);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IWatchManagerService {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.coolots.watch.service.IWatchManagerService
            public int p2pCallOutFromWatch(String buddy) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(buddy);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.coolots.watch.service.IWatchManagerService
            public int conferenceCallOutFromWatch(List<String> participants, String groupName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStringList(participants);
                    _data.writeString(groupName);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.coolots.watch.service.IWatchManagerService
            public boolean hangupCallFromWatch(int callID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.coolots.watch.service.IWatchManagerService
            public boolean receiveCallFromWatch(int callID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.coolots.watch.service.IWatchManagerService
            public boolean setMuteCallStateFromWatch(int callID, boolean muteCall) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeInt(muteCall ? 1 : 0);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.coolots.watch.service.IWatchManagerService
            public List<String> getRejectWithMessageList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
