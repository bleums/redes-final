package ux;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author migue
 */
public class PanelHorse extends JPanel{

    PanelSelection pSelection = null;
    /**
     * Creates new form JPanelHorse
     * @param panelSelection 
     * @throws IOException 
     */
    public PanelHorse(PanelSelection aThis) throws IOException {
        pSelection = aThis;

        initComponents();
        
        
        //btnHorse.setIcon(new ImageIcon("./images/0icons/blue.png"));
        //initiateHorse("Federico", "./images/0icons/blue.png");
        
    }

    public String getLblName() {
        return lblName.getText();
    }

    private void setLblName(String lblName) {
        this.lblName.setText(lblName);
    }

    public void initiateHorse(String name, String pathIcon) throws IOException{
    setLblName(name);
    
    btnHorse.setIcon(new ImageIcon(pathIcon));
    
    //btnHorse.setFocusable(false);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnHorse = new RoundButton("");
        lblName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(135, 150));

        //btnHorse.setText("foto");

        lblName.setFont(new java.awt.Font("Maiandra GD", 1, 11)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Caballo gen�rico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHorse, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnHorse, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        btnHorse.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		loadHorseInfo();
        	}

			private void loadHorseInfo() {
				pSelection.loadHorseInfo(lblName.getText());
			}
        });
        
    }// </editor-fold>                                                


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnHorse;
    private javax.swing.JLabel lblName;
    // End of variables declaration  
    
    private class RoundButton extends JButton {
      public RoundButton(String label) {
        super(label);

    // These statements enlarge the button so that it 
    // becomes a circle rather than an oval.
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, 
          size.height);
        setPreferredSize(size);

    // This call causes the JButton not to paint 
       // the background.
    // This allows us to paint a round background.
        setContentAreaFilled(false);
      }

    // Paint the round background and label.
      protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
    // You might want to make the highlight color 
       // a property of the RoundButton class.
          g.setColor(Color.white);
        } else {
          g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width-1, 
          getSize().height-1);

    // This call will paint the label and the 
       // focus rectangle.
        super.paintComponent(g);
      }

    // Paint the border of the button using a simple stroke.
      protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1, 
          getSize().height-1);
      }

    // Hit detection.
      Shape shape;
      public boolean contains(int x, int y) {
    // If the button has changed size, 
       // make a new shape object.
        if (shape == null || 
          !shape.getBounds().equals(getBounds())) {
          shape = new Ellipse2D.Float(0, 0, 
            getWidth(), getHeight());
        }
        return shape.contains(x, y);
      }
      
      
}
   
	
}
