package bookStore.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderManagerPanel extends JPanel {
    JButton btnCreateOrder,btnSearchOrder, buttonAddBook, buttonFind;
    JTextField textIDOrder, textNameCus, textIDC, textDateOrder, textDelivery;
    JTextField textIDB,textTitle,textAuthor, textPulish, textPrice, textYearPub;
    DefaultTableModel model;
    JTable table;
    JScrollPane scrollPane;
    public OrderManagerPanel(){
        setLayout(new BorderLayout());
        JPanel orderInformationPanel = new OrderInformationPanel();
        JPanel listInOrderPanel = new ListInOrderPanel();
        
        add(listInOrderPanel,BorderLayout.CENTER);
        add(orderInformationPanel,BorderLayout.NORTH);
    }
    public class OrderInformationPanel extends JPanel{
        public OrderInformationPanel(){
            setLayout(new BorderLayout());
            setSize(new Dimension(400,300));
            TitledBorder titledBorder = new TitledBorder("Hóa Đơn Bán Hàng");
            titledBorder.setTitleFont(new Font("Arial",Font.BOLD,20));
            setBorder(titledBorder);
            
            JPanel insertFormPanel = new JPanel(new GridLayout(3,4,5,5));
            
            JLabel idLabel = new JLabel("Mã Hóa Đơn:");
            textIDOrder = new JTextField("");
            insertFormPanel.add(idLabel);
            insertFormPanel.add(textIDOrder);
            insertFormPanel.add(new JPanel());
            insertFormPanel.add(new JPanel());
            
            
            JLabel nameCusLabel = new JLabel("Tên Khách Hàng:");
            textNameCus = new JTextField("");
            insertFormPanel.add(nameCusLabel);
            insertFormPanel.add(textNameCus);
            
            JLabel idCusLabel = new JLabel("Mã Khách Hàng: ");
            textIDC = new JTextField("");
            insertFormPanel.add(idCusLabel);
            insertFormPanel.add(textIDC);
            
            JLabel orderDateLabel = new JLabel("Ngày đặt hàng:");
            textDateOrder = new JTextField("");
            insertFormPanel.add(orderDateLabel);insertFormPanel.add(textDateOrder);
            
            JLabel deliveryDateLabel = new JLabel("Ngày giao hàng: ");
            textDelivery = new JTextField("");
            insertFormPanel.add(deliveryDateLabel);insertFormPanel.add(textDelivery);
            
            setLayout(new BorderLayout());
            
            JPanel boundPanel = new JPanel(new FlowLayout());
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(1,2));
            btnCreateOrder = new JButton("Tạo Hóa đơn");
            btnSearchOrder = new JButton("Tìm Hóa Đơn");
            
            buttonPanel.add(btnCreateOrder);
            buttonPanel.add(btnSearchOrder);
            
            boundPanel.add(buttonPanel);
            add(boundPanel,BorderLayout.SOUTH);
            add(insertFormPanel,BorderLayout.CENTER);
        }
    }
    
    public class ListInOrderPanel extends JPanel{
        public ListInOrderPanel(){
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createMatteBorder(1,0,1,0,new Color(0,0,0)));
            
            JPanel boundInfoBookPanel = new JPanel(new BorderLayout());
            JPanel insertBookPanel = new JPanel();
            insertBookPanel.setLayout(new GridLayout(6,2));
            TitledBorder titledBorder = new TitledBorder("Thông Tin Sách");
            titledBorder.setTitleFont(new Font("Arial",Font.BOLD,15));
            insertBookPanel.setBorder(titledBorder);
            
            JLabel idBookLabel = new JLabel("ID Sách:",JLabel.LEFT);
            textIDB = new JTextField("");
            
            JLabel titleLabel = new JLabel("Tên Sách");
            textTitle = new JTextField("");
            
            JLabel authorLabel = new JLabel("Tác Giả:");
            textAuthor = new JTextField("");
            
            JLabel publishLabel = new JLabel("Nhà Xuất Bản");
            textPulish = new JTextField("");
            
            JLabel priceLabel = new JLabel("Giá Sách");
            textPrice = new JTextField("");
            
            JLabel yearPubLabel = new JLabel("Năm Xuất Bản: ");
            textYearPub = new JTextField();
            
            JPanel buttonPanel = new JPanel(new FlowLayout());
            JPanel boundButtonPanel = new JPanel(new GridLayout(1,2,5,5));
            buttonPanel.add(boundButtonPanel);
            
            buttonAddBook = new JButton("Thêm");
            buttonFind = new JButton("Tìm");
            boundButtonPanel.add(buttonAddBook);
            boundButtonPanel.add(buttonFind);
            
            insertBookPanel.add(idBookLabel);
            insertBookPanel.add(textIDB);
            insertBookPanel.add(titleLabel);
            insertBookPanel.add(textTitle);
            insertBookPanel.add(authorLabel);
            insertBookPanel.add(textAuthor);
            insertBookPanel.add(publishLabel);
            insertBookPanel.add(textPulish);
            insertBookPanel.add(priceLabel);
            insertBookPanel.add(textPrice);
            insertBookPanel.add(yearPubLabel);
            insertBookPanel.add(textYearPub);
            
            boundInfoBookPanel.add(insertBookPanel,BorderLayout.NORTH);
            boundInfoBookPanel.add(buttonPanel,BorderLayout.CENTER);
            add(boundInfoBookPanel,BorderLayout.WEST);
            
            
            JPanel tablePanel = new JPanel();
            tablePanel.setLayout(new BorderLayout());
            String[]columns = {"STT","Mã Sách","Tên Sách","Tác Giả","Đơn Giá","Số Lượng","Thành Tiền"};
            model = new DefaultTableModel(columns,0);
            table = new JTable(model);
            table.getTableHeader().setReorderingAllowed(false);
            scrollPane = new JScrollPane(table);
            
            
            tablePanel.add(scrollPane);
            add(tablePanel);
            
        }
    }
}
