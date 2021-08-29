package movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MVDao {
	
	public static MVDao instance;
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String userId="jspid";
	String userPw="jsppw";
	
	private MVDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userId, userPw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static MVDao getInstance() {
		if(instance==null) {
			instance=new MVDao();
		}
		return instance;
	}
	
	public void insertCommand(MVBean mb) {
		String sql="insert into movie values(mv_seq.nextval,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getName());
			ps.setInt(3, mb.getAge());
			ps.setString(4, mb.getGenre());
			ps.setString(5, mb.getTime());
			ps.setInt(6, mb.getPartner());
			ps.setString(7, mb.getMemo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//insertCommand
	
	public ArrayList<MVBean> getAllCommand() {
		
		ArrayList<MVBean> list = new ArrayList<MVBean>();
		
		String sql="select * from movie order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String genre = rs.getString("genre");
				String time = rs.getString("time");
				int partner = rs.getInt("partner");
				String memo = rs.getString("memo");
				
				MVBean mb = new MVBean(num,id,name,age,genre,time,partner,memo);
				list.add(mb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
				if(rs!=null) {
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		return list;
	}//getAllCommand
	
	public MVBean oneCommand(int num) {
		MVBean mb = null;
		String sql="select * from movie where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
		
			rs = ps.executeQuery();
			if(rs.next()) {
				int num2 = rs.getInt("num");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String genre = rs.getString("genre");
				String time = rs.getString("time");
				int partner = rs.getInt("partner");
				String memo = rs.getString("memo");
				
				mb = new MVBean(num2,id,name,age,genre,time,partner,memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
				if(rs!=null) {
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		return mb;
	}//oneCommand
	
	
	public void deleteCommand(int num) {
		
		String sql="delete from movie where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
		
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
	}//deleteCommand
	
	
	public void UpdateCommand(MVBean mb) {
		
		String sql="update movie set name=?,age=?,genre=?,time=?,partner=?,memo=? where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getName());
			ps.setInt(2, mb.getAge());
			ps.setString(3, mb.getGenre());
			ps.setString(4, mb.getTime());
			ps.setInt(5, mb.getPartner());
			ps.setString(6, mb.getMemo());
			ps.setInt(7, mb.getNum());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
	}//UpdateCommand
	
	public boolean idCheck(String userid) {
		
		boolean flag=false;  
		String sql="select id from movie where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
				if(rs!=null) {
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		return flag;
	}//idCheck
	
	public void selectDelete(String[] rowcheck) {
		
		String sql="delete from movie where num=?";
		
		for(int i=0;i<rowcheck.length-1;i++) {
			sql += " or num=?";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			
			for(int i=1;i<=rowcheck.length;i++) {
				ps.setInt(i, Integer.parseInt(rowcheck[i-1]));
			}
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		
	}//selectDelete
	
	public MVBean getContent(String id) {
		
		MVBean mb=null;
		
		String sql="select * from movie where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				int num = rs.getInt("num");
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String genre = rs.getString("genre");
				String time = rs.getString("time");
				int partner = rs.getInt("partner");
				String memo = rs.getString("memo");
				
				mb = new MVBean(num,id2,name,age,genre,time,partner,memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
				ps.close();
				}
				if(rs!=null) {
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		return mb;
	}//getContent
	
}//
