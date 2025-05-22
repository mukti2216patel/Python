import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

class MahathirCoffeeShop extends Frame {
    private List<MenuItem> menuItems;
    private Panel totalPanel;
    private Label taxLabel, subTotalLabel, totalLabel, dateTimeLabel;

    public MahathirCoffeeShop() {
        setTitle("Mahathir CoffeeShop");
        setSize(1000, 700);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        initializeMenuItems();
        
        Panel headerPanel = new HeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        MenuPanel menuPanel = new MenuPanel(menuItems); // Declare as MenuPanel
        add(menuPanel, BorderLayout.CENTER);
        
        totalPanel = new TotalPanel(menuPanel); // Pass MenuPanel
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
        menuItems.add(new MenuItem("Cheese Cake", 24000));
        menuItems.add(new MenuItem("Croissant", 20000));
        menuItems.add(new MenuItem("Egg Toast", 20000));
        menuItems.add(new MenuItem("Espresso", 15000));
        menuItems.add(new MenuItem("Iced Tea", 14000));
        menuItems.add(new MenuItem("Latte", 23000));
        menuItems.add(new MenuItem("Lemon Tea", 16000));
        menuItems.add(new MenuItem("Macchiato", 22000));
        menuItems.add(new MenuItem("Matcha", 25000));
        menuItems.add(new MenuItem("Mineral Water", 5000));
        menuItems.add(new MenuItem("Mocha", 24000));
        menuItems.add(new MenuItem("Red Velvet Cake", 28000));
    }
    
    class HeaderPanel extends Panel {
        public HeaderPanel() {
            setLayout(new BorderLayout());
            setBackground(Color.LIGHT_GRAY);
            
            Label titleLabel = new Label("Mahathir CoffeeShop", Label.LEFT);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
            add(titleLabel, BorderLayout.WEST);
            
            dateTimeLabel = new Label("", Label.RIGHT);
            dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            add(dateTimeLabel, BorderLayout.EAST);
            
            updateDateTime();
        }
        
        private void updateDateTime() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss     EEEE, dd-MM-yyyy");
                    dateTimeLabel.setText(sdf.format(new Date()));
                }
            }, 0, 1000);
        }
    }
    
    class MenuPanel extends Panel {
        public MenuPanel(List<MenuItem> items) {
            setLayout(new GridLayout(0, 5, 10, 10));
            setBackground(Color.WHITE);
            for (MenuItem item : items) {
                add(new ItemPanel(item));
            }
        }
    }
    
    class ItemPanel extends Panel {
        private TextField quantityField;
        private Checkbox purchaseCheckbox;
        MenuItem item;
        
        public ItemPanel(MenuItem item) {
            this.item = item; // Store the menu item
            setLayout(new BorderLayout(5, 5));
            setBackground(Color.LIGHT_GRAY);
            
            Label nameLabel = new Label(item.name, Label.CENTER);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
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

        public int getItemPrice() {
            return item.price; // Return the price of the item
        }
    }
    
    class TotalPanel extends Panel {
        private MenuPanel menuPanel;
        private String receiptContent; 

        public TotalPanel(MenuPanel menuPanel) {
            this.menuPanel = menuPanel; 
            setLayout(new GridLayout(2, 4, 10, 10));
            setBackground(Color.LIGHT_GRAY);
            
            taxLabel = new Label("Tax (K): 0.0");
            subTotalLabel = new Label("Sub Total (K): 0.0");
            totalLabel = new Label("Total (K): 0.0");
            
            Button totalButton = new Button("Total");
            Button receiptButton = new Button("Receipt");
            Button resetButton = new Button("Reset");
            Button exitButton = new Button("Exit");
            
            add(taxLabel);
            add(totalButton);
            add(receiptButton);
            add(new Label()); 
            add(subTotalLabel);
            add(totalLabel);
            add(resetButton);
            add(exitButton);
            
            totalButton.addActionListener(e -> calculateTotal());
            receiptButton.addActionListener(e -> printReceipt());
            resetButton.addActionListener(e -> reset());
            exitButton.addActionListener(e -> System.exit(0));
        }
        
        private void calculateTotal() {
            double subtotal = 0;
            StringBuilder receiptContentBuilder = new StringBuilder("Receipt:\n\n");
            
            for (Component c : menuPanel.getComponents()) {
                if (c instanceof ItemPanel) {
                    ItemPanel ip = (ItemPanel) c;
                    if (ip.purchaseCheckbox.getState()) {
                        int quantity;
                        try {
                            quantity = Integer.parseInt(ip.quantityField.getText());
                        } catch (NumberFormatException e) {
                            quantity = 0; 
                        }
                        if (quantity > 0) { 
                            double itemTotal = quantity * ip.getItemPrice();
                            subtotal += itemTotal;
                            receiptContentBuilder.append(ip.item.name)
                                                  .append(" (x")
                                                  .append(quantity)
                                                  .append(") - Rp.")
                                                  .append(itemTotal)
                                                  .append("\n");
                        }
                    }
                }
            }

            double tax = subtotal * 0.1; 
            double total = subtotal + tax;

            subTotalLabel.setText("Sub Total (K): " + String.format("%.1f", subtotal / 1000));
            taxLabel.setText("Tax (K): " + String.format("%.1f", tax / 1000));
            totalLabel.setText("Total (K): " + String.format("%.1f", total / 1000));
            
            this.receiptContent = receiptContentBuilder.toString();
        }

        private void printReceipt() {
            if (receiptContent == null || receiptContent.isEmpty()) {
                Dialog noSelectionDialog = new Dialog(MahathirCoffeeShop.this, "No Items Selected", true);
                Label messageLabel = new Label("Please select items before printing the receipt.");
                noSelectionDialog.add(messageLabel);
                noSelectionDialog.setSize(300, 150);
                noSelectionDialog.setLayout(new FlowLayout());
                Button closeButton = new Button("Close");
                closeButton.addActionListener(e -> noSelectionDialog.dispose());
                noSelectionDialog.add(closeButton);
                noSelectionDialog.setVisible(true);
                return;
            }

            Dialog receiptDialog = new Dialog(MahathirCoffeeShop.this, "Receipt", true);
            TextArea textArea = new TextArea(receiptContent, 20, 50, TextArea.SCROLLBARS_VERTICAL_ONLY);
            textArea.setEditable(false);
            receiptDialog.add(textArea);
            receiptDialog.setSize(600, 400);
            receiptDialog.setLayout(new FlowLayout());
            Button closeButton = new Button("Close");
            closeButton.addActionListener(e -> receiptDialog.dispose());
            receiptDialog.add(closeButton);
            receiptDialog.setVisible(true);
        }

        private void reset() {
            // Reset logic
            subTotalLabel.setText("Sub Total (K): 0.0");
            taxLabel.setText("Tax (K): 0.0");
            totalLabel.setText("Total (K): 0.0");
            
            for (Component c : menuPanel.getComponents()) {
                if (c instanceof ItemPanel) {
                    ItemPanel ip = (ItemPanel) c;
                    ip.quantityField.setText("0");
                    ip.purchaseCheckbox.setState(false);
                }
            }
            receiptContent = ""; // Clear the receipt content
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
        MahathirCoffeeShop shop = new MahathirCoffeeShop();
        shop.setVisible(true);
    }
}
