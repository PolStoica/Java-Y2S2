package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.math.BigDecimal;
import java.util.Map;

/**
 *  todo: implement portfolio panel; for each owned stock add symbol, quantity, price per unit, total price of the position
 *  it should look similar to the 'Market' panel
 */
public class PortfolioJPanel extends JPanel {
            private StockMarketJFrame frame;
            private UserPortfolio userPortfolio;

            public PortfolioJPanel(StockMarketJFrame frame) {
                this.frame = frame;
                this.userPortfolio=frame.getPortfolio();

                initComponent();
            }

            public void initComponent() {
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                JTable jTablePortofolio = new JTable();
                JLabel availableFundsLabel = new JLabel("Available Funds:");

                refreshPortofolio(jTablePortofolio, frame,availableFundsLabel);

                JButton refreshButton = new JButton("Refresh");

                refreshButton.addActionListener(e -> refreshPortofolio(jTablePortofolio,frame,availableFundsLabel));
                JScrollPane jScrollPane = new JScrollPane(jTablePortofolio);

                add(jScrollPane);
                add(refreshButton);
                add(availableFundsLabel);
            }
            private void refreshPortofolio(JTable table, StockMarketJFrame frame,JLabel funds) {
                DefaultTableModel model = new DefaultTableModel(){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                model.addColumn("Symbol");
                model.addColumn("Quantity");
                model.addColumn("Price per unit");
                model.addColumn("Total price");
                try{
                    funds.setText( "Available Funds: "+userPortfolio.getCash().toPlainString() +" $");

                    for(Map.Entry<String,Integer> entry:userPortfolio.getShares().entrySet()){
                        String symbol = entry.getKey();
                        int quantity = entry.getValue();

                        BigDecimal stockPrice = frame.getMarketService().getStockPrice(symbol);
                        BigDecimal totalPrice = stockPrice.multiply(new BigDecimal(quantity));

                        model.addRow(new Object[]{symbol,quantity,stockPrice.toPlainString(),totalPrice.toPlainString()});
                    }
                    table.setModel(model);

                }catch(Exception e){
                    JOptionPane.showMessageDialog(this,
                            "Cannot get stock price",
                            "",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
}