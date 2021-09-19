package com.api.factory.cifrador.controller;

import com.api.factory.cifrador.model.CipherCaesarModel;
import com.api.factory.cifrador.service.CipherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the cipher.
 * @author Gustavo Gama.
 *
 */
@RestController
public class CipherController {

    @Autowired
    CipherService cipherService;

    /**
     * Method that encrypt a message with caesarCipher algorimth.
     * @param clave  key with  the message will be encrypted
     * @param mensaje message to encrypt
     * @return Response object with the encrypted message.
     */
    @GetMapping("/encrypt/{clave}/{mensaje}")
    public ResponseEntity<CipherCaesarModel> getEncryptCaesarCipher(@PathVariable("clave") int clave,
                                                                    @PathVariable("mensaje") String mensaje) {
        String encryptMessage=cipherService.CaesarCipher(clave,mensaje,true);
        CipherCaesarModel cipherCaesarModel= CipherCaesarModel.builder().resultmessage(encryptMessage).build();
        return new ResponseEntity<>(cipherCaesarModel, HttpStatus.OK);
    }


    /**
     * Method that dencrypt a message with caesarCipher algorimth.
     * @param clave  key with  the message was encrypted
     * @param mensaje message to decrypt
     * @return Response object with the encrypted message.
     */
    @GetMapping("/decrypt/{clave}/{mensaje}")
    public ResponseEntity<CipherCaesarModel> getDecryptCaesarCipher(@PathVariable("clave") int clave,
                                                                    @PathVariable("mensaje") String mensaje) {
        String message=cipherService.CaesarCipher(clave,mensaje,false);
        CipherCaesarModel cipherCaesarModel= CipherCaesarModel.builder().resultmessage(message).build();
        return new ResponseEntity<>(cipherCaesarModel, HttpStatus.OK);	}



}
