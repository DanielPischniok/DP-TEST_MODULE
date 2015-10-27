package de.pischniok;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import de.pischniok.encoding.Base64Coder;
import de.pischniok.encryption.Encrypter;

public class LoggingInvocationHandler implements InvocationHandler {
	
	private Object inner;
	private Encrypter crypter;
	
	public LoggingInvocationHandler(Object inner){
		this.inner = inner;
		
		String pass64 = "MzEuZG8zcTEuZ2V3c2d3UQ==";
		Base64Coder base64 = new Base64Coder();
		String encPass64 = base64.getDecodedString(pass64);
		SecretKey key = new SecretKeySpec(encPass64.getBytes(),"AES");
		try {
			crypter = new Encrypter("AES", key);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		try{
			
			if(method.getName().equalsIgnoreCase("getString")){
				if(args != null){
					for(Object o: args){
						if(o.toString().startsWith("enc7_")){
							Object result = method.invoke(inner, args);
							if(result != null){
								String r = new String(crypter.getClearData(result.toString().getBytes()));
								result = r;
							}
							return result;
						}
					}
				}
			}
			
			
			if(method.getName().equalsIgnoreCase("setString")){
				if(args != null){
					//get second argument from method
					Object value = args[1];
					value = new String(crypter.getEncryptedData(value.toString().getBytes()));
					args[1] = value;
				}
			}
			final Object result = method.invoke(inner, args);
			
			if(method.getReturnType().isInterface()){
				return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
						new Class[]{method.getReturnType()},
						new LoggingInvocationHandler(result));
			}
			return result;
			
		}catch(InvocationTargetException e){
			throw e.getCause();
		}
	}

}
