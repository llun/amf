package com.wavify.jmeter.protocol.amf.sampler.gui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.Box;

import org.apache.jmeter.config.Argument;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.property.CollectionProperty;
import org.apache.jmeter.testelement.property.JMeterProperty;
import org.apache.jmeter.testelement.property.PropertyIterator;

import com.wavify.jmeter.protocol.amf.sampler.AMFSampler;

public class AMFSamplerGui extends AbstractSamplerGui {

  private static final long serialVersionUID = 1L;

  private javax.swing.JLabel addressLabel;
  private javax.swing.JTextField addressTextfield;
  private javax.swing.JPanel mainPanel;
  private javax.swing.JLabel methodLabel;
  private javax.swing.JPanel methodPanel;
  private javax.swing.JTextField methodTextfield;
  private javax.swing.JPanel serverPanel;
  private javax.swing.JLabel serviceLabel;
  private javax.swing.JTextField serviceTextfield;

  // Lazy to create my self table model. So use default argument panel and don't
  // use name
  private ArgumentsPanel argumentsPanel = new ArgumentsPanel("Arguments");

  public AMFSamplerGui() {
    init();
  }

  /**
   * Render configuration input
   */
  private void init() {
    setLayout(new BorderLayout());
    setBorder(makeBorder());

    Box title = Box.createVerticalBox();
    title.add(makeTitlePanel());

    Box center = Box.createVerticalBox();
    center.add(createDataPanel());

    add(title, BorderLayout.NORTH);
    add(center, BorderLayout.CENTER);
  }

  private Component createDataPanel() {
    mainPanel = new javax.swing.JPanel();
    serverPanel = new javax.swing.JPanel();
    addressLabel = new javax.swing.JLabel();
    addressTextfield = new javax.swing.JTextField();
    methodPanel = new javax.swing.JPanel();
    serviceLabel = new javax.swing.JLabel();
    serviceTextfield = new javax.swing.JTextField();
    methodLabel = new javax.swing.JLabel();
    methodTextfield = new javax.swing.JTextField();

    mainPanel.setName("mainPanel"); // NOI18N

    serverPanel.setBorder(javax.swing.BorderFactory
        .createTitledBorder("Server")); // NOI18N
    serverPanel.setName("serverPanel"); // NOI18N

    addressLabel.setLabelFor(addressTextfield);
    addressLabel.setText("Address"); // NOI18N
    addressLabel.setName("addressLabel"); // NOI18N

    addressTextfield.setName("addressTextfield"); // NOI18N

    javax.swing.GroupLayout serverPanelLayout = new javax.swing.GroupLayout(
        serverPanel);
    serverPanel.setLayout(serverPanelLayout);
    serverPanelLayout.setHorizontalGroup(serverPanelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        serverPanelLayout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(addressLabel)
            .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(addressTextfield,
                javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
            .addContainerGap()));
    serverPanelLayout.setVerticalGroup(serverPanelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        serverPanelLayout
            .createSequentialGroup()
            .addGroup(
                serverPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressTextfield,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE)));

    methodPanel.setBorder(javax.swing.BorderFactory
        .createTitledBorder("Method")); // NOI18N
    methodPanel.setName("methodPanel"); // NOI18N

    serviceLabel.setLabelFor(serviceLabel);
    serviceLabel.setText("Service"); // NOI18N
    serviceLabel.setName("serviceLabel"); // NOI18N

    serviceTextfield.setName("serviceTextfield"); // NOI18N

    methodLabel.setLabelFor(methodTextfield);
    methodLabel.setText("Method"); // NOI18N
    methodLabel.setName("methodLabel"); // NOI18N

    methodTextfield.setName("methodTextfield"); // NOI18N

    javax.swing.GroupLayout methodPanelLayout = new javax.swing.GroupLayout(
        methodPanel);
    methodPanel.setLayout(methodPanelLayout);
    methodPanelLayout.setHorizontalGroup(methodPanelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        methodPanelLayout
            .createSequentialGroup()
            .addContainerGap()
            .addComponent(serviceLabel)
            .addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(serviceTextfield,
                javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(methodLabel)
            .addGap(12, 12, 12)
            .addComponent(methodTextfield,
                javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
            .addContainerGap()));
    methodPanelLayout.setVerticalGroup(methodPanelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        methodPanelLayout
            .createSequentialGroup()
            .addGroup(
                methodPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serviceLabel)
                    .addComponent(serviceTextfield,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(methodLabel)
                    .addComponent(methodTextfield,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(14, Short.MAX_VALUE)));

    javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
        mainPanel);
    mainPanel.setLayout(mainPanelLayout);
    mainPanelLayout.setHorizontalGroup(mainPanelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING).addGroup(
        javax.swing.GroupLayout.Alignment.TRAILING,
        mainPanelLayout
            .createSequentialGroup()
            .addContainerGap()
            .addGroup(
                mainPanelLayout
                    .createParallelGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(argumentsPanel,
                        javax.swing.GroupLayout.Alignment.LEADING,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(methodPanel,
                        javax.swing.GroupLayout.Alignment.LEADING,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverPanel,
                        javax.swing.GroupLayout.Alignment.LEADING,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap()));
    mainPanelLayout.setVerticalGroup(mainPanelLayout.createParallelGroup(
        javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(
            mainPanelLayout
                .createSequentialGroup()
                .addContainerGap()
                .addComponent(serverPanel,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(methodPanel,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(argumentsPanel,
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()));

    return mainPanel;
  }

  public String getStaticLabel() {
    return "AMF Sampler";
  }

  @Override
  public String getLabelResource() {
    return "amf_title";
  }

  @Override
  public TestElement createTestElement() {
    AMFSampler sampler = new AMFSampler();
    sampler.setName("AMF Sampler");
    return sampler;
  }

  public void configure(TestElement element) {
    super.configure(element);

    addressTextfield.setText(element
        .getPropertyAsString(AMFSampler.ADDRESS_PROP));
    serviceTextfield.setText(element
        .getPropertyAsString(AMFSampler.SERVICE_PROP));
    methodTextfield
        .setText(element.getPropertyAsString(AMFSampler.METHOD_PROP));

    JMeterProperty property = element.getProperty(AMFSampler.ARGUMENT_PROP);
    if (property instanceof CollectionProperty) {
      CollectionProperty properties = (CollectionProperty) property;
      Arguments arguments = new Arguments();
      PropertyIterator iterator = properties.iterator();
      while (iterator.hasNext()) {
        JMeterProperty argument = iterator.next();
        Argument object = (Argument) argument.getObjectValue();
        arguments.addArgument(object);
      }
      argumentsPanel.configure(arguments);
    }
  }

  @Override
  public void modifyTestElement(TestElement element) {
    element.clear();
    configureTestElement(element);

    element.setProperty(AMFSampler.ADDRESS_PROP, addressTextfield.getText());
    element.setProperty(AMFSampler.SERVICE_PROP, serviceTextfield.getText());
    element.setProperty(AMFSampler.METHOD_PROP, methodTextfield.getText());

    Arguments arguments = new Arguments();
    argumentsPanel.modifyTestElement(arguments);

    CollectionProperty property = arguments.getArguments();
    property.setName(AMFSampler.ARGUMENT_PROP);

    element.setProperty(property);
  }

  public void clearGui() {
    super.clearGui();

    addressTextfield.setText("");
    serviceTextfield.setText("");
    methodTextfield.setText("");
    argumentsPanel.clearGui();
  }

}
