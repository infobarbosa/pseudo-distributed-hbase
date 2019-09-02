# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  #configuracao da instancia do node master
  config.vm.define "hbase" do |hbase|
    hbase.vm.box = "ubuntu/bionic64"

    hbase.vm.network "private_network", ip: "192.168.56.40"
    hbase.vm.hostname = "hbase.infobarbosa.github.com"
    hbase.vm.provider "virtualbox" do |v|
      v.memory = 2500
      v.cpus = 4
      v.name = "pseudo-distributed-lab-hbase.vagrant"
    end

    #systemd
    hbase.vm.provision "file", source: "config-files/hadoop.service", destination: "hadoop.service"
    hbase.vm.provision "file", source: "config-files/yarn.service", destination: "yarn.service"
    hbase.vm.provision "file", source: "config-files/hbase.service", destination: "hbase.service"
    
    #configs
    hbase.vm.provision "file", source: "config-files/core-site.xml", destination: "core-site.xml"
    hbase.vm.provision "file", source: "config-files/hdfs-site.xml", destination: "hdfs-site.xml"
    hbase.vm.provision "file", source: "config-files/yarn-site.xml", destination: "yarn-site.xml"
    hbase.vm.provision "file", source: "config-files/mapred-site.xml", destination: "mapred-site.xml"
    hbase.vm.provision "file", source: "config-files/hbase-site.xml", destination: "hbase-site.xml"

    #environment scripts
    hbase.vm.provision "file", source: "config-files/hadoop-env.sh", destination: "hadoop-env.sh"
    hbase.vm.provision "file", source: "config-files/hbase-env.sh", destination: "hbase-env.sh"
    
    #packages
    hbase.vm.provision "file", source: "packages/hadoop-3.2.0.tar.gz", destination: "hadoop-3.2.0.tar.gz"
    hbase.vm.provision "file", source: "packages/hbase-1.4.10-bin.tar.gz", destination: "hbase-1.4.10-bin.tar.gz"

    #root script
    hbase.vm.provision "shell", path: "script.sh"

  end

end
