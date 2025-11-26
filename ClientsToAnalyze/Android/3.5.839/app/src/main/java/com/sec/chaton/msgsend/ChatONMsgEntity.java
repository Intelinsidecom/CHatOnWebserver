package com.sec.chaton.msgsend;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.util.C4874cl;

/* loaded from: classes.dex */
public class ChatONMsgEntity implements Parcelable {
    private String mChatMsg;
    private String mChatMsgTranslated;
    private long mCreateTime;
    private String mFormattedMsg;
    private int mIsFileUploaded;
    private boolean mIsInProgress;
    private long mLastSendEndTime;
    private long mLastSendTryTime;
    private String mLocalFileUri;
    private Long mMsgId;
    private EnumC2692aj mMsgSendStatus;
    private EnumC2214ab mMsgType;
    private int mSendTryCount;
    private static final String TAG = ChatONMsgEntity.class.getSimpleName();
    public static final Parcelable.Creator<ChatONMsgEntity> CREATOR = new C2700h();

    /* renamed from: m */
    private void m11250m() {
        if (this.mSendTryCount <= 1) {
            this.mCreateTime = SystemClock.uptimeMillis();
        }
    }

    /* renamed from: a */
    public void m11253a() {
        this.mMsgSendStatus = EnumC2692aj.SENDING;
        this.mSendTryCount++;
        this.mLastSendTryTime = SystemClock.uptimeMillis();
    }

    /* renamed from: b */
    public void m11257b() {
        this.mLastSendEndTime = SystemClock.uptimeMillis();
    }

    /* renamed from: c */
    public boolean m11258c() {
        switch (this.mMsgSendStatus) {
            case PENDING:
                if (!this.mIsInProgress) {
                    if (this.mSendTryCount <= 720) {
                        break;
                    } else {
                        C2684ab.m11290a(TAG, "doesNeedToResend(), Too many retry this msg : %s", this);
                        C2684ab.m11290a(TAG, "doesNeedToResend(), Too many retry this msg : %s", this);
                        C2684ab.m11290a(TAG, "doesNeedToResend(), WToo many retry this msg : %s", this);
                        this.mMsgSendStatus = EnumC2692aj.FAILED;
                        C2204r.m10041b(GlobalApplication.m18732r().getContentResolver(), this.mMsgId);
                        break;
                    }
                }
                break;
        }
        return false;
    }

    /* renamed from: d */
    String m11259d() {
        String string = "(not completed to send)";
        if (this.mLastSendEndTime >= this.mCreateTime) {
            string = new C2705m(this.mLastSendEndTime, this.mCreateTime).toString();
        }
        return String.format("TryCount(%d), Create(%d)/LastSendTry(%d)/LastSendEnd(%d) --> %s", Integer.valueOf(this.mSendTryCount), Long.valueOf(this.mCreateTime), Long.valueOf(this.mLastSendTryTime), Long.valueOf(this.mLastSendEndTime), string);
    }

    /* renamed from: e */
    public Long m11260e() {
        return this.mMsgId;
    }

    /* renamed from: f */
    public EnumC2214ab m11261f() {
        return this.mMsgType;
    }

    /* renamed from: a */
    public void m11254a(String str) {
        this.mChatMsg = str;
    }

    /* renamed from: g */
    public String m11262g() {
        return this.mChatMsg;
    }

    /* renamed from: h */
    public String m11263h() {
        return this.mChatMsgTranslated;
    }

    /* renamed from: i */
    public String m11264i() {
        return this.mLocalFileUri;
    }

    /* renamed from: j */
    public String m11265j() {
        return this.mFormattedMsg;
    }

    /* renamed from: k */
    public int m11266k() {
        return this.mIsFileUploaded;
    }

    /* renamed from: a */
    public void m11255a(boolean z) {
        this.mIsInProgress = z;
    }

    /* renamed from: l */
    public EnumC2692aj m11267l() {
        return this.mMsgSendStatus;
    }

    /* renamed from: a */
    public EnumC2692aj m11252a(EnumC2692aj enumC2692aj) {
        EnumC2692aj enumC2692aj2 = this.mMsgSendStatus;
        this.mMsgSendStatus = enumC2692aj;
        return enumC2692aj2;
    }

    /* renamed from: b */
    public String m11256b(String str) {
        String str2 = this.mFormattedMsg;
        this.mFormattedMsg = str;
        return str2;
    }

    /* renamed from: a */
    public int m11251a(int i) {
        int i2 = this.mIsFileUploaded;
        this.mIsFileUploaded = i;
        return i2;
    }

    public ChatONMsgEntity(long j, EnumC2214ab enumC2214ab, String str, String str2, String str3, String str4, int i, int i2) {
        this(j, enumC2214ab, str, str2, str3, str4, i, EnumC2692aj.m11301a(i2));
    }

    public ChatONMsgEntity(long j, EnumC2214ab enumC2214ab, String str, String str2, String str3, String str4, int i, EnumC2692aj enumC2692aj) {
        this.mIsInProgress = false;
        this.mSendTryCount = 0;
        this.mCreateTime = 0L;
        this.mLastSendTryTime = 0L;
        this.mLastSendEndTime = 0L;
        this.mMsgSendStatus = enumC2692aj;
        this.mMsgId = Long.valueOf(j);
        this.mMsgType = enumC2214ab;
        this.mChatMsg = str;
        this.mChatMsgTranslated = str2;
        this.mLocalFileUri = str3;
        this.mFormattedMsg = str4;
        this.mIsFileUploaded = i;
        m11250m();
    }

    public ChatONMsgEntity(Parcel parcel) {
        this.mIsInProgress = false;
        this.mSendTryCount = 0;
        this.mCreateTime = 0L;
        this.mLastSendTryTime = 0L;
        this.mLastSendEndTime = 0L;
        this.mMsgSendStatus = EnumC2692aj.m11301a(parcel.readInt());
        this.mSendTryCount = parcel.readInt();
        this.mCreateTime = parcel.readLong();
        this.mLastSendTryTime = parcel.readLong();
        this.mMsgId = Long.valueOf(parcel.readLong());
        this.mMsgType = EnumC2214ab.m10070a(parcel.readInt());
        this.mChatMsg = parcel.readString();
        this.mChatMsgTranslated = parcel.readString();
        this.mLocalFileUri = parcel.readString();
        this.mFormattedMsg = parcel.readString();
        this.mIsFileUploaded = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMsgSendStatus.m11302a());
        parcel.writeInt(this.mSendTryCount);
        parcel.writeLong(this.mCreateTime);
        parcel.writeLong(this.mLastSendTryTime);
        parcel.writeLong(this.mMsgId.longValue());
        parcel.writeInt(this.mMsgType.m10076a());
        parcel.writeString(this.mChatMsg);
        parcel.writeString(this.mChatMsgTranslated);
        parcel.writeString(this.mLocalFileUri);
        parcel.writeString(this.mFormattedMsg);
        parcel.writeInt(this.mIsFileUploaded);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[MsgEntity]msgId: " + this.mMsgId + ", msgType: " + this.mMsgType + ", chatMsg: " + C4874cl.m18506a(this.mChatMsg, 3) + ", chatMsg(Tsl): " + C4874cl.m18506a(this.mChatMsgTranslated, 3) + ", downUri: " + this.mLocalFileUri + ", formattedMsg: " + this.mFormattedMsg + ", isUploaded: " + this.mIsFileUploaded + ", statistics: " + m11259d();
    }

    public int hashCode() {
        return this.mMsgId.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && this.mMsgId.equals(((ChatONMsgEntity) obj).mMsgId);
    }
}
