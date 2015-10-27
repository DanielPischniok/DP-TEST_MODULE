package de.pischniok.jdbc;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import de.pischniok.LoggingInvocationHandler;
import de.pischniok.RuntimePropertiesCache;

public class CryptingDriver implements Driver {
	
	private final static String PREFIX = "jdbc:crypted:";
	

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		if(acceptsURL(url)){
			try {
				Class.forName(RuntimePropertiesCache.REALDBDRIVERCLASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			final Driver realDriver = DriverManager.getDriver(url.substring(PREFIX.length()));
			final Connection realConn = realDriver.connect(url.substring(PREFIX.length()), info);
			return (Connection) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), 
					new Class[]{Connection.class},
					new LoggingInvocationHandler(realConn));
		}else{
			return null;
		}
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return url.startsWith(PREFIX);
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
			throws SQLException {
		return null;
	}

	@Override
	public int getMajorVersion() {
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 1;
	}

	@Override
	public boolean jdbcCompliant() {
		return true;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

}
