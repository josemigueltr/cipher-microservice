package com.api.factory.cifrador.service;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CipherServiceImpl implements CipherService {

    /**
     * Method that encrypt or decrypt a message with caesarCipher algorithm.
     * @param clave  key with  the message was encrypted
     * @param mensaje message to encrypt or decrypt
     * @param op flag that indicate if  the message is  encrypted or decrypted
     * @return String message encrypted or decrypted
     */
    @Override
    public String CaesarCipher(Integer clave, String mensaje, Boolean op) {

        Function<Integer,Integer> operation=
                op? character -> (character + clave - 'a') % 26:
                        character -> (character - (clave + 'a')) % 26;

        StringBuilder result = new StringBuilder();

        for (char character : mensaje.toCharArray()) {

            if (character == ' '){
                result.append(character);
                continue;
            }
            int position = operation.apply((int) character);
            char encryptCharacter = (char) ('a' + position);
            result.append(encryptCharacter);
        }
        return result.toString();
    }

}
