package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

// CRUD functions
//getAllX,getXByID, createX, updateX,deleteX
// person, category, employee, etc = entity


// CREATE
public class CategoryRepository {

    private BasicDataSource basicDataSource;

    public CategoryRepository(String url, String userName, String password) {
        initializeDataSource(url, userName, password);
    }

    private void initializeDataSource(String url, String userName, String password) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public void createCategory(Category category) {
        String query = "INSERT INTO categories(CategoryName, Description) VALUES (?, ?)";

        try (Connection con = basicDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getDescription());

            ps.executeUpdate();

        } catch (SQLException e) {
            // Log or print the exception details for debugging
            e.printStackTrace();
        }
    }


    // UPDATE
    public void updateCategory(Category category) {
        String query = "UPDATE categories SET CategoryName = ? WHERE CategoryID = ?";
        try (Connection con = basicDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getCategoryID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // DELETE
    public void deleteCategory(int id) {
        String query = "DELETE FROM categories WHERE CategoryID = ?";
        try (Connection con = basicDataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }



}