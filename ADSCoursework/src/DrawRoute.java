import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*This class is used to visually display the route calculated by the algorithm*/

public class DrawRoute extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JFrame mainMap;
	private Polygon poly;

	public DrawRoute(){}
		
	public void Route(final ArrayList<Point2D> points)
	{
		// Visually approximate, but good enough.
		mainMap = new JFrame();
        mainMap.setResizable(true);

        mainMap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int[] xCoords = new int[points.size()];
        int[] yCoords = new int[points.size()];
        for(int i =0; i < points.size();i++)
        {
        	xCoords[i] = (int)points.get(i).getX()/18;
        	yCoords[i] = (int)points.get(i).getY()/18;
        }
    	poly = new Polygon(xCoords, yCoords, xCoords.length);
        JPanel p = new JPanel()
        {
           private static final long serialVersionUID = 1L;
			@Override
            protected void paintComponent(Graphics g)
			{
                super.paintComponent(g);
                g.setColor(Color.BLACK);
             
                g.drawString("Scaled down by 18.",50,50);
                g.setColor(Color.BLUE);
                g.drawPolygon(poly);
                g.setColor(Color.BLACK);
                for(int i=0; i < points.size();i++)
                {
                	DrawNthPoint(g,poly,i);
                }
            }

	        private void DrawNthPoint(Graphics g, Polygon polygon, int nth)
	        {	        	
	            int x = polygon.xpoints[nth];
	            int y = polygon.ypoints[nth];
	            g.drawOval(x-3,y-3,6,6);
	            g.fillOval(x-3,y-3,6,6);
	        }
            @Override
            public Dimension getPreferredSize()
            {
                return new Dimension(1980, 1080);
            }
        };
        mainMap.add(p);
        mainMap.pack();
        mainMap.setVisible(true);
	}
}
