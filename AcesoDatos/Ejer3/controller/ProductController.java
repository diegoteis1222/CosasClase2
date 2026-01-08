package controller;


import dao.ProductDAO;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import model.Product;
import view.MainView;
import view.ProductFormDialog;

public class ProductController {
    private ProductDAO dao;
    private MainView view;

    public ProductController(ProductDAO dao, MainView view) {
        this.dao = dao;
        this.view = view;
        initController();
        refreshTable();
    }

    private void initController() {
        view.getBtnRefresh().addActionListener(e -> refreshTable());
        view.getBtnBuscar().addActionListener(e -> searchByName());
        view.getBtnPrecioMayor50().addActionListener(e -> filterByPriceGreaterThan50());
        view.getBtnNuevo().addActionListener(e -> newProduct());
        view.getBtnEditar().addActionListener(e -> editProduct());
        view.getBtnEliminar().addActionListener(e -> deleteProduct());
    }

    private void refreshTable() {
        try {
            List<Product> list = dao.findAll();
            System.out.println("Productos cargados: " + list.size());
            view.setTableData(list);
        } catch (SQLException e) {
            showError("Error cargando productos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void searchByName() {
        String q = view.getSearchText();
        try {
            List<Product> list;
            if (q.isEmpty()) list = dao.findAll();
            else list = dao.findByName(q);
            view.setTableData(list);
        } catch (SQLException e) {
            showError("Error en búsqueda: " + e.getMessage());
        }
    }

    private void filterByPriceGreaterThan50() {
        try {
            List<Product> list = dao.findByPriceGreaterThan(50.0);
            view.setTableData(list);
        } catch (SQLException e) {
            showError("Error filtrando por precio: " + e.getMessage());
        }
    }

    private void newProduct() {
        ProductFormDialog form = new ProductFormDialog(view);
        form.setProduct(null);
        form.getBtnSave().addActionListener((ActionEvent e) -> {
            try {
                Product p = form.collectFormData();
                dao.insert(p);
                form.setVisible(false);
                refreshTable();
                showInfo("Producto creado correctamente (ID: " + p.getProductID() + ").");
            } catch (IllegalArgumentException ex) {
                showError(ex.getMessage());
            } catch (SQLException ex) {
                showError("Error al insertar producto: " + ex.getMessage());
            }
        });
        form.showDialog();
    }

    private void editProduct() {
        int id = view.getSelectedProductId();
        if (id == -1) { showError("Selecciona un producto para editar."); return; }
        try {
            Product p = dao.findById(id);
            if (p == null) { showError("Producto no encontrado."); return; }
            ProductFormDialog form = new ProductFormDialog(view);
            form.setProduct(p);
            form.getBtnSave().addActionListener((ActionEvent e) -> {
                try {
                    form.collectFormData();
                    int updated = dao.update(p);
                    if (updated > 0) {
                        form.setVisible(false);
                        refreshTable();
                        showInfo("Producto actualizado.");
                    } else {
                        showError("No se actualizó el producto.");
                    }
                } catch (IllegalArgumentException ex) {
                    showError(ex.getMessage());
                } catch (SQLException ex) {
                    showError("Error al actualizar producto: " + ex.getMessage());
                }
            });
            form.showDialog();
        } catch (SQLException ex) {
            showError("Error leyendo producto: " + ex.getMessage());
        }
    }

    private void deleteProduct() {
        int id = view.getSelectedProductId();
        if (id == -1) { showError("Selecciona un producto para eliminar."); return; }
        int res = JOptionPane.showConfirmDialog(view,
                "¿Seguro que quieres eliminar el producto seleccionado (ID " + id + ")?",
                "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        if (res != JOptionPane.YES_OPTION) return;
        try {
            int deleted = dao.delete(id);
            if (deleted > 0) {
                refreshTable();
                showInfo("Producto eliminado.");
            } else {
                showError("No se eliminó el producto. Puede que no exista o haya restricciones.");
            }
        } catch (SQLException ex) {
            showError("Error al eliminar producto. Es posible que existan restricciones (FK). Detalle: " + ex.getMessage());
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(view, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfo(String msg) {
        JOptionPane.showMessageDialog(view, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
