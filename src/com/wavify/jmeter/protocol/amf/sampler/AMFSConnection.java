package com.wavify.jmeter.protocol.amf.sampler;

import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import flex.messaging.io.amf.client.AMFConnection;

public class AMFSConnection extends AMFConnection {

  private SSLSocketFactory sslFactory;

  public void setSSLFactory(SSLSocketFactory sslFactory) {
    this.sslFactory = sslFactory;
  }

  protected void internalConnect() throws IOException {
    super.internalConnect();

    HttpsURLConnection secureConnection = (HttpsURLConnection) urlConnection;
    secureConnection.setSSLSocketFactory(sslFactory);
  }

}
