
Contributions:
 Saksham : Sprites,Hud,Main class, bird and pig classes,collision handling,debugging 
 Raghav: Level screens and structures,game over screen and settings and slingshot class,debugging

Most of the project work was cross-checked and verified by bith of us and some things like debugging 
or collision handling were done by both of us.Overall we have contributed equally



Introduction
This is a simplified Angry Birds game developed using the LibGDX framework.
The game features physics-based interactions, birds, pigs, and obstacles like wood and steel. Players can use a slingshot to launch birds and destroy pigs and structures to win the level.


Requirements
Java Development Kit (JDK) (version 8 or later)
LibGDX Framework (already included in the project dependencies)
LWJGL3 Launcher for running the game

How to Run the Project
Clone or Download the Project

Clone the repository or download the project as a ZIP file and extract it.
Open the Project

Use an IDE like IntelliJ IDEA to open the project.


Play the Game

The game window will open. Use the mouse to drag and release birds from the slingshot to hit pigs and obstacles



Game Initialization

The game initializes with the Main class, which loads the necessary assets and sets up the viewport, camera, and stage.
Level Setup

The Level1_screen class is responsible for:
Setting up the physics world with gravity and collision handling.
Adding game objects like birds, pigs, and obstacles (wood, steel).
Creating the ground to prevent objects from falling off the screen.
Slingshot and Birds

Birds are launched from the slingshot using the mouse input. Their movement and interactions are handled by the physics engine (Box2D).
Collision Handling

The CollisionHandler class manages what happens when objects collide:
Birds hitting pigs or obstacles.
Obstacles breaking when hit with sufficient force.


Rendering

The background and objects are drawn using LibGDX's Batch renderer, and physics interactions are visualized with Box2D's debug renderer.


Controls
Mouse:
Drag the bird on the slingshot to aim.
Release the mouse button to launch the bird.


Assets
The game uses the following assets located in the assets folder:

Background image: level.jpeg
Bird sprites: e.g., redbird.png
Pig sprite: pig_remove.png
Obstacle sprites: horizontal_wood.png, steel.png
and many more ...

Our code lies inside the source folder in the core folder

We have 3 levels 1,2,3 and 3 birds red bird ,yellow bird , black bird and 3 materials 
wood, steel , glass 

GITHUB LINK: https://github.com/saksham2104/2023466_2023414

THE END
