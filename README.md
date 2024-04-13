# Maze Generator using Wilson's Algorithm

This project is a maze generator that utilizes Wilson's algorithm to create random mazes. Wilson's algorithm efficiently generates uniform spanning trees, resulting in interesting and loop-free mazes.

## How It Works

1. **Uniform Spanning Tree (UST) Generation**:
   - A random vertex is chosen as the starting point.
   - A random walk is performed until a vertex already in the UST is encountered.
   - The vertices and edges touched during the walk are added to the UST.
   - These steps are repeated until all vertices are part of the UST.

2. **Maze Creation**:
   - The path of the random walk is followed, adding each vertex and edge to the maze.
   - Other visited vertices during the walk are discarded.

## Usage

1. Clone this repository:
```
git clone https://github.com/eduardo-bravo-dl/MazeGenerator.git
```

2. Open the repository folder and compile the Java code:
```
cd MazeGenerator/
javac *.java
```

3. Run the program:
```
java MazeGenerator
```
