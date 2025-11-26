package com.coolots.chaton.common.controller;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import com.coolots.chaton.common.view.EngineeringConfigActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PreventUMTSManagerInterface;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

/* loaded from: classes.dex */
public class PreventUMTSManager implements PreventUMTSManagerInterface {
    private static final String CLASSNAME = "[PreventUMTSManager]";
    static final long FIVE_SECONDS = 5000;
    static final long TEN_MIN = 60000;
    static long preventUMTSAlarmEndTime = -1;
    public AlarmManager alarmMnger = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    @Override // com.sds.coolots.call.PreventUMTSManagerInterface
    public void startPreventUMTSAlarm() {
        Date current = new Date();
        long currentTimeInMS = current.getTime();
        if (preventUMTSAlarmEndTime == -1) {
            preventUMTSAlarmEndTime = currentTimeInMS + TEN_MIN;
            logE("First Started!!!");
        } else if (preventUMTSAlarmEndTime > currentTimeInMS) {
            preventUMTSAlarmEndTime = currentTimeInMS + TEN_MIN;
            logE("Time Changed!! - preventUMTSAlarmEndTime : " + preventUMTSAlarmEndTime);
            return;
        } else if (preventUMTSAlarmEndTime < currentTimeInMS) {
            preventUMTSAlarmEndTime = currentTimeInMS + TEN_MIN;
            logE("PreventUMTS Alarm Retriggering!!!!!");
        }
        sendPreventUMTSAlarm();
    }

    @Override // com.sds.coolots.call.PreventUMTSManagerInterface
    public void sendPreventUMTSAlarm() {
        Date current = new Date();
        long currentTimeInMS = current.getTime();
        sendUDPPacket();
        if (currentTimeInMS <= preventUMTSAlarmEndTime) {
            Intent intent = new Intent(IntentName.ACTION_ALARM_PREVENT_UMTS);
            PendingIntent sender = PendingIntent.getBroadcast(MainApplication.mContext, 0, intent, 0);
            if (this.alarmMnger == null) {
                this.alarmMnger = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
            }
            this.alarmMnger.set(2, SystemClock.elapsedRealtime() + 5000, sender);
            return;
        }
        logE("End Time is Over do not set Alarm");
    }

    public void sendUDPPacket() {
        new Thread(new Runnable() { // from class: com.coolots.chaton.common.controller.PreventUMTSManager.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                try {
                    InetAddress serverAddr = InetAddress.getByName(EngineeringConfigActivity.DEF_CENTER_DOMAIN);
                    DatagramSocket socket = new DatagramSocket();
                    byte[] buf = "?".getBytes();
                    DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddr, 5355);
                    socket.send(packet);
                    PreventUMTSManager.this.logE("sendUDPPacket Success!!!!!!");
                    socket.close();
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }).start();
    }
}
