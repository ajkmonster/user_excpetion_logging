package com.fdmgroup.ood2wednesdayexercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static Logger gLogger = Logger.getLogger("generalLogger");
	static User user = new User();
	
	public static void main(String[] args) {
		prompt();
		writeToFile(user);
		readFromFile("Users.txt");
	}
	
	private static void readFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch (FileNotFoundException e) {
			gLogger.trace("File Not Found Exception: " + e);
		} catch (IOException e) {
			gLogger.trace("IOException could not read line: " + e);
		}
	}
	
	private static void writeToFile(User user) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Users.txt",true))) {
			bw.write(user.getName() + ", " + user.getAddress() + ", " + user.getPhone() + ", " + user.getEmail() + "\n");
		} catch (IOException e) {
			gLogger.trace("IOException could not write to file: " + e);
		}
	}
	
	private static void prompt() {
		System.out.println("Enter in your name: ");
		String name = sc.nextLine();
		System.out.println("Enter in your address: ");
		String address = sc.nextLine();
		System.out.println("Enter in your phone: (ex: xxx-xxx-xxxx)");
		String phone = sc.nextLine();
		System.out.println("Enter in your email: ");
		String email = sc.nextLine();
		user = new User(name,address,phone,email);
	}
	
}
