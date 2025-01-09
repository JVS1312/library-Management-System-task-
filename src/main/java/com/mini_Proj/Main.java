package com.mini_Proj;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		try {
			Connection connection= Connection_Pool.giveConnection();
			
			if (connection!=null) {
				Statement stmStatement=connection.createStatement();
			System.out.println("Menu : Library Mangement System");
			Authors authors=new Authors(connection);
			Books books=new Books(connection);
			Scanner scanner= new Scanner(System.in);
			int choice;
			do {
				System.out.println("****/*/*/*/*/*/*/*/*//******");
				System.out.println("1.add Author");
				System.out.println("2.update author");
				System.out.println("3.delete Author");
				System.out.println("4.list all Author");
				System.out.println("5.add books");
				System.out.println("6.update books");
				System.out.println("7.delete books");
				System.out.println("8.list all books");
				System.out.println("9.exit");
				System.out.println("****/*/*/*/*/*/*/*/*//******");
				System.out.println("Enter ur choice");
				choice=scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				
				case 1:
					System.out.println("enter author name");
					String aname=scanner.nextLine();
					authors.addAuthor(aname);
					System.out.println("Added");
					
					
					break;
				case 2:
                    System.out.println("Enter Author ID to update:");
                    int aidToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new author name:");
                    String newName = scanner.nextLine();
                    authors.updateAuthor(aidToUpdate, newName);
                    System.out.println("Author updated.");
                    break;

                case 3:
                    System.out.println("Enter Author ID to delete:");
                    int aidToDelete = scanner.nextInt();
                    authors.deleteAuthor(aidToDelete);
                    System.out.println("Author deleted.");
                    break;

                case 4:
                    authors.listAllAuthors();
                    break;

                case 5:
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter author ID:");
                    int authorId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    books.addBook(title, authorId);
                    System.out.println("Book added.");
                    break;

                case 6:
                    System.out.println("Enter Book ID to update:");
                    int bookIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new book title:");
                    String newTitle = scanner.nextLine();
                    books.updateBook(bookIdToUpdate, newTitle);
                    System.out.println("Book updated.");
                    break;

                case 7:
                    System.out.println("Enter Book ID to delete:");
                    int bookIdToDelete = scanner.nextInt();
                    books.deleteBook(bookIdToDelete);
                    System.out.println("Book deleted.");
                    break;

                case 8:
                    books.listAllBooks();
                    break;

                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 9);

        scanner.close();
    }

} catch (SQLException e) {
    e.printStackTrace();
}
}
}