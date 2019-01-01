DONE:
- The code is implemented following POM design.
- 3 functions of Demo Banking system are done:
	+ Verifying new customer can be created.
	+ Verifying create new account based on the customer just created above.
	+ Verifying deposit function work fine with the account just created.
Pre-conditions:
- System requirements:
	+ selenium server standalone 3.6.0
	+ gecko driver 0.19.0
	+ Junit 4
- Initialize testing:
	+ Customer name and email should be unique.
	+ Email should be defined with correct format.
	+ Init amount should be from 10000
	+ Gecko driver path, user/password to login are defined in project.properties file.
	+ User need to run all test cases to create data for testing because the demo page does not store the data.


