# java-mahasiswa-crud
is a program with the functions of adding, deleting, changing, displaying, and searching for student data.

## How to Run
java -jar fileLocationNameWithDependencies
> java -jar target/crud-mahasiswa-java-1.0-SNAPSHOT-jar-with-dependencies.jar


### Program Requirements
#### 1. Java 16
Some syntax need newest java version like text block.
#### 2. MySQL
You need to install MySQL or MariaDB for database. You must create database named 'crud_mahasiswa_java' and table 'mahasiswa' to run the program, table code is used as follows :

```bash
CREATE TABLE mahasiswa (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  nim varchar(14) NOT NULL,
  email varchar(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY nim_unique (nim),
  UNIQUE KEY email_unique (email)
) ENGINE=InnoDB;
```

You can change all name of table, database or setting about database at util/DatabaseUtil.java file.
