@Login
Feature: As an accounts user I should able to login and logout with valid credentials

  @Smoke @Regression @skip
  Scenario Outline: Login into the application with valid credentials
    Given user is on Phoenix Login page and logs in with "<PhoneNumber>"
    Then I click on Login button
    Then I should see OTP Page and verify the Title as "<Title>"
    And I should verify the text message as An OTP has been sent to "<PhoneNumber>". Please enter here.
    When I enter OTP as "<OTP>"
    Then I should see Home Page with "<name>"
    And I click on Logout button
    Then I got log out from the application and land on Login page

    Examples:
      | PhoneNumber | | Title| |OTP| |name|
      | 7908071774  | |Infra Market||123456| |Piyal Bhunia|

  @Regression
  Scenario Outline: Login into the application with invalid credentials
    Given user is on Phoenix Login page and logs in with different "<PhoneNumber>"
    Then I click on Login button
    Then I should see error message as "You are not registered with us. Please Sign up using Mobile App."

    Examples:
      |PhoneNumber|
      |7777888813|
      |3334445567|

  @Regression
  Scenario Outline: Login into the application with incomplete number
    Given user is on Phoenix Login page and logs in with different "<InvalidNumber>"
    Then I click on Login button
    Then I should see  an error message of "Please provide a valid Phone Number"

    Examples:
      |InvalidNumber|
      |675|
      |112334|



