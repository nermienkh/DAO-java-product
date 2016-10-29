package product;
import java.util.Scanner; 
import java.io.Console;
import java.io.Console;

public class program {

	public static void main(String[] args) {
        
        DAOImpl productDao= new DAOImpl() ;//constructor
        product product1=new product();
        boolean end =false;
        //System.out.println("choose an order : 1/insertproduct ,2/update product by ID,3/delete product by id ,4/list all products ,5/list products by manfuctrrer,6/exit");
        
        //Scanner scan = new Scanner(System.in);
        char s ;//= scan.next().charAt(0);
        
        while (end == false){
            
        System.out.println("choose an order 1/insertproduct ,2/update product by ID,3/delete product by id ,4/list all products ,5/list products by manfuctrrer,6/exit");
        Scanner scan5 = new Scanner(System.in);
        s = scan5.next().charAt(0);
        switch(s) {
         case '1' :
        System.out.println("insert productID ");
        Scanner scan_insert = new Scanner(System.in);
        String productID = scan_insert.next();
             System.out.println("insert productType ");
        String productType = scan_insert.next();
             System.out.println("insert productManufacturer");
        String productManufacturer = scan_insert.next();
             System.out.println("insert Expiry_Date ");
        String Expiry_Date = scan_insert.next();
             System.out.println("insert Production_Date ");
        String Production_Date = scan_insert.next();
            
        product1.setProductID(productID);
        product1.setType(productType);
        product1.setManufacturer(productManufacturer);
        product1.setExpiry_Date(Expiry_Date);
        product1.setProduction_Date(Production_Date);
        productDao.insert_product(product1);
        break;
        //System.out.println(" recored inserted successfully ");
           
         case '2' :
                     System.out.println("insert productID ");
                     Scanner scan_insert1 = new Scanner(System.in);
                     String productid = scan_insert1.next();
                     System.out.println("insert productType ");
                     String productType1 = scan_insert1.next();
                     System.out.println("insert Manufacturer ");
                     String Manufacturer1 = scan_insert1.next();
                     System.out.println("insert Expiry_Date ");
                     String Expiry_Date1= scan_insert1.next();
                     System.out.println("insert Production_Date ");
                     String Production_Date1= scan_insert1.next();
                     
        product1.setType(productType1);
        product1.setManufacturer(Manufacturer1);
        product1.setExpiry_Date(Expiry_Date1);
        product1.setProduction_Date(Production_Date1);
        productDao.update_Product(product1,productid);    
       // System.out.println("recored updated successfully ");
             break;
             
         case '3' :
       System.out.println("Which product do you want to delete?' insert the product ID please'  ");
                     Scanner scan_insert2 = new Scanner(System.in);
                     String productID2 = scan_insert2.next();
       productDao.delete_Product(productID2);
       System.out.println("the recored deleted successfully ");
            break;
         case '4' :
           productDao.Retrieve_all_products();
           break;
         case '5' :
             System.out.println("Which Manfuctrere do you want to see ? ");
                     Scanner scan_insert5 = new Scanner(System.in);
                     String manf = scan_insert5.next();
         productDao.select_by(manf);
            break;
            
            case '6' :
                end=true;
         default :
            //System.out.println("please,choose an order 1/insertproduct ,2/update product by ID,3/delete product by id ,4/list all products ,5/list products by manfuctrrer,6/exit");
      }
 
         }
        
        //1-delete the record 22
         /*productDao.delete_Product("22");*/
         
	 //2/insert new recored 22!
        /*product1.setProductID("22");
        product1.setType("sonyy");
        product1.setManufacturer("LG");
        product1.setExpiry_Date("2016");
        product1.setProduction_Date("2010");
        productDao.insert_product(product1);
        */
        
       //3- update the inserted record !
       /* String productid="22";
        product1.setType("sonyyyyy");
        product1.setManufacturer("LGhhh");
        product1.setExpiry_Date("2016ll");
        product1.setProduction_Date("2010kkk");
        productDao.update_Product(product1,productid);*/
       
       
        //4- delete the updated recored again no recored 22 
        /* productDao.delete_Product("22");*/

        //5-RETRIVE ALL
        //productDao.Retrieve_all_products();
        
        //6-select by manfacturer 
        //productDao.select_by("samsung");
       
		}
	   
	}

