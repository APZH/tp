# User Guide
SchedUrMods is a **desktop application for managing your NUSMODS timetable and everyday
tasks optimised for usage via a Command Line Interface (CLI).** If you can type fast, 
SchedUrMods can help you manage your daily tasks faster than traditional GUI application.

- [1. Quick Start](#1-quick-start)
- [2. Features](#2-features)
    - [2.1 Viewing help: `help`](#2-1-viewing-help--help)
    - [2.2 Adding a task:](#22-adding-a-task)
        - [2.2.1 Todo: `todo`](#221-todo-todo)
        - [2.2.2 Deadline: `deadline`](#222-deadline-deadline)
        - [2.2.3 Event: `event`](#223-event-event)
    - [2.3 Listing all tasks: `list`](#23-listing-all-tasks-list)
    - [2.4 Sorting the tasklist: `sort`](#24-sorting-the-tasklist-sort)
    - [2.5 Deleting tasks: `delete`](#25-deleting-tasks-delete)
    - [2.7 Exiting the program: `bye`](#26-exiting-the-program-bye)
- [3. FAQ](#3-faq)
- [4. Command Summary](#4-command-summary)

## 1. Quick Start
1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `SchedUrMods.jar` from [here](https://github.com/AY2122S1-CS2113T-W13-3/tp/releases)
3. Copy the file to the folder you want to use as the _home folder_ for Duke.
4. Open a terminal window in the _home folder_.
5. Type `java -jar SchedUrMods.jar` into the terminal to start Duke.
6. The following display should appear in a few seconds:

```
 _____        _                _  _   _       ___  ___            _
/  ___|      | |              | || | | |      |  \/  |           | |
\ `--.   ___ | |__    ___   __| || | | | _ __ | .  . |  ___    __| | ___
`--. \ / __|| '_ \  / _ \ / _` || | | || '__|| |\/| | / _ \  / _` |/ __|
/\__/ /| (__ | | | ||  __/| (_| || |_| || |   | |  | || (_) || (_| |\__ \
\____/  \___||_| |_| \___| \__,_| \___/ |_|   \_|  |_/ \___/  \__,_||___/
-------------------------------------------------------------------------
Command-Line Interface for NUSMODS                               (v1.0.0)
-------------------------------------------------------------------------
[user]:
```

7. You may now enter commands into SchedUrMods. Type a command beside
`[user]:` and press `Enter` on your keyboard to execute the command.
8. Refer to the [Features](#2-features) below for details of each command.

## 2. Features
### 2. 1 Viewing help : `help`
Displays all commands available for the SchedUrMods application.

**Format:** `help`

### 2.2 Adding a task:

> #### 📝 **Some notes when adding tasks**:
> - All commands are case-insensitive. For example, `todo` is the same as `Todo` or `TODO`
> - Command arguments within `< >` are mandatory fields and must be followed strictly.
> - Command arguments within `[ ]` are optional fields and may be arranged in any order or left out.

### 2.2.1 Todo: `todo`
Adds a **todo** task to the tasklist.

**Format:** `todo <description> [--flag <argument>]`
- `[description]` specifies the description of the todo.
- `[--flag <argument>]` specifies additional details of the todo.
  - When the task is to be done: `[--doOn dd-MM-yyyy hh:mm:ss]`
  - The priority of the task: `[--priority high|medium|low]`
  - How often the task is to repeat: `[--recur daily|weekly|monthly|yearly]`

**Example:** `todo read book --priority low --doOn 20-10-2021 02:00:00 --recur daily`
- Adds a todo task with description `read book` to the tasklist.
- Specifies the priority to be `low`.
- Specifies the task is to be done on `20-10-2021 02:00:00`.
- Specifies the task is to repeat `daily`.

**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: todo read book --priority low --doOn 20-10-2021 02:00:00 --recur daily
|| Task created!
|| read book [low] (doOn: 20-10-2021 02:00:00)
-------------------------------------------------------------------------
```

### 2.2.2 Deadline: `deadline`
Adds a **deadline** task to the tasklist.

**Format:** `deadline <description> <--due dd-MM-yyyy hh:mm:ss> [--flag <argument>]`
- `[description]` specifies the description of the deadline.
- `<--due dd-MM-yyyy hh:mm:ss>` is a mandatory flag.
- `[--flag <argument>]` specifies additional details of the deadline.
  - When the task is due: `[--due dd-MM-yyyy hh:mm:ss]`
  - The priority of the task: `[--priority high|medium|low]`
  - How often the task is to repeat: `[--recur daily|weekly|monthly|yearly]`

**Example:** `deadline CS2106 Lab 3 --priority high --due 20-10-2021 02:00:00`
- Adds a deadline task with description `CS2106 Lab 3` to the tasklist.
- Specifies the priority to be `high`.
- Specifies the task is to be done on `20-10-2021 02:00:00`.
- with no recurrence.

**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: deadline CS2106 Lab 3 --priority high --due 20-10-2021 02:00:00
|| Task created!
|| CS2106 Lab 3 [high] (dueDate: 20-10-2021 02:00:00)
-------------------------------------------------------------------------
```

### 2.2.3 Event: `event`
Adds a **event** task to the tasklist.

**Format:** `event <description> <--start dd-MM-yyyy hh:mm:ss> <--end dd-MM-yyyy hh:mm:ss> [--flag <argument>]`
- `[description]` specifies the description of the event.
- `<--start dd-MM-yyyy hh:mm:ss>` and `<--end dd-MM-yyyy hh:mm:ss>` are mandatory flags.
- `[--flag <argument>]` specifies additional details of the event.
  - When the event starts: `[--start dd-MM-yyyy hh:mm:ss]`
  - When the event ends: `[--end dd-MM-yyyy hh:mm:ss]`
  - The priority of the event: `[--priority high|medium|low]`
  - How often the event is to repeat: `[--recur daily|weekly|monthly|yearly]`

**Example:** `event Marquee Christmas Party --priority high --start 25-12-2020 22:00:00 --end 26-12-2020 04:00:00`
- Adds an event task with description `Marquee Christmas Party` to the tasklist.
- Specifies the priority to be `high`.
- Specifies the task to start on `25-12-2020 22:00:00` and end on `26-12-2020 04:00:00`.
- with no recurrence.

**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: event Marquee Christmas Party --priority high --start 25-12-2020 22:00:00 --end 26-12-2020 04:00:00
|| Task created!
|| Marquee Christmas Party [high] (startDate: 25-12-2020 10:00:00 - endDate: 26-12-2020 04:00:00)
-------------------------------------------------------------------------
```

### 2.3 Listing all tasks: `list`
Lists tasks in the tasklist.

**Format:** `list [--filter <argument>]`
- `[--flag <argument>]` specifies the filter to be applied to the tasklist.
  - Type of task: `[--type todo|deadline|event]`
  - Priority of the task: `[--priority high|medium|low]`
  - Recurrence of the task: `[--recur daily|weekly|monthly|yearly]`

**Example (without filter):** `list`
- List all tasks currently stored in the tasklist.

**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: list
|| -------------
||  MY TASKLIST
|| -------------
|| 1. read book [low] (doOn: 20-10-2021 02:00:00)
|| 2. return book [medium] (dueDate: 21-10-2021 03:00:00)
|| 3. project meeting [high] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
|| 4. wash clothes [medium] (doOn: 20-10-2021 02:00:00)
|| 5. homework [low] (dueDate: 21-10-2021 03:00:00)
|| 6. movie screening [low] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
-------------------------------------------------------------------------
```

**Example (with filter):** `list --type todo --priority low`
- List all tasks that are type `todo` and priority is `low`.

**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: list --type todo --priority low
|| -------------
||  MY TASKLIST
|| -------------
|| 1. read book [low] (doOn: 20-10-2021 02:00:00)
-------------------------------------------------------------------------
```

>💡 **Note**: To obtain the correct task id of each task, please use the `list` command without any filters.

### 2.4 Sorting the tasklist: `sort`
Sorts the tasklist by a given criteria.

**Format:** `sort --by <criteria>`
- `<criteria>` specifies what to sort the tasklist by.
  - Type of task: `type`.
  - Description of task: `description`
  - Priority of the task: `priority`

**Example:** `sort --by priority` + `list`
- Sort the current tasklist by `priority`
- Print out the sorted list with the `list` command

**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: sort --by priority
|| [!] Tasklist has been sorted by priority
-------------------------------------------------------------------------
[user]: list
|| -------------
||  MY TASKLIST
|| -------------
|| 1. read book [low] (doOn: 20-10-2021 02:00:00)
|| 2. homework [low] (dueDate: 21-10-2021 03:00:00)
|| 3. movie screening [low] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
|| 4. return book [medium] (dueDate: 21-10-2021 03:00:00)
|| 5. wash clothes [medium] (doOn: 20-10-2021 02:00:00)
|| 6. project meeting [high] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
-------------------------------------------------------------------------
```

### 2.5 Deleting tasks: `delete`
Deletes tasks specified in comma-seperated argument.

**Format:** `delete <indexes of tasks to delete>`
- task indexes should be comma seperated.
  - `delete 1,3,5` would delete tasks with indexes 1, 3 and 5.
  - `delete 1-3` would delete tasks with indexes 1, 2 and 3.
  - `delete 1-3, 5` would delete tasks with indexes 1, 2, 3 and 5.  
 >💡 **Note**: Whether there are any spaces between the commas, it does not matter.

**Example:** `delete 1-3, 5`
- delete tasks with indexes 1, 2, 3 and 5.

**List before deletion:**

```
-------------------------------------------------------------------------
[user]: list
|| -------------
||  MY TASKLIST
|| -------------
|| 1. read book [low] (doOn: 20-10-2021 02:00:00)
|| 2. return book [medium] (dueDate: 21-10-2021 03:00:00)
|| 3. project meeting [high] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
|| 4. wash clothes [medium] (doOn: 20-10-2021 02:00:00)
|| 5. homework [low] (dueDate: 21-10-2021 03:00:00)
|| 6. movie screening [low] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
-----
```
**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: delete 1-3,5
|| Tasks deleted:
|| read book [low] (doOn: 20-10-2021 02:00:00)
|| return book [medium] (dueDate: 21-10-2021 03:00:00)
|| project meeting [high] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
|| homework [low] (dueDate: 21-10-2021 03:00:00)
-------------------------------------------------------------------------
```

**List after deletion:**

```
-------------------------------------------------------------------------
[user]: list
|| -------------
||  MY TASKLIST
|| -------------
|| 1. wash clothes [medium] (doOn: 20-10-2021 02:00:00)
|| 2. movie screening [low] (startDate: 22-10-2021 04:00:00 - endDate: 22-10-2021 05:00:00)
-------------------------------------------------------------------------
```

### 2.6 Exiting the program: `bye`
Displays goodbye message and exits the program.

**Format:** `bye`

**Expected Outcome:**

```
-------------------------------------------------------------------------
[user]: bye
|| Exiting program!
-------------------------------------------------------------------------
```

## 3. FAQ

## 4. Command Summary

Action   | Format                                      | Example                                                                                              |
-------- | --------------------------------------------| -----------------------------------------------------------------------------------------------------|
help     | `help`                                      | `help`                                                                                               |
todo     | `todo <description> [--flag <argument>]`    | `todo read book`                                                                                     |
deadline | `deadline <description> [--flag <argument>]`|`deadline CS2106 Lab 3 --priority high --due 20-10-2021 02:00:00`                                     |
event    | `event <description> [--flag <argument>]`   | `event Marquee Christmas Party --priority high --start 25-12-2020 22:00:00 --end 26-12-2020 04:00:00`|
list     | `list [--filter <argument>]`                | `list` or `list --type todo --priority low`                                                          |
sort     | `sort --by <criteria>`                      | `sort --by priority`                                                                                 |
delete   | `delete <indexes of tasks to delete>`       | `delete 1, 2, 4-7`                                                                                   |
bye      | `bye`                                       | `bye`                                                                                                |
