
package com.laq.quanlycovid.utility;

import com.laq.quanlycovid.model.NguoiDung;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Envy
 */
public class ClassTableModel {
    public DefaultTableModel setTableNguoiDung(List<NguoiDung> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
            
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        System.out.println("So Dòng " + rows);
        if (rows > 0){
            for (int i =0; i < rows; i++){
                NguoiDung nguoiDung = listItem.get(i);
                obj = new Object[columns];
                obj[0] = nguoiDung.getCMND();
                obj[1] = nguoiDung.getName();
                obj[2] = nguoiDung.getYear();
                obj[3] = nguoiDung.getStatus();
                obj[4] = nguoiDung.getHospital();
                obj[5] = nguoiDung.getLinkedPID();
                obj[6] = nguoiDung.getDebt();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
