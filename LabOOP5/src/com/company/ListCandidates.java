package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ListCandidates extends JFrame implements ActionListener {

    private User user;
    private Elector elector = new Elector();
    private Candidate candidate = new Candidate();


    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    // Кнопки
    private JButton close = new JButton("Выход");
    private JButton[] btnVoice = new JButton[7];

    // Лейблы
    private JLabel alert = new JLabel("Выберите за кого хотите проголосовать");
    private JLabel[] candidates = new JLabel[7];

    private int windowWidth = 400;
    private int windowHeight = 300;
    public ListCandidates(User user) throws IOException, ClassNotFoundException {

        candidates[0] = new JLabel("      Николай Соболев");
        candidates[1] = new JLabel("      Юрий Дудь");
        candidates[2] = new JLabel("      Сергей Дружко");
        candidates[3] = new JLabel("      Эльдар Джарахов");
        candidates[4] = new JLabel("      Маша Вэй");
        candidates[5] = new JLabel("      Марьяна Рожкова");
        candidates[6] = new JLabel("      Костя Павлов");

        this.user = user;
        this.setTitle("Голосование");
        Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        this.setBounds(sSize.width/2-windowWidth/2,sSize.height/2-windowHeight/2,windowWidth,windowHeight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        for(int i = 0; i < btnVoice.length; i++){
            btnVoice[i] = new JButton("Проголосовать");
            btnVoice[i].addActionListener(this);
        }

        close.addActionListener(this);


        if(this.elector.fileExist == true){
            if(elector.isVoted(user.getLogin())) {
                alert.setText("Вы уже голосовали!");
                disableAllButton();
            }
        }

        if(user.getLogin().equals("admin")){
            alert.setText("Вы администратор и не можете голосовать!");
            for(int i = 0; i < candidates.length; i++) {
                candidates[i].setText(candidates[i].getText() + " ( " + candidate.getVoices(i) + " )");
            }
            disableAllButton();
        }

        Container container = this.getContentPane();

        container.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        if (shouldFill) {
            // натуральная высота, максимальная ширина
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        if (shouldWeightX) {
            c.weightx = 0.5;
        }

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        container.add(alert, c);



        for(int i = 0; i < candidates.length; i++) {
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i+1;
            c.gridwidth = 1;
            container.add(candidates[i], c);

            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 0.5;
            c.gridx = 1;
            c.gridy = i+1;
            container.add(btnVoice[i], c);
        }



        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 1;
        c.gridy = candidates.length+1;
        container.add(close, c);


    }
    @Override

    public void actionPerformed(ActionEvent ev)//слушатель

    {


        if (ev.getSource()==close) //getSource возвращает компонент для которого слушать

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

        else if(ev.getSource() == btnVoice[0]){
            try {
                vote(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ev.getSource() == btnVoice[1]){
            try {
                vote(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ev.getSource() == btnVoice[2]){
            try {
                vote(2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ev.getSource() == btnVoice[3]){
            try {
                vote(3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ev.getSource() == btnVoice[4]){
            try {
                vote(4);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ev.getSource() == btnVoice[5]){
            try {
                vote(5);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ev.getSource() == btnVoice[0]){
            try {
                vote(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ev.getSource() == btnVoice[6]){
            try {
                vote(6);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void vote(int num) throws IOException {
        elector.vote(user.getLogin(),num);
        candidate.addVoice(num);
        alert.setText("Вы проголосовали за " + candidates[num].getText());
        disableAllButton();
    }

    private void disableAllButton(){
        for(int i = 0; i < btnVoice.length; i++){
            btnVoice[i].setEnabled(false);
        }
    }

}

