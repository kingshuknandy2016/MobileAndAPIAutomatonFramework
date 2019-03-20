package com.common.backend.utils;

public class DatabaseUtils {
public static void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.clearWarnings();
				ps.clearParameters();
				ps.close();
			}
		} catch (SQLException sqlexception) {
			
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement!= null) {
				statement.close();
			}
		} catch (SQLException sqle) {
			
		}
	}
  
  public static void close(PreparedStatement ps, ResultSet rs) {
		close(rs);
		close(ps);
	}

	public static void close(Statement st, ResultSet rs) {
		close(rs);
		close(st);
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqle) {

		}
	}
  
  public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException se) {
		
		}
	}

	public static Connection getConnection() throws Exception {
		PropertyUtil props = new PropertyUtil(System.getProperty("user.dir")+"\\resources\\"+ConfigurationManager.getBundle().getProperty("db.properties"));
		String url = props.getString("db.connection.url");
		String driverclass = props.getString("db.driver.class");
		String user = props.getString("db.user");
		String pwd = props.getString("db.pwd");
		return getConnection(driverclass, url, user, pwd);
	}
  
  public static Connection getConnection(String driverCls, String url, String user, String pwd) throws Exception {
		Connection con = null;
		Class.forName(driverCls);
		con = DriverManager.getConnection(url, user, pwd);
		return con;
	}
  
  public static Object[][] getData(String query) {
		ArrayList<Object[]> rows = new ArrayList();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int colsCnt = rs.getMetaData().getColumnCount();
				Object[] cols = new Object[colsCnt];
				for (int indx = 0; indx < colsCnt; indx++) {
					cols[indx] = rs.getObject(indx + 1);
				}
				rows.add(cols);
			}
} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
			close(con);
		}
		return (Object[][]) rows.toArray(new Object[0][]);
	}
  
  public static HashMap<String, String> getDBSingleRowValue(String query) {
		HashMap<String, String> mapOtput = new HashMap<String, String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DatabaseUtils.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.err.println("-----------------------this isthe query" + query);
			while (rs.next()) {
				int colsCnt = rs.getMetaData().getColumnCount();
				for (int indx = 1; indx <= colsCnt; indx++) {
					mapOtput.put(rs.getMetaData().getColumnLabel(indx), String.valueOf(rs.getObject(indx)));
					System.out
							.println(rs.getMetaData().getColumnLabel(indx) + ":" + String.valueOf(rs.getObject(indx)));
				}
			}
      
      } catch (Exception e) {
			e.printStackTrace();
		} finally {
			DatabaseUtils.close(stmt, rs);
			DatabaseUtils.close(con);
		}
		return mapOtput;
	}

	public static HashMap<String, String> getDataFromDB(String tableName, String WhereClauseParameterName,
			String parameterValue) {
		HashMap<String, String> map = DatabaseUtils.getDBSingleRowValue(
				"Select * from " + tableName + " WHERE " + WhereClauseParameterName + "='" + parameterValue + "'");
		return map;
	}
}
