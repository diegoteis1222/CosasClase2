package dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.DBConnection;
import model.Product;

public class ProductDAO {

    public List<Product> findAll() throws SQLException {
        String sql = "SELECT ProductID, ProductName, QuantityPerUnit, UnitPrice, UnitsInStock, SupplierID, CategoryID " +
                     "FROM Products ORDER BY ProductID";
        List<Product> list = new ArrayList<>();
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Product p = mapRow(rs);
                list.add(p);
            }
        }
        return list;
    }

    public List<Product> findByName(String partialName) throws SQLException {
        String sql = "SELECT ProductID, ProductName, QuantityPerUnit, UnitPrice, UnitsInStock, SupplierID, CategoryID " +
                     "FROM Products WHERE ProductName LIKE ? ORDER BY ProductID";
        List<Product> list = new ArrayList<>();
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + partialName + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        }
        return list;
    }

    public Product findById(int id) throws SQLException {
        String sql = "SELECT ProductID, ProductName, QuantityPerUnit, UnitPrice, UnitsInStock, SupplierID, CategoryID " +
                     "FROM Products WHERE ProductID = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                } else {
                    return null;
                }
            }
        }
    }

    public int insert(Product p) throws SQLException {
        String sql = "INSERT INTO Products (ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getProductName());
            if (p.getSupplierID() != null) ps.setInt(2, p.getSupplierID()); else ps.setNull(2, Types.INTEGER);
            if (p.getCategoryID() != null) ps.setInt(3, p.getCategoryID()); else ps.setNull(3, Types.INTEGER);
            ps.setString(4, p.getQuantityPerUnit());
            if (p.getUnitPrice() != null) ps.setBigDecimal(5, p.getUnitPrice()); else ps.setNull(5, Types.DECIMAL);
            if (p.getUnitsInStock() != null) ps.setInt(6, p.getUnitsInStock()); else ps.setNull(6, Types.SMALLINT);

            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Insert fallido, no se ha creado fila.");
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    p.setProductID(keys.getInt(1));
                }
            }
            return affected;
        }
    }

    public int update(Product p) throws SQLException {
        String sql = "UPDATE Products SET ProductName=?, QuantityPerUnit=?, UnitPrice=?, UnitsInStock=? WHERE ProductID=?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getQuantityPerUnit());
            if (p.getUnitPrice() != null) ps.setBigDecimal(3, p.getUnitPrice()); else ps.setNull(3, Types.DECIMAL);
            if (p.getUnitsInStock() != null) ps.setInt(4, p.getUnitsInStock()); else ps.setNull(4, Types.SMALLINT);
            ps.setInt(5, p.getProductID());
            return ps.executeUpdate();
        }
    }

    public int delete(int productId) throws SQLException {
        String sql = "DELETE FROM Products WHERE ProductID = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, productId);
            return ps.executeUpdate();
        }
    }

    private Product mapRow(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setProductID(rs.getInt("ProductID"));
        p.setProductName(rs.getString("ProductName"));
        p.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
        BigDecimal price = rs.getBigDecimal("UnitPrice");
        p.setUnitPrice(price);
        int stock = rs.getInt("UnitsInStock");
        if (rs.wasNull()) p.setUnitsInStock(null); else p.setUnitsInStock(stock);
        int sup = rs.getInt("SupplierID");
        if (rs.wasNull()) p.setSupplierID(null); else p.setSupplierID(sup);
        int cat = rs.getInt("CategoryID");
        if (rs.wasNull()) p.setCategoryID(null); else p.setCategoryID(cat);
        return p;
    }
}
