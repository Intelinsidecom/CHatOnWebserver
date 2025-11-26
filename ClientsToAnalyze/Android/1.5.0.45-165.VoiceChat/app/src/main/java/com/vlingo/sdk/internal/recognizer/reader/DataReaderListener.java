package com.vlingo.sdk.internal.recognizer.reader;

/* loaded from: classes.dex */
public interface DataReaderListener {

    public enum ErrorCode {
        READ_ERROR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ErrorCode[] valuesCustom() {
            ErrorCode[] errorCodeArrValuesCustom = values();
            int length = errorCodeArrValuesCustom.length;
            ErrorCode[] errorCodeArr = new ErrorCode[length];
            System.arraycopy(errorCodeArrValuesCustom, 0, errorCodeArr, 0, length);
            return errorCodeArr;
        }
    }

    void onDataAvailable(byte[] bArr, int i);

    void onError(ErrorCode errorCode, String str);

    void onStarted();

    void onStopped(int i, boolean z);
}
