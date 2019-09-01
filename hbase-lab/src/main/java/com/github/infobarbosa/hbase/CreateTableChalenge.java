package com.github.infobarbosa.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.HColumnDescriptor;

public class CreateTableChalenge 
{
    /**
     * Desafio: Criar uma tabela para cadastro de clientes.
     * Critérios:
     *  1. A tabela deve se chamar clientes;
     *  2. A tabela deve ter três column families:
     *      2a. cliente - representando os dados gerais do cliente como nome, cpf, rg;
     *      2b. endereco - representando os dados de endereco como logradouro, numero, complemento;
     *      2c. contato - representando os dados de contato como email e telefone
     * 
     * Passo a passo:
     * 1. Criar um objeto Configuration a partir de HBaseConfiguration;
     * 2. Criar um objeto Connection utilizanto um ConnectionFactory e o configuration do passo 1;
     * 3. Obter um objeto Admin a partir da conexao do passo 2;
     * 4. Criar um objeto HTableDescriptor referenciando o nome da tabela;
     * 5. Adicionar as column families designadas no exercicio por meio do comando addFamily e instanciando objetos do tipo HColumnDescriptor;
     * 6. Executar a criacao da tabela por meio do comando createTable do objeto Admin.
     * 
     * Antes de criar efetivamente a tabela, testar se a mesma existe atraves do comando tableExists do objeto Admin.*/
    public static void main( String[] args ) throws IOException
    {
        //Configuration config = ...
        //Connection connection = ...
        
        //Admin admin = ...
        //HTableDescriptor clientes = ...

        //clientes.addFamily( ... );
        
        //if( !admin.tableExists( clientes.getTableName() )){
            //admin. ...( ... );
        //}
    }
}
