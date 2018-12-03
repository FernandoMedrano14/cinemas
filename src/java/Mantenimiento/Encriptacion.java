package Mantenimiento;

import org.apache.commons.codec.digest.DigestUtils;

public class Encriptacion {
    
    private String texto;
    private String encriptado;

    public Encriptacion() {
    }

    public String Encriptacion(String texto) {
        this.texto = texto;
        encriptado = DigestUtils.sha1Hex(texto);        
        return encriptado;        
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEncriptado() {
        return encriptado;
    }

    public void setEncriptado(String encriptado) {
        this.encriptado = encriptado;
    }
    
    
    
}
