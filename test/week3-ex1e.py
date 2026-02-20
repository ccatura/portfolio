#If you are not quite sure which exception will be thrown, you can catch the generic Exception, which will catch any exception that's thrown. It is a good practice to catch the generic Exception at the end of more specific except clauses and not by itself. Implement it like this:

try:
    with open('input.txt', 'r') as myinputfile:
        for line in myinputfile:
            print(line)
except FileNotFoundError:
    print("Whoops! File does not exist.")
except ValueError:
    print("A value error occurred")
except Exception:
    print("Something unforeseen happened")

print("Execution will continue to here.")