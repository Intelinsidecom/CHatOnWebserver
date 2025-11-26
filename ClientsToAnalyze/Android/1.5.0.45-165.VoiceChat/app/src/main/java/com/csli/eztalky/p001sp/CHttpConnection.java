package com.csli.eztalky.p001sp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/* loaded from: classes.dex */
public class CHttpConnection {
    private String host;

    /* renamed from: in */
    private InputStream f29in;
    private OutputStream out;
    private int port;
    private String resProtocol;
    private Socket socket;

    public void connect(String host, int port, int connectionTimeout, int timeout) throws IOException {
        SocketAddress socketAddress = new InetSocketAddress(host, port);
        this.socket = new Socket();
        this.socket.setSoTimeout(timeout);
        this.socket.connect(socketAddress, connectionTimeout);
        this.out = new BufferedOutputStream(this.socket.getOutputStream());
        this.f29in = new BufferedInputStream(this.socket.getInputStream());
        this.host = host;
        this.port = port;
    }

    public void writeHeader(byte[] buffer, int len) throws IOException {
        this.out.write(buffer, 0, len);
    }

    public OutputStream getOutputStream() {
        return this.out;
    }

    public InputStream getInputStream() throws IOException {
        return this.f29in;
    }

    public void close() throws IOException {
        if (this.out != null) {
            try {
                this.out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.out = null;
        }
        if (this.f29in != null) {
            try {
                this.f29in.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f29in = null;
        }
        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.socket = null;
        }
    }
}
