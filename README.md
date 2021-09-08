# invoiceApp
### This project is a simple application which allows to create and get invoices from stripe
## Requirements
- jdk 11
## How to run
	
## IDE
	* open folder as project
	* select correct jdk
	* go to InvoiceAppApplication
	* Click Run 'InvoiceAppApplication'

## How to use
1. POST local customer: localhost:8080/customer - body - // for later usage
{
    "name":"example",
    "email":"example",
    "phone":"example"
}
2. GET local customer: localhost:8080/customer
3. POST customer for stripe invoice: localhost:8080/api/invoice/addCustomer/{id} - "id" of local customer added previous
4. GET stripe customers: localhost:8080/api/invoice/customers
5. POST stripe invoice: localhost:8080/api/invoice/addInvoice?customerId=cus_example&amount=100 - with example params
6. GET stripe invoices: localhost:8080/api/invoice/invoices

## Author
#### Patryk Okrój
