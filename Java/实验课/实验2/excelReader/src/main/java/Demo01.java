/*java读取Excel文件*/
/*
 * 思路：使用apache公司提供的Poi包可以对Microsoft Office格式的文档实现读写功能；
 * Poi包封装了XSSFWorkbook（工作簿）、XSSFSheet（工作表）、Row（行）、Cell（单元格）四个对象，使得Excel表格和Poi中对象一一对应；
 *
 * 基本步骤：1.创建工作簿
 *         2.获取工作表
 *         3.遍历工作表获得行对象
 *         4.遍历行对象那获取单元格对象
 *         5.获取单元格中的值
 *
 * 遇到的问题: 1.将下载好的Poi包导入到当前项目花费了一些时间。
 *           2.一个项目的框架比较复杂，不知道有些文件的作用，误删了会影响程序运行。将多个源文件放在一起时发生错误。
 * */

//导入所需的Poi包

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        //获取工作簿，根据准备好的Excel文件路径创建一个工作簿对象
        XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\27142\\Desktop\\编程之路\\Java\\实验课\\实验2\\excelReader\\src\\test\\java\\test.xlsx");
        //获取工作表，索引从0开始，即从表中的第一个元素开始索引
        XSSFSheet sheet = workbook.getSheetAt(0);
        //1.通过遍历的方式来获取工作表中的每一行
        for (Row row : sheet) {
            for (Cell cell : row) {
                //通过遍历的方式来获取每一行中的每一个单元格
                String value = cell.getStringCellValue();
                //打印每个单元格
                System.out.println(value);
            }
        }

        //2.通过索引的方式来获取每个单元格
        System.out.println();
        int lastRowNum = sheet.getLastRowNum(); //获取最后一行的索引

        for (int i = 0; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                //当每一行不为空，获取每个单元格
                short cellNum = row.getLastCellNum();
                for (int j = 0; j <= cellNum; j++) {
                    XSSFCell cell = row.getCell(j);

                    if (cell != null) {
                        //单元格不为空，打印其值
                        String stringCellValue = cell.getStringCellValue();
                        System.out.println(stringCellValue);
                    }
                }
            }
        }
        //释放资源
        workbook.close();
    }
}