package com.wavify.jmeter.protocol.amf.sampler;

import org.apache.jmeter.samplers.SampleResult;

public class AMFSamplerResult extends SampleResult {

  private static final long serialVersionUID = -4393997284157939538L;
  private Object results;
  private String messageID;
  private String errorMsg;

  public void setResult(Object newResult) {
    this.results = newResult;
  }

  public Object getResult() {
    return this.results;
  }

  public void setMessageID(String messageID) {
    this.messageID = messageID;
  }

  public String getMessageID() {
    return messageID;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

}
