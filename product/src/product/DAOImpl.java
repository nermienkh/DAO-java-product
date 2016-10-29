
package product;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import product.product;

public class DAOImpl implements productDAO {
 Connection connection1 = null;
 public DAOImpl() {}//constrctor
 
private Connection getconnection1(){
System.out.println("-------- MySQL JDBC Connection Testing ------------");
try {Class.forName("com.mysql.jdbc.Driver");
		
		if (connection1==null)
			connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/task1","root", "");	
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
	
	   if (connection1 != null) {
		//System.out.println("You made it, take control your database now!");
		               return connection1 ;
	         } 
	   else {
		System.out.println("Failed to make connection!");
	}
	
	return connection1;

	
 }
   
	public void insert_product(product product){
		try{
		
	//statment=is the query excute bta5od kol 3lamet estfham w bt3mlha set :trteb el mod5lat = 1.2..3.4.5)
			getconnection1();
			
			PreparedStatement psmt = connection1.prepareStatement("INSERT INTO product(`ProductID`,`type`,`manfucturer`,`production_date`,`expiry_date`)VALUES(?,?,?,?,?)");
			psmt.setNString(1, product.getProductID());
			psmt.setString(2, product.getType());
			psmt.setString(3, product.getManufacturer());
			psmt.setString(4, product.getProduction_Date());
			psmt.setString(5, product.getExpiry_Date());
			int i = psmt.executeUpdate();
			
			if (i > 0) {
				JOptionPane.showMessageDialog(null, "Product was successfully added");
			}
			else {
				JOptionPane.showMessageDialog(null, "Product was not added");
			}
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

@Override
	public void delete_Product(String productID) {
             try{
             getconnection1();
         //
            PreparedStatement psmt = connection1.prepareStatement("DELETE FROM `task1`.`product`\n" +"WHERE ProductID= ?;");
            psmt.setString(1, productID);
            
            psmt.executeUpdate();
			
             }catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
            
                }
            
     }
        
        @Override
	public void update_Product(product product,String productID){
           try{
          getconnection1();
          
                         PreparedStatement preparedStatement ;
			//dbConnection = getDBConnection();
                        //`ProductID`,`type`,`manfucturer`,`production date`,`expiry date
			preparedStatement = connection1.prepareStatement("UPDATE `task1`.`product`  SET  type=? ,manfucturer=?, production_date=?,expiry_date=? "+ "WHERE ProductID= ?;");
                        //preparedStatement.setString(1, product.getProductID());
                        preparedStatement.setString(1, product.getType());
			preparedStatement.setString(2, product.getManufacturer());
			preparedStatement.setString(3, product.getProduction_Date());
			preparedStatement.setString(4, product.getExpiry_Date());
                        preparedStatement.setString(5,productID );                        
			///preparedStatement.setInt(2, 1001);

			// execute update SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("Record is updated to product table!");
          
          
        //psmt.executeUpdate();     
           }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);}
        
        }
        
    
   
    @Override
             public List<product> Retrieve_all_products(){
                    
              List<product> products = new LinkedList <product>() ;
     try{
         getconnection1();
                      Statement statement = connection1.createStatement();
                      ResultSet resultSet = statement.executeQuery("SELECT * FROM `task1`.`product`" );
                      /*+ "where manfucturer= ?"*/
                      
         
                             product product = null;
                      while(resultSet.next()){
                          product = new product();
                          product.setProductID(resultSet.getString("productID"));
                          product.setType(resultSet.getString("type"));
                          product.setManufacturer(resultSet.getString("manfucturer"));
                          product.setProduction_Date(resultSet.getString("production_date"));
                          product.setExpiry_Date(resultSet.getString("expiry_date"));
                          //System.out.println(product.toString());
                          System.out.println("productID:" + product.getProductID());
                          System.out.println("type:" + product.getType());
 
        /*SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dob = format.format(employee.getDob());
 */
                          System.out.println("manfucturer:" + product.getManufacturer());
                          System.out.println("production_date:" + product.getProduction_Date());
                          System.out.println("expiry_date:" + product.getExpiry_Date());
        //System.out.println();
                          
                          products.add(product);
                      }
                      
                 resultSet.close();
                statement.close();
                      
           } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
     //System.out.println(products);
     return products ;

   }
 
             
             
             
             
             
 @Override
                  public List<product> select_by(String Manufacturer){
                 
                    
              List<product> products = new LinkedList <product>() ;
     try{
         getconnection1();
                      PreparedStatement ps = connection1.prepareStatement("SELECT * FROM `task1`.`product`"+"where manfucturer=?");
                      /*+ "where manfucturer= ?"*/
                      ps.setNString(1, Manufacturer);
                     ResultSet resultSet =ps.executeQuery();
                           product product = null;
                           //if will return only one result not all 
                     while(resultSet.next()){
                          product = new product();
                          product.setProductID(resultSet.getString("productID"));
                          product.setType(resultSet.getString("type"));
                          product.setManufacturer(resultSet.getString("manfucturer"));
                          product.setProduction_Date(resultSet.getString("production_date"));
                          product.setExpiry_Date(resultSet.getString("expiry_date"));
                          //System.out.println(product.toString());
                          System.out.println("productID:" + product.getProductID());
                          System.out.println("type:" + product.getType());
 
        /*SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dob = format.format(employee.getDob());
 */
                          System.out.println("manfucturer:" + product.getManufacturer());
                          System.out.println("production_date:" + product.getProduction_Date());
                          System.out.println("expiry_date:" + product.getExpiry_Date());
        //System.out.println();
                          
                          products.add(product);
                      }
                      
                 resultSet.close();
                //statement.close();
                      
           } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
     //System.out.println(products);
     return products ;

   }
                  };

		
                
                