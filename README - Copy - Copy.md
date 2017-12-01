From: Saif Ur Rehman (Saifurrehman21@GitHub.com)
Date: Friday, December 01, 2017 11:20 pm

OK, I hacked out an ADOdb container for PEAR-Auth. The error handling's 
a bit of a mess, but all the methods work.

Copy ADOdb.php to your pear/Auth/Container/ directory.

Use the ADOdb container exactly as you would the DB
container, but specify 'ADOdb' instead of 'DB':


---------------------------------------------------------------------------------------------------------------

For mysql:
Connection_Link = "jdbc:mysql://localhost/School"
	UserName="root"
	Password=""


---------------------------------------------------------------------------------------------------------------

John Lim adds:

See http://pear.php.net/manual/en/package.authentication.php
