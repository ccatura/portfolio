from abc import ABC, abstractmethod #ABC stands for Abstract Base Classes

class Shape(ABC):
  @abstractmethod
  def area(self):
    pass

class Rectangle(Shape):
  def __init__(self, length, width):
    self.length = length
    self.width = width

  def area(self):
     return self.length * self.width

class Circle(Shape):
  def __init__(self, radius):
    self.radius = radius

  def area(self):
    return 3.14 * self.radius * self.radius

rectangle = Rectangle(4, 5)
circle = Circle(3)

print(f"Rectangle Area: {rectangle.area()}")
print(f"Circle Area: {round(circle.area(),2)}")

