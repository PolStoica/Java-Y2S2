package isp.lab9.exercise1.ui;
import isp.lab9.exercise1.services.StockMarketQueryService;
import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * todo: implement - it should look similar to the 'Buy' panel
 */
public class SellJPanel extends JPanel {
    private StockMarketJFrame mainFrame;
    private UserPortfolio userPortfolio;

    public SellJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.userPortfolio=mainFrame.getPortfolio();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel activeStocksLabel = new JLabel("Active stock funds:");

        BigDecimal totalPrice = BigDecimal.ZERO;

        for(Map.Entry<String,Integer> entry:userPortfolio.getShares().entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();

            BigDecimal stockPrice = BigDecimal.valueOf(0);
            try {
                stockPrice = mainFrame.getMarketService().getStockPrice(symbol);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            totalPrice = stockPrice.multiply(new BigDecimal(quantity));

        }
        JTextField activeStocksText = new JTextField( totalPrice + " $");
        activeStocksText.setEditable(false);
        JLabel symbolLabel = new JLabel("Symbol:");
        JComboBox<String> symbolComboBox = new JComboBox<>();
        symbolComboBox.setModel(new DefaultComboBoxModel(userPortfolio.getShares().keySet().toArray()));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel costLabel = new JLabel("Total cost:");
        JTextField costTextField = new JTextField();
        costTextField.setEditable(false);

        JButton buyButton = new JButton("Sell");
        buyButton.addActionListener(e ->sellStock(symbolComboBox,quantityTextField,activeStocksText) );


        JButton costButton = new JButton("Get cost");
        costButton.addActionListener(e ->  calculateTotalCostActionPerformed(symbolComboBox, quantityTextField, costTextField,activeStocksText));

        refreshSellPortofolio(activeStocksLabel,symbolComboBox,quantityLabel);
        {sellPanel.add(activeStocksLabel);
            sellPanel.add(activeStocksText);

            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(symbolLabel);
            sellPanel.add(symbolComboBox);
            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(quantityLabel);
            sellPanel.add(quantityTextField);
            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(costLabel);
            sellPanel.add(costTextField);
            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(new JPanel()); // empty cell in the grid
            sellPanel.add(costButton);
            sellPanel.add(buyButton);
            add(sellPanel);
            add(new JPanel()); // empty cell in the grid
            add(new JPanel()); // empty cell in the grid
            add(new JPanel()); // empty cell in the grid
        }
    }
    private void calculateTotalCostActionPerformed(JComboBox<String> symbolComboBox,
                                                   JTextField quantityTextField,
                                                   JTextField totalCostTextField,
                                                   JTextField totalStocksTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            try {
                int quantity = Integer.parseInt(quantityTextField.getText());
                DecimalFormat formatter = new DecimalFormat("#,##0.##");
                totalCostTextField.setText(
                        formatter.format(stockPrice.multiply(new BigDecimal(quantity))));
            } catch (NumberFormatException e) {
                totalCostTextField.setText("Invalid quantity value!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sellStock(JComboBox<String> symbolComboBox, JTextField quantityTextField, JTextField activeStocksTextField) {
        BigDecimal availableFunds= new BigDecimal(Float.parseFloat(activeStocksTextField.getText().split(" \\$")[0]));
        try {
            Object selectedStock=symbolComboBox.getSelectedItem();
            StockMarketQueryService marketService = mainFrame.getMarketService(); //luam datele pt stocckurile disponibile
            BigDecimal stockPrice = marketService.getStockPrice(selectedStock.toString());
            int quantityWanted = Integer.parseInt(quantityTextField.getText());
            int quantityOwned = userPortfolio.getShares().get(selectedStock.toString());

            if (quantityWanted >= quantityOwned ) {
                BigDecimal totalPrice = stockPrice.multiply(new BigDecimal(quantityWanted));
                mainFrame.getPortfolio().setCash(availableFunds.add(totalPrice)); //adaugam bani
                activeStocksTextField.setText(mainFrame.getPortfolio().getCash().toPlainString() + " $");

            }else{
                JOptionPane.showMessageDialog(this,
                        "Not Enough Stock",
                        "",
                        JOptionPane.ERROR_MESSAGE);
            }
        }catch (Exception e) {

        }
    }
}
private void refreshSellPortofolio(JLabel activeStocksLabel,JComboBox<String> symbolComboBox,JLabel quantityLabel){


}
