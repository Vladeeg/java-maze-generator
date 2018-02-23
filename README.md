# MazeGenerator

Generates mazes using Prim's algorithm

To run the sample, follow these steps:

#### 1. Install Maven

```sh
$ sudo apt-get install maven 
```


#### 2. Clone this repository:

with SSH:

```sh
$ git clone git@github.com:Vladeeg/java-maze-generator.git
```

or with HTTPS:

```sh
$ git clone https://github.com/Vladeeg/java-maze-generator.git
```

#### 3. Go to project's folder:

```sh
$ cd java-maze-generator
```


#### 4. Pack to jar:

```sh
$ mvn package
```


#### 5. Run with java -jar:

```sh
$ java -jar /target/mazegen-1.0-SNAPSHOT.jar %width% %height%
```
