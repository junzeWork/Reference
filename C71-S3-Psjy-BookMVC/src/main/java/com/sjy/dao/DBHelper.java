package com.sjy.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;


/**
 * 
 * 閻€劋绨琂DBC 閻ㄥ嫭鎼锋担婊呮畱瀹搞儱鍙跨猾浼欑窗 XXXHelper XXXUtils
 * @author OMEN
 *
 */


public class DBHelper {
	// 娴ｈ法鏁ら棃娆愶拷浣告健閿涘苯濮炴潪浠嬧攳閸旓拷
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			//婵″倷缍嶆径鍕倞瀵倸鐖�
			//缂傛牞鐦ч張鐔风磽鐢憡妫ゅ▔鏇炴躬闂堟瑦锟戒礁娼℃稉顓熷閸戯拷
			throw new RuntimeException(e);//瀵倸鐖舵潪顒�鐎�===閵嗗绱撶敮鎼佹懠
		}
	}
	
	public static Connection opConnection() {
		// 2.閼惧嘲褰囨潻鐐村复
		String url = "jdbc:mysql://localhost/book";
		String user = "root";
		String password = "a";
		
		try {
			return  DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		
		
		
	}
	
	
	
	//婢х偛鍨归弨锟�
	/**
	 * 
	 * @param sql
	 * @param Object...param 閸欘垰褰夐崣鍌涙殶閺佹壆绮�
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static int executeUpdate(String sql,Object...param) {
		Connection conn=opConnection();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//鐠佸墽鐤嗛崣鍌涙殶
			for(int i=0;i<param.length;i++) {
				ps.setObject(i+1, param[i]);
				
			}
			ps.executeUpdate();
			
		}catch(Exception e){
			throw new RuntimeException(e);
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {

				throw new RuntimeException(e);
			}
			
		}
		

		
		return 0;
		
		
		
	}
	
	//閺屻儴顕�
	
	/**
	 * 閸掑棝銆夐弻銉嚄:     缁楊剙鍤戞い纰夌礉濮ｅ繘銆夌悰灞炬殶
	 * @param sql
	 * @param page  缁楊剙鍤戞い锟�
	 * @param rows  濮ｅ繘銆夌悰灞炬殶
	 * @param param
	 * @return
	 */
	
	public static List<Map<String,Object>> queryPage(String sql,int page,int rows,Object...param){
		
		sql="select * from (select t.*,rownum rn from ("+sql+")t where rownum <= ?) where rn >?";
		
		
		int endRow = page* rows;	
		
		int startRow = (page-1)* rows;
		
		Object[] newParam =new Object[param.length+2];
		
		System.arraycopy(param, 0, newParam, 0, param.length);
		
		newParam[newParam.length-2] = endRow;
		
		newParam[newParam.length-1] = startRow;
		
		return executeQuery(sql,newParam);
		
		
		
	}
public static List<Map<String,Object>> queryPageMysql(String sql,int page,int rows,Object...param){
		
//		sql="select * from (select t.*,rownum rn from ("+sql+")t where rownum <= ?) where rn >?";
		sql="select * from ("+sql+") t limit ? , ? ";
		
		
		int startRow = (page-1)* rows;
		
		Object[] newParam =new Object[param.length+2];
		
		System.arraycopy(param, 0, newParam, 0, param.length);
		
		
		
		newParam[newParam.length-2] = startRow;
		newParam[newParam.length-1] = rows;
		
		return executeQuery(sql,newParam);
		
		
		
	}
	

	
	
	public static List<Map<String, Object>> executeQuery(String sql,Object...param){
		Connection conn=opConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//鐠佸墽鐤嗛崣鍌涙殶
			for(int i=0;i<param.length;i++) { 
				ps.setObject(i+1, param[i]);
				
			}
			
			//鐏忎浇顥婄紒鎾寸亯闂嗭拷
			
			ResultSet rs=ps.executeQuery();
			
			List<Map<String,Object>> ret=new ArrayList<Map<String,Object>>();
			
			//缂佹挻鐏夐梿鍡欐畱閸樼喐鏆熼幑顔碱嚠鐠炩槄绱濈亸浣筋棅娴滃棛绮ㄩ弸婊堟肠閻ㄥ嫭澧嶉張澶変繆閹垽绱濋崠鍛閸掓娈戦弫浼村櫤閿涘苯鍨惃鍕倳鐎涳拷
				
			ResultSetMetaData rsmd=rs.getMetaData();
			
			while(rs.next()) {
				
				//閹跺﹥鐦℃稉锟界悰宀�娈戦崐鐓庡晸閸忣櫝ap
				//rs.getString(1)
				
				Map<String ,Object> row =new LinkedHashMap<String , Object>();
				//getColumnCount  閼惧嘲褰囩紒鎾寸亯闂嗗棔鑵戦崚妤冩畱閺佷即鍣�
				for(int i=0;i<rsmd.getColumnCount();i++) {
					
					//getColumnName  閺嶈宓侀崚妤冪椽閸欑柉骞忛崣鏍у灙閸氾拷
					
					String columnName = rsmd.getColumnName(i+1);
					Object value =rs.getObject(columnName);
					
					row.put(columnName, value);
				}
				ret.add(row);
			}
			return ret;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					
					throw new RuntimeException(e);
				}
		}
	}
	
	public static Map<String, Object> executeQuery1(String sql,Object...param){
		Connection conn=opConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			//鐠佸墽鐤嗛崣鍌涙殶
			for(int i=0;i<param.length;i++) { 
				ps.setObject(i+1, param[i]);
				
			}
			
			//鐏忎浇顥婄紒鎾寸亯闂嗭拷
			
			ResultSet rs=ps.executeQuery();
			
			Map<String,Object> ret=new HashMap<String, Object>();
			
			//缂佹挻鐏夐梿鍡欐畱閸樼喐鏆熼幑顔碱嚠鐠炩槄绱濈亸浣筋棅娴滃棛绮ㄩ弸婊堟肠閻ㄥ嫭澧嶉張澶変繆閹垽绱濋崠鍛閸掓娈戦弫浼村櫤閿涘苯鍨惃鍕倳鐎涳拷
				
			ResultSetMetaData rsmd=rs.getMetaData();
			
			while(rs.next()) {
				
				//閹跺﹥鐦℃稉锟界悰宀�娈戦崐鐓庡晸閸忣櫝ap
				//rs.getString(1)
				
				Map<String ,Object> row =new LinkedHashMap<String , Object>();
				//getColumnCount  閼惧嘲褰囩紒鎾寸亯闂嗗棔鑵戦崚妤冩畱閺佷即鍣�
				for(int i=0;i<rsmd.getColumnCount();i++) {
					
					//getColumnName  閺嶈宓侀崚妤冪椽閸欑柉骞忛崣鏍у灙閸氾拷
					
					String columnName = rsmd.getColumnName(i+1);
					Object value =rs.getObject(columnName);
					
					row.put(columnName, value);
				}
				ret.putAll(row);
			}
			return ret;
		
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					
					throw new RuntimeException(e);
				}
		}
	}
	
	public static long executeCount(String sql,Object...param) {
		
		sql="select count(*) cnt from ("+sql+") a";
		List<Map<String, Object>> list=executeQuery(sql, param);
		//return list.size();

		
		return Long.parseLong( ""+list.get(0).get("cnt"));
	}
public static long executeCount2(String sql,Object...param) {
		
		List<Map<String, Object>> list=executeQuery(sql, param);
		//return list.size();

		
		return Long.parseLong( ""+list.get(0).get("cnt"));
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		//List<Object> param =new ArrayList<Object>();
		
		
		
		//System.out.println(DBHelper.executeUpdate("insert into dept values(?,?,?)",90,"鐠愩垹濮熼柈锟�","鐞涳繝妲�"));
		
		//閼惧嘲褰囪ぐ鎾冲閺冨爼妫块敍灞炬暈閹板骏绱扮拠顧奱te閺勭棥ava.sql.Date  鐠囶檴ate鐞涖劎銇�  楠炲瓨婀�閺冿拷
		
		//Date date =new Date(System.currentTimeMillis());
		/*
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		java.util.Date d=format.parse("2019/06/21");
		
		Date date = new Date(d.getTime());
		*/
		
//		Date date =Date.valueOf("2008-5-12");
//		
//		DBHelper.executeUpdate("insert into emp (empno,ename,job,hiredate,sal) values (?,?,?,?,?)"
//				,7001,"瀵姳绗�","coder",date,10000);
		
		
		/*System.out.println("======================================================");
		
		System.out.println(DBHelper.executeQuery("select * from dept"));
		
		System.out.println("======================================================");
		
		System.out.println(DBHelper.executeQuery("select * from emp where sal> ?", 8000));*/
		
		System.out.println(DBHelper.queryPage("select * from emp",2, 5));
		
		System.out.println(DBHelper.queryPage("select * from emp",2, 5).size());
		
		
		
	}
	
	

}

