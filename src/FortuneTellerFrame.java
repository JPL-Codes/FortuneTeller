import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl;
    JPanel topPnl;
    JPanel centerPnl;
    JPanel bottomPnl;
    JButton fortuneBtn;
    JButton quitBtn;
    Icon icon;
    JLabel titleLbl;
    JLabel fontLbl;


    JScrollPane pane;
    TextArea fortuneTA;
    Random rnd = new Random();

    String [] fortunes = {"Your beer will sour!", "All your bacon will burn!", "You are become rich!", "You are become so very poor!", "Your true love is a skink!", "Bees!", "No soup for you!", "No more school!", "Get super powers!","Gain intellect!"};
          int curFortuneDex = -1;
          int newFortuneDex = 0;
    
    public FortuneTellerFrame()
    {

        CreateGUI();
        setTitle("Fortune Teller");
      //  setSize(600,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        // center frame in screen
        setSize(3 * screenWidth / 4, 3 * screenHeight / 4);
        setLocation(screenWidth / 8, screenHeight / 6);
        setVisible(true);
    }
    
    private void CreateGUI()
    {

        mainPnl = new JPanel();
        topPnl = new JPanel();
        centerPnl = new JPanel();
        bottomPnl = new JPanel();


        mainPnl.setLayout(new BorderLayout());
        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(centerPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        createTopPnl();
        createCenterPnl();
        createBottomPnl();

    }

    private void createCenterPnl()
    {
        fortuneTA = new TextArea(15, 50);
        pane = new JScrollPane(fortuneTA);
        centerPnl.add(pane);
    }

    private void createTopPnl()
    {
        icon = new ImageIcon("src/orbS.jpg");
        titleLbl = new JLabel("Fortune Teller",icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setFont(new Font("Century", Font.PLAIN, 36));
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        topPnl.add(titleLbl);

    }

    private void createBottomPnl()
    {

        fortuneBtn = new JButton("Get a fortune");
        fortuneBtn.addActionListener((ActionEvent ae) ->{
            do {

                        newFortuneDex = rnd.nextInt(fortunes.length);}

                while(newFortuneDex == curFortuneDex);
                curFortuneDex = newFortuneDex;

                fortuneTA.append(fortunes[curFortuneDex] + "\n");

                });

        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) ->
        System.exit(0));

        
        bottomPnl.setLayout(new GridLayout(1,2));
        bottomPnl.add(fortuneBtn);
        bottomPnl.add(quitBtn);
    }
}
