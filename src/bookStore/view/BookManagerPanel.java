package bookStore.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookManagerPanel extends JPanel {
    JTextField textIDBook, textTitle, textAuthor, textPulish, textPrice, textYearPub, textQuantity;//TextF dung cho thong tin sach
    JTextField txFindIDBook, txFindTitle, txFindStartYearPub, txFindEndYearPub, txFindAuthor;//TF dung cho tim kiem
    JTextField txDisplayStatus;
    JButton btnFind;
    JButton btnAddStored, btnRemoveStored, btnRefreshStored;
    JComboBox<String> comboType, comboFindType;
    DefaultTableModel modelStored;
    JScrollPane scrollPane;
    JTable tableStored;
    
    public BookManagerPanel() {
        setLayout(new BorderLayout());
        
        JPanel boundFindInfoPanel = new JPanel(new BorderLayout());
        JPanel infoPanel = new InfoPanel();
        JPanel findPanel = new FindPanel();
        JPanel storedPanel = new StoredPanel();
        
        boundFindInfoPanel.add(infoPanel, BorderLayout.CENTER);
        boundFindInfoPanel.add(findPanel, BorderLayout.EAST);
        add(boundFindInfoPanel, BorderLayout.NORTH);
        add(storedPanel, BorderLayout.CENTER);
    }
    
    public class InfoPanel extends JPanel {
        public InfoPanel() {
            setLayout(new BorderLayout());
            TitledBorder titledBorder = new TitledBorder("Quản Lí Sách");
            titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 20));
            setBorder(titledBorder);
            
            JPanel insertInfoPanel = new JPanel(new GridLayout(8, 2));
            JLabel idBookLabel = new JLabel("Mã Sách");
            textIDBook = new JTextField();
            
            insertInfoPanel.add(idBookLabel);
            insertInfoPanel.add(textIDBook);
            
            JLabel titleLabel = new JLabel("Tên Sách");
            textTitle = new JTextField();
            insertInfoPanel.add(titleLabel);
            insertInfoPanel.add(textTitle);
            
            JLabel typeLabel = new JLabel("Thể Loại");
            String[] type = {"", "Light novel", "Triết học", "Truyện tranh", "Khoa học", "Tâm lý học", "Thơ kịch"};
            comboType = new JComboBox<String>(type);
            insertInfoPanel.add(typeLabel);
            insertInfoPanel.add(comboType);
            
            JLabel authorLabel = new JLabel("Tên Tác Giả");
            textAuthor = new JTextField();
            insertInfoPanel.add(authorLabel);
            insertInfoPanel.add(textAuthor);
            
            JLabel publishLabel = new JLabel("Nhà Xuất Bản");
            textPulish = new JTextField("");
            insertInfoPanel.add(publishLabel);
            insertInfoPanel.add(textPulish);
            
            JLabel yearPubLabel = new JLabel("Năm Xuất Bản:");
            textYearPub = new JTextField();
            insertInfoPanel.add(yearPubLabel);
            insertInfoPanel.add(textYearPub);
            
            JLabel quantityLabel = new JLabel("Số Lượng");
            textQuantity = new JTextField();
            insertInfoPanel.add(quantityLabel);
            insertInfoPanel.add(textQuantity);
            
            JLabel priceLabel = new JLabel("Giá Sách");
            textPrice = new JTextField("");
            insertInfoPanel.add(priceLabel);
            insertInfoPanel.add(textPrice);
            
            //Panel tim kiem
            add(insertInfoPanel, BorderLayout.CENTER);
        }
    }
    
    public class FindPanel extends JPanel {
        public FindPanel() {
            setLayout(new BorderLayout());
            JPanel boundFindPanel = new JPanel(new BorderLayout());
            TitledBorder titledBorder = new TitledBorder("Tìm Kiếm Sách");
            titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
            setBorder(titledBorder);
            
            JPanel insertPanel = new JPanel(new GridLayout(3, 4, 5, 5));
            JLabel idFindLabel = new JLabel("Mã Sách");
            txFindIDBook = new JTextField();
            
            JLabel titleFindLabel = new JLabel("Tên Sách");
            txFindTitle = new JTextField();
            
            JLabel typeFindLabel = new JLabel("Thể Loại");
            String[] type = {"", "Light novel", "Triết học", "Truyện tranh", "Khoa học", "Tâm lý học", "Thơ kịch"};
            comboFindType = new JComboBox<String>(type);
            
            JLabel authorFindLabel = new JLabel("Tên Tác Giả");
            txFindAuthor = new JTextField();
            
            JLabel yearStartPubFindLabel = new JLabel("Năm Xuất Bản Từ:");
            txFindStartYearPub = new JTextField();
            
            JLabel yearEndPubFindLabel = new JLabel("Đến:");
            txFindEndYearPub = new JTextField();
            
            
            insertPanel.add(idFindLabel);
            insertPanel.add(txFindIDBook);
            insertPanel.add(titleFindLabel);
            insertPanel.add(txFindTitle);
            insertPanel.add(typeFindLabel);
            insertPanel.add(comboFindType);
            insertPanel.add(authorFindLabel);
            insertPanel.add(txFindAuthor);
            insertPanel.add(yearStartPubFindLabel);
            insertPanel.add(txFindStartYearPub);
            insertPanel.add(yearEndPubFindLabel);
            insertPanel.add(txFindEndYearPub);
            
            JPanel buttonFindPanel = new JPanel(new GridLayout(1, 1));
            btnFind = new JButton("Tìm");
            btnFind.setBackground(new Color(255, 250, 250));
            btnFind.setFocusable(false);
            buttonFindPanel.add(btnFind);
            
            boundFindPanel.add(buttonFindPanel, BorderLayout.CENTER);
            boundFindPanel.add(insertPanel, BorderLayout.NORTH);
            
            JPanel buttonMorePanel = new ButtonMorePanel();
            
            add(boundFindPanel,BorderLayout.NORTH);
            add(buttonMorePanel,BorderLayout.CENTER);
        }
    }
    
    public class ButtonMorePanel extends JPanel {
        public ButtonMorePanel() {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            JPanel boundPanel = new JPanel(new GridLayout(1,3));
            btnAddStored = new JButton("Thêm Sách");
            btnRefreshStored = new JButton("Làm Mới Danh Sách");
            btnRemoveStored = new JButton("Xóa Sách");
            
            boundPanel.add(btnAddStored);
            boundPanel.add(btnRefreshStored);
            boundPanel.add(btnRemoveStored);
            
            add(boundPanel);
        }
    }
    
    public class StoredPanel extends JPanel {
        public StoredPanel() {
            setLayout(new BorderLayout());
            TitledBorder titledBorder = new TitledBorder("Danh Sách Sách Trong Kho");
            titledBorder.setTitleFont(new Font("Arial", Font.BOLD, 15));
            setBorder(titledBorder);
            String[] columns = {"STT", "Mã Sách", "Tên Sách", "Thể Loại", "Tác Giả", "Nhà Xuất Bản", "Năm Xuất Bản", "Đơn Giá", "Số Lượng",};
            modelStored = new DefaultTableModel(columns, 0);
            tableStored = new JTable(modelStored);
            scrollPane = new JScrollPane(tableStored);
            add(scrollPane, BorderLayout.CENTER);
        }
    }
    
}
