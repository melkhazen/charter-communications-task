# charter-communications-task

WebAPI Developer 
A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction.
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
·       Solve using Spring Boot
·       Create a RESTful endpoint
·       Make up a data set to best demonstrate your solution
·       Check solution into GitHub

======================================================================

the database is hosted on an AWS RDS instent, just download the solution and start it no need to add a DB.

To add a customer transaction:
POST: localhost:8080/customers/newTransaction
Body: {
    "customerName" : "jack",
    "transactionAmount" : "120"
}

++++++++++++++++++++++++++++++++++++++

To get a custemors rewards points:
GET: localhost:8080/customers/{id}

++++++++++++++++++++++++++++++++++++++

attached is a Postman file you can just import it: 'Charter Task.postman_collection.json'

========================================================================
