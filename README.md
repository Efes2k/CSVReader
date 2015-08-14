# CSVReader

**Description:**
- Valid extensions: text/csv, application/vnd.ms-excel, application/csv.(For example: temp.csv )
- Additional extensions you can add to mimeType.properties.
- Database setting are in the file database.properties.
- Data entered in the format: login, name, surname, email, phoneNumber
- separators: "." and ";"
- Update entries occur when matching field login.
- Deploying on Tomcat 7.0 .

**Working with application in Eclipse/STS.**

The following items should be installed in your system:
- Maven 3 (https://www.sonatype.com/books/mvnref-book/reference/installation.html)
- Git command line tool (https://help.github.com/articles/set-up-git)
- Eclipse with the m2e plugin (m2e is installed by default when using the STS 
       (http://www.springsource.org/sts) distribution of Eclipse)


1) In the command line

    git clone https://github.com/Efes2k/CSVReader.git

2) Inside Eclipse

    File -> Import -> Maven -> Existing Maven project
    
3) Execute script 

    contacts.sql
