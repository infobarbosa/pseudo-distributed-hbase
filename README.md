# pseudo-distributed-hbase

```
git clone https://github.com/infobarbosa/pseudo-distributed-hbase
cd pseudo-distributed-hbase
vagrant up

vagrant ssh

cd /vagrant/hbase-lab

mvn clean package

java -cp target/hbase-lab-1.0-SNAPSHOT-jar-with-dependencies.jar com.github.infobarbosa.hbase.CreateTable

hbase shell
list 'clientes'
describe 'clientes'
quit

java -cp target/hbase-lab-1.0-SNAPSHOT-jar-with-dependencies.jar com.github.infobarbosa.hbase.PutOperation

hbase shell
scan 'clientes'
quit

java -cp target/hbase-lab-1.0-SNAPSHOT-jar-with-dependencies.jar com.github.infobarbosa.hbase.DeleteTable

hbase shell
list 'clientes'
describe 'clientes'
quit

```