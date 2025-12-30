#Continuing with the file reading example, the finally keyword can be implemented like this:

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
finally:
    print("I will always show up")

print("Execution will continue to here.")