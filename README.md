# chiron

    create database mydb default character set utf8 collate utf8_bin;
    grant all on mydb.* to 'cloud'@'%' identified by 'passwd' with grant option;
    or
    CREATE USER 'cloud'@'%' IDENTIFIED BY 'passwd';
    grant all on mydb.* to 'cloud'@'%' with grant option;
    flush privileges;
    mysql mydb < mydb.sql