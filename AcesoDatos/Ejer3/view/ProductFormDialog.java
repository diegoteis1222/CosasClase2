package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.math.BigDecimal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Product;

public class ProductFormDialog extends JDialog {
    private JTextField txtProductName;
    private JTextField txtSupplierID;
    private JTextField txtCategoryID;
    private JTextField txtQuantityPerUnit;
    private JTextField txtUnitPrice;
    private JTextField txtUnitsInStock;
    private JButton btnSave;
    private JButton btnCancel;
    private Product product;

    public ProductFormDialog(Window owner) {
        super(owner, "Producto", ModalityType.APPLICATION_MODAL);
        init();
    }

    private void init() {
        setSize(400, 350);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(7,2,6,6));
        form.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        form.add(new JLabel("ProductName*:"));
        txtProductName = new JTextField();
        form.add(txtProductName);

        form.add(new JLabel("SupplierID:"));
        txtSupplierID = new JTextField();
        form.add(txtSupplierID);

        form.add(new JLabel("CategoryID:"));
        txtCategoryID = new JTextField();
        form.add(txtCategoryID);

        form.add(new JLabel("QuantityPerUnit:"));
        txtQuantityPerUnit = new JTextField();
        form.add(txtQuantityPerUnit);

        form.add(new JLabel("UnitPrice:"));
        txtUnitPrice = new JTextField();
        form.add(txtUnitPrice);

        form.add(new JLabel("UnitsInStock:"));
        txtUnitsInStock = new JTextField();
        form.add(txtUnitsInStock);

        add(form, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSave = new JButton("Guardar");
        btnCancel = new JButton("Cancelar");
        buttons.add(btnSave);
        buttons.add(btnCancel);
        add(buttons, BorderLayout.SOUTH);

        btnCancel.addActionListener(e -> {
            product = null;
            setVisible(false);
        });
    }

    public void setProduct(Product p) {
        this.product = p;
        if (p == null) {
            txtProductName.setText("");
            txtSupplierID.setText("");
            txtCategoryID.setText("");
            txtQuantityPerUnit.setText("");
            txtUnitPrice.setText("");
            txtUnitsInStock.setText("");
            setTitle("Nuevo producto");
        } else {
            txtProductName.setText(p.getProductName());
            txtSupplierID.setText(p.getSupplierID() == null ? "" : p.getSupplierID().toString());
            txtCategoryID.setText(p.getCategoryID() == null ? "" : p.getCategoryID().toString());
            txtQuantityPerUnit.setText(p.getQuantityPerUnit());
            txtUnitPrice.setText(p.getUnitPrice() == null ? "" : p.getUnitPrice().toString());
            txtUnitsInStock.setText(p.getUnitsInStock() == null ? "" : p.getUnitsInStock().toString());
            setTitle("Editar producto - ID " + p.getProductID());
        }
    }

    public Product showDialog() {
        setVisible(true);
        return product;
    }

    public JButton getBtnSave() { return btnSave; }

    public Product collectFormData() {
        String name = txtProductName.getText().trim();
        if (name.isEmpty()) throw new IllegalArgumentException("ProductName es obligatorio.");

        Integer supplier = null;
        if (!txtSupplierID.getText().trim().isEmpty()) {
            try { supplier = Integer.parseInt(txtSupplierID.getText().trim()); }
            catch (NumberFormatException ex) { throw new IllegalArgumentException("SupplierID debe ser un número entero."); }
        }

        Integer category = null;
        if (!txtCategoryID.getText().trim().isEmpty()) {
            try { category = Integer.parseInt(txtCategoryID.getText().trim()); }
            catch (NumberFormatException ex) { throw new IllegalArgumentException("CategoryID debe ser un número entero."); }
        }

        String qty = txtQuantityPerUnit.getText().trim();

        BigDecimal price = null;
        if (!txtUnitPrice.getText().trim().isEmpty()) {
            try {
                price = new BigDecimal(txtUnitPrice.getText().trim());
                if (price.compareTo(BigDecimal.ZERO) < 0)
                    throw new IllegalArgumentException("UnitPrice no puede ser negativo.");
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("UnitPrice debe ser un número válido.");
            }
        }

        Integer units = null;
        if (!txtUnitsInStock.getText().trim().isEmpty()) {
            try {
                units = Integer.parseInt(txtUnitsInStock.getText().trim());
                if (units < 0) throw new IllegalArgumentException("UnitsInStock no puede ser negativo.");
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("UnitsInStock debe ser un número entero.");
            }
        }

        if (product == null) product = new Product();

        product.setProductName(name);
        product.setSupplierID(supplier);
        product.setCategoryID(category);
        product.setQuantityPerUnit(qty);
        product.setUnitPrice(price);
        product.setUnitsInStock(units);

        return product;
    }
}
