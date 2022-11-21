package com.lixiaodong.springboot.dbtest;

//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name",required = false,  defaultValue = "World") 
		String name, Model model) {
		
		
		model.addAttribute("name", name);
		
		//setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//get connection to database
		
		try {
			System.out.println("connecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user, pass);
			
			System.out.println("Success!!");
			
			myConn.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
					
		}
		
		
		return "greeting";
		
	}
	
	@GetMapping("/greetingDB")
	public ResponseEntity<String> greetingDB() {
	 
	    
		//setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//get connection to database
		
		try {
			System.out.println("connecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user, pass);
			
			System.out.println("Success!!");
			
			myConn.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
					
		}
		
	    return new ResponseEntity<>(
	      "connecting to database: " + jdbcUrl + "\n <h1>success!!</h1>",
	      HttpStatus.OK);
	}

}
