package com.mini_Proj;

import java.sql.*;

public class Authors {
	 private Connection connection;

	    public Authors(Connection connection) {
	        this.connection = connection;
	    }

	    public void addAuthor(String name) {
	        String query = "INSERT INTO authors (name) VALUES (?)";
	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	            pstmt.setString(1, name);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void updateAuthor(int authorId, String newName) {
	        String query = "UPDATE authors SET name = ? WHERE id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	            pstmt.setString(1, newName);
	            pstmt.setInt(2, authorId);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteAuthor(int authorId) {
	        String query = "DELETE FROM authors WHERE id = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
	            pstmt.setInt(1, authorId);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void listAllAuthors() {
	        String query = "SELECT * FROM authors";
	        try (Statement stmt = connection.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}