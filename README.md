# lc-automated-testing
The automated tests defined within this project are the review of critical flows plus tests of separate components of the components within the forms:
* Change Request
* Change Request Withdraw
* Deletion Resquet Withdraw
* Reentry Request 
* Registration Request
* Registration Request Withdraw

All the fields are testing with the ACCs defined on the USs
## Definition for the enviroments
On the project we are pointing to INTG:

Link: https://my-i.epo.org/user-area/mailbox-intg/

The enviroment was defined in the class **Locators** in our proyect. If you want to change the enviroment, you need to update the class.

## Regression Execution

We created I Jenkins job that allow to us to generate a Serenity report, in the job configuration, you will be able to:

* Define the tasks do you want to execute
* Define the email addresses that should receive the report, if needed
* Specify the frequency of the execution

To be able to do this, you neede to modify the Jenkins file for the job.

## Certificate for Execution

For the execution, we use two certificates that were added to the grid:

* User 99814
* User 99819

The physical certifications are available on this confluence page: 

Link: https://confluence-p.internal.epo.org/pages/viewpage.action?spaceKey=P21115&title=Test+UserId+Setup

Due to the limit on space on the grid, we use certificates that we don't have on our Confluence page as:

* User 99791
* User 99795

## Add Certificate to the Grid Procedure

Steps you need to follow:

* Export the certificate from Chrome in base64
* Change the extension of the original certificate .p12 to .pem 
* Contact **Yuliya Novikova** to add the certificate to the grid, and give to her both certifications .cer and .pem

### How can I transform from .p12 to .pem?

* Open the console of GitHub
* Go to the directory where the certificate is located
* Write the following command: ```openssl pkcs12 -in certificate.p12 -out certificate.pem -nodes```

## Change Data Entries in TC 

In every TC, you will have a table of values that can be changed.

Be aware that when you change a user on the table, the name needs to be the same as the one on the grid

## Important

The report execution is associated with a branch, so for the changes to be reflected in the report, they must be in the **report-update** branch.
