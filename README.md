# 2DTopDown1

## Step 1: Setting up the game panel and window
- Created a Game Panel which is displays sprites and objects on 16x16 tile
- Scaled the pixels by 3 so now its 48x48 tile for modern resolutions
- Instantiated maximum height and maximum width of 768x576 pixels for screen
- Called game panel on main on a Java Frame with title, close operation and frame config

## Step 2: Game Loops
![image](https://github.com/user-attachments/assets/81862dda-a8c6-401a-9b81-b96d406459f2)
- Created a Game thread which updates and draws the the screen with character position
- Paincomponent method handles the drawing and update handles the frame update
- Then we create a new class for keyInputs and update its position in update method
- Since the change in position is updated quick due to modern CPU performance, we get the current time in nanoseconds to restrict update to 60fps
- This can be done in 2 methods Sleep and Delta Method
- Sleep Method is done by creating a draw interval of 1s/60 FPS
- ![image](https://github.com/user-attachments/assets/cb39569c-63fb-4d30-85b3-b073f3f395bd)
- I will be using Delta method as I prefer this
- This method involves using delta which will be difference between current time and previous time over the interval
- Update and Repaint occurs everytime delta is over 1

## Step 3: Sprite and Object animation
- Added Entity package and entity/player class, in future will add objects and npcs
- moved update and draw functionality to player class

# Credits
Special thanks to RyiSnow for their YouTube tutorial, which served as a key reference during development.
