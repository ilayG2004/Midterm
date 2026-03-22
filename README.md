**
This repository holds answers for Q1, Q2, and Q3 of the CS501 midterm under MainActivity.kt. 
Each question's code is marked clearly with inline comments.
**

**Q1: Simple counter with two buttons, and text to display count. rememberSaveable is used so that this count survives recomposition and reconfiguration.**

**Q2: Fixed given code (shown in a multi-line comment, see lines 81-90) so that a counter and a function to handle incrementing it are stored in a viewmodel class called CounterViewModel.
      A composable called CounterScreenParent takes in this viewmodel class as a parameter and directly references these viewmodel variables. It passes the count integer and the handler function to another composable, called CounterScreen 
      which holds the interactive button and text displays of the counter (State Hoisting). 
**

**Q3: A LazyColumn which takes a string list of 20 student names, and for each student generates a card with their name, using the items DSL. 
      While this LazyColumn is scrollable by default, to make that feature more visible and interactive I enclosed this lazy column in a small box (using the fillMaxSize modifier with 0.35f as the parameter)
      such that the user has to actually 'scroll' to view every item in this list.
**

** Everything on one screen:**
I added each of these composable to a composable called 'EveryQuestion,' which is what is called when MainActivity runs. So from a mobile device or emulator one can see and interact with every question coded.
Previews were not enough to suffice since I could not call a preview with the ViewModel for Q2, so this was the easiest way for me to show everything is working as intended.

**Screenshots:**
In image 1 you can see both counters having increased in number, and the top of the lazy column. In image 2, you can see that the first counter was reset back to 0 (using the reset button), and that we have scrolled a bit in the LazyColumn, showing different name cards.
![CS501-Midterm-SC1](https://github.com/user-attachments/assets/bda2a81f-2107-4cbb-9678-bc1000230ffb)
![CS501-Midterm-SC2](https://github.com/user-attachments/assets/05cc03c7-b407-48b5-bd71-a030339d27ab)

**Outside resource disclosure:**
AI was not used due to the simplicity of these questions and the generous amount of time alotted, however I did consult Google for certain errors, particularly with the ViewModel.
I could not pass my ViewModel as a parameter to my CounterScreenParent, so I had to search for why this was, where I then found out I had to update my gradle file.
Additionally, I was confused as to why I could not preview my CounterScreenParent, where I then found out ViewModels cannot be used with Previews. 
I did also have to brush up on my LazyList docs since I couldn't find the correct parameter to pass in the students list to my LazyColumn.
Otherwise, I used my extensive notes that I took through reading and following our textbook.
