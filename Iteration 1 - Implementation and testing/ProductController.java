import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductController implements ActionListener 
{
    private ProductView productView;
    private DataAdapter dataAdapter; // to save and load product information

    /**
     * @wbp.parser.entryPoint
     */
    public ProductController(ProductView productView, DataAdapter dataAdapter) 
    {
        this.dataAdapter = dataAdapter;
        this.productView = productView;

        productView.getBtnLoad().addActionListener(this);
        productView.getBtnSave().addActionListener(this);
    }


    /**
     * @wbp.parser.entryPoint
     */
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == productView.getBtnLoad())
            loadProduct();
        else
        if (e.getSource() == productView.getBtnSave())
            saveProduct();
    }

    /**
     * @wbp.parser.entryPoint
     */
    private void saveProduct() 
    {
        int productID;
        try {
            productID = Integer.parseInt(productView.getTxtProductID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product ID! Please provide a valid product ID!");
            return;
        }

        double productPrice;
        try {
            productPrice = Double.parseDouble(productView.getTxtProductPrice().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product price! Please provide a valid product price!");
            return;
        }

        double productQuantity;
        try {
            productQuantity = Double.parseDouble(productView.getTxtProductQuantity().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product quantity! Please provide a valid product quantity!");
            return;
        }
        
        double productTax;
        try {
        	productTax = Double.parseDouble(productView.getTxtProductTax().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product Tax! Please provide a valid product Tax!");
            return;
        }

        String productName = productView.getTxtProductName().getText().trim();

        if (productName.length() == 0) {
            JOptionPane.showMessageDialog(null, "Invalid product name! Please provide a non-empty product name!");
            return;
        }


        Product product = new Product();
        product.setProductID(productID);
        product.setName(productName);
        product.setPrice(productPrice);
        product.setQuantity(productQuantity);
        product.setTax(productTax);

        // Store the product to the database

        dataAdapter.saveProduct(product);
    }

    /**
     * @wbp.parser.entryPoint
     */
    private void loadProduct() 
    {
        int productID = 0;
        try {
            productID = Integer.parseInt(productView.getTxtProductID().getText());
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid product ID! Please provide a valid product ID!");
            return;
        }

        Product product = dataAdapter.loadProduct(productID);

        if (product == null) 
        {
            JOptionPane.showMessageDialog(null, "This product ID does not exist in the database!");
            return;
        }

        productView.getTxtProductName().setText(product.getName());
        productView.getTxtProductPrice().setText(String.valueOf(product.getPrice()));
        productView.getTxtProductQuantity().setText(String.valueOf(product.getQuantity()));
        productView.getTxtProductTax().setText(String.valueOf(product.getTax()));
    }


}