package com.dsunsoft.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

/**
 * @author zb
 * 导入excel工具类
 */
public class ImportExcelUtils {

    
    /**
     * 删除字符串末尾的0
     * @param tempString
     * @return
     */
    public static String delZero(String tempString) {
        if(tempString == null || "".equals(tempString)) {
             return "";
        }
        if("0".equals(tempString) || "0.00000000".equals(tempString)) { 
             return "0";
        }
        int initlen = tempString.length(); // 串的初始长度
        int finallen = initlen; // 串的最终长度
        int start = 0; // 串的开始位置
        int off = 0; // 串的偏移位置
        char[] val = new char[initlen];
        tempString.getChars(0, finallen, val, 0); // 保存原数据，用于判断字符
        while ((start < finallen) && (val[off + finallen - 1] == '0')) {
            finallen--;
        }
        return ((start > 0) || (finallen < initlen)) ? (tempString.substring(start, finallen).endsWith(".")?tempString.substring(start, finallen).replace(".", "") : tempString.substring(start, finallen)) 
                : (tempString.endsWith(".")?tempString.replace(".", "") : tempString);
     }

    
    @SuppressWarnings("unused")
    public static String getStringCellValue(Cell cell) {
        if(cell==null)
        {
            return "";
        }
        String strCell = "";
        switch (cell.getCellType()) {
        case HSSFCell.CELL_TYPE_STRING:
            strCell = cell.getStringCellValue();
            break;
        case HSSFCell.CELL_TYPE_NUMERIC:
            if (HSSFDateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式  
                SimpleDateFormat sdf = null;  
                if (cell.getCellStyle().getDataFormat() == HSSFDataFormat  
                        .getBuiltinFormat("h:mm")) {  
                    sdf = new SimpleDateFormat("HH:mm");  
                } else {// 日期  
                    sdf = new SimpleDateFormat("yyyy-MM-dd");  
                }  
                Date date = cell.getDateCellValue();  
                strCell = sdf.format(date);  
            } else if (cell.getCellStyle().getDataFormat() == 58) {  
                // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)  
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
                double value = cell.getNumericCellValue();  
                Date date = org.apache.poi.ss.usermodel.DateUtil  
                        .getJavaDate(value);  
                strCell = sdf.format(date);  
            } else {  
            	NumberFormat nf = NumberFormat.getInstance();
				nf.setGroupingUsed(false);// true时的格式：1,234,567,890
				strCell = nf.format(cell.getNumericCellValue());// 数值类型的数据为double，所以需要转换一下
//                double value = cell.getNumericCellValue();  
//                CellStyle style = cell.getCellStyle();  
//                DecimalFormat format = new DecimalFormat("0.0000000000");  
//                String temp = style.getDataFormatString();  
//                // 单元格设置成常规  
//                if (temp.equals("General")) {  
//                    format.applyPattern("#");  
//                }  
//                strCell = format.format(value);  
//                  strCell = Double.toString(cell.getNumericCellValue());  
            }  
            break;
        case HSSFCell.CELL_TYPE_BOOLEAN:
            strCell = String.valueOf(cell.getBooleanCellValue());
            break;
        case HSSFCell.CELL_TYPE_BLANK:
            strCell = "";
            break;
        default:
            strCell = "";
            break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        if (cell == null) {
            return "";
        }
        return strCell;
    }
}
