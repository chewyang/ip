      ____        _        
     |  _ \ _   _| | _____ 
     | | | | | | | |/ / _ \  
     | |_| | |_| |   <  __/
     |____/ \__,_|_|\_\___|
# ip User Guide
Duke is a project for students to store their tasks and manage them via a **Command Line Interface**
(CLI) if you can type fast you can manage your tasks faster than traditional apps.
 * [Quick start](#quickStart)
 * [Features](#features)
    * [Adding a **todo** task: todo](#todo)
    * [Adding a **deadline** task: deadline](#deadline)
    * [Adding a **event** task: event](#event)
    * [Listing all tasks : list](#list)
    * [Locating task by name: find](#find)
    * [Deleting a task : delete](#delete)
    * [Exiting the program : bye](#bye)
    * [Saving the data](#save)
 * [FAQ](#faq)
 * [Command summary](#commandSummmary)

<a name="quickStart"></a>    
## Quick start
1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest duke.jar from [here](https://github.com/chewyang/ip/releases).

3. Copy the file to the folder you want to use as the home folder for Duke

4. Open the command line on your computer and type java -jar <full-file-directory/ip.jar>
   You should see the following
   
5. Type the command in the field and press Enter to execute it. e.g. typing todo homwork and pressing enter will add a new **todo** task
   Some example commands you can try
   * **list** : Lists all your tasks.
   * **todo** CS2113 ip : Adds a task named CS2113 ip to the task list.
   * **delete** 2 : Deletes the 2nd task in the current list.
   * **bye** : Exits the app.
   
6. Refer to the [Features] below for details of each command

<a name="features"></a> 

## Features
notes about the command format:
* Words in UPPER_CASE are the parameters to be supplied by the user.
  e.g todo TASK, TASK is a parameter which can be used as todo HOMEWORK

* Parameters have to be in a fixed order.
<a name="todo"></a> 

### Adding a **todo** task: **todo**
Adds a **todo** task to the task list.

    Format: todo TASK

Example: 
* **todo** cs2113 tutorial 3
* **todo** project ip 
<a name="deadline"></a> 

### Adding a **deadline** task: **deadline**             
Adds a **deadline** task to the task list.
                    
    Format: deadline TASK /by DEADLINE
    note that dates and times can also be used as a parameter for DEADLINE as YYYY-MM-DDTHH:mm format (e.g., 2020-09-09T19:00)
    which will output as MM-DD-YYY HH:mm (e.g., 09-09-2020 19:00)              
                                         
Example:                                 
* **deadline** cs2113 tutorial 3 /by wednesday night            
* **deadline** project ip /by 2020-10-23T19:00                 
   <a name="abcd"></a>

<a name="event"></a> 
### Adding a **event** task: **event**                                                                                                 
Adds a **event** task to the task list.                                                                                     
                                                                                                                              
    Format: event TASK /at TIME                                                                                        
    note that dates and times can also be used as a parameter for TIME as YYYY-MM-DDTHH:mm format (e.g., 2020-09-09T19:00)
    which will output as MM-DD-YYY HH:mm (e.g., 09-09-2020 19:00)                                                             
                                                                                                                              
Example:                                                                                                                      
* **event** cs2113 tutorial 3 /at wednesday night                                                                          
* **event** project ip /at 2020-10-23T19:00                                                                                
<a name="find"></a>                                                                                                                               
### Finding a task: **find**
Finds a task using a keyword and shows a list of tasks containing that keyword

    Format: **find** KEYWORD

<a name="list"></a> 
### Listing all current tasks: **list**
Shows a descriptive list of all tasks and its status

    Format: **list**

 <a name="delete"></a>    
### Deleting a task: **delete**
Deletes an existing task in the task list

    Format: delete INDEX

Example:
* **list** followed by **delete** 2 deletes the 2nd task in the list
* **delete 2**
<a name="bye"></a> 
### Exiting the program: **bye**
Exits the program

    Format: bye

<a name="save"></a> 
### Saving the data
The tasks are saved in the hard disk automatically after the user enters **bye** and exits the program
There is no need to save manually
<a name="faq"></a> 
### FAQ
**Q**: How do I transfer my data to another Computer?
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

<a name="commandSummary"></a> 
### Command Summary
Action | Format, Examples
------------ | -------------
**todo** | todo TASK <br/> e.g **todo** cs2113 tutorial 3
**deadline** | deadline TASK /by DEADLINE <br/> e.g **deadline** homework /by tonight <br/> OR **deadline** project ip /by 2020-10-23T19:00  
**event** | event TASK /at TIME <br/> e.g **event** CS2101 meeting /at 9pm <br/> OR **event** project ip /at 2020-10-23T19:00
**list** | list 
**delete** | delete INDEX <br/> e.g **delete** delete 3
**find** | find KEYWORD <br/> e.g **find** cs2113
**bye** | bye

------------------




















