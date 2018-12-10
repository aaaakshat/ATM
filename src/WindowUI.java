
import javafx.geometry.Pos;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bisht81324
 */
public class WindowUI extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form WindowUI
     * @param accountName
     * @param accountBalance
     * @param accountPassword
     */
    public WindowUI(String accountName, Double accountBalance, int accountPassword) {
        initComponents();
        this.client = new Account(accountName, accountBalance, accountPassword);
    }

    Account client;
        
    String currentOperationState = "";
    int tempOldPin;
    
    public void authSequence() {
        withdrawalButton.setEnabled(false);
        depositButton.setEnabled(false);
        historyButton.setEnabled(false);
        pinChangeButton.setEnabled(false);
        
        addOutputText("ENTER PIN: \n");
        setOperationState("authentication");
        setInputState(true);
    }
    
     public void authCompletionSequence() {
        withdrawalButton.setEnabled(true);
        depositButton.setEnabled(true);
        historyButton.setEnabled(true);
        pinChangeButton.setEnabled(true);

        addOutputText("WELCOME, " + this.client.accountName + "\n");
         setInputState(false);
    }
    
    public void resetConfig() {
        this.currentOperationState = "";
    }
    
    public void setOperationState(String newOperationState) {
        this.currentOperationState = newOperationState;
    }
    
    public String getOperationState() {
        return this.currentOperationState;
    }
    
    public void setInputState(boolean state) {
        userInputField.setText("");
        userInputField.setEditable(state);
    }
    public void runInitialisationSequence() {
        textOutputArea.setEditable(false);
        emptyButton.setEnabled(false);
        authSequence();
    }
    
    public void addOutputText(String outputText) {
        textOutputArea.setText(textOutputArea.getText() + "\n" + outputText);
    }
    
    public Double testInputFieldValue(){
        try {
        return Double.parseDouble(userInputField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            return 0.00;
        }
    }
    
    public String getAccountBalance() {
		return client.accountName + ": $" + Double.toString(client.accountBalance);
	}

	public void accountDeposit(Double depositValue) {
		client.accountBalance = client.accountBalance + depositValue;
		client.newTransactionEntry("DEPOSIT:", depositValue);
	}
	
	public Boolean accountWithdrawal(Double withdrawalValue) {
		if (withdrawalValue <= client.accountBalance) {
			client.accountBalance = client.accountBalance - withdrawalValue;
			client.newTransactionEntry("WITHDRAWAL:", withdrawalValue);
			return true;
		} else {
			return false;
		}
	}
	
	public String accountHistory() {
		return client.transactions.getHistory();
	}
	
	public Boolean accountChangePin(int oldPassword, int newPassword) {
		if (client.setPassword(oldPassword, newPassword)) {
			client.newTransactionEntry("Changed Pin", 0.00);
			return true;
		} else {
			return false;
		}
	}
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        withdrawalButton = new javax.swing.JButton();
        titleCard = new javax.swing.JLabel();
        depositButton = new javax.swing.JButton();
        historyButton = new javax.swing.JButton();
        pinChangeButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        emptyButton = new javax.swing.JButton();
        enterButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textOutputArea = new javax.swing.JTextArea();
        userInputField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        withdrawalButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        withdrawalButton.setText("Withdrawal");
        withdrawalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawalButtonActionPerformed(evt);
            }
        });

        titleCard.setFont(new java.awt.Font("No Continue", 0, 50)); // NOI18N
        titleCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleCard.setText("super cool atm  v2.0");

        depositButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        historyButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        historyButton.setText("History");
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });

        pinChangeButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        pinChangeButton.setText("Change Pin");
        pinChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinChangeButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        exitButton.setText("EXIT");
        exitButton.setToolTipText("");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        emptyButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        emptyButton.setToolTipText("");

        enterButton.setBackground(new java.awt.Color(0, 204, 204));
        enterButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        enterButton.setText("ENTER");
        enterButton.setOpaque(false);
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        clearButton.setText("CLEAR");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        textOutputArea.setColumns(20);
        textOutputArea.setFont(new java.awt.Font("Square721 BT", 0, 14)); // NOI18N
        textOutputArea.setRows(5);
        jScrollPane1.setViewportView(textOutputArea);

        userInputField.setFont(new java.awt.Font("Arame", 1, 36)); // NOI18N
        userInputField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleCard, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(historyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(depositButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(withdrawalButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pinChangeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(userInputField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emptyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(titleCard, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(withdrawalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emptyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(userInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pinChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawalButtonActionPerformed
        // TODO add your handling code here:
        addOutputText("Enter Withdrawal Amount: \n");
        setOperationState("withdrawal");
        setInputState(true);
    }//GEN-LAST:event_withdrawalButtonActionPerformed

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyButtonActionPerformed
        // TODO add your handling code here:
        addOutputText("History:");
        addOutputText(this.accountHistory());
        setInputState(false);
    }//GEN-LAST:event_historyButtonActionPerformed

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        // TODO add your handling code here:
        System.out.println(getOperationState());
        switch (getOperationState()) {
            case "withdrawal":
                if (testInputFieldValue() != 0.00 && this.accountWithdrawal(testInputFieldValue()) == true) {
                    addOutputText("Withdrawal Success");
                    System.out.println("the withdrawal works.");
                } else {
                    addOutputText("Withdrawal Error");
                    System.out.println("the withdrawal no works.");
                }   System.out.println(this.accountHistory());
                setInputState(false);
                resetConfig();
                break;
            case "deposit":
                if (testInputFieldValue() != 0.00) {
                    this.accountDeposit(testInputFieldValue());
                    addOutputText("Deposit Success");
                } else {
                    addOutputText("Deposit Error");
                }   
                setInputState(false);
                resetConfig();
                break;
            case "pin change":
                if (this.client.testAccountPassword(testInputFieldValue().intValue()) == true) {
                    tempOldPin = testInputFieldValue().intValue();
                    addOutputText("Enter New Pin");
                    setOperationState("new pin input");
                    userInputField.setText("");
                } else {
                    addOutputText("Pin Change Error");
                    userInputField.setText("");
                }   break;
            case "new pin input":
                if (accountChangePin(tempOldPin, testInputFieldValue().intValue()) == true) {
                    addOutputText("Pin Change Success");
                    setInputState(false);
                } else {
                    addOutputText("Pin Change Error");
                    userInputField.setText("");
                }
                resetConfig();
                break;
            case "authentication":
                if (this.client.testAccountPassword(testInputFieldValue().intValue()) == true) {
                    addOutputText("Pin Verified");
                    authCompletionSequence();
                } else {
                    addOutputText("Verification Error");
                }
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_enterButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        // TODO add your handling code here:
        addOutputText("Enter Deposit Amount: \n");
        setOperationState("deposit");
        setInputState(true);
    }//GEN-LAST:event_depositButtonActionPerformed

    private void pinChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinChangeButtonActionPerformed
        // TODO add your handling code here:
        addOutputText("Enter Old Pin: \n");
        setOperationState("pin change");
        setInputState(true);
    }//GEN-LAST:event_pinChangeButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        userInputField.setText("");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void userInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton depositButton;
    private javax.swing.JButton emptyButton;
    private javax.swing.JButton enterButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton historyButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pinChangeButton;
    private javax.swing.JTextArea textOutputArea;
    private javax.swing.JLabel titleCard;
    private javax.swing.JTextField userInputField;
    private javax.swing.JButton withdrawalButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
