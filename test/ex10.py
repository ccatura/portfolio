class Animal:
  def speak(self):
    pass

class Dog(Animal):
  def speak(self):
    return "Woof!"

class Cat(Animal):
  def speak(self):
    return "Meow!"

dog = Dog()
cat = Cat()

def animal_sound(which_animal):
  return which_animal.speak()

print(animal_sound(dog)) # Output: "Woof!"
print(animal_sound(cat)) # Output: "Meow!"

