package com.sec.chaton.chat.p024b;

import android.speech.tts.TextToSpeech;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TTSSpeakEngine.java */
/* renamed from: com.sec.chaton.chat.b.i */
/* loaded from: classes.dex */
public class C0958i {

    /* renamed from: a */
    private static TextToSpeech f3941a;

    /* renamed from: b */
    private static boolean f3942b = false;

    /* renamed from: c */
    private static boolean f3943c = false;

    /* renamed from: d */
    private static boolean f3944d = false;

    /* renamed from: e */
    private static ArrayList<C0961l> f3945e = new ArrayList<>();

    /* renamed from: f */
    private static Timer f3946f = null;

    /* renamed from: g */
    private static TextToSpeech.OnInitListener f3947g = new C0959j();

    /* renamed from: h */
    private static TimerTask f3948h = null;

    /* renamed from: a */
    public static boolean m5166a() {
        return f3942b;
    }

    /* renamed from: b */
    public static synchronized void m5169b() {
        if (C3250y.f11735c) {
            C3250y.m11453c("initTTSSpeakEngine() - isInitInProgress : " + f3943c + ", isInitSuccess : " + f3944d, "TTSSpeakEngine");
        }
        if (C0963n.m5180a() && !f3943c && !f3944d) {
            m5179j();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
    
        com.sec.chaton.chat.p024b.C0958i.f3942b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
    
        if (com.sec.chaton.util.C3250y.f11735c == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
    
        com.sec.chaton.util.C3250y.m11453c("samsung engine exist : " + com.sec.chaton.chat.p024b.C0958i.f3942b, "TTSSpeakEngine");
     */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m5179j() {
        /*
            r0 = 1
            com.sec.chaton.chat.p024b.C0958i.f3943c = r0     // Catch: java.lang.Exception -> Lc1
            boolean r0 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Exception -> Lc1
            if (r0 == 0) goto Le
            java.lang.String r0 = "init()"
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r0, r1)     // Catch: java.lang.Exception -> Lc1
        Le:
            android.speech.tts.TextToSpeech r0 = new android.speech.tts.TextToSpeech     // Catch: java.lang.Exception -> Lc1
            android.content.Context r1 = com.sec.chaton.global.GlobalApplication.m11493l()     // Catch: java.lang.Exception -> Lc1
            android.speech.tts.TextToSpeech$OnInitListener r2 = com.sec.chaton.chat.p024b.C0958i.f3947g     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = "com.samsung.SMT"
            r0.<init>(r1, r2, r3)     // Catch: java.lang.Exception -> Lc1
            com.sec.chaton.chat.p024b.C0958i.f3941a = r0     // Catch: java.lang.Exception -> Lc1
            boolean r0 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Exception -> Lc1
            if (r0 == 0) goto L3b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc1
            r0.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r1 = "mTts : "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lc1
            android.speech.tts.TextToSpeech r1 = com.sec.chaton.chat.p024b.C0958i.f3941a     // Catch: java.lang.Exception -> Lc1
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r0, r1)     // Catch: java.lang.Exception -> Lc1
        L3b:
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.p024b.C0958i.f3941a     // Catch: java.lang.Exception -> Lc1
            java.util.List r0 = r0.getEngines()     // Catch: java.lang.Exception -> Lc1
            java.util.Iterator r1 = r0.iterator()     // Catch: java.lang.Exception -> Lc1
        L45:
            boolean r0 = r1.hasNext()     // Catch: java.lang.Exception -> Lc1
            if (r0 == 0) goto La2
            java.lang.Object r0 = r1.next()     // Catch: java.lang.Exception -> Lc1
            android.speech.tts.TextToSpeech$EngineInfo r0 = (android.speech.tts.TextToSpeech.EngineInfo) r0     // Catch: java.lang.Exception -> Lc1
            boolean r2 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Exception -> Lc1
            if (r2 == 0) goto L73
            java.lang.String r2 = r0.name     // Catch: java.lang.Exception -> Lc1
            if (r2 == 0) goto L73
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc1
            r2.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = "EngineInfo - info.name : "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = r0.name     // Catch: java.lang.Exception -> Lc1
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r3 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r2, r3)     // Catch: java.lang.Exception -> Lc1
        L73:
            java.lang.String r2 = r0.name     // Catch: java.lang.Exception -> Lc1
            if (r2 == 0) goto L45
            java.lang.String r0 = r0.name     // Catch: java.lang.Exception -> Lc1
            java.lang.String r2 = "com.samsung.SMT"
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Exception -> Lc1
            if (r0 == 0) goto L45
            r0 = 1
            com.sec.chaton.chat.p024b.C0958i.f3942b = r0     // Catch: java.lang.Exception -> Lc1
            boolean r0 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Exception -> Lc1
            if (r0 == 0) goto La2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc1
            r0.<init>()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r1 = "samsung engine exist : "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lc1
            boolean r1 = com.sec.chaton.chat.p024b.C0958i.f3942b     // Catch: java.lang.Exception -> Lc1
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lc1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lc1
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r0, r1)     // Catch: java.lang.Exception -> Lc1
        La2:
            boolean r0 = com.sec.chaton.util.C3250y.f11735c
            if (r0 == 0) goto Lc0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "mIsSamsungTTSEngineExist : "
            java.lang.StringBuilder r0 = r0.append(r1)
            boolean r1 = com.sec.chaton.chat.p024b.C0958i.f3942b
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r0, r1)
        Lc0:
            return
        Lc1:
            r0 = move-exception
            r1 = 0
            com.sec.chaton.chat.p024b.C0958i.f3943c = r1
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11443a(r0, r1)
            goto La2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p024b.C0958i.m5179j():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void m5172c() {
        /*
            java.lang.Class<com.sec.chaton.chat.b.i> r1 = com.sec.chaton.chat.p024b.C0958i.class
            monitor-enter(r1)
            boolean r0 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            if (r0 == 0) goto Le
            java.lang.String r0 = "shutdownTTSSpeakEngine()"
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r0, r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
        Le:
            java.util.Timer r0 = com.sec.chaton.chat.p024b.C0958i.f3946f     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            if (r0 == 0) goto L17
            java.util.Timer r0 = com.sec.chaton.chat.p024b.C0958i.f3946f     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            r0.cancel()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
        L17:
            java.util.ArrayList<com.sec.chaton.chat.b.l> r0 = com.sec.chaton.chat.p024b.C0958i.f3945e     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            r0.clear()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.p024b.C0958i.f3941a     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            if (r0 == 0) goto L48
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.p024b.C0958i.f3941a     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            boolean r0 = r0.isSpeaking()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            if (r0 == 0) goto L38
            boolean r0 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            if (r0 == 0) goto L33
            java.lang.String r0 = "mTts.stop()"
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r0, r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
        L33:
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.p024b.C0958i.f3941a     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            r0.stop()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
        L38:
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.p024b.C0958i.f3941a     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            r0.shutdown()     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            boolean r0 = com.sec.chaton.util.C3250y.f11735c     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
            if (r0 == 0) goto L48
            java.lang.String r0 = "mTts.shutdown()"
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11453c(r0, r2)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L5a
        L48:
            r0 = 0
            com.sec.chaton.chat.p024b.C0958i.f3942b = r0     // Catch: java.lang.Throwable -> L5a
            r0 = 0
            com.sec.chaton.chat.p024b.C0958i.f3944d = r0     // Catch: java.lang.Throwable -> L5a
            r0 = 0
            com.sec.chaton.chat.p024b.C0958i.f3943c = r0     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r1)
            return
        L53:
            r0 = move-exception
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> L5a
            goto L48
        L5a:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.p024b.C0958i.m5172c():void");
    }

    /* renamed from: a */
    public static void m5165a(long j, String str, String str2) {
        C0961l c0961l = new C0961l();
        C0952c c0952cM5143c = C0952c.m5143c();
        if (str == null) {
            if (C3250y.f11735c) {
                C3250y.m11453c("addMessageForPlayback - message is null", "TTSSpeakEngine");
                return;
            }
            return;
        }
        c0961l.f3950a = j;
        c0961l.f3951b = str;
        if (str2 == null) {
            str2 = c0952cM5143c.m5156d().f3915r;
        }
        c0961l.f3952c = str2;
        f3941a.stop();
        f3945e.clear();
        if (!f3945e.contains(c0961l)) {
            if (C3250y.f11735c) {
                C3250y.m11453c("addMessageForPlayback - add to messageQueue. isInitInProgress : " + f3943c + ", isInitSuccess : " + f3944d, "TTSSpeakEngine");
            }
            if (!f3944d) {
                f3943c = false;
                if (C3250y.f11735c) {
                    C3250y.m11453c("rebound TTSSpeakEngin()", "TTSSpeakEngine");
                }
                m5169b();
            }
            f3945e.add(c0961l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m5170b(C0961l c0961l) {
        int iSpeak = 112233;
        C0952c c0952cM5143c = C0952c.m5143c();
        if (f3941a != null) {
            int language = f3941a.setLanguage(c0952cM5143c.m5155c(c0961l.f3952c));
            C3250y.m11453c("Set language result code - " + language, "TTSSpeakEngine");
            if (language == -1 || language == -2) {
                C3250y.m11453c("Lang data missing !!! " + c0961l.f3952c + " result code - " + language, "TTSSpeakEngine");
            }
            iSpeak = f3941a.speak(c0961l.f3951b, 1, null);
            if (C3250y.f11735c) {
                C3250y.m11453c("speakMessage - result : " + iSpeak, "TTSSpeakEngine");
            }
        }
        return iSpeak == 0;
    }
}
