import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

//画面表示クラス
public class Display extends JFrame implements ActionListener,MouseListener{
	
	private JFrame disp;
	private JPanel top_panel,mid_panel,design_panel,soutyu_panel,bottom_panel;
	private JLabel msg_lbl;
	private JLabel pole_lbl,soutyu_lbl,pole_no_lbl;
	private JButton btn_gaisi,btn_makeDocument,btn_deleteDocument;

	ArrayList<Pole> poleList = new ArrayList<>();
	ArrayList<Soutyu> soutyuList = new ArrayList<>();
	private int opeMode;
	
	//処理モード定義
	final int MAKE_POLE_MODE = 1;
	final int SELECT_POLE_MODE = 2;
	final int CALC_COST_MODE = 3;
	final int CONST_POLE_MODE = 4;
	
	public Display() {
		//設計画面フレーム作成
		disp = new JFrame("設計書作成");
		disp.setSize(960, 560);
		disp.setLocationRelativeTo(null);
		disp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		disp.setResizable(false);
		
		Container contentPane = disp.getContentPane();

		//操作モード選択パネル作成
		top_panel = new JPanel();
		setPanel(top_panel,Color.LIGHT_GRAY,null,new Dimension(960,30));
		contentPane.add(top_panel, BorderLayout.NORTH);
		msg_lbl = new JLabel("操作モードを選択してください");
		top_panel.add(msg_lbl);
		setLabelFont(msg_lbl,Color.BLACK,-80,5,480,20,20,false);

		//設計書メインパネル作成
		mid_panel = new JPanel();
		setPanel(mid_panel,Color.WHITE,new BorderLayout(),new Dimension(960,180));
		contentPane.add(mid_panel,BorderLayout.CENTER);
		
		//設計書パネル
		design_panel = new JPanel();
		setPanel(design_panel,Color.CYAN,null,new Dimension(540,180));
		mid_panel.add(design_panel,BorderLayout.WEST);
		design_panel.addMouseListener(this);
		//装柱パネル
		soutyu_panel = new JPanel();
		setPanel(soutyu_panel,Color.WHITE,null,new Dimension(320,180));
		mid_panel.add(soutyu_panel,BorderLayout.CENTER);
		soutyu_panel.addMouseListener(this);
		
		//モード選択ボタン
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
		btn_deleteDocument= new JButton("金額計算");
		setButton(btn_deleteDocument,this,320,50,20);
		bottom_panel.add(btn_deleteDocument, BorderLayout.EAST);
		
		disp.setVisible(true);
	}
	
	//操作モードボタン押下処理
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
		else if(cmd.equals("金額計算")) {
			opeMode = CALC_COST_MODE;
			msg_lbl.setText("操作モード：電柱削除");
		}
		else if(cmd.equals("装柱")) {
			opeMode = CONST_POLE_MODE;
			msg_lbl.setText("操作モード：装柱作成");
		}
		return;
	}

	//パネル設定
	public static void setPanel(JPanel panel,Color color,BorderLayout layout,Dimension dimension) {
		BevelBorder border = new BevelBorder(BevelBorder.RAISED);
		panel.setBackground(color);
		panel.setLayout(layout);
		panel.setPreferredSize(dimension);
		panel.setBorder(border);
	}

	//ラベル設定
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
	
	//ボタン設定
	public static void setButton(JButton btn,ActionListener al,int x_size,int y_zize,int strSize) {
		btn.setPreferredSize(new Dimension(x_size,y_zize));
		btn.setFont(new Font("MS ゴシック",Font.PLAIN,strSize));
		btn.addActionListener(al);
		
		return;
	}

	//マウス押下処理
	@Override
	public void mouseClicked(MouseEvent e) {
		String poleNo = null;
		String soutyuNo = null;
		int zahyoX;
		int zahyoY;
		
		Point point = e.getPoint();
		zahyoX = point.x;
		zahyoY = point.y;
		
		//電柱作成モード
		if(opeMode == MAKE_POLE_MODE) {	
			poleNo = JOptionPane.showInputDialog(this,"電柱番号");
			if (poleNo == null) {
				;
			}

			Pole pole = new Pole(Integer.parseInt(poleNo));
			Soutyu soutyu = new Soutyu(Integer.parseInt(poleNo));
			poleList.add(pole);
			soutyuList.add(soutyu);
			
			if (soutyu_lbl != null){
				soutyu_lbl.setIcon(null);
				pole_no_lbl.setText(null);
			}

			pole.setZahyoX(zahyoX);
			pole.setZahyoY(zahyoY);
			pole_lbl = new JLabel(pole.makePole());
			design_panel.add(pole_lbl);
			setLabelFont(pole_lbl, Color.WHITE, zahyoX -100, zahyoY -100, 200, 200, 16, false);
			
			soutyu_lbl = new JLabel(soutyu.makeSoutyu());
			soutyu_panel.add(soutyu_lbl);
			setLabelFont(soutyu_lbl, Color.WHITE, 50, 35, 200, 400, 16, false);
			
			soutyuNo = "電柱No:" + poleNo;
			soutyu.setSoutyuNo(soutyuNo);
			pole_no_lbl = new JLabel(soutyuNo);
			soutyu_panel.add(pole_no_lbl);
			setLabelFont(pole_no_lbl, Color.WHITE, 15, 10, 100, 100, 16, false);
		}
		
		//電柱選択モード
		else if(opeMode == SELECT_POLE_MODE) {
			for(int i = 0; i < poleList.size(); i++) {
				if (soutyu_lbl != null){
					soutyu_lbl.setIcon(null);
					pole_no_lbl.setText(null);
				}
				if (poleList.get(i).getZahyoX() <= zahyoX + 10 && zahyoX - 10 <= poleList.get(i).getZahyoX()
					  && poleList.get(i).getZahyoY() <= zahyoY + 10 && zahyoY - 10 <= poleList.get(i).getZahyoY()){

					Soutyu soutyu = new Soutyu(soutyuList.get(i).getPoleNo());
					soutyu_lbl = new JLabel(soutyu.makeSoutyu());
					soutyu_panel.add(soutyu_lbl);
					setLabelFont(soutyu_lbl, Color.WHITE, 50, 35, 200, 400, 16, false);
					
					soutyuNo = soutyuList.get(i).getSoutyuNo();
					pole_no_lbl = new JLabel(soutyuNo);
					soutyu_panel.add(pole_no_lbl);
					setLabelFont(pole_no_lbl, Color.WHITE, 15, 10, 100, 100, 16, false);
					break;
				}
			}
		}
		
		//金額計算モード
		else if(opeMode == CALC_COST_MODE) {
			
		}
		
		//装柱作成モード
		else if(opeMode == CONST_POLE_MODE) {
			Soutyu soutyu = new Soutyu(Integer.parseInt(poleNo));
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
