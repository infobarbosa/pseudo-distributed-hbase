#!/bin/bash

#hosts
cat hosts >> /etc/hosts
sed -i "s/127.0.1.1/#127.0.1.1/" /etc/hosts

useradd -m hadoop
echo "hadoop:hadoop" | chpasswd

su hadoop -c 'mkdir -p /home/hadoop/.ssh'
su hadoop -c 'ssh-keygen -t rsa -P '' -f /home/hadoop/.ssh/id_rsa'
su hadoop -c 'cat ~/.ssh/id_rsa.pub >> /home/hadoop/.ssh/authorized_keys'
chmod 0600 /home/hadoop/.ssh/*

locale-gen en_US.UTF-8
add-apt-repository ppa:openjdk-r/ppa
apt-get -y update && apt-get install -y openjdk-8-jdk scala net-tools

echo "export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/jre" >> /etc/profile
echo "export PATH=${JAVA_HOME}/bin:${PATH}" >> /etc/profile

#wget -qO- http://ftp.unicamp.br/pub/apache/hadoop/common/hadoop-3.2.0/hadoop-3.2.0.tar.gz | tar xvz -C /opt/
tar xzf hadoop-3.2.0.tar.gz
mv hadoop-3.2.0 /opt/hadoop
chown -R hadoop:hadoop /opt/hadoop

#wget -qO- https://www-us.apache.org/dist/hbase/stable/hbase-1.4.10-bin.tar.gz | tar xvz -C /opt/
tar xzf hbase-1.4.10-bin.tar.gz
mv hbase-1.4.10 /opt/hbase
chown -R hadoop:hadoop /opt/hbase

#variaveis de ambiente
echo "export HADOOP_HOME=/opt/hadoop" >> /etc/profile
echo "export HADOOP_CONF_DIR=/opt/hadoop/etc/hadoop" >> /etc/profile
echo "export HADOOP_MAPRED_HOME=/opt/hadoop" >> /etc/profile
echo "export LD_LIBRARY_PATH=/opt/hadoop/lib/native" >> /etc/profile
echo "export HBASE_HOME=/opt/hbase" >> /etc/profile
echo "export PATH=$PATH:/opt/hadoop/bin:/opt/hadoop/sbin:/opt/hbase/bin" >> /etc/profile

mv /home/vagrant/core-site.xml /opt/hadoop/etc/hadoop/
mv /home/vagrant/mapred-site.xml /opt/hadoop/etc/hadoop/
mv /home/vagrant/hdfs-site.xml /opt/hadoop/etc/hadoop/
mv /home/vagrant/yarn-site.xml /opt/hadoop/etc/hadoop/
mv /home/vagrant/hadoop-env.sh /opt/hadoop/etc/hadoop/
mv /home/vagrant/hbase-site.xml /opt/hbase/conf/
mv /home/vagrant/hbase-env.sh /opt/hbase/conf/

chown -R hadoop:hadoop /opt/hadoop/etc/hadoop/
chown -R hadoop:hadoop /opt/hbase/conf

#formatando o hdfs
su hadoop -c "/opt/hadoop/bin/hdfs namenode -format"

#configurando os systemd daemons
mv hadoop.service /etc/systemd/system/
mv yarn.service /etc/systemd/system/
mv hbase.service /etc/systemd/system/

chown hadoop:hadoop /etc/systemd/system/hadoop.service
chown hadoop:hadoop /etc/systemd/system/yarn.service
chown hadoop:hadoop /etc/systemd/system/hbase.service

systemctl enable hadoop.service
systemctl enable yarn.service
systemctl enable hbase.service

systemctl daemon-reload
systemctl start hadoop
systemctl start yarn
systemctl start hbase

