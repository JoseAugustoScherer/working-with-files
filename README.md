# Working with files
Reading data from a .csv file and storing it in a new file and folders, created dynamically.

Write a program to read the path of a _.csv_ file containing data on sold items. Each item has a name, unit price, and quantity, separated by commas. You must generate a new file called _summary.csv_, located in a subfolder named _**out**_ within the original source file’s folder, containing only the item name and the total value for that item (unit price multiplied by quantity), as shown in the example.

## Exemple

Source file

- TV LED,1290.99,1
- Video Game Chair,350.50,3
- Iphone X,900.00,2
- Samsung Galaxy 9,850.00,2

summary.csv

- TV LED,1290.99
- Video Game Chair,1051.50
- Iphone X,1800.00
- Samsung Galaxy 9,1700.00
