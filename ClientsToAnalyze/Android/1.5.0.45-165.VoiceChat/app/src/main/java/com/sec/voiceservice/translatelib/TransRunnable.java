package com.sec.voiceservice.translatelib;

import org.apache.http.client.HttpClient;

/* loaded from: classes.dex */
public class TransRunnable implements Runnable {
    HttpClient httpclient;
    int number;
    ThreadCount threadCount;
    String[] transResult = null;
    String transText;

    TransRunnable(String transText, ThreadCount threadCount, HttpClient httpclient, int number) {
        this.transText = transText;
        this.threadCount = threadCount;
        this.httpclient = httpclient;
        this.number = number;
        threadCount.count++;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.transResult = Translate.TransExecute(this.transText, this.httpclient, false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ThreadCount threadCount = this.threadCount;
            threadCount.count--;
            Translate.translateResult[this.number] = this.transResult;
        }
    }
}
