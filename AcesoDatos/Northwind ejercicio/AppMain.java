
import controller.ProductController;
import dao.ProductDAO;
import javax.swing.*;
import view.MainView;

public class AppMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainView view = new MainView();
            ProductDAO dao = new ProductDAO();
            new ProductController(dao, view);
            view.setVisible(true);
        });
    }
}
