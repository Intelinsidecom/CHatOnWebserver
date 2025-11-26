package com.p002mb.mediaengine;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import java.io.FileOutputStream;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
class MBAudioDeviceAndroid {
    protected static final String LOG_TAG = "MBAudioDevice";
    private AudioManager _audioManager;
    private Context _context;
    private FileOutputStream _fileStream = null;
    private static AudioTrack _audioTrack = null;
    private static AudioRecord _audioRecord = null;
    private static byte[] _tempBufPlay = new byte[2646];
    private static byte[] _tempBufRec = new byte[2646];
    private static final ReentrantLock _playLock = new ReentrantLock();
    private static final ReentrantLock _recLock = new ReentrantLock();
    private static boolean _doPlayInit = true;
    private static boolean _doRecInit = true;
    private static boolean _isRecording = false;
    private static boolean _isPlaying = false;
    private static int _bufferedRecSamples = 0;
    private static int _bufferedPlaySamples = 0;
    private static int _playPosition = 0;

    MBAudioDeviceAndroid() {
    }

    public static int InitRecording(int sampleRate) {
        Log.w(LOG_TAG, "--- Init Recording ---sampleRate=" + sampleRate);
        int minRecBufSize = AudioRecord.getMinBufferSize(sampleRate, 2, 2);
        int recBufSize = 4160;
        Log.w(LOG_TAG, "InitRecording:min buffsize:" + minRecBufSize + ",recBufSize:4160");
        if (4160 < minRecBufSize) {
            recBufSize = minRecBufSize * 2;
        }
        _bufferedRecSamples = (sampleRate * 5) / 200;
        if (_audioRecord != null) {
            _audioRecord.release();
            _audioRecord = null;
        }
        try {
            Log.w(LOG_TAG, "rough rec delay set to " + recBufSize);
            _audioRecord = new AudioRecord(1, sampleRate, 2, 2, recBufSize);
            return _audioRecord.getState() != 1 ? -1 : 0;
        } catch (Exception e) {
            Log.w(LOG_TAG, e.getMessage());
            return -1;
        }
    }

    public static int StartRecording() throws IllegalStateException {
        Log.w(LOG_TAG, "--- Start Recording ---");
        try {
            _audioRecord.startRecording();
            _isRecording = true;
            return 0;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int InitPlayback(int sampleRate) {
        Log.w(LOG_TAG, "--- Init Playback ---");
        int minPlayBufSize = AudioTrack.getMinBufferSize(sampleRate, 2, 2);
        Log.w(LOG_TAG, "min play buf size is " + minPlayBufSize);
        int playBufSize = 8192;
        _bufferedPlaySamples = 0;
        Log.w(LOG_TAG, "InitPlayback: min playbuff:" + minPlayBufSize + ",play buf size:8192");
        if (8192 < minPlayBufSize) {
            playBufSize = minPlayBufSize;
        }
        if (_audioTrack != null) {
            _audioTrack.release();
            _audioTrack = null;
        }
        try {
            _audioTrack = new AudioTrack(0, sampleRate, 2, 2, playBufSize, 1);
            if (_audioTrack.getState() != 1) {
                return -1;
            }
            Log.w(LOG_TAG, "play sample rate set to " + sampleRate + ",playBufSize" + playBufSize);
            return 0;
        } catch (Exception e) {
            Log.w(LOG_TAG, e.getMessage());
            return -1;
        }
    }

    public static int StartPlayback() throws IllegalStateException {
        Log.w(LOG_TAG, "--- Start Playback ---");
        try {
            _audioTrack.play();
            _isPlaying = true;
            return 0;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int StopRecording() {
        _recLock.lock();
        try {
            Log.w(LOG_TAG, "--- Stop Recording ---");
            if (_audioRecord.getRecordingState() == 3) {
                try {
                    _audioRecord.stop();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    _doRecInit = true;
                    _recLock.unlock();
                    return -1;
                }
            }
            _audioRecord.release();
            _audioRecord = null;
            _doRecInit = true;
            _recLock.unlock();
            _isRecording = false;
            return 0;
        } catch (Throwable th) {
            _doRecInit = true;
            _recLock.unlock();
            throw th;
        }
    }

    public static int StopPlayback() {
        _playLock.lock();
        try {
            Log.w(LOG_TAG, "--- Stop Playback ---");
            if (_audioTrack.getPlayState() == 3) {
                try {
                    _audioTrack.stop();
                    _audioTrack.flush();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                    _doPlayInit = true;
                    _playLock.unlock();
                    return -1;
                }
            }
            _audioTrack.release();
            _audioTrack = null;
            _doPlayInit = true;
            _playLock.unlock();
            _isPlaying = false;
            return 0;
        } catch (Throwable th) {
            _doPlayInit = true;
            _playLock.unlock();
            throw th;
        }
    }

    public static int PlayAudio(int lengthInBytes) {
        _playLock.lock();
        try {
            if (_audioTrack == null) {
                _playLock.unlock();
                _playLock.unlock();
                return -2;
            }
            if (_doPlayInit) {
                try {
                    Process.setThreadPriority(-19);
                } catch (Exception e) {
                    Log.w(LOG_TAG, "Set play thread priority failed: " + e.getMessage());
                }
                _doPlayInit = false;
            }
            int written = _audioTrack.write(_tempBufPlay, 0, lengthInBytes);
            _bufferedPlaySamples += written >> 1;
            int pos = _audioTrack.getPlaybackHeadPosition();
            if (pos < _playPosition) {
                _playPosition = 0;
            }
            _bufferedPlaySamples -= pos - _playPosition;
            _playPosition = pos;
            if (!_isRecording) {
                int bufferedSamples = _bufferedPlaySamples;
            }
            if (written == lengthInBytes) {
                return written;
            }
            Log.w(LOG_TAG, "Could not write all data to sc (written = " + written + ", length = " + lengthInBytes + ")");
            _playLock.unlock();
            return -1;
        } finally {
            _playLock.unlock();
        }
    }

    public static int RecordAudio(int lengthInBytes) {
        _recLock.lock();
        int readBytes = 0;
        try {
        } catch (Exception e) {
            Log.e(LOG_TAG, "RecordAudio try failed: " + e.getMessage());
        } finally {
            _recLock.unlock();
        }
        if (_audioRecord == null) {
            _recLock.unlock();
            _recLock.unlock();
            return -2;
        }
        if (_doRecInit) {
            try {
                Process.setThreadPriority(-19);
            } catch (Exception e2) {
                Log.w(LOG_TAG, "Set rec thread priority failed: " + e2.getMessage());
            }
            _doRecInit = false;
        }
        readBytes = _audioRecord.read(_tempBufRec, 0, lengthInBytes);
        if (readBytes == lengthInBytes) {
            return readBytes;
        }
        Log.w(LOG_TAG, "Could not read all data from sc (read = " + readBytes + ", length = " + lengthInBytes + ")");
        _recLock.unlock();
        return -1;
    }

    public int SetPlayoutSpeaker(boolean loudspeakerOn) {
        if (this._audioManager == null && this._context != null) {
            this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this._audioManager == null) {
            return -1;
        }
        if (Build.VERSION.SDK.equals("3") || Build.VERSION.SDK.equals(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
            if (loudspeakerOn) {
                this._audioManager.setMode(0);
            } else {
                this._audioManager.setMode(2);
            }
        } else if (Build.BRAND.equals("Samsung") || Build.BRAND.equals("samsung")) {
            if (loudspeakerOn) {
                this._audioManager.setMode(2);
                this._audioManager.setSpeakerphoneOn(loudspeakerOn);
            } else {
                this._audioManager.setSpeakerphoneOn(loudspeakerOn);
                this._audioManager.setMode(0);
            }
        } else {
            this._audioManager.setSpeakerphoneOn(loudspeakerOn);
        }
        return 0;
    }

    public int SetPlayoutVolume(int level) {
        if (this._audioManager == null && this._context != null) {
            this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this._audioManager == null) {
            return -1;
        }
        this._audioManager.setStreamVolume(0, level, 0);
        return 0;
    }

    public int GetPlayoutVolume() {
        if (this._audioManager == null && this._context != null) {
            this._audioManager = (AudioManager) this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if (this._audioManager == null) {
            return -1;
        }
        int level = this._audioManager.getStreamVolume(0);
        return level;
    }
}
