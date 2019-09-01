package com.github.infobarbosa.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class PutOperationChalenge{
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
        // Configuration conf = ...
        // Connection connection = ...
        // Table clientes = connection.getTable( ... );

        // Put put = new Put(Bytes.toBytes("123"));
        // put.addColumn(Bytes.toBytes("cliente"), Bytes.toBytes("NOME"), Bytes.toBytes("Marcelo Barbosa"));
        // ...
        // clientes.put(put);
    }
}