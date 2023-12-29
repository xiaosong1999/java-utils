package com.jerry.tools.utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Iterator;

/**
 * description: ExcelUtils
 * date: 2023-12-29 16:22
 * author: Jerry
 * version: 1.0
 */
public class ExcelUtils {
	/**** 
	 * @description: sheet复制
	 * @param: sourceSheet
	 * @param: targetSheet
	 * @return: void
	 * @author Jerry
	 * @date: 2023-12-26 15:50
	 */
	public static void mergeSheet(Sheet sourceSheet, Sheet targetSheet) {
		Iterator<Row> rowIterator = sourceSheet.iterator();
		while (rowIterator.hasNext()) {
			Row sourceRow = rowIterator.next();
			Row newRow = targetSheet.createRow(sourceRow.getRowNum());
			Iterator<Cell> cellIterator = sourceRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell sourceCell = cellIterator.next();
				Cell newCell = newRow.createCell(sourceCell.getColumnIndex(), sourceCell.getCellType());
				// getCellType在旧版叫getCellTypeEnum
				switch (sourceCell.getCellType()) {
					case STRING:
						newCell.setCellValue(sourceCell.getStringCellValue());
						break;
					case NUMERIC:
						newCell.setCellValue(sourceCell.getNumericCellValue());
						break;
					case BOOLEAN:
						newCell.setCellValue(sourceCell.getBooleanCellValue());
						break;
					case BLANK:
						newCell.setCellValue("");
						break;
					default:
						// 处理其他类型的cell，根据需要进行调整
						break;
				}
			}
		}
	}
}
