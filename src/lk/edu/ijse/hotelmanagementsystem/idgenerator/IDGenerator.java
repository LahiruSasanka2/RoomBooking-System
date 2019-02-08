/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.hotelmanagementsystem.idgenerator;

import java.sql.SQLException;
import java.text.NumberFormat;
import lk.edu.ijse.hotelmanagementsystem.idcontroller.IDController;

/**
 *
 * @author Happy Go Lucky
 */
public class IDGenerator {
    
     public static String getNewID(String tableName, String colName, String prifix) throws SQLException, ClassNotFoundException {
        String lastId = IDController.getLastID(tableName, colName);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prifix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newID = numberFormat.format(id);
            return prifix + newID;
        } else {
            return prifix + "001";
        }
    }
    
}
