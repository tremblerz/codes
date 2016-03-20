import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class main extends JFrame {

    public main() {

        initUI();
    }

    private void initUI() {
        createMenuBar();
        createCenterScreen();
        setTitle("Simulator !!");
        setSize(1046, 300);
        setLocationRelativeTo(null);
     //   setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void createCenterScreen(){
    	java.net.URL disk = getClass().getResource("images/disk.png");
    	java.net.URL cpu = getClass().getResource("images/cpu.png");
    	java.net.URL page = getClass().getResource("images/paging.gif");
    	java.net.URL dining = getClass().getResource("images/dining.jpg");
    	
    	ImageIcon id1 = new ImageIcon(disk);
    	JLabel diskL = new JLabel(id1);
    	diskL.setBounds(20, 20, 256, 256);
    	diskL.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		     //LinesComponent d = new LinesComponent();
    		     LinesComponent.main(null);
    		}
		});
    	
    	
    	ImageIcon id3 = new ImageIcon(page);
    	JLabel diskP = new JLabel(id3);
    	diskP.setBounds(520,20,256,256);
    	diskP.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {

    		}
		});
    	
    	ImageIcon id2 = new ImageIcon(cpu);
    	JLabel diskC = new JLabel(id2);
    	diskC.setBounds(290,38,216,226);
    	diskC.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
		     //runner c = new runner();
    		
		     runner.main(null);    		     
    		}
		});
 
    	ImageIcon id4 = new ImageIcon(dining);
    	JLabel diskD = new JLabel(id4);
    	diskD.setBounds(790,10,256,296);
    	diskD.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		     //main1 m = new main1();
    		//	System.out.println("!!!");
    		     main1.main(null);
    		}
		});
    	
   	JLabel t = new JLabel("");
  		t.setBounds(600,280,200,40);
    	
    	getContentPane().add(diskL);
    	getContentPane().add(diskC);
    	getContentPane().add(diskD);
    	getContentPane().add(diskP);
    	getContentPane().add(t);
    	//getContentPane().add();
    }
    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();
        ImageIcon icone = new ImageIcon("exit.png");
        ImageIcon iconx = new ImageIcon("export.png");
        
        JMenu file = new JMenu("File");
        JMenu credits = new JMenu("Credits");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem i1 = new JMenuItem("Dr. Amitava Das Sir");
        JMenuItem i2 = new JMenuItem("Ashoka Sir");
        JMenuItem i3 = new JMenuItem("Abhishek Singh");
        JMenuItem i4 = new JMenuItem("Akash Das");
        JMenuItem i5 = new JMenuItem("Randhir Prakash");
        JMenuItem i6 = new JMenuItem("Chandrakant Ojha");
        
        JMenuItem eMenuItem = new JMenuItem("Exit", icone);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        JMenuItem export = new JMenuItem("Export", iconx);
        export.setMnemonic(KeyEvent.VK_X);
        export.setToolTipText("Export Results");
        export.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent event) {
        		
        	}
        });

        file.add(eMenuItem);
        file.add(export);
        credits.add(i1);
        credits.add(i2);
        credits.add(i3);
        credits.add(i4);
        credits.add(i5);
        credits.add(i6);
        menubar.add(file);
        menubar.add(credits);
        setJMenuBar(menubar);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            //@Override
            public void run() {
                main ex = new main();
                ex.setVisible(true);
            }
        });
    }
}