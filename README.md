# Codecool Online Shop

Java SE: Web Project skeleton

# Install

Import this project to IntelliJ as a Maven project.
IntelliJ can auto-install the dependencies based on the pom.xml

# Connection properties

There is a file in the repo called 'connection.properties.template', please copy it into the 'webapp' directory as 'connection.properties'.
Fill the template out with your user and password name that you use for creating the database. 

The 'database' property of this 'connection.properties' file should be a string that JDBC would accept as a PostgreSQL connection URL.

#Init database

To reach the products from the database on the website, you should initialise the database by running the files under path: 
src/main/sql/*

# Running

To run the application, type 'mvn jetty:run' to the terminal.
