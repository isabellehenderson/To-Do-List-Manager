# Todo List Manager

Todo List Manager is a Java-based command-line application that allows users to create, manage, and organize their to-do lists efficiently.

## Features

- **Add Tasks**: Add new tasks to your to-do list.
- **Mark Tasks as Done**: Remove completed tasks from the list.
- **Load Tasks**: Import tasks from a file.
- **Save Tasks**: Export your current to-do list to a file.
- **Multiple Task Addition**: Option to add multiple tasks at once (when extension flag is enabled).

## How to Use

1. Compile the Java file:
   ```
   javac TodoListManager.java
   ```

2. Run the program:
   ```
   java TodoListManager
   ```

3. Follow the on-screen prompts to manage your to-do list.

## Commands

- **A**: Add a new task
- **M**: Mark a task as done (removes it from the list)
- **L**: Load tasks from a file
- **S**: Save current tasks to a file
- **Q**: Quit the program

## Extension Feature

The program includes an extension feature that allows adding multiple tasks at once. To enable this:

1. Set the `EXTENSION_FLAG` to `true` in the `TodoListManager.java` file.
2. When adding tasks, you'll be prompted if you want to add multiple items.

## File Operations

- When loading tasks, provide the name of the file containing your tasks.
- When saving tasks, specify a filename to save your current to-do list.

## Sample Usage

```
Welcome to your TODO List Manager!
What would you like to do?
(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? A
What would you like to add? Buy groceries
Where in the list should it be (1-1)? (Enter for end): 

Today's TODOs:
 1: Buy groceries

What would you like to do?
(A)dd TODO, (M)ark TODO as done, (L)oad TODOs, (S)ave TODOs, (Q)uit? Q
```