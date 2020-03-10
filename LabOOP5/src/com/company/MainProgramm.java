package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainProgramm extends JFrame implements ActionListener{
    private User user = new User();
    // Кнопки
    private JButton enter = new JButton("Войти");
    private JButton register = new JButton("Регистрация");
    // Строки ввода
    private JTextField loginInput = new JTextField("", 5);
    private JTextField passInput = new JTextField("", 5);
    // Лейблы
    private JLabel loginLabel = new JLabel("Логин:");
    private JLabel passLabel = new JLabel("Пароль:");
    public MainProgramm() throws IOException, ClassNotFoundException {
        super("Вход в систему");
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        this.setBounds(sSize.width/2-150,sSize.height/2-75,300,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        enter.addActionListener(this);
        register.addActionListener(this);

        Container container = this.getContentPane();

        GroupLayout layout = new GroupLayout(container);
        container.setLayout(layout);

        layout.setAutoCreateGaps(true);

        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                addComponent(loginLabel).addComponent(passLabel).addComponent(enter));
        hGroup.addGroup(layout.createParallelGroup().
                addComponent(loginInput).addComponent(passInput).addComponent(register));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(loginLabel).addComponent(loginInput));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(passLabel).addComponent(passInput));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(enter).addComponent(register));
        layout.setVerticalGroup(vGroup);
    }


        @Override

    public void actionPerformed(ActionEvent ev)//слушатель

    {


        if (ev.getSource()==enter) //getSource возвращает компонент для которого слушать

        {
            if(loginInput.getText().isEmpty() || passInput.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Заполните все поля", "Окно сообщений", JOptionPane.WARNING_MESSAGE);
            }
            else {
                if(user.enter(loginInput.getText(), passInput.getText())) {
                    setVisible(false);
                    ListCandidates listCandidates = null;
                    try {
                        listCandidates = new ListCandidates(user);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    listCandidates.setVisible   (true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Логин или пароль не верен", "Окно сообщений", JOptionPane.WARNING_MESSAGE);
                }
            }

        }

        else if (ev.getSource()==register)

        {
            setVisible(false);
            RegisterGUI registerGUI = null;
            try {
                registerGUI = new RegisterGUI();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            registerGUI.setVisible(true);


        }


    }

}
