package br.eti.sen.endereco.wscorreios;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 *
 */
@WebService(name = "AtendeCliente", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/")
@XmlSeeAlso({ObjectFactory.class})
public interface AtendeCliente {

    /**
     * Método responsável por pesquisar um endereço na base de dados da Empresa Brasileira de Correios e Telégrafos.
     *
     * @param cep String com um CEP válido sem formatação
     * @return {@link EnderecoERP}
     * @throws SigepClienteException ocorre quando um endereço não é encontrado na base de dados da Empresa Brasileira de Correios e Telégrafos
     * @throws SQLException_Exception ocorre quando há problemas com o acesso à base de dados da Empresa Brasileira de Correios e Telégrafos
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaCEP", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", className = "br.eti.sen.endereco.wscorreios.ConsultaCEP")
    @ResponseWrapper(localName = "consultaCEPResponse", targetNamespace = "http://cliente.bean.master.sigep.bsb.correios.com.br/", className = "br.eti.sen.endereco.wscorreios.ConsultaCEPResponse")
    public EnderecoERP consultaCEP(@WebParam(name = "cep", targetNamespace = "") String cep) throws SQLException_Exception, SigepClienteException;

}
