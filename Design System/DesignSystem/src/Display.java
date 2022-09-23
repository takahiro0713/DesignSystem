import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Display implements ActionListener{
	private JFrame disp;
	private JPanel top_panel,mid_panel,design_panel,soutyu_panel,material_panel,bottom_panel;
	private JLabel msg_lbl;
	private JLabel pole_lbl,parent_suit_lbl,parent_no_lbl;
	private JLabel pole;
	private JLabel material;
	private JButton btn_gaisi,btn_sw,btn_tr,btn_makeDocument,btn_deleteDocument;
	
	private int zahyoX;
	private int zahyoY;
	private int opeMode;
	
	final int MAKE_POLE_MODE = 1;
	final int DELETE_POLE_MODE = 2;
	final int SELECT_POLE_MODE = 3;
	final int CONST_POLE_MODE = 4;
	
	public Display() {
		disp = new JFrame("設計書作成");
		disp.setSize(960, 560);
		disp.setLocationRelativeTo(null);
		disp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		disp.setResizable(false);
		
		Container contentPane = disp.getContentPane();
		
		top_panel = new JPanel();
		setPanel(top_panel,Color.LIGHT_GRAY,null,new Dimension(960,30));
		contentPane.add(top_panel, BorderLayout.NORTH);
		
		msg_lbl = new JLabel("操作モードを選択してください");
		top_panel.add(msg_lbl);
		setLabelFont(msg_lbl,Color.BLACK,-80,5,480,20,20,false);
		
		mid_panel = new JPanel();
		setPanel(mid_panel,Color.WHITE,new BorderLayout(),new Dimension(960,180));
		contentPane.add(mid_panel,BorderLayout.CENTER);
		
		design_panel = new JPanel();
		setPanel(design_panel,Color.CYAN,null,new Dimension(540,180));
		mid_panel.add(design_panel,BorderLayout.WEST);
		soutyu_panel = new JPanel();
		setPanel(soutyu_panel,Color.WHITE,null,new Dimension(320,180));
		mid_panel.add(soutyu_panel,BorderLayout.CENTER);
		btn_gaisi = new JButton("装柱");
		setButton(btn_gaisi,this,100,180,20);
		mid_panel.add(btn_gaisi, BorderLayout.EAST);
		
		bottom_panel= new JPanel();
		setPanel(bottom_panel,Color.LIGHT_GRAY,new BorderLayout(),new Dimension(960,50));
		contentPane.add(bottom_panel,BorderLayout.SOUTH);
		
		btn_makeDocument= new JButton("電柱作成");
		setButton(btn_makeDocument,this,320,50,20);
		bottom_panel.add(btn_makeDocument, BorderLayout.WEST);

		btn_makeDocument= new JButton("電柱選択");
		setButton(btn_makeDocument,this,320,50,20);
		bottom_panel.add(btn_makeDocument, BorderLayout.CENTER);
		
		btn_deleteDocument= new JButton("電柱削除");
		setButton(btn_deleteDocument,this,320,50,20);
		bottom_panel.add(btn_deleteDocument, BorderLayout.EAST);
		
		disp.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("電柱作成")) {
			opeMode = MAKE_POLE_MODE;
			msg_lbl.setText("操作モード：電柱作成");
		}
		else if(cmd.equals("電柱選択")) {
			opeMode = SELECT_POLE_MODE;
			msg_lbl.setText("操作モード：電柱選択");
		}
		else if(cmd.equals("電柱削除")) {
			opeMode = DELETE_POLE_MODE;
			msg_lbl.setText("操作モード：電柱削除");
		}
		else if(cmd.equals("装柱")) {
			opeMode = CONST_POLE_MODE;
			msg_lbl.setText("操作モード：装柱作成");
		}
		return;
	}
	
	public void mousePressed(MouseEvent e) {
		Point point = e.getPoint();
		zahyoX = point.x;
		zahyoY = point.y;
		
		if(opeMode == MAKE_POLE_MODE) {
			UtilityPole utilityPole = new UtilityPole();
			utilityPole.setZahyoX(zahyoX);
			utilityPole.setZahyoY(zahyoY);
			pole_lbl = new JLabel(utilityPole.makePole());
			setLabelFont(pole_lbl, Color.WHITE, zahyoX, zahyoY, 80, 100, 16, false);
		}
		else if(opeMode == SELECT_POLE_MODE) {
			
		}
		else if(opeMode == DELETE_POLE_MODE) {
			
		}
	}
	
	public static void setPanel(JPanel panel,Color color,BorderLayout layout,Dimension dimension) {
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		panel.setBackground(color);
		panel.setLayout(layout);
		panel.setPreferredSize(dimension);
		panel.setBorder(border);
	}
	
	public static void setLabelFont(JLabel label, Color clr,int x_pos,int y_pos,int x_size,int y_size,int strSize,boolean opq) {
		label.setBackground(clr);
		label.setLocation(x_pos,y_pos);
		label.setSize(x_size,y_size);
		label.setFont(new Font("MS ゴシック",Font.PLAIN,strSize));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setOpaque(opq);
		
		return;
	}
	
	public static void setButton(JButton btn,ActionListener al,int x_size,int y_zize,int strSize) {
		btn.setPreferredSize(new Dimension(x_size,y_zize));
		btn.setFont(new Font("MS ゴシック",Font.PLAIN,strSize));
		btn.addActionListener(al);
		
		return;
	}
}
