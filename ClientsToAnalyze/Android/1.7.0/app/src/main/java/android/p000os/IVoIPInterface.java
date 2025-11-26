package android.p000os;

import android.p000os.IVoIPCallbackInterface;

/* loaded from: classes.dex */
public interface IVoIPInterface extends IInterface {
    boolean answerVoIPCall();

    void callInVoIP(String str);

    boolean canUseBTInVoIP(String str);

    boolean createCallSession(String str, String str2, String str3, IVoIPCallbackInterface iVoIPCallbackInterface);

    boolean destroyCallSession(String str);

    void dumpCallSessionInfoDB(String str);

    String getCurrentVoIPNumber();

    int getSessionCount();

    int getVoIPCallCount(String str);

    boolean hangupVoIPCall();

    boolean holdVoIPCall();

    boolean isVoIPActivated();

    boolean isVoIPDialing();

    boolean isVoIPIdle();

    boolean isVoIPRingOrDialing();

    boolean isVoIPRinging();

    boolean moveVoIPToTop();

    boolean resumeVoIPCall();

    boolean setBTUserWantsAudioOn(boolean z);

    void setEngMode(String str, int i);

    boolean setUseBTInVoIP(String str, boolean z);

    boolean setVoIPActive(String str);

    boolean setVoIPCallCount(String str, int i);

    boolean setVoIPDialing(String str);

    boolean setVoIPDisconnected(String str);

    boolean setVoIPDisconnecting(String str);

    boolean setVoIPHolding(String str);

    boolean setVoIPIdle(String str);

    boolean setVoIPRinging(String str);

    public abstract class Stub extends Binder implements IVoIPInterface {
        private static final String DESCRIPTOR = "android.os.IVoIPInterface";
        static final int TRANSACTION_answerVoIPCall = 4;
        static final int TRANSACTION_callInVoIP = 26;
        static final int TRANSACTION_canUseBTInVoIP = 18;
        static final int TRANSACTION_createCallSession = 1;
        static final int TRANSACTION_destroyCallSession = 2;
        static final int TRANSACTION_dumpCallSessionInfoDB = 28;
        static final int TRANSACTION_getCurrentVoIPNumber = 25;
        static final int TRANSACTION_getSessionCount = 27;
        static final int TRANSACTION_getVoIPCallCount = 9;
        static final int TRANSACTION_hangupVoIPCall = 5;
        static final int TRANSACTION_holdVoIPCall = 6;
        static final int TRANSACTION_isVoIPActivated = 24;
        static final int TRANSACTION_isVoIPDialing = 23;
        static final int TRANSACTION_isVoIPIdle = 20;
        static final int TRANSACTION_isVoIPRingOrDialing = 21;
        static final int TRANSACTION_isVoIPRinging = 22;
        static final int TRANSACTION_moveVoIPToTop = 3;
        static final int TRANSACTION_resumeVoIPCall = 7;
        static final int TRANSACTION_setBTUserWantsAudioOn = 19;
        static final int TRANSACTION_setEngMode = 29;
        static final int TRANSACTION_setUseBTInVoIP = 17;
        static final int TRANSACTION_setVoIPActive = 13;
        static final int TRANSACTION_setVoIPCallCount = 8;
        static final int TRANSACTION_setVoIPDialing = 12;
        static final int TRANSACTION_setVoIPDisconnected = 16;
        static final int TRANSACTION_setVoIPDisconnecting = 15;
        static final int TRANSACTION_setVoIPHolding = 14;
        static final int TRANSACTION_setVoIPIdle = 10;
        static final int TRANSACTION_setVoIPRinging = 11;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVoIPInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IVoIPInterface)) {
                return (IVoIPInterface) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zCreateCallSession = createCallSession(parcel.readString(), parcel.readString(), parcel.readString(), IVoIPCallbackInterface.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(zCreateCallSession ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zDestroyCallSession = destroyCallSession(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDestroyCallSession ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zMoveVoIPToTop = moveVoIPToTop();
                    parcel2.writeNoException();
                    parcel2.writeInt(zMoveVoIPToTop ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zAnswerVoIPCall = answerVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zAnswerVoIPCall ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zHangupVoIPCall = hangupVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zHangupVoIPCall ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zHoldVoIPCall = holdVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zHoldVoIPCall ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zResumeVoIPCall = resumeVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zResumeVoIPCall ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPCallCount = setVoIPCallCount(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPCallCount ? 1 : 0);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int voIPCallCount2 = getVoIPCallCount(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPCallCount2);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPIdle = setVoIPIdle(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPIdle ? 1 : 0);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPRinging = setVoIPRinging(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPRinging ? 1 : 0);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPDialing = setVoIPDialing(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPDialing ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPActive = setVoIPActive(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPActive ? 1 : 0);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPHolding = setVoIPHolding(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPHolding ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPDisconnecting = setVoIPDisconnecting(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPDisconnecting ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean voIPDisconnected = setVoIPDisconnected(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(voIPDisconnected ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean useBTInVoIP = setUseBTInVoIP(parcel.readString(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(useBTInVoIP ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zCanUseBTInVoIP = canUseBTInVoIP(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCanUseBTInVoIP ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean bTUserWantsAudioOn = setBTUserWantsAudioOn(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(bTUserWantsAudioOn ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsVoIPIdle = isVoIPIdle();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsVoIPIdle ? 1 : 0);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsVoIPRingOrDialing = isVoIPRingOrDialing();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsVoIPRingOrDialing ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsVoIPRinging = isVoIPRinging();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsVoIPRinging ? 1 : 0);
                    return true;
                case 23:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsVoIPDialing = isVoIPDialing();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsVoIPDialing ? 1 : 0);
                    return true;
                case 24:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zIsVoIPActivated = isVoIPActivated();
                    parcel2.writeNoException();
                    parcel2.writeInt(zIsVoIPActivated ? 1 : 0);
                    return true;
                case 25:
                    parcel.enforceInterface(DESCRIPTOR);
                    String currentVoIPNumber = getCurrentVoIPNumber();
                    parcel2.writeNoException();
                    parcel2.writeString(currentVoIPNumber);
                    return true;
                case 26:
                    parcel.enforceInterface(DESCRIPTOR);
                    callInVoIP(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(DESCRIPTOR);
                    int sessionCount = getSessionCount();
                    parcel2.writeNoException();
                    parcel2.writeInt(sessionCount);
                    return true;
                case 28:
                    parcel.enforceInterface(DESCRIPTOR);
                    dumpCallSessionInfoDB(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 29:
                    parcel.enforceInterface(DESCRIPTOR);
                    setEngMode(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        class Proxy implements IVoIPInterface {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.p000os.IVoIPInterface
            public boolean createCallSession(String str, String str2, String str3, IVoIPCallbackInterface iVoIPCallbackInterface) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(iVoIPCallbackInterface != null ? iVoIPCallbackInterface.asBinder() : null);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean destroyCallSession(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean moveVoIPToTop() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean answerVoIPCall() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean hangupVoIPCall() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean holdVoIPCall() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean resumeVoIPCall() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPCallCount(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public int getVoIPCallCount(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPIdle(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPRinging(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(11, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPDialing(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(12, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPActive(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(13, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPHolding(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(14, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPDisconnecting(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(15, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setVoIPDisconnected(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(16, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setUseBTInVoIP(String str, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(17, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean canUseBTInVoIP(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(18, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean setBTUserWantsAudioOn(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(19, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean isVoIPIdle() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean isVoIPRingOrDialing() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(21, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean isVoIPRinging() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(22, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean isVoIPDialing() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(23, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public boolean isVoIPActivated() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(24, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public String getCurrentVoIPNumber() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(25, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public void callInVoIP(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(26, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public int getSessionCount() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(27, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public void dumpCallSessionInfoDB(String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(28, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPInterface
            public void setEngMode(String str, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(29, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
