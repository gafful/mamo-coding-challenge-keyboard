# mamo-coding-challenge-keyboard
Implement keyboard according to video in Mamo coding challenge.

# TODO
Hint = AED 0.00
Del button does nothing if nothing entered
First button starts with currency black and decimals still grey
Visual effect on click
Get colours using a picker?
Entries expand on both sides equally
Automatically add , when more than 3 digits
offscreen reduces size and later scrolls horizontally - bonus
Dot adds just that, . while the greyed out 00 remains
Adding more than 2 decimals after the point doesn't show
Deleting decimals take them back to greyed out 0
Deleting all entries takes it back to greyed out AED 0.00
Architecture - in case turned into a calculator - design pattern?
75% of width up to a specified width on bigger screens
Unit tests


Change back different button types

Tests
- Has display view with proper text and colour
- has all buttons with expected labels
- all buttons output expected number or value
- del button does nothing if nothing inside
- Dot adds just that, . while the greyed out 00 remains
- Adding more than 2 decimals after the point doesn't show
- Deleting decimals take them back to greyed out 0
- Deleting all entries takes it back to greyed out AED 0.00
- Has readme on how app works, what to expect et al
- Remove custom matchers