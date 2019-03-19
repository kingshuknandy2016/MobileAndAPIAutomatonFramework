Feature: Order Details

Scenario: Successful Login with Valid Credentials
	Given Get order details
	Then verify response code "200"
