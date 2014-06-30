package com.student.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtils {
	public static void readExcel(String sourceFile) {
		Workbook wb = null;
		try {
			InputStream is = new FileInputStream(sourceFile);
			// 1.读取 Excel 数据表的第一步是创建 Workbook( 术语：工作薄 )，
			wb = Workbook.getWorkbook(is);

			// 2.一旦创建了 Workbook，我们就可以通过它来访问 Excel Sheet( 术语：工作表 )。
			// 获取第一张 Sheet 表
			Sheet sheet = wb.getSheet(0);

			// 3.我们既可能通过 Sheet 的名称来访问它，也可以通过下标来访问它。如果通过下标来访问的话，要注意的一点是下标从 0
			// 开始，就像数组一样。
			// 一旦得到了 Sheet，我们就可以通过它来访问 Excel Cell( 术语：单元格 )。
			// 获取第一行，第一列的值
			Cell c00 = sheet.getCell(0, 0);
			String strC00 = c00.getContents();

			// 获取第一行，第二列的值
			Cell c10 = sheet.getCell(1, 0);
			String strC10 = c10.getContents();

			System.out.println("Cell(0, 0)" + " value : " + strC00
					+ "; type : " + c00.getType());
			System.out.println("Cell(1, 0)" + " value : " + strC10
					+ "; type : " + c10.getType());

			// 循环Excel中所有的内容
			int rows = sheet.getRows();
			for (int i = 0; i < rows; i++) {
				Cell[] cell = sheet.getRow(i);
//				System.out.println("第" + (i + 1) + "行:");
				for (Cell curCell : cell) {
					System.out.print("       " + curCell.getContents());
				}
				i--;
				System.out.println();
			}
			
			// 1. int getNumberOfSheets()
			// 获得工作薄（Workbook）中工作表（Sheet）的个数
			int sheetCount = wb.getNumberOfSheets();
			System.out.println("sheetCount:" + sheetCount);

			// 2. Sheet[] getSheets()
			// 返回工作薄（Workbook）中工作表（Sheet）对象数组，示例：
			Sheet[] sheetArr = wb.getSheets();
			System.out.println("sheetArr:" + Arrays.toString(sheetArr));

			// 3. String getVersion()
			// 返回正在使用的 API 的版本号
			String apiVersion = wb.getVersion();
			System.out.println("apiVersion:" + apiVersion);

			// 4) int getColumns()
			// 获取 Sheet 表中所包含的总列数，示例：
			int rsColumns = sheet.getColumns();
			System.out.println("rsColumns:" + rsColumns);

			// 5) int getRows()
			// 获取 Sheet 表中所包含的总行数，示例：
			int rsRows = sheet.getRows();
			System.out.println("rsRows:" + rsRows);

			// 6) Cell[] getRow(dint row)
			// 获取某一行的所有单元格，返回的是单元格对象数组，示例子：
			Cell[] cell = sheet.getRow(0);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				// 操作完成时，关闭对象，释放占用的内存空间
				wb.close();
			}
		}

	}
}
