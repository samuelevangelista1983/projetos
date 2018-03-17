
package br.eti.sen.endereco.wscorreios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the br.eti.sen.endereco.wscorreios package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.</p>
 *
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _ConsultaCEP_QNAME = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "consultaCEP");
  private final static QName _ConsultaCEPResponse_QNAME = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "consultaCEPResponse");
  private final static QName _SigepClienteException_QNAME = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "SigepClienteException");
  private final static QName _SQLException_QNAME = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/", "SQLException");

  // CONSTRUTORES PÚBLICOS

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.eti.sen.endereco.wscorreios
   *
   */
  public ObjectFactory() {}

  // MÉTODOS PÚBLICOS

  /**
    * Create an instance of {@link ConsultaCEP }
    *
    */
  public ConsultaCEP createConsultaCEP() {
      return new ConsultaCEP();
  }

  /**
    * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCEP }{@code >}}
    *
    */
  @XmlElementDecl(namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", name = "consultaCEP")
  public JAXBElement<ConsultaCEP> createConsultaCEP(ConsultaCEP value) {
      return new JAXBElement<ConsultaCEP>(_ConsultaCEP_QNAME, ConsultaCEP.class, null, value);
  }

  /**
    * Create an instance of {@link ConsultaCEPResponse }
    *
    */
  public ConsultaCEPResponse createConsultaCEPResponse() {
      return new ConsultaCEPResponse();
  }

  /**
    * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCEPResponse }{@code >}}
    *
    */
  @XmlElementDecl(namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", name = "consultaCEPResponse")
  public JAXBElement<ConsultaCEPResponse> createConsultaCEPResponse(ConsultaCEPResponse value) {
      return new JAXBElement<ConsultaCEPResponse>(_ConsultaCEPResponse_QNAME, ConsultaCEPResponse.class, null, value);
  }

  /**
    * Create an instance of {@link EnderecoERP }
    *
    */
  public EnderecoERP createEnderecoERP() {
      return new EnderecoERP();
  }

  /**
    * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
    *
    */
  @XmlElementDecl(namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", name = "SigepClienteException")
  public JAXBElement<String> createSigepClienteException(String value) {
      return new JAXBElement<String>(_SigepClienteException_QNAME, String.class, null, value);
  }

  /**
    * Create an instance of {@link SQLException }
    *
    */
  public SQLException createSQLException() {
      return new SQLException();
  }

  /**
    * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
    *
    */
  @XmlElementDecl(namespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", name = "SQLException")
  public JAXBElement<SQLException> createSQLException(SQLException value) {
      return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
  }

}
