# Connection Points and Document Flows
## Author: Sudersona Basu
## Role: Integration & Release QA
## Date: 2025-06-23

# Infor LN
Purpose: If LN Application wants to send or receive some data using ION. Can be used as both Receiver and Sender
## Creation Steps:
Pre Req: Ensure you have an EC (Enterprise Connector) already created and in OK state. (You can create your own EC if not available.)
Using LN CP as Sender (SBasu_LN_SendDoc)
1.	Navigate to Connection Points and click on the “+ Add” button.
2.	From the available options, select “Infor LN”.
3.	Enter a unique name for the Connection Point. (Avoid using special characters.
4.	In the Location field, select the EC name from the dropdown list.
5.	Fill in the required details as per the details provided below.
Hostname: nlbalappsmnt6
Activation: baanlogin
Port Number: 7150
Username: ionqadev
Password: printer
BSE: /b61a/bse
Bshell: bshell
Company: 9940/9941(preferable)/9942

6.	Click on the “Test” button to verify the connection.
7.	Move to the Document tab and select the type of document you want to publish.
•	Note: When using the LN Connection Point as a sender, it supports only the Purchase Order document.
•	As a receiver, it supports any document type.
## How to create Document Flow
Assuming that using File CP as Receiver.
1.	In the Navigation Menu, click on the Connect dropdown and select Data Flows. Then, click on the “+ Add” button and choose “Document Flow” from the available options.
2.	 Enter a valid name for the Document Flow.
3.	For the Sender End, select the Application option, and for the Receiver End, select File.
4.	Under Application, add the Infor LN Connection Point (CP) you created earlier.
5.	Under Documents, add the document you want to transfer (in this case, sync.purchase).
6.	Under File, select the appropriate file Connection Point (CP).
7.	Activate the Document Flow.

## BOD Publishing:
Pre- Requisite: Open EC Grid installed in System and do tenant mapping i.e.., add Tenant mapping as Infor.
1.	Open the BOD Publish from LN link: https://lndev.infor.com:8446/lnui_ga/servlet/standalone?startupArgument=Maintenance , select the Default checkbox, and click START LN UI.
2.	Go to Options > Change Company, and set the Selected Company, Logistic Company, and Financial Company as 9940 / 9941 / 9942.
3.	Ensure the Package Combination is set to Icem01, then click OK.
4.	Click Common, expand BOD Messaging > Publish BODs, and select Publish Order Management Transactional Data.
5.	Under the PurchaseOrder tab, check the PurchaseOrder checkbox, then click the search icon next to From: Purchase Order.
6.	Select the document you want to publish and click OK.
7.	Go to the Options tab, set Mode to Publish, and under Settings, select Use Process/Sync Verb.
8.	Click Process, then OK, set the Device value to D, and click CONTINUE.
9.	Finally, check the status of the published BOD in the report to confirm if it is Published or Failed.
* Once the BOD is published successfully, it can also be verified under the Active Connection Points section.
## How to Monitor:
1.	Navigate and Open OneView
2.	Apply Filters:
•	Date & Time Range: Select Last Hour
•	Document Name: Enter sync.Purchase
3.	Click on Search
4.	Open the Document from the search results
5.	Verify the Document Details

