package android.p000os;

/* loaded from: classes.dex */
public interface IVoIPCallbackInterface extends IInterface {
    boolean answerVoIPCall();

    boolean hangupVoIPCall();

    boolean holdVoIPCall();

    boolean moveVoIPToTop();

    boolean resumeVoIPCall();

    public abstract class Stub extends Binder implements IVoIPCallbackInterface {
        private static final String DESCRIPTOR = "android.os.IVoIPCallbackInterface";
        static final int TRANSACTION_answerVoIPCall = 1;
        static final int TRANSACTION_hangupVoIPCall = 2;
        static final int TRANSACTION_holdVoIPCall = 4;
        static final int TRANSACTION_moveVoIPToTop = 3;
        static final int TRANSACTION_resumeVoIPCall = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVoIPCallbackInterface asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IVoIPCallbackInterface)) {
                return (IVoIPCallbackInterface) iInterfaceQueryLocalInterface;
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
                    boolean zAnswerVoIPCall = answerVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zAnswerVoIPCall ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zHangupVoIPCall = hangupVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zHangupVoIPCall ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zMoveVoIPToTop = moveVoIPToTop();
                    parcel2.writeNoException();
                    parcel2.writeInt(zMoveVoIPToTop ? 1 : 0);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zHoldVoIPCall = holdVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zHoldVoIPCall ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean zResumeVoIPCall = resumeVoIPCall();
                    parcel2.writeNoException();
                    parcel2.writeInt(zResumeVoIPCall ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        class Proxy implements IVoIPCallbackInterface {
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

            @Override // android.p000os.IVoIPCallbackInterface
            public boolean answerVoIPCall() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPCallbackInterface
            public boolean hangupVoIPCall() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.p000os.IVoIPCallbackInterface
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

            @Override // android.p000os.IVoIPCallbackInterface
            public boolean holdVoIPCall() {
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

            @Override // android.p000os.IVoIPCallbackInterface
            public boolean resumeVoIPCall() {
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
        }
    }
}
