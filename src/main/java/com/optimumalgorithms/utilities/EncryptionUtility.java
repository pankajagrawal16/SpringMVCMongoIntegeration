package com.optimumalgorithms.utilities;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

/**
 * The class is used to encrypt and decrypt the String based passwords used
 * through out the work flow
 * 
 * @author OptimumAlgorithms
 * 
 */
@Service
public class EncryptionUtility {
	private static final String FORMAT = "ISO-8859-1";
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";

	private KeySpec ks;
	private SecretKeyFactory skf;
	private Cipher cipher;
	private SecretKey key;

	private String myEncryptionKey = "4A144BEBF7E5E7B7DCF26491AE79C54C768C514CF1547D23";

	public EncryptionUtility() {
		try {
			ks = new DESedeKeySpec(myEncryptionKey.getBytes(FORMAT));
			skf = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
			cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
			key = skf.generateSecret(ks);
		} catch (InvalidKeyException | UnsupportedEncodingException
				| NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeySpecException e) {
			e.printStackTrace();
		}

	}

	/**
	 * The method is used to encrypt the input String passed as input parameter
	 * 
	 * @param unencryptedString
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String unencryptedString){

		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = unencryptedString.getBytes(FORMAT);
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = DatatypeConverter
					.printBase64Binary(encryptedText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedString;
	}

	/**
	 * The method is used to decrypt the encrypted String as passed as input
	 * parameter
	 * 
	 * @param encryptedString
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String encryptedString) {

		String decryptedText = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] encryptedText = DatatypeConverter
					.parseBase64Binary(encryptedString);
			byte[] plainText = cipher.doFinal(encryptedText);
			decryptedText = new String(plainText, FORMAT);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return decryptedText;
	}

	/**
	 * Get the special character code
	 * 
	 * @param code
	 * @return
	 */
	public static String getSpecialCharacter(int code) {

		Charset charSet = Charset.forName(FORMAT);
		String specialCharacter = new String(new byte[] { (byte) code },
				charSet);
		specialCharacter = String.format("%s", specialCharacter);

		return specialCharacter;
	}

}
