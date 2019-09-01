package com.github.infobarbosa.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

public class DeleteTable{
    /**
     * Desafio: Eliminar a tabela criada para cadastro de clientes.
     * 
     * Passo a passo:
     * 1. Criar um objeto Configuration a partir de HBaseConfiguration;
     * 2. Criar um objeto Connection utilizanto um ConnectionFactory e o configuration do passo 1;
     * 3. Obter um objeto Admin a partir da conexao do passo 2;
     * 4. Criar um objeto HTableDescriptor referenciando o nome da tabela;
     * 5. Desabilitar a tabela por meio do método disableTable do objeto Admin;
     * 6. Eliminar a tabela por meio do comando deleteTable do objeto Admin.
     * 
     * Antes de eliminar efetivamente a tabela, testar se a mesma existe atraves do comando tableExists do objeto Admin.*/    
    public static void main(String[] args) throws IOException{
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        Admin admin = connection.getAdmin();
        HTableDescriptor clientes = new HTableDescriptor( TableName.valueOf("clientes") );

        if( admin.tableExists( clientes.getTableName() )){
            admin.disableTable(clientes.getTableName());
            admin.deleteTable(clientes.getTableName());
        }
    }
}