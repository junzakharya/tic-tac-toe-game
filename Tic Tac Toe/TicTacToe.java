import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TicTacToe class
public class TicTacToe implements ActionListener{
    JFrame window = new JFrame("Tic-Tac-Toe");
    // create a Jpanel
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel reloadPanel = new JPanel();
    JPanel scorePanel = new JPanel();

    JLabel textfield = new JLabel();

    JButton[] buttons = new JButton[9];

    JButton restartButton = new JButton("Restart");

    JLabel scoreLabelPlayerX = new JLabel();
    JLabel scoreLabelPlayerO = new JLabel();

    int playerXScore = 0;
    int playerOScore = 0;

    boolean playerXturn;

    TicTacToe(){
        window.setSize(1000,800);
        window.getContentPane().setBackground(new Color(50,50,50));
        window.setLayout(new BorderLayout());
        window.setVisible(true);
        window.setBounds(150,0,1000,800);

        textfield.setBackground(new Color(149,43,94));
        textfield.setForeground(new Color(245,255,64));

        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);

        textfield.setText("Tic-Tac-Toe");

        textfield.setOpaque(true);
        // set the layout of the JPanel
        titlePanel.setLayout(new BorderLayout());
        // set the bounds of the JPanel
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(240,240,240));

        for(int i=0;i<9;i++){
            buttons[i] =new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(240,240,240));
        }

        reloadPanel.setLayout(new BorderLayout());
        reloadPanel.setBounds(0,0,800,100);

        reloadPanel.setBackground(new Color(150,150,150));
        reloadPanel.add(restartButton);

        restartButton.setFont(new Font("MV Boli", Font.BOLD, 50));
        // set color of the reload button
        restartButton.setBackground(new Color(255, 0, 0));
        restartButton.setForeground(new Color(0, 0, 0));
        // set the reload button to be not focusable
        restartButton.setFocusable(false);
        // add an action listener to the reload button
        restartButton.addActionListener(this);
        restartButton.setHorizontalAlignment(JLabel.CENTER);

        scorePanel.setLayout(new GridLayout(2, 1));
        // set the background color of the JPanel as gold
        scorePanel.setBackground(new Color(0, 0, 0));

        scoreLabelPlayerX.setFont(new Font("MV Boli", Font.BOLD, 20));
        // set the text of the score label such that it displays the score of both players in two lines
        scoreLabelPlayerX.setText("Player X: " + playerXScore);
        scoreLabelPlayerX.setForeground(new Color(0,255,0));
        // add the score label to the JPanel
        scorePanel.add(scoreLabelPlayerX);

        scoreLabelPlayerO.setFont(new Font("MV Boli", Font.BOLD, 20));
        // set the text of the score label such that it displays the score of both players in two lines
        scoreLabelPlayerO.setText("Player O: " + playerOScore);
        scoreLabelPlayerO.setForeground(new Color(0,0,255));
        // add the score label to the JPanel
        scorePanel.add(scoreLabelPlayerO);
        titlePanel.add(textfield);

        window.add(titlePanel, BorderLayout.NORTH);
        // add the JPanel to the JFrame
        window.add(buttonPanel);
        // add the JPanel to the JFrame
        window.add(reloadPanel, BorderLayout.SOUTH);
        // add the JPanel to the JFrame
        window.add(scorePanel, BorderLayout.EAST);
        firstTurn();

    }

    public void firstTurn(){
        try{
            textfield.setText("Tic-Tac-Toe");
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        if(Math.random()<0.5){
            playerXturn = true;
            textfield.setText("player X's turn");
            textfield.setForeground(new Color(0,255,0));
        }
        else{
            playerXturn = false;
            textfield.setText("player O's turn");
            textfield.setForeground(new Color(0,0,255));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(playerXturn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,255,0));
                        buttons[i].setText("X");
                        playerXturn=false;

                        textfield.setText("player O's turn");
                        textfield.setForeground(new Color(0,0,255));
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        playerXturn=true;

                        textfield.setText("player X's turn");
                        textfield.setForeground(new Color(0,255,0));
                        check();
                    }
                }
            }
        }

        if(e.getSource()==restartButton){
            restart();
        }
    }
    public void restart(){
        for(int i=0;i<9;i++){
            buttons[i].setText("");
            buttons[i].setBackground(new Color(240,240,240));
            buttons[i].setEnabled(true);
        }
        firstTurn();
    }

    public void check(){
        // create an if statement
        if (
            (buttons[0].getText() == "X") &&
            (buttons[1].getText() == "X") &&
            (buttons[2].getText() == "X")
        ) {
            xWins(0, 1, 2);
        }
        // create an if statement
        if (
            (buttons[3].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[5].getText() == "X")
        ) {
            xWins(3, 4, 5);
        }
        // create an if statement
        if (
            (buttons[6].getText() == "X") &&
            (buttons[7].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(6, 7, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "X") &&
            (buttons[3].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(0, 3, 6);
        }
        // create an if statement
        if (
            (buttons[1].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[7].getText() == "X")
        ) {
            xWins(1, 4, 7);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "X") &&
            (buttons[5].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(2, 5, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[8].getText() == "X")
        ) {
            xWins(0, 4, 8);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "X") &&
            (buttons[4].getText() == "X") &&
            (buttons[6].getText() == "X")
        ) {
            xWins(2, 4, 6);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[1].getText() == "O") &&
            (buttons[2].getText() == "O")
        ) {
            oWins(0, 1, 2);
        }
        // create an if statement
        if (
            (buttons[3].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[5].getText() == "O")
        ) {
            oWins(3, 4, 5);
        }
        // create an if statement
        if (
            (buttons[6].getText() == "O") &&
            (buttons[7].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(6, 7, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[3].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(0, 3, 6);
        }
        // create an if statement
        if (
            (buttons[1].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[7].getText() == "O")
        ) {
            oWins(1, 4, 7);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "O") &&
            (buttons[5].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(2, 5, 8);
        }
        // create an if statement
        if (
            (buttons[0].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[8].getText() == "O")
        ) {
            oWins(0, 4, 8);
        }
        // create an if statement
        if (
            (buttons[2].getText() == "O") &&
            (buttons[4].getText() == "O") &&
            (buttons[6].getText() == "O")
        ) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
        textfield.setForeground(new Color(0,255,0));
        playerXScore++;
        scoreLabelPlayerX.setText("player X: "+playerXScore);
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.blue);
        buttons[b].setBackground(Color.blue);
        buttons[c].setBackground(Color.blue);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins");
        textfield.setForeground(new Color(0,0,255));
        playerOScore++;
        scoreLabelPlayerO.setText("player O: "+playerOScore);
    }

}