package com.coolots.chaton.setting.data;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONRejectMsgList implements DisposeInterface {
    private static final String CLASSNAME = "[ChatONRejectMsgList]";
    public static final Object LOCK = new Object();
    private ChatONRejectMsgData mItems;
    public int mMaxCnt;

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ChatONRejectMsgList(List<String> defaultString, int maxCnt) {
        logI("ChatONRejectMsgList1 create");
        this.mMaxCnt = maxCnt;
        this.mItems = loadData(defaultString, maxCnt);
    }

    public ChatONRejectMsgList(int maxCnt, ChatONRejectMsgData initString) {
        logI("ChatONRejectMsgList2 create");
        this.mMaxCnt = maxCnt;
        this.mItems = initString;
    }

    public int getCount() {
        return this.mItems.getCount();
    }

    public boolean canIAddMessage() {
        return this.mItems.getCount() < this.mMaxCnt;
    }

    public int getType(int index) {
        return this.mItems.getType(index);
    }

    public ChatONRejectMsgData getMessageList() {
        return this.mItems;
    }

    public String getMessage(int index) {
        return this.mItems.getMessage(index);
    }

    public boolean modifyMessage(int index, String msg) {
        if (index >= this.mMaxCnt) {
            logI("over");
            return false;
        }
        boolean ret = this.mItems.modifyMessage(index, msg);
        if (!ret) {
            return false;
        }
        saveData();
        return true;
    }

    public boolean addMessage(int type, String msg) {
        if (this.mItems.getCount() >= this.mMaxCnt) {
            logI("over");
            return false;
        }
        boolean ret = this.mItems.addMessage(type, msg);
        if (!ret) {
            return false;
        }
        saveData();
        return true;
    }

    public boolean deleteMessage(int index) {
        boolean ret = this.mItems.deleteMessage(index);
        if (!ret) {
            return false;
        }
        saveData();
        return true;
    }

    public void description() {
        this.mItems.description();
    }

    public void description(int index) {
        this.mItems.description(index);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00e8 A[PHI: r3 r6 r7
  0x00e8: PHI (r3v5 'fis' java.io.FileInputStream) = (r3v4 'fis' java.io.FileInputStream), (r3v7 'fis' java.io.FileInputStream) binds: [B:32:0x009e, B:21:0x0078] A[DONT_GENERATE, DONT_INLINE]
  0x00e8: PHI (r6v3 'items' com.coolots.chaton.setting.data.ChatONRejectMsgData) = 
  (r6v2 'items' com.coolots.chaton.setting.data.ChatONRejectMsgData)
  (r6v5 'items' com.coolots.chaton.setting.data.ChatONRejectMsgData)
 binds: [B:32:0x009e, B:21:0x0078] A[DONT_GENERATE, DONT_INLINE]
  0x00e8: PHI (r7v5 'ois' java.io.ObjectInputStream) = (r7v4 'ois' java.io.ObjectInputStream), (r7v7 'ois' java.io.ObjectInputStream) binds: [B:32:0x009e, B:21:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.coolots.chaton.setting.data.ChatONRejectMsgData loadData(java.util.List<java.lang.String> r13, int r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.setting.data.ChatONRejectMsgList.loadData(java.util.List, int):com.coolots.chaton.setting.data.ChatONRejectMsgData");
    }

    private void saveData() {
        new Thread() { // from class: com.coolots.chaton.setting.data.ChatONRejectMsgList.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x008e, IOException -> 0x00a4, TRY_LEAVE, TryCatch #3 {IOException -> 0x00a4, blocks: (B:12:0x0065, B:14:0x006a), top: B:54:0x0065, outer: #9 }] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00aa  */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r10 = this;
                    java.lang.Object r7 = com.coolots.chaton.setting.data.ChatONRejectMsgList.LOCK
                    monitor-enter(r7)
                    java.lang.String r6 = "saveData()+++"
                    com.coolots.chaton.setting.data.ChatONRejectMsgList.access$0(r6)     // Catch: java.lang.Throwable -> L8e
                    r2 = 0
                    r4 = 0
                    android.content.Context r6 = com.sds.coolots.MainApplication.mContext     // Catch: java.lang.Throwable -> L8e
                    android.content.Context r8 = com.sds.coolots.MainApplication.mContext     // Catch: java.lang.Throwable -> L8e
                    android.content.Context r8 = r8.getApplicationContext()     // Catch: java.lang.Throwable -> L8e
                    java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Throwable -> L8e
                    r9 = 0
                    java.io.File r0 = r6.getDir(r8, r9)     // Catch: java.lang.Throwable -> L8e
                    java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.io.File r6 = new java.io.File     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    r8.<init>()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.lang.StringBuilder r8 = r8.append(r0)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.lang.String r9 = "/"
                    java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.lang.String r9 = "reject_message"
                    java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.lang.String r9 = ".obj"
                    java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    r6.<init>(r8)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    r3.<init>(r6)     // Catch: java.lang.Exception -> L76 java.lang.Throwable -> L91
                    java.io.ObjectOutputStream r5 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb4
                    r5.<init>(r3)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb4
                    com.coolots.chaton.setting.data.ChatONRejectMsgList r6 = com.coolots.chaton.setting.data.ChatONRejectMsgList.this     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                    com.coolots.chaton.setting.data.ChatONRejectMsgData r6 = com.coolots.chaton.setting.data.ChatONRejectMsgList.access$1(r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                    if (r6 == 0) goto L5a
                    com.coolots.chaton.setting.data.ChatONRejectMsgList r6 = com.coolots.chaton.setting.data.ChatONRejectMsgList.this     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                    com.coolots.chaton.setting.data.ChatONRejectMsgData r6 = com.coolots.chaton.setting.data.ChatONRejectMsgList.access$1(r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                    r5.writeObject(r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                L5a:
                    com.coolots.chaton.setting.data.ChatONRejectMsgList r6 = com.coolots.chaton.setting.data.ChatONRejectMsgList.this     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                    com.coolots.chaton.setting.data.ChatONRejectMsgData r6 = com.coolots.chaton.setting.data.ChatONRejectMsgList.access$1(r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                    r6.description()     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb7
                    if (r3 == 0) goto L68
                    r3.close()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> La4
                L68:
                    if (r5 == 0) goto Laa
                    r5.close()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> La4
                    r4 = r5
                    r2 = r3
                L6f:
                    java.lang.String r6 = "saveData()--"
                    com.coolots.chaton.setting.data.ChatONRejectMsgList.access$0(r6)     // Catch: java.lang.Throwable -> L8e
                    monitor-exit(r7)     // Catch: java.lang.Throwable -> L8e
                    return
                L76:
                    r1 = move-exception
                L77:
                    java.lang.String r6 = "Exception"
                    com.coolots.chaton.setting.data.ChatONRejectMsgList.access$0(r6)     // Catch: java.lang.Throwable -> L91
                    if (r2 == 0) goto L81
                    r2.close()     // Catch: java.io.IOException -> L87 java.lang.Throwable -> L8e
                L81:
                    if (r4 == 0) goto L6f
                    r4.close()     // Catch: java.io.IOException -> L87 java.lang.Throwable -> L8e
                    goto L6f
                L87:
                    r1 = move-exception
                    java.lang.String r6 = "IOException"
                    com.coolots.chaton.setting.data.ChatONRejectMsgList.access$0(r6)     // Catch: java.lang.Throwable -> L8e
                    goto L6f
                L8e:
                    r6 = move-exception
                    monitor-exit(r7)     // Catch: java.lang.Throwable -> L8e
                    throw r6
                L91:
                    r6 = move-exception
                L92:
                    if (r2 == 0) goto L97
                    r2.close()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L9d
                L97:
                    if (r4 == 0) goto L9c
                    r4.close()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L9d
                L9c:
                    throw r6     // Catch: java.lang.Throwable -> L8e
                L9d:
                    r1 = move-exception
                    java.lang.String r8 = "IOException"
                    com.coolots.chaton.setting.data.ChatONRejectMsgList.access$0(r8)     // Catch: java.lang.Throwable -> L8e
                    goto L9c
                La4:
                    r1 = move-exception
                    java.lang.String r6 = "IOException"
                    com.coolots.chaton.setting.data.ChatONRejectMsgList.access$0(r6)     // Catch: java.lang.Throwable -> L8e
                Laa:
                    r4 = r5
                    r2 = r3
                    goto L6f
                Lad:
                    r6 = move-exception
                    r2 = r3
                    goto L92
                Lb0:
                    r6 = move-exception
                    r4 = r5
                    r2 = r3
                    goto L92
                Lb4:
                    r1 = move-exception
                    r2 = r3
                    goto L77
                Lb7:
                    r1 = move-exception
                    r4 = r5
                    r2 = r3
                    goto L77
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.setting.data.ChatONRejectMsgList.C04271.run():void");
            }
        }.run();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mItems != null) {
            this.mItems.dispose();
            this.mItems = null;
        }
    }
}
