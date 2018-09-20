# Vache Taureau Solver


Vache Taureau Solver is a command line project to solve the Vache Taureau game in the least amount of tries.

# How The Game Works:
This is an old game that consists in finding the EXACT NUMBER

Rules :

- Some one will imagine a XXXX Number in his head (he must not write it) to the others to discover it:

- The Number must not start by the digit 0
- The Number is composed of 4 digits (from 0 to 9) 
- The Number must contain all different digits (no repetition, exp. 0212 is prohibited)
- If a person (the one who tries to find the exact number) proposes a number that contains:
0 digit of the Number XXXX, the initiator of the game must say : *0 bulls 0 cows*

- 1 digit that belongs to the number XXXX, and this number is not in the right position, the one who initiates the game must say *1 cow and 0 bulls* (Exp. : XXXX= 1245, some one proposes 3659)

- 2 digits that belong to the number XXXX, and these 2 digits are not in the right position, the one who initiates the game must say *2 cows and 0 bulls* (Exp : XXXX= 1245, someone proposes 356 1)

etc. 

- A number that belongs to the number XXXX, and this number is in the right position, the one who initiates the game must say *1 bull and 0 cows* (Exp: XXXX= 1245, someone proposes 3649)


And so on until the result *4 Bulls and 0 Cows* is obtained


# How The Solver works:
The command line tool offer this options:
  - initiate List : to start a new game with 0 tries so all number are equiprobable
  - enter data : it allows the user to enter the result of one try ( how many vache and how me taureau)
  - show probabilité : it shows a matrix with the probability of a number accurence in every position
  - show most prob number : it give the user the most probable number to play
  - show possibilités : it shows all possible plays

### Installation


```sh
git clone https://github.com/MarouaneElkamel/vache_taureau.git
cd ./src
javac Vache.java
Java Vache
```


