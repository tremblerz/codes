import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LinesComponent extends JComponent{

private static class Line{
    final int x1; 
    final int y1;
    final int x2;
    final int y2;   
    final Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }               
}

private final LinkedList<Line> lines = new LinkedList<Line>();

public void addLine(int x1, int x2, int x3, int x4) {
    addLine(x1, x2, x3, x4, Color.black);
}

public void addLine(int x1, int x2, int x3, int x4, Color color) {
    lines.add(new Line(x1,x2,x3,x4, color));        
    repaint();
}

public void clearLines() {
    lines.clear();
    repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Line line : lines) {
        g.setColor(line.color);
        g.drawLine(line.x1, line.y1, line.x2, line.y2);
        System.out.println(line.x1 + "," + line.x2 + ","+line.y1 +","+ line.y2);
    }
}

public static void main(String[] args) {
    JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    final LinesComponent comp = new LinesComponent();
    comp.setPreferredSize(new Dimension(700, 400));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    JPanel buttonsPanel = new JPanel();
    JButton fcfs = new JButton("FCFS");
    JButton sstf = new JButton("SSTF");
    JButton scan = new JButton("SCAN");
    JButton cscan = new JButton("CSCAN");
    JButton look = new JButton("LOOK");
    JButton clook = new JButton("CLOOK");
    //JButton clearButton = new JButton("Clear");
    buttonsPanel.add(fcfs);
    buttonsPanel.add(sstf);
    buttonsPanel.add(scan);
    buttonsPanel.add(cscan);
    buttonsPanel.add(look);
    buttonsPanel.add(clook);
    fcfs.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			comp.clearLines();

            int x1 = 20;
            int x2 = 650;
            int y1 = 380;
            int y2 = 380;
           // Color randomColor = new Color(0,0,0);//(float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2);// randomColor);
            x1 = 20;
            x2 = 20;
            y1 = 380;
            y2 = 20;
            comp.addLine(x1 , y1 , x2 , y2);
			RandomInputGeneration r = new RandomInputGeneration(17);
            r.randomGeneration();
            fcfs f = new fcfs(r);
            f.makeOrder();
            int k=22;
            for(int i=1;i<r.numOfProcess;i++){
            	comp.addLine(10*f.ans[i-1]+20,k,10*f.ans[i]+20,k+20);
            	k+=20;
            }
		}
	});
    sstf.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			comp.clearLines();

            int x1 = 20;
            int x2 = 650;
            int y1 = 380;
            int y2 = 380;
           // Color randomColor = new Color(0,0,0);//(float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2);// randomColor);
            x1 = 20;
            x2 = 20;
            y1 = 380;
            y2 = 20;
            comp.addLine(x1 , y1 , x2 , y2);
			RandomInputGeneration r = new RandomInputGeneration(17);
            r.randomGeneration();
            sstf f = new sstf(r);
            f.makeOrder();
            int k=22;
            for(int i=1;i<r.numOfProcess;i++){
            	comp.addLine(10*f.ans[i-1]+20,k,10*f.ans[i]+20,k+20);
            	k+=20;
            }
		}
	});
    scan.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			comp.clearLines();

            int x1 = 20;
            int x2 = 650;
            int y1 = 380;
            int y2 = 380;
           // Color randomColor = new Color(0,0,0);//(float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2);// randomColor);
            x1 = 20;
            x2 = 20;
            y1 = 380;
            y2 = 20;
            comp.addLine(x1 , y1 , x2 , y2);
			RandomInputGeneration r = new RandomInputGeneration(17);
            r.randomGeneration();
            scan f = new scan(r);
            f.makeOrder();
            int k=22;
            for(int i=1;i<r.numOfProcess;i++){
            	comp.addLine(10*f.ans[i-1]+20,k,10*f.ans[i]+20,k+20);
            	k+=20;
            }
		}
	});    
    cscan.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			comp.clearLines();

            int x1 = 20;
            int x2 = 650;
            int y1 = 380;
            int y2 = 380;
           // Color randomColor = new Color(0,0,0);//(float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2);// randomColor);
            x1 = 20;
            x2 = 20;
            y1 = 380;
            y2 = 20;
            comp.addLine(x1 , y1 , x2 , y2);
			RandomInputGeneration r = new RandomInputGeneration(17);
            r.randomGeneration();
            cscan f = new cscan(r);
            f.makeOrder();
            int k=22;
            for(int i=1;i<r.numOfProcess;i++){
            	comp.addLine(10*f.ans[i-1]+20,k,10*f.ans[i]+20,k+20);
            	k+=20;
            }
		}
	});    
    look.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			comp.clearLines();

            int x1 = 20;
            int x2 = 650;
            int y1 = 380;
            int y2 = 380;
           // Color randomColor = new Color(0,0,0);//(float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2);// randomColor);
            x1 = 20;
            x2 = 20;
            y1 = 380;
            y2 = 20;
            comp.addLine(x1 , y1 , x2 , y2);
			RandomInputGeneration r = new RandomInputGeneration(17);
            r.randomGeneration();
            look f = new look(r);
            f.makeOrder();
            int k=22;
            for(int i=1;i<r.numOfProcess;i++){
            	comp.addLine(10*f.ans[i-1]+20,k,10*f.ans[i]+20,k+20);
            	k+=20;
            }
		}
	});    
    clook.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			comp.clearLines();

            int x1 = 20;
            int x2 = 650;
            int y1 = 380;
            int y2 = 380;
           // Color randomColor = new Color(0,0,0);//(float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2);// randomColor);
            x1 = 20;
            x2 = 20;
            y1 = 380;
            y2 = 20;
            comp.addLine(x1 , y1 , x2 , y2);
			RandomInputGeneration r = new RandomInputGeneration(17);
            r.randomGeneration();
            clook f = new clook(r);
            f.makeOrder();
            int k=22;
            for(int i=1;i<r.numOfProcess;i++){
            	comp.addLine(10*f.ans[i-1]+20,k,10*f.ans[i]+20,k+20);
            	k+=20;
            }
		}
	});
    //buttonsPanel.add(clearButton);
    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    //newLineButton.addActionListener(new ActionListener() {

        //@Override
       // public void actionPerformed(ActionEvent e) {
    //Drawing Axis
            int x1 = 20;
            int x2 = 650;
            int y1 = 380;
            int y2 = 380;
           // Color randomColor = new Color(0,0,0);//(float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2);// randomColor);
            x1 = 20;
            x2 = 20;
            y1 = 380;
            y2 = 20;
            comp.addLine(x1 , y1 , x2 , y2);
            
      //  }
    //});
   // clearButton.addActionListener(new ActionListener() {

        //@Override
     //   public void actionPerformed(ActionEvent e) {
          //  comp.clearLines();
     //   }
    //});
    testFrame.pack();
    testFrame.setVisible(true);
}

}