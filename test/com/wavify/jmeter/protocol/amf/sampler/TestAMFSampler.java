package com.wavify.jmeter.protocol.amf.sampler;

import java.util.ArrayList;

import junit.framework.Assert;

import org.apache.jmeter.protocol.http.control.CookieManager;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.util.JMeterUtils;
import org.junit.Test;


public class TestAMFSampler {

  @Test
  public void testProcess() {
    JMeterUtils.loadJMeterProperties("config/jmeter.properties");
    
    CookieManager cookieManager = new CookieManager();
    cookieManager.testStarted();
    
    // First sampler for get cookie
    HTTPSampler loginSampler = new HTTPSampler();
    loginSampler.setAutoRedirects(false);
    loginSampler.setFollowRedirects(false);
    loginSampler.setMethod(HTTPSampler.GET);
    loginSampler.setPath("/");
    loginSampler.setProtocol(HTTPSampler.PROTOCOL_HTTP);
    loginSampler.setDomain("localhost");
    loginSampler.setCookieManager(cookieManager);
    loginSampler.sample();
    
    // Second sampler for login
    loginSampler = new HTTPSampler();
    loginSampler.setAutoRedirects(false);
    loginSampler.setFollowRedirects(false);
    loginSampler.setMethod(HTTPSampler.POST);
    loginSampler.setPath("/amf");
    loginSampler.setProtocol(HTTPSampler.PROTOCOL_HTTP);
    loginSampler.setDomain("localhost");
    loginSampler.setCookieManager(cookieManager);
    
    loginSampler.addArgument("username", "llun");
    loginSampler.addArgument("password", "password");
    loginSampler.sample();
    
    // Third sampler for test login success
    loginSampler = new HTTPSampler();
    loginSampler.setAutoRedirects(false);
    loginSampler.setFollowRedirects(false);
    loginSampler.setMethod(HTTPSampler.GET);
    loginSampler.setPath("/amf");
    loginSampler.setProtocol(HTTPSampler.PROTOCOL_HTTP);
    loginSampler.setDomain("localhost");
    loginSampler.setCookieManager(cookieManager);
    loginSampler.sample();
    
    // AMF Sampler for test request
    AMFSampler sampler = new AMFSampler();
    sampler.setAddress("http://localhost/amf");
    sampler.setService("echo");
    sampler.setMethod("hello");
    sampler.setArguments(new ArrayList<String>(0));
    sampler.setCookieManager(cookieManager);
    
    SampleResult result = sampler.process();
    Assert.assertTrue(result.isSuccessful());
  }
  
}