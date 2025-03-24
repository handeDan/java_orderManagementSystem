package view;

import business.CustomerController;
import core.Helper;
import entity.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI extends JFrame{
    private JPanel container;
    private JLabel lbl_title;
    private JLabel lbl_name;
    private JTextField fld_customer_name;
    private JLabel lbl_type;
    private CustomerController customerController;
    private JLabel lbl_customer_phone;
    private JTextField fld_customer_phone;
    private JLabel lbl_customer_mail;
    private JTextField fld_customer_mail;
    private JLabel lbl_customer_address;
    private JTextArea tarea_customer_address;
    private JButton btn_customer_save;
    private Customer customer;
    private  JComboBox<Customer.TYPE> cmb_customer_type;

    public CustomerUI(Customer customer){
        this.customer = customer;
        this.customerController = new CustomerController();

        this.add(container);
        this.setTitle("Müşteri Ekle/Düzenle");
        this.setSize(300,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.cmb_customer_type.setModel(new DefaultComboBoxModel<>(Customer.TYPE.values()));

        if(this.customer.getId() == 0) {
            this.lbl_title.setText("Müşteri Ekle");
        } else{
            this.lbl_title.setText("Müşteri Düzenle");
            this.fld_customer_name.setText(this.customer.getName());
            this.fld_customer_mail.setText(this.customer.getMail());
            this.fld_customer_phone.setText(this.customer.getPhone());
            this.tarea_customer_address.setText(this.customer.getAddress());
            this.cmb_customer_type.getModel().setSelectedItem(this.customer.getType());

        }

        this.btn_customer_save.addActionListener(e -> {
            JTextField[] checkList = {this.fld_customer_name, this.fld_customer_phone};
            if(Helper.isFieldListEmpty(checkList)) {
                Helper.showMsg("fill");
            }else if((!Helper.isFieldEmpty(this.fld_customer_mail) && (!Helper.isEmailValid(this.fld_customer_mail.getText())))){
                Helper.showMsg("Lütfen geçerli bir e-posta adresi giriniz!");
            }else {
                boolean result = false;
                this.customer.setName(this.fld_customer_name.getText());
                this.customer.setPhone(this.fld_customer_phone.getText());
                this.customer.setMail(this.fld_customer_mail.getText());
                this.customer.setAddress(this.tarea_customer_address.getText());
                this.customer.setType((Customer.TYPE) this.cmb_customer_type.getSelectedItem());

                if(this.customer.getId() == 0) {
                    result =this.customerController.save(this.customer);
                }else{
                    result = this.customerController.update(this.customer);
                }

                if(result) {
                    Helper.showMsg("done");
                    dispose();
                }else {
                    Helper.showMsg("error");
                }
            }
        });


    }
}
