package com.sec.chaton.chat.translate;

import android.speech.tts.TextToSpeech;
import android.widget.ListView;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: TTSSpeakEngine.java */
/* renamed from: com.sec.chaton.chat.translate.i */
/* loaded from: classes.dex */
public class C1856i {

    /* renamed from: a */
    private static TextToSpeech f7052a;

    /* renamed from: g */
    private static long f7058g;

    /* renamed from: b */
    private static boolean f7053b = false;

    /* renamed from: c */
    private static boolean f7054c = false;

    /* renamed from: d */
    private static boolean f7055d = false;

    /* renamed from: e */
    private static ArrayList<C1859l> f7056e = new ArrayList<>();

    /* renamed from: f */
    private static Timer f7057f = null;

    /* renamed from: h */
    private static ListView f7059h = null;

    /* renamed from: i */
    private static TextToSpeech.OnInitListener f7060i = new C1857j();

    /* renamed from: j */
    private static TimerTask f7061j = null;

    /* renamed from: a */
    public static boolean m9049a() {
        return f7053b;
    }

    /* renamed from: a */
    public static void m9048a(ListView listView) {
        f7059h = listView;
    }

    /* renamed from: b */
    public static synchronized void m9053b() {
        if (C4904y.f17873c) {
            C4904y.m18641c("initTTSSpeakEngine() - isInitInProgress : " + f7054c + ", isInitSuccess : " + f7055d, "TTSSpeakEngine");
        }
        if (C1865r.m9070b() && !f7054c && !f7055d) {
            m9064k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0089, code lost:
    
        com.sec.chaton.chat.translate.C1856i.f7053b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008e, code lost:
    
        if (com.sec.chaton.util.C4904y.f17873c == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0090, code lost:
    
        com.sec.chaton.util.C4904y.m18641c("samsung engine exist : " + com.sec.chaton.chat.translate.C1856i.f7053b, "TTSSpeakEngine");
     */
    @android.annotation.TargetApi(14)
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void m9064k() {
        /*
            r0 = 1
            com.sec.chaton.chat.translate.C1856i.f7054c = r0     // Catch: java.lang.Exception -> Lcd
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Exception -> Lcd
            if (r0 == 0) goto L10
            java.lang.String r0 = "init()"
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r0, r1)     // Catch: java.lang.Exception -> Lcd
        L10:
            android.speech.tts.TextToSpeech r0 = new android.speech.tts.TextToSpeech     // Catch: java.lang.Exception -> Lcd
            android.content.Context r1 = com.sec.chaton.global.GlobalApplication.m18732r()     // Catch: java.lang.Exception -> Lcd
            android.speech.tts.TextToSpeech$OnInitListener r2 = com.sec.chaton.chat.translate.C1856i.f7060i     // Catch: java.lang.Exception -> Lcd
            java.lang.String r3 = "com.samsung.SMT"
            r0.<init>(r1, r2, r3)     // Catch: java.lang.Exception -> Lcd
            com.sec.chaton.chat.translate.C1856i.f7052a = r0     // Catch: java.lang.Exception -> Lcd
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Exception -> Lcd
            if (r0 == 0) goto L40
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcd
            r0.<init>()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r1 = "mTts : "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lcd
            android.speech.tts.TextToSpeech r1 = com.sec.chaton.chat.translate.C1856i.f7052a     // Catch: java.lang.Exception -> Lcd
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r0, r1)     // Catch: java.lang.Exception -> Lcd
        L40:
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.translate.C1856i.f7052a     // Catch: java.lang.Exception -> Lcd
            java.util.List r0 = r0.getEngines()     // Catch: java.lang.Exception -> Lcd
            java.util.Iterator r1 = r0.iterator()     // Catch: java.lang.Exception -> Lcd
        L4a:
            boolean r0 = r1.hasNext()     // Catch: java.lang.Exception -> Lcd
            if (r0 == 0) goto Lac
            java.lang.Object r0 = r1.next()     // Catch: java.lang.Exception -> Lcd
            android.speech.tts.TextToSpeech$EngineInfo r0 = (android.speech.tts.TextToSpeech.EngineInfo) r0     // Catch: java.lang.Exception -> Lcd
            boolean r2 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Exception -> Lcd
            if (r2 == 0) goto L7a
            java.lang.String r2 = r0.name     // Catch: java.lang.Exception -> Lcd
            if (r2 == 0) goto L7a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcd
            r2.<init>()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r3 = "EngineInfo - info.name : "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r3 = r0.name     // Catch: java.lang.Exception -> Lcd
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r3 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r2, r3)     // Catch: java.lang.Exception -> Lcd
        L7a:
            java.lang.String r2 = r0.name     // Catch: java.lang.Exception -> Lcd
            if (r2 == 0) goto L4a
            java.lang.String r0 = r0.name     // Catch: java.lang.Exception -> Lcd
            java.lang.String r2 = "com.samsung.SMT"
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Exception -> Lcd
            if (r0 == 0) goto L4a
            r0 = 1
            com.sec.chaton.chat.translate.C1856i.f7053b = r0     // Catch: java.lang.Exception -> Lcd
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Exception -> Lcd
            if (r0 == 0) goto Lac
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lcd
            r0.<init>()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r1 = "samsung engine exist : "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lcd
            boolean r1 = com.sec.chaton.chat.translate.C1856i.f7053b     // Catch: java.lang.Exception -> Lcd
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Exception -> Lcd
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lcd
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r0, r1)     // Catch: java.lang.Exception -> Lcd
        Lac:
            boolean r0 = com.sec.chaton.util.C4904y.f17873c
            if (r0 == 0) goto Lcc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "mIsSamsungTTSEngineExist : "
            java.lang.StringBuilder r0 = r0.append(r1)
            boolean r1 = com.sec.chaton.chat.translate.C1856i.f7053b
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r0, r1)
        Lcc:
            return
        Lcd:
            r0 = move-exception
            r1 = 0
            com.sec.chaton.chat.translate.C1856i.f7054c = r1
            java.lang.String r1 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18635a(r0, r1)
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.translate.C1856i.m9064k():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void m9056c() {
        /*
            java.lang.Class<com.sec.chaton.chat.translate.i> r1 = com.sec.chaton.chat.translate.C1856i.class
            monitor-enter(r1)
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            if (r0 == 0) goto L10
            java.lang.String r0 = "shutdownTTSSpeakEngine()"
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r0, r2)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
        L10:
            java.util.Timer r0 = com.sec.chaton.chat.translate.C1856i.f7057f     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            if (r0 == 0) goto L19
            java.util.Timer r0 = com.sec.chaton.chat.translate.C1856i.f7057f     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            r0.cancel()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
        L19:
            java.util.ArrayList<com.sec.chaton.chat.translate.l> r0 = com.sec.chaton.chat.translate.C1856i.f7056e     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            r0.clear()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.translate.C1856i.f7052a     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            if (r0 == 0) goto L4e
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.translate.C1856i.f7052a     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            boolean r0 = r0.isSpeaking()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            if (r0 == 0) goto L3c
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            if (r0 == 0) goto L37
            java.lang.String r0 = "mTts.stop()"
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r0, r2)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
        L37:
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.translate.C1856i.f7052a     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            r0.stop()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
        L3c:
            android.speech.tts.TextToSpeech r0 = com.sec.chaton.chat.translate.C1856i.f7052a     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            r0.shutdown()     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            boolean r0 = com.sec.chaton.util.C4904y.f17873c     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
            if (r0 == 0) goto L4e
            java.lang.String r0 = "mTts.shutdown()"
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18641c(r0, r2)     // Catch: java.lang.Exception -> L5c java.lang.Throwable -> L64
        L4e:
            r0 = 0
            com.sec.chaton.chat.translate.C1856i.f7053b = r0     // Catch: java.lang.Throwable -> L64
            r0 = 0
            com.sec.chaton.chat.translate.C1856i.f7055d = r0     // Catch: java.lang.Throwable -> L64
            r0 = 0
            com.sec.chaton.chat.translate.C1856i.f7054c = r0     // Catch: java.lang.Throwable -> L64
            r0 = 0
            com.sec.chaton.chat.translate.C1856i.f7059h = r0     // Catch: java.lang.Throwable -> L64
            monitor-exit(r1)
            return
        L5c:
            r0 = move-exception
            java.lang.String r2 = "TTSSpeakEngine"
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L64
            goto L4e
        L64:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.translate.C1856i.m9056c():void");
    }

    /* renamed from: a */
    public static void m9047a(long j, String str, String str2) {
        C1859l c1859l = new C1859l();
        C1850c c1850cM9024d = C1850c.m9024d();
        if (str == null) {
            if (C4904y.f17873c) {
                C4904y.m18641c("addMessageForPlayback - message is null", "TTSSpeakEngine");
                return;
            }
            return;
        }
        c1859l.f7063a = j;
        c1859l.f7064b = str;
        if (str2 == null) {
            str2 = c1850cM9024d.m9039e().f7022w;
        }
        c1859l.f7065c = str2;
        boolean z = f7052a.isSpeaking() && c1859l.f7063a == f7058g;
        f7052a.stop();
        f7056e.clear();
        if (!z && !f7056e.contains(c1859l)) {
            if (C4904y.f17873c) {
                C4904y.m18641c("addMessageForPlayback - add to messageQueue. isInitInProgress : " + f7054c + ", isInitSuccess : " + f7055d, "TTSSpeakEngine");
            }
            if (!f7055d) {
                f7054c = false;
                if (C4904y.f17873c) {
                    C4904y.m18641c("rebound TTSSpeakEngin()", "TTSSpeakEngine");
                }
                m9053b();
            }
            f7056e.add(c1859l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m9054b(C1859l c1859l) {
        int iSpeak = 112233;
        C1850c c1850cM9024d = C1850c.m9024d();
        if (f7052a != null) {
            int language = f7052a.setLanguage(c1850cM9024d.m9037c(c1859l.f7065c));
            C4904y.m18641c("Set language result code - " + language, "TTSSpeakEngine");
            if (language == -1 || language == -2) {
                C4904y.m18641c("Lang data missing !!! " + c1859l.f7065c + " result code - " + language, "TTSSpeakEngine");
            }
            iSpeak = f7052a.speak(c1859l.f7064b, 1, null);
            f7058g = c1859l.f7063a;
            if (C4904y.f17873c) {
                C4904y.m18641c("speakMessage - result : " + iSpeak, "TTSSpeakEngine");
            }
        }
        return iSpeak == 0;
    }

    /* renamed from: a */
    public static boolean m9051a(String str) {
        if (f7052a == null) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18634a("isLanguageAvailable - mTts is null", "TTSSpeakEngine");
            return false;
        }
        if (str == null) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18634a("isLanguageAvailable - language is null", "TTSSpeakEngine");
            return false;
        }
        Locale localeM9037c = C1850c.m9024d().m9037c(str);
        if (localeM9037c == null) {
            if (!C4904y.f17875e) {
                return false;
            }
            C4904y.m18634a("isLanguageAvailable - locale for " + str + " is null", "TTSSpeakEngine");
            return false;
        }
        int iIsLanguageAvailable = f7052a.isLanguageAvailable(localeM9037c);
        if (iIsLanguageAvailable == -2) {
            if (!C4904y.f17873c) {
                return false;
            }
            C4904y.m18641c("isLanguageAvailable - LANG_NOT_SUPPORTED(" + str + ") Status : " + iIsLanguageAvailable, "TTSSpeakEngine");
            return false;
        }
        return true;
    }
}
