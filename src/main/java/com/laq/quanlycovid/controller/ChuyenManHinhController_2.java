package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.bean.DanhMucBean;
import com.laq.quanlycovid.view.QuarantineLocation;
import com.laq.quanlycovid.view.SignUp;
import com.laq.quanlycovid.view.TrangChuJPanel_2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class ChuyenManHinhController_2 {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController_2(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96,100,191));
        jpnItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel_2());
        root.validate();
        root.repaint();
    }

    /**
     *
     * @param listItem
     */
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        for(DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
           
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) { 
            switch (kind) {
                case "TrangChu":
                    node = new TrangChuJPanel_2();
                    break;
                case "SignUp":
                    node = new SignUp();
                    break;
                case "QuarantineLocation":
                    node = new QuarantineLocation();
                    break;
                //more...
                default:
                    node = new SignUp();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76,176,80));
                jlbItem.setBackground(new Color(76,176,80));
            }
                    
        }
    }
    private void setChangeBackground(String kind){
        for(DanhMucBean item: listItem){
            if (item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191)); 
            } else {
                item.getJpn().setBackground(new Color(76,176,80));
                item.getJlb().setBackground(new Color(76,176,80));
            }
        }
    }
}
