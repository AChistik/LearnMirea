package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterGUI extends JFrame implements ActionListener{

    private User user = new User();

    // Кнопки
    private JButton goBack = new JButton("Назад");
    private JButton register = new JButton("Зарегистрироваться");
    // Строки ввода
    private JTextField loginInput = new JTextField("", 5);
    private JTextField passInput = new JTextField("", 5);
    // Лейблы
    private JLabel loginLabel = new JLabel("Придумайте логин:");
    private JLabel passLabel = new JLabel("Придумайте пароль:");
    private int windowWidth = 400;
    private int windowHeight = 150;
    public RegisterGUI() throws IOException, ClassNotFoundException {
        super("Регистрация");
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        this.setBounds(sSize.width/2-windowWidth/2,sSize.height/2-windowHeight/2,windowWidth,windowHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        goBack.addActionListener(this);
        register.addActionListener(this);

        Container container = this.getContentPane();

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);

        layout.setAutoCreateGaps(true);

        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(loginLabel).addComponent(passLabel).addComponent(goBack));
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(loginInput).addComponent(passInput).addComponent(register));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(loginLabel).addComponent(loginInput));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(passLabel).addComponent(passInput));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(goBack).addComponent(register));
        layout.setVerticalGroup(vGroup);
    }
    @Override

    public void actionPerformed(ActionEvent ev)//слушатель
    {
        if (ev.getSource()==goBack) //getSource возвращает компонент для которого слушать
        {
            setVisible(false);
            MainProgramm mainProgramm = null;
            try {
                mainProgramm = new MainProgramm();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            mainProgramm.setVisible(true);
        }
        else if (ev.getSource()==register)
        {
            if(loginInput.getText().isEmpty() || passInput.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Заполните все поля", "Окно сообщений", JOptionPane.WARNING_MESSAGE);
            }
            else {
                try {
                    user.addUser(loginInput.getText(), passInput.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setVisible(false);
                MainProgramm mainProgramm = null;
                try {
                    mainProgramm = new MainProgramm();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                mainProgramm.setVisible(true);
            }

        }


    }

}

