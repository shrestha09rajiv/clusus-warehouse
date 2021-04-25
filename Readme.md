#Clustered Warehouse

Clustered warehouse application reads the csv file uploaded by the user. After upload is successful it
validates the file format to verify whether the file is csv or not.<br/>
Application will save records containing valid data in database and returns messages that does not have valid data
with corresponding row number.

### Validations performed:

1. Blank data are checked for each row.
2. Only unique deals can be saved in the database.

### Technologies used:

1. Spring Boot
2. MySql
3. JPA
4. Spring data JPA
5. JUnit
6. Docker

## Deliverables

1. Working spring boot project
2. Docker file

 ### Github link
https://github.com/shrestha09rajiv/clusus-warehouse.git
