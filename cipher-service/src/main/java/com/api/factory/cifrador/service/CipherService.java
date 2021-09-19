package com.api.factory.cifrador.service;

public interface CipherService {

    String CaesarCipher(Integer clave, String mensaje, Boolean op);

}
