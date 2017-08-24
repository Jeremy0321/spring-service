package com.jeremy.sql;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mysql.jdbc.JDBC4Connection;

public class DataSourcePool implements DataSource {

	private static LinkedList<Connection> connections = new LinkedList<Connection>();

	static {
		try {
			InputStream input = DataSourcePool.class.getClassLoader().getResourceAsStream("config/db.properties");
			Properties prop = new Properties();
			prop.load(input);
			String driver = prop.getProperty("db.driver");
			String url = prop.getProperty("db.url");
			String username = prop.getProperty("db.username");
			String password = prop.getProperty("db.password");
			Integer initialSize = Integer.parseInt(prop.getProperty("db.initialSize"));
			for (int i = 0; i < initialSize; i++) {
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, username, password);
				connections.add(conn);
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public Connection getConnection() throws SQLException {
		if (connections.size() > 0) {
			final Connection conn = connections.removeFirst();
			return (Connection) Proxy.newProxyInstance(DataSourcePool.class.getClassLoader(),
					conn.getClass().getInterfaces(), new InvocationHandler() {
						public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
							if (!method.getName().equals("close")) {
								return method.invoke(conn, args);
							} else {
								// 如果调用的是Connection对象的close方法，就把conn还给数据库连接池
								connections.add(conn);
								System.out.println(conn + "被还给listConnections数据库连接池了！！");
								System.out.println("listConnections数据库连接池大小为" + connections.size());
								return null;
							}
						}
					});
		} else {
			throw new SQLException("超过最大连接数");
		}
	}

	static class ConnectionInvocationHandler implements InvocationHandler {

		Connection conn;

		Object newPorxyInstance(Connection conn) {
			this.conn = conn;
			return Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), this);
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			// TODO Auto-generated method stub
			return method.invoke(conn, args);
		}

	}

	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws Exception {
		DataSourcePool pool = new DataSourcePool();
		Connection conn = pool.getConnection();
		System.out.println(conn);
	}
}
