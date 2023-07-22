import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe extends JFrame implements ActionListener{

JPanel panel = new JPanel();
JButton[] buttons = new JButton[9];
JPanel paneltitle = new JPanel(); 
Random random = new Random(); 
JLabel textfield = new JLabel();
boolean player1turn;

    TicTacToe(){
		this.setTitle("TicTacToeGame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(700,700);
        this.getContentPane().setBackground(new Color(50,50,50));
        this.setLayout(new BorderLayout());

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,45));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);


        paneltitle.setLayout(new BorderLayout());
        paneltitle.setBounds(0,0,700,100);
        paneltitle.add(textfield);

        panel.setLayout(new GridLayout(3,3));
        panel.setBackground(new Color(150,150,150));

        for(int i =0;i<9;i++){
            buttons[i] = new JButton();
            panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.lightGray);
        }

        this.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    for(int i =0;i<9;i++){
                        buttons[i].setText("");
                        buttons[i].setEnabled(true);
                        buttons[i].setBackground(Color.lightGray);
                    }
                    firstTurn();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }

            @Override
            public void keyTyped(KeyEvent e) {
               
            }
            
        });

        this.add(paneltitle, BorderLayout.NORTH);
        this.add(panel);
        this.setVisible(true);
        firstTurn();
	}
	

    @Override
    public void actionPerformed(ActionEvent e) {
          
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1turn=false;
                        textfield.setText("O turn");
                        check();
                    }
                } 
                else {
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1turn=true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){

        try {
            Thread.sleep(1600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0){
            player1turn = true;
            textfield.setText("X turn");
        }
        else{
            player1turn = false;
            textfield.setText("O turn");
        }
    }
    
    public void check(){

        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }

        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }

        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }

        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }

        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }

        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }

        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }

        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }

        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }

        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }

        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }

        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }

        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }

        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }

        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }

    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins (Enter to restart)");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O wins (Enter to restart)");
    }
}
