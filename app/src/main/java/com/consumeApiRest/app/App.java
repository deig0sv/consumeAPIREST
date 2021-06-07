package com.consumeApiRest.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import com.consumeApiRest.client.ActivatorClient;
import com.consumeApiRest.error.ServiceException;
import com.consumeApiRest.model.GenericResponse;
import com.consumeApiRest.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
//        ActivatorClient client = new ActivatorClient("http://localhost:5000/", "");
//		try {
//	        Product product;
//			product = client.getProductById("4");
//	        System.out.println(String.format("Product By Id %s",product.toString()));
//	        
//	        List<Product> allProduct;
//	        allProduct = client.getAllProduct();
//	        System.out.println(String.format("Product By Id %s",allProduct.toString()));
//	        
//	        Product newProduct = new Product();
//	        newProduct.setId(6);
//	        newProduct.setActivateCode("321321321-31321321");
//	        newProduct.setProductName("Concatenado-PDF");
//	        newProduct.setProductVersion("1.0.0");
//	        System.out.println(String.format("New Product %s",newProduct.toString()));
//	        
//	        GenericResponse gResponse = new GenericResponse();
//	        gResponse = client.createProduct(newProduct);
//	        System.out.println(String.format("Product Created %s",gResponse.toString()));
//	        
//	        Product activateProduct = new Product();
//	        activateProduct.setActivateCode("1234");
//	        activateProduct.setCheckSumMAC("1234321");
//	        
//	        LocalDateTime myDateObj = LocalDateTime.now();
//	        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//	        String formattedDate = myDateObj.format(myFormatObj);
//	        
//	        activateProduct.setComments(formattedDate);
//	        
//	        activateProduct = client.activateProduct(activateProduct);
//	        System.out.println(String.format("Product Activated %s",activateProduct.toString()));
//	        
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    
			
			
			String computername;
			try {
				computername = InetAddress.getLocalHost().getHostName();
				System.out.println(computername);
				System.out.println("Checksum CRC32: "+getCRC32Checksum(computername.concat("-").getBytes()));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String test = "test";
			byte[] bytes = test.getBytes();
			
			System.out.println("Checksum CRC32: "+getCRC32Checksum(bytes));
//			CheckSum CRC32: 3632233996

//Checksum CRC32: 2633346148
//Checksum CRC32: 3632233996

//Checksum CRC32: 3718177557
//Checksum CRC32: 3632233996
    }
    
    public static long getCRC32Checksum(byte[] bytes) {
        Checksum crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        return crc32.getValue();
    }
}
