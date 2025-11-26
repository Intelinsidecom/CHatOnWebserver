package com.sec.chaton.smsplugin.transaction;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.util.Iterator;

/* compiled from: TransactionService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.an */
/* loaded from: classes.dex */
final class HandlerC4063an extends Handler {

    /* renamed from: a */
    final /* synthetic */ TransactionService f14646a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC4063an(TransactionService transactionService, Looper looper) {
        super(looper);
        this.f14646a = transactionService;
    }

    /* renamed from: a */
    private String m15633a(Message message) {
        if (message.what == 100) {
            return "EVENT_QUIT";
        }
        if (message.what == 3) {
            return "EVENT_CONTINUE_MMS_CONNECTIVITY";
        }
        if (message.what == 1) {
            return "EVENT_TRANSACTION_REQUEST";
        }
        if (message.what == 4) {
            return "EVENT_HANDLE_NEXT_PENDING_TRANSACTION";
        }
        return "unknown message.what";
    }

    /* renamed from: a */
    private String m15632a(int i) {
        if (i == 0) {
            return "NOTIFICATION_TRANSACTION";
        }
        if (i == 1) {
            return "RETRIEVE_TRANSACTION";
        }
        if (i == 2) {
            return "SEND_TRANSACTION";
        }
        if (i == 3) {
            return "READREC_TRANSACTION";
        }
        return "invalid transaction type";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:49|(2:51|52)(3:57|(2:59|(2:65|(3:67|34|111)(1:114))(1:63))(1:93)|64)|97|53|(1:(1:56)(1:113))(2:72|(1:74)(1:115))|34|111) */
    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01f0, code lost:
    
        com.sec.chaton.smsplugin.p111h.C3896s.m15041a("Exception occurred while handling message: " + r10 + " " + r1.getMessage(), "TransactionService");
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0219, code lost:
    
        if (r2 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x021b, code lost:
    
        r2.m15696b(r9.f14646a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x022a, code lost:
    
        if (r9.f14646a.f14600d.contains(r2) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0232, code lost:
    
        monitor-enter(r9.f14646a.f14600d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0233, code lost:
    
        r9.f14646a.f14600d.remove(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x023d, code lost:
    
        if (r8 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x023f, code lost:
    
        com.sec.chaton.smsplugin.p111h.C3896s.m15046d("Transaction was null. Stopping self: " + r3, "TransactionService");
        r9.f14646a.m15596b();
        r1 = r9.f14646a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0386, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0387, code lost:
    
        com.sec.chaton.smsplugin.p111h.C3896s.m15041a("Unexpected Throwable." + r1.getMessage(), "TransactionService");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x03dd, code lost:
    
        r1 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x03e0, code lost:
    
        r8 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0344 A[Catch: all -> 0x03da, Exception -> 0x03dd, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x03dd, blocks: (B:53:0x0279, B:72:0x0344), top: B:97:0x0279 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03ac  */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.os.Message r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1028
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.HandlerC4063an.handleMessage(android.os.Message):void");
    }

    /* renamed from: a */
    public void m15635a(AbstractC4059aj abstractC4059aj, C4064ao c4064ao) {
        AbstractC4059aj abstractC4059aj2;
        int size;
        if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
            C3890m.m14994a("TransactionService", "processPendingTxn: transaction=" + abstractC4059aj);
        }
        synchronized (this.f14646a.f14600d) {
            abstractC4059aj2 = this.f14646a.f14601e.size() != 0 ? (AbstractC4059aj) this.f14646a.f14601e.remove(0) : abstractC4059aj;
            size = this.f14646a.f14600d.size();
        }
        if (abstractC4059aj2 != null) {
            if (c4064ao != null) {
                abstractC4059aj2.m15612a(c4064ao);
            }
            try {
                int iM15620f = abstractC4059aj2.m15620f();
                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                    C3890m.m14994a("TransactionService", "processPendingTxn: process " + iM15620f);
                }
                if (m15634a(abstractC4059aj2)) {
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "Started deferred processing of transaction  " + abstractC4059aj2);
                        return;
                    }
                    return;
                }
                this.f14646a.stopSelf(iM15620f);
                return;
            } catch (IOException e) {
                C3890m.m14995a("TransactionService", e.getMessage(), e);
                return;
            }
        }
        if (size == 0) {
            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                C3890m.m14994a("TransactionService", "processPendingTxn: no more transaction, endMmsConnectivity");
            }
            this.f14646a.m15596b();
        }
    }

    /* renamed from: a */
    private boolean m15634a(AbstractC4059aj abstractC4059aj) {
        synchronized (this.f14646a.f14600d) {
            Iterator it = this.f14646a.f14601e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    Iterator it2 = this.f14646a.f14600d.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (((AbstractC4059aj) it2.next()).m15613a(abstractC4059aj)) {
                                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                                    C3890m.m14994a("TransactionService", "Duplicated transaction: " + abstractC4059aj.m15620f());
                                }
                            }
                        } else {
                            if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                                C3890m.m14994a("TransactionService", "processTransaction: call beginMmsConnectivity...");
                            }
                            if (this.f14646a.m15594a() == 1) {
                                this.f14646a.f14601e.add(abstractC4059aj);
                                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                                    C3890m.m14994a("TransactionService", "processTransaction: connResult=APN_REQUEST_STARTED, defer transaction pending MMS connectivity");
                                }
                            } else {
                                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                                    C3890m.m14994a("TransactionService", "Adding transaction to 'mProcessing' list: " + abstractC4059aj);
                                }
                                this.f14646a.f14600d.add(abstractC4059aj);
                                sendMessageDelayed(obtainMessage(3), 30000L);
                                if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                                    C3890m.m14994a("TransactionService", "processTransaction: starting transaction " + abstractC4059aj);
                                }
                                abstractC4059aj.m15695a(this.f14646a);
                                abstractC4059aj.mo15597a();
                            }
                        }
                    }
                } else if (((AbstractC4059aj) it.next()).m15613a(abstractC4059aj)) {
                    if (C3890m.m15000f("Mms:transaction", C3890m.f13993b)) {
                        C3890m.m14994a("TransactionService", "Transaction already pending: " + abstractC4059aj.m15620f());
                    }
                }
            }
        }
        return true;
    }
}
