#Note that the way you have written your code means that if any other exception occurs, it will be unhandled and the code will still crash. You can handle more than one exception by creating a tuple, like this:

try:
    with open('input.txt', 'r') as myinputfile:
        for line in myinputfile:
            print(line)
except (FileNotFoundError, ValueError):
    print("Whoops! File does not exist.")
print("Execution will continue to here.")