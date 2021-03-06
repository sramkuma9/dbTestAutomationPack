## This feature is dependant on create regional events
#Feature: Event Registration for a member
#
#  Scenario: To register for a member
#    Given BNI Home page entered with below login details
#      | UserName                | Password     | country         | region        | chapter        |
#      | shanthibni+32@gmail.com | aadhira@2014 | Australia - BNI | BNI- Adelaide | Adelaide North |
#      | shanthibni+32@gmail.com | aadhira@2014 | Australia - BNI | BNI- Adelaide | Adelaide North |
#    When Click My Network link in the home page, under Events select an event, click Register Me. On Register event page enter payment option click submit button
#      | eventName      |  | role   |  | paymentOption                      |
#      | TestAutomation |  | Member |  | Collected at Venue (if applicable) |
#      | Automation     |  | Member |  | Cash collected at venue |
#    Then Verify Email is received in registered Email account