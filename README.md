# mamo-coding-challenge-keyboard
Implement keyboard according to video in Mamo coding challenge.

# Description
This is a simple keyboard application which displays the digits when they are pressed.
The fractional part stays grayed unless provided.
On app start, a hint of the currency and digits are displayed.
Finally, the digits are automatically formatted with commas in their thousands.
When the values are so long they go off the screen, scroll left to view the rightmost values.

This project uses Hilt for dependency injection and DataStore Preferences for persistence.
It uses Espresso for UI tests, JUnit 4 and Mockito for unit tests.

# Testing
There are three tests for this project. They are:
- An instrumentation test KeyboardActivity
- A unit test for KeyboardRepository and
- A unit test for KeyboardViewModel

