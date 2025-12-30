# Creating a simple class
    
class Person:
    pass

person1 = Person()

person1.name = "Bob"

print(person1.name)
print(hasattr(person1, '__dict__'))