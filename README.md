Stock Data Intelligence Dashboard
Overview
This project is a mini financial data platform built as part of the Internship Assessment for Jarnox.
It demonstrates the ability to collect, process, and analyze stock market data and expose useful insights through REST APIs.
The backend is built using Java Spring Boot and MySQL, and it provides APIs to retrieve stock data, summaries, and compare performance between companies.
________________________________________
Tech Stack
Language: Java
Framework: Spring Boot
Database: MySQL
ORM: Spring Data JPA / Hibernate
Build Tool: Maven
API Testing: Postman
________________________________________
Project Features
Store company information
Store daily stock market data
Automatically calculate Daily Return
Fetch last 30 days stock data
Generate stock summary
Compare performance between two companies
________________________________________
Database Design
Companies Table
Field	Type
id	Long
symbol	String
companyName	String
StockData Table
Field	Type
id	Long
date	LocalDate
openPrice	double
closePrice	double
highPrice	double
lowPrice	double
volume	long
dailyReturn	double
company	ManyToOne
________________________________________
Daily Return Formula
Daily return is calculated automatically using:
Daily Return = (Close Price - Open Price) / Open Price
________________________________________
API Endpoints
Companies APIs
Method	Endpoint	Description
POST	/companies/createCompany	Create new company
GET	/companies	Get all companies
________________________________________
Stock Data APIs
Method	Endpoint	Description
POST	/addStockData/{id}	Add stock data for company
GET	/data/{symbol}	Get last 30 days stock data
GET	/summary/{symbol}	Get 52-week high, low and average close
GET	/compare?symbol1=&symbol2=	Compare two stocks
________________________________________
Example Request
Create Company
POST /companies/createCompany
Request Body:
{
"symbol": "INFY",
"companyName": "Infosys"
}
________________________________________
Add Stock Data
POST /addStockData/1
Request Body:
{
"date": "2025-04-01",
"openPrice": 1500,
"closePrice": 1520,
"highPrice": 1530,
"lowPrice": 1490,
"volume": 200000
}
________________________________________
Running the Project
Clone the repository
git clone https://github.com/yourusername/stock-data-dashboard.git
Open the project in Eclipse / IntelliJ
Configure database in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/stockdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Run the Spring Boot application
Test APIs using Postman
________________________________________
Possible Future Improvements
Add stock data collection from external APIs
Implement 7-day moving average
Add visualization dashboard using React or Chart.js
Deploy the application on cloud platforms
________________________________________
Author
Md Anas
Java Full Stack Developer
GitHub: https://github.com/mdanasec

