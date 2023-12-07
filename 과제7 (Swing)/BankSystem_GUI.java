import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Keyboard {
    JTextField textField = new JTextField();

    char getSelection() {
        String input = textField.getText();
        return input.isEmpty() ? '\0' : input.charAt(0);
    }

    int getAmount() {
        String input = textField.getText();
        return input.isEmpty() ? 0 : Integer.parseInt(input);
    }
}

class Screen {
    JTextArea textArea = new JTextArea();

    void displayMessage(String m) {
        textArea.append(m + "\n");
    }

    void displayPrompt(String m) {
        textArea.append(m + "\n");
    }

    void scrollToBottom() {
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}

interface IAccount {
    int getAccountNumber();

    int getBalance();

    void deposit(int amount);

    boolean withdraw(int amount);
}

class Account implements IAccount {
    protected int accountNumber;
    protected int balance;

    public Account(int number, int amount) {
        accountNumber = number;
        balance = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class NormalAccount extends Account {
    public NormalAccount(int number, int amount) {
        super(number, amount);
    }
}

class MinusAccount extends Account {
    private int creditAmount;

    public MinusAccount(int number, int amount, int creditAmount) {
        super(number, amount);
        this.creditAmount = creditAmount;
    }

    public boolean withdraw(int amount) {
        if (amount <= balance + creditAmount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class WithdrawControl {
    public void execute(IAccount acc, Screen scr, Keyboard kbd) {
        int amount = kbd.getAmount();
        if (amount == 0)
        {
            scr.displayPrompt("출금할 금액을 입력 후 버튼을 눌러주세요");
        }
        else
        {
            if (acc.withdraw(amount)) {
                scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
            } else {
                scr.displayMessage("잔고가 부족합니다.");
            }
        }
        scr.scrollToBottom();
        kbd.textField.setText("");
    }
}

class DepositControl {
    public void execute(IAccount acc, Screen scr, Keyboard kbd) {
        int amount = kbd.getAmount();
        if (amount == 0)
        {
            scr.displayPrompt("입금할 금액을 입력 후 버튼을 눌러주세요");
        }
        else
        {
            acc.deposit(amount);
            scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
            scr.scrollToBottom();
            kbd.textField.setText("");
        }
    }
}

class InquiryControl {
    public void execute(IAccount acc, Screen scr) {
        scr.displayMessage("잔고가 " + acc.getBalance() + " 입니다.");
        scr.scrollToBottom();
    }
}

class TransferControl {
    public void execute(IAccount acc, Screen scr, Keyboard kbd, IAccount acc2, JButton transferButton) {
        int accountNumber = kbd.getAmount();
        if (transferButton.getText().equals("Account Transfer")){

            if (accountNumber == 0) {
                scr.displayMessage("계좌번호를 입력 후 버튼을 눌러주세요.");
                scr.scrollToBottom();
                return;
            }
            else{
                if (acc.getAccountNumber() == accountNumber) {
                    scr.displayMessage("현재 계좌와 동일한 계좌는 송금할 수 없습니다.");
                    scr.scrollToBottom();
                } 
                else {
                    scr.displayMessage("송금할 금액을 입력 후 좌측의 Send버튼을 눌러주세요.");
                    transferButton.setText("send");
                    kbd.textField.setText("");
                }
            }
        }
        else
        {
            int toSend = kbd.getAmount();
            if (toSend > 0 && acc.withdraw(toSend)) {
                scr.displayMessage("'" + acc2.getAccountNumber() + "' 계좌로 " + toSend + "원을 송금하고 남은 잔고는 " + acc.getBalance() + " 입니다.");
                acc2.deposit(toSend);
                transferButton.setText("Account Transfer");
                kbd.textField.setText("");
                scr.scrollToBottom();
            } else {
                scr.displayMessage("송금할 금액이 부족하거나 입력되지 않았습니다.");
                scr.scrollToBottom();
                transferButton.setText("Account Transfer");
                kbd.textField.setText("");
            }
        }
    }
}

class OpenControl {
    public void execute(IAccount acc, Screen scr, Keyboard kbd, IAccount acc2) {
        scr.displayMessage("현재 계좌번호: " + acc.getAccountNumber() + ", 현재 잔고: " + acc.getBalance() + "원");
        scr.displayMessage("다른 계좌번호: " + acc2.getAccountNumber() + ", 다른 잔고: " + acc2.getBalance() + "원");
        scr.scrollToBottom();
    }
}

class Bank {
    private Screen scr;
    private Keyboard kbd;
    private IAccount acc1, acc2;

    public Bank() {
        scr = new Screen();
        kbd = new Keyboard();
        acc1 = new NormalAccount(1, 10000);
        acc2 = new MinusAccount(2, 50000, 10000);
    }

    public void run() {
        JFrame frame = new JFrame("Bank System");
        frame.setSize(960, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JButton inquiryButton = new JButton("Balance Inquiry");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Account Transfer");
        JButton openButton = new JButton("Account Opening");
        JButton terminateButton = new JButton("Terminate");

        inquiryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InquiryControl().execute(acc1, scr);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DepositControl().execute(acc1, scr, kbd);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new WithdrawControl().execute(acc1, scr, kbd);
            }
        });

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TransferControl().execute(acc1, scr, kbd, acc2, transferButton);
            }
        });

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new OpenControl().execute(acc1, scr, kbd, acc2);
            }
        });

        terminateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Terminated...");
                System.exit(0);
            }
        });

        panel.add(inquiryButton);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(transferButton);
        panel.add(openButton);
        panel.add(terminateButton);

        frame.add(panel, BorderLayout.WEST);
        frame.add(new JScrollPane(scr.textArea), BorderLayout.CENTER);
        frame.add(kbd.textField, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.run();
    }
}
