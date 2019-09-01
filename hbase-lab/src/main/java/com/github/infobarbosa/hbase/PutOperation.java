package com.github.infobarbosa.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class PutOperation{
    /**
     * Desafio: Inserir dados na tabela clientes.
     * Critérios:
     *  1. Inserir 3 clientes:
     *      - RG:123, NOME:Marcelo Barbosa, LOGRADOURO:rua abc, NUMERO:1, BAIRRO:XPTO, CIDADE:SAO PAULO, UF:SP, CEP:11111-000, TELEFONE:11-99999999, EMAIL:marcelo@mymail.com;
     *      - RG:456, NOME:John Doe, LOGRADOURO:rua xyz, NUMERO:2, BAIRRO:XPTO, CIDADE:SAO PAULO, UF:SP, CEP:22222-000, TELEFONE:11-99999999, EMAIL:john@mymail.com;
     *      - RG:789, NOME:Felonious Gru, LOGRADOURO:rua abc, NUMERO:3, BAIRRO:XPTO, CIDADE:SAO PAULO, UF:SP, CEP:33333-000, TELEFONE:11-99999999, EMAIL:gru@mymail.com.
     *  2. A inserção deve obedecer a seguinte distribuição nas column families:
     *      - ROWKEY: RG;
     *      - cliente: NOME;
     *      - endereco: LOGRADOURO, NUMERO, BAIRRO, CIDADE, UF, CEP;
     *      - contato: TELEFONE, EMAIL.
     * 
     * Passo a passo:
     * 1. Criar um objeto Configuration a partir de HBaseConfiguration;
     * 2. Criar um objeto Connection utilizanto um ConnectionFactory e o configuration do passo 1;
     * 3. Obter um objeto Table a partir da conexao do passo 2;
     * 4. Criar um objeto Put referenciando a rowkey desejada;
     * 5. Utilizando o método addColumn(column family, célula, valor) adicionar as célular para cada dado informado nos critérios acima;
     *      - Atentar que o metodo addColumn(...) recebe os parametros no formato de array de bytes.
     * 6. Executar a inserção na tabela passando o objeto put para o método put() do objeto Table criado no passo 3.
     */

    public static void main(String[] args) throws IOException{
        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        Table clientes = connection.getTable( TableName.valueOf("clientes") );

        Put put = new Put(Bytes.toBytes("123"));
        put.addColumn(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"), Bytes.toBytes("Marcelo Barbosa"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("LOGRADOURO"), Bytes.toBytes("rua abc"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("NUMERO"), Bytes.toBytes("1"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("BAIRRO"), Bytes.toBytes("XPTO"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("CIDADE"), Bytes.toBytes("SAO PAULO"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("UF"), Bytes.toBytes("SP"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("CEP"), Bytes.toBytes("11111-000"));
        put.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("TELEFONE"), Bytes.toBytes("11-99999999"));
        put.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("EMAIL"), Bytes.toBytes("marcelo@mymail.com"));
        clientes.put(put);

        put = new Put(Bytes.toBytes("456"));
        put.addColumn(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"), Bytes.toBytes("John Doe"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("LOGRADOURO"), Bytes.toBytes("rua xyz"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("NUMERO"), Bytes.toBytes("2"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("BAIRRO"), Bytes.toBytes("XPTO"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("CIDADE"), Bytes.toBytes("SAO PAULO"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("UF"), Bytes.toBytes("SP"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("CEP"), Bytes.toBytes("22222-000"));
        put.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("TELEFONE"), Bytes.toBytes("11-99999999"));
        put.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("EMAIL"), Bytes.toBytes("john@mymail.com"));
        clientes.put(put);

        put = new Put(Bytes.toBytes("789"));
        put.addColumn(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"), Bytes.toBytes("Felonious Gru"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("LOGRADOURO"), Bytes.toBytes("rua abc"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("NUMERO"), Bytes.toBytes("3"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("BAIRRO"), Bytes.toBytes("XPTO"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("CIDADE"), Bytes.toBytes("SAO PAULO"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("UF"), Bytes.toBytes("SP"));
        put.addColumn(Bytes.toBytes("endereco"), Bytes.toBytes("CEP"), Bytes.toBytes("33333-000"));
        put.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("TELEFONE"), Bytes.toBytes("11-99999999"));
        put.addColumn(Bytes.toBytes("contato"), Bytes.toBytes("EMAIL"), Bytes.toBytes("gru@mymail.com"));
        clientes.put(put);
    }
}