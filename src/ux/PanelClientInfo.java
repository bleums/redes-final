package ux;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelClientInfo extends JPanel {

	private String seg;
	private String min;
	private String estado;

	public PanelClientInfo(){
		seg="00";
		min="00";
		estado = "inicial";
		
	}

	public String getMin() {
		return min;
	}


	public void setMin(String min) {
		this.min = min;
	}



	public String getSeg() {
		return seg;
	}



	public void setSeg(String seg) {
		this.seg = seg;
	}



	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setFont(new Font("arial", Font.BOLD,50));
		g2.drawString(" TIEMPO:  ",20,45);
		
		
		g2.setColor(Color.RED);
		g2.drawString(min+":"+seg,300,45);
		
		g2.setFont(new Font("arial", Font.BOLD,30));
		g2.drawString(estado,600,45);
		
		ImageIcon imgMeta = new ImageIcon("../images/0icons/red.png");
		g2.drawImage(imgMeta.getImage(), 800, 0,40,50,null);
		
		repaint();
		validate();
	}

}
