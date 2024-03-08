def display_menu():
    print("To-Do List Menu:")
    print("1. Add Task")
    print("2. Complete Task")
    print("3. Remove Task")
    print("4. View Tasks")
    print("5. Exit")

def add_task(tasks, task):
    tasks.append(task)
    print("Task added successfully!")

def complete_task(tasks, task):
    if task in tasks:
        tasks.remove(task)
        print("Task marked as complete!")
    else:
        print("Task not found in the list.")

def remove_task(tasks, task):
    if task in tasks:
        tasks.remove(task)
        print("Task removed successfully!")
    else:
        print("Task not found in the list.")

def view_tasks(tasks):
    print("Tasks:")
    if tasks:
        for index, task in enumerate(tasks, start=1):
            print(f"{index}. {task}")
    else:
        print("No tasks in the list.")

def main():
    tasks = []

    while True:
        display_menu()
        choice = input("Enter your choice (1-5): ")

        if choice == "1":
            task = input("Enter the task: ")
            add_task(tasks, task)
        elif choice == "2":
            task = input("Enter the task to mark as complete: ")
            complete_task(tasks, task)
        elif choice == "3":
            task = input("Enter the task to remove: ")
            remove_task(tasks, task)
        elif choice == "4":
            view_tasks(tasks)
        elif choice == "5":
            print("Exiting the To-Do List application. Goodbye!")
            break
        else:
            print("Invalid choice. Please enter a number from 1 to 5.")

if __name__ == "__main__":
    main()
