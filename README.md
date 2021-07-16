# mamo-coding-challenge-keyboard
Implement keyboard according to video in Mamo coding challenge.

# Description
This is a simple keyboard application which displays the digits when they are pressed.
The fractional part stays grayed unless provided.
On app start, a hint of the currency and digits are displayed.
Finally, the digits are automatically formatted with commas in their thousands.

# Testing
To run the tests, execute the following in your terminal: 

`$ adb shell am instrument -w -m -e debug false -e class 'com.gafful.mamo.keyboard.KeyboardActivityTest' com.gafful.mamo.keyboard.test/androidx.test.runner.AndroidJUnitRunner`

Or run them from Android Studio.
