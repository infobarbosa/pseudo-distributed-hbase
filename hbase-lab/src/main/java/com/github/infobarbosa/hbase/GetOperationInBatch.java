package com.github.infobarbosa.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class GetOperationInBatch{
    /**
     * Desafio: Obter dados na tabela clientes.
     * Critérios:
     *  1. Rowkeys 123, 456 e 789
     *      - Atributos: NOME e EMAIL
     * 
     * Passo a passo:
     * 1. Criar um objeto Configuration a partir de HBaseConfiguration;
     * 2. Criar um objeto Connection utilizanto um ConnectionFactory e o configuration do passo 1;
     * 3. Obter um objeto Table a partir da conexao do passo 2;
     * 4. Criar um objeto Get referenciando a rowkey desejada;
     *      - Atentar para o parametro do construtor que deve ser em bytes.
     * 5. Utilizando o método addColumn(column family, célula, valor) adicionar as célular para cada dado informado nos critérios acima;
     *      - Atentar que o metodo addColumn(...) recebe os parametros no formato de array de bytes.
     *      - Executar este passo para cada Rowkey que se pretende recuperar.
     * 6. Criar uma lista do tipo Get (List<Get>) e adicionar os objetos Get criados no passo 5.
     * 6. Executar a instrução passando a lista do tipo Get para o método get() do objeto Table criado no passo 3.
     *      - O retorno do método get() é um array do Result.
     * 7. Obter os atributos desejados a partir do objeto Result.
     *      - Imprimir no console os atributos obtidos.
     */

    public static void main(String[] args) throws IOException{
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        Table clientes = connection.getTable(TableName.valueOf("clientes"));
        
        List<Get> gets = new ArrayList<Get>();
        Get get123 = new Get(Bytes.toBytes("123"));
        get123.addColumn(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"));
        get123.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("EMAIL"));
        gets.add(get123);

        Get get456 = new Get(Bytes.toBytes("456"));
        get456.addColumn(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"));
        get456.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("EMAIL"));
        gets.add(get456);

        Get get789 = new Get(Bytes.toBytes("789"));
        get789.addColumn(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"));
        get789.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("EMAIL"));
        gets.add(get789);

        Result[] results = clientes.get(gets);
        
        for(Result result: results){
            byte[] nome = result.getValue(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"));
            byte[] email = result.getValue(Bytes.toBytes("contato"), Bytes.toBytes("EMAIL"));

            System.out.println("Nome: " + Bytes.toString(nome) + ", e-mail: " + Bytes.toString(email));
        }
    }
}