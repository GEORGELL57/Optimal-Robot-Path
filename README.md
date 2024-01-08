# Optimal Robot Path
Author: GEORGELL57
## Name
OptimalRobotPath is a java project that finds an optimal path. The implementation will define two
different heuristics (Euclidean distance, Manhattan distance), which will then compare.
Euclidean distance between two points in Euclidean space is the length of a line segment between
the two points.
Manhattan is the distance traveled by a car in a city defined by city blocks (if there are no one-way
streets).
## Description
The goal of the project is through the implementation to drive the robot to move from the its initial
position in the cache via an optimal path (with the smallest cost) using the search algorithm A* . The
robot can move up, down, right and left. It is forbidden to move diagonally as well as in the positions
with the bombs. We assume that each action operator has the same cost (equal to one).
It will implement the appropriate interface so that the user will be able to provide another maze, i.e.
any with dimensions up to 99x99 and bomb locations, through a file whose structure should be the
one I will describe below. Then, the program to predict and present the steps (x,y position) that must
be followed to solve the given game. In the event that a maze has no solution, the program that must
display a relevant non-solvable message.
## Usage
Example input file:  
5 11  
00000001000  
11001000010  
00000000000  
00100000001  
00000101000  
0 0  
4 10  

The first line will show the dimensions of the maze with space (Rows Columns).  
From the second to the fifth line (or even more for a larger maze) will  
the maze appears, where 1 corresponds to a location with a bomb and 0 corresponds to an empty  
location.  
The penultimate line shows the initial position of the robot with a space (Line Column) and  
in the last line the position of the treasure (final position) is depicted in the same way.  
The starting, ending position and dimensions can vary in each maze.  
The output of your program will be similar to the example below where it corresponds to the input  
above.  
Path: [(0, 0), (0, 1), (0, 2), (0, 3), (0, 4), (0, 5), (0,
6), (1, 6), (1, 7), (1, 8), (2, 8), (2, 9), (3, 9), (4, 9), (4,
10)]
## Support
Tasks:  
• Make a grid of coordinates  
• Find optimal path using Euclidian distance  
• Find optimal path using Manhattan distance  
• Print the time it takes to find the route both  
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would
like to change.
Please make sure to update tests as appropriate.
## License
MIT License
Copyright (c) 2024 George Ellinides  
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
