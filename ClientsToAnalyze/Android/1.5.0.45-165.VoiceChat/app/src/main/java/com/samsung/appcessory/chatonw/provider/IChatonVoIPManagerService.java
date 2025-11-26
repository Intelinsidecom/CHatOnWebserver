package com.samsung.appcessory.chatonw.provider;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IChatonVoIPManagerService extends IInterface {
    void notifyCallConnected(int i) throws RemoteException;

    void notifyCallDisconnected(int i, int i2) throws RemoteException;

    void notifyChangeCallType(boolean z) throws RemoteException;

    void notifyChangeConfToP2PCall(int i, String str, String str2, boolean z) throws RemoteException;

    void notifyChangeP2PToConfCall(int i, List<String> list, List<String> list2, String str, boolean z) throws RemoteException;

    void notifyConfCallOutFromPhone(int i, List<String> list, List<String> list2, String str, boolean z) throws RemoteException;

    void notifyConferenceCallRinging(int i, List<String> list, List<String> list2, String str, boolean z, boolean z2) throws RemoteException;

    void notifyHoldState(int i, boolean z) throws RemoteException;

    void notifyMuteState(int i, boolean z) throws RemoteException;

    void notifyP2PCallOutFromPhone(int i, String str, String str2, boolean z) throws RemoteException;

    void notifyP2PCallRinging(int i, String str, String str2, boolean z, boolean z2) throws RemoteException;

    void notifyStartCallResult(int i, boolean z) throws RemoteException;

    void notifyStopRingtone(int i) throws RemoteException;

    void notifyUpdateConferenceMember(int i, List<String> list, List<String> list2, List<String> list3, String str, boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IChatonVoIPManagerService {
        private static final String DESCRIPTOR = "com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService";
        static final int TRANSACTION_notifyCallConnected = 2;
        static final int TRANSACTION_notifyCallDisconnected = 1;
        static final int TRANSACTION_notifyChangeCallType = 12;
        static final int TRANSACTION_notifyChangeConfToP2PCall = 10;
        static final int TRANSACTION_notifyChangeP2PToConfCall = 11;
        static final int TRANSACTION_notifyConfCallOutFromPhone = 7;
        static final int TRANSACTION_notifyConferenceCallRinging = 4;
        static final int TRANSACTION_notifyHoldState = 8;
        static final int TRANSACTION_notifyMuteState = 9;
        static final int TRANSACTION_notifyP2PCallOutFromPhone = 6;
        static final int TRANSACTION_notifyP2PCallRinging = 3;
        static final int TRANSACTION_notifyStartCallResult = 5;
        static final int TRANSACTION_notifyStopRingtone = 13;
        static final int TRANSACTION_notifyUpdateConferenceMember = 14;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IChatonVoIPManagerService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IChatonVoIPManagerService)) {
                return (IChatonVoIPManagerService) iin;
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
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    notifyCallDisconnected(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg02 = data.readInt();
                    notifyCallConnected(_arg02);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    String _arg12 = data.readString();
                    String _arg2 = data.readString();
                    boolean _arg3 = data.readInt() != 0;
                    boolean _arg4 = data.readInt() != 0;
                    notifyP2PCallRinging(_arg03, _arg12, _arg2, _arg3, _arg4);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    List<String> _arg13 = data.createStringArrayList();
                    List<String> _arg22 = data.createStringArrayList();
                    String _arg32 = data.readString();
                    boolean _arg42 = data.readInt() != 0;
                    boolean _arg5 = data.readInt() != 0;
                    notifyConferenceCallRinging(_arg04, _arg13, _arg22, _arg32, _arg42, _arg5);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    boolean _arg14 = data.readInt() != 0;
                    notifyStartCallResult(_arg05, _arg14);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg06 = data.readInt();
                    String _arg15 = data.readString();
                    String _arg23 = data.readString();
                    boolean _arg33 = data.readInt() != 0;
                    notifyP2PCallOutFromPhone(_arg06, _arg15, _arg23, _arg33);
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    List<String> _arg16 = data.createStringArrayList();
                    List<String> _arg24 = data.createStringArrayList();
                    String _arg34 = data.readString();
                    boolean _arg43 = data.readInt() != 0;
                    notifyConfCallOutFromPhone(_arg07, _arg16, _arg24, _arg34, _arg43);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg08 = data.readInt();
                    boolean _arg17 = data.readInt() != 0;
                    notifyHoldState(_arg08, _arg17);
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg09 = data.readInt();
                    boolean _arg18 = data.readInt() != 0;
                    notifyMuteState(_arg09, _arg18);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg010 = data.readInt();
                    String _arg19 = data.readString();
                    String _arg25 = data.readString();
                    boolean _arg35 = data.readInt() != 0;
                    notifyChangeConfToP2PCall(_arg010, _arg19, _arg25, _arg35);
                    reply.writeNoException();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg011 = data.readInt();
                    List<String> _arg110 = data.createStringArrayList();
                    List<String> _arg26 = data.createStringArrayList();
                    String _arg36 = data.readString();
                    boolean _arg44 = data.readInt() != 0;
                    notifyChangeP2PToConfCall(_arg011, _arg110, _arg26, _arg36, _arg44);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg012 = data.readInt() != 0;
                    notifyChangeCallType(_arg012);
                    reply.writeNoException();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg013 = data.readInt();
                    notifyStopRingtone(_arg013);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg014 = data.readInt();
                    List<String> _arg111 = data.createStringArrayList();
                    List<String> _arg27 = data.createStringArrayList();
                    List<String> _arg37 = data.createStringArrayList();
                    String _arg45 = data.readString();
                    boolean _arg52 = data.readInt() != 0;
                    notifyUpdateConferenceMember(_arg014, _arg111, _arg27, _arg37, _arg45, _arg52);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IChatonVoIPManagerService {
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

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyCallDisconnected(int callInstanceID, int rejectReason) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callInstanceID);
                    _data.writeInt(rejectReason);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyCallConnected(int callInstanceID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callInstanceID);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyP2PCallRinging(int callInstanceID, String buddyid, String buddyname, boolean isVideoCall, boolean isKnownBuddy) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callInstanceID);
                    _data.writeString(buddyid);
                    _data.writeString(buddyname);
                    _data.writeInt(isVideoCall ? 1 : 0);
                    _data.writeInt(isKnownBuddy ? 1 : 0);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyConferenceCallRinging(int callInstanceID, List<String> partiList, List<String> partiNames, String groupName, boolean isVideoCall, boolean isKnownBuddy) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callInstanceID);
                    _data.writeStringList(partiList);
                    _data.writeStringList(partiNames);
                    _data.writeString(groupName);
                    _data.writeInt(isVideoCall ? 1 : 0);
                    _data.writeInt(isKnownBuddy ? 1 : 0);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyStartCallResult(int callID, boolean isStartCall) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeInt(isStartCall ? 1 : 0);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyP2PCallOutFromPhone(int callID, String phoneNumber, String name, boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeString(phoneNumber);
                    _data.writeString(name);
                    _data.writeInt(isVideo ? 1 : 0);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyConfCallOutFromPhone(int callID, List<String> participants, List<String> participantsNames, String groupName, boolean isVideo) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeStringList(participants);
                    _data.writeStringList(participantsNames);
                    _data.writeString(groupName);
                    _data.writeInt(isVideo ? 1 : 0);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyHoldState(int callID, boolean holdState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeInt(holdState ? 1 : 0);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyMuteState(int callID, boolean muteState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeInt(muteState ? 1 : 0);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyChangeConfToP2PCall(int callID, String phoneNo, String userName, boolean isVideoCall) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeString(phoneNo);
                    _data.writeString(userName);
                    _data.writeInt(isVideoCall ? 1 : 0);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyChangeP2PToConfCall(int callID, List<String> participantsIDs, List<String> participantNames, String groupName, boolean isVideoCall) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeStringList(participantsIDs);
                    _data.writeStringList(participantNames);
                    _data.writeString(groupName);
                    _data.writeInt(isVideoCall ? 1 : 0);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyChangeCallType(boolean isVideoCall) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(isVideoCall ? 1 : 0);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyStopRingtone(int callID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.samsung.appcessory.chatonw.provider.IChatonVoIPManagerService
            public void notifyUpdateConferenceMember(int callID, List<String> participants, List<String> participantsNames, List<String> participantsStatus, String groupName, boolean isVideoCall) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(callID);
                    _data.writeStringList(participants);
                    _data.writeStringList(participantsNames);
                    _data.writeStringList(participantsStatus);
                    _data.writeString(groupName);
                    _data.writeInt(isVideoCall ? 1 : 0);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
