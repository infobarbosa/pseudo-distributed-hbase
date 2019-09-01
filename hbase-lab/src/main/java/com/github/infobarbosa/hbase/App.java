package com.github.infobarbosa.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Configuration conf = HBaseConfiguration.create();

            Connection connection = ConnectionFactory.createConnection(conf);
    
            Admin admin = connection.getAdmin();
    
            HTableDescriptor tableName = new HTableDescriptor(TableName.valueOf("notifications"));
    
            tableName.addFamily(new HColumnDescriptor("attributes"));
            tableName.addFamily(new HColumnDescriptor("metrics"));
    
    
            if (!admin.tableExists(tableName.getTableName())) {
                System.out.print("Creating table. ");
                admin.createTable(tableName);
                System.out.println(" Done.");
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
