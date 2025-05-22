import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class CoffeeShopInterface extends Frame {
    private List<MenuItem> menuItems;
    private Panel totalPanel;
    private Label taxLabel, subTotalLabel, totalLabel;
    private Button totalButton, receiptButton, resetButton, exitButton;

    public CoffeeShopInterface() {
        setTitle("Mahathir CoffeeShop");
        setSize(800, 600);
        setLayout(new BorderLayout());

        initializeMenuItems();
        
        Panel menuPanel = new MenuPanel(menuItems);
        add(menuPanel, BorderLayout.CENTER);
        
        totalPanel = new TotalPanel();
        add(totalPanel, BorderLayout.SOUTH);
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    
    private void initializeMenuItems() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Affogato", 25000));
        menuItems.add(new MenuItem("Americano", 20000));
        menuItems.add(new MenuItem("Cappuccino", 25000));
        menuItems.add(new MenuItem("Cheese Cake", 30000));
        menuItems.add(new MenuItem("Croissant", 20000));
        // Add more menu items here
    }
    
    class MenuPanel extends Panel {
        public MenuPanel(List<MenuItem> items) {
            setLayout(new GridLayout(0, 5, 10, 10));
            for (MenuItem item : items) {
                add(new ItemPanel(item));
            }
        }
    }
    
    class ItemPanel extends Panel {
        private TextField quantityField;
        private Checkbox purchaseCheckbox;
        
        public ItemPanel(MenuItem item) {
            setLayout(new BorderLayout(5, 5));
            
            Label nameLabel = new Label(item.name, Label.CENTER);
            add(nameLabel, BorderLayout.NORTH);
            
            Label priceLabel = new Label("Price: Rp." + item.price, Label.CENTER);
            add(priceLabel, BorderLayout.CENTER);
            
            Panel inputPanel = new Panel(new FlowLayout());
            Label quantityLabel = new Label("Quantity:");
            quantityField = new TextField("0", 3);
            purchaseCheckbox = new Checkbox("Purchase");
            inputPanel.add(quantityLabel);
            inputPanel.add(quantityField);
            inputPanel.add(purchaseCheckbox);
            add(inputPanel, BorderLayout.SOUTH);
        }
    }
    
    class TotalPanel extends Panel {
        public TotalPanel() {
            setLayout(new GridLayout(2, 4, 10, 10));
            
            taxLabel = new Label("Tax (K): 0.0");
            subTotalLabel = new Label("Sub Total (K): 0.0");
            totalLabel = new Label("Total (K): 0.0");
            
            totalButton = new Button("Total");
            receiptButton = new Button("Receipt");
            resetButton = new Button("Reset");
            exitButton = new Button("Exit");
            
            add(taxLabel);
            add(totalButton);
            add(receiptButton);
            add(new Label()); // Empty space
            add(subTotalLabel);
            add(totalLabel);
            add(resetButton);
            add(exitButton);
            
            // Add action listeners to buttons
            totalButton.addActionListener(e -> calculateTotal());
            receiptButton.addActionListener(e -> printReceipt());
            resetButton.addActionListener(e -> reset());
            exitButton.addActionListener(e -> System.exit(0));
        }
        
        private void calculateTotal() {
            // Implement total calculation logic here
        }
        
        private void printReceipt() {
            // Implement receipt printing logic here
        }
        
        private void reset() {
            // Implement reset logic here
        }
    }
    
    class MenuItem {
        String name;
        int price;
        
        public MenuItem(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
    
    public static void main(String[] args) {
        CoffeeShopInterface csi = new CoffeeShopInterface();
        csi.setVisible(true);
    }
}