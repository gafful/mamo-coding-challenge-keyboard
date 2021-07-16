# mamo-coding-challenge-keyboard
Implement keyboard according to video in Mamo coding challenge.

# Description
This app is a simple keyboard application which displays the digits when they are pressed.
The fractional part stays grayed unless provided.
On app start, a hint of the currency and digits are displayed.
Finally, the digits are automatically formatted with commas in their thousands.

Architecture - in case turned into a calculator - design pattern?
- Has readme on how app works, what to expect et al

# Testing
Run `$ adb shell am instrument -w -m    -e debug false -e class 'com.gafful.mamo.keyboard.KeyboardActivityTest' com.gafful.mamo.keyboard.test/androidx.test.runner.AndroidJUnitRunner`
in your terminal to run the tests or run them from Android Studio
