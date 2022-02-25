
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Database {

//     //connecting to the database
//     protected Connection connection;
//
//     //the Query class instance
//     protected Query query;
//
// 
//     public Database(String db, String userName, String password) throws SQLException{
//
//          connection = DriverManager.getConnection("jdbc:mysql://localhost/" + "pokemondb", "root", "Aman.deep123");
//
//     }
//     
//     public ResultSet select(String table, Object[] columns, Object[] params) throws SQLException{
//         return this.select(table, columns, "", params);
//     }
//     /**
//      * Returns data from a table
//      * @param table
//      * @param columns
//      * @param requirement
//      * @param params
//      * @return
//      * @throws SQLException
//      */
//     public ResultSet select(String table, Object[] columns, String requirement, Object[] params) throws SQLException{
//         query = new Query();
//         query.select(columns)
//              .from(table)
//              .where(requirement);
//
//         PreparedStatement ps = connection.prepareStatement(query.getQuery());
//         if(params != null){
//             int index = 1;
//             for(Object param : params){
//             ps.setObject(index, param);
//             index++;
//          }
//         }
//
//         ResultSet rs = ps.executeQuery();
//         return rs;
//     }
//     /**
//      * @param args the command line arguments
//      */
//     public static void main(String[] args) {
//         try {
//             Database database = new Database("persons", "root", "");
//         } catch (SQLException ex) {
//             System.out.println("error - "+ex.getMessage());
//         }
//     }
//     
//     
//     private int query(String query, Object[] params) throws SQLException{
//         PreparedStatement ps = connection.prepareStatement(query);
//         if (params != null){
//           int index = 1;
//           for(Object param : params){
//             ps.setObject(index, param);
//            index++;
//           }
//         }
//         return ps.executeUpdate();
//    }
//     
//     /**
//      * Updates data stored in a database table
//      * @param table
//      * @param columns
//      * @param requirement
//      * @param params
//      * @return
//      * @throws SQLException
//      */
//     public int update(String table, String[] columns, String requirement, Object[] params) throws SQLException{
//         query = new Query();
//
//         query.update(table)
//              .set(columns)
//              .where(requirement);
//
//         return query(query.getQuery(), params);
//     }
//     
//     
//     /**
//      * Inserts one row to a database table
//      * @param table
//      * @param params
//      * @return
//      * @throws java.sql.SQLException
//      */
//     public int insert(String table, Object[] params) throws SQLException{
//         query = new Query();
//         query.insert(table)
//              .values(params);
//         return query(query.getQuery(), params);
//     }
//     
//     public int delete(String table, String requirement, Object[] param) throws SQLException{
//         query = new Query();
//         query.delete(table)
//              .where(requirement);
//         return query(query.getQuery(), param);
//     }
     

}