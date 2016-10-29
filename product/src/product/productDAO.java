package product;
//import java.util.List;
import java.util.List;

//import java.util.List;


     public interface productDAO {
     public void insert_product (product product);
     public void delete_Product(String productID);
     public void update_Product(product product ,String productID );
     public List<product> Retrieve_all_products();
     public List<product> select_by(String Manufacturer );
	 
	
}
