package org.springblade.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Method: 数据库表结构word导出
 * @Description: 数据库表结构word导出
 * @Auter: Mollen
 * @Date: 2019/12/18  9:20
 * @return
 **/
public class ReportToWordUtil {

//    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://120.26.10.57:3306/culture_sea?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true";
    private final String USER_NAME = "culture_sea";
    private final String PASS_WORD = "vmA3CC16SVPH7zQE";
    private final String database = "culture_sea";
    private final String reportPath = "/Users/xiaoqi/Desktop/";

    // 启动方法
    public static void main(String[] args) {

        try {
            ReportToWordUtil rd = new ReportToWordUtil();
            rd.report();
        }catch (Exception e){
            System.out.println("异常：自行处理或者联系我都阔以.");
            e.printStackTrace();
        }

    }


    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // 获取查询数据
    public Map<String,List<TableColumn>> getData() throws Exception{

        System.out.println("数据生成中，请稍等...");
        Map<String,List<TableColumn>> map = new HashMap<>();

        List<Table> tables = getTables(database);

        for (Table table : tables) {
            if(table.getTableName().contains("copy") || table.getTableName().contains("2022") || table.getTableName().contains("zwl")){
                continue;
            }
            List<TableColumn> columns = getColumns(database,table.getTableName());
            map.put(table.getTableName(),columns);
        }

        return map;

    }


    // 获取表字段信息
    public List<TableColumn>  getColumns(String database,String tableName) throws Exception{

        String sql = "select column_name,column_comment,column_type,is_nullable, column_key from information_schema.columns  where  table_schema=? and table_name=?  group by column_name";
        ResultSet rs = getConn(database,tableName,sql);

        List<TableColumn> tableColumns = new ArrayList<>();

        while (rs.next()){

            TableColumn tc = new TableColumn();
            tc.setTableName(tableName);
            tc.setColumnName(rs.getString("column_name"));
            tc.setColumnType(rs.getString("column_type"));
            tc.setColumnKey(rs.getString("column_key"));
            tc.setIsNullable(rs.getString("is_nullable"));
            tc.setColumnComment(rs.getString("column_comment"));
            tableColumns.add(tc);

        }

        releaseConn();

        return tableColumns;

    }


    // 获取所有表
    public List<Table> getTables(String database) throws Exception{

        String  sql = "select table_name,table_comment from information_schema.tables where table_schema=?";
        ResultSet rs = getConn(database, "",sql);

        List<Table> tables = new ArrayList<>();
        while(rs.next()){
            Table table = new Table();
            table.setTableName(rs.getString( "table_name"));
            table.setTableCommont(rs.getString("table_comment"));
            tables.add(table);
        }

        releaseConn();
        return  tables;

    }

    // 连接数据库
    private ResultSet getConn(String dataBase,String tableName,String sql){

        try{

            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
            pst = conn.prepareStatement(sql);
            pst.setString(1,dataBase);
            if(!"".equals(tableName)){
                pst.setString(2,tableName);
            }
            rs = pst.executeQuery();
            return  rs;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    // 释放连接
    private void  releaseConn(){
        try{
            if(rs != null ){
                rs.close();
            }
            if(pst != null){
                pst.close();
            }
            if(conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    // 导出数据
    public void report()  throws  Exception{

        Map<String, List<TableColumn>> data = this.getData();       // 表名：表体
        List<Table> tables = this.getTables(this.database);         // 表体(列名、类型、注释)
        Map<String,String> tableMap = new HashMap<>();              // 表名:中文名

        JSONObject json = new JSONObject((HashMap)data);

        for (Table table : tables) {
            tableMap.put(table.getTableName(),table.getTableCommont());
        }

        // 构建表格数据
        XWPFDocument document = new XWPFDocument();

        Integer i = 1;
        for (String tableName : data.keySet()) {

            XWPFParagraph paragraph = document.createParagraph();                // 创建标题对象
            XWPFRun run = paragraph.createRun();                                 // 创建文本对象
            run.setText((i+"、"+tableName+"    "+tableMap.get(tableName)));      // 标题名称
            run.setFontSize(14);                                                 // 字体大小
            run.setBold(true);                                                   // 字体加粗

            int j = 0;
            XWPFTable table = document.createTable(data.get(tableName).size()+1,5);
            // 第一行
            table.setCellMargins(10,50,10,200);
            table.getRow(j).getCell(0).setText("字段名称");
            table.getRow(j).getCell(1).setText("字段类型");
            table.getRow(j).getCell(2).setText("约束");
            table.getRow(j).getCell(3).setText("为空");
            table.getRow(j).getCell(4).setText("字段含义");
            j++;

            for (TableColumn tableColumn : data.get(tableName)) {

                table.getRow(j).getCell(0).setText(tableColumn.getColumnName());
                table.getRow(j).getCell(1).setText(tableColumn.getColumnType());
                table.getRow(j).getCell(2).setText(tableColumn.getColumnKey());
                table.getRow(j).getCell(3).setText(tableColumn.getIsNullable());
                table.getRow(j).getCell(4).setText(tableColumn.getColumnComment());
                j++;

            }
            i++;
        }

        // 文档输出
        FileOutputStream out = new FileOutputStream(reportPath + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString()+"_"+database +".docx");
        document.write(out);
        out.close();
        System.out.println("Word生成完成!!!");

    }

    // 表
   class Table{

       private String tableName;

       private String tableCommont;

       public String getTableName() {
           return tableName;
       }

       public void setTableName(String tableName) {
           this.tableName = tableName;
       }

       public String getTableCommont() {
           return tableCommont;
       }

       public void setTableCommont(String tableCommont) {
           this.tableCommont = tableCommont;
       }

   }

   // 表列信息
   class TableColumn{
       // 表名
       private String tableName;
       // 字段名
       private String columnName;
       // 字段类型
       private String columnType;
       // 字段注释
       private String columnComment;
       // 可否为空
       private String isNullable;
       // 约束
       private String columnKey;

       public String getTableName() {
           return tableName;
       }

       public void setTableName(String tableName) {
           this.tableName = tableName;
       }

       public String getColumnName() {
           return columnName;
       }

       public void setColumnName(String columnName) {
           this.columnName = columnName;
       }

       public String getColumnType() {
           return columnType;
       }

       public void setColumnType(String columnType) {
           this.columnType = columnType;
       }

       public String getColumnComment() {
           return columnComment;
       }

       public void setColumnComment(String columnComment) {
           this.columnComment = columnComment;
       }

       public String getIsNullable() {
           return isNullable;
       }

       public void setIsNullable(String isNullable) {
           this.isNullable = isNullable;
       }

       public String getColumnKey() {
           return columnKey;
       }

       public void setColumnKey(String columnKey) {
           this.columnKey = columnKey;
       }

   }


}




